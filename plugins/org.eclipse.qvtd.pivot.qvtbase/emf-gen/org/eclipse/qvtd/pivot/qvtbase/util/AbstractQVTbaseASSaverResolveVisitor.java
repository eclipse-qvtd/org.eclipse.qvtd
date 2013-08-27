/**
 * <copyright>
 * 
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
 * Do not edit it.
 */
package	org.eclipse.qvtd.pivot.qvtbase.util;

import java.lang.Object;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.pivot.utilities.ASSaver;
import org.eclipse.ocl.examples.pivot.utilities.ASSaverResolveVisitor;

/**
 * An AbstractQVTbaseASSaverResolveVisitor provides a default implementation for each
 * visitXxx method that delegates to the visitYyy method of the first
 * super class, (or transitively its first super class' first super class
 * until a non-interface super-class is found). In the absence of any
 * suitable first super class, the method delegates to visiting().
 */
public abstract class AbstractQVTbaseASSaverResolveVisitor
	extends ASSaverResolveVisitor
	implements QVTbaseVisitor<Object>
{
	/**
	 * Initializes me with an initial value for my result.
	 * 
	 * @param context my initial result value
	 */
	protected AbstractQVTbaseASSaverResolveVisitor(@NonNull ASSaver context) {
		super(context);
	}	

	public @Nullable Object visitBaseModel(@NonNull org.eclipse.qvtd.pivot.qvtbase.BaseModel object) {
		return visitRoot(object);
	}

	public @Nullable Object visitDomain(@NonNull org.eclipse.qvtd.pivot.qvtbase.Domain object) {
		return visitNamedElement(object);
	}

	public @Nullable Object visitFunction(@NonNull org.eclipse.qvtd.pivot.qvtbase.Function object) {
		return visitOperation(object);
	}

	public @Nullable Object visitFunctionParameter(@NonNull org.eclipse.qvtd.pivot.qvtbase.FunctionParameter object) {
		return visitParameter(object);
	}

	public @Nullable Object visitPattern(@NonNull org.eclipse.qvtd.pivot.qvtbase.Pattern object) {
		return visitElement(object);
	}

	public @Nullable Object visitPredicate(@NonNull org.eclipse.qvtd.pivot.qvtbase.Predicate object) {
		return visitElement(object);
	}

	public @Nullable Object visitRule(@NonNull org.eclipse.qvtd.pivot.qvtbase.Rule object) {
		return visitNamedElement(object);
	}

	public @Nullable Object visitTransformation(@NonNull org.eclipse.qvtd.pivot.qvtbase.Transformation object) {
		return visitClass(object);
	}

	public @Nullable Object visitTypedModel(@NonNull org.eclipse.qvtd.pivot.qvtbase.TypedModel object) {
		return visitNamedElement(object);
	}

	public @Nullable Object visitUnit(@NonNull org.eclipse.qvtd.pivot.qvtbase.Unit object) {
		return visitNamedElement(object);
	}
}
