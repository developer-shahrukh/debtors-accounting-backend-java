package com.sm.debtors.accounting.services;

import com.sm.debtors.accounting.dao.TraderDao;
import com.sm.debtors.accounting.dto.Trader;
import com.sm.debtors.accounting.exceptions.InvalidInputException;
import com.sm.debtors.accounting.exceptions.TraderNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Optional;

@Service
public class TraderService {
    @Autowired
    private TraderDao traderDao;

    public List<Trader> getTrader(){
        return traderDao.findAll();
    }
    public Optional<Trader> getTrader(Integer code){
        if (ObjectUtils.isEmpty(code)) {
            throw new InvalidInputException("Code not provided");
        }
        return traderDao.findById(code);
    }

    public Trader updateTrader(Trader trader) throws TraderNotFoundException{
        if (ObjectUtils.isEmpty(trader)) {
            throw new InvalidInputException("Trader not provided");
        }

         Optional<Trader> traderOpt =  getTrader(trader.getCode());
        if(traderOpt.isEmpty()){
            throw new TraderNotFoundException("Trader not found");
        }
        return traderDao.save(trader);
    }

    public void deleteTrader(Integer code) {
        if (ObjectUtils.isEmpty(code)) {
            throw new InvalidInputException("Code not provided");
        }
        traderDao.deleteById(code);
    }
}
