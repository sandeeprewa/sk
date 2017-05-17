package com.academics.school.pl.timetable;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.academics.school.pl.timetable.dto.TimeTable;
import com.academics.school.sl.timetable.SubjectTimeTableService;
import com.academics.school.sl.timetable.model.TimeTableModel;

@Component
public class SubjectTimeTableFacade {

	@Autowired
	@Qualifier("subjectTimeTableServiceImpl")
	SubjectTimeTableService subjectTimeTableServiceImpl;
	
	public List<TimeTableModel> createAssociationOfSubjectAndTeacher(List<TimeTableModel> listOfTimeTable) {
		return subjectTimeTableServiceImpl.createAssociationOfSubjectAndTeacher(listOfTimeTable);
	}

	public TimeTableModel addSubjectAndTeacher(TimeTableModel timeTableModel) {
		return subjectTimeTableServiceImpl.addSubjectAndTeacher(timeTableModel);
	}

	public TimeTableModel UpdateSubjectAndTeacher(String timeTableId, TimeTableModel timeTableModel) {
		return subjectTimeTableServiceImpl.updateSubjectAndTeacher(timeTableId, timeTableModel);
	}

	public List<TimeTableModel> getCompleteTimeTable() {
		return subjectTimeTableServiceImpl.getCompleteTimeTable();
	}

	public List<TimeTableModel> getTimeTableBasedOnClassAndSection(String classId,	String sectionId) {
		return subjectTimeTableServiceImpl.getCompleteTimeTableBasedOnClassAndSection(classId, sectionId);
	}

	public List<TimeTableModel> getTimeTableBasedOnClass(String classId) {
		return getTimeTableBasedOnClassAndSection(classId, null);
	}

	public List<TimeTableModel> deleteTimeTableBasedOnClassAndSection(String classId, String sectionId) {
		return subjectTimeTableServiceImpl.deleteTimeTableBasedOnClassAndSection(classId, sectionId);
	}

}
