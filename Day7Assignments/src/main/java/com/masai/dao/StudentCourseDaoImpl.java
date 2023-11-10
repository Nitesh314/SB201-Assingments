package com.masai.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.masai.model.Course;
import com.masai.model.Student;
import com.masai.utility.EMUtil;

public class StudentCourseDaoImpl implements StudentCourseDao {

	@Override
	public String insertStudentInCourse(Student s) {
		
		String msg="not inserted...";
		
		EntityManager em= EMUtil.provideEntityManager();
		
		try {
			
			em.getTransaction().begin();
			
			em.persist(s);
			
			em.getTransaction().commit();
			
			msg="Inserted successfully...";
			
			return msg;
			
		}finally {
			em.close();
		}
		
		
	}

//*************************************************************************	
	
	@Override
	public List<Student> getStudentsEnrolledInCourse(int courseId) {
		
		List<Student> sList=new ArrayList<>();
		
		EntityManager em= EMUtil.provideEntityManager();
		
		try {
			
			Course course= em.find(Course.class,courseId);
			
			if(course!=null) {
				
				String jpql="SELECT s from Student s INNER JOIN s.courseList c where c=:course ";
				
				
				Query q= em.createQuery(jpql);
				
				q.setParameter("course", course);
				
				sList=q.getResultList();
				
				return sList;
				
			}else {
				return null;
			}
			
		}finally {
			em.close();
		}
		
	}

//************************************************************************************
	
	@Override
	public List<Course> getCoursesEnrolledInStudent(int studentId) {
		
		List<Course> cList=new ArrayList<>();
		
		EntityManager em= EMUtil.provideEntityManager();
		
		try {
			
			Student student=em.find(Student.class,studentId);
			
			if(student!=null) {
				String jpql="SELECT c FROM Course c INNER JOIN c.studentList s where s=:student";
				
				Query q= em.createQuery(jpql);
				
				q.setParameter("student",student);
				
				cList= q.getResultList();
				
				return cList;
			}else {
				return null;
			}
			
		}finally {
			em.close();
		}
		
		
		
		
	}

}
