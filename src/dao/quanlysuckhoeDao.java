/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.quanlysuckhoe;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hieu
 */
public class quanlysuckhoeDao {

    Connection connection;

    public quanlysuckhoeDao() throws Exception {
        connection = uliti.DBContext.getConnection();
    }

    public List<quanlysuckhoe> getAllData() {
        List<quanlysuckhoe> lst = new ArrayList<>();
        String sql = "select quanlysuckhoe.id,maql,danhsachdongvat.tendv,\n"
                + "tinhtrangsuckhoe,thuocdasudung,quanlysuckhoe.ghichu,ngaytao,quanlysuckhoe.trangthai\n"
                + "from quanlysuckhoe\n"
                + "join danhsachdongvat \n"
                + "on quanlysuckhoe.id_dongvat = danhsachdongvat.id";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeQuery();
            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String maql = resultSet.getString("maql");
                String tendv = resultSet.getString("tendv");
                String tinhtrangsuckhoe = resultSet.getString("tinhtrangsuckhoe");
                String thuocdasudung = resultSet.getString("thuocdasudung");
                String ghichu = resultSet.getString("ghichu");
                Date ngaytao = resultSet.getDate("ngaytao");
                int trangthai = resultSet.getInt("trangthai");
                quanlysuckhoe dmdv = new quanlysuckhoe(id, maql, tendv, tinhtrangsuckhoe, thuocdasudung, ghichu, ngaytao, trangthai);
                lst.add(dmdv);
            }
            return lst;
        } catch (SQLException e) {
            System.out.println("Mã Lỗi: " + e);
            return null;
        }
    }

    public boolean addData(quanlysuckhoe dmdv) {
        List<quanlysuckhoe> lst = new ArrayList<>();
        String sql = "INSERT INTO quanlysuckhoe (maql, id_dongvat, tinhtrangsuckhoe, thuocdasudung, ghichu, ngaytao, trangthai) VALUES \n"
                + "(?, ?, ?, ?,?, ?, 1)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, dmdv.getMaql());
            preparedStatement.setInt(2, dmdv.getId_dongvat());
            preparedStatement.setString(3, dmdv.getTinhtrangsuckhoe());
            preparedStatement.setString(4, dmdv.getThuocdasudung());
            preparedStatement.setString(5, dmdv.getGhichu());
            java.util.Date utilDate = dmdv.getNgaytao();
            preparedStatement.setDate(6, new java.sql.Date(utilDate.getTime()));
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Mã Lỗi: " + e);
            return true;
        }
    }

    public boolean updateData(quanlysuckhoe dmdv) {
        List<quanlysuckhoe> lst = new ArrayList<>();
        String sql = "UPDATE quanlysuckhoe\n"
                + "SET maql = ?, id_dongvat = ?\n, tinhtrangsuckhoe = ?, thuocdasudung = ?,ghichu = ?, ngaytao = ? "
                + "WHERE id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, dmdv.getMaql());
            preparedStatement.setInt(2, dmdv.getId_dongvat());
            preparedStatement.setString(3, dmdv.getTinhtrangsuckhoe());
            preparedStatement.setString(4, dmdv.getThuocdasudung());
            preparedStatement.setString(5, dmdv.getGhichu());
            java.util.Date utilDate = dmdv.getNgaytao();
            preparedStatement.setDate(6, new java.sql.Date(utilDate.getTime()));
            preparedStatement.setInt(7, dmdv.getId());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Mã Lỗi: " + e);
            return true;
        }
    }

    public boolean deleteData(quanlysuckhoe dmdv) {
        String sql = "DELETE FROM quanlysuckhoe WHERE id = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, dmdv.getId());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Mã Lỗi: " + e);
            return true;
        }
    }

}
