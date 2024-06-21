package com.sm.debtors.accounting.dao;

import com.sm.debtors.accounting.dto.Trader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TraderDao extends JpaRepository<Trader,Integer> {
}
