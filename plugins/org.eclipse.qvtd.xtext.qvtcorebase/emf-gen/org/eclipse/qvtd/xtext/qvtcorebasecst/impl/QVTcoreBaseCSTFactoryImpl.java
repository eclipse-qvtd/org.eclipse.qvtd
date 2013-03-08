/**
 * <copyright>
 *
 * Copyright (c) 2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.qvtd.xtext.qvtcorebasecst.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.qvtd.xtext.qvtcorebasecst.AssignmentCS;
import org.eclipse.qvtd.xtext.qvtcorebasecst.BottomPatternCS;
import org.eclipse.qvtd.xtext.qvtcorebasecst.DirectionCS;
import org.eclipse.qvtd.xtext.qvtcorebasecst.DomainCS;
import org.eclipse.qvtd.xtext.qvtcorebasecst.EnforcementOperationCS;
import org.eclipse.qvtd.xtext.qvtcorebasecst.GuardPatternCS;
import org.eclipse.qvtd.xtext.qvtcorebasecst.ParamDeclarationCS;
import org.eclipse.qvtd.xtext.qvtcorebasecst.QVTcoreBaseCSTFactory;
import org.eclipse.qvtd.xtext.qvtcorebasecst.QVTcoreBaseCSTPackage;
import org.eclipse.qvtd.xtext.qvtcorebasecst.QueryCS;
import org.eclipse.qvtd.xtext.qvtcorebasecst.RealizedVariableCS;
import org.eclipse.qvtd.xtext.qvtcorebasecst.TransformationCS;
import org.eclipse.qvtd.xtext.qvtcorebasecst.UnrealizedVariableCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class QVTcoreBaseCSTFactoryImpl extends EFactoryImpl implements QVTcoreBaseCSTFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static QVTcoreBaseCSTFactory init() {
		try {
			QVTcoreBaseCSTFactory theQVTcoreBaseCSTFactory = (QVTcoreBaseCSTFactory)EPackage.Registry.INSTANCE.getEFactory(QVTcoreBaseCSTPackage.eNS_URI);
			if (theQVTcoreBaseCSTFactory != null) {
				return theQVTcoreBaseCSTFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new QVTcoreBaseCSTFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QVTcoreBaseCSTFactoryImpl() {
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
			case QVTcoreBaseCSTPackage.ASSIGNMENT_CS: return createAssignmentCS();
			case QVTcoreBaseCSTPackage.BOTTOM_PATTERN_CS: return createBottomPatternCS();
			case QVTcoreBaseCSTPackage.DIRECTION_CS: return createDirectionCS();
			case QVTcoreBaseCSTPackage.DOMAIN_CS: return createDomainCS();
			case QVTcoreBaseCSTPackage.ENFORCEMENT_OPERATION_CS: return createEnforcementOperationCS();
			case QVTcoreBaseCSTPackage.GUARD_PATTERN_CS: return createGuardPatternCS();
			case QVTcoreBaseCSTPackage.PARAM_DECLARATION_CS: return createParamDeclarationCS();
			case QVTcoreBaseCSTPackage.QUERY_CS: return createQueryCS();
			case QVTcoreBaseCSTPackage.REALIZED_VARIABLE_CS: return createRealizedVariableCS();
			case QVTcoreBaseCSTPackage.TRANSFORMATION_CS: return createTransformationCS();
			case QVTcoreBaseCSTPackage.UNREALIZED_VARIABLE_CS: return createUnrealizedVariableCS();
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
	public QVTcoreBaseCSTPackage getQVTcoreBaseCSTPackage() {
		return (QVTcoreBaseCSTPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static QVTcoreBaseCSTPackage getPackage() {
		return QVTcoreBaseCSTPackage.eINSTANCE;
	}

} //QVTcoreBaseCSTFactoryImpl
