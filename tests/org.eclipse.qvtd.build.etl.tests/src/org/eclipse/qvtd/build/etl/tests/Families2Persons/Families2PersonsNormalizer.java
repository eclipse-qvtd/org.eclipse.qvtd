package org.eclipse.qvtd.build.etl.tests.Families2Persons;

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
import org.eclipse.qvtd.xtext.qvtimperative.tests.ModelNormalizer;

import build.test.families2persons.Persons.PersonsPackage;

/**
 * UpperToLowerNormalizer normalises the results of the UpperToLower transformation.
 * 
 * Even though everything is ordered in the input/output model, the edges/incoming/outgoing lists cn be independently ordered, and only
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

	public @NonNull List<Normalizer> normalize(@NonNull Resource resource) {
		EObject eRoot = resource.getContents().get(0);
		EPackage ePackage = eRoot.eClass().getEPackage();
		EClass femaleClass = (EClass) ePackage.getEClassifier(PersonsPackage.Literals.FEMALE.getName());
		assert femaleClass != null;
		EClass maleClass = (EClass) ePackage.getEClassifier(PersonsPackage.Literals.MALE.getName());
		assert maleClass != null;
		EClass personClass = (EClass) ePackage.getEClassifier(PersonsPackage.Literals.PERSON.getName());
		assert personClass != null;
		@NonNull EAttribute personFullName = (EAttribute) personClass.getEStructuralFeature(PersonsPackage.Literals.PERSON__FULL_NAME.getName());
		assert personFullName != null;
		PersonComparator personComparator = new PersonComparator(femaleClass, personFullName);
		ECollections.sort(resource.getContents(), personComparator);
		List<Normalizer> normalizers = new ArrayList<Normalizer>();
		return normalizers;
	}
}