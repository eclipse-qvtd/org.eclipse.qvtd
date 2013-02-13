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
 * This code is auto-generated
 * from: /org.eclipse.qvtd.pivot.qvtcore/model/QVTcore.ecore
 * by: org.eclipse.ocl.examples.build.acceleo.GenerateVisitor
 * defined by: org.eclipse.ocl.examples.build.acceleo.generateVisitors.mtl
 * invoked by: org.eclipse.ocl.examples.build.utilities.*
 * from: org.eclipse.ocl.examples.build.*.mwe2
 *
 * Do not edit it.
 *
 * $Id$
 */
package	org.eclipse.qvtd.pivot.qvtcore.util;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 */
public interface QVTcoreVisitor<R> extends org.eclipse.qvtd.pivot.qvtbase.util.QVTbaseVisitor<R>
{
	@Nullable R visitAssignment(@NonNull org.eclipse.qvtd.pivot.qvtcore.Assignment object);
	@Nullable R visitBottomPattern(@NonNull org.eclipse.qvtd.pivot.qvtcore.BottomPattern object);
	@Nullable R visitCoreDomain(@NonNull org.eclipse.qvtd.pivot.qvtcore.CoreDomain object);
	@Nullable R visitCoreModel(@NonNull org.eclipse.qvtd.pivot.qvtcore.CoreModel object);
	@Nullable R visitCorePattern(@NonNull org.eclipse.qvtd.pivot.qvtcore.CorePattern object);
	@Nullable R visitEnforcementOperation(@NonNull org.eclipse.qvtd.pivot.qvtcore.EnforcementOperation object);
	@Nullable R visitGuardPattern(@NonNull org.eclipse.qvtd.pivot.qvtcore.GuardPattern object);
	@Nullable R visitMapping(@NonNull org.eclipse.qvtd.pivot.qvtcore.Mapping object);
	@Nullable R visitMappingCall(@NonNull org.eclipse.qvtd.pivot.qvtcore.MappingCall object);
	@Nullable R visitMappingCallBinding(@NonNull org.eclipse.qvtd.pivot.qvtcore.MappingCallBinding object);
	@Nullable R visitPropertyAssignment(@NonNull org.eclipse.qvtd.pivot.qvtcore.PropertyAssignment object);
	@Nullable R visitRealizedVariable(@NonNull org.eclipse.qvtd.pivot.qvtcore.RealizedVariable object);
	@Nullable R visitVariableAssignment(@NonNull org.eclipse.qvtd.pivot.qvtcore.VariableAssignment object);
}
