package com.sm.debtors.accounting.dto;

import jakarta.persistence.*;
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
    @Column(name ="name")
    private String name;
    @Column(name="address")
    private String address;
    @Column(name="gst_num")
    private String gstNum;
    @Column(name="account_holder_name")
    private String accountHolderName;
    @Column(name="account_number")
    private Long accountNumber;
    @Column(name= "branch_name")
    private String branchName;
    @Column(name = "ifsc_code")
    private String ifscCode;
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
