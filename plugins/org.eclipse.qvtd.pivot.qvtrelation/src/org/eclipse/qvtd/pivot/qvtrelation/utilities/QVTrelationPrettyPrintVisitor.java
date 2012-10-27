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
package org.eclipse.qvtd.pivot.qvtrelation.utilities;

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.prettyprint.PrettyPrinter;
import org.eclipse.ocl.examples.pivot.util.AbstractVisitor;
import org.eclipse.qvtd.pivot.qvtrelation.DomainPattern;
import org.eclipse.qvtd.pivot.qvtrelation.Key;
import org.eclipse.qvtd.pivot.qvtrelation.OppositePropertyCallExp;
import org.eclipse.qvtd.pivot.qvtrelation.QVTrelationPackage;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationCallExp;
import org.eclipse.qvtd.pivot.qvtrelation.RelationDomain;
import org.eclipse.qvtd.pivot.qvtrelation.RelationDomainAssignment;
import org.eclipse.qvtd.pivot.qvtrelation.RelationImplementation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationModel;
import org.eclipse.qvtd.pivot.qvtrelation.RelationalTransformation;
import org.eclipse.qvtd.pivot.qvtrelation.util.QVTrelationVisitor;
import org.eclipse.qvtd.pivot.qvttemplate.utilities.QVTtemplatePrettyPrintVisitor;

public class QVTrelationPrettyPrintVisitor extends QVTtemplatePrettyPrintVisitor implements QVTrelationVisitor<Object>
{	
	private static final class Factory implements PrettyPrinter.Factory
	{
		private Factory() {
			QVTtemplatePrettyPrintVisitor.FACTORY.getClass();
			PrettyPrinter.addFactory(QVTrelationPackage.eINSTANCE, this);
		}

		public @NonNull AbstractVisitor<Object, PrettyPrinter> createPrettyPrintVisitor(@NonNull PrettyPrinter printer) {
			return new QVTrelationPrettyPrintVisitor(printer);
		}
	}

	public static @NonNull PrettyPrinter.Factory FACTORY = new Factory();

	public QVTrelationPrettyPrintVisitor(@NonNull PrettyPrinter context) {
		super(context);
	}

	public Object visitDomainPattern(@NonNull DomainPattern object) {
		return super.visitPattern(object);
	}

	public Object visitKey(@NonNull Key object) {
		org.eclipse.ocl.examples.pivot.Class identifies = object.getIdentifies();
		if (identifies != null) {
			context.appendQualifiedType(identifies);
		}
		return null;
	}

	public Object visitOppositePropertyCallExp(@NonNull OppositePropertyCallExp object) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object visitRelation(@NonNull Relation object) {
		return super.visitRule(object);
	}

	public Object visitRelationCallExp(@NonNull RelationCallExp object) {
		List<OCLExpression> arguments = object.getArgument();
		Relation referredRelation = object.getReferredRelation();
		context.appendName(referredRelation);
		context.push("(", "");
		String prefix = null; //$NON-NLS-1$
		for (OCLExpression argument : arguments) {
			if (prefix != null) {
				context.next(null, prefix, " ");
			}
			context.precedenceVisit(argument, null);
			prefix = ",";
		}
		context.next("", ")", "");
		context.pop();
		return null;
	}

	public Object visitRelationDomain(@NonNull RelationDomain object) {
		return super.visitDomain(object);
	}

	public Object visitRelationDomainAssignment(@NonNull RelationDomainAssignment object) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object visitRelationImplementation(@NonNull RelationImplementation object) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object visitRelationModel(@NonNull RelationModel object) {
		return super.visitBaseModel(object);
	}

	public Object visitRelationalTransformation(@NonNull RelationalTransformation object) {
		return super.visitTransformation(object);
	}
}
