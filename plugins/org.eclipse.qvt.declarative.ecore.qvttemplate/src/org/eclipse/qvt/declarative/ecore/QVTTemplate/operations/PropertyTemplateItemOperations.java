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
 * $Id: PropertyTemplateItemOperations.java,v 1.1 2008/12/31 17:43:44 ewillink Exp $
 */
package org.eclipse.qvt.declarative.ecore.QVTTemplate.operations;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.ecore.CollectionType;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.OrderedSetType;
import org.eclipse.ocl.ecore.SequenceType;
import org.eclipse.ocl.ecore.SetType;
import org.eclipse.ocl.ecore.Variable;
import org.eclipse.ocl.ecore.VariableExp;
import org.eclipse.qvt.declarative.ecore.QVTBase.Pattern;
import org.eclipse.qvt.declarative.ecore.QVTTemplate.CollectionTemplateExp;
import org.eclipse.qvt.declarative.ecore.QVTTemplate.ObjectTemplateExp;
import org.eclipse.qvt.declarative.ecore.QVTTemplate.PropertyTemplateItem;



public class PropertyTemplateItemOperations extends AbstractQVTTemplateOperations
{
	public static PropertyTemplateItemOperations INSTANCE = new PropertyTemplateItemOperations();

	/**
	 * Validates the ReferredPropertyIsDefinedByReferredClass constraint of '<em>Property Template Item</em>'.
	 */
	public boolean checkReferredPropertyIsDefinedByReferredClass(PropertyTemplateItem propertyTemplateItem, DiagnosticChain diagnostics, Map<Object, Object> context) {
		ObjectTemplateExp objectTemplateExp = propertyTemplateItem.getObjContainer();
		if (objectTemplateExp == null)
			return true;		// Multiplicity error
		EClass referredClass = objectTemplateExp.getReferredClass();
		if (referredClass == null)
			return true;		// Multiplicity error
		EStructuralFeature referredProperty = propertyTemplateItem.getReferredProperty();
		if (referredProperty == null)
			return true;		// Multiplicity error
		if (propertyTemplateItem.isIsOpposite()) {
			if (definesOppositeProperty(referredClass, (EReference) referredProperty))
				return true;
		}
		else {
			if (definesProperty(referredClass, referredProperty))
				return true;
		}
		Object[] messageSubstitutions = new Object[] { getObjectLabel(referredProperty, context), getObjectLabel(referredClass, context) };
		appendError(diagnostics, objectTemplateExp, QVTTemplateMessages._UI_PropertyTemplateItem_ReferredPropertyIsNotDefinedByReferredClass, messageSubstitutions);
		return false;
	}

	/**
	 * Validates the ValueElementTypeMatchesReferredPropertyElementType constraint of '<em>Property Template Item</em>'.
	 */
	public boolean checkValueElementTypeMatchesReferredPropertyElementType(PropertyTemplateItem propertyTemplateItem, DiagnosticChain diagnostics, Map<Object, Object> context) {
		EClassifier propertyType = getReferredPropertyType(propertyTemplateItem);
		if (propertyType == null)
			return true;		// Multiplicity error
		EClassifier propertyElementType = getElementType(propertyType);
		if (propertyElementType == null)
			return true;		// Multiplicity error
		OCLExpression value = propertyTemplateItem.getValue();
		if (value == null)
			return true;		// Multiplicity error
		EClassifier valueElementType = getElementType(value.getType());
		if (valueElementType == null)
			return true;		// Multiplicity error
		if (assignableToFrom(propertyElementType, valueElementType))
			return true;
		Object[] messageSubstitutions = new Object[] { getObjectLabel(valueElementType, context), getObjectLabel(propertyElementType, context), getObjectLabel(propertyTemplateItem.getReferredProperty(), context) };
		appendError(diagnostics, propertyTemplateItem, QVTTemplateMessages._UI_PropertyTemplateItem_ValueElementTypeDoesNotMatchReferredPropertyElementType, messageSubstitutions);
		return false;
	}

	/**
	 * Validates the SetMatchesSet constraint of '<em>Property Template Item</em>'.
	 */
	public boolean checkSetMatchesSet(PropertyTemplateItem propertyTemplateItem, DiagnosticChain diagnostics, Map<Object, Object> context) {
		OCLExpression value = propertyTemplateItem.getValue();
		if (!(value instanceof CollectionTemplateExp))
			return true;
		CollectionType valueCollectionType = ((CollectionTemplateExp)value).getReferredCollectionType();
		if (!(valueCollectionType instanceof SetType))
			return true;
		EClassifier propertyType = getReferredPropertyType(propertyTemplateItem);
		if (propertyType instanceof SetType)
			return true;
		Object[] messageSubstitutions = new Object[] { getObjectLabel(valueCollectionType, context), getObjectLabel(propertyType, context), getObjectLabel(propertyTemplateItem.getReferredProperty(), context) };
		appendError(diagnostics, propertyTemplateItem, QVTTemplateMessages._UI_PropertyTemplateItem_SetDoesNotMatchSet, messageSubstitutions);
		return false;
	}

	/**
	 * Validates the NonBagMatchesNonBag constraint of '<em>Property Template Item</em>'.
	 */
	public boolean checkNonBagMatchesNonBag(PropertyTemplateItem propertyTemplateItem, DiagnosticChain diagnostics, Map<Object, Object> context) {
		OCLExpression value = propertyTemplateItem.getValue();
		if (!(value instanceof CollectionTemplateExp))
			return true;
		CollectionType valueCollectionType = ((CollectionTemplateExp)value).getReferredCollectionType();
		if (!(valueCollectionType instanceof OrderedSetType) && !(valueCollectionType instanceof SequenceType))
			return true;
		EClassifier propertyType = getReferredPropertyType(propertyTemplateItem);
		if ((propertyType instanceof SequenceType) || (propertyType instanceof OrderedSetType) || (propertyType instanceof SetType))
			return true;
		Object[] messageSubstitutions = new Object[] { getObjectLabel(valueCollectionType, context), getObjectLabel(propertyType, context), getObjectLabel(propertyTemplateItem.getReferredProperty(), context) };
		appendError(diagnostics, propertyTemplateItem, QVTTemplateMessages._UI_PropertyTemplateItem_NonBagDDoesNotMatchNonBag, messageSubstitutions);
		return false;
	}

	/**
	 * Validates the SimpleVariableIsBoundByPattern constraint of '<em>Property Template Item</em>'.
	 */
	public boolean checkSimpleVariableIsBoundByPattern(PropertyTemplateItem propertyTemplateItem, DiagnosticChain diagnostics, Map<Object, Object> context) {
		OCLExpression value = propertyTemplateItem.getValue();
		if (!(value instanceof VariableExp))
			return true;
		Variable variable = (Variable) ((VariableExp)value).getReferredVariable();
		if (variable == null)
			return true;
		Pattern pattern = ObjectTemplateExpOperations.INSTANCE.getPattern(propertyTemplateItem.getObjContainer());
		if (pattern == null)
			return true;		// PatternExists error
		if (pattern.getBindsTo().contains(variable))
			return true;
		Object[] messageSubstitutions = new Object[] { getObjectLabel(variable, context), getObjectLabel(pattern, context) };
		appendError(diagnostics, propertyTemplateItem, QVTTemplateMessages._UI_PropertyTemplateItem_SimpleVariableIsNotBoundByPattern, messageSubstitutions);
		return false;
	}

	protected boolean getReferredPropertyIsOrdered(PropertyTemplateItem propertyTemplateItem) {
		EStructuralFeature referredProperty = propertyTemplateItem.getReferredProperty();
		if (referredProperty == null)
			return false;
		return propertyTemplateItem.isIsOpposite() ? false : referredProperty.isOrdered();
	}

	protected boolean getReferredPropertyIsUnique(PropertyTemplateItem propertyTemplateItem) {
		EStructuralFeature referredProperty = propertyTemplateItem.getReferredProperty();
		if (referredProperty == null)
			return false;
		return propertyTemplateItem.isIsOpposite() ? false : referredProperty.isUnique();
	}

	protected EClassifier getReferredPropertyType(PropertyTemplateItem propertyTemplateItem) {
		EStructuralFeature referredProperty = propertyTemplateItem.getReferredProperty();
		if (referredProperty == null)
			return null;
		if (propertyTemplateItem.isIsOpposite())
			return referredProperty.getEContainingClass();
		return getPropertyType(referredProperty);
	}

	protected boolean getReferredPropertyIsMany(PropertyTemplateItem propertyTemplateItem) {
		EStructuralFeature referredProperty = propertyTemplateItem.getReferredProperty();
		if (referredProperty == null)
			return false;
		return propertyTemplateItem.isIsOpposite() ? false : referredProperty.isMany();
	}
}