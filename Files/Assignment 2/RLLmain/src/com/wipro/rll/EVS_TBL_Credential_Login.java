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

import com.wipro.rll.beans.EVS_TBL_Credential_Class;

@WebServlet("/EVS_TBL_Credential_Login")
public class EVS_TBL_Credential_Login extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		String DBuserId = null;
		String DBpassword = null;
		String DBusertype = null;
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		String usertype = request.getParameter("usertype");

		PrintWriter out = response.getWriter();
		SessionFactory sc1 = new AnnotationConfiguration().configure().buildSessionFactory();
		Session sc = sc1.openSession();
		Transaction tx = null;
		try {
			tx = sc.beginTransaction();
			Query query = sc.createQuery("from EVS_TBL_Credential_Class where userId= :id");
			query.setParameter("id", userId);
			List<EVS_TBL_Credential_Class> list = query.list();
			tx.commit();
			Iterator<EVS_TBL_Credential_Class> itr = list.iterator();
			while (itr.hasNext()) {
				EVS_TBL_Credential_Class obj = itr.next();
				DBuserId = obj.getUserId();
				DBpassword = obj.getPassword();
				DBusertype = obj.getUserType();
			}
			if ((userId.equals(DBuserId))) {
				if ((password.equals(DBpassword))) {
					if ((usertype.equals(DBusertype))) {
						session.setAttribute("UserID", userId);
						
						if (userId.equals("AD-001") || userId.equals("AD-002") || userId.equals("AD-003")) {
							response.sendRedirect("Add_View_Election.jsp");
						} else if (userId.equals("AD-004") || userId.equals("AD-005")) {
							response.sendRedirect("Add_View_Party.jsp");
						} else if (userId.equals("AD-006") || userId.equals("AD-007")) {
							response.sendRedirect("Add_View_Candidate.jsp");
						} else if (userId.equals("AD-008")) {
							response.sendRedirect("EVS_TBL_Admin_Assign_Voter.jsp");
						} else if (userId.equals("EO-001") || userId.equals("EO-002")) {
							response.sendRedirect("EVS_TBL_Voter_Details_Conform.jsp");
						} else if (userId.equals("US-001")) {
							response.sendRedirect("EVS_TBL_User_Profile.jsp");
						} else if (userId.equals("US-002")) {
							response.sendRedirect("EVS_TBL_Voter_Details.jsp");
						}else if (userId.equals("US-003")) {
							response.sendRedirect("EVS_TBL_Vote_Voter_ID_Check.jsp");
						} else if (userId.equals("AD-010")) {
							response.sendRedirect("Add_View_Election.jsp");
						}else if (userId.equals("US-006") || userId.equals("US-007")) {
							response.sendRedirect("Cast_vote.jsp");
						}else if (userId.equals("US-004")) {
							response.sendRedirect("EVS_TBL_Election_Show.jsp");
						}else if (userId.equals("US-005")) {
							response.sendRedirect("EVS_TBL_Candidate_Show.jsp");
						}
						
						
						
					} else {
						session.setAttribute("Incorrect", "UserType");
						response.sendRedirect("index.jsp");
					}
				} else {
					session.setAttribute("Incorrect", "Password");
					response.sendRedirect("index.jsp");
				}
			} else {
				session.setAttribute("Incorrect", "UserName");
				response.sendRedirect("index.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sc.close();
		}
	}
}
