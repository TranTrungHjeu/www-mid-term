package com.example.wwwmidterm.impl;

import com.example.wwwmidterm.DB.DBConnection;
import com.example.wwwmidterm.dao.CanHoDAO;
import com.example.wwwmidterm.model.CanHo;
import com.example.wwwmidterm.model.ToaNha;
import com.mysql.cj.xdevapi.DbDoc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CanHoDAOImpl implements CanHoDAO {

    private CanHo mapRow(ResultSet rs) throws SQLException {
        ToaNha toaNha = new ToaNha(
                rs.getString("MATOA"),
                rs.getString("TENTOA"),
                rs.getString("DIACHI"),
                rs.getString("CHUTOA")
        );
        return new CanHo( rs.getString("MACANHO"),
                rs.getString("TENCANHO"),
                rs.getBigDecimal("GIATHUE"),
                rs.getFloat("DIENTICH"),
                rs.getString("HINHANH"),toaNha);

    }
    @Override
    public List<CanHo> getAll() {
        List<CanHo> list = new ArrayList<CanHo>();
        String sql = "SELECT c.*, t.TENTOA,t.DIACHI, t.CHUTOA   FROM CANHO c JOIN TOANHA t ON c.MATOA = t.MATOA";
        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                list.add(mapRow(rs));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;

    }

    @Override
    public CanHo findById(String maCanHo) {
        String sql = """
                SELECT c.*, t.TENTOA, t.DIACHI, t.CHUTOA
                FROM canho c
                JOIN toanha t ON c.MATOA = t.MATOA
                WHERE c.MACANHO = ?
                """;

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, maCanHo);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapRow(rs);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<CanHo> findByToaNha(String maToa) {
        List<CanHo> list = new ArrayList<>();
        String sql = """
                SELECT c.*, t.TENTOA, t.DIACHI, t.CHUTOA
                FROM canho c
                JOIN toanha t ON c.MATOA = t.MATOA
                WHERE c.MATOA = ?
                """;

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, maToa);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(mapRow(rs));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<CanHo> findByName(String keyword) {
        List<CanHo> list = new ArrayList<>();
        String sql = """
                SELECT c.*, t.TENTOA, t.DIACHI, t.CHUTOA
                FROM canho c
                JOIN toanha t ON c.MATOA = t.MATOA
                WHERE c.TENCANHO LIKE ?
                """;

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, "%" + keyword + "%");
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(mapRow(rs));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean update(CanHo canho) {
        String sql = """
                UPDATE canho
                SET TENCANHO = ?, GIATHUE = ?, DIENTICH = ?, HINHANH = ?, MATOA = ?
                WHERE MACANHO = ?
                """;

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, canho.getTenCanHo());
            ps.setBigDecimal(2, canho.getGiaThue());
            ps.setFloat(3, canho.getDienTich());
            ps.setString(4, canho.getHinhAnh());
            ps.setString(5, canho.getToaNha().getMaToa());
            ps.setString(6, canho.getMaCanHo());

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
