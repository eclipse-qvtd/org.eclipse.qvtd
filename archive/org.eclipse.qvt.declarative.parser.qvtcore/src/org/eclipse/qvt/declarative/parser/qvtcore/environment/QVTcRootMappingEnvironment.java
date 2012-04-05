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

import org.eclipse.qvt.declarative.ecore.QVTCore.Mapping;
import org.eclipse.qvt.declarative.parser.qvtcore.cst.MappingCS;

public class QVTcRootMappingEnvironment extends QVTcMappingEnvironment<QVTcTransformationEnvironment>
{
	public QVTcRootMappingEnvironment(QVTcTransformationEnvironment env, MappingCS mappingCS) {
		super(env, mappingCS);
	}

	@Override
	public Set<QVTcMappingEnvironment<?>> computeMappingEnvironmentsClosure() {
		Set<QVTcMappingEnvironment<?>> closure = super.computeMappingEnvironmentsClosure();
		computeMappingEnvironmentsClosure(closure, this);
		return closure;
	}

	protected void computeMappingEnvironmentsClosure(Set<QVTcMappingEnvironment<?>> closure, QVTcRootMappingEnvironment env) {
		if (closure.add(env)) {
			for (Mapping specification : env.getMapping().getSpecification()) {
				QVTcRootMappingEnvironment specificationEnvironment = getParentEnvironment().getEnvironment(specification.getName());
				if (specificationEnvironment != null)			// null for unresolved mappings
					computeMappingEnvironmentsClosure(closure, specificationEnvironment);					
			}
		}
	}

	@Override
	public QVTcMappingEnvironment<?> getContextEnvironment() {
		return null;
	}

	@Override public QVTcRootMappingEnvironment getMappingEnvironment() { return this; }
}


