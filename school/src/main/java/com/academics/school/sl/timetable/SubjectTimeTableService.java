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

	List<TimeTableModel> createAssociationOfSubjectAndTeacher(List<TimeTableModel> listOfTimeTable);

	TimeTableModel addSubjectAndTeacher(TimeTableModel timeTableModel);

	TimeTableModel updateSubjectAndTeacher(String timeTableId,
			TimeTableModel timeTableModel);

	List<TimeTableModel> getCompleteTimeTable();

	List<TimeTableModel> getCompleteTimeTableBasedOnClassAndSection(
			String classId, String sectionId);

	List<TimeTableModel> deleteTimeTableBasedOnClassAndSection(String classId,
			String sectionId);

}
