/*******************************************************************************
 * Copyright (c) 2013, 2014 Willink Transformations and others.
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
import org.eclipse.qvtd.xtext.qvtimperativecs.*;

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
			case QVTimperativeCSPackage.IMPERATIVE_DOMAIN_CS: return createImperativeDomainCS();
			case QVTimperativeCSPackage.IMPERATIVE_PREDICATE_OR_ASSIGNMENT_CS: return createImperativePredicateOrAssignmentCS();
			case QVTimperativeCSPackage.MAPPING_CS: return createMappingCS();
			case QVTimperativeCSPackage.MAPPING_CALL_BINDING_CS: return createMappingCallBindingCS();
			case QVTimperativeCSPackage.MAPPING_CALL_CS: return createMappingCallCS();
			case QVTimperativeCSPackage.MAPPING_LOOP_CS: return createMappingLoopCS();
			case QVTimperativeCSPackage.MAPPING_SEQUENCE_CS: return createMappingSequenceCS();
			case QVTimperativeCSPackage.TOP_LEVEL_CS: return createTopLevelCS();
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
	public MappingCS createMappingCS() {
		MappingCSImpl mappingCS = new MappingCSImpl();
		return mappingCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public MappingCallBindingCS createMappingCallBindingCS() {
		MappingCallBindingCSImpl mappingCallBindingCS = new MappingCallBindingCSImpl();
		return mappingCallBindingCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public MappingCallCS createMappingCallCS() {
		MappingCallCSImpl mappingCallCS = new MappingCallCSImpl();
		return mappingCallCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public MappingLoopCS createMappingLoopCS() {
		MappingLoopCSImpl mappingLoopCS = new MappingLoopCSImpl();
		return mappingLoopCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public MappingSequenceCS createMappingSequenceCS() {
		MappingSequenceCSImpl mappingSequenceCS = new MappingSequenceCSImpl();
		return mappingSequenceCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TopLevelCS createTopLevelCS() {
		TopLevelCSImpl topLevelCS = new TopLevelCSImpl();
		return topLevelCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ImperativeDomainCS createImperativeDomainCS() {
		ImperativeDomainCSImpl imperativeDomainCS = new ImperativeDomainCSImpl();
		return imperativeDomainCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ImperativePredicateOrAssignmentCS createImperativePredicateOrAssignmentCS() {
		ImperativePredicateOrAssignmentCSImpl imperativePredicateOrAssignmentCS = new ImperativePredicateOrAssignmentCSImpl();
		return imperativePredicateOrAssignmentCS;
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
