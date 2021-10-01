package idv.heimlich.BackendMonitor.domain.dao.impl;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import idv.heimlich.BackendMonitor.domain.dao.GetNumberDAO;

//取號檔案
public class GetNumberDAOImpl implements GetNumberDAO {
	
	public static final GetNumberDAOImpl INSTANCE = new GetNumberDAOImpl();
	private static Byte[] LOCK = new Byte[] {};

	private final static Logger LOG = LoggerFactory.getLogger(GetNumberDAOImpl.class);

//	public GetNumberDAOImpl() {
//		super("GET_NUMBER");
//	}

//	@Override
//	public MapConverter<GetNumberPo> getConverter() {
//		return GetNumberPo.CONVERTER;
//	}
//
//	@Override
//	public SqlWhere getPkSqlWhere(GetNumberPo po) {
//		SqlWhere sqlWhere = new SqlWhere();
//		sqlWhere.add(GetNumberPo.COLUMNS.PGM_ID.name(), po.getPgmId());
//		sqlWhere.add(GetNumberPo.COLUMNS.SYSCODE1.name(), po.getSyscode1());
//		sqlWhere.add(GetNumberPo.COLUMNS.SYSCODE2.name(), po.getSyscode2());
//		sqlWhere.add(GetNumberPo.COLUMNS.SYSCODE3.name(), po.getSyscode3());
//		return sqlWhere;
//	}

	@Override
	public BigDecimal getSerialNo(String pgmId, String... syscode) {
		if (syscode.length < 3) {
			throw new IllegalArgumentException("syscode argum must equal 3 ");
		}

		synchronized (LOCK) {
//			DoXdaoSession xdaoSession = XdaoSessionManager.getDoXdaoSession();
//
//			final String sys1 = StringUtils.defaultString(syscode[0], "N");
//			final String sys2 = StringUtils.defaultString(syscode[1], "N");
//			final String sys3 = StringUtils.defaultString(syscode[2], "N");
//
//			SqlWhere sqlWhere = new SqlWhere();
//			sqlWhere.add(GetNumberPo.COLUMNS.PGM_ID.name(), pgmId);
//			sqlWhere.add(GetNumberPo.COLUMNS.SYSCODE1.name(), sys1);
//			sqlWhere.add(GetNumberPo.COLUMNS.SYSCODE2.name(), sys2);
//			sqlWhere.add(GetNumberPo.COLUMNS.SYSCODE3.name(), sys3);
//
//			BigDecimal count = BigDecimal.ONE;
//			List<GetNumberPo> getNumberPos = xdaoSession.selectPo(GetNumberPo.class, sqlWhere);
//			if (CollectionUtils.isEmpty(getNumberPos)) {
//				GetNumberPo insertPo = new GetNumberPo();
//				insertPo.setCount(count);
//				insertPo.setPgmId(pgmId);
//				insertPo.setSyscode1(sys1);
//				insertPo.setSyscode2(sys2);
//				insertPo.setSyscode3(sys3);
//				xdaoSession.insertPo(insertPo);
//			} else {
//				count = getNumberPos.get(0).getCount().add(BigDecimal.ONE);
//				DataObject modfyObj = new DataObject();
//				modfyObj.setValue(GetNumberPo.COLUMNS.COUNT.name(), count);
//
//				try {
//					xdaoSession.update("GET_NUMBER", modfyObj, sqlWhere);
//				} catch (XdaoException e) {
//					LOG.error("更新異常  modfiy obj:{}", modfyObj, e);
//				}
//			}
//			return count;
			return null;
		}
	}

}
