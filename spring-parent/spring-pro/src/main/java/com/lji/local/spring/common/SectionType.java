package com.lji.local.spring.common;

import java.util.Calendar;

public enum SectionType {
	
	SectionType_1(1,1,"今年以来"),
	SectionType_2(2,2,"成立以来"),
	SectionType_3(3,3,"近一个月"),
	SectionType_4(4,4,"近三个月"),
	SectionType_5(5,5,"近六个月"),
	SectionType_6(6,6,"近一年"),
	SectionType_7(7,7,"进两年"),
	SectionType_8(8,8,"近三年"),
	SectionType_9(9,Calendar.getInstance().get(Calendar.YEAR) - 1, Calendar.getInstance().get(Calendar.YEAR) - 1 + ""),
	SectionType_10(10,Calendar.getInstance().get(Calendar.YEAR) - 2, Calendar.getInstance().get(Calendar.YEAR) - 2 + ""),
	SectionType_11(11,Calendar.getInstance().get(Calendar.YEAR) - 3, Calendar.getInstance().get(Calendar.YEAR) - 3 + ""),
	SectionType_12(12,Calendar.getInstance().get(Calendar.YEAR) - 4, Calendar.getInstance().get(Calendar.YEAR) - 4 + "");
	
	private SectionType(int index,int value,String description) {
		this.index = index;
		this.description = description;
		this.value = value;
	}
	
	private int index;
	private String description;
	private int value;
	
	
	public static String getDescription(int index) {
		for (SectionType c : SectionType.values()) {
			if(c.getIndex() == index)
				return c.getDescription();
		}
		return "";
	}
	
	public static int getValue(int index) {
		for (SectionType c : SectionType.values()) {
			if(c.getIndex() == index)
				return c.getValue();
		}
		return 0;
	}


	public int getIndex() {
		return index;
	}


	public void setIndex(int index) {
		this.index = index;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

}
