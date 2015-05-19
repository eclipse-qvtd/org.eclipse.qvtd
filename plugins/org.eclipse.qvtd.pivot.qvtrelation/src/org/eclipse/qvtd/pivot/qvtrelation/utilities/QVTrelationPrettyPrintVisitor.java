/*******************************************************************************
 * Copyright (c) 2012, 2014 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D. Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtrelation.utilities;

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.internal.prettyprint.PrettyPrinter;
import org.eclipse.qvtd.pivot.qvtrelation.DomainPattern;
import org.eclipse.qvtd.pivot.qvtrelation.Key;
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
	public QVTrelationPrettyPrintVisitor(@NonNull PrettyPrinter context) {
		super(context);
	}

	@Override
	public Object visitDomainPattern(@NonNull DomainPattern object) {
		return super.visitPattern(object);
	}

	@Override
	public Object visitKey(@NonNull Key object) {
		org.eclipse.ocl.pivot.Class identifies = object.getIdentifies();
		if (identifies != null) {
			context.appendQualifiedType(identifies);
		}
		return null;
	}

	@Override
	public Object visitRelation(@NonNull Relation object) {
		return super.visitRule(object);
	}

	@Override
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

	@Override
	public Object visitRelationDomain(@NonNull RelationDomain object) {
		return super.visitDomain(object);
	}

	@Override
	public Object visitRelationDomainAssignment(@NonNull RelationDomainAssignment object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitRelationImplementation(@NonNull RelationImplementation object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visitRelationModel(@NonNull RelationModel object) {
		return super.visitBaseModel(object);
	}

	@Override
	public Object visitRelationalTransformation(@NonNull RelationalTransformation object) {
		return super.visitTransformation(object);
	}
}
