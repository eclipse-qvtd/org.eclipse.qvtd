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
 * from: org.eclipse.qvtd.pivot.qvtimperative/model/QVTimperative.genmodel
 *
 * Only the copyright statement is editable.
 *******************************************************************************/
package	org.eclipse.qvtd.pivot.qvtimperative.util;

import org.eclipse.jdt.annotation.NonNull;

/**
 */
public interface QVTimperativeVisitor<R> extends org.eclipse.qvtd.pivot.qvtbase.util.QVTbaseVisitor<R>
{
	R visitAddStatement(org.eclipse.qvtd.pivot.qvtimperative.@NonNull AddStatement object);
	R visitAssignment(org.eclipse.qvtd.pivot.qvtimperative.@NonNull Assignment object);
	R visitBottomPattern(org.eclipse.qvtd.pivot.qvtimperative.@NonNull BottomPattern object);
	R visitBottomStatement(org.eclipse.qvtd.pivot.qvtimperative.@NonNull BottomStatement object);
	R visitConnectionVariable(org.eclipse.qvtd.pivot.qvtimperative.@NonNull ConnectionVariable object);
	R visitGuardPattern(org.eclipse.qvtd.pivot.qvtimperative.@NonNull GuardPattern object);
	R visitImperativeDomain(org.eclipse.qvtd.pivot.qvtimperative.@NonNull ImperativeDomain object);
	R visitImperativeModel(org.eclipse.qvtd.pivot.qvtimperative.@NonNull ImperativeModel object);
	R visitImperativePattern(org.eclipse.qvtd.pivot.qvtimperative.@NonNull ImperativePattern object);
	R visitMapping(org.eclipse.qvtd.pivot.qvtimperative.@NonNull Mapping object);
	R visitMappingCall(org.eclipse.qvtd.pivot.qvtimperative.@NonNull MappingCall object);
	R visitMappingCallBinding(org.eclipse.qvtd.pivot.qvtimperative.@NonNull MappingCallBinding object);
	R visitMappingLoop(org.eclipse.qvtd.pivot.qvtimperative.@NonNull MappingLoop object);
	R visitMappingStatement(org.eclipse.qvtd.pivot.qvtimperative.@NonNull MappingStatement object);
	R visitNewStatement(org.eclipse.qvtd.pivot.qvtimperative.@NonNull NewStatement object);
	R visitSetStatement(org.eclipse.qvtd.pivot.qvtimperative.@NonNull SetStatement object);
	R visitStatement(org.eclipse.qvtd.pivot.qvtimperative.@NonNull Statement object);
	R visitVariableAssignment(org.eclipse.qvtd.pivot.qvtimperative.@NonNull VariableAssignment object);
	R visitVariablePredicate(org.eclipse.qvtd.pivot.qvtimperative.@NonNull VariablePredicate object);
}
