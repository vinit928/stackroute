package com.wipro.rll;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import com.wipro.rll.beans.EVS_TBL_Result_Class;
import com.wipro.rll.beans.EVS_TBL_Voter_Details_Class;

@WebServlet("/EVS_TBL_Admin_Assign_Voter")
public class EVS_TBL_Admin_Assign_Voter extends HttpServlet {
	SessionFactory sc1 = new AnnotationConfiguration().configure().buildSessionFactory();
	Session sc = sc1.openSession();
	Transaction tx = null;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String serial_no = request.getParameter("serial_no");
		PrintWriter out = response.getWriter();
		try {
			tx = sc.beginTransaction();
			Query query = sc
					.createQuery("from EVS_TBL_Voter_Details_Class where Reject= '0' AND confrm= '0'");
			List<EVS_TBL_Voter_Details_Class> list = query.list();
			tx.commit();
			Iterator<EVS_TBL_Voter_Details_Class> itr = list.iterator();
			out.print(
					"<table border='1' width='100%'><tr><td><b>Serial No</b></td><td><b>Election Id</b></td><td></td></tr>");
			while (itr.hasNext()) {
				EVS_TBL_Voter_Details_Class obj = itr.next();
				out.print("<tr><td> <font color='red'>" + obj.getSerialNo() + "</font></td>");
				out.print("<td>" + obj.getElectionID() + "</td>");
				out.print("<td><form action='EVS_TBL_Admin_Assign_Voter_2' method='Post'><input type='hidden' value='"
						+ obj.getSerialNo() + "' name='serial_no'><input type='submit' value='Approve'></form></td>");
				out.print("<td><form action='EVS_TBL_Voter_AssignID' method='Get'><input type='hidden' value='"
						+ obj.getSerialNo()
						+ "' name='serial_no'><input type='submit' value='Reject'></form></td></tr>");
			}
			out.print("</table>");
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
}
