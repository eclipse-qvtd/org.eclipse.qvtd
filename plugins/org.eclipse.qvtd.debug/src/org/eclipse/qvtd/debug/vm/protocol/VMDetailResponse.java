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


public class VMDetailResponse extends VMResponse {

	private static final long serialVersionUID = -7687752310549667712L;
	
	private final String fDetail;
	
	public VMDetailResponse(String detail) {
		if(detail == null) {
			throw new IllegalArgumentException();
		}
		
		fDetail = detail;
	}

	public String getDetail() {
		return fDetail;
	};
	
}
