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
package org.eclipse.qvtd.xtext.qvtrelationcst.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.EssentialOCLCSTPackage;
import org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage;
import org.eclipse.qvtd.pivot.qvtrelation.QVTrelationPackage;
import org.eclipse.qvtd.xtext.qvtrelationcst.AbstractDomainCS;
import org.eclipse.qvtd.xtext.qvtrelationcst.CollectionTemplateCS;
import org.eclipse.qvtd.xtext.qvtrelationcst.DefaultValueCS;
import org.eclipse.qvtd.xtext.qvtrelationcst.DomainCS;
import org.eclipse.qvtd.xtext.qvtrelationcst.DomainPatternCS;
import org.eclipse.qvtd.xtext.qvtrelationcst.ElementTemplateCS;
import org.eclipse.qvtd.xtext.qvtrelationcst.KeyDeclCS;
import org.eclipse.qvtd.xtext.qvtrelationcst.ModelDeclCS;
import org.eclipse.qvtd.xtext.qvtrelationcst.ObjectTemplateCS;
import org.eclipse.qvtd.xtext.qvtrelationcst.ParamDeclarationCS;
import org.eclipse.qvtd.xtext.qvtrelationcst.PatternCS;
import org.eclipse.qvtd.xtext.qvtrelationcst.PredicateCS;
import org.eclipse.qvtd.xtext.qvtrelationcst.PrimitiveTypeDomainCS;
import org.eclipse.qvtd.xtext.qvtrelationcst.PropertyTemplateCS;
import org.eclipse.qvtd.xtext.qvtrelationcst.QVTrelationCSTFactory;
import org.eclipse.qvtd.xtext.qvtrelationcst.QVTrelationCSTPackage;
import org.eclipse.qvtd.xtext.qvtrelationcst.QueryCS;
import org.eclipse.qvtd.xtext.qvtrelationcst.RelationCS;
import org.eclipse.qvtd.xtext.qvtrelationcst.TemplateCS;
import org.eclipse.qvtd.xtext.qvtrelationcst.TemplateVariableCS;
import org.eclipse.qvtd.xtext.qvtrelationcst.TopLevelCS;
import org.eclipse.qvtd.xtext.qvtrelationcst.TransformationCS;
import org.eclipse.qvtd.xtext.qvtrelationcst.UnitCS;
import org.eclipse.qvtd.xtext.qvtrelationcst.VarDeclarationCS;
import org.eclipse.qvtd.xtext.qvtrelationcst.VarDeclarationIdCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class QVTrelationCSTPackageImpl extends EPackageImpl implements QVTrelationCSTPackage {
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
	private EClass defaultValueCSEClass = null;

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
	private EClass domainPatternCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass elementTemplateCSEClass = null;

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
	private EClass patternCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass predicateCSEClass = null;

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
	private EClass unitCSEClass = null;

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
	private EClass varDeclarationIdCSEClass = null;

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
	 * @see org.eclipse.qvtd.xtext.qvtrelationcst.QVTrelationCSTPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private QVTrelationCSTPackageImpl() {
		super(eNS_URI, QVTrelationCSTFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link QVTrelationCSTPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static QVTrelationCSTPackage init() {
		if (isInited) return (QVTrelationCSTPackage)EPackage.Registry.INSTANCE.getEPackage(QVTrelationCSTPackage.eNS_URI);

		// Obtain or create and register package
		QVTrelationCSTPackageImpl theQVTrelationCSTPackage = (QVTrelationCSTPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof QVTrelationCSTPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new QVTrelationCSTPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EssentialOCLCSTPackage.eINSTANCE.eClass();
		QVTrelationPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theQVTrelationCSTPackage.createPackageContents();

		// Initialize created meta-data
		theQVTrelationCSTPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theQVTrelationCSTPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(QVTrelationCSTPackage.eNS_URI, theQVTrelationCSTPackage);
		return theQVTrelationCSTPackage;
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
	public EReference getCollectionTemplateCS_MemberIdentifiers() {
		return (EReference)collectionTemplateCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCollectionTemplateCS_RestIdentifier() {
		return (EReference)collectionTemplateCSEClass.getEStructuralFeatures().get(1);
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
	public EReference getDefaultValueCS_Initialiser() {
		return (EReference)defaultValueCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDefaultValueCS_PropertyId() {
		return (EReference)defaultValueCSEClass.getEStructuralFeatures().get(1);
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
	public EReference getDomainCS_Pattern() {
		return (EReference)domainCSEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDomainCS_DefaultValues() {
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
	public EClass getDomainPatternCS() {
		return domainPatternCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDomainPatternCS_Template() {
		return (EReference)domainPatternCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getElementTemplateCS() {
		return elementTemplateCSEClass;
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
	public EReference getKeyDeclCS_PathName() {
		return (EReference)keyDeclCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getKeyDeclCS_PropertyIds() {
		return (EReference)keyDeclCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getKeyDeclCS_ClassId() {
		return (EReference)keyDeclCSEClass.getEStructuralFeatures().get(2);
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
	public EReference getModelDeclCS_MetaModelIds() {
		return (EReference)modelDeclCSEClass.getEStructuralFeatures().get(0);
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
	public EReference getObjectTemplateCS_PropertyTemplates() {
		return (EReference)objectTemplateCSEClass.getEStructuralFeatures().get(0);
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
	public EClass getPatternCS() {
		return patternCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPatternCS_Predicates() {
		return (EReference)patternCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPredicateCS() {
		return predicateCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPredicateCS_Expr() {
		return (EReference)predicateCSEClass.getEStructuralFeatures().get(0);
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
	public EReference getPropertyTemplateCS_ObjectTemplate() {
		return (EReference)propertyTemplateCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPropertyTemplateCS_PropertyId() {
		return (EReference)propertyTemplateCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPropertyTemplateCS_Expression() {
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
	public EReference getQueryCS_InputParamDeclarations() {
		return (EReference)queryCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getQueryCS_Expression() {
		return (EReference)queryCSEClass.getEStructuralFeatures().get(1);
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
	public EReference getRelationCS_Overrides() {
		return (EReference)relationCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRelationCS_VarDeclarations() {
		return (EReference)relationCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRelationCS_Domains() {
		return (EReference)relationCSEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRelationCS_When() {
		return (EReference)relationCSEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRelationCS_Where() {
		return (EReference)relationCSEClass.getEStructuralFeatures().get(5);
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
	public EReference getTopLevelCS_ImportClauses() {
		return (EReference)topLevelCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTopLevelCS_Transformations() {
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
	public EReference getTransformationCS_ModelDecls() {
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
	public EReference getTransformationCS_KeyDecls() {
		return (EReference)transformationCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTransformationCS_Queries() {
		return (EReference)transformationCSEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTransformationCS_Relation() {
		return (EReference)transformationCSEClass.getEStructuralFeatures().get(4);
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
	public EClass getVarDeclarationCS() {
		return varDeclarationCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVarDeclarationCS_VarDeclarationIds() {
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
	public EClass getVarDeclarationIdCS() {
		return varDeclarationIdCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QVTrelationCSTFactory getQVTrelationCSTFactory() {
		return (QVTrelationCSTFactory)getEFactoryInstance();
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
		createEReference(collectionTemplateCSEClass, COLLECTION_TEMPLATE_CS__MEMBER_IDENTIFIERS);
		createEReference(collectionTemplateCSEClass, COLLECTION_TEMPLATE_CS__REST_IDENTIFIER);

		defaultValueCSEClass = createEClass(DEFAULT_VALUE_CS);
		createEReference(defaultValueCSEClass, DEFAULT_VALUE_CS__INITIALISER);
		createEReference(defaultValueCSEClass, DEFAULT_VALUE_CS__PROPERTY_ID);

		domainCSEClass = createEClass(DOMAIN_CS);
		createEAttribute(domainCSEClass, DOMAIN_CS__CHECKONLY);
		createEAttribute(domainCSEClass, DOMAIN_CS__ENFORCE);
		createEReference(domainCSEClass, DOMAIN_CS__MODEL_ID);
		createEAttribute(domainCSEClass, DOMAIN_CS__REPLACE);
		createEReference(domainCSEClass, DOMAIN_CS__PATTERN);
		createEReference(domainCSEClass, DOMAIN_CS__DEFAULT_VALUES);
		createEReference(domainCSEClass, DOMAIN_CS__IMPLEMENTED_BY);

		domainPatternCSEClass = createEClass(DOMAIN_PATTERN_CS);
		createEReference(domainPatternCSEClass, DOMAIN_PATTERN_CS__TEMPLATE);

		elementTemplateCSEClass = createEClass(ELEMENT_TEMPLATE_CS);

		keyDeclCSEClass = createEClass(KEY_DECL_CS);
		createEReference(keyDeclCSEClass, KEY_DECL_CS__PATH_NAME);
		createEReference(keyDeclCSEClass, KEY_DECL_CS__PROPERTY_IDS);
		createEReference(keyDeclCSEClass, KEY_DECL_CS__CLASS_ID);

		modelDeclCSEClass = createEClass(MODEL_DECL_CS);
		createEReference(modelDeclCSEClass, MODEL_DECL_CS__META_MODEL_IDS);

		objectTemplateCSEClass = createEClass(OBJECT_TEMPLATE_CS);
		createEReference(objectTemplateCSEClass, OBJECT_TEMPLATE_CS__PROPERTY_TEMPLATES);

		paramDeclarationCSEClass = createEClass(PARAM_DECLARATION_CS);

		patternCSEClass = createEClass(PATTERN_CS);
		createEReference(patternCSEClass, PATTERN_CS__PREDICATES);

		predicateCSEClass = createEClass(PREDICATE_CS);
		createEReference(predicateCSEClass, PREDICATE_CS__EXPR);

		primitiveTypeDomainCSEClass = createEClass(PRIMITIVE_TYPE_DOMAIN_CS);

		propertyTemplateCSEClass = createEClass(PROPERTY_TEMPLATE_CS);
		createEReference(propertyTemplateCSEClass, PROPERTY_TEMPLATE_CS__OBJECT_TEMPLATE);
		createEReference(propertyTemplateCSEClass, PROPERTY_TEMPLATE_CS__PROPERTY_ID);
		createEReference(propertyTemplateCSEClass, PROPERTY_TEMPLATE_CS__EXPRESSION);
		createEAttribute(propertyTemplateCSEClass, PROPERTY_TEMPLATE_CS__OPPOSITE);

		queryCSEClass = createEClass(QUERY_CS);
		createEReference(queryCSEClass, QUERY_CS__INPUT_PARAM_DECLARATIONS);
		createEReference(queryCSEClass, QUERY_CS__EXPRESSION);

		relationCSEClass = createEClass(RELATION_CS);
		createEAttribute(relationCSEClass, RELATION_CS__TOP);
		createEReference(relationCSEClass, RELATION_CS__OVERRIDES);
		createEReference(relationCSEClass, RELATION_CS__VAR_DECLARATIONS);
		createEReference(relationCSEClass, RELATION_CS__DOMAINS);
		createEReference(relationCSEClass, RELATION_CS__WHEN);
		createEReference(relationCSEClass, RELATION_CS__WHERE);

		templateCSEClass = createEClass(TEMPLATE_CS);
		createEReference(templateCSEClass, TEMPLATE_CS__GUARD_EXPRESSION);

		templateVariableCSEClass = createEClass(TEMPLATE_VARIABLE_CS);
		createEReference(templateVariableCSEClass, TEMPLATE_VARIABLE_CS__TYPE);

		topLevelCSEClass = createEClass(TOP_LEVEL_CS);
		createEReference(topLevelCSEClass, TOP_LEVEL_CS__IMPORT_CLAUSES);
		createEReference(topLevelCSEClass, TOP_LEVEL_CS__TRANSFORMATIONS);

		transformationCSEClass = createEClass(TRANSFORMATION_CS);
		createEReference(transformationCSEClass, TRANSFORMATION_CS__MODEL_DECLS);
		createEReference(transformationCSEClass, TRANSFORMATION_CS__EXTENDS);
		createEReference(transformationCSEClass, TRANSFORMATION_CS__KEY_DECLS);
		createEReference(transformationCSEClass, TRANSFORMATION_CS__QUERIES);
		createEReference(transformationCSEClass, TRANSFORMATION_CS__RELATION);

		unitCSEClass = createEClass(UNIT_CS);
		createEReference(unitCSEClass, UNIT_CS__IDENTIFIER);

		varDeclarationCSEClass = createEClass(VAR_DECLARATION_CS);
		createEReference(varDeclarationCSEClass, VAR_DECLARATION_CS__VAR_DECLARATION_IDS);
		createEReference(varDeclarationCSEClass, VAR_DECLARATION_CS__TYPE);

		varDeclarationIdCSEClass = createEClass(VAR_DECLARATION_ID_CS);
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
		BaseCSTPackage theBaseCSTPackage = (BaseCSTPackage)EPackage.Registry.INSTANCE.getEPackage(BaseCSTPackage.eNS_URI);
		PivotPackage thePivotPackage = (PivotPackage)EPackage.Registry.INSTANCE.getEPackage(PivotPackage.eNS_URI);
		EssentialOCLCSTPackage theEssentialOCLCSTPackage = (EssentialOCLCSTPackage)EPackage.Registry.INSTANCE.getEPackage(EssentialOCLCSTPackage.eNS_URI);
		QVTbasePackage theQVTbasePackage = (QVTbasePackage)EPackage.Registry.INSTANCE.getEPackage(QVTbasePackage.eNS_URI);
		QVTrelationPackage theQVTrelationPackage = (QVTrelationPackage)EPackage.Registry.INSTANCE.getEPackage(QVTrelationPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		abstractDomainCSEClass.getESuperTypes().add(theBaseCSTPackage.getModelElementCS());
		abstractDomainCSEClass.getESuperTypes().add(thePivotPackage.getNameable());
		collectionTemplateCSEClass.getESuperTypes().add(this.getTemplateCS());
		defaultValueCSEClass.getESuperTypes().add(theBaseCSTPackage.getModelElementCS());
		domainCSEClass.getESuperTypes().add(this.getAbstractDomainCS());
		domainPatternCSEClass.getESuperTypes().add(theBaseCSTPackage.getModelElementCS());
		elementTemplateCSEClass.getESuperTypes().add(this.getTemplateVariableCS());
		keyDeclCSEClass.getESuperTypes().add(theBaseCSTPackage.getModelElementCS());
		modelDeclCSEClass.getESuperTypes().add(theBaseCSTPackage.getNamedElementCS());
		objectTemplateCSEClass.getESuperTypes().add(this.getTemplateCS());
		paramDeclarationCSEClass.getESuperTypes().add(theBaseCSTPackage.getTypedElementCS());
		patternCSEClass.getESuperTypes().add(theBaseCSTPackage.getModelElementCS());
		predicateCSEClass.getESuperTypes().add(theBaseCSTPackage.getModelElementCS());
		primitiveTypeDomainCSEClass.getESuperTypes().add(this.getTemplateVariableCS());
		primitiveTypeDomainCSEClass.getESuperTypes().add(this.getAbstractDomainCS());
		propertyTemplateCSEClass.getESuperTypes().add(theBaseCSTPackage.getModelElementCS());
		queryCSEClass.getESuperTypes().add(theBaseCSTPackage.getTypedElementCS());
		relationCSEClass.getESuperTypes().add(theBaseCSTPackage.getNamedElementCS());
		templateCSEClass.getESuperTypes().add(this.getTemplateVariableCS());
		templateCSEClass.getESuperTypes().add(theEssentialOCLCSTPackage.getExpCS());
		templateVariableCSEClass.getESuperTypes().add(theBaseCSTPackage.getNamedElementCS());
		topLevelCSEClass.getESuperTypes().add(theBaseCSTPackage.getRootPackageCS());
		transformationCSEClass.getESuperTypes().add(theBaseCSTPackage.getPackageCS());
		unitCSEClass.getESuperTypes().add(theBaseCSTPackage.getModelElementCS());
		varDeclarationCSEClass.getESuperTypes().add(theBaseCSTPackage.getModelElementCS());
		varDeclarationIdCSEClass.getESuperTypes().add(theBaseCSTPackage.getNamedElementCS());

		// Initialize classes and features; add operations and parameters
		initEClass(abstractDomainCSEClass, AbstractDomainCS.class, "AbstractDomainCS", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(collectionTemplateCSEClass, CollectionTemplateCS.class, "CollectionTemplateCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCollectionTemplateCS_MemberIdentifiers(), this.getTemplateVariableCS(), null, "memberIdentifiers", null, 1, -1, CollectionTemplateCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCollectionTemplateCS_RestIdentifier(), thePivotPackage.getVariable(), null, "restIdentifier", null, 0, 1, CollectionTemplateCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(defaultValueCSEClass, DefaultValueCS.class, "DefaultValueCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDefaultValueCS_Initialiser(), theEssentialOCLCSTPackage.getExpCS(), null, "initialiser", null, 1, 1, DefaultValueCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDefaultValueCS_PropertyId(), thePivotPackage.getVariable(), null, "propertyId", null, 1, 1, DefaultValueCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(domainCSEClass, DomainCS.class, "DomainCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDomainCS_Checkonly(), ecorePackage.getEBoolean(), "checkonly", null, 0, 1, DomainCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDomainCS_Enforce(), ecorePackage.getEBoolean(), "enforce", null, 0, 1, DomainCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDomainCS_ModelId(), theQVTbasePackage.getTypedModel(), null, "modelId", null, 0, 1, DomainCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDomainCS_Replace(), ecorePackage.getEBoolean(), "replace", null, 0, 1, DomainCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDomainCS_Pattern(), this.getDomainPatternCS(), null, "pattern", null, 0, 1, DomainCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDomainCS_DefaultValues(), this.getDefaultValueCS(), null, "defaultValues", null, 0, -1, DomainCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDomainCS_ImplementedBy(), theEssentialOCLCSTPackage.getExpCS(), null, "implementedBy", null, 0, 1, DomainCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(domainPatternCSEClass, DomainPatternCS.class, "DomainPatternCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDomainPatternCS_Template(), this.getTemplateCS(), null, "template", null, 0, 1, DomainPatternCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(elementTemplateCSEClass, ElementTemplateCS.class, "ElementTemplateCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(keyDeclCSEClass, KeyDeclCS.class, "KeyDeclCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getKeyDeclCS_PathName(), theBaseCSTPackage.getPathNameCS(), null, "pathName", null, 0, 1, KeyDeclCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getKeyDeclCS_PropertyIds(), thePivotPackage.getProperty(), null, "propertyIds", null, 0, -1, KeyDeclCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getKeyDeclCS_ClassId(), thePivotPackage.getClass_(), null, "classId", null, 0, 1, KeyDeclCS.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(modelDeclCSEClass, ModelDeclCS.class, "ModelDeclCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getModelDeclCS_MetaModelIds(), thePivotPackage.getNamespace(), null, "metaModelIds", null, 0, -1, ModelDeclCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(objectTemplateCSEClass, ObjectTemplateCS.class, "ObjectTemplateCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getObjectTemplateCS_PropertyTemplates(), this.getPropertyTemplateCS(), this.getPropertyTemplateCS_ObjectTemplate(), "propertyTemplates", null, 0, -1, ObjectTemplateCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(paramDeclarationCSEClass, ParamDeclarationCS.class, "ParamDeclarationCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(patternCSEClass, PatternCS.class, "PatternCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPatternCS_Predicates(), this.getPredicateCS(), null, "predicates", null, 1, -1, PatternCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(predicateCSEClass, PredicateCS.class, "PredicateCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPredicateCS_Expr(), theEssentialOCLCSTPackage.getExpCS(), null, "expr", null, 1, 1, PredicateCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(primitiveTypeDomainCSEClass, PrimitiveTypeDomainCS.class, "PrimitiveTypeDomainCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(propertyTemplateCSEClass, PropertyTemplateCS.class, "PropertyTemplateCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPropertyTemplateCS_ObjectTemplate(), this.getObjectTemplateCS(), this.getObjectTemplateCS_PropertyTemplates(), "objectTemplate", null, 0, 1, PropertyTemplateCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPropertyTemplateCS_PropertyId(), thePivotPackage.getProperty(), null, "propertyId", null, 0, 1, PropertyTemplateCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPropertyTemplateCS_Expression(), theEssentialOCLCSTPackage.getExpCS(), null, "expression", null, 0, 1, PropertyTemplateCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPropertyTemplateCS_Opposite(), ecorePackage.getEBoolean(), "opposite", "false", 0, 1, PropertyTemplateCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(queryCSEClass, QueryCS.class, "QueryCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getQueryCS_InputParamDeclarations(), this.getParamDeclarationCS(), null, "inputParamDeclarations", null, 0, -1, QueryCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getQueryCS_Expression(), theEssentialOCLCSTPackage.getExpCS(), null, "expression", null, 0, 1, QueryCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(relationCSEClass, RelationCS.class, "RelationCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRelationCS_Top(), ecorePackage.getEBoolean(), "top", null, 0, 1, RelationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRelationCS_Overrides(), theQVTrelationPackage.getRelation(), null, "overrides", null, 0, 1, RelationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRelationCS_VarDeclarations(), this.getVarDeclarationCS(), null, "varDeclarations", null, 0, -1, RelationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRelationCS_Domains(), this.getAbstractDomainCS(), null, "domains", null, 0, -1, RelationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRelationCS_When(), this.getPatternCS(), null, "when", null, 0, 1, RelationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRelationCS_Where(), this.getPatternCS(), null, "where", null, 0, 1, RelationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(templateCSEClass, TemplateCS.class, "TemplateCS", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTemplateCS_GuardExpression(), theEssentialOCLCSTPackage.getExpCS(), null, "guardExpression", null, 0, 1, TemplateCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(templateVariableCSEClass, TemplateVariableCS.class, "TemplateVariableCS", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTemplateVariableCS_Type(), theBaseCSTPackage.getTypedRefCS(), null, "type", null, 0, 1, TemplateVariableCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(topLevelCSEClass, TopLevelCS.class, "TopLevelCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTopLevelCS_ImportClauses(), this.getUnitCS(), null, "importClauses", null, 0, -1, TopLevelCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTopLevelCS_Transformations(), this.getTransformationCS(), null, "transformations", null, 0, -1, TopLevelCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(transformationCSEClass, TransformationCS.class, "TransformationCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTransformationCS_ModelDecls(), this.getModelDeclCS(), null, "modelDecls", null, 0, -1, TransformationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTransformationCS_Extends(), theQVTbasePackage.getTransformation(), null, "extends", null, 0, -1, TransformationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTransformationCS_KeyDecls(), this.getKeyDeclCS(), null, "keyDecls", null, 0, -1, TransformationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTransformationCS_Queries(), this.getQueryCS(), null, "queries", null, 0, -1, TransformationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTransformationCS_Relation(), this.getRelationCS(), null, "relation", null, 0, -1, TransformationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(unitCSEClass, UnitCS.class, "UnitCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUnitCS_Identifier(), thePivotPackage.getElement(), null, "identifier", null, 1, -1, UnitCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(varDeclarationCSEClass, VarDeclarationCS.class, "VarDeclarationCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVarDeclarationCS_VarDeclarationIds(), this.getVarDeclarationIdCS(), null, "varDeclarationIds", null, 0, -1, VarDeclarationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVarDeclarationCS_Type(), theBaseCSTPackage.getTypedRefCS(), null, "type", null, 0, 1, VarDeclarationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(varDeclarationIdCSEClass, VarDeclarationIdCS.class, "VarDeclarationIdCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //QVTrelationCSTPackageImpl
