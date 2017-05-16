package com.academics.school.dl.attendence;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
		Date currentDate = new Date();
		String dateString = getDateAsString(currentDate);
		StudentAttendenceRecord record1 = new StudentAttendenceRecord();
		record1.setAttendenceStatus(AttendenceStatus.ABSENT);
		record1.setStudentId(1L);
		record1.setTimeStamp(dateString);
		
		
		simpleHibernateTemplate.save(record1);
		
		StudentAttendenceRecord record2 = new StudentAttendenceRecord();
		record2.setAttendenceStatus(AttendenceStatus.ABSENT);
		record2.setStudentId(2L);
		record2.setTimeStamp(dateString);
		
		simpleHibernateTemplate.save(record2);
		
		StudentAttendenceRecord record3 = new StudentAttendenceRecord();
		record3.setAttendenceStatus(AttendenceStatus.ABSENT);
		record3.setStudentId(3L);
		record3.setTimeStamp(dateString);

		simpleHibernateTemplate.save(record3);
		
		StudentAttendenceRecord record4 = new StudentAttendenceRecord();
		record4.setAttendenceStatus(AttendenceStatus.ABSENT);
		record4.setStudentId(4L);
		record4.setTimeStamp(dateString);

		simpleHibernateTemplate.save(record4);
		
		StudentAttendenceRecord record5 = new StudentAttendenceRecord();
		record5.setAttendenceStatus(AttendenceStatus.ABSENT);
		record5.setStudentId(5L);
		record5.setTimeStamp(dateString);

		simpleHibernateTemplate.save(record5);
		
		StudentAttendenceRecord record6 = new StudentAttendenceRecord();
		record6.setAttendenceStatus(AttendenceStatus.ABSENT);
		record6.setStudentId(6L);
		
		simpleHibernateTemplate.save(record6);
	}
	
	
	@Transactional
	public List<StudentAttendenceRecord> getAttendenceRecord(String studentId,String startTime, String lastTime) {
		if(i==0){
			 demoTB();
			 i++;
		}
			startTime = getDateAsString(getFormattedDate(startTime));
			lastTime =  getDateAsString(getFormattedDate(lastTime));
		
		Criteria criteria = simpleHibernateTemplate.createCriteria(StudentAttendenceRecord.class);
		criteria.add(Restrictions.eq("studentId",Long.parseLong(studentId)));
		criteria.add(Restrictions.between("timeStamp", startTime, lastTime));
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
	public List<StudentAttendenceRecord> getAttendenceRecord(String studentId, String lastTime) {
		return getAttendenceRecord(studentId, null, lastTime);
	}
			
	 private static String getDateAsString(Date date){
			SimpleDateFormat newFormat = new SimpleDateFormat("MM-dd-yyyy");
			return newFormat.format(date);
	 }
	 
	 private static Date getFormattedDate(String start_dt) {
		 try{
			DateFormat formatter = new SimpleDateFormat("yyyy-MM-DD"); 
			return (Date)formatter.parse(start_dt);
		 }catch(Exception ex){
			 //supress and log
			 return null;
		 }
	 }
	
}
