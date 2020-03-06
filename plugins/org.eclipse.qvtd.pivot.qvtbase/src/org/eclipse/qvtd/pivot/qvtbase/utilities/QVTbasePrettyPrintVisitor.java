/*******************************************************************************
 * Copyright (c) 2012, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D. Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtbase.utilities;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Import;
import org.eclipse.ocl.pivot.internal.prettyprint.EssentialOCLPrettyPrintVisitor;
import org.eclipse.ocl.pivot.internal.prettyprint.PrettyPrinter;
import org.eclipse.qvtd.pivot.qvtbase.BaseModel;
import org.eclipse.qvtd.pivot.qvtbase.CompoundTargetElement;
import org.eclipse.qvtd.pivot.qvtbase.Target;
import org.eclipse.qvtd.pivot.qvtbase.TargetElement;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.Function;
import org.eclipse.qvtd.pivot.qvtbase.FunctionBody;
import org.eclipse.qvtd.pivot.qvtbase.FunctionParameter;
import org.eclipse.qvtd.pivot.qvtbase.Pattern;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.SimpleTargetElement;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.util.QVTbaseVisitor;

public class QVTbasePrettyPrintVisitor extends EssentialOCLPrettyPrintVisitor implements QVTbaseVisitor<Object>
{
	public QVTbasePrettyPrintVisitor(@NonNull PrettyPrinter context) {
		super(context);
	}

	@Override
	public Object visitBaseModel(@NonNull BaseModel object) {
		return super.visitModel(object);
	}

	@Override
	public Object visitCompoundTargetElement(@NonNull CompoundTargetElement object) {
		return null;
	}

	@Override
	public Object visitDomain(@NonNull Domain object) {
		context.appendName(object.getTypedModel());
		return null;
	}

	@Override
	public Object visitFunction(@NonNull Function object) {
		return super.visitOperation(object);
	}

	@Override
	public Object visitFunctionBody(@NonNull FunctionBody object) {
		return super.visitExpressionInOCL(object);
	}

	@Override
	public Object visitFunctionParameter(@NonNull FunctionParameter object) {
		return super.visitParameter(object);
	}

	@Override
	public Object visitImport(@NonNull Import object) {
		context.appendName(object);
		return null;
	}

	@Override
	public Object visitPattern(@NonNull Pattern object) {
		return null;
	}

	@Override
	public Object visitPredicate(@NonNull Predicate object) {
		return null;
	}

	@Override
	public Object visitRule(@NonNull Rule object) {
		context.appendName(object);
		return null;
	}

	@Override
	public Object visitSimpleTargetElement(@NonNull SimpleTargetElement object) {
		return null;
	}

	@Override
	public Object visitTarget(@NonNull Target object) {
		return null;
	}

	@Override
	public Object visitTargetElement(@NonNull TargetElement object) {
		return null;
	}

	@Override
	public Object visitTransformation(@NonNull Transformation object) {
		return super.visitClass(object);
	}

	@Override
	public Object visitTypedModel(@NonNull TypedModel object) {
		context.appendName(object);
		return null;
	}
}
