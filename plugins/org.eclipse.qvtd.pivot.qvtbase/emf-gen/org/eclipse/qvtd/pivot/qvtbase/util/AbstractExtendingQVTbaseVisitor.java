/*******************************************************************************
 * Copyright (c) 2013 E.D.Willink and others.
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

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * An AbstractExtendingQVTbaseVisitor provides a default implementation for each
 * visitXxx method that delegates to the visitYyy method of the first
 * super class, (or transitively its first super class' first super class
 * until a non-interface super-class is found). In the absence of any
 * suitable first super class, the method delegates to visiting().
 */
public abstract class AbstractExtendingQVTbaseVisitor<R, C>
	extends org.eclipse.ocl.pivot.util.AbstractExtendingVisitor<R, C>
	implements QVTbaseVisitor<R>
{
	/**
	 * Initializes me with an initial value for my result.
	 * 
	 * @param context my initial result value
	 */
	protected AbstractExtendingQVTbaseVisitor(@NonNull C context) {
		super(context);
	}	

	public @Nullable R visitBaseModel(@NonNull org.eclipse.qvtd.pivot.qvtbase.BaseModel object) {
		return visitModel(object);
	}

	public @Nullable R visitDomain(@NonNull org.eclipse.qvtd.pivot.qvtbase.Domain object) {
		return visitNamedElement(object);
	}

	public @Nullable R visitFunction(@NonNull org.eclipse.qvtd.pivot.qvtbase.Function object) {
		return visitOperation(object);
	}

	public @Nullable R visitFunctionParameter(@NonNull org.eclipse.qvtd.pivot.qvtbase.FunctionParameter object) {
		return visitParameter(object);
	}

	public @Nullable R visitPattern(@NonNull org.eclipse.qvtd.pivot.qvtbase.Pattern object) {
		return visitElement(object);
	}

	public @Nullable R visitPredicate(@NonNull org.eclipse.qvtd.pivot.qvtbase.Predicate object) {
		return visitElement(object);
	}

	public @Nullable R visitRule(@NonNull org.eclipse.qvtd.pivot.qvtbase.Rule object) {
		return visitNamedElement(object);
	}

	public @Nullable R visitTransformation(@NonNull org.eclipse.qvtd.pivot.qvtbase.Transformation object) {
		return visitClass(object);
	}

	public @Nullable R visitTypedModel(@NonNull org.eclipse.qvtd.pivot.qvtbase.TypedModel object) {
		return visitNamedElement(object);
	}

	public @Nullable R visitUnit(@NonNull org.eclipse.qvtd.pivot.qvtbase.Unit object) {
		return visitNamedElement(object);
	}
}
