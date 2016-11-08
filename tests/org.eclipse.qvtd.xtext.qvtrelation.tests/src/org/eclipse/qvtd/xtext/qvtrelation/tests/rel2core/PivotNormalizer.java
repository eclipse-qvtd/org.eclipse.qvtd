/*******************************************************************************
 * Copyright (c) 2016 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtrelation.tests.rel2core;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.xtext.tests.XtextTestCase.Normalizer;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.Nameable;
import org.eclipse.qvtd.xtext.qvtbase.tests.ModelNormalizer;

public class PivotNormalizer implements ModelNormalizer
{
	public static final @NonNull PivotNormalizer INSTANCE = new PivotNormalizer();

	public static final class ToStringComparator implements Comparator<Nameable>
	{
		public static final @NonNull ToStringComparator INSTANCE = new ToStringComparator();

		@Override
		public int compare(Nameable o1, Nameable o2) {
			String n1 = String.valueOf(o1);
			String n2 = String.valueOf(o2);
			return ClassUtil.safeCompareTo(n1, n2);
		}
	}

	protected class ClassNormalizer implements Normalizer
	{
		protected final org.eclipse.ocl.pivot.@NonNull Class asClass;

		public ClassNormalizer(org.eclipse.ocl.pivot.@NonNull Class asClass) {
			this.asClass = asClass;
		}

		@Override
		public void denormalize() {
			throw new UnsupportedOperationException();
		}

		@Override
		public void normalize() {
			ECollections.sort((EList<NamedElement>)(Object)asClass.getOwnedProperties(), NameUtil.NAMEABLE_COMPARATOR);
			ECollections.sort((EList<NamedElement>)(Object)asClass.getOwnedOperations(), NameUtil.NAMEABLE_COMPARATOR);
		}
	}

	protected class ModelNormalizer implements Normalizer
	{
		protected final @NonNull Model asModel;

		public ModelNormalizer(@NonNull Model asModel) {
			this.asModel = asModel;
		}

		@Override
		public void denormalize() {
			throw new UnsupportedOperationException();
		}

		@Override
		public void normalize() {
			ECollections.sort((EList<NamedElement>)(Object)asModel.getOwnedPackages(), NameUtil.NAMEABLE_COMPARATOR);
		}
	}

	protected class PackageNormalizer implements Normalizer
	{
		protected final org.eclipse.ocl.pivot.@NonNull Package asPackage;

		public PackageNormalizer(org.eclipse.ocl.pivot.@NonNull Package asPackage) {
			this.asPackage = asPackage;
		}

		@Override
		public void denormalize() {
			throw new UnsupportedOperationException();
		}

		@Override
		public void normalize() {
			ECollections.sort((EList<NamedElement>)(Object)asPackage.getOwnedClasses(), ToStringComparator.INSTANCE);
			ECollections.sort((EList<NamedElement>)(Object)asPackage.getOwnedPackages(), NameUtil.NAMEABLE_COMPARATOR);
		}
	}

	@Override
	public @NonNull List<@NonNull Normalizer> normalize(@NonNull Resource resource) {
		List<@NonNull Normalizer> normalizers = new ArrayList<>();
		for (TreeIterator<EObject> tit = resource.getAllContents(); tit.hasNext(); ) {
			EObject eObject = tit.next();
			if (eObject instanceof Model) {
				normalizers.add(new ModelNormalizer((Model)eObject));
			}
			else if (eObject instanceof org.eclipse.ocl.pivot.Package) {
				normalizers.add(new PackageNormalizer((org.eclipse.ocl.pivot.Package)eObject));
			}
			else if (eObject instanceof org.eclipse.ocl.pivot.Class) {
				((org.eclipse.ocl.pivot.Class)eObject).setUnspecializedElement(null);		// Suppress transient value
				normalizers.add(new ClassNormalizer((org.eclipse.ocl.pivot.Class)eObject));
			}
		}
		//		EList<NamedElement> contents = (EList<NamedElement>)(Object)resource.getContents();
		//		ECollections.sort(contents, ToStringComparator.INSTANCE);
		for (Normalizer normalizer : normalizers) {
			normalizer.normalize();
		}
		return normalizers;
	}
}