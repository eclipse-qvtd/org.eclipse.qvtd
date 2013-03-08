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
package org.eclipse.qvtd.xtext.qvtcorebase.cs2pivot;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.CS2PivotConversion;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.Continuation;
import org.eclipse.ocl.examples.xtext.essentialocl.cs2pivot.EssentialOCLPreOrderVisitor;
import org.eclipse.qvtd.xtext.qvtcorebasecst.util.QVTcoreBaseCSVisitor;

public class AbstractQVTcoreBasePreOrderVisitor extends EssentialOCLPreOrderVisitor implements QVTcoreBaseCSVisitor<Continuation<?>>
{
	//
	//	This file is maintained by copying from AbstractExtendingQVTcoreCSVisitor and changing R to Continuation<?>.
	//
	public AbstractQVTcoreBasePreOrderVisitor(@NonNull CS2PivotConversion context) {
		super(context);
	}	

	public Continuation<?> visitAbstractMappingCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebasecst.AbstractMappingCS object) {
		return visitNamedElementCS(object);
	}

	public Continuation<?> visitAreaCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebasecst.AreaCS object) {
		return visitNamedElementCS(object);
	}

	public Continuation<?> visitAssignmentCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebasecst.AssignmentCS object) {
		return visitExpCS(object);
	}

	public Continuation<?> visitBottomPatternCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebasecst.BottomPatternCS object) {
		return visitPatternCS(object);
	}

	public Continuation<?> visitDirectionCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebasecst.DirectionCS object) {
		return visitNamedElementCS(object);
	}

	public Continuation<?> visitDomainCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebasecst.DomainCS object) {
		return visitAreaCS(object);
	}

	public Continuation<?> visitEnforcementOperationCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebasecst.EnforcementOperationCS object) {
		return visitModelElementCS(object);
	}

	public Continuation<?> visitGuardPatternCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebasecst.GuardPatternCS object) {
		return visitPatternCS(object);
	}

	public Continuation<?> visitParamDeclarationCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebasecst.ParamDeclarationCS object) {
		return visitTypedElementCS(object);
	}

	public Continuation<?> visitPatternCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebasecst.PatternCS object) {
		return visitModelElementCS(object);
	}

	public Continuation<?> visitQueryCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebasecst.QueryCS object) {
		return visitTypedElementCS(object);
	}

	public Continuation<?> visitRealizeableVariableCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebasecst.RealizeableVariableCS object) {
		return visitTypedElementCS(object);
	}

	public Continuation<?> visitRealizedVariableCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebasecst.RealizedVariableCS object) {
		return visitRealizeableVariableCS(object);
	}

	public Continuation<?> visitTransformationCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebasecst.TransformationCS object) {
		return visitPackageCS(object);
	}

	public Continuation<?> visitUnrealizedVariableCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebasecst.UnrealizedVariableCS object) {
		return visitRealizeableVariableCS(object);
	}
}