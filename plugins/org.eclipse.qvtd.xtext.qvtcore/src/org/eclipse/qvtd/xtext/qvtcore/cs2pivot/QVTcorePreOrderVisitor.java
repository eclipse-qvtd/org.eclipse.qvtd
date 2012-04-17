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
import org.eclipse.qvtd.xtext.qvtcorecst.AssignmentCS;
import org.eclipse.qvtd.xtext.qvtcorecst.BottomPatternCS;
import org.eclipse.qvtd.xtext.qvtcorecst.DirectionCS;
import org.eclipse.qvtd.xtext.qvtcorecst.DomainCS;
import org.eclipse.qvtd.xtext.qvtcorecst.EnforcementOperationCS;
import org.eclipse.qvtd.xtext.qvtcorecst.GuardPatternCS;
import org.eclipse.qvtd.xtext.qvtcorecst.MappingCS;
import org.eclipse.qvtd.xtext.qvtcorecst.ParamDeclarationCS;
import org.eclipse.qvtd.xtext.qvtcorecst.QueryCS;
import org.eclipse.qvtd.xtext.qvtcorecst.RealizedVariableCS;
import org.eclipse.qvtd.xtext.qvtcorecst.TopLevelCS;
import org.eclipse.qvtd.xtext.qvtcorecst.TransformationCS;
import org.eclipse.qvtd.xtext.qvtcorecst.UnrealizedVariableCS;
import org.eclipse.qvtd.xtext.qvtcorecst.util.AbstractExtendingDelegatingQVTcoreCSVisitor;

public class QVTcorePreOrderVisitor
	extends AbstractExtendingDelegatingQVTcoreCSVisitor<Continuation<?>, CS2PivotConversion, EssentialOCLPreOrderVisitor>
{	

//	protected final MetaModelManager metaModelManager;

	public QVTcorePreOrderVisitor(CS2PivotConversion context) {
		super(new EssentialOCLPreOrderVisitor(context), context);
//		metaModelManager = context.getMetaModelManager();
	}

	@Override
	public Continuation<?> visitAssignmentCS(AssignmentCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitBottomPatternCS(BottomPatternCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitDirectionCS(DirectionCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitDomainCS(DomainCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitEnforcementOperationCS(EnforcementOperationCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitGuardPatternCS(GuardPatternCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitMappingCS(MappingCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitParamDeclarationCS(ParamDeclarationCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitQueryCS(QueryCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitRealizedVariableCS(RealizedVariableCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitTopLevelCS(TopLevelCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitTransformationCS(TransformationCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitUnrealizedVariableCS(UnrealizedVariableCS csElement) {
		return null;
	}
}