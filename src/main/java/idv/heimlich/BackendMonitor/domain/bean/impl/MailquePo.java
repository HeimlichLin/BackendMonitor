package idv.heimlich.BackendMonitor.domain.bean.impl;

public class MailquePo {
	
//	public static MapConverter<MailquePo> CONVERTER = new MapConverter<MailquePo>() {
//
//		@Override
//		public MailquePo convert(DataObject dataObject) {
//			final MailquePo vo = new MailquePo();
//			vo.setPgmId(dataObject.getString("PGM_ID"));
//			vo.setCreateDate(dataObject.getString("CREATE_DATE"));
//			vo.setSubject(dataObject.getString("SUBJECT"));
//			vo.setMailTo(dataObject.getString("MAIL_TO"));
//			vo.setMailCc(dataObject.getString("MAIL_CC"));
//			vo.setMailBcc(dataObject.getString("MAIL_BCC"));
//			vo.setMailFrom(dataObject.getString("MAIL_FROM"));
//			vo.setMessage(dataObject.getString("MESSAGE"));
//			vo.setRemarks(dataObject.getString("REMARKS"));
//			vo.setMailId(dataObject.getString("MAIL_ID"));
//			vo.setStatus(dataObject.getString("STATUS"));
//			vo.setSendDate(dataObject.getString("SEND_DATE"));
//			vo.setFilePath(dataObject.getString("FILE_PATH"));
//			return vo;
//		}
//
//		@Override
//		public DataObject toDataObject(MailquePo po) {
//			DataObject dataObject = new DataObject();
//			dataObject.setValue(MailquePo.COLUMNS.PGM_ID.name(), po.getPgmId());
//			dataObject.setValue(MailquePo.COLUMNS.CREATE_DATE.name(), po.getCreateDate());
//			dataObject.setValue(MailquePo.COLUMNS.SUBJECT.name(), po.getSubject());
//			dataObject.setValue(MailquePo.COLUMNS.MAIL_TO.name(), po.getMailTo());
//			dataObject.setValue(MailquePo.COLUMNS.MAIL_CC.name(), po.getMailCc());
//			dataObject.setValue(MailquePo.COLUMNS.MAIL_BCC.name(), po.getMailBcc());
//			dataObject.setValue(MailquePo.COLUMNS.MAIL_FROM.name(), po.getMailFrom());
//			dataObject.setValue(MailquePo.COLUMNS.MESSAGE.name(), po.getMessage());
//			dataObject.setValue(MailquePo.COLUMNS.REMARKS.name(), po.getRemarks());
//			dataObject.setValue(MailquePo.COLUMNS.MAIL_ID.name(), po.getMailId());
//			dataObject.setValue(MailquePo.COLUMNS.STATUS.name(), po.getStatus());
//			dataObject.setValue(MailquePo.COLUMNS.SEND_DATE.name(), po.getSendDate());
//			dataObject.setValue(MailquePo.COLUMNS.FILE_PATH.name(), po.getFilePath());
//			return dataObject;
//		}
//	};

	public enum COLUMNS {
		PGM_ID("產生程式", false), //
		CREATE_DATE("建立日期", false), //
		SUBJECT("信件主旨", false), //
		MAIL_TO("收件者,多筆以分號隔開", false), //
		MAIL_CC("副本", false), //
		MAIL_BCC("密件副本", false), //
		MAIL_FROM("寄件者", false), //
		MESSAGE("信件內容", false), //
		REMARKS("備註", false), //
		MAIL_ID("信件ID", true), //
		STATUS("狀態.W:等待,R:重送,C:完成", false), //
		SEND_DATE("寄件時間", false), //
		FILE_PATH("附件", false), //
		;//
		final String chineseName;
		final boolean isPK;

		private COLUMNS(String chineseName, boolean isPK) {
			this.chineseName = chineseName;
			this.isPK = isPK;
		}

		public String getChineseName() {
			return chineseName;
		}

		public boolean isPK() {
			return isPK;
		}
	}

	private String pgmId;// 產生程式
	private String createDate;// 建立日期
	private String subject;// 信件主旨
	private String mailTo;// 收件者,多筆以分號隔開
	private String mailCc;// 副本
	private String mailBcc;// 密件副本
	private String mailFrom;// 寄件者
	private String message;// 信件內容
	private String remarks;// 備註
	private String mailId;// 信件id
	private String status;// 狀態.w:等待,r:重送,c:完成
	private String sendDate;// 寄件時間
	private String filePath;// 附件

	public String getPgmId() {
		return this.pgmId;
	}

	public void setPgmId(String value) {
		this.pgmId = value;
	}

	public String getSubject() {
		return this.subject;
	}

	public void setSubject(String value) {
		this.subject = value;
	}

	public String getMailTo() {
		return this.mailTo;
	}

	public void setMailTo(String value) {
		this.mailTo = value;
	}

	public String getMailCc() {
		return this.mailCc;
	}

	public void setMailCc(String value) {
		this.mailCc = value;
	}

	public String getMailBcc() {
		return this.mailBcc;
	}

	public void setMailBcc(String value) {
		this.mailBcc = value;
	}

	public String getMailFrom() {
		return this.mailFrom;
	}

	public void setMailFrom(String value) {
		this.mailFrom = value;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String value) {
		this.message = value;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String value) {
		this.remarks = value;
	}

	public String getMailId() {
		return this.mailId;
	}

	public void setMailId(String value) {
		this.mailId = value;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String value) {
		this.status = value;
	}

	public String getFilePath() {
		return this.filePath;
	}

	public void setFilePath(String value) {
		this.filePath = value;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getSendDate() {
		return sendDate;
	}

	public void setSendDate(String sendDate) {
		this.sendDate = sendDate;
	}

}
