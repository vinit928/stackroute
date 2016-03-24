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
import javax.swing.JPanel;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import com.wipro.rll.beans.EVS_TBL_Credential_Class;
import com.wipro.rll.beans.EVS_TBL_Voter_Details_Class;

@WebServlet("/EVS_TBL_Voter_AssignID")
public class EVS_TBL_Voter_AssignID extends HttpServlet {
	
	SessionFactory sc1 = new AnnotationConfiguration().configure().buildSessionFactory();
	Session sc = sc1.openSession();
	Transaction tx = null;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String serial_no = request.getParameter("serial_no");
		int serialno=Integer.parseInt(serial_no);
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(100000);
		String voterID = "Voter" + randomInt;
		EVS_TBL_Voter_Details_Class obj= new EVS_TBL_Voter_Details_Class();
		tx = sc.beginTransaction();
		Query query1 = sc.createQuery("update EVS_TBL_Voter_Details_Class set voterID = :voterID"+" where serialNo = :sn");
		query1.setParameter("voterID", voterID);
		query1.setParameter("sn", serialno);
		query1.executeUpdate();
		tx.commit();
		JOptionPane.showMessageDialog(null, "Done Assigned ID: " + voterID);
		response.sendRedirect("EVS_TBL_Voter_Details_Conform.jsp");
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String serial_no = request.getParameter("serial_no");
		int serialno=Integer.parseInt(serial_no);
		
		EVS_TBL_Voter_Details_Class obj= new EVS_TBL_Voter_Details_Class();
		tx = sc.beginTransaction();
		Query query1 = sc.createQuery("update EVS_TBL_Voter_Details_Class set Reject = 1 "+" where serialNo = :sn");
		query1.setParameter("sn", serialno);
		query1.executeUpdate();
		tx.commit();
		JOptionPane.showMessageDialog(null, "Rejected");
		response.sendRedirect("EVS_TBL_Voter_Details_Conform.jsp");
	}


}
