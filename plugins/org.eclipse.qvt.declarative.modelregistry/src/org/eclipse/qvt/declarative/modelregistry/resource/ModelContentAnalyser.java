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
package org.eclipse.qvt.declarative.modelregistry.resource;

import java.io.InputStream;

import org.eclipse.emf.common.util.URI;

public interface ModelContentAnalyser
{
	/**
	 * Analyze the input stream and return an analyssis if the inputStream
	 * corresponds to a valid model content.
	 * 
	 * Return null if the inputStream clearly does not correspond to this content.
	 * 
	 * @param inputStream to be analysed
	 * @param uri from which this input stream derived
	 * @return non-null Analysis for valid and semi-valid content, null for incompatible content
	 */
	public ModelContentAnalysis analyze(InputStream inputStream, URI uri);
}
