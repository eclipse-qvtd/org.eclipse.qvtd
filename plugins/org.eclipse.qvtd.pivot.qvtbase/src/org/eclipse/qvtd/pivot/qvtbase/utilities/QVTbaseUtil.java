/*******************************************************************************
 * Copyright (c) 2010,2011 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtbase.utilities;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.internal.scoping.EnvironmentView;
import org.eclipse.qvtd.pivot.qvtbase.BaseModel;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;

public class QVTbaseUtil
{
	public static <T extends NamedElement> void addAllNamedElements(@NonNull EnvironmentView environmentView, @NonNull Iterable<T> namedElements) {
		String name = environmentView.getName();
		if (name != null) {
			for (T namedElement : namedElements) {
				if ((namedElement != null) && name.equals(namedElement.getName())) {
					environmentView.addElement(name, namedElement);
				}
			}
		}
		else {
			for (T namedElement : namedElements) {
				if (namedElement != null) {
					environmentView.addNamedElement(namedElement);
				}
			}
		}
	}

	/**
	 * Return the closure of typedModel and its dependsOn.
	 */
	public static @NonNull Set<TypedModel> getAllTypedModels(@NonNull TypedModel typedModel) {
		Set<TypedModel> allTypedModels = new HashSet<TypedModel>();
		getAllTypedModelsInternal(allTypedModels, typedModel);
		return allTypedModels;
	}

	private static void getAllTypedModelsInternal(@NonNull Set<TypedModel> allTypedModels, @NonNull TypedModel typedModel) {
		if (allTypedModels.add(typedModel)) {
			for (@SuppressWarnings("null")@NonNull TypedModel dependsOn : typedModel.getDependsOn()) {
				getAllTypedModelsInternal(allTypedModels, dependsOn);
			}
		}
	}

	/**
	 * Return the closure of transformation.modelParameter.usedPackages and their importedPackages.
	 */
	public static @NonNull Set<org.eclipse.ocl.pivot.Package> getAllUsedPackages(@NonNull Transformation transformation) {
		Set<org.eclipse.ocl.pivot.Package> allPackages = new HashSet<org.eclipse.ocl.pivot.Package>();
		for (@SuppressWarnings("null")@NonNull TypedModel typedModel : transformation.getModelParameter()) {
			getAllUsedPackagesInternal(allPackages, typedModel);
		}
		return allPackages;
	}

	/**
	 * Return the closure of typedModel.usedPackages and their importedPackages.
	 */
	public static @NonNull Set<org.eclipse.ocl.pivot.Package> getAllUsedPackages(@NonNull TypedModel typedModel) {
		Set<org.eclipse.ocl.pivot.Package> allUsedPackages = new HashSet<org.eclipse.ocl.pivot.Package>();
		getAllUsedPackagesInternal(allUsedPackages, typedModel);
		return allUsedPackages;
	}

	private static void getAllUsedPackagesInternal(@NonNull Set<org.eclipse.ocl.pivot.Package> allUsedPackages,
			@NonNull TypedModel typedModel) {
		getAllUsedPackagesInternal(allUsedPackages, typedModel.getUsedPackage());
		for (@SuppressWarnings("null")@NonNull TypedModel dependsOn : typedModel.getDependsOn()) {
			getAllUsedPackagesInternal(allUsedPackages, dependsOn);
		}
	}

	private static void getAllUsedPackagesInternal(@NonNull Set<org.eclipse.ocl.pivot.Package> allUsedPackages,
			@NonNull Iterable<org.eclipse.ocl.pivot.Package> moreUsedPackages) {
		for (org.eclipse.ocl.pivot.Package usedPackage : moreUsedPackages) {
			if (allUsedPackages.add(usedPackage)) {
				getAllUsedPackagesInternal(allUsedPackages, usedPackage.getImportedPackages());
			}
		}
	}

	public static @Nullable Domain getContainingDomain(@Nullable EObject eObject) {
		for ( ; eObject != null; eObject = eObject.eContainer()) {
			if (eObject instanceof Domain) {
				return (Domain) eObject;
			}
		}
		return null;
	}

	public static @Nullable BaseModel getContainingModel(@Nullable EObject eObject) {
		for ( ; eObject != null; eObject = eObject.eContainer()) {
			if (eObject instanceof BaseModel) {
				return (BaseModel) eObject;
			}
		}
		return null;
	}

	public static @Nullable Rule getContainingRule(@Nullable EObject eObject) {
		for ( ; eObject != null; eObject = eObject.eContainer()) {
			if (eObject instanceof Rule) {
				return (Rule) eObject;
			}
		}
		return null;
	}

	public static @Nullable Transformation getContainingTransformation(@Nullable EObject eObject) {
		for ( ; eObject != null; eObject = eObject.eContainer()) {
			if (eObject instanceof Transformation) {
				return (Transformation) eObject;
			}
		}
		return null;
	}
}