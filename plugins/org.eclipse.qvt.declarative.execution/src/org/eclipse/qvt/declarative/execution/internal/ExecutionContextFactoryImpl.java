/**
 * <copyright>
 * 
 * Copyright (c) 2007, 2008 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * </copyright>
 * 
 * Contributors:
 *     Quentin Glineur - initial API and implementation
 *
 * $Id: ExecutionContextFactoryImpl.java,v 1.4 2008/10/09 17:21:01 qglineur Exp $
 */
package org.eclipse.qvt.declarative.execution.internal;

import java.util.List;

import org.eclipse.qvt.declarative.execution.ExecutionContext;
import org.eclipse.qvt.declarative.execution.ExecutionContextFactory;
import org.eclipse.qvt.declarative.execution.LabelledModel;
import org.eclipse.qvt.declarative.execution.ExecutionContext.ExecutionMode;

public class ExecutionContextFactoryImpl implements ExecutionContextFactory {

	protected static ExecutionContextFactory INSTANCE = new ExecutionContextFactoryImpl();
	
	protected ExecutionContextFactoryImpl() {
		
	}
	
	public static ExecutionContextFactory getInstance() {
		return INSTANCE;
	}
	
	public ExecutionContext createExecutionContext(
			List<LabelledModel> sourceModels, LabelledModel directionModel,
			ExecutionMode mode) {
		ExecutionContext result = new ExecutionContextImpl(sourceModels, directionModel, mode);
		return result;
	}
	

}
