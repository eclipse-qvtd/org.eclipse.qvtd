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

import java.util.Arrays;
import java.util.Collections;
import java.util.List;



public class VMBreakpointRequest extends VMRequest {

	public static enum ActionKind {
		ADD,
		REMOVE,
		CHANGE
	}	
	
	private static final long serialVersionUID = -313847657694333827L;
	
	private final long fBreakpointID;
	private final ActionKind actionKind;	
	private final BreakpointData data[];
	
	
	private VMBreakpointRequest(long uniqueID, ActionKind actionKind) {
		this.actionKind = actionKind;
		this.fBreakpointID = uniqueID;
		this.data = null;
	}
	
	private VMBreakpointRequest(long uniqueID, BreakpointData data[], ActionKind actionKind) {
		this.actionKind = actionKind;
		this.data = data;
		this.fBreakpointID = uniqueID;
	}
	
	public long getBreakpointID() {
		return fBreakpointID;
	}

	public ActionKind getActionKind() {
		return actionKind;
	}
	
	public List<BreakpointData> getBreakpointData() {
		return Collections.unmodifiableList(Arrays.asList(data));
	}
	
	public BreakpointData getFirstBreakpointData() {
		return data != null && data.length > 0 ? data[0] : null;
	}
	
	@Override
	public String toString() {	
		return getClass().getSimpleName() + "(fBreakpointID:" + fBreakpointID + " action:" + actionKind + ")"; //$NON-NLS-1$ //$NON-NLS-2$
	}
	
	public static VMBreakpointRequest createRemove(long id) {
		return new VMBreakpointRequest(id, ActionKind.REMOVE);
	}

	public static VMBreakpointRequest createAdd(NewBreakpointData[] bpData) {
		return new VMBreakpointRequest(-1, bpData, ActionKind.ADD);
	}
	
	public static VMBreakpointRequest createAdd(NewBreakpointData bpData) {
		return new VMBreakpointRequest(-1, new NewBreakpointData[] { bpData }, ActionKind.ADD);
	}	

	public static VMBreakpointRequest createChange(long id, BreakpointData bpData) {
		return new VMBreakpointRequest((long)-1, new BreakpointData[] { bpData }, ActionKind.CHANGE);
	}	
}