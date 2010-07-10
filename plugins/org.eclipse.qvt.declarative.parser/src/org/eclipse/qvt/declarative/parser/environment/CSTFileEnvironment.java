/******************************************************************************
 * Copyright (c) 2007,2008 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvt.declarative.parser.environment;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import lpg.runtime.Monitor;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.EPackageRegistryImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.ocl.TypeResolver;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.examples.modelregistry.environment.AbstractModelResolver;
import org.eclipse.ocl.examples.modelregistry.environment.FileHandle;
import org.eclipse.ocl.lpg.AbstractParser;
import org.eclipse.qvt.declarative.ecore.utils.XMIUtils;
import org.eclipse.qvt.declarative.parser.qvt.environment.LPGProgressMonitor;
import org.eclipse.qvt.declarative.parser.utils.CSTUtils;

public abstract class CSTFileEnvironment<R extends ICSTRootEnvironment, E extends ICSTNodeEnvironment, CST extends CSTNode> extends CSTEnvironment<E> implements ICSTFileEnvironment
{
	protected final EPackage.Registry registryToo;
	protected final XMIResource ast;
	protected final AbstractModelResolver resolver;	
	private TypeResolver<EClassifier, EOperation, EStructuralFeature> typeResolver;	// FIXME Duplicated to support reset
		// inherited functionality should allow typeResolver to be in CSTRootEnvironment

	private CSTFileEnvironment(EPackage.Registry registry, FileHandle file, ResourceSet resourceSet, XMIResource astResource) {
		super(registry, null);		// Null suppresses inherited createTypeResolver
		ast = astResource;
		typeResolver = createTypeResolver(ast);
		registryToo = registry;
		if (file != null) {
			resolver = new AbstractModelResolver(file);	
			resolver.setResourceSet(resourceSet);
		}
		else
			resolver = null;
	}
	
	protected CSTFileEnvironment(FileHandle file, ResourceSet resourceSet, XMIResource astResource) {
		this(new EPackageRegistryImpl(), file, resourceSet, astResource);
	}

	public abstract ICSTFileAnalyzer<R> createAnalyzer(Monitor monitor);

	protected abstract R createRootEnvironment(XMIResource ast, CST cst);

	@Override
	protected TypeResolver<EClassifier, EOperation, EStructuralFeature> createTypeResolver(Resource resource) {
		return resource != null ? super.createTypeResolver(resource) : null;
	}

	public XMIResource getASTResource() {
		return ast;
	}

	protected abstract String getContentTypeIdentifier();

	public FileHandle getFile() {
		return getResolver().getHandle();
	}

	public ICSTFileEnvironment getFileEnvironment() {
		return this;
	}

	public EPackage.Registry getRegistry() {
		return registryToo;
	}

	public AbstractModelResolver getResolver() {
		return resolver;
	}

	public ResourceSet getResourceSet() {
		return resolver.getResourceSet();
	}

	@Override
	public TypeResolver<EClassifier, EOperation, EStructuralFeature> getTypeResolver() {
		return typeResolver;
	}

	public void initializePackageNs(EPackage ePackage) {
		ePackage.setNsPrefix(ePackage.getName());
		ePackage.setNsURI(CSTUtils.computePackageNs(resolver.getHandle(), ePackage));
	}

	public ICSTRootEnvironment parse(Reader reader, FileHandle file, IProgressMonitor monitor) throws IOException, CoreException {
		Monitor lpgMonitor = new LPGProgressMonitor(monitor);
		ICSTFileAnalyzer<R> analyzer = createAnalyzer(lpgMonitor);
		if (reader == null)
			reader = new InputStreamReader(file.getContents());
		else if (!file.exists())
			return null;
		analyzer.reset(reader, file.getName());
		AbstractParser parser = getParser();
		if ((monitor != null) && monitor.isCanceled())
			return null;
		parser.getLexer().lexer(parser.getIPrsStream());
		if ((monitor != null) && monitor.isCanceled())
			return null;
		@SuppressWarnings("unchecked")		// Maybe this should be a generic parameter
		CST cst = (CST) parser.parser(lpgMonitor, -1);
		if (cst == null)
			return null;
		if ((monitor != null) && monitor.isCanceled())
			return null;
		R rootEnvironment;
		try {
			reset();
			rootEnvironment = createRootEnvironment(ast, cst);
		} catch (ClassCastException e) {	// Occurs if cst is not a CST
			return null;
		}
		if (!analyzer.analyze(rootEnvironment))
 			return null;
		if ((monitor != null) && monitor.isCanceled())
			return null;
		postParse(rootEnvironment);
		return rootEnvironment;
	}

	protected void postParse(R rootEnvironment) {
		rootEnvironment.postParse();
		XMIUtils.assignLinearIds(ast, "ast");
	}

	public void reset() {
		ast.unload();
		typeResolver = createTypeResolver(ast);
		List<Adapter> eAdapters = ast.eAdapters();
		if (!eAdapters.isEmpty()) {
			for (Adapter eAdapter : new ArrayList<Adapter>(eAdapters)) {
				if (eAdapter instanceof ICSTEnvironment)
					eAdapters.remove(eAdapter);
			}
		}
	}
}
