package com.sm.debtors.accounting.controllers;

import com.sm.debtors.accounting.dto.Item;
import com.sm.debtors.accounting.dto.Trader;
import com.sm.debtors.accounting.services.TraderService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;
import java.util.Optional;

@ApiIgnore
@RequestMapping("api")
@RestController
public class TraderController {
    @Autowired
    private TraderService traderService;

    @ApiOperation(value = "To get traders")
    @GetMapping("/getTraders")
    public List<Trader> getTraders() {
        return traderService.getTrader();
    }

    @GetMapping("/getTrader/{code}")
    public Optional<Trader> getTrader(@PathVariable Integer code){
        return traderService.getTrader(code);
    }

    @DeleteMapping("/deleteTrader/{code}")
    public void deleteByCode(@PathVariable Integer code){
        traderService.deleteTrader(code);
    }
    @PutMapping("/updateTrader")
    public Trader updateTrader(@RequestBody Trader trader){
            return traderService.updateTrader(trader);

    }
}
