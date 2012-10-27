/**
 * <copyright>
 *
 * Copyright (c) 2010 E.D.Willink and others.
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
 * $Id: CompleteOCLPreOrderVisitor.java,v 1.11 2011/05/20 15:26:50 ewillink Exp $
 */
package org.eclipse.qvtd.xtext.qvtcore.cs2pivot;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.CS2PivotConversion;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.Continuation;
import org.eclipse.ocl.examples.xtext.essentialocl.cs2pivot.EssentialOCLContainmentVisitor;
import org.eclipse.qvtd.xtext.qvtcorecst.util.QVTcoreCSVisitor;

public class AbstractQVTcoreContainmentVisitor extends EssentialOCLContainmentVisitor implements QVTcoreCSVisitor<Continuation<?>>
{
	//
	//	This file is maintained by copying from AbstractExtendingQVTcoreCSVisitor and changing R to Continuation<?>.
	//
	public AbstractQVTcoreContainmentVisitor(@NonNull CS2PivotConversion context) {
		super(context);
	}	

	public Continuation<?> visitAreaCS(@NonNull org.eclipse.qvtd.xtext.qvtcorecst.AreaCS object) {
		return visitNamedElementCS(object);
	}

	public Continuation<?> visitAssignmentCS(@NonNull org.eclipse.qvtd.xtext.qvtcorecst.AssignmentCS object) {
		return visitExpCS(object);
	}

	public Continuation<?> visitBottomPatternCS(@NonNull org.eclipse.qvtd.xtext.qvtcorecst.BottomPatternCS object) {
		return visitPatternCS(object);
	}

	public Continuation<?> visitDirectionCS(@NonNull org.eclipse.qvtd.xtext.qvtcorecst.DirectionCS object) {
		return visitNamedElementCS(object);
	}

	public Continuation<?> visitDomainCS(@NonNull org.eclipse.qvtd.xtext.qvtcorecst.DomainCS object) {
		return visitAreaCS(object);
	}

	public Continuation<?> visitEnforcementOperationCS(@NonNull org.eclipse.qvtd.xtext.qvtcorecst.EnforcementOperationCS object) {
		return visitModelElementCS(object);
	}

	public Continuation<?> visitGuardPatternCS(@NonNull org.eclipse.qvtd.xtext.qvtcorecst.GuardPatternCS object) {
		return visitPatternCS(object);
	}

	public Continuation<?> visitMappingCS(@NonNull org.eclipse.qvtd.xtext.qvtcorecst.MappingCS object) {
		return visitNamedElementCS(object);
	}

	public Continuation<?> visitParamDeclarationCS(@NonNull org.eclipse.qvtd.xtext.qvtcorecst.ParamDeclarationCS object) {
		return visitTypedElementCS(object);
	}

	public Continuation<?> visitPatternCS(@NonNull org.eclipse.qvtd.xtext.qvtcorecst.PatternCS object) {
		return visitModelElementCS(object);
	}

	public Continuation<?> visitQueryCS(@NonNull org.eclipse.qvtd.xtext.qvtcorecst.QueryCS object) {
		return visitTypedElementCS(object);
	}

	public Continuation<?> visitRealizeableVariableCS(@NonNull org.eclipse.qvtd.xtext.qvtcorecst.RealizeableVariableCS object) {
		return visitTypedElementCS(object);
	}

	public Continuation<?> visitRealizedVariableCS(@NonNull org.eclipse.qvtd.xtext.qvtcorecst.RealizedVariableCS object) {
		return visitRealizeableVariableCS(object);
	}

	public Continuation<?> visitTopLevelCS(@NonNull org.eclipse.qvtd.xtext.qvtcorecst.TopLevelCS object) {
		return visitRootPackageCS(object);
	}

	public Continuation<?> visitTransformationCS(@NonNull org.eclipse.qvtd.xtext.qvtcorecst.TransformationCS object) {
		return visitPackageCS(object);
	}

	public Continuation<?> visitUnrealizedVariableCS(@NonNull org.eclipse.qvtd.xtext.qvtcorecst.UnrealizedVariableCS object) {
		return visitRealizeableVariableCS(object);
	}
}