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
 * $Id: EditorFactoryImpl.java,v 1.1 2008/08/08 16:39:55 ewillink Exp $
 */
package org.eclipse.qvt.declarative.editor.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.qvt.declarative.editor.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EditorFactoryImpl extends EFactoryImpl implements EditorFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EditorFactory init() {
		try {
			EditorFactory theEditorFactory = (EditorFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/qvt/1.0/Editor"); 
			if (theEditorFactory != null) {
				return theEditorFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new EditorFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EditorFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case EditorPackage.ECORE_NODE: return createEcoreNode();
			case EditorPackage.EDITOR_DEFINITION: return createEditorDefinition();
			case EditorPackage.FOLDING_BEHAVIOR: return createFoldingBehavior();
			case EditorPackage.JAVA_NODE: return createJavaNode();
			case EditorPackage.LABEL_BEHAVIOR: return createLabelBehavior();
			case EditorPackage.LABEL_ELEMENT: return createLabelElement();
			case EditorPackage.OUTLINE_BEHAVIOR: return createOutlineBehavior();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EcoreNode createEcoreNode() {
		EcoreNodeImpl ecoreNode = new EcoreNodeImpl();
		return ecoreNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EditorDefinition createEditorDefinition() {
		EditorDefinitionImpl editorDefinition = new EditorDefinitionImpl();
		return editorDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FoldingBehavior createFoldingBehavior() {
		FoldingBehaviorImpl foldingBehavior = new FoldingBehaviorImpl();
		return foldingBehavior;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JavaNode createJavaNode() {
		JavaNodeImpl javaNode = new JavaNodeImpl();
		return javaNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LabelBehavior createLabelBehavior() {
		LabelBehaviorImpl labelBehavior = new LabelBehaviorImpl();
		return labelBehavior;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LabelElement createLabelElement() {
		LabelElementImpl labelElement = new LabelElementImpl();
		return labelElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OutlineBehavior createOutlineBehavior() {
		OutlineBehaviorImpl outlineBehavior = new OutlineBehaviorImpl();
		return outlineBehavior;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EditorPackage getEditorPackage() {
		return (EditorPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static EditorPackage getPackage() {
		return EditorPackage.eINSTANCE;
	}

} //EditorFactoryImpl
