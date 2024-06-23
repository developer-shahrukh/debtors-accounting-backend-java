package com.sm.debtors.accounting.utils;

public class TaxCalculator {

    public static Double calculatTax(Double itemCost, float taxRate){
        return itemCost * (taxRate / 100);
    }
}
