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
package org.eclipse.qvtd.compiler.internal.qvtm2qvts;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.CompleteModel;
import org.eclipse.ocl.pivot.CompletePackage;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.internal.manager.MetamodelManagerInternal;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;

import com.google.common.collect.Sets;

/**
 * InheritanceAnalysis provides an analysis of the transitive super and sub class relationships in the EnvironmentFactory's resources.
 */
public class InheritanceAnalysis
{
	protected final @NonNull EnvironmentFactory environmentFactory;
	protected final @NonNull CompleteModel completeModel;

	/**
	 * Map from a complete class to the closure of all its super classes, excluding the complete class itself.
	 */
	private final @NonNull Map<@NonNull CompleteClass, @NonNull Set<@NonNull CompleteClass>> class2allSuperClasses = new HashMap<>();

	/**
	 * Map from a complete class to the closure of all its sub classes, including the complete class itself.
	 */
	private final @NonNull Map<@NonNull CompleteClass, @NonNull Set<@NonNull CompleteClass>> class2allSelfAndSubClasses = new HashMap<>();

	public InheritanceAnalysis(@NonNull EnvironmentFactory environmentFactory) {
		this.environmentFactory = environmentFactory;
		this.completeModel = environmentFactory.getCompleteModel();
		MetamodelManagerInternal metamodelManager = (MetamodelManagerInternal)environmentFactory.getMetamodelManager();
		//
		//	Ensure metamodels are loaded.
		//
		metamodelManager.getASmetamodel();
		//
		//	Populate the class2superClass map, and initialize class2subClass to 'self'.
		//
		ResourceSet resourceSet = metamodelManager.getASResourceSet();
		for (@NonNull Resource resource : ClassUtil.nullFree(resourceSet.getResources())) {
			for (EObject root : resource.getContents()) {
				if (root instanceof Model) {
					computeCompleteSuperClasses(ClassUtil.nullFree(((Model)root).getOwnedPackages()));
				}
			}
		}
		//
		//	Accumulate class2subClass by inverting class2superClass.
		//
		for (@NonNull CompleteClass completeClass : class2allSuperClasses.keySet()) {
			computeClass2SubClasses(completeClass);
		}
	}

	private void computeCompleteSuperClasses(@NonNull Iterable<org.eclipse.ocl.pivot.@NonNull Package> asPackages) {
		for (org.eclipse.ocl.pivot.@NonNull Package asPackage : asPackages) {
			CompletePackage completePackage = completeModel.getCompletePackage(asPackage);
			for (@NonNull CompleteClass completeClass : ClassUtil.nullFree(completePackage.getOwnedCompleteClasses())) {
				class2allSuperClasses.put(completeClass, Sets.newHashSet(completeClass.getProperSuperCompleteClasses()));
				class2allSelfAndSubClasses.put(completeClass, Sets.newHashSet(completeClass));
			}
			computeCompleteSuperClasses(ClassUtil.nullFree(asPackage.getOwnedPackages()));
		}
	}

	/**
	 * Register completeClass as a sub-class of all its super-classes. (It is already a sub-class ot itself.)
	 */
	private void computeClass2SubClasses(@NonNull CompleteClass completeClass) {
		Set<@NonNull CompleteClass> superCompleteClasses = class2allSuperClasses.get(completeClass);
		assert superCompleteClasses != null;
		for (@NonNull CompleteClass superCompleteClass : superCompleteClasses) {
			Set<@NonNull CompleteClass> allSelfAndSubClasses = class2allSelfAndSubClasses.get(superCompleteClass);
			assert allSelfAndSubClasses != null;
			allSelfAndSubClasses.add(completeClass);
		}
	}

	public @NonNull Set<@NonNull CompleteClass> getAllCompleteClasses() {
		return class2allSuperClasses.keySet();
	}

	public @NonNull Set<@NonNull CompleteClass> getAllSelfAndSubClasses(@NonNull CompleteClass completeClass) {
		Set<@NonNull CompleteClass> allSubClasses = class2allSelfAndSubClasses.get(completeClass);
		assert allSubClasses != null;
		return allSubClasses;
	}

	public @NonNull Set<@NonNull CompleteClass> getAllSuperAndSelfAndSubClasses(@NonNull CompleteClass completeClass) {
		Set<@NonNull CompleteClass> result = new HashSet<>();
		Set<@NonNull CompleteClass> allSuperClasses = class2allSuperClasses.get(completeClass);
		assert allSuperClasses != null;
		result.addAll(allSuperClasses);
		Set<@NonNull CompleteClass> allSubClasses = class2allSelfAndSubClasses.get(completeClass);
		assert allSubClasses != null;
		result.addAll(allSubClasses);
		return result;
	}

	public @NonNull EnvironmentFactory getEnvironmentFactory() {
		return environmentFactory;
	}
}
