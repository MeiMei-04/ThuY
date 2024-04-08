/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.danhmucdongvat;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hieu
 */
public class danhmucdongvatDao {

    Connection connection;

    public danhmucdongvatDao() throws Exception {
        connection = uliti.DBContext.getConnection();
    }

    public List<danhmucdongvat> getAllData() {
        List<danhmucdongvat> lst = new ArrayList<>();
        String sql = "Select * from danhmucdongvat";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeQuery();
            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String madm = resultSet.getString("madm");
                String tendm = resultSet.getString("tendm");
                int trangthai = resultSet.getInt("trangthai");
                danhmucdongvat dmdv = new danhmucdongvat(id, madm, tendm, trangthai);
                lst.add(dmdv);
            }
            return lst;
        } catch (SQLException e) {
            System.out.println("Mã Lỗi: " + e);
            return null;
        }
    }

    public boolean addData(danhmucdongvat dmdv) {
        List<danhmucdongvat> lst = new ArrayList<>();
        String sql = "INSERT INTO danhmucdongvat (madm, tendm, trangthai) VALUES \n"
                + "(?, ?, 1)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, dmdv.getMadm());
            preparedStatement.setString(2, dmdv.getTendm());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Mã Lỗi: " + e);
            return true;
        }
    }

    public boolean updateData(danhmucdongvat dmdv) {
        List<danhmucdongvat> lst = new ArrayList<>();
        String sql = "UPDATE danhmucdongvat\n"
                + "SET madm = ?, tendm = ?\n"
                + "WHERE id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, dmdv.getMadm());
            preparedStatement.setString(2, dmdv.getTendm());
            preparedStatement.setInt(3, dmdv.getId());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Mã Lỗi: " + e);
            return true;
        }
    }
    public boolean deleteData(danhmucdongvat dmdv) {
        List<danhmucdongvat> lst = new ArrayList<>();
        String sql = "DELETE FROM danhmucdongvat WHERE id = ?;";
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
