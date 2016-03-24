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

import com.wipro.rll.beans.EVS_TBL_Candidate_Class;
import com.wipro.rll.beans.EVS_TBL_Election_CLass;
import com.wipro.rll.beans.EVS_TBL_Result_Class;
import com.wipro.rll.beans.EVS_TBL_Voter_Details_Class;
import com.wipro.rll.beans.EVS_TBL_party_Class;

@WebServlet("/EVS_TBL_Result")
public class EVS_TBL_Result extends HttpServlet {
	SessionFactory sc1 = new AnnotationConfiguration().configure().buildSessionFactory();
	Session sc = sc1.openSession();
	Transaction tx = null;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String c_name = request.getParameter("c_name");
		System.out.print(c_name);
		try {
			tx = sc.beginTransaction();
			Query query = sc.createQuery("from EVS_TBL_Election_CLass where constituency= :c");
			query.setParameter("c", c_name);
			List<EVS_TBL_Election_CLass> list = query.list();
			Iterator<EVS_TBL_Election_CLass> iterator = list.iterator();
			while (iterator.hasNext()) {
				EVS_TBL_Election_CLass obj = iterator.next();
				out.print("<h2>" + obj.getConstituency() + "</h2>");
				out.print("<b>---" + obj.getElectionID() + "</b><br>");
				//out.print("<b>---Election date: </b>" + obj.getElectionDate().substring(0, 11));
				out.print(
						"<table width='40%'><tr><td><b>Name of Candidate</b></td><td><b>Party</b></td><td><b>Votes</b></td></tr>");
				Query query2 = sc.createQuery("from EVS_TBL_Result_Class where electionID= :eid");
				query2.setParameter("eid", obj.getElectionID());
				List<EVS_TBL_Result_Class> list2 = query2.list();
				Iterator<EVS_TBL_Result_Class> iterator2 = list2.iterator();
				while (iterator2.hasNext()) {
					EVS_TBL_Result_Class oResult_Class = iterator2.next();
					Query query3 = sc.createQuery("from EVS_TBL_Candidate_Class where candidateID= :cid");
					query3.setParameter("cid", oResult_Class.getCandidateID());
					List<EVS_TBL_Candidate_Class> list3 = query3.list();
					Iterator<EVS_TBL_Candidate_Class> iterator3 = list3.iterator();
					while (iterator3.hasNext()) {
						EVS_TBL_Candidate_Class oCandidate_Class = iterator3.next();
						out.print("<tr><td>" + oCandidate_Class.getName() + "</td>");
						out.print("<td>" + obj.getName() + "</td>");
					}
				}
			}
			out.print("</table>");
			tx.commit();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String c_name = request.getParameter("c_name");
		System.out.print(c_name);
		out.print("<h1>" + c_name + "</h1>");

		try {
			tx = sc.beginTransaction();
			Query query2 = sc.createQuery("from EVS_TBL_Election_CLass where constituency= :cn");
			query2.setParameter("cn", c_name);
			List<EVS_TBL_Election_CLass> list2 = query2.list();
			Iterator<EVS_TBL_Election_CLass> iterator2 = list2.iterator();
			while (iterator2.hasNext()) {
				EVS_TBL_Election_CLass obj = iterator2.next();
				Query query3 = sc.createQuery("from EVS_TBL_Candidate_Class where electionID= :en");
				query3.setParameter("en", obj.getElectionID());
				List<EVS_TBL_Candidate_Class> list3 = query3.list();
				Iterator<EVS_TBL_Candidate_Class> iterator3 = list3.iterator();

				out.println("<table cellpadding='10'><tr><td><b>Candidate Name</b></td><td><b>Votes</b></td></tr>");
				out.print(obj.getElectionID());
				int lastcount = 0;
				String Winner = null;
				while (iterator3.hasNext()) {
					EVS_TBL_Candidate_Class objCan = iterator3.next();
					out.println("<tr><td>" + objCan.getName() + "</td>");
					Query query = sc.createQuery(
							"from EVS_TBL_Voter_Details_Class where confrm=1 AND candidateID= :c AND electionID= :e");
					query.setParameter("c", objCan.getCandidateID());
					query.setParameter("e", obj.getElectionID());
					List<EVS_TBL_Voter_Details_Class> list = query.list();
					Iterator<EVS_TBL_Voter_Details_Class> iterator = list.iterator();
					int count = 0;
					while (iterator.hasNext()) {
						EVS_TBL_Voter_Details_Class objVo = iterator.next();
						count++;
					}
					if (count > lastcount) {
						lastcount = count;
						Winner = objCan.getName();
					} else if (lastcount < count) {
						lastcount = lastcount;
						Winner = Winner;
					}
					out.println("<td>" + count + "</td></tr>");

				}
				out.println("     <font color='red'><b>Winner:</b>" + lastcount + " " + Winner+"</font>");
			}

			out.print("<table>");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
