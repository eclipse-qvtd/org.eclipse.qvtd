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

import org.eclipse.qvtd.debug.vm.VMStackFrame;
import org.eclipse.qvtd.debug.vm.VMVariable;



public class VMStackFrameResponse extends VMResponse {

	private static final long serialVersionUID = 5164097654623010310L;

	public final VMStackFrame[] frames;
	public final VMVariable[] variables;
	public boolean isDeferredExecution;
	
	public VMStackFrameResponse(VMStackFrame frame) {
		this(new VMStackFrame[] { frame });
	}

	public VMStackFrameResponse(VMStackFrame[] frames) {
		this.frames = frames; 
		this.variables = null;
	}
	
	public VMStackFrameResponse(VMVariable[] variables) {
		this.variables = variables;
		this.frames = null;
	}
	
	public boolean isDeferredExecution() {
		return isDeferredExecution;
	}
	
	public VMStackFrame getFrame() {
		return frames != null && frames.length > 0 ? frames[0] : null;
	}
	
}