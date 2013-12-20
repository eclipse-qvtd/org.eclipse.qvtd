/*******************************************************************************
 * Copyright (c) 2009 R.Dvorak and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Radek Dvorak - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.debug.core;

import org.eclipse.debug.core.model.DebugElement;
import org.eclipse.qvtd.debug.utils.QVTODebugCore;

public abstract class QVTODebugElement extends DebugElement {	
	
	public QVTODebugElement(IQVTODebugTarget debugTarget) {
		super(debugTarget);
	}
	
	public String getModelIdentifier() {
		return QVTODebugCore.MODEL_ID;
	}

	public IQVTODebugTarget getQVTODebugTarget() {
		return (QVTODebugTarget) getDebugTarget(); 
	}	
}
