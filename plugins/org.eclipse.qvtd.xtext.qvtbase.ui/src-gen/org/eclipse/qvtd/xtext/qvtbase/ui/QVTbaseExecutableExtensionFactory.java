/*******************************************************************************
 * Copyright (c) 2011, 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtbase.ui;

import org.eclipse.xtext.ui.guice.AbstractGuiceAwareExecutableExtensionFactory;
import org.osgi.framework.Bundle;

import com.google.inject.Injector;

import org.eclipse.qvtd.xtext.qvtbase.ui.internal.QVTbaseActivator;

/**
 * This class was generated. Customizations should only happen in a newly
 * introduced subclass.
 */
public class QVTbaseExecutableExtensionFactory extends AbstractGuiceAwareExecutableExtensionFactory {

	@Override
	protected Bundle getBundle() {
		return QVTbaseActivator.getInstance().getBundle();
	}

	@Override
	protected Injector getInjector() {
		return QVTbaseActivator.getInstance().getInjector(QVTbaseActivator.ORG_ECLIPSE_QVTD_XTEXT_QVTBASE_QVTBASE);
	}

}
