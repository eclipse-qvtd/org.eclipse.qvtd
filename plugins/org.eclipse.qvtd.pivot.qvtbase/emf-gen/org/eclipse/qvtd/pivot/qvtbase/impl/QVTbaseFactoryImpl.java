/*******************************************************************************
 * Copyright (c) 2011, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtbase.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.pivot.qvtbase.*;
import org.eclipse.qvtd.pivot.qvtbase.BaseModel;
import org.eclipse.qvtd.pivot.qvtbase.Function;
import org.eclipse.qvtd.pivot.qvtbase.FunctionParameter;
import org.eclipse.qvtd.pivot.qvtbase.Pattern;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;
import org.eclipse.qvtd.pivot.qvtbase.QVTbaseFactory;
import org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class QVTbaseFactoryImpl extends EFactoryImpl implements QVTbaseFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static QVTbaseFactory init() {
		try {
			QVTbaseFactory theQVTbaseFactory = (QVTbaseFactory)EPackage.Registry.INSTANCE.getEFactory(QVTbasePackage.eNS_URI);
			if (theQVTbaseFactory != null) {
				return theQVTbaseFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new QVTbaseFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QVTbaseFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case 0: return createBaseModel();
			case 1: return createCompoundTargetElement();
			case 3: return createFunction();
			case 4: return createFunctionBody();
			case 5: return createFunctionParameter();
			case 6: return createPattern();
			case 7: return createPredicate();
			case 9: return createSimpleTargetElement();
			case 10: return createTarget();
			case 12: return createTransformation();
			case 13: return createTypedModel();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case 14:
				return createTargetElementKindFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case 14:
				return convertTargetElementKindToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull BaseModel createBaseModel() {
		BaseModelImpl baseModel = new BaseModelImpl();
		return baseModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CompoundTargetElement createCompoundTargetElement() {
		CompoundTargetElementImpl compoundTargetElement = new CompoundTargetElementImpl();
		return compoundTargetElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull Function createFunction() {
		FunctionImpl function = new FunctionImpl();
		return function;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public FunctionBody createFunctionBody() {
		FunctionBodyImpl functionBody = new FunctionBodyImpl();
		return functionBody;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull FunctionParameter createFunctionParameter() {
		FunctionParameterImpl functionParameter = new FunctionParameterImpl();
		return functionParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull Pattern createPattern() {
		PatternImpl pattern = new PatternImpl();
		return pattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull Predicate createPredicate() {
		PredicateImpl predicate = new PredicateImpl();
		return predicate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SimpleTargetElement createSimpleTargetElement() {
		SimpleTargetElementImpl simpleTargetElement = new SimpleTargetElementImpl();
		return simpleTargetElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Target createTarget() {
		TargetImpl target = new TargetImpl();
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull Transformation createTransformation() {
		TransformationImpl transformation = new TransformationImpl();
		return transformation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull TypedModel createTypedModel() {
		TypedModelImpl typedModel = new TypedModelImpl();
		return typedModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TargetElementKind createTargetElementKindFromString(EDataType eDataType, String initialValue) {
		TargetElementKind result = TargetElementKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTargetElementKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public QVTbasePackage getQVTbasePackage() {
		return (QVTbasePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static QVTbasePackage getPackage() {
		return QVTbasePackage.eINSTANCE;
	}

} //QVTbaseFactoryImpl
