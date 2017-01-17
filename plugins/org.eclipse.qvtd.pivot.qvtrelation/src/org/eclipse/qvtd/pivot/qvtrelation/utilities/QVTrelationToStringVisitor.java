/*******************************************************************************
 * Copyright (c) 2012, 2016 E.D. Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D. Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtrelation.utilities;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.utilities.ToStringVisitor;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtrelation.DomainPattern;
import org.eclipse.qvtd.pivot.qvtrelation.Key;
import org.eclipse.qvtd.pivot.qvtrelation.QVTrelationPackage;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationCallExp;
import org.eclipse.qvtd.pivot.qvtrelation.RelationDomain;
import org.eclipse.qvtd.pivot.qvtrelation.RelationDomainAssignment;
import org.eclipse.qvtd.pivot.qvtrelation.RelationImplementation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationModel;
import org.eclipse.qvtd.pivot.qvtrelation.RelationalTransformation;
import org.eclipse.qvtd.pivot.qvtrelation.SharedVariable;
import org.eclipse.qvtd.pivot.qvtrelation.TemplateVariable;
import org.eclipse.qvtd.pivot.qvtrelation.util.QVTrelationVisitor;
import org.eclipse.qvtd.pivot.qvttemplate.utilities.QVTtemplateToStringVisitor;

/**
 * Converts an OCL expression to a string for debugging. This is not intended to
 * be used by client applications as an AST-to-text transformation.
 */
public class QVTrelationToStringVisitor extends QVTtemplateToStringVisitor implements QVTrelationVisitor<String>
{
	protected static class QVTrelationToStringFactory implements QVTtemplateToStringVisitor.Factory
	{
		protected QVTrelationToStringFactory() {
			ToStringVisitor.addFactory(this);
			QVTtemplateToStringVisitor.FACTORY.getClass();
		}

		@Override
		public @NonNull ToStringVisitor createToStringVisitor(@NonNull StringBuilder s) {
			return new QVTrelationToStringVisitor(s);
		}

		@Override
		public @NonNull EPackage getEPackage() {
			QVTrelationPackage eInstance = QVTrelationPackage.eINSTANCE;
			assert eInstance != null;
			return eInstance;
		}
	}

	public static ToStringVisitor.@NonNull Factory FACTORY = new QVTrelationToStringFactory();

	public QVTrelationToStringVisitor(@NonNull StringBuilder s) {
		super(s);
	}

	@Override
	public String visitDomainPattern(@NonNull DomainPattern object) {
		safeVisit(object.getTemplateExpression());
		return null;
	}

	@Override
	public String visitKey(@NonNull Key object) {
		append("key ");
		safeVisit(object.getIdentifies());
		append(" ");
		append("{");
		boolean isFirst = true;
		for (Property part : object.getPart()) {
			if (!isFirst) {
				append(", ");
			}
			safeVisit(part);
			isFirst = false;
		}
		for (Property part : object.getOppositePart()) {
			if (!isFirst) {
				append(", ");
			}
			append("opposite ");
			safeVisit(part);
			isFirst = false;
		}
		append("}");
		return null;
	}

	@Override
	public String visitRelation(@NonNull Relation object) {
		if (object.isIsTopLevel()) {
			append("top ");
		}
		append("relation ");
		appendName(object);
		return null;
	}

	@Override
	public String visitRelationCallExp(@NonNull RelationCallExp object) {
		appendName(object.getReferredRelation());
		append("(");
		boolean isFirst = true;
		for (OCLExpression argument : object.getArgument()) {
			if (!isFirst) {
				append(", ");
			}
			safeVisit(argument);
			isFirst = false;
		}
		append(")");
		return null;
	}

	@Override
	public String visitRelationDomain(@NonNull RelationDomain object) {
		if (object.isIsCheckable()) {
			append("check ");
		}
		if (object.isIsEnforceable()) {
			append("enforce ");
		}
		append("domain ");
		appendName(object);
		/*		append(" ");
		boolean isFirst = true;
		for (DomainPattern pattern : object.getPattern()) {
			if (!isFirst) {
				append(", ");
			}
			safeVisit(pattern);
			isFirst = false;
		}
		append(";"); */
		return null;
	}

	@Override
	public String visitRelationDomainAssignment(@NonNull RelationDomainAssignment object) {
		return null;
	}

	@Override
	public String visitRelationImplementation(@NonNull RelationImplementation object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitRelationModel(@NonNull RelationModel object) {
		append("RelationModel " + object.getName());
		return null;
	}

	@Override
	public String visitRelationalTransformation(@NonNull RelationalTransformation object) {
		append("transformation ");
		appendName(object);
		append("(");
		boolean isFirst = true;
		for (TypedModel typedModel : object.getModelParameter()) {
			if (!isFirst) {
				append(", ");
			}
			safeVisit(typedModel);
			isFirst = false;
		}
		append(")");
		return null;
	}

	@Override
	public String visitSharedVariable(@NonNull SharedVariable object) {
		return visitVariable(object);
	}

	@Override
	public String visitTemplateVariable(@NonNull TemplateVariable object) {
		return visitVariable(object);
	}
}
