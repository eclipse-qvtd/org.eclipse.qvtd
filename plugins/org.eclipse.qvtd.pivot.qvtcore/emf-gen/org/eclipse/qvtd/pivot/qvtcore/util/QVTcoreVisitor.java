/*******************************************************************************
 * Copyright (c) 2013, 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 * 
 * </copyright>
 *
 * This code is auto-generated
 * from: org.eclipse.qvtd.pivot.qvtcore/model/QVTcore.genmodel
 *
 * Only the copyright statement is editable.
 *******************************************************************************/
package	org.eclipse.qvtd.pivot.qvtcore.util;

import org.eclipse.jdt.annotation.NonNull;

/**
 */
public interface QVTcoreVisitor<R> extends org.eclipse.qvtd.pivot.qvtbase.util.QVTbaseVisitor<R>
{
	R visitAssignment(org.eclipse.qvtd.pivot.qvtcore.@NonNull Assignment object);
	R visitBottomPattern(org.eclipse.qvtd.pivot.qvtcore.@NonNull BottomPattern object);
	R visitCoreDomain(org.eclipse.qvtd.pivot.qvtcore.@NonNull CoreDomain object);
	R visitCoreModel(org.eclipse.qvtd.pivot.qvtcore.@NonNull CoreModel object);
	R visitCorePattern(org.eclipse.qvtd.pivot.qvtcore.@NonNull CorePattern object);
	R visitEnforcementOperation(org.eclipse.qvtd.pivot.qvtcore.@NonNull EnforcementOperation object);
	R visitGuardPattern(org.eclipse.qvtd.pivot.qvtcore.@NonNull GuardPattern object);
	R visitMapping(org.eclipse.qvtd.pivot.qvtcore.@NonNull Mapping object);
	R visitNavigationAssignment(org.eclipse.qvtd.pivot.qvtcore.@NonNull NavigationAssignment object);
	R visitOppositePropertyAssignment(org.eclipse.qvtd.pivot.qvtcore.@NonNull OppositePropertyAssignment object);
	R visitPropertyAssignment(org.eclipse.qvtd.pivot.qvtcore.@NonNull PropertyAssignment object);
	R visitRealizedVariable(org.eclipse.qvtd.pivot.qvtcore.@NonNull RealizedVariable object);
	R visitVariableAssignment(org.eclipse.qvtd.pivot.qvtcore.@NonNull VariableAssignment object);
}
