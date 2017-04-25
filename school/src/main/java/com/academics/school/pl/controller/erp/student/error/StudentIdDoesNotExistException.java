package com.academics.school.pl.controller.erp.student.error;

public class StudentIdDoesNotExistException extends RuntimeException {

	private static final long serialVersionUID = 4267313636962565184L;

		public StudentIdDoesNotExistException(String msg) {
			super(msg);
		}
}
