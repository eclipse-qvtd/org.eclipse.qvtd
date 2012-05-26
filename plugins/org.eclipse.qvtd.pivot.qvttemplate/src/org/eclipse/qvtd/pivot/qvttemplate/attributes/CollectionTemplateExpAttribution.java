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
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.VariableExp;
import org.eclipse.ocl.examples.pivot.scoping.EnvironmentView;
import org.eclipse.ocl.examples.pivot.scoping.ScopeView;
import org.eclipse.qvtd.pivot.qvttemplate.CollectionTemplateExp;

public class CollectionTemplateExpAttribution extends TemplateExpAttribution
{
	public static final CollectionTemplateExpAttribution INSTANCE = new CollectionTemplateExpAttribution();

	@Override
	public ScopeView computeLookup(EObject target, EnvironmentView environmentView, ScopeView scopeView) {
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
