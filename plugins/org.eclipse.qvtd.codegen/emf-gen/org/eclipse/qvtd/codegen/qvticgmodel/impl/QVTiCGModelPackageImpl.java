/*******************************************************************************
 * Copyright (c) 2013, 2020 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.codegen.qvticgmodel.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.ocl.examples.codegen.cgmodel.CGEcoreContainerAssignment;
import org.eclipse.ocl.examples.codegen.cgmodel.CGEcorePropertyAssignment;
import org.eclipse.ocl.examples.codegen.cgmodel.CGModelPackage;
import org.eclipse.ocl.examples.codegen.cgmodel.CGPropertyAssignment;
import org.eclipse.ocl.examples.codegen.cgmodel.CGSequence;
import org.eclipse.ocl.examples.codegen.cgmodel.impl.CGClassImpl;
import org.eclipse.ocl.examples.codegen.cgmodel.impl.CGNamedElementImpl;
import org.eclipse.ocl.examples.codegen.cgmodel.impl.CGOperationCallExpImpl;
import org.eclipse.ocl.examples.codegen.cgmodel.impl.CGParameterImpl;
import org.eclipse.ocl.examples.codegen.cgmodel.impl.CGValuedElementImpl;
import org.eclipse.ocl.examples.codegen.cgmodel.impl.CGVariableImpl;
import org.eclipse.qvtd.codegen.qvticgmodel.CGConnectionAssignment;
import org.eclipse.qvtd.codegen.qvticgmodel.CGConnectionVariable;
import org.eclipse.qvtd.codegen.qvticgmodel.CGEcoreRealizedVariable;
import org.eclipse.qvtd.codegen.qvticgmodel.CGFunction;
import org.eclipse.qvtd.codegen.qvticgmodel.CGFunctionCallExp;
import org.eclipse.qvtd.codegen.qvticgmodel.CGFunctionParameter;
import org.eclipse.qvtd.codegen.qvticgmodel.CGGuardVariable;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMapping;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMappingCall;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMappingCallBinding;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMappingExp;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMappingLoop;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMiddlePropertyAssignment;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMiddlePropertyCallExp;
import org.eclipse.qvtd.codegen.qvticgmodel.CGRealizedVariable;
import org.eclipse.qvtd.codegen.qvticgmodel.CGRealizedVariablePart;
import org.eclipse.qvtd.codegen.qvticgmodel.CGSpeculateExp;
import org.eclipse.qvtd.codegen.qvticgmodel.CGSpeculatePart;
import org.eclipse.qvtd.codegen.qvticgmodel.CGTransformation;
import org.eclipse.qvtd.codegen.qvticgmodel.CGTypedModel;
import org.eclipse.qvtd.codegen.qvticgmodel.QVTiCGModelFactory;
import org.eclipse.qvtd.codegen.qvticgmodel.QVTiCGModelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class QVTiCGModelPackageImpl extends EPackageImpl implements QVTiCGModelPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgConnectionAssignmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgConnectionVariableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgEcoreRealizedVariableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgFunctionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgFunctionCallExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgFunctionParameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgGuardVariableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgMappingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgMappingCallEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgMappingCallBindingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgMappingExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgMappingLoopEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgMiddlePropertyAssignmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgMiddlePropertyCallExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgRealizedVariableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgRealizedVariablePartEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgSpeculateExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgSpeculatePartEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgTransformationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgTypedModelEClass = null;

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
	 * @see org.eclipse.qvtd.codegen.qvticgmodel.QVTiCGModelPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private QVTiCGModelPackageImpl() {
		super(eNS_URI, QVTiCGModelFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link QVTiCGModelPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static QVTiCGModelPackage init() {
		if (isInited) return (QVTiCGModelPackage)EPackage.Registry.INSTANCE.getEPackage(QVTiCGModelPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredQVTiCGModelPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		QVTiCGModelPackageImpl theQVTiCGModelPackage = registeredQVTiCGModelPackage instanceof QVTiCGModelPackageImpl ? (QVTiCGModelPackageImpl)registeredQVTiCGModelPackage : new QVTiCGModelPackageImpl();

		isInited = true;

		// Initialize simple dependencies
		CGModelPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theQVTiCGModelPackage.createPackageContents();

		// Initialize created meta-data
		theQVTiCGModelPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theQVTiCGModelPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(QVTiCGModelPackage.eNS_URI, theQVTiCGModelPackage);
		return theQVTiCGModelPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCGConnectionAssignment() {
		return cgConnectionAssignmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCGConnectionAssignment_OwningMapping() {
		return (EReference)cgConnectionAssignmentEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCGConnectionAssignment_ConnectionVariable() {
		return (EReference)cgConnectionAssignmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCGConnectionAssignment_OwnedInitValue() {
		return (EReference)cgConnectionAssignmentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCGConnectionVariable() {
		return cgConnectionVariableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCGEcoreRealizedVariable() {
		return cgEcoreRealizedVariableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCGEcoreRealizedVariable_EClassifier() {
		return (EReference)cgEcoreRealizedVariableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCGFunction() {
		return cgFunctionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCGFunctionCallExp() {
		return cgFunctionCallExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCGFunctionCallExp_Function() {
		return (EReference)cgFunctionCallExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCGFunctionParameter() {
		return cgFunctionParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCGFunctionParameter_Function() {
		return (EReference)cgFunctionParameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCGGuardVariable() {
		return cgGuardVariableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCGGuardVariable_OwningMapping() {
		return (EReference)cgGuardVariableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCGGuardVariable_TypedModel() {
		return (EReference)cgGuardVariableEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCGMapping() {
		return cgMappingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCGMapping_OwnedBody() {
		return (EReference)cgMappingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCGMapping_OwnedConnectionAssignments() {
		return (EReference)cgMappingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCGMapping_OwnedGuardVariables() {
		return (EReference)cgMappingEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCGMapping_OwnedRealizedVariables() {
		return (EReference)cgMappingEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCGMapping_OwningTransformation() {
		return (EReference)cgMappingEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getCGMapping_UseClass() {
		return (EAttribute)cgMappingEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCGMappingCall() {
		return cgMappingCallEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCGMappingCall_OwnedMappingCallBindings() {
		return (EReference)cgMappingCallEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCGMappingCall_ReferredMapping() {
		return (EReference)cgMappingCallEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCGMappingCallBinding() {
		return cgMappingCallBindingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCGMappingCallBinding_OwnedValue() {
		return (EReference)cgMappingCallBindingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCGMappingCallBinding_OwningMappingCall() {
		return (EReference)cgMappingCallBindingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCGMappingExp() {
		return cgMappingExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCGMappingExp_OwnedAccumulators() {
		return (EReference)cgMappingExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCGMappingExp_OwnedBody() {
		return (EReference)cgMappingExpEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCGMappingLoop() {
		return cgMappingLoopEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCGMiddlePropertyAssignment() {
		return cgMiddlePropertyAssignmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCGMiddlePropertyCallExp() {
		return cgMiddlePropertyCallExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCGRealizedVariable() {
		return cgRealizedVariableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCGRealizedVariable_TypedModel() {
		return (EReference)cgRealizedVariableEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCGRealizedVariable_OwnedParts() {
		return (EReference)cgRealizedVariableEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCGRealizedVariablePart() {
		return cgRealizedVariablePartEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCGRealizedVariablePart_OwningRealizedVariable() {
		return (EReference)cgRealizedVariablePartEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCGRealizedVariablePart_Init() {
		return (EReference)cgRealizedVariablePartEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCGRealizedVariablePart_ReferredProperty() {
		return (EReference)cgRealizedVariablePartEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCGSpeculateExp() {
		return cgSpeculateExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCGSpeculateExp_Parts() {
		return (EReference)cgSpeculateExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCGSpeculateExp_Speculated() {
		return (EReference)cgSpeculateExpEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCGSpeculatePart() {
		return cgSpeculatePartEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCGSpeculatePart_ObjectExp() {
		return (EReference)cgSpeculatePartEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCGSpeculatePart_EStructuralFeature() {
		return (EReference)cgSpeculatePartEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCGRealizedVariable_ExecutorType() {
		return (EReference)cgRealizedVariableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCGRealizedVariable_OwningMapping() {
		return (EReference)cgRealizedVariableEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCGTransformation() {
		return cgTransformationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCGTransformation_OwnedMappings() {
		return (EReference)cgTransformationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCGTransformation_OwnedTypedModels() {
		return (EReference)cgTransformationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCGTypedModel() {
		return cgTypedModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getCGTypedModel_ModelIndex() {
		return (EAttribute)cgTypedModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCGTypedModel_OwningTransformation() {
		return (EReference)cgTypedModelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public QVTiCGModelFactory getQVTiCGModelFactory() {
		return (QVTiCGModelFactory)getEFactoryInstance();
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
		cgConnectionAssignmentEClass = createEClass(0);
		createEReference(cgConnectionAssignmentEClass, CGValuedElementImpl.CG_VALUED_ELEMENT_FEATURE_COUNT + 0);
		createEReference(cgConnectionAssignmentEClass, CGValuedElementImpl.CG_VALUED_ELEMENT_FEATURE_COUNT + 1);
		createEReference(cgConnectionAssignmentEClass, CGValuedElementImpl.CG_VALUED_ELEMENT_FEATURE_COUNT + 2);

		cgConnectionVariableEClass = createEClass(1);

		cgEcoreRealizedVariableEClass = createEClass(2);
		createEReference(cgEcoreRealizedVariableEClass, CGVariableImpl.CG_VARIABLE_FEATURE_COUNT + 4);

		cgFunctionEClass = createEClass(3);

		cgFunctionCallExpEClass = createEClass(4);
		createEReference(cgFunctionCallExpEClass, CGOperationCallExpImpl.CG_OPERATION_CALL_EXP_FEATURE_COUNT + 0);

		cgFunctionParameterEClass = createEClass(5);
		createEReference(cgFunctionParameterEClass, CGParameterImpl.CG_PARAMETER_FEATURE_COUNT + 0);

		cgGuardVariableEClass = createEClass(6);
		createEReference(cgGuardVariableEClass, CGParameterImpl.CG_PARAMETER_FEATURE_COUNT + 0);
		createEReference(cgGuardVariableEClass, CGParameterImpl.CG_PARAMETER_FEATURE_COUNT + 1);

		cgMappingEClass = createEClass(7);
		createEReference(cgMappingEClass, CGValuedElementImpl.CG_VALUED_ELEMENT_FEATURE_COUNT + 0);
		createEReference(cgMappingEClass, CGValuedElementImpl.CG_VALUED_ELEMENT_FEATURE_COUNT + 1);
		createEReference(cgMappingEClass, CGValuedElementImpl.CG_VALUED_ELEMENT_FEATURE_COUNT + 2);
		createEReference(cgMappingEClass, CGValuedElementImpl.CG_VALUED_ELEMENT_FEATURE_COUNT + 3);
		createEReference(cgMappingEClass, CGValuedElementImpl.CG_VALUED_ELEMENT_FEATURE_COUNT + 4);
		createEAttribute(cgMappingEClass, CGValuedElementImpl.CG_VALUED_ELEMENT_FEATURE_COUNT + 5);

		cgMappingCallEClass = createEClass(8);
		createEReference(cgMappingCallEClass, CGValuedElementImpl.CG_VALUED_ELEMENT_FEATURE_COUNT + 0);
		createEReference(cgMappingCallEClass, CGValuedElementImpl.CG_VALUED_ELEMENT_FEATURE_COUNT + 1);

		cgMappingCallBindingEClass = createEClass(9);
		createEReference(cgMappingCallBindingEClass, CGValuedElementImpl.CG_VALUED_ELEMENT_FEATURE_COUNT + 0);
		createEReference(cgMappingCallBindingEClass, CGValuedElementImpl.CG_VALUED_ELEMENT_FEATURE_COUNT + 1);

		cgMappingExpEClass = createEClass(10);
		createEReference(cgMappingExpEClass, CGValuedElementImpl.CG_VALUED_ELEMENT_FEATURE_COUNT + 0);
		createEReference(cgMappingExpEClass, CGValuedElementImpl.CG_VALUED_ELEMENT_FEATURE_COUNT + 1);

		cgMappingLoopEClass = createEClass(11);

		cgMiddlePropertyAssignmentEClass = createEClass(12);

		cgMiddlePropertyCallExpEClass = createEClass(13);

		cgRealizedVariableEClass = createEClass(14);
		createEReference(cgRealizedVariableEClass, CGVariableImpl.CG_VARIABLE_FEATURE_COUNT + 0);
		createEReference(cgRealizedVariableEClass, CGVariableImpl.CG_VARIABLE_FEATURE_COUNT + 1);
		createEReference(cgRealizedVariableEClass, CGVariableImpl.CG_VARIABLE_FEATURE_COUNT + 2);
		createEReference(cgRealizedVariableEClass, CGVariableImpl.CG_VARIABLE_FEATURE_COUNT + 3);

		cgRealizedVariablePartEClass = createEClass(15);
		createEReference(cgRealizedVariablePartEClass, CGValuedElementImpl.CG_VALUED_ELEMENT_FEATURE_COUNT + 0);
		createEReference(cgRealizedVariablePartEClass, CGValuedElementImpl.CG_VALUED_ELEMENT_FEATURE_COUNT + 1);
		createEReference(cgRealizedVariablePartEClass, CGValuedElementImpl.CG_VALUED_ELEMENT_FEATURE_COUNT + 2);

		cgSpeculateExpEClass = createEClass(16);
		createEReference(cgSpeculateExpEClass, CGValuedElementImpl.CG_VALUED_ELEMENT_FEATURE_COUNT + 0);
		createEReference(cgSpeculateExpEClass, CGValuedElementImpl.CG_VALUED_ELEMENT_FEATURE_COUNT + 1);

		cgSpeculatePartEClass = createEClass(17);
		createEReference(cgSpeculatePartEClass, CGValuedElementImpl.CG_VALUED_ELEMENT_FEATURE_COUNT + 0);
		createEReference(cgSpeculatePartEClass, CGValuedElementImpl.CG_VALUED_ELEMENT_FEATURE_COUNT + 1);

		cgTransformationEClass = createEClass(18);
		createEReference(cgTransformationEClass, CGClassImpl.CG_CLASS_FEATURE_COUNT + 0);
		createEReference(cgTransformationEClass, CGClassImpl.CG_CLASS_FEATURE_COUNT + 1);

		cgTypedModelEClass = createEClass(19);
		createEAttribute(cgTypedModelEClass, CGValuedElementImpl.CG_VALUED_ELEMENT_FEATURE_COUNT + 0);
		createEReference(cgTypedModelEClass, CGValuedElementImpl.CG_VALUED_ELEMENT_FEATURE_COUNT + 1);
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
		CGModelPackage theCGModelPackage = (CGModelPackage)EPackage.Registry.INSTANCE.getEPackage(CGModelPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		cgConnectionAssignmentEClass.getESuperTypes().add(theCGModelPackage.getCGValuedElement());
		cgConnectionVariableEClass.getESuperTypes().add(this.getCGGuardVariable());
		cgEcoreRealizedVariableEClass.getESuperTypes().add(this.getCGRealizedVariable());
		cgFunctionEClass.getESuperTypes().add(theCGModelPackage.getCGOperation());
		cgFunctionCallExpEClass.getESuperTypes().add(theCGModelPackage.getCGOperationCallExp());
		cgFunctionParameterEClass.getESuperTypes().add(theCGModelPackage.getCGParameter());
		cgGuardVariableEClass.getESuperTypes().add(theCGModelPackage.getCGParameter());
		cgMappingEClass.getESuperTypes().add(theCGModelPackage.getCGValuedElement());
		cgMappingCallEClass.getESuperTypes().add(theCGModelPackage.getCGValuedElement());
		cgMappingCallBindingEClass.getESuperTypes().add(theCGModelPackage.getCGValuedElement());
		cgMappingExpEClass.getESuperTypes().add(theCGModelPackage.getCGValuedElement());
		cgMappingLoopEClass.getESuperTypes().add(theCGModelPackage.getCGIterationCallExp());
		cgMiddlePropertyAssignmentEClass.getESuperTypes().add(theCGModelPackage.getCGEcorePropertyAssignment());
		cgMiddlePropertyCallExpEClass.getESuperTypes().add(theCGModelPackage.getCGOppositePropertyCallExp());
		cgRealizedVariableEClass.getESuperTypes().add(theCGModelPackage.getCGVariable());
		cgRealizedVariablePartEClass.getESuperTypes().add(theCGModelPackage.getCGValuedElement());
		cgSpeculateExpEClass.getESuperTypes().add(theCGModelPackage.getCGValuedElement());
		cgSpeculatePartEClass.getESuperTypes().add(theCGModelPackage.getCGValuedElement());
		cgTransformationEClass.getESuperTypes().add(theCGModelPackage.getCGClass());
		cgTypedModelEClass.getESuperTypes().add(theCGModelPackage.getCGValuedElement());

		// Initialize classes and features; add operations and parameters
		initEClass(cgConnectionAssignmentEClass, CGConnectionAssignment.class, "CGConnectionAssignment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCGConnectionAssignment_ConnectionVariable(), theCGModelPackage.getCGVariable(), null, "connectionVariable", null, 1, 1, CGConnectionAssignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCGConnectionAssignment_OwnedInitValue(), theCGModelPackage.getCGValuedElement(), null, "ownedInitValue", null, 1, 1, CGConnectionAssignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCGConnectionAssignment_OwningMapping(), this.getCGMapping(), this.getCGMapping_OwnedConnectionAssignments(), "owningMapping", null, 1, 1, CGConnectionAssignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cgConnectionVariableEClass, CGConnectionVariable.class, "CGConnectionVariable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(cgEcoreRealizedVariableEClass, CGEcoreRealizedVariable.class, "CGEcoreRealizedVariable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCGEcoreRealizedVariable_EClassifier(), ecorePackage.getEClassifier(), null, "eClassifier", null, 1, 1, CGEcoreRealizedVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cgFunctionEClass, CGFunction.class, "CGFunction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(cgFunctionCallExpEClass, CGFunctionCallExp.class, "CGFunctionCallExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCGFunctionCallExp_Function(), this.getCGFunction(), null, "function", null, 1, 1, CGFunctionCallExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cgFunctionParameterEClass, CGFunctionParameter.class, "CGFunctionParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCGFunctionParameter_Function(), this.getCGFunction(), null, "function", null, 1, 1, CGFunctionParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cgGuardVariableEClass, CGGuardVariable.class, "CGGuardVariable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCGGuardVariable_OwningMapping(), this.getCGMapping(), this.getCGMapping_OwnedGuardVariables(), "owningMapping", null, 1, 1, CGGuardVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCGGuardVariable_TypedModel(), this.getCGTypedModel(), null, "typedModel", null, 1, 1, CGGuardVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cgMappingEClass, CGMapping.class, "CGMapping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCGMapping_OwnedBody(), theCGModelPackage.getCGValuedElement(), null, "ownedBody", null, 1, 1, CGMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCGMapping_OwnedConnectionAssignments(), this.getCGConnectionAssignment(), this.getCGConnectionAssignment_OwningMapping(), "ownedConnectionAssignments", null, 0, -1, CGMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCGMapping_OwnedGuardVariables(), this.getCGGuardVariable(), this.getCGGuardVariable_OwningMapping(), "ownedGuardVariables", null, 0, -1, CGMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getCGMapping_OwnedRealizedVariables(), this.getCGRealizedVariable(), this.getCGRealizedVariable_OwningMapping(), "ownedRealizedVariables", null, 0, -1, CGMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCGMapping_OwningTransformation(), this.getCGTransformation(), this.getCGTransformation_OwnedMappings(), "owningTransformation", null, 1, 1, CGMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCGMapping_UseClass(), ecorePackage.getEBoolean(), "useClass", "false", 0, 1, CGMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cgMappingCallEClass, CGMappingCall.class, "CGMappingCall", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCGMappingCall_OwnedMappingCallBindings(), this.getCGMappingCallBinding(), this.getCGMappingCallBinding_OwningMappingCall(), "ownedMappingCallBindings", null, 0, -1, CGMappingCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCGMappingCall_ReferredMapping(), this.getCGMapping(), null, "referredMapping", null, 1, 1, CGMappingCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cgMappingCallBindingEClass, CGMappingCallBinding.class, "CGMappingCallBinding", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCGMappingCallBinding_OwnedValue(), theCGModelPackage.getCGValuedElement(), null, "ownedValue", null, 1, 1, CGMappingCallBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCGMappingCallBinding_OwningMappingCall(), this.getCGMappingCall(), this.getCGMappingCall_OwnedMappingCallBindings(), "owningMappingCall", null, 1, 1, CGMappingCallBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cgMappingExpEClass, CGMappingExp.class, "CGMappingExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCGMappingExp_OwnedAccumulators(), theCGModelPackage.getCGAccumulator(), null, "ownedAccumulators", null, 0, -1, CGMappingExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCGMappingExp_OwnedBody(), theCGModelPackage.getCGValuedElement(), null, "ownedBody", null, 0, 1, CGMappingExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cgMappingLoopEClass, CGMappingLoop.class, "CGMappingLoop", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(cgMiddlePropertyAssignmentEClass, CGMiddlePropertyAssignment.class, "CGMiddlePropertyAssignment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(cgMiddlePropertyCallExpEClass, CGMiddlePropertyCallExp.class, "CGMiddlePropertyCallExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(cgRealizedVariableEClass, CGRealizedVariable.class, "CGRealizedVariable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCGRealizedVariable_ExecutorType(), theCGModelPackage.getCGExecutorType(), null, "executorType", null, 1, 1, CGRealizedVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCGRealizedVariable_OwningMapping(), this.getCGMapping(), this.getCGMapping_OwnedRealizedVariables(), "owningMapping", null, 1, 1, CGRealizedVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCGRealizedVariable_TypedModel(), this.getCGTypedModel(), null, "typedModel", null, 1, 1, CGRealizedVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCGRealizedVariable_OwnedParts(), this.getCGRealizedVariablePart(), this.getCGRealizedVariablePart_OwningRealizedVariable(), "ownedParts", null, 0, -1, CGRealizedVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cgRealizedVariablePartEClass, CGRealizedVariablePart.class, "CGRealizedVariablePart", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCGRealizedVariablePart_OwningRealizedVariable(), this.getCGRealizedVariable(), this.getCGRealizedVariable_OwnedParts(), "owningRealizedVariable", null, 1, 1, CGRealizedVariablePart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCGRealizedVariablePart_Init(), theCGModelPackage.getCGValuedElement(), null, "init", null, 1, 1, CGRealizedVariablePart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCGRealizedVariablePart_ReferredProperty(), theCGModelPackage.getCGProperty(), null, "referredProperty", null, 1, 1, CGRealizedVariablePart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cgSpeculateExpEClass, CGSpeculateExp.class, "CGSpeculateExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCGSpeculateExp_Parts(), this.getCGSpeculatePart(), null, "parts", null, 1, -1, CGSpeculateExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCGSpeculateExp_Speculated(), theCGModelPackage.getCGValuedElement(), null, "speculated", null, 1, 1, CGSpeculateExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cgSpeculatePartEClass, CGSpeculatePart.class, "CGSpeculatePart", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCGSpeculatePart_ObjectExp(), theCGModelPackage.getCGValuedElement(), null, "objectExp", null, 1, 1, CGSpeculatePart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCGSpeculatePart_EStructuralFeature(), ecorePackage.getEStructuralFeature(), null, "eStructuralFeature", null, 1, 1, CGSpeculatePart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cgTransformationEClass, CGTransformation.class, "CGTransformation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCGTransformation_OwnedMappings(), this.getCGMapping(), this.getCGMapping_OwningTransformation(), "ownedMappings", null, 1, -1, CGTransformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCGTransformation_OwnedTypedModels(), this.getCGTypedModel(), this.getCGTypedModel_OwningTransformation(), "ownedTypedModels", null, 0, -1, CGTransformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cgTypedModelEClass, CGTypedModel.class, "CGTypedModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCGTypedModel_ModelIndex(), ecorePackage.getEInt(), "modelIndex", null, 0, 1, CGTypedModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCGTypedModel_OwningTransformation(), this.getCGTransformation(), this.getCGTransformation_OwnedTypedModels(), "owningTransformation", null, 1, 1, CGTypedModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/OCL/Import
		createImportAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/OCL/Import</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createImportAnnotations() {
		String source = "http://www.eclipse.org/OCL/Import";
		addAnnotation
		  (this,
		   source,
		   new String[] {
			   "ecore", "http://www.eclipse.org/emf/2002/Ecore"
		   });
	}

} //QVTiCGModelPackageImpl
