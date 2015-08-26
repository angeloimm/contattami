package com.goinitaly.spring.web.util;

import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class DateUtil
{
	public static String fromLongToString(long date)
	{
		DateTimeFormatter fmt = DateTimeFormat.forPattern("dd/MM/yyyy");
		return fmt.print(date);
	}
}
