package com.sm.debtors.accounting.controllers;

import com.sm.debtors.accounting.dto.Item;
import com.sm.debtors.accounting.dto.State;
import com.sm.debtors.accounting.services.ItemService;
import com.sm.debtors.accounting.services.StateService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

@ApiIgnore
@RestController()
@RequestMapping("api")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @ApiOperation(value = "To get all states")
    @GetMapping("/getItems")
    public List<Item> getAllItems(){
        return itemService.getAllItems();
    }

}
