package com.wipro.rll;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import com.wipro.rll.beans.EVS_TBL_User_Profile_Class;

@WebServlet("/EVS_TBL_User_Profile")
public class EVS_TBL_User_Profile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String first_name = request.getParameter("first_name");
		String last_name = request.getParameter("last_name");
		String dob = request.getParameter("dob");
		String gender = request.getParameter("gender");
		String street = request.getParameter("street");
		String location = request.getParameter("location");
		String City = request.getParameter("City");
		String state = request.getParameter("state");
		String pincode = request.getParameter("pincode");
		String mobileno = request.getParameter("mobileno");
		String emailid = request.getParameter("emailid");
		
		int count = 0;
		PrintWriter out=response.getWriter();
		
		Random rnd=new Random();
		int a=rnd.nextInt(1000);
		String user= "US"+first_name.substring(0, 1)+a;
		
		
		try {
			if (first_name.length() == 0) {
				JOptionPane.showMessageDialog(null, "First Name Should not be Empty");
				response.sendRedirect("EVS_TBL_User_Profile.jsp");
				count = 10;
			}
			if (last_name.length() == 0) {
				JOptionPane.showMessageDialog(null, "Last Name Should not be Empty");
				response.sendRedirect("EVS_TBL_User_Profile.jsp");
				count = 10;
			}
			if (dob.length() == 0) {
				JOptionPane.showMessageDialog(null, "Date of Birth Should not be Empty");
				response.sendRedirect("EVS_TBL_User_Profile.jsp");
				count = 10;
			}
			if (state.length() == 0) {
				JOptionPane.showMessageDialog(null, "State Should not be Empty");
				response.sendRedirect("EVS_TBL_User_Profile.jsp");
				count = 10;
			}

			if (mobileno.length() < 10) {
				JOptionPane.showMessageDialog(null, "Mobile No Should Be 10 Digit");
				response.sendRedirect("EVS_TBL_User_Profile.jsp");
				count = 10;
			}
			if (!emailid.contains("@")) {
				JOptionPane.showMessageDialog(null, "Not Valid Email ID");
				response.sendRedirect("EVS_TBL_User_Profile.jsp");
				count = 10;
			}

			SessionFactory sc1 = new AnnotationConfiguration().configure().buildSessionFactory();
			Session sc = sc1.openSession();
			Transaction tx = null;

			tx = sc.beginTransaction();
			EVS_TBL_User_Profile_Class obj = new EVS_TBL_User_Profile_Class();
			obj.setUser_id(user);
			obj.setFirst_name(first_name);
			obj.setLast_name(last_name);
			obj.setDob(dob);
			obj.setGender(gender);
			obj.setStreet(street);
			obj.setLocation(location);
			obj.setCity(City);
			obj.setState(state);
			obj.setPincode(pincode);
			obj.setMobileno(mobileno);
			obj.setEmailid(emailid);
			sc.save(obj);
			if (count == 0) {
				JOptionPane.showMessageDialog(null, "Registation Done Your User ID is"+user);
				response.sendRedirect("index.jsp");
			}
			tx.commit();
		} catch (Exception e) {
			out.println(e);
		}
	}

}
