package ssac.emp.kth;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TestEMS {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		EmployeeMGR mgr = new EmployeeMGR();
		
		while (true) {

			System.out.println("작업을 선택해주세요. (1.등록, 2.목록, 3.수정, 4.삭제, 5.검색, 0.종료)");

			try {
		
				int num = sc.nextInt();
				
				if(num==0) {
					System.out.println("프로그램 종료");
					break;
				}
				
				//사원 등록
				if (num == 1) {
					System.out.println("이름, 사번, 전화번호, 주소 순으로 입력해주세요.");
					String name = sc.next();
					String sabun = sc.next();
					String phone = sc.next();
					String addr = sc.next();
					
					Employee e = new Employee(name, sabun, phone, addr);
					
					mgr.insert(e);
					System.out.println(mgr.db);
					
					//사원 목록
				} else if (num == 2) {
					System.out.println("사원 목록입니다.");
					mgr.selectAll();
					
					//사원정보 수정
				} else if (num == 3) {
					System.out.println("수정할 사원의 이름을 입력하세요.");
					String modifyName = sc.next();
					mgr.select(modifyName);
					while(true) {
						
						
						System.out.println("수정할 사항을 선택해주세요. (1.이름 2.사번 3.전화번호 4.주소 0.저장)");
						int modifyNum = sc.nextInt();
						
						if(modifyNum == 1) {
							System.out.println("수정할 이름을 입력해주세요.");
							String afterName = sc.next();
							mgr.update(modifyName, modifyNum, afterName);
						}else if(modifyNum == 2) {
							System.out.println("수정할 사번을 입력해주세요.");
							String afterSabun = sc.next();
							mgr.update(modifyName, modifyNum, afterSabun);
						}else if(modifyNum == 3) {
							System.out.println("수정할 전화번호를 입력해주세요.");
							String afterPhone = sc.next();
							mgr.update(modifyName, modifyNum, afterPhone);
						}else if(modifyNum == 4) {
							System.out.println("수정할 주소를 입력해주세요.");
							String afterAddr = sc.next();
							mgr.update(modifyName, modifyNum, afterAddr);
						}else {
							System.out.println("사원 정보 수정을 성공적으로 마쳤습니다.");
							break;
						}
					}
					
					//사원정보 삭제
				} else if (num == 4) {
					System.out.println("삭제할 사원의 이름을 입력하세요.");
					String delName = sc.next();
					
					if(mgr.checkedEmployee(delName)) {
						System.out.println("정말로 삭제하시겠습니까? (1.예 / 2.아니오)");
						int checkedNum = sc.nextInt();
						mgr.remove(delName, checkedNum);
					}
					
					
					//사원정보 검색
				} else if (num == 5) {
					System.out.println("검색할 사원의 이름을 입력해주세요.");
					String findName = sc.next();
					
					mgr.select(findName);
					
				}
			} catch (InputMismatchException e) {
				// 숫자 이외의 글자 입력 시 출력
				System.out.println("숫자를 입력해주세요!!");
				sc.nextLine(); // 버퍼 비우기
				continue;
			}
		}
		sc.close();

	}

}
