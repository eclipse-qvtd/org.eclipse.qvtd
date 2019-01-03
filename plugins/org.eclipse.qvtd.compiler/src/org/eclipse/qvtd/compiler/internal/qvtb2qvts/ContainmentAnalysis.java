/*******************************************************************************
 * Copyright (c) 2016, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     Adolfo Sanchez-Barbudo Herrera - initial API and implementation
 *     E.D.Willink - use Complete model
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvtb2qvts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.CompleteModel;
import org.eclipse.ocl.pivot.MapType;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.ocl.pivot.utilities.FeatureFilter;
import org.eclipse.ocl.pivot.utilities.PivotUtil;

/**
 * ContainmentAnalysis provides an analysis of all declared containment relationships in the EnvironmentFactory's resources. It therefore supports the compile time question:
 *
 * What declared container types could contain this declared contained type?
 *
 * The declared contained type could actually be any of its subtypes, so the containment properties must consider them all super-types of 'this declared container type'.
 * The actual containing types could also be an of the subtypes of each possible containing property owner.
 *
 * Considering e.g. EPackage.eClassifers, the containment is declared to contain EClassifier but may also be the container of the EClass/EDataType subtypes. The container is declared
 * to be EPackage but could be a subtype of EPackage.
 *
 * The more general usage of anENamedElement.eClassifiers anotherENamedElement has selective solutions when anENamedElement and anotherENamedElement are suitable derived classes,
 * but this is a separate problem requiring oclIsKindOf guards around the attempted containment test.
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
			computeContainedClass2containerClasses(completeClass);
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

	private void computeContainedClass2containerClasses(@NonNull CompleteClass containerCompleteClass) {
		for (@NonNull Property property : containerCompleteClass.getProperties(FeatureFilter.SELECT_NON_STATIC)) {
			if (property.isIsComposite()) {
				Type type = PivotUtil.getElementalType(PivotUtil.getType(property));
				if (!(type instanceof MapType)) {		// FIXME why?
					CompleteClass containedCompleteClass = completeModel.getCompleteClass(type);
					for (@NonNull CompleteClass containedSubCompleteClass : inheritanceAnalysis./*getAllSuperAndSelfAndSubClasses*/getAllSelfAndSubClasses(containedCompleteClass)) {
						addContainmentForContainedClasses(containerCompleteClass, property, containedSubCompleteClass);
					}
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

	public @NonNull EnvironmentFactory getEnvironmentFactory() {
		return inheritanceAnalysis.getEnvironmentFactory();
	}

	public @NonNull InheritanceAnalysis getInheritanceAnalysis() {
		return inheritanceAnalysis;
	}
}
