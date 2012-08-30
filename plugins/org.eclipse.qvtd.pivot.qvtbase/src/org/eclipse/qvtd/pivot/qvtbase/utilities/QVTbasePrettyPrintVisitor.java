/**
 * <copyright>
 *
 * Copyright (c) 2012 E.D.Willink and others.
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

		public AbstractVisitor<Object, PrettyPrinter> createPrettyPrintVisitor(PrettyPrinter printer) {
			return new QVTbasePrettyPrintVisitor(printer);
		}
	}

	public static PrettyPrinter.Factory FACTORY = new Factory();

	public QVTbasePrettyPrintVisitor(PrettyPrinter context) {
		super(context);
	}

	public Object visitBaseModel(BaseModel object) {
		return super.visitRoot(object);
	}

	public Object visitDomain(Domain object) {
		context.appendName(object.getTypedModel());
		return null;
	}

	public Object visitFunction(Function object) {
		return super.visitOperation(object);
	}

	public Object visitFunctionParameter(FunctionParameter object) {
		return super.visitParameter(object);
	}

	public Object visitPattern(Pattern object) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object visitPredicate(Predicate object) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object visitRule(Rule object) {
		context.appendName(object);
		return null;
	}

	public Object visitTransformation(Transformation object) {
		return super.visitPackage(object);
	}

	public Object visitTypedModel(TypedModel object) {
		context.appendName(object);
		return null;
	}

	public Object visitUnit(Unit object) {
		context.appendName(object);
		return null;
	}
}
