package com.cem.serviceImpl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SystemInfoGetterService {
	@Value("${system.domain}")
	private String systemDomain;

	public String getSystemDomain() {
		return systemDomain;
	}

	public void setSystemDomain(String systemDomain) {
		this.systemDomain = systemDomain;
	}
}
