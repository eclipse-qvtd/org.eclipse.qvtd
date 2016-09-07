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
			case QVTimperativeCSPackage.BOTTOM_PATTERN_CS: return createBottomPatternCS();
			case QVTimperativeCSPackage.CONNECTION_STATEMENT_CS: return createConnectionStatementCS();
			case QVTimperativeCSPackage.DIRECTION_CS: return createDirectionCS();
			case QVTimperativeCSPackage.DOMAIN_CS: return createDomainCS();
			case QVTimperativeCSPackage.GUARD_PATTERN_CS: return createGuardPatternCS();
			case QVTimperativeCSPackage.IMPERATIVE_DOMAIN_CS: return createImperativeDomainCS();
			case QVTimperativeCSPackage.IMPERATIVE_PREDICATE_OR_ASSIGNMENT_CS: return createImperativePredicateOrAssignmentCS();
			case QVTimperativeCSPackage.IMPERATIVE_REALIZED_VARIABLE_CS: return createImperativeRealizedVariableCS();
			case QVTimperativeCSPackage.MAPPING_CS: return createMappingCS();
			case QVTimperativeCSPackage.MAPPING_CALL_BINDING_CS: return createMappingCallBindingCS();
			case QVTimperativeCSPackage.MAPPING_CALL_CS: return createMappingCallCS();
			case QVTimperativeCSPackage.MAPPING_LOOP_CS: return createMappingLoopCS();
			case QVTimperativeCSPackage.MAPPING_SEQUENCE_CS: return createMappingSequenceCS();
			case QVTimperativeCSPackage.PARAM_DECLARATION_CS: return createParamDeclarationCS();
			case QVTimperativeCSPackage.PREDICATE_CS: return createPredicateCS();
			case QVTimperativeCSPackage.PREDICATE_OR_ASSIGNMENT_CS: return createPredicateOrAssignmentCS();
			case QVTimperativeCSPackage.QUERY_CS: return createQueryCS();
			case QVTimperativeCSPackage.REALIZED_VARIABLE_CS: return createRealizedVariableCS();
			case QVTimperativeCSPackage.TOP_LEVEL_CS: return createTopLevelCS();
			case QVTimperativeCSPackage.TRANSFORMATION_CS: return createTransformationCS();
			case QVTimperativeCSPackage.UNREALIZED_VARIABLE_CS: return createUnrealizedVariableCS();
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
	public @NonNull ConnectionStatementCS createConnectionStatementCS() {
		ConnectionStatementCSImpl connectionStatementCS = new ConnectionStatementCSImpl();
		return connectionStatementCS;
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
	public @NonNull MappingSequenceCS createMappingSequenceCS() {
		MappingSequenceCSImpl mappingSequenceCS = new MappingSequenceCSImpl();
		return mappingSequenceCS;
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
	public @NonNull ImperativeDomainCS createImperativeDomainCS() {
		ImperativeDomainCSImpl imperativeDomainCS = new ImperativeDomainCSImpl();
		return imperativeDomainCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull ImperativePredicateOrAssignmentCS createImperativePredicateOrAssignmentCS() {
		ImperativePredicateOrAssignmentCSImpl imperativePredicateOrAssignmentCS = new ImperativePredicateOrAssignmentCSImpl();
		return imperativePredicateOrAssignmentCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull ImperativeRealizedVariableCS createImperativeRealizedVariableCS() {
		ImperativeRealizedVariableCSImpl imperativeRealizedVariableCS = new ImperativeRealizedVariableCSImpl();
		return imperativeRealizedVariableCS;
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
