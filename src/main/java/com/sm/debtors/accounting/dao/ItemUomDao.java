package com.sm.debtors.accounting.dao;

import com.sm.debtors.accounting.dto.ItemUom;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemUomDao extends JpaRepository<ItemUom,Integer> {

    //@Query("delete from ac_item_uom where code = ?")
    //public void deleteByCode(Integer itemCode);
    @Transactional
    @Modifying
    @Query("DELETE FROM ac_item_uom i WHERE i.itemCode = :itemCode")
    void deleteByItemCode(@Param("itemCode") Integer itemCode);
}
