/**
 * Copyright (c) 2015, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr;

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
 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrFactory
 * @model kind="package"
 * @generated
 */
public interface trace_ATL2QVTrPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "trace_ATL2QVTr";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://QVTd_CompileQVTrTransformation__atl2qvtr/org/eclipse/qvtd/atl/atl2qvtr/ATL2QVTr";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "PATL2QVTr";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	trace_ATL2QVTrPackage eINSTANCE = org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.trace_ATL2QVTrPackageImpl.init();



	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.CmapVariableExp_referredVariable_Helper <em>Cmap Variable Exp referred Variable Helper</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cmap Variable Exp referred Variable Helper</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.CmapVariableExp_referredVariable_Helper
	 * @generated
	 */
	EClass getCmapVariableExp_referredVariable_Helper();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.CmapVariableExp_referredVariable_VariableDeclaration <em>Cmap Variable Exp referred Variable Variable Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cmap Variable Exp referred Variable Variable Declaration</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.CmapVariableExp_referredVariable_VariableDeclaration
	 * @generated
	 */
	EClass getCmapVariableExp_referredVariable_VariableDeclaration();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapHelper <em>Dmap Helper</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dmap Helper</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapHelper
	 * @generated
	 */
	EClass getDmapHelper();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapHelper#getD3atlHelper <em>D3atl Helper</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>D3atl Helper</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapHelper#getD3atlHelper()
	 * @see #getDmapHelper()
	 * @generated
	 */
	EReference getDmapHelper_D3atlHelper();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapHelper#getD4qvtrFunction <em>D4qvtr Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>D4qvtr Function</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapHelper#getD4qvtrFunction()
	 * @see #getDmapHelper()
	 * @generated
	 */
	EReference getDmapHelper_D4qvtrFunction();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapHelper#getDomapHelper_Attribute <em>Domap Helper Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Domap Helper Attribute</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapHelper#getDomapHelper_Attribute()
	 * @see #getDmapHelper()
	 * @generated
	 */
	EReference getDmapHelper_DomapHelper_Attribute();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapHelper#getDomapHelper_Operation <em>Domap Helper Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Domap Helper Operation</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapHelper#getDomapHelper_Operation()
	 * @see #getDmapHelper()
	 * @generated
	 */
	EReference getDmapHelper_DomapHelper_Operation();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapHelper#getResult <em>Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Result</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapHelper#getResult()
	 * @see #getDmapHelper()
	 * @generated
	 */
	EReference getDmapHelper_Result();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapHelper#getS0global <em>S0global</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>S0global</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapHelper#getS0global()
	 * @see #getDmapHelper()
	 * @generated
	 */
	EAttribute getDmapHelper_S0global();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapOclExpression <em>Dmap Ocl Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dmap Ocl Expression</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapOclExpression
	 * @generated
	 */
	EClass getDmapOclExpression();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapOclExpression#getD3atlExpression <em>D3atl Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>D3atl Expression</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapOclExpression#getD3atlExpression()
	 * @see #getDmapOclExpression()
	 * @generated
	 */
	EReference getDmapOclExpression_D3atlExpression();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapOclExpression#getD4qvtrExpression <em>D4qvtr Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>D4qvtr Expression</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapOclExpression#getD4qvtrExpression()
	 * @see #getDmapOclExpression()
	 * @generated
	 */
	EReference getDmapOclExpression_D4qvtrExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapOclExpression#getDomapBooleanExp <em>Domap Boolean Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Domap Boolean Exp</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapOclExpression#getDomapBooleanExp()
	 * @see #getDmapOclExpression()
	 * @generated
	 */
	EReference getDmapOclExpression_DomapBooleanExp();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapOclExpression#getDomapIfExp <em>Domap If Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Domap If Exp</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapOclExpression#getDomapIfExp()
	 * @see #getDmapOclExpression()
	 * @generated
	 */
	EReference getDmapOclExpression_DomapIfExp();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapOclExpression#getDomapIntegerExp <em>Domap Integer Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Domap Integer Exp</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapOclExpression#getDomapIntegerExp()
	 * @see #getDmapOclExpression()
	 * @generated
	 */
	EReference getDmapOclExpression_DomapIntegerExp();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapOclExpression#getDomapNavigationOrAttributeCallExp_Helper <em>Domap Navigation Or Attribute Call Exp Helper</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Domap Navigation Or Attribute Call Exp Helper</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapOclExpression#getDomapNavigationOrAttributeCallExp_Helper()
	 * @see #getDmapOclExpression()
	 * @generated
	 */
	EReference getDmapOclExpression_DomapNavigationOrAttributeCallExp_Helper();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapOclExpression#getDomapNavigationOrAttributeCallExp_Property <em>Domap Navigation Or Attribute Call Exp Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Domap Navigation Or Attribute Call Exp Property</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapOclExpression#getDomapNavigationOrAttributeCallExp_Property()
	 * @see #getDmapOclExpression()
	 * @generated
	 */
	EReference getDmapOclExpression_DomapNavigationOrAttributeCallExp_Property();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapOclExpression#getDomapOclType <em>Domap Ocl Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Domap Ocl Type</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapOclExpression#getDomapOclType()
	 * @see #getDmapOclExpression()
	 * @generated
	 */
	EReference getDmapOclExpression_DomapOclType();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapOclExpression#getDomapOperationCallExp_Helper <em>Domap Operation Call Exp Helper</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Domap Operation Call Exp Helper</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapOclExpression#getDomapOperationCallExp_Helper()
	 * @see #getDmapOclExpression()
	 * @generated
	 */
	EReference getDmapOclExpression_DomapOperationCallExp_Helper();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapOclExpression#getDomapOperationCallExp_Operation <em>Domap Operation Call Exp Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Domap Operation Call Exp Operation</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapOclExpression#getDomapOperationCallExp_Operation()
	 * @see #getDmapOclExpression()
	 * @generated
	 */
	EReference getDmapOclExpression_DomapOperationCallExp_Operation();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapOclExpression#getDomapOperatorCallExp <em>Domap Operator Call Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Domap Operator Call Exp</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapOclExpression#getDomapOperatorCallExp()
	 * @see #getDmapOclExpression()
	 * @generated
	 */
	EReference getDmapOclExpression_DomapOperatorCallExp();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapOclExpression#getDomapStringExp <em>Domap String Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Domap String Exp</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapOclExpression#getDomapStringExp()
	 * @see #getDmapOclExpression()
	 * @generated
	 */
	EReference getDmapOclExpression_DomapStringExp();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapOclExpression#getDomapVariableExp <em>Domap Variable Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Domap Variable Exp</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapOclExpression#getDomapVariableExp()
	 * @see #getDmapOclExpression()
	 * @generated
	 */
	EReference getDmapOclExpression_DomapVariableExp();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapOclExpression#getResult <em>Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Result</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapOclExpression#getResult()
	 * @see #getDmapOclExpression()
	 * @generated
	 */
	EReference getDmapOclExpression_Result();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapOclExpression#getS0global <em>S0global</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>S0global</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapOclExpression#getS0global()
	 * @see #getDmapOclExpression()
	 * @generated
	 */
	EAttribute getDmapOclExpression_S0global();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapVariableExp_referredVariable <em>Dmap Variable Exp referred Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dmap Variable Exp referred Variable</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapVariableExp_referredVariable
	 * @generated
	 */
	EClass getDmapVariableExp_referredVariable();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapVariableExp_referredVariable#getD3atlExpression <em>D3atl Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>D3atl Expression</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapVariableExp_referredVariable#getD3atlExpression()
	 * @see #getDmapVariableExp_referredVariable()
	 * @generated
	 */
	EReference getDmapVariableExp_referredVariable_D3atlExpression();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapVariableExp_referredVariable#getD4qvtrExpression <em>D4qvtr Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>D4qvtr Expression</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapVariableExp_referredVariable#getD4qvtrExpression()
	 * @see #getDmapVariableExp_referredVariable()
	 * @generated
	 */
	EReference getDmapVariableExp_referredVariable_D4qvtrExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapVariableExp_referredVariable#getDomapVariableExp_referredVariable_Helper <em>Domap Variable Exp referred Variable Helper</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Domap Variable Exp referred Variable Helper</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapVariableExp_referredVariable#getDomapVariableExp_referredVariable_Helper()
	 * @see #getDmapVariableExp_referredVariable()
	 * @generated
	 */
	EReference getDmapVariableExp_referredVariable_DomapVariableExp_referredVariable_Helper();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapVariableExp_referredVariable#getDomapVariableExp_referredVariable_VariableDeclaration <em>Domap Variable Exp referred Variable Variable Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Domap Variable Exp referred Variable Variable Declaration</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapVariableExp_referredVariable#getDomapVariableExp_referredVariable_VariableDeclaration()
	 * @see #getDmapVariableExp_referredVariable()
	 * @generated
	 */
	EReference getDmapVariableExp_referredVariable_DomapVariableExp_referredVariable_VariableDeclaration();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapVariableExp_referredVariable#getResult <em>Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Result</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapVariableExp_referredVariable#getResult()
	 * @see #getDmapVariableExp_referredVariable()
	 * @generated
	 */
	EReference getDmapVariableExp_referredVariable_Result();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapVariableExp_referredVariable#getS0global <em>S0global</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>S0global</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapVariableExp_referredVariable#getS0global()
	 * @see #getDmapVariableExp_referredVariable()
	 * @generated
	 */
	EAttribute getDmapVariableExp_referredVariable_S0global();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.ImapHelper <em>Imap Helper</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Imap Helper</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.ImapHelper
	 * @generated
	 */
	EClass getImapHelper();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.ImapHelper#getS0global <em>S0global</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>S0global</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.ImapHelper#getS0global()
	 * @see #getImapHelper()
	 * @generated
	 */
	EAttribute getImapHelper_S0global();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.ImapOclExpression <em>Imap Ocl Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Imap Ocl Expression</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.ImapOclExpression
	 * @generated
	 */
	EClass getImapOclExpression();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.ImapOclExpression#getS0global <em>S0global</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>S0global</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.ImapOclExpression#getS0global()
	 * @see #getImapOclExpression()
	 * @generated
	 */
	EAttribute getImapOclExpression_S0global();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.ImapVariableExp_referredVariable <em>Imap Variable Exp referred Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Imap Variable Exp referred Variable</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.ImapVariableExp_referredVariable
	 * @generated
	 */
	EClass getImapVariableExp_referredVariable();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.ImapVariableExp_referredVariable#getS0global <em>S0global</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>S0global</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.ImapVariableExp_referredVariable#getS0global()
	 * @see #getImapVariableExp_referredVariable()
	 * @generated
	 */
	EAttribute getImapVariableExp_referredVariable_S0global();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapBinding <em>Tmap Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tmap Binding</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapBinding
	 * @generated
	 */
	EClass getTmapBinding();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapBinding#getS0global <em>S0global</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>S0global</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapBinding#getS0global()
	 * @see #getTmapBinding()
	 * @generated
	 */
	EAttribute getTmapBinding_S0global();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapBinding#getT1propertyName <em>T1property Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>T1property Name</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapBinding#getT1propertyName()
	 * @see #getTmapBinding()
	 * @generated
	 */
	EAttribute getTmapBinding_T1propertyName();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapBinding#getT3atlBinding <em>T3atl Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T3atl Binding</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapBinding#getT3atlBinding()
	 * @see #getTmapBinding()
	 * @generated
	 */
	EReference getTmapBinding_T3atlBinding();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapBinding#getT3atlExpression <em>T3atl Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T3atl Expression</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapBinding#getT3atlExpression()
	 * @see #getTmapBinding()
	 * @generated
	 */
	EReference getTmapBinding_T3atlExpression();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapBinding#getT3atlOutPatternElement <em>T3atl Out Pattern Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T3atl Out Pattern Element</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapBinding#getT3atlOutPatternElement()
	 * @see #getTmapBinding()
	 * @generated
	 */
	EReference getTmapBinding_T3atlOutPatternElement();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapBinding#getT4qvtrExpression <em>T4qvtr Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T4qvtr Expression</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapBinding#getT4qvtrExpression()
	 * @see #getTmapBinding()
	 * @generated
	 */
	EReference getTmapBinding_T4qvtrExpression();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapBinding#getT4qvtrPart <em>T4qvtr Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T4qvtr Part</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapBinding#getT4qvtrPart()
	 * @see #getTmapBinding()
	 * @generated
	 */
	EReference getTmapBinding_T4qvtrPart();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapBinding#getT4qvtrTemplate <em>T4qvtr Template</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T4qvtr Template</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapBinding#getT4qvtrTemplate()
	 * @see #getTmapBinding()
	 * @generated
	 */
	EReference getTmapBinding_T4qvtrTemplate();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapBinding#getWmapOclExpression <em>Wmap Ocl Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Wmap Ocl Expression</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapBinding#getWmapOclExpression()
	 * @see #getTmapBinding()
	 * @generated
	 */
	EReference getTmapBinding_WmapOclExpression();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapBinding#getWmapSimpleOutPatternElement <em>Wmap Simple Out Pattern Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Wmap Simple Out Pattern Element</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapBinding#getWmapSimpleOutPatternElement()
	 * @see #getTmapBinding()
	 * @generated
	 */
	EReference getTmapBinding_WmapSimpleOutPatternElement();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapBooleanExp <em>Tmap Boolean Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tmap Boolean Exp</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapBooleanExp
	 * @generated
	 */
	EClass getTmapBooleanExp();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapBooleanExp#getDispatcher <em>Dispatcher</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Dispatcher</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapBooleanExp#getDispatcher()
	 * @see #getTmapBooleanExp()
	 * @generated
	 */
	EReference getTmapBooleanExp_Dispatcher();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapBooleanExp#isT1symbol <em>T1symbol</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>T1symbol</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapBooleanExp#isT1symbol()
	 * @see #getTmapBooleanExp()
	 * @generated
	 */
	EAttribute getTmapBooleanExp_T1symbol();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Attribute <em>Tmap Helper Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tmap Helper Attribute</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Attribute
	 * @generated
	 */
	EClass getTmapHelper_Attribute();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Attribute#getDispatcher <em>Dispatcher</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Dispatcher</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Attribute#getDispatcher()
	 * @see #getTmapHelper_Attribute()
	 * @generated
	 */
	EReference getTmapHelper_Attribute_Dispatcher();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Attribute#getT1attributeName <em>T1attribute Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>T1attribute Name</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Attribute#getT1attributeName()
	 * @see #getTmapHelper_Attribute()
	 * @generated
	 */
	EAttribute getTmapHelper_Attribute_T1attributeName();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Attribute#getT3atlDefinition <em>T3atl Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T3atl Definition</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Attribute#getT3atlDefinition()
	 * @see #getTmapHelper_Attribute()
	 * @generated
	 */
	EReference getTmapHelper_Attribute_T3atlDefinition();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Attribute#getT3atlExpression <em>T3atl Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T3atl Expression</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Attribute#getT3atlExpression()
	 * @see #getTmapHelper_Attribute()
	 * @generated
	 */
	EReference getTmapHelper_Attribute_T3atlExpression();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Attribute#getT3atlFeature <em>T3atl Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T3atl Feature</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Attribute#getT3atlFeature()
	 * @see #getTmapHelper_Attribute()
	 * @generated
	 */
	EReference getTmapHelper_Attribute_T3atlFeature();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Attribute#getT3atlModule <em>T3atl Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T3atl Module</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Attribute#getT3atlModule()
	 * @see #getTmapHelper_Attribute()
	 * @generated
	 */
	EReference getTmapHelper_Attribute_T3atlModule();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Attribute#getT3atlType <em>T3atl Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T3atl Type</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Attribute#getT3atlType()
	 * @see #getTmapHelper_Attribute()
	 * @generated
	 */
	EReference getTmapHelper_Attribute_T3atlType();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Attribute#getT4qvtrExpression <em>T4qvtr Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T4qvtr Expression</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Attribute#getT4qvtrExpression()
	 * @see #getTmapHelper_Attribute()
	 * @generated
	 */
	EReference getTmapHelper_Attribute_T4qvtrExpression();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Attribute#getT4qvtrTransformation <em>T4qvtr Transformation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T4qvtr Transformation</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Attribute#getT4qvtrTransformation()
	 * @see #getTmapHelper_Attribute()
	 * @generated
	 */
	EReference getTmapHelper_Attribute_T4qvtrTransformation();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Attribute#getWmapHelper_Context <em>Wmap Helper Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Wmap Helper Context</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Attribute#getWmapHelper_Context()
	 * @see #getTmapHelper_Attribute()
	 * @generated
	 */
	EReference getTmapHelper_Attribute_WmapHelper_Context();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Attribute#getWmapModule <em>Wmap Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Wmap Module</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Attribute#getWmapModule()
	 * @see #getTmapHelper_Attribute()
	 * @generated
	 */
	EReference getTmapHelper_Attribute_WmapModule();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Attribute#getWmapOclExpression <em>Wmap Ocl Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Wmap Ocl Expression</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Attribute#getWmapOclExpression()
	 * @see #getTmapHelper_Attribute()
	 * @generated
	 */
	EReference getTmapHelper_Attribute_WmapOclExpression();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Attribute#getS0local <em>S0local</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>S0local</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Attribute#getS0local()
	 * @see #getTmapHelper_Attribute()
	 * @generated
	 */
	EAttribute getTmapHelper_Attribute_S0local();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Context <em>Tmap Helper Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tmap Helper Context</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Context
	 * @generated
	 */
	EClass getTmapHelper_Context();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Context#getS0global <em>S0global</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>S0global</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Context#getS0global()
	 * @see #getTmapHelper_Context()
	 * @generated
	 */
	EAttribute getTmapHelper_Context_S0global();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Context#getT3atlContext <em>T3atl Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T3atl Context</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Context#getT3atlContext()
	 * @see #getTmapHelper_Context()
	 * @generated
	 */
	EReference getTmapHelper_Context_T3atlContext();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Context#getT3atlDefinition <em>T3atl Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T3atl Definition</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Context#getT3atlDefinition()
	 * @see #getTmapHelper_Context()
	 * @generated
	 */
	EReference getTmapHelper_Context_T3atlDefinition();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Context#getT3atlHelper <em>T3atl Helper</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T3atl Helper</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Context#getT3atlHelper()
	 * @see #getTmapHelper_Context()
	 * @generated
	 */
	EReference getTmapHelper_Context_T3atlHelper();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Context#getT3atlReturnType <em>T3atl Return Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T3atl Return Type</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Context#getT3atlReturnType()
	 * @see #getTmapHelper_Context()
	 * @generated
	 */
	EReference getTmapHelper_Context_T3atlReturnType();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Context#getT4qvtrFunction <em>T4qvtr Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T4qvtr Function</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Context#getT4qvtrFunction()
	 * @see #getTmapHelper_Context()
	 * @generated
	 */
	EReference getTmapHelper_Context_T4qvtrFunction();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Context#getT4qvtrParameter <em>T4qvtr Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T4qvtr Parameter</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Context#getT4qvtrParameter()
	 * @see #getTmapHelper_Context()
	 * @generated
	 */
	EReference getTmapHelper_Context_T4qvtrParameter();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Context#getWmapVariable <em>Wmap Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Wmap Variable</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Context#getWmapVariable()
	 * @see #getTmapHelper_Context()
	 * @generated
	 */
	EReference getTmapHelper_Context_WmapVariable();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Operation <em>Tmap Helper Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tmap Helper Operation</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Operation
	 * @generated
	 */
	EClass getTmapHelper_Operation();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Operation#getDispatcher <em>Dispatcher</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Dispatcher</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Operation#getDispatcher()
	 * @see #getTmapHelper_Operation()
	 * @generated
	 */
	EReference getTmapHelper_Operation_Dispatcher();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Operation#getT1operationName <em>T1operation Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>T1operation Name</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Operation#getT1operationName()
	 * @see #getTmapHelper_Operation()
	 * @generated
	 */
	EAttribute getTmapHelper_Operation_T1operationName();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Operation#getT3atlDefinition <em>T3atl Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T3atl Definition</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Operation#getT3atlDefinition()
	 * @see #getTmapHelper_Operation()
	 * @generated
	 */
	EReference getTmapHelper_Operation_T3atlDefinition();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Operation#getT3atlExpression <em>T3atl Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T3atl Expression</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Operation#getT3atlExpression()
	 * @see #getTmapHelper_Operation()
	 * @generated
	 */
	EReference getTmapHelper_Operation_T3atlExpression();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Operation#getT3atlFeature <em>T3atl Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T3atl Feature</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Operation#getT3atlFeature()
	 * @see #getTmapHelper_Operation()
	 * @generated
	 */
	EReference getTmapHelper_Operation_T3atlFeature();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Operation#getT3atlModule <em>T3atl Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T3atl Module</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Operation#getT3atlModule()
	 * @see #getTmapHelper_Operation()
	 * @generated
	 */
	EReference getTmapHelper_Operation_T3atlModule();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Operation#getT3atlType <em>T3atl Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T3atl Type</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Operation#getT3atlType()
	 * @see #getTmapHelper_Operation()
	 * @generated
	 */
	EReference getTmapHelper_Operation_T3atlType();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Operation#getT4qvtrExpression <em>T4qvtr Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T4qvtr Expression</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Operation#getT4qvtrExpression()
	 * @see #getTmapHelper_Operation()
	 * @generated
	 */
	EReference getTmapHelper_Operation_T4qvtrExpression();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Operation#getT4qvtrTransformation <em>T4qvtr Transformation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T4qvtr Transformation</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Operation#getT4qvtrTransformation()
	 * @see #getTmapHelper_Operation()
	 * @generated
	 */
	EReference getTmapHelper_Operation_T4qvtrTransformation();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Operation#getWmapHelper_Context <em>Wmap Helper Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Wmap Helper Context</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Operation#getWmapHelper_Context()
	 * @see #getTmapHelper_Operation()
	 * @generated
	 */
	EReference getTmapHelper_Operation_WmapHelper_Context();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Operation#getWmapModule <em>Wmap Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Wmap Module</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Operation#getWmapModule()
	 * @see #getTmapHelper_Operation()
	 * @generated
	 */
	EReference getTmapHelper_Operation_WmapModule();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Operation#getWmapOclExpression <em>Wmap Ocl Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Wmap Ocl Expression</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Operation#getWmapOclExpression()
	 * @see #getTmapHelper_Operation()
	 * @generated
	 */
	EReference getTmapHelper_Operation_WmapOclExpression();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Operation#getS0local <em>S0local</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>S0local</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Operation#getS0local()
	 * @see #getTmapHelper_Operation()
	 * @generated
	 */
	EAttribute getTmapHelper_Operation_S0local();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapIfExp <em>Tmap If Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tmap If Exp</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapIfExp
	 * @generated
	 */
	EClass getTmapIfExp();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapIfExp#getDispatcher <em>Dispatcher</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Dispatcher</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapIfExp#getDispatcher()
	 * @see #getTmapIfExp()
	 * @generated
	 */
	EReference getTmapIfExp_Dispatcher();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapIfExp#getT3atlCondition <em>T3atl Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T3atl Condition</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapIfExp#getT3atlCondition()
	 * @see #getTmapIfExp()
	 * @generated
	 */
	EReference getTmapIfExp_T3atlCondition();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapIfExp#getT3atlElse <em>T3atl Else</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T3atl Else</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapIfExp#getT3atlElse()
	 * @see #getTmapIfExp()
	 * @generated
	 */
	EReference getTmapIfExp_T3atlElse();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapIfExp#getT3atlThen <em>T3atl Then</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T3atl Then</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapIfExp#getT3atlThen()
	 * @see #getTmapIfExp()
	 * @generated
	 */
	EReference getTmapIfExp_T3atlThen();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapIfExp#getT4qvtrCondition <em>T4qvtr Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T4qvtr Condition</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapIfExp#getT4qvtrCondition()
	 * @see #getTmapIfExp()
	 * @generated
	 */
	EReference getTmapIfExp_T4qvtrCondition();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapIfExp#getT4qvtrElse <em>T4qvtr Else</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T4qvtr Else</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapIfExp#getT4qvtrElse()
	 * @see #getTmapIfExp()
	 * @generated
	 */
	EReference getTmapIfExp_T4qvtrElse();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapIfExp#getT4qvtrThen <em>T4qvtr Then</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T4qvtr Then</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapIfExp#getT4qvtrThen()
	 * @see #getTmapIfExp()
	 * @generated
	 */
	EReference getTmapIfExp_T4qvtrThen();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapIfExp#getWmapOclExpression <em>Wmap Ocl Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Wmap Ocl Expression</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapIfExp#getWmapOclExpression()
	 * @see #getTmapIfExp()
	 * @generated
	 */
	EReference getTmapIfExp_WmapOclExpression();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapIfExp#getWmapOclExpression1 <em>Wmap Ocl Expression1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Wmap Ocl Expression1</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapIfExp#getWmapOclExpression1()
	 * @see #getTmapIfExp()
	 * @generated
	 */
	EReference getTmapIfExp_WmapOclExpression1();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapIfExp#getWmapOclExpression2 <em>Wmap Ocl Expression2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Wmap Ocl Expression2</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapIfExp#getWmapOclExpression2()
	 * @see #getTmapIfExp()
	 * @generated
	 */
	EReference getTmapIfExp_WmapOclExpression2();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapIfExp#getS0local <em>S0local</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>S0local</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapIfExp#getS0local()
	 * @see #getTmapIfExp()
	 * @generated
	 */
	EAttribute getTmapIfExp_S0local();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapInPattern <em>Tmap In Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tmap In Pattern</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapInPattern
	 * @generated
	 */
	EClass getTmapInPattern();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapInPattern#getS0global <em>S0global</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>S0global</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapInPattern#getS0global()
	 * @see #getTmapInPattern()
	 * @generated
	 */
	EAttribute getTmapInPattern_S0global();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapInPattern#getT3atlModel <em>T3atl Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T3atl Model</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapInPattern#getT3atlModel()
	 * @see #getTmapInPattern()
	 * @generated
	 */
	EReference getTmapInPattern_T3atlModel();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapInPattern#getT3atlPattern <em>T3atl Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T3atl Pattern</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapInPattern#getT3atlPattern()
	 * @see #getTmapInPattern()
	 * @generated
	 */
	EReference getTmapInPattern_T3atlPattern();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapInPattern#getT3atlRule <em>T3atl Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T3atl Rule</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapInPattern#getT3atlRule()
	 * @see #getTmapInPattern()
	 * @generated
	 */
	EReference getTmapInPattern_T3atlRule();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapInPattern#getT4qvtrDomain <em>T4qvtr Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T4qvtr Domain</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapInPattern#getT4qvtrDomain()
	 * @see #getTmapInPattern()
	 * @generated
	 */
	EReference getTmapInPattern_T4qvtrDomain();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapInPattern#getT4qvtrRelation <em>T4qvtr Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T4qvtr Relation</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapInPattern#getT4qvtrRelation()
	 * @see #getTmapInPattern()
	 * @generated
	 */
	EReference getTmapInPattern_T4qvtrRelation();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapInPattern#getT4qvtrTypedModel <em>T4qvtr Typed Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T4qvtr Typed Model</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapInPattern#getT4qvtrTypedModel()
	 * @see #getTmapInPattern()
	 * @generated
	 */
	EReference getTmapInPattern_T4qvtrTypedModel();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapInPattern#getWmapMatchedRule <em>Wmap Matched Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Wmap Matched Rule</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapInPattern#getWmapMatchedRule()
	 * @see #getTmapInPattern()
	 * @generated
	 */
	EReference getTmapInPattern_WmapMatchedRule();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapInPattern#getWmapOclMetamodel <em>Wmap Ocl Metamodel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Wmap Ocl Metamodel</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapInPattern#getWmapOclMetamodel()
	 * @see #getTmapInPattern()
	 * @generated
	 */
	EReference getTmapInPattern_WmapOclMetamodel();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapInPattern_filter <em>Tmap In Pattern filter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tmap In Pattern filter</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapInPattern_filter
	 * @generated
	 */
	EClass getTmapInPattern_filter();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapInPattern_filter#getS0global <em>S0global</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>S0global</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapInPattern_filter#getS0global()
	 * @see #getTmapInPattern_filter()
	 * @generated
	 */
	EAttribute getTmapInPattern_filter_S0global();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapInPattern_filter#getT3atlExpression <em>T3atl Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T3atl Expression</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapInPattern_filter#getT3atlExpression()
	 * @see #getTmapInPattern_filter()
	 * @generated
	 */
	EReference getTmapInPattern_filter_T3atlExpression();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapInPattern_filter#getT3atlPattern <em>T3atl Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T3atl Pattern</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapInPattern_filter#getT3atlPattern()
	 * @see #getTmapInPattern_filter()
	 * @generated
	 */
	EReference getTmapInPattern_filter_T3atlPattern();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapInPattern_filter#getT3atlRule <em>T3atl Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T3atl Rule</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapInPattern_filter#getT3atlRule()
	 * @see #getTmapInPattern_filter()
	 * @generated
	 */
	EReference getTmapInPattern_filter_T3atlRule();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapInPattern_filter#getT4p <em>T4p</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T4p</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapInPattern_filter#getT4p()
	 * @see #getTmapInPattern_filter()
	 * @generated
	 */
	EReference getTmapInPattern_filter_T4p();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapInPattern_filter#getT4qvtrDomain <em>T4qvtr Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T4qvtr Domain</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapInPattern_filter#getT4qvtrDomain()
	 * @see #getTmapInPattern_filter()
	 * @generated
	 */
	EReference getTmapInPattern_filter_T4qvtrDomain();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapInPattern_filter#getT4qvtrExpression <em>T4qvtr Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T4qvtr Expression</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapInPattern_filter#getT4qvtrExpression()
	 * @see #getTmapInPattern_filter()
	 * @generated
	 */
	EReference getTmapInPattern_filter_T4qvtrExpression();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapInPattern_filter#getT4qvtrRelation <em>T4qvtr Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T4qvtr Relation</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapInPattern_filter#getT4qvtrRelation()
	 * @see #getTmapInPattern_filter()
	 * @generated
	 */
	EReference getTmapInPattern_filter_T4qvtrRelation();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapInPattern_filter#getT4w <em>T4w</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T4w</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapInPattern_filter#getT4w()
	 * @see #getTmapInPattern_filter()
	 * @generated
	 */
	EReference getTmapInPattern_filter_T4w();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapInPattern_filter#getWmapInPattern <em>Wmap In Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Wmap In Pattern</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapInPattern_filter#getWmapInPattern()
	 * @see #getTmapInPattern_filter()
	 * @generated
	 */
	EReference getTmapInPattern_filter_WmapInPattern();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapInPattern_filter#getWmapMatchedRule <em>Wmap Matched Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Wmap Matched Rule</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapInPattern_filter#getWmapMatchedRule()
	 * @see #getTmapInPattern_filter()
	 * @generated
	 */
	EReference getTmapInPattern_filter_WmapMatchedRule();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapInPattern_filter#getWmapOclExpression <em>Wmap Ocl Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Wmap Ocl Expression</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapInPattern_filter#getWmapOclExpression()
	 * @see #getTmapInPattern_filter()
	 * @generated
	 */
	EReference getTmapInPattern_filter_WmapOclExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapIntegerExp <em>Tmap Integer Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tmap Integer Exp</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapIntegerExp
	 * @generated
	 */
	EClass getTmapIntegerExp();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapIntegerExp#getDispatcher <em>Dispatcher</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Dispatcher</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapIntegerExp#getDispatcher()
	 * @see #getTmapIntegerExp()
	 * @generated
	 */
	EReference getTmapIntegerExp_Dispatcher();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapIntegerExp#getT1symbol <em>T1symbol</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>T1symbol</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapIntegerExp#getT1symbol()
	 * @see #getTmapIntegerExp()
	 * @generated
	 */
	EAttribute getTmapIntegerExp_T1symbol();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapMatchedRule <em>Tmap Matched Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tmap Matched Rule</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapMatchedRule
	 * @generated
	 */
	EClass getTmapMatchedRule();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapMatchedRule#getS0global <em>S0global</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>S0global</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapMatchedRule#getS0global()
	 * @see #getTmapMatchedRule()
	 * @generated
	 */
	EAttribute getTmapMatchedRule_S0global();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapMatchedRule#getT1ruleName <em>T1rule Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>T1rule Name</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapMatchedRule#getT1ruleName()
	 * @see #getTmapMatchedRule()
	 * @generated
	 */
	EAttribute getTmapMatchedRule_T1ruleName();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapMatchedRule#getT3atlModule <em>T3atl Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T3atl Module</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapMatchedRule#getT3atlModule()
	 * @see #getTmapMatchedRule()
	 * @generated
	 */
	EReference getTmapMatchedRule_T3atlModule();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapMatchedRule#getT3atlOutPattern <em>T3atl Out Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T3atl Out Pattern</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapMatchedRule#getT3atlOutPattern()
	 * @see #getTmapMatchedRule()
	 * @generated
	 */
	EReference getTmapMatchedRule_T3atlOutPattern();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapMatchedRule#getT3matchedRule <em>T3matched Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T3matched Rule</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapMatchedRule#getT3matchedRule()
	 * @see #getTmapMatchedRule()
	 * @generated
	 */
	EReference getTmapMatchedRule_T3matchedRule();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapMatchedRule#getT4_6 <em>T4 6</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T4 6</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapMatchedRule#getT4_6()
	 * @see #getTmapMatchedRule()
	 * @generated
	 */
	EReference getTmapMatchedRule_T4_6();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapMatchedRule#getT4qvtrRelation <em>T4qvtr Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T4qvtr Relation</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapMatchedRule#getT4qvtrRelation()
	 * @see #getTmapMatchedRule()
	 * @generated
	 */
	EReference getTmapMatchedRule_T4qvtrRelation();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapMatchedRule#getT4qvtrTransformation <em>T4qvtr Transformation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T4qvtr Transformation</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapMatchedRule#getT4qvtrTransformation()
	 * @see #getTmapMatchedRule()
	 * @generated
	 */
	EReference getTmapMatchedRule_T4qvtrTransformation();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapMatchedRule#getWmapModule <em>Wmap Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Wmap Module</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapMatchedRule#getWmapModule()
	 * @see #getTmapMatchedRule()
	 * @generated
	 */
	EReference getTmapMatchedRule_WmapModule();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapMatchedRule_super <em>Tmap Matched Rule super</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tmap Matched Rule super</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapMatchedRule_super
	 * @generated
	 */
	EClass getTmapMatchedRule_super();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapMatchedRule_super#getS0global <em>S0global</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>S0global</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapMatchedRule_super#getS0global()
	 * @see #getTmapMatchedRule_super()
	 * @generated
	 */
	EAttribute getTmapMatchedRule_super_S0global();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapMatchedRule_super#getT3atlChildRule <em>T3atl Child Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T3atl Child Rule</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapMatchedRule_super#getT3atlChildRule()
	 * @see #getTmapMatchedRule_super()
	 * @generated
	 */
	EReference getTmapMatchedRule_super_T3atlChildRule();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapMatchedRule_super#getT3atlSuperRule <em>T3atl Super Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T3atl Super Rule</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapMatchedRule_super#getT3atlSuperRule()
	 * @see #getTmapMatchedRule_super()
	 * @generated
	 */
	EReference getTmapMatchedRule_super_T3atlSuperRule();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapMatchedRule_super#getT4qvtrOverriddenRelation <em>T4qvtr Overridden Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T4qvtr Overridden Relation</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapMatchedRule_super#getT4qvtrOverriddenRelation()
	 * @see #getTmapMatchedRule_super()
	 * @generated
	 */
	EReference getTmapMatchedRule_super_T4qvtrOverriddenRelation();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapMatchedRule_super#getT4qvtrOverridesRelation <em>T4qvtr Overrides Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T4qvtr Overrides Relation</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapMatchedRule_super#getT4qvtrOverridesRelation()
	 * @see #getTmapMatchedRule_super()
	 * @generated
	 */
	EReference getTmapMatchedRule_super_T4qvtrOverridesRelation();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapMatchedRule_super#getWmapMatchedRule <em>Wmap Matched Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Wmap Matched Rule</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapMatchedRule_super#getWmapMatchedRule()
	 * @see #getTmapMatchedRule_super()
	 * @generated
	 */
	EReference getTmapMatchedRule_super_WmapMatchedRule();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapMatchedRule_super#getWmapMatchedRule1 <em>Wmap Matched Rule1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Wmap Matched Rule1</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapMatchedRule_super#getWmapMatchedRule1()
	 * @see #getTmapMatchedRule_super()
	 * @generated
	 */
	EReference getTmapMatchedRule_super_WmapMatchedRule1();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapModule <em>Tmap Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tmap Module</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapModule
	 * @generated
	 */
	EClass getTmapModule();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapModule#getS0global <em>S0global</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>S0global</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapModule#getS0global()
	 * @see #getTmapModule()
	 * @generated
	 */
	EAttribute getTmapModule_S0global();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapModule#getT1txName <em>T1tx Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>T1tx Name</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapModule#getT1txName()
	 * @see #getTmapModule()
	 * @generated
	 */
	EAttribute getTmapModule_T1txName();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapModule#getT3atlModule <em>T3atl Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T3atl Module</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapModule#getT3atlModule()
	 * @see #getTmapModule()
	 * @generated
	 */
	EReference getTmapModule_T3atlModule();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapModule#getT4_3 <em>T4 3</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T4 3</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapModule#getT4_3()
	 * @see #getTmapModule()
	 * @generated
	 */
	EReference getTmapModule_T4_3();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapModule#getT4_4 <em>T4 4</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T4 4</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapModule#getT4_4()
	 * @see #getTmapModule()
	 * @generated
	 */
	EReference getTmapModule_T4_4();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapModule#getT4_5 <em>T4 5</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T4 5</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapModule#getT4_5()
	 * @see #getTmapModule()
	 * @generated
	 */
	EReference getTmapModule_T4_5();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapModule#getT4_6 <em>T4 6</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T4 6</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapModule#getT4_6()
	 * @see #getTmapModule()
	 * @generated
	 */
	EReference getTmapModule_T4_6();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapModule#getT4qvtrTransformation <em>T4qvtr Transformation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T4qvtr Transformation</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapModule#getT4qvtrTransformation()
	 * @see #getTmapModule()
	 * @generated
	 */
	EReference getTmapModule_T4qvtrTransformation();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapNavigationOrAttributeCallExp_Helper <em>Tmap Navigation Or Attribute Call Exp Helper</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tmap Navigation Or Attribute Call Exp Helper</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapNavigationOrAttributeCallExp_Helper
	 * @generated
	 */
	EClass getTmapNavigationOrAttributeCallExp_Helper();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapNavigationOrAttributeCallExp_Helper#getDispatcher <em>Dispatcher</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Dispatcher</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapNavigationOrAttributeCallExp_Helper#getDispatcher()
	 * @see #getTmapNavigationOrAttributeCallExp_Helper()
	 * @generated
	 */
	EReference getTmapNavigationOrAttributeCallExp_Helper_Dispatcher();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapNavigationOrAttributeCallExp_Helper#getT1propertyName <em>T1property Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>T1property Name</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapNavigationOrAttributeCallExp_Helper#getT1propertyName()
	 * @see #getTmapNavigationOrAttributeCallExp_Helper()
	 * @generated
	 */
	EAttribute getTmapNavigationOrAttributeCallExp_Helper_T1propertyName();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapNavigationOrAttributeCallExp_Helper#getT3atlAttributes <em>T3atl Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>T3atl Attributes</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapNavigationOrAttributeCallExp_Helper#getT3atlAttributes()
	 * @see #getTmapNavigationOrAttributeCallExp_Helper()
	 * @generated
	 */
	EReference getTmapNavigationOrAttributeCallExp_Helper_T3atlAttributes();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapNavigationOrAttributeCallExp_Helper#getT3atlModule <em>T3atl Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T3atl Module</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapNavigationOrAttributeCallExp_Helper#getT3atlModule()
	 * @see #getTmapNavigationOrAttributeCallExp_Helper()
	 * @generated
	 */
	EReference getTmapNavigationOrAttributeCallExp_Helper_T3atlModule();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapNavigationOrAttributeCallExp_Helper#getT3atlSource <em>T3atl Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T3atl Source</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapNavigationOrAttributeCallExp_Helper#getT3atlSource()
	 * @see #getTmapNavigationOrAttributeCallExp_Helper()
	 * @generated
	 */
	EReference getTmapNavigationOrAttributeCallExp_Helper_T3atlSource();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapNavigationOrAttributeCallExp_Helper#getT4qvtrOperation <em>T4qvtr Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T4qvtr Operation</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapNavigationOrAttributeCallExp_Helper#getT4qvtrOperation()
	 * @see #getTmapNavigationOrAttributeCallExp_Helper()
	 * @generated
	 */
	EReference getTmapNavigationOrAttributeCallExp_Helper_T4qvtrOperation();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapNavigationOrAttributeCallExp_Helper#getT4qvtrSource <em>T4qvtr Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T4qvtr Source</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapNavigationOrAttributeCallExp_Helper#getT4qvtrSource()
	 * @see #getTmapNavigationOrAttributeCallExp_Helper()
	 * @generated
	 */
	EReference getTmapNavigationOrAttributeCallExp_Helper_T4qvtrSource();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapNavigationOrAttributeCallExp_Helper#getT4qvtrSourceArgument <em>T4qvtr Source Argument</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T4qvtr Source Argument</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapNavigationOrAttributeCallExp_Helper#getT4qvtrSourceArgument()
	 * @see #getTmapNavigationOrAttributeCallExp_Helper()
	 * @generated
	 */
	EReference getTmapNavigationOrAttributeCallExp_Helper_T4qvtrSourceArgument();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapNavigationOrAttributeCallExp_Helper#getT4qvtrThisVariable <em>T4qvtr This Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T4qvtr This Variable</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapNavigationOrAttributeCallExp_Helper#getT4qvtrThisVariable()
	 * @see #getTmapNavigationOrAttributeCallExp_Helper()
	 * @generated
	 */
	EReference getTmapNavigationOrAttributeCallExp_Helper_T4qvtrThisVariable();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapNavigationOrAttributeCallExp_Helper#getT4qvtrTransformation <em>T4qvtr Transformation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T4qvtr Transformation</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapNavigationOrAttributeCallExp_Helper#getT4qvtrTransformation()
	 * @see #getTmapNavigationOrAttributeCallExp_Helper()
	 * @generated
	 */
	EReference getTmapNavigationOrAttributeCallExp_Helper_T4qvtrTransformation();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapNavigationOrAttributeCallExp_Helper#getWmapHelper <em>Wmap Helper</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Wmap Helper</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapNavigationOrAttributeCallExp_Helper#getWmapHelper()
	 * @see #getTmapNavigationOrAttributeCallExp_Helper()
	 * @generated
	 */
	EReference getTmapNavigationOrAttributeCallExp_Helper_WmapHelper();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapNavigationOrAttributeCallExp_Helper#getWmapModule <em>Wmap Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Wmap Module</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapNavigationOrAttributeCallExp_Helper#getWmapModule()
	 * @see #getTmapNavigationOrAttributeCallExp_Helper()
	 * @generated
	 */
	EReference getTmapNavigationOrAttributeCallExp_Helper_WmapModule();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapNavigationOrAttributeCallExp_Helper#getWmapOclExpression <em>Wmap Ocl Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Wmap Ocl Expression</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapNavigationOrAttributeCallExp_Helper#getWmapOclExpression()
	 * @see #getTmapNavigationOrAttributeCallExp_Helper()
	 * @generated
	 */
	EReference getTmapNavigationOrAttributeCallExp_Helper_WmapOclExpression();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapNavigationOrAttributeCallExp_Helper#getS0local <em>S0local</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>S0local</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapNavigationOrAttributeCallExp_Helper#getS0local()
	 * @see #getTmapNavigationOrAttributeCallExp_Helper()
	 * @generated
	 */
	EAttribute getTmapNavigationOrAttributeCallExp_Helper_S0local();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapNavigationOrAttributeCallExp_Property <em>Tmap Navigation Or Attribute Call Exp Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tmap Navigation Or Attribute Call Exp Property</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapNavigationOrAttributeCallExp_Property
	 * @generated
	 */
	EClass getTmapNavigationOrAttributeCallExp_Property();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapNavigationOrAttributeCallExp_Property#getDispatcher <em>Dispatcher</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Dispatcher</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapNavigationOrAttributeCallExp_Property#getDispatcher()
	 * @see #getTmapNavigationOrAttributeCallExp_Property()
	 * @generated
	 */
	EReference getTmapNavigationOrAttributeCallExp_Property_Dispatcher();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapNavigationOrAttributeCallExp_Property#getT1propertyName <em>T1property Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>T1property Name</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapNavigationOrAttributeCallExp_Property#getT1propertyName()
	 * @see #getTmapNavigationOrAttributeCallExp_Property()
	 * @generated
	 */
	EAttribute getTmapNavigationOrAttributeCallExp_Property_T1propertyName();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapNavigationOrAttributeCallExp_Property#getT3atlAttributes <em>T3atl Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>T3atl Attributes</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapNavigationOrAttributeCallExp_Property#getT3atlAttributes()
	 * @see #getTmapNavigationOrAttributeCallExp_Property()
	 * @generated
	 */
	EReference getTmapNavigationOrAttributeCallExp_Property_T3atlAttributes();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapNavigationOrAttributeCallExp_Property#getT3atlModule <em>T3atl Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T3atl Module</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapNavigationOrAttributeCallExp_Property#getT3atlModule()
	 * @see #getTmapNavigationOrAttributeCallExp_Property()
	 * @generated
	 */
	EReference getTmapNavigationOrAttributeCallExp_Property_T3atlModule();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapNavigationOrAttributeCallExp_Property#getT3atlSource <em>T3atl Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T3atl Source</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapNavigationOrAttributeCallExp_Property#getT3atlSource()
	 * @see #getTmapNavigationOrAttributeCallExp_Property()
	 * @generated
	 */
	EReference getTmapNavigationOrAttributeCallExp_Property_T3atlSource();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapNavigationOrAttributeCallExp_Property#getT4qvtrProperty <em>T4qvtr Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T4qvtr Property</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapNavigationOrAttributeCallExp_Property#getT4qvtrProperty()
	 * @see #getTmapNavigationOrAttributeCallExp_Property()
	 * @generated
	 */
	EReference getTmapNavigationOrAttributeCallExp_Property_T4qvtrProperty();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapNavigationOrAttributeCallExp_Property#getT4qvtrSource <em>T4qvtr Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T4qvtr Source</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapNavigationOrAttributeCallExp_Property#getT4qvtrSource()
	 * @see #getTmapNavigationOrAttributeCallExp_Property()
	 * @generated
	 */
	EReference getTmapNavigationOrAttributeCallExp_Property_T4qvtrSource();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapNavigationOrAttributeCallExp_Property#getWmapOclExpression <em>Wmap Ocl Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Wmap Ocl Expression</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapNavigationOrAttributeCallExp_Property#getWmapOclExpression()
	 * @see #getTmapNavigationOrAttributeCallExp_Property()
	 * @generated
	 */
	EReference getTmapNavigationOrAttributeCallExp_Property_WmapOclExpression();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapNavigationOrAttributeCallExp_Property#getS0local <em>S0local</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>S0local</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapNavigationOrAttributeCallExp_Property#getS0local()
	 * @see #getTmapNavigationOrAttributeCallExp_Property()
	 * @generated
	 */
	EAttribute getTmapNavigationOrAttributeCallExp_Property_S0local();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOclMetamodel <em>Tmap Ocl Metamodel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tmap Ocl Metamodel</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOclMetamodel
	 * @generated
	 */
	EClass getTmapOclMetamodel();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOclMetamodel#getS0global <em>S0global</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>S0global</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOclMetamodel#getS0global()
	 * @see #getTmapOclMetamodel()
	 * @generated
	 */
	EAttribute getTmapOclMetamodel_S0global();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOclMetamodel#getT1tmName <em>T1tm Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>T1tm Name</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOclMetamodel#getT1tmName()
	 * @see #getTmapOclMetamodel()
	 * @generated
	 */
	EAttribute getTmapOclMetamodel_T1tmName();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOclMetamodel#getT3oclMetamodel <em>T3ocl Metamodel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T3ocl Metamodel</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOclMetamodel#getT3oclMetamodel()
	 * @see #getTmapOclMetamodel()
	 * @generated
	 */
	EReference getTmapOclMetamodel_T3oclMetamodel();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOclMetamodel#getT4qvtrTypedModel <em>T4qvtr Typed Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T4qvtr Typed Model</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOclMetamodel#getT4qvtrTypedModel()
	 * @see #getTmapOclMetamodel()
	 * @generated
	 */
	EReference getTmapOclMetamodel_T4qvtrTypedModel();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOclModel_IN <em>Tmap Ocl Model IN</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tmap Ocl Model IN</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOclModel_IN
	 * @generated
	 */
	EClass getTmapOclModel_IN();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOclModel_IN#getS0global <em>S0global</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>S0global</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOclModel_IN#getS0global()
	 * @see #getTmapOclModel_IN()
	 * @generated
	 */
	EAttribute getTmapOclModel_IN_S0global();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOclModel_IN#getT3atlModule <em>T3atl Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T3atl Module</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOclModel_IN#getT3atlModule()
	 * @see #getTmapOclModel_IN()
	 * @generated
	 */
	EReference getTmapOclModel_IN_T3atlModule();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOclModel_IN#getT3oclMetamodel <em>T3ocl Metamodel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T3ocl Metamodel</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOclModel_IN#getT3oclMetamodel()
	 * @see #getTmapOclModel_IN()
	 * @generated
	 */
	EReference getTmapOclModel_IN_T3oclMetamodel();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOclModel_IN#getT3oclModel <em>T3ocl Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T3ocl Model</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOclModel_IN#getT3oclModel()
	 * @see #getTmapOclModel_IN()
	 * @generated
	 */
	EReference getTmapOclModel_IN_T3oclModel();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOclModel_IN#getT4qvtrPackages <em>T4qvtr Packages</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>T4qvtr Packages</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOclModel_IN#getT4qvtrPackages()
	 * @see #getTmapOclModel_IN()
	 * @generated
	 */
	EReference getTmapOclModel_IN_T4qvtrPackages();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOclModel_IN#getT4qvtrTransformation <em>T4qvtr Transformation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T4qvtr Transformation</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOclModel_IN#getT4qvtrTransformation()
	 * @see #getTmapOclModel_IN()
	 * @generated
	 */
	EReference getTmapOclModel_IN_T4qvtrTransformation();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOclModel_IN#getT4qvtrTypedModel <em>T4qvtr Typed Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T4qvtr Typed Model</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOclModel_IN#getT4qvtrTypedModel()
	 * @see #getTmapOclModel_IN()
	 * @generated
	 */
	EReference getTmapOclModel_IN_T4qvtrTypedModel();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOclModel_IN#getWmapModule <em>Wmap Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Wmap Module</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOclModel_IN#getWmapModule()
	 * @see #getTmapOclModel_IN()
	 * @generated
	 */
	EReference getTmapOclModel_IN_WmapModule();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOclModel_IN#getWmapOclMetamodel <em>Wmap Ocl Metamodel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Wmap Ocl Metamodel</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOclModel_IN#getWmapOclMetamodel()
	 * @see #getTmapOclModel_IN()
	 * @generated
	 */
	EReference getTmapOclModel_IN_WmapOclMetamodel();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOclModel_OUT <em>Tmap Ocl Model OUT</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tmap Ocl Model OUT</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOclModel_OUT
	 * @generated
	 */
	EClass getTmapOclModel_OUT();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOclModel_OUT#getS0global <em>S0global</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>S0global</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOclModel_OUT#getS0global()
	 * @see #getTmapOclModel_OUT()
	 * @generated
	 */
	EAttribute getTmapOclModel_OUT_S0global();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOclModel_OUT#getT3atlModule <em>T3atl Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T3atl Module</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOclModel_OUT#getT3atlModule()
	 * @see #getTmapOclModel_OUT()
	 * @generated
	 */
	EReference getTmapOclModel_OUT_T3atlModule();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOclModel_OUT#getT3oclMetamodel <em>T3ocl Metamodel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T3ocl Metamodel</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOclModel_OUT#getT3oclMetamodel()
	 * @see #getTmapOclModel_OUT()
	 * @generated
	 */
	EReference getTmapOclModel_OUT_T3oclMetamodel();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOclModel_OUT#getT3oclModel <em>T3ocl Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T3ocl Model</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOclModel_OUT#getT3oclModel()
	 * @see #getTmapOclModel_OUT()
	 * @generated
	 */
	EReference getTmapOclModel_OUT_T3oclModel();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOclModel_OUT#getT4qvtrPackages <em>T4qvtr Packages</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>T4qvtr Packages</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOclModel_OUT#getT4qvtrPackages()
	 * @see #getTmapOclModel_OUT()
	 * @generated
	 */
	EReference getTmapOclModel_OUT_T4qvtrPackages();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOclModel_OUT#getT4qvtrTransformation <em>T4qvtr Transformation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T4qvtr Transformation</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOclModel_OUT#getT4qvtrTransformation()
	 * @see #getTmapOclModel_OUT()
	 * @generated
	 */
	EReference getTmapOclModel_OUT_T4qvtrTransformation();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOclModel_OUT#getT4qvtrTypedModel <em>T4qvtr Typed Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T4qvtr Typed Model</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOclModel_OUT#getT4qvtrTypedModel()
	 * @see #getTmapOclModel_OUT()
	 * @generated
	 */
	EReference getTmapOclModel_OUT_T4qvtrTypedModel();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOclModel_OUT#getWmapModule <em>Wmap Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Wmap Module</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOclModel_OUT#getWmapModule()
	 * @see #getTmapOclModel_OUT()
	 * @generated
	 */
	EReference getTmapOclModel_OUT_WmapModule();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOclModel_OUT#getWmapOclMetamodel <em>Wmap Ocl Metamodel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Wmap Ocl Metamodel</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOclModel_OUT#getWmapOclMetamodel()
	 * @see #getTmapOclModel_OUT()
	 * @generated
	 */
	EReference getTmapOclModel_OUT_WmapOclMetamodel();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOclType <em>Tmap Ocl Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tmap Ocl Type</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOclType
	 * @generated
	 */
	EClass getTmapOclType();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOclType#getDispatcher <em>Dispatcher</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Dispatcher</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOclType#getDispatcher()
	 * @see #getTmapOclType()
	 * @generated
	 */
	EReference getTmapOclType_Dispatcher();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_Helper <em>Tmap Operation Call Exp Helper</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tmap Operation Call Exp Helper</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_Helper
	 * @generated
	 */
	EClass getTmapOperationCallExp_Helper();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_Helper#getDispatcher <em>Dispatcher</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Dispatcher</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_Helper#getDispatcher()
	 * @see #getTmapOperationCallExp_Helper()
	 * @generated
	 */
	EReference getTmapOperationCallExp_Helper_Dispatcher();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_Helper#getT1operationName <em>T1operation Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>T1operation Name</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_Helper#getT1operationName()
	 * @see #getTmapOperationCallExp_Helper()
	 * @generated
	 */
	EAttribute getTmapOperationCallExp_Helper_T1operationName();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_Helper#getT3atlModule <em>T3atl Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T3atl Module</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_Helper#getT3atlModule()
	 * @see #getTmapOperationCallExp_Helper()
	 * @generated
	 */
	EReference getTmapOperationCallExp_Helper_T3atlModule();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_Helper#getT3atlOperations <em>T3atl Operations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>T3atl Operations</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_Helper#getT3atlOperations()
	 * @see #getTmapOperationCallExp_Helper()
	 * @generated
	 */
	EReference getTmapOperationCallExp_Helper_T3atlOperations();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_Helper#getT3atlSource <em>T3atl Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T3atl Source</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_Helper#getT3atlSource()
	 * @see #getTmapOperationCallExp_Helper()
	 * @generated
	 */
	EReference getTmapOperationCallExp_Helper_T3atlSource();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_Helper#getT4qvtrOperation <em>T4qvtr Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T4qvtr Operation</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_Helper#getT4qvtrOperation()
	 * @see #getTmapOperationCallExp_Helper()
	 * @generated
	 */
	EReference getTmapOperationCallExp_Helper_T4qvtrOperation();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_Helper#getT4qvtrSource <em>T4qvtr Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T4qvtr Source</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_Helper#getT4qvtrSource()
	 * @see #getTmapOperationCallExp_Helper()
	 * @generated
	 */
	EReference getTmapOperationCallExp_Helper_T4qvtrSource();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_Helper#getT4qvtrSourceArgument <em>T4qvtr Source Argument</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T4qvtr Source Argument</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_Helper#getT4qvtrSourceArgument()
	 * @see #getTmapOperationCallExp_Helper()
	 * @generated
	 */
	EReference getTmapOperationCallExp_Helper_T4qvtrSourceArgument();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_Helper#getT4qvtrThisVariable <em>T4qvtr This Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T4qvtr This Variable</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_Helper#getT4qvtrThisVariable()
	 * @see #getTmapOperationCallExp_Helper()
	 * @generated
	 */
	EReference getTmapOperationCallExp_Helper_T4qvtrThisVariable();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_Helper#getT4qvtrTransformation <em>T4qvtr Transformation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T4qvtr Transformation</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_Helper#getT4qvtrTransformation()
	 * @see #getTmapOperationCallExp_Helper()
	 * @generated
	 */
	EReference getTmapOperationCallExp_Helper_T4qvtrTransformation();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_Helper#getWmapHelper <em>Wmap Helper</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Wmap Helper</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_Helper#getWmapHelper()
	 * @see #getTmapOperationCallExp_Helper()
	 * @generated
	 */
	EReference getTmapOperationCallExp_Helper_WmapHelper();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_Helper#getWmapModule <em>Wmap Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Wmap Module</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_Helper#getWmapModule()
	 * @see #getTmapOperationCallExp_Helper()
	 * @generated
	 */
	EReference getTmapOperationCallExp_Helper_WmapModule();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_Helper#getWmapOclExpression <em>Wmap Ocl Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Wmap Ocl Expression</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_Helper#getWmapOclExpression()
	 * @see #getTmapOperationCallExp_Helper()
	 * @generated
	 */
	EReference getTmapOperationCallExp_Helper_WmapOclExpression();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_Helper#getS0local <em>S0local</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>S0local</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_Helper#getS0local()
	 * @see #getTmapOperationCallExp_Helper()
	 * @generated
	 */
	EAttribute getTmapOperationCallExp_Helper_S0local();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_Operation <em>Tmap Operation Call Exp Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tmap Operation Call Exp Operation</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_Operation
	 * @generated
	 */
	EClass getTmapOperationCallExp_Operation();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_Operation#getDispatcher <em>Dispatcher</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Dispatcher</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_Operation#getDispatcher()
	 * @see #getTmapOperationCallExp_Operation()
	 * @generated
	 */
	EReference getTmapOperationCallExp_Operation_Dispatcher();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_Operation#getT1operationName <em>T1operation Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>T1operation Name</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_Operation#getT1operationName()
	 * @see #getTmapOperationCallExp_Operation()
	 * @generated
	 */
	EAttribute getTmapOperationCallExp_Operation_T1operationName();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_Operation#getT3atlModule <em>T3atl Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T3atl Module</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_Operation#getT3atlModule()
	 * @see #getTmapOperationCallExp_Operation()
	 * @generated
	 */
	EReference getTmapOperationCallExp_Operation_T3atlModule();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_Operation#getT3atlOperations <em>T3atl Operations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>T3atl Operations</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_Operation#getT3atlOperations()
	 * @see #getTmapOperationCallExp_Operation()
	 * @generated
	 */
	EReference getTmapOperationCallExp_Operation_T3atlOperations();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_Operation#getT3atlSource <em>T3atl Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T3atl Source</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_Operation#getT3atlSource()
	 * @see #getTmapOperationCallExp_Operation()
	 * @generated
	 */
	EReference getTmapOperationCallExp_Operation_T3atlSource();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_Operation#getT4qvtrOperation <em>T4qvtr Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T4qvtr Operation</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_Operation#getT4qvtrOperation()
	 * @see #getTmapOperationCallExp_Operation()
	 * @generated
	 */
	EReference getTmapOperationCallExp_Operation_T4qvtrOperation();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_Operation#getT4qvtrSource <em>T4qvtr Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T4qvtr Source</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_Operation#getT4qvtrSource()
	 * @see #getTmapOperationCallExp_Operation()
	 * @generated
	 */
	EReference getTmapOperationCallExp_Operation_T4qvtrSource();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_Operation#getWmapOclExpression <em>Wmap Ocl Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Wmap Ocl Expression</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_Operation#getWmapOclExpression()
	 * @see #getTmapOperationCallExp_Operation()
	 * @generated
	 */
	EReference getTmapOperationCallExp_Operation_WmapOclExpression();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_Operation#getS0local <em>S0local</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>S0local</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_Operation#getS0local()
	 * @see #getTmapOperationCallExp_Operation()
	 * @generated
	 */
	EAttribute getTmapOperationCallExp_Operation_S0local();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_argument <em>Tmap Operation Call Exp argument</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tmap Operation Call Exp argument</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_argument
	 * @generated
	 */
	EClass getTmapOperationCallExp_argument();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_argument#getS0global <em>S0global</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>S0global</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_argument#getS0global()
	 * @see #getTmapOperationCallExp_argument()
	 * @generated
	 */
	EAttribute getTmapOperationCallExp_argument_S0global();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_argument#getT3atlArgument <em>T3atl Argument</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T3atl Argument</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_argument#getT3atlArgument()
	 * @see #getTmapOperationCallExp_argument()
	 * @generated
	 */
	EReference getTmapOperationCallExp_argument_T3atlArgument();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_argument#getT3atlParent <em>T3atl Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T3atl Parent</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_argument#getT3atlParent()
	 * @see #getTmapOperationCallExp_argument()
	 * @generated
	 */
	EReference getTmapOperationCallExp_argument_T3atlParent();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_argument#getT4qvtrArgument <em>T4qvtr Argument</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T4qvtr Argument</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_argument#getT4qvtrArgument()
	 * @see #getTmapOperationCallExp_argument()
	 * @generated
	 */
	EReference getTmapOperationCallExp_argument_T4qvtrArgument();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_argument#getT4qvtrParent <em>T4qvtr Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T4qvtr Parent</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_argument#getT4qvtrParent()
	 * @see #getTmapOperationCallExp_argument()
	 * @generated
	 */
	EReference getTmapOperationCallExp_argument_T4qvtrParent();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_argument#getWmapOclExpression <em>Wmap Ocl Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Wmap Ocl Expression</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_argument#getWmapOclExpression()
	 * @see #getTmapOperationCallExp_argument()
	 * @generated
	 */
	EReference getTmapOperationCallExp_argument_WmapOclExpression();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_argument#getWmapOclExpression1 <em>Wmap Ocl Expression1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Wmap Ocl Expression1</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_argument#getWmapOclExpression1()
	 * @see #getTmapOperationCallExp_argument()
	 * @generated
	 */
	EReference getTmapOperationCallExp_argument_WmapOclExpression1();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperatorCallExp <em>Tmap Operator Call Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tmap Operator Call Exp</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperatorCallExp
	 * @generated
	 */
	EClass getTmapOperatorCallExp();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperatorCallExp#getDispatcher <em>Dispatcher</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Dispatcher</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperatorCallExp#getDispatcher()
	 * @see #getTmapOperatorCallExp()
	 * @generated
	 */
	EReference getTmapOperatorCallExp_Dispatcher();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperatorCallExp#getT1operationName <em>T1operation Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>T1operation Name</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperatorCallExp#getT1operationName()
	 * @see #getTmapOperatorCallExp()
	 * @generated
	 */
	EAttribute getTmapOperatorCallExp_T1operationName();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperatorCallExp#getT3atlSource <em>T3atl Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T3atl Source</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperatorCallExp#getT3atlSource()
	 * @see #getTmapOperatorCallExp()
	 * @generated
	 */
	EReference getTmapOperatorCallExp_T3atlSource();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperatorCallExp#getT4qvtrOperation <em>T4qvtr Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T4qvtr Operation</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperatorCallExp#getT4qvtrOperation()
	 * @see #getTmapOperatorCallExp()
	 * @generated
	 */
	EReference getTmapOperatorCallExp_T4qvtrOperation();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperatorCallExp#getT4qvtrSource <em>T4qvtr Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T4qvtr Source</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperatorCallExp#getT4qvtrSource()
	 * @see #getTmapOperatorCallExp()
	 * @generated
	 */
	EReference getTmapOperatorCallExp_T4qvtrSource();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperatorCallExp#getWmapOclExpression <em>Wmap Ocl Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Wmap Ocl Expression</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperatorCallExp#getWmapOclExpression()
	 * @see #getTmapOperatorCallExp()
	 * @generated
	 */
	EReference getTmapOperatorCallExp_WmapOclExpression();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperatorCallExp#getS0local <em>S0local</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>S0local</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperatorCallExp#getS0local()
	 * @see #getTmapOperatorCallExp()
	 * @generated
	 */
	EAttribute getTmapOperatorCallExp_S0local();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleInPatternElement <em>Tmap Simple In Pattern Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tmap Simple In Pattern Element</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleInPatternElement
	 * @generated
	 */
	EClass getTmapSimpleInPatternElement();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleInPatternElement#getS0global <em>S0global</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>S0global</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleInPatternElement#getS0global()
	 * @see #getTmapSimpleInPatternElement()
	 * @generated
	 */
	EAttribute getTmapSimpleInPatternElement_S0global();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleInPatternElement#getT1elementName <em>T1element Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>T1element Name</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleInPatternElement#getT1elementName()
	 * @see #getTmapSimpleInPatternElement()
	 * @generated
	 */
	EAttribute getTmapSimpleInPatternElement_T1elementName();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleInPatternElement#getT3atlElement <em>T3atl Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T3atl Element</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleInPatternElement#getT3atlElement()
	 * @see #getTmapSimpleInPatternElement()
	 * @generated
	 */
	EReference getTmapSimpleInPatternElement_T3atlElement();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleInPatternElement#getT3atlPattern <em>T3atl Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T3atl Pattern</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleInPatternElement#getT3atlPattern()
	 * @see #getTmapSimpleInPatternElement()
	 * @generated
	 */
	EReference getTmapSimpleInPatternElement_T3atlPattern();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleInPatternElement#getT3atlRule <em>T3atl Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T3atl Rule</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleInPatternElement#getT3atlRule()
	 * @see #getTmapSimpleInPatternElement()
	 * @generated
	 */
	EReference getTmapSimpleInPatternElement_T3atlRule();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleInPatternElement#getT4qvtrDomain <em>T4qvtr Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T4qvtr Domain</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleInPatternElement#getT4qvtrDomain()
	 * @see #getTmapSimpleInPatternElement()
	 * @generated
	 */
	EReference getTmapSimpleInPatternElement_T4qvtrDomain();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleInPatternElement#getT4qvtrPattern <em>T4qvtr Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T4qvtr Pattern</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleInPatternElement#getT4qvtrPattern()
	 * @see #getTmapSimpleInPatternElement()
	 * @generated
	 */
	EReference getTmapSimpleInPatternElement_T4qvtrPattern();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleInPatternElement#getT4qvtrRelation <em>T4qvtr Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T4qvtr Relation</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleInPatternElement#getT4qvtrRelation()
	 * @see #getTmapSimpleInPatternElement()
	 * @generated
	 */
	EReference getTmapSimpleInPatternElement_T4qvtrRelation();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleInPatternElement#getT4qvtrTemplate <em>T4qvtr Template</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T4qvtr Template</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleInPatternElement#getT4qvtrTemplate()
	 * @see #getTmapSimpleInPatternElement()
	 * @generated
	 */
	EReference getTmapSimpleInPatternElement_T4qvtrTemplate();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleInPatternElement#getT4qvtrVariable <em>T4qvtr Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T4qvtr Variable</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleInPatternElement#getT4qvtrVariable()
	 * @see #getTmapSimpleInPatternElement()
	 * @generated
	 */
	EReference getTmapSimpleInPatternElement_T4qvtrVariable();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleInPatternElement#getWmapInPattern <em>Wmap In Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Wmap In Pattern</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleInPatternElement#getWmapInPattern()
	 * @see #getTmapSimpleInPatternElement()
	 * @generated
	 */
	EReference getTmapSimpleInPatternElement_WmapInPattern();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleInPatternElement#getWmapMatchedRule <em>Wmap Matched Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Wmap Matched Rule</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleInPatternElement#getWmapMatchedRule()
	 * @see #getTmapSimpleInPatternElement()
	 * @generated
	 */
	EReference getTmapSimpleInPatternElement_WmapMatchedRule();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleInPatternElement#getWmapVariable <em>Wmap Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Wmap Variable</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleInPatternElement#getWmapVariable()
	 * @see #getTmapSimpleInPatternElement()
	 * @generated
	 */
	EReference getTmapSimpleInPatternElement_WmapVariable();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleOutPatternElement <em>Tmap Simple Out Pattern Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tmap Simple Out Pattern Element</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleOutPatternElement
	 * @generated
	 */
	EClass getTmapSimpleOutPatternElement();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleOutPatternElement#getS0global <em>S0global</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>S0global</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleOutPatternElement#getS0global()
	 * @see #getTmapSimpleOutPatternElement()
	 * @generated
	 */
	EAttribute getTmapSimpleOutPatternElement_S0global();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleOutPatternElement#getT1elementName <em>T1element Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>T1element Name</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleOutPatternElement#getT1elementName()
	 * @see #getTmapSimpleOutPatternElement()
	 * @generated
	 */
	EAttribute getTmapSimpleOutPatternElement_T1elementName();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleOutPatternElement#getT3atlElement <em>T3atl Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T3atl Element</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleOutPatternElement#getT3atlElement()
	 * @see #getTmapSimpleOutPatternElement()
	 * @generated
	 */
	EReference getTmapSimpleOutPatternElement_T3atlElement();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleOutPatternElement#getT3atlMetamodel <em>T3atl Metamodel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T3atl Metamodel</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleOutPatternElement#getT3atlMetamodel()
	 * @see #getTmapSimpleOutPatternElement()
	 * @generated
	 */
	EReference getTmapSimpleOutPatternElement_T3atlMetamodel();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleOutPatternElement#getT3atlPattern <em>T3atl Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T3atl Pattern</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleOutPatternElement#getT3atlPattern()
	 * @see #getTmapSimpleOutPatternElement()
	 * @generated
	 */
	EReference getTmapSimpleOutPatternElement_T3atlPattern();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleOutPatternElement#getT3atlRule <em>T3atl Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T3atl Rule</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleOutPatternElement#getT3atlRule()
	 * @see #getTmapSimpleOutPatternElement()
	 * @generated
	 */
	EReference getTmapSimpleOutPatternElement_T3atlRule();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleOutPatternElement#getT3atlType <em>T3atl Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T3atl Type</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleOutPatternElement#getT3atlType()
	 * @see #getTmapSimpleOutPatternElement()
	 * @generated
	 */
	EReference getTmapSimpleOutPatternElement_T3atlType();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleOutPatternElement#getT4qvtrDomain <em>T4qvtr Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T4qvtr Domain</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleOutPatternElement#getT4qvtrDomain()
	 * @see #getTmapSimpleOutPatternElement()
	 * @generated
	 */
	EReference getTmapSimpleOutPatternElement_T4qvtrDomain();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleOutPatternElement#getT4qvtrPattern <em>T4qvtr Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T4qvtr Pattern</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleOutPatternElement#getT4qvtrPattern()
	 * @see #getTmapSimpleOutPatternElement()
	 * @generated
	 */
	EReference getTmapSimpleOutPatternElement_T4qvtrPattern();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleOutPatternElement#getT4qvtrRelation <em>T4qvtr Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T4qvtr Relation</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleOutPatternElement#getT4qvtrRelation()
	 * @see #getTmapSimpleOutPatternElement()
	 * @generated
	 */
	EReference getTmapSimpleOutPatternElement_T4qvtrRelation();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleOutPatternElement#getT4qvtrTemplate <em>T4qvtr Template</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T4qvtr Template</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleOutPatternElement#getT4qvtrTemplate()
	 * @see #getTmapSimpleOutPatternElement()
	 * @generated
	 */
	EReference getTmapSimpleOutPatternElement_T4qvtrTemplate();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleOutPatternElement#getT4qvtrType <em>T4qvtr Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T4qvtr Type</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleOutPatternElement#getT4qvtrType()
	 * @see #getTmapSimpleOutPatternElement()
	 * @generated
	 */
	EReference getTmapSimpleOutPatternElement_T4qvtrType();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleOutPatternElement#getT4qvtrTypedModel <em>T4qvtr Typed Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T4qvtr Typed Model</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleOutPatternElement#getT4qvtrTypedModel()
	 * @see #getTmapSimpleOutPatternElement()
	 * @generated
	 */
	EReference getTmapSimpleOutPatternElement_T4qvtrTypedModel();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleOutPatternElement#getT4qvtrVariable <em>T4qvtr Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T4qvtr Variable</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleOutPatternElement#getT4qvtrVariable()
	 * @see #getTmapSimpleOutPatternElement()
	 * @generated
	 */
	EReference getTmapSimpleOutPatternElement_T4qvtrVariable();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleOutPatternElement#getWmapMatchedRule <em>Wmap Matched Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Wmap Matched Rule</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleOutPatternElement#getWmapMatchedRule()
	 * @see #getTmapSimpleOutPatternElement()
	 * @generated
	 */
	EReference getTmapSimpleOutPatternElement_WmapMatchedRule();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleOutPatternElement#getWmapOclMetamodel <em>Wmap Ocl Metamodel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Wmap Ocl Metamodel</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleOutPatternElement#getWmapOclMetamodel()
	 * @see #getTmapSimpleOutPatternElement()
	 * @generated
	 */
	EReference getTmapSimpleOutPatternElement_WmapOclMetamodel();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleOutPatternElement#getWmapVariable <em>Wmap Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Wmap Variable</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleOutPatternElement#getWmapVariable()
	 * @see #getTmapSimpleOutPatternElement()
	 * @generated
	 */
	EReference getTmapSimpleOutPatternElement_WmapVariable();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapStringExp <em>Tmap String Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tmap String Exp</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapStringExp
	 * @generated
	 */
	EClass getTmapStringExp();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapStringExp#getDispatcher <em>Dispatcher</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Dispatcher</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapStringExp#getDispatcher()
	 * @see #getTmapStringExp()
	 * @generated
	 */
	EReference getTmapStringExp_Dispatcher();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapStringExp#getT1symbol <em>T1symbol</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>T1symbol</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapStringExp#getT1symbol()
	 * @see #getTmapStringExp()
	 * @generated
	 */
	EAttribute getTmapStringExp_T1symbol();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapVariable <em>Tmap Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tmap Variable</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapVariable
	 * @generated
	 */
	EClass getTmapVariable();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapVariable#getS0global <em>S0global</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>S0global</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapVariable#getS0global()
	 * @see #getTmapVariable()
	 * @generated
	 */
	EAttribute getTmapVariable_S0global();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapVariable#getT3atlVariable <em>T3atl Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T3atl Variable</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapVariable#getT3atlVariable()
	 * @see #getTmapVariable()
	 * @generated
	 */
	EReference getTmapVariable_T3atlVariable();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapVariable#getT4qvtrVariable <em>T4qvtr Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T4qvtr Variable</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapVariable#getT4qvtrVariable()
	 * @see #getTmapVariable()
	 * @generated
	 */
	EReference getTmapVariable_T4qvtrVariable();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapVariableExp <em>Tmap Variable Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tmap Variable Exp</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapVariableExp
	 * @generated
	 */
	EClass getTmapVariableExp();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapVariableExp#getDispatcher <em>Dispatcher</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Dispatcher</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapVariableExp#getDispatcher()
	 * @see #getTmapVariableExp()
	 * @generated
	 */
	EReference getTmapVariableExp_Dispatcher();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapVariableExp#getT1varName <em>T1var Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>T1var Name</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapVariableExp#getT1varName()
	 * @see #getTmapVariableExp()
	 * @generated
	 */
	EAttribute getTmapVariableExp_T1varName();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapVariableExp#getT3atlVariable <em>T3atl Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T3atl Variable</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapVariableExp#getT3atlVariable()
	 * @see #getTmapVariableExp()
	 * @generated
	 */
	EReference getTmapVariableExp_T3atlVariable();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapVariableExp#getWmapVariableExp_referredVariable <em>Wmap Variable Exp referred Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Wmap Variable Exp referred Variable</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapVariableExp#getWmapVariableExp_referredVariable()
	 * @see #getTmapVariableExp()
	 * @generated
	 */
	EReference getTmapVariableExp_WmapVariableExp_referredVariable();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapVariableExp_referredVariable_Helper <em>Tmap Variable Exp referred Variable Helper</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tmap Variable Exp referred Variable Helper</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapVariableExp_referredVariable_Helper
	 * @generated
	 */
	EClass getTmapVariableExp_referredVariable_Helper();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapVariableExp_referredVariable_Helper#getDispatcher <em>Dispatcher</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Dispatcher</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapVariableExp_referredVariable_Helper#getDispatcher()
	 * @see #getTmapVariableExp_referredVariable_Helper()
	 * @generated
	 */
	EReference getTmapVariableExp_referredVariable_Helper_Dispatcher();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapVariableExp_referredVariable_Helper#getT3atlHelper <em>T3atl Helper</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T3atl Helper</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapVariableExp_referredVariable_Helper#getT3atlHelper()
	 * @see #getTmapVariableExp_referredVariable_Helper()
	 * @generated
	 */
	EReference getTmapVariableExp_referredVariable_Helper_T3atlHelper();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapVariableExp_referredVariable_Helper#getT3atlVariable <em>T3atl Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T3atl Variable</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapVariableExp_referredVariable_Helper#getT3atlVariable()
	 * @see #getTmapVariableExp_referredVariable_Helper()
	 * @generated
	 */
	EReference getTmapVariableExp_referredVariable_Helper_T3atlVariable();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapVariableExp_referredVariable_Helper#getT4qvtrVariable <em>T4qvtr Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T4qvtr Variable</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapVariableExp_referredVariable_Helper#getT4qvtrVariable()
	 * @see #getTmapVariableExp_referredVariable_Helper()
	 * @generated
	 */
	EReference getTmapVariableExp_referredVariable_Helper_T4qvtrVariable();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapVariableExp_referredVariable_Helper#getS0local <em>S0local</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>S0local</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapVariableExp_referredVariable_Helper#getS0local()
	 * @see #getTmapVariableExp_referredVariable_Helper()
	 * @generated
	 */
	EAttribute getTmapVariableExp_referredVariable_Helper_S0local();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapVariableExp_referredVariable_VariableDeclaration <em>Tmap Variable Exp referred Variable Variable Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tmap Variable Exp referred Variable Variable Declaration</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapVariableExp_referredVariable_VariableDeclaration
	 * @generated
	 */
	EClass getTmapVariableExp_referredVariable_VariableDeclaration();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapVariableExp_referredVariable_VariableDeclaration#getDispatcher <em>Dispatcher</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Dispatcher</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapVariableExp_referredVariable_VariableDeclaration#getDispatcher()
	 * @see #getTmapVariableExp_referredVariable_VariableDeclaration()
	 * @generated
	 */
	EReference getTmapVariableExp_referredVariable_VariableDeclaration_Dispatcher();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapVariableExp_referredVariable_VariableDeclaration#getT3atlVariable <em>T3atl Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T3atl Variable</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapVariableExp_referredVariable_VariableDeclaration#getT3atlVariable()
	 * @see #getTmapVariableExp_referredVariable_VariableDeclaration()
	 * @generated
	 */
	EReference getTmapVariableExp_referredVariable_VariableDeclaration_T3atlVariable();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapVariableExp_referredVariable_VariableDeclaration#getT4qvtrVariable <em>T4qvtr Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>T4qvtr Variable</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapVariableExp_referredVariable_VariableDeclaration#getT4qvtrVariable()
	 * @see #getTmapVariableExp_referredVariable_VariableDeclaration()
	 * @generated
	 */
	EReference getTmapVariableExp_referredVariable_VariableDeclaration_T4qvtrVariable();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapVariableExp_referredVariable_VariableDeclaration#getS0local <em>S0local</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>S0local</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapVariableExp_referredVariable_VariableDeclaration#getS0local()
	 * @see #getTmapVariableExp_referredVariable_VariableDeclaration()
	 * @generated
	 */
	EAttribute getTmapVariableExp_referredVariable_VariableDeclaration_S0local();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TxATL2QVTr <em>Tx ATL2QV Tr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tx ATL2QV Tr</em>'.
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TxATL2QVTr
	 * @generated
	 */
	EClass getTxATL2QVTr();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	trace_ATL2QVTrFactory gettrace_ATL2QVTrFactory();

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
		 * The meta object literal for the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.CmapVariableExp_referredVariable_HelperImpl <em>Cmap Variable Exp referred Variable Helper</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.CmapVariableExp_referredVariable_HelperImpl
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.trace_ATL2QVTrPackageImpl#getCmapVariableExp_referredVariable_Helper()
		 * @generated
		 */
		EClass CMAP_VARIABLE_EXP_REFERRED_VARIABLE_HELPER = eINSTANCE.getCmapVariableExp_referredVariable_Helper();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.CmapVariableExp_referredVariable_VariableDeclarationImpl <em>Cmap Variable Exp referred Variable Variable Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.CmapVariableExp_referredVariable_VariableDeclarationImpl
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.trace_ATL2QVTrPackageImpl#getCmapVariableExp_referredVariable_VariableDeclaration()
		 * @generated
		 */
		EClass CMAP_VARIABLE_EXP_REFERRED_VARIABLE_VARIABLE_DECLARATION = eINSTANCE.getCmapVariableExp_referredVariable_VariableDeclaration();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.DmapHelperImpl <em>Dmap Helper</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.DmapHelperImpl
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.trace_ATL2QVTrPackageImpl#getDmapHelper()
		 * @generated
		 */
		EClass DMAP_HELPER = eINSTANCE.getDmapHelper();

		/**
		 * The meta object literal for the '<em><b>D3atl Helper</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DMAP_HELPER__D3ATL_HELPER = eINSTANCE.getDmapHelper_D3atlHelper();

		/**
		 * The meta object literal for the '<em><b>D4qvtr Function</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DMAP_HELPER__D4QVTR_FUNCTION = eINSTANCE.getDmapHelper_D4qvtrFunction();

		/**
		 * The meta object literal for the '<em><b>Domap Helper Attribute</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DMAP_HELPER__DOMAP_HELPER_ATTRIBUTE = eINSTANCE.getDmapHelper_DomapHelper_Attribute();

		/**
		 * The meta object literal for the '<em><b>Domap Helper Operation</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DMAP_HELPER__DOMAP_HELPER_OPERATION = eINSTANCE.getDmapHelper_DomapHelper_Operation();

		/**
		 * The meta object literal for the '<em><b>Result</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DMAP_HELPER__RESULT = eINSTANCE.getDmapHelper_Result();

		/**
		 * The meta object literal for the '<em><b>S0global</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DMAP_HELPER__S0GLOBAL = eINSTANCE.getDmapHelper_S0global();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.DmapOclExpressionImpl <em>Dmap Ocl Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.DmapOclExpressionImpl
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.trace_ATL2QVTrPackageImpl#getDmapOclExpression()
		 * @generated
		 */
		EClass DMAP_OCL_EXPRESSION = eINSTANCE.getDmapOclExpression();

		/**
		 * The meta object literal for the '<em><b>D3atl Expression</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DMAP_OCL_EXPRESSION__D3ATL_EXPRESSION = eINSTANCE.getDmapOclExpression_D3atlExpression();

		/**
		 * The meta object literal for the '<em><b>D4qvtr Expression</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DMAP_OCL_EXPRESSION__D4QVTR_EXPRESSION = eINSTANCE.getDmapOclExpression_D4qvtrExpression();

		/**
		 * The meta object literal for the '<em><b>Domap Boolean Exp</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DMAP_OCL_EXPRESSION__DOMAP_BOOLEAN_EXP = eINSTANCE.getDmapOclExpression_DomapBooleanExp();

		/**
		 * The meta object literal for the '<em><b>Domap If Exp</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DMAP_OCL_EXPRESSION__DOMAP_IF_EXP = eINSTANCE.getDmapOclExpression_DomapIfExp();

		/**
		 * The meta object literal for the '<em><b>Domap Integer Exp</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DMAP_OCL_EXPRESSION__DOMAP_INTEGER_EXP = eINSTANCE.getDmapOclExpression_DomapIntegerExp();

		/**
		 * The meta object literal for the '<em><b>Domap Navigation Or Attribute Call Exp Helper</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DMAP_OCL_EXPRESSION__DOMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER = eINSTANCE.getDmapOclExpression_DomapNavigationOrAttributeCallExp_Helper();

		/**
		 * The meta object literal for the '<em><b>Domap Navigation Or Attribute Call Exp Property</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DMAP_OCL_EXPRESSION__DOMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_PROPERTY = eINSTANCE.getDmapOclExpression_DomapNavigationOrAttributeCallExp_Property();

		/**
		 * The meta object literal for the '<em><b>Domap Ocl Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DMAP_OCL_EXPRESSION__DOMAP_OCL_TYPE = eINSTANCE.getDmapOclExpression_DomapOclType();

		/**
		 * The meta object literal for the '<em><b>Domap Operation Call Exp Helper</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DMAP_OCL_EXPRESSION__DOMAP_OPERATION_CALL_EXP_HELPER = eINSTANCE.getDmapOclExpression_DomapOperationCallExp_Helper();

		/**
		 * The meta object literal for the '<em><b>Domap Operation Call Exp Operation</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DMAP_OCL_EXPRESSION__DOMAP_OPERATION_CALL_EXP_OPERATION = eINSTANCE.getDmapOclExpression_DomapOperationCallExp_Operation();

		/**
		 * The meta object literal for the '<em><b>Domap Operator Call Exp</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DMAP_OCL_EXPRESSION__DOMAP_OPERATOR_CALL_EXP = eINSTANCE.getDmapOclExpression_DomapOperatorCallExp();

		/**
		 * The meta object literal for the '<em><b>Domap String Exp</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DMAP_OCL_EXPRESSION__DOMAP_STRING_EXP = eINSTANCE.getDmapOclExpression_DomapStringExp();

		/**
		 * The meta object literal for the '<em><b>Domap Variable Exp</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DMAP_OCL_EXPRESSION__DOMAP_VARIABLE_EXP = eINSTANCE.getDmapOclExpression_DomapVariableExp();

		/**
		 * The meta object literal for the '<em><b>Result</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DMAP_OCL_EXPRESSION__RESULT = eINSTANCE.getDmapOclExpression_Result();

		/**
		 * The meta object literal for the '<em><b>S0global</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DMAP_OCL_EXPRESSION__S0GLOBAL = eINSTANCE.getDmapOclExpression_S0global();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.DmapVariableExp_referredVariableImpl <em>Dmap Variable Exp referred Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.DmapVariableExp_referredVariableImpl
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.trace_ATL2QVTrPackageImpl#getDmapVariableExp_referredVariable()
		 * @generated
		 */
		EClass DMAP_VARIABLE_EXP_REFERRED_VARIABLE = eINSTANCE.getDmapVariableExp_referredVariable();

		/**
		 * The meta object literal for the '<em><b>D3atl Expression</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DMAP_VARIABLE_EXP_REFERRED_VARIABLE__D3ATL_EXPRESSION = eINSTANCE.getDmapVariableExp_referredVariable_D3atlExpression();

		/**
		 * The meta object literal for the '<em><b>D4qvtr Expression</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DMAP_VARIABLE_EXP_REFERRED_VARIABLE__D4QVTR_EXPRESSION = eINSTANCE.getDmapVariableExp_referredVariable_D4qvtrExpression();

		/**
		 * The meta object literal for the '<em><b>Domap Variable Exp referred Variable Helper</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DMAP_VARIABLE_EXP_REFERRED_VARIABLE__DOMAP_VARIABLE_EXP_REFERRED_VARIABLE_HELPER = eINSTANCE.getDmapVariableExp_referredVariable_DomapVariableExp_referredVariable_Helper();

		/**
		 * The meta object literal for the '<em><b>Domap Variable Exp referred Variable Variable Declaration</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DMAP_VARIABLE_EXP_REFERRED_VARIABLE__DOMAP_VARIABLE_EXP_REFERRED_VARIABLE_VARIABLE_DECLARATION = eINSTANCE.getDmapVariableExp_referredVariable_DomapVariableExp_referredVariable_VariableDeclaration();

		/**
		 * The meta object literal for the '<em><b>Result</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DMAP_VARIABLE_EXP_REFERRED_VARIABLE__RESULT = eINSTANCE.getDmapVariableExp_referredVariable_Result();

		/**
		 * The meta object literal for the '<em><b>S0global</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DMAP_VARIABLE_EXP_REFERRED_VARIABLE__S0GLOBAL = eINSTANCE.getDmapVariableExp_referredVariable_S0global();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.ImapHelperImpl <em>Imap Helper</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.ImapHelperImpl
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.trace_ATL2QVTrPackageImpl#getImapHelper()
		 * @generated
		 */
		EClass IMAP_HELPER = eINSTANCE.getImapHelper();

		/**
		 * The meta object literal for the '<em><b>S0global</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMAP_HELPER__S0GLOBAL = eINSTANCE.getImapHelper_S0global();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.ImapOclExpressionImpl <em>Imap Ocl Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.ImapOclExpressionImpl
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.trace_ATL2QVTrPackageImpl#getImapOclExpression()
		 * @generated
		 */
		EClass IMAP_OCL_EXPRESSION = eINSTANCE.getImapOclExpression();

		/**
		 * The meta object literal for the '<em><b>S0global</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMAP_OCL_EXPRESSION__S0GLOBAL = eINSTANCE.getImapOclExpression_S0global();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.ImapVariableExp_referredVariableImpl <em>Imap Variable Exp referred Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.ImapVariableExp_referredVariableImpl
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.trace_ATL2QVTrPackageImpl#getImapVariableExp_referredVariable()
		 * @generated
		 */
		EClass IMAP_VARIABLE_EXP_REFERRED_VARIABLE = eINSTANCE.getImapVariableExp_referredVariable();

		/**
		 * The meta object literal for the '<em><b>S0global</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMAP_VARIABLE_EXP_REFERRED_VARIABLE__S0GLOBAL = eINSTANCE.getImapVariableExp_referredVariable_S0global();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapBindingImpl <em>Tmap Binding</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapBindingImpl
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.trace_ATL2QVTrPackageImpl#getTmapBinding()
		 * @generated
		 */
		EClass TMAP_BINDING = eINSTANCE.getTmapBinding();

		/**
		 * The meta object literal for the '<em><b>S0global</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TMAP_BINDING__S0GLOBAL = eINSTANCE.getTmapBinding_S0global();

		/**
		 * The meta object literal for the '<em><b>T1property Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TMAP_BINDING__T1PROPERTY_NAME = eINSTANCE.getTmapBinding_T1propertyName();

		/**
		 * The meta object literal for the '<em><b>T3atl Binding</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_BINDING__T3ATL_BINDING = eINSTANCE.getTmapBinding_T3atlBinding();

		/**
		 * The meta object literal for the '<em><b>T3atl Expression</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_BINDING__T3ATL_EXPRESSION = eINSTANCE.getTmapBinding_T3atlExpression();

		/**
		 * The meta object literal for the '<em><b>T3atl Out Pattern Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_BINDING__T3ATL_OUT_PATTERN_ELEMENT = eINSTANCE.getTmapBinding_T3atlOutPatternElement();

		/**
		 * The meta object literal for the '<em><b>T4qvtr Expression</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_BINDING__T4QVTR_EXPRESSION = eINSTANCE.getTmapBinding_T4qvtrExpression();

		/**
		 * The meta object literal for the '<em><b>T4qvtr Part</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_BINDING__T4QVTR_PART = eINSTANCE.getTmapBinding_T4qvtrPart();

		/**
		 * The meta object literal for the '<em><b>T4qvtr Template</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_BINDING__T4QVTR_TEMPLATE = eINSTANCE.getTmapBinding_T4qvtrTemplate();

		/**
		 * The meta object literal for the '<em><b>Wmap Ocl Expression</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_BINDING__WMAP_OCL_EXPRESSION = eINSTANCE.getTmapBinding_WmapOclExpression();

		/**
		 * The meta object literal for the '<em><b>Wmap Simple Out Pattern Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_BINDING__WMAP_SIMPLE_OUT_PATTERN_ELEMENT = eINSTANCE.getTmapBinding_WmapSimpleOutPatternElement();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapBooleanExpImpl <em>Tmap Boolean Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapBooleanExpImpl
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.trace_ATL2QVTrPackageImpl#getTmapBooleanExp()
		 * @generated
		 */
		EClass TMAP_BOOLEAN_EXP = eINSTANCE.getTmapBooleanExp();

		/**
		 * The meta object literal for the '<em><b>Dispatcher</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_BOOLEAN_EXP__DISPATCHER = eINSTANCE.getTmapBooleanExp_Dispatcher();

		/**
		 * The meta object literal for the '<em><b>T1symbol</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TMAP_BOOLEAN_EXP__T1SYMBOL = eINSTANCE.getTmapBooleanExp_T1symbol();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapHelper_AttributeImpl <em>Tmap Helper Attribute</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapHelper_AttributeImpl
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.trace_ATL2QVTrPackageImpl#getTmapHelper_Attribute()
		 * @generated
		 */
		EClass TMAP_HELPER_ATTRIBUTE = eINSTANCE.getTmapHelper_Attribute();

		/**
		 * The meta object literal for the '<em><b>Dispatcher</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_HELPER_ATTRIBUTE__DISPATCHER = eINSTANCE.getTmapHelper_Attribute_Dispatcher();

		/**
		 * The meta object literal for the '<em><b>T1attribute Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TMAP_HELPER_ATTRIBUTE__T1ATTRIBUTE_NAME = eINSTANCE.getTmapHelper_Attribute_T1attributeName();

		/**
		 * The meta object literal for the '<em><b>T3atl Definition</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_HELPER_ATTRIBUTE__T3ATL_DEFINITION = eINSTANCE.getTmapHelper_Attribute_T3atlDefinition();

		/**
		 * The meta object literal for the '<em><b>T3atl Expression</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_HELPER_ATTRIBUTE__T3ATL_EXPRESSION = eINSTANCE.getTmapHelper_Attribute_T3atlExpression();

		/**
		 * The meta object literal for the '<em><b>T3atl Feature</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_HELPER_ATTRIBUTE__T3ATL_FEATURE = eINSTANCE.getTmapHelper_Attribute_T3atlFeature();

		/**
		 * The meta object literal for the '<em><b>T3atl Module</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_HELPER_ATTRIBUTE__T3ATL_MODULE = eINSTANCE.getTmapHelper_Attribute_T3atlModule();

		/**
		 * The meta object literal for the '<em><b>T3atl Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_HELPER_ATTRIBUTE__T3ATL_TYPE = eINSTANCE.getTmapHelper_Attribute_T3atlType();

		/**
		 * The meta object literal for the '<em><b>T4qvtr Expression</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_HELPER_ATTRIBUTE__T4QVTR_EXPRESSION = eINSTANCE.getTmapHelper_Attribute_T4qvtrExpression();

		/**
		 * The meta object literal for the '<em><b>T4qvtr Transformation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_HELPER_ATTRIBUTE__T4QVTR_TRANSFORMATION = eINSTANCE.getTmapHelper_Attribute_T4qvtrTransformation();

		/**
		 * The meta object literal for the '<em><b>Wmap Helper Context</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_HELPER_ATTRIBUTE__WMAP_HELPER_CONTEXT = eINSTANCE.getTmapHelper_Attribute_WmapHelper_Context();

		/**
		 * The meta object literal for the '<em><b>Wmap Module</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_HELPER_ATTRIBUTE__WMAP_MODULE = eINSTANCE.getTmapHelper_Attribute_WmapModule();

		/**
		 * The meta object literal for the '<em><b>Wmap Ocl Expression</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_HELPER_ATTRIBUTE__WMAP_OCL_EXPRESSION = eINSTANCE.getTmapHelper_Attribute_WmapOclExpression();

		/**
		 * The meta object literal for the '<em><b>S0local</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TMAP_HELPER_ATTRIBUTE__S0LOCAL = eINSTANCE.getTmapHelper_Attribute_S0local();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapHelper_ContextImpl <em>Tmap Helper Context</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapHelper_ContextImpl
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.trace_ATL2QVTrPackageImpl#getTmapHelper_Context()
		 * @generated
		 */
		EClass TMAP_HELPER_CONTEXT = eINSTANCE.getTmapHelper_Context();

		/**
		 * The meta object literal for the '<em><b>S0global</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TMAP_HELPER_CONTEXT__S0GLOBAL = eINSTANCE.getTmapHelper_Context_S0global();

		/**
		 * The meta object literal for the '<em><b>T3atl Context</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_HELPER_CONTEXT__T3ATL_CONTEXT = eINSTANCE.getTmapHelper_Context_T3atlContext();

		/**
		 * The meta object literal for the '<em><b>T3atl Definition</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_HELPER_CONTEXT__T3ATL_DEFINITION = eINSTANCE.getTmapHelper_Context_T3atlDefinition();

		/**
		 * The meta object literal for the '<em><b>T3atl Helper</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_HELPER_CONTEXT__T3ATL_HELPER = eINSTANCE.getTmapHelper_Context_T3atlHelper();

		/**
		 * The meta object literal for the '<em><b>T3atl Return Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_HELPER_CONTEXT__T3ATL_RETURN_TYPE = eINSTANCE.getTmapHelper_Context_T3atlReturnType();

		/**
		 * The meta object literal for the '<em><b>T4qvtr Function</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_HELPER_CONTEXT__T4QVTR_FUNCTION = eINSTANCE.getTmapHelper_Context_T4qvtrFunction();

		/**
		 * The meta object literal for the '<em><b>T4qvtr Parameter</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_HELPER_CONTEXT__T4QVTR_PARAMETER = eINSTANCE.getTmapHelper_Context_T4qvtrParameter();

		/**
		 * The meta object literal for the '<em><b>Wmap Variable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_HELPER_CONTEXT__WMAP_VARIABLE = eINSTANCE.getTmapHelper_Context_WmapVariable();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapHelper_OperationImpl <em>Tmap Helper Operation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapHelper_OperationImpl
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.trace_ATL2QVTrPackageImpl#getTmapHelper_Operation()
		 * @generated
		 */
		EClass TMAP_HELPER_OPERATION = eINSTANCE.getTmapHelper_Operation();

		/**
		 * The meta object literal for the '<em><b>Dispatcher</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_HELPER_OPERATION__DISPATCHER = eINSTANCE.getTmapHelper_Operation_Dispatcher();

		/**
		 * The meta object literal for the '<em><b>T1operation Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TMAP_HELPER_OPERATION__T1OPERATION_NAME = eINSTANCE.getTmapHelper_Operation_T1operationName();

		/**
		 * The meta object literal for the '<em><b>T3atl Definition</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_HELPER_OPERATION__T3ATL_DEFINITION = eINSTANCE.getTmapHelper_Operation_T3atlDefinition();

		/**
		 * The meta object literal for the '<em><b>T3atl Expression</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_HELPER_OPERATION__T3ATL_EXPRESSION = eINSTANCE.getTmapHelper_Operation_T3atlExpression();

		/**
		 * The meta object literal for the '<em><b>T3atl Feature</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_HELPER_OPERATION__T3ATL_FEATURE = eINSTANCE.getTmapHelper_Operation_T3atlFeature();

		/**
		 * The meta object literal for the '<em><b>T3atl Module</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_HELPER_OPERATION__T3ATL_MODULE = eINSTANCE.getTmapHelper_Operation_T3atlModule();

		/**
		 * The meta object literal for the '<em><b>T3atl Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_HELPER_OPERATION__T3ATL_TYPE = eINSTANCE.getTmapHelper_Operation_T3atlType();

		/**
		 * The meta object literal for the '<em><b>T4qvtr Expression</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_HELPER_OPERATION__T4QVTR_EXPRESSION = eINSTANCE.getTmapHelper_Operation_T4qvtrExpression();

		/**
		 * The meta object literal for the '<em><b>T4qvtr Transformation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_HELPER_OPERATION__T4QVTR_TRANSFORMATION = eINSTANCE.getTmapHelper_Operation_T4qvtrTransformation();

		/**
		 * The meta object literal for the '<em><b>Wmap Helper Context</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_HELPER_OPERATION__WMAP_HELPER_CONTEXT = eINSTANCE.getTmapHelper_Operation_WmapHelper_Context();

		/**
		 * The meta object literal for the '<em><b>Wmap Module</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_HELPER_OPERATION__WMAP_MODULE = eINSTANCE.getTmapHelper_Operation_WmapModule();

		/**
		 * The meta object literal for the '<em><b>Wmap Ocl Expression</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_HELPER_OPERATION__WMAP_OCL_EXPRESSION = eINSTANCE.getTmapHelper_Operation_WmapOclExpression();

		/**
		 * The meta object literal for the '<em><b>S0local</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TMAP_HELPER_OPERATION__S0LOCAL = eINSTANCE.getTmapHelper_Operation_S0local();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapIfExpImpl <em>Tmap If Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapIfExpImpl
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.trace_ATL2QVTrPackageImpl#getTmapIfExp()
		 * @generated
		 */
		EClass TMAP_IF_EXP = eINSTANCE.getTmapIfExp();

		/**
		 * The meta object literal for the '<em><b>Dispatcher</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_IF_EXP__DISPATCHER = eINSTANCE.getTmapIfExp_Dispatcher();

		/**
		 * The meta object literal for the '<em><b>T3atl Condition</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_IF_EXP__T3ATL_CONDITION = eINSTANCE.getTmapIfExp_T3atlCondition();

		/**
		 * The meta object literal for the '<em><b>T3atl Else</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_IF_EXP__T3ATL_ELSE = eINSTANCE.getTmapIfExp_T3atlElse();

		/**
		 * The meta object literal for the '<em><b>T3atl Then</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_IF_EXP__T3ATL_THEN = eINSTANCE.getTmapIfExp_T3atlThen();

		/**
		 * The meta object literal for the '<em><b>T4qvtr Condition</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_IF_EXP__T4QVTR_CONDITION = eINSTANCE.getTmapIfExp_T4qvtrCondition();

		/**
		 * The meta object literal for the '<em><b>T4qvtr Else</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_IF_EXP__T4QVTR_ELSE = eINSTANCE.getTmapIfExp_T4qvtrElse();

		/**
		 * The meta object literal for the '<em><b>T4qvtr Then</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_IF_EXP__T4QVTR_THEN = eINSTANCE.getTmapIfExp_T4qvtrThen();

		/**
		 * The meta object literal for the '<em><b>Wmap Ocl Expression</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_IF_EXP__WMAP_OCL_EXPRESSION = eINSTANCE.getTmapIfExp_WmapOclExpression();

		/**
		 * The meta object literal for the '<em><b>Wmap Ocl Expression1</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_IF_EXP__WMAP_OCL_EXPRESSION1 = eINSTANCE.getTmapIfExp_WmapOclExpression1();

		/**
		 * The meta object literal for the '<em><b>Wmap Ocl Expression2</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_IF_EXP__WMAP_OCL_EXPRESSION2 = eINSTANCE.getTmapIfExp_WmapOclExpression2();

		/**
		 * The meta object literal for the '<em><b>S0local</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TMAP_IF_EXP__S0LOCAL = eINSTANCE.getTmapIfExp_S0local();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapInPatternImpl <em>Tmap In Pattern</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapInPatternImpl
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.trace_ATL2QVTrPackageImpl#getTmapInPattern()
		 * @generated
		 */
		EClass TMAP_IN_PATTERN = eINSTANCE.getTmapInPattern();

		/**
		 * The meta object literal for the '<em><b>S0global</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TMAP_IN_PATTERN__S0GLOBAL = eINSTANCE.getTmapInPattern_S0global();

		/**
		 * The meta object literal for the '<em><b>T3atl Model</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_IN_PATTERN__T3ATL_MODEL = eINSTANCE.getTmapInPattern_T3atlModel();

		/**
		 * The meta object literal for the '<em><b>T3atl Pattern</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_IN_PATTERN__T3ATL_PATTERN = eINSTANCE.getTmapInPattern_T3atlPattern();

		/**
		 * The meta object literal for the '<em><b>T3atl Rule</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_IN_PATTERN__T3ATL_RULE = eINSTANCE.getTmapInPattern_T3atlRule();

		/**
		 * The meta object literal for the '<em><b>T4qvtr Domain</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_IN_PATTERN__T4QVTR_DOMAIN = eINSTANCE.getTmapInPattern_T4qvtrDomain();

		/**
		 * The meta object literal for the '<em><b>T4qvtr Relation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_IN_PATTERN__T4QVTR_RELATION = eINSTANCE.getTmapInPattern_T4qvtrRelation();

		/**
		 * The meta object literal for the '<em><b>T4qvtr Typed Model</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_IN_PATTERN__T4QVTR_TYPED_MODEL = eINSTANCE.getTmapInPattern_T4qvtrTypedModel();

		/**
		 * The meta object literal for the '<em><b>Wmap Matched Rule</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_IN_PATTERN__WMAP_MATCHED_RULE = eINSTANCE.getTmapInPattern_WmapMatchedRule();

		/**
		 * The meta object literal for the '<em><b>Wmap Ocl Metamodel</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_IN_PATTERN__WMAP_OCL_METAMODEL = eINSTANCE.getTmapInPattern_WmapOclMetamodel();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapInPattern_filterImpl <em>Tmap In Pattern filter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapInPattern_filterImpl
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.trace_ATL2QVTrPackageImpl#getTmapInPattern_filter()
		 * @generated
		 */
		EClass TMAP_IN_PATTERN_FILTER = eINSTANCE.getTmapInPattern_filter();

		/**
		 * The meta object literal for the '<em><b>S0global</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TMAP_IN_PATTERN_FILTER__S0GLOBAL = eINSTANCE.getTmapInPattern_filter_S0global();

		/**
		 * The meta object literal for the '<em><b>T3atl Expression</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_IN_PATTERN_FILTER__T3ATL_EXPRESSION = eINSTANCE.getTmapInPattern_filter_T3atlExpression();

		/**
		 * The meta object literal for the '<em><b>T3atl Pattern</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_IN_PATTERN_FILTER__T3ATL_PATTERN = eINSTANCE.getTmapInPattern_filter_T3atlPattern();

		/**
		 * The meta object literal for the '<em><b>T3atl Rule</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_IN_PATTERN_FILTER__T3ATL_RULE = eINSTANCE.getTmapInPattern_filter_T3atlRule();

		/**
		 * The meta object literal for the '<em><b>T4p</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_IN_PATTERN_FILTER__T4P = eINSTANCE.getTmapInPattern_filter_T4p();

		/**
		 * The meta object literal for the '<em><b>T4qvtr Domain</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_IN_PATTERN_FILTER__T4QVTR_DOMAIN = eINSTANCE.getTmapInPattern_filter_T4qvtrDomain();

		/**
		 * The meta object literal for the '<em><b>T4qvtr Expression</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_IN_PATTERN_FILTER__T4QVTR_EXPRESSION = eINSTANCE.getTmapInPattern_filter_T4qvtrExpression();

		/**
		 * The meta object literal for the '<em><b>T4qvtr Relation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_IN_PATTERN_FILTER__T4QVTR_RELATION = eINSTANCE.getTmapInPattern_filter_T4qvtrRelation();

		/**
		 * The meta object literal for the '<em><b>T4w</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_IN_PATTERN_FILTER__T4W = eINSTANCE.getTmapInPattern_filter_T4w();

		/**
		 * The meta object literal for the '<em><b>Wmap In Pattern</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_IN_PATTERN_FILTER__WMAP_IN_PATTERN = eINSTANCE.getTmapInPattern_filter_WmapInPattern();

		/**
		 * The meta object literal for the '<em><b>Wmap Matched Rule</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_IN_PATTERN_FILTER__WMAP_MATCHED_RULE = eINSTANCE.getTmapInPattern_filter_WmapMatchedRule();

		/**
		 * The meta object literal for the '<em><b>Wmap Ocl Expression</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_IN_PATTERN_FILTER__WMAP_OCL_EXPRESSION = eINSTANCE.getTmapInPattern_filter_WmapOclExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapIntegerExpImpl <em>Tmap Integer Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapIntegerExpImpl
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.trace_ATL2QVTrPackageImpl#getTmapIntegerExp()
		 * @generated
		 */
		EClass TMAP_INTEGER_EXP = eINSTANCE.getTmapIntegerExp();

		/**
		 * The meta object literal for the '<em><b>Dispatcher</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_INTEGER_EXP__DISPATCHER = eINSTANCE.getTmapIntegerExp_Dispatcher();

		/**
		 * The meta object literal for the '<em><b>T1symbol</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TMAP_INTEGER_EXP__T1SYMBOL = eINSTANCE.getTmapIntegerExp_T1symbol();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapMatchedRuleImpl <em>Tmap Matched Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapMatchedRuleImpl
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.trace_ATL2QVTrPackageImpl#getTmapMatchedRule()
		 * @generated
		 */
		EClass TMAP_MATCHED_RULE = eINSTANCE.getTmapMatchedRule();

		/**
		 * The meta object literal for the '<em><b>S0global</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TMAP_MATCHED_RULE__S0GLOBAL = eINSTANCE.getTmapMatchedRule_S0global();

		/**
		 * The meta object literal for the '<em><b>T1rule Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TMAP_MATCHED_RULE__T1RULE_NAME = eINSTANCE.getTmapMatchedRule_T1ruleName();

		/**
		 * The meta object literal for the '<em><b>T3atl Module</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_MATCHED_RULE__T3ATL_MODULE = eINSTANCE.getTmapMatchedRule_T3atlModule();

		/**
		 * The meta object literal for the '<em><b>T3atl Out Pattern</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_MATCHED_RULE__T3ATL_OUT_PATTERN = eINSTANCE.getTmapMatchedRule_T3atlOutPattern();

		/**
		 * The meta object literal for the '<em><b>T3matched Rule</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_MATCHED_RULE__T3MATCHED_RULE = eINSTANCE.getTmapMatchedRule_T3matchedRule();

		/**
		 * The meta object literal for the '<em><b>T4 6</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_MATCHED_RULE__T4_6 = eINSTANCE.getTmapMatchedRule_T4_6();

		/**
		 * The meta object literal for the '<em><b>T4qvtr Relation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_MATCHED_RULE__T4QVTR_RELATION = eINSTANCE.getTmapMatchedRule_T4qvtrRelation();

		/**
		 * The meta object literal for the '<em><b>T4qvtr Transformation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_MATCHED_RULE__T4QVTR_TRANSFORMATION = eINSTANCE.getTmapMatchedRule_T4qvtrTransformation();

		/**
		 * The meta object literal for the '<em><b>Wmap Module</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_MATCHED_RULE__WMAP_MODULE = eINSTANCE.getTmapMatchedRule_WmapModule();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapMatchedRule_superImpl <em>Tmap Matched Rule super</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapMatchedRule_superImpl
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.trace_ATL2QVTrPackageImpl#getTmapMatchedRule_super()
		 * @generated
		 */
		EClass TMAP_MATCHED_RULE_SUPER = eINSTANCE.getTmapMatchedRule_super();

		/**
		 * The meta object literal for the '<em><b>S0global</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TMAP_MATCHED_RULE_SUPER__S0GLOBAL = eINSTANCE.getTmapMatchedRule_super_S0global();

		/**
		 * The meta object literal for the '<em><b>T3atl Child Rule</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_MATCHED_RULE_SUPER__T3ATL_CHILD_RULE = eINSTANCE.getTmapMatchedRule_super_T3atlChildRule();

		/**
		 * The meta object literal for the '<em><b>T3atl Super Rule</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_MATCHED_RULE_SUPER__T3ATL_SUPER_RULE = eINSTANCE.getTmapMatchedRule_super_T3atlSuperRule();

		/**
		 * The meta object literal for the '<em><b>T4qvtr Overridden Relation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_MATCHED_RULE_SUPER__T4QVTR_OVERRIDDEN_RELATION = eINSTANCE.getTmapMatchedRule_super_T4qvtrOverriddenRelation();

		/**
		 * The meta object literal for the '<em><b>T4qvtr Overrides Relation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_MATCHED_RULE_SUPER__T4QVTR_OVERRIDES_RELATION = eINSTANCE.getTmapMatchedRule_super_T4qvtrOverridesRelation();

		/**
		 * The meta object literal for the '<em><b>Wmap Matched Rule</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_MATCHED_RULE_SUPER__WMAP_MATCHED_RULE = eINSTANCE.getTmapMatchedRule_super_WmapMatchedRule();

		/**
		 * The meta object literal for the '<em><b>Wmap Matched Rule1</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_MATCHED_RULE_SUPER__WMAP_MATCHED_RULE1 = eINSTANCE.getTmapMatchedRule_super_WmapMatchedRule1();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapModuleImpl <em>Tmap Module</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapModuleImpl
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.trace_ATL2QVTrPackageImpl#getTmapModule()
		 * @generated
		 */
		EClass TMAP_MODULE = eINSTANCE.getTmapModule();

		/**
		 * The meta object literal for the '<em><b>S0global</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TMAP_MODULE__S0GLOBAL = eINSTANCE.getTmapModule_S0global();

		/**
		 * The meta object literal for the '<em><b>T1tx Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TMAP_MODULE__T1TX_NAME = eINSTANCE.getTmapModule_T1txName();

		/**
		 * The meta object literal for the '<em><b>T3atl Module</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_MODULE__T3ATL_MODULE = eINSTANCE.getTmapModule_T3atlModule();

		/**
		 * The meta object literal for the '<em><b>T4 3</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_MODULE__T4_3 = eINSTANCE.getTmapModule_T4_3();

		/**
		 * The meta object literal for the '<em><b>T4 4</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_MODULE__T4_4 = eINSTANCE.getTmapModule_T4_4();

		/**
		 * The meta object literal for the '<em><b>T4 5</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_MODULE__T4_5 = eINSTANCE.getTmapModule_T4_5();

		/**
		 * The meta object literal for the '<em><b>T4 6</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_MODULE__T4_6 = eINSTANCE.getTmapModule_T4_6();

		/**
		 * The meta object literal for the '<em><b>T4qvtr Transformation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_MODULE__T4QVTR_TRANSFORMATION = eINSTANCE.getTmapModule_T4qvtrTransformation();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapNavigationOrAttributeCallExp_HelperImpl <em>Tmap Navigation Or Attribute Call Exp Helper</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapNavigationOrAttributeCallExp_HelperImpl
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.trace_ATL2QVTrPackageImpl#getTmapNavigationOrAttributeCallExp_Helper()
		 * @generated
		 */
		EClass TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER = eINSTANCE.getTmapNavigationOrAttributeCallExp_Helper();

		/**
		 * The meta object literal for the '<em><b>Dispatcher</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER__DISPATCHER = eINSTANCE.getTmapNavigationOrAttributeCallExp_Helper_Dispatcher();

		/**
		 * The meta object literal for the '<em><b>T1property Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER__T1PROPERTY_NAME = eINSTANCE.getTmapNavigationOrAttributeCallExp_Helper_T1propertyName();

		/**
		 * The meta object literal for the '<em><b>T3atl Attributes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER__T3ATL_ATTRIBUTES = eINSTANCE.getTmapNavigationOrAttributeCallExp_Helper_T3atlAttributes();

		/**
		 * The meta object literal for the '<em><b>T3atl Module</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER__T3ATL_MODULE = eINSTANCE.getTmapNavigationOrAttributeCallExp_Helper_T3atlModule();

		/**
		 * The meta object literal for the '<em><b>T3atl Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER__T3ATL_SOURCE = eINSTANCE.getTmapNavigationOrAttributeCallExp_Helper_T3atlSource();

		/**
		 * The meta object literal for the '<em><b>T4qvtr Operation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER__T4QVTR_OPERATION = eINSTANCE.getTmapNavigationOrAttributeCallExp_Helper_T4qvtrOperation();

		/**
		 * The meta object literal for the '<em><b>T4qvtr Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER__T4QVTR_SOURCE = eINSTANCE.getTmapNavigationOrAttributeCallExp_Helper_T4qvtrSource();

		/**
		 * The meta object literal for the '<em><b>T4qvtr Source Argument</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER__T4QVTR_SOURCE_ARGUMENT = eINSTANCE.getTmapNavigationOrAttributeCallExp_Helper_T4qvtrSourceArgument();

		/**
		 * The meta object literal for the '<em><b>T4qvtr This Variable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER__T4QVTR_THIS_VARIABLE = eINSTANCE.getTmapNavigationOrAttributeCallExp_Helper_T4qvtrThisVariable();

		/**
		 * The meta object literal for the '<em><b>T4qvtr Transformation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER__T4QVTR_TRANSFORMATION = eINSTANCE.getTmapNavigationOrAttributeCallExp_Helper_T4qvtrTransformation();

		/**
		 * The meta object literal for the '<em><b>Wmap Helper</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER__WMAP_HELPER = eINSTANCE.getTmapNavigationOrAttributeCallExp_Helper_WmapHelper();

		/**
		 * The meta object literal for the '<em><b>Wmap Module</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER__WMAP_MODULE = eINSTANCE.getTmapNavigationOrAttributeCallExp_Helper_WmapModule();

		/**
		 * The meta object literal for the '<em><b>Wmap Ocl Expression</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER__WMAP_OCL_EXPRESSION = eINSTANCE.getTmapNavigationOrAttributeCallExp_Helper_WmapOclExpression();

		/**
		 * The meta object literal for the '<em><b>S0local</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_HELPER__S0LOCAL = eINSTANCE.getTmapNavigationOrAttributeCallExp_Helper_S0local();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapNavigationOrAttributeCallExp_PropertyImpl <em>Tmap Navigation Or Attribute Call Exp Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapNavigationOrAttributeCallExp_PropertyImpl
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.trace_ATL2QVTrPackageImpl#getTmapNavigationOrAttributeCallExp_Property()
		 * @generated
		 */
		EClass TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_PROPERTY = eINSTANCE.getTmapNavigationOrAttributeCallExp_Property();

		/**
		 * The meta object literal for the '<em><b>Dispatcher</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_PROPERTY__DISPATCHER = eINSTANCE.getTmapNavigationOrAttributeCallExp_Property_Dispatcher();

		/**
		 * The meta object literal for the '<em><b>T1property Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_PROPERTY__T1PROPERTY_NAME = eINSTANCE.getTmapNavigationOrAttributeCallExp_Property_T1propertyName();

		/**
		 * The meta object literal for the '<em><b>T3atl Attributes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_PROPERTY__T3ATL_ATTRIBUTES = eINSTANCE.getTmapNavigationOrAttributeCallExp_Property_T3atlAttributes();

		/**
		 * The meta object literal for the '<em><b>T3atl Module</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_PROPERTY__T3ATL_MODULE = eINSTANCE.getTmapNavigationOrAttributeCallExp_Property_T3atlModule();

		/**
		 * The meta object literal for the '<em><b>T3atl Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_PROPERTY__T3ATL_SOURCE = eINSTANCE.getTmapNavigationOrAttributeCallExp_Property_T3atlSource();

		/**
		 * The meta object literal for the '<em><b>T4qvtr Property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_PROPERTY__T4QVTR_PROPERTY = eINSTANCE.getTmapNavigationOrAttributeCallExp_Property_T4qvtrProperty();

		/**
		 * The meta object literal for the '<em><b>T4qvtr Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_PROPERTY__T4QVTR_SOURCE = eINSTANCE.getTmapNavigationOrAttributeCallExp_Property_T4qvtrSource();

		/**
		 * The meta object literal for the '<em><b>Wmap Ocl Expression</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_PROPERTY__WMAP_OCL_EXPRESSION = eINSTANCE.getTmapNavigationOrAttributeCallExp_Property_WmapOclExpression();

		/**
		 * The meta object literal for the '<em><b>S0local</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_PROPERTY__S0LOCAL = eINSTANCE.getTmapNavigationOrAttributeCallExp_Property_S0local();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapOclMetamodelImpl <em>Tmap Ocl Metamodel</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapOclMetamodelImpl
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.trace_ATL2QVTrPackageImpl#getTmapOclMetamodel()
		 * @generated
		 */
		EClass TMAP_OCL_METAMODEL = eINSTANCE.getTmapOclMetamodel();

		/**
		 * The meta object literal for the '<em><b>S0global</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TMAP_OCL_METAMODEL__S0GLOBAL = eINSTANCE.getTmapOclMetamodel_S0global();

		/**
		 * The meta object literal for the '<em><b>T1tm Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TMAP_OCL_METAMODEL__T1TM_NAME = eINSTANCE.getTmapOclMetamodel_T1tmName();

		/**
		 * The meta object literal for the '<em><b>T3ocl Metamodel</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_OCL_METAMODEL__T3OCL_METAMODEL = eINSTANCE.getTmapOclMetamodel_T3oclMetamodel();

		/**
		 * The meta object literal for the '<em><b>T4qvtr Typed Model</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_OCL_METAMODEL__T4QVTR_TYPED_MODEL = eINSTANCE.getTmapOclMetamodel_T4qvtrTypedModel();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapOclModel_INImpl <em>Tmap Ocl Model IN</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapOclModel_INImpl
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.trace_ATL2QVTrPackageImpl#getTmapOclModel_IN()
		 * @generated
		 */
		EClass TMAP_OCL_MODEL_IN = eINSTANCE.getTmapOclModel_IN();

		/**
		 * The meta object literal for the '<em><b>S0global</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TMAP_OCL_MODEL_IN__S0GLOBAL = eINSTANCE.getTmapOclModel_IN_S0global();

		/**
		 * The meta object literal for the '<em><b>T3atl Module</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_OCL_MODEL_IN__T3ATL_MODULE = eINSTANCE.getTmapOclModel_IN_T3atlModule();

		/**
		 * The meta object literal for the '<em><b>T3ocl Metamodel</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_OCL_MODEL_IN__T3OCL_METAMODEL = eINSTANCE.getTmapOclModel_IN_T3oclMetamodel();

		/**
		 * The meta object literal for the '<em><b>T3ocl Model</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_OCL_MODEL_IN__T3OCL_MODEL = eINSTANCE.getTmapOclModel_IN_T3oclModel();

		/**
		 * The meta object literal for the '<em><b>T4qvtr Packages</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_OCL_MODEL_IN__T4QVTR_PACKAGES = eINSTANCE.getTmapOclModel_IN_T4qvtrPackages();

		/**
		 * The meta object literal for the '<em><b>T4qvtr Transformation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_OCL_MODEL_IN__T4QVTR_TRANSFORMATION = eINSTANCE.getTmapOclModel_IN_T4qvtrTransformation();

		/**
		 * The meta object literal for the '<em><b>T4qvtr Typed Model</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_OCL_MODEL_IN__T4QVTR_TYPED_MODEL = eINSTANCE.getTmapOclModel_IN_T4qvtrTypedModel();

		/**
		 * The meta object literal for the '<em><b>Wmap Module</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_OCL_MODEL_IN__WMAP_MODULE = eINSTANCE.getTmapOclModel_IN_WmapModule();

		/**
		 * The meta object literal for the '<em><b>Wmap Ocl Metamodel</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_OCL_MODEL_IN__WMAP_OCL_METAMODEL = eINSTANCE.getTmapOclModel_IN_WmapOclMetamodel();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapOclModel_OUTImpl <em>Tmap Ocl Model OUT</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapOclModel_OUTImpl
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.trace_ATL2QVTrPackageImpl#getTmapOclModel_OUT()
		 * @generated
		 */
		EClass TMAP_OCL_MODEL_OUT = eINSTANCE.getTmapOclModel_OUT();

		/**
		 * The meta object literal for the '<em><b>S0global</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TMAP_OCL_MODEL_OUT__S0GLOBAL = eINSTANCE.getTmapOclModel_OUT_S0global();

		/**
		 * The meta object literal for the '<em><b>T3atl Module</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_OCL_MODEL_OUT__T3ATL_MODULE = eINSTANCE.getTmapOclModel_OUT_T3atlModule();

		/**
		 * The meta object literal for the '<em><b>T3ocl Metamodel</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_OCL_MODEL_OUT__T3OCL_METAMODEL = eINSTANCE.getTmapOclModel_OUT_T3oclMetamodel();

		/**
		 * The meta object literal for the '<em><b>T3ocl Model</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_OCL_MODEL_OUT__T3OCL_MODEL = eINSTANCE.getTmapOclModel_OUT_T3oclModel();

		/**
		 * The meta object literal for the '<em><b>T4qvtr Packages</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_OCL_MODEL_OUT__T4QVTR_PACKAGES = eINSTANCE.getTmapOclModel_OUT_T4qvtrPackages();

		/**
		 * The meta object literal for the '<em><b>T4qvtr Transformation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_OCL_MODEL_OUT__T4QVTR_TRANSFORMATION = eINSTANCE.getTmapOclModel_OUT_T4qvtrTransformation();

		/**
		 * The meta object literal for the '<em><b>T4qvtr Typed Model</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_OCL_MODEL_OUT__T4QVTR_TYPED_MODEL = eINSTANCE.getTmapOclModel_OUT_T4qvtrTypedModel();

		/**
		 * The meta object literal for the '<em><b>Wmap Module</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_OCL_MODEL_OUT__WMAP_MODULE = eINSTANCE.getTmapOclModel_OUT_WmapModule();

		/**
		 * The meta object literal for the '<em><b>Wmap Ocl Metamodel</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_OCL_MODEL_OUT__WMAP_OCL_METAMODEL = eINSTANCE.getTmapOclModel_OUT_WmapOclMetamodel();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapOclTypeImpl <em>Tmap Ocl Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapOclTypeImpl
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.trace_ATL2QVTrPackageImpl#getTmapOclType()
		 * @generated
		 */
		EClass TMAP_OCL_TYPE = eINSTANCE.getTmapOclType();

		/**
		 * The meta object literal for the '<em><b>Dispatcher</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_OCL_TYPE__DISPATCHER = eINSTANCE.getTmapOclType_Dispatcher();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapOperationCallExp_HelperImpl <em>Tmap Operation Call Exp Helper</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapOperationCallExp_HelperImpl
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.trace_ATL2QVTrPackageImpl#getTmapOperationCallExp_Helper()
		 * @generated
		 */
		EClass TMAP_OPERATION_CALL_EXP_HELPER = eINSTANCE.getTmapOperationCallExp_Helper();

		/**
		 * The meta object literal for the '<em><b>Dispatcher</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_OPERATION_CALL_EXP_HELPER__DISPATCHER = eINSTANCE.getTmapOperationCallExp_Helper_Dispatcher();

		/**
		 * The meta object literal for the '<em><b>T1operation Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TMAP_OPERATION_CALL_EXP_HELPER__T1OPERATION_NAME = eINSTANCE.getTmapOperationCallExp_Helper_T1operationName();

		/**
		 * The meta object literal for the '<em><b>T3atl Module</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_OPERATION_CALL_EXP_HELPER__T3ATL_MODULE = eINSTANCE.getTmapOperationCallExp_Helper_T3atlModule();

		/**
		 * The meta object literal for the '<em><b>T3atl Operations</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_OPERATION_CALL_EXP_HELPER__T3ATL_OPERATIONS = eINSTANCE.getTmapOperationCallExp_Helper_T3atlOperations();

		/**
		 * The meta object literal for the '<em><b>T3atl Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_OPERATION_CALL_EXP_HELPER__T3ATL_SOURCE = eINSTANCE.getTmapOperationCallExp_Helper_T3atlSource();

		/**
		 * The meta object literal for the '<em><b>T4qvtr Operation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_OPERATION_CALL_EXP_HELPER__T4QVTR_OPERATION = eINSTANCE.getTmapOperationCallExp_Helper_T4qvtrOperation();

		/**
		 * The meta object literal for the '<em><b>T4qvtr Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_OPERATION_CALL_EXP_HELPER__T4QVTR_SOURCE = eINSTANCE.getTmapOperationCallExp_Helper_T4qvtrSource();

		/**
		 * The meta object literal for the '<em><b>T4qvtr Source Argument</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_OPERATION_CALL_EXP_HELPER__T4QVTR_SOURCE_ARGUMENT = eINSTANCE.getTmapOperationCallExp_Helper_T4qvtrSourceArgument();

		/**
		 * The meta object literal for the '<em><b>T4qvtr This Variable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_OPERATION_CALL_EXP_HELPER__T4QVTR_THIS_VARIABLE = eINSTANCE.getTmapOperationCallExp_Helper_T4qvtrThisVariable();

		/**
		 * The meta object literal for the '<em><b>T4qvtr Transformation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_OPERATION_CALL_EXP_HELPER__T4QVTR_TRANSFORMATION = eINSTANCE.getTmapOperationCallExp_Helper_T4qvtrTransformation();

		/**
		 * The meta object literal for the '<em><b>Wmap Helper</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_OPERATION_CALL_EXP_HELPER__WMAP_HELPER = eINSTANCE.getTmapOperationCallExp_Helper_WmapHelper();

		/**
		 * The meta object literal for the '<em><b>Wmap Module</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_OPERATION_CALL_EXP_HELPER__WMAP_MODULE = eINSTANCE.getTmapOperationCallExp_Helper_WmapModule();

		/**
		 * The meta object literal for the '<em><b>Wmap Ocl Expression</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_OPERATION_CALL_EXP_HELPER__WMAP_OCL_EXPRESSION = eINSTANCE.getTmapOperationCallExp_Helper_WmapOclExpression();

		/**
		 * The meta object literal for the '<em><b>S0local</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TMAP_OPERATION_CALL_EXP_HELPER__S0LOCAL = eINSTANCE.getTmapOperationCallExp_Helper_S0local();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapOperationCallExp_OperationImpl <em>Tmap Operation Call Exp Operation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapOperationCallExp_OperationImpl
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.trace_ATL2QVTrPackageImpl#getTmapOperationCallExp_Operation()
		 * @generated
		 */
		EClass TMAP_OPERATION_CALL_EXP_OPERATION = eINSTANCE.getTmapOperationCallExp_Operation();

		/**
		 * The meta object literal for the '<em><b>Dispatcher</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_OPERATION_CALL_EXP_OPERATION__DISPATCHER = eINSTANCE.getTmapOperationCallExp_Operation_Dispatcher();

		/**
		 * The meta object literal for the '<em><b>T1operation Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TMAP_OPERATION_CALL_EXP_OPERATION__T1OPERATION_NAME = eINSTANCE.getTmapOperationCallExp_Operation_T1operationName();

		/**
		 * The meta object literal for the '<em><b>T3atl Module</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_OPERATION_CALL_EXP_OPERATION__T3ATL_MODULE = eINSTANCE.getTmapOperationCallExp_Operation_T3atlModule();

		/**
		 * The meta object literal for the '<em><b>T3atl Operations</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_OPERATION_CALL_EXP_OPERATION__T3ATL_OPERATIONS = eINSTANCE.getTmapOperationCallExp_Operation_T3atlOperations();

		/**
		 * The meta object literal for the '<em><b>T3atl Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_OPERATION_CALL_EXP_OPERATION__T3ATL_SOURCE = eINSTANCE.getTmapOperationCallExp_Operation_T3atlSource();

		/**
		 * The meta object literal for the '<em><b>T4qvtr Operation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_OPERATION_CALL_EXP_OPERATION__T4QVTR_OPERATION = eINSTANCE.getTmapOperationCallExp_Operation_T4qvtrOperation();

		/**
		 * The meta object literal for the '<em><b>T4qvtr Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_OPERATION_CALL_EXP_OPERATION__T4QVTR_SOURCE = eINSTANCE.getTmapOperationCallExp_Operation_T4qvtrSource();

		/**
		 * The meta object literal for the '<em><b>Wmap Ocl Expression</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_OPERATION_CALL_EXP_OPERATION__WMAP_OCL_EXPRESSION = eINSTANCE.getTmapOperationCallExp_Operation_WmapOclExpression();

		/**
		 * The meta object literal for the '<em><b>S0local</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TMAP_OPERATION_CALL_EXP_OPERATION__S0LOCAL = eINSTANCE.getTmapOperationCallExp_Operation_S0local();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapOperationCallExp_argumentImpl <em>Tmap Operation Call Exp argument</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapOperationCallExp_argumentImpl
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.trace_ATL2QVTrPackageImpl#getTmapOperationCallExp_argument()
		 * @generated
		 */
		EClass TMAP_OPERATION_CALL_EXP_ARGUMENT = eINSTANCE.getTmapOperationCallExp_argument();

		/**
		 * The meta object literal for the '<em><b>S0global</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TMAP_OPERATION_CALL_EXP_ARGUMENT__S0GLOBAL = eINSTANCE.getTmapOperationCallExp_argument_S0global();

		/**
		 * The meta object literal for the '<em><b>T3atl Argument</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_OPERATION_CALL_EXP_ARGUMENT__T3ATL_ARGUMENT = eINSTANCE.getTmapOperationCallExp_argument_T3atlArgument();

		/**
		 * The meta object literal for the '<em><b>T3atl Parent</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_OPERATION_CALL_EXP_ARGUMENT__T3ATL_PARENT = eINSTANCE.getTmapOperationCallExp_argument_T3atlParent();

		/**
		 * The meta object literal for the '<em><b>T4qvtr Argument</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_OPERATION_CALL_EXP_ARGUMENT__T4QVTR_ARGUMENT = eINSTANCE.getTmapOperationCallExp_argument_T4qvtrArgument();

		/**
		 * The meta object literal for the '<em><b>T4qvtr Parent</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_OPERATION_CALL_EXP_ARGUMENT__T4QVTR_PARENT = eINSTANCE.getTmapOperationCallExp_argument_T4qvtrParent();

		/**
		 * The meta object literal for the '<em><b>Wmap Ocl Expression</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_OPERATION_CALL_EXP_ARGUMENT__WMAP_OCL_EXPRESSION = eINSTANCE.getTmapOperationCallExp_argument_WmapOclExpression();

		/**
		 * The meta object literal for the '<em><b>Wmap Ocl Expression1</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_OPERATION_CALL_EXP_ARGUMENT__WMAP_OCL_EXPRESSION1 = eINSTANCE.getTmapOperationCallExp_argument_WmapOclExpression1();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapOperatorCallExpImpl <em>Tmap Operator Call Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapOperatorCallExpImpl
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.trace_ATL2QVTrPackageImpl#getTmapOperatorCallExp()
		 * @generated
		 */
		EClass TMAP_OPERATOR_CALL_EXP = eINSTANCE.getTmapOperatorCallExp();

		/**
		 * The meta object literal for the '<em><b>Dispatcher</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_OPERATOR_CALL_EXP__DISPATCHER = eINSTANCE.getTmapOperatorCallExp_Dispatcher();

		/**
		 * The meta object literal for the '<em><b>T1operation Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TMAP_OPERATOR_CALL_EXP__T1OPERATION_NAME = eINSTANCE.getTmapOperatorCallExp_T1operationName();

		/**
		 * The meta object literal for the '<em><b>T3atl Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_OPERATOR_CALL_EXP__T3ATL_SOURCE = eINSTANCE.getTmapOperatorCallExp_T3atlSource();

		/**
		 * The meta object literal for the '<em><b>T4qvtr Operation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_OPERATOR_CALL_EXP__T4QVTR_OPERATION = eINSTANCE.getTmapOperatorCallExp_T4qvtrOperation();

		/**
		 * The meta object literal for the '<em><b>T4qvtr Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_OPERATOR_CALL_EXP__T4QVTR_SOURCE = eINSTANCE.getTmapOperatorCallExp_T4qvtrSource();

		/**
		 * The meta object literal for the '<em><b>Wmap Ocl Expression</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_OPERATOR_CALL_EXP__WMAP_OCL_EXPRESSION = eINSTANCE.getTmapOperatorCallExp_WmapOclExpression();

		/**
		 * The meta object literal for the '<em><b>S0local</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TMAP_OPERATOR_CALL_EXP__S0LOCAL = eINSTANCE.getTmapOperatorCallExp_S0local();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapSimpleInPatternElementImpl <em>Tmap Simple In Pattern Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapSimpleInPatternElementImpl
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.trace_ATL2QVTrPackageImpl#getTmapSimpleInPatternElement()
		 * @generated
		 */
		EClass TMAP_SIMPLE_IN_PATTERN_ELEMENT = eINSTANCE.getTmapSimpleInPatternElement();

		/**
		 * The meta object literal for the '<em><b>S0global</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TMAP_SIMPLE_IN_PATTERN_ELEMENT__S0GLOBAL = eINSTANCE.getTmapSimpleInPatternElement_S0global();

		/**
		 * The meta object literal for the '<em><b>T1element Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TMAP_SIMPLE_IN_PATTERN_ELEMENT__T1ELEMENT_NAME = eINSTANCE.getTmapSimpleInPatternElement_T1elementName();

		/**
		 * The meta object literal for the '<em><b>T3atl Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_SIMPLE_IN_PATTERN_ELEMENT__T3ATL_ELEMENT = eINSTANCE.getTmapSimpleInPatternElement_T3atlElement();

		/**
		 * The meta object literal for the '<em><b>T3atl Pattern</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_SIMPLE_IN_PATTERN_ELEMENT__T3ATL_PATTERN = eINSTANCE.getTmapSimpleInPatternElement_T3atlPattern();

		/**
		 * The meta object literal for the '<em><b>T3atl Rule</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_SIMPLE_IN_PATTERN_ELEMENT__T3ATL_RULE = eINSTANCE.getTmapSimpleInPatternElement_T3atlRule();

		/**
		 * The meta object literal for the '<em><b>T4qvtr Domain</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_SIMPLE_IN_PATTERN_ELEMENT__T4QVTR_DOMAIN = eINSTANCE.getTmapSimpleInPatternElement_T4qvtrDomain();

		/**
		 * The meta object literal for the '<em><b>T4qvtr Pattern</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_SIMPLE_IN_PATTERN_ELEMENT__T4QVTR_PATTERN = eINSTANCE.getTmapSimpleInPatternElement_T4qvtrPattern();

		/**
		 * The meta object literal for the '<em><b>T4qvtr Relation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_SIMPLE_IN_PATTERN_ELEMENT__T4QVTR_RELATION = eINSTANCE.getTmapSimpleInPatternElement_T4qvtrRelation();

		/**
		 * The meta object literal for the '<em><b>T4qvtr Template</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_SIMPLE_IN_PATTERN_ELEMENT__T4QVTR_TEMPLATE = eINSTANCE.getTmapSimpleInPatternElement_T4qvtrTemplate();

		/**
		 * The meta object literal for the '<em><b>T4qvtr Variable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_SIMPLE_IN_PATTERN_ELEMENT__T4QVTR_VARIABLE = eINSTANCE.getTmapSimpleInPatternElement_T4qvtrVariable();

		/**
		 * The meta object literal for the '<em><b>Wmap In Pattern</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_SIMPLE_IN_PATTERN_ELEMENT__WMAP_IN_PATTERN = eINSTANCE.getTmapSimpleInPatternElement_WmapInPattern();

		/**
		 * The meta object literal for the '<em><b>Wmap Matched Rule</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_SIMPLE_IN_PATTERN_ELEMENT__WMAP_MATCHED_RULE = eINSTANCE.getTmapSimpleInPatternElement_WmapMatchedRule();

		/**
		 * The meta object literal for the '<em><b>Wmap Variable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_SIMPLE_IN_PATTERN_ELEMENT__WMAP_VARIABLE = eINSTANCE.getTmapSimpleInPatternElement_WmapVariable();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapSimpleOutPatternElementImpl <em>Tmap Simple Out Pattern Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapSimpleOutPatternElementImpl
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.trace_ATL2QVTrPackageImpl#getTmapSimpleOutPatternElement()
		 * @generated
		 */
		EClass TMAP_SIMPLE_OUT_PATTERN_ELEMENT = eINSTANCE.getTmapSimpleOutPatternElement();

		/**
		 * The meta object literal for the '<em><b>S0global</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TMAP_SIMPLE_OUT_PATTERN_ELEMENT__S0GLOBAL = eINSTANCE.getTmapSimpleOutPatternElement_S0global();

		/**
		 * The meta object literal for the '<em><b>T1element Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TMAP_SIMPLE_OUT_PATTERN_ELEMENT__T1ELEMENT_NAME = eINSTANCE.getTmapSimpleOutPatternElement_T1elementName();

		/**
		 * The meta object literal for the '<em><b>T3atl Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_SIMPLE_OUT_PATTERN_ELEMENT__T3ATL_ELEMENT = eINSTANCE.getTmapSimpleOutPatternElement_T3atlElement();

		/**
		 * The meta object literal for the '<em><b>T3atl Metamodel</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_SIMPLE_OUT_PATTERN_ELEMENT__T3ATL_METAMODEL = eINSTANCE.getTmapSimpleOutPatternElement_T3atlMetamodel();

		/**
		 * The meta object literal for the '<em><b>T3atl Pattern</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_SIMPLE_OUT_PATTERN_ELEMENT__T3ATL_PATTERN = eINSTANCE.getTmapSimpleOutPatternElement_T3atlPattern();

		/**
		 * The meta object literal for the '<em><b>T3atl Rule</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_SIMPLE_OUT_PATTERN_ELEMENT__T3ATL_RULE = eINSTANCE.getTmapSimpleOutPatternElement_T3atlRule();

		/**
		 * The meta object literal for the '<em><b>T3atl Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_SIMPLE_OUT_PATTERN_ELEMENT__T3ATL_TYPE = eINSTANCE.getTmapSimpleOutPatternElement_T3atlType();

		/**
		 * The meta object literal for the '<em><b>T4qvtr Domain</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_SIMPLE_OUT_PATTERN_ELEMENT__T4QVTR_DOMAIN = eINSTANCE.getTmapSimpleOutPatternElement_T4qvtrDomain();

		/**
		 * The meta object literal for the '<em><b>T4qvtr Pattern</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_SIMPLE_OUT_PATTERN_ELEMENT__T4QVTR_PATTERN = eINSTANCE.getTmapSimpleOutPatternElement_T4qvtrPattern();

		/**
		 * The meta object literal for the '<em><b>T4qvtr Relation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_SIMPLE_OUT_PATTERN_ELEMENT__T4QVTR_RELATION = eINSTANCE.getTmapSimpleOutPatternElement_T4qvtrRelation();

		/**
		 * The meta object literal for the '<em><b>T4qvtr Template</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_SIMPLE_OUT_PATTERN_ELEMENT__T4QVTR_TEMPLATE = eINSTANCE.getTmapSimpleOutPatternElement_T4qvtrTemplate();

		/**
		 * The meta object literal for the '<em><b>T4qvtr Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_SIMPLE_OUT_PATTERN_ELEMENT__T4QVTR_TYPE = eINSTANCE.getTmapSimpleOutPatternElement_T4qvtrType();

		/**
		 * The meta object literal for the '<em><b>T4qvtr Typed Model</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_SIMPLE_OUT_PATTERN_ELEMENT__T4QVTR_TYPED_MODEL = eINSTANCE.getTmapSimpleOutPatternElement_T4qvtrTypedModel();

		/**
		 * The meta object literal for the '<em><b>T4qvtr Variable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_SIMPLE_OUT_PATTERN_ELEMENT__T4QVTR_VARIABLE = eINSTANCE.getTmapSimpleOutPatternElement_T4qvtrVariable();

		/**
		 * The meta object literal for the '<em><b>Wmap Matched Rule</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_SIMPLE_OUT_PATTERN_ELEMENT__WMAP_MATCHED_RULE = eINSTANCE.getTmapSimpleOutPatternElement_WmapMatchedRule();

		/**
		 * The meta object literal for the '<em><b>Wmap Ocl Metamodel</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_SIMPLE_OUT_PATTERN_ELEMENT__WMAP_OCL_METAMODEL = eINSTANCE.getTmapSimpleOutPatternElement_WmapOclMetamodel();

		/**
		 * The meta object literal for the '<em><b>Wmap Variable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_SIMPLE_OUT_PATTERN_ELEMENT__WMAP_VARIABLE = eINSTANCE.getTmapSimpleOutPatternElement_WmapVariable();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapStringExpImpl <em>Tmap String Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapStringExpImpl
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.trace_ATL2QVTrPackageImpl#getTmapStringExp()
		 * @generated
		 */
		EClass TMAP_STRING_EXP = eINSTANCE.getTmapStringExp();

		/**
		 * The meta object literal for the '<em><b>Dispatcher</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_STRING_EXP__DISPATCHER = eINSTANCE.getTmapStringExp_Dispatcher();

		/**
		 * The meta object literal for the '<em><b>T1symbol</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TMAP_STRING_EXP__T1SYMBOL = eINSTANCE.getTmapStringExp_T1symbol();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapVariableImpl <em>Tmap Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapVariableImpl
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.trace_ATL2QVTrPackageImpl#getTmapVariable()
		 * @generated
		 */
		EClass TMAP_VARIABLE = eINSTANCE.getTmapVariable();

		/**
		 * The meta object literal for the '<em><b>S0global</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TMAP_VARIABLE__S0GLOBAL = eINSTANCE.getTmapVariable_S0global();

		/**
		 * The meta object literal for the '<em><b>T3atl Variable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_VARIABLE__T3ATL_VARIABLE = eINSTANCE.getTmapVariable_T3atlVariable();

		/**
		 * The meta object literal for the '<em><b>T4qvtr Variable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_VARIABLE__T4QVTR_VARIABLE = eINSTANCE.getTmapVariable_T4qvtrVariable();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapVariableExpImpl <em>Tmap Variable Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapVariableExpImpl
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.trace_ATL2QVTrPackageImpl#getTmapVariableExp()
		 * @generated
		 */
		EClass TMAP_VARIABLE_EXP = eINSTANCE.getTmapVariableExp();

		/**
		 * The meta object literal for the '<em><b>Dispatcher</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_VARIABLE_EXP__DISPATCHER = eINSTANCE.getTmapVariableExp_Dispatcher();

		/**
		 * The meta object literal for the '<em><b>T1var Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TMAP_VARIABLE_EXP__T1VAR_NAME = eINSTANCE.getTmapVariableExp_T1varName();

		/**
		 * The meta object literal for the '<em><b>T3atl Variable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_VARIABLE_EXP__T3ATL_VARIABLE = eINSTANCE.getTmapVariableExp_T3atlVariable();

		/**
		 * The meta object literal for the '<em><b>Wmap Variable Exp referred Variable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_VARIABLE_EXP__WMAP_VARIABLE_EXP_REFERRED_VARIABLE = eINSTANCE.getTmapVariableExp_WmapVariableExp_referredVariable();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapVariableExp_referredVariable_HelperImpl <em>Tmap Variable Exp referred Variable Helper</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapVariableExp_referredVariable_HelperImpl
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.trace_ATL2QVTrPackageImpl#getTmapVariableExp_referredVariable_Helper()
		 * @generated
		 */
		EClass TMAP_VARIABLE_EXP_REFERRED_VARIABLE_HELPER = eINSTANCE.getTmapVariableExp_referredVariable_Helper();

		/**
		 * The meta object literal for the '<em><b>Dispatcher</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_VARIABLE_EXP_REFERRED_VARIABLE_HELPER__DISPATCHER = eINSTANCE.getTmapVariableExp_referredVariable_Helper_Dispatcher();

		/**
		 * The meta object literal for the '<em><b>T3atl Helper</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_VARIABLE_EXP_REFERRED_VARIABLE_HELPER__T3ATL_HELPER = eINSTANCE.getTmapVariableExp_referredVariable_Helper_T3atlHelper();

		/**
		 * The meta object literal for the '<em><b>T3atl Variable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_VARIABLE_EXP_REFERRED_VARIABLE_HELPER__T3ATL_VARIABLE = eINSTANCE.getTmapVariableExp_referredVariable_Helper_T3atlVariable();

		/**
		 * The meta object literal for the '<em><b>T4qvtr Variable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_VARIABLE_EXP_REFERRED_VARIABLE_HELPER__T4QVTR_VARIABLE = eINSTANCE.getTmapVariableExp_referredVariable_Helper_T4qvtrVariable();

		/**
		 * The meta object literal for the '<em><b>S0local</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TMAP_VARIABLE_EXP_REFERRED_VARIABLE_HELPER__S0LOCAL = eINSTANCE.getTmapVariableExp_referredVariable_Helper_S0local();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapVariableExp_referredVariable_VariableDeclarationImpl <em>Tmap Variable Exp referred Variable Variable Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapVariableExp_referredVariable_VariableDeclarationImpl
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.trace_ATL2QVTrPackageImpl#getTmapVariableExp_referredVariable_VariableDeclaration()
		 * @generated
		 */
		EClass TMAP_VARIABLE_EXP_REFERRED_VARIABLE_VARIABLE_DECLARATION = eINSTANCE.getTmapVariableExp_referredVariable_VariableDeclaration();

		/**
		 * The meta object literal for the '<em><b>Dispatcher</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_VARIABLE_EXP_REFERRED_VARIABLE_VARIABLE_DECLARATION__DISPATCHER = eINSTANCE.getTmapVariableExp_referredVariable_VariableDeclaration_Dispatcher();

		/**
		 * The meta object literal for the '<em><b>T3atl Variable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_VARIABLE_EXP_REFERRED_VARIABLE_VARIABLE_DECLARATION__T3ATL_VARIABLE = eINSTANCE.getTmapVariableExp_referredVariable_VariableDeclaration_T3atlVariable();

		/**
		 * The meta object literal for the '<em><b>T4qvtr Variable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMAP_VARIABLE_EXP_REFERRED_VARIABLE_VARIABLE_DECLARATION__T4QVTR_VARIABLE = eINSTANCE.getTmapVariableExp_referredVariable_VariableDeclaration_T4qvtrVariable();

		/**
		 * The meta object literal for the '<em><b>S0local</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TMAP_VARIABLE_EXP_REFERRED_VARIABLE_VARIABLE_DECLARATION__S0LOCAL = eINSTANCE.getTmapVariableExp_referredVariable_VariableDeclaration_S0local();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TxATL2QVTrImpl <em>Tx ATL2QV Tr</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TxATL2QVTrImpl
		 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.trace_ATL2QVTrPackageImpl#getTxATL2QVTr()
		 * @generated
		 */
		EClass TX_ATL2QV_TR = eINSTANCE.getTxATL2QVTr();

	}

} //trace_ATL2QVTrPackage
