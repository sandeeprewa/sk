package com.academics.school.sl.student;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.academics.school.dl.utility.SimpleHibernateTemplate;
import com.academics.school.pl.controller.registration.dto.CurrentClass;
import com.academics.school.pl.controller.registration.dto.Student;
import com.academics.school.pl.student.dto.StudentSearchRequestDTO;

@Service("studentSearchServiceImpl")
public class StudentSerachServiceImpl implements StudentSerachService {

	SimpleHibernateTemplate<Student> simpleHibernateTemplate;
	
	@Autowired
	public StudentSerachServiceImpl(SessionFactory sessionFactory){
		this.simpleHibernateTemplate = new SimpleHibernateTemplate<Student>(sessionFactory);
	}
	
	@Transactional
	public Student getStudentBasedOnStudentId(String studentId) {
		Criteria criteria = simpleHibernateTemplate.createCriteria(Student.class);
		criteria.add(Restrictions.eq("id",Long.parseLong(studentId)));
		Student student = (Student) criteria.uniqueResult();
		if(student == null){
			//thorow Student NOdi Foud 
		}
		return student;
	}

	@Transactional
	public List<Student> getStudentBasedOnParameters(StudentSearchRequestDTO searchDTO) {
		
		List<Student> listOfStudentToBeReturned  = new ArrayList<Student>();
		Criteria criteria = null;
		Boolean flag = Boolean.TRUE;
		
		if(isEligibleForStudent(searchDTO)){
			flag = Boolean.FALSE;
			
			criteria = simpleHibernateTemplate.createCriteria(Student.class);
			if(isNotNullOrNotEmpty(searchDTO.getStudentId()))
				criteria.add(Restrictions.eq("id", searchDTO.getStudentId()));
			if(isNotNullOrNotEmpty(searchDTO.getFirstName()))
				criteria.add(Restrictions.eq("firstName", searchDTO.getFirstName()));
			if(isNotNullOrNotEmpty(searchDTO.getLastName()))
				criteria.add(Restrictions.eq("lastName", searchDTO.getLastName()));
			if(isNotNullOrNotEmpty(searchDTO.getEmail()))
				criteria.add(Restrictions.eq("email", searchDTO.getEmail()));
			if(isNotNullOrNotEmpty(searchDTO.getMobileNumber()))
				criteria.add(Restrictions.eq("mobileNumber", searchDTO.getMobileNumber()));
			 listOfStudentToBeReturned = criteria.list();
		}//if
		
		if(isEligibleForCurrentClass(searchDTO) && flag){
			criteria = simpleHibernateTemplate.createCriteria(CurrentClass.class);
			if(isNotNullOrNotEmpty(searchDTO.getStandard()))
				criteria.add(Restrictions.eq("c_Class", searchDTO.getStandard()));
			if(isNotNullOrNotEmpty(searchDTO.getSection()))
				criteria.add(Restrictions.eq("section", searchDTO.getSection()));
			if(isNotNullOrNotEmpty(searchDTO.getStream()))
				criteria.add(Restrictions.eq("stream", searchDTO.getStream()));
			if(isNotNullOrNotEmpty(searchDTO.getRollNumber()))
				criteria.add(Restrictions.eq("rollNumber", searchDTO.getRollNumber()));
			List<CurrentClass>  listOfCurrentClass = criteria.list();
			for(CurrentClass current: listOfCurrentClass){
				listOfStudentToBeReturned.add(current.getStudent()); 
			}
		}//if

		
		if(!flag){
			filterBasedOnStandard(listOfStudentToBeReturned ,searchDTO.getStandard());
			filterBasedOnSection(listOfStudentToBeReturned, searchDTO.getSection());
			filterBasedOnStream(listOfStudentToBeReturned, searchDTO.getStream());
			filterBasedOnRollNumber(listOfStudentToBeReturned, searchDTO.getRollNumber());
		}
		return listOfStudentToBeReturned;
	}


	private void filterBasedOnRollNumber(List<Student> listOfStudentToBeReturned, String rollNumber) {
		for (Student student : listOfStudentToBeReturned) {
			if(student.getCurrentClass().getRollNumber() != rollNumber){
				listOfStudentToBeReturned.remove(student);
			}
		}		
		
	}

	private void filterBasedOnStream(List<Student> listOfStudentToBeReturned, String stream) {
		for (Student student : listOfStudentToBeReturned) {
			if(student.getCurrentClass().getStream() != stream){
				listOfStudentToBeReturned.remove(student);
			}
		}		
	}

	private void filterBasedOnSection(List<Student> listOfStudentToBeReturned, String section) {
		for (Student student : listOfStudentToBeReturned) {
			if(student.getCurrentClass().getSection() != section){
				listOfStudentToBeReturned.remove(student);
			}
		}
	}

	private void filterBasedOnStandard(List<Student> listOfStudentToBeReturned, String standard) {
			for (Student student : listOfStudentToBeReturned) {
				if(student.getCurrentClass().getC_Class() != standard){
					listOfStudentToBeReturned.remove(student);
				}
			}
	}

	private boolean isEligibleForCurrentClass(StudentSearchRequestDTO searchDTO) {
		return false;
	}

	private boolean isNotNullOrNotEmpty(String firstName) {
		return false;
	}

	private boolean isEligibleForStudent(StudentSearchRequestDTO searchDTO) {
		return true;
	}

}
 