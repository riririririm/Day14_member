package com.rim.view;

import java.util.ArrayList;

import com.rim.member.MemberDTO;

public class MemberView {

	public void view(String str) {
		System.out.println(str);
	}
	
	public void view(MemberDTO dto) {
		System.out.println("ID : "+dto.getId());
		System.out.println("PWD : "+dto.getPwd());
		System.out.println("이름 : "+dto.getName());
		System.out.println("나이 : "+dto.getAge());
		System.out.println("생일 : "+dto.getBirth());
		System.out.println();
	}
	
	public void view(ArrayList<MemberDTO> arr) {
		for(MemberDTO dto : arr)
			view(dto);
	}
}
