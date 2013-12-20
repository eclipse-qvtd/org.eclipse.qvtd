package org.eclipse.qvtd.debug.core;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.qvtd.debug.QVTdDebugPlugin;

public class BreakpointError extends Status {
	
	public static final int BREAKPOINT_CONDITION_ERR = 200;
	
	private long fBreakpointID;
	private String fDetail;
	
	public BreakpointError(long breakpointID, String message, String detail) {
		super(IStatus.ERROR, QVTdDebugPlugin.PLUGIN_ID, BREAKPOINT_CONDITION_ERR, message, null);
		
		fBreakpointID = breakpointID;
		fDetail = detail;
	}
	
	public long getfBreakpointID() {
		return fBreakpointID;
	}
	
	public String getDetail() {
		return fDetail;
	}
}
