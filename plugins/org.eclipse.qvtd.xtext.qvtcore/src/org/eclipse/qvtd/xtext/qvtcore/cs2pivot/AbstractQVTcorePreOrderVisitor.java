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

import org.eclipse.ocl.examples.xtext.base.cs2pivot.CS2PivotConversion;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.Continuation;
import org.eclipse.ocl.examples.xtext.essentialocl.cs2pivot.EssentialOCLPreOrderVisitor;
import org.eclipse.qvtd.xtext.qvtcorecst.util.QVTcoreCSVisitor;

public class AbstractQVTcorePreOrderVisitor extends EssentialOCLPreOrderVisitor implements QVTcoreCSVisitor<Continuation<?>>
{
	//
	//	This file is maintained by copying from AbstractExtendingQVTcoreCSVisitor and changing R to Continuation<?>.
	//
	public AbstractQVTcorePreOrderVisitor(CS2PivotConversion context) {
		super(context);
	}	

	public Continuation<?> visitAreaCS(org.eclipse.qvtd.xtext.qvtcorecst.AreaCS object) {
		return visitNamedElementCS(object);
	}

	public Continuation<?> visitAssignmentCS(org.eclipse.qvtd.xtext.qvtcorecst.AssignmentCS object) {
		return visitExpCS(object);
	}

	public Continuation<?> visitBottomPatternCS(org.eclipse.qvtd.xtext.qvtcorecst.BottomPatternCS object) {
		return visitPatternCS(object);
	}

	public Continuation<?> visitDirectionCS(org.eclipse.qvtd.xtext.qvtcorecst.DirectionCS object) {
		return visitNamedElementCS(object);
	}

	public Continuation<?> visitDomainCS(org.eclipse.qvtd.xtext.qvtcorecst.DomainCS object) {
		return visitAreaCS(object);
	}

	public Continuation<?> visitEnforcementOperationCS(org.eclipse.qvtd.xtext.qvtcorecst.EnforcementOperationCS object) {
		return visitModelElementCS(object);
	}

	public Continuation<?> visitGuardPatternCS(org.eclipse.qvtd.xtext.qvtcorecst.GuardPatternCS object) {
		return visitPatternCS(object);
	}

	public Continuation<?> visitMappingCS(org.eclipse.qvtd.xtext.qvtcorecst.MappingCS object) {
		return visitNamedElementCS(object);
	}

	public Continuation<?> visitParamDeclarationCS(org.eclipse.qvtd.xtext.qvtcorecst.ParamDeclarationCS object) {
		return visitTypedElementCS(object);
	}

	public Continuation<?> visitPatternCS(org.eclipse.qvtd.xtext.qvtcorecst.PatternCS object) {
		return visitModelElementCS(object);
	}

	public Continuation<?> visitQueryCS(org.eclipse.qvtd.xtext.qvtcorecst.QueryCS object) {
		return visitTypedElementCS(object);
	}

	public Continuation<?> visitRealizeableVariableCS(org.eclipse.qvtd.xtext.qvtcorecst.RealizeableVariableCS object) {
		return visitTypedElementCS(object);
	}

	public Continuation<?> visitRealizedVariableCS(org.eclipse.qvtd.xtext.qvtcorecst.RealizedVariableCS object) {
		return visitRealizeableVariableCS(object);
	}

	public Continuation<?> visitTopLevelCS(org.eclipse.qvtd.xtext.qvtcorecst.TopLevelCS object) {
		return visitRootPackageCS(object);
	}

	public Continuation<?> visitTransformationCS(org.eclipse.qvtd.xtext.qvtcorecst.TransformationCS object) {
		return visitPackageCS(object);
	}

	public Continuation<?> visitUnrealizedVariableCS(org.eclipse.qvtd.xtext.qvtcorecst.UnrealizedVariableCS object) {
		return visitRealizeableVariableCS(object);
	}
}