package com.lji.local.spring.common;

import java.util.Vector;

public class IdArrays {
	
	private static Vector<String> ids = new Vector<String>();
	
	public synchronized static Vector<String> getIds() {
		return ids;
	}

	public synchronized static void setIds(Vector<String> ids) {
		IdArrays.ids = ids;
	}

	public static void push(String id) {
		ids.add(id);
	}
	
	// 先进先出
	public synchronized static String pop() {
		System.err.println(ids.get(0));
		ids.remove(0);
		return null;
	}
	
	public synchronized static boolean hasNext() {
		return ids.size() > 0 ? true:false;
	}

}
