/*******************************************************************************
 * Copyright (c) 2016, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtimperative.attributes;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.internal.scoping.EmptyAttribution;
import org.eclipse.ocl.pivot.internal.scoping.EnvironmentView;
import org.eclipse.ocl.pivot.internal.scoping.ScopeView;
import org.eclipse.ocl.pivot.utilities.FeatureFilter;
import org.eclipse.qvtd.pivot.qvtimperative.NewStatement;

public class NewStatementAttribution extends EmptyAttribution
{
	public static final @NonNull NewStatementAttribution INSTANCE = new NewStatementAttribution();

	@Override
	public ScopeView computeLookup(@NonNull EObject target, @NonNull EnvironmentView environmentView, @NonNull ScopeView scopeView) {
		NewStatement asNewStatement = (NewStatement)target;
		if (environmentView.getRequiredType() == PivotPackage.Literals.PROPERTY) {		// FIXME should be detecting ancestor
			Type asType = asNewStatement.getType();
			if (asType instanceof org.eclipse.ocl.pivot.Class) {
				environmentView.addAllProperties((org.eclipse.ocl.pivot.Class)asType, FeatureFilter.SELECT_NON_STATIC);
			}
			return null;
		}
		else {
			return super.computeLookup(target, environmentView, scopeView);
		}
	}
}
