package com.Zap.GE.BP;

public class Enums {
	public enum eSortBy
	{
		PRICE("מחיר");
		private String val;

	    private eSortBy(String val){
	                this.val = val;
	    }

	    public String val() {
	                return val;
	    }
	}
	

}
