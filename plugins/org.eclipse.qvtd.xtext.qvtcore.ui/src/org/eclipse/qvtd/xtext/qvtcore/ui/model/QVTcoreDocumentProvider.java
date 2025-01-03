/*******************************************************************************
 * Copyright (c) 2014, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtcore.ui.model;

import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.internal.utilities.OCLInternal;
import org.eclipse.ocl.pivot.resource.BasicProjectManager;
import org.eclipse.ocl.xtext.base.ui.model.BaseCSorASDocumentProvider;
import org.eclipse.qvtd.pivot.qvtcore.utilities.QVTcore;
import org.eclipse.qvtd.pivot.qvtcore.utilities.QVTcoreUtil;
import org.eclipse.qvtd.xtext.qvtcore.ui.QVTcoreUiModule;
import org.eclipse.qvtd.xtext.qvtcorecs.QVTcoreCSPackage;

/**
 * QVTcoreDocumentProvider orchestrates the load and saving of optional XMI content
 * externally while maintaining the serialised human friendly form internally.
 */
public class QVTcoreDocumentProvider extends BaseCSorASDocumentProvider
{
	@Override
	protected @NonNull OCLInternal createOCL() {
		return QVTcore.newInstance(BasicProjectManager.createDefaultProjectManager(), null);
	}

	@Override
	protected @NonNull String createTestDocument(@NonNull URI uri, @NonNull String lastSegment) {
		return "";
	}

	@Override
	protected String getCScontentType() {
		return QVTcoreCSPackage.eCONTENT_TYPE;
	}

	@Override
	protected @NonNull String getFileExtension() {
		return QVTcoreUtil.QVTC_FILE_EXTENSION;
	}

	@Override
	protected String getPluginId() {
		return QVTcoreUiModule.PLUGIN_ID;
	}
}
