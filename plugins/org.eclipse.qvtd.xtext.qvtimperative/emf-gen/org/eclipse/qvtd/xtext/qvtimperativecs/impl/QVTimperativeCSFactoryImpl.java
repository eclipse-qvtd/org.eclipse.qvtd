/*******************************************************************************
 * Copyright (c) 2013, 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtimperativecs.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.xtext.qvtimperativecs.AddStatementCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.CheckStatementCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.DeclareStatementCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.DirectionCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.DomainCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.GuardVariableCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.InoutVariableCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.MappingCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.MappingCallBindingCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.MappingCallCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.MappingLoopCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.NewStatementCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.OutVariableCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.ParamDeclarationCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.QVTimperativeCSFactory;
import org.eclipse.qvtd.xtext.qvtimperativecs.QVTimperativeCSPackage;
import org.eclipse.qvtd.xtext.qvtimperativecs.QueryCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.SetStatementCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.TopLevelCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.TransformationCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class QVTimperativeCSFactoryImpl extends EFactoryImpl implements QVTimperativeCSFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static QVTimperativeCSFactory init() {
		try {
			QVTimperativeCSFactory theQVTimperativeCSFactory = (QVTimperativeCSFactory)EPackage.Registry.INSTANCE.getEFactory(QVTimperativeCSPackage.eNS_URI);
			if (theQVTimperativeCSFactory != null) {
				return theQVTimperativeCSFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new QVTimperativeCSFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QVTimperativeCSFactoryImpl() {
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
			case QVTimperativeCSPackage.ADD_STATEMENT_CS: return createAddStatementCS();
			case QVTimperativeCSPackage.CHECK_STATEMENT_CS: return createCheckStatementCS();
			case QVTimperativeCSPackage.DECLARE_STATEMENT_CS: return createDeclareStatementCS();
			case QVTimperativeCSPackage.DIRECTION_CS: return createDirectionCS();
			case QVTimperativeCSPackage.DOMAIN_CS: return createDomainCS();
			case QVTimperativeCSPackage.GUARD_VARIABLE_CS: return createGuardVariableCS();
			case QVTimperativeCSPackage.INOUT_VARIABLE_CS: return createInoutVariableCS();
			case QVTimperativeCSPackage.MAPPING_CS: return createMappingCS();
			case QVTimperativeCSPackage.MAPPING_CALL_BINDING_CS: return createMappingCallBindingCS();
			case QVTimperativeCSPackage.MAPPING_CALL_CS: return createMappingCallCS();
			case QVTimperativeCSPackage.MAPPING_LOOP_CS: return createMappingLoopCS();
			case QVTimperativeCSPackage.NEW_STATEMENT_CS: return createNewStatementCS();
			case QVTimperativeCSPackage.OUT_VARIABLE_CS: return createOutVariableCS();
			case QVTimperativeCSPackage.PARAM_DECLARATION_CS: return createParamDeclarationCS();
			case QVTimperativeCSPackage.QUERY_CS: return createQueryCS();
			case QVTimperativeCSPackage.SET_STATEMENT_CS: return createSetStatementCS();
			case QVTimperativeCSPackage.TOP_LEVEL_CS: return createTopLevelCS();
			case QVTimperativeCSPackage.TRANSFORMATION_CS: return createTransformationCS();
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
	public @NonNull AddStatementCS createAddStatementCS() {
		AddStatementCSImpl addStatementCS = new AddStatementCSImpl();
		return addStatementCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull CheckStatementCS createCheckStatementCS() {
		CheckStatementCSImpl checkStatementCS = new CheckStatementCSImpl();
		return checkStatementCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull DeclareStatementCS createDeclareStatementCS() {
		DeclareStatementCSImpl declareStatementCS = new DeclareStatementCSImpl();
		return declareStatementCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull DirectionCS createDirectionCS() {
		DirectionCSImpl directionCS = new DirectionCSImpl();
		return directionCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull DomainCS createDomainCS() {
		DomainCSImpl domainCS = new DomainCSImpl();
		return domainCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull GuardVariableCS createGuardVariableCS() {
		GuardVariableCSImpl guardVariableCS = new GuardVariableCSImpl();
		return guardVariableCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull InoutVariableCS createInoutVariableCS() {
		InoutVariableCSImpl inoutVariableCS = new InoutVariableCSImpl();
		return inoutVariableCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull MappingCS createMappingCS() {
		MappingCSImpl mappingCS = new MappingCSImpl();
		return mappingCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull MappingCallBindingCS createMappingCallBindingCS() {
		MappingCallBindingCSImpl mappingCallBindingCS = new MappingCallBindingCSImpl();
		return mappingCallBindingCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull MappingCallCS createMappingCallCS() {
		MappingCallCSImpl mappingCallCS = new MappingCallCSImpl();
		return mappingCallCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull MappingLoopCS createMappingLoopCS() {
		MappingLoopCSImpl mappingLoopCS = new MappingLoopCSImpl();
		return mappingLoopCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull ParamDeclarationCS createParamDeclarationCS() {
		ParamDeclarationCSImpl paramDeclarationCS = new ParamDeclarationCSImpl();
		return paramDeclarationCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull QueryCS createQueryCS() {
		QueryCSImpl queryCS = new QueryCSImpl();
		return queryCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull NewStatementCS createNewStatementCS() {
		NewStatementCSImpl newStatementCS = new NewStatementCSImpl();
		return newStatementCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull OutVariableCS createOutVariableCS() {
		OutVariableCSImpl outVariableCS = new OutVariableCSImpl();
		return outVariableCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull SetStatementCS createSetStatementCS() {
		SetStatementCSImpl setStatementCS = new SetStatementCSImpl();
		return setStatementCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull TopLevelCS createTopLevelCS() {
		TopLevelCSImpl topLevelCS = new TopLevelCSImpl();
		return topLevelCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull TransformationCS createTransformationCS() {
		TransformationCSImpl transformationCS = new TransformationCSImpl();
		return transformationCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public QVTimperativeCSPackage getQVTimperativeCSPackage() {
		return (QVTimperativeCSPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static QVTimperativeCSPackage getPackage() {
		return QVTimperativeCSPackage.eINSTANCE;
	}

} //QVTimperativeCSTFactoryImpl
