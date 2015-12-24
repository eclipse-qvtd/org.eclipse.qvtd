/*******************************************************************************
 * Copyright (c) 2013 Willink Transformations and others.
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
 * from: org.eclipse.qvtd.pivot.qvtcorebase/model/QVTcoreBase.genmodel
 *
 * Only the copyright statement is editable.
 *******************************************************************************/
package	org.eclipse.qvtd.pivot.qvtcorebase.util;

import org.eclipse.jdt.annotation.NonNull;

/**
 */
public interface QVTcoreBaseVisitor<R> extends org.eclipse.qvtd.pivot.qvtbase.util.QVTbaseVisitor<R>
{
	R visitAssignment(org.eclipse.qvtd.pivot.qvtcorebase.@NonNull Assignment object);
	R visitBottomPattern(org.eclipse.qvtd.pivot.qvtcorebase.@NonNull BottomPattern object);
	R visitCoreDomain(org.eclipse.qvtd.pivot.qvtcorebase.@NonNull CoreDomain object);
	R visitCorePattern(org.eclipse.qvtd.pivot.qvtcorebase.@NonNull CorePattern object);
	R visitEnforcementOperation(org.eclipse.qvtd.pivot.qvtcorebase.@NonNull EnforcementOperation object);
	R visitGuardPattern(org.eclipse.qvtd.pivot.qvtcorebase.@NonNull GuardPattern object);
	R visitPropertyAssignment(org.eclipse.qvtd.pivot.qvtcorebase.@NonNull PropertyAssignment object);
	R visitRealizedVariable(org.eclipse.qvtd.pivot.qvtcorebase.@NonNull RealizedVariable object);
	R visitVariableAssignment(org.eclipse.qvtd.pivot.qvtcorebase.@NonNull VariableAssignment object);
}
