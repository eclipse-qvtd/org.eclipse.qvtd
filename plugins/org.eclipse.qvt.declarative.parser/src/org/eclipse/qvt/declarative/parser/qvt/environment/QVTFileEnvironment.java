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

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.utilities.TypedElement;
import org.eclipse.qvt.declarative.ecore.utils.XMIUtils;
import org.eclipse.qvt.declarative.modelregistry.environment.AbstractFileHandle;
import org.eclipse.qvt.declarative.parser.environment.CSTFileEnvironment;
import org.eclipse.qvt.declarative.parser.environment.ICSTRootEnvironment;

public abstract class QVTFileEnvironment<R extends ICSTRootEnvironment, E extends IQVTNodeEnvironment, CST extends CSTNode> extends CSTFileEnvironment<R, E, CST> implements IQVTFileEnvironment
{
//	private UnresolvedEnvironment unresolvedEnvironment = null;
	
	protected QVTFileEnvironment(AbstractFileHandle file, ResourceSet resourceSet, XMIResource astResource) {
		super(file, resourceSet, astResource);
	}

/*	public Resource createASTResource(Collection<? extends EObject> asts, URI uri) {
		XMIResource resource = (XMIResource) getResourceSet().createResource(uri, getContentTypeIdentifier());
		if (resource != null) {
			if (asts != null)
				for (EObject ast : asts)
					if (ast != null)
						resource.getContents().add(ast);
			XMIUtils.assignIds(resource, "ast");
		}
		internalSetAST(resource);
		return resource;
	} */

	@Override
	protected QVTTypeResolverImpl createTypeResolver(Resource resource) {
		return new QVTTypeResolverImpl(this, resource);
	}
	
/*	public List<EPackage> getEPackages() {
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
	} */

	public Collection<Resource> getResourcesVisibleAt(EObject astNode) {
		List<Resource> resources = new ArrayList<Resource>();
		if (ast != null)
			resources.add(ast);
		resources.addAll(getResourceSet().getResources());
		return resources;
	}

	@Override
	public QVTTypeResolverImpl getTypeResolver() {
		return (QVTTypeResolverImpl) super.getTypeResolver();
	}
	
/*	public EClass lookupImportedClass(String name) {
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
	} */

/*	public void parseToAST(Reader reader, IProgressMonitor monitor) throws IOException, CoreException {
		initializeMonitor(monitor);
		AbstractQVTAnalyzer<E> analyzer = initializeAnalyzer(reader);
		URI sourceURI = file.getURI();
		analyzer.parseToAST(sourceURI);
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
	} */

/*	public boolean parseToAST(Reader reader, IProgressMonitor monitor) throws IOException, CoreException {
		initializeMonitor(monitor);
		AbstractQVTAnalyzer<E> analyzer = initializeAnalyzer(reader);
		if (!analyzer.parseToCST())
 			return false;
		if (isCancelled())
			return false;
		if (!analyzer.analyze(this))
 			return false;
		XMIUtils.assignIds(ast, "ast");
		return true;
	} */

	@Override
	protected void postParse(R rootEnvironment) {
		EPackage orphanPackage = getTypeResolver().getOrphanPackage();
		EList<EObject> astContents = ast.getContents();
		if (orphanPackage != null) {
			if (!astContents.isEmpty() && (astContents.get(0) instanceof EPackage)) {
				((EPackage)astContents.get(0)).getEClassifiers().addAll(orphanPackage.getEClassifiers());
			}
			else {
				initializePackageNs(orphanPackage);
				astContents.add(orphanPackage);
			}
		}
		super.postParse(rootEnvironment);
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
		XMIUtils.assignLinearIds(resource, "cst");
		resource.save(null);
	}

//	public void setCSTNode(CST cstNode) {
//		internalSetCST(cstNode);	
//	}

/*	@Override public EOperation tryLookupOperation(EClassifier owner, String name,
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
	} */
}
