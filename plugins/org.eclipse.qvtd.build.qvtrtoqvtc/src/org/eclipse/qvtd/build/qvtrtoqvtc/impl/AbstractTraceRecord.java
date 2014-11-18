package org.eclipse.qvtd.build.qvtrtoqvtc.impl;

import org.eclipse.qvtd.build.qvtrtoqvtc.Bindings;
import org.eclipse.qvtd.build.qvtrtoqvtc.TraceRecord;

public class AbstractTraceRecord implements TraceRecord {
	
	private boolean executed = false;
	private boolean partial = false;
	private Bindings bindings;
	
	
	public AbstractTraceRecord(Bindings bindings) {
		this.bindings = bindings;
	}

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
	
	
	
	public Bindings getBindings() {
		return bindings;
	}

	/**
	 * @return the partial
	 */
	public boolean isPartial() {
		return partial;
	}

	/**
	 * @param partial the partial to set
	 */
	public void setPartial(boolean partial) {
		this.partial = partial;
	}

	
	
	
}
