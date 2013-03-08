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
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.CS2PivotConversion;
import org.eclipse.ocl.examples.xtext.essentialocl.cs2pivot.EssentialOCLLeft2RightVisitor;
import org.eclipse.qvtd.xtext.qvtcorebasecst.util.QVTcoreBaseCSVisitor;

public class AbstractQVTcoreBaseLeft2RightVisitor extends EssentialOCLLeft2RightVisitor implements QVTcoreBaseCSVisitor<Element>
{
	//
	//	This file is maintained by copying from AbstractExtendingQVTcoreCSVisitor and changing R to Element.
	//
	public AbstractQVTcoreBaseLeft2RightVisitor(@NonNull CS2PivotConversion context) {
		super(context);
	}	

	public Element visitAbstractMappingCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebasecst.AbstractMappingCS object) {
		return visitNamedElementCS(object);
	}

	public Element visitAreaCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebasecst.AreaCS object) {
		return visitNamedElementCS(object);
	}

	public Element visitAssignmentCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebasecst.AssignmentCS object) {
		return visitExpCS(object);
	}

	public Element visitBottomPatternCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebasecst.BottomPatternCS object) {
		return visitPatternCS(object);
	}

	public Element visitDirectionCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebasecst.DirectionCS object) {
		return visitNamedElementCS(object);
	}

	public Element visitDomainCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebasecst.DomainCS object) {
		return visitAreaCS(object);
	}

	public Element visitEnforcementOperationCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebasecst.EnforcementOperationCS object) {
		return visitModelElementCS(object);
	}

	public Element visitGuardPatternCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebasecst.GuardPatternCS object) {
		return visitPatternCS(object);
	}

	public Element visitParamDeclarationCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebasecst.ParamDeclarationCS object) {
		return visitTypedElementCS(object);
	}

	public Element visitPatternCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebasecst.PatternCS object) {
		return visitModelElementCS(object);
	}

	public Element visitQueryCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebasecst.QueryCS object) {
		return visitTypedElementCS(object);
	}

	public Element visitRealizeableVariableCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebasecst.RealizeableVariableCS object) {
		return visitTypedElementCS(object);
	}

	public Element visitRealizedVariableCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebasecst.RealizedVariableCS object) {
		return visitRealizeableVariableCS(object);
	}

	public Element visitTransformationCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebasecst.TransformationCS object) {
		return visitPackageCS(object);
	}

	public Element visitUnrealizedVariableCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebasecst.UnrealizedVariableCS object) {
		return visitRealizeableVariableCS(object);
	}
}