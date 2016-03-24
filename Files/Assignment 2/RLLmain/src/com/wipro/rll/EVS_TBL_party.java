package com.wipro.rll;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
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

import com.wipro.rll.beans.EVS_TBL_party_Class;

@WebServlet("/EVS_TBL_party")
public class EVS_TBL_party extends HttpServlet {
	SessionFactory sc1 = new AnnotationConfiguration().configure().buildSessionFactory();
	Session sc = sc1.openSession();
	Transaction tx = null;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int count=0;
		PrintWriter out = response.getWriter();
		try {
			tx = sc.beginTransaction();
			Query query = sc.createQuery("from EVS_TBL_party_Class ");
			List<EVS_TBL_party_Class> list = query.list();
			tx.commit();
			Iterator<EVS_TBL_party_Class> itr = list.iterator();
			out.print(
					"<table border='1' width='100%'><tr><td><b>Party Name</b></td><td><b>Party Id</b></td><td><b>Party Leader</b></td><td><b>Party Symbol</b></td></tr>");
			while (itr.hasNext()) {
				EVS_TBL_party_Class obj = itr.next();
				byte[] bAvatar = obj.getImage();
				FileOutputStream fos = new FileOutputStream("E:\\Vinit Kumar\\RLLmain\\WebContent\\test"+count+".png");
				fos.write(bAvatar);
				String location="D:\\test.png";
				out.print("<tr><td>" + obj.getName() + "</td>");
				out.print("<td><font color='red'>" + obj.getParty_id() + "</td>");
				out.print("<td>" + obj.getLeader() + "</td>");
				out.print("<td><a href='http://localhost:1001/RLLmain/test"+count+".png' width='50'>click here</a></td></tr>");
				count++;
				fos.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		System.out.println(name);
		String leader = request.getParameter("leader");
		String pic = request.getParameter("pic");
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(100000);
		String party_id = "Party" + randomInt;

		try {
			File file = new File(pic);
			byte[] bFile = new byte[(int) file.length()];
			FileInputStream fileInputStream = new FileInputStream(file);
			tx = sc.beginTransaction();
			EVS_TBL_party_Class obj = new EVS_TBL_party_Class();
			obj.setName(name);
			obj.setParty_id(party_id);
			obj.setLeader(leader);
			fileInputStream.read(bFile);
			obj.setImage(bFile);
			sc.save(obj);
			tx.commit();
			JOptionPane.showMessageDialog(null, "Your Party ID is : <b>" + party_id + "</b>");
			response.sendRedirect("Add_View_Party.jsp");
			fileInputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}

	}
}