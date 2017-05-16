package com.academics.school.pl.controller.attendence;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
		
		String startTime = attendenceRequestDTO.getStartTime();
		String lastTime  = attendenceRequestDTO.getLastTime();
		Date currentTime = new Date();
		DateFormat df = new SimpleDateFormat("dd-mm-yyyy");
		df.format(currentTime);
		String currentTimeStr = currentTime.toString();
		
		 if(startTime == null & lastTime ==null){
			 return studentAttendenceServiceImpl.getAllAttendenceRecordTillCurrentDate(attendenceRequestDTO.getStudentId());
		 }
		 
		 if(startTime !=null){
			 	if(lastTime == null){
			 		lastTime = currentTimeStr;
			 	}
			return studentAttendenceServiceImpl.getAttendenceRecordBasedTimePeriod(attendenceRequestDTO.getStudentId(),startTime,lastTime);
		 }
	
		 
		 return studentAttendenceServiceImpl.getAttendenceRecordBasedOnDate(attendenceRequestDTO.getStudentId(), lastTime);
	}
	
}
