/*******************************************************************************
 * Copyright (c) 2012, 2015 E.D. Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D. Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtbase.utilities;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Import;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.utilities.ToStringVisitor;
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
import org.eclipse.qvtd.pivot.qvtbase.util.QVTbaseVisitor;

/**
 * Converts an OCL expression to a string for debugging. This is not intended to
 * be used by client applications as an AST-to-text transformation.
 */
public class QVTbaseToStringVisitor extends ToStringVisitor implements QVTbaseVisitor<String>
{
	protected static class QVTbaseToStringFactory implements ToStringVisitor.Factory
	{
		protected QVTbaseToStringFactory() {
			ToStringVisitor.addFactory(this);
			ToStringVisitor.FACTORY.getClass();
		}

		@Override
		public @NonNull ToStringVisitor createToStringVisitor(@NonNull StringBuilder s) {
			return new QVTbaseToStringVisitor(s);
		}

		@Override
		public @NonNull EPackage getEPackage() {
			QVTbasePackage eInstance = QVTbasePackage.eINSTANCE;
			assert eInstance != null;
			return eInstance;
		}
	}

	public static ToStringVisitor.@NonNull Factory FACTORY = new QVTbaseToStringFactory();

	public QVTbaseToStringVisitor(@NonNull StringBuilder s) {
		super(s);
	}

	@Override
	public String visitBaseModel(@NonNull BaseModel object) {
		append("base model ");
		return null;
	}

	@Override
	public String visitDomain(@NonNull Domain object) {
		appendQualifiedName(object);
		return null;
	}

	@Override
	public String visitFunction(@NonNull Function object) {
		return visitOperation(object);
	}

	@Override
	public String visitFunctionParameter(@NonNull FunctionParameter object) {
		return visitParameter(object);
	}

	@Override
	public String visitOperationCallExp(@NonNull OperationCallExp object) {
		Operation oper = object.getReferredOperation();
		if (!(oper instanceof Function)) {
			return super.visitOperationCallExp(object);
		}
		appendName(oper);
		append("(");
		String prefix = "";//$NON-NLS-1$
		for (OCLExpression argument : object.getOwnedArguments()) {
			append(prefix);
			safeVisit(argument);
			prefix = ", ";//$NON-NLS-1$
		}
		append(")");
		return null;
	}

	@Override
	public String visitPattern(@NonNull Pattern object) {
		append("pattern ");
//		appendName(object);
		return null;
	}

	@Override
	public String visitPredicate(@NonNull Predicate object) {
		safeVisit(object.getConditionExpression());
		return null;
	}

	@Override
	public String visitRule(@NonNull Rule object) {
		appendQualifiedName(object);
		return null;
	}

	@Override
	public String visitTransformation(@NonNull Transformation object) {
		appendQualifiedName(object);
		return null;
	}

	@Override
	public String visitTypedModel(@NonNull TypedModel object) {
		appendName(object);
		return null;
	}

	@Override
	public String visitImport(@NonNull Import object) {
		append("import ");
		appendName(object);
		return null;
	}
}
