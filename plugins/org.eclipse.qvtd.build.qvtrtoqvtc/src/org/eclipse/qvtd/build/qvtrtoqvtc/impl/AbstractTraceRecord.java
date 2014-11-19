package org.eclipse.qvtd.build.qvtrtoqvtc.impl;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.build.qvtrtoqvtc.CoreBindings;
import org.eclipse.qvtd.build.qvtrtoqvtc.PrimitivesBindings;
import org.eclipse.qvtd.build.qvtrtoqvtc.RelationsBindings;
import org.eclipse.qvtd.build.qvtrtoqvtc.TraceRecord;

public class AbstractTraceRecord implements TraceRecord {
	
	private boolean executed = false;
	private final @NonNull CoreBindings coreBindings;
	
	public AbstractTraceRecord(@NonNull CoreBindings coreBindings) {
		this.coreBindings = coreBindings;
	}
	
	public @NonNull CoreBindings getCoreBindings() {
		return coreBindings;
	}

	@Override
	public @NonNull PrimitivesBindings getPrimitivesBindings() {
		return coreBindings.getPrimitivesBindings();
	}

	@Override
	public @NonNull RelationsBindings getRelationsBindings() {
		return coreBindings.getRelationsBindings();
	}

	@Override
	public boolean hasExecuted() {
		return executed;
	}
	
	/**
	 * @param executed the executed to set
	 */
	public void setExecuted(boolean executed) {
		this.executed = executed;
	}
	
}
