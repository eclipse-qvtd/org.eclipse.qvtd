/*******************************************************************************
 * Copyright (c) 2007 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvt.declarative.editor.ui.format;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.qvt.declarative.editor.ui.format.IFormatResult.IFormatOption;



/**
 * DebugString supports generation of debug identification of objects, determining a name using
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
public class DefaultFormatManager extends AbstractFormatManager
{
	public static void initialize(IFormatManager manager) {
		FormatENamedElement.initialize(manager);
		FormatEObject.initialize(manager);
		FormatEcoreURI.initialize(manager);
		FormatIStructuredSelection.initialize(manager);
		FormatModelTreeNode.initialize(manager);
		FormatString.initialize(manager);
	}

	public static DefaultFormatManager INSTANCE = new DefaultFormatManager();

	public static String format(Object object) {
		IFormatResult result = new DefaultFormatResult(INSTANCE, null);
		result.format(object);
		return result.toString();
	}

	public static String format(Object object, Map<IFormatOption<?>, Object> options) {
		IFormatResult result = new DefaultFormatResult(INSTANCE, options);
		result.format(object);
		return result.toString();
	}

	public static String formatDebug(Object object) {
		Map<IFormatOption<?>, Object> options = new HashMap<IFormatOption<?>, Object>();
		options.put(IFormatResult.SHOW_CLASS_SIMPLE_NAME, Boolean.TRUE);
		IFormatResult result = new DefaultFormatResult(INSTANCE, options);
		result.format(object);
		return result.toString();
	}
}