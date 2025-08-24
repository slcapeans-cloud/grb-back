package com.example.grb.repository;

import com.example.grb.model.Grb;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IGrbRepository extends JpaRepository<Grb, Integer> {
    List<Grb> findAllByOrderByIdGrbDesc();
}
