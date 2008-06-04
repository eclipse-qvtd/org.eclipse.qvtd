package org.eclipse.qvt.declarative.test.common.mock;

import org.eclipse.qvt.declarative.common.framework.service.Provider;

public interface JobProvider extends Provider {
	
	public String doJob(String operationName);

}
