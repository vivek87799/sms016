package com.sms.customtags;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.sms.dao.impl.TeacherDetailsDAO;
import com.sms.exceptions.SmsBusinessException;
import com.sms.exceptions.SmsException;
import com.sms.util.PropertyUtil;

public class RetreiveTeacherDetails extends SimpleTagSupport{

	
	public void doTag() {

		TeacherDetailsDAO dao = null;
		try {
			dao = new TeacherDetailsDAO();
		} catch (SmsException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SmsBusinessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		List<String> teacher_list;
		teacher_list = dao.retreiveTeacherTable();
		Iterator<String> io = teacher_list.iterator();
		final JspWriter out = getJspContext().getOut();
		try {
			while(io.hasNext()){
				out.print("<label>" + io.next() + "</label>");
				out.print("<input type='text' /><br/>");
			}
			
		} catch (IOException e) {
			
		}

	}
}
