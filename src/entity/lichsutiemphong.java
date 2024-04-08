/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Date;

/**
 *
 * @author Hieu
 */
public class lichsutiemphong {
    private int id;
    private String mals;
    private int id_dongvat;
    private String tendv;
    private String loaibenh;
    private Date ngaytiem;
    private int trangthai;

    public lichsutiemphong(int id, String mals, int id_dongvat, String loaibenh, Date ngaytiem, int trangthai) {
        this.id = id;
        this.mals = mals;
        this.id_dongvat = id_dongvat;
        this.loaibenh = loaibenh;
        this.ngaytiem = ngaytiem;
        this.trangthai = trangthai;
    }

    public lichsutiemphong() {
    }

    public lichsutiemphong(int id, String mals, String tendv, String loaibenh, Date ngaytiem, int trangthai) {
        this.id = id;
        this.mals = mals;
        this.tendv = tendv;
        this.loaibenh = loaibenh;
        this.ngaytiem = ngaytiem;
        this.trangthai = trangthai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMals() {
        return mals;
    }

    public void setMals(String mals) {
        this.mals = mals;
    }

    public int getId_dongvat() {
        return id_dongvat;
    }

    public void setId_dongvat(int id_dongvat) {
        this.id_dongvat = id_dongvat;
    }

    public String getTendv() {
        return tendv;
    }

    public void setTendv(String tendv) {
        this.tendv = tendv;
    }

    public String getLoaibenh() {
        return loaibenh;
    }

    public void setLoaibenh(String loaibenh) {
        this.loaibenh = loaibenh;
    }

    public Date getNgaytiem() {
        return ngaytiem;
    }

    public void setNgaytiem(Date ngaytiem) {
        this.ngaytiem = ngaytiem;
    }

    public int getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(int trangthai) {
        this.trangthai = trangthai;
    }
    
}
