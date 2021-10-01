package idv.heimlich.BackendMonitor.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import idv.heimlich.BackendMonitor.common.exception.BaseBusinessException;

public class YYYYMMDDUtils {
	protected static final SimpleDateFormat SDF = new SimpleDateFormat(
			"yyyyMMdd");

	public static String getText(Date date) {
		return SDF.format(date);
	}

	public static String getText() {
		return getText(new Date());
	}

	public static Date parse(String yyyymmdd) {
		try {
			return SDF.parse(yyyymmdd);
		} catch (ParseException e) {
			throw new BaseBusinessException("日期格式錯誤:" + yyyymmdd);
		}
	}

}
