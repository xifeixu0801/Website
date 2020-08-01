package com.regex.admin.common.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Johnny
 * 
 */
public class DateConverterBase {
    private String datePattern = "yyyy-MM-dd";
    private String timePattern = "HH:mm:ss";
    private DateFormat dateFormat = new SimpleDateFormat(datePattern);
    private DateFormat dateTimeFormat = new SimpleDateFormat(datePattern + " " + timePattern);

    public DateFormat getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(DateFormat dateFormat) {
        this.dateFormat = dateFormat;
    }

    /**
     * @return the dateTimeFormat
     */
    public DateFormat getDateTimeFormat() {
        return dateTimeFormat;
    }

    /**
     * @param dateTimeFormat the dateTimeFormat to set
     */
    public void setDateTimeFormat(DateFormat dateTimeFormat) {
        this.dateTimeFormat = dateTimeFormat;
    }

	public String convert(Date source) {
		// TODO Auto-generated method stub
		return null;
	}

	public Date convert(String source) {
		// TODO Auto-generated method stub
		return null;
	}

}
