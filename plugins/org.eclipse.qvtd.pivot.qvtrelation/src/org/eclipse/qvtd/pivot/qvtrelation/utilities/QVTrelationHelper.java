/*******************************************************************************
 * Copyright (c) 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtrelation.utilities;

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.StandardLibrary;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtbase.Pattern;
import org.eclipse.qvtd.pivot.qvtbase.QVTbaseFactory;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseHelper;
import org.eclipse.qvtd.pivot.qvtrelation.DomainPattern;
import org.eclipse.qvtd.pivot.qvtrelation.Key;
import org.eclipse.qvtd.pivot.qvtrelation.QVTrelationFactory;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationCallExp;
import org.eclipse.qvtd.pivot.qvtrelation.RelationDomain;
import org.eclipse.qvtd.pivot.qvtrelation.RelationalTransformation;
import org.eclipse.qvtd.pivot.qvtrelation.SharedVariable;
import org.eclipse.qvtd.pivot.qvtrelation.TemplateVariable;
import org.eclipse.qvtd.pivot.qvttemplate.CollectionTemplateExp;
import org.eclipse.qvtd.pivot.qvttemplate.ObjectTemplateExp;
import org.eclipse.qvtd.pivot.qvttemplate.PropertyTemplateItem;
import org.eclipse.qvtd.pivot.qvttemplate.QVTtemplateFactory;
import org.eclipse.qvtd.pivot.qvttemplate.TemplateExp;

import com.google.common.collect.Iterables;

/**
 * QVTrelationHelper provides helper routines to assist creation of QVTrelation model elements.
 */
public class QVTrelationHelper extends QVTbaseHelper
{
	public QVTrelationHelper(@NonNull EnvironmentFactory environmentFactory) {
		super(environmentFactory);
	}

	public void addWhenPredicate(@NonNull Relation qvtrRelation, @NonNull RelationCallExp asRelationCallExp) {
		Pattern asPattern = qvtrRelation.getWhen();
		if (asPattern == null) {
			asPattern = QVTbaseFactory.eINSTANCE.createPattern();
			qvtrRelation.setWhen(asPattern);
		}
		asPattern.getPredicate().add(createPredicate(asRelationCallExp));
	}

	public void addWherePredicate(@NonNull Relation qvtrRelation, @NonNull RelationCallExp asRelationCallExp) {
		Pattern asPattern = qvtrRelation.getWhere();
		if (asPattern == null) {
			asPattern = QVTbaseFactory.eINSTANCE.createPattern();
			qvtrRelation.setWhere(asPattern);
		}
		asPattern.getPredicate().add(createPredicate(asRelationCallExp));
	}

	/**
	 * Traverse the templateExp hierarchy assigning all special variables (_) to specialVariables allocating a distinctive name to each.
	 * Append special member variables to relationVariables as well.
	 */
	public void computeBoundVariables(@NonNull List<@NonNull Variable> boundVariables, @NonNull OCLExpression asExpression) {
		if (asExpression instanceof ObjectTemplateExp) {
			ObjectTemplateExp asObjectTemplateExp = (ObjectTemplateExp)asExpression;
			Variable asBoundVariable = QVTrelationUtil.getBindsTo(asObjectTemplateExp);
			if (!boundVariables.contains(asBoundVariable)) {
				boundVariables.add(asBoundVariable);
			}
			for (@NonNull PropertyTemplateItem asPart : QVTrelationUtil.getOwnedParts(asObjectTemplateExp)) {
				computeBoundVariables(boundVariables, QVTrelationUtil.getOwnedValue(asPart));
			}
		}
		else if (asExpression instanceof CollectionTemplateExp) {
			CollectionTemplateExp asCollectionTemplateExp = (CollectionTemplateExp)asExpression;
			Variable asBoundVariable = QVTrelationUtil.getBindsTo(asCollectionTemplateExp);
			if (!boundVariables.contains(asBoundVariable)) {
				boundVariables.add(asBoundVariable);
			}
			for (@NonNull OCLExpression asMemberExpression : QVTrelationUtil.getOwnedMembers(asCollectionTemplateExp)) {
				computeBoundVariables(boundVariables, asMemberExpression);
			}
		}
		//		else if (asExpression instanceof VariableExp) {			// FIXME temporary test compatibility
		//			Variable asVariable = QVTrelationUtil.getReferredVariable((VariableExp)asExpression);
		//			if (!boundVariables.contains(asVariable)) {
		//				boundVariables.add(asVariable);
		//			}
		//		}
	}

	public @NonNull CollectionTemplateExp createCollectionTemplateExp(@NonNull TemplateVariable asTemplateVariable, org.eclipse.ocl.pivot.@NonNull Class asClass, boolean isRequired) {
		CollectionTemplateExp asCollectionTemplateExp = QVTtemplateFactory.eINSTANCE.createCollectionTemplateExp();
		//		asObjectTemplateExp.setName(PivotUtil.getName(asTemplateVariable));
		asCollectionTemplateExp.setType(asClass);
		asCollectionTemplateExp.setReferredCollectionType((CollectionType)asClass);
		asCollectionTemplateExp.setIsRequired(isRequired);
		asCollectionTemplateExp.setBindsTo(asTemplateVariable);
		return asCollectionTemplateExp;
	}

	public @NonNull DomainPattern createDomainPattern(TemplateExp asTemplateExp) {
		DomainPattern asDomainPattern = QVTrelationFactory.eINSTANCE.createDomainPattern();
		asDomainPattern.setTemplateExpression(asTemplateExp);
		return asDomainPattern;
	}

	public @NonNull Key createKey(org.eclipse.ocl.pivot.@NonNull Class asClass, @NonNull Iterable<@NonNull Property> asProperties) {
		Key asKey = QVTrelationFactory.eINSTANCE.createKey();
		asKey.setIdentifies(asClass);
		Iterables.addAll(QVTrelationUtil.Internal.getOwnedPartsList(asKey), asProperties);
		return asKey;
	}

	public @NonNull ObjectTemplateExp createObjectTemplateExp(@NonNull TemplateVariable asTemplateVariable, org.eclipse.ocl.pivot.@NonNull Class asClass, boolean isRequired) {
		ObjectTemplateExp asObjectTemplateExp = QVTtemplateFactory.eINSTANCE.createObjectTemplateExp();
		//		asObjectTemplateExp.setName(PivotUtil.getName(asTemplateVariable));
		asObjectTemplateExp.setType(asClass);
		asObjectTemplateExp.setReferredClass(asClass);
		asObjectTemplateExp.setIsRequired(isRequired);
		asObjectTemplateExp.setBindsTo(asTemplateVariable);
		return asObjectTemplateExp;
	}

	public @NonNull PropertyTemplateItem createPropertyTemplateItem(@NonNull Property asProperty, @NonNull OCLExpression asExpression) {
		PropertyTemplateItem asPropertyTemplateItem = QVTtemplateFactory.eINSTANCE.createPropertyTemplateItem();
		asPropertyTemplateItem.setReferredProperty(asProperty);
		asPropertyTemplateItem.setValue(asExpression);
		return asPropertyTemplateItem;
	}

	public @NonNull Relation createRelation(@NonNull String name, @NonNull Iterable<@NonNull RelationDomain> asRelationDomains) {
		Relation asRelation = QVTrelationFactory.eINSTANCE.createRelation();
		asRelation.setName(name);
		Iterables.addAll(QVTrelationUtil.Internal.getOwnedDomainsList(asRelation), asRelationDomains);
		return asRelation;
	}

	public @NonNull RelationCallExp createRelationCallExp(Relation asRelation, @NonNull List<? extends @NonNull OCLExpression> asArguments) {
		RelationCallExp asRelationCallExp = QVTrelationFactory.eINSTANCE.createRelationCallExp();
		asRelationCallExp.setReferredRelation(asRelation);
		Iterables.addAll(QVTrelationUtil.Internal.getOwnedArgumentsList(asRelationCallExp), asArguments);
		asRelationCallExp.setType(environmentFactory.getStandardLibrary().getBooleanType());
		asRelationCallExp.setIsRequired(true);;
		return asRelationCallExp;
	}

	public @NonNull RelationDomain createRelationDomain(@NonNull TypedModel asTypedModel) {
		RelationDomain asRelationDomain = QVTrelationFactory.eINSTANCE.createRelationDomain();
		asRelationDomain.setTypedModel(asTypedModel);
		return asRelationDomain;
	}

	public @NonNull RelationalTransformation createRelationalTransformation(@NonNull String name, @NonNull Iterable<@NonNull TypedModel> asTypedModels) {
		StandardLibrary standardLibrary = environmentFactory.getStandardLibrary();
		RelationalTransformation asRelationalTransformation = QVTrelationFactory.eINSTANCE.createRelationalTransformation();
		asRelationalTransformation.setName(name);
		Iterables.addAll(QVTrelationUtil.Internal.getModelParameterList(asRelationalTransformation), asTypedModels);
		asRelationalTransformation.getSuperClasses().add(standardLibrary.getOclElementType());
		return asRelationalTransformation;
	}

	public @NonNull SharedVariable createSharedVariable(@Nullable String name, @NonNull Type asType, boolean isRequired, @Nullable OCLExpression asInitExpression) {
		SharedVariable asVariable = QVTrelationFactory.eINSTANCE.createSharedVariable();
		asVariable.setName(name);
		asVariable.setType(asType);
		asVariable.setIsImplicit(name == null);
		asVariable.setIsRequired(isRequired);
		asVariable.setOwnedInit(asInitExpression);
		return asVariable;
	}

	public @NonNull TemplateVariable createTemplateVariable(@NonNull String name, @NonNull Type asType, boolean isRequired, @Nullable OCLExpression asInitExpression) {
		TemplateVariable asVariable = QVTrelationFactory.eINSTANCE.createTemplateVariable();
		asVariable.setName(name);
		asVariable.setType(asType);
		asVariable.setIsRequired(isRequired);
		asVariable.setOwnedInit(asInitExpression);
		return asVariable;
	}
}