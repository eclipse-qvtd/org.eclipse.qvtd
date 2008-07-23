/*******************************************************************************
 * Copyright (c) 2007 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvt.declarative.editor.ui.pages;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * A derived AbstractPageFactoryRegistry manages a set of derived IPageFactory registrations and
 * supports creation of the appropriate content-specific editing page.
 */
public abstract class AbstractPageFactoryRegistry<T extends IPageFactory> implements IPageFactoryRegistry<T>
{
	private final Map<String, T> registry = new HashMap<String, T>();

	public Collection<T> getPageFactories() {
		return registry.values();		
	}

	public T getPageFactory(String contentType) {
		return registry.get(contentType);		
	}

	public void registerPageFactory(String contentType, T pageFactory) {
		registry.put(contentType, pageFactory);		
	}
}
