package com.sms.bo;

import com.sms.dao.impl.TeacherDetailsDAO;
import com.sms.exceptions.SmsBusinessException;
import com.sms.exceptions.SmsException;
import com.sms.vo.TeacherDetailsVO;

public class TeacherDetailsBO {

	TeacherDetailsDAO dao;
	public void addcolumn(TeacherDetailsVO vo) throws SmsException, SmsBusinessException{
		System.out.println("booo");
		dao = new TeacherDetailsDAO();
		dao.addColumn(vo);
	}
}
