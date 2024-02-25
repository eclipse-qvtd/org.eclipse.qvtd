/*******************************************************************************
 * Copyright (c) 2024 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtbase.ui;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.sirius.business.api.resource.strategy.AbstractResourceStrategyImpl;
import org.eclipse.sirius.business.api.session.Session;

/**
 * QVTdNotAResourceStrategyImpl provides the QVTd-specific implementation of the Sirius AbstractResourceStrategyImpl
 * to prevent *.qvt*as files being loaded as Sirius semantic resources. See Bug 582958.
 * <p>
 * A more elegant solution could be available if Sirius responds to
 * https://github.com/eclipse-sirius/sirius-desktop/issues/301
 * by providing a parameterizable NotAResourceStrategyImpl.
 */
public class QVTdNotAResourceStrategyImpl extends AbstractResourceStrategyImpl
{
	@Override
	public boolean canHandle(URI resourceURI, ResourceStrategyType resourceStrategyType) {
		String fileExtension = resourceURI.fileExtension();
		if ("qvtcas".equals(fileExtension) || "qvtias".equals(fileExtension) || "qvtras".equals(fileExtension) || "qvtsas".equals(fileExtension)) {
			return true;
		}
		return false;
	}

	@Override
	public boolean canHandle(Resource resource, ResourceStrategyType resourceStrategyType) {
		return canHandle(resource.getURI(), resourceStrategyType);
	}

	@Override
	public boolean isPotentialSemanticResource(URI uri) {
		return true;
	}

	@Override
	public boolean isLoadableModel(URI uri, Session session) {
		return false;
	}

}
