package com.rim.input;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.Scanner;

import com.rim.member.MemberDTO;
import com.rim.view.MemberView;

public class MemberInput {
	private MemberView mv;
	
	public MemberInput() {
		// TODO Auto-generated constructor stub
		mv = new MemberView();
	}
	
	public MemberDTO setMember() throws Exception {
		Scanner sc = new Scanner(System.in);
		MemberDTO dto = new MemberDTO();
		
		mv.view("NUM:");
		dto.setNum(sc.nextInt());
		mv.view("ID:");
		dto.setId(sc.next());
		mv.view("PWD:");
		dto.setPwd(sc.next());
		mv.view("이름:");
		dto.setName(sc.next());
		mv.view("나이:");
		dto.setAge(sc.nextInt());
		mv.view("생일:");
		String birth = sc.next();
		Date date = Date.valueOf(birth);
//		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
//		Date date = sd.parse(birth);
//		java.sql.Date dBirth = new java.sql.Date(date.getTime());
		dto.setBirth(date);
		
		return dto;
		
	}
	
	public String setID(String str) {
		String id;
		
		Scanner sc = new Scanner(System.in);
		mv.view(str+" id:");
		id = sc.next();
		
		return id;
	}

}
