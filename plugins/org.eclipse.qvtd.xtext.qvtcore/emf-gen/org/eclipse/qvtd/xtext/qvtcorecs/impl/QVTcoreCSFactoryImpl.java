/*******************************************************************************
 * Copyright (c) 2012, 2014 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtcorecs.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.xtext.qvtcorecs.*;
import org.eclipse.qvtd.xtext.qvtcorecs.MappingCS;
import org.eclipse.qvtd.xtext.qvtcorecs.QVTcoreCSFactory;
import org.eclipse.qvtd.xtext.qvtcorecs.QVTcoreCSPackage;
import org.eclipse.qvtd.xtext.qvtcorecs.TopLevelCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class QVTcoreCSFactoryImpl extends EFactoryImpl implements QVTcoreCSFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static QVTcoreCSFactory init() {
		try {
			QVTcoreCSFactory theQVTcoreCSFactory = (QVTcoreCSFactory)EPackage.Registry.INSTANCE.getEFactory(QVTcoreCSPackage.eNS_URI);
			if (theQVTcoreCSFactory != null) {
				return theQVTcoreCSFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new QVTcoreCSFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QVTcoreCSFactoryImpl() {
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
			case QVTcoreCSPackage.BOTTOM_PATTERN_CS: return createBottomPatternCS();
			case QVTcoreCSPackage.DIRECTION_CS: return createDirectionCS();
			case QVTcoreCSPackage.DOMAIN_CS: return createDomainCS();
			case QVTcoreCSPackage.ENFORCEMENT_OPERATION_CS: return createEnforcementOperationCS();
			case QVTcoreCSPackage.GUARD_PATTERN_CS: return createGuardPatternCS();
			case QVTcoreCSPackage.MAPPING_CS: return createMappingCS();
			case QVTcoreCSPackage.PARAM_DECLARATION_CS: return createParamDeclarationCS();
			case QVTcoreCSPackage.PREDICATE_CS: return createPredicateCS();
			case QVTcoreCSPackage.PREDICATE_OR_ASSIGNMENT_CS: return createPredicateOrAssignmentCS();
			case QVTcoreCSPackage.QUERY_CS: return createQueryCS();
			case QVTcoreCSPackage.REALIZED_VARIABLE_CS: return createRealizedVariableCS();
			case QVTcoreCSPackage.TOP_LEVEL_CS: return createTopLevelCS();
			case QVTcoreCSPackage.TRANSFORMATION_CS: return createTransformationCS();
			case QVTcoreCSPackage.UNREALIZED_VARIABLE_CS: return createUnrealizedVariableCS();
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
	public @NonNull BottomPatternCS createBottomPatternCS() {
		BottomPatternCSImpl bottomPatternCS = new BottomPatternCSImpl();
		return bottomPatternCS;
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
	public @NonNull EnforcementOperationCS createEnforcementOperationCS() {
		EnforcementOperationCSImpl enforcementOperationCS = new EnforcementOperationCSImpl();
		return enforcementOperationCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull GuardPatternCS createGuardPatternCS() {
		GuardPatternCSImpl guardPatternCS = new GuardPatternCSImpl();
		return guardPatternCS;
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
	public @NonNull PredicateCS createPredicateCS() {
		PredicateCSImpl predicateCS = new PredicateCSImpl();
		return predicateCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull PredicateOrAssignmentCS createPredicateOrAssignmentCS() {
		PredicateOrAssignmentCSImpl predicateOrAssignmentCS = new PredicateOrAssignmentCSImpl();
		return predicateOrAssignmentCS;
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
	public @NonNull RealizedVariableCS createRealizedVariableCS() {
		RealizedVariableCSImpl realizedVariableCS = new RealizedVariableCSImpl();
		return realizedVariableCS;
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
	public @NonNull UnrealizedVariableCS createUnrealizedVariableCS() {
		UnrealizedVariableCSImpl unrealizedVariableCS = new UnrealizedVariableCSImpl();
		return unrealizedVariableCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public QVTcoreCSPackage getQVTcoreCSPackage() {
		return (QVTcoreCSPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static QVTcoreCSPackage getPackage() {
		return QVTcoreCSPackage.eINSTANCE;
	}

} //QVTcoreCSTFactoryImpl
