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

public class BreakpointData implements Serializable
{
	private static final long serialVersionUID = 2199378435188939811L;

	public String condition;
	public boolean conditionEnabled;
	public boolean conditionSuspendOnTrue;
	public int hitCount;
	
	public BreakpointData() {
		super();
	}
	
	public BreakpointData(BreakpointData data) {
		this.condition = data.condition;
		this.conditionEnabled = data.conditionEnabled;
		this.conditionSuspendOnTrue = data.conditionSuspendOnTrue;
		this.hitCount = data.hitCount;
	}
	
}