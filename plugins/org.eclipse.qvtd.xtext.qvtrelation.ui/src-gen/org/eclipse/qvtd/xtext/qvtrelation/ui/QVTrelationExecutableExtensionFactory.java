/*******************************************************************************
 * Copyright (c) 2011, 2020 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtrelation.ui;

import com.google.inject.Injector;
import org.eclipse.core.runtime.Platform;
import org.eclipse.qvtd.xtext.qvtrelation.ui.internal.QVTrelationActivator;
import org.eclipse.xtext.ui.guice.AbstractGuiceAwareExecutableExtensionFactory;
import org.osgi.framework.Bundle;

/**
 * This class was generated. Customizations should only happen in a newly
 * introduced subclass.
 */
public class QVTrelationExecutableExtensionFactory extends AbstractGuiceAwareExecutableExtensionFactory {

	@Override
	protected Bundle getBundle() {
		return Platform.getBundle(QVTrelationActivator.PLUGIN_ID);
	}

	@Override
	protected Injector getInjector() {
		QVTrelationActivator activator = QVTrelationActivator.getInstance();
		return activator != null ? activator.getInjector(QVTrelationActivator.ORG_ECLIPSE_QVTD_XTEXT_QVTRELATION_QVTRELATION) : null;
	}

}
