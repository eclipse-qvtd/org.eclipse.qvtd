/*******************************************************************************
 * Copyright (c) 2010, 2022 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
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
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.xtext.base.cs2as.CS2ASConversion;
import org.eclipse.ocl.xtext.essentialocl.cs2as.EssentialOCLCSLeft2RightVisitor;

/**
 * An AbstractQVTbaseCSLeft2RightVisitor provides a default implementation for each
 * visitXxx method that delegates to the visitYyy method of the first
 * super class, (or transitively its first super class first super class
 * until a non-interface super-class is found). In the absence of any
 * suitable first super class, the method delegates to visiting().
 */
public abstract class AbstractQVTbaseCSLeft2RightVisitor
	extends EssentialOCLCSLeft2RightVisitor
	implements QVTbaseCSVisitor<Element>
{
	/**
	 * Initializes me with an initial value for my result.
	 *
	 * @param context my initial result value
	 */
	protected AbstractQVTbaseCSLeft2RightVisitor(@NonNull CS2ASConversion context) {
		super(context);
	}

	@Override
	public @Nullable Element visitAbstractTransformationCS(org.eclipse.qvtd.xtext.qvtbasecs.@NonNull AbstractTransformationCS csElement) {
		return visitClassCS(csElement);
	}

	@Override
	public @Nullable Element visitCompoundTargetElementCS(org.eclipse.qvtd.xtext.qvtbasecs.@NonNull CompoundTargetElementCS csElement) {
		return visitTargetElementCS(csElement);
	}

	@Override
	public @Nullable Element visitJavaClassCS(org.eclipse.ocl.xtext.basecs.JavaClassCS csElement) {
		return visitNamedElementCS(csElement);
	}

	@Override
	public @Nullable Element visitJavaImplementationCS(org.eclipse.ocl.xtext.basecs.JavaImplementationCS csElement) {
		return visitElementCS(csElement);
	}

	@Override
	public @Nullable Element visitQualifiedPackageCS(org.eclipse.qvtd.xtext.qvtbasecs.@NonNull QualifiedPackageCS csElement) {
		return visitPackageCS(csElement);
	}

	@Override
	public @Nullable Element visitSimpleTargetElementCS(org.eclipse.qvtd.xtext.qvtbasecs.@NonNull SimpleTargetElementCS csElement) {
		return visitTargetElementCS(csElement);
	}

	@Override
	public @Nullable Element visitTargetCS(org.eclipse.qvtd.xtext.qvtbasecs.@NonNull TargetCS csElement) {
		return visitNamedElementCS(csElement);
	}

	@Override
	public @Nullable Element visitTargetElementCS(org.eclipse.qvtd.xtext.qvtbasecs.@NonNull TargetElementCS csElement) {
		return visitModelElementCS(csElement);
	}
}
