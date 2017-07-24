/*******************************************************************************
 * Copyright (c) 2014, 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtrelation.ui.model;

import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.internal.utilities.OCLInternal;
import org.eclipse.ocl.pivot.resource.BasicProjectManager;
import org.eclipse.ocl.xtext.base.ui.model.BaseCSorASDocumentProvider;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrelation;
import org.eclipse.qvtd.xtext.qvtrelation.ui.QVTrelationUiModule;
import org.eclipse.qvtd.xtext.qvtrelationcs.QVTrelationCSPackage;

/**
 * QVTrelationDocumentProvider orchestrates the load and saving of optional XMI content
 * externally while maintaining the serialised human friendly form internally.
 */
public class QVTrelationDocumentProvider extends BaseCSorASDocumentProvider
{
	@Override
	protected @NonNull OCLInternal createOCL() {
		return QVTrelation.newInstance(BasicProjectManager.createDefaultProjectManager(), null);
	}

	@Override
	protected @NonNull String createTestDocument(@NonNull URI uri, @NonNull String lastSegment) {
		return "";
	}

	@Override
	protected String getCScontentType() {
		return QVTrelationCSPackage.eCONTENT_TYPE;
	}

	@Override
	protected @NonNull String getFileExtension() {
		return "qvtr";
	}

	@Override
	protected String getPluginId() {
		return QVTrelationUiModule.PLUGIN_ID;
	}
}
