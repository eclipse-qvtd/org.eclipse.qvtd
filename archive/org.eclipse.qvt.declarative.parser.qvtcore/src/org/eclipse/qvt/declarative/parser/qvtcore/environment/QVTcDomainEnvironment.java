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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.qvt.declarative.ecore.QVTCore.CoreDomain;
import org.eclipse.qvt.declarative.ecore.QVTCore.QVTCoreFactory;
import org.eclipse.qvt.declarative.ecore.QVTCore.Mapping;
import org.eclipse.qvt.declarative.parser.qvtcore.cst.DomainCS;

public class QVTcDomainEnvironment extends QVTcAreaEnvironment<CoreDomain>
{
	public QVTcDomainEnvironment(QVTcMappingEnvironment<?> env, DomainCS domainCS) {
		super(env, QVTCoreFactory.eINSTANCE.createCoreDomain(), domainCS, domainCS.getIdentifier().getValue());
		setNameFromIdentifier(ast, domainCS.getIdentifier());
		ast.setIsCheckable(domainCS.isCheck());
		ast.setIsEnforceable(domainCS.isEnforce());
		getMapping().getDomain().add(ast);
		ast.setTypedModel(getTypedModel());		
	}

	@Override
	protected Set<QVTcAreaEnvironment<?>> computeAreaEnvironmentPartialClosure() {
		Set<QVTcAreaEnvironment<?>> areaEnvironmentClosure = new HashSet<QVTcAreaEnvironment<?>>();
		for (QVTcMappingEnvironment<?> mappingEnvironment : getParentEnvironment().getMappingEnvironmentClosure()) {
			QVTcDomainEnvironment domainEnvironment = mappingEnvironment.getDomainEnvironment(modelName);
			if (domainEnvironment != null)
				areaEnvironmentClosure.add(domainEnvironment);
		}
		areaEnvironmentClosure.add(this);	// Reduce error messages in case a duplicate domain hides this one
		return areaEnvironmentClosure;
	}

	@Override public CoreDomain getArea() { return ast; }

	@Override
	public QVTcDomainEnvironment getContextEnvironment() {
		QVTcMappingEnvironment<?> contextEnvironment = getParentEnvironment().getContextEnvironment();
		return contextEnvironment != null ? contextEnvironment.getDomainEnvironment(modelName) : null;
	}

	@Override public QVTcMappingEnvironment<?> getMappingEnvironment() {
		return getParentEnvironment();
	}

	public Mapping getMapping() { return getParentEnvironment().getMapping(); }

	@Override public String getModelName(EObject object) {
		Set<EPackage> ePackages = getUsedPackageClosure();
		if (ePackages.contains(object))
			return getTypedModel().getName();
		return super.getModelName(object);
	}
}
