package com.academics.school.dl.classallocation;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.academics.school.dl.utility.SimpleHibernateTemplate;
import com.academics.school.pl.controller.claaallocation.dto.SectionCreationDTO;
import com.academics.school.pl.controller.claaallocation.dto.StudentClassAllocationRecord;
import com.academics.school.pl.controller.classallocation.StudentClassAllocationRecordDTO;
import com.academics.school.pl.controller.registration.dto.CurrentClass;
import com.academics.school.pl.controller.registration.dto.Student;

@Repository("studentClassAllocationDaoImpl")
public class StudentClassAllocationDaoImpl implements StudentClassAllocationDao{

	
	SimpleHibernateTemplate<CurrentClass> simpleHibernateTemplate;
	
	@Autowired
	public StudentClassAllocationDaoImpl(SessionFactory sessionFactory) {
		this.simpleHibernateTemplate = new SimpleHibernateTemplate<CurrentClass>(sessionFactory);
	}
	
	@Transactional
	public List<Student> getClassAllocationRecordBasedOnClass(String studentClass) {
		List<Student> listOfStudent = new ArrayList<Student>();
		Criteria criteria = this.simpleHibernateTemplate.createCriteria(CurrentClass.class);
		criteria.add(Restrictions.eq("c_Class", studentClass));
		List<CurrentClass> listOfClass = criteria.list();
		if(listOfClass.isEmpty()){
			return null; // should throw exception i.e throw new Invalid CLass Sent
		}
		for(CurrentClass c_class : listOfClass){
			 listOfStudent.add(c_class.getStudent());
		}
		return listOfStudent;
	}

	public SectionCreationDTO createSection(SectionCreationDTO sectionCreationDTO) {
		return sectionCreationDTO;
	}

	public StudentClassAllocationRecord updateAdmissionRecord(StudentClassAllocationRecordDTO studentClassAllocationDTO) {
		return null;
	}

	

}
