/**
 * Copyright (c) 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.qvtd.umlx.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.umlx.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class UMLXFactoryImpl extends EFactoryImpl implements UMLXFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static UMLXFactory init() {
		try {
			UMLXFactory theUMLXFactory = (UMLXFactory)EPackage.Registry.INSTANCE.getEFactory(UMLXPackage.eNS_URI);
			if (theUMLXFactory != null) {
				return theUMLXFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new UMLXFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UMLXFactoryImpl() {
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
			case UMLXPackage.REL_CONSTRAINT_NODE: return createRelConstraintNode();
			case UMLXPackage.REL_DIAGRAM: return createRelDiagram();
			case UMLXPackage.REL_DOMAIN_NODE: return createRelDomainNode();
			case UMLXPackage.REL_INVOCATION_EDGE: return createRelInvocationEdge();
			case UMLXPackage.REL_INVOCATION_NODE: return createRelInvocationNode();
			case UMLXPackage.REL_NODE: return createRelNode();
			case UMLXPackage.REL_PATTERN_EDGE: return createRelPatternEdge();
			case UMLXPackage.REL_PATTERN_NODE: return createRelPatternNode();
			case UMLXPackage.TX_DIAGRAM: return createTxDiagram();
			case UMLXPackage.TX_IMPORT_NODE: return createTxImportNode();
			case UMLXPackage.TX_KEY_NODE: return createTxKeyNode();
			case UMLXPackage.TX_NODE: return createTxNode();
			case UMLXPackage.TX_PACKAGE_NODE: return createTxPackageNode();
			case UMLXPackage.TX_PART_NODE: return createTxPartNode();
			case UMLXPackage.TX_TYPED_MODEL_NODE: return createTxTypedModelNode();
			case UMLXPackage.UMLX_MODEL: return createUMLXModel();
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
	public @NonNull RelConstraintNode createRelConstraintNode() {
		RelConstraintNodeImpl relConstraintNode = new RelConstraintNodeImpl();
		return relConstraintNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull RelDiagram createRelDiagram() {
		RelDiagramImpl relDiagram = new RelDiagramImpl();
		return relDiagram;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull RelDomainNode createRelDomainNode() {
		RelDomainNodeImpl relDomainNode = new RelDomainNodeImpl();
		return relDomainNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull RelInvocationEdge createRelInvocationEdge() {
		RelInvocationEdgeImpl relInvocationEdge = new RelInvocationEdgeImpl();
		return relInvocationEdge;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull RelInvocationNode createRelInvocationNode() {
		RelInvocationNodeImpl relInvocationNode = new RelInvocationNodeImpl();
		return relInvocationNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull RelNode createRelNode() {
		RelNodeImpl relNode = new RelNodeImpl();
		return relNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull RelPatternEdge createRelPatternEdge() {
		RelPatternEdgeImpl relPatternEdge = new RelPatternEdgeImpl();
		return relPatternEdge;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull RelPatternNode createRelPatternNode() {
		RelPatternNodeImpl relPatternNode = new RelPatternNodeImpl();
		return relPatternNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull TxDiagram createTxDiagram() {
		TxDiagramImpl txDiagram = new TxDiagramImpl();
		return txDiagram;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull TxImportNode createTxImportNode() {
		TxImportNodeImpl txImportNode = new TxImportNodeImpl();
		return txImportNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull TxKeyNode createTxKeyNode() {
		TxKeyNodeImpl txKeyNode = new TxKeyNodeImpl();
		return txKeyNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull TxPartNode createTxPartNode() {
		TxPartNodeImpl txPartNode = new TxPartNodeImpl();
		return txPartNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull TxNode createTxNode() {
		TxNodeImpl txNode = new TxNodeImpl();
		return txNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull TxPackageNode createTxPackageNode() {
		TxPackageNodeImpl txPackageNode = new TxPackageNodeImpl();
		return txPackageNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull TxTypedModelNode createTxTypedModelNode() {
		TxTypedModelNodeImpl txTypedModelNode = new TxTypedModelNodeImpl();
		return txTypedModelNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public @NonNull UMLXModel createUMLXModel() {
		UMLXModelImpl umlxModel = new UMLXModelImpl();
		return umlxModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public UMLXPackage getUMLXPackage() {
		return (UMLXPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static UMLXPackage getPackage() {
		return UMLXPackage.eINSTANCE;
	}

} //UMLXFactoryImpl
