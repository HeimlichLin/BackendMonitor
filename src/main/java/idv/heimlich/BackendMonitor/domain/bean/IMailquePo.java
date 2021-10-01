package idv.heimlich.BackendMonitor.domain.bean;

//系統Mail傳送記錄
public interface IMailquePo {

	// get產生程式
	public String getPgmId();

	// set產生程式
	public void setPgmId(String pgmId);

	// get建立日期
	public String getCreateDate();

	// set建立日期
	public void setCreateDate(String createDate);

	// get信件主旨
	public String getSubject();

	// set信件主旨
	public void setSubject(String subject);

	// get收件者,多筆以分號隔開
	public String getMailTo();

	// set收件者,多筆以分號隔開
	public void setMailTo(String mailTo);

	// get副本
	public String getMailCc();

	// set副本
	public void setMailCc(String mailCc);

	// get密件副本
	public String getMailBcc();

	// set密件副本
	public void setMailBcc(String mailBcc);

	// get寄件者
	public String getMailFrom();

	// set寄件者
	public void setMailFrom(String mailFrom);

	// get信件內容
	public String getMessage();

	// set信件內容
	public void setMessage(String message);

	// get備註
	public String getRemarks();

	// set備註
	public void setRemarks(String remarks);

	// get信件ID
	public String getMailId();

	// set信件ID
	public void setMailId(String mailId);

	// get狀態.W:等待,R:重送,C:完成
	public String getStatus();

	// set狀態.W:等待,R:重送,C:完成
	public void setStatus(String status);

	// get寄件時間
	public String getSendDate();

	// set寄件時間
	public void setSendDate(String sendDate);

	// get附件
	public String getFilePath();

	// set附件
	public void setFilePath(String filePath);

}
