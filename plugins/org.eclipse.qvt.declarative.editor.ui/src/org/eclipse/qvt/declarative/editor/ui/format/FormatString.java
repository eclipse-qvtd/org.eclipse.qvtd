/*******************************************************************************
 * Copyright (c) 2008 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvt.declarative.editor.ui.format;


public final class FormatString extends AbstractFormatHelper<String>
{
	public static void initialize(IFormatManager manager) {
		manager.install(new FormatString(manager));		
	}
	
	public FormatString(IFormatManager manager) {
		super(manager, String.class);
	}

	public void format(IFormatResult s, String object) {
		s.append(object);
	}
}