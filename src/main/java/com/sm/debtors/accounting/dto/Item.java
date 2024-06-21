package com.sm.debtors.accounting.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "ac_item")
public class Item {
    @Id
    private Integer code;
    private String name;
    private Integer hsnCode;
}
