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
package org.eclipse.qvtd.compiler.internal.qvtp2qvts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.internal.manager.MetamodelManagerInternal;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.ocl.pivot.utilities.MetamodelManager;


/**
 * @author asbh500
 *
 * @param <C>
 */
public class ClassRelationships {
	private static final @NonNull Set<org.eclipse.ocl.pivot.@NonNull Class> EMPTY_CLASS_SET = Collections.emptySet();

	public static class ContainerClass {

		private org.eclipse.ocl.pivot.@NonNull Class containerClass;

		private @NonNull Property containmentProperty;

		public ContainerClass(org.eclipse.ocl.pivot.@NonNull Class containerClass, @NonNull Property containmentProperty) {
			this.containerClass = containerClass;
			this.containmentProperty = containmentProperty;
		}

		public org.eclipse.ocl.pivot.@NonNull Class getContainerClass() {
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

	private @NonNull Map<org.eclipse.ocl.pivot.@NonNull Class, @NonNull Set<org.eclipse.ocl.pivot.@NonNull Class>> class2superClasses = new HashMap<>();

	private @NonNull Map<org.eclipse.ocl.pivot.@NonNull Class, @NonNull Set<org.eclipse.ocl.pivot.@NonNull Class>> class2directSubClasses = new HashMap<>();

	private @NonNull Map<org.eclipse.ocl.pivot.@NonNull Class, @NonNull Set<org.eclipse.ocl.pivot.@NonNull Class>> class2allSubClasses = new HashMap<>();

	private @NonNull Map<org.eclipse.ocl.pivot.@NonNull Class, @NonNull Set<org.eclipse.ocl.pivot.@NonNull Class>> class2containerClasses = new HashMap<>();

	private @NonNull Map<org.eclipse.ocl.pivot.@NonNull Class, @NonNull Set<@NonNull ContainerClass>> class2detailedContainerClasses = new HashMap<>();

	protected @NonNull MetamodelManager mManager;

	private @NonNull Deque<org.eclipse.ocl.pivot.@NonNull Package> packageToProcess = new LinkedList<>();

	private @NonNull Set<org.eclipse.ocl.pivot.@NonNull Package> processedPackage = new HashSet<>();

	public ClassRelationships(@NonNull EnvironmentFactory ocl) {
		mManager = ocl.getMetamodelManager();
		((MetamodelManagerInternal)mManager).getASmetamodel();
		initializeMaps(ocl.getMetamodelManager().getASResourceSet());
	}

	private void initializeMaps(@NonNull ResourceSet resourceSet) {

		for (@NonNull Resource resource : ClassUtil.nullFree(resourceSet.getResources())) {
			for (org.eclipse.ocl.pivot.@NonNull Package aPackage : getInvolvedPackages(resource)) {
				org.eclipse.ocl.pivot.Package pPackage = mManager.getPrimaryPackage(aPackage);
				if (!packageToProcess.contains(pPackage)) {
					packageToProcess.add(pPackage);;
				}
			}
		}

		while (!packageToProcess.isEmpty()) {
			org.eclipse.ocl.pivot.Package aPackage = packageToProcess.pop();
			computeClass2SuperClasses(aPackage);
		}

		for (org.eclipse.ocl.pivot.Class type : class2superClasses.keySet()) {
			computeClass2SubClasses(type);
		}

		for (org.eclipse.ocl.pivot.Class type : class2superClasses.keySet()) { // subtypes need to be previously computed
			computeClass2ContainerClasses(type);
		}
	}


	private void computeClass2SuperClasses(org.eclipse.ocl.pivot.@NonNull Package p) {

		if (processedPackage.contains(p)) {
			return;
		}
		processedPackage.add(p);
		for (org.eclipse.ocl.pivot.Class aClass : ClassUtil.nullFree(p.getOwnedClasses())) {
			computeClass2SuperClasses(aClass);
		}
		for (org.eclipse.ocl.pivot.Package nestedPackage : ClassUtil.nullFree(p.getOwnedPackages())) {
			computeClass2SuperClasses(nestedPackage);
		}
	}

	/**
	 * Tranisitively compute
	 * @param aClass
	 * @return a set with all the all classess
	 */
	private @NonNull Set<org.eclipse.ocl.pivot.@NonNull Class> computeClass2SuperClasses(org.eclipse.ocl.pivot.@NonNull Class aClass) {

		//aClass = mManager.getPrimaryClass(aClass);
		Set<org.eclipse.ocl.pivot.@NonNull Class> superRels = class2superClasses.get(aClass);
		if (superRels != null) {
			return superRels;
		} else {
			superRels = new LinkedHashSet<>();
			class2superClasses.put(aClass, superRels);
		}

		// Super class inheritance might be shortcut
		for (org.eclipse.ocl.pivot.@NonNull Class superClass : ClassUtil.nullFree(aClass.getSuperClasses())) {
			//superClass = mManager.getPrimaryClass(superClass);
			superRels.add(superClass);
			superRels.addAll(computeClass2SuperClasses(superClass));
		}

		org.eclipse.ocl.pivot.Package classPackage = ClassUtil.nonNullState(aClass.getOwningPackage());
		org.eclipse.ocl.pivot.Package pPackage = mManager.getPrimaryPackage(classPackage);
		if (!processedPackage.contains(pPackage) &&
				! packageToProcess.contains(pPackage)) {
			packageToProcess.add(pPackage);
		}
		return superRels;
	}

	private void computeClass2SubClasses(org.eclipse.ocl.pivot.Class aClass) {
		Set<org.eclipse.ocl.pivot.@NonNull Class> superClasses = class2superClasses.get(aClass);
		if (superClasses != null) {
			for (org.eclipse.ocl.pivot.Class superClass : superClasses) {
				if (aClass.getSuperClasses().contains(superClass)) {
					Set<org.eclipse.ocl.pivot.Class> directSubClasses = class2directSubClasses.get(superClass);
					if (directSubClasses == null) {
						directSubClasses = new LinkedHashSet<>();
						class2directSubClasses.put(superClass, directSubClasses);
					}
					directSubClasses.add(aClass);
				}

				Set<org.eclipse.ocl.pivot.Class> allSubClasses = class2allSubClasses.get(superClass);
				if (allSubClasses == null) {
					allSubClasses = new LinkedHashSet<>();
					class2allSubClasses.put(superClass, allSubClasses);
				}
				allSubClasses.add(aClass);
			}
		}
	}

	private void computeClass2ContainerClasses(org.eclipse.ocl.pivot.@NonNull Class aClass) {

		for (@NonNull Property property : ClassUtil.nullFree(aClass.getOwnedProperties())) {
			Type propType = getType(property);
			if (property.isIsComposite() && propType instanceof org.eclipse.ocl.pivot.Class) {
				org.eclipse.ocl.pivot.Class isClass = propType.isClass();
				assert isClass != null;
				addContainerClassForTypeAndSubtypes(aClass, property, isClass);
			}
		}
	}

	public @NonNull EnvironmentFactory getEnvironmentFactory() {
		return mManager.getEnvironmentFactory();
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

	protected @NonNull Type getType(@NonNull TypedElement typedElement) {
		Type type = typedElement.getType();
		if (type instanceof CollectionType) {
			type = ((CollectionType) type).getElementType();
		}
		return ClassUtil.nonNullState(type);
	}

	private void addContainerClassForTypeAndSubtypes(org.eclipse.ocl.pivot.@NonNull Class containerClass, @NonNull Property containmentProperty, org.eclipse.ocl.pivot.@NonNull Class type) {

		//type = mManager.getPrimaryClass(type);
		Set<@NonNull ContainerClass> detailedContainerClasses = class2detailedContainerClasses.get(type);
		Set<org.eclipse.ocl.pivot.@NonNull Class> containerClasses = class2containerClasses.get(type);
		if (detailedContainerClasses == null) {
			detailedContainerClasses = new LinkedHashSet<>();
			class2detailedContainerClasses.put(type, detailedContainerClasses);
		}
		if (containerClasses == null) {
			containerClasses = new LinkedHashSet<>();
			class2containerClasses.put(type, containerClasses);
		}

		detailedContainerClasses.add(new ContainerClass(containerClass, containmentProperty));
		containerClasses.add(containerClass);

		for (org.eclipse.ocl.pivot.Class subType : getDirectSubClasses(type)) {
			addContainerClassForTypeAndSubtypes(containerClass, containmentProperty, subType);
		}
	}
	//	public boolean typeIsSupertypeOf(Class t1, Class t2) {
	//		Type primaryT1 = mManager.getPrimaryClass(t1);
	//		Type primaryT2 = mManager.getPrimaryClass(t2);
	//		return class2superClasses.get(primaryT1).contains(primaryT2);
	//	}


	public @NonNull Set<org.eclipse.ocl.pivot.@NonNull Class> getAllSuperClasses(org.eclipse.ocl.pivot.@NonNull Class type) {
		Type primaryType = mManager.getPrimaryClass(type);
		Set<org.eclipse.ocl.pivot.@NonNull Class> allSuperClasses = class2superClasses.get(primaryType);
		return allSuperClasses == null ? EMPTY_CLASS_SET
			: ClassUtil.nonNullState(Collections.<org.eclipse.ocl.pivot.@NonNull Class>unmodifiableSet(allSuperClasses));
	}

	public @NonNull Set<org.eclipse.ocl.pivot.@NonNull Class> getAllSubClasses(org.eclipse.ocl.pivot.@NonNull Class type) {
		Type primaryType = mManager.getPrimaryClass(type);
		Set<org.eclipse.ocl.pivot.@NonNull Class> allSubClasses = class2allSubClasses.get(primaryType);
		return allSubClasses == null ? EMPTY_CLASS_SET
			: ClassUtil.nonNullState(Collections.<org.eclipse.ocl.pivot.@NonNull Class>unmodifiableSet(allSubClasses));
	}

	public @NonNull Set<org.eclipse.ocl.pivot.@NonNull Class> getDirectSubClasses(org.eclipse.ocl.pivot.@NonNull Class type) {
		Type primaryType = mManager.getPrimaryClass(type);
		Set<org.eclipse.ocl.pivot.@NonNull Class> directSubClasses = class2directSubClasses.get(primaryType);
		return directSubClasses == null ? EMPTY_CLASS_SET
			: ClassUtil.nonNullState(Collections.<org.eclipse.ocl.pivot.@NonNull Class>unmodifiableSet(directSubClasses));
	}

	public @NonNull Set<org.eclipse.ocl.pivot.@NonNull Class> getContainerClasses(org.eclipse.ocl.pivot.@NonNull Class type) {
		Type primaryType = mManager.getPrimaryClass(type);
		Set<org.eclipse.ocl.pivot.@NonNull Class> containerClasses = class2containerClasses.get(primaryType);
		return containerClasses == null ? EMPTY_CLASS_SET
			: ClassUtil.nonNullState(Collections.<org.eclipse.ocl.pivot.@NonNull Class>unmodifiableSet(containerClasses));
	}

	public @NonNull Set<@NonNull ContainerClass> getDetailedContainerClasses(org.eclipse.ocl.pivot.@NonNull Class type) {
		Type primaryType = mManager.getPrimaryClass(type);
		Set<@NonNull ContainerClass> containerClasses = class2detailedContainerClasses.get(primaryType);
		return ClassUtil.nonNullState(containerClasses == null ? Collections.<@NonNull ContainerClass>emptySet()
			: Collections.<@NonNull ContainerClass>unmodifiableSet(containerClasses));
	}
}
