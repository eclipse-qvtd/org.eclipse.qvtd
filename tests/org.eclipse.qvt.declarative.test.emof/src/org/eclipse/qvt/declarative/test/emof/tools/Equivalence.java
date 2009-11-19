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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * An Equivalence groups a set of left and a set of right objects from an Ecore model
 * that have yet to be distinguished. Partitioning breaks an equivalence into a smaller
 * ideally single entry groups.
 */
public class Equivalence
{
	protected final EquivalenceHelper helper;
	protected final EClass eClass;
	private List<EObject> lefts = new ArrayList<EObject>();
	private List<EObject> rights = new ArrayList<EObject>();
	
	protected Equivalence(EquivalenceHelper helper, EClass eClass, EObject left, EObject right) {
		this.helper = helper;
		this.eClass = eClass;
		addLeft(left);
		addRight(right);
	}
	
	public Equivalence(EquivalenceHelper helper, List<EObject> lefts, List<EObject> rights) {
		this.helper = helper;
		this.eClass = null;
//		assert ((lefts != null) && (lefts.size() > 0)) || ((rights != null) && (rights.size() > 0));
		if (lefts != null)
			for (EObject left : lefts)
				addLeft(left);
		if (rights != null)
			for (EObject right : rights)
				addRight(right);
	}
	
	private void add(Equivalence equivalence) {
		if (equivalence.lefts != null)
			for (EObject left : equivalence.lefts)
				addLeft(left);		
		if (equivalence.rights != null)
			for (EObject right : equivalence.rights)
				addRight(right);		
	}


	private void addLeft(EObject left) {
		if (left != null) {
			assert (eClass == null) || (left.eClass() == eClass);
			lefts.add(left);
		}
	}

	private void addRight(EObject right) {
		if (right != null) {
			assert (eClass == null) || (right.eClass() == eClass);
			rights.add(right);
		}
	}
	
	public boolean canPartitionByName() {
		return helper.canPartitionByName(eClass);
	}

//	public List<EObject> getLefts() {
//		return lefts;
//	}

//	public List<EObject> getRights() {
//		return rights;
//	}

	public boolean isPartitioned() {
		return (lefts.size() <= 1) && (rights.size() <= 1);
	}
	
	/**
	 * Separate off same-class left/right equivalences. Mismatches are distinct.
	 * @return
	 */
	public List<Equivalence> partitionByClass() {
		List<EClass> eClasses = new ArrayList<EClass>();
		Map<EClass, Equivalence> resultMap = new HashMap<EClass, Equivalence>();
		if (lefts != null) {
			for (EObject left : lefts) {
				EClass leftClass = left.eClass();
				Equivalence leftEquivalence = resultMap.get(leftClass);
				if (leftEquivalence == null) {
					eClasses.add(leftClass);
					leftEquivalence = new Equivalence(helper, leftClass, left, null);
					resultMap.put(leftClass, leftEquivalence);
				}
				else
					leftEquivalence.addLeft(left);
			}				
		}
		if (rights != null) {
			for (EObject right : rights) {
				EClass rightClass = right.eClass();
				Equivalence rightEquivalence = resultMap.get(rightClass);
				if (rightEquivalence == null) {
					eClasses.add(rightClass);
					rightEquivalence = new Equivalence(helper, rightClass, null, right);
					resultMap.put(rightClass, rightEquivalence);
				}
				else
					rightEquivalence.addRight(right);
			}				
		}
		List<Equivalence> results = new ArrayList<Equivalence>();
		for (EClass eClass : eClasses)
			results.add(resultMap.get(eClass));
		return results;
	}
	
	/**
	 * Separate off known left-null/null-right equivalences.
	 * @return
	 */
	public List<Equivalence> partitionByKnown(Map<EObject, EObject> leftToRightMap, Map<EObject, EObject> rightToLeftMap) {
		List<Equivalence> newEquivalences = new ArrayList<Equivalence>();
		Equivalence residualEquivalence = null;
		List<EObject> residualRights = new ArrayList<EObject>(rights);
		for (EObject left : lefts) {
			EObject right = leftToRightMap.get(left);
			if ((right != null) && residualRights.contains(right)) {
				newEquivalences.add(new Equivalence(helper, eClass, left, right));
				residualRights.remove(right);
			}
			else if ((right == null) && leftToRightMap.containsKey(left)) {
				newEquivalences.add(new Equivalence(helper, eClass, left, null));
			}
			else {
				if (residualEquivalence == null) {
					residualEquivalence = new Equivalence(helper, eClass, null, null);
					newEquivalences.add(residualEquivalence);
				}
				residualEquivalence.addLeft(left);
			}
		}
		for (EObject right : residualRights) {
			if ((rightToLeftMap.get(right) == null) && rightToLeftMap.containsKey(right)) {
				newEquivalences.add(new Equivalence(helper, eClass, null, right));
			}
			else {
				if (residualEquivalence == null) {
					residualEquivalence = new Equivalence(helper, eClass, null, null);
					newEquivalences.add(residualEquivalence);
				}
				residualEquivalence.addRight(right);
			}
		}
		return newEquivalences;
	}

	/**
	 * Separate off same-named left/right equivalences. Mismatches remain grouped,
	 * potentially allowing a name change to be a single difference rather than a create+destroy.
	 * @return
	 */
	public List<Equivalence> partitionByName() {
		List<String> names = new ArrayList<String>();
		Map<String, Equivalence> resultMap = new HashMap<String, Equivalence>();
		if (lefts != null) {
			for (EObject left : lefts) {
				String name = helper.getName(left);
				Equivalence leftEquivalence = resultMap.get(name);
				if (leftEquivalence == null) {
					names.add(name);
					leftEquivalence = new Equivalence(helper, left.eClass(), left, null);
					resultMap.put(name, leftEquivalence);
				}
				else
					leftEquivalence.addLeft(left);
			}				
		}
		if (rights != null) {
			for (EObject right : rights) {
				String name = helper.getName(right);
				Equivalence rightEquivalence = resultMap.get(name);
				if (rightEquivalence == null) {
					names.add(name);
					rightEquivalence = new Equivalence(helper, right.eClass(), null, right);
					resultMap.put(name, rightEquivalence);
				}
				else
					rightEquivalence.addRight(right);
			}				
		}
		List<Equivalence> results = new ArrayList<Equivalence>();
		Equivalence oddsAndSods = null;
		for (String name : names) {
			Equivalence equivalence = resultMap.get(name);
			if ((equivalence.lefts != null) && (equivalence.lefts.size() > 0) && (equivalence.rights != null) && (equivalence.rights.size() > 0))
				results.add(equivalence);
			else if (oddsAndSods == null)
				oddsAndSods = equivalence;
			else
				oddsAndSods.add(equivalence);
		}
		if (oddsAndSods != null)
			results.add(oddsAndSods);
		return results;
	}

	/**
	 * Last ditch partitioning just pairing left and right in linear order.
	 * @param leftToRightMap
	 * @param rightToLeftMap
	 * @return
	 */
	public boolean partitionByOrder(Map<EObject, EObject> leftToRightMap, Map<EObject, EObject> rightToLeftMap) {
		int leftMax = lefts.size();
		int rightMax = rights.size();
		int iMax = Math.min(leftMax, rightMax);
		int i = 0;
		for ( ; i < iMax; i++) {
			EObject left = lefts.get(i);
			EObject right = rights.get(i);
			leftToRightMap.put(left, right);
			rightToLeftMap.put(right, left);
		}
		for ( ; i < leftMax; i++)
			leftToRightMap.put(lefts.get(i), null);
		for ( ; i < rightMax; i++)
			rightToLeftMap.put(rights.get(i), null);
		return true;
	}
	
	@Override public String toString() {
		StringBuffer s = new StringBuffer();
		s.append("lefts:");
		for (EObject left : lefts) {
			s.append(" ");
			s.append(helper.formatFullName(left));
		}
		s.append("\n");
		s.append("rights:");
		for (EObject right : rights) {
			s.append(" ");
			s.append(helper.formatFullName(right));
		}
		return s.toString();
	}
}
