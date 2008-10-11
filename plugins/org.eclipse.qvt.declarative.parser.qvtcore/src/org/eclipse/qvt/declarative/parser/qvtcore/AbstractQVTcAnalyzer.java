/**
 * <copyright>
 * 
 * Copyright (c) 2007,2008 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * E.D.Willink - initial API and implementation
 * 
 * </copyright>
 *
 * $Id: AbstractQVTcAnalyzer.java,v 1.3 2008/10/11 15:27:40 ewillink Exp $
 */
package org.eclipse.qvt.declarative.parser.qvtcore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import lpg.lpgjavaruntime.Monitor;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.LookupException;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.cst.CallExpCS;
import org.eclipse.ocl.cst.DotOrArrowEnum;
import org.eclipse.ocl.cst.OCLExpressionCS;
import org.eclipse.ocl.cst.PathNameCS;
import org.eclipse.ocl.cst.SimpleNameCS;
import org.eclipse.ocl.cst.VariableExpCS;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.EcoreFactory;
import org.eclipse.ocl.ecore.InvalidLiteralExp;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.OperationCallExp;
import org.eclipse.ocl.ecore.SendSignalAction;
import org.eclipse.ocl.ecore.Variable;
import org.eclipse.qvt.declarative.ecore.QVTBase.Function;
import org.eclipse.qvt.declarative.ecore.QVTBase.FunctionParameter;
import org.eclipse.qvt.declarative.ecore.QVTBase.Predicate;
import org.eclipse.qvt.declarative.ecore.QVTBase.QVTBaseFactory;
import org.eclipse.qvt.declarative.ecore.QVTBase.Transformation;
import org.eclipse.qvt.declarative.ecore.QVTBase.TypedModel;
import org.eclipse.qvt.declarative.ecore.QVTCore.Assignment;
import org.eclipse.qvt.declarative.ecore.QVTCore.BottomPattern;
import org.eclipse.qvt.declarative.ecore.QVTCore.EnforcementMode;
import org.eclipse.qvt.declarative.ecore.QVTCore.EnforcementOperation;
import org.eclipse.qvt.declarative.ecore.QVTCore.GuardPattern;
import org.eclipse.qvt.declarative.ecore.QVTCore.Mapping;
import org.eclipse.qvt.declarative.ecore.QVTCore.PropertyAssignment;
import org.eclipse.qvt.declarative.ecore.QVTCore.QVTCoreFactory;
import org.eclipse.qvt.declarative.ecore.QVTCore.VariableAssignment;
import org.eclipse.qvt.declarative.ecore.utils.ClassUtils;
import org.eclipse.qvt.declarative.ecore.utils.EcoreUtils;
import org.eclipse.qvt.declarative.parser.AbstractQVTAnalyzer;
import org.eclipse.qvt.declarative.parser.environment.CSTChildEnvironment;
import org.eclipse.qvt.declarative.parser.qvt.cst.IdentifierCS;
import org.eclipse.qvt.declarative.parser.qvtcore.cst.AssignmentCS;
import org.eclipse.qvt.declarative.parser.qvtcore.cst.BottomPatternCS;
import org.eclipse.qvt.declarative.parser.qvtcore.cst.DirectionCS;
import org.eclipse.qvt.declarative.parser.qvtcore.cst.DomainCS;
import org.eclipse.qvt.declarative.parser.qvtcore.cst.EnforcementOperationCS;
import org.eclipse.qvt.declarative.parser.qvtcore.cst.GuardPatternCS;
import org.eclipse.qvt.declarative.parser.qvtcore.cst.MappingCS;
import org.eclipse.qvt.declarative.parser.qvtcore.cst.ParamDeclarationCS;
import org.eclipse.qvt.declarative.parser.qvtcore.cst.QueryCS;
import org.eclipse.qvt.declarative.parser.qvtcore.cst.RealizedVariableCS;
import org.eclipse.qvt.declarative.parser.qvtcore.cst.TopLevelCS;
import org.eclipse.qvt.declarative.parser.qvtcore.cst.TransformationCS;
import org.eclipse.qvt.declarative.parser.qvtcore.cst.UnrealizedVariableCS;
import org.eclipse.qvt.declarative.parser.qvtcore.environment.IQVTcNodeEnvironment;
import org.eclipse.qvt.declarative.parser.qvtcore.environment.QVTcAreaEnvironment;
import org.eclipse.qvt.declarative.parser.qvtcore.environment.QVTcBottomPatternEnvironment;
import org.eclipse.qvt.declarative.parser.qvtcore.environment.QVTcDomainEnvironment;
import org.eclipse.qvt.declarative.parser.qvtcore.environment.QVTcGuardPatternEnvironment;
import org.eclipse.qvt.declarative.parser.qvtcore.environment.QVTcMappingEnvironment;
import org.eclipse.qvt.declarative.parser.qvtcore.environment.QVTcMiddleEnvironment;
import org.eclipse.qvt.declarative.parser.qvtcore.environment.QVTcNestedEnvironment;
import org.eclipse.qvt.declarative.parser.qvtcore.environment.QVTcPatternEnvironment;
import org.eclipse.qvt.declarative.parser.qvtcore.environment.QVTcQueryEnvironment;
import org.eclipse.qvt.declarative.parser.qvtcore.environment.QVTcTopLevelEnvironment;
import org.eclipse.qvt.declarative.parser.qvtcore.environment.QVTcTransformationEnvironment;

public abstract class AbstractQVTcAnalyzer extends AbstractQVTAnalyzer<IQVTcNodeEnvironment>
{
	/**
	 * Support sorting to achieve most refined last.
	 */
	public class MappingRefinementComparator implements Comparator<MappingCS>
	{
		protected final QVTcTransformationEnvironment txEnv;
		
		public MappingRefinementComparator(QVTcTransformationEnvironment txEnv) {
			this.txEnv = txEnv;
		}
		
		public int compare(MappingCS o1, MappingCS o2) {
			QVTcMappingEnvironment<?> m1 = txEnv.getEnvironment(o1);
			QVTcMappingEnvironment<?> m2 = txEnv.getEnvironment(o2);
			Set<QVTcMappingEnvironment<?>> s1 = m1.getMappingEnvironmentClosure();
			Set<QVTcMappingEnvironment<?>> s2 = m2.getMappingEnvironmentClosure();
			if (s1.contains(m2)) {
				if (s2.contains(m1))
					return m1.hashCode() - m2.hashCode();
				else
					return 1;
			}
			else {
				if (s2.contains(m1))
					return -1;
				else
					return m1.hashCode() - m2.hashCode();
			}
		}
		
	}
	
	public AbstractQVTcAnalyzer(QVTcParser parser, Monitor monitor) {
		super(parser, monitor);
	}

	@Override
	protected IQVTcNodeEnvironment createdNestedEnvironment(CSTNode cstNode,
			Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env) {
		return new QVTcNestedEnvironment((IQVTcNodeEnvironment)env, cstNode);
	}

	protected void declareDomainCS(QVTcAreaEnvironment<?> env, DomainCS domainCS) {
		BottomPatternCS bottomPatternCS = domainCS.getBottomPattern();
		GuardPatternCS guardPatternCS = domainCS.getGuardPattern();
		env.createBottomPatternEnvironment(bottomPatternCS);
		env.createGuardPatternEnvironment(guardPatternCS);
	}

	protected void declareDirectionCS(QVTcTransformationEnvironment env, DirectionCS directionCS) {
		TypedModel typedModel = env.createTypedModel(directionCS);
		for (PathNameCS packageNameCS : directionCS.getImports())
			if (!isCancelled())
				declareImportCS(env, typedModel, packageNameCS);
	}

	protected void declareImportCS(QVTcTransformationEnvironment env, TypedModel typedModel, PathNameCS packageNameCS) {
		resolvePackages(env, typedModel, packageNameCS);
		typedModel.getUsedPackage().addAll(resolvePackages(env, typedModel, packageNameCS));
	}
	
	protected void declareInputParamDeclarationCS(QVTcQueryEnvironment env, ParamDeclarationCS inputParamDeclarationCS) {
		FunctionParameter functionParameter = QVTBaseFactory.eINSTANCE.createFunctionParameter();
		env.initASTMapping(functionParameter, inputParamDeclarationCS);
		IdentifierCS identifier = inputParamDeclarationCS.getIdentifier();
		identifier.setAst(functionParameter);
		functionParameter.setName(identifierCS(identifier));
		functionParameter.setEType(resolveClassifier(env, "inputParamDeclarationCS", inputParamDeclarationCS.getType()));
		env.addParameter(functionParameter);
	}

	protected void declareMappingCS(QVTcMappingEnvironment<?> env, MappingCS mappingCS) {
		DomainCS middleCS = mappingCS.getMiddle();
		QVTcMiddleEnvironment middleEnv = env.createMiddleEnvironment(middleCS);
		declareDomainCS(middleEnv, middleCS);
		for (DomainCS domainCS : mappingCS.getDomains()) {
			QVTcDomainEnvironment domainEnv = env.createDomainEnvironment(domainCS);
			declareDomainCS(domainEnv, domainCS);
		}
		for (MappingCS composedMappingCS : mappingCS.getComposedMappings()) {
			QVTcMappingEnvironment<?> composedEnv = env.createComposedMappingEnvironment(composedMappingCS);
			PathNameCS transformationNameCS = composedMappingCS.getIn();
			if (transformationNameCS != null)
				WARNING(env, composedMappingCS, "InCS", "Inappropriate 'in' ignored");
			declareMappingCS(composedEnv, composedMappingCS);
		}
	}

	protected void declareQueryCS(QVTcTopLevelEnvironment env, QueryCS queryCS) {		
		PathNameCS pathNameCS = queryCS.getPathName();
		List<String> pathName = pathNameCS.getSequenceOfNames();
		if (pathName == null)
			return;
		int pathSize = pathName.size();
		if (pathSize < 2) {
			ERROR(env, queryCS, "QueryCS", "Scope::name required as query name");
			return;
		}
		List<String> transformationName = pathName.subList(0, pathSize-1);
		QVTcTransformationEnvironment txEnv;
		try {
			txEnv = env.getEnvironment(transformationName);
		} catch (LookupException e) {
			ERROR(env, queryCS, "QueryCS", "Invalid transformation '" + formatPath(transformationName) + "': " + e.getMessage());
			return;
		}
		if (txEnv == null) {
			ERROR(env, queryCS, "QueryCS", "Undefined transformation '" + formatPath(transformationName) + "'");
			return;
		}
		QVTcQueryEnvironment queryEnv = txEnv.createEnvironment(queryCS);
		EClassifier returnType = resolveClassifier(env, "queryCS", queryCS.getType());
		for (ParamDeclarationCS inputParamDeclarationCS : queryCS.getInputParamDeclaration())
			declareInputParamDeclarationCS(queryEnv, inputParamDeclarationCS);
		@SuppressWarnings("unused") Function function = queryEnv.resolveQuery(returnType);
	}

	protected void declareTransformationCS(QVTcTopLevelEnvironment topLevelEnvironment, TransformationCS transformationCS) {
		QVTcTransformationEnvironment env = topLevelEnvironment.createEnvironment(transformationCS);
		if (env == null)
			return;
		for (DirectionCS directionCS : transformationCS.getDirections())
			declareDirectionCS(env, directionCS);
		for (DirectionCS directionCS : transformationCS.getDirections())
			defineDirectionCS(env, directionCS);
	}
	
	protected Assignment defineAssignmentCS(QVTcPatternEnvironment<?> env, AssignmentCS assignmentCS) {
		Assignment assignment = null;
		OCLExpressionCS targetExpressionCS = assignmentCS.getTarget();
		OCLExpression assignmentValue = oclExpressionCS(assignmentCS.getInitialiser(), env);
		if (targetExpressionCS instanceof VariableExpCS) {
			VariableExpCS variableExpCS = (VariableExpCS) targetExpressionCS;
			VariableAssignment variableAssignment = QVTCoreFactory.eINSTANCE.createVariableAssignment();
			env.initASTMapping(variableAssignment, assignmentCS);
//			assignmentCS.getIdentifier().setAst(variableAssignment);
			SimpleNameCS identifierCS = variableExpCS.getSimpleNameCS();
			String targetVariableName = identifierCS.getValue();
			Variable targetVariable = (Variable) env.lookupLocal(targetVariableName);
			if (targetVariable == null) {
				ERROR(identifierCS, "AssignmentCS", "Undefined variable '" + formatString(targetVariableName) + "'");
				EClassifier type = assignmentValue.getType();
				targetVariable = env.createUnrealizedVariableDefinition(targetVariableName, type, identifierCS);
				env.initASTMapping(targetVariable, variableExpCS);
			}
			else {
				variableExpCS.setAst(targetVariable);
			}
			variableAssignment.setTargetVariable(targetVariable);
			identifierCS.setAst(targetVariable);
			assignment = variableAssignment;
		}
		else if ((targetExpressionCS instanceof CallExpCS) && (((CallExpCS)targetExpressionCS).getAccessor() == DotOrArrowEnum.DOT_LITERAL)) {
			CallExpCS callExp = (CallExpCS) targetExpressionCS;
			PropertyAssignment propertyAssignment = QVTCoreFactory.eINSTANCE.createPropertyAssignment();
			env.initASTMapping(propertyAssignment, callExp);
			assignmentCS.setAst(propertyAssignment);
			callExp.getSimpleNameCS().setAst(propertyAssignment);
			OCLExpression slotExpression = oclExpressionCS(callExp.getSource(), env);
			propertyAssignment.setSlotExpression(oclExpressionCS(callExp.getSource(), env));
			propertyAssignment.setTargetProperty(resolveProperty(env, slotExpression, callExp));
			assignment = propertyAssignment;
		}
		else {
			ERROR(assignmentCS, "AssignmentCS", "Assignment to property or variable expected");
			return null;
		}
		assignment.setIsDefault(assignmentCS.isDefault());
		assignment.setValue(assignmentValue);
		return assignment;
	}
	
	protected void defineBottomPatternCS(QVTcBottomPatternEnvironment env, BottomPatternCS patternCS) {
		if (patternCS == null)
			return;
		for (RealizedVariableCS realizedVariableCS : patternCS.getRealizedVariables())
			defineRealizedVariableCS(env, realizedVariableCS);
		for (UnrealizedVariableCS unrealizedVariableCS : patternCS.getUnrealizedVariables())
			defineUnrealizedVariableCS(env, unrealizedVariableCS);		
		BottomPattern bottomPattern = env.getASTNode();
		for (OCLExpressionCS constraintCS : patternCS.getConstraints()) {
			if (constraintCS instanceof AssignmentCS)
				bottomPattern.getAssignment().add(defineAssignmentCS(env, (AssignmentCS) constraintCS));
			else
				bottomPattern.getPredicate().add(definePredicateCS(env, constraintCS));
		}
		for (EnforcementOperationCS enforcementOperationCS : patternCS.getEnforcementOperations()) {
			EnforcementOperation enforcementOperation = QVTCoreFactory.eINSTANCE.createEnforcementOperation();
			env.initASTMapping(enforcementOperation, enforcementOperationCS);
			enforcementOperation.setEnforcementMode(enforcementOperationCS.isDeletion() ? EnforcementMode.DELETION : EnforcementMode.CREATION);
			org.eclipse.ocl.expressions.OCLExpression<EClassifier> expression = operationCallExpCS(enforcementOperationCS.getOperationCall(), env);
			if (expression instanceof OperationCallExp)
				enforcementOperation.setOperationCallExp((OperationCallExp) expression);
			else
				ERROR(enforcementOperationCS, "EnforcementOperationCS", "OperationCallExp expected");
			bottomPattern.getEnforcementOperation().add(enforcementOperation);
		}
	}

	protected void defineDirectionCS(QVTcTransformationEnvironment env, DirectionCS directionCS) {
		IdentifierCS identifierCS = directionCS.getIdentifier();
		TypedModel typedModel = env.getTypedModel(identifierCS);
		for (IdentifierCS usesCS : directionCS.getUses()) {
			TypedModel usedTypedModel = env.getTypedModel(usesCS);
			if (usedTypedModel != null)
				typedModel.getDependsOn().add(usedTypedModel);
			else
				ERROR(usesCS, "UsesCS", "Unknown direction '" + formatString(usesCS.getValue()) + "'");
		}
	}

	protected void defineDomainCS(QVTcAreaEnvironment<?> env, DomainCS domainCS) {
		BottomPatternCS bottomPatternCS = domainCS.getBottomPattern();
		GuardPatternCS guardPatternCS = domainCS.getGuardPattern();
		QVTcBottomPatternEnvironment bottomPatternEnvironment = env.getBottomPatternEnvironment();
		QVTcGuardPatternEnvironment guardPatternEnvironment = env.getGuardPatternEnvironment();
		//
		// Guard before bottom so that bottom sees guard variables
		//
		defineGuardPatternCS(guardPatternEnvironment, guardPatternCS);
		defineBottomPatternCS(bottomPatternEnvironment, bottomPatternCS);
	}

	protected void defineGuardPatternCS(QVTcGuardPatternEnvironment env, GuardPatternCS patternCS) {
		if (patternCS == null)
			return;
		for (UnrealizedVariableCS unrealizedVariableCS : patternCS.getUnrealizedVariables())
			defineUnrealizedVariableCS(env, unrealizedVariableCS);
		GuardPattern guardPattern = env.getASTNode();
		EList<Predicate> predicate = guardPattern.getPredicate();
		for (OCLExpressionCS constraintCS : patternCS.getConstraints()) {
			if (constraintCS instanceof AssignmentCS)
//				guardPattern.getAssignment().add(defineAssignment(env, (AssignmentCS) constraintCS));
				ERROR(patternCS, "GuardPattern", "Unexpected assignment ignored");
			else
				predicate.add(definePredicateCS(env, constraintCS));
		}
	}
	
	protected void defineMappingCS(QVTcMappingEnvironment<?> env, MappingCS mappingCS) {
		//
		// Composing mappings before composed so that composed mapping sees composing variables
		// Side domains before middle so that middle mapping sees side variables
		//
		for (DomainCS domainCS : mappingCS.getDomains()) {
			QVTcDomainEnvironment domainEnv = env.getEnvironment(domainCS);
			defineDomainCS(domainEnv, domainCS);
		}
		DomainCS middleCS = mappingCS.getMiddle();
		defineDomainCS(env.getMiddleEnvironment(), middleCS);
		for (MappingCS composedMappingCS : mappingCS.getComposedMappings()) {
			QVTcMappingEnvironment<?> composedEnv = env.getEnvironment(composedMappingCS);
			defineMappingCS(composedEnv, composedMappingCS);
		}
	}
	
	protected void defineMappingRefinementCS(QVTcMappingEnvironment<?> env, MappingCS mappingCS) {
		Mapping mapping = env.getMapping();
		for (IdentifierCS refinesCS : mappingCS.getRefines()) {
			try {
				Mapping refinedMapping = resolveMapping(env, refinesCS);
				if (refinedMapping != null)
					mapping.getSpecification().add(refinedMapping);
				if ((refinedMapping == null) || !env.isResolved(refinedMapping))
					ERROR(refinesCS, "RefinesCS", "Undefined mapping '" + formatString(refinesCS.getValue()) + "'");
			} catch (LookupException e) {
				ERROR(refinesCS, "MappingCS", env.formatLookupException(e));
			}
		}
	}

	protected Predicate definePredicateCS(QVTcPatternEnvironment<?> env, OCLExpressionCS constraintCS) {
		Predicate predicate = QVTBaseFactory.eINSTANCE.createPredicate();
		env.initASTMapping(predicate, constraintCS);
		predicate.setConditionExpression(oclExpressionCS(constraintCS, env));
		return predicate;
	}

	protected Function defineQueryCS(QVTcQueryEnvironment env, QueryCS queryCS) {
		Function query = env.getQuery();
		if (query.getQueryExpression() == null)		// Error generated from resolveQuery in declareQueryCS
			query.setQueryExpression(oclExpressionCS(queryCS.getOclExpression(), env));
		return query;
	}

	protected void defineRealizedVariableCS(QVTcBottomPatternEnvironment env, RealizedVariableCS realizedVariableCS) {
		IdentifierCS identifierCS = realizedVariableCS.getIdentifier();
		EClassifier type = typeCS(realizedVariableCS.getType(), env);
		env.createRealizedVariableDefinition(identifierCS.getValue(), type, realizedVariableCS);
	}

	protected void defineTopLevelCS(QVTcTopLevelEnvironment topLevelEnvironment) {
		TopLevelCS topLevelCS = topLevelEnvironment.getCSTNode();
		for (TransformationCS transformationCS : topLevelCS.getTransformations()) {
			if (!isCancelled())
				declareTransformationCS(topLevelEnvironment, transformationCS);
		}
		for (QueryCS queryCS : topLevelCS.getQueries()) {
			if (!isCancelled())
				declareQueryCS(topLevelEnvironment, queryCS);
		}
		for (MappingCS mappingCS : topLevelCS.getMappings()) {
			if (!isCancelled()) {
				PathNameCS transformationNameCS = mappingCS.getIn();
				if (transformationNameCS == null)
					ERROR(mappingCS, "InCS", "Missing 'in'");
				else {
					EList<String> transformationName = transformationNameCS.getSequenceOfNames();
					QVTcTransformationEnvironment txEnv = null;
					try {
						txEnv = topLevelEnvironment.getEnvironment(transformationName);
					} catch (LookupException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if (txEnv == null) {
						ERROR(transformationNameCS, "InCS", "Undefined transformation '" + formatPath(transformationName) + "'");
					} else {
						transformationNameCS.setAst(txEnv.getASTNode());
						QVTcMappingEnvironment<?> mapEnv = txEnv.createEnvironment(mappingCS);
						declareMappingCS(mapEnv, mappingCS);
					}
				}
			}
		}
		for (TransformationCS transformationCS : topLevelCS.getTransformations()) {
			if (!isCancelled())
				defineTransformationCS(topLevelEnvironment, transformationCS);
		}
	}

	protected void defineTransformationCS(QVTcTopLevelEnvironment topLevelEnvironment, TransformationCS transformationCS) {
		QVTcTransformationEnvironment txEnv = topLevelEnvironment.getEnvironment(transformationCS);
		if (txEnv == null)
			return;				// Error during declare
		Transformation transformation = txEnv.getTransformation();
		for (QueryCS queryCS : txEnv.getQueries()) {
			if (isCancelled())
				return;
			PathNameCS pathNameCS = queryCS.getPathName();
			List<String> pathName = pathNameCS.getSequenceOfNames();
			if (pathName != null) {
				int pathSize = pathName.size();
				if (pathSize > 0) {
					Transformation scope = transformation;
					if (pathSize > 1) {
						try {
							scope = resolveTransformation(topLevelEnvironment, pathNameCS, pathName.subList(0, pathSize-1));
						} catch (LookupException e) {
							ERROR(pathNameCS, "PathNameCS", e.toString());
							break;
						}
					}
					Function query = EcoreUtils.getNamedElement(scope.getEOperations(), pathName.get(pathSize-1), Function.class);
					if (query != null) {
						QVTcQueryEnvironment queryEnv = txEnv.getEnvironment(queryCS);
						defineQueryCS(queryEnv, queryCS);
					}
				}
			}
		}
		List<MappingCS> mappings = new ArrayList<MappingCS>(txEnv.getMappings());
		for (MappingCS mappingCS : mappings)
			if (!isCancelled()) {
				QVTcMappingEnvironment<?> mapEnv = txEnv.getEnvironment(mappingCS);
				defineMappingRefinementCS(mapEnv, mappingCS);
			}
		Collections.sort(mappings, new MappingRefinementComparator(txEnv));
		//
		// Refined mappings before refining so that refining mapping sees conflicts
		//
		for (MappingCS mappingCS : mappings)
			if (!isCancelled()) {
				QVTcMappingEnvironment<?> mapEnv = txEnv.getEnvironment(mappingCS);
				defineMappingCS(mapEnv, mappingCS);
			}
	}

//	protected EClassifier defineTypeCS(IQVTcEnvironment env, TypeCS typeCS) {
//		IQVTcEnvironment typeEnv = env; //createTypeEnvironment(env, typeCS);
//		EClassifier eClassifier = typeCS(typeCS, typeEnv);
//		if (eClassifier == null) {
//			String message = "Undefined type '" + computeInputString(typeCS) + "'";
//			ERROR(typeCS, "TypeCS", message);
//			eClassifier = UnresolvedPackage.eINSTANCE.getUnresolvedClass();
//		}
//		return eClassifier;
//	}

	protected void defineUnrealizedVariableCS(QVTcPatternEnvironment<?> env, UnrealizedVariableCS unrealizedVariableCS) {
		IdentifierCS identifierCS = unrealizedVariableCS.getIdentifier();
		EClassifier type = typeCS(unrealizedVariableCS.getType(), env);
		Variable variable = env.createUnrealizedVariableDefinition(identifierCS.getValue(), type, unrealizedVariableCS);
		identifierCS.setAst(variable);
	}

	//
	//	Overridden to catch a catastrophic parsing failure closer to its problem
	//
	@Override protected OCLExpression oclExpressionCS(OCLExpressionCS oclExpressionCS, Environment<
			EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter,
			EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env) {
		try {
			return (OCLExpression) super.oclExpressionCS(oclExpressionCS, env);
		} catch (Exception e) {
			ERROR(oclExpressionCS, "oclExpressionCS", "Failed to parse expression : " + e.getClass().getName() + " - " + e.getMessage());
			e.printStackTrace();
		}
		OCLExpression result = EcoreFactory.eINSTANCE.createInvalidLiteralExp();
		CSTChildEnvironment<IQVTcNodeEnvironment,?,?,?> cstEnv = ClassUtils.asClassUnchecked(env);
		cstEnv.initASTMapping(result, oclExpressionCS);
		return result;
	}

	protected Mapping resolveMapping(QVTcMappingEnvironment<?> env, IdentifierCS identifierCS) throws LookupException {
		Mapping mapping = env.tryLookupMapping(identifierCS.getValue());
		if (mapping == null)
			mapping = env.getUnresolvedEnvironment().getUnresolvedMapping(env.getTransformation(), identifierCS.getValue());
		identifierCS.setAst(mapping);
		return mapping;
	}

	protected List<EPackage> resolvePackages(QVTcTransformationEnvironment env, TypedModel typedModel, PathNameCS packageNameCS) {
		List<EPackage> ePackages = env.resolvePackages(packageNameCS);
		if ((ePackages == null) || ePackages.isEmpty())
			ePackages = Collections.singletonList(env.getUnresolvedEnvironment().getUnresolvedEPackage(packageNameCS.getSequenceOfNames()));
		packageNameCS.setAst(ePackages.get(0));
		return ePackages;
//		else {
//			if (ePackages != null)
//				ERROR(packageNameCS, "metaModelIdCS", "Package '" + formatString(packageName) + "' is empty");
//			typedModel.getUsedPackage().add(UnresolvedPackage.eINSTANCE);
	}

	protected EStructuralFeature resolveProperty(QVTcPatternEnvironment<?> env, OCLExpression slotExpression, CallExpCS callExp) {
		String propertyName = callExp.getSimpleNameCS().getValue();
		EStructuralFeature property = null;
		if ((slotExpression != null) && !(slotExpression instanceof InvalidLiteralExp)) {
			property = lookupProperty(callExp, env, slotExpression.getType(), propertyName);
			if (property == null)
				ERROR(callExp.getSimpleNameCS(), "AssignmentCS", "Undefined property '" + formatString(propertyName) + "'");
		}
		if (property == null)
			property = env.getUnresolvedEnvironment().getUnresolvedEAttribute(slotExpression != null ? slotExpression.getType() : null, propertyName);
		return property;
	}

	protected Transformation resolveTransformation(QVTcTopLevelEnvironment topLevelEnvironment, PathNameCS pathNameCS, List<String> pathNames) throws LookupException {
		Transformation transformation = topLevelEnvironment.tryLookupTransformation(pathNames);
		pathNameCS.setAst(transformation);
		return transformation;
	}
}
