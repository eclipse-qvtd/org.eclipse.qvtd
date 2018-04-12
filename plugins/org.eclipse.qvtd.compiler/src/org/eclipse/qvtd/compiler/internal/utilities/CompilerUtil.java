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

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.impl.BasicEObjectImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EcoreUtil.UnresolvedProxyCrossReferencer;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.dynamic.JavaFileUtil;
import org.eclipse.ocl.examples.codegen.generator.CodeGenerator;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableExp;
import org.eclipse.ocl.pivot.ids.OperationId;
import org.eclipse.ocl.pivot.utilities.LabelUtil;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.Nameable;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.utilities.StringUtil;
import org.eclipse.qvtd.compiler.CompilerChainException;
import org.eclipse.qvtd.compiler.CompilerProblem;
import org.eclipse.qvtd.compiler.internal.qvtm2qvts.RegionProblem;
import org.eclipse.qvtd.pivot.qvtcore.QVTcorePackage;
import org.eclipse.qvtd.pivot.qvtcore.VariableAssignment;
import org.eclipse.qvtd.pivot.qvtschedule.Region;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

import com.google.common.collect.Lists;

public class CompilerUtil extends QVTscheduleUtil
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

	/**
	 * Return a new list of project names that need to be on the class path.
	 */
	public static @NonNull List<@NonNull String> createClasspathProjectNameList(@NonNull String... projectNames) {
		List<@NonNull String> classProjectNames = new ArrayList<>();
		classProjectNames.add("org.eclipse.qvtd.runtime");
		classProjectNames.add("org.eclipse.ocl.pivot");
		classProjectNames.add("org.eclipse.emf.ecore");
		classProjectNames.add("org.eclipse.emf.common");
		classProjectNames.add("org.eclipse.jdt.annotation");
		classProjectNames.add("org.eclipse.osgi");
		if (projectNames != null) {
			for (@NonNull String projectName : projectNames) {
				classProjectNames.add(0, projectName);
			}
		}
		return classProjectNames;
	}

	public static @NonNull List<@NonNull String> createClassPathProjectList(@NonNull URIConverter uriConverter, @NonNull List<@NonNull String> projectNames) {
		List<@NonNull String> classpathProjectList = new ArrayList<@NonNull String>();
		for (@NonNull String projectName : projectNames) {
			File path = JavaFileUtil.getProjectBinFolder(uriConverter, projectName);
			if (path != null) {
				classpathProjectList.add(String.valueOf(path));
			}
		}
		//		}
		return classpathProjectList;
	}

	/**
	 * Return the classpath folders corresponding to the projectNames, except that the projectName uses an explicit and
	 * possibly irregular classFilePath allowing the current project to use a non-standard 'bin' folder to avoid confusion
	 * between the test compilation and the auto-build.
	 */
	public static @NonNull List<@NonNull String> createClassPathProjectList(@NonNull URIConverter uriConverter, @NonNull String projectName,
			@NonNull String classFilePath, @Nullable Iterable<@NonNull String> projectNames) {
		assert EcorePlugin.IS_ECLIPSE_RUNNING;
		if (projectNames == null) {
			projectNames = CompilerUtil.createClasspathProjectNameList(projectName);
		}
		List<@NonNull String> projectNames2 = Lists.newArrayList(projectNames);
		projectNames2.remove(projectName);
		List<@NonNull String> classpathProjects = JavaFileUtil.createClassPathProjectList(uriConverter, projectNames2);
		classpathProjects.add(0, classFilePath);
		return classpathProjects;
	}

	public static @NonNull RegionProblem createRegionError(@NonNull Region region, @NonNull String messageTemplate, Object... bindings) {
		String boundMessage = StringUtil.bind(messageTemplate, bindings);
		return new RegionProblem(CompilerProblem.Severity.ERROR, region, boundMessage);
	}

	public static @NonNull RegionProblem createRegionWarning(@NonNull Region region, @NonNull String messageTemplate, Object... bindings) {
		String boundMessage = StringUtil.bind(messageTemplate, bindings);
		return new RegionProblem(CompilerProblem.Severity.WARNING, region, boundMessage);
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

	/**
	 * Return the variable name associated with oclExpression, or null if none found.
	 * This enables the user's choice of name to be used for the expression node that implements it.
	 */
	public static @Nullable String recoverVariableName(@NonNull NamedElement namedElement) {
		EObject eContainer = namedElement.eContainer();
		EReference eContainmentFeature = namedElement.eContainmentFeature();
		if ((eContainmentFeature == PivotPackage.Literals.VARIABLE__OWNED_INIT) && (eContainer instanceof Variable)) {
			return ((Variable)eContainer).getName();
		}
		else if ((eContainmentFeature == QVTcorePackage.Literals.ASSIGNMENT__VALUE) && (eContainer instanceof VariableAssignment)) {
			return ((VariableAssignment)eContainer).getTargetVariable().getName();
		}
		else if ((eContainmentFeature == PivotPackage.Literals.CALL_EXP__OWNED_SOURCE) && (eContainer instanceof OperationCallExp)) {
			OperationCallExp operationCallExp = (OperationCallExp)eContainer;
			if (PivotUtil.isSameOperation(operationCallExp.getReferredOperation().getOperationId(), OperationId.OCLANY_EQUALS)) {
				OCLExpression argument = PivotUtil.getOwnedArgument(operationCallExp, 0);
				if (argument instanceof VariableExp) {
					return PivotUtil.getReferredVariable((VariableExp)argument).getName();
				}
			}
		}
		else if ((eContainmentFeature == PivotPackage.Literals.OPERATION_CALL_EXP__OWNED_ARGUMENTS) && (eContainer instanceof OperationCallExp)) {
			OperationCallExp operationCallExp = (OperationCallExp)eContainer;
			if (PivotUtil.isSameOperation(operationCallExp.getReferredOperation().getOperationId(), OperationId.OCLANY_EQUALS)) {
				OCLExpression source = PivotUtil.getOwnedSource(operationCallExp);
				if (source instanceof VariableExp) {
					return PivotUtil.getReferredVariable((VariableExp)source).getName();
				}
			}
		}
		return null;
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