/**
 * <copyright>
 * 
 * Copyright (c) 2008 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * E.D.Willink - initial API and implementation
 * 
 * </copyright>
 *
 * $Id: EditorPackage.java,v 1.2 2008/08/09 17:33:58 ewillink Exp $
 */
package org.eclipse.qvt.declarative.editor;

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
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.qvt.declarative.editor.EditorFactory
 * @model kind="package"
 * @generated
 */
public interface EditorPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "editor";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/qvt/1.0/Editor";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "ed";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EditorPackage eINSTANCE = org.eclipse.qvt.declarative.editor.impl.EditorPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.qvt.declarative.editor.impl.BehaviorImpl <em>Behavior</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvt.declarative.editor.impl.BehaviorImpl
	 * @see org.eclipse.qvt.declarative.editor.impl.EditorPackageImpl#getBehavior()
	 * @generated
	 */
	int BEHAVIOR = 0;

	/**
	 * The number of structural features of the '<em>Behavior</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOR_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvt.declarative.editor.impl.EditorDefinitionImpl <em>Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvt.declarative.editor.impl.EditorDefinitionImpl
	 * @see org.eclipse.qvt.declarative.editor.impl.EditorPackageImpl#getEditorDefinition()
	 * @generated
	 */
	int EDITOR_DEFINITION = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.qvt.declarative.editor.impl.FoldingBehaviorImpl <em>Folding Behavior</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvt.declarative.editor.impl.FoldingBehaviorImpl
	 * @see org.eclipse.qvt.declarative.editor.impl.EditorPackageImpl#getFoldingBehavior()
	 * @generated
	 */
	int FOLDING_BEHAVIOR = 3;

	/**
	 * The meta object id for the '{@link org.eclipse.qvt.declarative.editor.impl.JavaNodeImpl <em>Java Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvt.declarative.editor.impl.JavaNodeImpl
	 * @see org.eclipse.qvt.declarative.editor.impl.EditorPackageImpl#getJavaNode()
	 * @generated
	 */
	int JAVA_NODE = 4;

	/**
	 * The meta object id for the '{@link org.eclipse.qvt.declarative.editor.impl.NodeImpl <em>Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvt.declarative.editor.impl.NodeImpl
	 * @see org.eclipse.qvt.declarative.editor.impl.EditorPackageImpl#getNode()
	 * @generated
	 */
	int NODE = 7;

	/**
	 * The feature id for the '<em><b>Behavior</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__BEHAVIOR = 0;

	/**
	 * The feature id for the '<em><b>Base</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__BASE = 1;

	/**
	 * The number of structural features of the '<em>Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.qvt.declarative.editor.impl.EcoreNodeImpl <em>Ecore Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvt.declarative.editor.impl.EcoreNodeImpl
	 * @see org.eclipse.qvt.declarative.editor.impl.EditorPackageImpl#getEcoreNode()
	 * @generated
	 */
	int ECORE_NODE = 1;

	/**
	 * The feature id for the '<em><b>Behavior</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECORE_NODE__BEHAVIOR = NODE__BEHAVIOR;

	/**
	 * The feature id for the '<em><b>Base</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECORE_NODE__BASE = NODE__BASE;

	/**
	 * The feature id for the '<em><b>Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECORE_NODE__ELEMENT = NODE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Ecore Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ECORE_NODE_FEATURE_COUNT = NODE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Node</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDITOR_DEFINITION__NODE = 0;

	/**
	 * The number of structural features of the '<em>Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDITOR_DEFINITION_FEATURE_COUNT = 1;

	/**
	 * The number of structural features of the '<em>Folding Behavior</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOLDING_BEHAVIOR_FEATURE_COUNT = BEHAVIOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Behavior</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_NODE__BEHAVIOR = NODE__BEHAVIOR;

	/**
	 * The feature id for the '<em><b>Base</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_NODE__BASE = NODE__BASE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_NODE__NAME = NODE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Java Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_NODE_FEATURE_COUNT = NODE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.qvt.declarative.editor.impl.LabelBehaviorImpl <em>Label Behavior</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvt.declarative.editor.impl.LabelBehaviorImpl
	 * @see org.eclipse.qvt.declarative.editor.impl.EditorPackageImpl#getLabelBehavior()
	 * @generated
	 */
	int LABEL_BEHAVIOR = 5;

	/**
	 * The feature id for the '<em><b>Image</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABEL_BEHAVIOR__IMAGE = BEHAVIOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Format</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABEL_BEHAVIOR__FORMAT = BEHAVIOR_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABEL_BEHAVIOR__ELEMENTS = BEHAVIOR_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Label Behavior</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABEL_BEHAVIOR_FEATURE_COUNT = BEHAVIOR_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.qvt.declarative.editor.impl.LabelElementImpl <em>Label Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvt.declarative.editor.impl.LabelElementImpl
	 * @see org.eclipse.qvt.declarative.editor.impl.EditorPackageImpl#getLabelElement()
	 * @generated
	 */
	int LABEL_ELEMENT = 6;

	/**
	 * The feature id for the '<em><b>Path</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABEL_ELEMENT__PATH = 0;

	/**
	 * The feature id for the '<em><b>End</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABEL_ELEMENT__END = 1;

	/**
	 * The number of structural features of the '<em>Label Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABEL_ELEMENT_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.qvt.declarative.editor.impl.OutlineBehaviorImpl <em>Outline Behavior</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvt.declarative.editor.impl.OutlineBehaviorImpl
	 * @see org.eclipse.qvt.declarative.editor.impl.EditorPackageImpl#getOutlineBehavior()
	 * @generated
	 */
	int OUTLINE_BEHAVIOR = 8;

	/**
	 * The feature id for the '<em><b>Container</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTLINE_BEHAVIOR__CONTAINER = BEHAVIOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Terminal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTLINE_BEHAVIOR__TERMINAL = BEHAVIOR_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Outline Behavior</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTLINE_BEHAVIOR_FEATURE_COUNT = BEHAVIOR_FEATURE_COUNT + 2;

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvt.declarative.editor.Behavior <em>Behavior</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Behavior</em>'.
	 * @see org.eclipse.qvt.declarative.editor.Behavior
	 * @generated
	 */
	EClass getBehavior();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvt.declarative.editor.EcoreNode <em>Ecore Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ecore Node</em>'.
	 * @see org.eclipse.qvt.declarative.editor.EcoreNode
	 * @generated
	 */
	EClass getEcoreNode();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvt.declarative.editor.EcoreNode#getElement <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Element</em>'.
	 * @see org.eclipse.qvt.declarative.editor.EcoreNode#getElement()
	 * @see #getEcoreNode()
	 * @generated
	 */
	EReference getEcoreNode_Element();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvt.declarative.editor.EditorDefinition <em>Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Definition</em>'.
	 * @see org.eclipse.qvt.declarative.editor.EditorDefinition
	 * @generated
	 */
	EClass getEditorDefinition();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvt.declarative.editor.EditorDefinition#getNode <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Node</em>'.
	 * @see org.eclipse.qvt.declarative.editor.EditorDefinition#getNode()
	 * @see #getEditorDefinition()
	 * @generated
	 */
	EReference getEditorDefinition_Node();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvt.declarative.editor.FoldingBehavior <em>Folding Behavior</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Folding Behavior</em>'.
	 * @see org.eclipse.qvt.declarative.editor.FoldingBehavior
	 * @generated
	 */
	EClass getFoldingBehavior();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvt.declarative.editor.JavaNode <em>Java Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Java Node</em>'.
	 * @see org.eclipse.qvt.declarative.editor.JavaNode
	 * @generated
	 */
	EClass getJavaNode();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvt.declarative.editor.JavaNode#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.qvt.declarative.editor.JavaNode#getName()
	 * @see #getJavaNode()
	 * @generated
	 */
	EAttribute getJavaNode_Name();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvt.declarative.editor.LabelBehavior <em>Label Behavior</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Label Behavior</em>'.
	 * @see org.eclipse.qvt.declarative.editor.LabelBehavior
	 * @generated
	 */
	EClass getLabelBehavior();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvt.declarative.editor.LabelBehavior#getImage <em>Image</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Image</em>'.
	 * @see org.eclipse.qvt.declarative.editor.LabelBehavior#getImage()
	 * @see #getLabelBehavior()
	 * @generated
	 */
	EAttribute getLabelBehavior_Image();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvt.declarative.editor.LabelBehavior#getFormat <em>Format</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Format</em>'.
	 * @see org.eclipse.qvt.declarative.editor.LabelBehavior#getFormat()
	 * @see #getLabelBehavior()
	 * @generated
	 */
	EAttribute getLabelBehavior_Format();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvt.declarative.editor.LabelBehavior#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Elements</em>'.
	 * @see org.eclipse.qvt.declarative.editor.LabelBehavior#getElements()
	 * @see #getLabelBehavior()
	 * @generated
	 */
	EReference getLabelBehavior_Elements();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvt.declarative.editor.LabelElement <em>Label Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Label Element</em>'.
	 * @see org.eclipse.qvt.declarative.editor.LabelElement
	 * @generated
	 */
	EClass getLabelElement();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvt.declarative.editor.LabelElement#getPath <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Path</em>'.
	 * @see org.eclipse.qvt.declarative.editor.LabelElement#getPath()
	 * @see #getLabelElement()
	 * @generated
	 */
	EReference getLabelElement_Path();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvt.declarative.editor.LabelElement#getEnd <em>End</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>End</em>'.
	 * @see org.eclipse.qvt.declarative.editor.LabelElement#getEnd()
	 * @see #getLabelElement()
	 * @generated
	 */
	EReference getLabelElement_End();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvt.declarative.editor.Node <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Node</em>'.
	 * @see org.eclipse.qvt.declarative.editor.Node
	 * @generated
	 */
	EClass getNode();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvt.declarative.editor.Node#getBehavior <em>Behavior</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Behavior</em>'.
	 * @see org.eclipse.qvt.declarative.editor.Node#getBehavior()
	 * @see #getNode()
	 * @generated
	 */
	EReference getNode_Behavior();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvt.declarative.editor.Node#getBase <em>Base</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base</em>'.
	 * @see org.eclipse.qvt.declarative.editor.Node#getBase()
	 * @see #getNode()
	 * @generated
	 */
	EReference getNode_Base();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvt.declarative.editor.OutlineBehavior <em>Outline Behavior</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Outline Behavior</em>'.
	 * @see org.eclipse.qvt.declarative.editor.OutlineBehavior
	 * @generated
	 */
	EClass getOutlineBehavior();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvt.declarative.editor.OutlineBehavior#isContainer <em>Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Container</em>'.
	 * @see org.eclipse.qvt.declarative.editor.OutlineBehavior#isContainer()
	 * @see #getOutlineBehavior()
	 * @generated
	 */
	EAttribute getOutlineBehavior_Container();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvt.declarative.editor.OutlineBehavior#isTerminal <em>Terminal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Terminal</em>'.
	 * @see org.eclipse.qvt.declarative.editor.OutlineBehavior#isTerminal()
	 * @see #getOutlineBehavior()
	 * @generated
	 */
	EAttribute getOutlineBehavior_Terminal();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	EditorFactory getEditorFactory();

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
		 * The meta object literal for the '{@link org.eclipse.qvt.declarative.editor.impl.BehaviorImpl <em>Behavior</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvt.declarative.editor.impl.BehaviorImpl
		 * @see org.eclipse.qvt.declarative.editor.impl.EditorPackageImpl#getBehavior()
		 * @generated
		 */
		EClass BEHAVIOR = eINSTANCE.getBehavior();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvt.declarative.editor.impl.EcoreNodeImpl <em>Ecore Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvt.declarative.editor.impl.EcoreNodeImpl
		 * @see org.eclipse.qvt.declarative.editor.impl.EditorPackageImpl#getEcoreNode()
		 * @generated
		 */
		EClass ECORE_NODE = eINSTANCE.getEcoreNode();

		/**
		 * The meta object literal for the '<em><b>Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ECORE_NODE__ELEMENT = eINSTANCE.getEcoreNode_Element();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvt.declarative.editor.impl.EditorDefinitionImpl <em>Definition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvt.declarative.editor.impl.EditorDefinitionImpl
		 * @see org.eclipse.qvt.declarative.editor.impl.EditorPackageImpl#getEditorDefinition()
		 * @generated
		 */
		EClass EDITOR_DEFINITION = eINSTANCE.getEditorDefinition();

		/**
		 * The meta object literal for the '<em><b>Node</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EDITOR_DEFINITION__NODE = eINSTANCE.getEditorDefinition_Node();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvt.declarative.editor.impl.FoldingBehaviorImpl <em>Folding Behavior</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvt.declarative.editor.impl.FoldingBehaviorImpl
		 * @see org.eclipse.qvt.declarative.editor.impl.EditorPackageImpl#getFoldingBehavior()
		 * @generated
		 */
		EClass FOLDING_BEHAVIOR = eINSTANCE.getFoldingBehavior();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvt.declarative.editor.impl.JavaNodeImpl <em>Java Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvt.declarative.editor.impl.JavaNodeImpl
		 * @see org.eclipse.qvt.declarative.editor.impl.EditorPackageImpl#getJavaNode()
		 * @generated
		 */
		EClass JAVA_NODE = eINSTANCE.getJavaNode();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JAVA_NODE__NAME = eINSTANCE.getJavaNode_Name();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvt.declarative.editor.impl.LabelBehaviorImpl <em>Label Behavior</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvt.declarative.editor.impl.LabelBehaviorImpl
		 * @see org.eclipse.qvt.declarative.editor.impl.EditorPackageImpl#getLabelBehavior()
		 * @generated
		 */
		EClass LABEL_BEHAVIOR = eINSTANCE.getLabelBehavior();

		/**
		 * The meta object literal for the '<em><b>Image</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LABEL_BEHAVIOR__IMAGE = eINSTANCE.getLabelBehavior_Image();

		/**
		 * The meta object literal for the '<em><b>Format</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LABEL_BEHAVIOR__FORMAT = eINSTANCE.getLabelBehavior_Format();

		/**
		 * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LABEL_BEHAVIOR__ELEMENTS = eINSTANCE.getLabelBehavior_Elements();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvt.declarative.editor.impl.LabelElementImpl <em>Label Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvt.declarative.editor.impl.LabelElementImpl
		 * @see org.eclipse.qvt.declarative.editor.impl.EditorPackageImpl#getLabelElement()
		 * @generated
		 */
		EClass LABEL_ELEMENT = eINSTANCE.getLabelElement();

		/**
		 * The meta object literal for the '<em><b>Path</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LABEL_ELEMENT__PATH = eINSTANCE.getLabelElement_Path();

		/**
		 * The meta object literal for the '<em><b>End</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LABEL_ELEMENT__END = eINSTANCE.getLabelElement_End();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvt.declarative.editor.impl.NodeImpl <em>Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvt.declarative.editor.impl.NodeImpl
		 * @see org.eclipse.qvt.declarative.editor.impl.EditorPackageImpl#getNode()
		 * @generated
		 */
		EClass NODE = eINSTANCE.getNode();

		/**
		 * The meta object literal for the '<em><b>Behavior</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE__BEHAVIOR = eINSTANCE.getNode_Behavior();

		/**
		 * The meta object literal for the '<em><b>Base</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE__BASE = eINSTANCE.getNode_Base();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvt.declarative.editor.impl.OutlineBehaviorImpl <em>Outline Behavior</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvt.declarative.editor.impl.OutlineBehaviorImpl
		 * @see org.eclipse.qvt.declarative.editor.impl.EditorPackageImpl#getOutlineBehavior()
		 * @generated
		 */
		EClass OUTLINE_BEHAVIOR = eINSTANCE.getOutlineBehavior();

		/**
		 * The meta object literal for the '<em><b>Container</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OUTLINE_BEHAVIOR__CONTAINER = eINSTANCE.getOutlineBehavior_Container();

		/**
		 * The meta object literal for the '<em><b>Terminal</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OUTLINE_BEHAVIOR__TERMINAL = eINSTANCE.getOutlineBehavior_Terminal();

	}

} //EditorPackage
