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

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.AnyType;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.internal.scoping.EnvironmentView;
import org.eclipse.ocl.pivot.internal.scoping.ScopeView;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.xtext.base.attributes.PathElementCSAttribution;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrelationUtil;
import org.eclipse.qvtd.xtext.qvtrelationcs.RelationCS;

public class QVTrelationPathElementCSAttribution extends PathElementCSAttribution
{
	public static final QVTrelationPathElementCSAttribution INSTANCE = new QVTrelationPathElementCSAttribution();

	@Override
	public ScopeView computeLookup(@NonNull EObject target, @NonNull EnvironmentView environmentView, @NonNull ScopeView scopeView) {
		String name = environmentView.getName();
		if (QVTrelationUtil.DUMMY_VARIABLE_NAME.equals(name)) {
			for (EObject eObject = target; eObject != null; eObject = eObject.eContainer()) {
				if (eObject instanceof RelationCS) {
					Relation relation = PivotUtil.getPivot(Relation.class, (RelationCS)eObject);
					if (relation != null) {
						List<Variable> variables = relation.getVariable();
						AnyType oclAnyType = environmentView.getStandardLibrary().getOclAnyType();
						String variableName = QVTrelationUtil.DUMMY_VARIABLE_NAME + variables.size();
						Variable asVariable = PivotUtil.createVariable(variableName, oclAnyType, true, null);
						asVariable.setIsImplicit(true);
						variables.add(asVariable);
						environmentView.addElement(QVTrelationUtil.DUMMY_VARIABLE_NAME, asVariable);
					}
					break;
				}
			}
			return null;
		}
//		else if (name == null) {
//			env
//		}
		return super.computeLookup(target, environmentView, scopeView);
	}
}
