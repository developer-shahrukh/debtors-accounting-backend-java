package com.sm.debtors.accounting.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "ac_item_rate")
public class ItemRate {
    @Id
    @Column(name="item_code")
    private Integer itemCode;
    @Column (name= "uom_code")
    private Integer uomCode;
    @Column(name= "rate")
    private Double rate;
}
