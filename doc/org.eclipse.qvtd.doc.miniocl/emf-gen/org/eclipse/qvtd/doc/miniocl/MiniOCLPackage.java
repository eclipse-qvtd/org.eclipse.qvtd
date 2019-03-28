/*******************************************************************************
 * Copyright (c) 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     Adolfo Sanchez-Barbudo Herrera - initial API and implementation
 *******************************************************************************/
/**
 */
package org.eclipse.qvtd.doc.miniocl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
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
 * @see org.eclipse.qvtd.doc.miniocl.MiniOCLFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore"
 * @generated
 */
public interface MiniOCLPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "miniocl";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/qvtd/doc/MiniOCL/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "mocl";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	MiniOCLPackage eINSTANCE = org.eclipse.qvtd.doc.miniocl.impl.MiniOCLPackageImpl.init();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.doc.miniocl.BooleanLiteralExp <em>Boolean Literal Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Boolean Literal Exp</em>'.
	 * @see org.eclipse.qvtd.doc.miniocl.BooleanLiteralExp
	 * @generated
	 */
	EClass getBooleanLiteralExp();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.doc.miniocl.BooleanLiteralExp#isBooleanSymbol <em>Boolean Symbol</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Boolean Symbol</em>'.
	 * @see org.eclipse.qvtd.doc.miniocl.BooleanLiteralExp#isBooleanSymbol()
	 * @see #getBooleanLiteralExp()
	 * @generated
	 */
	EAttribute getBooleanLiteralExp_BooleanSymbol();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.doc.miniocl.Element <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Element</em>'.
	 * @see org.eclipse.qvtd.doc.miniocl.Element
	 * @generated
	 */
	EClass getElement();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.doc.miniocl.Feature <em>Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Feature</em>'.
	 * @see org.eclipse.qvtd.doc.miniocl.Feature
	 * @generated
	 */
	EClass getFeature();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.doc.miniocl.Import <em>Import</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Import</em>'.
	 * @see org.eclipse.qvtd.doc.miniocl.Import
	 * @generated
	 */
	EClass getImport();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.doc.miniocl.Import#getUri <em>Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Uri</em>'.
	 * @see org.eclipse.qvtd.doc.miniocl.Import#getUri()
	 * @see #getImport()
	 * @generated
	 */
	EAttribute getImport_Uri();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.doc.miniocl.Import#getAlias <em>Alias</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Alias</em>'.
	 * @see org.eclipse.qvtd.doc.miniocl.Import#getAlias()
	 * @see #getImport()
	 * @generated
	 */
	EAttribute getImport_Alias();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.doc.miniocl.IntegerLiteralExp <em>Integer Literal Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Integer Literal Exp</em>'.
	 * @see org.eclipse.qvtd.doc.miniocl.IntegerLiteralExp
	 * @generated
	 */
	EClass getIntegerLiteralExp();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.doc.miniocl.IntegerLiteralExp#getIntegerSymbol <em>Integer Symbol</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Integer Symbol</em>'.
	 * @see org.eclipse.qvtd.doc.miniocl.IntegerLiteralExp#getIntegerSymbol()
	 * @see #getIntegerLiteralExp()
	 * @generated
	 */
	EAttribute getIntegerLiteralExp_IntegerSymbol();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.doc.miniocl.IteratorExp <em>Iterator Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Iterator Exp</em>'.
	 * @see org.eclipse.qvtd.doc.miniocl.IteratorExp
	 * @generated
	 */
	EClass getIteratorExp();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.doc.miniocl.IteratorExp#getIterator <em>Iterator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Iterator</em>'.
	 * @see org.eclipse.qvtd.doc.miniocl.IteratorExp#getIterator()
	 * @see #getIteratorExp()
	 * @generated
	 */
	EAttribute getIteratorExp_Iterator();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.doc.miniocl.IterateExp <em>Iterate Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Iterate Exp</em>'.
	 * @see org.eclipse.qvtd.doc.miniocl.IterateExp
	 * @generated
	 */
	EClass getIterateExp();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.doc.miniocl.IterateExp#getOwnedResult <em>Owned Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Result</em>'.
	 * @see org.eclipse.qvtd.doc.miniocl.IterateExp#getOwnedResult()
	 * @see #getIterateExp()
	 * @generated
	 */
	EReference getIterateExp_OwnedResult();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.doc.miniocl.LetExp <em>Let Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Let Exp</em>'.
	 * @see org.eclipse.qvtd.doc.miniocl.LetExp
	 * @generated
	 */
	EClass getLetExp();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.doc.miniocl.LetExp#getOwnedIn <em>Owned In</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned In</em>'.
	 * @see org.eclipse.qvtd.doc.miniocl.LetExp#getOwnedIn()
	 * @see #getLetExp()
	 * @generated
	 */
	EReference getLetExp_OwnedIn();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.doc.miniocl.LetExp#getOwnedVariable <em>Owned Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Variable</em>'.
	 * @see org.eclipse.qvtd.doc.miniocl.LetExp#getOwnedVariable()
	 * @see #getLetExp()
	 * @generated
	 */
	EReference getLetExp_OwnedVariable();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.doc.miniocl.LiteralExp <em>Literal Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Literal Exp</em>'.
	 * @see org.eclipse.qvtd.doc.miniocl.LiteralExp
	 * @generated
	 */
	EClass getLiteralExp();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.doc.miniocl.LoopExp <em>Loop Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Loop Exp</em>'.
	 * @see org.eclipse.qvtd.doc.miniocl.LoopExp
	 * @generated
	 */
	EClass getLoopExp();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.doc.miniocl.LoopExp#getOwnedIterator <em>Owned Iterator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Iterator</em>'.
	 * @see org.eclipse.qvtd.doc.miniocl.LoopExp#getOwnedIterator()
	 * @see #getLoopExp()
	 * @generated
	 */
	EReference getLoopExp_OwnedIterator();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.doc.miniocl.LoopExp#getOwnedBody <em>Owned Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Owned Body</em>'.
	 * @see org.eclipse.qvtd.doc.miniocl.LoopExp#getOwnedBody()
	 * @see #getLoopExp()
	 * @generated
	 */
	EReference getLoopExp_OwnedBody();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.doc.miniocl.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Named Element</em>'.
	 * @see org.eclipse.qvtd.doc.miniocl.NamedElement
	 * @generated
	 */
	EClass getNamedElement();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.doc.miniocl.NamedElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.qvtd.doc.miniocl.NamedElement#getName()
	 * @see #getNamedElement()
	 * @generated
	 */
	EAttribute getNamedElement_Name();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.doc.miniocl.Namespace <em>Namespace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Namespace</em>'.
	 * @see org.eclipse.qvtd.doc.miniocl.Namespace
	 * @generated
	 */
	EClass getNamespace();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.doc.miniocl.NullLiteralExp <em>Null Literal Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Null Literal Exp</em>'.
	 * @see org.eclipse.qvtd.doc.miniocl.NullLiteralExp
	 * @generated
	 */
	EClass getNullLiteralExp();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.doc.miniocl.TypedElement <em>Typed Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Typed Element</em>'.
	 * @see org.eclipse.qvtd.doc.miniocl.TypedElement
	 * @generated
	 */
	EClass getTypedElement();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.doc.miniocl.TypedElement#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see org.eclipse.qvtd.doc.miniocl.TypedElement#getType()
	 * @see #getTypedElement()
	 * @generated
	 */
	EReference getTypedElement_Type();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.qvtd.doc.miniocl.CollectionKind <em>Collection Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Collection Kind</em>'.
	 * @see org.eclipse.qvtd.doc.miniocl.CollectionKind
	 * @generated
	 */
	EEnum getCollectionKind();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.doc.miniocl.ExpressionInOCL <em>Expression In OCL</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Expression In OCL</em>'.
	 * @see org.eclipse.qvtd.doc.miniocl.ExpressionInOCL
	 * @generated
	 */
	EClass getExpressionInOCL();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.doc.miniocl.ExpressionInOCL#getOwnedSelfVar <em>Owned Self Var</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Self Var</em>'.
	 * @see org.eclipse.qvtd.doc.miniocl.ExpressionInOCL#getOwnedSelfVar()
	 * @see #getExpressionInOCL()
	 * @generated
	 */
	EReference getExpressionInOCL_OwnedSelfVar();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.doc.miniocl.ExpressionInOCL#getOwnedBody <em>Owned Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Body</em>'.
	 * @see org.eclipse.qvtd.doc.miniocl.ExpressionInOCL#getOwnedBody()
	 * @see #getExpressionInOCL()
	 * @generated
	 */
	EReference getExpressionInOCL_OwnedBody();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.doc.miniocl.Constraint <em>Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Constraint</em>'.
	 * @see org.eclipse.qvtd.doc.miniocl.Constraint
	 * @generated
	 */
	EClass getConstraint();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.doc.miniocl.Constraint#getOwnedSpecification <em>Owned Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Specification</em>'.
	 * @see org.eclipse.qvtd.doc.miniocl.Constraint#getOwnedSpecification()
	 * @see #getConstraint()
	 * @generated
	 */
	EReference getConstraint_OwnedSpecification();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.doc.miniocl.Constraint#getConstrainedElement <em>Constrained Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Constrained Element</em>'.
	 * @see org.eclipse.qvtd.doc.miniocl.Constraint#getConstrainedElement()
	 * @see #getConstraint()
	 * @generated
	 */
	EReference getConstraint_ConstrainedElement();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.doc.miniocl.OCLExpression <em>OCL Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>OCL Expression</em>'.
	 * @see org.eclipse.qvtd.doc.miniocl.OCLExpression
	 * @generated
	 */
	EClass getOCLExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.doc.miniocl.OpaqueExpression <em>Opaque Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Opaque Expression</em>'.
	 * @see org.eclipse.qvtd.doc.miniocl.OpaqueExpression
	 * @generated
	 */
	EClass getOpaqueExpression();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.doc.miniocl.OpaqueExpression#getLanguage <em>Language</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Language</em>'.
	 * @see org.eclipse.qvtd.doc.miniocl.OpaqueExpression#getLanguage()
	 * @see #getOpaqueExpression()
	 * @generated
	 */
	EAttribute getOpaqueExpression_Language();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.doc.miniocl.CallExp <em>Call Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Call Exp</em>'.
	 * @see org.eclipse.qvtd.doc.miniocl.CallExp
	 * @generated
	 */
	EClass getCallExp();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.doc.miniocl.CallExp#getOwnedSource <em>Owned Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Source</em>'.
	 * @see org.eclipse.qvtd.doc.miniocl.CallExp#getOwnedSource()
	 * @see #getCallExp()
	 * @generated
	 */
	EReference getCallExp_OwnedSource();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.doc.miniocl.Root <em>Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Root</em>'.
	 * @see org.eclipse.qvtd.doc.miniocl.Root
	 * @generated
	 */
	EClass getRoot();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.doc.miniocl.Root#getOwnedConstraints <em>Owned Constraints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Constraints</em>'.
	 * @see org.eclipse.qvtd.doc.miniocl.Root#getOwnedConstraints()
	 * @see #getRoot()
	 * @generated
	 */
	EReference getRoot_OwnedConstraints();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.doc.miniocl.Root#getOwnedImports <em>Owned Imports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Imports</em>'.
	 * @see org.eclipse.qvtd.doc.miniocl.Root#getOwnedImports()
	 * @see #getRoot()
	 * @generated
	 */
	EReference getRoot_OwnedImports();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.doc.miniocl.Root#getOwnedPackages <em>Owned Packages</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Packages</em>'.
	 * @see org.eclipse.qvtd.doc.miniocl.Root#getOwnedPackages()
	 * @see #getRoot()
	 * @generated
	 */
	EReference getRoot_OwnedPackages();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.doc.miniocl.Package <em>Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Package</em>'.
	 * @see org.eclipse.qvtd.doc.miniocl.Package
	 * @generated
	 */
	EClass getPackage();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.doc.miniocl.Package#getOwnedClasses <em>Owned Classes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Classes</em>'.
	 * @see org.eclipse.qvtd.doc.miniocl.Package#getOwnedClasses()
	 * @see #getPackage()
	 * @generated
	 */
	EReference getPackage_OwnedClasses();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.doc.miniocl.Package#getOwnedPackages <em>Owned Packages</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Packages</em>'.
	 * @see org.eclipse.qvtd.doc.miniocl.Package#getOwnedPackages()
	 * @see #getPackage()
	 * @generated
	 */
	EReference getPackage_OwnedPackages();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.doc.miniocl.Class <em>Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Class</em>'.
	 * @see org.eclipse.qvtd.doc.miniocl.Class
	 * @generated
	 */
	EClass getClass_();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.doc.miniocl.Class#getSuperClasses <em>Super Classes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Super Classes</em>'.
	 * @see org.eclipse.qvtd.doc.miniocl.Class#getSuperClasses()
	 * @see #getClass_()
	 * @generated
	 */
	EReference getClass_SuperClasses();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.doc.miniocl.Class#getOwnedOperations <em>Owned Operations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Operations</em>'.
	 * @see org.eclipse.qvtd.doc.miniocl.Class#getOwnedOperations()
	 * @see #getClass_()
	 * @generated
	 */
	EReference getClass_OwnedOperations();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.doc.miniocl.Class#getOwnedProperties <em>Owned Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Properties</em>'.
	 * @see org.eclipse.qvtd.doc.miniocl.Class#getOwnedProperties()
	 * @see #getClass_()
	 * @generated
	 */
	EReference getClass_OwnedProperties();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.doc.miniocl.CollectionLiteralExp <em>Collection Literal Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Collection Literal Exp</em>'.
	 * @see org.eclipse.qvtd.doc.miniocl.CollectionLiteralExp
	 * @generated
	 */
	EClass getCollectionLiteralExp();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.doc.miniocl.CollectionLiteralExp#getOwnedParts <em>Owned Parts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Parts</em>'.
	 * @see org.eclipse.qvtd.doc.miniocl.CollectionLiteralExp#getOwnedParts()
	 * @see #getCollectionLiteralExp()
	 * @generated
	 */
	EReference getCollectionLiteralExp_OwnedParts();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.doc.miniocl.CollectionLiteralExp#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see org.eclipse.qvtd.doc.miniocl.CollectionLiteralExp#getKind()
	 * @see #getCollectionLiteralExp()
	 * @generated
	 */
	EAttribute getCollectionLiteralExp_Kind();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.doc.miniocl.CollectionItem <em>Collection Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Collection Item</em>'.
	 * @see org.eclipse.qvtd.doc.miniocl.CollectionItem
	 * @generated
	 */
	EClass getCollectionItem();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.doc.miniocl.CollectionItem#getOwnedItem <em>Owned Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Item</em>'.
	 * @see org.eclipse.qvtd.doc.miniocl.CollectionItem#getOwnedItem()
	 * @see #getCollectionItem()
	 * @generated
	 */
	EReference getCollectionItem_OwnedItem();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.doc.miniocl.CollectionLiteralPart <em>Collection Literal Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Collection Literal Part</em>'.
	 * @see org.eclipse.qvtd.doc.miniocl.CollectionLiteralPart
	 * @generated
	 */
	EClass getCollectionLiteralPart();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.doc.miniocl.CollectionRange <em>Collection Range</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Collection Range</em>'.
	 * @see org.eclipse.qvtd.doc.miniocl.CollectionRange
	 * @generated
	 */
	EClass getCollectionRange();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.doc.miniocl.CollectionRange#getOwnedFirst <em>Owned First</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned First</em>'.
	 * @see org.eclipse.qvtd.doc.miniocl.CollectionRange#getOwnedFirst()
	 * @see #getCollectionRange()
	 * @generated
	 */
	EReference getCollectionRange_OwnedFirst();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.doc.miniocl.CollectionRange#getOwnedLast <em>Owned Last</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Last</em>'.
	 * @see org.eclipse.qvtd.doc.miniocl.CollectionRange#getOwnedLast()
	 * @see #getCollectionRange()
	 * @generated
	 */
	EReference getCollectionRange_OwnedLast();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.doc.miniocl.Property <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property</em>'.
	 * @see org.eclipse.qvtd.doc.miniocl.Property
	 * @generated
	 */
	EClass getProperty();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.doc.miniocl.Property#getOwningClass <em>Owning Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Class</em>'.
	 * @see org.eclipse.qvtd.doc.miniocl.Property#getOwningClass()
	 * @see #getProperty()
	 * @generated
	 */
	EReference getProperty_OwningClass();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.doc.miniocl.Property#getLowerBound <em>Lower Bound</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Lower Bound</em>'.
	 * @see org.eclipse.qvtd.doc.miniocl.Property#getLowerBound()
	 * @see #getProperty()
	 * @generated
	 */
	EAttribute getProperty_LowerBound();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.doc.miniocl.Property#getUpperBound <em>Upper Bound</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Upper Bound</em>'.
	 * @see org.eclipse.qvtd.doc.miniocl.Property#getUpperBound()
	 * @see #getProperty()
	 * @generated
	 */
	EAttribute getProperty_UpperBound();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.doc.miniocl.Operation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operation</em>'.
	 * @see org.eclipse.qvtd.doc.miniocl.Operation
	 * @generated
	 */
	EClass getOperation();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.doc.miniocl.Operation#getOwnedParameters <em>Owned Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Parameters</em>'.
	 * @see org.eclipse.qvtd.doc.miniocl.Operation#getOwnedParameters()
	 * @see #getOperation()
	 * @generated
	 */
	EReference getOperation_OwnedParameters();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.doc.miniocl.Operation#getOwningClass <em>Owning Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Class</em>'.
	 * @see org.eclipse.qvtd.doc.miniocl.Operation#getOwningClass()
	 * @see #getOperation()
	 * @generated
	 */
	EReference getOperation_OwningClass();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.doc.miniocl.Operation#getOwnedBodyExpression <em>Owned Body Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Body Expression</em>'.
	 * @see org.eclipse.qvtd.doc.miniocl.Operation#getOwnedBodyExpression()
	 * @see #getOperation()
	 * @generated
	 */
	EReference getOperation_OwnedBodyExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.doc.miniocl.Parameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameter</em>'.
	 * @see org.eclipse.qvtd.doc.miniocl.Parameter
	 * @generated
	 */
	EClass getParameter();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.doc.miniocl.PrimitiveLiteralExp <em>Primitive Literal Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Primitive Literal Exp</em>'.
	 * @see org.eclipse.qvtd.doc.miniocl.PrimitiveLiteralExp
	 * @generated
	 */
	EClass getPrimitiveLiteralExp();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.doc.miniocl.PropertyCallExp <em>Property Call Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property Call Exp</em>'.
	 * @see org.eclipse.qvtd.doc.miniocl.PropertyCallExp
	 * @generated
	 */
	EClass getPropertyCallExp();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.doc.miniocl.PropertyCallExp#getReferredProperty <em>Referred Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Property</em>'.
	 * @see org.eclipse.qvtd.doc.miniocl.PropertyCallExp#getReferredProperty()
	 * @see #getPropertyCallExp()
	 * @generated
	 */
	EReference getPropertyCallExp_ReferredProperty();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.doc.miniocl.OperationCallExp <em>Operation Call Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operation Call Exp</em>'.
	 * @see org.eclipse.qvtd.doc.miniocl.OperationCallExp
	 * @generated
	 */
	EClass getOperationCallExp();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.doc.miniocl.OperationCallExp#getOwnedArguments <em>Owned Arguments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Arguments</em>'.
	 * @see org.eclipse.qvtd.doc.miniocl.OperationCallExp#getOwnedArguments()
	 * @see #getOperationCallExp()
	 * @generated
	 */
	EReference getOperationCallExp_OwnedArguments();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.doc.miniocl.OperationCallExp#getReferredOperation <em>Referred Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Operation</em>'.
	 * @see org.eclipse.qvtd.doc.miniocl.OperationCallExp#getReferredOperation()
	 * @see #getOperationCallExp()
	 * @generated
	 */
	EReference getOperationCallExp_ReferredOperation();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.doc.miniocl.Variable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable</em>'.
	 * @see org.eclipse.qvtd.doc.miniocl.Variable
	 * @generated
	 */
	EClass getVariable();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.doc.miniocl.Variable#getOwnedInitExp <em>Owned Init Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Init Exp</em>'.
	 * @see org.eclipse.qvtd.doc.miniocl.Variable#getOwnedInitExp()
	 * @see #getVariable()
	 * @generated
	 */
	EReference getVariable_OwnedInitExp();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.doc.miniocl.VariableExp <em>Variable Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable Exp</em>'.
	 * @see org.eclipse.qvtd.doc.miniocl.VariableExp
	 * @generated
	 */
	EClass getVariableExp();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.doc.miniocl.VariableExp#getReferredVariable <em>Referred Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Variable</em>'.
	 * @see org.eclipse.qvtd.doc.miniocl.VariableExp#getReferredVariable()
	 * @see #getVariableExp()
	 * @generated
	 */
	EReference getVariableExp_ReferredVariable();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.doc.miniocl.util.Visitable <em>Visitable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Visitable</em>'.
	 * @see org.eclipse.qvtd.doc.miniocl.util.Visitable
	 * @model instanceClass="org.eclipse.qvtd.doc.miniocl.util.Visitable"
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
	MiniOCLFactory getMiniOCLFactory();

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
		 * The meta object literal for the '{@link org.eclipse.qvtd.doc.miniocl.impl.BooleanLiteralExpImpl <em>Boolean Literal Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.doc.miniocl.impl.BooleanLiteralExpImpl
		 * @see org.eclipse.qvtd.doc.miniocl.impl.MiniOCLPackageImpl#getBooleanLiteralExp()
		 * @generated
		 */
		EClass BOOLEAN_LITERAL_EXP = eINSTANCE.getBooleanLiteralExp();

		/**
		 * The meta object literal for the '<em><b>Boolean Symbol</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOOLEAN_LITERAL_EXP__BOOLEAN_SYMBOL = eINSTANCE.getBooleanLiteralExp_BooleanSymbol();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.doc.miniocl.impl.ElementImpl <em>Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.doc.miniocl.impl.ElementImpl
		 * @see org.eclipse.qvtd.doc.miniocl.impl.MiniOCLPackageImpl#getElement()
		 * @generated
		 */
		EClass ELEMENT = eINSTANCE.getElement();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.doc.miniocl.impl.FeatureImpl <em>Feature</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.doc.miniocl.impl.FeatureImpl
		 * @see org.eclipse.qvtd.doc.miniocl.impl.MiniOCLPackageImpl#getFeature()
		 * @generated
		 */
		EClass FEATURE = eINSTANCE.getFeature();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.doc.miniocl.impl.ImportImpl <em>Import</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.doc.miniocl.impl.ImportImpl
		 * @see org.eclipse.qvtd.doc.miniocl.impl.MiniOCLPackageImpl#getImport()
		 * @generated
		 */
		EClass IMPORT = eINSTANCE.getImport();

		/**
		 * The meta object literal for the '<em><b>Uri</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMPORT__URI = eINSTANCE.getImport_Uri();

		/**
		 * The meta object literal for the '<em><b>Alias</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMPORT__ALIAS = eINSTANCE.getImport_Alias();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.doc.miniocl.impl.IntegerLiteralExpImpl <em>Integer Literal Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.doc.miniocl.impl.IntegerLiteralExpImpl
		 * @see org.eclipse.qvtd.doc.miniocl.impl.MiniOCLPackageImpl#getIntegerLiteralExp()
		 * @generated
		 */
		EClass INTEGER_LITERAL_EXP = eINSTANCE.getIntegerLiteralExp();

		/**
		 * The meta object literal for the '<em><b>Integer Symbol</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTEGER_LITERAL_EXP__INTEGER_SYMBOL = eINSTANCE.getIntegerLiteralExp_IntegerSymbol();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.doc.miniocl.impl.IteratorExpImpl <em>Iterator Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.doc.miniocl.impl.IteratorExpImpl
		 * @see org.eclipse.qvtd.doc.miniocl.impl.MiniOCLPackageImpl#getIteratorExp()
		 * @generated
		 */
		EClass ITERATOR_EXP = eINSTANCE.getIteratorExp();

		/**
		 * The meta object literal for the '<em><b>Iterator</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ITERATOR_EXP__ITERATOR = eINSTANCE.getIteratorExp_Iterator();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.doc.miniocl.impl.IterateExpImpl <em>Iterate Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.doc.miniocl.impl.IterateExpImpl
		 * @see org.eclipse.qvtd.doc.miniocl.impl.MiniOCLPackageImpl#getIterateExp()
		 * @generated
		 */
		EClass ITERATE_EXP = eINSTANCE.getIterateExp();

		/**
		 * The meta object literal for the '<em><b>Owned Result</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ITERATE_EXP__OWNED_RESULT = eINSTANCE.getIterateExp_OwnedResult();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.doc.miniocl.impl.LetExpImpl <em>Let Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.doc.miniocl.impl.LetExpImpl
		 * @see org.eclipse.qvtd.doc.miniocl.impl.MiniOCLPackageImpl#getLetExp()
		 * @generated
		 */
		EClass LET_EXP = eINSTANCE.getLetExp();

		/**
		 * The meta object literal for the '<em><b>Owned In</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LET_EXP__OWNED_IN = eINSTANCE.getLetExp_OwnedIn();

		/**
		 * The meta object literal for the '<em><b>Owned Variable</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LET_EXP__OWNED_VARIABLE = eINSTANCE.getLetExp_OwnedVariable();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.doc.miniocl.impl.LiteralExpImpl <em>Literal Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.doc.miniocl.impl.LiteralExpImpl
		 * @see org.eclipse.qvtd.doc.miniocl.impl.MiniOCLPackageImpl#getLiteralExp()
		 * @generated
		 */
		EClass LITERAL_EXP = eINSTANCE.getLiteralExp();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.doc.miniocl.impl.LoopExpImpl <em>Loop Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.doc.miniocl.impl.LoopExpImpl
		 * @see org.eclipse.qvtd.doc.miniocl.impl.MiniOCLPackageImpl#getLoopExp()
		 * @generated
		 */
		EClass LOOP_EXP = eINSTANCE.getLoopExp();

		/**
		 * The meta object literal for the '<em><b>Owned Iterator</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOOP_EXP__OWNED_ITERATOR = eINSTANCE.getLoopExp_OwnedIterator();

		/**
		 * The meta object literal for the '<em><b>Owned Body</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOOP_EXP__OWNED_BODY = eINSTANCE.getLoopExp_OwnedBody();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.doc.miniocl.impl.NamedElementImpl <em>Named Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.doc.miniocl.impl.NamedElementImpl
		 * @see org.eclipse.qvtd.doc.miniocl.impl.MiniOCLPackageImpl#getNamedElement()
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
		 * The meta object literal for the '{@link org.eclipse.qvtd.doc.miniocl.impl.NamespaceImpl <em>Namespace</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.doc.miniocl.impl.NamespaceImpl
		 * @see org.eclipse.qvtd.doc.miniocl.impl.MiniOCLPackageImpl#getNamespace()
		 * @generated
		 */
		EClass NAMESPACE = eINSTANCE.getNamespace();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.doc.miniocl.impl.NullLiteralExpImpl <em>Null Literal Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.doc.miniocl.impl.NullLiteralExpImpl
		 * @see org.eclipse.qvtd.doc.miniocl.impl.MiniOCLPackageImpl#getNullLiteralExp()
		 * @generated
		 */
		EClass NULL_LITERAL_EXP = eINSTANCE.getNullLiteralExp();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.doc.miniocl.impl.TypedElementImpl <em>Typed Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.doc.miniocl.impl.TypedElementImpl
		 * @see org.eclipse.qvtd.doc.miniocl.impl.MiniOCLPackageImpl#getTypedElement()
		 * @generated
		 */
		EClass TYPED_ELEMENT = eINSTANCE.getTypedElement();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPED_ELEMENT__TYPE = eINSTANCE.getTypedElement_Type();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.doc.miniocl.CollectionKind <em>Collection Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.doc.miniocl.CollectionKind
		 * @see org.eclipse.qvtd.doc.miniocl.impl.MiniOCLPackageImpl#getCollectionKind()
		 * @generated
		 */
		EEnum COLLECTION_KIND = eINSTANCE.getCollectionKind();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.doc.miniocl.impl.ExpressionInOCLImpl <em>Expression In OCL</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.doc.miniocl.impl.ExpressionInOCLImpl
		 * @see org.eclipse.qvtd.doc.miniocl.impl.MiniOCLPackageImpl#getExpressionInOCL()
		 * @generated
		 */
		EClass EXPRESSION_IN_OCL = eINSTANCE.getExpressionInOCL();

		/**
		 * The meta object literal for the '<em><b>Owned Self Var</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXPRESSION_IN_OCL__OWNED_SELF_VAR = eINSTANCE.getExpressionInOCL_OwnedSelfVar();

		/**
		 * The meta object literal for the '<em><b>Owned Body</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXPRESSION_IN_OCL__OWNED_BODY = eINSTANCE.getExpressionInOCL_OwnedBody();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.doc.miniocl.impl.ConstraintImpl <em>Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.doc.miniocl.impl.ConstraintImpl
		 * @see org.eclipse.qvtd.doc.miniocl.impl.MiniOCLPackageImpl#getConstraint()
		 * @generated
		 */
		EClass CONSTRAINT = eINSTANCE.getConstraint();

		/**
		 * The meta object literal for the '<em><b>Owned Specification</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSTRAINT__OWNED_SPECIFICATION = eINSTANCE.getConstraint_OwnedSpecification();

		/**
		 * The meta object literal for the '<em><b>Constrained Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSTRAINT__CONSTRAINED_ELEMENT = eINSTANCE.getConstraint_ConstrainedElement();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.doc.miniocl.impl.OCLExpressionImpl <em>OCL Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.doc.miniocl.impl.OCLExpressionImpl
		 * @see org.eclipse.qvtd.doc.miniocl.impl.MiniOCLPackageImpl#getOCLExpression()
		 * @generated
		 */
		EClass OCL_EXPRESSION = eINSTANCE.getOCLExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.doc.miniocl.impl.OpaqueExpressionImpl <em>Opaque Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.doc.miniocl.impl.OpaqueExpressionImpl
		 * @see org.eclipse.qvtd.doc.miniocl.impl.MiniOCLPackageImpl#getOpaqueExpression()
		 * @generated
		 */
		EClass OPAQUE_EXPRESSION = eINSTANCE.getOpaqueExpression();

		/**
		 * The meta object literal for the '<em><b>Language</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPAQUE_EXPRESSION__LANGUAGE = eINSTANCE.getOpaqueExpression_Language();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.doc.miniocl.impl.CallExpImpl <em>Call Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.doc.miniocl.impl.CallExpImpl
		 * @see org.eclipse.qvtd.doc.miniocl.impl.MiniOCLPackageImpl#getCallExp()
		 * @generated
		 */
		EClass CALL_EXP = eINSTANCE.getCallExp();

		/**
		 * The meta object literal for the '<em><b>Owned Source</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CALL_EXP__OWNED_SOURCE = eINSTANCE.getCallExp_OwnedSource();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.doc.miniocl.impl.RootImpl <em>Root</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.doc.miniocl.impl.RootImpl
		 * @see org.eclipse.qvtd.doc.miniocl.impl.MiniOCLPackageImpl#getRoot()
		 * @generated
		 */
		EClass ROOT = eINSTANCE.getRoot();

		/**
		 * The meta object literal for the '<em><b>Owned Constraints</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROOT__OWNED_CONSTRAINTS = eINSTANCE.getRoot_OwnedConstraints();

		/**
		 * The meta object literal for the '<em><b>Owned Imports</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROOT__OWNED_IMPORTS = eINSTANCE.getRoot_OwnedImports();

		/**
		 * The meta object literal for the '<em><b>Owned Packages</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROOT__OWNED_PACKAGES = eINSTANCE.getRoot_OwnedPackages();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.doc.miniocl.impl.PackageImpl <em>Package</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.doc.miniocl.impl.PackageImpl
		 * @see org.eclipse.qvtd.doc.miniocl.impl.MiniOCLPackageImpl#getPackage()
		 * @generated
		 */
		EClass PACKAGE = eINSTANCE.getPackage();

		/**
		 * The meta object literal for the '<em><b>Owned Classes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PACKAGE__OWNED_CLASSES = eINSTANCE.getPackage_OwnedClasses();

		/**
		 * The meta object literal for the '<em><b>Owned Packages</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PACKAGE__OWNED_PACKAGES = eINSTANCE.getPackage_OwnedPackages();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.doc.miniocl.impl.ClassImpl <em>Class</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.doc.miniocl.impl.ClassImpl
		 * @see org.eclipse.qvtd.doc.miniocl.impl.MiniOCLPackageImpl#getClass_()
		 * @generated
		 */
		EClass CLASS = eINSTANCE.getClass_();

		/**
		 * The meta object literal for the '<em><b>Super Classes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS__SUPER_CLASSES = eINSTANCE.getClass_SuperClasses();

		/**
		 * The meta object literal for the '<em><b>Owned Operations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS__OWNED_OPERATIONS = eINSTANCE.getClass_OwnedOperations();

		/**
		 * The meta object literal for the '<em><b>Owned Properties</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS__OWNED_PROPERTIES = eINSTANCE.getClass_OwnedProperties();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.doc.miniocl.impl.CollectionLiteralExpImpl <em>Collection Literal Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.doc.miniocl.impl.CollectionLiteralExpImpl
		 * @see org.eclipse.qvtd.doc.miniocl.impl.MiniOCLPackageImpl#getCollectionLiteralExp()
		 * @generated
		 */
		EClass COLLECTION_LITERAL_EXP = eINSTANCE.getCollectionLiteralExp();

		/**
		 * The meta object literal for the '<em><b>Owned Parts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLLECTION_LITERAL_EXP__OWNED_PARTS = eINSTANCE.getCollectionLiteralExp_OwnedParts();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLLECTION_LITERAL_EXP__KIND = eINSTANCE.getCollectionLiteralExp_Kind();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.doc.miniocl.impl.CollectionItemImpl <em>Collection Item</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.doc.miniocl.impl.CollectionItemImpl
		 * @see org.eclipse.qvtd.doc.miniocl.impl.MiniOCLPackageImpl#getCollectionItem()
		 * @generated
		 */
		EClass COLLECTION_ITEM = eINSTANCE.getCollectionItem();

		/**
		 * The meta object literal for the '<em><b>Owned Item</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLLECTION_ITEM__OWNED_ITEM = eINSTANCE.getCollectionItem_OwnedItem();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.doc.miniocl.impl.CollectionLiteralPartImpl <em>Collection Literal Part</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.doc.miniocl.impl.CollectionLiteralPartImpl
		 * @see org.eclipse.qvtd.doc.miniocl.impl.MiniOCLPackageImpl#getCollectionLiteralPart()
		 * @generated
		 */
		EClass COLLECTION_LITERAL_PART = eINSTANCE.getCollectionLiteralPart();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.doc.miniocl.impl.CollectionRangeImpl <em>Collection Range</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.doc.miniocl.impl.CollectionRangeImpl
		 * @see org.eclipse.qvtd.doc.miniocl.impl.MiniOCLPackageImpl#getCollectionRange()
		 * @generated
		 */
		EClass COLLECTION_RANGE = eINSTANCE.getCollectionRange();

		/**
		 * The meta object literal for the '<em><b>Owned First</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLLECTION_RANGE__OWNED_FIRST = eINSTANCE.getCollectionRange_OwnedFirst();

		/**
		 * The meta object literal for the '<em><b>Owned Last</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLLECTION_RANGE__OWNED_LAST = eINSTANCE.getCollectionRange_OwnedLast();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.doc.miniocl.impl.PropertyImpl <em>Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.doc.miniocl.impl.PropertyImpl
		 * @see org.eclipse.qvtd.doc.miniocl.impl.MiniOCLPackageImpl#getProperty()
		 * @generated
		 */
		EClass PROPERTY = eINSTANCE.getProperty();

		/**
		 * The meta object literal for the '<em><b>Owning Class</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY__OWNING_CLASS = eINSTANCE.getProperty_OwningClass();

		/**
		 * The meta object literal for the '<em><b>Lower Bound</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY__LOWER_BOUND = eINSTANCE.getProperty_LowerBound();

		/**
		 * The meta object literal for the '<em><b>Upper Bound</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY__UPPER_BOUND = eINSTANCE.getProperty_UpperBound();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.doc.miniocl.impl.OperationImpl <em>Operation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.doc.miniocl.impl.OperationImpl
		 * @see org.eclipse.qvtd.doc.miniocl.impl.MiniOCLPackageImpl#getOperation()
		 * @generated
		 */
		EClass OPERATION = eINSTANCE.getOperation();

		/**
		 * The meta object literal for the '<em><b>Owned Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION__OWNED_PARAMETERS = eINSTANCE.getOperation_OwnedParameters();

		/**
		 * The meta object literal for the '<em><b>Owning Class</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION__OWNING_CLASS = eINSTANCE.getOperation_OwningClass();

		/**
		 * The meta object literal for the '<em><b>Owned Body Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION__OWNED_BODY_EXPRESSION = eINSTANCE.getOperation_OwnedBodyExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.doc.miniocl.impl.ParameterImpl <em>Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.doc.miniocl.impl.ParameterImpl
		 * @see org.eclipse.qvtd.doc.miniocl.impl.MiniOCLPackageImpl#getParameter()
		 * @generated
		 */
		EClass PARAMETER = eINSTANCE.getParameter();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.doc.miniocl.impl.PrimitiveLiteralExpImpl <em>Primitive Literal Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.doc.miniocl.impl.PrimitiveLiteralExpImpl
		 * @see org.eclipse.qvtd.doc.miniocl.impl.MiniOCLPackageImpl#getPrimitiveLiteralExp()
		 * @generated
		 */
		EClass PRIMITIVE_LITERAL_EXP = eINSTANCE.getPrimitiveLiteralExp();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.doc.miniocl.impl.PropertyCallExpImpl <em>Property Call Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.doc.miniocl.impl.PropertyCallExpImpl
		 * @see org.eclipse.qvtd.doc.miniocl.impl.MiniOCLPackageImpl#getPropertyCallExp()
		 * @generated
		 */
		EClass PROPERTY_CALL_EXP = eINSTANCE.getPropertyCallExp();

		/**
		 * The meta object literal for the '<em><b>Referred Property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_CALL_EXP__REFERRED_PROPERTY = eINSTANCE.getPropertyCallExp_ReferredProperty();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.doc.miniocl.impl.OperationCallExpImpl <em>Operation Call Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.doc.miniocl.impl.OperationCallExpImpl
		 * @see org.eclipse.qvtd.doc.miniocl.impl.MiniOCLPackageImpl#getOperationCallExp()
		 * @generated
		 */
		EClass OPERATION_CALL_EXP = eINSTANCE.getOperationCallExp();

		/**
		 * The meta object literal for the '<em><b>Owned Arguments</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION_CALL_EXP__OWNED_ARGUMENTS = eINSTANCE.getOperationCallExp_OwnedArguments();

		/**
		 * The meta object literal for the '<em><b>Referred Operation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION_CALL_EXP__REFERRED_OPERATION = eINSTANCE.getOperationCallExp_ReferredOperation();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.doc.miniocl.impl.VariableImpl <em>Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.doc.miniocl.impl.VariableImpl
		 * @see org.eclipse.qvtd.doc.miniocl.impl.MiniOCLPackageImpl#getVariable()
		 * @generated
		 */
		EClass VARIABLE = eINSTANCE.getVariable();

		/**
		 * The meta object literal for the '<em><b>Owned Init Exp</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE__OWNED_INIT_EXP = eINSTANCE.getVariable_OwnedInitExp();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.doc.miniocl.impl.VariableExpImpl <em>Variable Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.doc.miniocl.impl.VariableExpImpl
		 * @see org.eclipse.qvtd.doc.miniocl.impl.MiniOCLPackageImpl#getVariableExp()
		 * @generated
		 */
		EClass VARIABLE_EXP = eINSTANCE.getVariableExp();

		/**
		 * The meta object literal for the '<em><b>Referred Variable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_EXP__REFERRED_VARIABLE = eINSTANCE.getVariableExp_ReferredVariable();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.doc.miniocl.util.Visitable <em>Visitable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.doc.miniocl.util.Visitable
		 * @see org.eclipse.qvtd.doc.miniocl.impl.MiniOCLPackageImpl#getVisitable()
		 * @generated
		 */
		EClass VISITABLE = eINSTANCE.getVisitable();

	}

} //MiniOCLPackage
