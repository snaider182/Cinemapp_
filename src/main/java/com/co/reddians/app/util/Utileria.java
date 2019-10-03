package com.co.reddians.app.util;

import java.text.SimpleDateFormat;
import java.util.*;

public class Utileria {
	/**
	 * Metodoque regresa una lista de Strings con las fechas siguientes, según el
	 * parametro count
	 * 
	 * @param count
	 * @return
	 */

	public static List<String> getNextDays(int count) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		// today 's Date
		Date start = new Date();
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, count);
		Date endDate = cal.getTime();

		GregorianCalendar gCal = new GregorianCalendar();
		gCal.setTime(start);
		List<String> nextDay = new ArrayList<String>();
		while (!gCal.getTime().after(endDate)) {
			Date d = gCal.getTime();
			gCal.add(Calendar.DATE, 1);
			nextDay.add(sdf.format(d));
		}
		return nextDay;
	}

}
