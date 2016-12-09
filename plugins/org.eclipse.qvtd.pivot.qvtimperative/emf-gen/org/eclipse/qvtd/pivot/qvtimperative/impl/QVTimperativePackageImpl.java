/*******************************************************************************
 * Copyright (c) 2013, 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtimperative.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage;
import org.eclipse.qvtd.pivot.qvtimperative.AddStatement;
import org.eclipse.qvtd.pivot.qvtimperative.AppendParameter;
import org.eclipse.qvtd.pivot.qvtimperative.AppendParameterBinding;
import org.eclipse.qvtd.pivot.qvtimperative.BufferStatement;
import org.eclipse.qvtd.pivot.qvtimperative.CheckStatement;
import org.eclipse.qvtd.pivot.qvtimperative.ConnectionVariable;
import org.eclipse.qvtd.pivot.qvtimperative.DeclareStatement;
import org.eclipse.qvtd.pivot.qvtimperative.GuardParameter;
import org.eclipse.qvtd.pivot.qvtimperative.GuardParameterBinding;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeModel;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeTransformation;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeTypedModel;
import org.eclipse.qvtd.pivot.qvtimperative.LoopParameterBinding;
import org.eclipse.qvtd.pivot.qvtimperative.LoopVariable;
import org.eclipse.qvtd.pivot.qvtimperative.Mapping;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCall;
import org.eclipse.qvtd.pivot.qvtimperative.MappingLoop;
import org.eclipse.qvtd.pivot.qvtimperative.MappingParameter;
import org.eclipse.qvtd.pivot.qvtimperative.MappingParameterBinding;
import org.eclipse.qvtd.pivot.qvtimperative.MappingStatement;
import org.eclipse.qvtd.pivot.qvtimperative.NewStatement;
import org.eclipse.qvtd.pivot.qvtimperative.ObservableStatement;
import org.eclipse.qvtd.pivot.qvtimperative.QVTimperativeFactory;
import org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage;
import org.eclipse.qvtd.pivot.qvtimperative.SetStatement;
import org.eclipse.qvtd.pivot.qvtimperative.SimpleParameter;
import org.eclipse.qvtd.pivot.qvtimperative.SimpleParameterBinding;
import org.eclipse.qvtd.pivot.qvtimperative.Statement;
import org.eclipse.qvtd.pivot.qvtimperative.VariableStatement;
import org.eclipse.qvtd.pivot.qvtimperative.util.QVTimperativeValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class QVTimperativePackageImpl extends EPackageImpl implements QVTimperativePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass addStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass appendParameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass appendParameterBindingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bufferStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass checkStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass connectionVariableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass declareStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass guardParameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass guardParameterBindingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass imperativeModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass imperativeTransformationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass imperativeTypedModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass loopParameterBindingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass loopVariableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mappingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mappingCallEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mappingLoopEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mappingParameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mappingParameterBindingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mappingStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass newStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass observableStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass setStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass simpleParameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass simpleParameterBindingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass statementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass variableStatementEClass = null;

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
	 * @see org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private QVTimperativePackageImpl() {
		super(eNS_URI, QVTimperativeFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link QVTimperativePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static QVTimperativePackage init() {
		if (isInited) return (QVTimperativePackage)EPackage.Registry.INSTANCE.getEPackage(QVTimperativePackage.eNS_URI);

		// Obtain or create and register package
		Object ePackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		QVTimperativePackageImpl theQVTimperativePackage = (QVTimperativePackageImpl)(ePackage instanceof QVTimperativePackageImpl ? ePackage : new QVTimperativePackageImpl());

		isInited = true;

		// Initialize simple dependencies
		QVTbasePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theQVTimperativePackage.createPackageContents();

		// Initialize created meta-data
		theQVTimperativePackage.initializePackageContents();

		// Register package validator
		EValidator.Registry.INSTANCE.put
		(theQVTimperativePackage,
			new EValidator.Descriptor() {
			@Override
			public EValidator getEValidator() {
				return QVTimperativeValidator.INSTANCE;
			}
		});

		// Mark meta-data to indicate it can't be changed
		theQVTimperativePackage.freeze();


		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(QVTimperativePackage.eNS_URI, theQVTimperativePackage);
		return theQVTimperativePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAddStatement() {
		return addStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAddStatement_TargetVariable() {
		return (EReference)addStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAddStatement_IsEnforcedUnique() {
		return (EAttribute)addStatementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAddStatement_OwnedExpression() {
		return (EReference)addStatementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAppendParameter() {
		return appendParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAppendParameterBinding() {
		return appendParameterBindingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAppendParameterBinding_Value() {
		return (EReference)appendParameterBindingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getBufferStatement() {
		return bufferStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getBufferStatement_OwnedExpression() {
		return (EReference)bufferStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCheckStatement() {
		return checkStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCheckStatement_OwnedExpression() {
		return (EReference)checkStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getConnectionVariable() {
		return connectionVariableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getConnectionVariable_IsStrict() {
		return (EAttribute)connectionVariableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDeclareStatement() {
		return declareStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDeclareStatement_IsCheck() {
		return (EAttribute)declareStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDeclareStatement_OwnedExpression() {
		return (EReference)declareStatementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getGuardParameter() {
		return guardParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGuardParameter_ReferredTypedModel() {
		return (EReference)guardParameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getGuardParameterBinding() {
		return guardParameterBindingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getGuardParameterBinding_Value() {
		return (EReference)guardParameterBindingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getGuardParameterBinding_IsCheck() {
		return (EAttribute)guardParameterBindingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getImperativeModel() {
		return imperativeModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getImperativeTransformation() {
		return imperativeTransformationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getImperativeTypedModel() {
		return imperativeTypedModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getImperativeTypedModel_IsChecked() {
		return (EAttribute)imperativeTypedModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getImperativeTypedModel_IsEnforced() {
		return (EAttribute)imperativeTypedModelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getLoopParameterBinding() {
		return loopParameterBindingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getLoopParameterBinding_Value() {
		return (EReference)loopParameterBindingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getLoopParameterBinding_IsCheck() {
		return (EAttribute)loopParameterBindingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getLoopVariable() {
		return loopVariableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getLoopVariable_OwningMappingLoop() {
		return (EReference)loopVariableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMapping() {
		return mappingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMapping_IsStrict() {
		return (EAttribute)mappingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMapping_OwnedParameters() {
		return (EReference)mappingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMapping_OwnedStatements() {
		return (EReference)mappingEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getMapping__ValidateisTrue__DiagnosticChain_Map() {
		return mappingEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMappingCall() {
		return mappingCallEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMappingCall_ReferredMapping() {
		return (EReference)mappingCallEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMappingCall_Binding() {
		return (EReference)mappingCallEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMappingCall_IsInstall() {
		return (EAttribute)mappingCallEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMappingCall_IsInvoke() {
		return (EAttribute)mappingCallEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMappingLoop() {
		return mappingLoopEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMappingLoop_OwnedIterators() {
		return (EReference)mappingLoopEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMappingLoop_OwnedMappingStatements() {
		return (EReference)mappingLoopEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMappingLoop_OwnedExpression() {
		return (EReference)mappingLoopEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMappingParameter() {
		return mappingParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMappingParameterBinding() {
		return mappingParameterBindingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMappingParameterBinding_MappingCall() {
		return (EReference)mappingParameterBindingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMappingParameterBinding_BoundVariable() {
		return (EReference)mappingParameterBindingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMappingStatement() {
		return mappingStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getNewStatement() {
		return newStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getNewStatement_ReferredTypedModel() {
		return (EReference)newStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getNewStatement_OwnedExpression() {
		return (EReference)newStatementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getObservableStatement() {
		return observableStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getObservableStatement_ObservedProperties() {
		return (EReference)observableStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSetStatement() {
		return setStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSetStatement_TargetVariable() {
		return (EReference)setStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSetStatement_TargetProperty() {
		return (EReference)setStatementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSetStatement_IsOpposite() {
		return (EAttribute)setStatementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSetStatement_IsNotify() {
		return (EAttribute)setStatementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSetStatement_OwnedExpression() {
		return (EReference)setStatementEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSimpleParameter() {
		return simpleParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSimpleParameter_ReferredTypedModel() {
		return (EReference)simpleParameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSimpleParameterBinding() {
		return simpleParameterBindingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSimpleParameterBinding_Value() {
		return (EReference)simpleParameterBindingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSimpleParameterBinding_IsCheck() {
		return (EAttribute)simpleParameterBindingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getStatement() {
		return statementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getVariableStatement() {
		return variableStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public QVTimperativeFactory getQVTimperativeFactory() {
		return (QVTimperativeFactory)getEFactoryInstance();
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
		addStatementEClass = createEClass(ADD_STATEMENT);
		createEReference(addStatementEClass, ADD_STATEMENT__TARGET_VARIABLE);
		createEAttribute(addStatementEClass, ADD_STATEMENT__IS_ENFORCED_UNIQUE);
		createEReference(addStatementEClass, ADD_STATEMENT__OWNED_EXPRESSION);

		appendParameterEClass = createEClass(APPEND_PARAMETER);

		appendParameterBindingEClass = createEClass(APPEND_PARAMETER_BINDING);
		createEReference(appendParameterBindingEClass, APPEND_PARAMETER_BINDING__VALUE);

		bufferStatementEClass = createEClass(BUFFER_STATEMENT);
		createEReference(bufferStatementEClass, BUFFER_STATEMENT__OWNED_EXPRESSION);

		checkStatementEClass = createEClass(CHECK_STATEMENT);
		createEReference(checkStatementEClass, CHECK_STATEMENT__OWNED_EXPRESSION);

		connectionVariableEClass = createEClass(CONNECTION_VARIABLE);
		createEAttribute(connectionVariableEClass, CONNECTION_VARIABLE__IS_STRICT);

		declareStatementEClass = createEClass(DECLARE_STATEMENT);
		createEAttribute(declareStatementEClass, DECLARE_STATEMENT__IS_CHECK);
		createEReference(declareStatementEClass, DECLARE_STATEMENT__OWNED_EXPRESSION);

		guardParameterEClass = createEClass(GUARD_PARAMETER);
		createEReference(guardParameterEClass, GUARD_PARAMETER__REFERRED_TYPED_MODEL);

		guardParameterBindingEClass = createEClass(GUARD_PARAMETER_BINDING);
		createEReference(guardParameterBindingEClass, GUARD_PARAMETER_BINDING__VALUE);
		createEAttribute(guardParameterBindingEClass, GUARD_PARAMETER_BINDING__IS_CHECK);

		imperativeModelEClass = createEClass(IMPERATIVE_MODEL);

		imperativeTransformationEClass = createEClass(IMPERATIVE_TRANSFORMATION);

		imperativeTypedModelEClass = createEClass(IMPERATIVE_TYPED_MODEL);
		createEAttribute(imperativeTypedModelEClass, IMPERATIVE_TYPED_MODEL__IS_CHECKED);
		createEAttribute(imperativeTypedModelEClass, IMPERATIVE_TYPED_MODEL__IS_ENFORCED);

		loopParameterBindingEClass = createEClass(LOOP_PARAMETER_BINDING);
		createEReference(loopParameterBindingEClass, LOOP_PARAMETER_BINDING__VALUE);
		createEAttribute(loopParameterBindingEClass, LOOP_PARAMETER_BINDING__IS_CHECK);

		loopVariableEClass = createEClass(LOOP_VARIABLE);
		createEReference(loopVariableEClass, LOOP_VARIABLE__OWNING_MAPPING_LOOP);

		mappingEClass = createEClass(MAPPING);
		createEAttribute(mappingEClass, MAPPING__IS_STRICT);
		createEReference(mappingEClass, MAPPING__OWNED_PARAMETERS);
		createEReference(mappingEClass, MAPPING__OWNED_STATEMENTS);
		createEOperation(mappingEClass, MAPPING___VALIDATEIS_TRUE__DIAGNOSTICCHAIN_MAP);

		mappingCallEClass = createEClass(MAPPING_CALL);
		createEReference(mappingCallEClass, MAPPING_CALL__BINDING);
		createEAttribute(mappingCallEClass, MAPPING_CALL__IS_INSTALL);
		createEAttribute(mappingCallEClass, MAPPING_CALL__IS_INVOKE);
		createEReference(mappingCallEClass, MAPPING_CALL__REFERRED_MAPPING);

		mappingLoopEClass = createEClass(MAPPING_LOOP);
		createEReference(mappingLoopEClass, MAPPING_LOOP__OWNED_ITERATORS);
		createEReference(mappingLoopEClass, MAPPING_LOOP__OWNED_MAPPING_STATEMENTS);
		createEReference(mappingLoopEClass, MAPPING_LOOP__OWNED_EXPRESSION);

		mappingParameterEClass = createEClass(MAPPING_PARAMETER);

		mappingParameterBindingEClass = createEClass(MAPPING_PARAMETER_BINDING);
		createEReference(mappingParameterBindingEClass, MAPPING_PARAMETER_BINDING__MAPPING_CALL);
		createEReference(mappingParameterBindingEClass, MAPPING_PARAMETER_BINDING__BOUND_VARIABLE);

		mappingStatementEClass = createEClass(MAPPING_STATEMENT);

		newStatementEClass = createEClass(NEW_STATEMENT);
		createEReference(newStatementEClass, NEW_STATEMENT__REFERRED_TYPED_MODEL);
		createEReference(newStatementEClass, NEW_STATEMENT__OWNED_EXPRESSION);

		observableStatementEClass = createEClass(OBSERVABLE_STATEMENT);
		createEReference(observableStatementEClass, OBSERVABLE_STATEMENT__OBSERVED_PROPERTIES);

		setStatementEClass = createEClass(SET_STATEMENT);
		createEReference(setStatementEClass, SET_STATEMENT__TARGET_VARIABLE);
		createEReference(setStatementEClass, SET_STATEMENT__TARGET_PROPERTY);
		createEAttribute(setStatementEClass, SET_STATEMENT__IS_OPPOSITE);
		createEAttribute(setStatementEClass, SET_STATEMENT__IS_NOTIFY);
		createEReference(setStatementEClass, SET_STATEMENT__OWNED_EXPRESSION);

		simpleParameterEClass = createEClass(SIMPLE_PARAMETER);
		createEReference(simpleParameterEClass, SIMPLE_PARAMETER__REFERRED_TYPED_MODEL);

		simpleParameterBindingEClass = createEClass(SIMPLE_PARAMETER_BINDING);
		createEReference(simpleParameterBindingEClass, SIMPLE_PARAMETER_BINDING__VALUE);
		createEAttribute(simpleParameterBindingEClass, SIMPLE_PARAMETER_BINDING__IS_CHECK);

		statementEClass = createEClass(STATEMENT);

		variableStatementEClass = createEClass(VARIABLE_STATEMENT);
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

		// Obtain other dependent packages
		PivotPackage thePivotPackage = (PivotPackage)EPackage.Registry.INSTANCE.getEPackage(PivotPackage.eNS_URI);
		QVTbasePackage theQVTbasePackage = (QVTbasePackage)EPackage.Registry.INSTANCE.getEPackage(QVTbasePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		addStatementEClass.getESuperTypes().add(this.getMappingStatement());
		addStatementEClass.getESuperTypes().add(this.getObservableStatement());
		appendParameterEClass.getESuperTypes().add(this.getConnectionVariable());
		appendParameterEClass.getESuperTypes().add(this.getMappingParameter());
		appendParameterBindingEClass.getESuperTypes().add(this.getMappingParameterBinding());
		bufferStatementEClass.getESuperTypes().add(this.getConnectionVariable());
		bufferStatementEClass.getESuperTypes().add(this.getVariableStatement());
		bufferStatementEClass.getESuperTypes().add(this.getObservableStatement());
		checkStatementEClass.getESuperTypes().add(this.getObservableStatement());
		connectionVariableEClass.getESuperTypes().add(thePivotPackage.getVariableDeclaration());
		declareStatementEClass.getESuperTypes().add(this.getVariableStatement());
		declareStatementEClass.getESuperTypes().add(this.getObservableStatement());
		guardParameterEClass.getESuperTypes().add(this.getMappingParameter());
		guardParameterBindingEClass.getESuperTypes().add(this.getMappingParameterBinding());
		imperativeModelEClass.getESuperTypes().add(theQVTbasePackage.getBaseModel());
		imperativeTransformationEClass.getESuperTypes().add(theQVTbasePackage.getTransformation());
		imperativeTypedModelEClass.getESuperTypes().add(theQVTbasePackage.getTypedModel());
		loopParameterBindingEClass.getESuperTypes().add(this.getMappingParameterBinding());
		loopVariableEClass.getESuperTypes().add(thePivotPackage.getVariableDeclaration());
		mappingEClass.getESuperTypes().add(theQVTbasePackage.getRule());
		mappingCallEClass.getESuperTypes().add(this.getMappingStatement());
		mappingCallEClass.getESuperTypes().add(thePivotPackage.getReferringElement());
		mappingLoopEClass.getESuperTypes().add(this.getMappingStatement());
		mappingLoopEClass.getESuperTypes().add(this.getObservableStatement());
		mappingParameterEClass.getESuperTypes().add(thePivotPackage.getVariableDeclaration());
		mappingParameterBindingEClass.getESuperTypes().add(thePivotPackage.getElement());
		mappingStatementEClass.getESuperTypes().add(this.getStatement());
		newStatementEClass.getESuperTypes().add(this.getVariableStatement());
		newStatementEClass.getESuperTypes().add(this.getObservableStatement());
		observableStatementEClass.getESuperTypes().add(this.getStatement());
		setStatementEClass.getESuperTypes().add(this.getObservableStatement());
		simpleParameterEClass.getESuperTypes().add(this.getMappingParameter());
		simpleParameterBindingEClass.getESuperTypes().add(this.getMappingParameterBinding());
		statementEClass.getESuperTypes().add(thePivotPackage.getNamedElement());
		variableStatementEClass.getESuperTypes().add(thePivotPackage.getVariableDeclaration());
		variableStatementEClass.getESuperTypes().add(this.getStatement());

		// Initialize classes, features, and operations; add parameters
		initEClass(addStatementEClass, AddStatement.class, "AddStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAddStatement_TargetVariable(), this.getConnectionVariable(), null, "targetVariable", null, 1, 1, AddStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAddStatement_IsEnforcedUnique(), ecorePackage.getEBoolean(), "isEnforcedUnique", null, 0, 1, AddStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAddStatement_OwnedExpression(), thePivotPackage.getOCLExpression(), null, "ownedExpression", null, 1, 1, AddStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(appendParameterEClass, AppendParameter.class, "AppendParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(appendParameterBindingEClass, AppendParameterBinding.class, "AppendParameterBinding", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAppendParameterBinding_Value(), this.getConnectionVariable(), null, "value", null, 1, 1, AppendParameterBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(bufferStatementEClass, BufferStatement.class, "BufferStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBufferStatement_OwnedExpression(), thePivotPackage.getOCLExpression(), null, "ownedExpression", null, 0, 1, BufferStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(checkStatementEClass, CheckStatement.class, "CheckStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCheckStatement_OwnedExpression(), thePivotPackage.getOCLExpression(), null, "ownedExpression", null, 1, 1, CheckStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(connectionVariableEClass, ConnectionVariable.class, "ConnectionVariable", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getConnectionVariable_IsStrict(), ecorePackage.getEBoolean(), "isStrict", "false", 0, 1, ConnectionVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(declareStatementEClass, DeclareStatement.class, "DeclareStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDeclareStatement_IsCheck(), ecorePackage.getEBoolean(), "isCheck", "false", 0, 1, DeclareStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDeclareStatement_OwnedExpression(), thePivotPackage.getOCLExpression(), null, "ownedExpression", null, 1, 1, DeclareStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(guardParameterEClass, GuardParameter.class, "GuardParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGuardParameter_ReferredTypedModel(), this.getImperativeTypedModel(), null, "referredTypedModel", null, 1, 1, GuardParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(guardParameterBindingEClass, GuardParameterBinding.class, "GuardParameterBinding", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGuardParameterBinding_Value(), this.getConnectionVariable(), null, "value", null, 1, 1, GuardParameterBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGuardParameterBinding_IsCheck(), ecorePackage.getEBoolean(), "isCheck", "false", 0, 1, GuardParameterBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(imperativeModelEClass, ImperativeModel.class, "ImperativeModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(imperativeTransformationEClass, ImperativeTransformation.class, "ImperativeTransformation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(imperativeTypedModelEClass, ImperativeTypedModel.class, "ImperativeTypedModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getImperativeTypedModel_IsChecked(), ecorePackage.getEBoolean(), "isChecked", "false", 0, 1, ImperativeTypedModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getImperativeTypedModel_IsEnforced(), ecorePackage.getEBoolean(), "isEnforced", "false", 0, 1, ImperativeTypedModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(loopParameterBindingEClass, LoopParameterBinding.class, "LoopParameterBinding", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLoopParameterBinding_Value(), this.getLoopVariable(), null, "value", null, 1, 1, LoopParameterBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLoopParameterBinding_IsCheck(), ecorePackage.getEBoolean(), "isCheck", "false", 0, 1, LoopParameterBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(loopVariableEClass, LoopVariable.class, "LoopVariable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLoopVariable_OwningMappingLoop(), this.getMappingLoop(), this.getMappingLoop_OwnedIterators(), "owningMappingLoop", null, 1, 1, LoopVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mappingEClass, Mapping.class, "Mapping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMapping_IsStrict(), ecorePackage.getEBoolean(), "isStrict", "false", 0, 1, Mapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMapping_OwnedParameters(), this.getMappingParameter(), null, "ownedParameters", null, 0, -1, Mapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getMapping_OwnedStatements(), this.getStatement(), null, "ownedStatements", null, 0, -1, Mapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = initEOperation(getMapping__ValidateisTrue__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateisTrue", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		EGenericType g1 = createEGenericType(ecorePackage.getEMap());
		EGenericType g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(mappingCallEClass, MappingCall.class, "MappingCall", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMappingCall_Binding(), this.getMappingParameterBinding(), this.getMappingParameterBinding_MappingCall(), "binding", null, 0, -1, MappingCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMappingCall_IsInstall(), ecorePackage.getEBoolean(), "isInstall", "false", 0, 1, MappingCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMappingCall_IsInvoke(), ecorePackage.getEBoolean(), "isInvoke", "false", 0, 1, MappingCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappingCall_ReferredMapping(), this.getMapping(), null, "referredMapping", null, 1, 1, MappingCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mappingLoopEClass, MappingLoop.class, "MappingLoop", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMappingLoop_OwnedIterators(), this.getLoopVariable(), this.getLoopVariable_OwningMappingLoop(), "ownedIterators", null, 0, -1, MappingLoop.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappingLoop_OwnedMappingStatements(), this.getMappingStatement(), null, "ownedMappingStatements", null, 0, -1, MappingLoop.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappingLoop_OwnedExpression(), thePivotPackage.getOCLExpression(), null, "ownedExpression", null, 1, 1, MappingLoop.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mappingParameterEClass, MappingParameter.class, "MappingParameter", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(mappingParameterBindingEClass, MappingParameterBinding.class, "MappingParameterBinding", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMappingParameterBinding_MappingCall(), this.getMappingCall(), this.getMappingCall_Binding(), "mappingCall", null, 0, 1, MappingParameterBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappingParameterBinding_BoundVariable(), this.getMappingParameter(), null, "boundVariable", null, 1, 1, MappingParameterBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mappingStatementEClass, MappingStatement.class, "MappingStatement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(newStatementEClass, NewStatement.class, "NewStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNewStatement_ReferredTypedModel(), this.getImperativeTypedModel(), null, "referredTypedModel", null, 1, 1, NewStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNewStatement_OwnedExpression(), thePivotPackage.getOCLExpression(), null, "ownedExpression", null, 0, 1, NewStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(observableStatementEClass, ObservableStatement.class, "ObservableStatement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getObservableStatement_ObservedProperties(), thePivotPackage.getProperty(), null, "observedProperties", null, 0, -1, ObservableStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(setStatementEClass, SetStatement.class, "SetStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSetStatement_TargetVariable(), thePivotPackage.getVariableDeclaration(), null, "targetVariable", null, 1, 1, SetStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSetStatement_TargetProperty(), thePivotPackage.getProperty(), null, "targetProperty", null, 1, 1, SetStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSetStatement_IsOpposite(), ecorePackage.getEBoolean(), "isOpposite", null, 0, 1, SetStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSetStatement_IsNotify(), ecorePackage.getEBoolean(), "isNotify", null, 0, 1, SetStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSetStatement_OwnedExpression(), thePivotPackage.getOCLExpression(), null, "ownedExpression", null, 1, 1, SetStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(simpleParameterEClass, SimpleParameter.class, "SimpleParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSimpleParameter_ReferredTypedModel(), this.getImperativeTypedModel(), null, "referredTypedModel", null, 1, 1, SimpleParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(simpleParameterBindingEClass, SimpleParameterBinding.class, "SimpleParameterBinding", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSimpleParameterBinding_Value(), thePivotPackage.getOCLExpression(), null, "value", null, 1, 1, SimpleParameterBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSimpleParameterBinding_IsCheck(), ecorePackage.getEBoolean(), "isCheck", "false", 0, 1, SimpleParameterBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(statementEClass, Statement.class, "Statement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(variableStatementEClass, VariableStatement.class, "VariableStatement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/emf/2002/Ecore
		createEcoreAnnotations();
		// http://www.eclipse.org/uml2/2.0.0/UML
		createUMLAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/Ecore</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createEcoreAnnotations() {
		String source = "http://www.eclipse.org/emf/2002/Ecore";
		addAnnotation
		(this,
			source,
			new String[] {
		});
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/uml2/2.0.0/UML</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createUMLAnnotations() {
		String source = "http://www.eclipse.org/uml2/2.0.0/UML";
		addAnnotation
		(getMapping__ValidateisTrue__DiagnosticChain_Map(),
			source,
			new String[] {
				"originalName", "isTrue"
		});
	}

} //QVTimperativePackageImpl
