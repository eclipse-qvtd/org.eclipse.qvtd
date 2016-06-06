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

import org.eclipse.qvtd.umlx.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class UmlxFactoryImpl extends EFactoryImpl implements UmlxFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final UmlxFactoryImpl eINSTANCE = init();

	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static UmlxFactoryImpl init() {
		try {
			UmlxFactoryImpl theUmlxFactory = (UmlxFactoryImpl)EPackage.Registry.INSTANCE.getEFactory(UmlxPackageImpl.eNS_URI);
			if (theUmlxFactory != null) {
				return theUmlxFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new UmlxFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UmlxFactoryImpl() {
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
			case UmlxPackageImpl.MODEL: return createModel();
			case UmlxPackageImpl.REL_DIAGRAM: return createRelDiagram();
			case UmlxPackageImpl.REL_DOMAIN_NODE: return createRelDomainNode();
			case UmlxPackageImpl.REL_INVOCATION_EDGE: return createRelInvocationEdge();
			case UmlxPackageImpl.REL_INVOCATION_NODE: return createRelInvocationNode();
			case UmlxPackageImpl.REL_PATTERN_EDGE: return createRelPatternEdge();
			case UmlxPackageImpl.REL_PATTERN_NODE: return createRelPatternNode();
			case UmlxPackageImpl.TX_DIAGRAM: return createTxDiagram();
			case UmlxPackageImpl.TX_NODE: return createTxNode();
			case UmlxPackageImpl.TX_PACKAGE_NODE: return createTxPackageNode();
			case UmlxPackageImpl.TX_TRANSFORMATION_NODE: return createTxTransformationNode();
			case UmlxPackageImpl.TX_TYPED_MODEL_NODE: return createTxTypedModelNode();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Model createModel() {
		ModelImpl model = new ModelImpl();
		return model;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RelDiagram createRelDiagram() {
		RelDiagramImpl relDiagram = new RelDiagramImpl();
		return relDiagram;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RelDomainNode createRelDomainNode() {
		RelDomainNodeImpl relDomainNode = new RelDomainNodeImpl();
		return relDomainNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RelInvocationEdge createRelInvocationEdge() {
		RelInvocationEdgeImpl relInvocationEdge = new RelInvocationEdgeImpl();
		return relInvocationEdge;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RelInvocationNode createRelInvocationNode() {
		RelInvocationNodeImpl relInvocationNode = new RelInvocationNodeImpl();
		return relInvocationNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RelPatternEdge createRelPatternEdge() {
		RelPatternEdgeImpl relPatternEdge = new RelPatternEdgeImpl();
		return relPatternEdge;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RelPatternNode createRelPatternNode() {
		RelPatternNodeImpl relPatternNode = new RelPatternNodeImpl();
		return relPatternNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TxDiagram createTxDiagram() {
		TxDiagramImpl txDiagram = new TxDiagramImpl();
		return txDiagram;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TxNode createTxNode() {
		TxNodeImpl txNode = new TxNodeImpl();
		return txNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TxPackageNode createTxPackageNode() {
		TxPackageNodeImpl txPackageNode = new TxPackageNodeImpl();
		return txPackageNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TxTransformationNode createTxTransformationNode() {
		TxTransformationNodeImpl txTransformationNode = new TxTransformationNodeImpl();
		return txTransformationNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TxTypedModelNode createTxTypedModelNode() {
		TxTypedModelNodeImpl txTypedModelNode = new TxTypedModelNodeImpl();
		return txTypedModelNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UmlxPackageImpl getUmlxPackage() {
		return (UmlxPackageImpl)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static UmlxPackageImpl getPackage() {
		return UmlxPackageImpl.eINSTANCE;
	}

} //UmlxFactoryImpl
