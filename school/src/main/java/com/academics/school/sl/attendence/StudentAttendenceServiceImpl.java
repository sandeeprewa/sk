package com.academics.school.sl.attendence;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.academics.school.dl.attendence.StudentAttendenceDAO;
import com.academics.school.pl.controller.attendence.dto.AttendenceRequestDTO;
import com.academics.school.pl.controller.attendence.dto.StudentAttendenceRecord;

@Service("studentAttendenceServiceImpl")
	
public class StudentAttendenceServiceImpl implements StudentAttendenceService {

	
	@Autowired
	@Qualifier("studentAttendenceDAO")
	StudentAttendenceDAO studentAttendenceDAOImpl;
	

	public List<StudentAttendenceRecord> getAllAttendenceRecordTillCurrentDate(String studentId) {
		
		return studentAttendenceDAOImpl.getAttendenceRecord(studentId);
	}

	public List<StudentAttendenceRecord> getAttendenceRecordBasedTimePeriod(String studentId, String startTime, String lastTime) {
		return studentAttendenceDAOImpl.getAttendenceRecord(studentId, startTime, lastTime);
	}

	public List<StudentAttendenceRecord> getAttendenceRecordBasedOnDate(String studentId, String lastTime) {
		return studentAttendenceDAOImpl.getAttendenceRecord(studentId, lastTime);
	}
	
}
