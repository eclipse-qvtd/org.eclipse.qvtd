/**
 * Copyright (c) 2015, 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.qvtd.xtext.qvtrelation.tests;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.xtext.tests.XtextTestCase.Normalizer;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.qvtd.xtext.qvtbase.tests.ModelNormalizer;

/**
 * Families2PersonsNormalizer normalises the results of the Families2Persons transformation.
 *
 * Even though everything is ordered in the input/output model, the edges/incoming/outgoing lists can be independently ordered, and only
 * the edges order is preserved in the middle model.
 */
public class Families2PersonsNormalizer implements ModelNormalizer
{
	public static final @NonNull Families2PersonsNormalizer INSTANCE = new Families2PersonsNormalizer();

	protected static class PersonComparator implements Comparator<EObject>
	{
		private final @NonNull EClass femaleClass;
		private final @NonNull EAttribute personFullName;

		public PersonComparator(@NonNull EClass femaleClass, @NonNull EAttribute personFullName) {
			this.femaleClass = femaleClass;
			this.personFullName = personFullName;
		}

		@Override
		public int compare(EObject o1, EObject o2) {
			if (femaleClass.isInstance(o1)) {
				if (!femaleClass.isInstance(o2)) {
					return 1;
				}
			}
			else {
				if (femaleClass.isInstance(o2)) {
					return -1;
				}
			}
			String n1 = (String) o1.eGet(personFullName);
			String n2 = (String) o2.eGet(personFullName);
			return ClassUtil.safeCompareTo(n1, n2);
		}
	}

	@Override
	public @NonNull List<@NonNull Normalizer> normalize(@NonNull Resource resource) {
		EObject eRoot = resource.getContents().get(0);
		EPackage ePackage = eRoot.eClass().getEPackage();
		EClass femaleClass = (EClass) ePackage.getEClassifier("Female");
		assert femaleClass != null;
		EClass maleClass = (EClass) ePackage.getEClassifier("Male");
		assert maleClass != null;
		EClass personClass = (EClass) ePackage.getEClassifier("Person");
		assert personClass != null;
		EAttribute personFullName = (EAttribute) personClass.getEStructuralFeature("fullName");
		assert personFullName != null;
		PersonComparator personComparator = new PersonComparator(femaleClass, personFullName);
		ECollections.sort(resource.getContents(), personComparator);
		List<@NonNull Normalizer> normalizers = new ArrayList<>();
		return normalizers;
	}
}