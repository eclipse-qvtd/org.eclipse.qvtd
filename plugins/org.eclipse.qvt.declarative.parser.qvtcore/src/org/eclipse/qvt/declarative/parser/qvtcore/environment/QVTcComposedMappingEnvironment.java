/*******************************************************************************
 * Copyright (c) 2007 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvt.declarative.parser.qvtcore.environment;

import java.util.Set;

import org.eclipse.qvt.declarative.parser.qvtcore.cst.MappingCS;

public class QVTcComposedMappingEnvironment extends QVTcMappingEnvironment<QVTcMappingEnvironment<?>>
{
	public QVTcComposedMappingEnvironment(QVTcMappingEnvironment<?> env, MappingCS mappingCS) {
		super(env, mappingCS);
		env.getMapping().getLocal().add(getMapping());
	}

	@Override
	public Set<QVTcMappingEnvironment<?>> computeMappingEnvironmentsClosure() {
		Set<QVTcMappingEnvironment<?>> closure = super.computeMappingEnvironmentsClosure();
		closure.add(this);
		return closure;
	}
	
	@Override
	public QVTcMappingEnvironment<?> getContextEnvironment() {
		return getParentEnvironment();
	}

	@Override public QVTcComposedMappingEnvironment getMappingEnvironment() { return this; }
}
