/*******************************************************************************
 * Copyright (c) 2010, 2017 Willink Transformations and others.
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
import org.eclipse.jdt.annotation.Nullable;

/**
 * An AbstractNullQVTbaseCSVisitor provides a default implementation for each
 * visitXxx method that returns null.
 *
 * @deprecated Explicit 'Null' functionality is obsolete with Java 8 @Nullable annotations.  
 */
 @Deprecated
public abstract class AbstractNullQVTbaseCSVisitor<@Nullable R, C>
	extends org.eclipse.ocl.xtext.essentialoclcs.util.AbstractNullEssentialOCLCSVisitor<R, C> implements QVTbaseCSVisitor<R>
{
	/**
	 * Initializes me with an initial value for my result.
	 * 
	 * @param context my initial result value
	 */
	protected AbstractNullQVTbaseCSVisitor(C context) {
		super(context);
	}	

	@Override
	public R visitAbstractTransformationCS(org.eclipse.qvtd.xtext.qvtbasecs.@NonNull AbstractTransformationCS object) {
		return null;
	}

	@Override
	public R visitQualifiedPackageCS(org.eclipse.qvtd.xtext.qvtbasecs.@NonNull QualifiedPackageCS object) {
		return null;
	}
}
