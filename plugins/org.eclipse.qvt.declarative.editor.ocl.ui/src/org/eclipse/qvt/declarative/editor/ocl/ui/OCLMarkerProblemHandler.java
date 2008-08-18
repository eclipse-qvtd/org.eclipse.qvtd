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
 * $Id: OCLMarkerProblemHandler.java,v 1.1 2008/08/18 07:45:00 ewillink Exp $
 */
package org.eclipse.qvt.declarative.editor.ocl.ui;

import org.eclipse.core.resources.IResource;
import org.eclipse.qvt.declarative.editor.ui.builder.EcoreMarkerProblemHandler;

public class OCLMarkerProblemHandler extends EcoreMarkerProblemHandler
{
	public OCLMarkerProblemHandler(IResource resource) {
		super(OCLCreationFactory.INSTANCE, resource);
	}
}