package com.example.wwwmidterm.dao;

import com.example.wwwmidterm.model.ToaNha;

import java.util.List;

public interface ToaNhaDAO {
    List<ToaNha> getAll();
    ToaNha findById(String id);
}
