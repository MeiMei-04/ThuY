/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Hieu
 */
public class danhsachdongvat {
    private int id;
    private String madv;
    private int id_danhmuc;
    private String tendm;
    private String tendv;
    private float cannang;
    private String ghichu;
    private int trangthai;

    public String getTendm() {
        return tendm;
    }

    public void setTendm(String tendm) {
        this.tendm = tendm;
    }
    
    public danhsachdongvat(int id, String madv, String tendm, String tendv, float cannang, String ghichu, int trangthai) {
        this.id = id;
        this.madv = madv;
        this.tendm = tendm;
        this.tendv = tendv;
        this.cannang = cannang;
        this.ghichu = ghichu;
        this.trangthai = trangthai;
    }
    
    public danhsachdongvat() {
    }

    public danhsachdongvat(int id, String madv, int id_danhmuc, String tendv, float cannang, String ghichu, int trangthai) {
        this.id = id;
        this.madv = madv;
        this.id_danhmuc = id_danhmuc;
        this.tendv = tendv;
        this.cannang = cannang;
        this.ghichu = ghichu;
        this.trangthai = trangthai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMadv() {
        return madv;
    }

    public void setMadv(String madv) {
        this.madv = madv;
    }

    public int getId_danhmuc() {
        return id_danhmuc;
    }

    public void setId_danhmuc(int id_danhmuc) {
        this.id_danhmuc = id_danhmuc;
    }

    public String getTendv() {
        return tendv;
    }

    public void setTendv(String tendv) {
        this.tendv = tendv;
    }

    public float getCannang() {
        return cannang;
    }

    public void setCannang(float cannang) {
        this.cannang = cannang;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }

    public int getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(int trangthai) {
        this.trangthai = trangthai;
    }
    
    
}
