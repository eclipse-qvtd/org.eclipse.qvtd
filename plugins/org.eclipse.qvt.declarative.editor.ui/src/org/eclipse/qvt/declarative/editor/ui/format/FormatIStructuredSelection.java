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

import java.util.Iterator;

import org.eclipse.jface.viewers.IStructuredSelection;

public final class FormatIStructuredSelection extends AbstractFormatHelper<IStructuredSelection>
{
	public static void initialize(IFormatManager manager) {
		manager.install(new FormatIStructuredSelection(manager));		
	}
	
	public FormatIStructuredSelection(IFormatManager manager) {
		super(manager, IStructuredSelection.class);
	}

	public void format(IFormatResult s, IStructuredSelection object) {
		if (object == null)
			s.append("<null-selection>");
		else if (object.size() == 0)
			s.append("<empty-selection>");
		else {
			Boolean first = true;
			s.append("{");
			for (Iterator<?> i = object.iterator(); i.hasNext(); ) {
				if (!first)
					s.append(",");
				else
					first = false;
				s.format(i.next());
			}
			s.append("}");
		}
	}
}