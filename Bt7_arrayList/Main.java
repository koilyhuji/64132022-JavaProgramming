package Bt7_arrayList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		DSSV dssv = new DSSV();
		int choice;
        System.out.println("-----Menu-----");
        System.out.println("1.Thêm SV");
        System.out.println("2.In danh sách SV");
        System.out.println("3.Kiểm tra SV có tồn tại không");
        System.out.println("4.Xóa SV");
        System.out.println("5.Tìm kiếm SV");
        System.out.println("6.Sắp xếp danh sách SV");
        System.out.print("Lựa chọn: ");
        choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
        case 1: {
            SinhVien sVien=new SinhVien();
            System.out.print("Nhập MSSV: ");
            sVien.setId(scanner.nextLine());
            System.out.print("Nhập họ tên: ");
            sVien.setHoten(scanner.nextLine());
            System.out.print("Nhập năm sinh: ");
            sVien.setNamsinh(scanner.nextInt());
            System.out.print("Nhập điểm TB: ");
            sVien.setDiemTB(scanner.nextFloat());
            dssv.ThemSV(sVien);
        } break;
        
        case 2:{
            dssv.inDS();
        } break;
        
        case 3: {
            String msv;
            System.out.print("Nhập MSSV: ");
            msv=scanner.nextLine();
            dssv.KtSinhVien(msv);
        } break;
        
        case 4: {
            String msv;
            System.out.print("Nhập MSSV: ");
            msv=scanner.nextLine();
            dssv.Xoa(msv);
        } break;
        
        case 5: {
            String ten;
            System.out.print("Nhập tên SV: ");
            ten=scanner.nextLine();
            dssv.Timkiem(ten);
        } break;
        
        case 6: {
            dssv.Sapxep();
            dssv.inDS();
        } break;
        default:
            System.out.println("Lựa chọn lỗi!");
        } 
	}
}
