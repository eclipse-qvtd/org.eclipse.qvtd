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
package org.eclipse.qvtd.compiler.internal.qvtp2qvts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.CompleteModel;
import org.eclipse.ocl.pivot.CompletePackage;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.internal.manager.MetamodelManagerInternal;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.ocl.pivot.utilities.FeatureFilter;

import com.google.common.collect.Iterables;

/**
 * ClassRelationships provides an analysis of all class relationships in the EnvironmentFactory's resources.
 */
public class ClassRelationships
{
	private static final @NonNull Set<@NonNull CompleteClass> EMPTY_CLASS_SET = Collections.emptySet();

	public static class ContainerClass
	{
		private final @NonNull CompleteClass containerClass;
		private final @NonNull Property containmentProperty;

		public ContainerClass(@NonNull CompleteClass containerClass, @NonNull Property containmentProperty) {
			this.containerClass = containerClass;
			this.containmentProperty = containmentProperty;
		}

		public @NonNull CompleteClass getContainerClass() {
			return containerClass;
		}

		public @NonNull Property getContainmentProperty() {
			return containmentProperty;
		}

		@Override
		public @NonNull String toString() {
			return containerClass.getName() + " - " + containmentProperty.getName();
		}
	}

	protected final @NonNull CompleteModel completeModel;

	private final @NonNull Deque<@NonNull CompletePackage> packageToProcess = new LinkedList<>();
	private final @NonNull Set<@NonNull CompletePackage> processedPackage = new HashSet<>();

	private final @NonNull Map<@NonNull CompleteClass, @NonNull Set<@NonNull CompleteClass>> class2superClasses = new HashMap<>();
	private final @NonNull Map<@NonNull CompleteClass, @NonNull Set<@NonNull CompleteClass>> class2directSubClasses = new HashMap<>();
	private final @NonNull Map<@NonNull CompleteClass, @NonNull Set<@NonNull CompleteClass>> class2allSubClasses = new HashMap<>();
	private final @NonNull Map<@NonNull CompleteClass, @NonNull Set<@NonNull CompleteClass>> class2containerClasses = new HashMap<>();
	private final @NonNull Map<@NonNull CompleteClass, @NonNull Set<@NonNull ContainerClass>> class2detailedContainerClasses = new HashMap<>();

	public ClassRelationships(@NonNull EnvironmentFactory environmentFactory) {
		this.completeModel = environmentFactory.getCompleteModel();
		MetamodelManagerInternal metamodelManager = (MetamodelManagerInternal)environmentFactory.getMetamodelManager();
		metamodelManager.getASmetamodel();
		initializeMaps(metamodelManager.getASResourceSet());
	}

	private void addContainerClassForTypeAndSubtypes(@NonNull CompleteClass containerClass, @NonNull Property containmentProperty, @NonNull CompleteClass type) {
		Set<@NonNull ContainerClass> detailedContainerClasses = class2detailedContainerClasses.get(type);
		Set<@NonNull CompleteClass> containerClasses = class2containerClasses.get(type);
		if (detailedContainerClasses == null) {
			detailedContainerClasses = new HashSet<>();
			class2detailedContainerClasses.put(type, detailedContainerClasses);
		}
		if (containerClasses == null) {
			containerClasses = new HashSet<>();
			class2containerClasses.put(type, containerClasses);
		}

		detailedContainerClasses.add(new ContainerClass(containerClass, containmentProperty));
		containerClasses.add(containerClass);

		for (@NonNull CompleteClass subType : getDirectSubClasses(type)) {
			addContainerClassForTypeAndSubtypes(containerClass, containmentProperty, subType);
		}
	}

	private void computeClass2ContainerClasses(@NonNull CompleteClass aClass) {

		for (@NonNull Property property : aClass.getProperties(FeatureFilter.SELECT_NON_STATIC)) {
			if (property.isIsComposite()) {
				Type propType = getType(property);
				//				if (propType instanceof org.eclipse.ocl.pivot.Class) {
				CompleteClass completeClass = getCompleteClass(propType);
				addContainerClassForTypeAndSubtypes(aClass, property, completeClass);
				//				}
			}
		}
	}

	private void computeClass2SubClasses(@NonNull CompleteClass aClass) {
		Set<@NonNull CompleteClass> superClasses = class2superClasses.get(aClass);
		if (superClasses != null) {
			for (@NonNull CompleteClass superClass : superClasses) {
				if (Iterables.contains(aClass.getSuperCompleteClasses(), superClass)) {
					Set<@NonNull CompleteClass> directSubClasses = class2directSubClasses.get(superClass);
					if (directSubClasses == null) {
						directSubClasses = new HashSet<>();
						class2directSubClasses.put(superClass, directSubClasses);
					}
					directSubClasses.add(aClass);
				}

				Set<@NonNull CompleteClass> allSubClasses = class2allSubClasses.get(superClass);
				if (allSubClasses == null) {
					allSubClasses = new HashSet<>();
					class2allSubClasses.put(superClass, allSubClasses);
				}
				allSubClasses.add(aClass);
			}
		}
	}

	private void computeClass2SuperClasses(@NonNull CompletePackage p) {
		if (processedPackage.contains(p)) {
			return;
		}
		processedPackage.add(p);
		for (@NonNull CompleteClass aClass : ClassUtil.nullFree(p.getOwnedCompleteClasses())) {
			computeClass2SuperClasses(aClass);
		}
		for (@NonNull CompletePackage nestedPackage : ClassUtil.nullFree(p.getOwnedCompletePackages())) {
			computeClass2SuperClasses(nestedPackage);
		}
	}

	/**
	 * Tranisitively compute
	 * @param aClass
	 * @return a set with all the all classess
	 */
	private @NonNull Set<@NonNull CompleteClass> computeClass2SuperClasses(@NonNull CompleteClass aClass) {
		Set<@NonNull CompleteClass> superRels = class2superClasses.get(aClass);
		if (superRels != null) {
			return superRels;
		} else {
			superRels = new HashSet<>();
			class2superClasses.put(aClass, superRels);
		}

		// Super class inheritance might be shortcut
		for (@NonNull CompleteClass superClass : aClass.getProperSuperCompleteClasses()) {
			superRels.add(superClass);
			superRels.addAll(computeClass2SuperClasses(superClass));
		}

		CompletePackage pPackage = ClassUtil.nonNullState(aClass.getOwningCompletePackage());
		if (!processedPackage.contains(pPackage) &&
				! packageToProcess.contains(pPackage)) {
			packageToProcess.add(pPackage);
		}
		return superRels;
	}

	public @NonNull Set<@NonNull CompleteClass> getAllSubClasses(@NonNull CompleteClass type) {
		Set<@NonNull CompleteClass> allSubClasses = class2allSubClasses.get(type);
		return allSubClasses == null ? EMPTY_CLASS_SET
			: ClassUtil.nonNullState(Collections.<@NonNull CompleteClass>unmodifiableSet(allSubClasses));
	}

	public @NonNull Set<@NonNull CompleteClass> getAllSuperClasses(@NonNull CompleteClass type) {
		Set<@NonNull CompleteClass> allSuperClasses = class2superClasses.get(type);
		return allSuperClasses == null ? EMPTY_CLASS_SET
			: ClassUtil.nonNullState(Collections.<@NonNull CompleteClass>unmodifiableSet(allSuperClasses));
	}

	public @NonNull CompleteClass getCompleteClass(@NonNull Type asClass) {
		return completeModel.getCompleteClass(asClass);
	}

	public @NonNull Set<@NonNull CompleteClass> getContainerClasses(@NonNull CompleteClass type) {
		Set<@NonNull CompleteClass> containerClasses = class2containerClasses.get(type);
		return containerClasses == null ? EMPTY_CLASS_SET
			: ClassUtil.nonNullState(Collections.<@NonNull CompleteClass>unmodifiableSet(containerClasses));
	}

	public @NonNull Set<@NonNull ContainerClass> getDetailedContainerClasses(@NonNull CompleteClass type) {
		Set<@NonNull ContainerClass> containerClasses = class2detailedContainerClasses.get(type);
		return ClassUtil.nonNullState(containerClasses == null ? Collections.<@NonNull ContainerClass>emptySet()
			: Collections.<@NonNull ContainerClass>unmodifiableSet(containerClasses));
	}

	public @NonNull Set<@NonNull CompleteClass> getDirectSubClasses(@NonNull CompleteClass type) {
		Set<@NonNull CompleteClass> directSubClasses = class2directSubClasses.get(type);
		return directSubClasses == null ? EMPTY_CLASS_SET
			: ClassUtil.nonNullState(Collections.<@NonNull CompleteClass>unmodifiableSet(directSubClasses));
	}

	private @NonNull List<org.eclipse.ocl.pivot.@NonNull Package> getInvolvedPackages(@NonNull Resource resource) {
		List<@NonNull Model> oclRoots = new ArrayList<>();
		for (EObject root : resource.getContents()) {
			if (root instanceof Model) {
				oclRoots.add((Model)root);
			}
		}
		List<org.eclipse.ocl.pivot.@NonNull Package> result = new ArrayList<>();
		for (Model root : oclRoots) {
			for (org.eclipse.ocl.pivot.@NonNull Package pckg : ClassUtil.nullFree(root.getOwnedPackages())) {
				result.add(pckg);
			}
		}
		return result;
	}

	private @NonNull Type getType(@NonNull TypedElement typedElement) {
		Type type = typedElement.getType();
		if (type instanceof CollectionType) {
			type = ((CollectionType) type).getElementType();
		}
		return ClassUtil.nonNullState(type);
	}

	private void initializeMaps(@NonNull ResourceSet resourceSet) {
		for (@NonNull Resource resource : ClassUtil.nullFree(resourceSet.getResources())) {
			for (org.eclipse.ocl.pivot.@NonNull Package aPackage : getInvolvedPackages(resource)) {
				CompletePackage pPackage = completeModel.getCompletePackage(aPackage);
				if (!packageToProcess.contains(pPackage)) {
					packageToProcess.add(pPackage);;
				}
			}
		}
		while (!packageToProcess.isEmpty()) {
			CompletePackage aPackage = packageToProcess.pop();
			computeClass2SuperClasses(aPackage);
		}
		for (@NonNull CompleteClass type : class2superClasses.keySet()) {
			computeClass2SubClasses(type);
		}
		for (@NonNull CompleteClass type : class2superClasses.keySet()) { // subtypes need to be previously computed
			computeClass2ContainerClasses(type);
		}
	}
}
