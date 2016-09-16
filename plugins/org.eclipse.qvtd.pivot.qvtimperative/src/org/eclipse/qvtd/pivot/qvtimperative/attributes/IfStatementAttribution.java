/*******************************************************************************
 * Copyright (c) 2014 Willink Transformations and others.
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
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.internal.scoping.AbstractAttribution;
import org.eclipse.ocl.pivot.internal.scoping.EnvironmentView;
import org.eclipse.ocl.pivot.internal.scoping.ScopeView;
import org.eclipse.qvtd.pivot.qvtimperative.IfStatement;
import org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage;
import org.eclipse.qvtd.pivot.qvtimperative.Statement;
import org.eclipse.qvtd.pivot.qvtimperative.VariableStatement;

public class IfStatementAttribution extends AbstractAttribution
{
	public static final IfStatementAttribution INSTANCE = new IfStatementAttribution();

	@Override
	public ScopeView computeLookup(@NonNull EObject target, @NonNull EnvironmentView environmentView, @NonNull ScopeView scopeView) {
		IfStatement ifStatement = (IfStatement)target;
		EStructuralFeature containmentFeature = scopeView.getContainmentFeature();
		if (containmentFeature == QVTimperativePackage.Literals.IF_STATEMENT__OWNED_THEN_STATEMENTS) {
			EObject child = scopeView.getChild();
			for (Statement asStatement : ifStatement.getOwnedThenStatements()) {
				if (asStatement == child) {
					break;
				}
				if (asStatement instanceof VariableStatement) {
					environmentView.addNamedElement(asStatement);
				}
			}
		}
		else if (containmentFeature == QVTimperativePackage.Literals.IF_STATEMENT__OWNED_ELSE_STATEMENTS) {
			EObject child = scopeView.getChild();
			for (Statement asStatement : ifStatement.getOwnedElseStatements()) {
				if (asStatement == child) {
					break;
				}
				if (asStatement instanceof VariableStatement) {
					environmentView.addNamedElement(asStatement);
				}
			}
		}
		return scopeView.getParent();
	}
}
