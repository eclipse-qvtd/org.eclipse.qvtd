/*******************************************************************************
 * Copyright (c) 2007,2008 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvt.declarative.importer.roseuml;

import org.eclipse.emf.importer.ModelImporter;
import org.eclipse.emf.importer.rose.RoseImporterApplication;

public class RoseUMLImporterApplication extends RoseImporterApplication
{
	@Override
	public RoseUMLImporter getRoseImporter()
	{
		return (RoseUMLImporter)getModelImporter();
	}

	@Override
	protected ModelImporter createModelImporter()
	{
		return new RoseUMLImporter();
	}
}
