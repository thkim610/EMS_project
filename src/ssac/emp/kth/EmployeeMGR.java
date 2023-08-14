package ssac.emp.kth;

import java.util.LinkedHashMap;
import java.util.Map;

public class EmployeeMGR {

	Map<String, Employee> db = new LinkedHashMap<String, Employee>();

	public EmployeeMGR() {}

	//���
	void insert(Employee employee) {
		if (employee.equals(db)) {
			db.put(employee.getName(), employee);
			System.out.println("��ϵǾ����ϴ�.");
		}
	}

	//����
	void remove(String name, int checkedNum) {
		if(checkedNum==1) {
			db.remove(name);
			System.out.println("����� ������ �����Ǿ����ϴ�.");
		}else {
			System.out.println("��ҵǾ����ϴ�.");
		}

	}

	//��� �����ֱ�
	void selectAll() {
		for (Employee employee : db.values()) {
			System.out.println(employee);
		}
	}

	//�˻�
	void select(String name) {
		if (checkedEmployee(name)) {
			System.out.println(name + "�� �����Դϴ�.");
			System.out.println(db.get(name));
		}
	}

	//����
	void update(String name, int modifyNum, String object) {
		if (checkedEmployee(name)) {
			Employee value = db.get(name); // ���� Ű�� �ش��ϴ� ���� ������
			//�̸� ����
			if (modifyNum == 1) {
				String newKey = object; // ���ο� �̸��� Ű ���� ��.
				value.setName(object);
				db.put(newKey, value);
				db.remove(name);
			//��� ����
			} else if (modifyNum == 2) {
				value.setSabun(object);
				db.put(name, value);
			//��ȭ��ȣ ����
			} else if (modifyNum == 3) {
				value.setPhone(object);
				db.put(name, value);
			//�ּ� ����
			} else if (modifyNum == 4) {
				value.setAddr(object);
				db.put(name, value);
			}

			System.out.println("������ �Ϸ�Ǿ����ϴ�.");

		}
	}

	// db�� ��������� ����ִ��� üũ
	boolean checkedEmployee(String name) {
		if (db.containsKey(name)) {
			return true;
		} else {
			System.out.println("�������� �ʴ� ����Դϴ�.");
			return false;
		}
	}

}
