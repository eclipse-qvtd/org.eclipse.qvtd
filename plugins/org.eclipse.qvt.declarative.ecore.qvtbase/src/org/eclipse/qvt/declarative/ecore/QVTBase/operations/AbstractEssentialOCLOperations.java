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
 * $Id: AbstractEssentialOCLOperations.java,v 1.1 2008/12/31 17:42:29 ewillink Exp $
 */
package org.eclipse.qvt.declarative.ecore.QVTBase.operations;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.CollectionLiteralPart;
import org.eclipse.ocl.ecore.CollectionType;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.EcoreEnvironment;
import org.eclipse.ocl.ecore.EcoreEnvironmentFactory;
import org.eclipse.ocl.ecore.IterateExp;
import org.eclipse.ocl.ecore.LetExp;
import org.eclipse.ocl.ecore.LoopExp;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.SendSignalAction;
import org.eclipse.ocl.ecore.TupleLiteralPart;
import org.eclipse.ocl.ecore.Variable;
import org.eclipse.ocl.ecore.VariableExp;
import org.eclipse.ocl.types.OCLStandardLibrary;
import org.eclipse.ocl.utilities.UMLReflection;
import org.eclipse.qvt.declarative.ecore.operations.AbstractValidatorOperations;
import org.eclipse.qvt.declarative.ecore.operations.EValidatorWithOperations;

public class AbstractEssentialOCLOperations extends AbstractValidatorOperations
{
	private static final EcoreEnvironment ecoreEnvironment = (EcoreEnvironment) EcoreEnvironmentFactory.INSTANCE.createEnvironment();
	private static final OCLStandardLibrary<EClassifier> oclStandardLibrary = ecoreEnvironment.getOCLStandardLibrary();
	protected static final UMLReflection<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint> uml = ecoreEnvironment.getUMLReflection();
	private static final EClassifier booleanType = oclStandardLibrary.getBoolean();
	private static final EClassifier integerType = oclStandardLibrary.getInteger();
	private static final EClassifier realType = oclStandardLibrary.getReal();
	private static final EClassifier stringType = oclStandardLibrary.getString();
	private static final EClassifier unlimitedNaturalType = oclStandardLibrary.getUnlimitedNatural();
	private static final EClassifier voidType = oclStandardLibrary.getOclVoid();

	public static EClassifier getBooleanType() {
		return booleanType;
	}

	public static EClassifier getIntegerType() {
		return integerType;
	}

	public static EClassifier getPropertyType(EStructuralFeature referredProperty) {
		EClassifier elementType = referredProperty.getEType();
		if (!referredProperty.isMany())
			return elementType;
		CollectionType collectionType;
		if (referredProperty.isUnique()) {
			if (referredProperty.isOrdered())
				collectionType = org.eclipse.ocl.ecore.EcoreFactory.eINSTANCE.createOrderedSetType();
			else
				collectionType = org.eclipse.ocl.ecore.EcoreFactory.eINSTANCE.createSetType();		
		}
		else {
			if (referredProperty.isOrdered())
				collectionType = org.eclipse.ocl.ecore.EcoreFactory.eINSTANCE.createSequenceType();
			else
				collectionType = org.eclipse.ocl.ecore.EcoreFactory.eINSTANCE.createBagType();		
		}
		collectionType.setElementType(elementType);
		return collectionType;
	}

	public static EClassifier getRealType() {
		return realType;
	}

	public static EClassifier getStringType() {
		return stringType;
	}

	public static EClassifier getVoidType() {
		return voidType;
	}

	public static EClassifier getUnlimitedNaturalType() {
		return unlimitedNaturalType;
	}

	public AbstractEssentialOCLOperations(EValidatorWithOperations validator) {
		super(validator);
	}

	protected boolean assignableToFrom(EClassifier toType, EClassifier fromType) {
		EClassifier resolvedToType = uml.getOCLType(toType);
		EClassifier resolvedFromType = uml.getOCLType(fromType);
		if (resolvedToType == resolvedFromType)
			return true;
		if (resolvedToType instanceof CollectionType) {
			CollectionType toCollectionType = (CollectionType) resolvedToType;
			EClassifier toElementType = toCollectionType.getElementType(); 
			if (resolvedFromType instanceof CollectionType) {
				CollectionType fromCollectionType = (CollectionType) resolvedFromType;
				EClassifier fromElementType = fromCollectionType.getElementType(); 
				if (fromElementType == getVoidType())
					return true;
				return assignableToFrom(toElementType, fromElementType);
			}
		}
		else {
			if (!(resolvedToType instanceof EClass))
				return false;
			if (!(resolvedFromType instanceof EClass))
				return false;
			return ((EClass)resolvedToType).isSuperTypeOf((EClass)resolvedFromType);
		}
		return false;
	}

	public Set<Variable> getAllReferencedVariables(EObject eObject) {
		Set<Variable> referencedVariables = new HashSet<Variable>();
		if (eObject instanceof VariableExp)
			referencedVariables.add((Variable)((VariableExp)eObject).getReferredVariable());
		for (TreeIterator<EObject> i = eObject.eAllContents(); i.hasNext(); ) {
			EObject element = i.next();
			if (element instanceof VariableExp)
				referencedVariables.add((Variable)((VariableExp)element).getReferredVariable());
		}
		return referencedVariables;
	}

	public Collection<VariableExp> getAllVariableReferences(EObject eObject) {
		Set<VariableExp> variableExps = new HashSet<VariableExp>();
		if (eObject instanceof VariableExp)
			variableExps.add((VariableExp)eObject);
		for (TreeIterator<EObject> i = eObject.eAllContents(); i.hasNext(); ) {
			EObject element = i.next();
			if (element instanceof VariableExp)
				variableExps.add((VariableExp)element);
		}
		return variableExps;
	}

	public Collection<Variable> getAllVariables(EObject eObject) {
		Set<Variable> variables = new HashSet<Variable>();
		if (eObject instanceof Variable)
			variables.add((Variable)eObject);
		for (TreeIterator<EObject> i = eObject.eAllContents(); i.hasNext(); ) {
			EObject element = i.next();
			if (element instanceof Variable)
				variables.add((Variable)element);
		}
		return variables;
	}

	public EClassifier getElementType(EClassifier type) {
		if (type instanceof CollectionType)
			return getElementType(((CollectionType)type).getElementType());
		else
			return type;
	}

	public boolean isPredefinedType(EClassifier type) {
		if (type == getBooleanType())
			return true;
		else if (type == getIntegerType())
			return true;
		else if (type == getRealType())
			return true;
		else if (type == getStringType())
			return true;
		else if (type == getUnlimitedNaturalType())
			return true;
		else
			return false;
	}

	public Collection<VariableExp> zzgetAllVariableReferences(Collection<OCLExpression> expressions) {
		Set<VariableExp> variableReferences = new HashSet<VariableExp>();
    	for (OCLExpression expression : expressions) {
    		for (TreeIterator<EObject> i = expression.eAllContents(); i.hasNext(); ) {
    			EObject eObject = i.next();
    			if (eObject instanceof VariableExp) {
					VariableExp variableExp = (VariableExp) eObject;
					variableReferences.add(variableExp);
				}
    		}
    	}
		return variableReferences;
	}

	public EObject getNonExpressionParent(OCLExpression expression) {
		EObject parent = expression.eContainer();
		if (parent instanceof OCLExpression)
			return getNonExpressionParent((OCLExpression) parent);
		else
			return parent;
	}

	public boolean locallyDefined(VariableExp variableReference) {
		Variable variable = (Variable) variableReference.getReferredVariable();
		return locallyDefined(variableReference, variable);
	}

	public boolean locallyDefined(EObject element, Variable variable) {
		if (element instanceof LetExp) {
			if (((LetExp)element).getVariable() == variable)
				return true;
		}
		else if (element instanceof IterateExp) {
			if (((IterateExp)element).getResult() == variable)
				return true;
			if (((IterateExp)element).getIterator().contains(variable))
				return true;
		}
		else if (element instanceof LoopExp) {
			if (((LoopExp)element).getIterator().contains(variable))
				return true;
		}
		else if (element instanceof CollectionLiteralPart)
			;
		else if (element instanceof TupleLiteralPart)
			;
		else if (element instanceof OCLExpression) {
			if (element.eContents().contains(variable)) {
				System.out.println("Missing child variable for " + element.getClass().getName());
				return true;
			}
		}
		else
			return false;
		EObject parent = element.eContainer();
		if (parent == null)
			return false;
		return locallyDefined(parent, variable);
	}
}