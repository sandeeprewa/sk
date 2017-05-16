package com.academics.school.pl.controller.attendence;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.academics.school.pl.controller.attendence.dto.AttendenceRequestDTO;
import com.academics.school.pl.controller.attendence.dto.StudentAttendenceRecord;
import com.academics.school.sl.attendence.StudentAttendenceService;
import com.academics.school.sl.attendence.StudentAttendenceServiceImpl;

@Component
public class StudentAttendenceFacade {

	@Autowired
	@Qualifier("studentAttendenceServiceImpl")
	StudentAttendenceService studentAttendenceServiceImpl;
	
	public List<StudentAttendenceRecord> getAttendenceRecordBasedOnDiffParameter(AttendenceRequestDTO attendenceRequestDTO) {
		
		Date startTime = attendenceRequestDTO.getStartTime();
		Date lastTime  = attendenceRequestDTO.getLastTime();
		Date currentTime = new Date();
		
		 if(startTime == null & lastTime ==null){
			 return studentAttendenceServiceImpl.getAllAttendenceRecordTillCurrentDate(attendenceRequestDTO.getStudentId());
		 }
		 
		 if(startTime !=null){
			 	if(lastTime == null){
			 		lastTime = currentTime;
			 	}
			return studentAttendenceServiceImpl.getAttendenceRecordBasedTimePeriod(attendenceRequestDTO.getStudentId(),startTime,lastTime);
		 }
	
		 
		 return studentAttendenceServiceImpl.getAttendenceRecordBasedOnDate(attendenceRequestDTO.getStudentId(), lastTime);
	}
	
}
