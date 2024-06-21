package com.sm.debtors.accounting.dao;

import com.sm.debtors.accounting.dto.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemDao extends JpaRepository<Item, Integer> {
}
