package com.wipro.rll;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import com.wipro.rll.DAO.EVS_TBL_Credential_Registation_DAO;
import com.wipro.rll.beans.EVS_TBL_Credential_Class;
import com.wipro.rll.beans.EVS_TBL_EO_Class;
import com.wipro.rll.beans.EVS_TBL_party_Class;

@WebServlet("/EVS_TBL_Credential_Registation")
public class EVS_TBL_Credential_Registation extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		String usertype = request.getParameter("usertype");
		int loginStatus = 1;
		boolean action = EVS_TBL_Credential_Registation_DAO.Registation_DAO(userId, password, usertype, loginStatus);
		
		
		
		
		
		if (action = true) {
			HttpSession session = request.getSession(true);
			session.setAttribute("UserID", userId);
			JOptionPane.showMessageDialog(null, "Registation Done");
			response.sendRedirect("index.html");
		}

	}

}
