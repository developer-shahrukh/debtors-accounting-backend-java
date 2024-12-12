package com.sm.debtors.accounting.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name= "ac_customer")
public class Customer {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ac_customer_code_seq_gen")
    @SequenceGenerator(name = "ac_customer_code_seq_gen", sequenceName = "ac_customer_code_seq", allocationSize =1)
    @Column(name="code")
    private Integer code;
    @Column(name ="name")
    private String name;
    @Column(name="address")
    private String address;
    @Column(name="reg_title_1")
    private String regTitle1;
    @Column(name="reg_title_2")
    private String regTitle2;
    @Column(name="reg_title_3")
    private String regTitle3;
    @Column(name="reg_value_1")
    private String regValue1;
    @Column(name="reg_value_2")
    private String regValue2;
    @Column(name="reg_value_3")
    private String regValue3;
    @Column(name="contact_1")
    private Long contact1;
    @Column(name="contact_2")
    private Long contact2;
    @Column(name="contact_3")
    private Long contact3;
    @Column(name="state_code")
    private Integer stateCode;
}
