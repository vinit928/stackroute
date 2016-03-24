package com.wipro.rll;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.Date;
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

import com.ibm.icu.text.SimpleDateFormat;
import com.wipro.rll.beans.EVS_TBL_Election_CLass;

@WebServlet("/EVS_TBL_Election")
public class EVS_TBL_Election extends HttpServlet {
	SessionFactory sc1 = new AnnotationConfiguration().configure().buildSessionFactory();
	Session sc = sc1.openSession();
	Transaction tx = null;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		String con = req.getParameter("constituency");
		String name = null;
		Date date = null;
		String district = null;
		String constituency = null;
		Date countingdate = null;
		String id = null;
		try {
			tx = sc.beginTransaction();
			Query query = sc.createQuery("from EVS_TBL_Election_CLass where CONSTITUENCY= :cons");

			query.setParameter("cons", con);
			List<EVS_TBL_Election_CLass> list = query.list();
			tx.commit();
			Iterator<EVS_TBL_Election_CLass> itr = list.iterator();
			out.print(
					"<font color='red'><table border='1' width='100%' cellpadding='10px'><tr><td><b>Election ID </b></td><td><b>Election Name</b></td><td><b>Election Date</b></td><td><b>Election District</b></td><td><b>Constituency</b></td><td><b>Countingdate</b></td></tr></font>");
			while (itr.hasNext()) {
				EVS_TBL_Election_CLass obj = itr.next();
				id = obj.getElectionID();
				name = obj.getName();
				date = obj.getElectionDate();
				district = obj.getDistrict();
				constituency = obj.getConstituency();
				countingdate = obj.getCountionDate();
				if ((con.equals(constituency))) {
					out.print("<font color='white'><tr><td>" + id + "</td>");
					out.print("<td>" + name + "</td>");
					out.print("<td>" + date + "</td>");
					out.print("<td>" + district + "</td>");
					out.print("<td>" + constituency + "</td>");
					out.print("<td>" + countingdate + "</td></tr></font>");
				}
			}
			out.print("</table>");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		String date = request.getParameter("date");
		String district = request.getParameter("district");
		String constituency = request.getParameter("constituency");
		String countingdate = request.getParameter("countingdate");
		int count = 0;

		try {

			SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy");
			Date maindate = sdf.parse(date);

			SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MMM/yyyy");
			Date maindate2 = sdf.parse(countingdate);

			Random randomGenerator = new Random();
			int randomInt = randomGenerator.nextInt(100000);
			String electionID = "Election" + randomInt;

			int diffyear = maindate2.getYear() - maindate.getYear();
			int diffmonth = maindate2.getMonth() - maindate.getMonth();
			int diffdays = maindate2.getDay() - maindate.getDay();

			tx = sc.beginTransaction();
			EVS_TBL_Election_CLass obj = new EVS_TBL_Election_CLass();
			obj.setElectionID(electionID);
			obj.setName(name);
			obj.setDistrict(district);
			obj.setConstituency(constituency);
			if (maindate2.after(maindate)) {
				obj.setCountionDate(maindate2);
			} else {

				JOptionPane.showMessageDialog(null, "Counting Date Should Be After the Election Date");
				response.sendRedirect("Election_ADD.html");
				count = 10;
			}
			obj.setElectionDate(maindate);
			if (count == 0) {
				sc.save(obj);
				tx.commit();
				JOptionPane.showMessageDialog(null, "Election Is Register Your Election Id is: " + electionID);
				response.sendRedirect("Add_View_Election.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 

	}

}
