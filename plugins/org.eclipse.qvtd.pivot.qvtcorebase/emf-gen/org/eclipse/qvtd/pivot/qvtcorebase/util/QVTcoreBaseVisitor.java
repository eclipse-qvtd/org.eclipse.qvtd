/**
 * <copyright>
 * 
 * Copyright (c) 2013 E.D.Willink and others.
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
 * Do not edit it.
 */
package	org.eclipse.qvtd.pivot.qvtcorebase.util;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 */
public interface QVTcoreBaseVisitor<R> extends org.eclipse.qvtd.pivot.qvtbase.util.QVTbaseVisitor<R>
{
	@Nullable R visitAssignment(@NonNull org.eclipse.qvtd.pivot.qvtcorebase.Assignment object);
	@Nullable R visitBottomPattern(@NonNull org.eclipse.qvtd.pivot.qvtcorebase.BottomPattern object);
	@Nullable R visitCoreDomain(@NonNull org.eclipse.qvtd.pivot.qvtcorebase.CoreDomain object);
	@Nullable R visitCorePattern(@NonNull org.eclipse.qvtd.pivot.qvtcorebase.CorePattern object);
	@Nullable R visitEnforcementOperation(@NonNull org.eclipse.qvtd.pivot.qvtcorebase.EnforcementOperation object);
	@Nullable R visitGuardPattern(@NonNull org.eclipse.qvtd.pivot.qvtcorebase.GuardPattern object);
	@Nullable R visitPropertyAssignment(@NonNull org.eclipse.qvtd.pivot.qvtcorebase.PropertyAssignment object);
	@Nullable R visitRealizedVariable(@NonNull org.eclipse.qvtd.pivot.qvtcorebase.RealizedVariable object);
	@Nullable R visitVariableAssignment(@NonNull org.eclipse.qvtd.pivot.qvtcorebase.VariableAssignment object);
}
