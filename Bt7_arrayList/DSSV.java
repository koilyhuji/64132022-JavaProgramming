
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class DSSV {
	private ArrayList<SinhVien> SinhViens;

	public DSSV(ArrayList<SinhVien> SinhViens) {
		super();
		this.SinhViens = SinhViens;
	}

	public DSSV() {
        super();
        SinhViens =new ArrayList<SinhVien>();
	}
	
	public void ThemSV(SinhVien sv) {
		this.SinhViens.add(sv);
	}
	
	public void inDS() {
		for(SinhVien sv:SinhViens) {
			System.out.println(sv.toString());
		}
	}
	public void KtSinhVien(String id) {
		for(SinhVien sv:SinhViens) {
			if(sv.getId().equals(id)) {
                System.out.println("SV tồn tại!");
				return;
			}	
		}
		System.out.println("SV không tồn tại!");
	}
	
	public void Xoa(String id) {

		for(SinhVien sv:SinhViens) {
			if(sv.getId().equals(id)) {
				SinhViens.remove(sv);
				System.out.println("Xóa SV thành công!");
                return;
			}
			
		}
        System.out.println("Xóa SV không thành công!");

	}
	public void Timkiem(String ten) {
		for(SinhVien sv:SinhViens) {
			if(sv.getHoten().equals(ten)) System.out.println(sv.toString());
		}
	}
	public void Sapxep() {
		Collections.sort(this.SinhViens,new Comparator<SinhVien>() {

			@Override
			public int compare(SinhVien sv1, SinhVien sv2) {
				// TODO Auto-generated method stub
				if(sv1.getDiemTB()>sv2.getDiemTB()) return -1;
				if(sv1.getDiemTB()<sv2.getDiemTB()) return 1;
				else return 0;
			}
		});
	}
}