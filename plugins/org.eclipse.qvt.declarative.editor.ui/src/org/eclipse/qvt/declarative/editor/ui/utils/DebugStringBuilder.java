/*******************************************************************************
 * Copyright (c) 2007 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvt.declarative.editor.ui.utils;



/**
 * DebugStringBuilder builds the debug string on behalf of a DebugString.
 */
public class DebugStringBuilder
{	
	protected final DebugString debugUtils;
	protected final StringBuilder s = new StringBuilder();
	
	public DebugStringBuilder(DebugString debugUtils) {
		this.debugUtils = debugUtils;
	}

	public void append(String string) {
		s.append(string);
	}

	public void debug(Object object) {
		debugUtils.debug(this, object);
	}

	@Override
	public String toString() {
		return s.toString();
	}	
}