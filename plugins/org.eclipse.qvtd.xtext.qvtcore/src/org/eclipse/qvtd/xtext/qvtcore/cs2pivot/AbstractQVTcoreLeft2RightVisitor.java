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
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.CS2PivotConversion;
import org.eclipse.ocl.examples.xtext.essentialocl.cs2pivot.EssentialOCLLeft2RightVisitor;
import org.eclipse.qvtd.xtext.qvtcorecst.util.QVTcoreCSVisitor;

public class AbstractQVTcoreLeft2RightVisitor extends EssentialOCLLeft2RightVisitor implements QVTcoreCSVisitor<Element>
{
	//
	//	This file is maintained by copying from AbstractExtendingQVTcoreCSVisitor and changing R to Element.
	//
	public AbstractQVTcoreLeft2RightVisitor(@NonNull CS2PivotConversion context) {
		super(context);
	}	

	public Element visitAreaCS(@NonNull org.eclipse.qvtd.xtext.qvtcorecst.AreaCS object) {
		return visitNamedElementCS(object);
	}

	public Element visitAssignmentCS(@NonNull org.eclipse.qvtd.xtext.qvtcorecst.AssignmentCS object) {
		return visitExpCS(object);
	}

	public Element visitBottomPatternCS(@NonNull org.eclipse.qvtd.xtext.qvtcorecst.BottomPatternCS object) {
		return visitPatternCS(object);
	}

	public Element visitDirectionCS(@NonNull org.eclipse.qvtd.xtext.qvtcorecst.DirectionCS object) {
		return visitNamedElementCS(object);
	}

	public Element visitDomainCS(@NonNull org.eclipse.qvtd.xtext.qvtcorecst.DomainCS object) {
		return visitAreaCS(object);
	}

	public Element visitEnforcementOperationCS(@NonNull org.eclipse.qvtd.xtext.qvtcorecst.EnforcementOperationCS object) {
		return visitModelElementCS(object);
	}

	public Element visitGuardPatternCS(@NonNull org.eclipse.qvtd.xtext.qvtcorecst.GuardPatternCS object) {
		return visitPatternCS(object);
	}

	public Element visitMappingCS(@NonNull org.eclipse.qvtd.xtext.qvtcorecst.MappingCS object) {
		return visitNamedElementCS(object);
	}

	public Element visitParamDeclarationCS(@NonNull org.eclipse.qvtd.xtext.qvtcorecst.ParamDeclarationCS object) {
		return visitTypedElementCS(object);
	}

	public Element visitPatternCS(@NonNull org.eclipse.qvtd.xtext.qvtcorecst.PatternCS object) {
		return visitModelElementCS(object);
	}

	public Element visitQueryCS(@NonNull org.eclipse.qvtd.xtext.qvtcorecst.QueryCS object) {
		return visitTypedElementCS(object);
	}

	public Element visitRealizeableVariableCS(@NonNull org.eclipse.qvtd.xtext.qvtcorecst.RealizeableVariableCS object) {
		return visitTypedElementCS(object);
	}

	public Element visitRealizedVariableCS(@NonNull org.eclipse.qvtd.xtext.qvtcorecst.RealizedVariableCS object) {
		return visitRealizeableVariableCS(object);
	}

	public Element visitTopLevelCS(@NonNull org.eclipse.qvtd.xtext.qvtcorecst.TopLevelCS object) {
		return visitRootPackageCS(object);
	}

	public Element visitTransformationCS(@NonNull org.eclipse.qvtd.xtext.qvtcorecst.TransformationCS object) {
		return visitPackageCS(object);
	}

	public Element visitUnrealizedVariableCS(@NonNull org.eclipse.qvtd.xtext.qvtcorecst.UnrealizedVariableCS object) {
		return visitRealizeableVariableCS(object);
	}
}