package org.eclipse.qvt.declarative.test.common.mock;

import org.eclipse.qvt.declarative.common.framework.service.Operation;
import org.eclipse.qvt.declarative.common.framework.service.Provider;

public class FalseOperation implements Operation{

	@Override
	public Object execute(Provider provider) {
		return null;
	}

}
