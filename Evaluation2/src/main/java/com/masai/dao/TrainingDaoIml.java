package com.masai.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import com.masai.exception.CourseException;
import com.masai.exception.TeacherException;
import com.masai.models.Course;
import com.masai.models.Student;
import com.masai.models.Teacher;
import com.masai.utillity.EMUtil;

public class TrainingDaoIml implements TrainingDao {

	@Override
	public void addCourse(Course course) {
		
		EntityManager em= EMUtil.provideEntityManager();
		
		try {
			
			em.getTransaction().begin();
			
			em.persist(course);
            
			em.getTransaction().commit();
			
			System.out.println("Course Details inserted SuccessFully...");
			
		}catch (Exception e) {
			System.out.println("Not inserted...");
		}
		finally {
			em.close();
		}
		
		
	}

//**********************************************************************************
	
	@Override
	public void registerStudent(Student student, int courseId) throws CourseException {
		
		EntityManager em= EMUtil.provideEntityManager();
		
		try {
			
			Course cur= em.find(Course.class,courseId);
			
			if(cur==null) {
				throw new CourseException("Course with course id "+courseId+" is not exist...");
			}
			
			em.getTransaction().begin();
			
			cur.getsList().add(student);
			em.merge(cur);//because em is close there for we use merge();
			
			em.getTransaction().commit();
			
			System.out.println("Student register inside course successfully...");
			
			
		}finally {
			em.close();
		}
		
		
	}

//*************************************************************
	
	@Override
	public void registerTeacher(Teacher teacher) {
		
		EntityManager em= EMUtil.provideEntityManager();
		
		try {
			
			em.getTransaction().begin();
			
			em.persist(teacher);

			em.getTransaction().commit();
			
			System.out.println("Teacher register successfully...");
			
		}catch (Exception e) {
			System.out.println("not registered...");
			if (em.getTransaction().isActive()) {
		        em.getTransaction().rollback();
		    }
		}finally {
			em.close();
		}
		
		
	}
//************************************************************************************
	
	@Override
	public void assignTeacherWithCourse(int teacherId, int courseId) throws TeacherException, CourseException {
		 
		EntityManager em= EMUtil.provideEntityManager();
		
		try {
			
			Teacher tea= em.find(Teacher.class,teacherId);
			
			Course cur= em.find(Course.class,courseId);
			
			if(tea==null) {
				throw new TeacherException("Teacher with teacher id "+teacherId+" dose not exist");
			}
			
			if(cur==null) {
				throw new CourseException("Course with course id "+courseId+" dose not exist...");
			}
			
			em.getTransaction().begin();
			
			cur.setTeacher(tea);
			
			em.getTransaction().commit();
			
			System.out.println("Teacher assing course...");
			
		}catch (Exception e) {
			System.out.println("not registered...");
			if (em.getTransaction().isActive()) {
		        em.getTransaction().rollback();
		    }
		}finally {
			em.close();
		}
		
		
		
	}
//******************************************************************************************
	@Override
	public List<Student> getAlltheStudentsByCourseName(String courseName) throws CourseException {
		
		List<Student> sList=new ArrayList<>();
		
		EntityManager em= EMUtil.provideEntityManager();
		
		try {
			
			String jpql="SELECT s FROM Student s INNER JOIN s.cList c WHERE c.courseName=:cName";
			
			TypedQuery<Student> query = em.createQuery(jpql, Student.class);
	        query.setParameter("cName", courseName);

	        sList = query.getResultList();
		    
			return sList;
			
		}finally {
			em.close();
		}
		
	}

}
