package com.sm.debtors.accounting.controllers;

import com.sm.debtors.accounting.dto.InvoiceRequest;
import com.sm.debtors.accounting.dto.InvoiceResponse;
import com.sm.debtors.accounting.services.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;


@RequestMapping("api")
@RestController
@ApiIgnore
public class InvoiceController {
    @Autowired
    private InvoiceService invoiceService;
    @PostMapping("/generateInvoice")
    public InvoiceResponse generateInvoice(@RequestBody InvoiceRequest invoiceRequest){
        return invoiceService.generateInvoice(invoiceRequest);
    }
}
