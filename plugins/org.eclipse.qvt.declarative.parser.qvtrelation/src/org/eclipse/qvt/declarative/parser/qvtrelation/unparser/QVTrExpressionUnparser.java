/*******************************************************************************
 * Copyright (c) 2007 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvt.declarative.parser.qvtrelation.unparser;

import java.util.List;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.CollectionType;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.PrimitiveType;
import org.eclipse.ocl.ecore.SendSignalAction;
import org.eclipse.ocl.ecore.Variable;
import org.eclipse.ocl.ecore.util.EcoreSwitch;
import org.eclipse.ocl.utilities.UMLReflection;
import org.eclipse.qvt.declarative.ecore.QVTRelation.RelationCallExp;
import org.eclipse.qvt.declarative.ecore.QVTRelation.util.QVTRelationSwitch;
import org.eclipse.qvt.declarative.ecore.QVTTemplate.CollectionTemplateExp;
import org.eclipse.qvt.declarative.ecore.QVTTemplate.ObjectTemplateExp;
import org.eclipse.qvt.declarative.ecore.QVTTemplate.PropertyTemplateItem;
import org.eclipse.qvt.declarative.ecore.QVTTemplate.TemplateExp;
import org.eclipse.qvt.declarative.ecore.QVTTemplate.util.QVTTemplateSwitch;
import org.eclipse.qvt.declarative.parser.unparser.OCLExpressionUnparser;

public abstract class QVTrExpressionUnparser extends OCLExpressionUnparser
{
	protected class QVTrExpressionUnparserSwitch extends OCLExpressionUnparserSwitch
	{
		@Override public Object caseOCLExpression(OCLExpression object) {
			if (object instanceof TemplateExp)
				return templateSwitch.doSwitch(object);
			if (object instanceof RelationCallExp)
				return relationSwitch.doSwitch(object);
			return super.caseOCLExpression(object);
		}
	}

	protected class QVTrRelationUnparserSwitch extends QVTRelationSwitch<Object>
	{
		@Override public Object caseRelationCallExp(RelationCallExp object) {
			unparseRelationCallExp(object);
			return this;
		}

		@Override public Object defaultCase(EObject object) {
			append("\n***" + getClass().getSimpleName() + "-Unsupported-" + object.getClass().getSimpleName() + "***\n");
			return this;
		}
	}

	protected class QVTrTemplateUnparserSwitch extends QVTTemplateSwitch<Object>
	{
		@Override public Object caseCollectionTemplateExp(CollectionTemplateExp object) {
			unparseCollectionTemplateExp(object);
			return this;
		}

		@Override public Object caseObjectTemplateExp(ObjectTemplateExp object) {
			unparseObjectTemplateExp(object);
			return this;
		}

		@Override public Object casePropertyTemplateItem(PropertyTemplateItem object) {
			unparsePropertyTemplateItem(object);
			return this;
		}

		@Override public Object defaultCase(EObject object) {
			append("\n***" + getClass().getSimpleName() + "-Unsupported-" + object.getClass().getSimpleName() + "***\n");
			return this;
		}
	}

	private QVTRelationSwitch<Object> relationSwitch = null;	
	private QVTTemplateSwitch<Object> templateSwitch = null;
	
	public QVTrExpressionUnparser(Resource resource, UMLReflection<?, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint> uml) {
		super(resource, uml);
	}

	@Override protected EcoreSwitch<Object> createExpressionSwitch() {
		return new QVTrExpressionUnparserSwitch();
	}

	protected QVTRelationSwitch<Object> createRelationSwitch() {
		return new QVTrRelationUnparserSwitch();
	}

	protected QVTTemplateSwitch<Object> createTemplateSwitch() {
		return new QVTrTemplateUnparserSwitch();
	}

	protected Object doRelationSwitch(OCLExpression oclExpression) {
		if (oclExpression != null)
			return relationSwitch.doSwitch(oclExpression);
		else
			append("_null_relation_");		
		return this;
	}

	protected Object doTemplateSwitch(OCLExpression oclExpression) {
		if (oclExpression != null)
			return templateSwitch.doSwitch(oclExpression);
		else
			append("_null_template_");		
		return this;
	}

	@Override protected String formatQualifiedName(Object object) {
		if (object instanceof CollectionType)
			return super.formatName(object);
		else if (object instanceof PrimitiveType)
			return super.formatName(object);
		else
			return super.formatQualifiedName(object);
	}

	@Override protected void initialize() {
		super.initialize();
		if (relationSwitch == null)
			relationSwitch = createRelationSwitch();
		if (templateSwitch == null)
			templateSwitch = createTemplateSwitch();
	}

	protected void unparseCollectionTemplateExp(CollectionTemplateExp templateExpression) {
		if (templateExpression == null)
			return;
		Variable variable = templateExpression.getBindsTo();
		if (variable != null)
			unparseVariable(variable);
		else {							// Perhaps a ObjectTemplateExp as a literal
			appendName(templateExpression);
			append(" : ");
			appendName(templateExpression.getType());
		}
		List<OCLExpression> parts = templateExpression.getMember();
		append(" {");
		if (parts.size() > 0) {
			append("\n");
			indent();
			doExpressionsSwitch(parts, ",\n");
			append(" ++ ");
			doExpressionSwitch(templateExpression.getRest());
			exdent();
			append("\n");
		}
		append("}");
	}

	protected void unparseObjectTemplateExp(ObjectTemplateExp templateExpression) {
		if (templateExpression == null)
			return;
		Variable variable = templateExpression.getBindsTo();
		if (variable != null)
			unparseVariable(variable);
		else {							// Perhaps a ObjectTemplateExp as a literal
			appendName(templateExpression);
			append(" : ");
			appendName(templateExpression.getType());
		}
		List<PropertyTemplateItem> parts = templateExpression.getPart();
		if (parts.size() > 0) {
			append(" {\n");
			indent();
			boolean first = true;
			for (PropertyTemplateItem part : parts) {
				if (!first)
					append(",\n");
				unparsePropertyTemplateItem(part);
				first = false;
			}
			exdent();
			append("\n}");
		}
		else
			append(" {}");
	}

	protected void unparsePropertyTemplateItem(PropertyTemplateItem part) {
		EStructuralFeature property = part.getReferredProperty();
		appendName(property);
		append(" = ");
		doExpressionSwitch(part.getValue());		
	}

	protected void unparseRelationCallExp(RelationCallExp object) {
		if (object == null)
			append("_null_relation_call_");
		else {		       
			appendName(object.getReferredRelation());
			append("(");
			doExpressionsSwitch(object.getArgument(), ", ");
			append(")");
		}
	}
}
