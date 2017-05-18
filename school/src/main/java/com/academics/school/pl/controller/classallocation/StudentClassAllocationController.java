package com.academics.school.pl.controller.classallocation;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.academics.school.pl.controller.claaallocation.dto.SearchClassAllocationRequestDTO;
import com.academics.school.pl.controller.claaallocation.dto.SectionCreationDTO;
import com.academics.school.pl.controller.claaallocation.dto.StudentClassAllocationRecord;
import com.academics.school.pl.controller.classallocation.error.SectionAlredyExistException;
import com.academics.school.pl.controller.classallocation.error.StudentAlreadyAllocatedException;
import com.academics.school.pl.controller.classallocation.error.StudentClassAllocationFieldValidationException;
import com.academics.school.pl.controller.classallocation.error.StudentSectionDoesNotExistException;
import com.academics.school.pl.controller.classallocation.validation.StudentClassAllocationRecordValidator;
import com.academics.school.pl.controller.registration.dto.Student;
import com.academics.school.pl.rest.security.PrivilageEnum;
import com.academics.school.pl.rest.security.RequiredPrivilage;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

/*
 * @author sandeep
 */
@RestController
@RequestMapping("/rest/classallocation")
public class StudentClassAllocationController {

	@Autowired
	StudentClassAllocationFacade studentClassAllocationFacade;
	
	StudentClassAllocationRecordDTO studentClassAllocationDTO;
	 /*
	 *Search Admission Record based on Different Parameter
	 */
		@RequiredPrivilage({PrivilageEnum.EDITOR})
		@RequestMapping(value = "/search", method = RequestMethod.POST)
		public List<Student> getStudentAdmissionRecordByStudentClass(@RequestBody SearchClassAllocationRequestDTO searchClassAllocationRequestDTO)throws StudentClassAllocationFieldValidationException 
		{
			 validate(searchClassAllocationRequestDTO);
			 return studentClassAllocationFacade.getClassAllocationRecordBasedOnClass(searchClassAllocationRequestDTO);
		}
		
		/*
		 * creating section
		 */
		@RequiredPrivilage({PrivilageEnum.EDITOR})
		@RequestMapping(value = "/section", method = RequestMethod.POST)
		public SectionCreationDTO createSection(@RequestBody SectionCreationDTO sectionCreationDTO) 
				throws SectionAlredyExistException ,StudentClassAllocationFieldValidationException{
			validate(sectionCreationDTO,"POST");
			SectionCreationDTO sectionCreationDTOResult=studentClassAllocationFacade.createSection(sectionCreationDTO);
			return sectionCreationDTOResult;
		}
		
		
	/*
	 * updating admission record with section or allocating section
	 */
		@RequestMapping(value = "/alocate_seaction", method = RequestMethod.POST)
		@RequiredPrivilage({PrivilageEnum.EDITOR})
		public StudentClassAllocationRecord allocateSection(@RequestBody FakeStudentClassAllocationRecord   fakeStudentClassAllocationRecord) 
				throws  StudentAlreadyAllocatedException, JsonParseException, JsonMappingException, IOException, StudentClassAllocationFieldValidationException {
			ArrayList<StudentClassAllocationRecord> allocationList = (ArrayList<StudentClassAllocationRecord>) fakeStudentClassAllocationRecord.getListOfStudent();
			studentClassAllocationDTO.setListOfStudent(allocationList);
			studentClassAllocationDTO.setStudentclass(fakeStudentClassAllocationRecord.getStudentclass());
			studentClassAllocationDTO.setSection(fakeStudentClassAllocationRecord.getSection());
			validate(studentClassAllocationDTO);
			return studentClassAllocationFacade.updateAdmissionRecord(studentClassAllocationDTO);
		}
		
		/*
		 * updating  section
		 */
		@RequiredPrivilage({PrivilageEnum.EDITOR})
		@RequestMapping(value = "/update", method = RequestMethod.PUT)
		public SectionCreationDTO updateSection(@RequestBody SectionCreationDTO sectionCreationDTO) 
				throws SectionAlredyExistException ,StudentClassAllocationFieldValidationException{
			validate(sectionCreationDTO,"PUT");
			SectionCreationDTO sectionCreationDTOResult=studentClassAllocationFacade.createSection(sectionCreationDTO);
			return sectionCreationDTOResult;
		}
		
		@RequiredPrivilage({PrivilageEnum.EDITOR})
		@RequestMapping(value = "/getsection", method = RequestMethod.POST)
		public List<SectionCreationDTO> getSection(@RequestBody SectionCreationDTO sectionCreationDTO) 
				throws StudentSectionDoesNotExistException ,StudentClassAllocationFieldValidationException{
			validate(sectionCreationDTO,"GET");
			List<SectionCreationDTO> sectionCreationDTOResult=studentClassAllocationFacade.getSection(sectionCreationDTO);
			return sectionCreationDTOResult;
		}

		/*
		 * deleting  section
		 */
		@RequiredPrivilage({PrivilageEnum.EDITOR})
		@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
		public SectionCreationDTO deleteSection(@RequestBody SectionCreationDTO sectionCreationDTO)throws StudentClassAllocationFieldValidationException{
			validate(sectionCreationDTO,"DELETE");
			//SectionCreationDTO sectionCreationDTOResult=studentClassAllocationFacade.deleteSection(sectionCreationDTO);
			return studentClassAllocationFacade.deleteSection(sectionCreationDTO);
		}
		
	/*
	 * Validating ClassAllocation Record 
	 */
	private void validateListOfAllocationSectionRecord(List<StudentClassAllocationRecord> statusDTOList) {
		StudentClassAllocationRecordValidator.validate(statusDTOList);
	}

	private void validate(StudentClassAllocationRecord studentClassAllocationRecord) throws StudentClassAllocationFieldValidationException {
		StudentClassAllocationRecordValidator.validate(studentClassAllocationRecord);
	}
	private void validate(StudentClassAllocationRecordDTO studentClassAllocationDTO) throws StudentClassAllocationFieldValidationException {
		validateListOfAllocationSectionRecord(studentClassAllocationDTO.getListOfStudent());
		StudentClassAllocationRecordValidator.validate(studentClassAllocationDTO);
	}
	
	private void validate(SectionCreationDTO sectionCreationDTO,String input) throws StudentClassAllocationFieldValidationException {
		StudentClassAllocationRecordValidator.validate(sectionCreationDTO,input);
	}
	
	private void validate(SearchClassAllocationRequestDTO searchClassAllocationRequestDTO) throws StudentClassAllocationFieldValidationException {
		StudentClassAllocationRecordValidator.validate(searchClassAllocationRequestDTO);
	}
	
	
}
