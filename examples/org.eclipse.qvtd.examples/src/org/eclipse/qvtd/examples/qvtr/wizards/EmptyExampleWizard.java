/*******************************************************************************
 * Copyright (c) 2009, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 * 
 * Contributors:
 * E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.examples.qvtr.wizards;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.qvtd.examples.wizards.AbstractExampleWizard;

public class EmptyExampleWizard extends AbstractExampleWizard
{	
	@Override
	protected Collection<ProjectDescriptor> getProjectDescriptors() {
		List<ProjectDescriptor> projects = new ArrayList<ProjectDescriptor>(4);
		projects.add(new ProjectDescriptor("org.eclipse.qvtd.examples", "zips/qvtr/empty.zip", "EmptyQVTrProject"));  //$NON-NLS-1$//$NON-NLS-2$ //$NON-NLS-3$		
		return projects;
	}
}
