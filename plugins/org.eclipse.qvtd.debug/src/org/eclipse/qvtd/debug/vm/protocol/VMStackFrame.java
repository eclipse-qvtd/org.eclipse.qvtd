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

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

public class VMStackFrame implements Serializable
{
	private static final long serialVersionUID = -1055712783030253722L;

	private static class Loc implements VMLocation
	{
		private static final long serialVersionUID = 300982114845658039L;

		private final @NonNull VMStackFrame frame;
		
		private Loc(@NonNull VMStackFrame frame) {
			this.frame = frame;
		}
		
		public int getCharEnd() {
			return frame.charEnd;
		}
		
		public int getCharStart() {
			return frame.charStart;
		}
	
		/* (non-Javadoc)
		 * @see org.eclipse.m2m.qvt.oml.debug.core.vm.VMLocation#getLineNum()
		 */
		public int getLineNum() {
			return frame.lineNum;
		}
		
		/* (non-Javadoc)
		 * @see org.eclipse.m2m.qvt.oml.debug.core.vm.VMLocation#getURI()
		 */
		public String getURI() {
			return frame.uri;
		}
		
		/* (non-Javadoc)
		 * @see org.eclipse.m2m.qvt.oml.debug.core.vm.VMLocation#getModule()
		 */
		public String getModule() {
			return frame.module;
		}
		
		/* (non-Javadoc)
		 * @see org.eclipse.m2m.qvt.oml.debug.core.vm.VMLocation#getOperationSignature()
		 */
		public String getOperationSignature() {
			return frame.operationSignature;
		}
	}
	
	
	public long id;
	private String uri;
	private int lineNum;	
	private int charStart;	
	private int charEnd;	
	public String module;
	public String operationSignature;	
	public @Nullable VMVariable[] visibleVariables;
	
	private transient VMLocation location;	
	
	public VMStackFrame(long id, String uri, String module, String operationSignature, int line, int startPosition, int endPosition, @Nullable VMVariable[] vars) {
//		if(vars != null && (vars.length == 0 || Arrays.asList(vars).contains(null))) {
//			throw new IllegalArgumentException();
//		}

		this.id = id;
		this.uri = uri;
		this.module = module;
		this.operationSignature = operationSignature;
		this.visibleVariables = vars;
		this.lineNum = line;
		this.charStart = startPosition;
		this.charEnd = endPosition;
	}
	
	public synchronized @NonNull VMLocation getLocation() {
		VMLocation location2 = location;
		if (location2 == null) {
			location = location2 = new Loc(this);
		}
		return location2;
	}	
	
	public List<VMVariable> getVisibleVariables() {
		if(visibleVariables == null) {
			return Collections.emptyList();
		}
		return Arrays.asList(visibleVariables);
	}
	
	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append(getClass().getSimpleName());
		s.append("(").append(id);
		s.append(", ").append(uri);
		s.append(":").append(module);
		s.append(":").append(lineNum);
		s.append(":").append(charStart);
		s.append(", ").append(operationSignature);
		VMVariable[] visibleVariables2 = visibleVariables;
		if (visibleVariables2 != null) {
			s.append(", {");
			for (int i = 0; i < visibleVariables2.length; i++) {
				if (i > 0) {
					s.append(",");
				}
				s.append("\n\t\t");
				s.append(visibleVariables2[i]);
			}
			s.append("}");
		}
		s.append(")");
		return s.toString();
	}
}
