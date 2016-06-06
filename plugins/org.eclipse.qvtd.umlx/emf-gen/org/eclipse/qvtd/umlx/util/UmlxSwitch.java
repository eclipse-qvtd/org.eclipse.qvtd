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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.eclipse.qvtd.umlx.*;

import org.eclipse.qvtd.umlx.impl.UmlxPackageImpl;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipse.qvtd.umlx.impl.UmlxPackageImpl
 * @generated
 */
public class UmlxSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static UmlxPackageImpl modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UmlxSwitch() {
		if (modelPackage == null) {
			modelPackage = UmlxPackageImpl.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case UmlxPackageImpl.DIAGRAM: {
				Diagram diagram = (Diagram)theEObject;
				T result = caseDiagram(diagram);
				if (result == null) result = caseElement(diagram);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UmlxPackageImpl.EDGE: {
				Edge edge = (Edge)theEObject;
				T result = caseEdge(edge);
				if (result == null) result = caseElement(edge);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UmlxPackageImpl.ELEMENT: {
				Element element = (Element)theEObject;
				T result = caseElement(element);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UmlxPackageImpl.MODEL: {
				Model model = (Model)theEObject;
				T result = caseModel(model);
				if (result == null) result = caseElement(model);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UmlxPackageImpl.NODE: {
				Node node = (Node)theEObject;
				T result = caseNode(node);
				if (result == null) result = caseElement(node);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UmlxPackageImpl.REL_DIAGRAM: {
				RelDiagram relDiagram = (RelDiagram)theEObject;
				T result = caseRelDiagram(relDiagram);
				if (result == null) result = caseDiagram(relDiagram);
				if (result == null) result = caseElement(relDiagram);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UmlxPackageImpl.REL_DOMAIN_NODE: {
				RelDomainNode relDomainNode = (RelDomainNode)theEObject;
				T result = caseRelDomainNode(relDomainNode);
				if (result == null) result = caseNode(relDomainNode);
				if (result == null) result = caseElement(relDomainNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UmlxPackageImpl.REL_INVOCATION_EDGE: {
				RelInvocationEdge relInvocationEdge = (RelInvocationEdge)theEObject;
				T result = caseRelInvocationEdge(relInvocationEdge);
				if (result == null) result = caseEdge(relInvocationEdge);
				if (result == null) result = caseElement(relInvocationEdge);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UmlxPackageImpl.REL_INVOCATION_NODE: {
				RelInvocationNode relInvocationNode = (RelInvocationNode)theEObject;
				T result = caseRelInvocationNode(relInvocationNode);
				if (result == null) result = caseNode(relInvocationNode);
				if (result == null) result = caseElement(relInvocationNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UmlxPackageImpl.REL_PATTERN_EDGE: {
				RelPatternEdge relPatternEdge = (RelPatternEdge)theEObject;
				T result = caseRelPatternEdge(relPatternEdge);
				if (result == null) result = caseEdge(relPatternEdge);
				if (result == null) result = caseElement(relPatternEdge);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UmlxPackageImpl.REL_PATTERN_NODE: {
				RelPatternNode relPatternNode = (RelPatternNode)theEObject;
				T result = caseRelPatternNode(relPatternNode);
				if (result == null) result = caseNode(relPatternNode);
				if (result == null) result = caseElement(relPatternNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UmlxPackageImpl.TX_DIAGRAM: {
				TxDiagram txDiagram = (TxDiagram)theEObject;
				T result = caseTxDiagram(txDiagram);
				if (result == null) result = caseDiagram(txDiagram);
				if (result == null) result = caseElement(txDiagram);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UmlxPackageImpl.TX_EDGE: {
				TxEdge txEdge = (TxEdge)theEObject;
				T result = caseTxEdge(txEdge);
				if (result == null) result = caseEdge(txEdge);
				if (result == null) result = caseElement(txEdge);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UmlxPackageImpl.TX_NODE: {
				TxNode txNode = (TxNode)theEObject;
				T result = caseTxNode(txNode);
				if (result == null) result = caseNode(txNode);
				if (result == null) result = caseElement(txNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UmlxPackageImpl.TX_PACKAGE_NODE: {
				TxPackageNode txPackageNode = (TxPackageNode)theEObject;
				T result = caseTxPackageNode(txPackageNode);
				if (result == null) result = caseTxNode(txPackageNode);
				if (result == null) result = caseNode(txPackageNode);
				if (result == null) result = caseElement(txPackageNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UmlxPackageImpl.TX_TRANSFORMATION_NODE: {
				TxTransformationNode txTransformationNode = (TxTransformationNode)theEObject;
				T result = caseTxTransformationNode(txTransformationNode);
				if (result == null) result = caseTxNode(txTransformationNode);
				if (result == null) result = caseNode(txTransformationNode);
				if (result == null) result = caseElement(txTransformationNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UmlxPackageImpl.TX_TYPED_MODEL_NODE: {
				TxTypedModelNode txTypedModelNode = (TxTypedModelNode)theEObject;
				T result = caseTxTypedModelNode(txTypedModelNode);
				if (result == null) result = caseTxNode(txTypedModelNode);
				if (result == null) result = caseNode(txTypedModelNode);
				if (result == null) result = caseElement(txTypedModelNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Diagram</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Diagram</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDiagram(Diagram object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Edge</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Edge</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEdge(Edge object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseElement(Element object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModel(Model object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNode(Node object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Rel Diagram</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Rel Diagram</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRelDiagram(RelDiagram object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Rel Domain Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Rel Domain Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRelDomainNode(RelDomainNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Rel Invocation Edge</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Rel Invocation Edge</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRelInvocationEdge(RelInvocationEdge object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Rel Invocation Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Rel Invocation Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRelInvocationNode(RelInvocationNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Rel Pattern Edge</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Rel Pattern Edge</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRelPatternEdge(RelPatternEdge object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Rel Pattern Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Rel Pattern Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRelPatternNode(RelPatternNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tx Diagram</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tx Diagram</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTxDiagram(TxDiagram object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tx Edge</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tx Edge</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTxEdge(TxEdge object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tx Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tx Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTxNode(TxNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tx Package Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tx Package Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTxPackageNode(TxPackageNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tx Transformation Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tx Transformation Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTxTransformationNode(TxTransformationNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tx Typed Model Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tx Typed Model Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTxTypedModelNode(TxTypedModelNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //UmlxSwitch
