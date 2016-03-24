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

import com.wipro.rll.beans.EVS_TBL_User_Profile_Class;
import com.wipro.rll.beans.EVS_TBL_Voter_Details_Class;
import com.wipro.rll.beans.EVS_TBL_party_Class;

@WebServlet("/EVS_TBL_Voter_Details")
public class EVS_TBL_Voter_Details extends HttpServlet {
	SessionFactory sc1 = new AnnotationConfiguration().configure().buildSessionFactory();
	Session sc = sc1.openSession();
	Transaction tx = null;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String user = request.getParameter("user");
		String election_id = request.getParameter("election_id");
		System.out.print(election_id + user);
		Random randomGenerator = new Random();
		int serial_id = randomGenerator.nextInt(100000);

		try {
			tx = sc.beginTransaction();
			Query query3 = sc.createQuery("from EVS_TBL_User_Profile_Class Where user_id= :id");
			query3.setParameter("id", user);
			List<EVS_TBL_User_Profile_Class> list3 = query3.list();
			Iterator<EVS_TBL_User_Profile_Class> iterator3 = list3.iterator();
			System.out.println(list3);
			if (iterator3.hasNext()) {

				EVS_TBL_Voter_Details_Class obj = new EVS_TBL_Voter_Details_Class();
				obj.setElectionID(election_id);
				obj.setSerialNo(serial_id);
				obj.setReject("0");
				obj.setConfrm("0");
				sc.save(obj);
				tx.commit();
				JOptionPane.showMessageDialog(null, "Your Serial ID: " + serial_id + "Your Voter Id Pending..");
				response.sendRedirect("EVS_TBL_Voter_Details.jsp");
			}

		} catch (Exception e) {
			out.println(e);
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		try {
			tx = sc.beginTransaction();
			Query query = sc
					.createQuery("from EVS_TBL_Voter_Details_Class where Reject= '0' AND confrm= '1' AND voterID =null");
			List<EVS_TBL_Voter_Details_Class> list = query.list();
			tx.commit();
			Iterator<EVS_TBL_Voter_Details_Class> itr = list.iterator();
			out.print(
					"<table border='1' width='100%'><tr><td><b>Serial No</b></td><td><b>Election Id</b></td></tr>");
			while (itr.hasNext()) {
				EVS_TBL_Voter_Details_Class obj = itr.next();
				out.print("<tr><td> <font color='red'>" + obj.getSerialNo() + "</font></td>");
				out.print("<td>" + obj.getElectionID() + "</td>");
				out.print("<td><form action='EVS_TBL_Voter_AssignID' method='Post'><input type='hidden' value='"
						+ obj.getSerialNo() + "' name='serial_no'><input type='submit' value='Assign'></form></td>");
				out.print("<td><form action='EVS_TBL_Voter_AssignID' method='get'><input type='hidden' value='"
						+ obj.getSerialNo()
						+ "' name='serial_no'><input type='submit' value='Reject'></form></td></tr>");
			}
			out.print("</table>");
		} catch (Exception e) {
			e.printStackTrace();

		}
	}
}
