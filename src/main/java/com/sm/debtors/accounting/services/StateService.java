package com.sm.debtors.accounting.services;

import com.sm.debtors.accounting.dao.StateDao;
import com.sm.debtors.accounting.dto.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StateService {
    @Autowired
    StateDao stateDao;

    public List<State> getAllStates(){
        return stateDao.findAll();
    }
    public Optional<State> getByCode(Integer stateCode){
        return stateDao.findById(stateCode);
    }
}
