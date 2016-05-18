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

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.qvtd.pivot.qvtrelation.Key;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;

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

	public @NonNull String createKeyFunctionName(@NonNull Key rKey) {
		org.eclipse.ocl.pivot.@NonNull Class identifiedClass = ClassUtil.nonNullState(rKey.getIdentifies());
		return "Key2" + identifiedClass.getName();
	}

//	public @NonNull String createKey2InstanceClassName(org.eclipse.ocl.pivot.@NonNull Class identifiedClass) {
//		return "Key2" + identifiedClass.getName();
//	}

//	public @NonNull String createKey2InstanceMappingName(org.eclipse.ocl.pivot.@NonNull Class identifiedClass, @NonNull TypedModel typedModel) {
//		String rEnforcedDomainName = ClassUtil.nonNullState(typedModel.getName());
//		return "Key2" + identifiedClass.getName() + "_" + rEnforcedDomainName;
//	}

	public @NonNull String createKeyedVariableName(@NonNull Variable identifiedVariable) {
		return identifiedVariable.getName() + "_key";
	}

	public @NonNull String createTraceClassName(@NonNull Relation relation) {
		return "T" + relation.getName();
	}
}
