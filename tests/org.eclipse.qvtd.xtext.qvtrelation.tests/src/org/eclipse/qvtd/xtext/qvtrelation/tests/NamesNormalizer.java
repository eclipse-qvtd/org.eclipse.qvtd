/**
 * Copyright (c) 2015, 2019 Willink Transformations and others.
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
import org.eclipse.ocl.pivot.utilities.TreeIterable;
import org.eclipse.qvtd.xtext.qvtbase.tests.ModelNormalizer;

/**
 * NamesNormalizer normalises the intermediates of the Persons2Names2Families transformation.
 *
 * Even though everything is ordered in the input/output model, the edges/incoming/outgoing lists can be independently ordered, and only
 * the edges order is preserved in the middle model.
 */
public class NamesNormalizer implements ModelNormalizer
{
	public static final @NonNull NamesNormalizer INSTANCE = new NamesNormalizer();

	protected static class SurnamePlanComparator implements Comparator<@NonNull EObject>
	{
		private final @NonNull EAttribute surnameAttribute;

		public SurnamePlanComparator(@NonNull EAttribute surnameAttribute) {
			this.surnameAttribute = surnameAttribute;
		}

		@Override
		public int compare(@NonNull EObject o1, @NonNull EObject o2) {
			String n1 = (String) o1.eGet(surnameAttribute);
			String n2 = (String) o2.eGet(surnameAttribute);
			return ClassUtil.safeCompareTo(n1, n2);
		}
	}

	protected static class ForenameComparator implements Comparator<@NonNull EObject>
	{
		private final @NonNull EReference familyMemberReference;
		private final @NonNull EAttribute familyMember_nameAttribute;

		public ForenameComparator(@NonNull EReference familyMemberReference, @NonNull EAttribute familyMember_nameAttribute) {
			this.familyMemberReference = familyMemberReference;
			this.familyMember_nameAttribute = familyMember_nameAttribute;
		}

		@Override
		public int compare(@NonNull EObject o1, @NonNull EObject o2) {
			EObject fm1 = (EObject) o1.eGet(familyMemberReference);
			EObject fm2 = (EObject) o2.eGet(familyMemberReference);
			String n1 = (String) fm1.eGet(familyMember_nameAttribute);
			String n2 = (String) fm2.eGet(familyMember_nameAttribute);
			return ClassUtil.safeCompareTo(n1, n2);
		}
	}

	@Override
	public @NonNull List<@NonNull Normalizer> normalize(@NonNull Resource resource) {
		EObject eRoot = resource.getContents().get(0);
		EPackage namesPackage = eRoot.eClass().getEPackage();
		EClass familyGroupClass = (EClass) namesPackage.getEClassifier("FamilyGroup");
		assert familyGroupClass != null;
		EClass namesRegisterClass = (EClass) namesPackage.getEClassifier("NameRegister");
		assert namesRegisterClass != null;
		EClass surnameClass = (EClass) namesPackage.getEClassifier("Surname");
		assert surnameClass != null;
		EClass familyMemberForenameClass = (EClass) namesPackage.getEClassifier("FamilyMemberForename");
		assert familyMemberForenameClass != null;

		EReference familyMemberForename_familyMember = (EReference) familyMemberForenameClass.getEStructuralFeature("familyMember");
		assert familyMemberForename_familyMember != null;
		EReference familyGroup_forenames = (EReference) familyGroupClass.getEStructuralFeature("forenames");
		assert familyGroup_forenames != null;
		EReference namesRegister_surnames = (EReference) namesRegisterClass.getEStructuralFeature("surnames");
		assert namesRegister_surnames != null;
		EAttribute surname_name = (EAttribute) surnameClass.getEStructuralFeature("name");
		assert surname_name != null;

		EClass familyMemberClass = familyMemberForename_familyMember.getEReferenceType();
		assert familyMemberClass != null;
		EAttribute familyMemberForename_name = (EAttribute) familyMemberClass.getEStructuralFeature("name");
		assert familyMemberForename_name != null;

		ForenameComparator forenameComparator = new ForenameComparator(familyMemberForename_familyMember, familyMemberForename_name);
		SurnamePlanComparator surnameComparator = new SurnamePlanComparator(surname_name);

		Map<@NonNull EList<EObject>, Comparator<@NonNull EObject>> eCollection2comparator = new HashMap<>();
		for (EObject eObject : new TreeIterable(resource)) {
			if (namesRegisterClass.isInstance(eObject)) {
				@SuppressWarnings("unchecked")
				@NonNull EList<@NonNull EObject> surnames = (@NonNull EList<@NonNull EObject>)eObject.eGet(namesRegister_surnames);
				eCollection2comparator.put(surnames, surnameComparator);
			}
			else if (familyGroupClass.isInstance(eObject)) {
				@SuppressWarnings("unchecked")
				@NonNull EList<@NonNull EObject> forenames = (@NonNull EList<@NonNull EObject>)eObject.eGet(familyGroup_forenames);
				eCollection2comparator.put(forenames, forenameComparator);
			}
		}
		for (EList<EObject> eCollection : eCollection2comparator.keySet()) {
			Comparator<@NonNull EObject> comparator = eCollection2comparator.get(eCollection);
			assert comparator != null;
			ECollections.sort(eCollection, comparator);
		}
		List<@NonNull Normalizer> normalizers = new ArrayList<>();
		return normalizers;
	}
}