package com.springMVC.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springMVC.model.Grades;
import com.springMVC.model.Student;

@Repository
public class StudentDaoImpl implements StudentDao {
	
    @Autowired	
	private SessionFactory sessionFactory;

	public void addStudent(Student student) {
		sessionFactory.getCurrentSession().save(student);
	}
	
	public void updateStudent(Student student) {
		Session session = sessionFactory.getCurrentSession();
		Student updateStudent = (Student) session.get(Student.class, student.getId());
		updateStudent.setFirstName(student.getFirstName());
		updateStudent.setLastName(student.getLastName());
		updateStudent.setLevel(student.getLevel());
		session.update(updateStudent);
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
	
	public void saveGrades(Student student) {
		Session session = sessionFactory.getCurrentSession();
		Student updateStudent = (Student) session.get(Student.class, student.getId());
		Grades grade = updateStudent.getGrade();
		if (grade == null) {
			System.out.println("It is null!!!!");
			Grades newGrade = new Grades();
			newGrade.setMath(student.getGrade().getMath());
			newGrade.setScience(student.getGrade().getScience());
			newGrade.setEnglish(student.getGrade().getEnglish());
			updateStudent.setGrade(newGrade);
		} else {
			grade.setMath(student.getGrade().getMath());
			grade.setEnglish(student.getGrade().getEnglish());
			grade.setScience(student.getGrade().getScience());
			updateStudent.setGrade(grade);
		}
		session.update(updateStudent);
	}
	
}
