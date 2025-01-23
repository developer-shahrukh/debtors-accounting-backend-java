package com.sm.debtors.accounting.controllers;

import com.sm.debtors.accounting.dto.Item;
import com.sm.debtors.accounting.dto.Uom;
import com.sm.debtors.accounting.services.UomService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;
import java.util.Optional;

@ApiIgnore
@RestController
//@RequestMapping("api")
public class UomController {
    @Autowired
    private UomService uomService;

    @ApiOperation(value = "To get Unit of measurements")
    @GetMapping("/getUoms")
    public List<Uom> getUoms() {
        return uomService.getUoms();
    }

    @GetMapping("/getUnitOfMeasurementByCode/{code}")
    public Optional<Uom> getByCode(@PathVariable Integer code){
        return uomService.getByCode(code);
    }
    @PostMapping("/addUnitOfMeasurement")
    public ResponseEntity<Object> addUom(@RequestBody Uom uom){
        return uomService.addUom(uom);
    }


    @DeleteMapping("/deleteUom/{code}")
    public void deleteByCode(@PathVariable Integer code){
        uomService.deleteByCode(code);
    }

    @PutMapping("/updateUom")
    public ResponseEntity<Object> updateUom(@RequestBody Uom uom){
        return uomService.updateUom(uom);
    }
}
