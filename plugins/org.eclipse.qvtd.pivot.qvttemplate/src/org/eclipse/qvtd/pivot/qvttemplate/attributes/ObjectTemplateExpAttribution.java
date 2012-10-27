/**
 * <copyright>
 *
 * Copyright (c) 2010,2011 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * $Id: EnumCSAttribution.java,v 1.3 2011/04/25 09:50:02 ewillink Exp $
 */
package org.eclipse.qvtd.pivot.qvttemplate.attributes;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.scoping.EnvironmentView;
import org.eclipse.ocl.examples.pivot.scoping.ScopeView;
import org.eclipse.qvtd.pivot.qvttemplate.ObjectTemplateExp;

public class ObjectTemplateExpAttribution extends TemplateExpAttribution
{
	public static final ObjectTemplateExpAttribution INSTANCE = new ObjectTemplateExpAttribution();

	@Override
	public ScopeView computeLookup(@NonNull EObject target, @NonNull EnvironmentView environmentView, @NonNull ScopeView scopeView) {
		ObjectTemplateExp targetElement = (ObjectTemplateExp)target;
		Type referredClass = targetElement.getReferredClass();
		if (referredClass != null) {
			environmentView.addAllProperties(referredClass, Boolean.FALSE);
		}
		return super.computeLookup(target, environmentView, scopeView);
	}
}
