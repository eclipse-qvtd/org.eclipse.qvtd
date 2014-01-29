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
package org.eclipse.qvtd.debug.vm.protocol;

import java.io.Serializable;

import org.eclipse.jdt.annotation.Nullable;

public interface VMLocation extends Serializable {

	int getCharEnd();
	int getCharStart();
	int getLineNum();

	String getURI();

	String getModule();
	@Nullable String getOperationSignature();

}