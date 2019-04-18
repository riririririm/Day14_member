package com.rim.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Random;

import org.junit.Test;

import com.rim.input.MemberInput;
import com.rim.member.MemberDAO;
import com.rim.member.MemberDTO;

public class MemberDAOTest {

	//@Test
	public void deleteTest() throws Exception {
		MemberDAO dao = new MemberDAO();
		
		int result = dao.delete();
		
		assertEquals(1, result);
	}
	
	//@Test
	public void selectTest() throws Exception {
		MemberDAO dao = new MemberDAO();
		
		MemberDTO dto = dao.select();
		
		assertNotNull(dto);
	}
	
	//@Test
	public void selectListTest() throws Exception {
		MemberDAO dao = new MemberDAO();
		
		ArrayList<MemberDTO> arr = dao.selectList();
		
		assertNotNull(arr);
	}
	
	//@Test
	public void insertTest() throws Exception {
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = new MemberDTO();
		MemberInput input = new MemberInput();
		
		dto = input.setMember();
		
		int result = dao.insert(dto);
		
		assertEquals(1, result);
	}

	//@Test
//	public void test() throws Exception{
//		MemberDAO dao = new MemberDAO();
//		
//		Random r = new Random();
//		for (int i = 0; i < 100; i++) {
//			MemberDTO dto = new MemberDTO();
//			int num = dto.getNum();
//			
//			dto.setNum(num+1);
//			dto.setId("a"+i);
//			dto.setPwd(num+1+"");
//			dto.setName(num+"");
//			dto.setAge(r.nextInt(101));
//			dto.setBirth('2001-12-12');
//			int result= dao.insert(dto);
//		}
//	}
}
