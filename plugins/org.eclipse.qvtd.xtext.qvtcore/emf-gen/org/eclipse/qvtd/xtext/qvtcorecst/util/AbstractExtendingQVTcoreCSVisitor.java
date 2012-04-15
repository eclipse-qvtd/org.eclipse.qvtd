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
 * from: /org.eclipse.qvtd.xtext.qvtcore/model/QVTcoreCST.ecore
 * by: org.eclipse.ocl.examples.build.acceleo.GenerateVisitor
 * defined by: org.eclipse.ocl.examples.build.acceleo.generateVisitors.mtl
 * invoked by: org.eclipse.ocl.examples.build.utilities.*
 * from: org.eclipse.ocl.examples.build.*.mwe2
 *
 * Do not edit it.
 *
 * $Id$
 */
package	org.eclipse.qvtd.xtext.qvtcorecst.util;

/**
 * An AbstractExtendingQVTcoreCSVisitor provides a default implementation for each
 * visitXxx method that delegates to the visitYyy method of the first
 * super class, (or transitively its first super class first super class
 * until a non-interface super-class is found). In the absence of any
 * suitable first super class, the method delegates to visiting().
 */
public abstract class AbstractExtendingQVTcoreCSVisitor<R, C>
	extends org.eclipse.ocl.examples.xtext.essentialocl.util.AbstractExtendingEssentialOCLCSVisitor<R, C>
	implements QVTcoreCSVisitor<R, C>
{
	/**
	 * Initializes me with an initial value for my result.
	 * 
	 * @param context my initial result value
	 */
	protected AbstractExtendingQVTcoreCSVisitor(C context) {
	    super(context);
	}	

	public R visitAreaCS(org.eclipse.qvtd.xtext.qvtcorecst.AreaCS object) {
		return visitNamedElementCS(object);
	}

	public R visitBottomPatternCS(org.eclipse.qvtd.xtext.qvtcorecst.BottomPatternCS object) {
		return visitPatternCS(object);
	}

	public R visitConstraintCS(org.eclipse.qvtd.xtext.qvtcorecst.ConstraintCS object) {
		return visitExpCS(object);
	}

	public R visitDirectionCS(org.eclipse.qvtd.xtext.qvtcorecst.DirectionCS object) {
		return visitNamedElementCS(object);
	}

	public R visitDomainCS(org.eclipse.qvtd.xtext.qvtcorecst.DomainCS object) {
		return visitAreaCS(object);
	}

	public R visitEnforcementOperationCS(org.eclipse.qvtd.xtext.qvtcorecst.EnforcementOperationCS object) {
		return visitModelElementCS(object);
	}

	public R visitGuardPatternCS(org.eclipse.qvtd.xtext.qvtcorecst.GuardPatternCS object) {
		return visitPatternCS(object);
	}

	public R visitMappingCS(org.eclipse.qvtd.xtext.qvtcorecst.MappingCS object) {
		return visitNamedElementCS(object);
	}

	public R visitParamDeclarationCS(org.eclipse.qvtd.xtext.qvtcorecst.ParamDeclarationCS object) {
		return visitTypedElementCS(object);
	}

	public R visitPatternCS(org.eclipse.qvtd.xtext.qvtcorecst.PatternCS object) {
		return visitModelElementCS(object);
	}

	public R visitQueryCS(org.eclipse.qvtd.xtext.qvtcorecst.QueryCS object) {
		return visitTypedElementCS(object);
	}

	public R visitRealizeableVariableCS(org.eclipse.qvtd.xtext.qvtcorecst.RealizeableVariableCS object) {
		return visitTypedElementCS(object);
	}

	public R visitRealizedVariableCS(org.eclipse.qvtd.xtext.qvtcorecst.RealizedVariableCS object) {
		return visitRealizeableVariableCS(object);
	}

	public R visitTopLevelCS(org.eclipse.qvtd.xtext.qvtcorecst.TopLevelCS object) {
		return visitRootPackageCS(object);
	}

	public R visitTransformationCS(org.eclipse.qvtd.xtext.qvtcorecst.TransformationCS object) {
		return visitPackageCS(object);
	}

	public R visitUnrealizedVariableCS(org.eclipse.qvtd.xtext.qvtcorecst.UnrealizedVariableCS object) {
		return visitRealizeableVariableCS(object);
	}
}
