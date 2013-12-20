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

import java.util.List;


public class VMBreakpointResponse extends VMResponse {
	private static final long serialVersionUID = -3465458653297749248L;

	private long[] fAddedBreakpointsIDs;
	
	public VMBreakpointResponse() {
		super();
	}

	public VMBreakpointResponse(List<Long> addedBreakpointIDs) {
		if(addedBreakpointIDs == null || addedBreakpointIDs.contains(null)) {
			throw new IllegalArgumentException("invalid installed breakpoints"); //$NON-NLS-1$
		}
		
		fAddedBreakpointsIDs = new long[addedBreakpointIDs.size()];
		int i = 0;
		for (Long id : addedBreakpointIDs) {
			fAddedBreakpointsIDs[i++] = id.longValue();
		}
	}

	public long[] getAddedBreakpointsIDs() {
		return fAddedBreakpointsIDs != null ? fAddedBreakpointsIDs.clone() : new long[0];
	}
	
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append(getClass().getSimpleName() + "(" + toStatusString(status));
		s.append(", {");
		for (int i = 0; i < fAddedBreakpointsIDs.length; i++) {
			if (i > 0) {
				s.append(",");
			}
			s.append(fAddedBreakpointsIDs[i]);
		}
		s.append("}");
		return s.toString();
	}
}