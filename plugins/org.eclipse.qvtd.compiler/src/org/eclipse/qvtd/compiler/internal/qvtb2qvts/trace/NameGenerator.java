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
package org.eclipse.qvtd.compiler.internal.qvtb2qvts.trace;

import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.Nameable;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatum;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

/**
 * NameGenerator localizes the name generation functionality to facilitate a chnage / rewrite.
 */
public class NameGenerator
{
	/**
	 * Return a uniqueName for object within the name2object domain.
	 * Returns name if not already in use otherwise a numerically suffixed variant of name.
	 * In either case a new entry is added to name2object for the the returned name mapped to object.
	 */
	public static <T> @NonNull String getUniqueName(@NonNull Map<@NonNull String, T> name2object, @NonNull String name, @NonNull T object) {
		assert !name2object.containsValue(object);
		String uniqueName = name;
		int suffix = 0;
		while (name2object.get(uniqueName) != null) {
			uniqueName = name + ++suffix;
		}
		name2object.put(uniqueName, object);
		return uniqueName;
	}
	public static <T> @NonNull String getUniqueName(@NonNull Set<@NonNull String> names, @NonNull String newName) {
		String uniqueName = newName;
		int suffix = 0;
		while (names.contains(uniqueName)) {
			uniqueName = newName + ++suffix;
		}
		return uniqueName;
	}
	public static <T> @NonNull String getUniqueName(@NonNull Iterable<? extends @NonNull Nameable> nameables, @NonNull String newName) {
		String uniqueName = newName;
		int suffix = 0;
		while (NameUtil.getNameable(nameables, uniqueName) != null) {
			uniqueName = newName + ++suffix;
		}
		return uniqueName;
	}

	public @NonNull String createKeyFunctionName(@NonNull ClassDatum classDatum) {
		TypedModel typedModel = QVTscheduleUtil.getReferredTypedModel(classDatum);
		CompleteClass completeClass = QVTscheduleUtil.getCompleteClass(classDatum);
		return  "Key_" + QVTbaseUtil.getName(typedModel) + "_" + QVTbaseUtil.getName(completeClass);
	}

	//	public @NonNull String createTracePropertyName(@NonNull VariableDeclaration variable) {
	//		return /*"t_" +*/ QVTbaseUtil.getName(variable);
	//	}
}
