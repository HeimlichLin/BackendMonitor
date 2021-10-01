package idv.heimlich.BackendMonitor.common.mail;

import java.util.Properties;
import java.util.StringTokenizer;

public class MailBean {
	
	private String[] to = null; // 收件人
	private String[] cc = null; // 副本收件人
	private String[] bcc = null; // 密送副本收件人
	private String from = ""; // 寄件人
	private String subject = ""; // 郵件主旨
	private String msgText = ""; // 郵件內容
	private String[] file = null; // 附加檔案

	// 建構子--開始

	public MailBean(MailFace face) {
		this.to = face.to() == null ? null : toArray(face.to());
		this.from = face.from();
		this.subject = ""; // ApContext.getContext().getSetting("env") + face.subject();
		this.msgText = face.msg();
		this.cc = face.cc() == null ? null : toArray(face.cc());
		this.file = face.files() == null ? null : face.files();
	}

	/**
	 * 執行主程式
	 * 
	 * @throws MessagingException
	 */
	public void sendMail() {
//		boolean sessionDebug = false;
//		Properties props = System.getProperties();
//		props.put("mail.smtp.host", "csmail2.tradevan.com.tw");
//		Session session = Session.getInstance(props, null);// Session.getDefaultInstance(props,
//		session.setDebug(sessionDebug);
//
//		// create a message
//		MimeMessage msg = new MimeMessage(session);
//		int count = 0;
//		// 設定收件人
//		if (to != null && from.trim().length() != 0) {
//			count = 0;
//			for (int i = 0; i < to.length; i++)
//				if (to[i] != null && to[i].length() != 0)
//					count++;
//
//			InternetAddress[] address = new InternetAddress[count];
//
//			for (int i = 0; i < count; i++) {
//				if (to[i] != null && to[i].length() != 0)
//					address[i] = new InternetAddress(to[i]);
//			}
//
//			msg.setRecipients(Message.RecipientType.TO, address);
//
//			// 設定副本收件人
//			if (cc != null) {
//				count = 0;
//				for (int i = 0; i < cc.length; i++)
//					if (cc[i] != null && cc[i].length() != 0)
//						count++;
//
//				InternetAddress[] ccaddress = new InternetAddress[count];
//
//				for (int i = 0; i < count; i++) {
//					if (cc[i] != null && cc[i].length() != 0)
//						ccaddress[i] = new InternetAddress(cc[i]);
//				}
//				msg.setRecipients(Message.RecipientType.CC, ccaddress);
//
//			}
//
//			// 設定密件副本收件人
//			if (bcc != null) {
//				count = 0;
//				for (int i = 0; i < bcc.length; i++)
//					if (bcc[i] != null && bcc[i].length() != 0)
//						count++;
//
//				InternetAddress[] bccaddress = new InternetAddress[count];
//
//				for (int i = 0; i < count; i++) {
//					if (bcc[i] != null && bcc[i].length() != 0)
//						bccaddress[i] = new InternetAddress(bcc[i]);
//
//				}
//				msg.setRecipients(Message.RecipientType.BCC, bccaddress);
//
//			}
//
//			// 設定寄件人
//			msg.setFrom(new InternetAddress(from));
//
//			// 設定郵件主旨
//			msg.setSubject(subject);
//
//			// 設定寄件日期
//			msg.setSentDate(new Date());
//			// 若無附加檔案,則加入郵件內容後寄送
//			if (file == null)
//				// msg.setText(msgText); //純文字
//				msg.setContent(msgText, "text/html;charset=UTF-8"); // HTML+CSS+JAVASCRIPT
//			else {
//				// create and fill the first message part
//				MimeBodyPart[] mbp = new MimeBodyPart[file.length + 1];
//				FileDataSource[] fds = new FileDataSource[file.length];
//				// create the Multipart and its parts to it
//				Multipart mp = new MimeMultipart();
//
//				for (int i = 0; i < file.length + 1; i++) {
//					mbp[i] = new MimeBodyPart();
//					if (i == 0)
//						mbp[i].setText(msgText);
//					else {
//
//						// . 設定附加檔案
//						// . 附加檔案暫只限於同台機器上之檔案
//						// . 附加檔案必須包含完整之實際路徑之字串
//						fds[i - 1] = new FileDataSource(file[i - 1]);
//						mbp[i].setDataHandler(new DataHandler(fds[i - 1]));
//						mbp[i].setFileName(fds[i - 1].getName());
//					}
//					mp.addBodyPart(mbp[i]);
//				}
//				// 將郵件內容及附加檔案加入郵件
//				msg.setContent(mp);
//			}
//
//			// 寄送郵件
//			Transport.send(msg);
//		}

	}

	/**
	 * 設定密件副本收件人
	 * 
	 * @param String
	 *            單筆或多筆電子郵件地址字串(需以分號隔開)
	 */
	public void setBCC(String bcc) {
		this.bcc = toArray(bcc);
	}

	/**
	 * 設定密件副本收件人
	 * 
	 * @param String
	 *            [] 單筆或多筆電子郵件地址陣列
	 */
	public void setBCC(String[] bcc) {
		this.bcc = bcc;
	}

	/**
	 * 設定副本收件人
	 * 
	 * @param String
	 *            單筆或多筆電子郵件地址字串(需以分號隔開)
	 */
	public void setCC(String cc) {
		this.cc = toArray(cc);
	}

	/**
	 * 設定副本收件人
	 * 
	 * @param String
	 *            [] 單筆或多筆電子郵件地址陣列
	 */
	public void setCC(String[] cc) {
		this.cc = cc;
	}

	/**
	 * 設定附加檔案
	 * 
	 * @param String
	 *            [] 單筆或多筆檔案之完整實體路徑名稱陣列
	 */

	public void setFile(String[] file) {
		this.file = file;
	}

	/**
	 * 將以分號分隔的多個電子郵件位址,拆解塞入陣列內
	 * 
	 * @param String
	 *            電子郵件位址字串
	 */
	private String[] toArray(String str) {
		String[] tmpArr = null;
		String first = "yes";
		String temp = "";
		int count = 0;
		if (str.trim().length() != 0) {
			StringTokenizer st = new StringTokenizer(str);
			while (st.hasMoreTokens()) {
				temp = st.nextToken(",");
				if (first.equals("yes")) {
					count = st.countTokens();
					tmpArr = new String[count + 1];
					first = "no";
				}
				tmpArr[count - st.countTokens()] = temp;
			}
		}
		return tmpArr;
	}

}
