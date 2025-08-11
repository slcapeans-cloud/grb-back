package com.example.grb.controller;

import com.example.grb.exception.ModelNotFoundException;
import com.example.grb.model.Grb;
import com.example.grb.service.GrbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/grb")
@CrossOrigin(origins = "http://localhost:4200")
public class GrbController {

    @Autowired
    private GrbService grbService;

    @GetMapping
    public ResponseEntity<List<Grb>> findAll() {
        return new ResponseEntity<>(grbService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Grb> create(@RequestBody Grb grb) {
        return new ResponseEntity<>(grbService.create(grb),  HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Object> update(@RequestBody Grb grb) {
        List <Grb> allGrb = grbService.findAll();
        boolean flag = false;

        for (Grb subGrb : allGrb) {
            if (subGrb.getIdGrb().equals(grb.getIdGrb())) {
                flag = true;
                break;
            }
        }

        if (!flag) throw new ModelNotFoundException("El grb que desea modificar no existe");
        grbService.update(grb);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Grb> findById(@PathVariable("id") Integer id) {
        Grb grb = grbService.findById(id);
        if (grb ==null){
            throw new ModelNotFoundException("El grb que desea buscar no existe");
        }
        return new ResponseEntity<>(grb, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") Integer id) {
        Grb grb = grbService.findById(id);
        if (grb ==null){
            throw new ModelNotFoundException("El grb que desea eliminar no existe");
        }
        grbService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
