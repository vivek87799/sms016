package com.sms.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sms.bo.TeacherDetailsBO;
import com.sms.exceptions.SmsBusinessException;
import com.sms.exceptions.SmsException;
import com.sms.vo.TeacherDetailsVO;

/**
 * Servlet implementation class TeacherTableController
 */
public class TeacherTableController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherTableController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		TeacherDetailsBO bo = new TeacherDetailsBO();
		TeacherDetailsVO vo = new TeacherDetailsVO();
		vo.setNewcolumn(request.getParameter("cname"));
		vo.setNewdatatype(request.getParameter("datatype"));
		System.out.println(vo.getNewcolumn());
		System.out.println(vo.getNewdatatype());
		try {
			bo.addcolumn(vo);
		} catch (SmsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SmsBusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
