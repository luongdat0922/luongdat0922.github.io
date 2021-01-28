package QuanLyNhanSu;

import java.util.*;
import java.text.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Management {

    private static List<Personnel> list;
    private static Scanner sc;

        public Management() {
		    list = new ArrayList<>();
			sc = new Scanner(System.in);
        }
		String line = "+------------------------+-------------+-----------+-----------------+-------------+-------------+----------------------+-----------+---------------------+---------------------+%n";
		// Menu
    	public void menu() { // Tạo Menu
		int choose = -1;
		boolean predict;
		System.out.println("  222222222222222           000000000        222222222222222           1111111       ");
		System.out.println(" 2:::::::::::::::22       00:::::::::00     2:::::::::::::::22        1::::::1       ");
		System.out.println(" 2::::::222222:::::2    00:::::::::::::00   2::::::222222:::::2      1:::::::1       ");
		System.out.println(" 2222222     2:::::2   0:::::::000:::::::0  2222222     2:::::2      111:::::1       ");
		System.out.println("             2:::::2   0:::::::000:::::::0              2:::::2         1::::1       ");
		System.out.println("             2:::::2   0:::::::000:::::::0              2:::::2         1::::1       ");
		System.out.println("          2222::::2    0:::::::000:::::::0           2222::::2          1::::1       ");
		System.out.println("     22222::::::22     0:::::::000:::::::0      22222::::::22           1::::1       ");
		System.out.println("   22::::::::222       0:::::::000:::::::0    22::::::::222             1::::1       ");
		System.out.println("  2:::::22222          0:::::::000:::::::0   2:::::22222                1::::1       ");
		System.out.println(" 2:::::2               0:::::::000:::::::0  2:::::2                     1::::1       ");
		System.out.println(" 2:::::2       222222  0:::::::000:::::::0  2:::::2       222222     111::::::111    ");
		System.out.println(" 2::::::2222222:::::2   00:::::::::::::00   2::::::2222222:::::2     1::::::::::1    ");
		System.out.println(" 2::::::::::::::::::2     00:::::::::00     2::::::::::::::::::2     1::::::::::1    ");
		System.out.println(" 22222222222222222222       000000000       22222222222222222222     111111111111    ");
		do {

			String leftAlignFormat = "| %-2s | %-50s | %n";
			String line = "+----+----------------------------------------------------+%n";
			System.out.format(line);
			System.out.format("| #  |                  QUẢN LÝ NHÂN SỰ                   |%n");
			System.out.format(line);

			System.out.format(leftAlignFormat, 1, "Nhập dữ liệu nhân sự tự động");
			System.out.format(leftAlignFormat, 2, "Thêm nhân sự");
			System.out.format(leftAlignFormat, 3, "Xóa nhân sự");
			System.out.format(leftAlignFormat, 4, "Sắp xếp nhân sự (tăng dần, giảm dần)");
			System.out.format(leftAlignFormat, 5, "Tìm kiếm nhân sự");
			System.out.format(leftAlignFormat, 6, "Lọc hệ số nhân sự");
			System.out.format(leftAlignFormat, 7, "Hiển thị toàn bộ nhân sự");
			System.out.format(leftAlignFormat, 8, "Lưu file");
			System.out.format(leftAlignFormat, 9, "Đọc file");
			System.out.format(leftAlignFormat, 0, "Thoát");
			System.out.format(line);

			do {
				System.out.print(">");
				try {
					choose = Integer.parseInt(sc.nextLine());
					predict = true;
				} catch (Exception ex) {
					predict = false;
				}
			} while (predict != true);

			switch (choose) {
				case 1:
					cN1(list);
					break;
				case 2:
					cN2(list);
					break;
				case 3:
					cN3(list);
					break;
				case 4:
					cN4();
					break;
				case 5:
					cN5(list);
					break;
                case 6:
                    cN6(list);
					break;
				case 7:
					cN7(list);
					break;
				case 8:
					cN8(list);
					break;
				case 9:
					cN9(list);
					break;
			}
		} while (choose != 0);
	}
	// Format (Định dạng)
	private Date convertStringToDate() { // Chuyển chuỗi sang ngày
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date dt = new Date();
		boolean predict = false;
		do{
			System.out.print("\tNgày/Tháng/Năm >");
			try {
				dt =  sdf.parse(sc.nextLine());
				predict = true;
			} catch (ParseException e) {
				predict = false;
			}
		}while(predict != true);
		return dt;
	}

	private boolean convertStringToBoolean() { // Chuyển chuỗi về boolean
		boolean predict = false, gender = false;
		String sex;
		do{
			System.out.print("\tNu|0 => \"Nu\"\n\tNam|1 => \"Nam\"\n>");
			sex = sc.nextLine();
			if (sex.trim().equalsIgnoreCase("Nam") || sex.trim().equalsIgnoreCase("1")) {
				gender = true;
				predict = true;
			} else if (sex.trim().equalsIgnoreCase("Nu") || sex.trim().equalsIgnoreCase("0")) {
				gender = false;
				predict = true;
			} else {
				predict = false;
				System.out.println("Chỉ được nhập Nam hoặc Nữ hay 1 hoặc 0 🤔🤔🤔");
			}
		} while (predict != true);
		return gender;
	}
	// Import
	public void cN1(List<Personnel> list) {
		try {
			list.add(new Personnel("Luong Thanh Dat", new SimpleDateFormat("dd/MM/yyyy").parse("22/09/2002"), true, new SimpleDateFormat("dd/MM/yyyy").parse("22/09/2020"), "Viet Nam", "PXU001", "Bao ve", 4, 4000000));
			list.add(new Personnel("Nguyen Viet Bang", new SimpleDateFormat("dd/MM/yyyy").parse("05/01/1990"), true, new SimpleDateFormat("dd/MM/yyyy").parse("05/01/2010"), "Viet Nam", "PXU002", "Truong Phong Ke Toan", 3, 11000000));
			list.add(new Personnel("Vo Duyet", new SimpleDateFormat("dd/MM/yyyy").parse("24/01/1994"), true, new SimpleDateFormat("dd/MM/yyyy").parse("24/01/2014"), "Viet Nam", "PXU003", "Lao Cong", 4, 4000000));
			list.add(new Personnel("Tran Cong Hung", new SimpleDateFormat("dd/MM/yyyy").parse("21/12/1994"), true, new SimpleDateFormat("dd/MM/yyyy").parse("21/12/2014"), "Viet Nam", "PXU004", "Nhan Vien", 3, 8000000));
			list.add(new Personnel("Duong Van Huy", new SimpleDateFormat("dd/MM/yyyy").parse("28/05/1985"), true, new SimpleDateFormat("dd/MM/yyyy").parse("28/05/2000"), "Viet Nam", "PXU005", "Pho Giam Doc", 4, 20000000));
			list.add(new Personnel("Nguyen Huu Nhat", new SimpleDateFormat("dd/MM/yyyy").parse("23/02/1980"), true, new SimpleDateFormat("dd/MM/yyyy").parse("23/02/1998"), "Viet Nam", "PXU006", "Tong Giam Doc", 4, 25000000));
			list.add(new Personnel("Nguyen Duc Hong Phong", new SimpleDateFormat("dd/MM/yyyy").parse("28/12/1995"), true, new SimpleDateFormat("dd/MM/yyyy").parse("28/12/2013"), "Viet Nam", "PXU007", "Bao ve", 4, 4000000));
			list.add(new Personnel("Tran Thi Kieu Trinh", new SimpleDateFormat("dd/MM/yyyy").parse("27/02/1994"), false, new SimpleDateFormat("dd/MM/yyyy").parse("27/02/2014"), "Viet Nam", "PXU008", "Chuyen gia", 4, 15000000));
			list.add(new Personnel("Bui Quang Minh Hieu", new SimpleDateFormat("dd/MM/yyyy").parse("23/12/1996"), true, new SimpleDateFormat("dd/MM/yyyy").parse("23/12/2014"), "Viet Nam", "PXU009", "Bao ve", 3.5, 4000000));
			list.add(new Personnel("Nguyen Huy Hoang", new SimpleDateFormat("dd/MM/yyyy").parse("18/12/1994"), true, new SimpleDateFormat("dd/MM/yyyy").parse("18/12/2014"), "Viet Nam", "PXU010", "Lao Công", 3, 4000000));
			System.out.println("Nhập dữ liệu thành công 🤗🤗🤗");
		} catch (Exception e) {
			System.out.println("Nhập dữ liệu thất bại 😡😡😡");
		}
	}
	// Add
	public void cN2(List<Personnel> list) {
		System.out.println("Nhập tên :");
		String name = sc.nextLine();
		System.out.println("Nhập ngày sinh :");
		Date birthOfDate = this.convertStringToDate();
		System.out.println("Nhập giới tính :");
		boolean gender = this.convertStringToBoolean();
		System.out.println("Nhập ngày vào làm :");
		Date workOfDate = this.convertStringToDate();
		System.out.println("Nhập quốc tịch :");
		String country = sc.nextLine();
		System.out.println("Nhập mã số :");
		String code = sc.nextLine();
		System.out.println("Nhập chức vụ :");
		String position = sc.nextLine();
		System.out.println("Nhập hệ số :");
		double factor = Double.parseDouble(sc.nextLine());
		System.out.println("Nhập lương thỏa thuận :");
		double agreementSalary = Double.parseDouble(sc.nextLine());
		
		Personnel epl = new Personnel(name, birthOfDate, gender, workOfDate, country, code, position, factor, agreementSalary);
		if (list.contains(epl)) {
			System.out.println("Thêm thất bại 😡😡😡");
		} else {
			if (list.add(epl)) {
				System.out.println("Thêm thành công 🤗🤗🤗");
			}
		}
	}
	// Delete
	public void cN3(List<Personnel> list) {
		System.out.println("Nhập mã số :");
		String code = sc.nextLine();
		Iterator<Personnel> id = list.iterator();
		while (id.hasNext()) {
			Personnel epl = id.next();
			if (epl.getCode().equals(code)) {
				list.remove(epl);
				System.out.println("Xóa thành công 🤗🤗🤗");
				break;
			}
			
		}
	}
	// Sort
	public void cN4() {
		int choose = -1;
		boolean predict = false;
		do{
			String leftAlignFormat = "| %-2s | %-50s | %n";
			String line = "+----+----------------------------------------------------+%n";
			System.out.format(line);
			System.out.format("| #  | Sắp xếp                                            |%n");
			System.out.format(line);
			
			System.out.format(leftAlignFormat, 1, "Tăng dần :");
			System.out.format(leftAlignFormat, 2, "Giảm dần :");
			System.out.format(leftAlignFormat, 0, "Quay lại");
			System.out.format(line);

			do{
				System.out.print(">");
				try{
					choose = Integer.parseInt(sc.nextLine());
					predict = true;
				}catch(Exception ex){
					predict = false;
				}
			}while(predict != true);

			switch(choose){
				case 1:
					cN4_1(list);
					break;
				case 2:
					cN4_2(list);
					break;
			}
		}while(choose != 0);
	}
	// Ascending
	public void cN4_1(List<Personnel> list) {
		Collections.sort(list, new Comparator<Personnel>() {
			@Override
			public int compare(Personnel obj1, Personnel obj2) {
				return obj1.getName().compareToIgnoreCase(obj2.getName());
			}
		});
		cN7(list);
	}
	// Descending
	public void cN4_2(List<Personnel> list) {
		Collections.sort(list, new Comparator<Personnel>() {
			@Override
			public int compare(Personnel obj1, Personnel obj2) {
				return obj2.getName().compareToIgnoreCase(obj1.getName());
			}
		});
		cN7(list);
	}
	// Search
	public void cN5(List<Personnel> list) {
		System.out.println(" Nhập mã số :");
		String code = sc.nextLine();
		Iterator<Personnel> id = list.iterator();
		while (id.hasNext()) {
			Personnel epl = id.next();
			if (epl.getCode().equals(code)) {
				System.out.println("Tìm kiếm thành công 🤗🤗🤗");
				System.out.format(line);
				epl.display();
				break;
			}
		}
	}
	// Filter
	public void cN6(List<Personnel> list) {
		String leftAlignFormat = "| %-16d | %-7s |%n";
		String line = "+------------------+---------+%n";
		int count = 0;
		double n;
		System.out.println("Nhập hệ số :");
		n = sc.nextDouble();

		for (Personnel object : list) {
			if (object.getFactor() == n) {
				count++;
			}
		}
		System.out.format(line);
		System.out.format("| Nhân sự          | Hệ số   |%n");
		System.out.format(line);
		System.out.format(leftAlignFormat, count, n);
		System.out.format(line);
	}
	// Show
	public void cN7(List<Personnel> list) {
		System.out.format(line);
		System.out.format("| Họ và tên              | Ngày sinh   | Giới tính | Ngày vào làm    | Quốc tịch   | Mã số       | Chức vụ              | Hệ số     | Lương thỏa thuận    | Lương chính thức    |%n");
		System.out.format(line);
		for (Personnel obj : list) {
			obj.display();
		}
	}
	// Save File
	public void cN8(List<Personnel> list) {
		FileOutputStream fos = null;
        BufferedOutputStream bos = null;
        try {
            String filename = "personnel.txt";
            fos = new FileOutputStream(filename);
            
            bos = new BufferedOutputStream(fos);
            
            // Ghi dữ liệu vào file
            for (Personnel epl : list) {
                String line = epl.getLine();
                byte[] b;
                try {
                    b = line.getBytes("utf8");
                    bos.write(b);
                } catch (UnsupportedEncodingException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(bos != null) {
                    bos.close();
                }
                if(fos != null) {
                    fos.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
		}
		System.out.println("Lưu file thành công 🤗🤗🤗");
	}
	// Read File
	public void cN9(List<Personnel> list) {
        FileInputStream fis = null;
        File file_input = new File("personnel.txt");
        try {
            fis = new FileInputStream(file_input);

            StringBuilder builder = new StringBuilder();
            int code;
            while ((code = fis.read()) != -1) {
                builder.append((char) code);
            }
            String content = builder.toString();
            System.out.println(content);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
		}
		System.out.println("Đọc file thành công 🤗🤗🤗");
    }
}

    

