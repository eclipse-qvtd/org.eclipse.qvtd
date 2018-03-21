/**
 * <copyright>
 *
 * Copyright (c) 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.qvtd.runtime.qvttrace.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.qvtd.runtime.qvttrace.Dispatch;
import org.eclipse.qvtd.runtime.qvttrace.Execution;
import org.eclipse.qvtd.runtime.qvttrace.QVTtraceFactory;
import org.eclipse.qvtd.runtime.qvttrace.QVTtracePackage;
import org.eclipse.qvtd.runtime.qvttrace.TraceElement;
import org.eclipse.qvtd.runtime.qvttrace.TraceInstance;
import org.eclipse.qvtd.runtime.qvttrace.TraceModel;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class QVTtracePackageImpl extends EPackageImpl implements QVTtracePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dispatchEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass executionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass traceElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass traceInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass traceModelEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.qvtd.runtime.qvttrace.QVTtracePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private QVTtracePackageImpl() {
		super(eNS_URI, QVTtraceFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>This method is used to initialize {@link QVTtracePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static QVTtracePackage init() {
		if (isInited) return (QVTtracePackage)EPackage.Registry.INSTANCE.getEPackage(QVTtracePackage.eNS_URI);

		// Obtain or create and register package
		Object registeredQVTtracePackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		QVTtracePackageImpl theQVTtracePackage = registeredQVTtracePackage instanceof QVTtracePackageImpl ? (QVTtracePackageImpl)registeredQVTtracePackage : new QVTtracePackageImpl();

		isInited = true;

		// Create package meta-data objects
		theQVTtracePackage.createPackageContents();

		// Initialize created meta-data
		theQVTtracePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theQVTtracePackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(QVTtracePackage.eNS_URI, theQVTtracePackage);
		return theQVTtracePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDispatch() {
		return dispatchEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDispatch_Success() {
		return (EAttribute)dispatchEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getExecution() {
		return executionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTraceElement() {
		return traceElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTraceInstance() {
		return traceInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTraceInstance_OwningModel() {
		return (EReference)traceInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTraceModel() {
		return traceModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTraceModel_OwnedTraces() {
		return (EReference)traceModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTraceModel_Name() {
		return (EAttribute)traceModelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public QVTtraceFactory getQVTtraceFactory() {
		return (QVTtraceFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		dispatchEClass = createEClass(DISPATCH);
		createEAttribute(dispatchEClass, DISPATCH__SUCCESS);

		executionEClass = createEClass(EXECUTION);

		traceElementEClass = createEClass(TRACE_ELEMENT);

		traceInstanceEClass = createEClass(TRACE_INSTANCE);
		createEReference(traceInstanceEClass, TRACE_INSTANCE__OWNING_MODEL);

		traceModelEClass = createEClass(TRACE_MODEL);
		createEReference(traceModelEClass, TRACE_MODEL__OWNED_TRACES);
		createEAttribute(traceModelEClass, TRACE_MODEL__NAME);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		dispatchEClass.getESuperTypes().add(this.getTraceInstance());
		executionEClass.getESuperTypes().add(this.getTraceInstance());
		traceInstanceEClass.getESuperTypes().add(this.getTraceElement());
		traceModelEClass.getESuperTypes().add(this.getTraceElement());

		// Initialize classes, features, and operations; add parameters
		initEClass(dispatchEClass, Dispatch.class, "Dispatch", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDispatch_Success(), ecorePackage.getEBooleanObject(), "success", null, 0, 1, Dispatch.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(executionEClass, Execution.class, "Execution", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(traceElementEClass, TraceElement.class, "TraceElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(traceInstanceEClass, TraceInstance.class, "TraceInstance", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTraceInstance_OwningModel(), this.getTraceModel(), this.getTraceModel_OwnedTraces(), "owningModel", null, 0, 1, TraceInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(traceModelEClass, TraceModel.class, "TraceModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTraceModel_OwnedTraces(), this.getTraceInstance(), this.getTraceInstance_OwningModel(), "ownedTraces", null, 0, -1, TraceModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTraceModel_Name(), ecorePackage.getEString(), "name", null, 1, 1, TraceModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //QVTtracePackageImpl