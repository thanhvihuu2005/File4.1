package HomeWork4_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main extends SinhVien{
    public Main(String maSV, String HoTen, String GioiTinh, double DiemPyThon, double DiemJava) {
		super(maSV, HoTen, GioiTinh, DiemPyThon, DiemJava);
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập và ghi ra file danh sách học viên
        try {
            System.out.print("Nhập số lượng học viên: ");
            int n = scanner.nextInt();
            scanner.nextLine();  // Đọc kí tự xuống dòng

            PrintWriter writer = new PrintWriter("students.txt");
            for (int i = 0; i < n; i++) {
                System.out.print("Nhập mã sinh viên: ");
                String maSV = scanner.nextLine();
                System.out.print("Nhập họ và tên: ");
                String hoTen = scanner.nextLine();
                System.out.print("Nhập giới tính: ");
                String gioiTinh = scanner.nextLine();
                System.out.print("Nhập điểm Python: ");
                double diemPython = scanner.nextDouble();
                System.out.print("Nhập điểm Java: ");
                double diemJava = scanner.nextDouble();
                scanner.nextLine();  // Đọc kí tự xuống dòng

                writer.printf("%s,%s,%s,%.2f,%.2f%n", maSV, hoTen, gioiTinh, diemPython, diemJava);
            }
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // Đọc dữ liệu từ file và thực hiện các công việc
        List<SinhVien> danhSachSV = new ArrayList<>();
        try {
            File file = new File("students.txt");
            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNextLine()) {
                String[] tokens = fileScanner.nextLine().split(",");
                SinhVien sv = new SinhVien(tokens[0], tokens[1], tokens[2], Double.parseDouble(tokens[3]), Double.parseDouble(tokens[4]));
                danhSachSV.add(sv);
            }
            fileScanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // Sắp xếp học viên theo điểm trung bình giảm dần
        Collections.sort(danhSachSV, new Comparator<SinhVien>() {
            @Override
            public int compare(SinhVien sv1, SinhVien sv2) {
                return Double.compare(sv2.DiemTB, sv1.DiemTB);
            }
        });

        // In danh sách học viên và ghi ra file
        try {
            PrintWriter writer = new PrintWriter("sorted_students.txt");
            System.out.println("Danh sách học viên sau khi sắp xếp:");
            for (SinhVien sv : danhSachSV) {
                System.out.println(sv);
                writer.println(sv);
            }
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // Nhập vào họ tên học viên cần tìm
        System.out.print("Nhập họ tên học viên cần tìm: ");
        String tenCanTim = scanner.nextLine();
        boolean timThay = false;
        for (SinhVien sv : danhSachSV) {
            if (sv.HoTen.contains(tenCanTim)) {
                System.out.println(sv);
                timThay = true;
            }
        }
        if (!timThay) {
            System.out.println("Không tìm thấy học viên có họ tên '" + tenCanTim + "'");
        }

        // Hiển thị thông tin những bạn đã đậu và những bạn đã trượt
        System.out.println("Thông tin những bạn đã đậu:");
        for (SinhVien sv : danhSachSV) {
            if (sv.ketQua.equals("Đậu")) {
                System.out.println(sv);
            }
        }
        System.out.println("Thông tin những bạn đã trượt:");
        for (SinhVien sv : danhSachSV) {
            if (!sv.ketQua.equals("Đậu")) {
                System.out.println(sv);
            }
        }

        scanner.close();
    }
}
