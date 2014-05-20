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
 */
package org.eclipse.qvtd.xtext.qvtimperative.attributes;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.scoping.EnvironmentView;
import org.eclipse.ocl.examples.pivot.scoping.ScopeView;
import org.eclipse.ocl.examples.xtext.base.attributes.PivotCSAttribution;
import org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage;

public class MappingCSAttribution extends PivotCSAttribution
{
	public static final @NonNull MappingCSAttribution INSTANCE = new MappingCSAttribution();

	@Override
	public ScopeView computeLookup(@NonNull EObject target, @NonNull EnvironmentView environmentView, @NonNull ScopeView scopeView) {
		if (environmentView.accepts(QVTbasePackage.Literals.TRANSFORMATION)) {
			return scopeView.getRoot();
		}
		return super.computeLookup(target, environmentView, scopeView);
	}
}
