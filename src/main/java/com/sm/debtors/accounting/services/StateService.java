package com.sm.debtors.accounting.services;

import com.sm.debtors.accounting.dao.StateDao;
import com.sm.debtors.accounting.dto.State;
import com.sm.debtors.accounting.exceptions.InvalidInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Optional;

@Service
public class StateService {
    @Autowired
    StateDao stateDao;

    public List<State> getAllStates(){
        return stateDao.findAll();
    }
    public Optional<State> getByCode(Integer code){
        if (ObjectUtils.isEmpty(code)) {
            throw new InvalidInputException("Code not provided");
        }
        return stateDao.findById(code);
    }
}
