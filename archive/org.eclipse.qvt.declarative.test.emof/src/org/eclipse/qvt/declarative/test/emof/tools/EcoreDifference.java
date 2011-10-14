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

import junit.framework.TestCase;

import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

public class EcoreDifference implements Comparable<EcoreDifference>
{
	protected final EquivalenceHelper helper;
	protected final EObject context;
	protected final EStructuralFeature feature;
	protected final Object leftObject;
	protected final Object rightObject;
	protected final String reason;
	
	public EcoreDifference(EquivalenceHelper helper, EObject context, EStructuralFeature feature, Object leftObject, Object rightObject, String reason) {
		this.helper = helper;
		this.context = context;
		this.feature = feature;
		this.leftObject = leftObject;
		this.rightObject = rightObject;
		this.reason = reason;
	}

	public void assertDifference(EStructuralFeature feature, Object leftObject, Object rightObject, String reason) {
		TestCase.assertEquals("Feature ", feature, this.feature);
		TestCase.assertEquals("Left object ", leftObject, this.leftObject);
		TestCase.assertEquals("Right object ", rightObject, this.rightObject);		
		if (reason != null)
			TestCase.assertEquals("Right object ", reason, this.reason);		
	}

	public int compareTo(EcoreDifference o) {
		if (feature != o.feature) {
			if (feature == null)
				return -1;
			else if (o.feature == null)
				return 1;
			else if (feature.eContainer() != o.feature.eContainer())
				return ((ENamedElement) feature.eContainer()).getName().compareTo(((ENamedElement) o.feature.eContainer()).getName());
			else
				return feature.getName().compareTo(o.feature.getName());
		}
		else if (leftObject != o.leftObject) {
			if (leftObject == null)
				return -1;
			else if (o.leftObject == null)
				return 1;
			else
				return leftObject.hashCode() - o.leftObject.hashCode();
		}
		else if (rightObject != o.rightObject) {
			if (rightObject == null)
				return -1;
			else if (o.rightObject == null)
				return 1;
			else
				return rightObject.hashCode() - o.rightObject.hashCode();
		}
		else if (reason != o.reason) {
			if (reason == null)
				return -1;
			else if (o.reason == null)
				return 1;
			else
				return reason.compareTo(o.reason);
		}
		return hashCode() - o.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof EcoreDifference))
			return false;
		if (!equals(helper, ((EcoreDifference)obj).helper))
			return false;
		if (!equals(context, ((EcoreDifference)obj).context))
			return false;
		if (!equals(feature, ((EcoreDifference)obj).feature))
			return false;
		if (!equals(leftObject, ((EcoreDifference)obj).leftObject))
			return false;
		if (!equals(rightObject, ((EcoreDifference)obj).rightObject))
			return false;
		if (!equals(reason, ((EcoreDifference)obj).reason))
			return false;
		return true;
	}

	private boolean equals(Object a, Object b) {
		if ((a != null) != (b != null))
			return false;
		if (a == null)
			return true;
		return a.equals(b);
	}

	@Override
	public int hashCode() {
		return hashCode(helper)
		     + hashCode(context)
		     + hashCode(feature)
		     + hashCode(leftObject)
		     + hashCode(rightObject)
		     + hashCode(reason);
	}

	private int hashCode(Object object) {
		return object != null ? object.hashCode() : 0;
	}
	
	public boolean isSameLeftElseRight(Object obj) {
		if (!(obj instanceof EcoreDifference))
			return false;
		if (!equals(helper, ((EcoreDifference)obj).helper))
			return false;
		if (!equals(context, ((EcoreDifference)obj).context))
			return false;
		if (!equals(feature, ((EcoreDifference)obj).feature))
			return false;
		if (!equals(leftObject, ((EcoreDifference)obj).leftObject))
			return false;
		if ((leftObject == null) && !equals(rightObject, ((EcoreDifference)obj).rightObject))
			return false;
		if (!equals(reason, ((EcoreDifference)obj).reason))
			return false;
		return true;
	}

	@Override public String toString() {
		StringBuffer s = new StringBuffer();
		s.append("Unmatched ");
		if (leftObject != null)
			s.append("left");
		if ((leftObject != null) && (rightObject != null))
			s.append("/");
		if (rightObject != null)
			s.append("right");
		s.append(" ");
		if (feature == null)
			s.append("object");
		else {
			if (context != null)
				s.append(helper.formatFullName(context));
			s.append("/");
			s.append(helper.formatFeatureName(feature));
		}
		s.append(" : ");
		if (leftObject != null)
			s.append(helper.formatFullName(leftObject));
		if ((leftObject != null) && (rightObject != null))
			s.append(" : ");
		if (rightObject != null)
			s.append(helper.formatFullName(rightObject));
		if (reason != null) {
			s.append(" : ");
			s.append(reason);
		}
		return s.toString();
	}
}
