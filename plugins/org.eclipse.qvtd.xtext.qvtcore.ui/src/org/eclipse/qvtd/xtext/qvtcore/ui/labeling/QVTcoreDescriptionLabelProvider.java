/*******************************************************************************
 * Copyright (c) 2014, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtcore.ui.labeling;

import org.eclipse.ocl.xtext.essentialocl.ui.labeling.EssentialOCLDescriptionLabelProvider;

/**
 * Provides labels for a IEObjectDescriptions and IResourceDescriptions.
 *
 * see http://www.eclipse.org/Xtext/documentation/latest/xtext.html#labelProvider
 */
public class QVTcoreDescriptionLabelProvider extends EssentialOCLDescriptionLabelProvider {

	/*
	//Labels and icons can be computed like this:

	String text(IEObjectDescription ele) {
	  return "my "+ele.getName();
	}

    String image(IEObjectDescription ele) {
      return ele.getEClass().getName() + ".gif";
    }
	 */

}
