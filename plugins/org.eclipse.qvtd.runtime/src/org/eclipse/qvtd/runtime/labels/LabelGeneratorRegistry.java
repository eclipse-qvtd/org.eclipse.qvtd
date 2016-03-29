/*******************************************************************************
 * Copyright (c) 2010, 2014 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.runtime.labels;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.labels.ILabelGenerator;

/**
 * DebugString supports generation of debug identification of objects, determining a name usuing
 * the following alternatives.
 * <br>The null object is identified as <null-Object>
 * <br>Implementers of IDebugString are identified by IDebugString.toDebugString();
 * <br>MethodCall registrations in DebugUtils are identified by MethodCall.invoke().
 * <br>Other objects are identified as <unknown-'class-name' 'object.toString()'>
 * <p>
 * MethodCall registrations may be made via registerInstanceMethod or registerStaticMethod.
 * <p>
 * A debug string may be obtained via DebugString.toDebug(object).
 * <p>
 * DebugString providers string formatters for simple classes such as String, Number, Boolean
 * and Ecore components such as EObject, Resource and ResourceSet.
 * <p>
 * User extensions should be registered prior to use. Beware that late registration can
 * give misleading results since in the absence of an exact MethodCall registration the
 * class hierarchy is search first for base classes then for instances for which there
 * is an exact MethodCall match. This result is then cached and so may occlude a late
 * registration.
 */
public class LabelGeneratorRegistry
{	
	public static void initialize(ILabelGenerator.@NonNull Registry registry) {
		TransformationInstanceLabelGenerator.initialize(registry);
		TypedModelInstanceLabelGenerator.initialize(registry);
	}
}