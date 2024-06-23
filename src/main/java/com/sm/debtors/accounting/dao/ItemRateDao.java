package com.sm.debtors.accounting.dao;

import com.sm.debtors.accounting.dto.ItemRate;
import com.sm.debtors.accounting.dto.Uom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRateDao extends JpaRepository<ItemRate,Integer> {
}
