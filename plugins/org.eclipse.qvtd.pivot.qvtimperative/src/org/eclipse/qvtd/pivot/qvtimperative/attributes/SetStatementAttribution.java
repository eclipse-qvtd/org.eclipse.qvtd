/*******************************************************************************
 * Copyright (c) 2013, 2014 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtimperative.attributes;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.internal.scoping.EmptyAttribution;
import org.eclipse.ocl.pivot.internal.scoping.EnvironmentView;
import org.eclipse.ocl.pivot.internal.scoping.ScopeView;
import org.eclipse.qvtd.pivot.qvtimperative.SetStatement;

public class SetStatementAttribution extends EmptyAttribution
{
	public static final SetStatementAttribution INSTANCE = new SetStatementAttribution();

	@Override
	public ScopeView computeLookup(@NonNull EObject target, @NonNull EnvironmentView environmentView, @NonNull ScopeView scopeView) {
		SetStatement asSetStatement = (SetStatement)target;
		if (environmentView.getRequiredType() == PivotPackage.Literals.PROPERTY) {		// FIXME should be detecting ancestor
			environmentView.addElementsOfScope(asSetStatement.getSlotExpression().getType(), scopeView);
			return null;
		}
		else {
			return super.computeLookup(target, environmentView, scopeView);
		}
	}
}
