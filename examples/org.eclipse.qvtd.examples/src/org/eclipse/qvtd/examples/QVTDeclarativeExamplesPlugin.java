/**
 * <copyright>
 * 
 * Copyright (c) 2008 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * E.D.Willink - initial API and implementation
 * 
 * </copyright>
 *
 * $Id: QVTDeclarativeExamplesPlugin.java,v 1.1 2008/08/26 21:00:59 ewillink Exp $
 */
package org.eclipse.qvtd.examples;

import org.eclipse.ui.plugin.AbstractUIPlugin;

/**
 * The activator class controls the plug-in life cycle
 */
public class QVTDeclarativeExamplesPlugin extends AbstractUIPlugin
{
	// The shared instance
	private static QVTDeclarativeExamplesPlugin plugin;
	
	/**
	 * The constructor
	 */
	public QVTDeclarativeExamplesPlugin() {
		plugin = this;
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static QVTDeclarativeExamplesPlugin getDefault() {
		return plugin;
	}

}
