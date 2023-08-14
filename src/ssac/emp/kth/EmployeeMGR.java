package ssac.emp.kth;

import java.util.LinkedHashMap;
import java.util.Map;

public class EmployeeMGR {

	Map<String, Employee> db = new LinkedHashMap<String, Employee>();

	public EmployeeMGR() {}

	//등록
	void insert(Employee employee) {
		if (employee.equals(db)) {
			db.put(employee.getName(), employee);
			System.out.println("등록되었습니다.");
		}
	}

	//삭제
	void remove(String name, int checkedNum) {
		if(checkedNum==1) {
			db.remove(name);
			System.out.println("사원의 정보가 삭제되었습니다.");
		}else {
			System.out.println("취소되었습니다.");
		}

	}

	//목록 보여주기
	void selectAll() {
		for (Employee employee : db.values()) {
			System.out.println(employee);
		}
	}

	//검색
	void select(String name) {
		if (checkedEmployee(name)) {
			System.out.println(name + "의 정보입니다.");
			System.out.println(db.get(name));
		}
	}

	//수정
	void update(String name, int modifyNum, String object) {
		if (checkedEmployee(name)) {
			Employee value = db.get(name); // 기존 키에 해당하는 값을 가져옴
			//이름 변경
			if (modifyNum == 1) {
				String newKey = object; // 새로운 이름이 키 값이 됨.
				value.setName(object);
				db.put(newKey, value);
				db.remove(name);
			//사번 변경
			} else if (modifyNum == 2) {
				value.setSabun(object);
				db.put(name, value);
			//전화번호 변경
			} else if (modifyNum == 3) {
				value.setPhone(object);
				db.put(name, value);
			//주소 변경
			} else if (modifyNum == 4) {
				value.setAddr(object);
				db.put(name, value);
			}

			System.out.println("수정이 완료되었습니다.");

		}
	}

	// db에 사원정보가 들어있는지 체크
	boolean checkedEmployee(String name) {
		if (db.containsKey(name)) {
			return true;
		} else {
			System.out.println("존재하지 않는 사원입니다.");
			return false;
		}
	}

}
