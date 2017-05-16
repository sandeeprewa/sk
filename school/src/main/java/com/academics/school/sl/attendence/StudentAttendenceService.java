package com.academics.school.sl.attendence;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.academics.school.pl.controller.attendence.dto.AttendenceRequestDTO;
import com.academics.school.pl.controller.attendence.dto.StudentAttendenceRecord;

@Service
public interface StudentAttendenceService {

    
	List<StudentAttendenceRecord> getAllAttendenceRecordTillCurrentDate(String studentId);
	List<StudentAttendenceRecord> getAttendenceRecordBasedTimePeriod(String string, Date startTime,Date lastTime);
	List<StudentAttendenceRecord> getAttendenceRecordBasedOnDate(String studentId,Date lastTime);
     
}
