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
package example1.source.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import org.eclipse.jdt.annotation.Nullable;

import example1.source.PathElementCS;
import example1.source.PathNameCS;
import example1.source.SElement;
import example1.source.SRoot;
import example1.source.SourcePackage;
import example1.source.X;
import example1.source.Y;
import example1.source.Y1;
import example1.source.Y2;
import example1.source.Z;

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
 * @see example1.source.SourcePackage
 * @generated
 */
public class SourceSwitch<@Nullable T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static SourcePackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SourceSwitch() {
		if (modelPackage == null) {
			modelPackage = SourcePackage.eINSTANCE;
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
			case SourcePackage.X: {
				X x = (X)theEObject;
				T result = caseX(x);
				if (result == null) result = caseSElement(x);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SourcePackage.Y: {
				Y y = (Y)theEObject;
				T result = caseY(y);
				if (result == null) result = caseSElement(y);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SourcePackage.Y1: {
				Y1 y1 = (Y1)theEObject;
				T result = caseY1(y1);
				if (result == null) result = caseY(y1);
				if (result == null) result = caseSElement(y1);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SourcePackage.Y2: {
				Y2 y2 = (Y2)theEObject;
				T result = caseY2(y2);
				if (result == null) result = caseY(y2);
				if (result == null) result = caseSElement(y2);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SourcePackage.Z: {
				Z z = (Z)theEObject;
				T result = caseZ(z);
				if (result == null) result = caseSElement(z);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SourcePackage.SROOT: {
				SRoot sRoot = (SRoot)theEObject;
				T result = caseSRoot(sRoot);
				if (result == null) result = caseSElement(sRoot);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SourcePackage.SELEMENT: {
				SElement sElement = (SElement)theEObject;
				T result = caseSElement(sElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SourcePackage.PATH_NAME_CS: {
				PathNameCS pathNameCS = (PathNameCS)theEObject;
				T result = casePathNameCS(pathNameCS);
				if (result == null) result = caseSElement(pathNameCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SourcePackage.PATH_ELEMENT_CS: {
				PathElementCS pathElementCS = (PathElementCS)theEObject;
				T result = casePathElementCS(pathElementCS);
				if (result == null) result = caseSElement(pathElementCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>X</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>X</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseX(X object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Y</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Y</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseY(Y object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Y1</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Y1</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseY1(Y1 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Y2</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Y2</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseY2(Y2 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Z</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Z</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseZ(Z object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>SRoot</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SRoot</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSRoot(SRoot object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>SElement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SElement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSElement(SElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Path Name CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Path Name CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePathNameCS(PathNameCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Path Element CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Path Element CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePathElementCS(PathElementCS object) {
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

} //SourceSwitch
