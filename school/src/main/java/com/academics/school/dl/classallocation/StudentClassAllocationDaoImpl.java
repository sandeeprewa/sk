package com.academics.school.dl.classallocation;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.academics.school.dl.standardfixture.StandardFixture;
import com.academics.school.dl.utility.SimpleHibernateTemplate;
import com.academics.school.pl.classallocation.error.StudentClassDoesNotException;
import com.academics.school.pl.controller.claaallocation.dto.SearchClassAllocationRequestDTO;
import com.academics.school.pl.controller.claaallocation.dto.SectionCreationDTO;
import com.academics.school.pl.controller.claaallocation.dto.StudentClassAllocationRecord;
import com.academics.school.pl.controller.classallocation.StudentClassAllocationRecordDTO;
import com.academics.school.pl.controller.registration.dto.CurrentClass;
import com.academics.school.pl.controller.registration.dto.Student;
import com.academics.school.pl.controller.registration.dto.StudentRegistrationRecord;
import com.academics.school.pl.controller.registration.error.StudentIdDoesNotExistException;
import com.google.common.base.Optional;

@Repository("studentClassAllocationDaoImpl")
public class StudentClassAllocationDaoImpl implements StudentClassAllocationDao{

	
	SimpleHibernateTemplate<Object> simpleHibernateTemplate;
	
	@Autowired
	public StudentClassAllocationDaoImpl(SessionFactory sessionFactory) {
		this.simpleHibernateTemplate = new SimpleHibernateTemplate<Object>(sessionFactory);
	}
	
	@Transactional
	public List<Student> getStudentBasedOnClass(String standard){
		List<Student> listOfStudent = new ArrayList<Student>();
		Criteria criteria = this.simpleHibernateTemplate.createCriteria(CurrentClass.class);
		criteria.add(Restrictions.eq("c_Class",standard));
		List<CurrentClass> listOfCurrentClass = criteria.list(); 
		
		for(CurrentClass currentClass : listOfCurrentClass){
			listOfStudent.add(currentClass.getStudent());
		}
		return listOfStudent;
	}
	
	@Transactional
	public List<Student> getClassAllocationRecordBasedOnClass(SearchClassAllocationRequestDTO searchClassAllocationRequestDTO) {
		return getStudentBasedOnClass(searchClassAllocationRequestDTO.getStudentclass());
	}

	@Transactional
	public StandardFixture createSection(SectionCreationDTO sectionCreationDTO) {
		
		Criteria criteria = this.simpleHibernateTemplate.createCriteria(StandardFixture.class);
		criteria.add(Restrictions.eq("standard", sectionCreationDTO.getClassname()));
		List<StandardFixture> list = criteria.list();
		StandardFixture sf = list.get(0);
		
			if(sf.getSection()==null){
				sf.setSection(""+sectionCreationDTO.getSectionname()+",");
			}
			else {
				StringBuilder sectionwithcomma =new StringBuilder(sf.getSection());
				String sectionstring=sf.getSection();
				
				String [] section=sectionstring.split(",");
				boolean flag=true;
				
					for(int i=0;i<section.length;i++){
					String value=section[i];
					
					if(value.equals(sectionCreationDTO.getSectionname())){
						flag=false;
						break;
					}
					}
					if(flag){
						sf.setSection(new String (sectionwithcomma.append(sectionCreationDTO.getSectionname()+",")));
					}
			}//outer else
		simpleHibernateTemplate.saveOrUpdateAndGet(sf);
		return sf;
	}

	@Transactional
	public StandardFixture updateSection(SectionCreationDTO sectionCreationDTO) {
		StandardFixture sf = getStandardFixtureBasedOnStandardAndSection(sectionCreationDTO.getClassname(), sectionCreationDTO.getSectionname());
		String sections =sf.getSection();
		StringBuilder sectionBuilder = new StringBuilder();
		for (String section : sections.split(",")) {
			if(section.equals(sectionCreationDTO.getSectionname())){
				section = sectionCreationDTO.getUpdatesectionname();
			}
			sectionBuilder.append(section+",");
		}		
		System.out.println(sectionBuilder.toString());
		sf.setSection(sectionBuilder.toString());
		return sf;
	}
	
	@Transactional
	public StandardFixture getSection(SectionCreationDTO sectionCreationDTO) {
		
		Criteria criteria = this.simpleHibernateTemplate.createCriteria(StandardFixture.class);
		criteria.add(Restrictions.eq("standard", sectionCreationDTO.getClassname()));
		List<StandardFixture> list = criteria.list();
		StandardFixture sf = list.get(0);
		if(sf==null){
			//throw exception
		}
		return sf;
		
	}
	
	@Transactional
	public StudentClassAllocationRecord allocateSection( StudentClassAllocationRecord studentClassAllocationRecord) {

		String section = studentClassAllocationRecord.getSection();
		if(! isStandardAndSectionExist(studentClassAllocationRecord.getStudentclass(), studentClassAllocationRecord.getSection())){
			//
		}
		
		for (String studentId : studentClassAllocationRecord.getStudentid()) {
		    Student student = (Student)	this.simpleHibernateTemplate.get(Student.class, Long.parseLong(studentId));
		    student.getCurrentClass().setSection(section);
		}
		
		return studentClassAllocationRecord;
}

	@Transactional
	public boolean isStandardAndSectionExist(String standard, String section) {
		StandardFixture standardFixture = getStandardFixtureBasedOnStandardAndSection(standard, section);
		return standardFixture == null;
	}
	
	@Transactional
	public StandardFixture getStandardFixtureBasedOnStandardAndSection(String standard, String section){
		Criteria criteria = this.simpleHibernateTemplate.createCriteria(StandardFixture.class);		
		criteria.add(Restrictions.eq("standard", standard));
		criteria.add(Restrictions.like("section", section, MatchMode.ANYWHERE));
		return (StandardFixture) criteria.uniqueResult();
	}
	
}
