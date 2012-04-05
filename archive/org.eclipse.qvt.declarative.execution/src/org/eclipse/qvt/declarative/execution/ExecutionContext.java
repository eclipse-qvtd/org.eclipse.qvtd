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
 * $Id: ExecutionContext.java,v 1.5 2008/10/09 17:21:02 qglineur Exp $
 */
package org.eclipse.qvt.declarative.execution;

import java.util.List;

public interface ExecutionContext {
	
	public static enum ExecutionMode {
		enforcement, checkOnly
	}

	public abstract LabelledModel getDirectionModel();

	public abstract void setDirectionModel(LabelledModel directionModel);

	public abstract ExecutionMode getMode();

	public abstract void setMode(ExecutionMode mode);

	public abstract void addSourceModel(LabelledModel model);

	public abstract List<LabelledModel> getSourceModels();

}