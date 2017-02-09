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
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.qvtd.umlx.*;

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
 * @see org.eclipse.qvtd.umlx.UMLXPackage
 * @generated
 */
public class UMLXSwitch<@Nullable T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static UMLXPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UMLXSwitch() {
		if (modelPackage == null) {
			modelPackage = UMLXPackage.eINSTANCE;
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
			case UMLXPackage.REL_DIAGRAM: {
				RelDiagram relDiagram = (RelDiagram)theEObject;
				T result = caseRelDiagram(relDiagram);
				if (result == null) result = caseUMLXNamedElement(relDiagram);
				if (result == null) result = caseUMLXElement(relDiagram);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLXPackage.REL_DOMAIN_NODE: {
				RelDomainNode relDomainNode = (RelDomainNode)theEObject;
				T result = caseRelDomainNode(relDomainNode);
				if (result == null) result = caseRelNode(relDomainNode);
				if (result == null) result = caseUMLXElement(relDomainNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLXPackage.REL_EDGE: {
				RelEdge relEdge = (RelEdge)theEObject;
				T result = caseRelEdge(relEdge);
				if (result == null) result = caseUMLXElement(relEdge);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLXPackage.REL_INVOCATION_EDGE: {
				RelInvocationEdge relInvocationEdge = (RelInvocationEdge)theEObject;
				T result = caseRelInvocationEdge(relInvocationEdge);
				if (result == null) result = caseRelEdge(relInvocationEdge);
				if (result == null) result = caseUMLXElement(relInvocationEdge);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLXPackage.REL_INVOCATION_NODE: {
				RelInvocationNode relInvocationNode = (RelInvocationNode)theEObject;
				T result = caseRelInvocationNode(relInvocationNode);
				if (result == null) result = caseRelNode(relInvocationNode);
				if (result == null) result = caseUMLXElement(relInvocationNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLXPackage.REL_NODE: {
				RelNode relNode = (RelNode)theEObject;
				T result = caseRelNode(relNode);
				if (result == null) result = caseUMLXElement(relNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLXPackage.REL_PATTERN_EDGE: {
				RelPatternEdge relPatternEdge = (RelPatternEdge)theEObject;
				T result = caseRelPatternEdge(relPatternEdge);
				if (result == null) result = caseRelEdge(relPatternEdge);
				if (result == null) result = caseUMLXElement(relPatternEdge);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLXPackage.REL_PATTERN_NODE: {
				RelPatternNode relPatternNode = (RelPatternNode)theEObject;
				T result = caseRelPatternNode(relPatternNode);
				if (result == null) result = caseRelNode(relPatternNode);
				if (result == null) result = caseUMLXTypedElement(relPatternNode);
				if (result == null) result = caseUMLXNamedElement(relPatternNode);
				if (result == null) result = caseUMLXElement(relPatternNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLXPackage.TX_DIAGRAM: {
				TxDiagram txDiagram = (TxDiagram)theEObject;
				T result = caseTxDiagram(txDiagram);
				if (result == null) result = caseUMLXNamedElement(txDiagram);
				if (result == null) result = caseUMLXElement(txDiagram);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLXPackage.TX_KEY_NODE: {
				TxKeyNode txKeyNode = (TxKeyNode)theEObject;
				T result = caseTxKeyNode(txKeyNode);
				if (result == null) result = caseTxNode(txKeyNode);
				if (result == null) result = caseUMLXElement(txKeyNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLXPackage.TX_NODE: {
				TxNode txNode = (TxNode)theEObject;
				T result = caseTxNode(txNode);
				if (result == null) result = caseUMLXElement(txNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLXPackage.TX_PACKAGE_NODE: {
				TxPackageNode txPackageNode = (TxPackageNode)theEObject;
				T result = caseTxPackageNode(txPackageNode);
				if (result == null) result = caseTxNode(txPackageNode);
				if (result == null) result = caseUMLXElement(txPackageNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLXPackage.TX_PARAMETER_NODE: {
				TxParameterNode txParameterNode = (TxParameterNode)theEObject;
				T result = caseTxParameterNode(txParameterNode);
				if (result == null) result = caseTxNode(txParameterNode);
				if (result == null) result = caseUMLXTypedElement(txParameterNode);
				if (result == null) result = caseUMLXNamedElement(txParameterNode);
				if (result == null) result = caseUMLXElement(txParameterNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLXPackage.TX_PART_NODE: {
				TxPartNode txPartNode = (TxPartNode)theEObject;
				T result = caseTxPartNode(txPartNode);
				if (result == null) result = caseTxNode(txPartNode);
				if (result == null) result = caseUMLXElement(txPartNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLXPackage.TX_QUERY_NODE: {
				TxQueryNode txQueryNode = (TxQueryNode)theEObject;
				T result = caseTxQueryNode(txQueryNode);
				if (result == null) result = caseTxNode(txQueryNode);
				if (result == null) result = caseUMLXTypedElement(txQueryNode);
				if (result == null) result = caseUMLXNamedElement(txQueryNode);
				if (result == null) result = caseUMLXElement(txQueryNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLXPackage.TX_TYPED_MODEL_NODE: {
				TxTypedModelNode txTypedModelNode = (TxTypedModelNode)theEObject;
				T result = caseTxTypedModelNode(txTypedModelNode);
				if (result == null) result = caseTxNode(txTypedModelNode);
				if (result == null) result = caseUMLXNamedElement(txTypedModelNode);
				if (result == null) result = caseUMLXElement(txTypedModelNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLXPackage.UMLX_ELEMENT: {
				UMLXElement umlxElement = (UMLXElement)theEObject;
				T result = caseUMLXElement(umlxElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLXPackage.UMLX_MODEL: {
				UMLXModel umlxModel = (UMLXModel)theEObject;
				T result = caseUMLXModel(umlxModel);
				if (result == null) result = caseUMLXElement(umlxModel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLXPackage.UMLX_NAMED_ELEMENT: {
				UMLXNamedElement umlxNamedElement = (UMLXNamedElement)theEObject;
				T result = caseUMLXNamedElement(umlxNamedElement);
				if (result == null) result = caseUMLXElement(umlxNamedElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UMLXPackage.UMLX_TYPED_ELEMENT: {
				UMLXTypedElement umlxTypedElement = (UMLXTypedElement)theEObject;
				T result = caseUMLXTypedElement(umlxTypedElement);
				if (result == null) result = caseUMLXNamedElement(umlxTypedElement);
				if (result == null) result = caseUMLXElement(umlxTypedElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
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
	 * Returns the result of interpreting the object as an instance of '<em>Rel Edge</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Rel Edge</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRelEdge(RelEdge object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Rel Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Rel Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRelNode(RelNode object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Tx Key Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tx Key Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTxKeyNode(TxKeyNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tx Part Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tx Part Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTxPartNode(TxPartNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tx Query Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tx Query Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTxQueryNode(TxQueryNode object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Tx Parameter Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tx Parameter Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTxParameterNode(TxParameterNode object) {
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
	public T caseUMLXElement(UMLXElement object) {
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
	public T caseUMLXModel(UMLXModel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Named Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Named Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUMLXNamedElement(UMLXNamedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Typed Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Typed Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUMLXTypedElement(UMLXTypedElement object) {
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

} //UMLXSwitch
