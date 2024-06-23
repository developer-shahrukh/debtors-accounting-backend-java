package com.sm.debtors.accounting.services;

import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.sm.debtors.accounting.dao.*;
import com.sm.debtors.accounting.dto.*;
import com.sm.debtors.accounting.exceptions.CustomerNotFoundException;
import com.sm.debtors.accounting.exceptions.ItemNotFoundException;
import com.sm.debtors.accounting.exceptions.TraderNotFoundException;
import com.sm.debtors.accounting.utils.TaxCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class InvoiceService {

    @Autowired
    private Item itemsData;
    @Autowired
    private TraderDao traderDao;
    @Autowired
    private CustomerDao customerDao;
    @Autowired
    private ItemDao itemDao;
    @Autowired
    private ItemTaxDao itemTaxDao;
    @Autowired
    private UomDao uomDao;
    @Autowired
    private ItemRateDao itemRateDao;

    public InvoiceResponse generateInvoice(InvoiceRequest invoiceRequest) {
        Optional<Trader> traderOptional = traderDao.findById(invoiceRequest.getTraderId());
        Optional<Customer> customerOptional = customerDao.findById(invoiceRequest.getBuyerId());
        if(traderOptional.isEmpty()) throw new TraderNotFoundException();
        if(customerOptional.isEmpty()) throw new CustomerNotFoundException();
        Trader trader = traderOptional.get();
        Customer customer = customerOptional.get();
        boolean isSameState = trader.getStateCode().equals(customer.getStateCode());
        boolean isIgstEligible = !isSameState;

        Double totalAmount = 0.0;
        Double totalSgstAmount = 0.0;
        Double totalCgstAmount = 0.0;
        Double totalIgstAmount = 0.0;
        for(Item item: invoiceRequest.getItems()){
            Item itemFromDB = null;
            ItemTax itemTaxFromDB = null;
            Uom uomFromDB = null;
            ItemRate itemRateFromDB = null;
            fetchFromDB(item.getCode(), item.getItemRate().getUomCode(), itemFromDB, itemTaxFromDB, uomFromDB,itemRateFromDB);

            Double sgstAmount = 0.0;
            Double cgstAmount = 0.0;
            Double igstAmount = 0.0;

            sgstAmount =  TaxCalculator.calculatTax(itemRateFromDB.getRate(), itemTaxFromDB.getSgst());
            if(isIgstEligible){
                igstAmount = TaxCalculator.calculatTax(itemRateFromDB.getRate(), itemTaxFromDB.getIgst());
            }else{
                cgstAmount = TaxCalculator.calculatTax(itemRateFromDB.getRate(), itemTaxFromDB.getCgst());
            }

            item.setSgstAmount(sgstAmount);
            item.setCgstAmount(cgstAmount);
            item.setIgstAmount(igstAmount);

            Double amountWithTax = itemRateFromDB.getRate() + sgstAmount + cgstAmount + igstAmount;
            item.setAmountWithTax(amountWithTax);
            totalAmount = totalAmount + amountWithTax;
            totalCgstAmount = totalCgstAmount + amountWithTax;
            totalSgstAmount = totalSgstAmount + amountWithTax;
            totalIgstAmount = totalIgstAmount + amountWithTax;

        }

        InvoiceResponse invoiceResponse = new InvoiceResponse();
        invoiceResponse.setInvoiceNumber(UUID.randomUUID().toString());
        invoiceResponse.setTraderId(invoiceRequest.getTraderId());
        invoiceResponse.setBuyerId(invoiceRequest.getBuyerId());
        invoiceResponse.setTotalCgstAmount(totalCgstAmount);
        invoiceResponse.setTotalSgstAmount(totalSgstAmount);
        invoiceResponse.setTotalIgstAmount(totalIgstAmount);
        invoiceResponse.setTotalAmount(totalAmount);

        return invoiceResponse;
    }

    private void fetchFromDB(Integer itemCode, Integer uomCode, Item itemDB, ItemTax itemTaxDB, Uom uomDB, ItemRate itemRateDB){
        Optional<Item> itemOptional = itemDao.findById(itemCode);
        Optional<ItemTax> itemTaxOptional = itemTaxDao.findById(itemCode);
        Optional<Uom> uomOptional = uomDao.findById(uomCode);
        Optional<ItemRate> itemRateOptional = itemRateDao.findById(itemCode);
        if (itemOptional.isEmpty()) throw new ItemNotFoundException();
        if (itemTaxOptional.isEmpty()) throw new ItemNotFoundException();
        if (uomOptional.isEmpty()) throw new ItemNotFoundException();
        itemDB = itemOptional.get();
        itemTaxDB = itemTaxOptional.get();
        uomDB = uomOptional.get();
        itemRateDB = itemRateOptional.get();
    }

    private Double calculateTotalTax(double itemRate, boolean isIgstEligible, Float sgstRate, Float cgstRate, Float igstRate){
        Double sgstAmount = 0.0;
        Double cgstAmount = 0.0;
        Double igstAmount = 0.0;
        sgstAmount = TaxCalculator.calculatTax(itemRate, sgstRate);
        if(isIgstEligible){
            igstAmount = TaxCalculator.calculatTax(itemRate, igstRate);
        }else{
            cgstAmount = TaxCalculator.calculatTax(itemRate, cgstRate);
        }

        return sgstAmount + cgstAmount + igstAmount;

    }

}
