package idv.heimlich.BackendMonitor.common.mail;

import idv.heimlich.BackendMonitor.domain.bean.impl.MailquePo;

public class MailqueWarpPo implements MailFace {
	
	public MailquePo mailquePo;
	
	protected MailqueWarpPo(MailquePo mailquePo) {
		super();
		this.mailquePo = mailquePo;
	}

	public static MailFace newMailFace(MailquePo mailquePo) {
		return new MailqueWarpPo(mailquePo);
	}
	
	@Override
	public String to() {
		return mailquePo.getMailTo();
	}

	@Override
	public String from() {
		return mailquePo.getMailFrom();
	}

	@Override
	public String subject() {
		return mailquePo.getSubject();
	}

	@Override
	public String msg() {
		return mailquePo.getMessage();
	}

	@Override
	public String cc() {
		return mailquePo.getMailCc();
	}

	@Override
	public String[] files() {
		String filePath = mailquePo.getFilePath();
		return filePath == null ? new String[] {} : filePath.split(",");
	}

}
