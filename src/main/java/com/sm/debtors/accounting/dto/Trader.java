package com.sm.debtors.accounting.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "ac_trader")
public class Trader {
    @Id
    private Integer code;
    private String name;
    private String address;
    private String reg_title_1;
    private String reg_title_2;
    private String reg_title_3;
    private String reg_value_1;
    private String reg_value_2;
    private String reg_value_3;
    private Integer contact_1;
    private Integer contact_2;
    private Integer contact_3;
    private Integer stateCode;
}
