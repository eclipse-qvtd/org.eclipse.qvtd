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
public abstract class AbstractFormatManager implements IFormatManager
{	
	private Map<Class<?>, IFormatHelper<?>> map = new HashMap<Class<?>, IFormatHelper<?>>();
	
	public <T> void format(IFormatResult s, T object) {
		if (object == null) {
			s.append("<null-Object>");
			return;
		}
		Boolean showClassName = s.getOption(IFormatResult.SHOW_CLASS_NAME);
		if ((showClassName != null) && showClassName) {
			s.append(object.getClass().getName());
			s.append(" ");
		}
		else {
			Boolean showClassSimpleName = s.getOption(IFormatResult.SHOW_CLASS_SIMPLE_NAME);
			if ((showClassSimpleName != null) && showClassSimpleName) {
				s.append(object.getClass().getSimpleName());
				s.append(" ");
			}			
		}
		if (object instanceof IFormatSelf) {
			((IFormatSelf)object).format(s);
			return;
		}
		subformat(s, object);
	}

	public IFormatHelper<?> get(Class<?> formattedClass) {
		return map.get(formattedClass);
	}

	protected IFormatHelper<?> getFormatHelper(Class<?> cls) {
		for (Class<?> sCls = cls; sCls != null; sCls = sCls.getSuperclass()) {
			IFormatHelper<?> methodCall = map.get(sCls);
			if (methodCall != null)
				return methodCall;	
		}
		for (Class<?> iCls : cls.getInterfaces()) {
			IFormatHelper<?> methodCall = map.get(iCls);
			if (methodCall != null)
				return methodCall;	
		}
		for (Class<?> iCls : cls.getInterfaces()) {
			IFormatHelper<?> methodCall = getFormatHelper(iCls);
			if (methodCall != null)
				return methodCall;	
		}
		Class<?> sCls = cls.getSuperclass();
		if (sCls != null)
			return getFormatHelper(sCls);
		return null;
	}

	public void install(IFormatHelper<?> debugClass) {
		map.put(debugClass.getFormattedClass(), debugClass);
	}

	public <T> void subformat(IFormatResult s, T object) {
		if (object == null) {
			s.append("<null-Object>");
			return;
		}
		IFormatHelper<?> formatHelper = map.get(object.getClass());
		if (formatHelper == null) {
			formatHelper = getFormatHelper(object.getClass());
			if (formatHelper != null)
				map.put(object.getClass(), formatHelper);
		}
		if (formatHelper != null) {
			@SuppressWarnings("unchecked")
			IFormatHelper<T> castFormatHelper = (IFormatHelper<T>) formatHelper;
			castFormatHelper.format(s, object);
			return;
		}
		else
			getFormatHelper(object.getClass());		// Debugging
		s.append("<unknown-");
		s.append(object.getClass().getSimpleName());
		s.append(" ");
		s.append(object.toString());
		s.append(">");
	}
}