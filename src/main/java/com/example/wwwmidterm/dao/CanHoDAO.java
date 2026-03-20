package com.example.wwwmidterm.dao;

import com.example.wwwmidterm.model.CanHo;

import java.util.List;

public interface CanHoDAO {
    List<CanHo> getAll();
    CanHo findById(String id);
    List<CanHo> findByName(String name);
    List<CanHo> findByToaNha(String maToa);
    boolean update(CanHo canHo);
}
