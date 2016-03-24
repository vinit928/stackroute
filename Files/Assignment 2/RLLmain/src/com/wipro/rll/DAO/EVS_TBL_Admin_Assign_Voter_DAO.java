package com.wipro.rll.DAO;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

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

import com.wipro.rll.beans.EVS_TBL_Result_Class;

@WebServlet("/EVS_TBL_Admin_Assign_Voter_DAO")
public class EVS_TBL_Admin_Assign_Voter_DAO extends HttpServlet {

	static SessionFactory sc1 = new AnnotationConfiguration().configure().buildSessionFactory();
	static Session sc = sc1.openSession();
	static Transaction tx = null;
	static Random random = new Random();
	static int serialNo = random.nextInt(10000);
	static int newvote;

	public static boolean IncreaseVoteCounter(String CandidateID, String ElectionID) {
		tx = sc.beginTransaction();
		Query query = sc.createQuery("from EVS_TBL_Result_Class where CandidateID= :cid AND ElectionID= :eid");
		query.setCacheable(false);
		query.setParameter("cid", CandidateID);
		query.setParameter("eid", ElectionID);
		List<EVS_TBL_Result_Class> list = query.list();
		Iterator<EVS_TBL_Result_Class> iterator = list.iterator();
		if (iterator.hasNext()) {
			EVS_TBL_Result_Class obj = iterator.next();
			//int vote = obj.getVoteCount();
			//System.out.println(vote);
			//newvote = vote + 1;
			//System.out.println(newvote);
			Query query2 = sc.createQuery(
					"update EVS_TBL_Result_Class SET votecount= :vc where CandidateID= :cid AND ElectionID= :eid");
			query2.setCacheable(false);
			query2.setParameter("cid", CandidateID);
			query2.setParameter("eid", ElectionID);
			query2.setParameter("vc", newvote);
			query2.executeUpdate();
			return true;
		} else {
			EVS_TBL_Result_Class obj = new EVS_TBL_Result_Class();
			obj.setCandidateID(CandidateID);
			obj.setElectionID(ElectionID);
			obj.setSerialNo(serialNo);
			//obj.setVoteCount(1);
			sc.save(obj);
			tx.commit();
			return true;
		}
	}
}
