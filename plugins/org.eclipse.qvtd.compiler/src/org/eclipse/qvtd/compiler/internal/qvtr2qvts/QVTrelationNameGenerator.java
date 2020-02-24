/*******************************************************************************
 * Copyright (c) 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvtr2qvts;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.qvtd.compiler.internal.common.TypedModelsConfiguration;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.trace.NameGenerator;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationDomain;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrelationUtil;

/**
 * NameGenerator localizes the name generation functionality to facilitate a chnage / rewrite.
 */
public class QVTrelationNameGenerator extends NameGenerator
{
	public static final @NonNull String DISPATCHCLASS_RESULT_PROPERTY_NAME = "result";
	public static final @NonNull String DISPATCHCLASS_SELF_NAME = "dispatcher";
	public static final @NonNull String INVOCATION_GUARD_NAME = "invocationGuard";
	public static final @NonNull String IDENTIFIED_INSTANCE_VARIABLE_NAME = "identifiedInstance";
	public static final @NonNull String KEYED_INSTANCE_PROPERTY_NAME = "instance";
	public static final @NonNull String KEY2INSTANCE_VARIABLE_NAME = "key2instance";
	//	@SuppressWarnings("null")
	//	public static final @NonNull String TRACE_DISPATCH_SUCCESS_PROPERTY_NAME = QVTtracePackage.Literals.DISPATCH__SUCCESS.getName();
	public static final @NonNull String TRACE_GLOBAL_SUCCESS_PROPERTY_NAME_SUFFIX = "global";
	public static final @NonNull String TRACE_LOCAL_SUCCESS_PROPERTY_NAME_SUFFIX = "local";
	public static final @NonNull String TRACECLASS_PROPERTY_NAME = "trace";

	public static final @NonNull String TRACE_DISPATCH_CLASS_NAME_PREFIX = "D";
	public static final @NonNull String TRACE_INVOCATION_CLASS_NAME_PREFIX = "C";
	public static final @NonNull String TRACE_INTERFACE_CLASS_NAME_PREFIX = "I";
	public static final @NonNull String TRACE_TRACE_CLASS_NAME_PREFIX = "T";
	public static final @NonNull String TRACE_WRAPPER_CLASS_NAME_PREFIX = "W";

	public static final @NonNull String TRACE_DISPATCH_CLASS_DISPATCH_PROPERTY_NAME_PREFIX = "do";
	public static final @NonNull String TRACE_DISPATCH_PROPERTY_NAME_PREFIX = "d";
	public static final @NonNull String TRACE_INTERFACE_PROPERTY_NAME_PREFIX = "i";
	public static final @NonNull String TRACE_INVOCATION_PROPERTY_NAME_PREFIX = "c";
	public static final @NonNull String TRACE_INVOCATION_TRACE_PROPERTY_NAME_PREFIX = "w";
	public static final @NonNull String TRACE_SUCCESS_PROPERTY_NAME_PREFIX = "s";
	public static final @NonNull String TRACE_TRACE_PROPERTY_NAME_PREFIX = "t";
	public static final @NonNull String TRACE_WRAPPER_CLASS_PROPERTY_NAME_PREFIX = "ts";
	public static final @NonNull String TRACE_WHEN_PROPERTY_NAME_PREFIX = "when_";
	public static final @NonNull String TRACE_WHERE_PROPERTY_NAME_PREFIX = "where_";

	public @NonNull String createDispatchClassName(@NonNull Rule rule) {
		return TRACE_DISPATCH_CLASS_NAME_PREFIX + QVTbaseUtil.getName(rule);
	}

	public @NonNull String createDispatchClassDispatchPropertyName(@NonNull Relation relation) {
		String name = QVTrelationUtil.getName(relation);
		return TRACE_DISPATCH_CLASS_DISPATCH_PROPERTY_NAME_PREFIX + name;
	}

	public @NonNull String createDispatchClassPropertyName(@Nullable TypedModel typedModel, @NonNull VariableDeclaration variable) {
		int index = QVTbaseUtil.getTypedModelIndex(typedModel);
		String name = QVTrelationUtil.getName(variable);
		return TRACE_DISPATCH_PROPERTY_NAME_PREFIX + index + name;
	}

	public @NonNull String createDispatchClassResultPropertyName() {
		return /*"a_" +*/ DISPATCHCLASS_RESULT_PROPERTY_NAME;
	}

	public @NonNull String createInvocationClassName(@NonNull Rule rule) {
		return TRACE_INVOCATION_CLASS_NAME_PREFIX + QVTbaseUtil.getName(rule);
	}

	public @NonNull String createInvocationClassPropertyName(@Nullable TypedModel typedModel, @NonNull VariableDeclaration variable) {
		int index = QVTbaseUtil.getTypedModelIndex(typedModel);
		String name = QVTrelationUtil.getName(variable);
		return TRACE_INVOCATION_PROPERTY_NAME_PREFIX + index + name;
	}



	//	public @NonNull String createKey2InstanceClassName(org.eclipse.ocl.pivot.@NonNull Class identifiedClass) {
	//		return "Key2" + identifiedClass.getName();
	//	}

	//	public @NonNull String createKey2InstanceMappingName(org.eclipse.ocl.pivot.@NonNull Class identifiedClass, @NonNull TypedModel typedModel) {
	//		String enforcedDomainName = ClassUtil.nonNullState(typedModel.getName());
	//		return "Key2" + identifiedClass.getName() + "_" + enforcedDomainName;
	//	}

	public @NonNull String createInvocationTraceProperty(@NonNull Relation invokedRelation) {
		return TRACE_INVOCATION_TRACE_PROPERTY_NAME_PREFIX + invokedRelation.getName();
	}

	public @NonNull String createKeyedVariableName(@NonNull Variable identifiedVariable) {
		return QVTbaseUtil.getName(identifiedVariable) + "_key";
	}

	public @NonNull String createMappingName(@NonNull Relation rule, @Nullable String role, @NonNull TypedModelsConfiguration typedModelsConfiguration) {
		StringBuilder s = new StringBuilder();
		s.append(PivotUtil.getName(rule));
		if (role != null) {
			s.append("_");
			s.append(role);
		}
		for (@NonNull RelationDomain domain : QVTrelationUtil.getOwnedDomains(rule)) {
			TypedModel typedModel = domain.getTypedModel();
			if ((typedModel != null) && typedModelsConfiguration.isOutput(typedModel)) {
				s.append("_");
				s.append(PivotUtil.getName(typedModel));
			}
		}
		return s.toString();
	}

	public @NonNull String createTraceClassName(@NonNull Rule rule) {
		return TRACE_TRACE_CLASS_NAME_PREFIX + QVTbaseUtil.getName(rule);
	}

	public @NonNull String createTraceClassPropertyName(@Nullable TypedModel typedModel, @NonNull VariableDeclaration variable) {
		int index = QVTbaseUtil.getTypedModelIndex(typedModel);
		String name = QVTrelationUtil.getName(variable);
		return TRACE_TRACE_PROPERTY_NAME_PREFIX + index  + name;
	}

	public @NonNull String createTraceGlobalSuccessPropertyName() {
		int index = 0; //QVTbaseUtil.getTypedModelIndex(targetTypedModel);
		return TRACE_SUCCESS_PROPERTY_NAME_PREFIX + index + TRACE_GLOBAL_SUCCESS_PROPERTY_NAME_SUFFIX;
	}

	public @NonNull String createTraceLocalSuccessPropertyName() {
		int index = 0; //QVTbaseUtil.getTypedModelIndex(targetTypedModel);
		return TRACE_SUCCESS_PROPERTY_NAME_PREFIX + index + TRACE_LOCAL_SUCCESS_PROPERTY_NAME_SUFFIX;
	}

	public @NonNull String createTraceInterfaceName(@NonNull Rule rule) {
		return TRACE_INTERFACE_CLASS_NAME_PREFIX + QVTbaseUtil.getName(rule);
	}

	public @NonNull String createTraceInterfacePropertyName(@Nullable TypedModel typedModel, @NonNull VariableDeclaration variable) {
		int index = QVTbaseUtil.getTypedModelIndex(typedModel);
		String name = QVTrelationUtil.getName(variable);
		return TRACE_INTERFACE_PROPERTY_NAME_PREFIX + index + name;
	}

	public @NonNull String createWhenInvocationPropertyName(@NonNull Rule rule) {
		return TRACE_WHEN_PROPERTY_NAME_PREFIX + QVTbaseUtil.getName(rule);
	}

	//	public @NonNull String createWhenMappingClassName(@NonNull RelationDomain rInvokedDomain) {
	//		Relation invokedRelation = QVTbaseUtil.getContainingRelation(rInvokedDomain);
	//		return "when_" + invokedRelation.getName() + '_' + rInvokedDomain.getName();
	//	}
	/*	public @NonNull String createWhenMappingClassName(@NonNull Domain rInvokedDomain, @Nullable CallExp rInvocation) {
		Rule invokedRule = QVTbaseUtil.getContainingRule(rInvokedDomain);
		StringBuilder s = new StringBuilder();
		s.append(invokedRule.getName());
		s.append('_');
		s.append(rInvokedDomain.getName());
		s.append("_when");
		if (rInvocation != null) {
			s.append("_");
			s.append(QVTbaseUtil.getReferredRelation(rInvocation).getName());
		}
		return s.toString();
	} */

	//	public @NonNull String createWhenTraceClassName(@NonNull Relation invokingRelation, @NonNull Relation invokedRelation) {
	//		return TRACE_TRACE_CLASS_NAME_PREFIX + invokingRelation.getName() + "_when_" + invokedRelation.getName();
	//	}

	//	public @NonNull String createWhereMappingClassName(@NonNull RelationDomain rInvokedDomain) {
	//		Relation invokedRelation = QVTbaseUtil.getContainingRelation(rInvokedDomain);
	//		return "where_" + invokedRelation.getName() + '_' + rInvokedDomain.getName();
	//	}
	/*	public @NonNull String createWhereMappingClassName(@NonNull Domain rInvokedDomain, @Nullable RelationCallExp rInvocation) {
		Rule invokedRule = QVTbaseUtil.getContainingRule(rInvokedDomain);
		StringBuilder s = new StringBuilder();
		s.append(invokedRule.getName());
		s.append('_');
		s.append(rInvokedDomain.getName());
		s.append("_where");
		if (rInvocation != null) {
			s.append("_");
			s.append(QVTbaseUtil.getReferredRelation(rInvocation).getName());
		}
		return s.toString();
	} */

	public @NonNull String createWhereInvocationPropertyName(@NonNull Rule rule) {
		return TRACE_WHERE_PROPERTY_NAME_PREFIX + QVTbaseUtil.getName(rule);
	}

	public @NonNull String createWrapperClassPropertyName(@Nullable TypedModel typedModel, @NonNull VariableDeclaration variable) {
		int index = QVTbaseUtil.getTypedModelIndex(typedModel);
		String name = QVTrelationUtil.getName(variable);
		return TRACE_WRAPPER_CLASS_PROPERTY_NAME_PREFIX + index + name;
	}

	public @NonNull String createWrapperClassName(@NonNull Rule rule) {
		return TRACE_WRAPPER_CLASS_NAME_PREFIX + QVTbaseUtil.getName(rule);
	}
}
