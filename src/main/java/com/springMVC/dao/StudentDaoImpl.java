package com.springMVC.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springMVC.model.Student;

@Repository
public class StudentDaoImpl implements StudentDao {
	
    @Autowired	
	private SessionFactory sessionFactory;

	public void addStudent(Student student) {
		sessionFactory.getCurrentSession().saveOrUpdate(student);
	}
	
	public List<Student> getStudentList() {
		Query query = sessionFactory.getCurrentSession().createQuery("from Student");
		return query.list();
	}

	public Student getStudent(int id) {
		return (Student) sessionFactory.getCurrentSession().get(Student.class, id);
	}

	public void deleteStudent(int id) {
		Session session = sessionFactory.getCurrentSession();
		Student student = (Student) session.get(Student.class, id);
		if (student != null) {
			session.delete(student);
		}
	}
	
}
