/*******************************************************************************
 * Copyright (c) 2014 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtcore.ui.model;

import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.xtext.essentialocl.ui.model.BaseDocumentProvider;
import org.eclipse.qvtd.xtext.qvtcore.qvtcorecs.QVTcoreCSPackage;

/**
 * QVTcoreDocumentProvider orchestrates the load and saving of optional XMI content
 * externally while maintaining the serialised human friendly form internally. 
 */
public class QVTcoreDocumentProvider extends BaseDocumentProvider
{
	@Override
	protected @NonNull String createTestDocument(@NonNull URI uri, @NonNull String lastSegment) {
		return "package " + lastSegment + " : pfx = '"+ uri + "' {\n" +
		"}\n";
	}

	@Override
	protected String getCScontentType() {
		return QVTcoreCSPackage.eCONTENT_TYPE;
	}

	@Override
	protected @NonNull String getFileExtension() {
		return "qvtc";
	}
}
