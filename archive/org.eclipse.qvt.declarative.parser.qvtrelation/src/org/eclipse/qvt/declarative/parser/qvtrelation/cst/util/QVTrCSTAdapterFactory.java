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
 * $Id: QVTrCSTAdapterFactory.java,v 1.4 2008/10/10 07:59:24 ewillink Exp $
 */
package org.eclipse.qvt.declarative.parser.qvtrelation.cst.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
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
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.QVTrCSTPackage
 * @generated
 */
public class QVTrCSTAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static QVTrCSTPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QVTrCSTAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = QVTrCSTPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected QVTrCSTSwitch<Adapter> modelSwitch =
		new QVTrCSTSwitch<Adapter>() {
			@Override
			public Adapter caseAbstractDomainCS(AbstractDomainCS object) {
				return createAbstractDomainCSAdapter();
			}
			@Override
			public Adapter caseCollectionTemplateCS(CollectionTemplateCS object) {
				return createCollectionTemplateCSAdapter();
			}
			@Override
			public Adapter caseDefaultValueCS(DefaultValueCS object) {
				return createDefaultValueCSAdapter();
			}
			@Override
			public Adapter caseDomainCS(DomainCS object) {
				return createDomainCSAdapter();
			}
			@Override
			public Adapter caseKeyDeclCS(KeyDeclCS object) {
				return createKeyDeclCSAdapter();
			}
			@Override
			public Adapter caseModelDeclCS(ModelDeclCS object) {
				return createModelDeclCSAdapter();
			}
			@Override
			public Adapter caseObjectTemplateCS(ObjectTemplateCS object) {
				return createObjectTemplateCSAdapter();
			}
			@Override
			public Adapter caseParamDeclarationCS(ParamDeclarationCS object) {
				return createParamDeclarationCSAdapter();
			}
			@Override
			public Adapter casePrimitiveTypeDomainCS(PrimitiveTypeDomainCS object) {
				return createPrimitiveTypeDomainCSAdapter();
			}
			@Override
			public Adapter casePropertyTemplateCS(PropertyTemplateCS object) {
				return createPropertyTemplateCSAdapter();
			}
			@Override
			public Adapter caseQueryCS(QueryCS object) {
				return createQueryCSAdapter();
			}
			@Override
			public Adapter caseRelationCS(RelationCS object) {
				return createRelationCSAdapter();
			}
			@Override
			public Adapter caseTemplateCS(TemplateCS object) {
				return createTemplateCSAdapter();
			}
			@Override
			public Adapter caseTemplateVariableCS(TemplateVariableCS object) {
				return createTemplateVariableCSAdapter();
			}
			@Override
			public Adapter caseTopLevelCS(TopLevelCS object) {
				return createTopLevelCSAdapter();
			}
			@Override
			public Adapter caseTransformationCS(TransformationCS object) {
				return createTransformationCSAdapter();
			}
			@Override
			public Adapter caseUnitCS(UnitCS object) {
				return createUnitCSAdapter();
			}
			@Override
			public Adapter caseVarDeclarationCS(VarDeclarationCS object) {
				return createVarDeclarationCSAdapter();
			}
			@Override
			public Adapter caseWhenCS(WhenCS object) {
				return createWhenCSAdapter();
			}
			@Override
			public Adapter caseWhereCS(WhereCS object) {
				return createWhereCSAdapter();
			}
			@Override
			public Adapter caseCSTNode(CSTNode object) {
				return createCSTNodeAdapter();
			}
			@Override
			public Adapter caseIHasName(IHasName object) {
				return createIHasNameAdapter();
			}
			@Override
			public Adapter caseIdentifiedCS(IdentifiedCS object) {
				return createIdentifiedCSAdapter();
			}
			@Override
			public Adapter caseOCLExpressionCS(OCLExpressionCS object) {
				return createOCLExpressionCSAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.TopLevelCS <em>Top Level CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.TopLevelCS
	 * @generated
	 */
	public Adapter createTopLevelCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.TransformationCS <em>Transformation CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.TransformationCS
	 * @generated
	 */
	public Adapter createTransformationCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.ModelDeclCS <em>Model Decl CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.ModelDeclCS
	 * @generated
	 */
	public Adapter createModelDeclCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.KeyDeclCS <em>Key Decl CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.KeyDeclCS
	 * @generated
	 */
	public Adapter createKeyDeclCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.RelationCS <em>Relation CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.RelationCS
	 * @generated
	 */
	public Adapter createRelationCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.QueryCS <em>Query CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.QueryCS
	 * @generated
	 */
	public Adapter createQueryCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.DomainCS <em>Domain CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.DomainCS
	 * @generated
	 */
	public Adapter createDomainCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.UnitCS <em>Unit CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.UnitCS
	 * @generated
	 */
	public Adapter createUnitCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.PrimitiveTypeDomainCS <em>Primitive Type Domain CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.PrimitiveTypeDomainCS
	 * @generated
	 */
	public Adapter createPrimitiveTypeDomainCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.VarDeclarationCS <em>Var Declaration CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.VarDeclarationCS
	 * @generated
	 */
	public Adapter createVarDeclarationCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.WhenCS <em>When CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.WhenCS
	 * @generated
	 */
	public Adapter createWhenCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.WhereCS <em>Where CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.WhereCS
	 * @generated
	 */
	public Adapter createWhereCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvt.declarative.parser.environment.IHasName <em>IHas Name</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvt.declarative.parser.environment.IHasName
	 * @generated
	 */
	public Adapter createIHasNameAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvt.declarative.parser.qvt.cst.IdentifiedCS <em>Identified CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvt.declarative.parser.qvt.cst.IdentifiedCS
	 * @generated
	 */
	public Adapter createIdentifiedCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.DefaultValueCS <em>Default Value CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.DefaultValueCS
	 * @generated
	 */
	public Adapter createDefaultValueCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.AbstractDomainCS <em>Abstract Domain CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.AbstractDomainCS
	 * @generated
	 */
	public Adapter createAbstractDomainCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.TemplateVariableCS <em>Template Variable CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.TemplateVariableCS
	 * @generated
	 */
	public Adapter createTemplateVariableCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.PropertyTemplateCS <em>Property Template CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.PropertyTemplateCS
	 * @generated
	 */
	public Adapter createPropertyTemplateCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.TemplateCS <em>Template CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.TemplateCS
	 * @generated
	 */
	public Adapter createTemplateCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.ObjectTemplateCS <em>Object Template CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.ObjectTemplateCS
	 * @generated
	 */
	public Adapter createObjectTemplateCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.CollectionTemplateCS <em>Collection Template CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.CollectionTemplateCS
	 * @generated
	 */
	public Adapter createCollectionTemplateCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.ParamDeclarationCS <em>Param Declaration CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.ParamDeclarationCS
	 * @generated
	 */
	public Adapter createParamDeclarationCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.cst.CSTNode <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.cst.CSTNode
	 * @generated
	 */
	public Adapter createCSTNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.ocl.cst.OCLExpressionCS <em>OCL Expression CS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.ocl.cst.OCLExpressionCS
	 * @generated
	 */
	public Adapter createOCLExpressionCSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //EqvtrCSTAdapterFactory
