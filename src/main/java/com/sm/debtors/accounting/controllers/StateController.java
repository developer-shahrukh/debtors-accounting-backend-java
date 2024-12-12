package com.sm.debtors.accounting.controllers;

import com.sm.debtors.accounting.dto.Item;
import com.sm.debtors.accounting.dto.State;
import com.sm.debtors.accounting.services.StateService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;
import java.util.Optional;

@ApiIgnore
@RestController()
//@RequestMapping("/api")
public class StateController {

    @Autowired
    private StateService stateService;

    @ApiOperation(value = "To get all states")
    @GetMapping("/getStates")
    public List<State> getAllStates(){
        return stateService.getAllStates();
    }

    @GetMapping("/getState/{code}")
    public Optional<State> getByCode(@PathVariable Integer code){
        return stateService.getByCode(code);
    }
}
