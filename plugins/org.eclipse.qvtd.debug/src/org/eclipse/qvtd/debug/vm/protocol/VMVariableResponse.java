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
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.qvtd.debug.vm.VMVariable;


public class VMVariableResponse extends VMResponse {
	
	private static final long serialVersionUID = 4349537265414257787L;

	public final @NonNull VMVariable variable;
	public final @Nullable VMVariable[] childVariables;
	
	public VMVariableResponse(@NonNull VMVariable variable, @Nullable VMVariable[] childVariables) {
		this.variable = variable;
		this.childVariables = childVariables;
	}
	
	public VMVariableResponse(@NonNull VMVariable variable) {
		this(variable, null);
	}
	
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append(getClass().getSimpleName() + "(" + toStatusString(status));
		s.append(", ");
		s.append(variable);
		if (childVariables != null) {
			s.append(", {");
			for (int i = 0; i < childVariables.length; i++) {
				if (i > 0) {
					s.append(",");
				}
				s.append(childVariables[i]);
			}
			s.append("}");
		}
		return s.toString();
	}
}