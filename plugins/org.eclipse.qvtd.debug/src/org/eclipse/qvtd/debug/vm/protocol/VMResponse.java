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

import org.eclipse.jdt.annotation.NonNull;

public class VMResponse implements Serializable
{
	private static final long serialVersionUID = 8136163293629606805L;

	public static final int STATUS_OK = 0;
	public static final int STATUS_ERROR = 1;

	public static @NonNull String toStatusString(int status) {
		switch (status) {
		case STATUS_OK: return "OK";
		case STATUS_ERROR: return "ERROR";
		}
		return "???";
	}
	
	public final int status;
	
	protected VMResponse() {
		this(STATUS_OK);
	}
	
	protected VMResponse(int status) {
		this.status = status;
	}
		
	public boolean isOK() {
		return status == STATUS_OK;
	}
	
	public static VMResponse createOK() {
		return new VMResponse();
	}
	
	public static VMResponse createERROR() {
		return new VMResponse(STATUS_ERROR);
	}
	
	@Override
	public String toString() {
		return getClass().getSimpleName() + "(" + toStatusString(status) + ")";
	}
}