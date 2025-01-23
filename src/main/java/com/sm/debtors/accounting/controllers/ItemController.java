package com.sm.debtors.accounting.controllers;

import com.sm.debtors.accounting.dto.Customer;
import com.sm.debtors.accounting.dto.Item;
import com.sm.debtors.accounting.services.ItemService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;
import java.util.Optional;

@ApiIgnore
@RestController()
//@RequestMapping("api")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @ApiOperation(value = "To get all states")
    @GetMapping("/getItems")
    public List<Item> getAllItems(){
        return itemService.getAllItems();
    }

    @GetMapping("/getItem/{code}")
    public Optional<Item> getByCode(@PathVariable Integer code){
        return itemService.getByCode(code);
    }
    @PostMapping("/addItem")
    public ResponseEntity<Object> addItem(@RequestBody Item item){
        return itemService.addItem(item);
    }


    @DeleteMapping("/deleteItemByCode/{code}")
    public void deleteByCode(@PathVariable Integer code){
        itemService.deleteByCode(code);
    }

    @PutMapping("/updateItem")
    public ResponseEntity<Object> updateItem(@RequestBody Item itemData){
        return itemService.updateItem(itemData);
    }
}
