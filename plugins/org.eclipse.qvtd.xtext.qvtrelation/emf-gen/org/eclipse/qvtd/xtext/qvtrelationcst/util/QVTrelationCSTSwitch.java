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
package org.eclipse.qvtd.xtext.qvtrelationcst.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import org.eclipse.ocl.examples.domain.elements.Nameable;
import org.eclipse.ocl.examples.pivot.util.Pivotable;
import org.eclipse.ocl.examples.xtext.base.baseCST.ElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ModelElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.NamedElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.NamespaceCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.PackageCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.PivotableElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.RootCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.RootPackageCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypedElementCS;
import org.eclipse.ocl.examples.xtext.base.util.VisitableCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ExpCS;
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
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipse.qvtd.xtext.qvtrelationcst.QVTrelationCSTPackage
 * @generated
 */
public class QVTrelationCSTSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static QVTrelationCSTPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QVTrelationCSTSwitch() {
		if (modelPackage == null) {
			modelPackage = QVTrelationCSTPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case QVTrelationCSTPackage.ABSTRACT_DOMAIN_CS: {
				AbstractDomainCS abstractDomainCS = (AbstractDomainCS)theEObject;
				T result = caseAbstractDomainCS(abstractDomainCS);
				if (result == null) result = caseModelElementCS(abstractDomainCS);
				if (result == null) result = caseNameable(abstractDomainCS);
				if (result == null) result = casePivotableElementCS(abstractDomainCS);
				if (result == null) result = caseElementCS(abstractDomainCS);
				if (result == null) result = casePivotable(abstractDomainCS);
				if (result == null) result = caseVisitableCS(abstractDomainCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTrelationCSTPackage.COLLECTION_TEMPLATE_CS: {
				CollectionTemplateCS collectionTemplateCS = (CollectionTemplateCS)theEObject;
				T result = caseCollectionTemplateCS(collectionTemplateCS);
				if (result == null) result = caseTemplateCS(collectionTemplateCS);
				if (result == null) result = caseTemplateVariableCS(collectionTemplateCS);
				if (result == null) result = caseExpCS(collectionTemplateCS);
				if (result == null) result = caseNamedElementCS(collectionTemplateCS);
				if (result == null) result = caseModelElementCS(collectionTemplateCS);
				if (result == null) result = caseNameable(collectionTemplateCS);
				if (result == null) result = casePivotableElementCS(collectionTemplateCS);
				if (result == null) result = caseElementCS(collectionTemplateCS);
				if (result == null) result = casePivotable(collectionTemplateCS);
				if (result == null) result = caseVisitableCS(collectionTemplateCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTrelationCSTPackage.DEFAULT_VALUE_CS: {
				DefaultValueCS defaultValueCS = (DefaultValueCS)theEObject;
				T result = caseDefaultValueCS(defaultValueCS);
				if (result == null) result = caseModelElementCS(defaultValueCS);
				if (result == null) result = casePivotableElementCS(defaultValueCS);
				if (result == null) result = caseElementCS(defaultValueCS);
				if (result == null) result = casePivotable(defaultValueCS);
				if (result == null) result = caseVisitableCS(defaultValueCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTrelationCSTPackage.DOMAIN_CS: {
				DomainCS domainCS = (DomainCS)theEObject;
				T result = caseDomainCS(domainCS);
				if (result == null) result = caseAbstractDomainCS(domainCS);
				if (result == null) result = caseModelElementCS(domainCS);
				if (result == null) result = caseNameable(domainCS);
				if (result == null) result = casePivotableElementCS(domainCS);
				if (result == null) result = caseElementCS(domainCS);
				if (result == null) result = casePivotable(domainCS);
				if (result == null) result = caseVisitableCS(domainCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTrelationCSTPackage.DOMAIN_PATTERN_CS: {
				DomainPatternCS domainPatternCS = (DomainPatternCS)theEObject;
				T result = caseDomainPatternCS(domainPatternCS);
				if (result == null) result = caseModelElementCS(domainPatternCS);
				if (result == null) result = casePivotableElementCS(domainPatternCS);
				if (result == null) result = caseElementCS(domainPatternCS);
				if (result == null) result = casePivotable(domainPatternCS);
				if (result == null) result = caseVisitableCS(domainPatternCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTrelationCSTPackage.ELEMENT_TEMPLATE_CS: {
				ElementTemplateCS elementTemplateCS = (ElementTemplateCS)theEObject;
				T result = caseElementTemplateCS(elementTemplateCS);
				if (result == null) result = caseTemplateVariableCS(elementTemplateCS);
				if (result == null) result = caseNamedElementCS(elementTemplateCS);
				if (result == null) result = caseModelElementCS(elementTemplateCS);
				if (result == null) result = caseNameable(elementTemplateCS);
				if (result == null) result = casePivotableElementCS(elementTemplateCS);
				if (result == null) result = caseElementCS(elementTemplateCS);
				if (result == null) result = casePivotable(elementTemplateCS);
				if (result == null) result = caseVisitableCS(elementTemplateCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTrelationCSTPackage.KEY_DECL_CS: {
				KeyDeclCS keyDeclCS = (KeyDeclCS)theEObject;
				T result = caseKeyDeclCS(keyDeclCS);
				if (result == null) result = caseModelElementCS(keyDeclCS);
				if (result == null) result = casePivotableElementCS(keyDeclCS);
				if (result == null) result = caseElementCS(keyDeclCS);
				if (result == null) result = casePivotable(keyDeclCS);
				if (result == null) result = caseVisitableCS(keyDeclCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTrelationCSTPackage.MODEL_DECL_CS: {
				ModelDeclCS modelDeclCS = (ModelDeclCS)theEObject;
				T result = caseModelDeclCS(modelDeclCS);
				if (result == null) result = caseNamedElementCS(modelDeclCS);
				if (result == null) result = caseModelElementCS(modelDeclCS);
				if (result == null) result = caseNameable(modelDeclCS);
				if (result == null) result = casePivotableElementCS(modelDeclCS);
				if (result == null) result = caseElementCS(modelDeclCS);
				if (result == null) result = casePivotable(modelDeclCS);
				if (result == null) result = caseVisitableCS(modelDeclCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTrelationCSTPackage.OBJECT_TEMPLATE_CS: {
				ObjectTemplateCS objectTemplateCS = (ObjectTemplateCS)theEObject;
				T result = caseObjectTemplateCS(objectTemplateCS);
				if (result == null) result = caseTemplateCS(objectTemplateCS);
				if (result == null) result = caseTemplateVariableCS(objectTemplateCS);
				if (result == null) result = caseExpCS(objectTemplateCS);
				if (result == null) result = caseNamedElementCS(objectTemplateCS);
				if (result == null) result = caseModelElementCS(objectTemplateCS);
				if (result == null) result = caseNameable(objectTemplateCS);
				if (result == null) result = casePivotableElementCS(objectTemplateCS);
				if (result == null) result = caseElementCS(objectTemplateCS);
				if (result == null) result = casePivotable(objectTemplateCS);
				if (result == null) result = caseVisitableCS(objectTemplateCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTrelationCSTPackage.PARAM_DECLARATION_CS: {
				ParamDeclarationCS paramDeclarationCS = (ParamDeclarationCS)theEObject;
				T result = caseParamDeclarationCS(paramDeclarationCS);
				if (result == null) result = caseTypedElementCS(paramDeclarationCS);
				if (result == null) result = caseNamedElementCS(paramDeclarationCS);
				if (result == null) result = caseModelElementCS(paramDeclarationCS);
				if (result == null) result = caseNameable(paramDeclarationCS);
				if (result == null) result = casePivotableElementCS(paramDeclarationCS);
				if (result == null) result = caseElementCS(paramDeclarationCS);
				if (result == null) result = casePivotable(paramDeclarationCS);
				if (result == null) result = caseVisitableCS(paramDeclarationCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTrelationCSTPackage.PATTERN_CS: {
				PatternCS patternCS = (PatternCS)theEObject;
				T result = casePatternCS(patternCS);
				if (result == null) result = caseModelElementCS(patternCS);
				if (result == null) result = casePivotableElementCS(patternCS);
				if (result == null) result = caseElementCS(patternCS);
				if (result == null) result = casePivotable(patternCS);
				if (result == null) result = caseVisitableCS(patternCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTrelationCSTPackage.PREDICATE_CS: {
				PredicateCS predicateCS = (PredicateCS)theEObject;
				T result = casePredicateCS(predicateCS);
				if (result == null) result = caseModelElementCS(predicateCS);
				if (result == null) result = casePivotableElementCS(predicateCS);
				if (result == null) result = caseElementCS(predicateCS);
				if (result == null) result = casePivotable(predicateCS);
				if (result == null) result = caseVisitableCS(predicateCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTrelationCSTPackage.PRIMITIVE_TYPE_DOMAIN_CS: {
				PrimitiveTypeDomainCS primitiveTypeDomainCS = (PrimitiveTypeDomainCS)theEObject;
				T result = casePrimitiveTypeDomainCS(primitiveTypeDomainCS);
				if (result == null) result = caseTemplateVariableCS(primitiveTypeDomainCS);
				if (result == null) result = caseAbstractDomainCS(primitiveTypeDomainCS);
				if (result == null) result = caseNamedElementCS(primitiveTypeDomainCS);
				if (result == null) result = caseModelElementCS(primitiveTypeDomainCS);
				if (result == null) result = caseNameable(primitiveTypeDomainCS);
				if (result == null) result = casePivotableElementCS(primitiveTypeDomainCS);
				if (result == null) result = caseElementCS(primitiveTypeDomainCS);
				if (result == null) result = casePivotable(primitiveTypeDomainCS);
				if (result == null) result = caseVisitableCS(primitiveTypeDomainCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTrelationCSTPackage.PROPERTY_TEMPLATE_CS: {
				PropertyTemplateCS propertyTemplateCS = (PropertyTemplateCS)theEObject;
				T result = casePropertyTemplateCS(propertyTemplateCS);
				if (result == null) result = caseModelElementCS(propertyTemplateCS);
				if (result == null) result = casePivotableElementCS(propertyTemplateCS);
				if (result == null) result = caseElementCS(propertyTemplateCS);
				if (result == null) result = casePivotable(propertyTemplateCS);
				if (result == null) result = caseVisitableCS(propertyTemplateCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTrelationCSTPackage.QUERY_CS: {
				QueryCS queryCS = (QueryCS)theEObject;
				T result = caseQueryCS(queryCS);
				if (result == null) result = caseTypedElementCS(queryCS);
				if (result == null) result = caseNamedElementCS(queryCS);
				if (result == null) result = caseModelElementCS(queryCS);
				if (result == null) result = caseNameable(queryCS);
				if (result == null) result = casePivotableElementCS(queryCS);
				if (result == null) result = caseElementCS(queryCS);
				if (result == null) result = casePivotable(queryCS);
				if (result == null) result = caseVisitableCS(queryCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTrelationCSTPackage.RELATION_CS: {
				RelationCS relationCS = (RelationCS)theEObject;
				T result = caseRelationCS(relationCS);
				if (result == null) result = caseNamedElementCS(relationCS);
				if (result == null) result = caseModelElementCS(relationCS);
				if (result == null) result = caseNameable(relationCS);
				if (result == null) result = casePivotableElementCS(relationCS);
				if (result == null) result = caseElementCS(relationCS);
				if (result == null) result = casePivotable(relationCS);
				if (result == null) result = caseVisitableCS(relationCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTrelationCSTPackage.TEMPLATE_CS: {
				TemplateCS templateCS = (TemplateCS)theEObject;
				T result = caseTemplateCS(templateCS);
				if (result == null) result = caseTemplateVariableCS(templateCS);
				if (result == null) result = caseExpCS(templateCS);
				if (result == null) result = caseNamedElementCS(templateCS);
				if (result == null) result = caseModelElementCS(templateCS);
				if (result == null) result = caseNameable(templateCS);
				if (result == null) result = casePivotableElementCS(templateCS);
				if (result == null) result = caseElementCS(templateCS);
				if (result == null) result = casePivotable(templateCS);
				if (result == null) result = caseVisitableCS(templateCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTrelationCSTPackage.TEMPLATE_VARIABLE_CS: {
				TemplateVariableCS templateVariableCS = (TemplateVariableCS)theEObject;
				T result = caseTemplateVariableCS(templateVariableCS);
				if (result == null) result = caseNamedElementCS(templateVariableCS);
				if (result == null) result = caseModelElementCS(templateVariableCS);
				if (result == null) result = caseNameable(templateVariableCS);
				if (result == null) result = casePivotableElementCS(templateVariableCS);
				if (result == null) result = caseElementCS(templateVariableCS);
				if (result == null) result = casePivotable(templateVariableCS);
				if (result == null) result = caseVisitableCS(templateVariableCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTrelationCSTPackage.TOP_LEVEL_CS: {
				TopLevelCS topLevelCS = (TopLevelCS)theEObject;
				T result = caseTopLevelCS(topLevelCS);
				if (result == null) result = caseRootPackageCS(topLevelCS);
				if (result == null) result = casePackageCS(topLevelCS);
				if (result == null) result = caseRootCS(topLevelCS);
				if (result == null) result = caseNamespaceCS(topLevelCS);
				if (result == null) result = caseNamedElementCS(topLevelCS);
				if (result == null) result = caseModelElementCS(topLevelCS);
				if (result == null) result = caseNameable(topLevelCS);
				if (result == null) result = casePivotableElementCS(topLevelCS);
				if (result == null) result = caseElementCS(topLevelCS);
				if (result == null) result = casePivotable(topLevelCS);
				if (result == null) result = caseVisitableCS(topLevelCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTrelationCSTPackage.TRANSFORMATION_CS: {
				TransformationCS transformationCS = (TransformationCS)theEObject;
				T result = caseTransformationCS(transformationCS);
				if (result == null) result = casePackageCS(transformationCS);
				if (result == null) result = caseNamespaceCS(transformationCS);
				if (result == null) result = caseNamedElementCS(transformationCS);
				if (result == null) result = caseModelElementCS(transformationCS);
				if (result == null) result = caseNameable(transformationCS);
				if (result == null) result = casePivotableElementCS(transformationCS);
				if (result == null) result = caseElementCS(transformationCS);
				if (result == null) result = casePivotable(transformationCS);
				if (result == null) result = caseVisitableCS(transformationCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTrelationCSTPackage.UNIT_CS: {
				UnitCS unitCS = (UnitCS)theEObject;
				T result = caseUnitCS(unitCS);
				if (result == null) result = caseModelElementCS(unitCS);
				if (result == null) result = casePivotableElementCS(unitCS);
				if (result == null) result = caseElementCS(unitCS);
				if (result == null) result = casePivotable(unitCS);
				if (result == null) result = caseVisitableCS(unitCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTrelationCSTPackage.VAR_DECLARATION_CS: {
				VarDeclarationCS varDeclarationCS = (VarDeclarationCS)theEObject;
				T result = caseVarDeclarationCS(varDeclarationCS);
				if (result == null) result = caseModelElementCS(varDeclarationCS);
				if (result == null) result = casePivotableElementCS(varDeclarationCS);
				if (result == null) result = caseElementCS(varDeclarationCS);
				if (result == null) result = casePivotable(varDeclarationCS);
				if (result == null) result = caseVisitableCS(varDeclarationCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTrelationCSTPackage.VAR_DECLARATION_ID_CS: {
				VarDeclarationIdCS varDeclarationIdCS = (VarDeclarationIdCS)theEObject;
				T result = caseVarDeclarationIdCS(varDeclarationIdCS);
				if (result == null) result = caseNamedElementCS(varDeclarationIdCS);
				if (result == null) result = caseModelElementCS(varDeclarationIdCS);
				if (result == null) result = caseNameable(varDeclarationIdCS);
				if (result == null) result = casePivotableElementCS(varDeclarationIdCS);
				if (result == null) result = caseElementCS(varDeclarationIdCS);
				if (result == null) result = casePivotable(varDeclarationIdCS);
				if (result == null) result = caseVisitableCS(varDeclarationIdCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Domain CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Domain CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractDomainCS(AbstractDomainCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Collection Template CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Collection Template CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCollectionTemplateCS(CollectionTemplateCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Default Value CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Default Value CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDefaultValueCS(DefaultValueCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Domain CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Domain CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDomainCS(DomainCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Domain Pattern CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Domain Pattern CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDomainPatternCS(DomainPatternCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Element Template CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Element Template CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseElementTemplateCS(ElementTemplateCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Key Decl CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Key Decl CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseKeyDeclCS(KeyDeclCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model Decl CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model Decl CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModelDeclCS(ModelDeclCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Object Template CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Object Template CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseObjectTemplateCS(ObjectTemplateCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Param Declaration CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Param Declaration CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseParamDeclarationCS(ParamDeclarationCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Pattern CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Pattern CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePatternCS(PatternCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Predicate CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Predicate CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePredicateCS(PredicateCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Primitive Type Domain CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Primitive Type Domain CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePrimitiveTypeDomainCS(PrimitiveTypeDomainCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Property Template CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Property Template CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePropertyTemplateCS(PropertyTemplateCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Query CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Query CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseQueryCS(QueryCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Relation CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Relation CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRelationCS(RelationCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Template CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Template CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTemplateCS(TemplateCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Template Variable CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Template Variable CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTemplateVariableCS(TemplateVariableCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Top Level CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Top Level CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTopLevelCS(TopLevelCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Transformation CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Transformation CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTransformationCS(TransformationCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unit CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unit CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUnitCS(UnitCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Var Declaration CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Var Declaration CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVarDeclarationCS(VarDeclarationCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Var Declaration Id CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Var Declaration Id CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVarDeclarationIdCS(VarDeclarationIdCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Visitable CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Visitable CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVisitableCS(VisitableCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Element CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Element CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseElementCS(ElementCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Pivotable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Pivotable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePivotable(Pivotable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Pivotable Element CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Pivotable Element CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePivotableElementCS(PivotableElementCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model Element CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model Element CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModelElementCS(ModelElementCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Nameable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Nameable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNameable(Nameable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Exp CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Exp CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExpCS(ExpCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Named Element CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Named Element CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNamedElementCS(NamedElementCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Typed Element CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Typed Element CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTypedElementCS(TypedElementCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Namespace CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Namespace CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNamespaceCS(NamespaceCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Package CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Package CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePackageCS(PackageCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Root CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Root CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRootCS(RootCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Root Package CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Root Package CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRootPackageCS(RootPackageCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //QVTrelationCSTSwitch
