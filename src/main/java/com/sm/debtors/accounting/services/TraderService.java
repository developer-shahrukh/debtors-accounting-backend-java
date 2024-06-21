package com.sm.debtors.accounting.services;

import com.sm.debtors.accounting.dao.TraderDao;
import com.sm.debtors.accounting.dto.Trader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TraderService {
    @Autowired
    private TraderDao traderDao;

    public List<Trader> getTrader(){
        return traderDao.findAll();
    }
    public Optional<Trader> getByCode(Integer code){
        return traderDao.findById(code);
    }

}
