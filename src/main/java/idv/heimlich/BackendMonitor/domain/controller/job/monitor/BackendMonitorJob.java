package idv.heimlich.BackendMonitor.domain.controller.job.monitor;

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import idv.heimlich.BackendMonitor.domain.dto.impl.BackendMonitorDTO;
import idv.heimlich.BackendMonitor.domain.dto.impl.MailCreateDTO;
import idv.heimlich.BackendMonitor.domain.service.MailService;
import idv.heimlich.BackendMonitor.domain.service.impl.MailServiceImpl;

/**
 * 檢查最舊當按超過預期未處理
 */
public class BackendMonitorJob implements Runnable {
	
	final String path;// 檔案路徑
	final String overTime;// 最舊處理時間超過
	final String regex;// 檔名規則
	final String overFiles;// 超過檔案限制數量
	final String doc;// 文件別
	private final static Logger LOG = LoggerFactory.getLogger(BackendMonitorJob.class);
	private MailService mailService = MailServiceImpl.get();
	
	public BackendMonitorJob(BackendMonitorDTO backendMonitorDTO) {//
		super();
		this.doc = backendMonitorDTO.getDoc();
		this.path = backendMonitorDTO.getPath();
		this.overTime = backendMonitorDTO.getOverTime();
		this.regex = backendMonitorDTO.getRegex();
		this.overFiles = backendMonitorDTO.getOverFiles();
	}

	@Override
	public void run() {
		LOG.info("run(PATH:{},OVERTIME:{},REGEX:{} OVERFILES:{})", this.path, this.overTime, this.regex, this.overFiles);

		final File folder = new File(this.path);
		final File[] fs = folder.listFiles(new FileFilter() {

			@Override
			public boolean accept(File pathname) {
				return pathname.getName().matches(regex);
			}
		});
		// /根據最後異動時間
		Arrays.sort(fs, new Comparator<File>() {
			public int compare(File f1, File f2) {
				long diff = f1.lastModified() - f2.lastModified();
				if (diff > 0)
					return 1;
				else if (diff == 0)
					return 0;
				else
					return -1;//
			}

			public boolean equals(Object obj) {
				return true;
			}

		});
		// 有一筆檔案
		if (fs.length > 0) {
			File firstFile = fs[0];
			boolean isOverTime = this.getIsOverTime(firstFile);
			boolean isOverFiles = this.getIsOverTime(fs, this.overFiles);
			if (isOverTime || isOverFiles) {

				String message = "";
				message += "通知原因：\n";
				if (isOverTime) {
					message += String.format("最舊檔案：%s已超過預計完成時間%s分以上\n", firstFile.getName(), overTime);
				}

				if (isOverFiles) {
					message += String.format("待處理檔案 總共為：%d筆已經超過限制數量：%s筆\n", fs.length, this.overFiles);
				}

				String callkillUrl = ""; // ApContext.getContext().getSetting("web-url")+ String.format("/rest/job/kill/%s", this.doc);
				message += "訊息資料：\n";
				message += String.format("資料路徑：%s\n", this.path);
				message += String.format("待處理筆數：%d\n", fs.length);
				message += String.format("呼叫：%s\n", callkillUrl);

				MailCreateDTO mailCreateDTO = new MailCreateDTO();
				mailCreateDTO.setFilePath("");
				mailCreateDTO.setMailBcc("");
				mailCreateDTO.setMailCc("");
				mailCreateDTO.setMailFrom(from());
				mailCreateDTO.setMailTo(to());
				mailCreateDTO.setMessage(message);
				mailCreateDTO.setPgmId(BackendMonitor.class.getSimpleName());
				mailCreateDTO.setRemarks("");
				mailCreateDTO.setSubject(subject());
				mailService.create(mailCreateDTO);
			}

		}
	}

	private boolean getIsOverTime(File[] fs, String overFiles) {
		return fs.length > Integer.parseInt(overFiles);
	}

	/**
	 * 是否逾時未處理
	 * 
	 * @param firstFile
	 * @return
	 */
	private boolean getIsOverTime(File firstFile) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MINUTE, -Integer.parseInt(this.overTime));
		// 超過逾期處理時間
		if (firstFile.lastModified() < calendar.getTimeInMillis()) {// 最舊一筆資料超過10分鐘未執行
			LOG.info("File name:{} is expired to execute....", firstFile.getName());
			return true;
		} else {
			LOG.info("File name:{} wait to doing", firstFile.getName());
		}
		return false;
	}

	// == [Method] Block Stop
	// ================================================
	// == [Inner Class] Block Start
	// == [Inner Class] Block Stop
	// ================================================

	public String to() {
//		final DoSqlWhere<SyscodeDo.COLUMNS> sqlWhere = new DoSqlWhere<SyscodeDo.COLUMNS>();
//		sqlWhere.add(SyscodeDo.COLUMNS.TYPE_ID, "MAIL");
//		sqlWhere.add(SyscodeDo.COLUMNS.CODE_ID, "A010");
//
//		final DoXdaoSession doXdaoSession = XdaoSessionManager.getDoXdaoSession();
//		final List<SyscodeDo> syscodeDos = doXdaoSession.selectPo(SyscodeDo.class, sqlWhere);
//		return this.syscodes2String(syscodeDos);
		return null;
	}

//	private String syscodes2String(final List<SyscodeDo> syscodeDos) {
//		final List<String> list = new ArrayList<String>();
//		for (final SyscodeDo syscodeDo : syscodeDos) {
//			list.add(syscodeDo.getCodeData2());
//		}
//		final String mailsString = StringUtils.join(list, ",");
//		LOG.debug("收信人員:" + mailsString);
//		return mailsString;
//	}

	public String from() {
		String from = ""; // ApContext.getContext().getSetting("owner_mail");
		LOG.info("form:{}", from);
		return from;
	}

	public String subject() {
		return path + "逾期未處理";
	}

	public String msg(String message) {
		return "because " + message;
	}

}
