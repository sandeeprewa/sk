package com.academics.school.pl.controller.attendence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.academics.school.pl.controller.attendence.dto.AttendenceRequestDTO;
import com.academics.school.pl.controller.attendence.dto.StudentAttendenceRecord;
import com.academics.school.sl.attendence.StudentAttendenceService;

@Component
public class StudentAttendenceFacade {

	@Autowired
	StudentAttendenceService studentAttendenceServiceImpl;
	
	public StudentAttendenceRecord getAttendenceRecordBasedOnDiffParameter(
			AttendenceRequestDTO attendenceRequestDTO) {
		// TODO Auto-generated method stub
		return studentAttendenceServiceImpl.getAttendenceRecordBasedOnDiffParameter(attendenceRequestDTO);
	}

}
