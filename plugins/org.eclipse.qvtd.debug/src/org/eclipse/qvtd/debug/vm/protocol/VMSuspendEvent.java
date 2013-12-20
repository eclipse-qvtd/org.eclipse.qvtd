/*******************************************************************************
 * Copyright (c) 2009 R.Dvorak and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Radek Dvorak - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.debug.vm.protocol;

import org.eclipse.debug.core.DebugEvent;
import org.eclipse.qvtd.debug.vm.VMLocation;
import org.eclipse.qvtd.debug.vm.VMStackFrame;

public class VMSuspendEvent extends VMEvent {

	private static final long serialVersionUID = -2117406291312177660L;

	public static final int BREAKPOINT_CONDITION_ERR = DebugEvent.MODEL_SPECIFIC + 10;

	public VMLocation location;
	public VMStackFrame[] stackFrames;
	public Long breakpointID;

	// TODO - currently using DebugEvent constants, QVTO should define its own
	public int detail;
	
	public String reason;
	public String reasonDetail;

	public VMSuspendEvent(VMStackFrame[] stack, int detail) {
		if(stack == null || stack.length == 0) {
			throw new IllegalArgumentException("empty stack"); //$NON-NLS-1$
		}
		
		this.stackFrames = stack;
		this.location = stack[0].getLocation();
		this.detail = detail;
	}
		
	public Long getBreakpointID() {
		return breakpointID;
	}
	
	public void setBreakpointID(Long breakpointID) {
		this.breakpointID = breakpointID;
	}
	
	public void setReason(String reason, String reasonDetail) {
		if(reason == null && reasonDetail != null) {
			throw new IllegalArgumentException();
		}
		this.reason = reason;
		this.reasonDetail = reasonDetail;
	}
	
	public String getReason() {
		return reason;
	}
	
	public String getReasonDetail() {
		return reasonDetail;
	}

	public void setReasonDetail(String reasonDetail) {
		this.reasonDetail = reasonDetail;
	}
	
	@Override
	public String toString() {
		StringBuilder buf = new StringBuilder();
		buf.append(getClass().getSimpleName());
		buf.append(" detail:").append(detail); //$NON-NLS-1$
		if(breakpointID != null) {
			buf.append(" breakpointID:").append(breakpointID); //$NON-NLS-1$
		}
		if(reason != null) {
			buf.append(" reason:").append( //$NON-NLS-1$
					reason.substring(0, Math.min(50, reason.length())));
		}
		return buf.toString();
	}
}