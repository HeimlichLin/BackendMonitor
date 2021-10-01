package idv.heimlich.BackendMonitor.domain.dao.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import idv.heimlich.BackendMonitor.common.code.MailqueStatus;
import idv.heimlich.BackendMonitor.domain.bean.impl.MailquePo;
import idv.heimlich.BackendMonitor.domain.dao.MailqueDAO;

//系統Mail傳送記錄
public class MailqueDAOImpl implements MailqueDAO {

	public static final MailqueDAOImpl INSTANCE = new MailqueDAOImpl();

	private final static Logger LOG = LoggerFactory.getLogger(MailqueDAOImpl.class);

//	public MailqueDAOImpl() {
//		super("MAILQUE");
//	}

//	@Override
//	public MapConverter<MailquePo> getConverter() {
//		return MailquePo.CONVERTER;
//	}
//
//	@Override
//	public SqlWhere getPkSqlWhere(MailquePo po) {
//		SqlWhere sqlWhere = new SqlWhere();
//		sqlWhere.add(MailquePo.COLUMNS.MAIL_ID.name(), po.getPgmId());
//		return sqlWhere;
//	}

	@Override
	public List<MailquePo> queryMails() {
//		DoXdaoSession xdaoSession = XdaoSessionManager.getDoXdaoSession();
//		SqlWhere sqlWhere = new SqlWhere(SqlWhere.OR);
//		sqlWhere.add(MailquePo.COLUMNS.STATUS.name(),MailqueStatus.W.name());
//		sqlWhere.add(MailquePo.COLUMNS.STATUS.name(),MailqueStatus.R.name());
//		return xdaoSession.selectPo(MailquePo.class, sqlWhere);
		return null;
	}

	@Override
	public void update(String id, MailqueStatus status) {
//		DoXdaoSession xdaoSession = XdaoSessionManager.getDoXdaoSession();
//		DoSqlWhere<MailquePo.COLUMNS> sqlWhere = new DoSqlWhere<MailquePo.COLUMNS>();
//		sqlWhere.add(MailquePo.COLUMNS.MAIL_ID, id);
//		DataObject dataObject = new DataObject();
//		dataObject.setValue(MailquePo.COLUMNS.STATUS.name(), status.name());
//		dataObject.setValue(MailquePo.COLUMNS.SEND_DATE.name(), YYYYMMDDHHMMSSUtils.getText());
//		try {
//			int updateCnt = xdaoSession.update("Mailque", dataObject, sqlWhere);
//			if (updateCnt == 0) {
//				LOG.error("upate erorr id:{}", id);
//			}
//		} catch (XdaoException e) {
//			LOG.error("upate erorr id:{}", id, e);
//		}
	}
	
}
