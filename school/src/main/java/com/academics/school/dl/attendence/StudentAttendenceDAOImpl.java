package com.academics.school.dl.attendence;

import java.sql.Timestamp;
import java.util.*;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.academics.school.dl.utility.SimpleHibernateTemplate;
import com.academics.school.pl.controller.attendence.dto.AttendenceStatus;
import com.academics.school.pl.controller.attendence.dto.StudentAttendenceRecord;
import com.academics.school.pl.controller.registration.error.StudentIdDoesNotFoundException;

@Repository("studentAttendenceDAO")
public class StudentAttendenceDAOImpl implements StudentAttendenceDAO {
	
	
	SimpleHibernateTemplate<StudentAttendenceRecord> simpleHibernateTemplate;
	int i =0;
	
	@Autowired
	public StudentAttendenceDAOImpl(SessionFactory session) {
		this.simpleHibernateTemplate = new SimpleHibernateTemplate<StudentAttendenceRecord>(session);
	}
	
	@Transactional(value = TxType.REQUIRES_NEW)
	public void demoTB(){
		StudentAttendenceRecord record1 = new StudentAttendenceRecord();
		record1.setAttendenceStatus(AttendenceStatus.ABSENT);
		record1.setStudentId(1L);
		
		simpleHibernateTemplate.save(record1);
		
		StudentAttendenceRecord record2 = new StudentAttendenceRecord();
		record2.setAttendenceStatus(AttendenceStatus.ABSENT);
		record2.setStudentId(2L);
		
		simpleHibernateTemplate.save(record2);
		
		StudentAttendenceRecord record3 = new StudentAttendenceRecord();
		record3.setAttendenceStatus(AttendenceStatus.ABSENT);
		record3.setStudentId(3L);
		
		simpleHibernateTemplate.save(record3);
		
		StudentAttendenceRecord record4 = new StudentAttendenceRecord();
		record4.setAttendenceStatus(AttendenceStatus.ABSENT);
		record4.setStudentId(4L);
		
		simpleHibernateTemplate.save(record4);
		
		StudentAttendenceRecord record5 = new StudentAttendenceRecord();
		record5.setAttendenceStatus(AttendenceStatus.ABSENT);
		record5.setStudentId(5L);
		
		simpleHibernateTemplate.save(record5);
		
		StudentAttendenceRecord record6 = new StudentAttendenceRecord();
		record6.setAttendenceStatus(AttendenceStatus.ABSENT);
		record6.setStudentId(6L);
		
		simpleHibernateTemplate.save(record6);
	}
	
	
	@Transactional
	public List<StudentAttendenceRecord> getAttendenceRecord(String studentId,Date startTime, Date lastTime) {
		if(i==0){
			 demoTB();
			 i++;
		}
		
		
		Criteria criteria = simpleHibernateTemplate.createCriteria(StudentAttendenceRecord.class);
		criteria.add(Restrictions.eq("studentId",Long.parseLong(studentId)));
		criteria.add(Restrictions.between("timestamp", startTime, lastTime));
		List<StudentAttendenceRecord> listOfRecord = criteria.list();
		
		if(listOfRecord == null){
			throw new StudentIdDoesNotFoundException("Student ID does not exist");
		}
		
		return listOfRecord;
	}
	
	@Transactional
	public List<StudentAttendenceRecord> getAttendenceRecord(String studentId) {
		return getAttendenceRecord(studentId, null, null);
	}
	@Transactional
	public List<StudentAttendenceRecord> getAttendenceRecord(String studentId, Date lastTime) {
		return getAttendenceRecord(studentId, null, lastTime);
	}
			
}
