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

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import junit.framework.AssertionFailedError;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.ocl.lpg.AbstractProblemHandler;
import org.eclipse.ocl.lpg.ProblemHandler;
import org.eclipse.ocl.lpg.StringProblemHandler;
import org.eclipse.qvt.declarative.ecore.QVTBase.Function;
import org.eclipse.qvt.declarative.ecore.QVTBase.FunctionParameter;
import org.eclipse.qvt.declarative.ecore.QVTBase.Pattern;
import org.eclipse.qvt.declarative.ecore.QVTBase.Predicate;
import org.eclipse.qvt.declarative.ecore.QVTBase.QVTBaseFactory;
import org.eclipse.qvt.declarative.ecore.QVTBase.QVTBasePackage;
import org.eclipse.qvt.declarative.ecore.QVTBase.Transformation;
import org.eclipse.qvt.declarative.ecore.QVTBase.TypedModel;
import org.eclipse.qvt.declarative.parser.environment.ProblemHandlerDiagnosticChain;
import org.eclipse.qvt.declarative.parser.utils.ProblemLog;
import org.eclipse.qvt.declarative.parser.utils.ProblemLog.Problem;
import org.eclipse.qvt.declarative.test.TestQVTBase.TestDomain;
import org.eclipse.qvt.declarative.test.TestQVTBase.TestExpression;
import org.eclipse.qvt.declarative.test.TestQVTBase.TestPattern;
import org.eclipse.qvt.declarative.test.TestQVTBase.TestQVTBaseFactory;
import org.eclipse.qvt.declarative.test.TestQVTBase.TestRule;
import org.eclipse.qvt.declarative.test.TestQVTBase.TestTransformation;
import org.eclipse.qvt.declarative.test.emof.essentialocl.AbstractEssentialOCLValidationTest;
import org.eclipse.qvt.declarative.test.emof.utils.TestFormattingHelper;

public abstract class AbstractQVTBaseValidationTest extends AbstractEssentialOCLValidationTest
{
	public static final QVTBaseFactory QVTb_Factory = QVTBaseFactory.eINSTANCE;

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
					Collections.sort(actualProblems);
					Collections.sort(expectedProblems);
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

	protected TestDomain createTestDomain(List<? super TestDomain> contents, String name, TypedModel typedModel) {
		TestDomain domain = TestQVTBaseFactory.eINSTANCE.createTestDomain();
		domain.setName(name);
		if (typedModel != null)
			domain.setTypedModel(typedModel);
		if (contents != null)
			contents.add(domain);
		domain.setIsCheckable(true);
		domain.setIsEnforceable(true);
		return domain;
	}

	protected TestExpression createTestExpression() {
		TestExpression expression = TestQVTBaseFactory.eINSTANCE.createTestExpression();
		expression.setType(getStringType());
		return expression;
	}

	protected TestPattern createTestPattern(List<? super TestPattern> contents) {
		TestPattern pattern = TestQVTBaseFactory.eINSTANCE.createTestPattern();
		if (contents != null)
			contents.add(pattern);
		return pattern;
	}

	protected TestRule createTestRule(List<? super TestRule> contents, String name) {
		TestRule rule = TestQVTBaseFactory.eINSTANCE.createTestRule();
		rule.setName(name);
		if (contents != null)
			contents.add(rule);
		return rule;
	}

	protected TestTransformation createTestTransformation(List<? super TestTransformation> contents, String name) {
		TestTransformation transformation = TestQVTBaseFactory.eINSTANCE.createTestTransformation();
		transformation.setName(name);
		if (contents != null)
			contents.add(transformation);
		return transformation;
	}

	protected Transformation createTransformation(Resource resource, String name) {
		Transformation transformation = QVTb_Factory.createTransformation();
		transformation.setName(name);
		if (resource != null)
			resource.getContents().add(transformation);
		return transformation;
	}

	protected TypedModel createTypedModel(Transformation transformation, String name, EPackage... usedPackages) {
		TypedModel typedModel = QVTb_Factory.createTypedModel();
		typedModel.setName(name);
		if (usedPackages != null)
			for (EPackage usedPackage : usedPackages)
				typedModel.getUsedPackage().add(usedPackage);
		if (transformation != null)
			transformation.getModelParameter().add(typedModel);
		return typedModel;
	}

	protected String getQualifiedNameOf(Object object) {
		return TestFormattingHelper.INSTANCE.formatQualifiedName(object);
	}
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getContentTypeToFactoryMap().put(QVTBasePackage.eCONTENT_TYPE, new XMIResourceFactoryImpl());
		resource = resourceSet.createResource(URI.createURI("TestURI"), QVTBasePackage.eCONTENT_TYPE);
	}
	
	protected void validationTest(ProblemLog expectedProblems) {
		AbstractProblemHandler actualProblems = new ProblemLog();
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
}
