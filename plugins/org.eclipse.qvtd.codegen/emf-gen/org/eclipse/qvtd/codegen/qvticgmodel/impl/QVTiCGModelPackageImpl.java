/*******************************************************************************
 * Copyright (c) 2013, 2014 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
import org.eclipse.ocl.examples.codegen.cgmodel.CGModelPackage;
import org.eclipse.qvtd.codegen.qvticgmodel.CGEcorePropertyAssignment;
import org.eclipse.qvtd.codegen.qvticgmodel.CGEcoreRealizedVariable;
import org.eclipse.qvtd.codegen.qvticgmodel.CGFunction;
import org.eclipse.qvtd.codegen.qvticgmodel.CGFunctionCallExp;
import org.eclipse.qvtd.codegen.qvticgmodel.CGFunctionParameter;
import org.eclipse.qvtd.codegen.qvticgmodel.CGGuardVariable;
import org.eclipse.qvtd.codegen.qvticgmodel.CGConnectionAssignment;
import org.eclipse.qvtd.codegen.qvticgmodel.CGConnectionVariable;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMapping;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMappingCall;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMappingCallBinding;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMappingExp;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMappingLoop;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMiddlePropertyAssignment;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMiddlePropertyCallExp;
import org.eclipse.qvtd.codegen.qvticgmodel.CGPredicate;
import org.eclipse.qvtd.codegen.qvticgmodel.CGPropertyAssignment;
import org.eclipse.qvtd.codegen.qvticgmodel.CGRealizedVariable;
import org.eclipse.qvtd.codegen.qvticgmodel.CGSequence;
import org.eclipse.qvtd.codegen.qvticgmodel.CGTransformation;
import org.eclipse.qvtd.codegen.qvticgmodel.CGTypedModel;
import org.eclipse.qvtd.codegen.qvticgmodel.CGVariablePredicate;
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
	private EClass cgEcorePropertyAssignmentEClass = null;

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
	private EClass cgPredicateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgPropertyAssignmentEClass = null;

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
	private EClass cgSequenceEClass = null;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cgVariablePredicateEClass = null;

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
		Object ePackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		QVTiCGModelPackageImpl theQVTiCGModelPackage = (QVTiCGModelPackageImpl)(ePackage instanceof QVTiCGModelPackageImpl ? ePackage : new QVTiCGModelPackageImpl());

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
	public EReference getCGConnectionAssignment_MappingExp() {
		return (EReference)cgConnectionAssignmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCGConnectionAssignment_InitValue() {
		return (EReference)cgConnectionAssignmentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCGConnectionAssignment_ConnectionVariable() {
		return (EReference)cgConnectionAssignmentEClass.getEStructuralFeatures().get(2);
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
	public EClass getCGEcorePropertyAssignment() {
		return cgEcorePropertyAssignmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCGEcorePropertyAssignment_EStructuralFeature() {
		return (EReference)cgEcorePropertyAssignmentEClass.getEStructuralFeatures().get(0);
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
	public EReference getCGGuardVariable_Mapping() {
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
	public EReference getCGMapping_Body() {
		return (EReference)cgMappingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCGMapping_FreeVariables() {
		return (EReference)cgMappingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCGMapping_Transformation() {
		return (EReference)cgMappingEClass.getEStructuralFeatures().get(2);
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
	public EReference getCGMappingCall_MappingCallBindings() {
		return (EReference)cgMappingCallEClass.getEStructuralFeatures().get(0);
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
	public EReference getCGMappingCallBinding_Value() {
		return (EReference)cgMappingCallBindingEClass.getEStructuralFeatures().get(0);
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
	public EReference getCGMappingExp_Assignments() {
		return (EReference)cgMappingExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCGMappingExp_Mapping() {
		return (EReference)cgMappingExpEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCGMappingExp_Predicates() {
		return (EReference)cgMappingExpEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCGMappingExp_RealizedVariables() {
		return (EReference)cgMappingExpEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCGMappingExp_Body() {
		return (EReference)cgMappingExpEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCGMappingExp_VariableAssignments() {
		return (EReference)cgMappingExpEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCGMappingExp_ConnectionAssignments() {
		return (EReference)cgMappingExpEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCGMappingExp_OwnedAccumulators() {
		return (EReference)cgMappingExpEClass.getEStructuralFeatures().get(7);
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
	public EClass getCGPredicate() {
		return cgPredicateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCGPredicate_ConditionExpression() {
		return (EReference)cgPredicateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCGPredicate_MappingExp() {
		return (EReference)cgPredicateEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCGPredicate_ThenExpression() {
		return (EReference)cgPredicateEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCGPropertyAssignment() {
		return cgPropertyAssignmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCGPropertyAssignment_MappingExp() {
		return (EReference)cgPropertyAssignmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCGPropertyAssignment_SlotValue() {
		return (EReference)cgPropertyAssignmentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getCGPropertyAssignment_ReferredProperty() {
		return (EAttribute)cgPropertyAssignmentEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCGPropertyAssignment_InitValue() {
		return (EReference)cgPropertyAssignmentEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCGPropertyAssignment_ExecutorProperty() {
		return (EReference)cgPropertyAssignmentEClass.getEStructuralFeatures().get(4);
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
		return (EReference)cgRealizedVariableEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCGSequence() {
		return cgSequenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCGSequence_Statements() {
		return (EReference)cgSequenceEClass.getEStructuralFeatures().get(0);
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
	public EClass getCGTransformation() {
		return cgTransformationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCGTransformation_Mappings() {
		return (EReference)cgTransformationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCGTransformation_TypedModels() {
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
	public EReference getCGTypedModel_Transformation() {
		return (EReference)cgTypedModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getCGTypedModel_ModelIndex() {
		return (EAttribute)cgTypedModelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCGVariablePredicate() {
		return cgVariablePredicateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCGVariablePredicate_PredicateVariable() {
		return (EReference)cgVariablePredicateEClass.getEStructuralFeatures().get(0);
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
		cgConnectionAssignmentEClass = createEClass(CG_CONNECTION_ASSIGNMENT);
		createEReference(cgConnectionAssignmentEClass, CG_CONNECTION_ASSIGNMENT__MAPPING_EXP);
		createEReference(cgConnectionAssignmentEClass, CG_CONNECTION_ASSIGNMENT__INIT_VALUE);
		createEReference(cgConnectionAssignmentEClass, CG_CONNECTION_ASSIGNMENT__CONNECTION_VARIABLE);

		cgConnectionVariableEClass = createEClass(CG_CONNECTION_VARIABLE);

		cgEcorePropertyAssignmentEClass = createEClass(CG_ECORE_PROPERTY_ASSIGNMENT);
		createEReference(cgEcorePropertyAssignmentEClass, CG_ECORE_PROPERTY_ASSIGNMENT__ESTRUCTURAL_FEATURE);

		cgEcoreRealizedVariableEClass = createEClass(CG_ECORE_REALIZED_VARIABLE);
		createEReference(cgEcoreRealizedVariableEClass, CG_ECORE_REALIZED_VARIABLE__ECLASSIFIER);

		cgFunctionEClass = createEClass(CG_FUNCTION);

		cgFunctionCallExpEClass = createEClass(CG_FUNCTION_CALL_EXP);
		createEReference(cgFunctionCallExpEClass, CG_FUNCTION_CALL_EXP__FUNCTION);

		cgFunctionParameterEClass = createEClass(CG_FUNCTION_PARAMETER);
		createEReference(cgFunctionParameterEClass, CG_FUNCTION_PARAMETER__FUNCTION);

		cgGuardVariableEClass = createEClass(CG_GUARD_VARIABLE);
		createEReference(cgGuardVariableEClass, CG_GUARD_VARIABLE__MAPPING);
		createEReference(cgGuardVariableEClass, CG_GUARD_VARIABLE__TYPED_MODEL);

		cgMappingEClass = createEClass(CG_MAPPING);
		createEReference(cgMappingEClass, CG_MAPPING__BODY);
		createEReference(cgMappingEClass, CG_MAPPING__FREE_VARIABLES);
		createEReference(cgMappingEClass, CG_MAPPING__TRANSFORMATION);

		cgMappingCallEClass = createEClass(CG_MAPPING_CALL);
		createEReference(cgMappingCallEClass, CG_MAPPING_CALL__MAPPING_CALL_BINDINGS);

		cgMappingCallBindingEClass = createEClass(CG_MAPPING_CALL_BINDING);
		createEReference(cgMappingCallBindingEClass, CG_MAPPING_CALL_BINDING__VALUE);

		cgMappingExpEClass = createEClass(CG_MAPPING_EXP);
		createEReference(cgMappingExpEClass, CG_MAPPING_EXP__ASSIGNMENTS);
		createEReference(cgMappingExpEClass, CG_MAPPING_EXP__MAPPING);
		createEReference(cgMappingExpEClass, CG_MAPPING_EXP__PREDICATES);
		createEReference(cgMappingExpEClass, CG_MAPPING_EXP__REALIZED_VARIABLES);
		createEReference(cgMappingExpEClass, CG_MAPPING_EXP__BODY);
		createEReference(cgMappingExpEClass, CG_MAPPING_EXP__VARIABLE_ASSIGNMENTS);
		createEReference(cgMappingExpEClass, CG_MAPPING_EXP__CONNECTION_ASSIGNMENTS);
		createEReference(cgMappingExpEClass, CG_MAPPING_EXP__OWNED_ACCUMULATORS);

		cgMappingLoopEClass = createEClass(CG_MAPPING_LOOP);

		cgMiddlePropertyAssignmentEClass = createEClass(CG_MIDDLE_PROPERTY_ASSIGNMENT);

		cgMiddlePropertyCallExpEClass = createEClass(CG_MIDDLE_PROPERTY_CALL_EXP);

		cgPredicateEClass = createEClass(CG_PREDICATE);
		createEReference(cgPredicateEClass, CG_PREDICATE__CONDITION_EXPRESSION);
		createEReference(cgPredicateEClass, CG_PREDICATE__MAPPING_EXP);
		createEReference(cgPredicateEClass, CG_PREDICATE__THEN_EXPRESSION);

		cgPropertyAssignmentEClass = createEClass(CG_PROPERTY_ASSIGNMENT);
		createEReference(cgPropertyAssignmentEClass, CG_PROPERTY_ASSIGNMENT__MAPPING_EXP);
		createEReference(cgPropertyAssignmentEClass, CG_PROPERTY_ASSIGNMENT__SLOT_VALUE);
		createEAttribute(cgPropertyAssignmentEClass, CG_PROPERTY_ASSIGNMENT__REFERRED_PROPERTY);
		createEReference(cgPropertyAssignmentEClass, CG_PROPERTY_ASSIGNMENT__INIT_VALUE);
		createEReference(cgPropertyAssignmentEClass, CG_PROPERTY_ASSIGNMENT__EXECUTOR_PROPERTY);

		cgRealizedVariableEClass = createEClass(CG_REALIZED_VARIABLE);
		createEReference(cgRealizedVariableEClass, CG_REALIZED_VARIABLE__EXECUTOR_TYPE);
		createEReference(cgRealizedVariableEClass, CG_REALIZED_VARIABLE__TYPED_MODEL);

		cgSequenceEClass = createEClass(CG_SEQUENCE);
		createEReference(cgSequenceEClass, CG_SEQUENCE__STATEMENTS);

		cgTransformationEClass = createEClass(CG_TRANSFORMATION);
		createEReference(cgTransformationEClass, CG_TRANSFORMATION__MAPPINGS);
		createEReference(cgTransformationEClass, CG_TRANSFORMATION__TYPED_MODELS);

		cgTypedModelEClass = createEClass(CG_TYPED_MODEL);
		createEReference(cgTypedModelEClass, CG_TYPED_MODEL__TRANSFORMATION);
		createEAttribute(cgTypedModelEClass, CG_TYPED_MODEL__MODEL_INDEX);

		cgVariablePredicateEClass = createEClass(CG_VARIABLE_PREDICATE);
		createEReference(cgVariablePredicateEClass, CG_VARIABLE_PREDICATE__PREDICATE_VARIABLE);
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
		cgEcorePropertyAssignmentEClass.getESuperTypes().add(this.getCGPropertyAssignment());
		cgEcoreRealizedVariableEClass.getESuperTypes().add(this.getCGRealizedVariable());
		cgFunctionEClass.getESuperTypes().add(theCGModelPackage.getCGOperation());
		cgFunctionCallExpEClass.getESuperTypes().add(theCGModelPackage.getCGOperationCallExp());
		cgFunctionParameterEClass.getESuperTypes().add(theCGModelPackage.getCGParameter());
		cgGuardVariableEClass.getESuperTypes().add(theCGModelPackage.getCGParameter());
		cgMappingEClass.getESuperTypes().add(theCGModelPackage.getCGNamedElement());
		cgMappingCallEClass.getESuperTypes().add(theCGModelPackage.getCGValuedElement());
		cgMappingCallBindingEClass.getESuperTypes().add(theCGModelPackage.getCGValuedElement());
		cgMappingExpEClass.getESuperTypes().add(theCGModelPackage.getCGValuedElement());
		cgMappingLoopEClass.getESuperTypes().add(theCGModelPackage.getCGIterationCallExp());
		cgMiddlePropertyAssignmentEClass.getESuperTypes().add(this.getCGEcorePropertyAssignment());
		cgMiddlePropertyCallExpEClass.getESuperTypes().add(theCGModelPackage.getCGOppositePropertyCallExp());
		cgPredicateEClass.getESuperTypes().add(theCGModelPackage.getCGValuedElement());
		cgPropertyAssignmentEClass.getESuperTypes().add(theCGModelPackage.getCGValuedElement());
		cgRealizedVariableEClass.getESuperTypes().add(theCGModelPackage.getCGVariable());
		cgSequenceEClass.getESuperTypes().add(theCGModelPackage.getCGValuedElement());
		cgTransformationEClass.getESuperTypes().add(theCGModelPackage.getCGClass());
		cgTypedModelEClass.getESuperTypes().add(theCGModelPackage.getCGNamedElement());
		cgVariablePredicateEClass.getESuperTypes().add(this.getCGPredicate());

		// Initialize classes and features; add operations and parameters
		initEClass(cgConnectionAssignmentEClass, CGConnectionAssignment.class, "CGConnectionAssignment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCGConnectionAssignment_MappingExp(), this.getCGMappingExp(), this.getCGMappingExp_ConnectionAssignments(), "mappingExp", null, 1, 1, CGConnectionAssignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCGConnectionAssignment_InitValue(), theCGModelPackage.getCGValuedElement(), null, "initValue", null, 1, 1, CGConnectionAssignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCGConnectionAssignment_ConnectionVariable(), this.getCGConnectionVariable(), null, "connectionVariable", null, 1, 1, CGConnectionAssignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cgConnectionVariableEClass, CGConnectionVariable.class, "CGConnectionVariable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(cgEcorePropertyAssignmentEClass, CGEcorePropertyAssignment.class, "CGEcorePropertyAssignment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCGEcorePropertyAssignment_EStructuralFeature(), ecorePackage.getEStructuralFeature(), null, "eStructuralFeature", null, 1, 1, CGEcorePropertyAssignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cgEcoreRealizedVariableEClass, CGEcoreRealizedVariable.class, "CGEcoreRealizedVariable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCGEcoreRealizedVariable_EClassifier(), ecorePackage.getEClassifier(), null, "eClassifier", null, 1, 1, CGEcoreRealizedVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cgFunctionEClass, CGFunction.class, "CGFunction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(cgFunctionCallExpEClass, CGFunctionCallExp.class, "CGFunctionCallExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCGFunctionCallExp_Function(), this.getCGFunction(), null, "function", null, 1, 1, CGFunctionCallExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cgFunctionParameterEClass, CGFunctionParameter.class, "CGFunctionParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCGFunctionParameter_Function(), this.getCGFunction(), null, "function", null, 1, 1, CGFunctionParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cgGuardVariableEClass, CGGuardVariable.class, "CGGuardVariable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCGGuardVariable_Mapping(), this.getCGMapping(), this.getCGMapping_FreeVariables(), "mapping", null, 1, 1, CGGuardVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCGGuardVariable_TypedModel(), this.getCGTypedModel(), null, "typedModel", null, 1, 1, CGGuardVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cgMappingEClass, CGMapping.class, "CGMapping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCGMapping_Body(), theCGModelPackage.getCGValuedElement(), null, "body", null, 1, 1, CGMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCGMapping_FreeVariables(), this.getCGGuardVariable(), this.getCGGuardVariable_Mapping(), "freeVariables", null, 0, -1, CGMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getCGMapping_Transformation(), this.getCGTransformation(), this.getCGTransformation_Mappings(), "transformation", null, 1, 1, CGMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cgMappingCallEClass, CGMappingCall.class, "CGMappingCall", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCGMappingCall_MappingCallBindings(), this.getCGMappingCallBinding(), null, "mappingCallBindings", null, 0, -1, CGMappingCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cgMappingCallBindingEClass, CGMappingCallBinding.class, "CGMappingCallBinding", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCGMappingCallBinding_Value(), theCGModelPackage.getCGValuedElement(), null, "value", null, 1, 1, CGMappingCallBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cgMappingExpEClass, CGMappingExp.class, "CGMappingExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCGMappingExp_Assignments(), this.getCGPropertyAssignment(), this.getCGPropertyAssignment_MappingExp(), "assignments", null, 0, -1, CGMappingExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCGMappingExp_Mapping(), this.getCGMapping(), null, "mapping", null, 1, 1, CGMappingExp.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getCGMappingExp_Predicates(), this.getCGPredicate(), this.getCGPredicate_MappingExp(), "predicates", null, 0, -1, CGMappingExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCGMappingExp_RealizedVariables(), theCGModelPackage.getCGValuedElement(), null, "realizedVariables", null, 0, -1, CGMappingExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCGMappingExp_Body(), theCGModelPackage.getCGValuedElement(), null, "body", null, 0, 1, CGMappingExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCGMappingExp_VariableAssignments(), theCGModelPackage.getCGFinalVariable(), null, "variableAssignments", null, 0, -1, CGMappingExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCGMappingExp_ConnectionAssignments(), this.getCGConnectionAssignment(), this.getCGConnectionAssignment_MappingExp(), "connectionAssignments", null, 0, -1, CGMappingExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCGMappingExp_OwnedAccumulators(), theCGModelPackage.getCGAccumulator(), null, "ownedAccumulators", null, 0, -1, CGMappingExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cgMappingLoopEClass, CGMappingLoop.class, "CGMappingLoop", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(cgMiddlePropertyAssignmentEClass, CGMiddlePropertyAssignment.class, "CGMiddlePropertyAssignment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(cgMiddlePropertyCallExpEClass, CGMiddlePropertyCallExp.class, "CGMiddlePropertyCallExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(cgPredicateEClass, CGPredicate.class, "CGPredicate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCGPredicate_ConditionExpression(), theCGModelPackage.getCGValuedElement(), null, "conditionExpression", null, 1, 1, CGPredicate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCGPredicate_MappingExp(), this.getCGMappingExp(), this.getCGMappingExp_Predicates(), "mappingExp", null, 1, 1, CGPredicate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCGPredicate_ThenExpression(), theCGModelPackage.getCGValuedElement(), null, "thenExpression", null, 0, 1, CGPredicate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cgPropertyAssignmentEClass, CGPropertyAssignment.class, "CGPropertyAssignment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCGPropertyAssignment_MappingExp(), this.getCGMappingExp(), this.getCGMappingExp_Assignments(), "mappingExp", null, 1, 1, CGPropertyAssignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCGPropertyAssignment_SlotValue(), theCGModelPackage.getCGValuedElement(), null, "slotValue", null, 1, 1, CGPropertyAssignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCGPropertyAssignment_ReferredProperty(), theCGModelPackage.getProperty(), "referredProperty", null, 1, 1, CGPropertyAssignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCGPropertyAssignment_InitValue(), theCGModelPackage.getCGValuedElement(), null, "initValue", null, 1, 1, CGPropertyAssignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCGPropertyAssignment_ExecutorProperty(), theCGModelPackage.getCGExecutorProperty(), null, "executorProperty", null, 1, 1, CGPropertyAssignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cgRealizedVariableEClass, CGRealizedVariable.class, "CGRealizedVariable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCGRealizedVariable_ExecutorType(), theCGModelPackage.getCGExecutorType(), null, "executorType", null, 1, 1, CGRealizedVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCGRealizedVariable_TypedModel(), this.getCGTypedModel(), null, "typedModel", null, 1, 1, CGRealizedVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cgSequenceEClass, CGSequence.class, "CGSequence", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCGSequence_Statements(), theCGModelPackage.getCGValuedElement(), null, "statements", null, 0, -1, CGSequence.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cgTransformationEClass, CGTransformation.class, "CGTransformation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCGTransformation_Mappings(), this.getCGMapping(), this.getCGMapping_Transformation(), "mappings", null, 1, -1, CGTransformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCGTransformation_TypedModels(), this.getCGTypedModel(), this.getCGTypedModel_Transformation(), "typedModels", null, 0, -1, CGTransformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cgTypedModelEClass, CGTypedModel.class, "CGTypedModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCGTypedModel_Transformation(), this.getCGTransformation(), this.getCGTransformation_TypedModels(), "transformation", null, 1, 1, CGTypedModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCGTypedModel_ModelIndex(), ecorePackage.getEInt(), "modelIndex", null, 0, 1, CGTypedModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cgVariablePredicateEClass, CGVariablePredicate.class, "CGVariablePredicate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCGVariablePredicate_PredicateVariable(), theCGModelPackage.getCGVariable(), null, "predicateVariable", null, 1, 1, CGVariablePredicate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

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
			 "ecore", "http://www.eclipse.org/emf/2002/Ecore#/"
		   });
	}

} //QVTiCGModelPackageImpl
