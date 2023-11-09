package com.masai.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;


import com.masai.models.Collage;
import com.masai.models.Student;
import com.masai.utility.EMUtil;

public class CollageStudentDaoImpl implements CollageStudentDao {

	@Override
	public String insertCollageStudentDetails(Collage clg1,Collage clg2) {
		
		String msg="Details not inserted....";
		
		EntityManager em=EMUtil.provideEntityManager();
		
		try {
			
			em.getTransaction().begin();
			
			em.persist(clg1);
			em.persist(clg2);
			
			em.getTransaction().commit();
			
		    return	msg="Details inserted succefully...";
			
			
		}finally {
			em.close();
		}
		
	}
//*****************************************************************************
	@Override
	public List<Student> getStudentDetailsBasedOnClgId(int clgId) {
		
		EntityManager em= EMUtil.provideEntityManager();
		
		try {
			
			String jpql="SELECT s from Student s where s.collage.collageId= :cId";
			
			Query tq=em.createQuery(jpql);
			
			tq.setParameter("cId",clgId);
			
			List<Student> sList=tq.getResultList();
			
			return sList;
			
		}finally {
			em.close();
		}
		
	}

//*************************************************************************************************
	
	@Override
	public Collage getCollageDetailsBasedOnStuRoll(int stuRoll) {
	    
		Collage clg=null;
		
		EntityManager em=EMUtil.provideEntityManager();
		
		try {
			
			String jpql="SELECT c from Collage c INNER JOIN c.student s where s.StudentRoll=:sId";
			
			Query q= em.createQuery(jpql);
			
			q.setParameter("sId", stuRoll);
			
			clg=(Collage)q.getSingleResult();//downcast
			
			return clg;
			
		}finally {
			em.close();
		}
		
	}

}
