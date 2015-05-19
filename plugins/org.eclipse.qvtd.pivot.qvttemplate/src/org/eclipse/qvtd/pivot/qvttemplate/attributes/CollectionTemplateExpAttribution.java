/*******************************************************************************
 * Copyright (c) 2010, 2014 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvttemplate.attributes;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableExp;
import org.eclipse.ocl.pivot.internal.scoping.EnvironmentView;
import org.eclipse.ocl.pivot.internal.scoping.ScopeView;
import org.eclipse.qvtd.pivot.qvttemplate.CollectionTemplateExp;

public class CollectionTemplateExpAttribution extends TemplateExpAttribution
{
	public static final CollectionTemplateExpAttribution INSTANCE = new CollectionTemplateExpAttribution();

	@Override
	public ScopeView computeLookup(@NonNull EObject target, @NonNull EnvironmentView environmentView, @NonNull ScopeView scopeView) {
		CollectionTemplateExp targetElement = (CollectionTemplateExp)target;
		for (OCLExpression member : targetElement.getMember()) {
			if (member instanceof VariableExp) {
				Variable variable = (Variable) ((VariableExp)member).getReferredVariable();
				if ((variable != null) && (variable.getName() != null)) {
					environmentView.addNamedElement(variable);
				}
			}
		}
		Variable variable = targetElement.getRest();
		if ((variable != null) && (variable.getName() != null)) {
			environmentView.addNamedElement(variable);
		}
		return super.computeLookup(target, environmentView, scopeView);
	}
}
