package com.sm.debtors.accounting.services;

import com.sm.debtors.accounting.dao.ItemDao;
import com.sm.debtors.accounting.dto.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {
    @Autowired
    private ItemDao itemDao;

    public List<Item> getAllItems(){
        return itemDao.findAll();
    }
    public Optional<Item> getByCode(Integer code){
        return itemDao.findById(code);
    }
    public Item addItem(Item item){
        return itemDao.save(item);
    }
    public void deleteByCode(Integer code){
        itemDao.deleteById(code);
    }

}
