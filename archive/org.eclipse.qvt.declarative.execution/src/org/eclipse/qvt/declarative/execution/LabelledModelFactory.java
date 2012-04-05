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
 * $Id: LabelledModelFactory.java,v 1.3 2008/10/09 17:21:02 qglineur Exp $
 */
package org.eclipse.qvt.declarative.execution;

import org.eclipse.qvt.declarative.execution.internal.LabelledModelFactoryImpl;

public interface LabelledModelFactory {

	public static LabelledModelFactory INSTANCE = LabelledModelFactoryImpl
			.getInstance();

	public LabelledModel createLabelledModel(String label,
			String modelAccessor, LabelledModel metamodel);

	public LabelledModel createLabelledMetamodel(String label,
			String modelAccessor);
}
