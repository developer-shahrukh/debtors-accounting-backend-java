package com.sm.debtors.accounting.services;

import com.sm.debtors.accounting.dao.UomDao;
import com.sm.debtors.accounting.dto.Uom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UomService {
    @Autowired
    private UomDao uomDao;

    public List<Uom> getUoms(){
        return uomDao.findAll();
    }
}
