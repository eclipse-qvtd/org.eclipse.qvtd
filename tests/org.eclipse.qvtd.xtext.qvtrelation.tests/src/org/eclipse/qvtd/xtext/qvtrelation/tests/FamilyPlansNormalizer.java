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
 * Families2PersonsNormalizer normalises the results of the Families2Persons transformation.
 *
 * Even though everything is ordered in the input/output model, the edges/incoming/outgoing lists can be independently ordered, and only
 * the edges order is preserved in the middle model.
 */
public class FamilyPlansNormalizer implements ModelNormalizer
{
	public static final @NonNull FamilyPlansNormalizer INSTANCE = new FamilyPlansNormalizer();

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

	protected static class FamilyMemberPlanComparator implements Comparator<@NonNull EObject>
	{
		private final @NonNull EReference familyMemberReference;
		private final @NonNull EAttribute familyMember_nameAttribute;

		public FamilyMemberPlanComparator(@NonNull EReference familyMemberReference, @NonNull EAttribute familyMember_nameAttribute) {
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
		EPackage familyPlanPackage = eRoot.eClass().getEPackage();
		EClass familyPlanClass = (EClass) familyPlanPackage.getEClassifier("FamilyPlan");
		assert familyPlanClass != null;
		EClass familyPlanningClass = (EClass) familyPlanPackage.getEClassifier("FamilyPlanning");
		assert familyPlanningClass != null;
		EClass surnamePlanClass = (EClass) familyPlanPackage.getEClassifier("SurnamePlan");
		assert surnamePlanClass != null;
		EClass familyMemberPlanClass = (EClass) familyPlanPackage.getEClassifier("FamilyMemberPlan");
		assert familyMemberPlanClass != null;

		EReference familyMemberPlan_familyMember = (EReference) familyMemberPlanClass.getEStructuralFeature("familyMember");
		assert familyMemberPlan_familyMember != null;
		EReference familyPlan_familyMemberPlans = (EReference) familyPlanClass.getEStructuralFeature("familyMemberPlans");
		assert familyPlan_familyMemberPlans != null;
		EReference familyPlanning_surnamePlans = (EReference) familyPlanningClass.getEStructuralFeature("surnamePlans");
		assert familyPlanning_surnamePlans != null;
		EAttribute surnamePlan_name = (EAttribute) surnamePlanClass.getEStructuralFeature("name");
		assert surnamePlan_name != null;

		EClass familyMemberClass = familyMemberPlan_familyMember.getEReferenceType();
		assert familyMemberClass != null;
		EAttribute familyMemberPlan_name = (EAttribute) familyMemberClass.getEStructuralFeature("name");
		assert familyMemberPlan_name != null;

		FamilyMemberPlanComparator familyMemberPlanComparator = new FamilyMemberPlanComparator(familyMemberPlan_familyMember, familyMemberPlan_name);
		SurnamePlanComparator surnamePlanComparator = new SurnamePlanComparator(surnamePlan_name);

		Map<@NonNull EList<EObject>, Comparator<@NonNull EObject>> eCollection2comparator = new HashMap<>();
		for (EObject eObject : new TreeIterable(resource)) {
			if (familyPlanningClass.isInstance(eObject)) {
				eCollection2comparator.put((EList<EObject>)eObject.eGet(familyPlanning_surnamePlans), surnamePlanComparator);
			}
			else if (familyPlanClass.isInstance(eObject)) {
				eCollection2comparator.put((EList<EObject>)eObject.eGet(familyPlan_familyMemberPlans), familyMemberPlanComparator);
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