package com.wipro.rll;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import com.wipro.rll.beans.EVS_TBL_Voter_Details_Class;

@WebServlet("/EVS_TBL_Vote_Voter_ID_Check")
public class EVS_TBL_Vote_Voter_ID_Check extends HttpServlet {
	SessionFactory sc1 = new AnnotationConfiguration().configure().buildSessionFactory();
	Session sc = sc1.openSession();
	Transaction tx = null;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String serial_no = request.getParameter("serial_no");
		int serialno = Integer.parseInt(serial_no);
		PrintWriter out = response.getWriter();
		try {
			tx = sc.beginTransaction();

			Query query = sc.createQuery("from EVS_TBL_Voter_Details_Class where serialNo= :sn");
			query.setParameter("sn", serialno);
			List<EVS_TBL_Voter_Details_Class> list = query.list();
			Iterator<EVS_TBL_Voter_Details_Class> iterator = list.iterator();
			if (iterator.hasNext()) {
				EVS_TBL_Voter_Details_Class obj = iterator.next();
				out.print(
						"<table><tr><td><b>Serial No</b></td><td><b>Election ID</b></td><td><b>Voter ID</b></td><td><b>Approval</b></td></tr>");
				out.println("<tr><td>" + obj.getSerialNo() + "</td>");
				out.println("<td>" + obj.getElectionID() + "</td>");

				if (obj.getVoterID() != null) {
					out.println("<td><font color='red'><b>" + obj.getVoterID() + "</b></font></td>");
				} else {
					out.println("<td><font color='red'><b>Pending</b></font></td>");

				}

				if (obj.getConfrm().equals("0")) {
					if (obj.getReject().equals("1")) {
						out.println("<td><font color='red'><b>Rejected</b></font></td></tr>");
					} else {
						out.println("<td><font color='red'><b>Pending</b></font></td></tr>");
					}
				} else {
					out.println("<td><font color='red'><b>Approved</b></font></td></tr>");
				}

				out.println("</table>");
			} else {
				out.println("<font color='red'><b>Sorry Serial No is Not Present</b></font>");
			}

			tx.commit();

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

}
