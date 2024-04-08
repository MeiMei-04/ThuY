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
public class quanlysuckhoe {
    private int id;
    private String maql;
    private int id_dongvat;
    private String tendv;
    private String tinhtrangsuckhoe;
    private String thuocdasudung;
    private String ghichu;
    private Date ngaytao;
    private int trangthai;

    public String getTendv() {
        return tendv;
    }

    public void setTendv(String tendv) {
        this.tendv = tendv;
    }

    public quanlysuckhoe(int id, String maql, String tendv, String tinhtrangsuckhoe, String thuocdasudung, String ghichu, Date ngaytao, int trangthai) {
        this.id = id;
        this.maql = maql;
        this.tendv = tendv;
        this.tinhtrangsuckhoe = tinhtrangsuckhoe;
        this.thuocdasudung = thuocdasudung;
        this.ghichu = ghichu;
        this.ngaytao = ngaytao;
        this.trangthai = trangthai;
    }
    
    public quanlysuckhoe() {
    }

    public quanlysuckhoe(int id, String maql, int id_dongvat, String tinhtrangsuckhoe, String thuocdasudung, String ghichu, Date ngaytao, int trangthai) {
        this.id = id;
        this.maql = maql;
        this.id_dongvat = id_dongvat;
        this.tinhtrangsuckhoe = tinhtrangsuckhoe;
        this.thuocdasudung = thuocdasudung;
        this.ghichu = ghichu;
        this.ngaytao = ngaytao;
        this.trangthai = trangthai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaql() {
        return maql;
    }

    public void setMaql(String maql) {
        this.maql = maql;
    }

    public int getId_dongvat() {
        return id_dongvat;
    }

    public void setId_dongvat(int id_dongvat) {
        this.id_dongvat = id_dongvat;
    }

    public String getTinhtrangsuckhoe() {
        return tinhtrangsuckhoe;
    }

    public void setTinhtrangsuckhoe(String tinhtrangsuckhoe) {
        this.tinhtrangsuckhoe = tinhtrangsuckhoe;
    }

    public String getThuocdasudung() {
        return thuocdasudung;
    }

    public void setThuocdasudung(String thuocdasudung) {
        this.thuocdasudung = thuocdasudung;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }

    public Date getNgaytao() {
        return ngaytao;
    }

    public void setNgaytao(Date ngaytao) {
        this.ngaytao = ngaytao;
    }

    public int getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(int trangthai) {
        this.trangthai = trangthai;
    }
    
}
