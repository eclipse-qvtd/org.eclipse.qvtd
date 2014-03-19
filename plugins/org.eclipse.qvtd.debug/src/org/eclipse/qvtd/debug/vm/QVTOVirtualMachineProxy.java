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
package org.eclipse.qvtd.debug.vm;

import java.io.EOFException;
import java.io.IOException;

import org.eclipse.emf.common.util.Monitor;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.debug.vm.event.VMDisconnectEvent;
import org.eclipse.ocl.examples.debug.vm.event.VMEvent;
import org.eclipse.ocl.examples.debug.vm.event.VMTerminateEvent;
import org.eclipse.ocl.examples.debug.vm.request.VMRequest;
import org.eclipse.ocl.examples.debug.vm.request.VMTerminateRequest;
import org.eclipse.ocl.examples.debug.vm.response.VMResponse;


public class QVTOVirtualMachineProxy implements IQVTOVirtualMachineShell {

	private final @NonNull VMRemoteClient fClient;
	private final Object fRequestLock;
	private final Object fEventLock;
	
	private boolean fIsTerminated;
	private boolean fIsTerminating;
	
	public QVTOVirtualMachineProxy(String host, int requestPort, Monitor monitor) throws IOException {
		fClient = new VMRemoteClient(host, requestPort, monitor);
		fRequestLock = new Object();
		fEventLock = new Object();
		fIsTerminated = false;
	}

	public boolean isTerminated() {
		return fIsTerminated;
	}
	
	public boolean isAvailable() {
		return !(fIsTerminated || fIsTerminating); 
	}
	
	public VMResponse sendRequest(@NonNull VMRequest request) throws IOException {
		synchronized (fRequestLock) {				
			if(!isAvailable()) {
				// FIXME report not available error
				return VMResponse.createERROR();
			}
			
			if(request instanceof VMTerminateRequest) {
				fIsTerminating = true;
			}
			
			return fClient.sendRequest(request);	
		}
	}

	public VMEvent readVMEvent() throws IOException {
		try {
			VMEvent event;
			synchronized (fEventLock) {
				event = fClient.readEvent();

				if(isTerminatingEvent(event)) {
					fIsTerminated = true;
					fIsTerminating = false;
				}
			}
						
			return event;	
		} catch (EOFException e) {
			if(!fIsTerminated) {
				fIsTerminated = true;
				fIsTerminating = false;
				return new VMDisconnectEvent();
			}
			
			throw e;
		} 
	}	
	
	private boolean isTerminatingEvent(VMEvent event) {
		return event instanceof VMTerminateEvent ||
			event instanceof VMDisconnectEvent; 
	}
}
