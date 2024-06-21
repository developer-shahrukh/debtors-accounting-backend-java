package com.sm.debtors.accounting.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name ="ac_uom")
public class Uom {
    @Id
    private Integer code;
    private String name;
}
