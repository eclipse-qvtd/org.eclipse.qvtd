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
package org.eclipse.qvt.declarative.parser.qvt.environment;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;

import lpg.lpgjavaruntime.Monitor;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EPackageRegistryImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.ocl.LookupException;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.utilities.TypedElement;
import org.eclipse.qvt.declarative.ecore.QVTBase.Transformation;
import org.eclipse.qvt.declarative.ecore.utils.XMIUtils;
import org.eclipse.qvt.declarative.modelregistry.environment.AbstractFileHandle;
import org.eclipse.qvt.declarative.modelregistry.environment.AbstractModelResolver;
import org.eclipse.qvt.declarative.parser.AbstractQVTAnalyzer;
import org.eclipse.qvt.declarative.parser.environment.IFileEnvironment;

public abstract class QVTTopLevelEnvironment<E extends IQVTEnvironment> extends QVTEnvironment<E, E> implements IFileEnvironment
{
	public static class LPGProgressMonitor implements Monitor
	{
		protected final IProgressMonitor monitor;

		public LPGProgressMonitor(IProgressMonitor monitor) {
			this.monitor = monitor;
		}

		public boolean isCancelled() {
			return (monitor != null) && monitor.isCanceled();
		}
	}

	private final EPackage.Registry qvtRegistry;
	protected AbstractFileHandle file;					// FIXME only used in parseToAST
	private AbstractQVTAnalyzer<E> analyzer = null;
	protected AbstractModelResolver resolver = null;
	
	protected QVTTopLevelEnvironment(EPackage.Registry reg, CSTNode cstNode) {
		super(reg);
		setCSTNode(cstNode);
		qvtRegistry = reg;
	}
	
	protected QVTTopLevelEnvironment(AbstractFileHandle file, ResourceSet resourceSet) {
		this(new EPackageRegistryImpl(), null);
		this.file = file;
		resolver = new AbstractModelResolver(file);
		resolver.setResourceSet(resourceSet);
	}

	protected void addPackage(EPackage ePackage) {
		qvtRegistry.put(ePackage.getName(), ePackage);
		initializePackageNs(ePackage);
	}

	protected void addSubPackage(EPackage ePackage, EPackage childPackage) {
		ePackage.getESubpackages().add(childPackage);
		initializePackageNs(childPackage);
	}

	public Resource createASTResource(Collection<? extends EObject> asts, URI uri) {
		Resource resource = getResourceSet().createResource(uri, getContentTypeIdentifier());
		if (resource != null) {
			if (asts != null)
				for (EObject ast : asts)
					if (ast != null)
						resource.getContents().add(ast);
			XMIUtils.assignIds(resource, "ast");
		}
		return resource;
	}

	protected abstract AbstractQVTAnalyzer<E> createAnalyzer();

	public AbstractQVTAnalyzer<E> getAnalyzer() {
		if (analyzer == null)
			analyzer = createAnalyzer();
		return analyzer;
	}

	protected abstract String getContentTypeIdentifier();
	
	public List<EPackage> getEPackages() {
		List<EPackage> ePackages = new ArrayList<EPackage>();
		for (Object object : qvtRegistry.values())
			if (object instanceof EPackage)
				ePackages.add((EPackage) object);
		EPackage orphanPackage = getTypeResolver().getOrphanPackage();
		if ((orphanPackage != null) && (ePackages.size() > 0)) {
			EPackage firstPackage = ePackages.get(0);
			firstPackage.getEClassifiers().addAll(orphanPackage.getEClassifiers());
		}
		return ePackages;
	}

	public AbstractFileHandle getFile() {
		return file;
	}

	public AbstractModelResolver getResolver() {
		return resolver;
	}

	public ResourceSet getResourceSet() {
		return resolver.getResourceSet();
	}

	protected AbstractQVTAnalyzer<E> initializeAnalyzer(Reader reader) throws CoreException, FileNotFoundException, IOException {
		AbstractQVTAnalyzer<E> analyzer = getAnalyzer();
// FIXME		analyzer.reset();
		analyzer.setFileName(file.getName());
		analyzer.setResolver(resolver);
		if (reader == null)
			reader = new InputStreamReader(file.getContents());
		else if (!file.exists())
			return null;
		analyzer.initialize(reader);
		return analyzer;
	}

	protected void initializeMonitor(IProgressMonitor monitor) {
		setMonitor(new LPGProgressMonitor(monitor));
	}

	protected void initializePackageNs(EPackage ePackage) {
		ePackage.setNsPrefix(ePackage.getName());
		StringBuilder s = new StringBuilder();
		s.append("http://");
		s.append(file.getProjectHandle().getName());
		s.append("/");
		s.append(file.getProjectRelativeName());
		s.append("/");
		initializePackageNs(s, ePackage);
		ePackage.setNsURI(s.toString());
	}

	protected void initializePackageNs(StringBuilder s, ENamedElement eNamedElement) {
		EObject eContainer = eNamedElement.eContainer();
		if (eContainer instanceof ENamedElement) {
			initializePackageNs(s, (ENamedElement) eContainer);
			s.append(".");
		}
		s.append(eNamedElement.getName());
	}

	public EClass lookupImportedClass(String name) {
		for (Entry<String, Object> entry : qvtRegistry.entrySet()) {
			EPackage ePackage = (EPackage) entry.getValue();
			EClassifier eClassifier = ePackage.getEClassifier(name);
			if (eClassifier instanceof EClass)
				return (EClass) eClassifier;
		}
		return null;
	}

	public EClassifier lookupImportedClassifier(String name) {
		for (Entry<String, Object> entry : qvtRegistry.entrySet()) {
			EPackage ePackage = (EPackage) entry.getValue();
			EClassifier eClassifier = ePackage.getEClassifier(name);
			if (eClassifier != null)
				return eClassifier;
		}
		return null;
	}

	@Override public Transformation lookupImportedTransformation(String name) {
		for (Entry<String, Object> entry : qvtRegistry.entrySet()) {
			EPackage ePackage = (EPackage) entry.getValue();
			EClassifier eClassifier = ePackage.getEClassifier(name);
			if (eClassifier instanceof Transformation)
				return (Transformation) eClassifier;
		}
		return null;
	}

	public Collection<? extends EObject> parseToAST(Reader reader, IProgressMonitor monitor)
			throws IOException, CoreException {
		initializeMonitor(monitor);
		AbstractQVTAnalyzer<E> analyzer = initializeAnalyzer(reader);
		URI sourceURI = file.getURI();
		return analyzer.parseToAST(sourceURI);
	}

	public CSTNode parseToCST(Reader reader, IProgressMonitor monitor) throws IOException, CoreException {
		initializeMonitor(monitor);
		AbstractQVTAnalyzer<E> analyzer = initializeAnalyzer(reader);
		return analyzer.parseToCST();
	}

	public AbstractQVTAnalyzer<E> parseToTokens(Reader reader, IProgressMonitor monitor) throws IOException, CoreException {
		initializeMonitor(monitor);
		AbstractQVTAnalyzer<E> analyzer = initializeAnalyzer(reader);
		return analyzer;
	}

	protected String resolveSynonym(EClassifier owner, String name, List<? extends TypedElement<EClassifier>> args) {
		if ("+".equals(name) && (args.size() == 1)) {
			EClassifier oclString = getOCLStandardLibrary().getString();
			EClassifier ownerType = getTypeResolver().resolve(owner);
			EClassifier argType = getTypeResolver().resolve(args.get(0).getType());
			if ((ownerType == oclString) && (argType == oclString))
				name = "concat";
		}
		return name;
	}

	public void saveCST(CSTNode cstNode, URI uri) throws IOException {
		Resource resource = getResourceSet().createResource(uri);
		XMIUtils.assignIds(resource, "cst");
		resource.save(null);
	}

	@Override public EOperation tryLookupOperation(EClassifier owner, String name,
			List<? extends TypedElement<EClassifier>> args) throws LookupException {
		name = resolveSynonym(owner, name, args);
		return super.tryLookupOperation(owner, name, args);
	}

	@Override public Transformation tryLookupTransformation(List<String> pathName) throws LookupException {
		EPackage ePackage = tryLookupPackage(pathName);
		if (ePackage == null)
			return null;
		if (ePackage instanceof Transformation)
			return (Transformation) ePackage;
		throw new LookupException("Not a transformation", Collections.singletonList(ePackage));
	}
}
