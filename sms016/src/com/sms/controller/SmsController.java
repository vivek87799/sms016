package com.sms.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import com.sms.bo.SmsBO;
import com.sms.delegate.SmsDelegate;
import com.sms.exceptions.SmsBusinessException;
import com.sms.exceptions.SmsException;
import com.sms.vo.ExtraVO;
import com.sms.vo.SubjectVO;
import com.sun.corba.se.impl.protocol.giopmsgheaders.Message;

/**
 * Servlet implementation class SmsController
 */
public class SmsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SmsController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String val = (String) request.getParameter("val");
		System.out.println("hidden---->>>>>>>>>>>" + val);
		HttpSession session=request.getSession();		
		session.setAttribute("std", Integer.parseInt(request.getParameter("std")));
		session.setAttribute("type", request.getParameter("type"));		
		
		System.out.println(val);
		
		SmsDelegate delegate = new SmsDelegate();
		
		if(val!=null){
					
			//To retrive subject to edit
		if(val.equalsIgnoreCase("1")){
			SmsBO bo=new SmsBO();
			if(((String)session.getAttribute("type")).equalsIgnoreCase("subject")){
				String sub_code = request.getParameter("r_subject");
		        SubjectVO vo=new SubjectVO();		        		       		        
		        try {
					//vo=bo.retreiveEditingSubjectInfo(sub_code);
		        	vo=delegate.retreiveEditingSubjectDelegate(sub_code);
					System.out.println(vo.getSubjectname()+"sub to get edited");
					session.setAttribute("rvo",vo);
					session.setAttribute("edit", "edit");
				} catch (SmsBusinessException e) {
					// TODO Auto-generated catch block
					request.setAttribute("message", e.getMessage());
					RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp"); 
					//This error message shld be redirected to the subjext.jsp page after the UI is done
					dispatcher.forward(request, response);					
				} catch (SmsException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
		
			}
			else if(((String)session.getAttribute("type")).equalsIgnoreCase("extra")){
				String extra_code = request.getParameter("r_extra");				
				ExtraVO vo = new ExtraVO();
				try {
					//vo=bo.retreiveEditingExtraInfo(extra_code);
					vo=delegate.retreiveEditingExtraDelegate(extra_code);
					session.setAttribute("rvo",vo);
					session.setAttribute("edit", "edit");
				} catch (SmsBusinessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			       	} catch (SmsException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 			
			}
		}
		
		
		//To delete the subject
		if(val.equalsIgnoreCase("2")){			
	        SmsBO bo=new SmsBO();    
	        if(((String)session.getAttribute("type")).equalsIgnoreCase("subject")){
	        	String sub_code = request.getParameter("r_subject");
	        	try {	
					//bo.deleteSubjectInfo(sub_code);
	        		delegate.deletesubjectDelegate(sub_code);
				}catch (SmsBusinessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			       	} catch (SmsException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
	        }
	        else if(((String)session.getAttribute("type")).equalsIgnoreCase("extra")){
	        	String extra_code = request.getParameter("r_extra");				
				try {
					//bo.deleteExtraInfo(extra_code);
					delegate.deleteExtraDelegate(extra_code);
				} catch (SmsBusinessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			       	} catch (SmsException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
	        }
	        
		}
			
		//To add subject to the table
		if(val.equalsIgnoreCase("3")){			
			SmsBO bo=new SmsBO();
			if(((String)session.getAttribute("type")).equalsIgnoreCase("subject")){
				SubjectVO addinfo = new SubjectVO();
				addinfo.setSubjectname(request.getParameter("subname"));
				addinfo.setSubjectcode(request.getParameter("subcode"));
				addinfo.setMax_mark(Integer.parseInt(request.getParameter("maxmarks")));
				addinfo.setPass_mark(Integer.parseInt(request.getParameter("passmarks")));	
				addinfo.setStd(Integer.parseInt(request.getParameter("std")));
				try {
					//bo.insertSubjectInfo(addinfo);
					delegate.insertSubjectDelegate(addinfo);
				} catch (SmsBusinessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			       	} catch (SmsException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
			}
			else if(((String)session.getAttribute("type")).equalsIgnoreCase("extra")){				
				ExtraVO addinfo = new ExtraVO();
				addinfo.setExtra_code(request.getParameter("extracode"));
				addinfo.setExtra_name(request.getParameter("extraname"));
				addinfo.setStd(Integer.parseInt(request.getParameter("std")));
				try {
					//bo.insertExtraInfo(addinfo);
					delegate.insertExtraDelegate(addinfo);
					
				} catch (SmsBusinessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			       	} catch (SmsException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
			}
			
						
			
		}
		
		//To update the table
		if(val.equalsIgnoreCase("4")){
			SmsBO bo=new SmsBO();
			if(((String)session.getAttribute("type")).equalsIgnoreCase("subject")){
				SubjectVO editinfo = new SubjectVO();
				System.out.println("edit controller");
				editinfo.setSubjectname(request.getParameter("subname"));
				editinfo.setSubjectcode(request.getParameter("subcode"));
				editinfo.setMax_mark(Integer.parseInt(request.getParameter("maxmarks")));
				editinfo.setPass_mark(Integer.parseInt(request.getParameter("passmarks")));
				editinfo.setStd(Integer.parseInt(request.getParameter("std")));				
				System.out.println("edit controller 1");
				try {
					//bo.editSubjectInfo(editinfo);
					delegate.editSubjectDelegate(editinfo);
					
					/*This is to be used when read below :(
					 //Here the smsAdminDao to retrive the subject info 
					//is called so that the edited subject info is also updated on the 
					//text field :P
					SmsVO vo=new SmsVO();
					String sub_code=editinfo.getSubjectcode();
					vo=bo.retriveEditingSubjectInfo(sub_code);				
					session.setAttribute("rvo",vo);
					session.setAttribute("edit", "edit");
					*/	
					session.removeAttribute("rvo");
					session.removeAttribute("edit");
					//************** after editing the required subject the chart should be repopulated
					//////subject_list=bo.retriveSubjectInfo(vo);
					//////session.setAttribute("sub_list",subject_list);
				} catch (SmsBusinessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			       	} catch (SmsException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
			}
			else if(((String)session.getAttribute("type")).equalsIgnoreCase("extra")){
				System.out.println("edit extra controller");
				ExtraVO editinfo = new ExtraVO();
				editinfo.setExtra_code(request.getParameter("extracode"));
				editinfo.setExtra_name(request.getParameter("extraname"));
				try {
					//bo.editExtraInfo(editinfo);
					delegate.editExtraDelegate(editinfo);
					session.removeAttribute("rvo");
					session.removeAttribute("edit");
				}catch (SmsBusinessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			       	} catch (SmsException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
				
			}
		
		}
		
		}	
		
		//First time call :)
		if(((String)session.getAttribute("type")).equalsIgnoreCase("subject")){
			SubjectVO vo=new SubjectVO();
			List<SubjectVO> subject_list;
			vo.setType(request.getParameter("type"));
			vo.setStd(Integer.parseInt(request.getParameter("std")));
			SmsBO bo = new SmsBO();
	       try {	   
			//subject_list=bo.retreiveSubjectInfo(vo);
	    	   subject_list = delegate.retreiveSubjectDelegate(vo);
			System.out.println(subject_list.isEmpty()+"that no data in table");
				session.setAttribute("sub_list",subject_list);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("subjects.jsp");		
			dispatcher.forward(request,response);		       	
	       	} catch (SmsBusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		       	} catch (SmsException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
	  }
		else if(((String)session.getAttribute("type")).equalsIgnoreCase("extra")){
			ExtraVO vo = new ExtraVO();
			List<ExtraVO> extra_list;
			vo.setSelect_type(request.getParameter("type"));
			vo.setStd(Integer.parseInt(request.getParameter("std")));
			SmsBO bo = new SmsBO();
	       try {	   
			//extra_list=bo.retreiveExtraInfo(vo);
			extra_list = delegate.retreiveExtraDelegate(vo);
			session.setAttribute("extra_list",extra_list);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("subjects.jsp");		
			dispatcher.forward(request,response);	
	       	} catch (SmsBusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	       	} catch (SmsException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	       
		}
       
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
