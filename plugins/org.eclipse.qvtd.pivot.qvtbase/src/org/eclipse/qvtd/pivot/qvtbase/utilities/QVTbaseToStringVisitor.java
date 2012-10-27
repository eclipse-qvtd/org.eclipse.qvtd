/**
 * <copyright>
 *
 * Copyright (c) 2012 E.D. Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D. Willink - Initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.qvtd.pivot.qvtbase.utilities;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.utilities.ToStringVisitor;
import org.eclipse.qvtd.pivot.qvtbase.BaseModel;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.Function;
import org.eclipse.qvtd.pivot.qvtbase.FunctionParameter;
import org.eclipse.qvtd.pivot.qvtbase.Pattern;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;
import org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.Unit;
import org.eclipse.qvtd.pivot.qvtbase.util.QVTbaseVisitor;

/**
 * Converts an OCL expression to a string for debugging. This is not intended to
 * be used by client applications as an AST-to-text transformation.
 */
public class QVTbaseToStringVisitor extends ToStringVisitor implements QVTbaseVisitor<String>
{
	private static final class Factory implements ToStringVisitor.Factory
	{
		private Factory() {
			ToStringVisitor.FACTORY.getClass();
			ToStringVisitor.addFactory(this);
		}

		public @NonNull ToStringVisitor createToStringVisitor() {
			return new QVTbaseToStringVisitor();
		}

		@SuppressWarnings("null")
		public @NonNull EPackage getEPackage() {
			return QVTbasePackage.eINSTANCE;
		}
	}

	public static @NonNull ToStringVisitor.Factory FACTORY = new Factory();

	protected QVTbaseToStringVisitor() {}

	public String visitBaseModel(@NonNull BaseModel object) {
		append("base model ");
		return null;
	}

	public String visitDomain(@NonNull Domain object) {
		append("domain ");
		appendName(object);
		return null;
	}

	public String visitFunction(@NonNull Function object) {
		append("function ");
		appendName(object);
		return null;
	}

	public String visitFunctionParameter(@NonNull FunctionParameter object) {
		append("function parameter ");
		appendName(object);
		return null;
	}

	public String visitPattern(@NonNull Pattern object) {
		append("pattern ");
//		appendName(object);
		return null;
	}

	public String visitPredicate(@NonNull Predicate object) {
		append("predicate ");
//		appendName(object);
		return null;
	}

	public String visitRule(@NonNull Rule object) {
		append("rule ");
		appendName(object);
		return null;
	}

	public String visitTransformation(@NonNull Transformation object) {
		append("transformation ");
		appendName(object);
		return null;
	}

	public String visitTypedModel(@NonNull TypedModel object) {
		append("typed model ");
		appendName(object);
		return null;
	}

	public String visitUnit(@NonNull Unit object) {
		append("unit ");
		appendName(object);
		return null;
	}
}
