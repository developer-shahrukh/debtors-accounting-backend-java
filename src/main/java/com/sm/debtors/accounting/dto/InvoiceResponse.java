package com.sm.debtors.accounting.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class InvoiceResponse {
    private Integer id;
    private String invoiceNumber;
    private Integer traderId;
    private Integer buyerId;
    private List<Item> itemCode;
    private Date createdOn;
    private Date updatedOn;
    private Double totalSgstAmount = 0.0;
    private Double totalCgstAmount = 0.0;
    private Double totalIgstAmount = 0.0;
    private Double totalAmount;
}
