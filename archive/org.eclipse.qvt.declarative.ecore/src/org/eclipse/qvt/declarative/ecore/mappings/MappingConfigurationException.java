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
 * $Id: MappingConfigurationException.java,v 1.2 2008/08/08 17:00:10 ewillink Exp $
 */
package org.eclipse.qvt.declarative.ecore.mappings;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * A MappingConfigurationException is thrown to describe an inconsistency in the mapping meta-deta
 * defining the mapping of an adapting and ecore model.
 */
@SuppressWarnings("serial")
public class MappingConfigurationException extends RuntimeException
{
	protected final EObject eObject;
	protected final EStructuralFeature eFeature;

	public MappingConfigurationException(String message, EObject eObject, EStructuralFeature eFeature) {
		super(message);
		this.eObject = eObject;
		this.eFeature = eFeature;
	}

	@Override
	public String getMessage() {
		if (eFeature != null)
			return super.getMessage() + MappingUtils.formatLocalName(eObject) + "." + MappingUtils.formatLocalName(eFeature);
		else
			return super.getMessage() + MappingUtils.formatLocalName(eObject);
	}	
}
