package com.academics.school.dl.attendence;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.academics.school.pl.controller.attendence.dto.StudentAttendenceRecord;

@Repository
public interface StudentAttendenceDAO {
	
	
	List<StudentAttendenceRecord> getAttendenceRecord(String studentId,
			Date startTime, Date lastDate);

	List<StudentAttendenceRecord> getAttendenceRecord(String studentId);

	List<StudentAttendenceRecord> getAttendenceRecord(String studentId, Date lastTime);
	
	
	
}
