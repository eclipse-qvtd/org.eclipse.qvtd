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

import java.io.PrintStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.qvt.declarative.ecore.adapters.AdaptingEObject;
import org.eclipse.qvt.declarative.ecore.mappings.MappingUtils;
import org.eclipse.qvt.declarative.ecore.utils.EcoreUtils;
import org.eclipse.qvt.declarative.emof.EMOF.NamedElement;
import org.eclipse.qvt.declarative.test.emof.HTMLStream;

/**
 * An EquivalenceHelper provides model-specific assistance when comparing models.
 */
public abstract class EquivalenceHelper
{
	protected HTMLStream htmlStream = null;
	protected PrintStream logStream = null;
	private final Map<EObject, EObject> leftToRightMap = new HashMap<EObject, EObject>();
	private final Map<EObject, EObject> rightToLeftMap = new HashMap<EObject, EObject>();
	
	public EquivalenceHelper(HTMLStream htmlStream, PrintStream logStream) {
		this.htmlStream = htmlStream;
		this.logStream = logStream;
	}

	public abstract boolean canPartitionByName(EClass eClass);

	public EcoreDifference createDifference(EObject context, EStructuralFeature feature,
			Object leftObject, Object rightObject, String reason) {
		return new EcoreDifference(this, context, feature, leftObject, rightObject, reason);
	}

	public boolean equals(EObject leftObject, EObject rightObject) {
		if (leftObject.eClass() != rightObject.eClass())
			return false;
		if (!(leftObject instanceof ENamedElement))
			return false;
		if (!(rightObject instanceof ENamedElement))
			return false;
		return sameObject(leftObject, rightObject);
	}

	public String formatDifference(EObject object, EStructuralFeature feature, Object left1, Object right) {
		Object left = object.eGet(feature, false);
		StringBuffer s = new StringBuffer();
		s.append("'");
		s.append(MappingUtils.formatLocalName(feature));
		s.append("' for ");
		s.append(MappingUtils.formatClassAndFeatureName(object));
		s.append(" should be ");
		MappingUtils.formatObject(s, left);
		s.append(" rather than ");
		if (right == null)
			s.append("undefined");
		else if ((right instanceof Collection<?>) && ((Collection<?>) right).isEmpty())
			s.append("nothing");
		else
			MappingUtils.formatObject(s, right);
		return s.toString();
	}
	
	public String formatFeatureName(EStructuralFeature eFeature) {
		return MappingUtils.formatFeatureName(eFeature);
	}

	public String formatFullName(Object object) {
		return MappingUtils.formatFullName(object);
	}

	public String formatLocalName(Object object) {
		if (object instanceof AdaptingEObject)
			object = ((AdaptingEObject) object).getTarget();
		if (object instanceof NamedElement)
			return formatString(((NamedElement)object).getName());
		return MappingUtils.formatLocalName(object);
	}

	public String formatString(Object object) {
		return MappingUtils.formatString(object);
	}

//	public EObject getLeft(EObject rightObject) { return rightToLeftMap.get(rightObject); }

	public abstract String getName(EObject eObject);

	public EObject getRight(EObject leftObject) {
		if (leftObject == null)
			return null;
		EObject mappedRight = leftToRightMap.get(leftObject);
		if (mappedRight != null)
			return mappedRight;
		EObject leftContainer = leftObject.eContainer();
		if (leftContainer == null)
			return null;
		EObject rightContainer = getRight(leftContainer);
		if (rightContainer == null)
			return null;
		EStructuralFeature containingFeature = leftObject.eContainingFeature();
		Object rightFeatures = rightContainer.eGet(containingFeature, false);
		if (!containingFeature.isMany())
			return (EObject) rightFeatures;
		if (leftObject instanceof ENamedElement) {
			@SuppressWarnings("unchecked")
			Collection<ENamedElement> castRightFeatures = (Collection<ENamedElement>)rightFeatures;
			return EcoreUtils.getNamedElement(castRightFeatures, ((ENamedElement) leftObject).getName());
		}
		TestCase.fail("Need name : " + MappingUtils.formatFullName(leftObject));
		return null;		
	}
	
	/**
	 * Suppress comparison of an eClass-specific eFeature, optionally in a leftObject or rightObject-specific fashion, by returning false.
	 */
	public abstract boolean isComparable(EClass eClass, EStructuralFeature eFeature, EObject leftObject, EObject rightObject);

	public abstract boolean isOrdered(EStructuralFeature feature);

	protected boolean sameObject(EObject leftObject, EObject rightObject) {
		EObject mappedRightObject = getRight(leftObject);
		if (mappedRightObject == rightObject)
			return true;
		if ((leftObject.eContainer() != null) != (rightObject.eContainer() != null))
			return false;
		ENamedElement leftNamedElement = (ENamedElement) leftObject;
		ENamedElement rightNamedElement = (ENamedElement) rightObject;
		String leftName = leftNamedElement.getName();
		String rightName = rightNamedElement.getName();
		if ((leftName != null) != (rightName != null))
			return false;
		if ((leftName != rightName) && ((leftName == null) || !leftName.equals(rightName)))
			return false;
		if (leftObject.eContainer() == null)
			return true;
		return equals(leftObject.eContainer(), rightObject.eContainer());
	}

	public void println(String string) {
		if (logStream != null) {
			if (htmlStream != null)
				htmlStream.printDifferenceLine(string);		
			logStream.println(string);
		}
	}

	public void putEquivalence(EObject leftObject, EObject rightObject) {
		leftToRightMap.put(leftObject, rightObject);
		rightToLeftMap.put(rightObject, leftObject);
	}

	public void setLogStream(PrintStream logStream) {
		if (this.logStream != null)
			this.logStream.close();
		this.logStream = logStream;		
	}
}
