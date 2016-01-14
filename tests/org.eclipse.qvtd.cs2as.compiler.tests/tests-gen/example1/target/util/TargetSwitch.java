/*******************************************************************************
 * Copyright (c) 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
/**
 */
package example1.target.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import org.eclipse.jdt.annotation.Nullable;

import example1.target.A;
import example1.target.A1;
import example1.target.A2;
import example1.target.A3;
import example1.target.B;
import example1.target.C;
import example1.target.D;
import example1.target.NamedElement;
import example1.target.Namespace;
import example1.target.TRoot;
import example1.target.TargetPackage;

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
 * @see example1.target.TargetPackage
 * @generated
 */
public class TargetSwitch<@Nullable T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static TargetPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TargetSwitch() {
		if (modelPackage == null) {
			modelPackage = TargetPackage.eINSTANCE;
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
			case TargetPackage.A: {
				A a = (A)theEObject;
				T result = caseA(a);
				if (result == null) result = caseNamespace(a);
				if (result == null) result = caseNamedElement(a);
				if (result == null) result = caseVisitable(a);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TargetPackage.A1: {
				A1 a1 = (A1)theEObject;
				T result = caseA1(a1);
				if (result == null) result = caseA(a1);
				if (result == null) result = caseNamespace(a1);
				if (result == null) result = caseNamedElement(a1);
				if (result == null) result = caseVisitable(a1);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TargetPackage.A2: {
				A2 a2 = (A2)theEObject;
				T result = caseA2(a2);
				if (result == null) result = caseA(a2);
				if (result == null) result = caseNamespace(a2);
				if (result == null) result = caseNamedElement(a2);
				if (result == null) result = caseVisitable(a2);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TargetPackage.A3: {
				A3 a3 = (A3)theEObject;
				T result = caseA3(a3);
				if (result == null) result = caseA2(a3);
				if (result == null) result = caseA(a3);
				if (result == null) result = caseNamespace(a3);
				if (result == null) result = caseNamedElement(a3);
				if (result == null) result = caseVisitable(a3);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TargetPackage.B: {
				B b = (B)theEObject;
				T result = caseB(b);
				if (result == null) result = caseNamespace(b);
				if (result == null) result = caseNamedElement(b);
				if (result == null) result = caseVisitable(b);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TargetPackage.C: {
				C c = (C)theEObject;
				T result = caseC(c);
				if (result == null) result = caseNamespace(c);
				if (result == null) result = caseNamedElement(c);
				if (result == null) result = caseVisitable(c);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TargetPackage.D: {
				D d = (D)theEObject;
				T result = caseD(d);
				if (result == null) result = caseNamedElement(d);
				if (result == null) result = caseVisitable(d);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TargetPackage.TROOT: {
				TRoot tRoot = (TRoot)theEObject;
				T result = caseTRoot(tRoot);
				if (result == null) result = caseVisitable(tRoot);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TargetPackage.NAMED_ELEMENT: {
				NamedElement namedElement = (NamedElement)theEObject;
				T result = caseNamedElement(namedElement);
				if (result == null) result = caseVisitable(namedElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TargetPackage.NAMESPACE: {
				Namespace namespace = (Namespace)theEObject;
				T result = caseNamespace(namespace);
				if (result == null) result = caseNamedElement(namespace);
				if (result == null) result = caseVisitable(namespace);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TargetPackage.VISITABLE: {
				Visitable visitable = (Visitable)theEObject;
				T result = caseVisitable(visitable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>A</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>A</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseA(A object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>A1</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>A1</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseA1(A1 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>A2</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>A2</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseA2(A2 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>A3</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>A3</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseA3(A3 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>B</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>B</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseB(B object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>C</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>C</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseC(C object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>D</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>D</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseD(D object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TRoot</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TRoot</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTRoot(TRoot object) {
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
	public T caseNamedElement(NamedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Namespace</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Namespace</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNamespace(Namespace object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Visitable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Visitable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVisitable(Visitable object) {
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

} //TargetSwitch
