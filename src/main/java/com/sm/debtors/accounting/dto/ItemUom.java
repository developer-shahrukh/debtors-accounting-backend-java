package com.sm.debtors.accounting.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name="ac_item_uom")
public class ItemUom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="item_code")
    private Integer itemCode;
    @Column(name="uom_code")
    private Integer uomCode;
}
