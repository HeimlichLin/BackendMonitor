package idv.heimlich.BackendMonitor.domain.controller.job.monitor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import idv.heimlich.BackendMonitor.domain.dto.impl.BackendMonitorDTO;

/**
 * Backend監控程式
 */
public class BackendMonitor {
	
	private final static Logger LOG = LoggerFactory.getLogger(BackendMonitor.class);
	
	private String config = "";

	public BackendMonitor(String config) { // /APCLMS/JAVA/com/tradevan/clms/job/monitor/
		super();
		this.config = config;
	}

	public static void main(String[] args) {
		final String pathString = BackendMonitor.class.getPackage().getName()
				.replaceAll("\\.", "\\/");
		String path = BackendMonitor.class.getClassLoader()
				.getResource(pathString).getFile();
		LOG.info("load config path:{}", path);
		if (args.length >= 1) {
			path = args[0];
		}
		new BackendMonitor(path).doCheck();
	}

	public void doCheck() {
		LOG.debug("BackendMonitor execute.. ");
		final File folder = new File(config);
		final File[] fs = folder.listFiles(new FilenameFilter() {

			@Override
			public boolean accept(File dir, String name) {
				return name.endsWith(".properties");
			}
		});
		// 讀取設定檔案
		final List<BackendMonitorJob> jobs = new ArrayList<BackendMonitorJob>();
		LOG.debug("load properties beging.. ");
		for (final File f : fs) {
			LOG.info("load properties:{}", f);
			final Properties prop = new Properties();
			try {
				prop.load(new FileInputStream(f));
				final String path = prop.getProperty("path");
				final String overTime = prop.getProperty("overTime");
				final String regex = prop.getProperty("regex");
				final String overFiles = prop.getProperty("overFiles");
				final String doc = prop.getProperty("doc");

				BackendMonitorDTO backendMonitorDTO = new BackendMonitorDTO();
				backendMonitorDTO.setPath(path);
				backendMonitorDTO.setOverTime(overTime);
				backendMonitorDTO.setRegex(regex);
				backendMonitorDTO.setOverFiles(overFiles);
				backendMonitorDTO.setDoc(doc);
				jobs.add(new BackendMonitorJob(backendMonitorDTO));
			} catch (Exception e) {
				LOG.error("load properties error file:{}", f, e);
			}

		}
		for (final BackendMonitorJob job : jobs) {
			try {
				job.run();
			} catch (Exception e) {
				LOG.error("job run error:{}", job, e);
			}
		}
	}

}
