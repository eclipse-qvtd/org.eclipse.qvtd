/*******************************************************************************
 * Copyright (c) 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtrelation.scoping;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableExp;
import org.eclipse.ocl.pivot.internal.scoping.AbstractAttribution;
import org.eclipse.ocl.pivot.internal.scoping.EnvironmentView;
import org.eclipse.ocl.pivot.internal.scoping.ScopeView;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.qvtd.xtext.qvtrelationcs.ElementTemplateCS;

public class ElementTemplateCSAttribution extends AbstractAttribution
{
	public static final ElementTemplateCSAttribution INSTANCE = new ElementTemplateCSAttribution();

	@Override
	public ScopeView computeLookup(@NonNull EObject target, @NonNull EnvironmentView environmentView, @NonNull ScopeView scopeView) {
		Element asElement = PivotUtil.getPivot(Element.class, (ElementTemplateCS)target);
		String name = environmentView.getName();
		if (name != null) {
			if (asElement instanceof VariableExp) {
				environmentView.addElement(name, ((VariableExp)asElement).getReferredVariable());
			}
			else if (asElement instanceof Variable) {
				environmentView.addElement(name, asElement);
			}
		}
		return null;
	}
}
