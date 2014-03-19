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

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

import org.eclipse.emf.common.util.Monitor;
import org.eclipse.ocl.examples.debug.vm.event.VMEvent;
import org.eclipse.ocl.examples.debug.vm.request.VMConnectRequest;
import org.eclipse.ocl.examples.debug.vm.request.VMRequest;
import org.eclipse.ocl.examples.debug.vm.response.VMConnectResponse;
import org.eclipse.ocl.examples.debug.vm.response.VMResponse;
import org.eclipse.qvtd.debug.utils.SocketUtil;


class VMRemoteClient {
	
	public static final int CONNECT_ATTEMPTS = 100;
	public static final int CONNECT_ATTEMPT_DELAY = 200;
	
	private InetSocketAddress fAddress;
	private Socket fRequestSocket;		
	private ObjectOutputStream fRequestOut;
	private ObjectInputStream fResponseIn;
	private InputStream fResponseIS;
	
	private Socket fEventSocket;
	private int fEventPort;
	private ObjectInputStream fEventObjInput;		
	
	
	VMRemoteClient(String host, int requestPort, Monitor monitor) throws IOException {	
		fAddress = new InetSocketAddress(host, requestPort);
		fRequestSocket = connect(fAddress, CONNECT_ATTEMPTS, monitor);
		
		fRequestOut = new ObjectOutputStream(fRequestSocket.getOutputStream());
		fResponseIS = fRequestSocket.getInputStream();
						
		VMResponse response = sendRequest(new VMConnectRequest());
		
		if(response instanceof VMConnectResponse) {
			VMConnectResponse connectResponse = (VMConnectResponse) response;
			fEventPort = connectResponse.getEventPort();
		} else {
			// FIXME
			throw new IOException("No free port for event dispatcher");
		}
	}


	VMEvent readEvent() throws IOException {
		if(fEventObjInput == null) {
			assert fRequestSocket != null;
			
			InetSocketAddress eventSocketAddress = new InetSocketAddress(fAddress.getAddress(), fEventPort);
			int attemptCount = 3;
			
			Socket eventSocket = connect(eventSocketAddress, attemptCount, null); 
			fEventObjInput = new ObjectInputStream(eventSocket.getInputStream());
		}

		try {
			return (VMEvent) fEventObjInput.readObject();
		} catch (ClassNotFoundException e) {
			throw new IOException(e.toString());
		}
	}
	
	VMResponse sendRequest(VMRequest request) throws IOException {
		fRequestOut.writeObject(request);
		fRequestOut.flush();
				
		try {
			if(fResponseIn == null) {
				fResponseIn = new ObjectInputStream(fResponseIS);
			}
			
			Object readObject = fResponseIn.readObject();

			if(readObject instanceof VMResponse == false) {
				// FIXME -  report invalid response
				return VMResponse.createERROR();
			}
			
			return (VMResponse) readObject;
			
		} catch (ClassNotFoundException e) {
			throw new IOException(e.toString());
		}
	}
	
	void close() throws IOException {
		SocketUtil.close(fRequestOut);
		SocketUtil.close(fResponseIn);
		SocketUtil.close(fRequestSocket);
		
		SocketUtil.close(fEventObjInput);
		SocketUtil.close(fEventSocket);
	}
	
	private Socket connect(InetSocketAddress address, int attemptCount, Monitor monitor) throws IOException {
		Socket socket = null;
		
		int attempts = attemptCount;			
		while(attempts-- > 0) {
			try {
				socket = new Socket(address.getAddress(), address.getPort());
				break;
			} catch (IOException e) {
				if (attempts == 0 || (monitor != null && monitor.isCanceled())) {
					throw e;
				}
			}

			try {
				// get some sleep and try again				
				Thread.sleep(CONNECT_ATTEMPT_DELAY);
			} catch (InterruptedException e) {
				Thread.interrupted();
			}			
		}
		assert socket != null;
		return socket;
	}
	
}