package com.sm.debtors.accounting.services;

import com.sm.debtors.accounting.dao.ItemDao;
import com.sm.debtors.accounting.dao.ItemTaxDao;
import com.sm.debtors.accounting.dao.ItemUomDao;
import com.sm.debtors.accounting.dto.Item;
import com.sm.debtors.accounting.dto.ItemTax;
import com.sm.debtors.accounting.dto.ItemUom;
import com.sm.debtors.accounting.exceptions.InvalidInputException;
import com.sm.debtors.accounting.exceptions.ItemNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

@Service
public class ItemService {
    @Autowired
    private ItemDao itemDao;
    @Autowired
    private ItemTaxDao itemTaxDao;
    @Autowired
    private ItemUomDao itemUomDao;

    public List<Item> getAllItems() {
       return itemDao.findAll();
    }

    public Optional<Item> getByCode(Integer code) {
        if (ObjectUtils.isEmpty(code)) {
            throw new InvalidInputException("Code not provided");
        }
        Optional<Item> optionalItem=itemDao.findById(code);

        if(optionalItem.isPresent()) {
            Item item = optionalItem.get();
            Optional<ItemTax> optionalItemTax=itemTaxDao.findById(code);
            optionalItemTax.ifPresent(itemTax->{
                item.setCgstAmount(Double.valueOf(itemTax.getCgst()));
                item.setSgstAmount(Double.valueOf(itemTax.getSgst()));
                item.setIgstAmount(Double.valueOf(itemTax.getIgst()));
            });
        }
        //return itemDao.findById(code);
        return optionalItem;
    }

    public ResponseEntity<Object> addItem(Item item) {
        if (ObjectUtils.isEmpty(item)) {
            throw new InvalidInputException("Item not provided");
        }
        try {
          Item itemSaved = itemDao.save(item);
          return ResponseEntity.status(200).body(itemSaved);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Problem in adding item");
        }
    }



    public ResponseEntity<Object> updateItem(Item item) {
        if (ObjectUtils.isEmpty(item)) {
            throw new InvalidInputException("Item not provided");
        }
        Optional<Item> itemInDB= getByCode(item.getCode());
        if (itemInDB.isEmpty()) {
            throw new ItemNotFoundException();
        }
        try {
            Item itemUpdated= itemDao.save(item);
            return ResponseEntity.status(200).body(itemUpdated);
        } catch (Exception e){
            return ResponseEntity.status(500).body("Problem in updated item");
        }
    }

    public void deleteByCode(Integer code) {
        if (ObjectUtils.isEmpty(code)) {
            throw new InvalidInputException("Code not provided");
        }
        itemTaxDao.deleteById(code);
        itemUomDao.deleteByItemCode(code);
        itemDao.deleteById(code);
    }
}
