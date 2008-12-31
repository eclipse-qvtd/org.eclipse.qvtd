/**
 * <copyright>
 * 
 * Copyright (c) 2008 E.D.Willink and others.
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
 * $Id: QVTRelationMessages.java,v 1.1 2008/12/31 17:41:29 ewillink Exp $
 */
package org.eclipse.qvt.declarative.ecore.QVTRelation.operations;
import org.eclipse.osgi.util.NLS;

public class QVTRelationMessages extends NLS
{
	public static String _UI_DomainPattern_RootTemplateExpressionIsNotBoundToRootVariable;
	public static String _UI_DomainPattern_RootTemplateExpressionTypeIsNotRootVariableType;
	public static String _UI_DomainPattern_VariableIsNotDefinedByRelation;
	public static String _UI_Key_IdentifiesTypeIsNotDeclaredByTransformation;
	public static String _UI_Key_NoParts;
	public static String _UI_Key_OppositePartDoesNotReferenceIdentifies;
	public static String _UI_Key_PartIsNotDeclaredByIdentifies;
	public static String _UI_OppositePropertyCallExp_PropertyIsNotAReference;
	public static String _UI_OppositePropertyCallExp_PropertyIsNotUnidirectional;
	public static String _UI_OppositePropertyCallExp_TypeIsNotSetOfPropertyTarget;
	public static String _UI_Relation_DomainIsNotARelationDomain;
	public static String _UI_Relation_DomainNumberDoesNotMatch;
	public static String _UI_Relation_LessThanTwoDomains;
	public static String _UI_Relation_VariableNameIsNotUnique;
	public static String _UI_Relation_WhenTypeIsNotDeclaredByRelation;
	public static String _UI_Relation_WhenVariableIsNotDefinedByRelation;
	public static String _UI_Relation_WhereTypeIsNotDeclaredByRelation;
	public static String _UI_Relation_WhereVariableIsNotDefinedByRelation;
	public static String _UI_RelationCallExp_NotInvokedFromWhenOrWhereClause;
	public static String _UI_RelationCallExp_PatternDoesNotExist;
	public static String _UI_RelationCallExp_ReferredRelationArgumentNumberDoesNotMatch;
	public static String _UI_RelationCallExp_ReferredRelationIsNotDeclaredByTransformation;
	public static String _UI_RelationCallExp_RelationDoesNotExist;
	public static String _UI_RelationCallExp_WhenReferredRelationArgumentTypeDoesNotMatch;
	public static String _UI_RelationCallExp_WhereReferredRelationArgumentTypeIsNotMatchableWarning;
	public static String _UI_RelationDomain_BoundVariableFeatureIsNotDefinedByEnforceableDomain;
	public static String _UI_RelationDomain_BoundVariableIsNotDefinedByEnforceableDomain;
	public static String _UI_RelationDomain_RootVariableIsNotDefinedByRelation;
	public static String _UI_RelationDomain_RootVariableTypeIsNotDeclaredByDomainTypedModel;
	public static String _UI_RelationDomainAssignment_VariableIsNotDefinedByRelation;
	public static String _UI_RelationDomainAssignment_VariableTypeMatchesValueType;
	public static String _UI_RelationImplementation_DirectionIsNotDefinedByTransformation;
	public static String _UI_RelationalTransformation_CollectionNameIsNotUnique;
	public static String _UI_RelationalTransformation_ClassifierNameIsSimilar;
	public static String _UI_RelationalTransformation_ClassifierNameIsNotUnique;
	public static String _UI_RelationalTransformation_KeyIsNotUnique;
	public static String _UI_RelationalTransformation_RuleIsNotARelation;

	static {
		NLS.initializeMessages(QVTRelationMessages.class.getName(), QVTRelationMessages.class);
	}
}