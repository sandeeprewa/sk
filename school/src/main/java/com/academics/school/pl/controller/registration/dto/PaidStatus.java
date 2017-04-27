package com.academics.school.pl.controller.registration.dto;

public enum PaidStatus {
		PAID("paid"),
		UNPAID("unpaid");
		
		private String status;
		
		PaidStatus(String status){
			this.status = status;
		}
}
