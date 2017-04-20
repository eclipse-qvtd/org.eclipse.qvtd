/*******************************************************************************
 * Copyright (c) 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvtr2qvtc;

import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtrelation.Key;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationDomain;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrelationUtil;

/**
 * QVTrNameGenerator localizes the name generation functionality to facilitate a chnage / rewrite.
 */
public class QVTrNameGenerator
{
	public static final @NonNull String IDENTIFIED_INSTANCE_VARIABLE_NAME = "identifiedInstance";
	public static final @NonNull String KEYED_INSTANCE_PROPERTY_NAME = "instance";
	public static final @NonNull String KEY2INSTANCE_VARIABLE_NAME = "key2instance";

	protected final @NonNull QVTr2QVTc qvtr2qvtc;

	public QVTrNameGenerator(@NonNull QVTr2QVTc qvtr2qvtc) {
		this.qvtr2qvtc = qvtr2qvtc;
	}

	public @NonNull String createKeyFunctionName(@NonNull TypedModel rTypedModel, @NonNull Key rKey) {
		org.eclipse.ocl.pivot.@NonNull Class identifiedClass = QVTrelationUtil.getIdentifies(rKey);
		return  "Key_" + QVTrelationUtil.getName(rTypedModel) + "_" + QVTrelationUtil.getName(identifiedClass);
	}

	//	public @NonNull String createKey2InstanceClassName(org.eclipse.ocl.pivot.@NonNull Class identifiedClass) {
	//		return "Key2" + identifiedClass.getName();
	//	}

	//	public @NonNull String createKey2InstanceMappingName(org.eclipse.ocl.pivot.@NonNull Class identifiedClass, @NonNull TypedModel typedModel) {
	//		String rEnforcedDomainName = ClassUtil.nonNullState(typedModel.getName());
	//		return "Key2" + identifiedClass.getName() + "_" + rEnforcedDomainName;
	//	}

	public @NonNull String createKeyedVariableName(@NonNull Variable identifiedVariable) {
		return QVTrelationUtil.getName(identifiedVariable) + "_key";
	}

	public @NonNull String createSignatureClassName(org.eclipse.ocl.pivot.@NonNull Class signatureClass) {
		return "S" + signatureClass.getName().substring(1);
	}

	public @NonNull String createTraceClassName(@NonNull Relation relation) {
		return "T" + QVTrelationUtil.getName(relation);
	}

	public @NonNull String createTracePropertyName(@NonNull VariableDeclaration variable) {
		return /*"t_" +*/ QVTrelationUtil.getName(variable);
	}

	public @NonNull String createWhenInvocationPropertyName(@NonNull Relation relation) {
		return "when_" + QVTrelationUtil.getName(relation);
	}

	public @NonNull String createWhereInvocationPropertyName(@NonNull Relation relation) {
		return "where_" + QVTrelationUtil.getName(relation);
	}

	public @NonNull String createWhenMappingClassName(@NonNull RelationDomain rInvokedDomain) {
		Relation invokedRelation = QVTrelationUtil.getContainingRelation(rInvokedDomain);
		return "when_" + invokedRelation.getName() + '_' + rInvokedDomain.getName();
	}

	//	public @NonNull String createWhenTraceClassName(@NonNull Relation invokingRelation, @NonNull Relation invokedRelation) {
	//		return "T" + invokingRelation.getName() + "_when_" + invokedRelation.getName();
	//	}

	public @NonNull String createWhereMappingClassName(@NonNull RelationDomain rInvokedDomain) {
		Relation invokedRelation = QVTrelationUtil.getContainingRelation(rInvokedDomain);
		return "where_" + invokedRelation.getName() + '_' + rInvokedDomain.getName();
	}

	//	public @NonNull String createWhereTraceClassName(@NonNull Relation invokingRelation, @NonNull Relation invokedRelation) {
	//		return "T" + invokingRelation.getName() + "_where_" + invokedRelation.getName();
	//	} */

	/**
	 * Return a uniqueName for object within the name2object domain.
	 * Returns name if not already in use otherwise a numerically suffixed variant of name.
	 * In either case a new entry is added to name2object for the the returned name mapped to object.
	 */
	public <T> @NonNull String getUniqueName(@NonNull Map<@NonNull String, @NonNull T> name2object, @NonNull String name, @NonNull T object) {
		String uniqueName = name;
		int suffix = 0;
		while (name2object.get(uniqueName) != null) {
			uniqueName = name + ++suffix;
		}
		name2object.put(uniqueName, object);
		return uniqueName;
	}
}
