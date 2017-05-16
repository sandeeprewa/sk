/**
 * 
 */
package com.academics.school.sl.timetable;

import java.util.List;

import org.springframework.stereotype.Service;

import com.academics.school.pl.timetable.dto.TimeTable;
import com.academics.school.sl.timetable.model.TimeTableModel;

/**
 * @author sandeep
 *
 */
@Service
public interface SubjectTimeTableService {

	List<TimeTableModel> createAssociationOfSubjectAndTeacher(TimeTable timeTable);

	TimeTableModel addOrUpdateSubjectAndTeacher(TimeTableModel timeTableModel);

	TimeTableModel addSubjectAndTeacher(TimeTableModel timeTableModel);

	TimeTableModel updateSubjectAndTeacher(String timeTableId,
			TimeTableModel timeTableModel);

	List<TimeTableModel> getCompleteTimeTable();

}
