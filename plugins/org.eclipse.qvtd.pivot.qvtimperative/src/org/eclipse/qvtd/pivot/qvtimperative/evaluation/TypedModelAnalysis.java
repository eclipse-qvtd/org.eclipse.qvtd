/*******************************************************************************
 * Copyright (c) 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 ******************************************************************************/
package org.eclipse.qvtd.pivot.qvtimperative.evaluation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.ids.ClassId;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;

public class TypedModelAnalysis
{
	protected final @NonNull QVTiTransformationAnalysis transformationAnalysis;
	protected final @NonNull TypedModel typedModel;
	protected final @NonNull Set<@NonNull CompleteClass> allInstancesCompleteClasses;
	protected final @NonNull Map<@NonNull CompleteClass, @Nullable List<@NonNull CompleteClass>> instancesCompleteClassAnalysis;
	protected final @NonNull Map<@NonNull CompleteClass, @NonNull Integer> instancesCompleteClass2index;
	protected final @NonNull List<@NonNull CompleteClass> sortedCompleteClasses;
	protected final int extentClassIndex;
	protected @Nullable List<@NonNull Integer> extentOppositePropertyIndexes = null;

	public TypedModelAnalysis(@NonNull QVTiTransformationAnalysis transformationAnalysis, @NonNull TypedModel typedModel, @NonNull Set<@NonNull CompleteClass> allInstancesCompleteClasses) {
		this.transformationAnalysis = transformationAnalysis;
		this.typedModel = typedModel;
		this.allInstancesCompleteClasses = allInstancesCompleteClasses;
		this.instancesCompleteClassAnalysis = transformationAnalysis.getInstancesCompleteClassAnalysis(allInstancesCompleteClasses);
		//
		// Populate a mapping from instancesClass to linear index.
		//
		this.instancesCompleteClass2index = new HashMap<>(instancesCompleteClassAnalysis.size());
		this.sortedCompleteClasses = new ArrayList<>(instancesCompleteClassAnalysis.keySet());
		Collections.sort(sortedCompleteClasses, NameUtil.NameableComparator.INSTANCE);
		ClassId extentClassId = QVTiModelsManager.EXTENT_CLASSID;
		int extentClassIndex = -1;
		for (int i = 0; i < sortedCompleteClasses.size(); i++) {
			CompleteClass sortedCompleteClass = sortedCompleteClasses.get(i);
			instancesCompleteClass2index.put(sortedCompleteClass, i);
			TypeId typeId = sortedCompleteClass.getPrimaryClass().getTypeId();
			if (typeId == extentClassId) {
				extentClassIndex = i;
			}
		}
		this.extentClassIndex = extentClassIndex;
		//
		Map<@NonNull Property, @NonNull Integer> opposites = transformationAnalysis.getCaches();
		for (@NonNull Property property : opposites.keySet()) {
			org.eclipse.ocl.pivot.Class owningClass = PivotUtil.getOwningClass(property);
			TypeId typeId = owningClass.getTypeId();
			if (typeId == extentClassId) {
				Integer index = opposites.get(property);
				assert index != null;
				List<@NonNull Integer> extentOppositePropertyIndexes2 = extentOppositePropertyIndexes;
				if (extentOppositePropertyIndexes2 == null) {
					extentOppositePropertyIndexes = extentOppositePropertyIndexes2 = new ArrayList<>();
				}
				extentOppositePropertyIndexes2.add(index);
			}
		}
	}

	/*	public @NonNull Integer @NonNull [] getClassId2classIndex() {
		@NonNull Integer [] classId2classIndex = new @NonNull Integer [sortedCompleteClasses.size()];
		for (int i = 0; i < sortedCompleteClasses.size(); i++) {
			org.eclipse.ocl.pivot.Class instancesClass = sortedCompleteClasses.get(i);
			TypeId classId = instancesClass.getTypeId();
			//	CGTypeId cgTypeId = getCodeGenerator().getAnalyzer().getTypeId(instancesClass.getTypeId());
		}
		return classId2classIndex;
	} */

	public int @Nullable [] @NonNull [] getClassIndex2allClassIndexes() {
		int iMax = sortedCompleteClasses.size();
		int [] @NonNull [] classIndex2allClassIndexes = new int @Nullable [iMax] [];
		for (int i = 0; i < iMax; i++) {
			CompleteClass instancesClass = sortedCompleteClasses.get(i);
			List<@NonNull CompleteClass> superInstancesClasses = ClassUtil.nonNullState(instancesCompleteClassAnalysis.get(instancesClass));
			int j = 0;
			int[] row = new int[superInstancesClasses.size()];
			for (@NonNull CompleteClass superInstancesClass : superInstancesClasses) {
				Integer index = instancesCompleteClass2index.get(superInstancesClass);
				assert index != null;
				row[j++] = index;
			}
			classIndex2allClassIndexes[i] = row;;
		}
		return classIndex2allClassIndexes;
	}

	public @NonNull ClassId @NonNull [] getClassIndex2ClassId() {
		@NonNull ClassId [] classIndex2ClassId = new @NonNull ClassId [sortedCompleteClasses.size()];
		for (int i = 0; i < sortedCompleteClasses.size(); i++) {
			CompleteClass instancesClass = sortedCompleteClasses.get(i);
			TypeId classId = instancesClass.getPrimaryClass().getTypeId();
			classIndex2ClassId[i] = (ClassId) classId;
		}
		return classIndex2ClassId;
	}

	public int getExtentClassIndex() {
		return extentClassIndex;
	}

	public @Nullable List<@NonNull Integer> getExtentOppositePropertyIndexes() {
		return extentOppositePropertyIndexes;
	}

	@Override
	public String toString() {
		return typedModel.toString();
	}
}