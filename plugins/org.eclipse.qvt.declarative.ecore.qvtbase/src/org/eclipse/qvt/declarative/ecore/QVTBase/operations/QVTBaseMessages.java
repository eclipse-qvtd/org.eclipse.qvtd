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
 * $Id: QVTBaseMessages.java,v 1.3 2009/01/27 21:17:57 ewillink Exp $
 */
package org.eclipse.qvt.declarative.ecore.QVTBase.operations;
import org.eclipse.osgi.util.NLS;

public class QVTBaseMessages extends NLS
{
	public static String _UI_Domain_IsNotCheckableOrEnforceable;
	public static String _UI_Domain_TypedModelDoesNotExistWarning;
	public static String _UI_Domain_TypedModelIsNotDefinedByTransformation;
	public static String _UI_Function_MayHaveASideEffect;
	public static String _UI_Function_ParameterIsNotAFunctionParameter;
	public static String _UI_Pattern_VariableIsNotAFunctionParameter;
	public static String _UI_Predicate_ConditionExpressionIsNotBoolean;
	public static String _UI_Predicate_ExternalVariableIsNotBoundByPattern;
	public static String _UI_Predicate_LocalVariableIsBoundByPattern;
	public static String _UI_Rule_DomainNameIsNotUnique;
	public static String _UI_Rule_DomainTypedModelIsNotUnique;
	public static String _UI_Rule_OverridenDomainDoesNotExist;
	public static String _UI_Rule_OverridenDomainPackagesAreNotCompatible;
	public static String _UI_Rule_OverridesIsNotDefinedByTransformation;
	public static String _UI_Transformation_ModelParameterUsedPackagesAreNotCompatibleWithExtension;
	public static String _UI_Transformation_ExtendsContainsACycle;
	public static String _UI_Transformation_UsedPackagesAreNotCompatibleWithExtends;
	public static String _UI_Transformation_ModelParameterNameIsNotCompatibleWithExtension;
	public static String _UI_Transformation_ModelParameterNameIsNotUnique;
	public static String _UI_Transformation_RuleNameIsNotUnique;	
	public static String _UI_Transformation_SynthesizedTypeIsNotOwned;
	public static String _UI_Transformation_SynthesizedTypeIsNotUnique;
	public static String _UI_TypedModel_DependsOnContainsACycle;
	public static String _UI_TypedModel_DependsOnIsNotAModelParameter;

	static {
		NLS.initializeMessages(QVTBaseMessages.class.getName(), QVTBaseMessages.class);
	}
}