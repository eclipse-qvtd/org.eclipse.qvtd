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
package org.eclipse.qvtd.debug.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import org.eclipse.qvtd.debug.QVTdDebugPlugin;

public class SocketUtil {
	
	private SocketUtil() {
		super();
	}

	/**
	 * Returns a free port number on localhost, or -1 if unable to find a free port.
	 * 
	 * @return a free port number on localhost, or -1 if unable to find a free port
	 * @since 3.0
	 */
	public static int findFreePort() {
		ServerSocket socket= null;
		try {
			socket= new ServerSocket(0);
			return socket.getLocalPort();
		} catch (IOException e) { 
		} finally {
			if (socket != null) {
				try {
					socket.close();
				} catch (IOException e) {
				}
			}
		}
		return -1;		
	}	

	public static boolean close(Socket socket) {
		try {
			socket.close();
			return true;
		} catch (IOException e) {
	        if(QVTODebugCore.TRACE.shouldTraceCatching()) {
	        	QVTODebugCore.TRACE.catching(SocketUtil.class, "close(Socket socket)", e); //$NON-NLS-1$
	        }
			
	        QVTdDebugPlugin.log(e);
		}
		
		return false;
	}
	
	public static boolean close(ServerSocket socket) {
		try {
			socket.close();
			return true; 
		} catch (IOException e) {
	        if(QVTODebugCore.TRACE.shouldTraceCatching()) {
	        	QVTODebugCore.TRACE.catching(SocketUtil.class, "close(ServerSocket socket)", e); //$NON-NLS-1$
	        }
			
	        QVTdDebugPlugin.log(e);
		}
		return false;
	}	
	
	public static boolean close(InputStream is) {
		try {
			is.close();
			return true; 
		} catch (IOException e) {
	        if(QVTODebugCore.TRACE.shouldTraceCatching()) {
	        	QVTODebugCore.TRACE.catching(SocketUtil.class, "close(InputStream is)", e); //$NON-NLS-1$
	        }
			
	        QVTdDebugPlugin.log(e);
		}
		return false;
	}
	
	public static boolean close(OutputStream os) {
		try {
			os.close();
			return true; 
		} catch (IOException e) {
	        if(QVTODebugCore.TRACE.shouldTraceCatching()) {
	        	QVTODebugCore.TRACE.catching(SocketUtil.class, "close(OutputStream os)", e); //$NON-NLS-1$
	        }
			
	        QVTdDebugPlugin.log(e);
		}
		
		return false;
	}	
}
