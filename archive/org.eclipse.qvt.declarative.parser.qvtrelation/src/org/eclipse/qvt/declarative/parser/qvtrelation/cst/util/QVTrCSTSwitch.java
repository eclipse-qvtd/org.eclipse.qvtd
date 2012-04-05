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
 * $Id: QVTrCSTSwitch.java,v 1.4 2008/10/10 07:59:24 ewillink Exp $
 */
package org.eclipse.qvt.declarative.parser.qvtrelation.cst.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.cst.OCLExpressionCS;
import org.eclipse.qvt.declarative.parser.environment.IHasName;
import org.eclipse.qvt.declarative.parser.qvt.cst.IdentifiedCS;
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
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.QVTrCSTPackage
 * @generated
 */
public class QVTrCSTSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static QVTrCSTPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QVTrCSTSwitch() {
		if (modelPackage == null) {
			modelPackage = QVTrCSTPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public T doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List<EClass> eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch(eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case QVTrCSTPackage.ABSTRACT_DOMAIN_CS: {
				AbstractDomainCS abstractDomainCS = (AbstractDomainCS)theEObject;
				T result = caseAbstractDomainCS(abstractDomainCS);
				if (result == null) result = caseCSTNode(abstractDomainCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTrCSTPackage.COLLECTION_TEMPLATE_CS: {
				CollectionTemplateCS collectionTemplateCS = (CollectionTemplateCS)theEObject;
				T result = caseCollectionTemplateCS(collectionTemplateCS);
				if (result == null) result = caseTemplateCS(collectionTemplateCS);
				if (result == null) result = caseTemplateVariableCS(collectionTemplateCS);
				if (result == null) result = caseOCLExpressionCS(collectionTemplateCS);
				if (result == null) result = caseIdentifiedCS(collectionTemplateCS);
				if (result == null) result = caseCSTNode(collectionTemplateCS);
				if (result == null) result = caseIHasName(collectionTemplateCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTrCSTPackage.DEFAULT_VALUE_CS: {
				DefaultValueCS defaultValueCS = (DefaultValueCS)theEObject;
				T result = caseDefaultValueCS(defaultValueCS);
				if (result == null) result = caseCSTNode(defaultValueCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTrCSTPackage.DOMAIN_CS: {
				DomainCS domainCS = (DomainCS)theEObject;
				T result = caseDomainCS(domainCS);
				if (result == null) result = caseAbstractDomainCS(domainCS);
				if (result == null) result = caseCSTNode(domainCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTrCSTPackage.KEY_DECL_CS: {
				KeyDeclCS keyDeclCS = (KeyDeclCS)theEObject;
				T result = caseKeyDeclCS(keyDeclCS);
				if (result == null) result = caseCSTNode(keyDeclCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTrCSTPackage.MODEL_DECL_CS: {
				ModelDeclCS modelDeclCS = (ModelDeclCS)theEObject;
				T result = caseModelDeclCS(modelDeclCS);
				if (result == null) result = caseCSTNode(modelDeclCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTrCSTPackage.OBJECT_TEMPLATE_CS: {
				ObjectTemplateCS objectTemplateCS = (ObjectTemplateCS)theEObject;
				T result = caseObjectTemplateCS(objectTemplateCS);
				if (result == null) result = caseTemplateCS(objectTemplateCS);
				if (result == null) result = caseTemplateVariableCS(objectTemplateCS);
				if (result == null) result = caseOCLExpressionCS(objectTemplateCS);
				if (result == null) result = caseIdentifiedCS(objectTemplateCS);
				if (result == null) result = caseCSTNode(objectTemplateCS);
				if (result == null) result = caseIHasName(objectTemplateCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTrCSTPackage.PARAM_DECLARATION_CS: {
				ParamDeclarationCS paramDeclarationCS = (ParamDeclarationCS)theEObject;
				T result = caseParamDeclarationCS(paramDeclarationCS);
				if (result == null) result = caseCSTNode(paramDeclarationCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTrCSTPackage.PRIMITIVE_TYPE_DOMAIN_CS: {
				PrimitiveTypeDomainCS primitiveTypeDomainCS = (PrimitiveTypeDomainCS)theEObject;
				T result = casePrimitiveTypeDomainCS(primitiveTypeDomainCS);
				if (result == null) result = caseTemplateVariableCS(primitiveTypeDomainCS);
				if (result == null) result = caseAbstractDomainCS(primitiveTypeDomainCS);
				if (result == null) result = caseIdentifiedCS(primitiveTypeDomainCS);
				if (result == null) result = caseCSTNode(primitiveTypeDomainCS);
				if (result == null) result = caseIHasName(primitiveTypeDomainCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTrCSTPackage.PROPERTY_TEMPLATE_CS: {
				PropertyTemplateCS propertyTemplateCS = (PropertyTemplateCS)theEObject;
				T result = casePropertyTemplateCS(propertyTemplateCS);
				if (result == null) result = caseCSTNode(propertyTemplateCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTrCSTPackage.QUERY_CS: {
				QueryCS queryCS = (QueryCS)theEObject;
				T result = caseQueryCS(queryCS);
				if (result == null) result = caseCSTNode(queryCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTrCSTPackage.RELATION_CS: {
				RelationCS relationCS = (RelationCS)theEObject;
				T result = caseRelationCS(relationCS);
				if (result == null) result = caseCSTNode(relationCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTrCSTPackage.TEMPLATE_CS: {
				TemplateCS templateCS = (TemplateCS)theEObject;
				T result = caseTemplateCS(templateCS);
				if (result == null) result = caseTemplateVariableCS(templateCS);
				if (result == null) result = caseOCLExpressionCS(templateCS);
				if (result == null) result = caseIdentifiedCS(templateCS);
				if (result == null) result = caseCSTNode(templateCS);
				if (result == null) result = caseIHasName(templateCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTrCSTPackage.TEMPLATE_VARIABLE_CS: {
				TemplateVariableCS templateVariableCS = (TemplateVariableCS)theEObject;
				T result = caseTemplateVariableCS(templateVariableCS);
				if (result == null) result = caseIdentifiedCS(templateVariableCS);
				if (result == null) result = caseCSTNode(templateVariableCS);
				if (result == null) result = caseIHasName(templateVariableCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTrCSTPackage.TOP_LEVEL_CS: {
				TopLevelCS topLevelCS = (TopLevelCS)theEObject;
				T result = caseTopLevelCS(topLevelCS);
				if (result == null) result = caseCSTNode(topLevelCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTrCSTPackage.TRANSFORMATION_CS: {
				TransformationCS transformationCS = (TransformationCS)theEObject;
				T result = caseTransformationCS(transformationCS);
				if (result == null) result = caseCSTNode(transformationCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTrCSTPackage.UNIT_CS: {
				UnitCS unitCS = (UnitCS)theEObject;
				T result = caseUnitCS(unitCS);
				if (result == null) result = caseCSTNode(unitCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTrCSTPackage.VAR_DECLARATION_CS: {
				VarDeclarationCS varDeclarationCS = (VarDeclarationCS)theEObject;
				T result = caseVarDeclarationCS(varDeclarationCS);
				if (result == null) result = caseCSTNode(varDeclarationCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTrCSTPackage.WHEN_CS: {
				WhenCS whenCS = (WhenCS)theEObject;
				T result = caseWhenCS(whenCS);
				if (result == null) result = caseCSTNode(whenCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QVTrCSTPackage.WHERE_CS: {
				WhereCS whereCS = (WhereCS)theEObject;
				T result = caseWhereCS(whereCS);
				if (result == null) result = caseCSTNode(whereCS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
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
	 * Returns the result of interpreting the object as an instance of '<em>When CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>When CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseWhenCS(WhenCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Where CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Where CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseWhereCS(WhereCS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IHas Name</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IHas Name</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIHasName(IHasName object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Identified CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Identified CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIdentifiedCS(IdentifiedCS object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCSTNode(CSTNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>OCL Expression CS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>OCL Expression CS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOCLExpressionCS(OCLExpressionCS object) {
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
	public T defaultCase(EObject object) {
		return null;
	}

} //EqvtrCSTSwitch
