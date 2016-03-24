package com.wipro.rll.DAO;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import com.wipro.rll.beans.EVS_TBL_Credential_Class;

public class EVS_TBL_Credential_Registation_DAO extends HttpServlet {
	
	static SessionFactory sc1 = new AnnotationConfiguration().configure().buildSessionFactory();
	static Session sc = sc1.openSession();
	static Transaction tx = null;

	public static boolean Registation_DAO(String userId, String password, String usertype, int loginStatus) {
		try {
			tx = sc.beginTransaction();
			EVS_TBL_Credential_Class obj = new EVS_TBL_Credential_Class();
			obj.setUserId(userId);
			obj.setPassword(password);
			obj.setUserType(usertype);
			obj.setLoginStatus(loginStatus);
			sc.save(obj);
			tx.commit();

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
