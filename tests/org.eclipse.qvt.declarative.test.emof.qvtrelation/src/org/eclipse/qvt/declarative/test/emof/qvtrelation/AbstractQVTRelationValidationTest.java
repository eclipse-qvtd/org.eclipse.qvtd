/**
 * <copyright>
 * 
 * Copyright (c) 2008 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * E.D.Willink - initial API and implementation
 * 
 * </copyright>
 *
 * $Id: AbstractQVTRelationValidationTest.java,v 1.2 2009/01/14 21:27:49 ewillink Exp $
 */
package org.eclipse.qvt.declarative.test.emof.qvtrelation;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.Variable;
import org.eclipse.qvt.declarative.ecore.QVTBase.TypedModel;
import org.eclipse.qvt.declarative.ecore.QVTRelation.DomainPattern;
import org.eclipse.qvt.declarative.ecore.QVTRelation.Key;
import org.eclipse.qvt.declarative.ecore.QVTRelation.OppositePropertyCallExp;
import org.eclipse.qvt.declarative.ecore.QVTRelation.QVTRelationFactory;
import org.eclipse.qvt.declarative.ecore.QVTRelation.Relation;
import org.eclipse.qvt.declarative.ecore.QVTRelation.RelationCallExp;
import org.eclipse.qvt.declarative.ecore.QVTRelation.RelationDomain;
import org.eclipse.qvt.declarative.ecore.QVTRelation.RelationDomainAssignment;
import org.eclipse.qvt.declarative.ecore.QVTRelation.RelationalTransformation;
import org.eclipse.qvt.declarative.test.emof.qvttemplate.AbstractQVTTemplateValidationTest;

public abstract class AbstractQVTRelationValidationTest extends AbstractQVTTemplateValidationTest
{
	public static final QVTRelationFactory QVTr_Factory = QVTRelationFactory.eINSTANCE;

	protected DomainPattern createDomainPattern(RelationDomain relationDomain) {
		DomainPattern domainPattern = QVTr_Factory.createDomainPattern();
		if (relationDomain != null)
			relationDomain.setPattern(domainPattern);
		return domainPattern;
	}

	protected Key createKey(RelationalTransformation transformation, EClass identifies, EStructuralFeature... features) {
		Key key = QVTr_Factory.createKey();
		key.setIdentifies(identifies);
		if (transformation != null)
			transformation.getOwnedKey().add(key);
		if (features != null) {
			for (EStructuralFeature feature : features)
				key.getPart().add(feature);
		}
		return key;
	}

	protected OppositePropertyCallExp createOppositePropertyCallExp(OCLExpression source, EStructuralFeature property) {
		OppositePropertyCallExp expr = QVTr_Factory.createOppositePropertyCallExp();
		if (source != null)
			expr.setSource(source);
		if (property != null) {
			expr.setReferredProperty(property);
			expr.setEType(property.getEContainingClass());
		}
		return expr;
	}

	protected Relation createRelation(RelationalTransformation transformation, String name) {
		Relation relation = QVTr_Factory.createRelation();
		relation.setName(name);
		if (transformation != null)
			transformation.getRule().add(relation);
		return relation;
	}

	protected RelationCallExp createRelationCallExp(Relation relation, OCLExpression... arguments) {
		RelationCallExp relationCallExp = QVTr_Factory.createRelationCallExp();
		relationCallExp.setEType(getBooleanType());
		if (relation != null)
			relationCallExp.setReferredRelation(relation);
		if (arguments != null) {
			for (OCLExpression argument : arguments)
				relationCallExp.getArgument().add(argument);
		}
		return relationCallExp;
	}

	protected RelationDomain createRelationDomain(Relation relation, String name, TypedModel typedModel, String rootVariableName, EClassifier rootVariableType) {
		RelationDomain relationDomain = QVTr_Factory.createRelationDomain();
		relationDomain.setName(name);
		if (typedModel != null)
			relationDomain.setTypedModel(typedModel);
		if (relation != null) {
			relation.getDomain().add(relationDomain);
			if ((rootVariableName != null) && (rootVariableType != null)) {
				Variable variable = createVariable(relation.getVariable(), rootVariableName, rootVariableType);
				relationDomain.setRootVariable(variable);
			}
		}
		relationDomain.setIsCheckable(true);
		relationDomain.setIsEnforceable(true);
		return relationDomain;
	}

	protected RelationDomainAssignment createRelationDomainAssignment(RelationDomain domain, Variable variable, OCLExpression value) {
		RelationDomainAssignment assignment = QVTr_Factory.createRelationDomainAssignment();
		if (variable != null)
			assignment.setVariable(variable);
		if (value != null)
			assignment.setValueExp(value);
		if (domain != null)
			domain.getDefaultAssignment().add(assignment);
		return assignment;
	}

	protected RelationalTransformation createRelationalTransformation(Resource resource, String name) {
		RelationalTransformation transformation = QVTr_Factory.createRelationalTransformation();
		transformation.setName(name);
		if (resource != null)
			resource.getContents().add(transformation);
		return transformation;
	}
}
