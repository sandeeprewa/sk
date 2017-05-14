package com.academics.school.sl.attendence;

import com.academics.school.pl.controller.attendence.dto.AttendenceRequestDTO;
import com.academics.school.pl.controller.attendence.dto.StudentAttendenceRecord;

public interface StudentAttendenceService {

	StudentAttendenceRecord getAttendenceRecordBasedOnDiffParameter(
			AttendenceRequestDTO attendenceRequestDTO);

}
