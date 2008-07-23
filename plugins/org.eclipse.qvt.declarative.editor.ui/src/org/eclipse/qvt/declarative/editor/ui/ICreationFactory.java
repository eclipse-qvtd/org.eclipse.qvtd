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
package org.eclipse.qvt.declarative.editor.ui;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.ocl.lpg.ProblemHandler;
import org.eclipse.qvt.declarative.ecore.mappings.IMappingMetaData;
import org.eclipse.qvt.declarative.editor.ui.text.TextPageEditor;
import org.eclipse.qvt.declarative.modelregistry.environment.AbstractFileHandle;
import org.eclipse.qvt.declarative.parser.environment.IFileEnvironment;
import org.eclipse.qvt.declarative.parser.unparser.AbstractUnparser;

public interface ICreationFactory
{
	/**
	 * Assign an xmi:id to each element of resource.
	 * 
	 * @param resource
	 */
	public void assignXmiIds(XMLResource resource);

	/**
	 * Create the IFileEnvironment for parsing fileHandle within resourceSet.
	 */
	public IFileEnvironment createFileEnvironment(AbstractFileHandle fileHandle, ResourceSet resourceSet);

	/**
	 * Create the problem handler and associated marker creation support.
	 */
	public ProblemHandler createProblemHandler(IFile file);

	public TextPageEditor createTextEditor(IPageManager editorPageManager);
	public AbstractUnparser createUnparser(Resource resource);	

	/**
	 * Return an adapter that enables this to behave as key, or null if no adapter available. 
	 */
	public <T> T getAdapter(Class<T> key);
	
	/**
	 * Return the ID of the builder.
	 */
	public String getBuilderId();

	public String getEMOFExtension();
	
	public String[] getEMOFExtensions();

	public String getEcoreExtension();

	public String[] getEcoreExtensions();

	/**
	 * Return a name to be used to describe the associated type of editor.
	 */
	public String getEditorName();
	
	/**
	 * Return the EMOF to/from Ecore mapping description.
	 */
	public IMappingMetaData getMappingMetaData();

	/**
	 * Return the ID of the nature.
	 */
	public String getNatureId();

	/**
	 * Return the Marker ID for problems.
	 */
	public String getProblemMarkerId();
	
	public String getTextExtension();

	/**
	 * Return the extensions for which checkResource should invoke compile.
	 */
	public String[] getTextExtensions();

	public String getXMLExtension();
}
