package com.example.wwwmidterm.impl;

import com.example.wwwmidterm.DB.DBConnection;
import com.example.wwwmidterm.dao.ToaNhaDAO;
import com.example.wwwmidterm.model.ToaNha;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ToaNhaDAOImpl implements ToaNhaDAO {

    @Override
    public List<ToaNha> getAll() {
        List<ToaNha> list = new ArrayList<ToaNha>();
        String sql = "SELECT * FROM toanha";
        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                ToaNha t = new ToaNha(rs.getString("MATOA"),rs.getString("TENTOA"),rs.getString("DIACHI"),rs.getString("CHUTOA"));
            list.add(t);
                }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public ToaNha findById(String id) {
        String sql = "SELECT * FROM toanha WHERE MATOA = ?";
        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,id);
            try(ResultSet rs = ps.executeQuery()) {
                    if (rs.next()){
                        return new ToaNha(rs.getString("MATOA"),rs.getString("TENTOA"),rs.getString("DIACHI"),rs.getString("CHUTOA"));

                    }
            }catch (Exception e){
                throw new RuntimeException(e);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
