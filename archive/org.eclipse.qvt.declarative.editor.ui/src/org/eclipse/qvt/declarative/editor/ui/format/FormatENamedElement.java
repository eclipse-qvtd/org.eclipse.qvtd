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

import org.eclipse.emf.ecore.ENamedElement;

public final class FormatENamedElement extends AbstractFormatHelper<ENamedElement>
{
	public static void initialize(IFormatManager manager) {
		manager.install(new FormatENamedElement(manager));		
	}
	
	public FormatENamedElement(IFormatManager manager) {
		super(manager, ENamedElement.class);
	}

	public void format(IFormatResult s, ENamedElement object) {
		if (object.eContainer() != null) {
			manager.subformat(s, object.eContainer());
			s.append("/");
		}
		String name = object.getName();
		if (name != null)
			s.append(name);
		else {
			s.append("<null-named-");
			s.append(object.getClass().getSimpleName());
			s.append(">");
		}
	}
}