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
package org.eclipse.qvt.declarative.parser.qvtrelation.environment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.cst.SimpleNameCS;
import org.eclipse.ocl.cst.VariableExpCS;
import org.eclipse.ocl.ecore.CollectionType;
import org.eclipse.ocl.ecore.EcoreFactory;
import org.eclipse.ocl.ecore.Variable;
import org.eclipse.ocl.expressions.CollectionKind;
import org.eclipse.ocl.util.TypeUtil;
import org.eclipse.qvt.declarative.ecore.QVTBase.Domain;
import org.eclipse.qvt.declarative.ecore.QVTRelation.QVTRelationFactory;
import org.eclipse.qvt.declarative.ecore.QVTRelation.Relation;
import org.eclipse.qvt.declarative.ecore.QVTRelation.RelationDomain;
import org.eclipse.qvt.declarative.ecore.QVTRelation.RelationalTransformation;
import org.eclipse.qvt.declarative.parser.qvt.cst.IdentifierCS;
import org.eclipse.qvt.declarative.parser.qvtrelation.AbstractQVTrAnalyzer;
import org.eclipse.qvt.declarative.parser.qvtrelation.cst.AbstractDomainCS;
import org.eclipse.qvt.declarative.parser.qvtrelation.cst.DomainCS;
import org.eclipse.qvt.declarative.parser.qvtrelation.cst.PrimitiveTypeDomainCS;
import org.eclipse.qvt.declarative.parser.qvtrelation.cst.RelationCS;
import org.eclipse.qvt.declarative.parser.utils.OCLUtils;

public class QVTrRelationEnvironment extends QVTrEnvironment<QVTrTransformationEnvironment, Relation, RelationCS>
{
	private static class ImplicitVariable
	{
		public final EClassifier type;
		public final Domain domain;;
		public final boolean isInvocation;
		public final CSTNode cstNode;
		public ImplicitVariable(EClassifier type, Domain domain, boolean isInvocation, CSTNode cstNode) {
			this.type = type;
			this.domain = domain;
			this.isInvocation = isInvocation;
			this.cstNode = cstNode;
		}
		public boolean isChecked() { return domain.isIsCheckable(); }
		public boolean isEnforced() { return domain.isIsEnforceable(); }
		public boolean isInvocation() { return isInvocation; }
	}
	
	private Map<AbstractDomainCS, QVTrDomainEnvironment> domEnvMap = new HashMap<AbstractDomainCS, QVTrDomainEnvironment>(); 
	private final Map<String, Variable> explicitVariableMap = new HashMap<String, Variable>();
	private final Map<String, List<ImplicitVariable>> implicitVariableMap = new HashMap<String, List<ImplicitVariable>>();
	
	public QVTrRelationEnvironment(QVTrTransformationEnvironment env, RelationCS relationCS) {
		super(env, QVTRelationFactory.eINSTANCE.createRelation(), relationCS);
		setNameFromIdentifier(ast, relationCS.getIdentifier());
		for (Domain domain : ast.getDomain()) {
			Variable rootVariable = ((RelationDomain) domain).getRootVariable();
			String rootVariableName = rootVariable.getName();
			if (rootVariableName != null) {
				addElement(rootVariableName, rootVariable, true);
				explicitVariableMap.put(rootVariableName, rootVariable);
			}
		}
	}

	private void addExplicitVariable(Variable variable) {
		ast.getVariable().add(variable);
		String name = variable.getName();
		if (!isSpecialVariable(variable))
			addElement(name, variable, true);
		explicitVariableMap.put(name, variable);
	}

	protected boolean checkImplicitElementType(EClass explicitElementClass, ImplicitVariable implicitVariable, EClass implicitElementClass) {
		boolean isConflicting;
		if (implicitElementClass == null)
			isConflicting = true;
		else if (implicitElementClass == explicitElementClass)
			isConflicting = false;
		else if (!implicitVariable.isInvocation() && implicitVariable.isEnforced())
			isConflicting = !implicitElementClass.isSuperTypeOf(explicitElementClass);	// enforce may refer to supertype of known type
		else if (!implicitVariable.isInvocation() && !implicitVariable.isEnforced())
			isConflicting = true;
		else if (implicitVariable.isInvocation() && implicitVariable.isChecked())
			isConflicting = !implicitElementClass.isSuperTypeOf(explicitElementClass) && !explicitElementClass.isSuperTypeOf(implicitElementClass);	// checkonly may refer to supertype of known type or vice-versa					
		else if (implicitVariable.isInvocation() && implicitVariable.isEnforced())
			isConflicting = !implicitElementClass.isSuperTypeOf(explicitElementClass);	// enforce may refer to supertype of known type					
		else if (implicitVariable.isInvocation() && !implicitVariable.isEnforced())
			isConflicting = true;
		else
			isConflicting = true;
		return isConflicting;
	}

	public QVTrDomainEnvironment createEnvironment(DomainCS domainCS) {
		QVTrDomainEnvironment environment = new QVTrDomainEnvironment(this, domainCS);
		RelationDomain domain = environment.getDomain();
		ast.getDomain().add(domain);
		domEnvMap.put(domainCS, environment);
		return environment;
	}

	public QVTrDomainEnvironment createEnvironment(PrimitiveTypeDomainCS domainCS) {
		QVTrDomainEnvironment environment = new QVTrDomainEnvironment(this, domainCS);
		RelationDomain domain = environment.getDomain();
		ast.getDomain().add(domain);
		domEnvMap.put(domainCS, environment);
		return environment;
	}

	public void createReferencedVariables(AbstractQVTrAnalyzer parser) {
		for (String name : implicitVariableMap.keySet()) {
			List<ImplicitVariable> implicitVariables = implicitVariableMap.get(name);
			Variable variable = explicitVariableMap.get(name);
			EClassifier explicitType = variable != null ? variable.getType() : null;
			CollectionType explicitCollectionType = (explicitType instanceof CollectionType) ? (CollectionType) explicitType : null;
			@SuppressWarnings("unused") CollectionKind explicitCollectionKind = explicitCollectionType != null ? explicitCollectionType.getKind() : null;
			EClassifier explicitElementType = explicitCollectionType != null ? explicitCollectionType.getElementType() : explicitType;
			EClass explicitElementClass = (explicitElementType instanceof EClass) ? (EClass) explicitElementType : null;
			if (variable == null)
				variable = createVariableDeclaration(name, null, implicitVariables.get(0).cstNode);
			for (ImplicitVariable implicitVariable : implicitVariables) {
				EClassifier resolvedType = variable.getType();
				CollectionType resolvedCollectionType = (resolvedType instanceof CollectionType) ? (CollectionType) resolvedType : null;
				CollectionKind resolvedCollectionKind = resolvedCollectionType != null ? resolvedCollectionType.getKind() : null;
				EClassifier resolvedElementType = resolvedCollectionType != null ? resolvedCollectionType.getElementType() : resolvedType;
				@SuppressWarnings("unused") EClass resolvedElementClass = (resolvedElementType instanceof EClass) ? (EClass) resolvedElementType : null;
				EClassifier implicitType = implicitVariable.type;
				CollectionType implicitCollectionType = (implicitType instanceof CollectionType) ? (CollectionType) implicitType : null;
				CollectionKind implicitCollectionKind = implicitCollectionType != null ? implicitCollectionType.getKind() : null;
				EClassifier implicitElementType = implicitCollectionType != null ? implicitCollectionType.getElementType() : implicitType;
				EClass implicitElementClass = (implicitElementType instanceof EClass) ? (EClass) implicitElementType : null;
				boolean isConflicting = false;
				if (resolvedElementType == null)
					getUMLReflection().setType(variable, implicitType);
				else if ((resolvedCollectionKind == null) && (implicitCollectionKind != null))	// Collection = non-Collection
					isConflicting = checkImplicitElementType(explicitElementClass, implicitVariable, implicitElementClass);
				else if ((resolvedCollectionKind != null) != (implicitCollectionKind != null))	// Collection / non-Collection
					isConflicting = true;
				else if (resolvedElementType == implicitElementType)
					;
				else if (explicitElementClass != null)
					isConflicting = checkImplicitElementType(explicitElementClass, implicitVariable, implicitElementClass);
				else if (explicitElementType != null) {
					isConflicting = true;		// FIXME Check Sets
				}
				else {
					CollectionKind commonCollectionKind = OCLUtils.commonCollectionKind(resolvedCollectionKind, implicitCollectionKind);
					EClassifier commonElementType = TypeUtil.commonSuperType(null, this, resolvedElementType, implicitElementType);
					if ((commonElementType == resolvedElementType) && (commonCollectionKind == resolvedCollectionKind))
						;
					else if ((commonElementType == implicitElementType) && (commonCollectionKind == implicitCollectionKind))
						variable.setType(implicitType);
					else if (commonElementType != null) {
						if (commonCollectionKind == null)
							variable.setType(commonElementType);
						else
							variable.setType(OCLUtils.getOCLCollectionType(commonElementType, OCLUtils.isOrdered(commonCollectionKind), OCLUtils.isUnique(commonCollectionKind)));
					}
					else
						isConflicting = true;
				}
				if (isConflicting) {
					String message = "Conflicting type '" + parser.formatType(implicitType) + "' for '" + name + ":" + parser.formatType(resolvedType) + "'";
					analyzerError(message, "implicit varDeclarationCS", implicitVariable.cstNode);
				}
			}
		}
	}
	
	public void createVariableDeclaration(VariableExpCS variableExpCS, EClassifier type, Domain domain, boolean isInvocation) {
		SimpleNameCS simpleNameCS = variableExpCS.getSimpleNameCS();
		String name = simpleNameCS.getValue();
		Variable explicitVariable = explicitVariableMap.get(name);
		if (explicitVariable == null) {
			List<ImplicitVariable> list = implicitVariableMap.get(name);
			if (list == null) {
				list = new ArrayList<ImplicitVariable>();
				implicitVariableMap.put(name, list);
			}
			if (!list.contains(type))
				list.add(new ImplicitVariable(type, domain, isInvocation, simpleNameCS));
		}
	}
	
	@Override public Variable createVariableDeclaration(IdentifierCS identifierCS, EClassifier type) {
		Variable createVariableDeclaration = createVariableDeclaration(identifierCS.getValue(), type, identifierCS);
//		identifierCS.setAst(createVariableDeclaration);
		return createVariableDeclaration;
	}

	private Variable createVariableDeclaration(String name, EClassifier type, CSTNode cstNode) {
		Variable variable = explicitVariableMap.get(name);
		if (variable != null) {
			if ((variable.getType() != type) && !isSpecialVariable(variable)) {
				String message = "Conflicting type '" + formatType(type) + "' for variable of type '" + formatType(variable.getType()) + "'";
				analyzerError(message, "explicit varDeclarationCS", cstNode);
			}
			cstNode.setAst(variable);
		}
		else {
			variable = EcoreFactory.eINSTANCE.createVariable();
			initASTMapping(variable, cstNode);
			variable.setName(name);
			if (!isSpecialVariable(variable))
				variable.setType(type);
			else
				variable.setType(getOCLStandardLibrary().getOclAny());
			addExplicitVariable(variable);
		}
		return variable;
	}

	public QVTrDomainEnvironment getEnvironment(DomainCS domainCS) {
		return domEnvMap.get(domainCS);
	}

	public Relation getRelation() { return ast; }

	@Override public Relation getRelation(List<String> pathName, String relationName) {
		RelationalTransformation transformation = getRelationalTransformation();
		if (pathName != null)
			transformation = getRelationalTransformation(pathName);
		return transformation != null ? transformation.getRelation(relationName) : null;
	}

	public Variable getVariable(String name) {
		return explicitVariableMap.get(name);
	}

	@Override
	public Variable tryLookupVariable(String name) {
		return getVariable(name);
	}
}
