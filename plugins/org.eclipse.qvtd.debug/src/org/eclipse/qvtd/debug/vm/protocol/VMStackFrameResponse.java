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

import org.eclipse.jdt.annotation.NonNull;

public class VMStackFrameResponse extends VMResponse
{
	private static final long serialVersionUID = -731807514003839012L;

	public final VMStackFrame[] frames;
	public final VMVariable[] variables;
	public boolean isDeferredExecution;
	
	public VMStackFrameResponse(@NonNull VMStackFrame frame) {
		this(new VMStackFrame[] { frame });
	}

	public VMStackFrameResponse(@NonNull VMStackFrame[] frames) {
		this.frames = frames; 
		this.variables = null;
	}
	
	public VMStackFrameResponse(@NonNull VMVariable[] variables) {
		this.variables = variables;
		this.frames = null;
	}
	
	public boolean isDeferredExecution() {
		return isDeferredExecution;
	}
	
	public VMStackFrame getFrame() {
		return frames != null && frames.length > 0 ? frames[0] : null;
	}
	
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append(getClass().getSimpleName() + "(" + toStatusString(status));
		if (frames != null) {
			s.append(", {");
			for (int i = 0; i < frames.length; i++) {
				if (i > 0) {
					s.append(",");
				}
				s.append("\n\t");
				s.append(frames[i]);
			}
			s.append("}");
		}
		if (variables != null) {
			s.append(", {");
			for (int i = 0; i < variables.length; i++) {
				if (i > 0) {
					s.append(",");
				}
				s.append("\n\t");
				s.append(variables[i]);
			}
			s.append("}");
		}
		s.append(", deferred = " + isDeferredExecution);
		return s.toString();
	}
}