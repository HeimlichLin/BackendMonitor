package idv.heimlich.BackendMonitor.common.db;

public interface IDBSessionFactory {

	IDBSession getXdaoSession(String conn);

}
