/**
 * <copyright>
 *
 * Copyright (c) 2012 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
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

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.prettyprint.EssentialOCLPrettyPrintVisitor;
import org.eclipse.ocl.examples.pivot.prettyprint.PrettyPrinter;
import org.eclipse.ocl.examples.pivot.util.AbstractVisitor;
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

public class QVTbasePrettyPrintVisitor extends EssentialOCLPrettyPrintVisitor implements QVTbaseVisitor<Object>
{	
	private static final class Factory implements PrettyPrinter.Factory
	{
		private Factory() {
			EssentialOCLPrettyPrintVisitor.FACTORY.getClass();
			PrettyPrinter.addFactory(QVTbasePackage.eINSTANCE, this);
		}

		public @NonNull AbstractVisitor<Object, PrettyPrinter> createPrettyPrintVisitor(@NonNull PrettyPrinter printer) {
			return new QVTbasePrettyPrintVisitor(printer);
		}
	}

	public static @NonNull PrettyPrinter.Factory FACTORY = new Factory();

	public QVTbasePrettyPrintVisitor(@NonNull PrettyPrinter context) {
		super(context);
	}

	public Object visitBaseModel(@NonNull BaseModel object) {
		return super.visitRoot(object);
	}

	public Object visitDomain(@NonNull Domain object) {
		context.appendName(object.getTypedModel());
		return null;
	}

	public Object visitFunction(@NonNull Function object) {
		return super.visitOperation(object);
	}

	public Object visitFunctionParameter(@NonNull FunctionParameter object) {
		return super.visitParameter(object);
	}

	public Object visitPattern(@NonNull Pattern object) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object visitPredicate(@NonNull Predicate object) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object visitRule(@NonNull Rule object) {
		context.appendName(object);
		return null;
	}

	public Object visitTransformation(@NonNull Transformation object) {
		return super.visitPackage(object);
	}

	public Object visitTypedModel(@NonNull TypedModel object) {
		context.appendName(object);
		return null;
	}

	public Object visitUnit(@NonNull Unit object) {
		context.appendName(object);
		return null;
	}
}
