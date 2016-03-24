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

import com.wipro.rll.beans.EVS_TBL_Credential_Class;
import com.wipro.rll.beans.EVS_TBL_party_Class;

@WebServlet("/EVS_TBL_Admin_Change_Password")
public class EVS_TBL_Admin_Change_Password extends HttpServlet {
	SessionFactory sc1 = new AnnotationConfiguration().configure().buildSessionFactory();
	Session sc = sc1.openSession();
	Transaction tx = null;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String userid = request.getParameter("userid");
		String oldpass = request.getParameter("oldpass");
		String pass1 = request.getParameter("pass1");
		System.out.println(userid+" "+oldpass+" "+pass1);
		String DBuserid = null;
		String DBpass = null;
		try {
			Query query = sc.createQuery("from EVS_TBL_Credential_Class where userid= :id AND password= :pass ");
			query.setParameter("id", userid);
			query.setParameter("pass", oldpass);
			List<EVS_TBL_Credential_Class> list = query.list();
			Iterator<EVS_TBL_Credential_Class> itr = list.iterator();
			while (itr.hasNext()) {
				EVS_TBL_Credential_Class obj1 = itr.next();
				DBuserid=obj1.getUserId();
				DBpass=obj1.getPassword();
				System.out.println(DBpass+"  "+DBuserid);
				sc.save(obj1);
			}
			if((userid.equals(DBuserid)) && oldpass.equals(DBpass)){
				EVS_TBL_Credential_Class obj= new EVS_TBL_Credential_Class();
				tx = sc.beginTransaction();
				Query query1 = sc.createQuery("update EVS_TBL_Credential_Class set password = :pass"+" where userid = :id");
				query1.setParameter("id", userid);
				query1.setParameter("pass", pass1);
				query1.executeUpdate();
				tx.commit();
				out.print("Password Changed");
			}else{
				out.print("Wrong Details");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
