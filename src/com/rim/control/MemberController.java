package com.rim.control;

import java.util.ArrayList;
import java.util.Scanner;

import com.rim.input.MemberInput;
import com.rim.member.MemberDAO;
import com.rim.member.MemberDTO;
import com.rim.view.MemberView;

public class MemberController {
	private MemberDAO dao;
	private MemberDTO dto;
	private MemberView mv;
	private MemberInput input;
	private Scanner sc;
	private ArrayList<MemberDTO> arr;

	public MemberController() throws Exception {
		// TODO Auto-generated constructor stub
		sc = new Scanner(System.in);
		mv = new MemberView();
		dao = new MemberDAO();
		input = new MemberInput();
		arr = new ArrayList<MemberDTO>();
	}
	
	public void start() throws Exception {
		int result;
		String str;
		
		while(true) {
			mv.view("1.회원가입 / 2.회원탈퇴 / 3.회원정보 검색 / 4.회원전체 정보 / 5.검색 / 6.종료");
			int select = sc.nextInt();
			
			if(select==1) {
				dto = input.setMember();
				result = dao.insert(dto);
				str="가입실패";
				if(result>0)
					str="가입성공";
				mv.view(str);
				
			}else if(select==2) {
				result = dao.delete();
				str="삭제실패";
				if(result>0)
					str = "삭제성공";
				
				mv.view(str);
	
			}else if(select==3) {
				dto = dao.select();
				
				if(dto!=null)
					mv.view(dto);
				else
					mv.view("없는 회원");
				
			}else if(select==4) {
				arr = dao.selectList();
				if(arr!=null)
					mv.view(arr);
				else
					mv.view("조회실패");				
				
			}else if(select==5) {
				arr= dao.searchMember();
				if(arr!=null)
					mv.view(arr);
				else
					mv.view("없는 회원");
			}
			else if(select==6) {
				mv.view("프로그램 종료");
				break;
			}else {
				mv.view("1~5번 중에 선택하세요");
			}
		}//end of while
		
		
		
		
		
	}
}
