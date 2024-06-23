package com.sm.debtors.accounting.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.CookieValue;

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

    private ItemRate itemRate;
    private Double sgstAmount;
    private Double cgstAmount;
    private Double igstAmount;
    private Double amountWithTax;
}
