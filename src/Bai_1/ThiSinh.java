package Bai_1;

public class ThiSinh {
    private String sbd;
    private String hoTen;
    private String diaChi;
    private String uuTien;

    public ThiSinh() {
    }

    public ThiSinh(String sbd, String hoTen, String diaChi, String uuTien) {
        this.sbd = sbd;
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.uuTien = uuTien;
    }

    public String getSbd() {
        return sbd;
    }

    public void setSbd(String sbd) {
        this.sbd = sbd;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getUuTien() {
        return uuTien;
    }

    public void setUuTien(String uuTien) {
        this.uuTien = uuTien;
    }
}
