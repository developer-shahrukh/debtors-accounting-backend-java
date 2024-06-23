package com.sm.debtors.accounting.dao;

import com.sm.debtors.accounting.dto.ItemTax;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemTaxDao extends JpaRepository<ItemTax,Integer> {
}
