/**
 * <copyright>
 * 
 * Copyright (c) 2007, 2008 E.D.Willink and others.
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
 * $Id: QVTrCSTPackageImpl.java,v 1.4 2008/09/10 05:23:32 ewillink Exp $
 */
package org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.ocl.cst.CSTPackage;
import org.eclipse.qvt.declarative.parser.qvt.cst.QVTCSTPackage;
import org.eclipse.qvt.declarative.parser.qvtrelation.cst.AbstractDomainCS;
import org.eclipse.qvt.declarative.parser.qvtrelation.cst.CollectionTemplateCS;
import org.eclipse.qvt.declarative.parser.qvtrelation.cst.DefaultValueCS;
import org.eclipse.qvt.declarative.parser.qvtrelation.cst.DomainCS;
import org.eclipse.qvt.declarative.parser.qvtrelation.cst.KeyDeclCS;
import org.eclipse.qvt.declarative.parser.qvtrelation.cst.ModelDeclCS;
import org.eclipse.qvt.declarative.parser.qvtrelation.cst.ObjectTemplateCS;
import org.eclipse.qvt.declarative.parser.qvtrelation.cst.ParamDeclarationCS;
import org.eclipse.qvt.declarative.parser.qvtrelation.cst.PrimitiveTypeDomainCS;
import org.eclipse.qvt.declarative.parser.qvtrelation.cst.PropertyTemplateCS;
import org.eclipse.qvt.declarative.parser.qvtrelation.cst.QVTrCSTFactory;
import org.eclipse.qvt.declarative.parser.qvtrelation.cst.QVTrCSTPackage;
import org.eclipse.qvt.declarative.parser.qvtrelation.cst.QueryCS;
import org.eclipse.qvt.declarative.parser.qvtrelation.cst.RelationCS;
import org.eclipse.qvt.declarative.parser.qvtrelation.cst.TemplateCS;
import org.eclipse.qvt.declarative.parser.qvtrelation.cst.TemplateVariableCS;
import org.eclipse.qvt.declarative.parser.qvtrelation.cst.TopLevelCS;
import org.eclipse.qvt.declarative.parser.qvtrelation.cst.TransformationCS;
import org.eclipse.qvt.declarative.parser.qvtrelation.cst.UnitCS;
import org.eclipse.qvt.declarative.parser.qvtrelation.cst.VarDeclarationCS;
import org.eclipse.qvt.declarative.parser.qvtrelation.cst.WhenCS;
import org.eclipse.qvt.declarative.parser.qvtrelation.cst.WhereCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class QVTrCSTPackageImpl extends EPackageImpl implements QVTrCSTPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractDomainCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass collectionTemplateCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass domainCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass unitCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass keyDeclCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modelDeclCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass objectTemplateCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass paramDeclarationCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass primitiveTypeDomainCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propertyTemplateCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass queryCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass relationCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass templateCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass templateVariableCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass topLevelCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass transformationCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass varDeclarationCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass whenCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass whereCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass defaultValueCSEClass = null;

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
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.QVTrCSTPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private QVTrCSTPackageImpl() {
		super(eNS_URI, QVTrCSTFactory.eINSTANCE);
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
	public static QVTrCSTPackage init() {
		if (isInited) return (QVTrCSTPackage)EPackage.Registry.INSTANCE.getEPackage(QVTrCSTPackage.eNS_URI);

		// Obtain or create and register package
		QVTrCSTPackageImpl theQVTrCSTPackage = (QVTrCSTPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof QVTrCSTPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new QVTrCSTPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();
		QVTCSTPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theQVTrCSTPackage.createPackageContents();

		// Initialize created meta-data
		theQVTrCSTPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theQVTrCSTPackage.freeze();

		return theQVTrCSTPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractDomainCS() {
		return abstractDomainCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCollectionTemplateCS() {
		return collectionTemplateCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCollectionTemplateCS_MemberIdentifier() {
		return (EReference)collectionTemplateCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCollectionTemplateCS_ReferredCollectionType() {
		return (EReference)collectionTemplateCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCollectionTemplateCS_RestIdentifier() {
		return (EReference)collectionTemplateCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDomainCS() {
		return domainCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDomainCS_Checkonly() {
		return (EAttribute)domainCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDomainCS_Enforce() {
		return (EAttribute)domainCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDomainCS_ModelId() {
		return (EReference)domainCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDomainCS_Replace() {
		return (EAttribute)domainCSEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDomainCS_Template() {
		return (EReference)domainCSEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDomainCS_DefaultValue() {
		return (EReference)domainCSEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDomainCS_ImplementedBy() {
		return (EReference)domainCSEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUnitCS() {
		return unitCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUnitCS_Identifier() {
		return (EReference)unitCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getKeyDeclCS() {
		return keyDeclCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getKeyDeclCS_ClassId() {
		return (EReference)keyDeclCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getKeyDeclCS_PropertyId() {
		return (EReference)keyDeclCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModelDeclCS() {
		return modelDeclCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModelDeclCS_ModelId() {
		return (EReference)modelDeclCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModelDeclCS_MetaModelId() {
		return (EReference)modelDeclCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getObjectTemplateCS() {
		return objectTemplateCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getObjectTemplateCS_PropertyTemplate() {
		return (EReference)objectTemplateCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getObjectTemplateCS_ReferredClass() {
		return (EReference)objectTemplateCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getParamDeclarationCS() {
		return paramDeclarationCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getParamDeclarationCS_Identifier() {
		return (EReference)paramDeclarationCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getParamDeclarationCS_Type() {
		return (EReference)paramDeclarationCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPrimitiveTypeDomainCS() {
		return primitiveTypeDomainCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPropertyTemplateCS() {
		return propertyTemplateCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPropertyTemplateCS_PropertyId() {
		return (EReference)propertyTemplateCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPropertyTemplateCS_OclExpression() {
		return (EReference)propertyTemplateCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPropertyTemplateCS_ReferredProperty() {
		return (EReference)propertyTemplateCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPropertyTemplateCS_Opposite() {
		return (EAttribute)propertyTemplateCSEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getQueryCS() {
		return queryCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getQueryCS_PathName() {
		return (EReference)queryCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getQueryCS_InputParamDeclaration() {
		return (EReference)queryCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getQueryCS_OclExpression() {
		return (EReference)queryCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getQueryCS_Type() {
		return (EReference)queryCSEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRelationCS() {
		return relationCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRelationCS_Top() {
		return (EAttribute)relationCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRelationCS_Identifier() {
		return (EReference)relationCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRelationCS_Overrides() {
		return (EReference)relationCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRelationCS_VarDeclaration() {
		return (EReference)relationCSEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRelationCS_Domain() {
		return (EReference)relationCSEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRelationCS_When() {
		return (EReference)relationCSEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRelationCS_Where() {
		return (EReference)relationCSEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTemplateCS() {
		return templateCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTemplateCS_GuardExpression() {
		return (EReference)templateCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTemplateVariableCS() {
		return templateVariableCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTemplateVariableCS_Type() {
		return (EReference)templateVariableCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTopLevelCS() {
		return topLevelCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTopLevelCS_ImportClause() {
		return (EReference)topLevelCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTopLevelCS_Transformation() {
		return (EReference)topLevelCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTransformationCS() {
		return transformationCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTransformationCS_ModelDecl() {
		return (EReference)transformationCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTransformationCS_Extends() {
		return (EReference)transformationCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTransformationCS_Identifier() {
		return (EReference)transformationCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTransformationCS_KeyDecl() {
		return (EReference)transformationCSEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTransformationCS_Query() {
		return (EReference)transformationCSEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTransformationCS_Relation() {
		return (EReference)transformationCSEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVarDeclarationCS() {
		return varDeclarationCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVarDeclarationCS_VarDeclarationId() {
		return (EReference)varDeclarationCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVarDeclarationCS_Type() {
		return (EReference)varDeclarationCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWhenCS() {
		return whenCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWhenCS_Expr() {
		return (EReference)whenCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWhereCS() {
		return whereCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWhereCS_Expr() {
		return (EReference)whereCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QVTrCSTFactory getQVTrCSTFactory() {
		return (QVTrCSTFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDefaultValueCS() {
		return defaultValueCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDefaultValueCS_Identifier() {
		return (EReference)defaultValueCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDefaultValueCS_Initialiser() {
		return (EReference)defaultValueCSEClass.getEStructuralFeatures().get(1);
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
		abstractDomainCSEClass = createEClass(ABSTRACT_DOMAIN_CS);

		collectionTemplateCSEClass = createEClass(COLLECTION_TEMPLATE_CS);
		createEReference(collectionTemplateCSEClass, COLLECTION_TEMPLATE_CS__MEMBER_IDENTIFIER);
		createEReference(collectionTemplateCSEClass, COLLECTION_TEMPLATE_CS__REFERRED_COLLECTION_TYPE);
		createEReference(collectionTemplateCSEClass, COLLECTION_TEMPLATE_CS__REST_IDENTIFIER);

		defaultValueCSEClass = createEClass(DEFAULT_VALUE_CS);
		createEReference(defaultValueCSEClass, DEFAULT_VALUE_CS__IDENTIFIER);
		createEReference(defaultValueCSEClass, DEFAULT_VALUE_CS__INITIALISER);

		domainCSEClass = createEClass(DOMAIN_CS);
		createEAttribute(domainCSEClass, DOMAIN_CS__CHECKONLY);
		createEAttribute(domainCSEClass, DOMAIN_CS__ENFORCE);
		createEReference(domainCSEClass, DOMAIN_CS__MODEL_ID);
		createEAttribute(domainCSEClass, DOMAIN_CS__REPLACE);
		createEReference(domainCSEClass, DOMAIN_CS__TEMPLATE);
		createEReference(domainCSEClass, DOMAIN_CS__DEFAULT_VALUE);
		createEReference(domainCSEClass, DOMAIN_CS__IMPLEMENTED_BY);

		keyDeclCSEClass = createEClass(KEY_DECL_CS);
		createEReference(keyDeclCSEClass, KEY_DECL_CS__CLASS_ID);
		createEReference(keyDeclCSEClass, KEY_DECL_CS__PROPERTY_ID);

		modelDeclCSEClass = createEClass(MODEL_DECL_CS);
		createEReference(modelDeclCSEClass, MODEL_DECL_CS__MODEL_ID);
		createEReference(modelDeclCSEClass, MODEL_DECL_CS__META_MODEL_ID);

		objectTemplateCSEClass = createEClass(OBJECT_TEMPLATE_CS);
		createEReference(objectTemplateCSEClass, OBJECT_TEMPLATE_CS__PROPERTY_TEMPLATE);
		createEReference(objectTemplateCSEClass, OBJECT_TEMPLATE_CS__REFERRED_CLASS);

		paramDeclarationCSEClass = createEClass(PARAM_DECLARATION_CS);
		createEReference(paramDeclarationCSEClass, PARAM_DECLARATION_CS__IDENTIFIER);
		createEReference(paramDeclarationCSEClass, PARAM_DECLARATION_CS__TYPE);

		primitiveTypeDomainCSEClass = createEClass(PRIMITIVE_TYPE_DOMAIN_CS);

		propertyTemplateCSEClass = createEClass(PROPERTY_TEMPLATE_CS);
		createEReference(propertyTemplateCSEClass, PROPERTY_TEMPLATE_CS__PROPERTY_ID);
		createEReference(propertyTemplateCSEClass, PROPERTY_TEMPLATE_CS__OCL_EXPRESSION);
		createEReference(propertyTemplateCSEClass, PROPERTY_TEMPLATE_CS__REFERRED_PROPERTY);
		createEAttribute(propertyTemplateCSEClass, PROPERTY_TEMPLATE_CS__OPPOSITE);

		queryCSEClass = createEClass(QUERY_CS);
		createEReference(queryCSEClass, QUERY_CS__PATH_NAME);
		createEReference(queryCSEClass, QUERY_CS__INPUT_PARAM_DECLARATION);
		createEReference(queryCSEClass, QUERY_CS__OCL_EXPRESSION);
		createEReference(queryCSEClass, QUERY_CS__TYPE);

		relationCSEClass = createEClass(RELATION_CS);
		createEAttribute(relationCSEClass, RELATION_CS__TOP);
		createEReference(relationCSEClass, RELATION_CS__IDENTIFIER);
		createEReference(relationCSEClass, RELATION_CS__OVERRIDES);
		createEReference(relationCSEClass, RELATION_CS__VAR_DECLARATION);
		createEReference(relationCSEClass, RELATION_CS__DOMAIN);
		createEReference(relationCSEClass, RELATION_CS__WHEN);
		createEReference(relationCSEClass, RELATION_CS__WHERE);

		templateCSEClass = createEClass(TEMPLATE_CS);
		createEReference(templateCSEClass, TEMPLATE_CS__GUARD_EXPRESSION);

		templateVariableCSEClass = createEClass(TEMPLATE_VARIABLE_CS);
		createEReference(templateVariableCSEClass, TEMPLATE_VARIABLE_CS__TYPE);

		topLevelCSEClass = createEClass(TOP_LEVEL_CS);
		createEReference(topLevelCSEClass, TOP_LEVEL_CS__IMPORT_CLAUSE);
		createEReference(topLevelCSEClass, TOP_LEVEL_CS__TRANSFORMATION);

		transformationCSEClass = createEClass(TRANSFORMATION_CS);
		createEReference(transformationCSEClass, TRANSFORMATION_CS__MODEL_DECL);
		createEReference(transformationCSEClass, TRANSFORMATION_CS__EXTENDS);
		createEReference(transformationCSEClass, TRANSFORMATION_CS__IDENTIFIER);
		createEReference(transformationCSEClass, TRANSFORMATION_CS__KEY_DECL);
		createEReference(transformationCSEClass, TRANSFORMATION_CS__QUERY);
		createEReference(transformationCSEClass, TRANSFORMATION_CS__RELATION);

		unitCSEClass = createEClass(UNIT_CS);
		createEReference(unitCSEClass, UNIT_CS__IDENTIFIER);

		varDeclarationCSEClass = createEClass(VAR_DECLARATION_CS);
		createEReference(varDeclarationCSEClass, VAR_DECLARATION_CS__VAR_DECLARATION_ID);
		createEReference(varDeclarationCSEClass, VAR_DECLARATION_CS__TYPE);

		whenCSEClass = createEClass(WHEN_CS);
		createEReference(whenCSEClass, WHEN_CS__EXPR);

		whereCSEClass = createEClass(WHERE_CS);
		createEReference(whereCSEClass, WHERE_CS__EXPR);
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
		CSTPackage theCSTPackage = (CSTPackage)EPackage.Registry.INSTANCE.getEPackage(CSTPackage.eNS_URI);
		QVTCSTPackage theQVTCSTPackage = (QVTCSTPackage)EPackage.Registry.INSTANCE.getEPackage(QVTCSTPackage.eNS_URI);
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		abstractDomainCSEClass.getESuperTypes().add(theCSTPackage.getCSTNode());
		collectionTemplateCSEClass.getESuperTypes().add(this.getTemplateCS());
		defaultValueCSEClass.getESuperTypes().add(theCSTPackage.getCSTNode());
		domainCSEClass.getESuperTypes().add(this.getAbstractDomainCS());
		keyDeclCSEClass.getESuperTypes().add(theCSTPackage.getCSTNode());
		modelDeclCSEClass.getESuperTypes().add(theCSTPackage.getCSTNode());
		objectTemplateCSEClass.getESuperTypes().add(this.getTemplateCS());
		paramDeclarationCSEClass.getESuperTypes().add(theCSTPackage.getCSTNode());
		primitiveTypeDomainCSEClass.getESuperTypes().add(this.getTemplateVariableCS());
		primitiveTypeDomainCSEClass.getESuperTypes().add(this.getAbstractDomainCS());
		propertyTemplateCSEClass.getESuperTypes().add(theCSTPackage.getCSTNode());
		queryCSEClass.getESuperTypes().add(theCSTPackage.getCSTNode());
		relationCSEClass.getESuperTypes().add(theCSTPackage.getCSTNode());
		templateCSEClass.getESuperTypes().add(this.getTemplateVariableCS());
		templateCSEClass.getESuperTypes().add(theCSTPackage.getOCLExpressionCS());
		templateVariableCSEClass.getESuperTypes().add(theQVTCSTPackage.getIdentifiedCS());
		topLevelCSEClass.getESuperTypes().add(theCSTPackage.getCSTNode());
		transformationCSEClass.getESuperTypes().add(theCSTPackage.getCSTNode());
		unitCSEClass.getESuperTypes().add(theCSTPackage.getCSTNode());
		varDeclarationCSEClass.getESuperTypes().add(theCSTPackage.getCSTNode());
		whenCSEClass.getESuperTypes().add(theCSTPackage.getCSTNode());
		whereCSEClass.getESuperTypes().add(theCSTPackage.getCSTNode());

		// Initialize classes and features; add operations and parameters
		initEClass(abstractDomainCSEClass, AbstractDomainCS.class, "AbstractDomainCS", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(collectionTemplateCSEClass, CollectionTemplateCS.class, "CollectionTemplateCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCollectionTemplateCS_MemberIdentifier(), theQVTCSTPackage.getIdentifiedCS(), null, "memberIdentifier", null, 1, -1, CollectionTemplateCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCollectionTemplateCS_ReferredCollectionType(), theEcorePackage.getEClassifier(), null, "referredCollectionType", null, 0, 1, CollectionTemplateCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCollectionTemplateCS_RestIdentifier(), theQVTCSTPackage.getIdentifierCS(), null, "restIdentifier", null, 1, 1, CollectionTemplateCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(defaultValueCSEClass, DefaultValueCS.class, "DefaultValueCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDefaultValueCS_Identifier(), theQVTCSTPackage.getIdentifierCS(), null, "identifier", null, 1, 1, DefaultValueCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDefaultValueCS_Initialiser(), theCSTPackage.getOCLExpressionCS(), null, "initialiser", null, 1, 1, DefaultValueCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(domainCSEClass, DomainCS.class, "DomainCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDomainCS_Checkonly(), ecorePackage.getEBoolean(), "checkonly", null, 0, 1, DomainCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDomainCS_Enforce(), ecorePackage.getEBoolean(), "enforce", null, 0, 1, DomainCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDomainCS_ModelId(), theQVTCSTPackage.getIdentifierCS(), null, "modelId", null, 0, 1, DomainCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDomainCS_Replace(), ecorePackage.getEBoolean(), "replace", null, 0, 1, DomainCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDomainCS_Template(), this.getTemplateCS(), null, "template", null, 0, 1, DomainCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDomainCS_DefaultValue(), this.getDefaultValueCS(), null, "defaultValue", null, 0, -1, DomainCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDomainCS_ImplementedBy(), theCSTPackage.getOperationCallExpCS(), null, "implementedBy", null, 0, 1, DomainCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(keyDeclCSEClass, KeyDeclCS.class, "KeyDeclCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getKeyDeclCS_ClassId(), theCSTPackage.getPathNameCS(), null, "classId", null, 0, 1, KeyDeclCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getKeyDeclCS_PropertyId(), theQVTCSTPackage.getIdentifiedCS(), null, "propertyId", null, 0, -1, KeyDeclCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(modelDeclCSEClass, ModelDeclCS.class, "ModelDeclCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getModelDeclCS_ModelId(), theQVTCSTPackage.getIdentifierCS(), null, "modelId", null, 0, 1, ModelDeclCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModelDeclCS_MetaModelId(), theQVTCSTPackage.getIdentifierCS(), null, "metaModelId", null, 0, -1, ModelDeclCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(objectTemplateCSEClass, ObjectTemplateCS.class, "ObjectTemplateCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getObjectTemplateCS_PropertyTemplate(), this.getPropertyTemplateCS(), null, "propertyTemplate", null, 0, -1, ObjectTemplateCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getObjectTemplateCS_ReferredClass(), theEcorePackage.getEClass(), null, "referredClass", null, 0, 1, ObjectTemplateCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(paramDeclarationCSEClass, ParamDeclarationCS.class, "ParamDeclarationCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getParamDeclarationCS_Identifier(), theQVTCSTPackage.getIdentifierCS(), null, "identifier", null, 0, 1, ParamDeclarationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getParamDeclarationCS_Type(), theCSTPackage.getTypeCS(), null, "type", null, 0, 1, ParamDeclarationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(primitiveTypeDomainCSEClass, PrimitiveTypeDomainCS.class, "PrimitiveTypeDomainCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(propertyTemplateCSEClass, PropertyTemplateCS.class, "PropertyTemplateCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPropertyTemplateCS_PropertyId(), theQVTCSTPackage.getIdentifiedCS(), null, "propertyId", null, 0, 1, PropertyTemplateCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPropertyTemplateCS_OclExpression(), theCSTPackage.getOCLExpressionCS(), null, "oclExpression", null, 0, 1, PropertyTemplateCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPropertyTemplateCS_ReferredProperty(), theEcorePackage.getEStructuralFeature(), null, "referredProperty", null, 0, 1, PropertyTemplateCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPropertyTemplateCS_Opposite(), ecorePackage.getEBoolean(), "opposite", "false", 0, 1, PropertyTemplateCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(queryCSEClass, QueryCS.class, "QueryCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getQueryCS_PathName(), theCSTPackage.getPathNameCS(), null, "pathName", null, 0, 1, QueryCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getQueryCS_InputParamDeclaration(), this.getParamDeclarationCS(), null, "inputParamDeclaration", null, 0, -1, QueryCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getQueryCS_OclExpression(), theCSTPackage.getOCLExpressionCS(), null, "oclExpression", null, 0, 1, QueryCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getQueryCS_Type(), theCSTPackage.getTypeCS(), null, "type", null, 0, 1, QueryCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(relationCSEClass, RelationCS.class, "RelationCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRelationCS_Top(), ecorePackage.getEBoolean(), "top", null, 0, 1, RelationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRelationCS_Identifier(), theQVTCSTPackage.getIdentifierCS(), null, "identifier", null, 0, 1, RelationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRelationCS_Overrides(), theQVTCSTPackage.getIdentifierCS(), null, "overrides", null, 0, 1, RelationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRelationCS_VarDeclaration(), this.getVarDeclarationCS(), null, "varDeclaration", null, 0, -1, RelationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRelationCS_Domain(), this.getAbstractDomainCS(), null, "domain", null, 0, -1, RelationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRelationCS_When(), this.getWhenCS(), null, "when", null, 0, 1, RelationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRelationCS_Where(), this.getWhereCS(), null, "where", null, 0, 1, RelationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(templateCSEClass, TemplateCS.class, "TemplateCS", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTemplateCS_GuardExpression(), theCSTPackage.getOCLExpressionCS(), null, "guardExpression", null, 0, 1, TemplateCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(templateVariableCSEClass, TemplateVariableCS.class, "TemplateVariableCS", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTemplateVariableCS_Type(), theCSTPackage.getTypeCS(), null, "type", null, 0, 1, TemplateVariableCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(topLevelCSEClass, TopLevelCS.class, "TopLevelCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTopLevelCS_ImportClause(), this.getUnitCS(), null, "importClause", null, 0, -1, TopLevelCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTopLevelCS_Transformation(), this.getTransformationCS(), null, "transformation", null, 0, -1, TopLevelCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(transformationCSEClass, TransformationCS.class, "TransformationCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTransformationCS_ModelDecl(), this.getModelDeclCS(), null, "modelDecl", null, 0, -1, TransformationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTransformationCS_Extends(), theQVTCSTPackage.getIdentifierCS(), null, "extends", null, 0, 1, TransformationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTransformationCS_Identifier(), theQVTCSTPackage.getIdentifierCS(), null, "identifier", null, 0, 1, TransformationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTransformationCS_KeyDecl(), this.getKeyDeclCS(), null, "keyDecl", null, 0, -1, TransformationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTransformationCS_Query(), this.getQueryCS(), null, "query", null, 0, -1, TransformationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTransformationCS_Relation(), this.getRelationCS(), null, "relation", null, 0, -1, TransformationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(unitCSEClass, UnitCS.class, "UnitCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUnitCS_Identifier(), theQVTCSTPackage.getIdentifierCS(), null, "identifier", null, 1, -1, UnitCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(varDeclarationCSEClass, VarDeclarationCS.class, "VarDeclarationCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVarDeclarationCS_VarDeclarationId(), theQVTCSTPackage.getIdentifierCS(), null, "varDeclarationId", null, 0, -1, VarDeclarationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVarDeclarationCS_Type(), theCSTPackage.getTypeCS(), null, "type", null, 0, 1, VarDeclarationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(whenCSEClass, WhenCS.class, "WhenCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getWhenCS_Expr(), theCSTPackage.getOCLExpressionCS(), null, "expr", null, 1, -1, WhenCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(whereCSEClass, WhereCS.class, "WhereCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getWhereCS_Expr(), theCSTPackage.getOCLExpressionCS(), null, "expr", null, 1, -1, WhereCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //EqvtrCSTPackageImpl
