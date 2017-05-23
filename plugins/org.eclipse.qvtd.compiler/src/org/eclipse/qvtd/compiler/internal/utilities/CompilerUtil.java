/*******************************************************************************
 * Copyright (c) 2016, 2017 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.utilities;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.impl.BasicEObjectImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EcoreUtil.UnresolvedProxyCrossReferencer;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.codegen.generator.CodeGenerator;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.utilities.LabelUtil;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.Nameable;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.qvtd.compiler.CompilerChainException;

public class CompilerUtil
{
	public final static @NonNull Map<Object, Object> defaultSavingOptions;

	// FIXME use a better default strategy for the saving options
	static {
		defaultSavingOptions = new HashMap<Object, Object>();
		defaultSavingOptions.put(XMLResource.OPTION_ENCODING, "UTF-8");
		defaultSavingOptions.put(XMLResource.OPTION_LINE_DELIMITER, "\n");
		defaultSavingOptions.put(XMLResource.OPTION_SCHEMA_LOCATION, Boolean.TRUE);
		defaultSavingOptions.put(XMLResource.OPTION_SCHEMA_LOCATION_IMPLEMENTATION, Boolean.TRUE);
		defaultSavingOptions.put(XMLResource.OPTION_LINE_WIDTH, Integer.valueOf(132));

	}

	public static void assertNoResourceErrors(@NonNull String prefix, @NonNull Resource resource) {
		String message = PivotUtil.formatResourceDiagnostics(resource.getErrors(), prefix, "\n\t");
		if (message != null)
			assert false : message;
	}

	public static void assertNoResourceSetErrors(@NonNull String prefix, @NonNull Resource resource) {
		ResourceSet resourceSet = resource.getResourceSet();
		assert resourceSet != null : prefix + " no ResourceSet for " + resource;
		for (Resource aResource : resourceSet.getResources()) {
			if (aResource != null) {
				assertNoResourceErrors(prefix, aResource);
			}
		}
	}

	public static void assertNoUnresolvedProxies(String message, Resource resource) {
		Map<EObject, Collection<Setting>> unresolvedProxies = UnresolvedProxyCrossReferencer.find(resource);
		if (unresolvedProxies.size() > 0) {
			StringBuilder s = new StringBuilder();
			s.append(unresolvedProxies.size());
			s.append(" unresolved proxies in '" + resource.getURI() + "' ");
			s.append(message);
			for (Map.Entry<EObject, Collection<Setting>> unresolvedProxy : unresolvedProxies.entrySet()) {
				s.append("\n");
				BasicEObjectImpl key = (BasicEObjectImpl) unresolvedProxy.getKey();
				s.append(key.eProxyURI());
				for (Setting setting : unresolvedProxy.getValue()) {
					s.append("\n\t");
					EObject eObject = setting.getEObject();
					s.append(eObject.toString());
				}
			}
			assert false : s.toString();
		}
	}

	public static void assertNoValidationErrors(@NonNull String prefix, @NonNull Resource resource) {
		for (EObject eObject : resource.getContents()) {
			assertNoValidationErrors(prefix, eObject);
		}
	}

	public static void assertNoValidationErrors(@NonNull String string, EObject eObject) {
		Map<Object, Object> validationContext = LabelUtil.createDefaultContext(Diagnostician.INSTANCE);
		Diagnostic diagnostic = Diagnostician.INSTANCE.validate(eObject, validationContext);
		List<Diagnostic> children = diagnostic.getChildren();
		if (children.size() <= 0) {
			return;
		}
		StringBuilder s = new StringBuilder();
		s.append(children.size() + " validation errors");
		for (Diagnostic child : children){
			s.append("\n\t");
			if (child.getData().size() > 0) {
				Object data = child.getData().get(0);
				if (data instanceof Element) {
					for (EObject eScope = (Element)data; eScope instanceof Element; eScope = eScope.eContainer()) {
						/*						ModelElementCS csElement = ElementUtil.getCsElement((Element)eScope);
						if (csElement != null) {
							ICompositeNode node = NodeModelUtils.getNode(csElement);
							if (node != null) {
								Resource eResource = csElement.eResource();
								if (eResource != null) {
									s.append(eResource.getURI().lastSegment() + ":");
								}
								int startLine = node.getStartLine();
								s.append(startLine + ":");
							}
							s.append(((Element)data).eClass().getName() + ": ");
							break;
						} */
					}
				}
			}
			s.append(child.getMessage());
		}
		assert false : s.toString();
	}

	public static void indent(@NonNull StringBuilder s, int depth) {
		for (int i = 0; i < depth; i++) {
			s.append("    ");
		}
	}

	/**
	 * Normalize a list of ENamedElement by sorting according to their name.
	 *
	public static void normalize(@NonNull List<@NonNull ? extends ENamedElement> nameables) {
		if (nameables instanceof EList<?>) {
			ECollections.sort((EList<? extends ENamedElement>)nameables, NameUtil.ENamedElementComparator.INSTANCE);
		}
		else {
			Collections.sort(nameables, NameUtil.ENamedElementComparator.INSTANCE);
		}
	} */

	/**
	 * Normalize a list of Nameable by sorting according to their name.
	 */
	public static void normalizeNameables(@NonNull List<@NonNull ? extends Nameable> nameables) {
		if (nameables instanceof EList<?>) {
			ECollections.sort((EList<? extends Nameable>)nameables, NameUtil.NAMEABLE_COMPARATOR);
		}
		else {
			Collections.sort(nameables, NameUtil.NAMEABLE_COMPARATOR);
		}
	}

	public static <T> void removeAll(@NonNull Collection<T> removeFrom, @NonNull Iterable<T> elementsToTemove) {
		for (T element : elementsToTemove) {
			removeFrom.remove(element);
		}
	}

	public static void throwExceptionWithProblems(@NonNull CodeGenerator codeGenerator, @NonNull Exception e) throws Exception {
		List<@NonNull Exception> problems = codeGenerator.getProblems();
		if (problems != null) {
			StringBuilder s = new StringBuilder();
			for (@NonNull Exception ex : problems) {
				s.append(ex.toString() + "\n");
			}
			s.append(e.toString());
			throw new CompilerChainException(e, s.toString());
		}
		else {
			throw e;
		}
	}
}