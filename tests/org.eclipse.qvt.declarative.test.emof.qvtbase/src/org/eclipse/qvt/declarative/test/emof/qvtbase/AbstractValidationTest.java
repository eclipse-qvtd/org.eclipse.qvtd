/*******************************************************************************
 * Copyright (c) 2008 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvt.declarative.test.emof.qvtbase;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import junit.framework.AssertionFailedError;
import junit.framework.TestCase;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.StringLiteralExp;
import org.eclipse.ocl.ecore.Variable;
import org.eclipse.ocl.ecore.VariableExp;
import org.eclipse.ocl.internal.l10n.OCLMessages;
import org.eclipse.ocl.lpg.AbstractParser;
import org.eclipse.ocl.lpg.AbstractProblemHandler;
import org.eclipse.ocl.lpg.ProblemHandler;
import org.eclipse.ocl.lpg.StringProblemHandler;
import org.eclipse.qvt.declarative.ecore.QVTBase.Domain;
import org.eclipse.qvt.declarative.ecore.QVTBase.Function;
import org.eclipse.qvt.declarative.ecore.QVTBase.FunctionParameter;
import org.eclipse.qvt.declarative.ecore.QVTBase.Pattern;
import org.eclipse.qvt.declarative.ecore.QVTBase.Predicate;
import org.eclipse.qvt.declarative.ecore.QVTBase.QVTBaseFactory;
import org.eclipse.qvt.declarative.ecore.QVTBase.QVTBasePackage;
import org.eclipse.qvt.declarative.ecore.QVTBase.Rule;
import org.eclipse.qvt.declarative.ecore.QVTBase.Transformation;
import org.eclipse.qvt.declarative.ecore.QVTBase.TypedModel;
import org.eclipse.qvt.declarative.ecore.QVTBase.impl.DomainImpl;
import org.eclipse.qvt.declarative.ecore.QVTBase.impl.RuleImpl;
import org.eclipse.qvt.declarative.ecore.QVTBase.util.QVTBaseValidator;
import org.eclipse.qvt.declarative.ecore.QVTRelation.QVTRelationFactory;
import org.eclipse.qvt.declarative.ecore.QVTRelation.Relation;
import org.eclipse.qvt.declarative.ecore.operations.EValidatorWithOperations;
import org.eclipse.qvt.declarative.parser.environment.ProblemHandlerDiagnosticChain;
import org.eclipse.qvt.declarative.parser.utils.ProblemLog;
import org.eclipse.qvt.declarative.parser.utils.ProblemLog.Problem;
import org.eclipse.qvt.declarative.test.parser.TestFormattingHelper;
import org.eclipse.qvt.declarative.test.parser.AbstractParseTestCase.ProblemComparator;

public abstract class AbstractValidationTest extends TestCase
{
	public static final QVTBaseFactory QVTb_Factory = QVTBaseFactory.eINSTANCE;
	public static final org.eclipse.emf.ecore.EcoreFactory Ecore_Factory = org.eclipse.emf.ecore.EcoreFactory.eINSTANCE;
	public static final org.eclipse.ocl.ecore.EcoreFactory OCL_Factory = org.eclipse.ocl.ecore.EcoreFactory.eINSTANCE;
	
	public static class ExpectedProblemLog extends ProblemLog
	{
		public void expectValidatorError(String key, String[] substitutions) {
			EValidatorWithOperations validator = QVTBaseValidator.INSTANCE;
			ResourceLocator resourceLocator = validator.getResourceLocator();
			String problemMessage = substitutions == null ? resourceLocator.getString(key) : resourceLocator.getString(key, substitutions);
			String processingContext = validator.getDiagnosticSource();
			super.handleProblem(ProblemHandler.Severity.ERROR, ProblemHandler.Phase.VALIDATOR, problemMessage,
					processingContext, -1, -1);
		}
		public void expectValidatorWarning(String key, String[] substitutions) {
			EValidatorWithOperations validator = QVTBaseValidator.INSTANCE;
			ResourceLocator resourceLocator = validator.getResourceLocator();
			String problemMessage = substitutions == null ? resourceLocator.getString(key) : resourceLocator.getString(key, substitutions);
			String processingContext = validator.getDiagnosticSource();
			super.handleProblem(ProblemHandler.Severity.WARNING, ProblemHandler.Phase.VALIDATOR, problemMessage,
					processingContext, -1, -1);
		}
	}

	private final class TestProblemHandler extends StringProblemHandler
	{
		private TestProblemHandler() {
			super(null);
		}

		/**
		 * Implements the interface, invoking <code>addProblem</code> with a line comprising
		 * <code>processingPhase-problemSeverity in processingContext; lineNumber : problemMessage</code>.
		 */
		@Override
		public void handleProblem(Severity problemSeverity, Phase processingPhase,
				String problemMessage, String processingContext, int startOffset, int endOffset) {
			AbstractParser parser = getParser();
			String file = parser.getFileName();
			int lineNumber = parser.getTokenAtCharacter(startOffset).getLine();
			String message = OCLMessages.bind(
					 "{0}-{1} in {2}; {3}:{4} : {5}", //OCLMessages.ProblemMessage_ERROR_,
					new Object[] {
						processingPhase != null ? processingPhase : "?", //$NON-NLS-1$
						problemSeverity != null ? problemSeverity : "?", //$NON-NLS-1$
						processingContext != null ? processingContext : "?", //$NON-NLS-1$
						file, lineNumber,
						problemMessage != null ? problemMessage : "?"}); //$NON-NLS-1$
			addProblem(message);
		}
	}

	/**
	 * Asserts that two objects are equal. If they are not
	 * an AssertionFailedError is thrown.
	 */
	static public void assertEquals(ProblemLog expectedProblemLog, ProblemLog actualProblemLog) {
		try {
			int actualTotalProblems = actualProblemLog.getAllProblems();
			int expectedTotalProblems = expectedProblemLog.getAllProblems();
			assertEquals("Total Problem count", expectedTotalProblems, actualTotalProblems);
			Set<ProblemHandler.Phase> actualProcessingPhases = actualProblemLog.getProcessingPhases();
			Set<ProblemHandler.Phase> expectedProcessingPhases = expectedProblemLog.getProcessingPhases();
			if (!actualProcessingPhases.equals(expectedProcessingPhases)) {
				assertEquals("Processing Phases", expectedProcessingPhases, actualProcessingPhases);
			}
			for (ProblemHandler.Phase processingPhase : actualProcessingPhases) {
				Map<ProblemHandler.Severity, List<Problem>> actualPhaseProblems = actualProblemLog.getProblems(processingPhase);
				Map<ProblemHandler.Severity, List<Problem>> expectedPhaseProblems = expectedProblemLog.getProblems(processingPhase);
				Set<ProblemHandler.Severity> actualSeverities = actualPhaseProblems.keySet();
				Set<ProblemHandler.Severity> expectedSeverities = expectedPhaseProblems.keySet();
				if (!actualSeverities.equals(expectedSeverities)) {
					assertEquals("Processing Severities", expectedSeverities, actualSeverities);
				}
				for (ProblemHandler.Severity severity : actualSeverities) {
					List<Problem> actualProblems = actualPhaseProblems.get(severity);
					List<Problem> expectedProblems = expectedPhaseProblems.get(severity);
					Collections.sort(actualProblems, ProblemComparator.INSTANCE);
					Collections.sort(expectedProblems, ProblemComparator.INSTANCE);
					int actualProblemCount = actualProblems.size();
					int expectedProblemCount = expectedProblems.size();
					assertEquals("Problem count", expectedProblemCount, actualProblemCount);
					for (int i = 0; i < actualProblemCount; i++) {
						Problem actualProblem = actualProblems.get(i);
						Problem expectedProblem = expectedProblems.get(i);
						assertEquals("Problem message", expectedProblem.problemMessage, actualProblem.problemMessage);
						assertEquals("Problem processingContext", expectedProblem.processingContext, actualProblem.processingContext);
						if (expectedProblem.startOffset >= 0)
							assertEquals("Problem startOffset", expectedProblem.startOffset, actualProblem.startOffset);
						if (expectedProblem.endOffset >= 0)
							assertEquals("Problem endOffset", expectedProblem.endOffset, actualProblem.endOffset);
					}
				}
			}
		} catch (AssertionFailedError e) {
			StringBuffer s = new StringBuffer();
			s.append(e.getMessage());
			s.append("\nExpected");
			expectedProblemLog.toString(s, "  ");
			s.append("\nActual");
			actualProblemLog.toString(s, "  ");
			throw new AssertionFailedError(s.toString());
		}
	}

	protected boolean copyErrorToConsole = false;	// True to put error message on console as well as JUnit failure
	protected ResourceSet resourceSet;
	protected Resource resource;

	protected Domain createConcreteDomain(Rule rule, String name) {
		Domain domain = new DomainImpl()
		{
		};
		domain.setName(name);
		if (rule != null)
			rule.getDomain().add(domain);
		return domain;
	}

	protected Rule createConcreteRule(Transformation transformation, String name) {
		Rule rule = new RuleImpl()
		{
		};
		rule.setName(name);
		if (transformation != null)
			transformation.getRule().add(rule);
		return rule;
	}

	protected EParameter createEParameter(EOperation eOperation, String name, EClassifier eType) {
		EParameter eParameter = Ecore_Factory.createEParameter();
		eParameter.setName(name);
		eParameter.setEType(eType);
		if (eOperation != null)
			eOperation.getEParameters().add(eParameter);
		return eParameter;
	}

	protected Function createFunction(Transformation transformation, String name) {
		Function function = QVTb_Factory.createFunction();
		function.setName(name);
		if (transformation != null)
			transformation.getEOperations().add(function);
		return function;
	}

	protected FunctionParameter createFunctionParameter(Function function, String name, EClassifier eType) {
		FunctionParameter functionParameter = QVTb_Factory.createFunctionParameter();
		functionParameter.setName(name);
		functionParameter.setEType(eType);
		if (function != null)
			function.getEParameters().add(functionParameter);
		return functionParameter;
	}

	protected Pattern createPattern(List<? super Pattern> patterns) {
		Pattern pattern = QVTb_Factory.createPattern();
		if (patterns != null)
			patterns.add(pattern);
		return pattern;
	}

	protected Predicate createPredicate(List<? super Predicate> predicates) {
		Predicate predicate = QVTb_Factory.createPredicate();
		if (predicates != null)
			predicates.add(predicate);
		return predicate;
	}

	protected Relation createRelation(Transformation transformation, String name) {
		Relation relation = QVTRelationFactory.eINSTANCE.createRelation();
		relation.setName(name);
		if (transformation != null)
			transformation.getRule().add(relation);
		return relation;
	}

	protected StringLiteralExp createStringLiteralExp(String string) {
		StringLiteralExp expr = OCL_Factory.createStringLiteralExp();
		expr.setStringSymbol(string);
		expr.setEType(EcorePackage.Literals.ESTRING);
		return expr;
	}

	protected Transformation createTransformation(Resource resource, String name) {
		Transformation transformation = QVTb_Factory.createTransformation();
		transformation.setName(name);
		if (resource != null)
			resource.getContents().add(transformation);
		return transformation;
	}

	protected TypedModel createTypedModel(Transformation transformation, String name, Collection<? extends EPackage> usedPackages) {
		TypedModel typedModel = QVTb_Factory.createTypedModel();
		typedModel.setName(name);
		if (usedPackages != null)
			typedModel.getUsedPackage().addAll(usedPackages);
		if (transformation != null)
			transformation.getModelParameter().add(typedModel);
		return typedModel;
	}

	protected Variable createVariable(List<? super Variable> variables, String name, EClassifier eType) {
		Variable variable = OCL_Factory.createVariable();
		variable.setName(name);
		variable.setEType(eType);
		if (variables != null)
			variables.add(variable);
		return variable;
	}

	protected OCLExpression createVariableExp(Variable variable) {
		VariableExp variableExp = OCL_Factory.createVariableExp();
		variableExp.setReferredVariable(variable);
		variableExp.setName(variable.getName());
		variableExp.setEType(variable.getEType());
		return variableExp;
	}

	protected EClassifier getBooleanType() {
		return EcorePackage.Literals.EBOOLEAN;
	}

	protected String getQualifiedNameOf(Object object) {
		return TestFormattingHelper.INSTANCE.formatQualifiedName(object);
	}
	
	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
		resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getContentTypeToFactoryMap().put(QVTBasePackage.eCONTENT_TYPE, new XMIResourceFactoryImpl());
		resource = resourceSet.createResource(URI.createURI("TestURI"), QVTBasePackage.eCONTENT_TYPE);
	}
	
	protected void validationTest(ProblemLog expectedProblems) {
		AbstractProblemHandler actualProblems;
		if (expectedProblems != null)
			actualProblems = new ProblemLog();
		else
			actualProblems = new TestProblemHandler();
		DiagnosticChain diagnosticChain = new ProblemHandlerDiagnosticChain(actualProblems);
		Diagnostician diagnostician = createDiagnostician();
	    Map<Object, Object> context = new HashMap<Object, Object>();
	    context.put(EValidator.SubstitutionLabelProvider.class, TestFormattingHelper.INSTANCE);
	    context.put(EValidator.class, diagnostician);
		for (EObject eObject : resource.getContents()) {
			diagnostician.validate(eObject, diagnosticChain, context);
		}
		if (expectedProblems != null) {
//			expectedProblems.setParser(environment.getParser());
			assertEquals(expectedProblems, (ProblemLog)actualProblems);
		}
		else {
			int errorCount = ((StringProblemHandler) actualProblems).getProblemCount();
			if (errorCount > 0) {
				StringBuffer s = new StringBuffer();
				s.append(errorCount + " validation errors\n");
				s.append(((StringProblemHandler) actualProblems).getProblemString());
				if (copyErrorToConsole)
					System.out.println(s.toString());
				s.setLength(s.length()-1);
				fail(s.toString());
			}
		}
	}
	
	protected Diagnostician createDiagnostician() {
		return new Diagnostician()
		{
			@Override
			protected boolean doValidateContents(EObject object, DiagnosticChain diagnostics, Map<Object, Object> context) {
				if (object.eClass().getEPackage() == org.eclipse.ocl.ecore.EcorePackage.eINSTANCE)
					return true;		// OCL's ValidatorVisitor does its own child traversal
				else
					return super.doValidateContents(object, diagnostics, context);
			}
		};
	}
}
