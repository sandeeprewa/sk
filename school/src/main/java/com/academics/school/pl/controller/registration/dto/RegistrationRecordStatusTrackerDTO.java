package com.academics.school.pl.controller.registration.dto;

public class RegistrationRecordStatusTrackerDTO {
	
			long registrationId;
			String status;
			String comment;
			
			public long getRegistrationId() {
				return registrationId;
			}
			public void setRegistrationId(long registrationId) {
				this.registrationId = registrationId;
			}
			public String getStatus() {
				return status;
			}
			public void setStatus(String status) {
				this.status = status;
			}
			public String getComment() {
				return comment;
			}
			public void setComment(String comment) {
				this.comment = comment;
			}
	
}
