/*******************************************************************************
 * Copyright (c) 2013, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.runtime.evaluation;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * AbstractObjectManager provides the mandatory shared functionality for an object state manager.
 */
public abstract class AbstractObjectManager implements ObjectManager
{
	protected static final @NonNull List<@NonNull SlotState> EMPTY_SLOT_STATE_LIST = Collections.emptyList();

	protected final @NonNull InvocationManager invocationManager;
	protected final boolean debugAssignments = AbstractTransformer.ASSIGNMENTS.isActive();
	protected final boolean debugGettings = AbstractTransformer.GETTINGS.isActive();
	//	protected final boolean debugInvocations = AbstractTransformer.INVOCATIONS.isActive();

	protected AbstractObjectManager(@NonNull InvocationManager invocationManager) {
		this.invocationManager = invocationManager;
	}

	@Override
	public <R> R accept(@NonNull ExecutionVisitor<R> visitor) {
		return visitor.visitObjectManager(this);
	}

	@Deprecated /* @deprecated childKey not used */
	@Override
	public synchronized void assigned(@NonNull Object eObject, /*@NonNull*/ EStructuralFeature eFeature, @Nullable Object ecoreValue, @Nullable Object childKey) {
		assigned(eObject, eFeature, ecoreValue);
	}

	@Deprecated /* @deprecated childKey not used */
	@Override
	public void assigned(Invocation.@NonNull Incremental invocation, @NonNull Object eObject, EStructuralFeature eFeature, @Nullable Object ecoreValue, @Nullable Object childKey) {
		assigned(invocation, eObject, eFeature, ecoreValue);
	}

	/**
	 * Return the string rendering of object for use in debug messages. The default just invokes String.valueOf().
	 * Derived implementations may provide metamodel-specific content.
	 */
	public static @NonNull String toDebugString(@Nullable Object object) {		// FIXME make non-static and usefully overrideable
		if (object == null) {
			return "null";
		}
		StringBuilder s = new StringBuilder();
		if (object instanceof EObject) {
			EClass eClass = ((EObject)object).eClass();
			EPackage ePackage = eClass.getEPackage();
			//			EResource eResource = eClass.eResource();
			s.append(ePackage.getName());
			s.append("::");
			s.append(eClass.getName());
		}
		else {
			String className = object.getClass().getName();
			int index = className.lastIndexOf('.');
			if (index >= 0) {
				className = className.substring(index+1);
			}
			s.append(className);
		}
		s.append("@");
		s.append(Integer.toHexString(System.identityHashCode(object)));
		return s.toString();
	}
}