package ssac.emp.kth;

import java.util.Map;

public class Employee {

	private String name;
	private String sabun;
	private String phone;
	private String addr;
	
	
	

	public Employee(String name, String sabun, String phone, String addr) {
		this.name = name;
		this.sabun = sabun;
		this.phone = phone;
		this.addr = addr;
	}


	public boolean equals(Map db) {
		if(db.containsKey(name)) {
			System.out.println("�̹� �����ϴ� ����Դϴ�.");
			return false;
		}else {
			return true;
		}
	}

	@Override
	public String toString() {
		return "[����̸�: " + name + ", ���: " + sabun + ", ��ȭ��ȣ: " + phone + ", �ּ�: " + addr + "]";
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSabun() {
		return sabun;
	}
	public void setSabun(String sabun) {
		this.sabun = sabun;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}

}
