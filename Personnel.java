package QuanLyNhanSu;

import java.text.*;
import java.util.*;

public class Personnel extends General {
    // Properties (Thuộc tính)
    private String code; // Mã số
    private String position; // Chức vụ
    private double factor; // Hệ số
    private double agreementSalary; // Lương thỏa thuận
	public String setName;
    // Constructors (Khởi tạo)
    public Personnel() {
    }

    public Personnel(String name, Date birthOfDate, boolean gender, Date workOfDate, String country,
                     String code, String position, double factor, double agreementSalary) {
        super(name, birthOfDate, gender, workOfDate, country);
        this.code = code;
        this.position = position;
        this.factor = factor;
        this.agreementSalary = agreementSalary;
    }
     // Get and Set (Trả về giá trị cho biến và đặt giá trị)
	public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPosition() {
        return position;
    }

    public void Position(String position) {
        this.position = position;
    }

    public double getFactor() {
        return factor;
    }

    public void setFactor(double factor) {
        this.factor = factor;
    }

    public double getAgreementSalary() {
        return agreementSalary;
    }

    public void setAgreementSalary(double agreementSalary) {
        this.agreementSalary = agreementSalary;
    }
    // Methods (Phương thức)
    public double officialSalary(){ // Lương chính thức
		return this.agreementSalary + super.seniority(); // Lương chính thức + Phụ cấp thâm niên
    }
    // Format (Định dạng)
    public String formatMoney(double number) { // Định dạng tiền
        try {
            NumberFormat nf = new DecimalFormat("###,###");
            String value = nf.format(number);
            value = value.replaceAll(",", ".");
            return value + " VND";
        } catch (Exception e) {
            return "Sai định dạng 🤔🤔🤔";
        }
    }

    private String convertBoolToString(Boolean gender) { // Chuyển boolean sang chuỗi
		if(gender == true)  
			return "Nam";
		else
			return "Nu";
    }

    private String convertDatetoString(Date date) { // Chuyển ngày sang chuỗi
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return sdf.format(date);
    }
    
    public void display() { // Hiển thị theo bảng
        String leftAlignFormat = "| %-22s | %-11s | %-9s | %-15s | %-11s | %-11s | %-20s | %-9s | %-19s | %-19s |%n";
        String line = "+------------------------+-------------+-----------+-----------------+-------------+-------------+----------------------+-----------+---------------------+---------------------+%n";
        System.out.format(leftAlignFormat, getName(), this.convertDatetoString(getBirthOfDate()), this.convertBoolToString(getGender()), this.convertDatetoString(getWokOfDate()), getCountry(), getCode(), getPosition(), getFactor(), this.formatMoney(getAgreementSalary()), this.formatMoney(officialSalary()));
        System.out.format(line);
    }
    
    @Override
	public boolean equals(Object obj) { // Truy vấn đến mã số
		if(obj instanceof Personnel) {
			Personnel epl = (Personnel)obj;
			return this.code.equals(epl.code);
		}
		return false;
    }
    
    String getLine() { // Kiểu dữ liệu đưa vào file
        return name+","+this.convertDatetoString(getBirthOfDate())+","+this.convertBoolToString(getGender())+","+this.convertDatetoString(getWokOfDate())+","+country+","+code+","+position+","+factor+","+this.formatMoney(getAgreementSalary())+","+this.formatMoney(officialSalary())+"\n";
    }
}
