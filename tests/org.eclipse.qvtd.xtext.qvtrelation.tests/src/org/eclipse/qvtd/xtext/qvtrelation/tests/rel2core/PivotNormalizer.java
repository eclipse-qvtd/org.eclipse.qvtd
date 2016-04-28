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
import java.util.List;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.xtext.tests.XtextTestCase.Normalizer;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.qvtd.xtext.qvtimperative.tests.ModelNormalizer;

public class PivotNormalizer implements ModelNormalizer
{
	public static final @NonNull PivotNormalizer INSTANCE = new PivotNormalizer();

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
			ECollections.sort((EList<NamedElement>)(Object)asPackage.getOwnedClasses(), NameUtil.NAMEABLE_COMPARATOR);
			ECollections.sort((EList<NamedElement>)(Object)asPackage.getOwnedPackages(), NameUtil.NAMEABLE_COMPARATOR);
		}
	}

	public @NonNull List<Normalizer> normalize(@NonNull Resource resource) {
		List<Normalizer> normalizers = new ArrayList<Normalizer>();
		for (TreeIterator<EObject> tit = resource.getAllContents(); tit.hasNext(); ) {
			EObject eObject = tit.next();
			if (eObject instanceof org.eclipse.ocl.pivot.Package) {
				normalizers.add(new PackageNormalizer((org.eclipse.ocl.pivot.Package)eObject));
			}
			else if (eObject instanceof org.eclipse.ocl.pivot.Class) {
				normalizers.add(new ClassNormalizer((org.eclipse.ocl.pivot.Class)eObject));
			}
		}
		EList<NamedElement> contents = (EList<NamedElement>)(Object)resource.getContents();
		ECollections.sort(contents, NameUtil.NAMEABLE_COMPARATOR);
		for (Normalizer normalizer : normalizers) {
			normalizer.normalize();
		}
		return normalizers;
	}
}