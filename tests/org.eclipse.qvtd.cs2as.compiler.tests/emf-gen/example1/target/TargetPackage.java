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
package example1.target;

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
 * @see example1.target.TargetFactory
 * @model kind="package"
 * @generated
 */
public interface TargetPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "target";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://cs2as/tests/example1/targetMM/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "target";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TargetPackage eINSTANCE = example1.target.impl.TargetPackageImpl.init();

	/**
	 * The meta object id for the '{@link example1.target.impl.AImpl <em>A</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see example1.target.impl.AImpl
	 * @see example1.target.impl.TargetPackageImpl#getA()
	 * @generated
	 */
	int A = 0;

	/**
	 * The meta object id for the '{@link example1.target.impl.A1Impl <em>A1</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see example1.target.impl.A1Impl
	 * @see example1.target.impl.TargetPackageImpl#getA1()
	 * @generated
	 */
	int A1 = 1;

	/**
	 * The meta object id for the '{@link example1.target.impl.A2Impl <em>A2</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see example1.target.impl.A2Impl
	 * @see example1.target.impl.TargetPackageImpl#getA2()
	 * @generated
	 */
	int A2 = 2;

	/**
	 * The meta object id for the '{@link example1.target.impl.A3Impl <em>A3</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see example1.target.impl.A3Impl
	 * @see example1.target.impl.TargetPackageImpl#getA3()
	 * @generated
	 */
	int A3 = 3;

	/**
	 * The meta object id for the '{@link example1.target.impl.NamedElementImpl <em>Named Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see example1.target.impl.NamedElementImpl
	 * @see example1.target.impl.TargetPackageImpl#getNamedElement()
	 * @generated
	 */
	int NAMED_ELEMENT = 8;

	/**
	 * The meta object id for the '{@link example1.target.impl.BImpl <em>B</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see example1.target.impl.BImpl
	 * @see example1.target.impl.TargetPackageImpl#getB()
	 * @generated
	 */
	int B = 4;

	/**
	 * The meta object id for the '{@link example1.target.impl.CImpl <em>C</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see example1.target.impl.CImpl
	 * @see example1.target.impl.TargetPackageImpl#getC()
	 * @generated
	 */
	int C = 5;

	/**
	 * The meta object id for the '{@link example1.target.impl.DImpl <em>D</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see example1.target.impl.DImpl
	 * @see example1.target.impl.TargetPackageImpl#getD()
	 * @generated
	 */
	int D = 6;

	/**
	 * The meta object id for the '{@link example1.target.impl.TRootImpl <em>TRoot</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see example1.target.impl.TRootImpl
	 * @see example1.target.impl.TargetPackageImpl#getTRoot()
	 * @generated
	 */
	int TROOT = 7;

	/**
	 * The meta object id for the '{@link example1.target.util.Visitable <em>Visitable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see example1.target.util.Visitable
	 * @see example1.target.impl.TargetPackageImpl#getVisitable()
	 * @generated
	 */
	int VISITABLE = 10;

	/**
	 * The number of structural features of the '<em>Visitable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VISITABLE_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Visitable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VISITABLE_OPERATION_COUNT = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__NAME = VISITABLE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Named Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT_FEATURE_COUNT = VISITABLE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Named Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT_OPERATION_COUNT = VISITABLE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link example1.target.impl.NamespaceImpl <em>Namespace</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see example1.target.impl.NamespaceImpl
	 * @see example1.target.impl.TargetPackageImpl#getNamespace()
	 * @generated
	 */
	int NAMESPACE = 9;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMESPACE__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The number of structural features of the '<em>Namespace</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMESPACE_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Namespace</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMESPACE_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A__NAME = NAMESPACE__NAME;

	/**
	 * The number of structural features of the '<em>A</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A_FEATURE_COUNT = NAMESPACE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>A</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A_OPERATION_COUNT = NAMESPACE_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A1__NAME = A__NAME;

	/**
	 * The feature id for the '<em><b>Owns B</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A1__OWNS_B = A_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>A1</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A1_FEATURE_COUNT = A_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>A1</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A1_OPERATION_COUNT = A_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A2__NAME = A__NAME;

	/**
	 * The feature id for the '<em><b>Owns C</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A2__OWNS_C = A_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>A2</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A2_FEATURE_COUNT = A_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>A2</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A2_OPERATION_COUNT = A_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A3__NAME = A2__NAME;

	/**
	 * The feature id for the '<em><b>Owns C</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A3__OWNS_C = A2__OWNS_C;

	/**
	 * The number of structural features of the '<em>A3</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A3_FEATURE_COUNT = A2_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>A3</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A3_OPERATION_COUNT = A2_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B__NAME = NAMESPACE__NAME;

	/**
	 * The feature id for the '<em><b>To A1</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B__TO_A1 = NAMESPACE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owns D</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B__OWNS_D = NAMESPACE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>B</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B_FEATURE_COUNT = NAMESPACE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>B</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B_OPERATION_COUNT = NAMESPACE_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int C__NAME = NAMESPACE__NAME;

	/**
	 * The feature id for the '<em><b>To A2</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int C__TO_A2 = NAMESPACE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owns D</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int C__OWNS_D = NAMESPACE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>C</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int C_FEATURE_COUNT = NAMESPACE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>C</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int C_OPERATION_COUNT = NAMESPACE_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int D__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>To C</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int D__TO_C = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>To B</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int D__TO_B = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>To A</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int D__TO_A = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Refs B</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int D__REFS_B = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Refs C</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int D__REFS_C = NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>D</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int D_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The number of operations of the '<em>D</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int D_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned A</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TROOT__OWNED_A = VISITABLE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>TRoot</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TROOT_FEATURE_COUNT = VISITABLE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>TRoot</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TROOT_OPERATION_COUNT = VISITABLE_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link example1.target.A <em>A</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>A</em>'.
	 * @see example1.target.A
	 * @generated
	 */
	EClass getA();

	/**
	 * Returns the meta object for class '{@link example1.target.A1 <em>A1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>A1</em>'.
	 * @see example1.target.A1
	 * @generated
	 */
	EClass getA1();

	/**
	 * Returns the meta object for the containment reference list '{@link example1.target.A1#getOwnsB <em>Owns B</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owns B</em>'.
	 * @see example1.target.A1#getOwnsB()
	 * @see #getA1()
	 * @generated
	 */
	EReference getA1_OwnsB();

	/**
	 * Returns the meta object for class '{@link example1.target.A2 <em>A2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>A2</em>'.
	 * @see example1.target.A2
	 * @generated
	 */
	EClass getA2();

	/**
	 * Returns the meta object for the containment reference list '{@link example1.target.A2#getOwnsC <em>Owns C</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owns C</em>'.
	 * @see example1.target.A2#getOwnsC()
	 * @see #getA2()
	 * @generated
	 */
	EReference getA2_OwnsC();

	/**
	 * Returns the meta object for class '{@link example1.target.A3 <em>A3</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>A3</em>'.
	 * @see example1.target.A3
	 * @generated
	 */
	EClass getA3();

	/**
	 * Returns the meta object for class '{@link example1.target.B <em>B</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>B</em>'.
	 * @see example1.target.B
	 * @generated
	 */
	EClass getB();

	/**
	 * Returns the meta object for the container reference '{@link example1.target.B#getToA1 <em>To A1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>To A1</em>'.
	 * @see example1.target.B#getToA1()
	 * @see #getB()
	 * @generated
	 */
	EReference getB_ToA1();

	/**
	 * Returns the meta object for the containment reference '{@link example1.target.B#getOwnsD <em>Owns D</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owns D</em>'.
	 * @see example1.target.B#getOwnsD()
	 * @see #getB()
	 * @generated
	 */
	EReference getB_OwnsD();

	/**
	 * Returns the meta object for class '{@link example1.target.C <em>C</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>C</em>'.
	 * @see example1.target.C
	 * @generated
	 */
	EClass getC();

	/**
	 * Returns the meta object for the container reference '{@link example1.target.C#getToA2 <em>To A2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>To A2</em>'.
	 * @see example1.target.C#getToA2()
	 * @see #getC()
	 * @generated
	 */
	EReference getC_ToA2();

	/**
	 * Returns the meta object for the containment reference '{@link example1.target.C#getOwnsD <em>Owns D</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owns D</em>'.
	 * @see example1.target.C#getOwnsD()
	 * @see #getC()
	 * @generated
	 */
	EReference getC_OwnsD();

	/**
	 * Returns the meta object for class '{@link example1.target.D <em>D</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>D</em>'.
	 * @see example1.target.D
	 * @generated
	 */
	EClass getD();

	/**
	 * Returns the meta object for the container reference '{@link example1.target.D#getToC <em>To C</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>To C</em>'.
	 * @see example1.target.D#getToC()
	 * @see #getD()
	 * @generated
	 */
	EReference getD_ToC();

	/**
	 * Returns the meta object for the container reference '{@link example1.target.D#getToB <em>To B</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>To B</em>'.
	 * @see example1.target.D#getToB()
	 * @see #getD()
	 * @generated
	 */
	EReference getD_ToB();

	/**
	 * Returns the meta object for the reference '{@link example1.target.D#getToA <em>To A</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>To A</em>'.
	 * @see example1.target.D#getToA()
	 * @see #getD()
	 * @generated
	 */
	EReference getD_ToA();

	/**
	 * Returns the meta object for the reference '{@link example1.target.D#getRefsB <em>Refs B</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Refs B</em>'.
	 * @see example1.target.D#getRefsB()
	 * @see #getD()
	 * @generated
	 */
	EReference getD_RefsB();

	/**
	 * Returns the meta object for the reference '{@link example1.target.D#getRefsC <em>Refs C</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Refs C</em>'.
	 * @see example1.target.D#getRefsC()
	 * @see #getD()
	 * @generated
	 */
	EReference getD_RefsC();

	/**
	 * Returns the meta object for class '{@link example1.target.TRoot <em>TRoot</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TRoot</em>'.
	 * @see example1.target.TRoot
	 * @generated
	 */
	EClass getTRoot();

	/**
	 * Returns the meta object for the containment reference list '{@link example1.target.TRoot#getOwnedA <em>Owned A</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned A</em>'.
	 * @see example1.target.TRoot#getOwnedA()
	 * @see #getTRoot()
	 * @generated
	 */
	EReference getTRoot_OwnedA();

	/**
	 * Returns the meta object for class '{@link example1.target.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Named Element</em>'.
	 * @see example1.target.NamedElement
	 * @generated
	 */
	EClass getNamedElement();

	/**
	 * Returns the meta object for the attribute '{@link example1.target.NamedElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see example1.target.NamedElement#getName()
	 * @see #getNamedElement()
	 * @generated
	 */
	EAttribute getNamedElement_Name();

	/**
	 * Returns the meta object for class '{@link example1.target.Namespace <em>Namespace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Namespace</em>'.
	 * @see example1.target.Namespace
	 * @generated
	 */
	EClass getNamespace();

	/**
	 * Returns the meta object for class '{@link example1.target.util.Visitable <em>Visitable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Visitable</em>'.
	 * @see example1.target.util.Visitable
	 * @model instanceClass="example1.target.util.Visitable"
	 * @generated
	 */
	EClass getVisitable();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	TargetFactory getTargetFactory();

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
		 * The meta object literal for the '{@link example1.target.impl.AImpl <em>A</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see example1.target.impl.AImpl
		 * @see example1.target.impl.TargetPackageImpl#getA()
		 * @generated
		 */
		EClass A = eINSTANCE.getA();

		/**
		 * The meta object literal for the '{@link example1.target.impl.A1Impl <em>A1</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see example1.target.impl.A1Impl
		 * @see example1.target.impl.TargetPackageImpl#getA1()
		 * @generated
		 */
		EClass A1 = eINSTANCE.getA1();

		/**
		 * The meta object literal for the '<em><b>Owns B</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference A1__OWNS_B = eINSTANCE.getA1_OwnsB();

		/**
		 * The meta object literal for the '{@link example1.target.impl.A2Impl <em>A2</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see example1.target.impl.A2Impl
		 * @see example1.target.impl.TargetPackageImpl#getA2()
		 * @generated
		 */
		EClass A2 = eINSTANCE.getA2();

		/**
		 * The meta object literal for the '<em><b>Owns C</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference A2__OWNS_C = eINSTANCE.getA2_OwnsC();

		/**
		 * The meta object literal for the '{@link example1.target.impl.A3Impl <em>A3</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see example1.target.impl.A3Impl
		 * @see example1.target.impl.TargetPackageImpl#getA3()
		 * @generated
		 */
		EClass A3 = eINSTANCE.getA3();

		/**
		 * The meta object literal for the '{@link example1.target.impl.BImpl <em>B</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see example1.target.impl.BImpl
		 * @see example1.target.impl.TargetPackageImpl#getB()
		 * @generated
		 */
		EClass B = eINSTANCE.getB();

		/**
		 * The meta object literal for the '<em><b>To A1</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference B__TO_A1 = eINSTANCE.getB_ToA1();

		/**
		 * The meta object literal for the '<em><b>Owns D</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference B__OWNS_D = eINSTANCE.getB_OwnsD();

		/**
		 * The meta object literal for the '{@link example1.target.impl.CImpl <em>C</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see example1.target.impl.CImpl
		 * @see example1.target.impl.TargetPackageImpl#getC()
		 * @generated
		 */
		EClass C = eINSTANCE.getC();

		/**
		 * The meta object literal for the '<em><b>To A2</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference C__TO_A2 = eINSTANCE.getC_ToA2();

		/**
		 * The meta object literal for the '<em><b>Owns D</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference C__OWNS_D = eINSTANCE.getC_OwnsD();

		/**
		 * The meta object literal for the '{@link example1.target.impl.DImpl <em>D</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see example1.target.impl.DImpl
		 * @see example1.target.impl.TargetPackageImpl#getD()
		 * @generated
		 */
		EClass D = eINSTANCE.getD();

		/**
		 * The meta object literal for the '<em><b>To C</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference D__TO_C = eINSTANCE.getD_ToC();

		/**
		 * The meta object literal for the '<em><b>To B</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference D__TO_B = eINSTANCE.getD_ToB();

		/**
		 * The meta object literal for the '<em><b>To A</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference D__TO_A = eINSTANCE.getD_ToA();

		/**
		 * The meta object literal for the '<em><b>Refs B</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference D__REFS_B = eINSTANCE.getD_RefsB();

		/**
		 * The meta object literal for the '<em><b>Refs C</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference D__REFS_C = eINSTANCE.getD_RefsC();

		/**
		 * The meta object literal for the '{@link example1.target.impl.TRootImpl <em>TRoot</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see example1.target.impl.TRootImpl
		 * @see example1.target.impl.TargetPackageImpl#getTRoot()
		 * @generated
		 */
		EClass TROOT = eINSTANCE.getTRoot();

		/**
		 * The meta object literal for the '<em><b>Owned A</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TROOT__OWNED_A = eINSTANCE.getTRoot_OwnedA();

		/**
		 * The meta object literal for the '{@link example1.target.impl.NamedElementImpl <em>Named Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see example1.target.impl.NamedElementImpl
		 * @see example1.target.impl.TargetPackageImpl#getNamedElement()
		 * @generated
		 */
		EClass NAMED_ELEMENT = eINSTANCE.getNamedElement();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAMED_ELEMENT__NAME = eINSTANCE.getNamedElement_Name();

		/**
		 * The meta object literal for the '{@link example1.target.impl.NamespaceImpl <em>Namespace</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see example1.target.impl.NamespaceImpl
		 * @see example1.target.impl.TargetPackageImpl#getNamespace()
		 * @generated
		 */
		EClass NAMESPACE = eINSTANCE.getNamespace();

		/**
		 * The meta object literal for the '{@link example1.target.util.Visitable <em>Visitable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see example1.target.util.Visitable
		 * @see example1.target.impl.TargetPackageImpl#getVisitable()
		 * @generated
		 */
		EClass VISITABLE = eINSTANCE.getVisitable();

	}

} //TargetPackage
