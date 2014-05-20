/*******************************************************************************
 * Copyright (c) 2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.AssignmentCS;
import org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.BottomPatternCS;
import org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.DirectionCS;
import org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.DomainCS;
import org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.EnforcementOperationCS;
import org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.GuardPatternCS;
import org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.ParamDeclarationCS;
import org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.QVTcoreBaseCSFactory;
import org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.QVTcoreBaseCSPackage;
import org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.QueryCS;
import org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.RealizedVariableCS;
import org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.TransformationCS;
import org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.UnrealizedVariableCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class QVTcoreBaseCSFactoryImpl extends EFactoryImpl implements QVTcoreBaseCSFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static QVTcoreBaseCSFactory init() {
		try {
			QVTcoreBaseCSFactory theQVTcoreBaseCSFactory = (QVTcoreBaseCSFactory)EPackage.Registry.INSTANCE.getEFactory(QVTcoreBaseCSPackage.eNS_URI);
			if (theQVTcoreBaseCSFactory != null) {
				return theQVTcoreBaseCSFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new QVTcoreBaseCSFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QVTcoreBaseCSFactoryImpl() {
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
			case QVTcoreBaseCSPackage.ASSIGNMENT_CS: return createAssignmentCS();
			case QVTcoreBaseCSPackage.BOTTOM_PATTERN_CS: return createBottomPatternCS();
			case QVTcoreBaseCSPackage.DIRECTION_CS: return createDirectionCS();
			case QVTcoreBaseCSPackage.DOMAIN_CS: return createDomainCS();
			case QVTcoreBaseCSPackage.ENFORCEMENT_OPERATION_CS: return createEnforcementOperationCS();
			case QVTcoreBaseCSPackage.GUARD_PATTERN_CS: return createGuardPatternCS();
			case QVTcoreBaseCSPackage.PARAM_DECLARATION_CS: return createParamDeclarationCS();
			case QVTcoreBaseCSPackage.QUERY_CS: return createQueryCS();
			case QVTcoreBaseCSPackage.REALIZED_VARIABLE_CS: return createRealizedVariableCS();
			case QVTcoreBaseCSPackage.TRANSFORMATION_CS: return createTransformationCS();
			case QVTcoreBaseCSPackage.UNREALIZED_VARIABLE_CS: return createUnrealizedVariableCS();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssignmentCS createAssignmentCS() {
		AssignmentCSImpl assignmentCS = new AssignmentCSImpl();
		return assignmentCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BottomPatternCS createBottomPatternCS() {
		BottomPatternCSImpl bottomPatternCS = new BottomPatternCSImpl();
		return bottomPatternCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DirectionCS createDirectionCS() {
		DirectionCSImpl directionCS = new DirectionCSImpl();
		return directionCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DomainCS createDomainCS() {
		DomainCSImpl domainCS = new DomainCSImpl();
		return domainCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnforcementOperationCS createEnforcementOperationCS() {
		EnforcementOperationCSImpl enforcementOperationCS = new EnforcementOperationCSImpl();
		return enforcementOperationCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GuardPatternCS createGuardPatternCS() {
		GuardPatternCSImpl guardPatternCS = new GuardPatternCSImpl();
		return guardPatternCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParamDeclarationCS createParamDeclarationCS() {
		ParamDeclarationCSImpl paramDeclarationCS = new ParamDeclarationCSImpl();
		return paramDeclarationCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QueryCS createQueryCS() {
		QueryCSImpl queryCS = new QueryCSImpl();
		return queryCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RealizedVariableCS createRealizedVariableCS() {
		RealizedVariableCSImpl realizedVariableCS = new RealizedVariableCSImpl();
		return realizedVariableCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TransformationCS createTransformationCS() {
		TransformationCSImpl transformationCS = new TransformationCSImpl();
		return transformationCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnrealizedVariableCS createUnrealizedVariableCS() {
		UnrealizedVariableCSImpl unrealizedVariableCS = new UnrealizedVariableCSImpl();
		return unrealizedVariableCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QVTcoreBaseCSPackage getQVTcoreBaseCSPackage() {
		return (QVTcoreBaseCSPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static QVTcoreBaseCSPackage getPackage() {
		return QVTcoreBaseCSPackage.eINSTANCE;
	}

} //QVTcoreBaseCSTFactoryImpl
