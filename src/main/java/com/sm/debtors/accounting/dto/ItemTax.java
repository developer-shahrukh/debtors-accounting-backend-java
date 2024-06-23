package com.sm.debtors.accounting.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name="ac_item_tax")
public class ItemTax {
    @Id
    @Column(name="item_code")
    private Integer itemCode;
    @Column(name="cgst")
    private Float cgst;
    @Column(name="sgst")
    private Float sgst;
    @Column(name="igst")
    private Float igst;
}
