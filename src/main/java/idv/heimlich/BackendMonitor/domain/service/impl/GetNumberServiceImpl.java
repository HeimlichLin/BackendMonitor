package idv.heimlich.BackendMonitor.domain.service.impl;

import java.math.BigDecimal;

import idv.heimlich.BackendMonitor.domain.code.GetNumberType;
import idv.heimlich.BackendMonitor.domain.dao.GetNumberDAO;
import idv.heimlich.BackendMonitor.domain.dao.impl.GetNumberDAOImpl;
import idv.heimlich.BackendMonitor.domain.service.GetNumberService;

/**
 * 取號服務
 */
public class GetNumberServiceImpl implements GetNumberService {
	
	private static GetNumberService INSTANCT = new GetNumberServiceImpl();
	private GetNumberDAO getNumberDAO = GetNumberDAOImpl.INSTANCE;

	protected GetNumberServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	public static GetNumberService get() {
		return INSTANCT;
	}

	@Override
	public String getCount(GetNumberType getNumberType, String... codes) {
		final String[] codesArray = getNumberType.codes(codes);
		BigDecimal bigDecimal = this.getNumberDAO.getSerialNo(getNumberType.name(), codesArray);
		return getNumberType.getId(codesArray[0], codesArray[1], codesArray[2], bigDecimal);
	}

}
