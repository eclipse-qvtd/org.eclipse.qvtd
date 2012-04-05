/**
 * <copyright>
 * 
 * Copyright (c) 2007,2008 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * E.D.Willink - initial API and implementation
 * 
 * </copyright>
 *
 * $Id: ICSTFileEnvironment.java,v 1.3 2010/07/10 09:35:38 ewillink Exp $
 */
package org.eclipse.qvt.declarative.parser.environment;

import java.io.IOException;
import java.io.Reader;
import java.util.Collection;

import lpg.runtime.Monitor;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.ocl.examples.modelregistry.environment.AbstractModelResolver;
import org.eclipse.ocl.examples.modelregistry.environment.FileHandle;

public interface ICSTFileEnvironment extends ICSTEnvironment
{
	public ICSTFileAnalyzer<?> createAnalyzer(Monitor monitor);
	
	public XMIResource getASTResource();

	public FileHandle getFile();
	
	public EPackage.Registry getRegistry();

	public AbstractModelResolver getResolver();
	
	public ResourceSet getResourceSet();

	/**
	 * Return the resource that are visible at astNode, and which are consequently
	 * able to contribute valid completion proposals for astNode.
	 */
	public Collection<Resource> getResourcesVisibleAt(EObject astNode);

	/**
	 * Provide a plausible namespace for ePackage.
	 */
	public void initializePackageNs(EPackage ePackage);
	
	/**
	 * Parse the source text that purports to come from filr and return its root environment
	 * from which AST and CST may be obtained. monitor may nbe used to cancel parsing.
	 * @param reader the source text, or null to use the file contents
	 * @param the file source if reader null, or the nominal source if reader non-null
	 * @param monitor
	 * @return
	 * @throws IOException
	 * @throws CoreException
	 */
	public ICSTRootEnvironment parse(Reader reader, FileHandle file, IProgressMonitor monitor) throws IOException, CoreException;
}
