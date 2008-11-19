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
package org.eclipse.qvt.declarative.editor.ui.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.qvt.declarative.editor.ui.QVTEditorPlugin;
import org.eclipse.qvt.declarative.editor.ui.format.AbstractFormatHelper;
import org.eclipse.qvt.declarative.editor.ui.format.AbstractFormatManager;
import org.eclipse.qvt.declarative.editor.ui.format.DefaultFormatResult;
import org.eclipse.qvt.declarative.editor.ui.format.IFormatResult;

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
public class DebugString extends AbstractFormatManager
{
	public static DebugString INSTANCE = new DebugString(true);
	
	public static void debugPrintln(String string) {
		System.out.println(string);	
	}
	
	public static String format(Object object) {
		DefaultFormatResult s = new DefaultFormatResult(INSTANCE, null);
		s.format(object);
		return s.toString();
	}
	
	public static String toDebug(Object object) {
		return format(object);
	}
	
	protected static class MethodCall<T> extends AbstractFormatHelper<T>
	{
		protected final Object instance;
		protected final Method method;
		
		public MethodCall(DebugString debugger, Class<T> debuggedClass, T instance, Method method) {
			super(debugger, debuggedClass);
			this.instance = instance;
			this.method = method;
		}

		public void format(IFormatResult s, Object object) {
			try {
				method.invoke(instance, s, object);
			} catch (IllegalArgumentException e) {
				QVTEditorPlugin.logError("Failed to invoke '" + method.getName() + "'", e);
			} catch (IllegalAccessException e) {
				QVTEditorPlugin.logError("Failed to invoke '" + method.getName() + "'", e);
			} catch (InvocationTargetException e) {
				QVTEditorPlugin.logError("Failed to invoke '" + method.getName() + "'", e);
			}
		}
	}
	
	public static void initialize(DebugString debugger) {
		DebugString instance = new DebugString(false);
		debugger.registerInstanceMethod(instance, "debugBoolean", Boolean.class);
		debugger.registerInstanceMethod(instance, "debugEObject", EObject.class);
		debugger.registerInstanceMethod(instance, "debugEmptyList", List.class, Collections.EMPTY_LIST.getClass());
		debugger.registerInstanceMethod(instance, "debugNumber", Number.class);
		debugger.registerInstanceMethod(instance, "debugResource", Resource.class);
		debugger.registerInstanceMethod(instance, "debugResourceSet", ResourceSet.class);
		debugger.registerInstanceMethod(instance, "debugString", String.class);
		debugger.registerInstanceMethod(instance, "debugURI", URI.class);
	}
	
	public DebugString(boolean doInit) {
		if (doInit)
			initialize(this);
	}
	
	public void debugBoolean(DefaultFormatResult s, Boolean object) {
		s.append(object.toString());
	}

	public void debugEObject(DefaultFormatResult s, EObject object) {
		if (object == null) {
			s.append("<null-EObject>");
			return;
		}
		if (object.eIsProxy()) {
			debugURI(s, EcoreUtil.getURI(object));
			return;
		}
		if (object.eContainer() != null) {
			debugEObject(s, object.eContainer());
			s.append("/");
		}
		if (object instanceof ENamedElement) {
			String name = ((ENamedElement)object).getName();
			if (name != null)
				s.append(name);
			else {
				s.append("<null-named-");
				s.append(object.getClass().getSimpleName());
				s.append(">");
			}
		}
		else {
			s.append("<unnamed-");
			s.append(object.getClass().getSimpleName());
			s.append(">");
		}
	}
	
	public void debugEmptyList(DefaultFormatResult s, List<?> object) {
		s.append("<empty-list>");
	}
	
	public void debugNumber(DefaultFormatResult s, Number object) {
		s.append(object.toString());
	}
	
	public void debugResource(DefaultFormatResult s, Resource object) {
		s.append("Resource(");
		debugURI(s, object.getURI());
		s.append(")");
	}
	
	public void debugResourceSet(DefaultFormatResult s, ResourceSet object) {
		s.append("ResourceSet");
	}
	
	public void debugString(DefaultFormatResult s, String object) {
		if (object == null)
			s.append("<null-String>");
		else {
			s.append("'");
			s.append(object);
			s.append("'");
		}
	}
	
	public void debugURI(DefaultFormatResult s, URI object) {
		debugString(s, object.toString());
	}

	public <T> void registerInstanceMethod(Object instance, String methodName, Class<T> objectClass) {
		registerInstanceMethod(instance, methodName, objectClass, objectClass);
	}

	public <T> void registerInstanceMethod(Object instance, String methodName, Class<?> argClass, Class<T> objectClass) {
		Class<?> staticClass = instance.getClass();
		try {
			Method method = staticClass.getDeclaredMethod(methodName, DefaultFormatResult.class, argClass);
			install(new MethodCall<T>(this, objectClass, (T)instance, method));
		} catch (SecurityException e) {
			QVTEditorPlugin.logError("Failed to register '" + objectClass.getName() + "." + methodName + "'", e);
		} catch (NoSuchMethodException e) {
			QVTEditorPlugin.logError("Failed to register '" + objectClass.getName() + "." + methodName + "'", e);
		}
	}

	public <T> void registerStaticMethod(Class<T> staticClass, String methodName) {
		registerStaticMethod(staticClass, methodName, staticClass);
	}

	public <T> void registerStaticMethod(Class<T> staticClass, String methodName, Class<?> argClass) {
		try {
			Method method = staticClass.getDeclaredMethod(methodName, DefaultFormatResult.class, argClass);
			install(new MethodCall<T>(this, staticClass, null, method));
		} catch (SecurityException e) {
			QVTEditorPlugin.logError("Failed to register '" + staticClass.getName() + "." + methodName + "'", e);
		} catch (NoSuchMethodException e) {
			QVTEditorPlugin.logError("Failed to register '" + staticClass.getName() + "." + methodName + "'", e);
		}
	}
}