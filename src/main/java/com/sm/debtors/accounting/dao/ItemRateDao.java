package com.sm.debtors.accounting.dao;

import com.sm.debtors.accounting.dto.Item;
import com.sm.debtors.accounting.dto.ItemRate;
import com.sm.debtors.accounting.dto.Uom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ItemRateDao extends JpaRepository<ItemRate,Integer> {

    @Query(value = "select i from ac_item_rate i where i.itemCode=:itemCode and i.uomCode=:uomCode", nativeQuery = false)
    Optional<ItemRate> findByItemCodeAndUomCode(@Param("itemCode") Integer itemCode, @Param("uomCode") Integer uomCode);
}
