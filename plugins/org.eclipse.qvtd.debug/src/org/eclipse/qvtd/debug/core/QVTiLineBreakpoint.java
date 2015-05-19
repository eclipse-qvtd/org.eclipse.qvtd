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
package org.eclipse.qvtd.debug.core;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.debug.core.OCLDebugCore;
import org.eclipse.ocl.examples.debug.vm.core.VMLineBreakpoint;

public class QVTiLineBreakpoint extends VMLineBreakpoint
{
    public static @NonNull QVTiLineBreakpoint createRunToLineBreakpoint(@NonNull URI sourceURI, int lineNumber) throws CoreException {
    	return new QVTiLineBreakpoint(sourceURI, lineNumber, true);
    }
    
    public static QVTiLineBreakpoint getBreakpointByID(long id) {
    	for (QVTiLineBreakpoint qvtBreakpoint : OCLDebugCore.INSTANCE.getOCLBreakpoints(QVTiLineBreakpoint.class)) {
			if (qvtBreakpoint.getID() == id) {
				return qvtBreakpoint;
			}
		}
    	
    	return null;
    }

    /* 
     * Remark: Keep the default constructor to allow the breakpoint manager to create breakpoint from markers
     */
    public QVTiLineBreakpoint() {
    	super();
    }

    public QVTiLineBreakpoint(@NonNull URI sourceURI, int lineNumber) throws CoreException {
		this(sourceURI, lineNumber, false);
	}
    
    private QVTiLineBreakpoint(@NonNull URI sourceURI, int lineNumber, boolean isRunToLine) throws CoreException {  
    	super(sourceURI, lineNumber, isRunToLine);
    }

	protected @NonNull QVTiDebugCore getDebugCore() {
		return QVTiDebugCore.INSTANCE;
	}
}