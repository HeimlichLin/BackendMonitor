package idv.heimlich.BackendMonitor.domain.service;

import idv.heimlich.BackendMonitor.domain.code.GetNumberType;

public interface GetNumberService {
	
	/**
	 * 取號
	 */
	public String getCount(GetNumberType getNumberType, String... codes);

}
