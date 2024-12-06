/*******************************************************************************
 * Copyright (c) 2014, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtbase.ui;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.xtext.base.cs2as.CS2AS;
import org.eclipse.ocl.xtext.base.utilities.BaseCSResource;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.xtext.ui.editor.model.JavaClassPathResourceForIEditorInputFactory;

/**
 * QVTbaseJavaClassPathResourceForIEditorInputFactory passes the project from the editorInput to a
 * JavaClassScope adapter onn the created resource for subsequent classPath resolution.
 */
public class QVTbaseJavaClassPathResourceForIEditorInputFactory extends JavaClassPathResourceForIEditorInputFactory
{
	@Override
	public Resource createResource(IEditorInput editorInput) {
		Resource csResource = super.createResource(editorInput);
		if ((csResource instanceof BaseCSResource) && (editorInput instanceof FileEditorInput)) {
			IProject project = ((FileEditorInput)editorInput).getFile().getProject();
			if (project != null) {
				BaseCSResource baseCSResource = (BaseCSResource)csResource;
				@SuppressWarnings("unused") CS2AS cs2as = baseCSResource.getCS2AS(baseCSResource.getEnvironmentFactory());
				//	JavaClassScope.getAdapter((BaseCSResource) csResource, project);
			}
		}
		return csResource;
	}
}
