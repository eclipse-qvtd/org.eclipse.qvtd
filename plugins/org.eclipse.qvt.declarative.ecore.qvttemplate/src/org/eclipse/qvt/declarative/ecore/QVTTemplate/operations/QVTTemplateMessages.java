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
 * $Id: QVTTemplateMessages.java,v 1.1 2008/12/31 17:41:31 ewillink Exp $
 */
package org.eclipse.qvt.declarative.ecore.QVTTemplate.operations;
import org.eclipse.osgi.util.NLS;

public class QVTTemplateMessages extends NLS
{
	public static String _UI_CollectionTemplateExp_EnforceableMemberIsNotEnforced;
	public static String _UI_CollectionTemplateExp_MemberTypeDoesNotMatchElementType;
	public static String _UI_CollectionTemplateExp_RestTypeDoesNotMatchCollectionType;
	public static String _UI_CollectionTemplateExp_RestVariableIsNotBoundByPattern;
	public static String _UI_CollectionTemplateExp_TypeIsNotDeclaredByDomain;
	public static String _UI_ObjectTemplateExp_EnforceablePartIsNotEnforced;
	public static String _UI_ObjectTemplateExp_PartIsNotUnique;
	public static String _UI_ObjectTemplateExp_ReferredClassIsNotDeclaredByDomain;
	public static String _UI_PropertyTemplateItem_NonBagDDoesNotMatchNonBag;
	public static String _UI_PropertyTemplateItem_ReferredPropertyIsNotDefinedByReferredClass;
	public static String _UI_PropertyTemplateItem_SetDoesNotMatchSet;
	public static String _UI_PropertyTemplateItem_SimpleVariableIsNotBoundByPattern;
	public static String _UI_PropertyTemplateItem_ValueElementTypeDoesNotMatchReferredPropertyElementType;
	public static String _UI_TemplateExp_DomainDoesNotExist;
	public static String _UI_TemplateExp_PatternDoesNotExist;
	public static String _UI_TemplateExp_VariableIsNotBoundByPattern;
	public static String _UI_TemplateExp_VariableTypeIsNotDeclaredByDomain;
	public static String _UI_TemplateExp_WhereIsNotBoolean;

	static {
		NLS.initializeMessages(QVTTemplateMessages.class.getName(), QVTTemplateMessages.class);
	}
}