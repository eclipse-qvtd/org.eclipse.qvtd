/*******************************************************************************
 * Copyright (c) 2009, 2013 R.Dvorak and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Radek Dvorak - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.debug.vm;


import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.debug.evaluator.DebugRootQVTiEvaluationVisitor;
import org.eclipse.qvtd.debug.vm.protocol.VMEvent;
import org.eclipse.qvtd.debug.vm.protocol.VMRequest;

public interface IQVTODebuggerShell {

	void sessionStarted(@NonNull DebugRootQVTiEvaluationVisitor evaluator);
	
	VMRequest popRequest();

	VMRequest waitAndPopRequest(@NonNull VMEvent suspend) throws InterruptedException;
	
	VMRequest peekRequest();
	
	void handleVMEvent(@NonNull VMEvent event);	

	VMBreakpointManager getBreakPointManager();
}
