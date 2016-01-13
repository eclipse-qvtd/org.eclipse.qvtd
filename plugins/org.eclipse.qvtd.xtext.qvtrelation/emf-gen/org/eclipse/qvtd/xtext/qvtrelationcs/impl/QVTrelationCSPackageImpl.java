/*******************************************************************************
 * Copyright (c) 2012, 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
import org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage;
import org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage;
import org.eclipse.qvtd.pivot.qvtrelation.QVTrelationPackage;
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
import org.eclipse.qvtd.xtext.qvtrelationcs.PropertyTemplateCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.QVTrelationCSFactory;
import org.eclipse.qvtd.xtext.qvtrelationcs.QVTrelationCSPackage;
import org.eclipse.qvtd.xtext.qvtrelationcs.QueryCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.RelationCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.TemplateCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.TemplateVariableCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.TopLevelCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.TransformationCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.UnitCS;
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
		Object ePackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		QVTrelationCSPackageImpl theQVTrelationCSPackage = (QVTrelationCSPackageImpl)(ePackage instanceof QVTrelationCSPackageImpl ? ePackage : new QVTrelationCSPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EssentialOCLCSPackage.eINSTANCE.eClass();
		QVTrelationPackage.eINSTANCE.eClass();

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
	public EReference getDomainCS_OwnedPattern() {
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
	public EClass getRelationCS() {
		return relationCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getRelationCS_IsDefault() {
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
	public EReference getRelationCS_Overrides() {
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
	public EReference getTopLevelCS_OwnedImportClauses() {
		return (EReference)topLevelCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTopLevelCS_OwnedTransformations() {
		return (EReference)topLevelCSEClass.getEStructuralFeatures().get(1);
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
	public EReference getTransformationCS_OwnedPathName() {
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
	public EClass getUnitCS() {
		return unitCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getUnitCS_Identifiers() {
		return (EReference)unitCSEClass.getEStructuralFeatures().get(0);
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
		abstractDomainCSEClass = createEClass(ABSTRACT_DOMAIN_CS);

		collectionTemplateCSEClass = createEClass(COLLECTION_TEMPLATE_CS);
		createEReference(collectionTemplateCSEClass, COLLECTION_TEMPLATE_CS__OWNED_MEMBER_IDENTIFIERS);
		createEReference(collectionTemplateCSEClass, COLLECTION_TEMPLATE_CS__OWNED_REST_IDENTIFIER);

		defaultValueCSEClass = createEClass(DEFAULT_VALUE_CS);
		createEReference(defaultValueCSEClass, DEFAULT_VALUE_CS__OWNED_INIT_EXPRESSION);
		createEReference(defaultValueCSEClass, DEFAULT_VALUE_CS__PROPERTY_ID);

		domainCSEClass = createEClass(DOMAIN_CS);
		createEAttribute(domainCSEClass, DOMAIN_CS__IMPLEMENTED_BY);
		createEAttribute(domainCSEClass, DOMAIN_CS__IS_CHECKONLY);
		createEAttribute(domainCSEClass, DOMAIN_CS__IS_ENFORCE);
		createEReference(domainCSEClass, DOMAIN_CS__MODEL_ID);
		createEAttribute(domainCSEClass, DOMAIN_CS__IS_REPLACE);
		createEReference(domainCSEClass, DOMAIN_CS__OWNED_PATTERN);
		createEReference(domainCSEClass, DOMAIN_CS__OWNED_DEFAULT_VALUES);
		createEReference(domainCSEClass, DOMAIN_CS__OWNED_IMPLEMENTED_BY);

		domainPatternCSEClass = createEClass(DOMAIN_PATTERN_CS);
		createEReference(domainPatternCSEClass, DOMAIN_PATTERN_CS__OWNED_TEMPLATE);

		elementTemplateCSEClass = createEClass(ELEMENT_TEMPLATE_CS);
		createEReference(elementTemplateCSEClass, ELEMENT_TEMPLATE_CS__IDENTIFIER);

		keyDeclCSEClass = createEClass(KEY_DECL_CS);
		createEReference(keyDeclCSEClass, KEY_DECL_CS__OWNED_PATH_NAME);
		createEReference(keyDeclCSEClass, KEY_DECL_CS__PROPERTY_IDS);
		createEReference(keyDeclCSEClass, KEY_DECL_CS__OWNED_OPPOSITE_PROPERTY_IDS);
		createEReference(keyDeclCSEClass, KEY_DECL_CS__CLASS_ID);

		modelDeclCSEClass = createEClass(MODEL_DECL_CS);
		createEReference(modelDeclCSEClass, MODEL_DECL_CS__METAMODEL_IDS);

		objectTemplateCSEClass = createEClass(OBJECT_TEMPLATE_CS);
		createEReference(objectTemplateCSEClass, OBJECT_TEMPLATE_CS__OWNED_PROPERTY_TEMPLATES);

		paramDeclarationCSEClass = createEClass(PARAM_DECLARATION_CS);

		patternCSEClass = createEClass(PATTERN_CS);
		createEReference(patternCSEClass, PATTERN_CS__OWNED_PREDICATES);

		predicateCSEClass = createEClass(PREDICATE_CS);
		createEReference(predicateCSEClass, PREDICATE_CS__OWNED_CONDITION);

		primitiveTypeDomainCSEClass = createEClass(PRIMITIVE_TYPE_DOMAIN_CS);

		propertyTemplateCSEClass = createEClass(PROPERTY_TEMPLATE_CS);
		createEReference(propertyTemplateCSEClass, PROPERTY_TEMPLATE_CS__OWNING_OBJECT_TEMPLATE);
		createEReference(propertyTemplateCSEClass, PROPERTY_TEMPLATE_CS__PROPERTY_ID);
		createEReference(propertyTemplateCSEClass, PROPERTY_TEMPLATE_CS__OWNED_OPPOSITE_PROPERTY_ID);
		createEReference(propertyTemplateCSEClass, PROPERTY_TEMPLATE_CS__OWNED_EXPRESSION);

		queryCSEClass = createEClass(QUERY_CS);
		createEReference(queryCSEClass, QUERY_CS__OWNED_PARAMETERS);
		createEReference(queryCSEClass, QUERY_CS__OWNED_EXPRESSION);

		relationCSEClass = createEClass(RELATION_CS);
		createEAttribute(relationCSEClass, RELATION_CS__IS_DEFAULT);
		createEAttribute(relationCSEClass, RELATION_CS__IS_TOP);
		createEReference(relationCSEClass, RELATION_CS__OVERRIDES);
		createEReference(relationCSEClass, RELATION_CS__OWNED_VAR_DECLARATIONS);
		createEReference(relationCSEClass, RELATION_CS__OWNED_DOMAINS);
		createEReference(relationCSEClass, RELATION_CS__OWNED_WHEN);
		createEReference(relationCSEClass, RELATION_CS__OWNED_WHERE);

		templateCSEClass = createEClass(TEMPLATE_CS);
		createEReference(templateCSEClass, TEMPLATE_CS__OWNED_GUARD_EXPRESSION);

		templateVariableCSEClass = createEClass(TEMPLATE_VARIABLE_CS);
		createEReference(templateVariableCSEClass, TEMPLATE_VARIABLE_CS__OWNED_TYPE);

		topLevelCSEClass = createEClass(TOP_LEVEL_CS);
		createEReference(topLevelCSEClass, TOP_LEVEL_CS__OWNED_IMPORT_CLAUSES);
		createEReference(topLevelCSEClass, TOP_LEVEL_CS__OWNED_TRANSFORMATIONS);

		transformationCSEClass = createEClass(TRANSFORMATION_CS);
		createEReference(transformationCSEClass, TRANSFORMATION_CS__OWNED_MODEL_DECLS);
		createEReference(transformationCSEClass, TRANSFORMATION_CS__EXTENDS);
		createEReference(transformationCSEClass, TRANSFORMATION_CS__OWNED_KEY_DECLS);
		createEReference(transformationCSEClass, TRANSFORMATION_CS__OWNED_PATH_NAME);
		createEReference(transformationCSEClass, TRANSFORMATION_CS__OWNED_QUERIES);
		createEReference(transformationCSEClass, TRANSFORMATION_CS__OWNED_RELATIONS);

		unitCSEClass = createEClass(UNIT_CS);
		createEReference(unitCSEClass, UNIT_CS__IDENTIFIERS);

		varDeclarationCSEClass = createEClass(VAR_DECLARATION_CS);
		createEReference(varDeclarationCSEClass, VAR_DECLARATION_CS__OWNED_INIT_EXPRESSION);
		createEReference(varDeclarationCSEClass, VAR_DECLARATION_CS__OWNED_TYPE);
		createEReference(varDeclarationCSEClass, VAR_DECLARATION_CS__OWNED_VAR_DECLARATION_IDS);

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
		BaseCSPackage theBaseCSPackage = (BaseCSPackage)EPackage.Registry.INSTANCE.getEPackage(BaseCSPackage.eNS_URI);
		PivotPackage thePivotPackage = (PivotPackage)EPackage.Registry.INSTANCE.getEPackage(PivotPackage.eNS_URI);
		EssentialOCLCSPackage theEssentialOCLCSPackage = (EssentialOCLCSPackage)EPackage.Registry.INSTANCE.getEPackage(EssentialOCLCSPackage.eNS_URI);
		QVTbasePackage theQVTbasePackage = (QVTbasePackage)EPackage.Registry.INSTANCE.getEPackage(QVTbasePackage.eNS_URI);
		QVTrelationPackage theQVTrelationPackage = (QVTrelationPackage)EPackage.Registry.INSTANCE.getEPackage(QVTrelationPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		abstractDomainCSEClass.getESuperTypes().add(theBaseCSPackage.getModelElementCS());
		abstractDomainCSEClass.getESuperTypes().add(thePivotPackage.getNameable());
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
		primitiveTypeDomainCSEClass.getESuperTypes().add(this.getTemplateVariableCS());
		primitiveTypeDomainCSEClass.getESuperTypes().add(this.getAbstractDomainCS());
		propertyTemplateCSEClass.getESuperTypes().add(theBaseCSPackage.getModelElementCS());
		queryCSEClass.getESuperTypes().add(theBaseCSPackage.getTypedElementCS());
		relationCSEClass.getESuperTypes().add(theBaseCSPackage.getNamedElementCS());
		templateCSEClass.getESuperTypes().add(theEssentialOCLCSPackage.getExpCS());
		templateCSEClass.getESuperTypes().add(this.getTemplateVariableCS());
		templateVariableCSEClass.getESuperTypes().add(theBaseCSPackage.getNamedElementCS());
		topLevelCSEClass.getESuperTypes().add(theBaseCSPackage.getRootPackageCS());
		transformationCSEClass.getESuperTypes().add(theBaseCSPackage.getClassCS());
		unitCSEClass.getESuperTypes().add(theBaseCSPackage.getModelElementCS());
		varDeclarationCSEClass.getESuperTypes().add(theBaseCSPackage.getModelElementCS());
		varDeclarationIdCSEClass.getESuperTypes().add(theBaseCSPackage.getNamedElementCS());

		// Initialize classes and features; add operations and parameters
		initEClass(abstractDomainCSEClass, AbstractDomainCS.class, "AbstractDomainCS", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(collectionTemplateCSEClass, CollectionTemplateCS.class, "CollectionTemplateCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCollectionTemplateCS_OwnedMemberIdentifiers(), this.getTemplateVariableCS(), null, "ownedMemberIdentifiers", null, 1, -1, CollectionTemplateCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCollectionTemplateCS_OwnedRestIdentifier(), this.getElementTemplateCS(), null, "ownedRestIdentifier", null, 0, 1, CollectionTemplateCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(defaultValueCSEClass, DefaultValueCS.class, "DefaultValueCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDefaultValueCS_OwnedInitExpression(), theEssentialOCLCSPackage.getExpCS(), null, "ownedInitExpression", null, 1, 1, DefaultValueCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDefaultValueCS_PropertyId(), thePivotPackage.getVariable(), null, "propertyId", null, 1, 1, DefaultValueCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(domainCSEClass, DomainCS.class, "DomainCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDomainCS_ImplementedBy(), thePivotPackage.getString(), "implementedBy", null, 0, 1, DomainCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDomainCS_IsCheckonly(), ecorePackage.getEBoolean(), "isCheckonly", null, 0, 1, DomainCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDomainCS_IsEnforce(), ecorePackage.getEBoolean(), "isEnforce", null, 0, 1, DomainCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDomainCS_ModelId(), theQVTbasePackage.getTypedModel(), null, "modelId", null, 0, 1, DomainCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDomainCS_IsReplace(), ecorePackage.getEBoolean(), "isReplace", null, 0, 1, DomainCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDomainCS_OwnedPattern(), this.getDomainPatternCS(), null, "ownedPattern", null, 0, -1, DomainCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDomainCS_OwnedDefaultValues(), this.getDefaultValueCS(), null, "ownedDefaultValues", null, 0, -1, DomainCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDomainCS_OwnedImplementedBy(), theEssentialOCLCSPackage.getExpCS(), null, "ownedImplementedBy", null, 0, 1, DomainCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(domainPatternCSEClass, DomainPatternCS.class, "DomainPatternCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDomainPatternCS_OwnedTemplate(), this.getTemplateCS(), null, "ownedTemplate", null, 0, 1, DomainPatternCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(elementTemplateCSEClass, ElementTemplateCS.class, "ElementTemplateCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getElementTemplateCS_Identifier(), thePivotPackage.getVariable(), null, "identifier", null, 0, 1, ElementTemplateCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(keyDeclCSEClass, KeyDeclCS.class, "KeyDeclCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getKeyDeclCS_OwnedPathName(), theBaseCSPackage.getPathNameCS(), null, "ownedPathName", null, 0, 1, KeyDeclCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getKeyDeclCS_PropertyIds(), thePivotPackage.getProperty(), null, "propertyIds", null, 0, -1, KeyDeclCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getKeyDeclCS_OwnedOppositePropertyIds(), theBaseCSPackage.getPathNameCS(), null, "ownedOppositePropertyIds", null, 0, -1, KeyDeclCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getKeyDeclCS_ClassId(), thePivotPackage.getClass_(), null, "classId", null, 0, 1, KeyDeclCS.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(modelDeclCSEClass, ModelDeclCS.class, "ModelDeclCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getModelDeclCS_MetamodelIds(), thePivotPackage.getNamespace(), null, "metamodelIds", null, 0, -1, ModelDeclCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(objectTemplateCSEClass, ObjectTemplateCS.class, "ObjectTemplateCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getObjectTemplateCS_OwnedPropertyTemplates(), this.getPropertyTemplateCS(), this.getPropertyTemplateCS_OwningObjectTemplate(), "ownedPropertyTemplates", null, 0, -1, ObjectTemplateCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(paramDeclarationCSEClass, ParamDeclarationCS.class, "ParamDeclarationCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(patternCSEClass, PatternCS.class, "PatternCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPatternCS_OwnedPredicates(), this.getPredicateCS(), null, "ownedPredicates", null, 1, -1, PatternCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(predicateCSEClass, PredicateCS.class, "PredicateCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPredicateCS_OwnedCondition(), theEssentialOCLCSPackage.getExpCS(), null, "ownedCondition", null, 1, 1, PredicateCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(primitiveTypeDomainCSEClass, PrimitiveTypeDomainCS.class, "PrimitiveTypeDomainCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(propertyTemplateCSEClass, PropertyTemplateCS.class, "PropertyTemplateCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPropertyTemplateCS_OwningObjectTemplate(), this.getObjectTemplateCS(), this.getObjectTemplateCS_OwnedPropertyTemplates(), "owningObjectTemplate", null, 0, 1, PropertyTemplateCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPropertyTemplateCS_PropertyId(), thePivotPackage.getProperty(), null, "propertyId", null, 0, 1, PropertyTemplateCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPropertyTemplateCS_OwnedOppositePropertyId(), theBaseCSPackage.getPathNameCS(), null, "ownedOppositePropertyId", null, 0, 1, PropertyTemplateCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPropertyTemplateCS_OwnedExpression(), theEssentialOCLCSPackage.getExpCS(), null, "ownedExpression", null, 0, 1, PropertyTemplateCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(queryCSEClass, QueryCS.class, "QueryCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getQueryCS_OwnedParameters(), this.getParamDeclarationCS(), null, "ownedParameters", null, 0, -1, QueryCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getQueryCS_OwnedExpression(), theEssentialOCLCSPackage.getExpCS(), null, "ownedExpression", null, 0, 1, QueryCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(relationCSEClass, RelationCS.class, "RelationCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRelationCS_IsDefault(), ecorePackage.getEBoolean(), "isDefault", "false", 0, 1, RelationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRelationCS_IsTop(), ecorePackage.getEBoolean(), "isTop", "false", 0, 1, RelationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRelationCS_Overrides(), theQVTrelationPackage.getRelation(), null, "overrides", null, 0, 1, RelationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRelationCS_OwnedVarDeclarations(), this.getVarDeclarationCS(), null, "ownedVarDeclarations", null, 0, -1, RelationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRelationCS_OwnedDomains(), this.getAbstractDomainCS(), null, "ownedDomains", null, 0, -1, RelationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRelationCS_OwnedWhen(), this.getPatternCS(), null, "ownedWhen", null, 0, 1, RelationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRelationCS_OwnedWhere(), this.getPatternCS(), null, "ownedWhere", null, 0, 1, RelationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(templateCSEClass, TemplateCS.class, "TemplateCS", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTemplateCS_OwnedGuardExpression(), theEssentialOCLCSPackage.getExpCS(), null, "ownedGuardExpression", null, 0, 1, TemplateCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(templateVariableCSEClass, TemplateVariableCS.class, "TemplateVariableCS", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTemplateVariableCS_OwnedType(), theBaseCSPackage.getTypedRefCS(), null, "ownedType", null, 0, 1, TemplateVariableCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(topLevelCSEClass, TopLevelCS.class, "TopLevelCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTopLevelCS_OwnedImportClauses(), this.getUnitCS(), null, "ownedImportClauses", null, 0, -1, TopLevelCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTopLevelCS_OwnedTransformations(), this.getTransformationCS(), null, "ownedTransformations", null, 0, -1, TopLevelCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(transformationCSEClass, TransformationCS.class, "TransformationCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTransformationCS_OwnedModelDecls(), this.getModelDeclCS(), null, "ownedModelDecls", null, 0, -1, TransformationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTransformationCS_Extends(), theQVTbasePackage.getTransformation(), null, "extends", null, 0, -1, TransformationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTransformationCS_OwnedKeyDecls(), this.getKeyDeclCS(), null, "ownedKeyDecls", null, 0, -1, TransformationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTransformationCS_OwnedPathName(), theBaseCSPackage.getPathNameCS(), null, "ownedPathName", null, 0, 1, TransformationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTransformationCS_OwnedQueries(), this.getQueryCS(), null, "ownedQueries", null, 0, -1, TransformationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTransformationCS_OwnedRelations(), this.getRelationCS(), null, "ownedRelations", null, 0, -1, TransformationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(unitCSEClass, UnitCS.class, "UnitCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUnitCS_Identifiers(), thePivotPackage.getElement(), null, "identifiers", null, 1, -1, UnitCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(varDeclarationCSEClass, VarDeclarationCS.class, "VarDeclarationCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVarDeclarationCS_OwnedInitExpression(), theEssentialOCLCSPackage.getExpCS(), null, "ownedInitExpression", null, 0, 1, VarDeclarationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVarDeclarationCS_OwnedType(), theBaseCSPackage.getTypedRefCS(), null, "ownedType", null, 0, 1, VarDeclarationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVarDeclarationCS_OwnedVarDeclarationIds(), this.getVarDeclarationIdCS(), null, "ownedVarDeclarationIds", null, 0, -1, VarDeclarationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(varDeclarationIdCSEClass, VarDeclarationIdCS.class, "VarDeclarationIdCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //QVTrelationCSTPackageImpl
