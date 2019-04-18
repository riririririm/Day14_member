package com.rim.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import com.rim.input.MemberInput;
import com.rim.util.DBConnector;
import com.rim.view.MemberView;

public class MemberDAO {
	private Scanner sc;
	private MemberView mv;
	private Connection conn;
	private MemberDTO dto;
	private MemberInput input;

	public MemberDAO() throws Exception {
		// TODO Auto-generated constructor stub
		sc = new Scanner(System.in);
		mv = new MemberView();
		input = new MemberInput();

	}

	public int getNum() throws Exception {
		Connection conn = DBConnector.getConnector();

		String sql = "select max(num) from member";
		PreparedStatement pst = conn.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		
		int num=0;
		if(rs.next())
			num = rs.getInt("num");
		
		DBConnector.disConnect(pst, conn);
		return num;
	}

	public int insert(MemberDTO dto) throws Exception {
		Connection conn = DBConnector.getConnector();

		String sql = "insert into member values(?,?,?,?,?,?)";
		// String sql = "insert into member values(?,?,?,?,to_date(?, yyyy-mm-dd))";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setInt(1, dto.getNum());
		pst.setString(2, dto.getId());
		pst.setString(3, dto.getPwd());
		pst.setString(4, dto.getName());
		pst.setInt(5, dto.getAge());
		pst.setDate(6, dto.getBirth());
		// pst.setString(5, dto.getBirth2());
		int result = pst.executeUpdate();

		return result;

	}

	public int delete() throws Exception {
		conn = new DBConnector().getConnector();
		String sql = "delete member where id = ?";
		PreparedStatement pst = conn.prepareStatement(sql);

		String id = input.setID("삭제할");
		pst.setString(1, id);
		int result = pst.executeUpdate();

		DBConnector.disConnect(pst, conn);

		return result;
	}

	public MemberDTO select() throws Exception {
		conn = new DBConnector().getConnector();
		String sql = "select * from member where id=?";
		PreparedStatement pst = conn.prepareStatement(sql);

		String id = input.setID("검색할");
		pst.setString(1, id);
		ResultSet rs = pst.executeQuery();

		dto = null;
		if (rs.next()) {
			dto = new MemberDTO();
			dto.setId(rs.getString("id"));
			dto.setPwd(rs.getString("pwd"));
			dto.setName(rs.getString("name"));
			dto.setAge(rs.getInt("age"));
			dto.setBirth(rs.getDate("birth"));
		}

		DBConnector.disConnect(pst, conn);

		return dto;
	}

	public ArrayList<MemberDTO> searchMember() throws Exception {
		ArrayList<MemberDTO> arr = new ArrayList<MemberDTO>();
		conn = new DBConnector().getConnector();
		String sql = "select * from member where id like ?";
		PreparedStatement pst = conn.prepareStatement(sql);

		String sid = input.setID("검색할");
		pst.setString(1, "%" + sid + "%");
		ResultSet rs = pst.executeQuery();

		dto = null;
		while (rs.next()) {
			MemberDTO dto = new MemberDTO();
			dto.setId(rs.getString("id"));
			dto.setPwd(rs.getString("pwd"));
			dto.setName(rs.getString("name"));
			dto.setAge(rs.getInt("age"));
			dto.setBirth(rs.getDate("birth"));
			arr.add(dto);
		}

		return arr;
	}

	public ArrayList<MemberDTO> selectList() throws Exception {
		ArrayList<MemberDTO> arr = new ArrayList<MemberDTO>();
		conn = DBConnector.getConnector();
		String sql = "select * from member";
		PreparedStatement pst = conn.prepareStatement(sql);

		ResultSet rs = pst.executeQuery();

		while (rs.next()) {
			MemberDTO dto = new MemberDTO();
			dto.setId(rs.getString("id"));
			dto.setPwd(rs.getString("pwd"));
			dto.setName(rs.getString("name"));
			dto.setAge(rs.getInt("age"));
			dto.setBirth(rs.getDate("birth"));
			arr.add(dto);
		}

		return arr;
	}

}
