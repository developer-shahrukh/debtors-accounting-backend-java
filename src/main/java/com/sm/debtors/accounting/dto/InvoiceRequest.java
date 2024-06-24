package com.sm.debtors.accounting.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class InvoiceRequest {
    private Integer traderId;
    private Integer buyerId;
    private List<Item> items;
}
