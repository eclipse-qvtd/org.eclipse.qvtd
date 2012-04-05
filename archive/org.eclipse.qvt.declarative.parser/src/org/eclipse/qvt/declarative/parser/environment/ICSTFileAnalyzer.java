/**
 * <copyright>
 * 
 * Copyright (c) 2008 E.D.Willink and others.
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
 * $Id: ICSTFileAnalyzer.java,v 1.2 2010/01/26 22:03:09 ewillink Exp $
 */
package org.eclipse.qvt.declarative.parser.environment;

import java.io.IOException;
import java.io.Reader;

import org.eclipse.ocl.lpg.AbstractParser;

/**
 * ICSTFileAnalyzer defines the required interface of the analyzer used
 * to perform lexical, syntactic ansd semantic analysis.
 */
public interface ICSTFileAnalyzer<R extends ICSTRootEnvironment>
{
	public boolean analyze(R rootEnvironment);

	public AbstractParser getParser();

	@Deprecated
	public void initialize(Reader reader) throws IOException;

	public void reset(Reader reader, String fileName) throws IOException;

	@Deprecated
	public void setFileName(String name);
}
