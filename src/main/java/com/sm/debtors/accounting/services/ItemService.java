package com.sm.debtors.accounting.services;

import com.sm.debtors.accounting.dao.ItemDao;
import com.sm.debtors.accounting.dto.Item;
import com.sm.debtors.accounting.exceptions.InvalidInputException;
import com.sm.debtors.accounting.exceptions.ItemNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {
    @Autowired
    private ItemDao itemDao;

    public List<Item> getAllItems() {
        return itemDao.findAll();
    }

    public Optional<Item> getByCode(Integer code) {
        if (ObjectUtils.isEmpty(code)) {
            throw new InvalidInputException("Code not provided");
        }
        return itemDao.findById(code);
    }

    public ResponseEntity<Object> addItem(Item item) {
        if (ObjectUtils.isEmpty(item)) {
            throw new InvalidInputException("Item not provided");
        }
        try {
          Item itemSaved = itemDao.save(item);
          return ResponseEntity.status(200).body(itemSaved);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Problem in adding item");
        }
    }

    public Item updateItem(Item item) {
        if (ObjectUtils.isEmpty(item)) {
            throw new InvalidInputException("Item not provided");
        }
        Optional<Item> itemInDB = getByCode(item.getCode());
        if (itemInDB.isEmpty()) {
            throw new ItemNotFoundException();
        }
        return itemDao.save(item);
    }

    public void deleteByCode(Integer code) {
        if (ObjectUtils.isEmpty(code)) {
            throw new InvalidInputException("Code not provided");
        }
        itemDao.deleteById(code);
    }

}
