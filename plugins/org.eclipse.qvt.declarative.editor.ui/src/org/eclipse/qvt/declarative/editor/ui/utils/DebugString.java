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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.qvt.declarative.editor.ui.plugin.QVTEditorPlugin;

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
public class DebugString
{
	public static DebugString INSTANCE = new DebugString(true);
	
	public static void debugPrintln(String string) {
		System.out.println(string);	
	}
	
	public static String toDebug(Object object) {
		DebugStringBuilder s = new DebugStringBuilder(INSTANCE);
		s.debug(object);
		return s.toString();
	}
	
	protected static class MethodCall {
		protected final Object instance;
		protected final Method method;
		
		public MethodCall(Object instance, Method method) {
			this.instance = instance;
			this.method = method;
		}
		
		public void invoke(DebugStringBuilder s, Object object) {
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
	
	public static void initialize(DebugString debugUtils) {
		DebugString instance = new DebugString(false);
		debugUtils.registerInstanceMethod(instance, "debugBoolean", Boolean.class);
		debugUtils.registerInstanceMethod(instance, "debugEObject", EObject.class);
		debugUtils.registerInstanceMethod(instance, "debugEmptyList", List.class, Collections.EMPTY_LIST.getClass());
		debugUtils.registerInstanceMethod(instance, "debugNumber", Number.class);
		debugUtils.registerInstanceMethod(instance, "debugResource", Resource.class);
		debugUtils.registerInstanceMethod(instance, "debugResourceSet", ResourceSet.class);
		debugUtils.registerInstanceMethod(instance, "debugString", String.class);
		debugUtils.registerInstanceMethod(instance, "debugURI", URI.class);
	}
	
	public Map<Class<?>, MethodCall> map = new HashMap<Class<?>, MethodCall>();
	
	public DebugString(boolean doInit) {
		if (doInit)
			initialize(this);
	}
	
	public void debug(DebugStringBuilder s, Object object) {
		if (object == null) {
			s.append("<null-Object>");
			return;
		}
		if (object instanceof IDebugString) {
			((IDebugString)object).toDebugString(s);
			return;
		}
		MethodCall methodCall = map.get(object.getClass());
		if (methodCall == null) {
			methodCall = getMethod(object.getClass());
			if (methodCall != null)
				map.put(object.getClass(), methodCall);
		}
		if (methodCall != null) {
			methodCall.invoke(s, object);
			return;
		}
		else
			getMethod(object.getClass());		// Debugging
		s.append("<unknown-");
		s.append(object.getClass().getSimpleName());
		s.append(" ");
		s.append(object.toString());
		s.append(">");
	}
	
	public void debugBoolean(DebugStringBuilder s, Boolean object) {
		s.append(object.toString());
	}

	public void debugEObject(DebugStringBuilder s, EObject object) {
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
	
	public void debugEmptyList(DebugStringBuilder s, List<?> object) {
		s.append("<empty-list>");
	}
	
	public void debugNumber(DebugStringBuilder s, Number object) {
		s.append(object.toString());
	}
	
	public void debugResource(DebugStringBuilder s, Resource object) {
		s.append("Resource(");
		debugURI(s, object.getURI());
		s.append(")");
	}
	
	public void debugResourceSet(DebugStringBuilder s, ResourceSet object) {
		s.append("ResourceSet");
	}
	
	public void debugString(DebugStringBuilder s, String object) {
		if (object == null)
			s.append("<null-String>");
		else {
			s.append("'");
			s.append(object);
			s.append("'");
		}
	}
	
	public void debugURI(DebugStringBuilder s, URI object) {
		debugString(s, object.toString());
	}

	public MethodCall getMethod(Class<?> cls) {
		for (Class<?> sCls = cls; sCls != null; sCls = sCls.getSuperclass()) {
			MethodCall methodCall = map.get(sCls);
			if (methodCall != null)
				return methodCall;	
		}
		for (Class<?> iCls : cls.getInterfaces()) {
			MethodCall methodCall = map.get(iCls);
			if (methodCall != null)
				return methodCall;	
		}
		for (Class<?> iCls : cls.getInterfaces()) {
			MethodCall methodCall = getMethod(iCls);
			if (methodCall != null)
				return methodCall;	
		}
		Class<?> sCls = cls.getSuperclass();
		if (sCls != null)
			return getMethod(sCls);
		return null;
	}

	public void registerInstanceMethod(Object instance, String methodName, Class<?> objectClass) {
		registerInstanceMethod(instance, methodName, objectClass, objectClass);
	}

	public void registerInstanceMethod(Object instance, String methodName, Class<?> argClass, Class<?> objectClass) {
		Class<?> staticClass = instance.getClass();
		try {
			Method method = staticClass.getDeclaredMethod(methodName, DebugStringBuilder.class, argClass);
			map.put(objectClass, new MethodCall(instance, method));
		} catch (SecurityException e) {
			QVTEditorPlugin.logError("Failed to register '" + staticClass.getName() + "." + methodName + "'", e);
		} catch (NoSuchMethodException e) {
			QVTEditorPlugin.logError("Failed to register '" + staticClass.getName() + "." + methodName + "'", e);
		}
	}

	public void registerStaticMethod(Class<?> staticClass, String methodName, Class<?> objectClass) {
		registerStaticMethod(staticClass, methodName, objectClass, objectClass);
	}

	public void registerStaticMethod(Class<?> staticClass, String methodName, Class<?> argClass, Class<?> objectClass) {
		try {
			Method method = staticClass.getDeclaredMethod(methodName, DebugStringBuilder.class, argClass);
			map.put(objectClass, new MethodCall(null, method));
		} catch (SecurityException e) {
			QVTEditorPlugin.logError("Failed to register '" + staticClass.getName() + "." + methodName + "'", e);
		} catch (NoSuchMethodException e) {
			QVTEditorPlugin.logError("Failed to register '" + staticClass.getName() + "." + methodName + "'", e);
		}
	}
}