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
package org.eclipse.qvtd.umlx.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.qvtd.umlx.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.qvtd.umlx.UMLXPackage
 * @generated
 */
public class UMLXAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static UMLXPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UMLXAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = UMLXPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UMLXSwitch<@Nullable Adapter> modelSwitch =
			new UMLXSwitch<@Nullable Adapter>() {
			@Override
			public Adapter caseRelDiagram(RelDiagram object) {
				return createRelDiagramAdapter();
			}
			@Override
			public Adapter caseRelDomainNode(RelDomainNode object) {
				return createRelDomainNodeAdapter();
			}
			@Override
			public Adapter caseRelEdge(RelEdge object) {
				return createRelEdgeAdapter();
			}
			@Override
			public Adapter caseRelInvocationEdge(RelInvocationEdge object) {
				return createRelInvocationEdgeAdapter();
			}
			@Override
			public Adapter caseRelInvocationNode(RelInvocationNode object) {
				return createRelInvocationNodeAdapter();
			}
			@Override
			public Adapter caseRelNode(RelNode object) {
				return createRelNodeAdapter();
			}
			@Override
			public Adapter caseRelPatternEdge(RelPatternEdge object) {
				return createRelPatternEdgeAdapter();
			}
			@Override
			public Adapter caseRelPatternNode(RelPatternNode object) {
				return createRelPatternNodeAdapter();
			}
			@Override
			public Adapter caseTxDiagram(TxDiagram object) {
				return createTxDiagramAdapter();
			}
			@Override
			public Adapter caseTxKeyNode(TxKeyNode object) {
				return createTxKeyNodeAdapter();
			}
			@Override
			public Adapter caseTxNode(TxNode object) {
				return createTxNodeAdapter();
			}
			@Override
			public Adapter caseTxPackageNode(TxPackageNode object) {
				return createTxPackageNodeAdapter();
			}
			@Override
			public Adapter caseTxParameterNode(TxParameterNode object) {
				return createTxParameterNodeAdapter();
			}
			@Override
			public Adapter caseTxPartNode(TxPartNode object) {
				return createTxPartNodeAdapter();
			}
			@Override
			public Adapter caseTxQueryNode(TxQueryNode object) {
				return createTxQueryNodeAdapter();
			}
			@Override
			public Adapter caseTxTypedModelNode(TxTypedModelNode object) {
				return createTxTypedModelNodeAdapter();
			}
			@Override
			public Adapter caseUMLXElement(UMLXElement object) {
				return createUMLXElementAdapter();
			}
			@Override
			public Adapter caseUMLXModel(UMLXModel object) {
				return createUMLXModelAdapter();
			}
			@Override
			public Adapter caseUMLXNamedElement(UMLXNamedElement object) {
				return createUMLXNamedElementAdapter();
			}
			@Override
			public Adapter caseUMLXTypedElement(UMLXTypedElement object) {
				return createUMLXTypedElementAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.umlx.RelDiagram <em>Rel Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.umlx.RelDiagram
	 * @generated
	 */
	public Adapter createRelDiagramAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.umlx.RelDomainNode <em>Rel Domain Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.umlx.RelDomainNode
	 * @generated
	 */
	public Adapter createRelDomainNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.umlx.RelEdge <em>Rel Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.umlx.RelEdge
	 * @generated
	 */
	public Adapter createRelEdgeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.umlx.RelInvocationEdge <em>Rel Invocation Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.umlx.RelInvocationEdge
	 * @generated
	 */
	public Adapter createRelInvocationEdgeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.umlx.RelInvocationNode <em>Rel Invocation Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.umlx.RelInvocationNode
	 * @generated
	 */
	public Adapter createRelInvocationNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.umlx.RelNode <em>Rel Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.umlx.RelNode
	 * @generated
	 */
	public Adapter createRelNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.umlx.RelPatternEdge <em>Rel Pattern Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.umlx.RelPatternEdge
	 * @generated
	 */
	public Adapter createRelPatternEdgeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.umlx.RelPatternNode <em>Rel Pattern Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.umlx.RelPatternNode
	 * @generated
	 */
	public Adapter createRelPatternNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.umlx.TxDiagram <em>Tx Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.umlx.TxDiagram
	 * @generated
	 */
	public Adapter createTxDiagramAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.umlx.TxKeyNode <em>Tx Key Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.umlx.TxKeyNode
	 * @generated
	 */
	public Adapter createTxKeyNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.umlx.TxPartNode <em>Tx Part Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.umlx.TxPartNode
	 * @generated
	 */
	public Adapter createTxPartNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.umlx.TxQueryNode <em>Tx Query Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.umlx.TxQueryNode
	 * @generated
	 */
	public Adapter createTxQueryNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.umlx.TxNode <em>Tx Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.umlx.TxNode
	 * @generated
	 */
	public Adapter createTxNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.umlx.TxPackageNode <em>Tx Package Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.umlx.TxPackageNode
	 * @generated
	 */
	public Adapter createTxPackageNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.umlx.TxParameterNode <em>Tx Parameter Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.umlx.TxParameterNode
	 * @generated
	 */
	public Adapter createTxParameterNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.umlx.TxTypedModelNode <em>Tx Typed Model Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.umlx.TxTypedModelNode
	 * @generated
	 */
	public Adapter createTxTypedModelNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.umlx.UMLXElement <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.umlx.UMLXElement
	 * @generated
	 */
	public Adapter createUMLXElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.umlx.UMLXModel <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.umlx.UMLXModel
	 * @generated
	 */
	public Adapter createUMLXModelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.umlx.UMLXNamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.umlx.UMLXNamedElement
	 * @generated
	 */
	public Adapter createUMLXNamedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.umlx.UMLXTypedElement <em>Typed Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.umlx.UMLXTypedElement
	 * @generated
	 */
	public Adapter createUMLXTypedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //UMLXAdapterFactory
