/*******************************************************************************
 * Copyright (c) 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation based on org.eclipse.xtext.ui.XtextProjectHelper
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtbase.ui;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.ICommand;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;

/**
 */
public class QVTdProjectHelper {

	public static final String NATURE_ID = "org.eclipse.qvtd.xtext.qvtbase.ui.qvtdnature"; //$NON-NLS-1$
	public static final String BUILDER_ID = "org.eclipse.qvtd.xtext.qvtbase.ui.qvtdbuilder"; //$NON-NLS-1$

	private static final Logger log = Logger.getLogger(QVTdProjectHelper.class);

	public static boolean hasNature(IProject project) {
		try {
			if (project.isAccessible()) {
				return project.hasNature(NATURE_ID);
			}
		} catch (CoreException e) {
			log.error(e.getMessage(), e);
		}
		return false;
	}

	public static boolean hasBuilder(IProject project) {
		if (project.isAccessible()) {
			try {
				for (ICommand command : project.getDescription().getBuildSpec()) {
					if (BUILDER_ID.equals(command.getBuilderName())) {
						return true;
					}
				}
			} catch (CoreException e) {
				log.error("Can't build due to an exception.", e);
			}
		}
		return false;
	}

}
