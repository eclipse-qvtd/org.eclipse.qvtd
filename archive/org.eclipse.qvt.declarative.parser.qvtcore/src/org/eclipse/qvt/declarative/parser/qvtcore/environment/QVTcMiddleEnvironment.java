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

import java.util.HashSet;
import java.util.Set;

import org.eclipse.qvt.declarative.ecore.QVTBase.TypedModel;
import org.eclipse.qvt.declarative.ecore.QVTCore.Area;
import org.eclipse.qvt.declarative.ecore.QVTCore.Mapping;
import org.eclipse.qvt.declarative.parser.qvtcore.cst.DomainCS;

public class QVTcMiddleEnvironment extends QVTcAreaEnvironment<Mapping>
{
	private static String getMiddleModelName(DomainCS domainCS) {
		String modelName = domainCS.getIdentifier().getValue();
		if ("".equals(modelName))
			modelName = "middle";
		return modelName;
	}

	public QVTcMiddleEnvironment(QVTcMappingEnvironment<?> env, DomainCS domainCS) {
		super(env, null, domainCS, getMiddleModelName(domainCS));
		internalSetAST(env.getASTNode());
		domainCS.setAst(ast);
		domainCS.getIdentifier().setAst(ast);
	}

	@Override
	protected Set<QVTcAreaEnvironment<?>> computeAreaEnvironmentPartialClosure() {
		Set<QVTcAreaEnvironment<?>> areaEnvironmentClosure = new HashSet<QVTcAreaEnvironment<?>>();
		for (QVTcMappingEnvironment<?> mappingEnvironment : getParentEnvironment().getMappingEnvironmentClosure()) {
			areaEnvironmentClosure.add(mappingEnvironment.getMiddleEnvironment());
			for (QVTcDomainEnvironment domainEnvironment : mappingEnvironment.getDomainEnvironments())
				areaEnvironmentClosure.add(domainEnvironment);
		}
		return areaEnvironmentClosure;
	}

	@Override
	protected Set<TypedModel> computeTypedModelClosure() {
		Set<TypedModel> closure = super.computeTypedModelClosure();
		for (QVTcDomainEnvironment domainEnvironment : getParentEnvironment().getDomainEnvironments())
			computeTypedModelClosure(closure, domainEnvironment.getTypedModel());
		return closure;
	}	

	@Override
	public Area getArea() {
		return getMapping();
	}

	@Override
	public QVTcMiddleEnvironment getContextEnvironment() {
		QVTcMappingEnvironment<?> contextEnvironment = getParentEnvironment().getContextEnvironment();
		return contextEnvironment != null ? contextEnvironment.getMiddleEnvironment() : null;
	}

	public Mapping getMapping() {
		return getMappingEnvironment().getMapping();
	}

	@Override
	public QVTcMappingEnvironment<?> getMappingEnvironment() {
		return getParentEnvironment();
	}
}
