package com.example.grb.service;

import com.example.grb.model.Grb;
import com.example.grb.repository.IGrbRepository;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GrbService implements IGrbService {

    @Autowired
    private IGrbRepository iGrbRepository;


    @Override
    public Grb create(Grb grb) {
        return iGrbRepository.save(grb);
    }

    @Override
    public Grb update(Grb grb) {
        return iGrbRepository.save(grb);
    }

    @Override
    public Grb findById(Integer id) {
        Optional<Grb> grbOptional = iGrbRepository.findById(id);
        return grbOptional.orElse(null);
    }

    @Override
    @Transactional
    public List<Grb> findAll() {
        return iGrbRepository.findAllByOrderByIdGrbDesc();
    }

    @Override
    public void delete(Integer id) {
        iGrbRepository.deleteById(id);
    }
}
