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
package org.eclipse.qvt.declarative.parser.qvtrelation.unparser;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.Variable;
import org.eclipse.qvt.declarative.ecore.QVTBase.Domain;
import org.eclipse.qvt.declarative.ecore.QVTBase.Function;
import org.eclipse.qvt.declarative.ecore.QVTBase.Pattern;
import org.eclipse.qvt.declarative.ecore.QVTBase.Predicate;
import org.eclipse.qvt.declarative.ecore.QVTBase.Rule;
import org.eclipse.qvt.declarative.ecore.QVTBase.TypedModel;
import org.eclipse.qvt.declarative.ecore.QVTRelation.DomainPattern;
import org.eclipse.qvt.declarative.ecore.QVTRelation.Key;
import org.eclipse.qvt.declarative.ecore.QVTRelation.Relation;
import org.eclipse.qvt.declarative.ecore.QVTRelation.RelationDomain;
import org.eclipse.qvt.declarative.ecore.QVTRelation.RelationDomainAssignment;
import org.eclipse.qvt.declarative.ecore.QVTRelation.RelationImplementation;
import org.eclipse.qvt.declarative.ecore.QVTRelation.RelationalTransformation;
import org.eclipse.qvt.declarative.ecore.QVTTemplate.CollectionTemplateExp;
import org.eclipse.qvt.declarative.ecore.QVTTemplate.ObjectTemplateExp;
import org.eclipse.qvt.declarative.ecore.QVTTemplate.PropertyTemplateItem;
import org.eclipse.qvt.declarative.ecore.QVTTemplate.TemplateExp;
import org.eclipse.qvt.declarative.ecore.QVTTemplate.util.QVTTemplateConstants;
import org.eclipse.qvt.declarative.parser.qvt.environment.QVTReflectionImpl;

public class QVTrUnparser extends QVTrExpressionUnparser
{
	protected Set<String> reservedKeywords = new HashSet<String>();
	
	public QVTrUnparser(Resource resource) {
		super(resource, QVTReflectionImpl.INSTANCE);
		reservedKeywords.add("domain");
		reservedKeywords.add("key");
		reservedKeywords.add("when");
		reservedKeywords.add("where");
	}

	@Override
	protected String formatName(Object object) {
		String formatName = super.formatName(object);
		if (reservedKeywords.contains(formatName))
			return "_" + formatName;
		else
			return formatName;
	}

	protected void getPatternVariables(Set<Variable> patternVariables, Relation relation) {
		for (Domain domain : relation.getDomain()) {
			if (domain instanceof RelationDomain) {
				patternVariables.add(((RelationDomain) domain).getRootVariable());
				DomainPattern pattern = ((RelationDomain) domain).getPattern();
				if (pattern != null)
					getPatternVariables(patternVariables, pattern.getTemplateExpression());
			}
		}
	}

	protected void getPatternVariables(Set<Variable> patternVariables, TemplateExp templateExpression) {
		if (templateExpression == null)
			return;
		patternVariables.add(templateExpression.getBindsTo());
		if (templateExpression instanceof ObjectTemplateExp) {
			for (PropertyTemplateItem part : ((ObjectTemplateExp)templateExpression).getPart()) {
				OCLExpression value = part.getValue();
				if (value instanceof TemplateExp)
					getPatternVariables(patternVariables, (TemplateExp) value);
			}
		}
		else if (templateExpression instanceof CollectionTemplateExp) {
			for (OCLExpression value : ((CollectionTemplateExp)templateExpression).getMember()) {
				if (value instanceof TemplateExp)
					getPatternVariables(patternVariables, (TemplateExp) value);
			}
		}
	}

	@Override public void unparse() {
		initialize();
		for (EObject eObject : resource.getContents()) {
			if (eObject instanceof RelationalTransformation)
				unparseRelationalTransformation((RelationalTransformation) eObject);
			else
				append("\n***" + getClass().getSimpleName() + "-Unsupported-" + eObject.getClass().getSimpleName() + "***\n");
		}
	}

	protected void unparseDomainPattern(DomainPattern pattern) {
		if (pattern == null)
			return;
		doExpressionSwitch(pattern.getTemplateExpression());		
		List<Predicate> predicates = pattern.getPredicate();
		if (predicates.size() > 0) {
			append("\n{\n");
			indent();
			for (Predicate predicate : predicates)
				unparsePredicate(predicate);
			exdent();
			append("}");
		}
	}

	protected void unparseKey(Key key) {
		if (key == null)
			return;
		append("key ");
		appendQualifiedName(key.getIdentifies());
		append(" { ");
		boolean first = true;
		for (EStructuralFeature property : key.getPart()) {
			if (!first)
				append(", ");
			appendName(property);
			first = false;
		}
		for (EStructuralFeature property : key.getOppositePart()) {
			if (!first)
				append(", ");
			append(getNameForOpposite(property));
			first = false;
		}
		append(" };\n");
	}

	protected void unparseParameter(EParameter parameter) {
		if (parameter == null)
			return;
		appendName(parameter);
		append(" : ");
		appendName(parameter.getEType());
	}

	protected void unparsePattern(Pattern pattern) {
		if (pattern == null)
			return;
		for (Predicate predicate : pattern.getPredicate())
			unparsePredicate(predicate);
	}

	protected void unparsePredicate(Predicate predicate) {
		doExpressionSwitch(predicate.getConditionExpression());		
		append(";\n");
	}

	protected void unparseQuery(Function query) {
		if (query == null)
			return;
		append("query ");
		appendName(query);
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

	protected void unparseRelation(Relation relation) {
		if (relation == null)
			return;
		if (relation.isIsTopLevel())
			append("top ");
		append("relation ");
		appendName(relation);
		append(" {\n");
		indent();
		Set<Variable> patternVariables = new HashSet<Variable>();
		getPatternVariables(patternVariables, relation);
		List<Variable> variables = relation.getVariable();
		if (variables.size() > 0) {
			for (Variable variable : variables) {
				if (!patternVariables.contains(variable) && !QVTTemplateConstants.WILDCARD_VARIABLE_NAME.equals(variable.getName())) {
					unparseVariable(variable);
					append(";\n");
				}
			}
		}
		for (Domain domain : relation.getDomain())
			if (domain instanceof RelationDomain)
				unparseRelationDomain((RelationDomain)domain);
		Pattern when = relation.getWhen();
		if (when != null) {
			append("when {\n");
			indent();
			unparsePattern(when);
			exdent();
			append("}\n");
		}
		Pattern where = relation.getWhere();
		if (where != null) {
			append("where {\n");
			indent();
			unparsePattern(where);
			exdent();
			append("}\n");
		}
		exdent();
		append("}\n");
	}

	protected void unparseRelationDomain(RelationDomain domain) {
		if (domain == null)
			return;
		if (!domain.isIsEnforceable() && domain.isIsCheckable())
			append("checkonly ");
		if (!domain.isIsCheckable() && domain.isIsEnforceable())
			append("enforce ");
		DomainPattern domainPattern = domain.getPattern();
		if (domainPattern == null)
			append("primitive ");
		append("domain ");
		if (domainPattern == null) {
			unparseVariable(domain.getRootVariable());
			append(";\n");
		}
		else {
			appendName(domain);
			append("\n");
			indent();
			unparseDomainPattern(domain.getPattern());
			exdent();
			Relation relation = (Relation) domain.getRule();
			TypedModel typedModel = domain.getTypedModel();
			for (RelationImplementation implementation : relation.getOperationalImpl()) {
				if (implementation.getInDirectionOf() == typedModel) {
					append("\n");
					append("implementedby ");
					doExpressionSwitch(implementation.getImpl());
					append("()");		// FIXME argument list ...
				}
			}
			List<RelationDomainAssignment> domainInitializers = domain.getDefaultAssignment();
			if (domainInitializers.size() > 0) {
				append("\n");
				append("default_values {\n");
				indent();
				for (RelationDomainAssignment domainInitializer : domainInitializers) {
					appendName(domainInitializer.getVariable());
					append(" = ");
					doExpressionSwitch(domainInitializer.getValueExp());
					append(";\n");
				}
				exdent();
				append("}");
			}		
			append(";\n");
		}
	}

	protected void unparseRelationalTransformation(RelationalTransformation transformation) {
		if (transformation == null)
			return;
		append("transformation ");
		appendName(transformation);
		append("(");
		boolean first = true;
		for (TypedModel typedModel : transformation.getModelParameter()) {
			if (!first)
				append(", ");
			unparseTypedModel(typedModel);
			first = false;
		}
		append(")\n");
		append("{\n");
		indent();
		List<Key> keys = transformation.getOwnedKey();
		if (keys.size() > 0) {
			for (Key key : keys)
				unparseKey(key);
		}
		List<EOperation> queries = transformation.getEOperations();
		if (queries.size() > 0) {
			for (EOperation query : queries)
				if (query instanceof Function) {
					append("\n");
					unparseQuery((Function) query);
				}
		}
		List<Rule> relations = transformation.getRule();
		if (relations.size() > 0) {
			for (Rule relation : relations)
				if (relation instanceof Relation) {
					append("\n");
					unparseRelation((Relation)relation);
				}
		}
		exdent();
		append("}\n");
	}

	protected void unparseTypedModel(TypedModel typedModel) {
		if (typedModel == null)
			return;
		appendName(typedModel);
		append(":");
		List<EPackage> usedPackages = typedModel.getUsedPackage();
		if (usedPackages.size() > 1)
			append("{");
		boolean first = true;
		for (EPackage ePackage : usedPackages) {
			if (!first)
				append(",");
			appendName(ePackage);
			first = false;
		}
		if (usedPackages.size() > 1)
			append("}");
	}
}
