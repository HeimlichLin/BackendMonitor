package idv.heimlich.BackendMonitor.domain.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import idv.heimlich.BackendMonitor.common.code.MailqueStatus;
import idv.heimlich.BackendMonitor.common.mail.MailBean;
import idv.heimlich.BackendMonitor.common.mail.MailFace;
import idv.heimlich.BackendMonitor.common.mail.MailqueWarpPo;
import idv.heimlich.BackendMonitor.domain.bean.impl.MailquePo;
import idv.heimlich.BackendMonitor.domain.dao.MailqueDAO;
import idv.heimlich.BackendMonitor.domain.dao.impl.MailqueDAOImpl;
import idv.heimlich.BackendMonitor.domain.dto.impl.MailCreateDTO;
import idv.heimlich.BackendMonitor.domain.service.GetNumberService;
import idv.heimlich.BackendMonitor.domain.service.MailService;

/**
 * 信件服務
 */
public class MailServiceImpl implements MailService {
	
	private final static Logger LOG = LoggerFactory.getLogger(MailServiceImpl.class);
	private transient GetNumberService getNumberService = GetNumberServiceImpl.get();

	private transient MailqueDAO mailqueDAO = MailqueDAOImpl.INSTANCE;

	private static MailService INSTANCT = new MailServiceImpl();
	
	public static MailService get() {
		return INSTANCT;
	}

	@Override
	public String create(MailCreateDTO mailCreateDTO) {
//		DoXdaoSession doXdaoSession = XdaoSessionManager.getDoXdaoSession();
//		final String id = this.getNumberService.getCount(GetNumberType.YYYYMMDD12N);
//		final MailquePo mailquePo = new MailquePo();
//		mailquePo.setMailId(id);
//		mailquePo.setCreateDate(YYYYMMDDHHMMSSUtils.getText());
//		mailquePo.setFilePath(mailCreateDTO.getFilePath());
//		mailquePo.setMailBcc(mailCreateDTO.getMailBcc());
//		mailquePo.setMailCc(mailCreateDTO.getMailCc());
//		mailquePo.setMailFrom(mailCreateDTO.getMailFrom());
//		mailquePo.setMailTo(mailCreateDTO.getMailTo());
//		mailquePo.setMessage(mailCreateDTO.getMessage());
//		mailquePo.setPgmId(mailCreateDTO.getPgmId());
//		mailquePo.setRemarks(mailCreateDTO.getRemarks());
//		mailquePo.setSendDate(null);
//		mailquePo.setSubject(mailCreateDTO.getSubject());
//		mailquePo.setStatus(MailqueStatus.W.name());
//		mailqueDAO.insert(doXdaoSession, mailquePo);
//		return id;
		return null;
	}

	@Override
	public void send() {
		List<MailquePo> mails = mailqueDAO.queryMails();

		for (MailquePo mailquePo : mails) {
			MailFace face = MailqueWarpPo.newMailFace(mailquePo);
			MailBean mailBean = new MailBean(face);
			try {
				mailBean.sendMail();
				mailqueDAO.update(mailquePo.getMailId(), MailqueStatus.C);
			} catch (Exception e) {
				LOG.error("sendamil error", e);
				if (mailquePo.getStatus().equals(MailqueStatus.R.name())) {
					mailqueDAO.update(mailquePo.getMailId(), MailqueStatus.E);
				} else {
					mailqueDAO.update(mailquePo.getMailId(), MailqueStatus.R);
				}

			}
		}

	}

}
