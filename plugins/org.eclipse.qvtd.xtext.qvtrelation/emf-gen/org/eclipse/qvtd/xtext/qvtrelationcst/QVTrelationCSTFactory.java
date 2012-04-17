/**
 * <copyright>
 *
 * Copyright (c) 2012 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.qvtd.xtext.qvtrelationcst;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.qvtd.xtext.qvtrelationcst.QVTrelationCSTPackage
 * @generated
 */
public interface QVTrelationCSTFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	QVTrelationCSTFactory eINSTANCE = org.eclipse.qvtd.xtext.qvtrelationcst.impl.QVTrelationCSTFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Any Element CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Any Element CS</em>'.
	 * @generated
	 */
	AnyElementCS createAnyElementCS();

	/**
	 * Returns a new object of class '<em>Collection Template CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Collection Template CS</em>'.
	 * @generated
	 */
	CollectionTemplateCS createCollectionTemplateCS();

	/**
	 * Returns a new object of class '<em>Default Value CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Default Value CS</em>'.
	 * @generated
	 */
	DefaultValueCS createDefaultValueCS();

	/**
	 * Returns a new object of class '<em>Domain CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Domain CS</em>'.
	 * @generated
	 */
	DomainCS createDomainCS();

	/**
	 * Returns a new object of class '<em>Key Decl CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Key Decl CS</em>'.
	 * @generated
	 */
	KeyDeclCS createKeyDeclCS();

	/**
	 * Returns a new object of class '<em>Model Decl CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Model Decl CS</em>'.
	 * @generated
	 */
	ModelDeclCS createModelDeclCS();

	/**
	 * Returns a new object of class '<em>Object Template CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Object Template CS</em>'.
	 * @generated
	 */
	ObjectTemplateCS createObjectTemplateCS();

	/**
	 * Returns a new object of class '<em>Param Declaration CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Param Declaration CS</em>'.
	 * @generated
	 */
	ParamDeclarationCS createParamDeclarationCS();

	/**
	 * Returns a new object of class '<em>Primitive Type Domain CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Primitive Type Domain CS</em>'.
	 * @generated
	 */
	PrimitiveTypeDomainCS createPrimitiveTypeDomainCS();

	/**
	 * Returns a new object of class '<em>Property Template CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Property Template CS</em>'.
	 * @generated
	 */
	PropertyTemplateCS createPropertyTemplateCS();

	/**
	 * Returns a new object of class '<em>Query CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Query CS</em>'.
	 * @generated
	 */
	QueryCS createQueryCS();

	/**
	 * Returns a new object of class '<em>Relation CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Relation CS</em>'.
	 * @generated
	 */
	RelationCS createRelationCS();

	/**
	 * Returns a new object of class '<em>Top Level CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Top Level CS</em>'.
	 * @generated
	 */
	TopLevelCS createTopLevelCS();

	/**
	 * Returns a new object of class '<em>Transformation CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Transformation CS</em>'.
	 * @generated
	 */
	TransformationCS createTransformationCS();

	/**
	 * Returns a new object of class '<em>Unit CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Unit CS</em>'.
	 * @generated
	 */
	UnitCS createUnitCS();

	/**
	 * Returns a new object of class '<em>Var Declaration CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Var Declaration CS</em>'.
	 * @generated
	 */
	VarDeclarationCS createVarDeclarationCS();

	/**
	 * Returns a new object of class '<em>When CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>When CS</em>'.
	 * @generated
	 */
	WhenCS createWhenCS();

	/**
	 * Returns a new object of class '<em>Where CS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Where CS</em>'.
	 * @generated
	 */
	WhereCS createWhereCS();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	QVTrelationCSTPackage getQVTrelationCSTPackage();

} //QVTrelationCSTFactory
