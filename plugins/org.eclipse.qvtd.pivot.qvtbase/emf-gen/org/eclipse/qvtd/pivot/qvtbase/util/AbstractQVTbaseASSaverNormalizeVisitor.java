/*******************************************************************************
 * <copyright>
 * 
 * Copyright (c) 2013, 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 * 
 * </copyright>
 *
 * This code is auto-generated
 * from: org.eclipse.qvtd.pivot.qvtbase/model/QVTbase.genmodel
 *
 * Only the copyright statement is editable.
 *******************************************************************************/
package	org.eclipse.qvtd.pivot.qvtbase.util;

import java.lang.Object;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.internal.resource.ASSaver;
import org.eclipse.ocl.pivot.utilities.PivotASSaverNormalizeVisitor;

/**
 * An AbstractQVTbaseASSaverNormalizeVisitor provides a default implementation for each
 * visitXxx method that delegates to the visitYyy method of the first
 * super class, (or transitively its first super class' first super class
 * until a non-interface super-class is found). In the absence of any
 * suitable first super class, the method delegates to visiting().
 */
public abstract class AbstractQVTbaseASSaverNormalizeVisitor
	extends PivotASSaverNormalizeVisitor
	implements QVTbaseVisitor<Object>
{
	/**
	 * Initializes me with an initial value for my result.
	 * 
	 * @param context my initial result value
	 */
	protected AbstractQVTbaseASSaverNormalizeVisitor(@NonNull ASSaver context) {
		super(context);
	}	

	@Override
	public @Nullable Object visitBaseModel(org.eclipse.qvtd.pivot.qvtbase.@NonNull BaseModel object) {
		return visitModel(object);
	}

	@Override
	public @Nullable Object visitDomain(org.eclipse.qvtd.pivot.qvtbase.@NonNull Domain object) {
		return visitNamedElement(object);
	}

	@Override
	public @Nullable Object visitFunction(org.eclipse.qvtd.pivot.qvtbase.@NonNull Function object) {
		return visitOperation(object);
	}

	@Override
	public @Nullable Object visitFunctionParameter(org.eclipse.qvtd.pivot.qvtbase.@NonNull FunctionParameter object) {
		return visitParameter(object);
	}

	@Override
	public @Nullable Object visitPattern(org.eclipse.qvtd.pivot.qvtbase.@NonNull Pattern object) {
		return visitElement(object);
	}

	@Override
	public @Nullable Object visitPredicate(org.eclipse.qvtd.pivot.qvtbase.@NonNull Predicate object) {
		return visitElement(object);
	}

	@Override
	public @Nullable Object visitRule(org.eclipse.qvtd.pivot.qvtbase.@NonNull Rule object) {
		return visitNamedElement(object);
	}

	@Override
	public @Nullable Object visitTransformation(org.eclipse.qvtd.pivot.qvtbase.@NonNull Transformation object) {
		return visitClass(object);
	}

	@Override
	public @Nullable Object visitTypedModel(org.eclipse.qvtd.pivot.qvtbase.@NonNull TypedModel object) {
		return visitNamedElement(object);
	}
}
