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
package org.eclipse.qvt.declarative.parser.utils;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.examples.modelregistry.environment.FileHandle;
import org.eclipse.qvt.declarative.ecore.utils.ClassUtils;
import org.eclipse.qvt.declarative.ecore.utils.EcoreUtils;
import org.eclipse.qvt.declarative.parser.qvt.cst.ErrorNode;
import org.eclipse.qvt.declarative.parser.qvt.cst.QVTCSTFactory;

public class CSTUtils
{	
	@Deprecated
	public static <T> T asClassUnchecked(Object object, T requiredClassObject) {
		return ClassUtils.asClassUnchecked(object, requiredClassObject);
	}

	/**
	 * Return a plausible suggestion for a package namespace for the ePackage within file.
	 */
	public static String computePackageNs(FileHandle file, EPackage ePackage) {
		StringBuilder s = new StringBuilder();
		s.append("http://");
		s.append(file.getProjectHandle().getName());
		s.append("/");
		s.append(file.getProjectRelativeName());
		s.append("/");
		computePackageNs(s, ePackage);
		String string = s.toString();
		return string;
	}

	private static void computePackageNs(StringBuilder s, ENamedElement eNamedElement) {
		EObject eContainer = eNamedElement.eContainer();
		if (eContainer instanceof ENamedElement) {
			computePackageNs(s, (ENamedElement) eContainer);
			s.append(".");
		}
		s.append(eNamedElement.getName());
	}

	@Deprecated
	public static <T extends ENamedElement> T getNamedElement(Collection<T> elements, String name) {
		return EcoreUtils.getNamedElement(elements, name);				
	}

	@Deprecated
	public static <T extends ENamedElement, R extends T> R getNamedElement(Collection<T> elements, String name, Class<R> returnClass) {
		return EcoreUtils.getNamedElement(elements, name, returnClass);				
	}

	public static void setASTErrorNode(CSTNode cstNode, String problemMessage) {
		ErrorNode errorNode = QVTCSTFactory.eINSTANCE.createErrorNode();
		errorNode.setMessage(problemMessage);
		cstNode.setAst(errorNode);
	}

	@Deprecated
	public static String splice(List<String> strings, String separator) {
		return StringUtils.splice(strings, separator);
	}
}
