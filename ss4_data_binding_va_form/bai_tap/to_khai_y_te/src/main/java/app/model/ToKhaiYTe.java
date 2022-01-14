package app.model;

import java.util.HashMap;
import java.util.Map;

public class ToKhaiYTe {
    private String hoTen;
    private String namSinh;
    private Integer gioiTinh;
    private String quocTich;
    private String cmnd;
    private String thongTinDiLai;
    private String soHieu;
    private String soGhe;
    private String ngayKhoiHanh;
    private String ngayKetThuc;
    private String tpDaDen;
    private String tinhThanh;
    private String quanHuyen;
    private String phuongXa;
    private String diaChi;
    private String sdt;
    private Boolean sot;
    private Boolean ho;
    private Boolean khoTho;
    private Boolean dauHong;
    private Boolean buonNon;
    private Boolean tieuChay;
    private Boolean xuatHuyet;
    private Boolean phatBan;
    private Boolean dongVat;
    private Boolean tiepXuc;
    private String mail;



    public ToKhaiYTe(String hoTen, String namSinh, Integer gioiTinh, String quocTich, String cmnd, String thongTinDiLai, String soHieu, String soGhe, String ngayKhoiHanh, String ngayKetThuc, String tpDaDen, String tinhThanh, String quanHuyen, String phuongXa, String diaChi, String sdt, Boolean sot, Boolean ho, Boolean khoTho, Boolean dauHong, Boolean buonNon, Boolean tieuChay, Boolean xuatHuyet, Boolean phatBan, Boolean dongVat, Boolean tiepXuc, String mail) {
        this.hoTen = hoTen;
        this.namSinh = namSinh;
        this.gioiTinh = gioiTinh;
        this.quocTich = quocTich;
        this.cmnd = cmnd;
        this.thongTinDiLai = thongTinDiLai;
        this.soHieu = soHieu;
        this.soGhe = soGhe;
        this.ngayKhoiHanh = ngayKhoiHanh;
        this.ngayKetThuc = ngayKetThuc;
        this.tpDaDen = tpDaDen;
        this.tinhThanh = tinhThanh;
        this.quanHuyen = quanHuyen;
        this.phuongXa = phuongXa;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.sot = sot;
        this.ho = ho;
        this.khoTho = khoTho;
        this.dauHong = dauHong;
        this.buonNon = buonNon;
        this.tieuChay = tieuChay;
        this.xuatHuyet = xuatHuyet;
        this.phatBan = phatBan;
        this.dongVat = dongVat;
        this.tiepXuc = tiepXuc;
        this.mail = mail;
    }

    public ToKhaiYTe() {
    }

    public Boolean getSot() {
        return sot;
    }

    public void setSot(Boolean sot) {
        this.sot = sot;
    }

    public Boolean getHo() {
        return ho;
    }

    public void setHo(Boolean ho) {
        this.ho = ho;
    }

    public Boolean getKhoTho() {
        return khoTho;
    }

    public void setKhoTho(Boolean khoTho) {
        this.khoTho = khoTho;
    }

    public Boolean getDauHong() {
        return dauHong;
    }

    public void setDauHong(Boolean dauHong) {
        this.dauHong = dauHong;
    }

    public Boolean getBuonNon() {
        return buonNon;
    }

    public void setBuonNon(Boolean buonNon) {
        this.buonNon = buonNon;
    }

    public Boolean getTieuChay() {
        return tieuChay;
    }

    public void setTieuChay(Boolean tieuChay) {
        this.tieuChay = tieuChay;
    }

    public Boolean getXuatHuyet() {
        return xuatHuyet;
    }

    public void setXuatHuyet(Boolean xuatHuyet) {
        this.xuatHuyet = xuatHuyet;
    }

    public Boolean getPhatBan() {
        return phatBan;
    }

    public void setPhatBan(Boolean phatBan) {
        this.phatBan = phatBan;
    }

    public Boolean getDongVat() {
        return dongVat;
    }

    public void setDongVat(Boolean dongVat) {
        this.dongVat = dongVat;
    }

    public Boolean getTiepXuc() {
        return tiepXuc;
    }

    public void setTiepXuc(Boolean tiepXuc) {
        this.tiepXuc = tiepXuc;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhuongXa() {
        return phuongXa;
    }

    public void setPhuongXa(String phuongXa) {
        this.phuongXa = phuongXa;
    }

    public String getSoGhe() {
        return soGhe;
    }

    public void setSoGhe(String soGhe) {
        this.soGhe = soGhe;
    }

    public String getHoTen() {
        return hoTen;
    }

    public String getQuocTich() {
        return quocTich;
    }

    public void setQuocTich(String quocTich) {
        this.quocTich = quocTich;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(String namSinh) {
        this.namSinh = namSinh;
    }

    public Integer getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(Integer gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public String getThongTinDiLai() {
        return thongTinDiLai;
    }

    public void setThongTinDiLai(String thongTinDiLai) {
        this.thongTinDiLai = thongTinDiLai;
    }

    public String getSoHieu() {
        return soHieu;
    }

    public void setSoHieu(String soHieu) {
        this.soHieu = soHieu;
    }

    public String getNgayKhoiHanh() {
        return ngayKhoiHanh;
    }

    public void setNgayKhoiHanh(String ngayKhoiHanh) {
        this.ngayKhoiHanh = ngayKhoiHanh;
    }

    public String getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(String ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public String getTpDaDen() {
        return tpDaDen;
    }

    public void setTpDaDen(String tpDaDen) {
        this.tpDaDen = tpDaDen;
    }

    public String getTinhThanh() {
        return tinhThanh;
    }

    public void setTinhThanh(String tinhThanh) {
        this.tinhThanh = tinhThanh;
    }

    public String getQuanHuyen() {
        return quanHuyen;
    }

    public void setQuanHuyen(String quanHuyen) {
        this.quanHuyen = quanHuyen;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    @Override
    public String toString() {
        return "ToKhaiYTe{" +
                "hoTen='" + hoTen + '\'' +
                ", namSinh='" + namSinh + '\'' +
                ", gioiTinh=" + gioiTinh +
                ", quocTich='" + quocTich + '\'' +
                ", cmnd='" + cmnd + '\'' +
                ", thongTinDiLai='" + thongTinDiLai + '\'' +
                ", soHieu='" + soHieu + '\'' +
                ", soGhe='" + soGhe + '\'' +
                ", ngayKhoiHanh='" + ngayKhoiHanh + '\'' +
                ", ngayKetThuc='" + ngayKetThuc + '\'' +
                ", tpDaDen='" + tpDaDen + '\'' +
                ", tinhThanh='" + tinhThanh + '\'' +
                ", quanHuyen='" + quanHuyen + '\'' +
                ", phuongXa='" + phuongXa + '\'' +
                ", diaChi='" + diaChi + '\'' +
                ", sdt='" + sdt + '\'' +
                ", sot=" + sot +
                ", ho=" + ho +
                ", khoTho=" + khoTho +
                ", dauHong=" + dauHong +
                ", buonNon=" + buonNon +
                ", tieuChay=" + tieuChay +
                ", xuatHuyet=" + xuatHuyet +
                ", phatBan=" + phatBan +
                ", dongVat=" + dongVat +
                ", tiepXuc=" + tiepXuc +
                ", mail='" + mail + '\'' +
                '}';
    }
}
