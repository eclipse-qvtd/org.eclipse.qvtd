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

/**
 */
public interface QVTcoreVisitor<R, C> extends org.eclipse.qvtd.pivot.qvtbase.util.QVTbaseVisitor<R, C>
{
	R visitAssignment(org.eclipse.qvtd.pivot.qvtcore.Assignment object);
	R visitBottomPattern(org.eclipse.qvtd.pivot.qvtcore.BottomPattern object);
	R visitCoreDomain(org.eclipse.qvtd.pivot.qvtcore.CoreDomain object);
	R visitCoreModel(org.eclipse.qvtd.pivot.qvtcore.CoreModel object);
	R visitCorePattern(org.eclipse.qvtd.pivot.qvtcore.CorePattern object);
	R visitEnforcementOperation(org.eclipse.qvtd.pivot.qvtcore.EnforcementOperation object);
	R visitGuardPattern(org.eclipse.qvtd.pivot.qvtcore.GuardPattern object);
	R visitMapping(org.eclipse.qvtd.pivot.qvtcore.Mapping object);
	R visitPropertyAssignment(org.eclipse.qvtd.pivot.qvtcore.PropertyAssignment object);
	R visitRealizedVariable(org.eclipse.qvtd.pivot.qvtcore.RealizedVariable object);
	R visitVariableAssignment(org.eclipse.qvtd.pivot.qvtcore.VariableAssignment object);
}
