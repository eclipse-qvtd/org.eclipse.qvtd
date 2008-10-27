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
 * $Id: ModelMorfExampleWizard.java,v 1.1 2008/10/27 21:07:32 ewillink Exp $
 */
package org.eclipse.qvt.declarative.examples.qvtr.wizards;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.qvt.declarative.examples.wizards.AbstractExampleWizard;

public class ModelMorfExampleWizard extends AbstractExampleWizard
{	
	@Override
	protected Collection<ProjectDescriptor> getProjectDescriptors() {
		List<ProjectDescriptor> projects = new ArrayList<ProjectDescriptor>(4);
		projects.add(new ProjectDescriptor("org.eclipse.qvt.declarative.examples", "zips/modelmorf.zip", "org.eclipse.qvt.declarative.examples.qvtrelation.modelmorf"));  //$NON-NLS-1$//$NON-NLS-2$ //$NON-NLS-3$		
		return projects;
	}
}
