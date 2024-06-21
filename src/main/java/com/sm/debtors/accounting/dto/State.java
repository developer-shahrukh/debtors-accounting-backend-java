package com.sm.debtors.accounting.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table
@Entity(name = "ac_state")
public class State {
    @Id
    @Column(name ="code")
    private Integer code;
    @Column(name = "alpha_code")
    private String alphaCode;
    @Column(name = "name")
    private String name;
}
