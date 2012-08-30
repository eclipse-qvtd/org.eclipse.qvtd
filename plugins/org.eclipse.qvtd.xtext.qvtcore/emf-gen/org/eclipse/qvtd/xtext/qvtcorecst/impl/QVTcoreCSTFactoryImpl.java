/**
 * <copyright>
 *
 * Copyright (c) 2012 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.qvtd.xtext.qvtcorecst.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.qvtd.xtext.qvtcorecst.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class QVTcoreCSTFactoryImpl extends EFactoryImpl implements QVTcoreCSTFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static QVTcoreCSTFactory init() {
		try {
			QVTcoreCSTFactory theQVTcoreCSTFactory = (QVTcoreCSTFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/qvt/0.9/QVTcoreCST"); 
			if (theQVTcoreCSTFactory != null) {
				return theQVTcoreCSTFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new QVTcoreCSTFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QVTcoreCSTFactoryImpl() {
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
			case QVTcoreCSTPackage.ASSIGNMENT_CS: return createAssignmentCS();
			case QVTcoreCSTPackage.BOTTOM_PATTERN_CS: return createBottomPatternCS();
			case QVTcoreCSTPackage.DIRECTION_CS: return createDirectionCS();
			case QVTcoreCSTPackage.DOMAIN_CS: return createDomainCS();
			case QVTcoreCSTPackage.ENFORCEMENT_OPERATION_CS: return createEnforcementOperationCS();
			case QVTcoreCSTPackage.GUARD_PATTERN_CS: return createGuardPatternCS();
			case QVTcoreCSTPackage.MAPPING_CS: return createMappingCS();
			case QVTcoreCSTPackage.PARAM_DECLARATION_CS: return createParamDeclarationCS();
			case QVTcoreCSTPackage.QUERY_CS: return createQueryCS();
			case QVTcoreCSTPackage.REALIZED_VARIABLE_CS: return createRealizedVariableCS();
			case QVTcoreCSTPackage.TOP_LEVEL_CS: return createTopLevelCS();
			case QVTcoreCSTPackage.TRANSFORMATION_CS: return createTransformationCS();
			case QVTcoreCSTPackage.UNREALIZED_VARIABLE_CS: return createUnrealizedVariableCS();
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
	public MappingCS createMappingCS() {
		MappingCSImpl mappingCS = new MappingCSImpl();
		return mappingCS;
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
	public TopLevelCS createTopLevelCS() {
		TopLevelCSImpl topLevelCS = new TopLevelCSImpl();
		return topLevelCS;
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
	public QVTcoreCSTPackage getQVTcoreCSTPackage() {
		return (QVTcoreCSTPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static QVTcoreCSTPackage getPackage() {
		return QVTcoreCSTPackage.eINSTANCE;
	}

} //QVTcoreCSTFactoryImpl
