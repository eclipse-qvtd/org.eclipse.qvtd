/*******************************************************************************
 * Copyright (c) 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Adolfo Sanchez-Barbudo Herrera - initial API and implementation
 *     E.D.Willink - use Complete model
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvtp2qvts.analysis;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.CompleteModel;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.ocl.pivot.utilities.FeatureFilter;

/**
 * ContainmentAnalysis provides an analysis of all declared containment relationships in the EnvironmentFactory's resources. It therefore supports the compile time question:
 *
 * What declared container types could contain this declared contained type?
 *
 * The declared contained type could actually be any of its subclasses, so the containment properties must consider them all.
 * The actual container types could be the sub-class of each possible containment property.
 * The declared container types could be the super-classes too.
 */
public class ContainmentAnalysis
{
	private static final @NonNull List<@NonNull CompleteClass> EMPTY_CLASS_LIST = Collections.emptyList();
	private static final @NonNull List<@NonNull Property> EMPTY_PROPERTY_LIST = Collections.emptyList();

	protected final @NonNull CompleteModel completeModel;
	protected final @NonNull InheritanceAnalysis inheritanceAnalysis;

	/**
	 * Map from a contained class to all its possible containment (container2contained) properties.
	 */
	private final @NonNull Map<@NonNull CompleteClass, @NonNull List<@NonNull Property>> containedClass2containmentProperties = new HashMap<>();

	/**
	 * Map from a contained class to all its possible container classes.
	 */
	private final @NonNull Map<@NonNull CompleteClass, @NonNull List<@NonNull CompleteClass>> containedClass2containerClasses = new HashMap<>();

	public ContainmentAnalysis(@NonNull EnvironmentFactory environmentFactory) {
		this.completeModel = environmentFactory.getCompleteModel();
		this.inheritanceAnalysis = new InheritanceAnalysis(environmentFactory);
		for (@NonNull CompleteClass completeClass : inheritanceAnalysis.getAllCompleteClasses()) {
			computeContainedClass2ContainerClasses(completeClass);
		}
	}

	private void addContainmentForContainedClasses(@NonNull CompleteClass containerClass, @NonNull Property containmentProperty, @NonNull CompleteClass containedClass) {
		List<@NonNull Property> containmentProperties = containedClass2containmentProperties.get(containedClass);
		if (containmentProperties == null) {
			containmentProperties = new ArrayList<>();
			containedClass2containmentProperties.put(containedClass, containmentProperties);
		}
		if (!containmentProperties.contains(containmentProperty)) {
			containmentProperties.add(containmentProperty);
		}
		//
		List<@NonNull CompleteClass> containerClasses = containedClass2containerClasses.get(containedClass);
		if (containerClasses == null) {
			containerClasses = new ArrayList<>();
			containedClass2containerClasses.put(containedClass, containerClasses);
		}
		if (!containerClasses.contains(containerClass)) {
			containerClasses.add(containerClass);
		}
	}

	private void computeContainedClass2ContainerClasses(@NonNull CompleteClass containerCompleteClass) {
		for (@NonNull Property property : containerCompleteClass.getProperties(FeatureFilter.SELECT_NON_STATIC)) {
			if (property.isIsComposite()) {
				Type type = property.getType();
				if (type instanceof CollectionType) {
					type = ((CollectionType) type).getElementType();
				}
				assert type != null;
				CompleteClass containedCompleteClass = completeModel.getCompleteClass(type);
				for (@NonNull CompleteClass containedSubCompleteClass : inheritanceAnalysis.getAllSuperAndSelfAndSubClasses(containedCompleteClass)) {
					addContainmentForContainedClasses(containerCompleteClass, property, containedSubCompleteClass);
				}
			}
		}
	}

	public @NonNull Iterable<@NonNull CompleteClass> getContainerClasses(@NonNull CompleteClass containedClass) {
		List<@NonNull CompleteClass> containerClasses = containedClass2containerClasses.get(containedClass);
		return containerClasses == null ? EMPTY_CLASS_LIST : containerClasses;
	}

	public @NonNull Iterable<@NonNull Property> getContainmentProperties(@NonNull CompleteClass containedClass) {
		List<@NonNull Property> containmentProperties = containedClass2containmentProperties.get(containedClass);
		return containmentProperties == null ? EMPTY_PROPERTY_LIST : containmentProperties;
	}

	public @NonNull InheritanceAnalysis getInheritanceAnalysis() {
		return inheritanceAnalysis;
	}
}
