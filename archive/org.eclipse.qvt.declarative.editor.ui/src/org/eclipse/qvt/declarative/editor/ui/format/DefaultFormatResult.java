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
package org.eclipse.qvt.declarative.editor.ui.format;

import java.util.Map;

/**
 * DefaultFormatResult builds the formatted description on behalf of a
 * IFormatManager using a StringBuilder.
 */
public class DefaultFormatResult extends AbstractFormatResult
{	
	protected final StringBuilder s = new StringBuilder();
	
	public DefaultFormatResult(IFormatManager manager, Map<IFormatOption<?>, Object> options) {
		super(manager, options);
	}

	public void append(String string) {
		s.append(string);
	}

	@Override
	public String toString() {
		return s.toString();
	}
}