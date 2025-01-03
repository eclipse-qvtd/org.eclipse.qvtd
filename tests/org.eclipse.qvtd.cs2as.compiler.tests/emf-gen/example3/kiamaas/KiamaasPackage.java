/*******************************************************************************
 * Copyright (c) 2016, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
/**
 */
package example3.kiamaas;

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
 * @see example3.kiamaas.KiamaasFactory
 * @model kind="package"
 * @generated
 */
public interface KiamaasPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "kiamaas";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://cs2as/tests/example3/kiamaas/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "kiamaas";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	KiamaasPackage eINSTANCE = example3.kiamaas.impl.KiamaasPackageImpl.init();

	/**
	 * Returns the meta object for class '{@link example3.kiamaas.Top <em>Top</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Top</em>'.
	 * @see example3.kiamaas.Top
	 * @generated
	 */
	EClass getTop();

	/**
	 * Returns the meta object for the containment reference '{@link example3.kiamaas.Top#getNode <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Node</em>'.
	 * @see example3.kiamaas.Top#getNode()
	 * @see #getTop()
	 * @generated
	 */
	EReference getTop_Node();

	/**
	 * Returns the meta object for class '{@link example3.kiamaas.Node <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Node</em>'.
	 * @see example3.kiamaas.Node
	 * @generated
	 */
	EClass getNode();

	/**
	 * Returns the meta object for the attribute '{@link example3.kiamaas.Node#getHeight <em>Height</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Height</em>'.
	 * @see example3.kiamaas.Node#getHeight()
	 * @see #getNode()
	 * @generated
	 */
	EAttribute getNode_Height();

	/**
	 * Returns the meta object for the attribute '{@link example3.kiamaas.Node#getDepth <em>Depth</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Depth</em>'.
	 * @see example3.kiamaas.Node#getDepth()
	 * @see #getNode()
	 * @generated
	 */
	EAttribute getNode_Depth();

	/**
	 * Returns the meta object for class '{@link example3.kiamaas.Plus <em>Plus</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Plus</em>'.
	 * @see example3.kiamaas.Plus
	 * @generated
	 */
	EClass getPlus();

	/**
	 * Returns the meta object for the containment reference '{@link example3.kiamaas.Plus#getLeft <em>Left</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Left</em>'.
	 * @see example3.kiamaas.Plus#getLeft()
	 * @see #getPlus()
	 * @generated
	 */
	EReference getPlus_Left();

	/**
	 * Returns the meta object for the containment reference '{@link example3.kiamaas.Plus#getRight <em>Right</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Right</em>'.
	 * @see example3.kiamaas.Plus#getRight()
	 * @see #getPlus()
	 * @generated
	 */
	EReference getPlus_Right();

	/**
	 * Returns the meta object for class '{@link example3.kiamaas.Num <em>Num</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Num</em>'.
	 * @see example3.kiamaas.Num
	 * @generated
	 */
	EClass getNum();

	/**
	 * Returns the meta object for the attribute '{@link example3.kiamaas.Num#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see example3.kiamaas.Num#getValue()
	 * @see #getNum()
	 * @generated
	 */
	EAttribute getNum_Value();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	KiamaasFactory getKiamaasFactory();

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
		 * The meta object literal for the '{@link example3.kiamaas.impl.TopImpl <em>Top</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see example3.kiamaas.impl.TopImpl
		 * @see example3.kiamaas.impl.KiamaasPackageImpl#getTop()
		 * @generated
		 */
		EClass TOP = eINSTANCE.getTop();

		/**
		 * The meta object literal for the '<em><b>Node</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TOP__NODE = eINSTANCE.getTop_Node();

		/**
		 * The meta object literal for the '{@link example3.kiamaas.impl.NodeImpl <em>Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see example3.kiamaas.impl.NodeImpl
		 * @see example3.kiamaas.impl.KiamaasPackageImpl#getNode()
		 * @generated
		 */
		EClass NODE = eINSTANCE.getNode();

		/**
		 * The meta object literal for the '<em><b>Height</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NODE__HEIGHT = eINSTANCE.getNode_Height();

		/**
		 * The meta object literal for the '<em><b>Depth</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NODE__DEPTH = eINSTANCE.getNode_Depth();

		/**
		 * The meta object literal for the '{@link example3.kiamaas.impl.PlusImpl <em>Plus</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see example3.kiamaas.impl.PlusImpl
		 * @see example3.kiamaas.impl.KiamaasPackageImpl#getPlus()
		 * @generated
		 */
		EClass PLUS = eINSTANCE.getPlus();

		/**
		 * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PLUS__LEFT = eINSTANCE.getPlus_Left();

		/**
		 * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PLUS__RIGHT = eINSTANCE.getPlus_Right();

		/**
		 * The meta object literal for the '{@link example3.kiamaas.impl.NumImpl <em>Num</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see example3.kiamaas.impl.NumImpl
		 * @see example3.kiamaas.impl.KiamaasPackageImpl#getNum()
		 * @generated
		 */
		EClass NUM = eINSTANCE.getNum();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NUM__VALUE = eINSTANCE.getNum_Value();

	}

} //KiamaasPackage
