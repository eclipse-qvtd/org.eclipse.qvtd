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
package org.eclipse.qvtd.xtext.qvtimperative.ui.model;

import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.internal.utilities.OCLInternal;
import org.eclipse.ocl.pivot.resource.BasicProjectManager;
import org.eclipse.ocl.pivot.utilities.OCL;
import org.eclipse.ocl.xtext.base.ui.model.BaseCSorASDocumentProvider;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbase;
import org.eclipse.qvtd.xtext.qvtimperativecs.QVTimperativeCSPackage;

/**
 * QVTimperativeDocumentProvider orchestrates the load and saving of optional XMI content
 * externally while maintaining the serialised human friendly form internally. 
 */
public class QVTimperativeDocumentProvider extends BaseCSorASDocumentProvider
{
	private @Nullable OCLInternal ocl;		// FIXME Eliminate once OCL implements createOCL

//	@Override
	protected @NonNull OCLInternal createOCL() {
		return QVTbase.newInstance(BasicProjectManager.createDefaultProjectManager(), null);
	}

	@Override
	protected @NonNull String createTestDocument(@NonNull URI uri, @NonNull String lastSegment) {
		return "package " + lastSegment + " : pfx = '"+ uri + "' {\n" +
		"}\n";
	}

	@Override
	protected void disconnected() {
		OCL ocl2 = ocl;
		if (ocl2 != null) {
			ocl = null;
			ocl2.dispose();
		}
		super.disconnected();
	}

	@Override
	protected String getCScontentType() {
		return QVTimperativeCSPackage.eCONTENT_TYPE;
	}

	@Override
	protected @NonNull String getFileExtension() {
		return "qvti";
	}
	
	protected @NonNull OCLInternal getOCL() {
		OCLInternal ocl2 = ocl;
		if (ocl2 == null) {
			ocl = ocl2 = createOCL();
		}
		return ocl2;
	}
}
