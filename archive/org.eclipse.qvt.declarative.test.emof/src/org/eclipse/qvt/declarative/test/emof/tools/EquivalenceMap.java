/*******************************************************************************
 * Copyright (c) 2007,2008 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvt.declarative.test.emof.tools;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.qvt.declarative.ecore.mappings.MappingConfigurationException;
import org.eclipse.qvt.declarative.ecore.mappings.MappingUtils;

public class EquivalenceMap implements EcoreComparator 
{	
	public static interface ContentPredicate
	{
		public boolean isValid(EObject ecoreObject);
	}
	
	protected final EquivalenceHelper helper;
	private URI baseURI = null;
//	private final Resource leftResource;
//	private final Resource rightResource;
	private final Map<EObject, EObject> leftToRightMap = new HashMap<EObject, EObject>();
	private final Map<EObject, EObject> rightToLeftMap = new HashMap<EObject, EObject>();
	private final List<EcoreDifference> differences = new ArrayList<EcoreDifference>();
	private boolean resolveProxies = true;
	
	public EquivalenceMap(EquivalenceHelper helper) {
		this.helper = helper;
	}
	
	public EquivalenceMap(Resource leftResource, Resource rightResource) {
		this(EcoreEquivalenceHelper.INSTANCE, leftResource, rightResource, null);
	}
	
	public EquivalenceMap(EquivalenceHelper helper, Resource leftResource, Resource rightResource, ContentPredicate contentPredicate) {
		this.helper = helper;
//		this.leftResource = leftResource;
//		this.rightResource = rightResource;
		load(leftResource, rightResource, contentPredicate);
	}

	protected void addContents(List<EObject> leftContents, List<EObject> rightContents, ContentPredicate contentPredicate) {
		if (contentPredicate != null) {
			if (leftContents != null) {
				leftContents = new ArrayList<EObject>(leftContents);	// need supported remove();
				for (int i = 0; i < leftContents.size(); ) {
					EObject leftContent = leftContents.get(i);
					if (contentPredicate.isValid(leftContent))
						i++;
					else
						leftContents.remove(i);
				}
			}
			if (rightContents != null) {
				rightContents = new ArrayList<EObject>(rightContents);	// need supported remove();
				for (int i = 0; i < rightContents.size(); ) {
					EObject rightContent = rightContents.get(i);
					if (contentPredicate.isValid(rightContent))
						i++;
					else
						rightContents.remove(i);
				}
			}
		}
		List<Equivalence> equivalences = new ArrayList<Equivalence>();
		equivalences.add(createEquivalence(leftContents, rightContents));
		@SuppressWarnings("unused") boolean ok = partition(equivalences);
		if (leftContents != null)
			for (EObject leftContent : leftContents) {
				EObject rightContent = leftToRightMap.get(leftContent);
				if ((leftContent.eContents().size() > 0) || ((rightContent != null) && (rightContent.eContents().size() > 0)))
					addContents(leftContent.eContents(), rightContent != null ? rightContent.eContents() : null, contentPredicate);
			}
		if (rightContents != null)
			for (EObject rightContent : rightContents) {
				EObject leftContent = rightToLeftMap.get(rightContent);
				if ((leftContent == null) && (rightContent.eContents().size() > 0))
					addContents(null, rightContent.eContents(), contentPredicate);
			}
	}

	protected void addEcoreDifference(Object leftFeature, Object rightFeature, String string) {
		differences.add(helper.createDifference(null, null, leftFeature, rightFeature, string));		
	}

	protected void addEcoreDifference(EObject context, EStructuralFeature feature, Object leftFeature, Object rightFeature, String string) {
		differences.add(helper.createDifference(context, feature, leftFeature, rightFeature, string));		
	}

	protected Object basicListGet(EList<?> list, int i) {
		if (list instanceof BasicEList<?>)
			return ((BasicEList<?>) list).basicGet(i);		// Avoid resolving proxies
		else
			return list.get(i);
	}

	public boolean compareEFeature(EObject context, EStructuralFeature eFeature, Object leftObject, Object rightObject) {
		boolean allOk = false;
//		if ((leftObject instanceof List) && ((List<?>)leftObject).isEmpty())
//			leftObject = null;
//		if ((rightObject instanceof List) && ((List<?>)rightObject).isEmpty())
//			rightObject = null;
		if (leftObject == rightObject)
			allOk = true;
		else if (leftObject == null)
			addEcoreDifference(context, eFeature, leftObject, rightObject, "Null left feature");
		else if (rightObject == null)
			addEcoreDifference(context, eFeature, leftObject, rightObject,  "Null right feature");
//		else if (leftFeature.getClass() != rightFeature.getClass())
//			addEcoreDifference(context, eFeature, leftFeature, rightFeature,  "Different classes");
		else if (leftObject instanceof EFactory)
			allOk = true;
		else if (leftObject instanceof EMap<?,?>) {
			EMap<String,?> leftMap = MappingUtils.asClassUnchecked(leftObject, (EMap<String,?>) null);
			EMap<String,?> rightMap = MappingUtils.asClassUnchecked(rightObject, (EMap<String,?>) null);
			if (compareMapFeature(context, eFeature, leftMap, rightMap))
				allOk = true;
		}
		else if (leftObject instanceof BasicEList<?>) {
			if (compareBasicListFeature(context, eFeature, (BasicEList<?>)leftObject, (BasicEList<?>)rightObject))
				allOk = true;
		}
		else if (leftObject instanceof EList<?>) {
			if (compareListFeature(context, eFeature, (EList<?>)leftObject, (EList<?>)rightObject))
				allOk = true;
		}
		else if (((leftObject instanceof EObject) && ((EObject)leftObject).eIsProxy()) 
			  || ((rightObject instanceof EObject) && ((EObject)rightObject).eIsProxy())) {
			if (((EObject) leftObject).eClass() != ((EObject) rightObject).eClass())
				addEcoreDifference(context, eFeature, leftObject, rightObject,  "Different classes");
			else if (compareProxyFeature(context, eFeature, (EObject)leftObject, (EObject)rightObject))
				allOk = true;
		}
		else if (leftToRightMap.get(leftObject) != null) {
			Object mappedLeftFeature = leftToRightMap.get(leftObject);
			if (rightObject != mappedLeftFeature)
				addEcoreDifference(context, eFeature, leftObject, rightObject,  "Different mapped objects");
			else
				allOk = true;
		}
		else if (!leftObject.equals(rightObject)) {
			if (!(leftObject instanceof EObject) || !(rightObject instanceof EObject) || !helper.equals((EObject)leftObject, (EObject)rightObject))
				addEcoreDifference(context, eFeature, leftObject, rightObject,  "Different objects");
		}
		return allOk;
	}

	public boolean compareEObject(EObject leftObject, EObject rightObject) {
		boolean allOk = false;
		if (leftObject == rightObject)
			allOk = true;
		else if (!isComparable(leftObject))
			allOk = true;
		else if (!isComparable(rightObject))
			allOk = true;
		else if (leftObject == null)
			addEcoreDifference(leftObject, rightObject, "Null left object");
		else if (rightObject == null)
			addEcoreDifference(leftObject, rightObject,  "Null right object");
//		else if (leftObject.getClass() != rightObject.getClass())
//			addEcoreDifference(leftObject, rightObject,  "Different classes");
		else if (leftObject.eClass() != rightObject.eClass())
			addEcoreDifference(leftObject, rightObject,  "Different classes");
		else {
			allOk = true;
			EClass eClass = leftObject.eClass();
			for (EStructuralFeature eFeature : eClass.getEAllStructuralFeatures()) {
				if (isComparable(eFeature) && helper.isComparable(eClass, eFeature, leftObject, rightObject)) {
					try {
						Object leftFeature = leftObject != null ? leftObject.eGet(eFeature, resolveProxies) : null;
						Object rightFeature = rightObject != null ? rightObject.eGet(eFeature, resolveProxies) : null;
						if (!compareEFeature(leftObject, eFeature, leftFeature, rightFeature))
							allOk = false;
	//					else
	//						System.out.println("    Ok " + formatFeatureName(eFeature) + "  => " + formatFullName(leftFeature));
					} catch (MappingConfigurationException e) {
						addEcoreDifference(leftObject, rightObject, e.getMessage());
					}
				}
			}
		}
//		if (allOk)
//			System.out.println("Ok " + formatFullName(leftObject));
		return allOk;
	}

	public boolean compareBasicListFeature(EObject context, EStructuralFeature eFeature, BasicEList<?> leftFeature, BasicEList<?> rightFeature) {
		boolean allOk = false;
		int iMax = leftFeature.size();
		if (iMax != rightFeature.size())
			addEcoreDifference(context, eFeature, leftFeature, rightFeature,  "Different sizes");
		else if (helper.isOrdered(eFeature)) {
			allOk = true;
			for (int i = 0; i < iMax; i++)
				if (!compareEFeature(context, eFeature, leftFeature.basicGet(i), rightFeature.basicGet(i)))
					allOk = false;
		}
		else {
			allOk = true;
			List<Object> rights = new ArrayList<Object>();
			for (int i = 0; i < iMax; i++)
				rights.add(rightFeature.basicGet(i));
			List<Object> leftOrderedRights = new ArrayList<Object>();
			for (int i = 0; i < iMax; i++) {
				Object leftObject = leftFeature.basicGet(i);
				Object rightObject = leftToRightMap.get(leftObject);
				if ((rightObject == null) && (leftObject instanceof EObject))
					rightObject = helper.getRight((EObject) leftObject);
				if (!rights.contains(rightObject))
					rightObject = null;
				else
					rights.remove(rightObject);
				leftOrderedRights.add(rightObject);
			}
			for (int i = 0; i < iMax; i++) {
				Object rightObject = leftOrderedRights.get(i);
				if (rightObject == null)
					rightObject = rights.remove(0);
				if (!compareEFeature(context, eFeature, leftFeature.basicGet(i), rightObject))
					allOk = false;
			}
		}
		return allOk;
	}

	public boolean compareListFeature(EObject context, EStructuralFeature eFeature, EList<?> leftFeature, EList<?> rightFeature) {
		boolean allOk = false;
		int iMax = leftFeature.size();
		if (iMax != rightFeature.size())
			addEcoreDifference(context, eFeature, leftFeature, rightFeature,  "Different sizes");
		else if (helper.isOrdered(eFeature)) {
			allOk = true;
			for (int i = 0; i < iMax; i++)
				if (!compareEFeature(context, eFeature, basicListGet(leftFeature, i), basicListGet(rightFeature, i)))
					allOk = false;
		}
		else {
			allOk = true;
			List<Object> rights = new ArrayList<Object>();
			for (int i = 0; i < iMax; i++)
				rights.add(basicListGet(rightFeature, i));
			List<Object> leftOrderedRights = new ArrayList<Object>();
			for (int i = 0; i < iMax; i++) {
				Object leftObject = basicListGet(leftFeature, i);
				Object rightObject = leftToRightMap.get(leftObject);
				if (!rights.contains(rightObject))
					rightObject = null;
				else
					rights.remove(rightObject);
				leftOrderedRights.add(rightObject);
			}
			for (int i = 0; i < iMax; i++) {
				Object rightObject = leftOrderedRights.get(i);
				if (rightObject == null)
					rightObject = rights.remove(0);
				if (!compareEFeature(context, eFeature, basicListGet(leftFeature, i), rightObject))
					allOk = false;
			}
		}
		return allOk;
	}

	private boolean compareMapFeature(EObject context, EStructuralFeature eFeature, EMap<String, ?> leftFeature, EMap<String, ?> rightFeature) {
		boolean allOk = false;
		List<String> leftKeys = new ArrayList<String>(leftFeature.keySet());
		List<String> rightKeys = new ArrayList<String>(rightFeature.keySet());
		int iMax = leftKeys.size();
		if (iMax != rightKeys.size())
			addEcoreDifference(context, eFeature, leftFeature, rightFeature,  "Different sizes");
		else {
			allOk = true;
			Collections.sort(leftKeys);
			Collections.sort(rightKeys);
			for (int i = 0; i < iMax; i++) {
				String leftKey = leftKeys.get(i);
				String rightKey = rightKeys.get(i);
				if (!leftKey.equals(rightKey)) {
					addEcoreDifference(context, eFeature, leftFeature, rightFeature,  "Different keys");
					allOk = false;
					break;
				}
				Object leftValue = leftFeature.get(leftKey);
				Object rightValue = rightFeature.get(rightKey);
				if ((leftValue != rightValue) && ((leftValue == null) || !leftValue.equals(rightValue))) {
					addEcoreDifference(context, eFeature, leftFeature, rightFeature,  "Different objects");
					allOk = false;
					break;
				}
			}
		}
		return allOk;
	}

	public boolean compareProxyFeature(EObject context, EStructuralFeature eFeature, EObject leftFeature, EObject rightFeature) {
		boolean allOk = false;
		URI leftURI = EcoreUtil.getURI(leftFeature);
		URI rightURI = EcoreUtil.getURI(rightFeature);
		if (leftURI == null)
			addEcoreDifference(context, eFeature, leftFeature, rightFeature, "Null left proxy URI");
		else if (rightURI == null)
			addEcoreDifference(context, eFeature, leftFeature, rightFeature,  "Null right proxy URI");
		else {
			if (baseURI != null) {
				leftURI = leftURI.resolve(baseURI);
				rightURI = rightURI.resolve(baseURI);
			}
			if (!leftURI.equals(rightURI))
				addEcoreDifference(context, eFeature, leftFeature, rightFeature,  "Different proxy URIs");
			else
				allOk = true;
		}
		return allOk;
	}
	
	public List<EcoreDifference> computeDifferences() {
		for (EObject leftObject : leftToRightMap.keySet()) {
			EObject rightObject = leftToRightMap.get(leftObject);
			compareEObject(leftObject, rightObject);
		}
		for (EObject rightObject : rightToLeftMap.keySet()) {
			EObject leftObject = rightToLeftMap.get(rightObject);
			if (leftObject == null)
				compareEObject(null, rightObject);
		}
		return differences;
	}

	protected Equivalence createEquivalence(List<EObject> leftContents, List<EObject> rightContents) {
		return new Equivalence(helper, leftContents, rightContents);
	}

	protected boolean isComparable(EObject eObject) {
		if (eObject instanceof EGenericType)
			return false;
		return true;
	}	
	
	protected boolean isComparable(EStructuralFeature eFeature) {
		if (eFeature.isDerived())
			return false;
		if (eFeature.isTransient())
			return false;
//		if (eFeature.isVolatile()
//		 && (eFeature != EcorePackage.eINSTANCE.getEClassifier_InstanceClassName()))		// Beware spurious volatile declaration
//			return false;
//		if (eFeature == EcorePackage.eINSTANCE.getETypedElement_EGenericType())
//			return false;
//		if (eFeature == EcorePackage.eINSTANCE.getEClass_EGenericSuperTypes())
//			return false;
//		if (eFeature == EcorePackage.eINSTANCE.getEClassifier_ETypeParameters())
//			return false;
//		if (eFeature == EcorePackage.eINSTANCE.getEModelElement_EAnnotations())
//			return false;
//		if (eFeature == EcorePackage.eINSTANCE.getEReference_EKeys())
//			return false;
		return true;
	}	

	public void load(Resource leftResource, Resource rightResource, ContentPredicate contentPredicate) {
		EcoreUtil.resolveAll(leftResource);
		EcoreUtil.resolveAll(rightResource);
		addContents(leftResource.getContents(), rightResource.getContents(), contentPredicate);
	}
	
	public boolean partition(List<Equivalence> equivalences) {
		if (equivalences.size() <= 0)
			return true;
		List<Equivalence> equivalences0 = partitionByKnown(equivalences);
		List<Equivalence> equivalences1 = partitionByClass(equivalences0);
		List<Equivalence> equivalences2 = partitionByName(equivalences1);
		return partitionByOrder(equivalences2);
	}
	
	public List<Equivalence> partitionByClass(List<Equivalence> equivalences) {
		List<Equivalence> newEquivalences = new ArrayList<Equivalence>();
		for (Equivalence equivalence : equivalences)
			if (equivalence.isPartitioned())
				newEquivalences.add(equivalence);
			else
				newEquivalences.addAll(equivalence.partitionByClass());
		return newEquivalences;
	}
	
	public List<Equivalence> partitionByKnown(List<Equivalence> equivalences) {
		List<Equivalence> newEquivalences = new ArrayList<Equivalence>();
		for (Equivalence equivalence : equivalences)
			if (equivalence.isPartitioned())
				newEquivalences.add(equivalence);
			else
				newEquivalences.addAll(equivalence.partitionByKnown(leftToRightMap, rightToLeftMap));
		return newEquivalences;
	}
	
	public List<Equivalence> partitionByName(List<Equivalence> equivalences) {
		List<Equivalence> newEquivalences = new ArrayList<Equivalence>();
		for (Equivalence equivalence : equivalences)
			if (equivalence.isPartitioned() || !equivalence.canPartitionByName())
				newEquivalences.add(equivalence);
			else
				newEquivalences.addAll(equivalence.partitionByName());
		return newEquivalences;
	}
	
	public boolean partitionByOrder(List<Equivalence> equivalences) {
		boolean ok = true;
		for (Equivalence equivalence : equivalences)
			if (!equivalence.partitionByOrder(leftToRightMap, rightToLeftMap))
				ok = false;
		return ok;
	}
	
	public void setURI(URI baseURI) {
		this.baseURI = baseURI;
	}

	public void putEquivalence(EObject leftObject, EObject rightObject) {
//		TestCase.assertNotNull(leftObject);
//		TestCase.assertNotNull(rightObject);
		if (leftObject != null)
			leftToRightMap.put(leftObject, rightObject);
		if (rightObject != null)
			rightToLeftMap.put(rightObject, leftObject);
		helper.putEquivalence(leftObject, rightObject);
	}
}
