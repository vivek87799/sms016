package com.sms.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sms.exceptions.SmsBusinessException;
import com.sms.exceptions.SmsException;
import com.sms.vo.TeacherDetailsVO;

public class TeacherDetailsDAO {

	PreparedStatement addcolumn_statement=null,teachertable_statement;
	Connection con;
	ResultSet result;
	public TeacherDetailsDAO() throws SmsException, SmsBusinessException {
		try {
			Class.forName("com.mysql.jdbc.Driver");		
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "admin");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			throw new SmsException("Database driver not found");
		}
		catch(SQLException e){
			throw new SmsBusinessException("Connection could not be established");
		}
	}
	
	public void addColumn(TeacherDetailsVO vo){
		String exe_statem = null;
		String datatype = vo.getNewdatatype();	
		if(datatype.equalsIgnoreCase("char")){
			exe_statem = "alter table teacherdetails add " + vo.getNewcolumn() + " varchar(30)";
		}
		else if(datatype.equalsIgnoreCase("number")){
			exe_statem = "alter table teacherdetails add " + vo.getNewcolumn() + " int(10)";
		}
		else if(datatype.equalsIgnoreCase("date")){
			exe_statem = "alter table teacherdetails add " + vo.getNewcolumn() + " date";
		}
		try {	
			addcolumn_statement = con.prepareStatement(exe_statem);
			addcolumn_statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<String> retreiveTeacherTable(){
		List<String> teacher_list = new ArrayList<String>();;
		try {
			teachertable_statement = con.prepareStatement("select column_name from information_schema.columns where table_name='teacherdetails' order by ordinal_position");
			result = teachertable_statement.executeQuery();
			while(result.next()){
				teacher_list.add(result.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return teacher_list;	
	}
}
