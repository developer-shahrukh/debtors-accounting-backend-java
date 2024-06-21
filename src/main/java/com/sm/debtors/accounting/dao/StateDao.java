package com.sm.debtors.accounting.dao;

import com.sm.debtors.accounting.dto.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface StateDao extends JpaRepository<State, Integer> {


}
