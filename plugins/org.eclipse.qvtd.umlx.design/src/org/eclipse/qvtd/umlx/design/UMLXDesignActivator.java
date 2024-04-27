/*******************************************************************************
 * Copyright (c) 2017, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *	 E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.umlx.design;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.sirius.business.api.componentization.ViewpointRegistry;
import org.eclipse.sirius.viewpoint.description.Viewpoint;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class UMLXDesignActivator extends AbstractUIPlugin
{
	// The plug-in ID
	public static final @NonNull String PLUGIN_ID = "org.eclipse.qvtd.umlx.design";

	public static final @NonNull String VIEWPOINT_ID = "org.eclipse.qvtd.umlx.viewpoint";
	public static final @NonNull String RELATION_REPRESENTATION_DESCRIPTION_ID = "org.eclipse.qvtd.umlx.relation";
	public static final @NonNull String TRANSFORMATION_REPRESENTATION_DESCRIPTION_ID = "org.eclipse.qvtd.umlx.transformation";

	public static final @NonNull URI VIEWPOINT_URI = URI.createURI("viewpoint:/" + PLUGIN_ID + "/" + VIEWPOINT_ID);

	// The shared instance
	private static UMLXDesignActivator plugin;

	private static Set<Viewpoint> viewpoints;

	/**
	 * The constructor
	 */
	public UMLXDesignActivator() {
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		viewpoints = new HashSet<Viewpoint>();
		viewpoints.addAll(ViewpointRegistry.getInstance().registerFromPlugin(PLUGIN_ID + "/description/umlx.odesign"));
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	@Override
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		if (viewpoints != null) {
			for (final Viewpoint viewpoint: viewpoints) {
				ViewpointRegistry.getInstance().disposeFromPlugin(viewpoint);
			}
			viewpoints.clear();
			viewpoints = null;
		}
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static UMLXDesignActivator getDefault() {
		return plugin;
	}
}
