package com.db.point;

import java.util.Scanner;

public class PointController {
	
	private Scanner sc;
	private PointInput pi;
	private PointDAO pa;
	private PointView pv;
	
	public PointController() {
		
		sc = new Scanner(System.in);
		pi = new PointInput();
		pa = new PointDAO();
		pv = new PointView();
		
	}
	
	
	public void start() throws Exception {
		
		
		boolean check = true;
		
		while(check) {
			
			System.out.println("1. 점수 정보 등록");
			System.out.println("2. 종료");
			int select = sc.nextInt();
			
			switch(select) {
			
			case 1:
				PointDTO pointDTO = pi.setPoint();
				int result = pa.insert(pointDTO);
				
				String message = "등록 실패";
				
				if(result > 0) {
					
					message = "등록 성공";
					
				}
				
				pv.view(message);
				
				
				break;
				
			default:
				check = !check;
				System.out.println("프로그램이 종료 됩니다.");
			
			
			}
			
			
		}
		
	}

}
