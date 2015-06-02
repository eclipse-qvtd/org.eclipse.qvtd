/*******************************************************************************
 * Copyright (c) 2014 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     R.Dvorak and others - QVTo debugger framework
 *     E.D.Willink - revised API for OCL/QVTi debugger framework
 *******************************************************************************/
package org.eclipse.qvtd.debug.ui.actions;

import org.apache.log4j.Logger;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.qvtd.debug.ui.QVTdDebugUIPlugin;
import org.eclipse.swt.graphics.Image;

public class QVTiDebugImages
{
	private static final Logger logger = Logger.getLogger(QVTiDebugImages.class);

	public static final String TRANSFORMATION = "Transformation"; //$NON-NLS-1$
	public static final String MAPPING = "Mapping"; //$NON-NLS-1$
	
	private static ImageRegistry fgImageRegistry = QVTdDebugUIPlugin.getDefault().getImageRegistry();

	protected QVTiDebugImages() {
		super();
	}

	public static Image getImage(String key) {
		Image image = fgImageRegistry.get(key);
		if (image == null) {
			logger.error("No image for '" + key + "'");
		}
		return image;
	}
}
