package com.sm.debtors.accounting.services;

import com.sm.debtors.accounting.dao.UomDao;
import com.sm.debtors.accounting.dto.Item;
import com.sm.debtors.accounting.dto.Uom;
import com.sm.debtors.accounting.exceptions.InvalidInputException;
import com.sm.debtors.accounting.exceptions.ItemNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Optional;

@Service
public class UomService {
    @Autowired
    private UomDao uomDao;

    public List<Uom> getUoms(){
        return uomDao.findAll();
    }

    public Optional<Uom> getByCode(Integer code) {
        if (ObjectUtils.isEmpty(code)) {
            throw new InvalidInputException("Code not provided");
        }
        return uomDao.findById(code);
    }

    public ResponseEntity<Object> addUom(Uom uom) {
        if (ObjectUtils.isEmpty(uom)) {
            throw new InvalidInputException("Uom not provided");
        }
        try {
            Uom uomSaved = uomDao.save(uom);
            return ResponseEntity.status(200).body(uomSaved);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Problem in adding uom");
        }
    }

    public ResponseEntity<Object> updateUom(Uom uom) {
        if (ObjectUtils.isEmpty(uom)) {
            throw new InvalidInputException("Uom not provided");
        }
        Optional<Uom> uomInDB = getByCode(uom.getCode());
        if (uomInDB.isEmpty()) {
            throw new ItemNotFoundException();
        }
        try {
            Uom uomUpdated = uomDao.save(uom);
            return ResponseEntity.status(200).body(uomUpdated);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Problem in updated uom");
        }
    }

    public void deleteByCode(Integer code) {
        if (ObjectUtils.isEmpty(code)) {
            throw new InvalidInputException("Code not provided");
        }
        uomDao.deleteById(code);
    }
}
