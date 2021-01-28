package QuanLyNhanSu;

import java.util.*;

public  abstract class General {
    // Properties (Thuộc tính)
    protected String name; // Tên
    protected Date birthOfDate; // Ngày sinh
    protected boolean gender; // Giới tính
    protected Date workOfDate; // Ngày vào làm
    protected String country; // Đất nước
    // Constructors (Khởi tạo)
    public General() {
    }
    
    public General(String name, Date birthOfDate, boolean gender, Date workOfDate, String country) {
        this.name = name;
        this.birthOfDate = birthOfDate;
        this.gender = gender;
        this.workOfDate = workOfDate;
        this.country = country;
    }
    // Get and Set (Trả về giá trị cho biến và đặt giá trị)
    public String getName() {
        return name;
    }

    public void setTen(String name) {
        this.name = name;
    }

    public Date getBirthOfDate() {
        return birthOfDate;
    }

    public void setNgaySinh(Date birthOfDate) {
        this.birthOfDate = birthOfDate;
    }

    public boolean getGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public Date getWokOfDate() {
        return workOfDate;
    }

    public void workOfDate(Date workOfDate) {
        this.workOfDate = workOfDate;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    // Methods (Phương thức)
    public double seniority() { // Phụ cấp thâm niên 
		Calendar calNow = Calendar.getInstance();
		Calendar calPast = Calendar.getInstance();
		calNow.getTime();
		calPast.setTime(workOfDate);
		int totalYear = calNow.get(Calendar.YEAR) - calPast.get(Calendar.YEAR); // Tổng năm = Năm hiện tại - Năm quá khứ (Ngày vào làm).
		return totalYear * 1000000; // Tổng năm * 1.000.000 VNĐ.
    }
    
    abstract double officialSalary(); // Lương chính thức
}
