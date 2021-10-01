package idv.heimlich.BackendMonitor.domain.dto.impl;

public class BackendMonitorDTO {
	
	private String path;// 檔案路徑
	private String overTime;// 最舊處理時間超過
	private String regex;// 檔名規則
	private String overFiles;// 超過檔案限制數量
	private String doc;// 文件別
	
	public void setPath(String path) {
		this.path = path;
	}

	public void setOverTime(String overTime) {
		this.overTime = overTime;
	}

	public void setRegex(String regex) {
		this.regex = regex;
	}

	public void setOverFiles(String overFiles) {
		this.overFiles = overFiles;
	}

	public void setDoc(String doc) {
		this.doc = doc;
	}

	public String getPath() {
		return path;
	}

	public String getOverTime() {
		return overTime;
	}

	public String getRegex() {
		return regex;
	}

	public String getOverFiles() {
		return overFiles;
	}

	public String getDoc() {
		return doc;
	}

}
