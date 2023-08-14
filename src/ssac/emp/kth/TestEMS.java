package ssac.emp.kth;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TestEMS {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		EmployeeMGR mgr = new EmployeeMGR();
		
		while (true) {

			System.out.println("�۾��� �������ּ���. (1.���, 2.���, 3.����, 4.����, 5.�˻�, 0.����)");

			try {
		
				int num = sc.nextInt();
				
				if(num==0) {
					System.out.println("���α׷� ����");
					break;
				}
				
				//��� ���
				if (num == 1) {
					System.out.println("�̸�, ���, ��ȭ��ȣ, �ּ� ������ �Է����ּ���.");
					String name = sc.next();
					String sabun = sc.next();
					String phone = sc.next();
					String addr = sc.next();
					
					Employee e = new Employee(name, sabun, phone, addr);
					
					mgr.insert(e);
					System.out.println(mgr.db);
					
					//��� ���
				} else if (num == 2) {
					System.out.println("��� ����Դϴ�.");
					mgr.selectAll();
					
					//������� ����
				} else if (num == 3) {
					System.out.println("������ ����� �̸��� �Է��ϼ���.");
					String modifyName = sc.next();
					mgr.select(modifyName);
					while(true) {
						
						
						System.out.println("������ ������ �������ּ���. (1.�̸� 2.��� 3.��ȭ��ȣ 4.�ּ� 0.����)");
						int modifyNum = sc.nextInt();
						
						if(modifyNum == 1) {
							System.out.println("������ �̸��� �Է����ּ���.");
							String afterName = sc.next();
							mgr.update(modifyName, modifyNum, afterName);
						}else if(modifyNum == 2) {
							System.out.println("������ ����� �Է����ּ���.");
							String afterSabun = sc.next();
							mgr.update(modifyName, modifyNum, afterSabun);
						}else if(modifyNum == 3) {
							System.out.println("������ ��ȭ��ȣ�� �Է����ּ���.");
							String afterPhone = sc.next();
							mgr.update(modifyName, modifyNum, afterPhone);
						}else if(modifyNum == 4) {
							System.out.println("������ �ּҸ� �Է����ּ���.");
							String afterAddr = sc.next();
							mgr.update(modifyName, modifyNum, afterAddr);
						}else {
							System.out.println("��� ���� ������ ���������� ���ƽ��ϴ�.");
							break;
						}
					}
					
					//������� ����
				} else if (num == 4) {
					System.out.println("������ ����� �̸��� �Է��ϼ���.");
					String delName = sc.next();
					
					if(mgr.checkedEmployee(delName)) {
						System.out.println("������ �����Ͻðڽ��ϱ�? (1.�� / 2.�ƴϿ�)");
						int checkedNum = sc.nextInt();
						mgr.remove(delName, checkedNum);
					}
					
					
					//������� �˻�
				} else if (num == 5) {
					System.out.println("�˻��� ����� �̸��� �Է����ּ���.");
					String findName = sc.next();
					
					mgr.select(findName);
					
				}
			} catch (InputMismatchException e) {
				// ���� �̿��� ���� �Է� �� ���
				System.out.println("���ڸ� �Է����ּ���!!");
				sc.nextLine(); // ���� ����
				continue;
			}
		}
		sc.close();

	}

}
