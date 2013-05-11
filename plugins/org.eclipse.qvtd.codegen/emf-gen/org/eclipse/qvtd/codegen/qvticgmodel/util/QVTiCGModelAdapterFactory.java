/**
 * <copyright>
 * 
 * Copyright (c) 2013 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 * 
 * </copyright>
 */
package org.eclipse.qvtd.codegen.qvticgmodel.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.ocl.examples.codegen.cgmodel.CGCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGClass;
import org.eclipse.ocl.examples.codegen.cgmodel.CGElement;
import org.eclipse.ocl.examples.codegen.cgmodel.CGNamedElement;
import org.eclipse.ocl.examples.codegen.cgmodel.CGOperation;
import org.eclipse.ocl.examples.codegen.cgmodel.CGOperationCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGParameter;
import org.eclipse.ocl.examples.codegen.cgmodel.CGTypedElement;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.cgmodel.CGVariable;

import org.eclipse.ocl.examples.domain.elements.Nameable;

import org.eclipse.qvtd.codegen.qvticgmodel.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.qvtd.codegen.qvticgmodel.QVTiCGModelPackage
 * @generated
 */
public class QVTiCGModelAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static QVTiCGModelPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QVTiCGModelAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = QVTiCGModelPackage.eINSTANCE;
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
	protected QVTiCGModelSwitch<Adapter> modelSwitch =
		new QVTiCGModelSwitch<Adapter>() {
			@Override
			public Adapter caseCGEcorePropertyAssignment(CGEcorePropertyAssignment object) {
				return createCGEcorePropertyAssignmentAdapter();
			}
			@Override
			public Adapter caseCGEcoreRealizedVariable(CGEcoreRealizedVariable object) {
				return createCGEcoreRealizedVariableAdapter();
			}
			@Override
			public Adapter caseCGFunction(CGFunction object) {
				return createCGFunctionAdapter();
			}
			@Override
			public Adapter caseCGFunctionCallExp(CGFunctionCallExp object) {
				return createCGFunctionCallExpAdapter();
			}
			@Override
			public Adapter caseCGFunctionParameter(CGFunctionParameter object) {
				return createCGFunctionParameterAdapter();
			}
			@Override
			public Adapter caseCGGuardVariable(CGGuardVariable object) {
				return createCGGuardVariableAdapter();
			}
			@Override
			public Adapter caseCGMapping(CGMapping object) {
				return createCGMappingAdapter();
			}
			@Override
			public Adapter caseCGMappingCall(CGMappingCall object) {
				return createCGMappingCallAdapter();
			}
			@Override
			public Adapter caseCGMappingCallBinding(CGMappingCallBinding object) {
				return createCGMappingCallBindingAdapter();
			}
			@Override
			public Adapter caseCGPredicate(CGPredicate object) {
				return createCGPredicateAdapter();
			}
			@Override
			public Adapter caseCGPropertyAssignment(CGPropertyAssignment object) {
				return createCGPropertyAssignmentAdapter();
			}
			@Override
			public Adapter caseCGRealizedVariable(CGRealizedVariable object) {
				return createCGRealizedVariableAdapter();
			}
			@Override
			public Adapter caseCGTransformation(CGTransformation object) {
				return createCGTransformationAdapter();
			}
			@Override
			public Adapter caseCGTypedModel(CGTypedModel object) {
				return createCGTypedModelAdapter();
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
			public Adapter caseCGVariable(CGVariable object) {
				return createCGVariableAdapter();
			}
			@Override
			public Adapter caseCGOperation(CGOperation object) {
				return createCGOperationAdapter();
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
			public Adapter caseCGParameter(CGParameter object) {
				return createCGParameterAdapter();
			}
			@Override
			public Adapter caseCGClass(CGClass object) {
				return createCGClassAdapter();
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
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGEcorePropertyAssignment <em>CG Ecore Property Assignment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGEcorePropertyAssignment
	 * @generated
	 */
	public Adapter createCGEcorePropertyAssignmentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGEcoreRealizedVariable <em>CG Ecore Realized Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGEcoreRealizedVariable
	 * @generated
	 */
	public Adapter createCGEcoreRealizedVariableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGFunction <em>CG Function</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGFunction
	 * @generated
	 */
	public Adapter createCGFunctionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGFunctionCallExp <em>CG Function Call Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGFunctionCallExp
	 * @generated
	 */
	public Adapter createCGFunctionCallExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGFunctionParameter <em>CG Function Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGFunctionParameter
	 * @generated
	 */
	public Adapter createCGFunctionParameterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGGuardVariable <em>CG Guard Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGGuardVariable
	 * @generated
	 */
	public Adapter createCGGuardVariableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGPropertyAssignment <em>CG Property Assignment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGPropertyAssignment
	 * @generated
	 */
	public Adapter createCGPropertyAssignmentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGMapping <em>CG Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGMapping
	 * @generated
	 */
	public Adapter createCGMappingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGTransformation <em>CG Transformation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGTransformation
	 * @generated
	 */
	public Adapter createCGTransformationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGTypedModel <em>CG Typed Model</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGTypedModel
	 * @generated
	 */
	public Adapter createCGTypedModelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGMappingCall <em>CG Mapping Call</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGMappingCall
	 * @generated
	 */
	public Adapter createCGMappingCallAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGMappingCallBinding <em>CG Mapping Call Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGMappingCallBinding
	 * @generated
	 */
	public Adapter createCGMappingCallBindingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGPredicate <em>CG Predicate</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGPredicate
	 * @generated
	 */
	public Adapter createCGPredicateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvtd.codegen.qvticgmodel.CGRealizedVariable <em>CG Realized Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.CGRealizedVariable
	 * @generated
	 */
	public Adapter createCGRealizedVariableAdapter() {
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
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.domain.elements.Nameable <em>Nameable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.domain.elements.Nameable
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
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGOperation <em>CG Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGOperation
	 * @generated
	 */
	public Adapter createCGOperationAdapter() {
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
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGParameter <em>CG Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGParameter
	 * @generated
	 */
	public Adapter createCGParameterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGClass <em>CG Class</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGClass
	 * @generated
	 */
	public Adapter createCGClassAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.examples.codegen.cgmodel.CGVariable <em>CG Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.examples.codegen.cgmodel.CGVariable
	 * @generated
	 */
	public Adapter createCGVariableAdapter() {
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

} //QVTiCGModelAdapterFactory
