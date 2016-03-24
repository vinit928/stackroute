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

import com.wipro.rll.beans.EVS_TBL_Candidate_Class;
import com.wipro.rll.beans.EVS_TBL_Credential_Class;
import com.wipro.rll.beans.EVS_TBL_party_Class;

@WebServlet("/EVS_TBL_Candidate")
public class EVS_TBL_Candidate extends HttpServlet {
	SessionFactory sc1 = new AnnotationConfiguration().configure().buildSessionFactory();
	Session sc = sc1.openSession();
	Transaction tx = null;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		try {
			tx = sc.beginTransaction();
			Query query = sc.createQuery("from EVS_TBL_Candidate_Class ");
			List<EVS_TBL_Candidate_Class> list = query.list();
			tx.commit();
			Iterator<EVS_TBL_Candidate_Class> itr = list.iterator();
			out.print(
					"<table border='1' width='100%'><tr><td><b>Candidate Name</b></td><td><b>Candidate Id</b></td><td><b>Election ID</b></td><td><b>Party ID</b></td><td><b>Constituency</b></td><td><b>District</b></td><td><b>Address</b></td><td><b>Date of Birth</b></td><td><b>Mobile No</b></td><td><b>Email ID</b></td></tr>");
			while (itr.hasNext()) {
				EVS_TBL_Candidate_Class obj = itr.next();
				out.print("<tr><td>" + obj.getName() + "</td>");
				out.print("<td><font color='red'>" + obj.getCandidateID() + "</td>");
				out.print("<td>" + obj.getElectionID() + "</td>");
				out.print("<td>" + obj.getPartyID() + "</td>");
				out.print("<td>" + obj.getConstituency() + "</td>");
				out.print("<td>" + obj.getDistrict() + "</td>");
				out.print("<td>" + obj.getAddress() + "</td>");
				out.print("<td>" + obj.getDateOfBirth() + "</td>");
				out.print("<td>" + obj.getMobileNo() + "</td>");
				out.print("<td>" + obj.getEmailID() + "</td></tr>");
			}
			out.print("</table>");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		String electionID = request.getParameter("election_id");
		String partyID = request.getParameter("party_id");
		String district = request.getParameter("district");
		String constituency = request.getParameter("constituency");
		String dateOfBirth = request.getParameter("dob");
		String mobileNo = request.getParameter("mobile_no");
		String address = request.getParameter("address");
		String emailID = request.getParameter("email_id");
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(100000);
		String candidateID = "Candidate" + randomInt;
		try {
			tx = sc.beginTransaction();
			EVS_TBL_Candidate_Class obj = new EVS_TBL_Candidate_Class();
			obj.setCandidateID(candidateID);
			obj.setName(name);
			obj.setPartyID(partyID);
			obj.setDateOfBirth(dateOfBirth);
			obj.setDistrict(district);
			obj.setMobileNo(mobileNo);
			obj.setAddress(address);
			obj.setEmailID(emailID);
			obj.setConstituency(constituency);
			obj.setElectionID(electionID);
			sc.save(obj);
			tx.commit();
			JOptionPane.showMessageDialog(null, "Registered");
			response.sendRedirect("Add_View_Election.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
