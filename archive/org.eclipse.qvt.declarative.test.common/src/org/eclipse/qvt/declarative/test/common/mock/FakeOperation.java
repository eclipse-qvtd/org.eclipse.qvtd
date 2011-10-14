package org.eclipse.qvt.declarative.test.common.mock;

import org.eclipse.qvt.declarative.common.framework.service.Operation;
import org.eclipse.qvt.declarative.common.framework.service.Provider;

public class FakeOperation implements Operation {
	
	public static final String OPERATION_NAME = "fake operation";

	@Override
	public Object execute(Provider provider) {
		if (provider instanceof DummyProvider) {
			DummyProvider dummyProvider = (DummyProvider) provider;
			return dummyProvider.doJob(OPERATION_NAME);
		}
		return null;
	}

}
