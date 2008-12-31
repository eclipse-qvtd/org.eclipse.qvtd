/*******************************************************************************
 * Copyright (c) 2008 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvt.declarative.test.emof.essentialocl;

import java.util.List;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.ocl.ecore.BooleanLiteralExp;
import org.eclipse.ocl.ecore.CollectionItem;
import org.eclipse.ocl.ecore.CollectionLiteralExp;
import org.eclipse.ocl.ecore.CollectionLiteralPart;
import org.eclipse.ocl.ecore.CollectionType;
import org.eclipse.ocl.ecore.EcoreEnvironment;
import org.eclipse.ocl.ecore.EcoreEnvironmentFactory;
import org.eclipse.ocl.ecore.EnumLiteralExp;
import org.eclipse.ocl.ecore.IntegerLiteralExp;
import org.eclipse.ocl.ecore.LetExp;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.StringLiteralExp;
import org.eclipse.ocl.ecore.TypeExp;
import org.eclipse.ocl.ecore.Variable;
import org.eclipse.ocl.ecore.VariableExp;
import org.eclipse.ocl.expressions.CollectionKind;
import org.eclipse.ocl.types.OCLStandardLibrary;
import org.eclipse.qvt.declarative.test.emof.emof.AbstractEMOFValidationTest;

public abstract class AbstractEssentialOCLValidationTest extends AbstractEMOFValidationTest
{
	public static final org.eclipse.ocl.ecore.EcoreFactory OCL_Factory = org.eclipse.ocl.ecore.EcoreFactory.eINSTANCE;
//	public static final org.eclipse.ocl.ecore.EcorePackage OCL_Literals = org.eclipse.ocl.ecore.EcorePackage.Literals;
	private static final EcoreEnvironment ecoreEnvironment = (EcoreEnvironment) EcoreEnvironmentFactory.INSTANCE.createEnvironment();
	private static final OCLStandardLibrary<EClassifier> oclStandardLibrary = ecoreEnvironment.getOCLStandardLibrary();
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

	protected BooleanLiteralExp createBooleanLiteralExp(boolean value) {
		BooleanLiteralExp expr = OCL_Factory.createBooleanLiteralExp();
		expr.setBooleanSymbol(value);
		expr.setEType(getBooleanType());
		return expr;
	}

	protected CollectionLiteralExp createCollectionLiteralExp(EClassifier type, CollectionLiteralPart... parts) {
		CollectionLiteralExp expr = OCL_Factory.createCollectionLiteralExp();
		if (type != null) {
			expr.setEType(type);
			if (type instanceof CollectionType) {
				expr.setKind(((CollectionType)type).getKind());
			}
		}
		if (parts != null) {
			for (CollectionLiteralPart part : parts)
				expr.getPart().add(part);
		}
		return expr;
	}

	protected CollectionLiteralPart createCollectionItem(OCLExpression value) {
		CollectionItem expr = OCL_Factory.createCollectionItem();
		if (value != null) {
			expr.setEType(value.getType());
			expr.setItem(value);
		}
		return expr;
	}

	protected CollectionType createCollectionType(List<? super CollectionType> classifiers, CollectionKind kind, EClassifier elementType) {
		CollectionType collectionType = OCL_Factory.createCollectionType();
		switch (kind) {
			case BAG_LITERAL: collectionType = OCL_Factory.createBagType(); break;
			case ORDERED_SET_LITERAL: collectionType = OCL_Factory.createOrderedSetType(); break;
			case SEQUENCE_LITERAL: collectionType = OCL_Factory.createSequenceType(); break;
			case SET_LITERAL: collectionType = OCL_Factory.createSetType(); break;
			default: collectionType = OCL_Factory.createCollectionType(); break;
		}
		collectionType.setElementType(elementType);
		if (classifiers != null)
			classifiers.add(collectionType);
		return collectionType;
	}

	protected EnumLiteralExp createEnumLiteralExp(EEnumLiteral value) {
		EnumLiteralExp expr = OCL_Factory.createEnumLiteralExp();
		expr.setReferredEnumLiteral(value);
		expr.setEType(value.getEEnum());
		return expr;
	}

	protected IntegerLiteralExp createIntegerLiteralExp(int value) {
		IntegerLiteralExp expr = OCL_Factory.createIntegerLiteralExp();
		expr.setIntegerSymbol(value);
		expr.setEType(getIntegerType());
		return expr;
	}

	protected LetExp createLetExp(String variableName, EClassifier variableType, OCLExpression inExpression) {
		Variable variable = OCL_Factory.createVariable();
		variable.setName(variableName);
		variable.setEType(variableType);
		LetExp letExp = OCL_Factory.createLetExp();
		letExp.setVariable(variable);
		letExp.setIn(inExpression);
		letExp.setEType(inExpression.getEType());
		return letExp;
	}

	protected StringLiteralExp createStringLiteralExp(String string) {
		StringLiteralExp expr = OCL_Factory.createStringLiteralExp();
		expr.setStringSymbol(string);
		expr.setEType(getStringType());
		return expr;
	}

	protected TypeExp createTypeExp(EClassifier type) {
		TypeExp typeExp = OCL_Factory.createTypeExp();
		if (type != null)
			typeExp.setReferredType(type);
		typeExp.setType(org.eclipse.ocl.ecore.EcorePackage.Literals.TYPE_TYPE);
		return typeExp;
	}

	protected Variable createVariable(List<? super Variable> variables, String name, EClassifier eType) {
		Variable variable = OCL_Factory.createVariable();
		variable.setName(name);
		variable.setEType(eType);
		if (variables != null)
			variables.add(variable);
		return variable;
	}

	protected Variable createVariable(List<? super Variable> variables, String name, EClassifier eType, OCLExpression initExpression) {
		Variable variable = createVariable(variables, name, eType);
		if (initExpression != null)
			variable.setInitExpression(initExpression);
		return variable;
	}

	protected VariableExp createVariableExp(Variable variable) {
		VariableExp variableExp = OCL_Factory.createVariableExp();
		variableExp.setReferredVariable(variable);
		variableExp.setName(variable.getName());
		variableExp.setEType(variable.getEType());
		return variableExp;
	}
}
