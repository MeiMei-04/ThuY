/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.danhmucdongvat;
import entity.lichsutiemphong;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hieu
 */
public class lichsutiemphongDao {

    Connection connection;

    public lichsutiemphongDao() throws Exception {
        connection = uliti.DBContext.getConnection();
    }

    public List<lichsutiemphong> getAllData() {
        List<lichsutiemphong> lst = new ArrayList<>();
        String sql = "select lichsutiemphong.id,mals,danhsachdongvat.tendv,\n"
                + "loaibenh,ngaytiem,lichsutiemphong.trangthai\n"
                + "from lichsutiemphong\n"
                + "join danhsachdongvat \n"
                + "on lichsutiemphong.id_dongvat = danhsachdongvat.id";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeQuery();
            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String mals = resultSet.getString("mals");
                String tendv = resultSet.getString("tendv");
                String loaibenh = resultSet.getString("loaibenh");
                Date ngaytiem = resultSet.getDate("ngaytiem");
                int trangthai = resultSet.getInt("trangthai");
                lichsutiemphong dmdv = new lichsutiemphong(id, mals, tendv, loaibenh, ngaytiem, trangthai);
                lst.add(dmdv);
            }
            return lst;
        } catch (SQLException e) {
            System.out.println("Mã Lỗi: " + e);
            return null;
        }
    }

    public boolean addData(lichsutiemphong dmdv) {
        List<lichsutiemphong> lst = new ArrayList<>();
        String sql = "INSERT INTO lichsutiemphong (mals, id_dongvat, loaibenh, ngaytiem, trangthai) VALUES \n"
                + "(?, ?, ?, ?, 1)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, dmdv.getMals());
            preparedStatement.setInt(2, dmdv.getId_dongvat());
            preparedStatement.setString(3, dmdv.getLoaibenh());
            java.util.Date utilDate = dmdv.getNgaytiem();
            preparedStatement.setDate(4, new java.sql.Date(utilDate.getTime()));
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Mã Lỗi: " + e);
            return true;
        }
    }

    public boolean updateData(lichsutiemphong dmdv) {
        List<lichsutiemphong> lst = new ArrayList<>();
        String sql = "UPDATE lichsutiemphong\n"
                + "SET mals = ?, id_dongvat = ?\n, loaibenh = ?, ngaytiem = ? "
                + "WHERE id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, dmdv.getMals());
            preparedStatement.setInt(2, dmdv.getId_dongvat());
            preparedStatement.setString(3, dmdv.getLoaibenh());
            java.util.Date utilDate = dmdv.getNgaytiem();
            preparedStatement.setDate(4, new java.sql.Date(utilDate.getTime()));
            preparedStatement.setInt(5, dmdv.getId());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Mã Lỗi: " + e);
            return true;
        }
    }

    public boolean deleteData(lichsutiemphong dmdv) {
        List<danhmucdongvat> lst = new ArrayList<>();
        String sql = "DELETE FROM lichsutiemphong WHERE id = ?;";
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
