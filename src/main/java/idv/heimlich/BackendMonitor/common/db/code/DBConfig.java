package idv.heimlich.BackendMonitor.common.db.code;

import idv.heimlich.BackendMonitor.common.db.AbstractDBSessionManager;
import idv.heimlich.BackendMonitor.common.db.DBSessionFTZBManager;
import idv.heimlich.BackendMonitor.common.db.DBSessionManager;
import idv.heimlich.BackendMonitor.common.db.IDBSession;


public enum DBConfig {
	
	PFTZBPool {
		@Override
		public AbstractDBSessionManager getDBSessionManager() {
			return new DBSessionFTZBManager();
		}
		
	},
	PCLMSPool {
		@Override
		public AbstractDBSessionManager getDBSessionManager() {
			return new DBSessionManager();
		}
	
	},

	;
	final String connid;

	private DBConfig() {
		this.connid = name();
	}

	 public abstract AbstractDBSessionManager getDBSessionManager();
	 
	 public IDBSession getXdaoSession(){
		 return this.getDBSessionManager().getDBSession();
	 }

}
