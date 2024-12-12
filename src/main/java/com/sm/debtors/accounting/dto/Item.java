package com.sm.debtors.accounting.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "ac_item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "code")
    private Integer code;
    @Column(name= "name")
    private String name;
    @Column(name="hsn_code")
    private Integer hsnCode;

    @Transient
    private ItemRate itemRate;
    @Transient
    private Double sgstAmount;
    @Transient
    private Double cgstAmount;
    @Transient
    private Double igstAmount;
    @Transient
    private Double amountWithTax;
    @Transient
    private Uom uom;
}
