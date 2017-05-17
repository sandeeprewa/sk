package com.academics.school.pl.timetable;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.academics.school.pl.timetable.dto.TimeTable;
import com.academics.school.pl.timetable.validation.TimeTableModelValidator;
import com.academics.school.pl.timetable.validation.TimeTableValidator;
import com.academics.school.sl.timetable.model.TimeTableModel;

@RestController
@RequestMapping(value = "/rest/timetable")
public class SubjectTimeTableController {
	
	@Autowired
	SubjectTimeTableFacade subjectTimeTableFacade;
	
	@RequestMapping(method = RequestMethod.POST)
	public List<TimeTableModel> createAssociationOfSubjectAndTeacher(@RequestBody TimeTableModel[] timeTable){
		List<TimeTableModel> listOfTimeTable = Arrays.asList(timeTable);
		for (TimeTableModel timeTableModel : listOfTimeTable) {
			validate(timeTableModel);
		}
		return subjectTimeTableFacade.createAssociationOfSubjectAndTeacher(listOfTimeTable);
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public TimeTableModel addSubjectAndTeacher(@RequestBody TimeTableModel timeTableModel){
		validate(timeTableModel);
		return subjectTimeTableFacade.addSubjectAndTeacher(timeTableModel);
	}
	
	@RequestMapping(value = "{timeTableId}", method = RequestMethod.POST)
	public TimeTableModel updateSubjectAndTeacher(@PathVariable("timeTableId") String timeTableId, @ModelAttribute TimeTableModel timeTableModel ){
		timeTableModel.setId(Long.parseLong(timeTableId));
		validate(timeTableModel);
		return subjectTimeTableFacade.UpdateSubjectAndTeacher(timeTableId ,timeTableModel);
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<TimeTableModel> getTimeTable(){
		return subjectTimeTableFacade.getCompleteTimeTable();
	}
	
	@RequestMapping(value = "/class/{classId}/section/{sectionId}" ,method = RequestMethod.GET)
	public List<TimeTableModel> getTimeTableBasedOnClassAndSection(@PathVariable("classId") String classId, @PathVariable("sectionId") String sectionId){
		return subjectTimeTableFacade.getTimeTableBasedOnClassAndSection(classId, sectionId);
	}
	
	@RequestMapping(value = "/class/{classId}", method = RequestMethod.GET)
	public List<TimeTableModel> getTimeBasedOnClass(@PathVariable("classId") String classId ){
		return subjectTimeTableFacade.getTimeTableBasedOnClass(classId);
	}
	
	@RequestMapping(value = "/class/{classId}/section/{sectionId}" ,method = RequestMethod.DELETE)
	public List<TimeTableModel> deleteTimeTableBasedOnClassAndSection(@PathVariable("classId") String classId, @PathVariable("sectionId") String sectionId){
		return subjectTimeTableFacade.deleteTimeTableBasedOnClassAndSection(classId, sectionId);
	}
	
	private void validate(TimeTable timeTable){
		TimeTableValidator.validate(timeTable);
	}
	
	private void validate(TimeTableModel timeTableModel){
		TimeTableModelValidator.validate(timeTableModel);
	}
}
