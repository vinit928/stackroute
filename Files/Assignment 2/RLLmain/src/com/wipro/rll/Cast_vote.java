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
import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import com.wipro.rll.beans.EVS_TBL_Candidate_Class;
import com.wipro.rll.beans.EVS_TBL_Election_CLass;
import com.wipro.rll.beans.EVS_TBL_Voter_Details_Class;

@WebServlet("/Cast_vote")
public class Cast_vote extends HttpServlet {
	SessionFactory sc1 = new AnnotationConfiguration().configure().buildSessionFactory();
	Session sc = sc1.openSession();
	Transaction tx = null;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession httpSessio = request.getSession();
		String s1 = request.getParameter("vote");
		String vote[] = s1.split(" ", 2);
		System.out.println(s1);
		System.out.println(vote[0]);
		int serial_no = Integer.parseInt(vote[1]);
		try {
			tx = sc.beginTransaction();
			Query query = sc.createQuery("from EVS_TBL_Voter_Details_Class where serialNo= :sn");
			query.setParameter("sn", serial_no);
			List<EVS_TBL_Voter_Details_Class> list = query.list();
			Iterator<EVS_TBL_Voter_Details_Class> iterator = list.iterator();
			if (iterator.hasNext()) {
				EVS_TBL_Voter_Details_Class evs_TBL_Voter_Details_Class = iterator.next();
				Query query2 = sc
						.createQuery("update EVS_TBL_Voter_Details_Class SET candidateID= :cid where serialNo= :sn");
				query2.setParameter("cid", vote[0]);
				query2.setParameter("sn", serial_no);
				int result = query2.executeUpdate();
				System.out.println("Row Affacted" + result);
				tx.commit();
				response.sendRedirect("Cast_vote.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String voter_id = request.getParameter("voter_id");

		PrintWriter out = response.getWriter();

		Query query5 = sc.createQuery("from EVS_TBL_Voter_Details_Class where voterID= :vid");
		query5.setParameter("vid", voter_id);
		List<EVS_TBL_Voter_Details_Class> list5 = query5.list();
		Iterator<EVS_TBL_Voter_Details_Class> iterator5 = list5.iterator();
		if (iterator5.hasNext()) {
			EVS_TBL_Voter_Details_Class obj = iterator5.next();
			Query query4 = sc
					.createQuery("from EVS_TBL_Voter_Details_Class where serialNo= :sn AND candidateID = Null");
			query4.setParameter("sn", obj.getSerialNo());
			List<EVS_TBL_Voter_Details_Class> list4 = query4.list();
			Iterator<EVS_TBL_Voter_Details_Class> iterator4 = list4.iterator();
			if (iterator4.hasNext()) {
				Query query = sc.createQuery("from EVS_TBL_Voter_Details_Class where serialNo= :sn");
				query.setParameter("sn", obj.getSerialNo());
				List<EVS_TBL_Voter_Details_Class> list = query.list();
				Iterator<EVS_TBL_Voter_Details_Class> iterator = list.iterator();
				HttpSession httpSessio = request.getSession();
				httpSessio.setAttribute("sn", obj.getSerialNo());
				if (iterator.hasNext()) {
					EVS_TBL_Voter_Details_Class evs_TBL_Voter_Details_Class = iterator.next();

					Query query2 = sc.createQuery("from EVS_TBL_Election_CLass where electionID= :eid");
					query2.setParameter("eid", evs_TBL_Voter_Details_Class.getElectionID());
					List<EVS_TBL_Election_CLass> list2 = query2.list();
					Iterator<EVS_TBL_Election_CLass> iterator2 = list2.iterator();

					if (iterator2.hasNext()) {
						EVS_TBL_Election_CLass eVS_TBL_Election_CLass = iterator2.next();

						Query query3 = sc.createQuery("from EVS_TBL_Candidate_Class where electionID= :sn");
						query3.setParameter("sn", eVS_TBL_Election_CLass.getElectionID());
						List<EVS_TBL_Candidate_Class> list3 = query3.list();
						Iterator<EVS_TBL_Candidate_Class> iterator3 = list3.iterator();

						out.println("<form action='Cast_vote?sn='+" + obj.getSerialNo() + " method='get'>");
						out.println(
								"<table><tr><td><b>Vote</b></td><td><b>Candidate Name</b></td><td><b>Party ID</b></td></tr>");
						while (iterator3.hasNext()) {
							EVS_TBL_Candidate_Class evs_TBL_Candidate_Class = iterator3.next();
							out.println("<tr><td>" + "<input type='radio' name='vote' value='"
									+ evs_TBL_Candidate_Class.getCandidateID() + " " + obj.getSerialNo() + "' </td>");
							out.println("<td>" + evs_TBL_Candidate_Class.getName() + "</td>");
							out.println("<td>" + evs_TBL_Candidate_Class.getPartyID() + "</td></tr>");

							evs_TBL_Candidate_Class.getName();
							evs_TBL_Candidate_Class.getPartyID();

						}
						out.println("<input type='submit' value='Vote'>");
						out.println("</table>");
						out.println("</form>");

					}

				}
			} else {
				out.print("You Already Vote");
			}
		} else {
			out.println("Invalid Voter ID");
		}

	}

}
