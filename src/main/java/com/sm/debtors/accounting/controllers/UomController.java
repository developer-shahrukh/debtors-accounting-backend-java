package com.sm.debtors.accounting.controllers;

import com.sm.debtors.accounting.dto.Uom;
import com.sm.debtors.accounting.services.UomService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

@ApiIgnore
@RestController
@RequestMapping("api")
public class UomController {
    @Autowired
    private UomService uomService;

    @ApiOperation(value = "To get Unit of measurements")
    @GetMapping("/getUoms")
    public List<Uom> getUoms(){ return uomService.getUoms();}
}
