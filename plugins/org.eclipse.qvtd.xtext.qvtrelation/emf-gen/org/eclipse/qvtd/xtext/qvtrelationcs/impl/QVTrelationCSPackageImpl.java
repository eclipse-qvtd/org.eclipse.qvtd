/*******************************************************************************
 * Copyright (c) 2012, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtrelationcs.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.xtext.basecs.BaseCSPackage;
import org.eclipse.ocl.xtext.basecs.impl.ModelElementCSImpl;
import org.eclipse.ocl.xtext.basecs.impl.NamedElementCSImpl;
import org.eclipse.ocl.xtext.basecs.impl.RootPackageCSImpl;
import org.eclipse.ocl.xtext.basecs.impl.TypedElementCSImpl;
import org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage;
import org.eclipse.ocl.xtext.essentialoclcs.impl.ExpCSImpl;
import org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage;
import org.eclipse.qvtd.pivot.qvtrelation.QVTrelationPackage;
import org.eclipse.qvtd.pivot.qvttemplate.QVTtemplatePackage;
import org.eclipse.qvtd.xtext.qvtbasecs.QVTbaseCSPackage;
import org.eclipse.qvtd.xtext.qvtbasecs.impl.AbstractTransformationCSImpl;
import org.eclipse.qvtd.xtext.qvtrelationcs.AbstractDomainCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.CollectionTemplateCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.DefaultValueCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.DomainCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.DomainPatternCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.ElementTemplateCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.KeyDeclCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.ModelDeclCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.ObjectTemplateCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.ParamDeclarationCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.PatternCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.PredicateCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.PrimitiveTypeDomainCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.PrimitiveTypeDomainPatternCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.PropertyTemplateCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.QVTrelationCSFactory;
import org.eclipse.qvtd.xtext.qvtrelationcs.QVTrelationCSPackage;
import org.eclipse.qvtd.xtext.qvtrelationcs.QueryCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.RelationCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.TemplateCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.TemplateVariableCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.TopLevelCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.TransformationCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.VarDeclarationCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.VarDeclarationIdCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class QVTrelationCSPackageImpl extends EPackageImpl implements QVTrelationCSPackage {
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
	private EClass varDeclarationCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass varDeclarationIdCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass primitiveTypeDomainPatternCSEClass = null;

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
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.QVTrelationCSPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private QVTrelationCSPackageImpl() {
		super(eNS_URI, QVTrelationCSFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link QVTrelationCSPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static QVTrelationCSPackage init() {
		if (isInited) return (QVTrelationCSPackage)EPackage.Registry.INSTANCE.getEPackage(QVTrelationCSPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredQVTrelationCSPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		QVTrelationCSPackageImpl theQVTrelationCSPackage = registeredQVTrelationCSPackage instanceof QVTrelationCSPackageImpl ? (QVTrelationCSPackageImpl)registeredQVTrelationCSPackage : new QVTrelationCSPackageImpl();

		isInited = true;

		// Initialize simple dependencies
		BaseCSPackage.eINSTANCE.eClass();
		EssentialOCLCSPackage.eINSTANCE.eClass();
		PivotPackage.eINSTANCE.eClass();
		QVTbasePackage.eINSTANCE.eClass();
		QVTbaseCSPackage.eINSTANCE.eClass();
		QVTrelationPackage.eINSTANCE.eClass();
		QVTtemplatePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theQVTrelationCSPackage.createPackageContents();

		// Initialize created meta-data
		theQVTrelationCSPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theQVTrelationCSPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(QVTrelationCSPackage.eNS_URI, theQVTrelationCSPackage);
		return theQVTrelationCSPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAbstractDomainCS() {
		return abstractDomainCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCollectionTemplateCS() {
		return collectionTemplateCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCollectionTemplateCS_OwnedMemberIdentifiers() {
		return (EReference)collectionTemplateCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCollectionTemplateCS_OwnedRestIdentifier() {
		return (EReference)collectionTemplateCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDefaultValueCS() {
		return defaultValueCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDefaultValueCS_OwnedInitExpression() {
		return (EReference)defaultValueCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDefaultValueCS_PropertyId() {
		return (EReference)defaultValueCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDomainCS() {
		return domainCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDomainCS_ImplementedBy() {
		return (EAttribute)domainCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDomainCS_IsCheckonly() {
		return (EAttribute)domainCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDomainCS_IsEnforce() {
		return (EAttribute)domainCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDomainCS_ModelId() {
		return (EReference)domainCSEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDomainCS_IsReplace() {
		return (EAttribute)domainCSEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDomainCS_OwnedPatterns() {
		return (EReference)domainCSEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDomainCS_OwnedDefaultValues() {
		return (EReference)domainCSEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDomainCS_OwnedImplementedBy() {
		return (EReference)domainCSEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDomainPatternCS() {
		return domainPatternCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDomainPatternCS_OwnedTemplate() {
		return (EReference)domainPatternCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getElementTemplateCS() {
		return elementTemplateCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getElementTemplateCS_Identifier() {
		return (EReference)elementTemplateCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getKeyDeclCS() {
		return keyDeclCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getKeyDeclCS_OwnedPathName() {
		return (EReference)keyDeclCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getKeyDeclCS_PropertyIds() {
		return (EReference)keyDeclCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getKeyDeclCS_OwnedOppositePropertyIds() {
		return (EReference)keyDeclCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getKeyDeclCS_ClassId() {
		return (EReference)keyDeclCSEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getModelDeclCS() {
		return modelDeclCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getModelDeclCS_MetamodelIds() {
		return (EReference)modelDeclCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getModelDeclCS_DependsOn() {
		return (EReference)modelDeclCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getModelDeclCS_Iterates() {
		return (EReference)modelDeclCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getObjectTemplateCS() {
		return objectTemplateCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getObjectTemplateCS_OwnedPropertyTemplates() {
		return (EReference)objectTemplateCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getParamDeclarationCS() {
		return paramDeclarationCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPatternCS() {
		return patternCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPatternCS_OwnedPredicates() {
		return (EReference)patternCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPredicateCS() {
		return predicateCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPredicateCS_OwnedCondition() {
		return (EReference)predicateCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPrimitiveTypeDomainCS() {
		return primitiveTypeDomainCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPrimitiveTypeDomainCS_OwnedPatterns() {
		return (EReference)primitiveTypeDomainCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPropertyTemplateCS() {
		return propertyTemplateCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPropertyTemplateCS_OwningObjectTemplate() {
		return (EReference)propertyTemplateCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPropertyTemplateCS_PropertyId() {
		return (EReference)propertyTemplateCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPropertyTemplateCS_OwnedOppositePropertyId() {
		return (EReference)propertyTemplateCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPropertyTemplateCS_OwnedExpression() {
		return (EReference)propertyTemplateCSEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getQueryCS() {
		return queryCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getQueryCS_OwnedParameters() {
		return (EReference)queryCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getQueryCS_OwnedExpression() {
		return (EReference)queryCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getQueryCS_IsTransient() {
		return (EAttribute)queryCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getRelationCS() {
		return relationCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getRelationCS_IsAbstract() {
		return (EAttribute)relationCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getRelationCS_IsTop() {
		return (EAttribute)relationCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRelationCS_Overridden() {
		return (EReference)relationCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRelationCS_OwnedVarDeclarations() {
		return (EReference)relationCSEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRelationCS_OwnedDomains() {
		return (EReference)relationCSEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRelationCS_OwnedWhen() {
		return (EReference)relationCSEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRelationCS_OwnedWhere() {
		return (EReference)relationCSEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTemplateCS() {
		return templateCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTemplateCS_OwnedGuardExpression() {
		return (EReference)templateCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTemplateVariableCS() {
		return templateVariableCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTemplateVariableCS_OwnedType() {
		return (EReference)templateVariableCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTopLevelCS() {
		return topLevelCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTopLevelCS_OwnedTransformations() {
		return (EReference)topLevelCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTransformationCS() {
		return transformationCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTransformationCS_OwnedModelDecls() {
		return (EReference)transformationCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTransformationCS_Extends() {
		return (EReference)transformationCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTransformationCS_OwnedKeyDecls() {
		return (EReference)transformationCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTransformationCS_OwnedProperties() {
		return (EReference)transformationCSEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTransformationCS_OwnedQueries() {
		return (EReference)transformationCSEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTransformationCS_OwnedRelations() {
		return (EReference)transformationCSEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getVarDeclarationCS() {
		return varDeclarationCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getVarDeclarationCS_OwnedInitExpression() {
		return (EReference)varDeclarationCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getVarDeclarationCS_OwnedVarDeclarationIds() {
		return (EReference)varDeclarationCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getVarDeclarationCS_OwnedType() {
		return (EReference)varDeclarationCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getVarDeclarationIdCS() {
		return varDeclarationIdCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPrimitiveTypeDomainPatternCS() {
		return primitiveTypeDomainPatternCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public QVTrelationCSFactory getQVTrelationCSFactory() {
		return (QVTrelationCSFactory)getEFactoryInstance();
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
		abstractDomainCSEClass = createEClass(0);

		collectionTemplateCSEClass = createEClass(1);
		createEReference(collectionTemplateCSEClass, ExpCSImpl.EXP_CS_FEATURE_COUNT + 3);
		createEReference(collectionTemplateCSEClass, ExpCSImpl.EXP_CS_FEATURE_COUNT + 4);

		defaultValueCSEClass = createEClass(2);
		createEReference(defaultValueCSEClass, ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 0);
		createEReference(defaultValueCSEClass, ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 1);

		domainCSEClass = createEClass(3);
		createEAttribute(domainCSEClass, ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 0);
		createEAttribute(domainCSEClass, ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 1);
		createEAttribute(domainCSEClass, ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 2);
		createEReference(domainCSEClass, ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 3);
		createEAttribute(domainCSEClass, ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 4);
		createEReference(domainCSEClass, ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 5);
		createEReference(domainCSEClass, ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 6);
		createEReference(domainCSEClass, ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 7);

		domainPatternCSEClass = createEClass(4);
		createEReference(domainPatternCSEClass, ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 0);

		elementTemplateCSEClass = createEClass(5);
		createEReference(elementTemplateCSEClass, NamedElementCSImpl.NAMED_ELEMENT_CS_FEATURE_COUNT + 1);

		keyDeclCSEClass = createEClass(6);
		createEReference(keyDeclCSEClass, ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 0);
		createEReference(keyDeclCSEClass, ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 1);
		createEReference(keyDeclCSEClass, ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 2);
		createEReference(keyDeclCSEClass, ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 3);

		modelDeclCSEClass = createEClass(7);
		createEReference(modelDeclCSEClass, NamedElementCSImpl.NAMED_ELEMENT_CS_FEATURE_COUNT + 0);
		createEReference(modelDeclCSEClass, NamedElementCSImpl.NAMED_ELEMENT_CS_FEATURE_COUNT + 1);
		createEReference(modelDeclCSEClass, NamedElementCSImpl.NAMED_ELEMENT_CS_FEATURE_COUNT + 2);

		objectTemplateCSEClass = createEClass(8);
		createEReference(objectTemplateCSEClass, ExpCSImpl.EXP_CS_FEATURE_COUNT + 3);

		paramDeclarationCSEClass = createEClass(9);

		patternCSEClass = createEClass(10);
		createEReference(patternCSEClass, ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 0);

		predicateCSEClass = createEClass(11);
		createEReference(predicateCSEClass, ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 0);

		primitiveTypeDomainCSEClass = createEClass(12);
		createEReference(primitiveTypeDomainCSEClass, ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 0);

		primitiveTypeDomainPatternCSEClass = createEClass(13);

		propertyTemplateCSEClass = createEClass(14);
		createEReference(propertyTemplateCSEClass, ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 0);
		createEReference(propertyTemplateCSEClass, ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 1);
		createEReference(propertyTemplateCSEClass, ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 2);
		createEReference(propertyTemplateCSEClass, ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 3);

		queryCSEClass = createEClass(15);
		createEReference(queryCSEClass, TypedElementCSImpl.TYPED_ELEMENT_CS_FEATURE_COUNT + 1);
		createEReference(queryCSEClass, TypedElementCSImpl.TYPED_ELEMENT_CS_FEATURE_COUNT + 2);
		createEAttribute(queryCSEClass, TypedElementCSImpl.TYPED_ELEMENT_CS_FEATURE_COUNT + 3);

		relationCSEClass = createEClass(16);
		createEAttribute(relationCSEClass, NamedElementCSImpl.NAMED_ELEMENT_CS_FEATURE_COUNT + 0);
		createEAttribute(relationCSEClass, NamedElementCSImpl.NAMED_ELEMENT_CS_FEATURE_COUNT + 1);
		createEReference(relationCSEClass, NamedElementCSImpl.NAMED_ELEMENT_CS_FEATURE_COUNT + 2);
		createEReference(relationCSEClass, NamedElementCSImpl.NAMED_ELEMENT_CS_FEATURE_COUNT + 3);
		createEReference(relationCSEClass, NamedElementCSImpl.NAMED_ELEMENT_CS_FEATURE_COUNT + 4);
		createEReference(relationCSEClass, NamedElementCSImpl.NAMED_ELEMENT_CS_FEATURE_COUNT + 5);
		createEReference(relationCSEClass, NamedElementCSImpl.NAMED_ELEMENT_CS_FEATURE_COUNT + 6);

		templateCSEClass = createEClass(17);
		createEReference(templateCSEClass, ExpCSImpl.EXP_CS_FEATURE_COUNT + 2);

		templateVariableCSEClass = createEClass(18);
		createEReference(templateVariableCSEClass, NamedElementCSImpl.NAMED_ELEMENT_CS_FEATURE_COUNT + 0);

		topLevelCSEClass = createEClass(19);
		createEReference(topLevelCSEClass, RootPackageCSImpl.ROOT_PACKAGE_CS_FEATURE_COUNT + 0);

		transformationCSEClass = createEClass(20);
		createEReference(transformationCSEClass, AbstractTransformationCSImpl.ABSTRACT_TRANSFORMATION_CS_FEATURE_COUNT + 0);
		createEReference(transformationCSEClass, AbstractTransformationCSImpl.ABSTRACT_TRANSFORMATION_CS_FEATURE_COUNT + 1);
		createEReference(transformationCSEClass, AbstractTransformationCSImpl.ABSTRACT_TRANSFORMATION_CS_FEATURE_COUNT + 2);
		createEReference(transformationCSEClass, AbstractTransformationCSImpl.ABSTRACT_TRANSFORMATION_CS_FEATURE_COUNT + 3);
		createEReference(transformationCSEClass, AbstractTransformationCSImpl.ABSTRACT_TRANSFORMATION_CS_FEATURE_COUNT + 4);
		createEReference(transformationCSEClass, AbstractTransformationCSImpl.ABSTRACT_TRANSFORMATION_CS_FEATURE_COUNT + 5);

		varDeclarationCSEClass = createEClass(21);
		createEReference(varDeclarationCSEClass, ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 0);
		createEReference(varDeclarationCSEClass, ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 1);
		createEReference(varDeclarationCSEClass, ModelElementCSImpl.MODEL_ELEMENT_CS_FEATURE_COUNT + 2);

		varDeclarationIdCSEClass = createEClass(22);
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
		BaseCSPackage theBaseCSPackage = (BaseCSPackage)EPackage.Registry.INSTANCE.getEPackage(BaseCSPackage.eNS_URI);
		EssentialOCLCSPackage theEssentialOCLCSPackage = (EssentialOCLCSPackage)EPackage.Registry.INSTANCE.getEPackage(EssentialOCLCSPackage.eNS_URI);
		QVTrelationPackage theQVTrelationPackage = (QVTrelationPackage)EPackage.Registry.INSTANCE.getEPackage(QVTrelationPackage.eNS_URI);
		PivotPackage thePivotPackage = (PivotPackage)EPackage.Registry.INSTANCE.getEPackage(PivotPackage.eNS_URI);
		QVTbasePackage theQVTbasePackage = (QVTbasePackage)EPackage.Registry.INSTANCE.getEPackage(QVTbasePackage.eNS_URI);
		QVTbaseCSPackage theQVTbaseCSPackage = (QVTbaseCSPackage)EPackage.Registry.INSTANCE.getEPackage(QVTbaseCSPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		abstractDomainCSEClass.getESuperTypes().add(theBaseCSPackage.getModelElementCS());
		collectionTemplateCSEClass.getESuperTypes().add(this.getTemplateCS());
		defaultValueCSEClass.getESuperTypes().add(theBaseCSPackage.getModelElementCS());
		domainCSEClass.getESuperTypes().add(this.getAbstractDomainCS());
		domainPatternCSEClass.getESuperTypes().add(theBaseCSPackage.getModelElementCS());
		elementTemplateCSEClass.getESuperTypes().add(this.getTemplateVariableCS());
		keyDeclCSEClass.getESuperTypes().add(theBaseCSPackage.getModelElementCS());
		modelDeclCSEClass.getESuperTypes().add(theBaseCSPackage.getNamedElementCS());
		objectTemplateCSEClass.getESuperTypes().add(this.getTemplateCS());
		paramDeclarationCSEClass.getESuperTypes().add(theBaseCSPackage.getTypedElementCS());
		patternCSEClass.getESuperTypes().add(theBaseCSPackage.getModelElementCS());
		predicateCSEClass.getESuperTypes().add(theBaseCSPackage.getModelElementCS());
		primitiveTypeDomainCSEClass.getESuperTypes().add(this.getAbstractDomainCS());
		primitiveTypeDomainPatternCSEClass.getESuperTypes().add(this.getTemplateVariableCS());
		propertyTemplateCSEClass.getESuperTypes().add(theBaseCSPackage.getModelElementCS());
		queryCSEClass.getESuperTypes().add(theBaseCSPackage.getTypedElementCS());
		queryCSEClass.getESuperTypes().add(theQVTbaseCSPackage.getJavaImplementationCS());
		relationCSEClass.getESuperTypes().add(theBaseCSPackage.getNamedElementCS());
		templateCSEClass.getESuperTypes().add(theEssentialOCLCSPackage.getExpCS());
		templateCSEClass.getESuperTypes().add(this.getTemplateVariableCS());
		templateVariableCSEClass.getESuperTypes().add(theBaseCSPackage.getNamedElementCS());
		topLevelCSEClass.getESuperTypes().add(theBaseCSPackage.getRootPackageCS());
		transformationCSEClass.getESuperTypes().add(theQVTbaseCSPackage.getAbstractTransformationCS());
		varDeclarationCSEClass.getESuperTypes().add(theBaseCSPackage.getModelElementCS());
		varDeclarationIdCSEClass.getESuperTypes().add(theBaseCSPackage.getNamedElementCS());

		// Initialize classes and features; add operations and parameters
		initEClass(abstractDomainCSEClass, AbstractDomainCS.class, "AbstractDomainCS", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(collectionTemplateCSEClass, CollectionTemplateCS.class, "CollectionTemplateCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCollectionTemplateCS_OwnedMemberIdentifiers(), this.getTemplateVariableCS(), null, "ownedMemberIdentifiers", null, 1, -1, CollectionTemplateCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCollectionTemplateCS_OwnedRestIdentifier(), this.getElementTemplateCS(), null, "ownedRestIdentifier", null, 0, 1, CollectionTemplateCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(defaultValueCSEClass, DefaultValueCS.class, "DefaultValueCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDefaultValueCS_OwnedInitExpression(), theEssentialOCLCSPackage.getExpCS(), null, "ownedInitExpression", null, 1, 1, DefaultValueCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDefaultValueCS_PropertyId(), theQVTrelationPackage.getSharedVariable(), null, "propertyId", null, 1, 1, DefaultValueCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(domainCSEClass, DomainCS.class, "DomainCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDomainCS_ImplementedBy(), thePivotPackage.getString(), "implementedBy", null, 0, 1, DomainCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDomainCS_IsCheckonly(), ecorePackage.getEBoolean(), "isCheckonly", null, 0, 1, DomainCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDomainCS_IsEnforce(), ecorePackage.getEBoolean(), "isEnforce", null, 0, 1, DomainCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDomainCS_ModelId(), theQVTbasePackage.getTypedModel(), null, "modelId", null, 0, 1, DomainCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDomainCS_IsReplace(), ecorePackage.getEBoolean(), "isReplace", null, 0, 1, DomainCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDomainCS_OwnedPatterns(), this.getDomainPatternCS(), null, "ownedPatterns", null, 0, -1, DomainCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDomainCS_OwnedDefaultValues(), this.getDefaultValueCS(), null, "ownedDefaultValues", null, 0, -1, DomainCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDomainCS_OwnedImplementedBy(), theEssentialOCLCSPackage.getExpCS(), null, "ownedImplementedBy", null, 0, 1, DomainCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(domainPatternCSEClass, DomainPatternCS.class, "DomainPatternCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDomainPatternCS_OwnedTemplate(), this.getTemplateCS(), null, "ownedTemplate", null, 0, 1, DomainPatternCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(elementTemplateCSEClass, ElementTemplateCS.class, "ElementTemplateCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getElementTemplateCS_Identifier(), theQVTrelationPackage.getSharedVariable(), null, "identifier", null, 0, 1, ElementTemplateCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(keyDeclCSEClass, KeyDeclCS.class, "KeyDeclCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getKeyDeclCS_OwnedPathName(), theBaseCSPackage.getPathNameCS(), null, "ownedPathName", null, 0, 1, KeyDeclCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getKeyDeclCS_PropertyIds(), thePivotPackage.getProperty(), null, "propertyIds", null, 0, -1, KeyDeclCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getKeyDeclCS_OwnedOppositePropertyIds(), theBaseCSPackage.getPathNameCS(), null, "ownedOppositePropertyIds", null, 0, -1, KeyDeclCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getKeyDeclCS_ClassId(), thePivotPackage.getClass_(), null, "classId", null, 0, 1, KeyDeclCS.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(modelDeclCSEClass, ModelDeclCS.class, "ModelDeclCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getModelDeclCS_MetamodelIds(), thePivotPackage.getNamespace(), null, "metamodelIds", null, 0, -1, ModelDeclCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModelDeclCS_DependsOn(), theQVTbasePackage.getTypedModel(), null, "dependsOn", null, 0, -1, ModelDeclCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModelDeclCS_Iterates(), theQVTbasePackage.getTypedModel(), null, "iterates", null, 0, -1, ModelDeclCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(objectTemplateCSEClass, ObjectTemplateCS.class, "ObjectTemplateCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getObjectTemplateCS_OwnedPropertyTemplates(), this.getPropertyTemplateCS(), this.getPropertyTemplateCS_OwningObjectTemplate(), "ownedPropertyTemplates", null, 0, -1, ObjectTemplateCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(paramDeclarationCSEClass, ParamDeclarationCS.class, "ParamDeclarationCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(patternCSEClass, PatternCS.class, "PatternCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPatternCS_OwnedPredicates(), this.getPredicateCS(), null, "ownedPredicates", null, 1, -1, PatternCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(predicateCSEClass, PredicateCS.class, "PredicateCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPredicateCS_OwnedCondition(), theEssentialOCLCSPackage.getExpCS(), null, "ownedCondition", null, 1, 1, PredicateCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(primitiveTypeDomainCSEClass, PrimitiveTypeDomainCS.class, "PrimitiveTypeDomainCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPrimitiveTypeDomainCS_OwnedPatterns(), this.getPrimitiveTypeDomainPatternCS(), null, "ownedPatterns", null, 0, -1, PrimitiveTypeDomainCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(primitiveTypeDomainPatternCSEClass, PrimitiveTypeDomainPatternCS.class, "PrimitiveTypeDomainPatternCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(propertyTemplateCSEClass, PropertyTemplateCS.class, "PropertyTemplateCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPropertyTemplateCS_OwningObjectTemplate(), this.getObjectTemplateCS(), this.getObjectTemplateCS_OwnedPropertyTemplates(), "owningObjectTemplate", null, 0, 1, PropertyTemplateCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPropertyTemplateCS_PropertyId(), thePivotPackage.getProperty(), null, "propertyId", null, 0, 1, PropertyTemplateCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPropertyTemplateCS_OwnedOppositePropertyId(), theBaseCSPackage.getPathNameCS(), null, "ownedOppositePropertyId", null, 0, 1, PropertyTemplateCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPropertyTemplateCS_OwnedExpression(), theEssentialOCLCSPackage.getExpCS(), null, "ownedExpression", null, 0, 1, PropertyTemplateCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(queryCSEClass, QueryCS.class, "QueryCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getQueryCS_OwnedParameters(), this.getParamDeclarationCS(), null, "ownedParameters", null, 0, -1, QueryCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getQueryCS_OwnedExpression(), theEssentialOCLCSPackage.getExpCS(), null, "ownedExpression", null, 0, 1, QueryCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getQueryCS_IsTransient(), ecorePackage.getEBoolean(), "isTransient", "false", 0, 1, QueryCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(relationCSEClass, RelationCS.class, "RelationCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRelationCS_IsAbstract(), ecorePackage.getEBoolean(), "isAbstract", "false", 0, 1, RelationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRelationCS_IsTop(), ecorePackage.getEBoolean(), "isTop", "false", 0, 1, RelationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRelationCS_Overridden(), theQVTrelationPackage.getRelation(), null, "overridden", null, 0, 1, RelationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRelationCS_OwnedVarDeclarations(), this.getVarDeclarationCS(), null, "ownedVarDeclarations", null, 0, -1, RelationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRelationCS_OwnedDomains(), this.getAbstractDomainCS(), null, "ownedDomains", null, 0, -1, RelationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRelationCS_OwnedWhen(), this.getPatternCS(), null, "ownedWhen", null, 0, 1, RelationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRelationCS_OwnedWhere(), this.getPatternCS(), null, "ownedWhere", null, 0, 1, RelationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(templateCSEClass, TemplateCS.class, "TemplateCS", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTemplateCS_OwnedGuardExpression(), theEssentialOCLCSPackage.getExpCS(), null, "ownedGuardExpression", null, 0, 1, TemplateCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(templateVariableCSEClass, TemplateVariableCS.class, "TemplateVariableCS", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTemplateVariableCS_OwnedType(), theBaseCSPackage.getTypedRefCS(), null, "ownedType", null, 0, 1, TemplateVariableCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(topLevelCSEClass, TopLevelCS.class, "TopLevelCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTopLevelCS_OwnedTransformations(), this.getTransformationCS(), null, "ownedTransformations", null, 0, -1, TopLevelCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(transformationCSEClass, TransformationCS.class, "TransformationCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTransformationCS_OwnedModelDecls(), this.getModelDeclCS(), null, "ownedModelDecls", null, 0, -1, TransformationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTransformationCS_Extends(), theQVTbasePackage.getTransformation(), null, "extends", null, 0, -1, TransformationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTransformationCS_OwnedKeyDecls(), this.getKeyDeclCS(), null, "ownedKeyDecls", null, 0, -1, TransformationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTransformationCS_OwnedProperties(), theBaseCSPackage.getStructuralFeatureCS(), null, "ownedProperties", null, 0, -1, TransformationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTransformationCS_OwnedQueries(), this.getQueryCS(), null, "ownedQueries", null, 0, -1, TransformationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTransformationCS_OwnedRelations(), this.getRelationCS(), null, "ownedRelations", null, 0, -1, TransformationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(varDeclarationCSEClass, VarDeclarationCS.class, "VarDeclarationCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVarDeclarationCS_OwnedInitExpression(), theEssentialOCLCSPackage.getExpCS(), null, "ownedInitExpression", null, 0, 1, VarDeclarationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVarDeclarationCS_OwnedType(), theBaseCSPackage.getTypedRefCS(), null, "ownedType", null, 0, 1, VarDeclarationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVarDeclarationCS_OwnedVarDeclarationIds(), this.getVarDeclarationIdCS(), null, "ownedVarDeclarationIds", null, 0, -1, VarDeclarationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(varDeclarationIdCSEClass, VarDeclarationIdCS.class, "VarDeclarationIdCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //QVTrelationCSTPackageImpl
