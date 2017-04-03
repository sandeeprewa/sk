package com.school.pl.controller.teset;

public enum Quality {
		GOOD("good"),
		BAD("bad");
		
		private String val;
		Quality(String val){
			this.val = val;
		}
		
		
		@Override
		public String toString(){
			return this.val;
		}
		
		
}
