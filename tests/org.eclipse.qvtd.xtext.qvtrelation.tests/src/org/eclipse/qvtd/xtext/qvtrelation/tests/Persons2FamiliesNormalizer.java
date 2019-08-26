/**
 * Copyright (c) 2015, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.qvtd.xtext.qvtrelation.tests;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
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
public class Persons2FamiliesNormalizer implements ModelNormalizer
{
	public static final @NonNull Persons2FamiliesNormalizer INSTANCE = new Persons2FamiliesNormalizer();

	protected static class FamilyComparator implements Comparator<@NonNull EObject>
	{
		private final @NonNull EClass familyClass;
		private final @NonNull EAttribute familyName;
		private final @NonNull EReference familyFather;
		private final @NonNull EReference familyMother;
		private final @NonNull EReference familySons;
		private final @NonNull EReference familyDaughters;
		private final @NonNull EAttribute familyMemberName;
		private final @NonNull Map<@NonNull EObject, @NonNull String> family2id = new HashMap<>();

		public FamilyComparator(@NonNull EClass familyClass, @NonNull EAttribute familyName, @NonNull EReference familyFather, @NonNull EReference familyMother, @NonNull EReference familySons, @NonNull EReference familyDaughters, @NonNull EAttribute familyMemberName) {
			this.familyClass = familyClass;
			this.familyName = familyName;
			this.familyFather = familyFather;
			this.familyMother = familyMother;
			this.familySons = familySons;
			this.familyDaughters = familyDaughters;
			this.familyMemberName = familyMemberName;
		}

		@Override
		public int compare(@NonNull EObject o1, @NonNull EObject o2) {
			if (familyClass.isInstance(o1)) {
				if (!familyClass.isInstance(o2)) {
					return 1;
				}
			}
			else {
				if (familyClass.isInstance(o2)) {
					return -1;
				}
			}
			String n1 = getId(o1);
			String n2 = getId(o2);
			return ClassUtil.safeCompareTo(n1, n2);
		}

		@SuppressWarnings("unchecked")
		private @NonNull String getId(@NonNull EObject o) {
			String id = family2id.get(o);
			if (id == null) {
				StringBuilder s = new StringBuilder();
				s.append(o.eGet(familyName));
				s.append("=");
				EObject father = (EObject)o.eGet(familyFather);
				if (father != null) {
					s.append(father.eGet(familyMemberName));
				}
				s.append("=");
				EObject mother = (EObject)o.eGet(familyMother);
				if (mother != null) {
					s.append(mother.eGet(familyMemberName));
				}
				s.append("=");
				for (EObject eObject : (Collection<EObject>)o.eGet(familySons)) {
					s.append("-");
					s.append(String.valueOf(eObject.eGet(familyMemberName)));
				}
				s.append("=");
				for (EObject eObject : (Collection<EObject>)o.eGet(familyDaughters)) {
					s.append("-");
					s.append(String.valueOf(eObject.eGet(familyMemberName)));
				}
				id = s.toString();
				family2id.put(o, id);
			}
			return id;
		}
	}

	@Override
	public @NonNull List<@NonNull Normalizer> normalize(@NonNull Resource resource) {
		EObject eRoot = resource.getContents().get(0);
		EPackage ePackage = eRoot.eClass().getEPackage();
		EClass familyRegisterClass = (EClass) ePackage.getEClassifier("FamilyRegister");
		assert familyRegisterClass != null;
		EClass familyClass = (EClass) ePackage.getEClassifier("Family");
		assert familyClass != null;
		EClass familyMemberClass = (EClass) ePackage.getEClassifier("FamilyMember");
		assert familyMemberClass != null;
		EReference familyRegisterFamilies = (EReference) familyRegisterClass.getEStructuralFeature("families");
		assert familyRegisterFamilies != null;
		EAttribute familyName = (EAttribute) familyClass.getEStructuralFeature("name");
		assert familyName != null;
		EReference familyFather = (EReference) familyClass.getEStructuralFeature("father");
		assert familyFather != null;
		EReference familyMother = (EReference) familyClass.getEStructuralFeature("mother");
		assert familyMother != null;
		EReference familySons = (EReference) familyClass.getEStructuralFeature("sons");
		assert familySons != null;
		EReference familyDaughters = (EReference) familyClass.getEStructuralFeature("daughters");
		assert familyDaughters != null;
		EAttribute familyMemberName = (EAttribute) familyMemberClass.getEStructuralFeature("name");
		assert familyMemberName != null;
		FamilyComparator familyComparator = new FamilyComparator(familyClass, familyName, familyFather, familyMother, familySons, familyDaughters, familyMemberName);
		for (EObject eObject : resource.getContents()) {
			ECollections.sort((EList<EObject>)eObject.eGet(familyRegisterFamilies), familyComparator);
		}
		List<@NonNull Normalizer> normalizers = new ArrayList<>();
		return normalizers;
	}
}