package org.eclipse.qvt.declarative.test.common.mock;

import org.eclipse.qvt.declarative.common.framework.service.Operation;

public class DummyProvider implements JobProvider {

	public static final String ACCOMPLISHMENT = " done";
	
	@Override
	public boolean provides(Operation operation) {
		if (operation instanceof FakeOperation) {
			return true;
		}
		return false;
	}
	
	@Override
	public String doJob(String operationName) {
		return operationName+ ACCOMPLISHMENT;
	}

}
