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

import org.eclipse.emf.ecore.resource.Resource;

/**
 * ModelContentAnalysis captures the result of an attempt at textaul anlysis
 * of a model by a ModelContentAnalyser
 */
public interface ModelContentAnalysis
{
	/**
	 * Return the number of errors detected by the analysis.
	 * (An error is a problem that must be resolved before the model can be used.)
	 * 
	 * @return the number of errors
	 */
	public int getErrorCount();
	
	/**
	 * Return the resource resulting from the analysis.
	 * 
	 * Multi-pass analysers for similar modeling languages may benefit by implementing this
	 * lazily. getResource() is only invoked for the resource with the lowest errorCount.
	 *  
	 * @return the resource
	 */
	public Resource getResource();
	
	/**
	 * Return the number of warnings detected by the analysis.
	 * (A warning is a problem that need not be resolved before the model can be used.)
	 * 
	 * @return the number of warnings
	 */
	public int getWarningCount();
	
}
