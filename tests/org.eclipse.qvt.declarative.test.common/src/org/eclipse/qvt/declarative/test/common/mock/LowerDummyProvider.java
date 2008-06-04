package org.eclipse.qvt.declarative.test.common.mock;

import org.eclipse.qvt.declarative.common.framework.service.Operation;

public class LowerDummyProvider implements JobProvider {

	@Override
	public String doJob(String operationName) {
		return null;
	}

	@Override
	public boolean provides(Operation operation) {
		return true;
	}

}
