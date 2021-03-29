/*******************************************************************************
 * Copyright (c) 2013, 2019 Willink Transformations and others.
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
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.PrimitiveType;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.ids.PropertyId;
import org.eclipse.ocl.pivot.internal.manager.MetamodelManagerInternal;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtimperative.EntryPoint;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeTransformation;
import org.eclipse.qvtd.pivot.qvtimperative.Mapping;
import org.eclipse.qvtd.pivot.qvtimperative.SetStatement;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeUtil;

/**
 * EntryPointsAnalysis accumulates salient characteristics of one or more entry points for a transformation
 * prior to execution so that those characteristics can be exploited during execution.
 * <p>
 * Salient characteristics are:
 * <br>
 * - the source types of allInstances() calls
 * - cache indexes of MiddleSetStatement/MiddlePropertyCallExp
 */
public class EntryPointsAnalysis
{
	protected final @NonNull EnvironmentFactoryInternal environmentFactory;
	protected final @NonNull ImperativeTransformation transformation;

	/**
	 *  Set of all types for which allInstances() is invoked.
	 */
	private final @NonNull Set<@NonNull CompleteClass> allInstancesCompleteClasses = new HashSet<>();

	/**
	 *  Map from navigable property to sequential index in any TypedModel.
	 */
	private final @NonNull Map<@NonNull Property, @NonNull Integer> property2cacheIndex = new HashMap<>();

	/**
	 * Map from propertyAssignment to the cache index of an un-navigable lookup cache to be updated by the assignment.
	 */
	private final @NonNull Map<@NonNull SetStatement, @NonNull Integer> setStatement2cacheIndex = new HashMap<>();


	/**
	 * Mappings that can be used as entry points.
	 */
	private final @NonNull Map<@NonNull EntryPoint, @NonNull EntryPointAnalysis> entryPoint2entryPointAnalysis = new HashMap<>();

	/**
	 * Mapping and their entry points.
	 */
	private final @NonNull Map<@NonNull Mapping, @NonNull EntryPointAnalysis> mapping2entryPointAnalysis = new HashMap<>();

	public EntryPointsAnalysis(@NonNull EnvironmentFactoryInternal environmentFactory, @NonNull ImperativeTransformation transformation) {
		this.environmentFactory = environmentFactory;
		this.transformation = transformation;
	}

	protected @NonNull Integer allocateCacheIndex(@Nullable OCLExpression sourceExpression, @NonNull Property navigableProperty) {
		Integer cacheIndex = property2cacheIndex.get(navigableProperty);
		if (cacheIndex == null) {
			Integer size = property2cacheIndex.size();
			property2cacheIndex.put(navigableProperty, size);
			cacheIndex = size;
		}
		return cacheIndex;
	}

	protected void analyzeStatements(@NonNull Iterable<@NonNull SetStatement> setStatements) {
		for (@NonNull SetStatement propertyAssignment : setStatements) {
			Property navigableProperty = propertyAssignment.getTargetProperty();
			if (navigableProperty != null) {
				Integer cacheIndex = property2cacheIndex.get(navigableProperty);
				if (cacheIndex != null) { 		// No need to set cacheIndex if it is never accessed by an OppositePropertyCallExp
					setStatement2cacheIndex.put(propertyAssignment, cacheIndex);
				}
			}
		}
	}

	public void analyzeTransformation() {
		for (@NonNull EntryPoint iEntryPoint : QVTimperativeUtil.computeEntryPoints(transformation)) {
			EntryPointAnalysis entryPointAnalysis = new EntryPointAnalysis(this, iEntryPoint);
			entryPoint2entryPointAnalysis.put(iEntryPoint, entryPointAnalysis);
			for (@NonNull Mapping mapping : QVTimperativeUtil.computeMappingClosure(iEntryPoint)) {
				entryPointAnalysis.addMapping(mapping);
				mapping2entryPointAnalysis.put(mapping, entryPointAnalysis);
			}
		}
		assert !entryPoint2entryPointAnalysis.isEmpty();
		for (@NonNull EntryPointAnalysis entryPointAnalysis : entryPoint2entryPointAnalysis.values()) {
			entryPointAnalysis.analyze();
		}
	}

	public void addAllInstancesClass(@NonNull TypedElement asExpression) {
		Type asType = asExpression instanceof OCLExpression ? ((OCLExpression)asExpression).getTypeValue() : null;
		if (asType == null) {
			asType = asExpression.getType();
		}
		if (asType instanceof org.eclipse.ocl.pivot.Class) {
			assert !(asType instanceof PrimitiveType);
			assert !(asType instanceof CollectionType);
			CompleteClass completeClass = environmentFactory.getCompleteModel().getCompleteClass(asType);
			allInstancesCompleteClasses.add(completeClass);
		}
	}

	public @NonNull Set<@NonNull CompleteClass> getAllInstancesCompleteClasses() {
		return allInstancesCompleteClasses;
	}

	public @Nullable Integer getCacheIndex(@NonNull SetStatement setStatement) {
		return setStatement2cacheIndex.get(setStatement);
	}

	public int getCacheIndexes() {
		return property2cacheIndex.size();
	}

	public @NonNull Map<@NonNull Property, @NonNull Integer> getCaches() {
		return property2cacheIndex;
	}

	//	@Deprecated
	//	public @NonNull EntryPointAnalysis getDefaultEntryPointAnalysis() {
	//		return entryPoint2entryPointAnalysis.values().iterator().next();
	//	}

	public @NonNull EnvironmentFactory getEnvironmentFactory() {
		return environmentFactory;
	}

	public @NonNull Iterable<@NonNull EntryPointAnalysis> getEntryPointAnalyses() {
		return entryPoint2entryPointAnalysis.values();
	}

	public @NonNull EntryPointAnalysis getEntryPointAnalysis(@NonNull EntryPoint entryPoint) {
		return ClassUtil.nonNullState(entryPoint2entryPointAnalysis.get(entryPoint));
	}

	/**
	 * Return a Map from each instanceClasses to the subset of instanceClasses that are transitive superClasses of the particular instanceClass.
	 */
	public @NonNull Map<@NonNull CompleteClass, @Nullable List<@NonNull CompleteClass>> getInstancesCompleteClassAnalysis(@NonNull Iterable<@NonNull CompleteClass> instanceCompleteClasses) {
		Map<@NonNull CompleteClass, @Nullable List<@NonNull CompleteClass>> instancesClassAnalysis = new HashMap<>();
		for (@NonNull CompleteClass instanceCompleteClass : instanceCompleteClasses) {
			instancesClassAnalysis.put(instanceCompleteClass, null);
		}
		for (@NonNull CompleteClass instanceCompleteClass : instancesClassAnalysis.keySet()) {
			List<@NonNull CompleteClass> superInstanceCompleteClasses = new ArrayList<>();
			superInstanceCompleteClasses.add(instanceCompleteClass);
			for (@NonNull CompleteClass superCompleteClass : instanceCompleteClass.getProperSuperCompleteClasses()) {
				if (instancesClassAnalysis.containsKey(superCompleteClass)) {
					superInstanceCompleteClasses.add(superCompleteClass);
				}
				instancesClassAnalysis.put(instanceCompleteClass, superInstanceCompleteClasses);
			}
		}
		return instancesClassAnalysis;
	}

	public @NonNull MetamodelManagerInternal getMetamodelManager() {
		return environmentFactory.getMetamodelManager();
	}

	public @NonNull PropertyId @NonNull [] getPropertyIndex2propertyId() {
		@NonNull PropertyId @NonNull [] propertyIndex2propertyId = new @NonNull PropertyId[property2cacheIndex.size()];
		for (@NonNull Property property : property2cacheIndex.keySet()) {
			Integer index = property2cacheIndex.get(property);
			assert index != null;
			propertyIndex2propertyId[index] = property.getPropertyId();
		}
		return propertyIndex2propertyId;
	}

	public @NonNull ImperativeTransformation getTransformation() {
		return transformation;
	}

	@Override
	public String toString() {
		return entryPoint2entryPointAnalysis.keySet().toString();
	}
}
