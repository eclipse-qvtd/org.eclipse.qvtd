/*******************************************************************************
 * Copyright (c) 2015 Willink Transformations, University of York and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Adolfo Sanchez-Barbudo Herrera - initial API and implementation
 ******************************************************************************/
package org.eclipse.qvtd.pivot.qvtbase.utilities;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.resource.ProjectManager;
import org.eclipse.ocl.pivot.utilities.AbstractEnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtbase.model.QVTbaseLibrary;

public class QVTbaseEnvironmentFactory extends AbstractEnvironmentFactory {

	public QVTbaseEnvironmentFactory(@NonNull ProjectManager projectManager,
			@Nullable ResourceSet externalResourceSet) {
		super(projectManager, externalResourceSet);
		getStandardLibrary().setDefaultStandardLibraryURI(QVTbaseLibrary.STDLIB_URI);
	}

}
