/*******************************************************************************
 * Copyright (c) 2010, 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * This code is auto-generated
 * from: org.eclipse.qvtd.xtext.qvtbase/model/QVTbaseCS.genmodel
 *
 * Only the copyright statement is editable.
 *******************************************************************************/
package	org.eclipse.qvtd.xtext.qvtbasecs.util;

import org.eclipse.jdt.annotation.NonNull;

/**
 * An AbstractExtendingQVTbaseCSVisitor provides a default implementation for each
 * visitXxx method that delegates to the visitYyy method of the first
 * super class, (or transitively its first super class' first super class
 * until a non-interface super-class is found). In the absence of any
 * suitable first super class, the method delegates to visiting().
 */
public abstract class AbstractExtendingQVTbaseCSVisitor<R, C>
	extends org.eclipse.ocl.xtext.essentialoclcs.util.AbstractExtendingEssentialOCLCSVisitor<R, C>
	implements QVTbaseCSVisitor<R>
{
	/**
	 * Initializes me with an initial value for my result.
	 * 
	 * @param context my initial result value
	 */
	protected AbstractExtendingQVTbaseCSVisitor(C context) {
		super(context);
	}	

	@Override
	public R visitAbstractTransformationCS(org.eclipse.qvtd.xtext.qvtbasecs.@NonNull AbstractTransformationCS object) {
		return visitClassCS(object);
	}

	@Override
	public R visitQualifiedPackageCS(org.eclipse.qvtd.xtext.qvtbasecs.@NonNull QualifiedPackageCS object) {
		return visitPackageCS(object);
	}
}
