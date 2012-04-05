/**
 * <copyright>
 * </copyright>
 *
 * $Id: RelationsToTraceClassPackageImpl.java,v 1.2 2009/02/24 17:31:29 qglineur Exp $
 */
package org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.qvt.declarative.ecore.QVTRelation.QVTRelationPackage;

import org.eclipse.qvt.declarative.ecore.QVTTemplate.QVTTemplatePackage;

import org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.RelationsToTraceClassFactory;
import org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.RelationsToTraceClassPackage;
import org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.TRelationToTraceClass;
import org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.TSubTemplateToTraceClassProps;
import org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.TTransformationToPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class RelationsToTraceClassPackageImpl extends EPackageImpl implements RelationsToTraceClassPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tTransformationToPackageEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tRelationToTraceClassEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tSubTemplateToTraceClassPropsEClass = null;

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
	 * @see org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.RelationsToTraceClassPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private RelationsToTraceClassPackageImpl() {
		super(eNS_URI, RelationsToTraceClassFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this
	 * model, and for any others upon which it depends.  Simple
	 * dependencies are satisfied by calling this method on all
	 * dependent packages before doing anything else.  This method drives
	 * initialization for interdependent packages directly, in parallel
	 * with this package, itself.
	 * <p>Of this package and its interdependencies, all packages which
	 * have not yet been registered by their URI values are first created
	 * and registered.  The packages are then initialized in two steps:
	 * meta-model objects for all of the packages are created before any
	 * are initialized, since one package's meta-model objects may refer to
	 * those of another.
	 * <p>Invocation of this method will not affect any packages that have
	 * already been initialized.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static RelationsToTraceClassPackage init() {
		if (isInited) return (RelationsToTraceClassPackage)EPackage.Registry.INSTANCE.getEPackage(RelationsToTraceClassPackage.eNS_URI);

		// Obtain or create and register package
		RelationsToTraceClassPackageImpl theRelationsToTraceClassPackage = (RelationsToTraceClassPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof RelationsToTraceClassPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new RelationsToTraceClassPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		QVTRelationPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theRelationsToTraceClassPackage.createPackageContents();

		// Initialize created meta-data
		theRelationsToTraceClassPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theRelationsToTraceClassPackage.freeze();

		return theRelationsToTraceClassPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTTransformationToPackage() {
		return tTransformationToPackageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTTransformationToPackage_Rt() {
		return (EReference)tTransformationToPackageEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTTransformationToPackage_P() {
		return (EReference)tTransformationToPackageEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTRelationToTraceClass() {
		return tRelationToTraceClassEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTRelationToTraceClass_A() {
		return (EReference)tRelationToTraceClassEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTRelationToTraceClass_Rc() {
		return (EReference)tRelationToTraceClassEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTRelationToTraceClass_C() {
		return (EReference)tRelationToTraceClassEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTRelationToTraceClass_P() {
		return (EReference)tRelationToTraceClassEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTRelationToTraceClass_Tv() {
		return (EReference)tRelationToTraceClassEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTRelationToTraceClass_T() {
		return (EReference)tRelationToTraceClassEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTRelationToTraceClass_Rdp() {
		return (EReference)tRelationToTraceClassEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTRelationToTraceClass_Rd() {
		return (EReference)tRelationToTraceClassEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTRelationToTraceClass_R() {
		return (EReference)tRelationToTraceClassEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTRelationToTraceClass_Rt() {
		return (EReference)tRelationToTraceClassEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTSubTemplateToTraceClassProps() {
		return tSubTemplateToTraceClassPropsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTSubTemplateToTraceClassProps_C() {
		return (EReference)tSubTemplateToTraceClassPropsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTSubTemplateToTraceClassProps_Tv() {
		return (EReference)tSubTemplateToTraceClassPropsEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTSubTemplateToTraceClassProps_Tp() {
		return (EReference)tSubTemplateToTraceClassPropsEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTSubTemplateToTraceClassProps_Pt() {
		return (EReference)tSubTemplateToTraceClassPropsEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTSubTemplateToTraceClassProps_T() {
		return (EReference)tSubTemplateToTraceClassPropsEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTSubTemplateToTraceClassProps_A() {
		return (EReference)tSubTemplateToTraceClassPropsEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTSubTemplateToTraceClassProps_Rc() {
		return (EReference)tSubTemplateToTraceClassPropsEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RelationsToTraceClassFactory getRelationsToTraceClassFactory() {
		return (RelationsToTraceClassFactory)getEFactoryInstance();
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
		tTransformationToPackageEClass = createEClass(TTRANSFORMATION_TO_PACKAGE);
		createEReference(tTransformationToPackageEClass, TTRANSFORMATION_TO_PACKAGE__RT);
		createEReference(tTransformationToPackageEClass, TTRANSFORMATION_TO_PACKAGE__P);

		tRelationToTraceClassEClass = createEClass(TRELATION_TO_TRACE_CLASS);
		createEReference(tRelationToTraceClassEClass, TRELATION_TO_TRACE_CLASS__A);
		createEReference(tRelationToTraceClassEClass, TRELATION_TO_TRACE_CLASS__RC);
		createEReference(tRelationToTraceClassEClass, TRELATION_TO_TRACE_CLASS__C);
		createEReference(tRelationToTraceClassEClass, TRELATION_TO_TRACE_CLASS__P);
		createEReference(tRelationToTraceClassEClass, TRELATION_TO_TRACE_CLASS__TV);
		createEReference(tRelationToTraceClassEClass, TRELATION_TO_TRACE_CLASS__T);
		createEReference(tRelationToTraceClassEClass, TRELATION_TO_TRACE_CLASS__RDP);
		createEReference(tRelationToTraceClassEClass, TRELATION_TO_TRACE_CLASS__RD);
		createEReference(tRelationToTraceClassEClass, TRELATION_TO_TRACE_CLASS__R);
		createEReference(tRelationToTraceClassEClass, TRELATION_TO_TRACE_CLASS__RT);

		tSubTemplateToTraceClassPropsEClass = createEClass(TSUB_TEMPLATE_TO_TRACE_CLASS_PROPS);
		createEReference(tSubTemplateToTraceClassPropsEClass, TSUB_TEMPLATE_TO_TRACE_CLASS_PROPS__C);
		createEReference(tSubTemplateToTraceClassPropsEClass, TSUB_TEMPLATE_TO_TRACE_CLASS_PROPS__TV);
		createEReference(tSubTemplateToTraceClassPropsEClass, TSUB_TEMPLATE_TO_TRACE_CLASS_PROPS__TP);
		createEReference(tSubTemplateToTraceClassPropsEClass, TSUB_TEMPLATE_TO_TRACE_CLASS_PROPS__PT);
		createEReference(tSubTemplateToTraceClassPropsEClass, TSUB_TEMPLATE_TO_TRACE_CLASS_PROPS__T);
		createEReference(tSubTemplateToTraceClassPropsEClass, TSUB_TEMPLATE_TO_TRACE_CLASS_PROPS__A);
		createEReference(tSubTemplateToTraceClassPropsEClass, TSUB_TEMPLATE_TO_TRACE_CLASS_PROPS__RC);
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
		QVTRelationPackage theQVTRelationPackage = (QVTRelationPackage)EPackage.Registry.INSTANCE.getEPackage(QVTRelationPackage.eNS_URI);
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);
		org.eclipse.ocl.ecore.EcorePackage theEcorePackage_1 = (org.eclipse.ocl.ecore.EcorePackage)EPackage.Registry.INSTANCE.getEPackage(org.eclipse.ocl.ecore.EcorePackage.eNS_URI);
		QVTTemplatePackage theQVTTemplatePackage = (QVTTemplatePackage)EPackage.Registry.INSTANCE.getEPackage(QVTTemplatePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(tTransformationToPackageEClass, TTransformationToPackage.class, "TTransformationToPackage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTTransformationToPackage_Rt(), theQVTRelationPackage.getRelationalTransformation(), null, "rt", null, 0, 1, TTransformationToPackage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTTransformationToPackage_P(), theEcorePackage.getEPackage(), null, "p", null, 0, 1, TTransformationToPackage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tRelationToTraceClassEClass, TRelationToTraceClass.class, "TRelationToTraceClass", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTRelationToTraceClass_A(), theEcorePackage.getEReference(), null, "a", null, 0, 1, TRelationToTraceClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTRelationToTraceClass_Rc(), theEcorePackage.getEClass(), null, "rc", null, 0, 1, TRelationToTraceClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTRelationToTraceClass_C(), theEcorePackage.getEClass(), null, "c", null, 0, 1, TRelationToTraceClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTRelationToTraceClass_P(), theEcorePackage.getEPackage(), null, "p", null, 0, 1, TRelationToTraceClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTRelationToTraceClass_Tv(), theEcorePackage_1.getVariable(), null, "tv", null, 0, 1, TRelationToTraceClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTRelationToTraceClass_T(), theQVTTemplatePackage.getObjectTemplateExp(), null, "t", null, 0, 1, TRelationToTraceClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTRelationToTraceClass_Rdp(), theQVTRelationPackage.getDomainPattern(), null, "rdp", null, 0, 1, TRelationToTraceClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTRelationToTraceClass_Rd(), theQVTRelationPackage.getRelationDomain(), null, "rd", null, 0, 1, TRelationToTraceClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTRelationToTraceClass_R(), theQVTRelationPackage.getRelation(), null, "r", null, 0, 1, TRelationToTraceClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTRelationToTraceClass_Rt(), theQVTRelationPackage.getRelationalTransformation(), null, "rt", null, 0, 1, TRelationToTraceClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tSubTemplateToTraceClassPropsEClass, TSubTemplateToTraceClassProps.class, "TSubTemplateToTraceClassProps", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTSubTemplateToTraceClassProps_C(), theEcorePackage.getEClass(), null, "c", null, 0, 1, TSubTemplateToTraceClassProps.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTSubTemplateToTraceClassProps_Tv(), theEcorePackage_1.getVariable(), null, "tv", null, 0, 1, TSubTemplateToTraceClassProps.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTSubTemplateToTraceClassProps_Tp(), theQVTTemplatePackage.getObjectTemplateExp(), null, "tp", null, 0, 1, TSubTemplateToTraceClassProps.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTSubTemplateToTraceClassProps_Pt(), theQVTTemplatePackage.getPropertyTemplateItem(), null, "pt", null, 0, 1, TSubTemplateToTraceClassProps.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTSubTemplateToTraceClassProps_T(), theQVTTemplatePackage.getObjectTemplateExp(), null, "t", null, 0, 1, TSubTemplateToTraceClassProps.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTSubTemplateToTraceClassProps_A(), theEcorePackage.getEReference(), null, "a", null, 0, 1, TSubTemplateToTraceClassProps.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTSubTemplateToTraceClassProps_Rc(), theEcorePackage.getEClass(), null, "rc", null, 0, 1, TSubTemplateToTraceClassProps.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //RelationsToTraceClassPackageImpl
