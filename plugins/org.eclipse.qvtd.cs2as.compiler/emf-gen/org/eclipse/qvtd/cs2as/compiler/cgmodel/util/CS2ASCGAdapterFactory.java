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
package org.eclipse.qvtd.cs2as.compiler.cgmodel.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.cgmodel.CGCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGElement;
import org.eclipse.ocl.examples.codegen.cgmodel.CGNamedElement;
import org.eclipse.ocl.examples.codegen.cgmodel.CGOperationCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGTypedElement;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;

import org.eclipse.ocl.pivot.utilities.Nameable;
import org.eclipse.qvtd.cs2as.compiler.cgmodel.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.qvtd.cs2as.compiler.cgmodel.CS2ASCGPackage
 * @generated
 */
public class CS2ASCGAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static CS2ASCGPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CS2ASCGAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = CS2ASCGPackage.eINSTANCE;
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
	protected CS2ASCGSwitch<@Nullable Adapter> modelSwitch =
		new CS2ASCGSwitch<@Nullable Adapter>() {
			@Override
			public Adapter caseCGLookupCallExp(CGLookupCallExp object) {
				return createCGLookupCallExpAdapter();
			}
			@Override
			public Adapter caseCGElement(CGElement object) {
				return createCGElementAdapter();
			}
			@Override
			public Adapter caseNameable(Nameable object) {
				return createNameableAdapter();
			}
			@Override
			public Adapter caseCGNamedElement(CGNamedElement object) {
				return createCGNamedElementAdapter();
			}
			@Override
			public Adapter caseCGTypedElement(CGTypedElement object) {
				return createCGTypedElementAdapter();
			}
			@Override
			public Adapter caseCGValuedElement(CGValuedElement object) {
				return createCGValuedElementAdapter();
			}
			@Override
			public Adapter caseCGCallExp(CGCallExp object) {
				return createCGCallExpAdapter();
			}
			@Override
			public Adapter caseCGOperationCallExp(CGOperationCallExp object) {
				return createCGOperationCallExpAdapter();
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
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.cs2as.compiler.cgmodel.CGLookupCallExp <em>CG Lookup Call Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.cs2as.compiler.cgmodel.CGLookupCallExp
	 * @generated
	 */
	public Adapter createCGLookupCallExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGElement <em>CG Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGElement
	 * @generated
	 */
	public Adapter createCGElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.pivot.utilities.Nameable <em>Nameable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.pivot.utilities.Nameable
	 * @generated
	 */
	public Adapter createNameableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGNamedElement <em>CG Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGNamedElement
	 * @generated
	 */
	public Adapter createCGNamedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGTypedElement <em>CG Typed Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGTypedElement
	 * @generated
	 */
	public Adapter createCGTypedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement <em>CG Valued Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement
	 * @generated
	 */
	public Adapter createCGValuedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGCallExp <em>CG Call Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGCallExp
	 * @generated
	 */
	public Adapter createCGCallExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGOperationCallExp <em>CG Operation Call Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGOperationCallExp
	 * @generated
	 */
	public Adapter createCGOperationCallExpAdapter() {
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

} //CS2ASCGAdapterFactory
