package idv.heimlich.BackendMonitor.domain.service;

import idv.heimlich.BackendMonitor.domain.dto.impl.MailCreateDTO;

public interface MailService {
	
	String create(MailCreateDTO mailCreateDTO);

	void send();

}
