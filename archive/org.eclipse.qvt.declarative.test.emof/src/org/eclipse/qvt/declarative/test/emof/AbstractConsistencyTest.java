/*******************************************************************************
 * Copyright (c) 2008 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvt.declarative.test.emof;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.EMOFExtendedMetaData;
import org.eclipse.emf.ecore.xmi.impl.EMOFResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.qvt.declarative.ecore.mappings.MappingConfigurationException;
import org.eclipse.qvt.declarative.ecore.mappings.MappingMetaDataRegistry;
import org.eclipse.qvt.declarative.ecore.mappings.MappingUtils;
import org.eclipse.qvt.declarative.ecore.utils.EcoreUtils;
import org.eclipse.qvt.declarative.test.emof.omg20070708EMOF.OMG20070708EMOFModels;
import org.eclipse.qvt.declarative.test.emof.omg20070708Ecore.OMG20070708EcoreModels;
import org.eclipse.qvt.declarative.test.emof.omg20070708Rose.OMG20070708RoseModels;
import org.eclipse.qvt.declarative.test.emof.rose.RoseModels;
import org.eclipse.qvt.declarative.test.emof.tools.EcoreDifference;
import org.eclipse.qvt.declarative.test.emof.tools.EcoreEquivalenceHelper;
import org.eclipse.qvt.declarative.test.emof.tools.EquivalenceHelper;
import org.eclipse.qvt.declarative.test.emof.tools.EquivalenceMap;

public abstract class AbstractConsistencyTest extends AbstractTestCase
{
	public static final String EMOF_PACKAGE_NAME = "EMOF";
	public static final String ESSENTIAL_OCL_PACKAGE_NAME = "EssentialOCL";
	public static final String IMPERATIVE_OCL_PACKAGE_NAME = "ImperativeOCL";
	public static final String QVTBASE_PACKAGE_NAME = "QVTBase";
	public static final String QVTCORE_PACKAGE_NAME = "QVTCore";
	public static final String QVTOPERATIONAL_PACKAGE_NAME = "QVTOperational";
	public static final String QVTRELATION_PACKAGE_NAME = "QVTRelation";
	public static final String QVTTEMPLATE_PACKAGE_NAME = "QVTTemplate";

	public static String loggedPackageName = null;

	protected static class GeneratedEcoreEquivalenceHelper extends EcoreEquivalenceHelper
	{	
		public GeneratedEcoreEquivalenceHelper(HTMLStream htmlStream, PrintStream logStream) {
			super(htmlStream, logStream);
		}
 
		@Override
		public boolean isComparable(EClass eClass, EStructuralFeature eFeature, EObject leftObject, EObject rightObject) {
			if (eFeature == EcorePackage.Literals.ECLASSIFIER__INSTANCE_CLASS_NAME)
				return false;
			if (eFeature == EcorePackage.Literals.ECLASSIFIER__INSTANCE_TYPE_NAME)
				return false;
			if (eFeature == EcorePackage.Literals.ECLASS__EGENERIC_SUPER_TYPES)
				return false;
			if (eFeature == EcorePackage.Literals.ETYPED_ELEMENT__EGENERIC_TYPE)
				return false;
			return super.isComparable(eClass, eFeature, leftObject, rightObject);
		}

		@Override
		public boolean isOrdered(EStructuralFeature feature) {
			if (feature == EcorePackage.Literals.EPACKAGE__ECLASSIFIERS)
				return false;
			if (feature == EcorePackage.Literals.ECLASS__ESTRUCTURAL_FEATURES)
				return false;
			if (feature == EcorePackage.Literals.ECLASS__ESUPER_TYPES)
				return false;
			return super.isOrdered(feature);
		}
	}

	protected static class OMGEcoreEquivalenceHelper extends GeneratedEcoreEquivalenceHelper
	{
		public OMGEcoreEquivalenceHelper(HTMLStream htmlStream, PrintStream logStream) {
			super(htmlStream, logStream);
		}

		@Override
		public boolean isComparable(EClass eClass, EStructuralFeature eFeature, EObject leftObject, EObject rightObject) {
			if (eFeature == EcorePackage.Literals.EREFERENCE__RESOLVE_PROXIES)
				return false;
			return super.isComparable(eClass, eFeature, leftObject, rightObject);
		}
	}

	public static class InconsistencyKey implements Comparable<InconsistencyKey> {
		ENamedElement element;
		EStructuralFeature feature;
		
		public InconsistencyKey(ENamedElement element, EStructuralFeature feature) {
			super();
			this.element = element;
			this.feature = feature;
		}

		@Override
		public boolean equals(Object obj) {
			if (!(obj instanceof InconsistencyKey))
				return false;
			InconsistencyKey that = (InconsistencyKey) obj;
			if ((element != null) != (that.element != null))
				return false;
			if ((feature != null) != (that.feature != null))
				return false;
			if ((element != null) && !element.equals(that.element))
				return false;
			if ((feature != null) && !feature.equals(that.feature))
				return false;
			return true;
		}

		@Override
		public int hashCode() {
			return (element != null ? element.hashCode() : 0)
				 + (feature != null ? feature.hashCode() : 0);
		}		
		
		@Override
		public String toString() {
			return MappingUtils.formatFullName(element) + "[" + MappingUtils.formatFullName(feature) + "]";
		}

		public int compareTo(InconsistencyKey that) {
			if ((element != null) && !element.equals(that.element))
				return element == null ? -1 : +1;
			if (element != null) {
				int value = element.getName().compareTo(that.element.getName());
				if (value != 0)
					return value;
			}
			if ((feature != null) && !feature.equals(that.feature))
				return feature == null ? -1 : +1;
			if (feature != null)
				return feature.getName().compareTo(that.feature.getName());
			else
				return 0;
		}
	}

	public static class InconsistencyValue {
		Object ecoreValue;
		Object adaptingValue;
		
		public InconsistencyValue(Object ecoreValue, Object adaptingValue) {
			super();
			this.ecoreValue = ecoreValue;
			this.adaptingValue = adaptingValue;
		}

		@Override
		public boolean equals(Object obj) {
			if (!(obj instanceof InconsistencyValue))
				return false;
			InconsistencyValue that = (InconsistencyValue) obj;
			if ((ecoreValue != null) != (that.ecoreValue != null))
				return false;
			if ((adaptingValue != null) != (that.adaptingValue != null))
				return false;
			if ((ecoreValue != null) && !ecoreValue.equals(that.ecoreValue))
				return false;
			if ((adaptingValue != null) && !adaptingValue.equals(that.adaptingValue))
				return false;
			return true;
		}

		@Override
		public int hashCode() {
			return (ecoreValue != null ? ecoreValue.hashCode() : 0)
			 	 + (adaptingValue != null ? adaptingValue.hashCode() : 0);
		}
		
		@Override
		public String toString() {
			return "{ ecore: " + MappingUtils.formatFullName(ecoreValue) + ", adapted: " + MappingUtils.formatFullName(adaptingValue) + " }";
		}
	}

	public static class ConsistencyValidator implements MappingMetaDataRegistry.ConsistencyValidator
	{
		private Map<InconsistencyKey, InconsistencyValue> ecoreInconsistencies = new HashMap<InconsistencyKey, InconsistencyValue>();
		private Map<InconsistencyKey, InconsistencyValue> adaptingInconsistencies = new HashMap<InconsistencyKey, InconsistencyValue>();

		public void assertEquals(Map<InconsistencyKey, InconsistencyValue> expectedEcoreInconsistencies, Map<InconsistencyKey, InconsistencyValue> expectedAdaptingInconsistencies) {
			StringBuffer errors = null;
			errors = assertEmpty(errors, "Extra Ecore", ecoreInconsistencies, expectedEcoreInconsistencies);
			errors = assertEmpty(errors, "Missing Ecore", expectedEcoreInconsistencies, ecoreInconsistencies);
			errors = assertEmpty(errors, "Extra Adapting", adaptingInconsistencies, expectedAdaptingInconsistencies);
			errors = assertEmpty(errors, "Missing Adapting", expectedAdaptingInconsistencies, adaptingInconsistencies);
			if (errors != null)
				AbstractConsistencyTest.fail("Model inconsistencies" + errors.toString());
		}

		private StringBuffer assertEmpty(StringBuffer errors, String prefix, Map<InconsistencyKey, InconsistencyValue> test, Map<InconsistencyKey, InconsistencyValue> reference) {
			Set<InconsistencyKey> residualKeys = new HashSet<InconsistencyKey>(test.keySet());
			for (InconsistencyKey referenceKey : reference.keySet()) {
				InconsistencyValue testValue = test.get(referenceKey);
				if (testValue != null) {
					InconsistencyValue referenceValue = reference.get(referenceKey);
					if (testValue.equals(referenceValue))
						residualKeys.remove(referenceKey);
				}
			}
			residualKeys.removeAll(reference.keySet());
			if (residualKeys.size() > 0) {
				if (errors == null)
					errors = new StringBuffer();
				errors.append("\n  ");
				errors.append(residualKeys.size());
				errors.append(" ");
				errors.append(prefix);
				errors.append(" Inconsistencies");
				List<InconsistencyKey> keys = new ArrayList<InconsistencyKey>(residualKeys);
				Collections.sort(keys);
				for (InconsistencyKey key : keys) {
					errors.append("\n    ");
					errors.append(key);
					errors.append(" = ");
					errors.append(test.get(key));
				}
			}
			return errors;
		}
		
		public void inconsistentClass(EClass ecoreClass, EClass adaptingClass) {
		}

		public void inconsistent(ENamedElement ecoreFeature, ENamedElement adaptingFeature, EStructuralFeature inconsistentFeature, Object ecoreValue, Object adaptingValue) {
			InconsistencyValue newValue = new InconsistencyValue(ecoreValue, adaptingValue);
			if (ecoreFeature != null) {
				InconsistencyKey key = new InconsistencyKey(ecoreFeature, inconsistentFeature);
				InconsistencyValue oldValue = ecoreInconsistencies.get(key);
				if (oldValue == null)
					ecoreInconsistencies.put(key, newValue);
				else if (!oldValue.equals(newValue))			
//					QVTRelationConsistencyTest.assertEquals("Duplicate inconsistency", oldValue, newValue);
					System.out.println("Duplicate ecore inconsistency : " + oldValue + " : " + newValue);
			}
			else if (adaptingFeature != null) {
				InconsistencyKey key = new InconsistencyKey(adaptingFeature, inconsistentFeature);
				InconsistencyValue oldValue = adaptingInconsistencies.get(key);
				if (oldValue == null)
					adaptingInconsistencies.put(key, newValue);
				else if (!oldValue.equals(newValue))			
//					QVTRelationConsistencyTest.assertEquals("Duplicate inconsistency", oldValue, newValue);
					System.out.println("Duplicate adapter inconsistency : " + oldValue + " : " + newValue);
			}
			else
				System.out.println("Unclassified inconsistency : " + newValue);
		}
	}
	
	protected ConsistencyValidator consistencyValidator;
	protected HTMLStream htmlStream = null;

	protected static void changeOfAbstract(Set<EcoreDifference> differences, EquivalenceHelper helper, EClass leftObject) {
		changeOfFeature(differences, helper, leftObject, EcorePackage.Literals.ECLASS__ABSTRACT);
	}

	protected static void changeOfChangeable(Set<EcoreDifference> differences, EquivalenceHelper helper, EStructuralFeature leftObject) {
		changeOfFeature(differences, helper, leftObject, EcorePackage.Literals.ESTRUCTURAL_FEATURE__CHANGEABLE);
	}

	protected static void changeOfContainment(Set<EcoreDifference> differences, EquivalenceHelper helper, EReference object) {
		changeOfFeature(differences, helper, object, EcorePackage.Literals.EREFERENCE__CONTAINMENT);
	}

	protected static void changeOfDefaultValue(Set<EcoreDifference> differences, EquivalenceHelper helper, ETypedElement object) {
		changeOfFeature(differences, helper, object, EcorePackage.Literals.ESTRUCTURAL_FEATURE__DEFAULT_VALUE_LITERAL, helper.getRight(object), "Null right feature");
	}

	protected static void changeOfFeature(Set<EcoreDifference> differences, EquivalenceHelper helper,
			EObject leftObject, EStructuralFeature feature) {
		changeOfFeature(differences, helper, leftObject, feature, helper.getRight(leftObject), "Different objects");
	}

	protected static void changeOfFeature(Set<EcoreDifference> differences, EquivalenceHelper helper,
			EObject leftObject, EStructuralFeature feature, EObject rightObject, String reason) {
		Object left = leftObject != null ? leftObject.eGet(feature) : null;
		Object right = rightObject != null ? rightObject.eGet(feature) : null;
		changeOfFeature(differences, helper, leftObject, feature, left, right, reason);
	}

	private static void changeOfFeature(Set<EcoreDifference> differences, EquivalenceHelper helper, EObject object, EStructuralFeature feature, Object left, Object right, String reason) {
		differences.add(new EcoreDifference(helper, object, feature, left, right, reason));
		helper.println(helper.formatDifference(object, feature, left, right));
	}

	protected static void changeOfInterface(Set<EcoreDifference> differences, EquivalenceHelper helper, EClass object) {
		changeOfFeature(differences, helper, object, EcorePackage.Literals.ECLASS__INTERFACE);
	}

	protected static void changeOfList(Set<EcoreDifference> differences, EquivalenceHelper helper, EObject obj, EReference ref) {
		Object leftList = obj.eGet(ref);
		Object rightList = helper.getRight(obj).eGet(ref);
		differences.add(new EcoreDifference(helper, obj, ref, leftList, null, "Different sizes"));
		helper.println(helper.formatDifference(obj, ref, leftList, rightList));
	}

	protected static void changeOfListObject(Set<EcoreDifference> differences, EquivalenceHelper helper, EObject obj,
			EReference ref, EObject left, EObject right) {
//		changeOfListFeature(differences, helper, obj, ref, left, right, "Different objects");
		differences.add(new EcoreDifference(helper, obj, ref, left, right, "Different objects"));
		helper.println(helper.formatDifference(obj, ref, left, right));
	}

	protected static void changeOfLower(Set<EcoreDifference> differences, EquivalenceHelper helper, ETypedElement object) {
		changeOfFeature(differences, helper, object, EcorePackage.Literals.ETYPED_ELEMENT__LOWER_BOUND);
	}

	protected static void changeOfMappedListObject(Set<EcoreDifference> differences, EquivalenceHelper helper, EClass obj,
			EReference ref, EObject left, EObject right) {
//		changeOfListFeature(differences, helper, obj, ref, left, right, "Different objects");
		differences.add(new EcoreDifference(helper, obj, ref, left, right, "Different mapped objects"));
		helper.println(helper.formatDifference(obj, ref, left, right));
	}

	protected static void changeOfMappedObject(Set<EcoreDifference> differences, EquivalenceHelper helper, EObject leftObject, EReference ref) {
		changeOfFeature(differences, helper, leftObject, ref, helper.getRight(leftObject), "Different mapped objects");
	}

	protected static void changeOfName(Set<EcoreDifference> differences, EquivalenceHelper helper, ENamedElement leftObject) {
		changeOfFeature(differences, helper, leftObject, EcorePackage.Literals.ENAMED_ELEMENT__NAME, helper.getRight(leftObject), "Different objects");
	}

	protected static void changeOfObject(Set<EcoreDifference> differences, EquivalenceHelper helper,
			EObject leftObject, EReference ref, Object leftValue, EPackage rightPackage) {
		changeOfFeature(differences, helper, leftObject, ref, helper.getRight(leftObject), leftValue, "Different objects");
	}

	protected static void changeOfObject(Set<EcoreDifference> differences, EquivalenceHelper helper, EObject leftObject, EReference ref) {
		changeOfFeature(differences, helper, leftObject, ref, helper.getRight(leftObject), "Different objects");
	}
	
	protected static void changeOfOppositeAnnotation(Set<EcoreDifference> differences, EquivalenceHelper helper, EReference object, EStructuralFeature otherObject) {
		String oppositeRoleName = EMOFExtendedMetaData.EMOF_PROPERTY_OPPOSITE_ROLE_NAME_ANNOTATION_SOURCE;
		differences.add(new EcoreDifference(helper, getAnnotation(object, oppositeRoleName), EcorePackage.Literals.EANNOTATION__DETAILS, getAnnotation(object, oppositeRoleName).getDetails(), getAnnotation(otherObject, oppositeRoleName).getDetails(), "Different objects"));
		differences.add(new EcoreDifference(helper, (EObject)getDetail(object, oppositeRoleName, "body"), EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY__VALUE, getDetail(object, oppositeRoleName, "body").getValue(), getDetail(otherObject, oppositeRoleName, "body").getValue(), "Different objects"));
//		StringBuffer s = new StringBuffer();
//		s.append("Unnavigable 'opposite' of '");
//		helper.formatClassAndFeatureName(s, object);
//		s.append("' should be modelled");
//		helper.println(s.toString());
	}

	protected static void changeOfOrdered(Set<EcoreDifference> differences, EquivalenceHelper helper, EObject object) {
		changeOfFeature(differences, helper, object, EcorePackage.Literals.ETYPED_ELEMENT__ORDERED);
	}

	protected static void changeOfPrefix(Set<EcoreDifference> differences, EquivalenceHelper helper, EPackage leftObject) {
		changeOfFeature(differences, helper, leftObject, EcorePackage.Literals.EPACKAGE__NS_PREFIX);
	}

	protected static void changeOfProxyObject(Set<EcoreDifference> differences, EquivalenceHelper helper, EObject leftObject, EReference ref) {
		changeOfFeature(differences, helper, leftObject, ref, helper.getRight(leftObject), "Different proxy URIs");
	}

	protected static void changeOfSize(Set<EcoreDifference> differences, EquivalenceHelper helper, EObject object, EReference ref) {
		differences.add(new EcoreDifference(helper, object, ref, object.eGet(ref), null, "Different sizes"));
	}

	protected static void changeOfTransient(Set<EcoreDifference> differences, EquivalenceHelper helper, EObject object) {
		changeOfFeature(differences, helper, object, EcorePackage.Literals.ESTRUCTURAL_FEATURE__TRANSIENT);
	}

	protected static void changeOfURI(Set<EcoreDifference> differences, EquivalenceHelper helper, EPackage object) {
		changeOfFeature(differences, helper, object, EcorePackage.Literals.EPACKAGE__NS_URI);
	}

	protected static void changeOfUnsettable(Set<EcoreDifference> differences, EquivalenceHelper helper, EStructuralFeature leftObject) {
		changeOfFeature(differences, helper, leftObject, EcorePackage.Literals.ESTRUCTURAL_FEATURE__UNSETTABLE);
	}

	protected static void changeOfUpper(Set<EcoreDifference> differences, EquivalenceHelper helper, ETypedElement object) {
		changeOfFeature(differences, helper, object, EcorePackage.Literals.ETYPED_ELEMENT__UPPER_BOUND);
	}
	
	public void ecore2EmofAdapterConsistencyTest(Map<InconsistencyKey, InconsistencyValue> ecoreInconsistencies, Map<InconsistencyKey, InconsistencyValue> adaptingInconsistencies) throws IOException, MappingConfigurationException {
		consistencyValidator.assertEquals(ecoreInconsistencies, adaptingInconsistencies);
	}

	/**
	 * Verify that the builtInNsURI has the getExpectedGeneratedDifferences()
	 * with respect to the generatedModelFileName.
	 */
	protected void ecore2EmofConsistencyTest(String builtInNsURI, EPackage emofPackage, EPackage... emofPackages) {
		URI builtInURI = URI.createURI(builtInNsURI);
		Resource builtInResource = resourceSet.getResource(builtInURI, true);
		ResourceSet emofResourceSet = new ResourceSetImpl();
		Resource emofResource = emofPackage.eResource();
		emofResourceSet.getResources().add(emofResource);
		for (EPackage anotherEmofPackage : emofPackages) {
			Resource anotherEmofResource = anotherEmofPackage.eResource();
			if (!emofResourceSet.getResources().contains(anotherEmofResource))
				emofResourceSet.getResources().add(anotherEmofResource);
		}
		//
		//	Compare the built-in model with the generated model 
		//
		GeneratedEcoreEquivalenceHelper helper = new GeneratedEcoreEquivalenceHelper(htmlStream, null);
		EquivalenceMap comparator = new EquivalenceMap(helper);
		installEcoreEclipseMappings(comparator, emofResourceSet);		
		comparator.load(builtInResource, emofResource, null);
		//
		if (loggedPackageName != null)
			try {
				helper.setLogStream(new PrintStream("temp/" + loggedPackageName + "2EmofConsistency.log"));
			} catch (FileNotFoundException e) {
				fail(e.getMessage());
			}
		if (htmlStream != null) {
			htmlStream.println("<h2>Ecore-based Model Compliance with respect to the EMOF-based Model</h2>");
			htmlStream.println("The Ecore-based <tt>" + loggedPackageName + "</tt> model exhibits the following differences with respect to its EMOF-based counterpart.");
			htmlStream.println("<p>");
		}
		Set<EcoreDifference> differences = getExpectedEcore2EmofDifferences(helper, getPackage(emofResource, getPackageName()));
		assertDifferencesEquals(comparator, builtInURI, emofResource.getURI(), differences);
	}

	/**
	 * Verify that the builtInNsURI has the getExpectedEmof2OmgEcoreDifferences()
	 * with respect to the omgModelFileName.
	 */
	protected void emof2OmgEcoreConsistencyTest(String builtInNsURI, String omgModelFileName) {
		URI builtInURI = URI.createURI(builtInNsURI);
		URI omgURI = OMG20070708EcoreModels.INSTANCE.getURI(omgModelFileName);
		Resource builtInResource = resourceSet.getResource(builtInURI, true);
		Resource omgResource = loadEcoreResource(omgURI);
		//
		//	Compare the built-in model with the OMG model 
		//
		OMGEcoreEquivalenceHelper helper = new OMGEcoreEquivalenceHelper(htmlStream, null);
		EquivalenceMap comparator = new EquivalenceMap(helper);		
		installEmofOmgMappings(comparator, omgResource.getResourceSet());		
		comparator.load(builtInResource, omgResource, null);
		if (loggedPackageName != null)
			try {
				helper.setLogStream(new PrintStream("temp/" + loggedPackageName + "EcoreConsistency.log"));
			} catch (FileNotFoundException e) {
				fail(e.getMessage());
			}
		if (htmlStream != null) {
			htmlStream.println("<h2>EMOF-based Model Compliance with respect to the OMG Ecore Model</h2>");
			htmlStream.println("The OMG Ecore Models are notionally generated from the OMG QVT Rose Model.");
			htmlStream.println("<p>");
			htmlStream.println("The Eclipse <tt>" + loggedPackageName + "</tt> Model resolves the following errors and anomalies in the corresponding OMG Ecore Model.");
			htmlStream.println("<p>");
		}
		Set<EcoreDifference> differences = getExpectedEmof2OmgEcoreDifferences(helper, getPackage(omgResource, getPackageName().toLowerCase()));
		assertDifferencesEquals(comparator, builtInURI, omgURI, differences);
	}

	/**
	 * Verify that the builtInNsURI has the getExpectedEmof2OmgEmofDifferences()
	 * with respect to the omgModelFileName.
	 */
	protected void emof2OmgEmofConsistencyTest(String builtInNsURI) {
		URI builtInURI = URI.createURI(builtInNsURI);
		URI omgURI = OMG20070708EMOFModels.INSTANCE.getURI("qvt_metamodel.emof");
		Resource builtInResource = resourceSet.getResource(builtInURI, true);
		Resource omgResource = loadEMOFResource(omgURI);
		ResourceSet omgResourceSet = omgResource.getResourceSet();
		String emofPackageName = getPackageName().toLowerCase();
		EPackage emofPackage = getPackage(omgResource, emofPackageName);
		Resource anotherOmgResource = new XMIResourceImpl(URI.createURI("qvt_metamodel.emof-" + emofPackageName));
		omgResourceSet.getResources().add(anotherOmgResource);
		anotherOmgResource.getContents().add(emofPackage);
		//
		//	Compare the built-in model with the OMG model 
		//
		OMGEcoreEquivalenceHelper helper = new OMGEcoreEquivalenceHelper(htmlStream, null)
		{
			@Override
			public boolean isComparable(EClass class1, EStructuralFeature feature, EObject leftObject, EObject rightObject) {
				if (feature == EcorePackage.Literals.ETYPED_ELEMENT__ORDERED) {
					int leftUpper = leftObject != null ? ((ETypedElement)leftObject).getUpperBound() : 1;
					int rightUpper = rightObject != null ? ((ETypedElement)rightObject).getUpperBound() : 1;
					if ((leftUpper <= 1) && (rightUpper <= 1))
						return false;
				}
				return super.isComparable(class1, feature, leftObject, rightObject);
			}
			
		};
		EquivalenceMap comparator = new EquivalenceMap(helper);		
		installEmof2EmofMappings(comparator, omgResourceSet);		
		comparator.load(builtInResource, anotherOmgResource, null);
		if (loggedPackageName != null)
			try {
				helper.setLogStream(new PrintStream("temp/" + loggedPackageName + "EmofConsistency.log"));
			} catch (FileNotFoundException e) {
				fail(e.getMessage());
			}
		if (htmlStream != null) {
			htmlStream.println("<h2>EMOF-based Model Compliance with respect to the OMG EMOF Model</h2>");
			htmlStream.println("The OMG EMOF Model is notionally generated from the OMG QVT Rose Model.");
			htmlStream.println("<p>");
			htmlStream.println("The Eclipse <tt>" + loggedPackageName + "</tt> Model resolves the following errors and anomalies in the corresponding OMG EMOF Model.");
			htmlStream.println("<p>");
			helper.println("The model namespace should be 'http://schema.omg.org/spec/MOF/2.0/emof.xml' rather than 'http://www.schema.omg.org/spec/MOF/2.0/emof.xml'" );
			helper.println("'xmi:type' of 'Boolean' should be 'emof:PrimitiveType' rather than 'emof:Class'" );
			helper.println("'xmi:type' of 'Integer' should be 'emof:PrimitiveType' rather than 'emof:Class'" );
			helper.println("'xmi:type' of 'String' should be 'emof:PrimitiveType' rather than 'emof:Class'" );
			helper.println("'xmi:type' of 'UnlimitedNatural' should be 'emof:PrimitiveType' rather than 'emof:Class'" );
			helper.println("'package' of 'Boolean' should be 'emof' rather than 'primitivetypes'" );
			helper.println("'package' of 'Integer' should be 'emof' rather than 'primitivetypes'" );
			helper.println("'package' of 'String' should be 'emof' rather than 'primitivetypes'" );
			helper.println("'package' of 'UnlimitedNatural' should be 'emof' rather than 'primitivetypes'" );
			htmlStream.println("<p>");
		}
		Set<EcoreDifference> differences = getExpectedEmof2OmgEmofDifferences(helper, emofPackage);
		assertDifferencesEquals(comparator, builtInURI, omgURI, differences);
	}

	/**
	 * Verify that the builtInNsURI has the getExpectedEmof2OmgRoseDifferences()
	 * with respect to the omgModelFileName.
	 */
	protected void emof2OmgRoseConsistencyTest(String builtInNsURI, String omgModelFileName) {
		URI builtInURI = URI.createURI(builtInNsURI);
		URI omgURI = OMG20070708RoseModels.INSTANCE.getURI(omgModelFileName);
		Resource builtInResource = resourceSet.getResource(builtInURI, true);
		Resource omgResource = loadEcoreResource(omgURI);
		//
		//	Compare the built-in model with the OMG model 
		//
		OMGEcoreEquivalenceHelper helper = new OMGEcoreEquivalenceHelper(htmlStream, null);
		EquivalenceMap comparator = new EquivalenceMap(helper);
		installEmofOmgMappings(comparator, omgResource.getResourceSet());
		comparator.load(builtInResource, omgResource, null);
		//
		if (loggedPackageName != null)
			try {
				helper.setLogStream(new PrintStream("temp/" + loggedPackageName + "RoseConsistency.log"));
			} catch (FileNotFoundException e) {
				fail(e.getMessage());
			}
		if (htmlStream != null) {
			htmlStream.println("<h2>EMOF-based Model Compliance with respect to the OMG QVT Rose Model</h2>");
			htmlStream.println("The OMG QVT Rose Model is the source of all diagrams in the QVT specification");
			htmlStream.println("and the notional source of all other generated models.");
			htmlStream.println("<p>");
			htmlStream.println("The Eclipse <tt>" + loggedPackageName + "</tt> Model resolves the following errors");
			htmlStream.println("and anomalies in the OMG QVT Rose Model.");
			htmlStream.println("<p>");
		}
		Set<EcoreDifference> differences = getExpectedEmof2OmgRoseDifferences(helper, getPackage(omgResource, getPackageName().toLowerCase()));
		assertDifferencesEquals(comparator, builtInURI, omgURI, differences);
	}
	/**
	 * Verify that the builtInNsURI has the getExpectedGeneratedDifferences()
	 * with respect to the generatedModelFileName.
	 */
	protected void emof2RoseConsistencyTest(String builtInNsURI, String generatedModelFileName) {
		URI builtInURI = URI.createURI(builtInNsURI);
		URI generatedURI = RoseModels.INSTANCE.getURI(generatedModelFileName);
		Resource builtInResource = resourceSet.getResource(builtInURI, true);
		Resource generatedResource = loadEcoreResource(generatedURI);
		//
		//	Compare the built-in model with the generated model 
		//
		GeneratedEcoreEquivalenceHelper helper = new GeneratedEcoreEquivalenceHelper(htmlStream, null);
		EquivalenceMap comparator = new EquivalenceMap(helper);
		installEmofEclipseMappings(comparator, generatedResource.getResourceSet());
		comparator.load(builtInResource, generatedResource, null);
		//
		if (loggedPackageName != null)
			try {
				helper.setLogStream(new PrintStream("temp/" + loggedPackageName + "2RoseConsistency.log"));
			} catch (FileNotFoundException e) {
				fail(e.getMessage());
			}
		if (htmlStream != null) {
			htmlStream.println("<h2>EMOF-based Model Compliance with respect to the Eclipse QVT Rose Model</h2>");
			htmlStream.println("The Eclipse QVT Rose Model provides the definition for all models; it resolves numerous errors in the OMG QVT Rose Model.");
			htmlStream.println("<p>");
//			htmlStream.println("The Ecore-based Models provide a realisation of the Rose Model exploiting");
//			htmlStream.println("Eclipse EMF Ecore in place of EMOF, and Eclipse MDT OCL in place of EssentialOCL.");
//			htmlStream.println("<p>");
			htmlStream.println("The EMOF-based <tt>" + loggedPackageName + "</tt> Model exhibits the following differences with respect to the Eclipse QVT Rose Model.");
			htmlStream.println("<p>");
		}
		Set<EcoreDifference> differences = getExpectedEmof2RoseDifferences(helper, getPackage(generatedResource, getPackageName()));
		assertDifferencesEquals(comparator, builtInURI, generatedURI, differences);
	}

	protected void extraAdaptingObjectInconsistency(Map<InconsistencyKey, InconsistencyValue> ecoreInconsistencies,
			InconsistencyKey inconsistencyKey, InconsistencyValue inconsistencyValue) {
		ecoreInconsistencies.put(inconsistencyKey, inconsistencyValue);
		if (htmlStream != null) {
			StringBuffer s = new StringBuffer();
			s.append("'");
			MappingUtils.formatClassAndFeatureName(s, inconsistencyKey.element);
			s.append("' does not exist");
			htmlStream.printDifferenceLine(s.toString());
		}
	}

	protected void extraEcoreObjectInconsistency(Map<InconsistencyKey, InconsistencyValue> ecoreInconsistencies,
			InconsistencyKey inconsistencyKey, InconsistencyValue inconsistencyValue) {
		ecoreInconsistencies.put(inconsistencyKey, inconsistencyValue);
		if (htmlStream != null) {
			StringBuffer s = new StringBuffer();
			if (inconsistencyValue.adaptingValue == null) {
				s.append("'");
				MappingUtils.formatClassAndFeatureName(s, inconsistencyKey.element);
				s.append("' exists");
			}
			else {
				s.append("'");
				s.append(MappingUtils.formatLocalName(inconsistencyKey.feature));
				s.append("' for '");
				MappingUtils.formatClassAndFeatureName(s, inconsistencyKey.element);
				s.append("' is ");
				MappingUtils.formatObject(s, inconsistencyValue.ecoreValue);
				s.append(" rather than ");
				MappingUtils.formatObject(s, inconsistencyValue.adaptingValue);
			}
			htmlStream.printDifferenceLine(s.toString());
		}
	}

	protected static void extraFeature(Set<EcoreDifference> differences, EquivalenceHelper helper, EObject object, EReference feature, EStructuralFeature zz) {
		differences.add(new EcoreDifference(helper, object, feature, null, zz, "Null left feature"));
		StringBuffer s = new StringBuffer();
		s.append("'");
		s.append(MappingUtils.formatLocalName(feature));
		s.append("' for ");
		s.append(MappingUtils.formatClassAndFeatureName(object));
		s.append(" should be undefined");
		helper.println(s.toString());
	}

	protected static void extraListObject(Set<EcoreDifference> differences, EquivalenceHelper helper, EObject object, EReference feature, EObject... extras) {
		changeOfSize(differences, helper, object, feature);
		StringBuffer s = new StringBuffer();
		s.append("'");
		s.append(MappingUtils.formatLocalName(feature));
		s.append("' for ");
		s.append(MappingUtils.formatClassAndFeatureName(object));
		s.append(" should not include");
		String prefix = " ";
		for (EObject extra : extras) {
			s.append(prefix);
			s.append(MappingUtils.formatClassAndFeatureName(extra));
			prefix = ",";
		}
		helper.println(s.toString());
	}

	protected static void extraObject(Set<EcoreDifference> differences, EquivalenceHelper helper, EObject object) {
		differences.add(new EcoreDifference(helper, null, null, null, object, "Null left object"));
		StringBuffer s = new StringBuffer();
		s.append(MappingUtils.formatClassAndFeatureName(object));
		s.append(" should be undefined");
		helper.println(s.toString());
	}
	
//	protected static void extraOpposite(Set<EcoreDifference> differences, EquivalenceHelper helper, EStructuralFeature object) {
//		differences.add(new EcoreDifference(helper, object, EcorePackage.Literals.EMODEL_ELEMENT__EANNOTATIONS, object.getEAnnotations(), null, "Different sizes"));
//		extraOppositeAnnotation(differences, helper, object);
//	}

	protected void extraOpposite(Set<EcoreDifference> differences, EquivalenceHelper helper, EModelElement leftObject, EStructuralFeature rightObject) {
		differences.add(new EcoreDifference(helper, leftObject, EcorePackage.Literals.EMODEL_ELEMENT__EANNOTATIONS, leftObject.getEAnnotations(), rightObject.getEAnnotations(), "Different sizes"));
		extraOppositeAnnotation(differences, helper, rightObject);
	}
	
	protected static void extraOppositeAnnotation(Set<EcoreDifference> differences, EquivalenceHelper helper, EStructuralFeature object) {
		String oppositeRoleName = EMOFExtendedMetaData.EMOF_PROPERTY_OPPOSITE_ROLE_NAME_ANNOTATION_SOURCE;
		differences.add(new EcoreDifference(helper, null, null, null, getAnnotation(object, oppositeRoleName), "Null left object"));
		differences.add(new EcoreDifference(helper, null, null, null, getDetail(object, oppositeRoleName, "body"), "Null left object"));
	}

	public static EAnnotation getAnnotation(EObject element, String source) {
		if (!(element instanceof EModelElement))
			return null;
		return ((EModelElement) element).getEAnnotation(source);
	}

	public static List<EAnnotation> getAnnotations(EObject element) {
		if (!(element instanceof EModelElement))
			return null;
		return ((EModelElement) element).getEAnnotations();
	}

	public static EClass getClass(EPackage ePackage, String name) {
		if (ePackage == null)
			return null;
		EClassifier classifier = ePackage.getEClassifier(name);
		if (!(classifier instanceof EClass))
			return null;
		return (EClass) classifier;
	}

	public static EDataType getDataType(EPackage ePackage, String name) {
		if (ePackage == null)
			return null;
		EClassifier classifier = ePackage.getEClassifier(name);
		if (!(classifier instanceof EDataType))
			return null;
		return (EDataType) classifier;
	}

	public static Entry<String, String> getDetail(EObject element, String source, String key) {
		if (!(element instanceof EModelElement))
			return null;
		EAnnotation annotation = ((EModelElement) element).getEAnnotation(source);
		if (annotation == null)
			return null;
		EMap<String, String> details = annotation.getDetails();
		int i = details.indexOfKey(key);
		if (i < 0)
			return null;
		return details.get(i);
	}

	/**
	 * Populate ecoreInconsistencies and adaptingInconsistencies with the inconsistencies
	 * expected between the ECore-based and EMOF-based models for a package derived from
	 * both Ecore and Ecore OCL.
	 */
	protected void getExpectedDerivedPackageInconsistencies(
			Map<InconsistencyKey, InconsistencyValue> ecoreInconsistencies,
			Map<InconsistencyKey, InconsistencyValue> adaptingInconsistencies) {}
	
	protected Set<EcoreDifference> getExpectedEcore2EmofDifferences(EquivalenceHelper helper, EPackage rightPackage) {
		Set<EcoreDifference> differences = new HashSet<EcoreDifference>();
		htmlStream.println("No differences");
		return differences;
	}

	protected Set<EcoreDifference> getExpectedEmof2OmgEcoreDifferences(EquivalenceHelper helper, EPackage rightPackage) {
		Set<EcoreDifference> differences = new HashSet<EcoreDifference>();
		htmlStream.println("No differences");
		return differences;
	}

	protected Set<EcoreDifference> getExpectedEmof2OmgEmofDifferences(EquivalenceHelper helper, EPackage rightPackage) {
		Set<EcoreDifference> differences = new HashSet<EcoreDifference>();
		htmlStream.println("No differences");
		return differences;
	}

	protected Set<EcoreDifference> getExpectedEmof2OmgRoseDifferences(EquivalenceHelper helper, EPackage rightPackage) {
		Set<EcoreDifference> differences = new HashSet<EcoreDifference>();
		htmlStream.println("No differences");
		return differences;
	}

	protected Set<EcoreDifference> getExpectedEmof2RoseDifferences(EquivalenceHelper helper, EPackage rightPackage) {
		Set<EcoreDifference> differences = new HashSet<EcoreDifference>();
		htmlStream.println("No differences");
		return differences;
	}
	
	protected Set<EcoreDifference> getExpectedOMGEMOFDifferences(EquivalenceHelper helper, EPackage rightPackage) {
		Set<EcoreDifference> differences = new HashSet<EcoreDifference>();
		htmlStream.println("No differences");
		return differences;
	}

	public static EStructuralFeature getFeature(EClassifier eClass, String name) {
		if (!(eClass instanceof EClass))
			return null;
		return ((EClass) eClass).getEStructuralFeature(name);
	}

	public static EOperation getOperation(EClassifier eClass, String name) {
		if (!(eClass instanceof EClass))
			return null;
		return EcoreUtils.getNamedElement(((EClass) eClass).getEOperations(), name);
	}

	public static EPackage getPackage(Resource resource, String name) {
		for (EObject content : resource.getContents())
			if ((content instanceof EPackage) && ((EPackage)content).getName().equals(name))
				return (EPackage) content;
		fail("Missing EPackage '" + name + "' in '" + MappingUtils.formatFullName(resource) + "'");
		return null;
	}

	public static EPackage getPackage(ResourceSet resourceSet, String name) {
		for (Resource resource : resourceSet.getResources())
			for (EObject content : resource.getContents())
				if ((content instanceof EPackage) && ((EPackage)content).getName().equals(name))
					return (EPackage) content;
//		fail("Missing EPackage '" + name + "' in '" + MappingUtils.formatFullName(resourceSet) + "'");
		return null;
	}

	public abstract String getPackageName();

//	public String getOmgPackageName() {
//		return getPackageName().toLowerCase();
//	}

	public static EParameter getParameter(EOperation eOperation, String parameterName) {
		if (eOperation == null)
			return null;
		return EcoreUtils.getNamedElement(eOperation.getEParameters(), parameterName);
	}

	public static EParameter getParameter(EClassifier eClass, String operationName, String parameterName) {
		EOperation op = getOperation(eClass,operationName);
		if (op == null)
			return null;
		return EcoreUtils.getNamedElement(op.getEParameters(), parameterName);
	}

	public static Resource getResource(Resource resource, URI name) {
		return resource.getResourceSet().getResource(name, false);
	}

	protected void installEcoreEclipseMappings(EquivalenceMap comparator, ResourceSet resourceSet) {}

//	protected void installEcoreOmgMappings(EquivalenceMap comparator, ResourceSet resourceSet) {}

	protected void installEmofEclipseMappings(EquivalenceMap comparator, ResourceSet resourceSet) {}

	protected void installEmofOmgMappings(EquivalenceMap comparator, ResourceSet resourceSet) {}

	protected void installEmof2EmofMappings(EquivalenceMap comparator, ResourceSet resourceSet) {}

	/**
	 * Load the Ecore URI in a distinct Resource Set
	 */
	private Resource loadEcoreResource(URI uri) {
		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl());
		Resource resource = resourceSet.getResource(uri, true);
		EcoreUtil.resolveAll(resource);
		return resource;
	}

	/**
	 * Load the EMOF URI in a distinct Resource Set
	 */
	private Resource loadEMOFResource(URI uri) {
		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("emof", new EMOFResourceFactoryImpl());
		Resource resource = resourceSet.getResource(uri, true);
		EcoreUtil.resolveAll(resource);
		return resource;
	}

	protected static void missingClass(Set<EcoreDifference> differences, EquivalenceHelper helper, EClass eClass) {
		differences.add(new EcoreDifference(helper, null, null, eClass, null, "Null right object"));
		StringBuffer s = new StringBuffer();
		s.append("'");
		s.append(helper.formatLocalName(eClass));
		s.append("' should be defined");
		helper.println(s.toString());
	}
	
	protected static void missingConstraint(Set<EcoreDifference> differences, EquivalenceHelper helper, EModelElement object) {
		String oppositeRoleName = EcorePackage.eNS_URI;
		differences.add(new EcoreDifference(helper, object, EcorePackage.Literals.EMODEL_ELEMENT__EANNOTATIONS, object.getEAnnotations(), null, "Different sizes"));
		differences.add(new EcoreDifference(helper, null, null, getAnnotation(object, oppositeRoleName), null, "Null right object"));
		differences.add(new EcoreDifference(helper, null, null, getDetail(object, oppositeRoleName, "constraints"), null, "Null right object"));
	}

	protected static void missingEnumerationLiteral(Set<EcoreDifference> differences, EquivalenceHelper helper, EEnumLiteral eLiteral) {
		differences.add(new EcoreDifference(helper, null, null, eLiteral, null, "Null right object"));
		StringBuffer s = new StringBuffer();
		s.append("'");
		s.append(MappingUtils.formatLocalName(eLiteral.getEEnum()));
		s.append("::");
		s.append(MappingUtils.formatLocalName(eLiteral));
		s.append("' should be defined");
		helper.println(s.toString());
	}

	protected static void missingListObject(Set<EcoreDifference> differences, EquivalenceHelper helper, EObject object, EReference feature, EObject... extras) {
		changeOfSize(differences, helper, object, feature);
		StringBuffer s = new StringBuffer();
		s.append("'");
		s.append(MappingUtils.formatLocalName(feature));
		s.append("' for ");
		s.append(MappingUtils.formatClassAndFeatureName(object));
		s.append(" should include");
		String prefix = " ";
		for (EObject extra : extras) {
			s.append(prefix);
			s.append(MappingUtils.formatClassAndFeatureName(extra));
			prefix = ",";
		}
		helper.println(s.toString());
	}

	protected static void missingObject(Set<EcoreDifference> differences, EquivalenceHelper helper, ENamedElement feature) {
		differences.add(new EcoreDifference(helper, null, null, feature, null, "Null right object"));
		StringBuffer s = new StringBuffer();
		s.append(MappingUtils.formatClassAndFeatureName(feature));
		s.append(" should be defined");
		helper.println(s.toString());
	}

	protected static void missingOperation(Set<EcoreDifference> differences, EquivalenceHelper helper, EOperation operation) {
		differences.add(new EcoreDifference(helper, null, null, operation, null, "Null right object"));
		StringBuffer s = new StringBuffer();
		s.append("'");
		MappingUtils.formatClassAndFeatureName(s, operation);
		s.append("(");
		String prefix = "";
		for (EParameter parameter : operation.getEParameters()) {
			s.append(prefix);
			differences.add(new EcoreDifference(helper, null, null, parameter, null, "Null right object"));
			s.append(MappingUtils.formatLocalName(parameter));
			prefix = ",";
		}
		s.append(")' should be defined");
		helper.println(s.toString());
	}
	
	protected static void missingOpposite(Set<EcoreDifference> differences, EquivalenceHelper helper, EReference object) {
		differences.add(new EcoreDifference(helper, object, EcorePackage.Literals.EMODEL_ELEMENT__EANNOTATIONS, object.getEAnnotations(), null, "Different sizes"));
		missingOppositeAnnotation(differences, helper, object);
	}
	
	protected static void missingOppositeAnnotation(Set<EcoreDifference> differences, EquivalenceHelper helper, EReference object) {
		String oppositeRoleName = EMOFExtendedMetaData.EMOF_PROPERTY_OPPOSITE_ROLE_NAME_ANNOTATION_SOURCE;
		differences.add(new EcoreDifference(helper, null, null, getAnnotation(object, oppositeRoleName), null, "Null right object"));
		differences.add(new EcoreDifference(helper, null, null, getDetail(object, oppositeRoleName, "body"), null, "Null right object"));
		StringBuffer s = new StringBuffer();
		s.append("Unnavigable 'opposite' of '");
		MappingUtils.formatClassAndFeatureName(s, object);
		s.append("' should be modelled");
		helper.println(s.toString());
	}

	protected static void missingOppositeFeature(Set<EcoreDifference> differences, EquivalenceHelper helper, EReference ref) {
		differences.add(new EcoreDifference(helper, ref, EcorePackage.Literals.EREFERENCE__EOPPOSITE, ref.eGet(EcorePackage.Literals.EREFERENCE__EOPPOSITE, false), null, "Null right feature"));
		StringBuffer s = new StringBuffer();
		s.append(MappingUtils.formatClassAndFeatureName(ref.getEOpposite()));
		s.append(" should be the 'opposite' of ");
		s.append(MappingUtils.formatClassAndFeatureName(ref));
		helper.println(s.toString());
	}

	protected static void missingOppositeFeatureAndContext(Set<EcoreDifference> differences, EquivalenceHelper helper, EReference ref) {
		changeOfSize(differences, helper, ref.eContainer(), EcorePackage.Literals.ECLASS__ESTRUCTURAL_FEATURES);
		missingObject(differences, helper, ref);
		missingOppositeFeature(differences, helper, ref.getEOpposite());
	}

	protected static void missingPrefix(Set<EcoreDifference> differences, EquivalenceHelper helper, EPackage object) {
		differences.add(new EcoreDifference(helper, object, EcorePackage.Literals.EPACKAGE__NS_PREFIX, object.getNsPrefix(), null, "Null right feature"));
		StringBuffer s = new StringBuffer();
		s.append("'prefix' for '");
		s.append(helper.formatLocalName(object));
		s.append("' should be defined");
		helper.println(s.toString());
	}

	protected static void missingURI(Set<EcoreDifference> differences, EquivalenceHelper helper, EPackage object) {
		differences.add(new EcoreDifference(helper, object, EcorePackage.Literals.EPACKAGE__NS_URI, object.getNsURI(), null, "Null right feature"));
		StringBuffer s = new StringBuffer();
		s.append("'uri' for '");
		s.append(helper.formatLocalName(object));
		s.append("' should be defined");
		helper.println(s.toString());
	}

	@Override
	protected void setUp() throws Exception {		
		loggedPackageName = getPackageName();
		consistencyValidator = new ConsistencyValidator();
		MappingMetaDataRegistry.consistencyValidator = consistencyValidator;
		new TestEnvironment();
		super.setUp();
		resourceSet = new ResourceSetImpl();
		getMappingMetaDataRegistry().configure(resourceSet);
		if (loggedPackageName != null) {
			File dir = new File("temp");
			dir.mkdir();
			htmlStream = new HTMLStream("temp/" + loggedPackageName + "Compliance.html");
			htmlStream.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0//EN\">");
			htmlStream.println("<!-- This file was autogenerated on " + new Date() + " by the " + getClass().getName() + "." + getName() + "() JUnit test -->");
			htmlStream.println("<html>");
			htmlStream.println("<head>");
			htmlStream.println("<title>" + loggedPackageName + " Model Compliance</title>");
			htmlStream.println("<meta http-equiv=Content-Type content=\"text/html; charset=ISO-8859-1\">");
			htmlStream.println("</head>");
			htmlStream.println("<body lang=\"EN-US\">");
			htmlStream.println("<h1>" + loggedPackageName + " Model Compliance</h1>");
			htmlStream.println("<p>");
			htmlStream.println("This document describes clarifications and fixes to"); 
			htmlStream.println("<ul>");
			htmlStream.println("	<li><a href=\"http://www.omg.org/docs/formal/06-01-01.pdf\">OMG MOF 2.0 specification (06-01-01)</a></li>");
			htmlStream.println("	<li><a href=\"http://www.omg.org/docs/formal/06-05-01.pdf\">OMG OCL 2.0 specification (06-05-01)</a></li>");
			htmlStream.println("	<li><a href=\"http://www.omg.org/docs/formal/08-04-03.pdf\">OMG QVT 1.0 specification (08-04-03)</a></li>");
			htmlStream.println("</ul>");
			htmlStream.println("realised by the Ecore-based and EMOF-based " + loggedPackageName + " models.");
			htmlStream.println("<p>");
			htmlStream.println("The EMOF-based <tt>" + loggedPackageName + "</tt> model is intended to exactly comply with the spirit of the latest QVT specification;");
			htmlStream.println("the model therefore corrects numerous problems in the official QVT 1.0 models.");
			htmlStream.println("The EMOF-based model should be used for modelling, where accuracy is important.");
			htmlStream.println("<p>");
			htmlStream.println("The Ecore-based <tt>" + loggedPackageName + "</tt> model is intended to provide identical behaviour subject to the replacement of");
			htmlStream.println("<ul>");
			htmlStream.println("	<li>the <tt>EMOF</tt> package by Ecore (from Eclipse EMF)</li>");
			htmlStream.println("	<li>the <tt>EssentialOCL</tt> package by the Ecore OCL package (from  Eclipse MDT).</li>");
			htmlStream.println("</ul>");
			htmlStream.println("The Ecore-based model should be used within tools, where the power of Ecore and its associated tooling is important.");
		}
	}

	@Override
	protected void tearDown() throws Exception {
		if (htmlStream != null) {
			htmlStream.println("</body>");
			htmlStream.println("</html>");
			htmlStream.close();
		}
		super.tearDown();
	}
}
