package com.academics.school.sl.timetable;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
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
	public List<TimeTableModel> createAssociationOfSubjectAndTeacher(List<TimeTableModel> listOfTimeTableModel) {
		List<TimeTableModel> listToBeReturned = new ArrayList<TimeTableModel>();
		for (TimeTableModel timeTableModel : listOfTimeTableModel) {
				listToBeReturned.add(simpleHibernateTemplate.saveOrUpdateAndGet(timeTableModel));
		}
		return listToBeReturned;
	}
	
	@Transactional
	public TimeTableModel addSubjectAndTeacher(TimeTableModel timeTableModel) {
		return this.simpleHibernateTemplate.saveOrUpdateAndGet(timeTableModel);
	}
	
	@Transactional
	public TimeTableModel updateSubjectAndTeacher(String timeTableId,TimeTableModel timeTableModel) {
		return this.simpleHibernateTemplate.updateAndGet(timeTableModel);
	}

	@Transactional
	public List<TimeTableModel> getCompleteTimeTable() {
		Criteria criteria = this.simpleHibernateTemplate.createCriteria(TimeTableModel.class);
		List<TimeTableModel> list = criteria.list();
		return list;
	}

	@Transactional 
	public List<TimeTableModel> getCompleteTimeTableBasedOnClassAndSection(String standard, String sectionId) {
		Criteria criteria = this.simpleHibernateTemplate.createCriteria(TimeTableModel.class);
		if(sectionId != null && !sectionId.isEmpty())
			criteria.add(Restrictions.eq("section", sectionId));
		
		criteria.add(Restrictions.eq("standard",standard));
		List<TimeTableModel> listOfTimeTableModel = criteria.list();
		return listOfTimeTableModel;
	}

	public List<TimeTableModel> deleteTimeTableBasedOnClassAndSection(String classId, String sectionId) {
		
		return null;
	}

}
