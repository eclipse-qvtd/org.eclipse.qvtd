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
package org.eclipse.qvt.declarative.parser.environment;

import java.io.IOException;
import java.io.Reader;
import java.util.Collection;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.lpg.BasicEnvironment;

public interface IFileEnvironment extends BasicEnvironment
{
	public Resource createASTResource(Collection<? extends EObject> ePackages, URI uri);
	
	/**
	 * Parse the source text and return an AST forest.
	 * @param reader the source text, or null to use an implicit file context
	 * @param monitor
	 * @return
	 * @throws IOException
	 * @throws CoreException
	 */
	public Collection<? extends EObject> parseToAST(Reader reader, IProgressMonitor monitor) throws IOException, CoreException;

	public void validate(Resource resource);
}
