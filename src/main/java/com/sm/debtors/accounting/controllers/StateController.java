package com.sm.debtors.accounting.controllers;

import com.sm.debtors.accounting.dto.State;
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
@RequestMapping("/api")
public class StateController {

    @Autowired
    private StateService stateService;

    @ApiOperation(value = "To get all states")
    @GetMapping("/getStates")
    public List<State> getAllStates(){
        return stateService.getAllStates();
    }

}
