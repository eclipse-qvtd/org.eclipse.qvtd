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

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.ocl.LookupException;
import org.eclipse.qvt.declarative.ecore.QVTBase.TypedModel;
import org.eclipse.qvt.declarative.ecore.QVTCore.CoreDomain;
import org.eclipse.qvt.declarative.ecore.QVTCore.Mapping;
import org.eclipse.qvt.declarative.ecore.QVTCore.QVTCoreFactory;
import org.eclipse.qvt.declarative.parser.qvt.cst.IdentifierCS;
import org.eclipse.qvt.declarative.parser.qvtcore.cst.DomainCS;
import org.eclipse.qvt.declarative.parser.qvtcore.cst.MappingCS;

public abstract class QVTcMappingEnvironment<P extends IQVTcNodeEnvironment> extends QVTcEnvironment<IQVTcNodeEnvironment, P, Mapping, MappingCS> implements IQVTcEnvironment
{
	private Map<DomainCS, QVTcDomainEnvironment> domainCSEnvironments = new HashMap<DomainCS, QVTcDomainEnvironment>(); 
	private Map<String, QVTcDomainEnvironment> domainEnvironments = new HashMap<String, QVTcDomainEnvironment>(); 
	private Map<MappingCS, QVTcComposedMappingEnvironment> childCSEnvironments = new HashMap<MappingCS, QVTcComposedMappingEnvironment>(); 
	private List<EPackage> middlePackages = null;
	private Set<QVTcMappingEnvironment<?>> mappingEnvironmentClosure = null;
	private QVTcMiddleEnvironment middleEnvironment = null;
	
	protected QVTcMappingEnvironment(P env, MappingCS mappingCS) {
		super(env, QVTCoreFactory.eINSTANCE.createMapping(), mappingCS);
		setNameFromIdentifier(ast, mappingCS.getIdentifier());
	}

	protected Set<QVTcMappingEnvironment<?>> computeMappingEnvironmentsClosure() {
		return new HashSet<QVTcMappingEnvironment<?>>();
	}

	public QVTcComposedMappingEnvironment createComposedMappingEnvironment(MappingCS mappingCS) {
		assert mappingEnvironmentClosure == null : "Must not createComposedMappingEnvironment after computeMappingEnvironmentsClosure";
		QVTcComposedMappingEnvironment environment = new QVTcComposedMappingEnvironment(this, mappingCS);
		childCSEnvironments.put(mappingCS, environment);
		return environment;
	}

	public QVTcDomainEnvironment createDomainEnvironment(DomainCS domainCS) {
		assert mappingEnvironmentClosure == null : "Must not createDomainEnvironment after computeMappingEnvironmentsClosure";
		QVTcDomainEnvironment environment = new QVTcDomainEnvironment(this, domainCS);
		domainCSEnvironments.put(domainCS, environment);
		IdentifierCS identifierCS = domainCS.getIdentifier();
		if (identifierCS != null) {
			String name = identifierCS.getValue();
			@SuppressWarnings("unused")
			QVTcDomainEnvironment oldEnvironment = domainEnvironments.put(name, environment);
//			if (oldEnvironment != null)
//				analyzerError("Duplicate domain name '" + name + "'", "DomainCS", identifierCS); -- moved to validation
			String middleModelName = middleEnvironment.getModelName();
			if (name.equals(middleModelName))
				analyzerWarning("Domain name '" + name + "' should be distinct from middle domain name '" + middleModelName + "'", "DomainCS", identifierCS);
		}
		return environment;
	}

	public QVTcMiddleEnvironment createMiddleEnvironment(DomainCS domainCS) {
		assert mappingEnvironmentClosure == null : "Must not createMiddleEnvironment after computeMappingEnvironmentsClosure";
		middleEnvironment = new QVTcMiddleEnvironment(this, domainCS);
		return middleEnvironment;
	}
	
	public abstract QVTcMappingEnvironment<?> getContextEnvironment();

	public QVTcDomainEnvironment getDomainEnvironment(String domainName) {
		return domainEnvironments.get(domainName);
	}

	public Collection<QVTcDomainEnvironment> getDomainEnvironments() {
		return domainCSEnvironments.values();	// Only domainCSEnvironments has the duplicates
	}

	public QVTcDomainEnvironment getEnvironment(DomainCS domainCS) {
		return domainCSEnvironments.get(domainCS);
	}

	public QVTcComposedMappingEnvironment getEnvironment(MappingCS mappingCS) {
		return childCSEnvironments.get(mappingCS);
	}

	public Mapping getMapping() { return ast; }

	public QVTcMappingEnvironment<?> getMappingEnvironment() { return this; }

	public Set<QVTcMappingEnvironment<?>> getMappingEnvironmentClosure() {
		if (mappingEnvironmentClosure == null)
			mappingEnvironmentClosure = computeMappingEnvironmentsClosure();
		return mappingEnvironmentClosure;
	}

	public QVTcMiddleEnvironment getMiddleEnvironment() {
		return middleEnvironment;
	}

	public QVTcPatternEnvironment<?> getPatternEnvironment(QVTcPatternEnvironment<?> patternEnv) {
		QVTcAreaEnvironment<?> areaEnv = patternEnv.getParentEnvironment();
		QVTcAreaEnvironment<?> domainEnv = null;
		if (areaEnv instanceof QVTcDomainEnvironment) {
			CoreDomain domain = ((QVTcDomainEnvironment)areaEnv).getASTNode();
			if (domain == null)
				return null;
			domainEnv = getDomainEnvironment(domain.getName());
		}
		else
			domainEnv = getMiddleEnvironment();
		if (domainEnv == null)
			return null;
		return patternEnv instanceof QVTcGuardPatternEnvironment
				? domainEnv.getGuardPatternEnvironment()
				: domainEnv.getBottomPatternEnvironment();
	}

	@Override public EClassifier tryLookupClassifier(List<String> names) throws LookupException {
		if (names == null)
			return null;
		int namesSize = names.size();
		if (namesSize > 0) {
			if (middlePackages == null) {
				middlePackages = new ArrayList<EPackage>();
				TypedModel middleTypedModel = getMiddleEnvironment().getTypedModel();
				middlePackages.addAll(middleTypedModel.getUsedPackage());
			}
			EClassifier eClassifier = tryLookupClassifier(middlePackages, names);
			if (eClassifier != null)
				return eClassifier;
		}
		return super.tryLookupClassifier(names);
	}
}
