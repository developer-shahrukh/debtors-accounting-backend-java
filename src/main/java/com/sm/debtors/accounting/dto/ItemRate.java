package com.sm.debtors.accounting.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Table
@Entity(name = "ac_item_rate")
public class ItemRate {
    @Column(name="item_code")
    @Id
    private Integer itemCode;
    @Column (name= "uom_code")
    private Integer uomCode;
    @Column(name= "rate")
    private Double rate;
}
