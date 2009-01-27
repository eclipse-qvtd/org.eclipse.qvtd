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

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.ocl.LookupException;
import org.eclipse.ocl.cst.VariableExpCS;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.Variable;
import org.eclipse.ocl.ecore.VariableExp;
import org.eclipse.qvt.declarative.ecore.QVTBase.TypedModel;
import org.eclipse.qvt.declarative.ecore.QVTBase.operations.AbstractEssentialOCLOperations;
import org.eclipse.qvt.declarative.ecore.QVTRelation.DomainPattern;
import org.eclipse.qvt.declarative.ecore.QVTRelation.QVTRelationFactory;
import org.eclipse.qvt.declarative.ecore.QVTRelation.RelationDomain;
import org.eclipse.qvt.declarative.ecore.QVTRelation.RelationalTransformation;
import org.eclipse.qvt.declarative.ecore.QVTTemplate.CollectionTemplateExp;
import org.eclipse.qvt.declarative.ecore.QVTTemplate.ObjectTemplateExp;
import org.eclipse.qvt.declarative.ecore.QVTTemplate.PropertyTemplateItem;
import org.eclipse.qvt.declarative.ecore.QVTTemplate.TemplateExp;
import org.eclipse.qvt.declarative.parser.qvt.cst.IdentifierCS;
import org.eclipse.qvt.declarative.parser.qvtrelation.cst.AbstractDomainCS;
import org.eclipse.qvt.declarative.parser.qvtrelation.cst.DomainCS;
import org.eclipse.qvt.declarative.parser.qvtrelation.cst.PrimitiveTypeDomainCS;

public class QVTrDomainEnvironment extends QVTrEnvironment<QVTrRelationEnvironment, RelationDomain, AbstractDomainCS>
{
	private final TypedModel typedModel;
	
	public QVTrDomainEnvironment(QVTrRelationEnvironment env, DomainCS domainCS) {
		super(env, QVTRelationFactory.eINSTANCE.createRelationDomain(), domainCS);
		IdentifierCS modelIdCS = domainCS.getModelId();
		setNameFromIdentifier(ast, modelIdCS);
		QVTrTransformationEnvironment txEnv = env.getParentEnvironment();
//		metaModelId = txEnv.getMetaModelId(modelId);
		RelationalTransformation transformation = txEnv.getRelationalTransformation();
		TypedModel typedModel = transformation.getModelParameter(modelIdCS.getValue());
		if (typedModel == null) {
			String message = "Domain identifier '" + modelIdCS.getValue() + "' must refer to a model parameter";
			analyzerError(message, "DomainCS", modelIdCS);
		}
		ast.setTypedModel(typedModel);		
		this.typedModel = typedModel;
	}
	
	public QVTrDomainEnvironment(QVTrRelationEnvironment env, PrimitiveTypeDomainCS domainCS) {
		super(env, QVTRelationFactory.eINSTANCE.createRelationDomain(), domainCS);
		typedModel = null;
	}

	public void createVariableDeclaration(VariableExpCS variableExpCS, EClassifier type) {
		getParentEnvironment().createVariableDeclaration(variableExpCS, type, ast, false);
	}

	public RelationDomain getDomain() {
		return ast;
	}

	@Override public String getModelName(EObject object) {
		QVTrTypedModelEnvironment env = getParentEnvironment().getParentEnvironment().getEnvironment(typedModel);
		if (env != null)
			return env.getModelName(object);
		else
			return super.getModelName(object);
	}	

	public void installPattern(TemplateExp templateExpression) {
		DomainPattern domainPattern = QVTRelationFactory.eINSTANCE.createDomainPattern();
		initASTMapping(domainPattern, cst, null);
		ast.setPattern(domainPattern);
		domainPattern.setTemplateExpression(templateExpression);
		installPatternVariables(templateExpression);
	}

	protected void installPatternVariables(OCLExpression expression) {
		if (expression instanceof ObjectTemplateExp) {
			ObjectTemplateExp objectTemplateExp = (ObjectTemplateExp)expression;
			installPatternVariable(objectTemplateExp.getBindsTo());
			for (PropertyTemplateItem part : objectTemplateExp.getPart())
				installPatternVariables(part.getValue());
		}
		else if (expression instanceof CollectionTemplateExp) {
			CollectionTemplateExp collectionTemplateExp = (CollectionTemplateExp)expression;
			installPatternVariable(collectionTemplateExp.getBindsTo());
			for (OCLExpression member : collectionTemplateExp.getMember())
				installPatternVariables( member);
			installPatternVariable(collectionTemplateExp.getRest());
		}
		else if (expression instanceof VariableExp) {
//			installPatternVariableExp((VariableExp) expression);
			VariableExp variableExp = (VariableExp) expression;
			Variable variable = (Variable) variableExp.getReferredVariable();
			if ((variable != null) && !AbstractEssentialOCLOperations.locallyDefined(variableExp, variable))
				installPatternVariable(variable);
		}
		else {
			for (EObject eObject : expression.eContents()) {
				if (eObject instanceof OCLExpression)
					installPatternVariables((OCLExpression) eObject);
			}
		}
	}

	protected void installPatternVariable(Variable variable) {
		if (variable == null)
			return;
		if (isSpecialVariable(variable))
			return;
		List<Variable> bindsTo = ast.getPattern().getBindsTo();
		if (!bindsTo.contains(variable))
			bindsTo.add(variable);
	}

/*	protected void installPatternVariableExp(VariableExp variableExp) {
		if (variableExp == null)
			return;
		Variable variable = (Variable) variableExp.getReferredVariable();
		if (variable == null)
			return;
		if (AbstractEssentialOCLOperations.locallyDefined(variableExp, variable))
			return;
		installPatternVariable(variable);
	} */
	
	public EClass lookupImportedClass(String name) {
		if (typedModel != null) {
			for (EPackage ePackage : typedModel.getUsedPackage()) {
				EClassifier eClassifier = ePackage.getEClassifier(name);
				if (eClassifier instanceof EClass)
					return (EClass) eClassifier;
			}
		}
		return null;
	}

	public EClassifier lookupImportedClassifier(String name) {
		if (typedModel != null) {
			for (EPackage ePackage : typedModel.getUsedPackage()) {
				EClassifier eClassifier = ePackage.getEClassifier(name);
				if (eClassifier != null)
					return eClassifier;
			}
		}
		return null;
	}

	@Override public EClassifier tryLookupClassifier(List<String> names) throws LookupException {
		if (typedModel != null) {
			EClassifier eClassifier = tryLookupClassifier(typedModel.getUsedPackage(), names);
			if (eClassifier != null)
				return eClassifier;
		}
		return super.tryLookupClassifier(names);
	}
}
