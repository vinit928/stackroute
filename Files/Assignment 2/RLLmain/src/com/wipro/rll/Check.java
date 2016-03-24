package com.wipro.rll;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.icu.text.SimpleDateFormat;

@SuppressWarnings("serial")
@WebServlet("/Check")
public class Check extends HttpServlet {
	@SuppressWarnings("deprecation")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String dob = request.getParameter("dob");

		String aa[] = dob.split("/");

		for (int a = 0; a <= 2; a++) {
			System.out.println(aa[a]);
		}

		try {

			SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy");
			Date maindate = sdf.parse(dob);
			System.out.println(maindate);
			System.out.println(maindate.getDate());
			System.out.println(maindate.getMonth());
			System.out.println(maindate.getYear());
			
			

		} catch (ParseException e1) {
			e1.printStackTrace();
		}

	}

}
