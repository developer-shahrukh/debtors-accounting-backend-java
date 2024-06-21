package com.sm.debtors.accounting.controllers;

import com.sm.debtors.accounting.dto.Trader;
import com.sm.debtors.accounting.services.TraderService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

@ApiIgnore
@RequestMapping("api")
@RestController
public class TraderController {
    @Autowired
    private TraderService traderService;

    @ApiOperation(value = "To get traders")
    @GetMapping("/getTraders")
    public List<Trader> getTraders(){ return traderService.getTrader();}
}
