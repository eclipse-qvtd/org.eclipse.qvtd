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
 * $Id: QVTBasePlugin.java,v 1.1 2008/12/12 15:31:45 ewillink Exp $
 */
package org.eclipse.qvt.declarative.ecore.QVTBase.util;

import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EPackage;

/**
 * A collection of platform-neutral static utilities
 * as well as Eclipse support utilities.
 */
public class QVTBasePlugin extends EMFPlugin
{
	/**
	 * The singleton instance of the plugin.
	 */
	public static final QVTBasePlugin INSTANCE = new QVTBasePlugin();

	/**
	 * Creates the singleton instance.
	 */
	private QVTBasePlugin()
	{
		super(new ResourceLocator[] {});
	}

	@Override
	public ResourceLocator getPluginResourceLocator()
	{
		return plugin;
	}

	/** 
	 * A plugin implementation that handles Ecore plugin registration.
	 * @see #startup()
	 */
	static public class Implementation extends EclipsePlugin
	{
		/**
		 * Creates the singleton instance.
		 */
		public Implementation()
		{
			super();
			plugin = this;
		}

		/**
		 * The default registry implementation singleton.
		 */
		private static EPackage.Registry defaultRegistryImplementation; 

		/**
		 * Returns the default registry implementation singleton.
		 * @return the default registry implementation singleton.
		 */
		public static EPackage.Registry getDefaultRegistryImplementation()
		{
			return defaultRegistryImplementation;
		}

		/**
		 * Returns the Eclipse plugin singleton.
		 * @return the plugin singleton.
		 */
		public static Implementation getPlugin()
		{
			return plugin;
		}
	}
	/**
	 * The plugin singleton
	 */
	private static Implementation plugin;
}