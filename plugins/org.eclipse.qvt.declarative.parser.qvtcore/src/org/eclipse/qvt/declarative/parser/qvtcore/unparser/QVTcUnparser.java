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
package org.eclipse.qvt.declarative.parser.qvtcore.unparser;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.Variable;
import org.eclipse.ocl.types.VoidType;
import org.eclipse.qvt.declarative.ecore.QVTBase.Domain;
import org.eclipse.qvt.declarative.ecore.QVTBase.Function;
import org.eclipse.qvt.declarative.ecore.QVTBase.Predicate;
import org.eclipse.qvt.declarative.ecore.QVTBase.Rule;
import org.eclipse.qvt.declarative.ecore.QVTBase.Transformation;
import org.eclipse.qvt.declarative.ecore.QVTBase.TypedModel;
import org.eclipse.qvt.declarative.ecore.QVTCore.Area;
import org.eclipse.qvt.declarative.ecore.QVTCore.Assignment;
import org.eclipse.qvt.declarative.ecore.QVTCore.BottomPattern;
import org.eclipse.qvt.declarative.ecore.QVTCore.CoreDomain;
import org.eclipse.qvt.declarative.ecore.QVTCore.EnforcementMode;
import org.eclipse.qvt.declarative.ecore.QVTCore.EnforcementOperation;
import org.eclipse.qvt.declarative.ecore.QVTCore.GuardPattern;
import org.eclipse.qvt.declarative.ecore.QVTCore.Mapping;
import org.eclipse.qvt.declarative.ecore.QVTCore.PropertyAssignment;
import org.eclipse.qvt.declarative.ecore.QVTCore.RealizedVariable;
import org.eclipse.qvt.declarative.ecore.QVTCore.VariableAssignment;
import org.eclipse.qvt.declarative.parser.qvt.environment.QVTReflectionImpl;
import org.eclipse.qvt.declarative.parser.unparser.OCLExpressionUnparser;

public class QVTcUnparser extends OCLExpressionUnparser
{
	public QVTcUnparser(Resource resource) {
		super(resource, QVTReflectionImpl.INSTANCE);
	}

	@Override public void unparse() {
		initialize();
		boolean first = true;
		for (EObject eObject : resource.getContents()) {
			if (!first)
				append("\n");
			if (eObject instanceof Transformation)
				unparseTransformation((Transformation) eObject);
			else
				unparseUnsupported(eObject);
			first = false;
		}
		for (EObject eObject : resource.getContents()) {
			if (!first)
				append("\n");
			if (eObject instanceof Transformation) {
				for (EOperation operation : ((Transformation)eObject).getEOperations())
					if (operation instanceof Function)
						unparseQuery((Function) operation);
					else
						unparseUnsupported(operation);
				for (Rule rule : ((Transformation)eObject).getRule())
					if (rule instanceof Mapping)
						unparseMapping((Mapping) rule);
					else
						unparseUnsupported(rule);
			}
			first = false;
		}
	}

	protected void unparseArea(Area area, List<EPackage> areaPackages) {
		if (area == null)
			return;
		append(" (\n");
		unparseGuardPattern(area.getGuardPattern(), areaPackages);
		append(") {\n");
		unparseBottomPattern(area.getBottomPattern(), areaPackages);
		append("}\n");
	}

	protected Object unparseAreaVariable(Variable variable, List<EPackage> areaPackages) {
		if (variable == null)
			append("_null_variable_");
		else {
			appendName(variable);
			EClassifier type = variable.getType();
			if (type != null) {
				EPackage variablePackage = type.getEPackage();
				if ((areaPackages != null) && areaPackages.contains(variablePackage)) {
					append(" : ");
					appendName(type);
				}
				else if ((variablePackage != null) && "oclstdlib".equals(variablePackage.getName())) {
					append(" : ");
					appendName(type);
				}
				else {
					if (type.eIsProxy())
						type = variable.getType();
					if ((type != null) && !(type instanceof VoidType<?>)) {
						append(" : ");
						appendQualifiedName(type);
					}
				}
			}
		}
		return this;
	}

	protected void unparseAssignment(Assignment assignment) {
		if (assignment == null)
			return;
		if (assignment.isIsDefault())
			append("default ");
		if (assignment instanceof PropertyAssignment) {
			PropertyAssignment propertyAssignment = (PropertyAssignment)assignment;
			doExpressionSwitch(propertyAssignment.getSlotExpression());		
			append(".");
			appendName(propertyAssignment.getTargetProperty());		
		}
		else if (assignment instanceof VariableAssignment) {
			VariableAssignment variableAssignment = (VariableAssignment)assignment;
			appendName(variableAssignment.getTargetVariable());		
		}
		else
			unparseUnsupported(assignment);
		append(" := ");
		doExpressionSwitch(assignment.getValue());		
		append(";\n");
	}

	protected void unparseBottomPattern(BottomPattern pattern, List<EPackage> areaPackages) {
		if (pattern == null)
			return;
		indent();
		EList<Variable> variables = pattern.getVariable();
		EList<RealizedVariable> realizedVariables = pattern.getRealizedVariable();
		if ((realizedVariables.size() > 0) || (variables.size() > 0)) {
			boolean first = true;
			for (Variable realizedVariable : realizedVariables) {
				if (!first)
					append(",\n");
				append("realize ");
				unparseAreaVariable(realizedVariable, areaPackages);
				first = false;
			}
			for (Variable variable : variables) {
				if (!first)
					append(",\n");
				unparseAreaVariable(variable, areaPackages);
				first = false;
			}
			exdent();
			append("\n|\n");
			indent();
		}
		for (Predicate predicate : pattern.getPredicate())
			unparsePredicate(predicate);
		for (Assignment assignment : pattern.getAssignment())
			unparseAssignment(assignment);
		for (EnforcementOperation enforcementOperation : pattern.getEnforcementOperation())
			unparseEnforcementOperation(enforcementOperation);
		exdent();
	}

	protected void unparseCoreDomain(CoreDomain domain) {
		if (domain == null)
			return;
		if (domain.isIsCheckable())
			append("check ");
		if (domain.isIsEnforceable())
			append("enforce ");
		appendName(domain.getTypedModel());
		unparseArea(domain, domain.getTypedModel().getUsedPackage());
//		for (EnforcementOperation enforcementOperation : domain.getBottomPattern().getEnforcementOperation())
//		unparseEnforcementOperation(enforcementOperation);
	}

	protected void unparseEnforcementOperation(EnforcementOperation enforcementOperation) {
		if (enforcementOperation == null)
			return;
		append(enforcementOperation.getEnforcementMode() == EnforcementMode.CREATION ? "creation " : "deletion ");
		doExpressionSwitch(enforcementOperation.getOperationCallExp());		
		append(";\n");
	}

	protected void unparseGuardPattern(GuardPattern pattern, List<EPackage> areaPackages) {
		if (pattern == null)
			return;
		indent();
		List<Variable> variables = pattern.getVariable();
		for (Variable variable : variables)
			unparseAreaVariable(variable, areaPackages);
		List<Predicate> predicates = pattern.getPredicate();
		if (predicates.size() > 0) {
			if (variables.size() > 0) {
				exdent();
				append("\n|\n");
				indent();
			}
			for (Predicate predicate : predicates)
				unparsePredicate(predicate);
		}
		exdent();
	}

	protected void unparseMapping(Mapping mapping) {
		if (mapping == null)
			return;
		append("map ");
		if (mapping.getName() != null) {
			appendName(mapping);
			append(" ");
		}
		if (mapping.getContext() == null) {
			Transformation transformation = mapping.getTransformation();
			if (transformation != null) {
				append("in ");
				appendName(transformation);
				append(" ");
			}
		}
		EList<Mapping> specifications = mapping.getSpecification();
		if (!specifications.isEmpty()) {
			append("refines ");
			boolean isFirst = true;
			for (Mapping specification : specifications) {
				if (!isFirst)
					append(", ");
				appendName(specification);
				isFirst = false;
			}
		}
		append(" {\n");
		indent();
		for (Domain domain : mapping.getDomain())
			if (domain instanceof CoreDomain)
				unparseCoreDomain((CoreDomain)domain);
			else
				unparseUnsupported(domain);
		append("where");
		Mapping rootMapping = mapping;
		while (rootMapping.getContext() != null)
			rootMapping = rootMapping.getContext();
		List<TypedModel> middleTypedModels = new ArrayList<TypedModel>(rootMapping.getTransformation().getModelParameter());
		List<EPackage> middlePackages = new ArrayList<EPackage>();
		for (Domain domain : mapping.getDomain())
			middleTypedModels.remove(domain.getTypedModel());
		for (TypedModel middleTypedModel : middleTypedModels)
			middlePackages.addAll(middleTypedModel.getUsedPackage());
		unparseArea(mapping, middlePackages);
		for (Mapping composedMapping : mapping.getLocal())
			unparseMapping(composedMapping);
		exdent();
		append("}\n");
	}

	protected void unparseParameter(EParameter parameter) {
		if (parameter == null)
			return;
		appendName(parameter);
		append(" : ");
		appendName(parameter.getEType());
	}

	protected void unparsePredicate(Predicate predicate) {
		doExpressionSwitch(predicate.getConditionExpression());		
		append(";\n");
	}

	protected void unparseQuery(Function query) {
		if (query == null)
			return;
		append("query ");
		appendQualifiedName(query);
		append("(");
		boolean first = true;
		for (EParameter eParameter : query.getEParameters()) {
			if (!first)
				append(", ");
			unparseParameter(eParameter);
			first = false;
		}
		append(") : ");
		appendName(query.getEType());
		OCLExpression body = query.getQueryExpression();
		if (body != null) {
			append(" {\n");
			indent();
			doExpressionSwitch(body);
			append("\n");
			exdent();
			append("}\n");
		}
		else
			append(";\n");
	}

	protected void unparseTransformation(Transformation transformation) {
		if (transformation == null)
			return;
		append("transformation ");
		appendName(transformation);
		append(" {\n");
		indent();
		for (TypedModel typedModel : transformation.getModelParameter())
			unparseTypedModel(typedModel);
		exdent();
		append("}\n");
	}

	protected void unparseTypedModel(TypedModel typedModel) {
		if (typedModel == null)
			return;
		appendName(typedModel);
		List<EPackage> usedPackages = typedModel.getUsedPackage();
		if (usedPackages.size() > 0) {
			append(" imports ");
			boolean first = true;
			for (EPackage ePackage : usedPackages) {
				if (!first)
					append(",");
				appendName(ePackage);
				first = false;
			}
		}
		List<TypedModel> typedModels = typedModel.getDependsOn();
		if (typedModels.size() > 0) {
			append(" uses ");
			boolean first = true;
			for (TypedModel dependsOn : typedModels) {
				if (!first)
					append(",");
				appendName(dependsOn);
				first = false;
			}
		}
		append(";\n");
	}
}
