/**
 * <copyright>
 * 
 * Copyright (c) 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 * 
 * </copyright>
 */
package org.eclipse.qvtd.runtime.qvttrace;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.qvtd.runtime.qvttrace.QVTtraceFactory
 * @model kind="package"
 * @generated
 */
public interface QVTtracePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "qvttrace";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/qvt/2018/QVTtrace";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "qvttrace";

	/**
	 * The package content type ID.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eCONTENT_TYPE = "org.eclipse.qvtd.qvttrace";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	QVTtracePackage eINSTANCE = org.eclipse.qvtd.runtime.qvttrace.impl.QVTtracePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.runtime.qvttrace.impl.TraceElementImpl <em>Trace Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.runtime.qvttrace.impl.TraceElementImpl
	 * @see org.eclipse.qvtd.runtime.qvttrace.impl.QVTtracePackageImpl#getTraceElement()
	 * @generated
	 */
	int TRACE_ELEMENT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.runtime.qvttrace.impl.TraceInstanceImpl <em>Trace Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.runtime.qvttrace.impl.TraceInstanceImpl
	 * @see org.eclipse.qvtd.runtime.qvttrace.impl.QVTtracePackageImpl#getTraceInstance()
	 * @generated
	 */
	int TRACE_INSTANCE = 3;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.runtime.qvttrace.impl.DispatchImpl <em>Dispatch</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.runtime.qvttrace.impl.DispatchImpl
	 * @see org.eclipse.qvtd.runtime.qvttrace.impl.QVTtracePackageImpl#getDispatch()
	 * @generated
	 */
	int DISPATCH = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.runtime.qvttrace.impl.ExecutionImpl <em>Execution</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.runtime.qvttrace.impl.ExecutionImpl
	 * @see org.eclipse.qvtd.runtime.qvttrace.impl.QVTtracePackageImpl#getExecution()
	 * @generated
	 */
	int EXECUTION = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.runtime.qvttrace.impl.TraceModelImpl <em>Trace Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.runtime.qvttrace.impl.TraceModelImpl
	 * @see org.eclipse.qvtd.runtime.qvttrace.impl.QVTtracePackageImpl#getTraceModel()
	 * @generated
	 */
	int TRACE_MODEL = 4;

	/**
	 * The number of structural features of the '<em>Trace Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_ELEMENT_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Trace Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_ELEMENT_OPERATION_COUNT = 0;

	/**
	 * The feature id for the '<em><b>Owning Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_INSTANCE__OWNING_MODEL = TRACE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Trace Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_INSTANCE_FEATURE_COUNT = TRACE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Trace Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_INSTANCE_OPERATION_COUNT = TRACE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owning Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPATCH__OWNING_MODEL = TRACE_INSTANCE__OWNING_MODEL;

	/**
	 * The feature id for the '<em><b>Success</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPATCH__SUCCESS = TRACE_INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Dispatch</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPATCH_FEATURE_COUNT = TRACE_INSTANCE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Dispatch</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPATCH_OPERATION_COUNT = TRACE_INSTANCE_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owning Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION__OWNING_MODEL = TRACE_INSTANCE__OWNING_MODEL;

	/**
	 * The number of structural features of the '<em>Execution</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_FEATURE_COUNT = TRACE_INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Execution</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_OPERATION_COUNT = TRACE_INSTANCE_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Traces</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_MODEL__OWNED_TRACES = TRACE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_MODEL__NAME = TRACE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Trace Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_MODEL_FEATURE_COUNT = TRACE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Trace Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_MODEL_OPERATION_COUNT = TRACE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.runtime.qvttrace.Dispatch <em>Dispatch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dispatch</em>'.
	 * @see org.eclipse.qvtd.runtime.qvttrace.Dispatch
	 * @generated
	 */
	EClass getDispatch();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.runtime.qvttrace.Dispatch#getSuccess <em>Success</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Success</em>'.
	 * @see org.eclipse.qvtd.runtime.qvttrace.Dispatch#getSuccess()
	 * @see #getDispatch()
	 * @generated
	 */
	EAttribute getDispatch_Success();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.runtime.qvttrace.Execution <em>Execution</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Execution</em>'.
	 * @see org.eclipse.qvtd.runtime.qvttrace.Execution
	 * @generated
	 */
	EClass getExecution();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.runtime.qvttrace.TraceElement <em>Trace Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Trace Element</em>'.
	 * @see org.eclipse.qvtd.runtime.qvttrace.TraceElement
	 * @generated
	 */
	EClass getTraceElement();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.runtime.qvttrace.TraceInstance <em>Trace Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Trace Instance</em>'.
	 * @see org.eclipse.qvtd.runtime.qvttrace.TraceInstance
	 * @generated
	 */
	EClass getTraceInstance();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.runtime.qvttrace.TraceInstance#getOwningModel <em>Owning Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Model</em>'.
	 * @see org.eclipse.qvtd.runtime.qvttrace.TraceInstance#getOwningModel()
	 * @see #getTraceInstance()
	 * @generated
	 */
	EReference getTraceInstance_OwningModel();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.runtime.qvttrace.TraceModel <em>Trace Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Trace Model</em>'.
	 * @see org.eclipse.qvtd.runtime.qvttrace.TraceModel
	 * @generated
	 */
	EClass getTraceModel();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.runtime.qvttrace.TraceModel#getOwnedTraces <em>Owned Traces</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Traces</em>'.
	 * @see org.eclipse.qvtd.runtime.qvttrace.TraceModel#getOwnedTraces()
	 * @see #getTraceModel()
	 * @generated
	 */
	EReference getTraceModel_OwnedTraces();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.runtime.qvttrace.TraceModel#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.qvtd.runtime.qvttrace.TraceModel#getName()
	 * @see #getTraceModel()
	 * @generated
	 */
	EAttribute getTraceModel_Name();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	QVTtraceFactory getQVTtraceFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.runtime.qvttrace.impl.DispatchImpl <em>Dispatch</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.runtime.qvttrace.impl.DispatchImpl
		 * @see org.eclipse.qvtd.runtime.qvttrace.impl.QVTtracePackageImpl#getDispatch()
		 * @generated
		 */
		EClass DISPATCH = eINSTANCE.getDispatch();

		/**
		 * The meta object literal for the '<em><b>Success</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DISPATCH__SUCCESS = eINSTANCE.getDispatch_Success();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.runtime.qvttrace.impl.ExecutionImpl <em>Execution</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.runtime.qvttrace.impl.ExecutionImpl
		 * @see org.eclipse.qvtd.runtime.qvttrace.impl.QVTtracePackageImpl#getExecution()
		 * @generated
		 */
		EClass EXECUTION = eINSTANCE.getExecution();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.runtime.qvttrace.impl.TraceElementImpl <em>Trace Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.runtime.qvttrace.impl.TraceElementImpl
		 * @see org.eclipse.qvtd.runtime.qvttrace.impl.QVTtracePackageImpl#getTraceElement()
		 * @generated
		 */
		EClass TRACE_ELEMENT = eINSTANCE.getTraceElement();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.runtime.qvttrace.impl.TraceInstanceImpl <em>Trace Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.runtime.qvttrace.impl.TraceInstanceImpl
		 * @see org.eclipse.qvtd.runtime.qvttrace.impl.QVTtracePackageImpl#getTraceInstance()
		 * @generated
		 */
		EClass TRACE_INSTANCE = eINSTANCE.getTraceInstance();

		/**
		 * The meta object literal for the '<em><b>Owning Model</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRACE_INSTANCE__OWNING_MODEL = eINSTANCE.getTraceInstance_OwningModel();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.runtime.qvttrace.impl.TraceModelImpl <em>Trace Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.runtime.qvttrace.impl.TraceModelImpl
		 * @see org.eclipse.qvtd.runtime.qvttrace.impl.QVTtracePackageImpl#getTraceModel()
		 * @generated
		 */
		EClass TRACE_MODEL = eINSTANCE.getTraceModel();

		/**
		 * The meta object literal for the '<em><b>Owned Traces</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRACE_MODEL__OWNED_TRACES = eINSTANCE.getTraceModel_OwnedTraces();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRACE_MODEL__NAME = eINSTANCE.getTraceModel_Name();

	}

} //QVTtracePackage
