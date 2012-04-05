/**
 * <copyright>
 * </copyright>
 *
 * $Id: RelationsToTraceClassPackage.java,v 1.2 2009/02/24 17:31:28 qglineur Exp $
 */
package org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass;

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
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.RelationsToTraceClassFactory
 * @model kind="package"
 * @generated
 */
public interface RelationsToTraceClassPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "relationsToTraceClass";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/qvt/1.0/RelationsToTraceClass";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "rttc";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	RelationsToTraceClassPackage eINSTANCE = org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.impl.RelationsToTraceClassPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.impl.TTransformationToPackageImpl <em>TTransformation To Package</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.impl.TTransformationToPackageImpl
	 * @see org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.impl.RelationsToTraceClassPackageImpl#getTTransformationToPackage()
	 * @generated
	 */
	int TTRANSFORMATION_TO_PACKAGE = 0;

	/**
	 * The feature id for the '<em><b>Rt</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TTRANSFORMATION_TO_PACKAGE__RT = 0;

	/**
	 * The feature id for the '<em><b>P</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TTRANSFORMATION_TO_PACKAGE__P = 1;

	/**
	 * The number of structural features of the '<em>TTransformation To Package</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TTRANSFORMATION_TO_PACKAGE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.impl.TRelationToTraceClassImpl <em>TRelation To Trace Class</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.impl.TRelationToTraceClassImpl
	 * @see org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.impl.RelationsToTraceClassPackageImpl#getTRelationToTraceClass()
	 * @generated
	 */
	int TRELATION_TO_TRACE_CLASS = 1;

	/**
	 * The feature id for the '<em><b>A</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRELATION_TO_TRACE_CLASS__A = 0;

	/**
	 * The feature id for the '<em><b>Rc</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRELATION_TO_TRACE_CLASS__RC = 1;

	/**
	 * The feature id for the '<em><b>C</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRELATION_TO_TRACE_CLASS__C = 2;

	/**
	 * The feature id for the '<em><b>P</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRELATION_TO_TRACE_CLASS__P = 3;

	/**
	 * The feature id for the '<em><b>Tv</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRELATION_TO_TRACE_CLASS__TV = 4;

	/**
	 * The feature id for the '<em><b>T</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRELATION_TO_TRACE_CLASS__T = 5;

	/**
	 * The feature id for the '<em><b>Rdp</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRELATION_TO_TRACE_CLASS__RDP = 6;

	/**
	 * The feature id for the '<em><b>Rd</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRELATION_TO_TRACE_CLASS__RD = 7;

	/**
	 * The feature id for the '<em><b>R</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRELATION_TO_TRACE_CLASS__R = 8;

	/**
	 * The feature id for the '<em><b>Rt</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRELATION_TO_TRACE_CLASS__RT = 9;

	/**
	 * The number of structural features of the '<em>TRelation To Trace Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRELATION_TO_TRACE_CLASS_FEATURE_COUNT = 10;

	/**
	 * The meta object id for the '{@link org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.impl.TSubTemplateToTraceClassPropsImpl <em>TSub Template To Trace Class Props</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.impl.TSubTemplateToTraceClassPropsImpl
	 * @see org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.impl.RelationsToTraceClassPackageImpl#getTSubTemplateToTraceClassProps()
	 * @generated
	 */
	int TSUB_TEMPLATE_TO_TRACE_CLASS_PROPS = 2;

	/**
	 * The feature id for the '<em><b>C</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSUB_TEMPLATE_TO_TRACE_CLASS_PROPS__C = 0;

	/**
	 * The feature id for the '<em><b>Tv</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSUB_TEMPLATE_TO_TRACE_CLASS_PROPS__TV = 1;

	/**
	 * The feature id for the '<em><b>Tp</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSUB_TEMPLATE_TO_TRACE_CLASS_PROPS__TP = 2;

	/**
	 * The feature id for the '<em><b>Pt</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSUB_TEMPLATE_TO_TRACE_CLASS_PROPS__PT = 3;

	/**
	 * The feature id for the '<em><b>T</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSUB_TEMPLATE_TO_TRACE_CLASS_PROPS__T = 4;

	/**
	 * The feature id for the '<em><b>A</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSUB_TEMPLATE_TO_TRACE_CLASS_PROPS__A = 5;

	/**
	 * The feature id for the '<em><b>Rc</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSUB_TEMPLATE_TO_TRACE_CLASS_PROPS__RC = 6;

	/**
	 * The number of structural features of the '<em>TSub Template To Trace Class Props</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSUB_TEMPLATE_TO_TRACE_CLASS_PROPS_FEATURE_COUNT = 7;


	/**
	 * Returns the meta object for class '{@link org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.TTransformationToPackage <em>TTransformation To Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TTransformation To Package</em>'.
	 * @see org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.TTransformationToPackage
	 * @generated
	 */
	EClass getTTransformationToPackage();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.TTransformationToPackage#getRt <em>Rt</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Rt</em>'.
	 * @see org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.TTransformationToPackage#getRt()
	 * @see #getTTransformationToPackage()
	 * @generated
	 */
	EReference getTTransformationToPackage_Rt();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.TTransformationToPackage#getP <em>P</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>P</em>'.
	 * @see org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.TTransformationToPackage#getP()
	 * @see #getTTransformationToPackage()
	 * @generated
	 */
	EReference getTTransformationToPackage_P();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.TRelationToTraceClass <em>TRelation To Trace Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TRelation To Trace Class</em>'.
	 * @see org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.TRelationToTraceClass
	 * @generated
	 */
	EClass getTRelationToTraceClass();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.TRelationToTraceClass#getA <em>A</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>A</em>'.
	 * @see org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.TRelationToTraceClass#getA()
	 * @see #getTRelationToTraceClass()
	 * @generated
	 */
	EReference getTRelationToTraceClass_A();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.TRelationToTraceClass#getRc <em>Rc</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Rc</em>'.
	 * @see org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.TRelationToTraceClass#getRc()
	 * @see #getTRelationToTraceClass()
	 * @generated
	 */
	EReference getTRelationToTraceClass_Rc();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.TRelationToTraceClass#getC <em>C</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>C</em>'.
	 * @see org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.TRelationToTraceClass#getC()
	 * @see #getTRelationToTraceClass()
	 * @generated
	 */
	EReference getTRelationToTraceClass_C();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.TRelationToTraceClass#getP <em>P</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>P</em>'.
	 * @see org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.TRelationToTraceClass#getP()
	 * @see #getTRelationToTraceClass()
	 * @generated
	 */
	EReference getTRelationToTraceClass_P();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.TRelationToTraceClass#getTv <em>Tv</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Tv</em>'.
	 * @see org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.TRelationToTraceClass#getTv()
	 * @see #getTRelationToTraceClass()
	 * @generated
	 */
	EReference getTRelationToTraceClass_Tv();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.TRelationToTraceClass#getT <em>T</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T</em>'.
	 * @see org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.TRelationToTraceClass#getT()
	 * @see #getTRelationToTraceClass()
	 * @generated
	 */
	EReference getTRelationToTraceClass_T();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.TRelationToTraceClass#getRdp <em>Rdp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Rdp</em>'.
	 * @see org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.TRelationToTraceClass#getRdp()
	 * @see #getTRelationToTraceClass()
	 * @generated
	 */
	EReference getTRelationToTraceClass_Rdp();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.TRelationToTraceClass#getRd <em>Rd</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Rd</em>'.
	 * @see org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.TRelationToTraceClass#getRd()
	 * @see #getTRelationToTraceClass()
	 * @generated
	 */
	EReference getTRelationToTraceClass_Rd();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.TRelationToTraceClass#getR <em>R</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>R</em>'.
	 * @see org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.TRelationToTraceClass#getR()
	 * @see #getTRelationToTraceClass()
	 * @generated
	 */
	EReference getTRelationToTraceClass_R();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.TRelationToTraceClass#getRt <em>Rt</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Rt</em>'.
	 * @see org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.TRelationToTraceClass#getRt()
	 * @see #getTRelationToTraceClass()
	 * @generated
	 */
	EReference getTRelationToTraceClass_Rt();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.TSubTemplateToTraceClassProps <em>TSub Template To Trace Class Props</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TSub Template To Trace Class Props</em>'.
	 * @see org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.TSubTemplateToTraceClassProps
	 * @generated
	 */
	EClass getTSubTemplateToTraceClassProps();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.TSubTemplateToTraceClassProps#getC <em>C</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>C</em>'.
	 * @see org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.TSubTemplateToTraceClassProps#getC()
	 * @see #getTSubTemplateToTraceClassProps()
	 * @generated
	 */
	EReference getTSubTemplateToTraceClassProps_C();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.TSubTemplateToTraceClassProps#getTv <em>Tv</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Tv</em>'.
	 * @see org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.TSubTemplateToTraceClassProps#getTv()
	 * @see #getTSubTemplateToTraceClassProps()
	 * @generated
	 */
	EReference getTSubTemplateToTraceClassProps_Tv();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.TSubTemplateToTraceClassProps#getTp <em>Tp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Tp</em>'.
	 * @see org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.TSubTemplateToTraceClassProps#getTp()
	 * @see #getTSubTemplateToTraceClassProps()
	 * @generated
	 */
	EReference getTSubTemplateToTraceClassProps_Tp();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.TSubTemplateToTraceClassProps#getPt <em>Pt</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Pt</em>'.
	 * @see org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.TSubTemplateToTraceClassProps#getPt()
	 * @see #getTSubTemplateToTraceClassProps()
	 * @generated
	 */
	EReference getTSubTemplateToTraceClassProps_Pt();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.TSubTemplateToTraceClassProps#getT <em>T</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T</em>'.
	 * @see org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.TSubTemplateToTraceClassProps#getT()
	 * @see #getTSubTemplateToTraceClassProps()
	 * @generated
	 */
	EReference getTSubTemplateToTraceClassProps_T();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.TSubTemplateToTraceClassProps#getA <em>A</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>A</em>'.
	 * @see org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.TSubTemplateToTraceClassProps#getA()
	 * @see #getTSubTemplateToTraceClassProps()
	 * @generated
	 */
	EReference getTSubTemplateToTraceClassProps_A();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.TSubTemplateToTraceClassProps#getRc <em>Rc</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Rc</em>'.
	 * @see org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.TSubTemplateToTraceClassProps#getRc()
	 * @see #getTSubTemplateToTraceClassProps()
	 * @generated
	 */
	EReference getTSubTemplateToTraceClassProps_Rc();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	RelationsToTraceClassFactory getRelationsToTraceClassFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.impl.TTransformationToPackageImpl <em>TTransformation To Package</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.impl.TTransformationToPackageImpl
		 * @see org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.impl.RelationsToTraceClassPackageImpl#getTTransformationToPackage()
		 * @generated
		 */
		EClass TTRANSFORMATION_TO_PACKAGE = eINSTANCE.getTTransformationToPackage();

		/**
		 * The meta object literal for the '<em><b>Rt</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TTRANSFORMATION_TO_PACKAGE__RT = eINSTANCE.getTTransformationToPackage_Rt();

		/**
		 * The meta object literal for the '<em><b>P</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TTRANSFORMATION_TO_PACKAGE__P = eINSTANCE.getTTransformationToPackage_P();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.impl.TRelationToTraceClassImpl <em>TRelation To Trace Class</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.impl.TRelationToTraceClassImpl
		 * @see org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.impl.RelationsToTraceClassPackageImpl#getTRelationToTraceClass()
		 * @generated
		 */
		EClass TRELATION_TO_TRACE_CLASS = eINSTANCE.getTRelationToTraceClass();

		/**
		 * The meta object literal for the '<em><b>A</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRELATION_TO_TRACE_CLASS__A = eINSTANCE.getTRelationToTraceClass_A();

		/**
		 * The meta object literal for the '<em><b>Rc</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRELATION_TO_TRACE_CLASS__RC = eINSTANCE.getTRelationToTraceClass_Rc();

		/**
		 * The meta object literal for the '<em><b>C</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRELATION_TO_TRACE_CLASS__C = eINSTANCE.getTRelationToTraceClass_C();

		/**
		 * The meta object literal for the '<em><b>P</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRELATION_TO_TRACE_CLASS__P = eINSTANCE.getTRelationToTraceClass_P();

		/**
		 * The meta object literal for the '<em><b>Tv</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRELATION_TO_TRACE_CLASS__TV = eINSTANCE.getTRelationToTraceClass_Tv();

		/**
		 * The meta object literal for the '<em><b>T</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRELATION_TO_TRACE_CLASS__T = eINSTANCE.getTRelationToTraceClass_T();

		/**
		 * The meta object literal for the '<em><b>Rdp</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRELATION_TO_TRACE_CLASS__RDP = eINSTANCE.getTRelationToTraceClass_Rdp();

		/**
		 * The meta object literal for the '<em><b>Rd</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRELATION_TO_TRACE_CLASS__RD = eINSTANCE.getTRelationToTraceClass_Rd();

		/**
		 * The meta object literal for the '<em><b>R</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRELATION_TO_TRACE_CLASS__R = eINSTANCE.getTRelationToTraceClass_R();

		/**
		 * The meta object literal for the '<em><b>Rt</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRELATION_TO_TRACE_CLASS__RT = eINSTANCE.getTRelationToTraceClass_Rt();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.impl.TSubTemplateToTraceClassPropsImpl <em>TSub Template To Trace Class Props</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.impl.TSubTemplateToTraceClassPropsImpl
		 * @see org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.impl.RelationsToTraceClassPackageImpl#getTSubTemplateToTraceClassProps()
		 * @generated
		 */
		EClass TSUB_TEMPLATE_TO_TRACE_CLASS_PROPS = eINSTANCE.getTSubTemplateToTraceClassProps();

		/**
		 * The meta object literal for the '<em><b>C</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TSUB_TEMPLATE_TO_TRACE_CLASS_PROPS__C = eINSTANCE.getTSubTemplateToTraceClassProps_C();

		/**
		 * The meta object literal for the '<em><b>Tv</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TSUB_TEMPLATE_TO_TRACE_CLASS_PROPS__TV = eINSTANCE.getTSubTemplateToTraceClassProps_Tv();

		/**
		 * The meta object literal for the '<em><b>Tp</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TSUB_TEMPLATE_TO_TRACE_CLASS_PROPS__TP = eINSTANCE.getTSubTemplateToTraceClassProps_Tp();

		/**
		 * The meta object literal for the '<em><b>Pt</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TSUB_TEMPLATE_TO_TRACE_CLASS_PROPS__PT = eINSTANCE.getTSubTemplateToTraceClassProps_Pt();

		/**
		 * The meta object literal for the '<em><b>T</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TSUB_TEMPLATE_TO_TRACE_CLASS_PROPS__T = eINSTANCE.getTSubTemplateToTraceClassProps_T();

		/**
		 * The meta object literal for the '<em><b>A</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TSUB_TEMPLATE_TO_TRACE_CLASS_PROPS__A = eINSTANCE.getTSubTemplateToTraceClassProps_A();

		/**
		 * The meta object literal for the '<em><b>Rc</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TSUB_TEMPLATE_TO_TRACE_CLASS_PROPS__RC = eINSTANCE.getTSubTemplateToTraceClassProps_Rc();

	}

} //RelationsToTraceClassPackage
