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

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import com.wipro.rll.DAO.EVS_TBL_Admin_Assign_Voter_DAO;
import com.wipro.rll.beans.EVS_TBL_Result_Class;
import com.wipro.rll.beans.EVS_TBL_Voter_Details_Class;

@WebServlet("/EVS_TBL_Admin_Assign_Voter_2")
public class EVS_TBL_Admin_Assign_Voter_2 extends HttpServlet {
	SessionFactory sc1 = new AnnotationConfiguration().configure().buildSessionFactory();
	Session sc = sc1.openSession();
	Transaction tx = null;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String serial_no = req.getParameter("serial_no");
		PrintWriter out = resp.getWriter();
		int serialno = Integer.parseInt(serial_no);

		try {
			tx = sc.beginTransaction();
			Query query4 = sc.createQuery("from EVS_TBL_Voter_Details_Class where serialno= :sn");
			query4.setParameter("sn", serial_no);
			List<EVS_TBL_Voter_Details_Class> list = query4.list();
			Iterator<EVS_TBL_Voter_Details_Class> itr4 = list.iterator();
			if (itr4.hasNext()) {
				EVS_TBL_Voter_Details_Class obj = itr4.next();
				Query query1 = sc
						.createQuery("update EVS_TBL_Voter_Details_Class set confrm = 1" + " where serialNo = :sn");
				query1.setParameter("sn", serialno);
				int update = query1.executeUpdate();
				String CandidateID = obj.getCandidateID();
				String ElectionID = obj.getElectionID();
			} else {
				resp.sendRedirect("EVS_TBL_Admin_Assign_Voter.jsp");
			}
			tx.commit();
			resp.sendRedirect("EVS_TBL_Admin_Assign_Voter.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String serial_no = req.getParameter("serial_no");
		PrintWriter out = resp.getWriter();
		int serialno = Integer.parseInt(serial_no);

		try {
			tx = sc.beginTransaction();
			Query query4 = sc.createQuery("from EVS_TBL_Voter_Details_Class where serialno= :sn");
			query4.setParameter("sn", serial_no);
			List<EVS_TBL_Voter_Details_Class> list = query4.list();
			Iterator<EVS_TBL_Voter_Details_Class> itr4 = list.iterator();
			if (itr4.hasNext()) {
				EVS_TBL_Voter_Details_Class obj = itr4.next();
				Query query1 = sc
						.createQuery("update EVS_TBL_Voter_Details_Class set Reject= '1'" + " where serialNo = :sn");
				query1.setParameter("sn", serialno);
				int update = query1.executeUpdate();
				String CandidateID = obj.getCandidateID();
				String ElectionID = obj.getElectionID();
			} else {
				resp.sendRedirect("EVS_TBL_Admin_Assign_Voter.jsp");
			}
			tx.commit();
			resp.sendRedirect("EVS_TBL_Admin_Assign_Voter.jsp");
		}
		catch (Exception e) {

			e.printStackTrace();
		}
	}

}
