package com.vti.backend;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.vti.entity.CanBo;
import com.vti.entity.CongNhan;
import com.vti.entity.KySu;
import com.vti.entity.NhanVien;
import com.vti.entity.GioiTinh;

public class QLCB {
	public List<CanBo> cb = new ArrayList<>();
	public Scanner sc = new Scanner(System.in);
	
	public void generateCanBo() {
		CanBo congNhan1 = new CongNhan("Nguyen Trong Hoang", 22, "Nam", "Ha Noi", 2);
		CanBo kySu1 = new KySu("Bui Huy Dong", 21, "Nam", "Nam Dinh", "Robot");
		CanBo nhanVien1 = new NhanVien("Nguyen Hai Yen", 21, "Nu", "Ha Noi", "Dieu phoi");
		
		cb.add(nhanVien1);
		cb.add(kySu1);
		cb.add(congNhan1);
	}
	
	public void q1() {
		while(true) {
			System.out.println("Chon cac chuc nang sau de quan ly can bo:");
			System.out.println("1. Them moi can bo");
			System.out.println("2. Tim kiem theo ho ten");
			System.out.println("3. Hien thi thong tin danh sach can bo");
			System.out.println("4. Xoa can bo theo ten");
			System.out.println("0. Thoat");
			int x = sc.nextInt();
			switch(x) {
			case 1:
				addCanBo();
				break;
			case 2:
				searchByName();
				break;
			case 3:
				viewListCB();
				break;
			case 4:
				delByName();
				break;
			case 0:
				return;
			}
		}
	}
	
	public void addCanBo() {
		while(true) {
			System.out.println("Chon can bo muon them moi:");
			System.out.println("1. Cong nhan");
			System.out.println("2. Ky su");
			System.out.println("3. Nhan vien");
			System.out.println("0. Thoat");
			int x = sc.nextInt();
			switch(x) {
			case 1:
				nhapThongTinCB("Cong nhan");
				break;
			case 2:
				nhapThongTinCB("Ky su");
				break;
			case 3:
				nhapThongTinCB("Nhan vien");
				break;
			case 0:
				return;
			}
		}
	}
	
	public void nhapThongTinCB(String loaiCB) {
		sc.nextLine();
		System.out.println("Nhap thong tin cho " + loaiCB);
		System.out.println("Nhap ho ten: ");
		String name = sc.nextLine();
		System.out.println("Nhap tuoi: ");
		int age = sc.nextInt();
		System.out.println("Nhập vào giới tính " + " 1: Nam, 2: Nữ, 3: Khác");
		int gioiTinhNum = sc.nextInt();
		String gioitinh = "";
		switch (gioiTinhNum) {
		case 1:
			gioitinh = GioiTinh.GIOI_TINH_NAM.getGioiTinh();
			break;
		case 2:
			gioitinh = GioiTinh.GIOI_TINH_NU.getGioiTinh();
			break;
		case 3:
			gioitinh = GioiTinh.GIOI_TINH_KHAC.getGioiTinh();
			break;
		}
		sc.nextLine();
		System.out.println("Nhap dia chi: ");
		String addredd = sc.nextLine();
		
		if(loaiCB == "Cong nhan") {
			System.out.println("Nhap bac cong nhan: ");
			int bac = sc.nextInt();
			CanBo newCongNhan = new CongNhan(name, gioiTinhNum, gioitinh, addredd, bac);
			cb.add(newCongNhan);
		} else if (loaiCB == "Ky su") {
			System.out.println("Nhap chuyen nganh: ");
			String nganhDaotao = sc.nextLine();
			CanBo newKySu = new KySu(name, gioiTinhNum, gioitinh, addredd, nganhDaotao);
			cb.add(newKySu);
		} else {
			System.out.println("Nhap cong viec: ");
			String congViec = sc.nextLine();
			CanBo newNhanVien = new NhanVien(name, gioiTinhNum, gioitinh, addredd, congViec);
			cb.add(newNhanVien);
		}
	}
	
	public void searchByName() {
		sc.nextLine();
		System.out.println("Nhap ten can tim: ");
		String name = sc.nextLine();
		
		for(CanBo o:cb) {
			if(o.getHoTen().equals(name)) {
				System.out.println(o);
			}
		}
	}
	
	public void viewListCB() {
		if(cb.size() > 0) {
			for(CanBo o:cb) {
				System.out.println(o);
			}
		} else {
			System.out.println("Chua co can bo nao");
		}
		
	}
	
	public void delByName() {
		sc.nextLine();
		System.out.println("Nhap ten can xoa: ");
		String name = sc.nextLine();
		
		List<CanBo> tmp = cb;
		for(CanBo o:cb) {
			if(o.getHoTen().equals(name)) {
				tmp.remove(o);
			}
		}
		cb = tmp;
	}
}
