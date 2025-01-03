/**
 * Copyright (c) 2016, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.qvtd.umlx;

import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tx Typed Model Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.umlx.TxTypedModelNode#isCheck <em>Check</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.TxTypedModelNode#getDependsOns <em>Depends Ons</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.TxTypedModelNode#isEnforce <em>Enforce</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.TxTypedModelNode#getIterates <em>Iterates</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.TxTypedModelNode#getOwningTxDiagram <em>Owning Tx Diagram</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.TxTypedModelNode#getUsedTxPackageNodes <em>Used Tx Package Nodes</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.umlx.UMLXPackage#getTxTypedModelNode()
 * @generated
 */
public interface TxTypedModelNode extends TxNode, UMLXNamedElement {
	/**
	 * Returns the value of the '<em><b>Check</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Check</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Check</em>' attribute.
	 * @see #setCheck(boolean)
	 * @see org.eclipse.qvtd.umlx.UMLXPackage#getTxTypedModelNode_Check()
	 * @generated
	 */
	boolean isCheck();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.umlx.TxTypedModelNode#isCheck <em>Check</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Check</em>' attribute.
	 * @see #isCheck()
	 * @generated
	 */
	void setCheck(boolean value);

	/**
	 * Returns the value of the '<em><b>Depends Ons</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.umlx.TxTypedModelNode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Depends Ons</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Depends Ons</em>' reference list.
	 * @see org.eclipse.qvtd.umlx.UMLXPackage#getTxTypedModelNode_DependsOns()
	 * @generated
	 */
	EList<TxTypedModelNode> getDependsOns();

	/**
	 * Returns the value of the '<em><b>Enforce</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enforce</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enforce</em>' attribute.
	 * @see #setEnforce(boolean)
	 * @see org.eclipse.qvtd.umlx.UMLXPackage#getTxTypedModelNode_Enforce()
	 * @generated
	 */
	boolean isEnforce();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.umlx.TxTypedModelNode#isEnforce <em>Enforce</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enforce</em>' attribute.
	 * @see #isEnforce()
	 * @generated
	 */
	void setEnforce(boolean value);

	/**
	 * Returns the value of the '<em><b>Iterates</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.umlx.TxTypedModelNode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Iterates</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Iterates</em>' reference list.
	 * @see org.eclipse.qvtd.umlx.UMLXPackage#getTxTypedModelNode_Iterates()
	 * @generated
	 */
	EList<TxTypedModelNode> getIterates();

	/**
	 * Returns the value of the '<em><b>Owning Tx Diagram</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.umlx.TxDiagram#getOwnedTxTypedModelNodes <em>Owned Tx Typed Model Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owning Tx Diagram</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owning Tx Diagram</em>' container reference.
	 * @see #setOwningTxDiagram(TxDiagram)
	 * @see org.eclipse.qvtd.umlx.UMLXPackage#getTxTypedModelNode_OwningTxDiagram()
	 * @see org.eclipse.qvtd.umlx.TxDiagram#getOwnedTxTypedModelNodes
	 * @generated
	 */
	TxDiagram getOwningTxDiagram();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.umlx.TxTypedModelNode#getOwningTxDiagram <em>Owning Tx Diagram</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Tx Diagram</em>' container reference.
	 * @see #getOwningTxDiagram()
	 * @generated
	 */
	void setOwningTxDiagram(TxDiagram value);

	/**
	 * Returns the value of the '<em><b>Used Tx Package Nodes</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.umlx.TxPackageNode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Used Tx Package Nodes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Used Tx Package Nodes</em>' reference list.
	 * @see org.eclipse.qvtd.umlx.UMLXPackage#getTxTypedModelNode_UsedTxPackageNodes()
	 * @generated
	 */
	EList<TxPackageNode> getUsedTxPackageNodes();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	boolean validateTxPackageNodePackagesAreUnique(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	boolean validateNameIsRequired(DiagnosticChain diagnostics, Map<Object, Object> context);

} // TxTypedModelNode
