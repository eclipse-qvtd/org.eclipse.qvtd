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

		public AbstractVisitor<Object, PrettyPrinter> createPrettyPrintVisitor(PrettyPrinter printer) {
			return new QVTrelationPrettyPrintVisitor(printer);
		}
	}

	public static PrettyPrinter.Factory FACTORY = new Factory();

	public QVTrelationPrettyPrintVisitor(PrettyPrinter context) {
		super(context);
	}

	public Object visitDomainPattern(DomainPattern object) {
		return super.visitPattern(object);
	}

	public Object visitKey(Key object) {
		context.appendQualifiedType(object.getIdentifies());
		return null;
	}

	public Object visitOppositePropertyCallExp(OppositePropertyCallExp object) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object visitRelation(Relation object) {
		return super.visitRule(object);
	}

	public Object visitRelationCallExp(RelationCallExp object) {
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

	public Object visitRelationDomain(RelationDomain object) {
		return super.visitDomain(object);
	}

	public Object visitRelationDomainAssignment(RelationDomainAssignment object) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object visitRelationImplementation(RelationImplementation object) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object visitRelationModel(RelationModel object) {
		return super.visitBaseModel(object);
	}

	public Object visitRelationalTransformation(RelationalTransformation object) {
		return super.visitTransformation(object);
	}
}
