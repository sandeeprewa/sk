package com.academics.school.sl.timetable;

import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.academics.school.dl.utility.SimpleHibernateTemplate;
import com.academics.school.pl.timetable.dto.Standard;
import com.academics.school.pl.timetable.dto.SubjectAndTeacher;
import com.academics.school.pl.timetable.dto.TimeTable;
import com.academics.school.sl.timetable.model.TimeTableModel;


@Service("subjectTimeTableServiceImpl")
public class SubjectTimeTableServiceImpl implements SubjectTimeTableService {
	
	SimpleHibernateTemplate<TimeTableModel> simpleHibernateTemplate;
	
	@Autowired
	public SubjectTimeTableServiceImpl(SessionFactory sessionFactory){
		this.simpleHibernateTemplate = new SimpleHibernateTemplate<TimeTableModel>(sessionFactory);
	}
	
	@Transactional
	public List<TimeTableModel> createAssociationOfSubjectAndTeacher(TimeTable timeTable) {
		List<TimeTableModel> listToBeReturned = new ArrayList<TimeTableModel>();
		List<TimeTableModel> listOfTimeTableModel = buildTimeTableModel(timeTable);
		for (TimeTableModel timeTableModel : listOfTimeTableModel) {
			listToBeReturned.add(simpleHibernateTemplate.saveAndGet(timeTableModel));
		}
		return listToBeReturned;
	}
	
	@Transactional
	public TimeTableModel addOrUpdateSubjectAndTeacher(TimeTableModel timeTableModel) {
		return this.simpleHibernateTemplate.updateAndGet(timeTableModel);
	}

	private List<TimeTableModel> buildTimeTableModel(TimeTable timeTable) {
		List<TimeTableModel> listOfTimeTableModel = new ArrayList<TimeTableModel>();
		for(Standard standard : timeTable.getListOfStandard()){
			String local_Standard = standard.getStandard();
			String local_Section = standard.getSection();
			for(SubjectAndTeacher subAndTeacher : standard.getListOfSubject()){
				String subject = subAndTeacher.getSubject();
				String teacher = subAndTeacher.getTeacher();
				TimeTableModel timeTableModelObject = new TimeTableModel();
				timeTableModelObject.setSection(local_Section);
				timeTableModelObject.setStandard(local_Standard);
				timeTableModelObject.setSubject(subject);
				timeTableModelObject.setTeacher(teacher);
				listOfTimeTableModel.add(timeTableModelObject);
			}
		}
		return listOfTimeTableModel;
	}

	public TimeTableModel addSubjectAndTeacher(TimeTableModel timeTableModel) {
		// TODO Auto-generated method stub
		return null;
	}

}
