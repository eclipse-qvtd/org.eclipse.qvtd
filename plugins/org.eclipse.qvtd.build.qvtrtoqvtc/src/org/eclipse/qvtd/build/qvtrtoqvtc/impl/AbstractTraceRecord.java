package org.eclipse.qvtd.build.qvtrtoqvtc.impl;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.qvtd.build.qvtrtoqvtc.ConstrainedRule;
import org.eclipse.qvtd.build.qvtrtoqvtc.TraceRecord;

public abstract class AbstractTraceRecord implements TraceRecord {
	
	boolean executed = false;
	
	
	@Override
	public boolean wasExecuted() {
		return executed;
	}
	
	/**
	 * @param executed the executed to set
	 */
	public void wasExecuted(boolean executed) {
		this.executed = executed;
	}
	
	public boolean matches(ConstrainedRule rule, List<Object> inputElements) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
