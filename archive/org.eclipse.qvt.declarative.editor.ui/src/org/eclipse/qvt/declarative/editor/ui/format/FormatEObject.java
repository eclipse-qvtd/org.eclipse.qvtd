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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

public final class FormatEObject extends AbstractFormatHelper<EObject>
{
	public static void initialize(IFormatManager manager) {
		manager.install(new FormatEObject(manager));		
	}
	
	public FormatEObject(IFormatManager manager) {
		super(manager, EObject.class);
	}

	public void format(IFormatResult s, EObject object) {
		if (object.eIsProxy()) {
			manager.subformat(s, EcoreUtil.getURI(object));
			return;
		}
		if (object.eContainer() != null) {
			manager.subformat(s, object.eContainer());
			s.append("/");
		}
		s.append("<unnamed-");
		s.append(object.getClass().getSimpleName());
		s.append(">");
	}
}