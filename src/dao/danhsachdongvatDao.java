/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.danhmucdongvat;
import entity.danhsachdongvat;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hieu
 */
public class danhsachdongvatDao {

    Connection connection;

    public danhsachdongvatDao() throws Exception {
        connection = uliti.DBContext.getConnection();
    }

    public List<danhsachdongvat> getAllData() {
        List<danhsachdongvat> lst = new ArrayList<>();
        String sql = "Select danhsachdongvat.id,madv,tendm,tendv,cannang,ghichu,danhsachdongvat.trangthai from danhsachdongvat\n"
                + "join danhmucdongvat on danhmucdongvat.id = danhsachdongvat.id_danhmuc";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeQuery();
            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String madv = resultSet.getString("madv");
                String tendm = resultSet.getString("tendm");
                String tendv = resultSet.getString("tendv");
                float cannang = resultSet.getFloat("cannang");
                String ghichu = resultSet.getString("ghichu");
                int trangthai = resultSet.getInt("trangthai");
                danhsachdongvat dmdv = new danhsachdongvat(id, madv, tendm, tendv, cannang, ghichu, trangthai);
                lst.add(dmdv);
            }
            return lst;
        } catch (SQLException e) {
            System.out.println("Mã Lỗi: " + e);
            return null;
        }
    }

    public boolean addData(danhsachdongvat dmdv) {
        List<danhsachdongvat> lst = new ArrayList<>();
        String sql = "INSERT INTO danhsachdongvat (madv, id_danhmuc, tendv, cannang, ghichu, trangthai) VALUES \n"
                + "(?, ?, ?, ?, ?, 1)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, dmdv.getMadv());
            preparedStatement.setInt(2, dmdv.getId_danhmuc());
            preparedStatement.setString(3, dmdv.getTendv());
            preparedStatement.setFloat(4, dmdv.getCannang());
            preparedStatement.setString(5, dmdv.getGhichu());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Mã Lỗi: " + e);
            return true;
        }
    }

    public boolean updateData(danhsachdongvat dmdv) {
        List<danhmucdongvat> lst = new ArrayList<>();
        String sql = "UPDATE danhsachdongvat\n"
                + "SET madv = ?, id_danhmuc = ?\n, tendv = ?, cannang = ?, ghichu = ? "
                + "WHERE id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, dmdv.getMadv());
            preparedStatement.setInt(2, dmdv.getId_danhmuc());
            preparedStatement.setString(3, dmdv.getTendv());
            preparedStatement.setFloat(4, dmdv.getCannang());
            preparedStatement.setString(5, dmdv.getGhichu());
            preparedStatement.setInt(6, dmdv.getId());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Mã Lỗi: " + e);
            return true;
        }
    }

    public boolean deleteData(danhsachdongvat dmdv) {
        List<danhmucdongvat> lst = new ArrayList<>();
        String sql = "DELETE FROM danhsachdongvat WHERE id = ?;";
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
