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
 * This code is auto-generated
 * from: org.eclipse.qvtd.xtext.qvtcorebase/model/QVTcoreBaseCST.genmodel
 * by: org.eclipse.ocl.examples.build.xtend.GenerateVisitors
 * invoked by: org.eclipse.ocl.examples.build.*.mwe2
 *
 * Do not edit it.
 */
package	org.eclipse.qvtd.xtext.qvtcorebasecst.util;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.xtext.base.cs2as.CS2PivotConversion;
import org.eclipse.ocl.examples.xtext.essentialocl.cs2as.EssentialOCLPostOrderVisitor;
import org.eclipse.ocl.examples.xtext.base.cs2as.Continuation;

/**
 * An AbstractQVTcoreBasePostOrderVisitor provides a default implementation for each
 * visitXxx method that delegates to the visitYyy method of the first
 * super class, (or transitively its first super class first super class
 * until a non-interface super-class is found). In the absence of any
 * suitable first super class, the method delegates to visiting().
 */
public abstract class AbstractQVTcoreBasePostOrderVisitor
	extends EssentialOCLPostOrderVisitor
	implements QVTcoreBaseCSVisitor<Continuation<?>>
{
	/**
	 * Initializes me with an initial value for my result.
	 * 
	 * @param context my initial result value
	 */
	protected AbstractQVTcoreBasePostOrderVisitor(@NonNull CS2PivotConversion context) {
		super(context);
	}

	public @Nullable Continuation<?> visitAbstractMappingCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebasecst.AbstractMappingCS csElement) {
		return visitNamedElementCS(csElement);
	}

	public @Nullable Continuation<?> visitAreaCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebasecst.AreaCS csElement) {
		return visitNamedElementCS(csElement);
	}

	public @Nullable Continuation<?> visitAssignmentCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebasecst.AssignmentCS csElement) {
		return visitExpCS(csElement);
	}

	public @Nullable Continuation<?> visitBottomPatternCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebasecst.BottomPatternCS csElement) {
		return visitPatternCS(csElement);
	}

	public @Nullable Continuation<?> visitDirectionCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebasecst.DirectionCS csElement) {
		return visitNamedElementCS(csElement);
	}

	public @Nullable Continuation<?> visitDomainCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebasecst.DomainCS csElement) {
		return visitAreaCS(csElement);
	}

	public @Nullable Continuation<?> visitEnforcementOperationCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebasecst.EnforcementOperationCS csElement) {
		return visitModelElementCS(csElement);
	}

	public @Nullable Continuation<?> visitGuardPatternCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebasecst.GuardPatternCS csElement) {
		return visitPatternCS(csElement);
	}

	public @Nullable Continuation<?> visitParamDeclarationCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebasecst.ParamDeclarationCS csElement) {
		return visitTypedElementCS(csElement);
	}

	public @Nullable Continuation<?> visitPatternCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebasecst.PatternCS csElement) {
		return visitModelElementCS(csElement);
	}

	public @Nullable Continuation<?> visitQueryCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebasecst.QueryCS csElement) {
		return visitTypedElementCS(csElement);
	}

	public @Nullable Continuation<?> visitRealizeableVariableCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebasecst.RealizeableVariableCS csElement) {
		return visitTypedElementCS(csElement);
	}

	public @Nullable Continuation<?> visitRealizedVariableCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebasecst.RealizedVariableCS csElement) {
		return visitRealizeableVariableCS(csElement);
	}

	public @Nullable Continuation<?> visitTransformationCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebasecst.TransformationCS csElement) {
		return visitPackageCS(csElement);
	}

	public @Nullable Continuation<?> visitUnrealizedVariableCS(@NonNull org.eclipse.qvtd.xtext.qvtcorebasecst.UnrealizedVariableCS csElement) {
		return visitRealizeableVariableCS(csElement);
	}
}
