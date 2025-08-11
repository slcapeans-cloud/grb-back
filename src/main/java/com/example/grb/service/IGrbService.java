package com.example.grb.service;

import com.example.grb.model.Grb;

import java.util.List;

public interface IGrbService {

    Grb create(Grb grb);

    Grb update(Grb grb);

    Grb findById(Integer id);

    List<Grb> findAll();

    void delete(Integer id);
}

