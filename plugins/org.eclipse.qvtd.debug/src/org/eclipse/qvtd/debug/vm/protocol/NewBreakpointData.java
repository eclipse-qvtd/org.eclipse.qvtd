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


public class NewBreakpointData extends BreakpointData
{
	private static final long serialVersionUID = -8614925057936040002L;

	public long ID;
	public int line = -1;
	public String targetURI;
	
	public NewBreakpointData() {
		super();
	}
	
	public NewBreakpointData(long id, int line, String targetURI, BreakpointData data) {
		super(data);
		this.ID = id;
		this.line = line;
		this.targetURI = targetURI;			
	}
}