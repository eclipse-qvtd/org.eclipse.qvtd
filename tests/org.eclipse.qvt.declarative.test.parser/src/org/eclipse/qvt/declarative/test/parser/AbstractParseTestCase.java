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
 * $Id: AbstractParseTestCase.java,v 1.11 2010/07/10 09:38:12 ewillink Exp $
 */
package org.eclipse.qvt.declarative.test.parser;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import junit.framework.AssertionFailedError;
import lpg.runtime.IPrsStream;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.ocl.examples.modelregistry.standalone.JavaFileHandle;
import org.eclipse.ocl.lpg.AbstractProblemHandler;
import org.eclipse.ocl.lpg.ProblemHandler;
import org.eclipse.ocl.lpg.StringProblemHandler;
import org.eclipse.osgi.util.NLS;
import org.eclipse.qvt.declarative.ecore.mappings.IMappingMetaData;
import org.eclipse.qvt.declarative.ecore.mappings.IMappingMetaDataRegistry;
import org.eclipse.qvt.declarative.ecore.mappings.MappingConfigurationException;
import org.eclipse.qvt.declarative.editor.ui.ICreationFactory;
import org.eclipse.qvt.declarative.parser.environment.ICSTFileEnvironment;
import org.eclipse.qvt.declarative.parser.environment.ICSTRootEnvironment;
import org.eclipse.qvt.declarative.parser.environment.ProblemHandlerDiagnosticChain;
import org.eclipse.qvt.declarative.parser.unparser.IUnparser;
import org.eclipse.qvt.declarative.parser.utils.ProblemLog;
import org.eclipse.qvt.declarative.parser.utils.ProblemLog.Problem;
import org.eclipse.qvt.declarative.test.emof.AbstractTestCase;
import org.eclipse.qvt.declarative.test.emof.tools.EcoreEquivalenceHelper;
import org.eclipse.qvt.declarative.test.emof.tools.EquivalenceHelper;
import org.eclipse.qvt.declarative.test.emof.utils.TestFormattingHelper;

public abstract class AbstractParseTestCase extends AbstractTestCase
{	
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
			IPrsStream prsStream = getParser().getIPrsStream();
			String file = prsStream.getFileName();
			int lineNumber = prsStream.getTokenAtCharacter(startOffset).getLine();
			String message = NLS.bind(
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
	
	protected boolean asEMOF = false;		// True to generate EMOF-based rather than Ecore-based AST models
	protected boolean doSave = true;		// False to suppress save of parsed AST
	protected boolean doValidate = true;	// False to suppress validation of parsed AST
	protected boolean doCompare = true;		// False to suppress compare of parsed AST
	protected boolean copyErrorToConsole = false;	// True to put error message on console as well as JUnit failure
	
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
	
	protected abstract ICSTFileEnvironment createEnvironment(String fileName, URI astURI) throws IOException, CoreException;

	protected final IUnparser createUnparser(Resource referenceResource) {
		return getCreationFactory().createUnparser(referenceResource);
	}
	
	protected void expectUnrecognizedVariable(ProblemLog expectedProblems, String name) {
		expectedProblems.handleProblem(ProblemHandler.Severity.ERROR, ProblemHandler.Phase.ANALYZER,
				"Unrecognized variable: (" + name + ")", "variableExpCS", -1, -1);
	}
	
	protected abstract ICreationFactory getCreationFactory();
	
	@Override
	protected IMappingMetaDataRegistry getMappingMetaDataRegistry() {
		IMappingMetaDataRegistry mappingMetaDataRegistry = super.getMappingMetaDataRegistry();
		IMappingMetaData mappingMetaData = getCreationFactory().getMappingMetaData();
		if (mappingMetaData != null)
			mappingMetaData.getFactory(mappingMetaDataRegistry);
		return mappingMetaDataRegistry;
	}

	protected final String getTextExtension() {
		return getCreationFactory().getTextExtension();
	}
	
	protected final String getXMLExtension(boolean generateEMOF) {
		return (generateEMOF ? getCreationFactory().getEMOFExtension() : getCreationFactory().getEcoreExtension());
	}
	
	/*
	 * Parse fileStem to an AST resource, then if doSave save the AST in to Ecore or EMOF according to asEMOF,
	 * then if doValidate validate the AST, then if doCompare compare the parsed AST against 
	 * fileStem extentended by '.reference' and the asEMOF determined extension. 
	 */
	@Deprecated
	protected void parserTest(String fileStem, boolean asEMOF) throws IOException, CoreException, MappingConfigurationException {
		this.asEMOF = asEMOF;
		parserTest(fileStem, null);
	}
	@Deprecated
	protected void parserTest(String fileStem, ProblemLog expectedProblems, boolean asEMOF) throws IOException, CoreException, MappingConfigurationException {
		this.asEMOF = asEMOF;
		parserTest(fileStem, expectedProblems);
	}
	protected void parserTest(String fileStem, ProblemLog expectedProblems) throws IOException, CoreException, MappingConfigurationException {
		String generatedName = fileStem + "." + getXMLExtension(asEMOF);
		URI generatedURI = getProjectFileURI(generatedName);
		ICSTFileEnvironment environment = createEnvironment(fileStem + "." + getTextExtension(), generatedURI);
		AbstractProblemHandler actualProblems;
		if (expectedProblems != null)
			actualProblems = new ProblemLog();
		else
			actualProblems = new TestProblemHandler();
		environment.setProblemHandler(actualProblems);
		//
		ICSTRootEnvironment rootEnvironment = environment.parse(null, environment.getFile(), null);
		//
		Resource ecoreResource = null;
		if (rootEnvironment != null) {
			ecoreResource = rootEnvironment.getASTNode();
			if (doSave) {
				if (asEMOF) {
					Resource emofResource = getMappingMetaDataRegistry().getAdapter(ecoreResource, generatedURI);
					emofResource.save(null);
				}
				else
					ecoreResource.save(null);
			}
			if (doValidate && (rootEnvironment.getCSTErrorTokens() <= 0))
				rootEnvironment.validate();
		}
		actualProblems.flush(null);
		//
		if (expectedProblems != null) {
			expectedProblems.setParser(environment.getParser());
			assertEquals(expectedProblems, (ProblemLog)actualProblems);
		}
		else {
			int errorCount = ((StringProblemHandler) actualProblems).getProblemCount();
			if (errorCount > 0) {
				StringBuffer s = new StringBuffer();
				s.append(errorCount + " parser errors\n");
				s.append(((StringProblemHandler) actualProblems).getProblemString());
				if (copyErrorToConsole)
					System.out.println(s.toString());
				s.setLength(s.length()-1);
				fail(s.toString());
			}
		}
		//
		if (doCompare) {
			String referenceName = fileStem + ".reference." + getXMLExtension(asEMOF);
			URI projectURI = getProjectURI();
			URI referenceURI = getProjectFileURI(referenceName);
			EquivalenceHelper equivalenceHelper = /*asEMOF ? EMOFEquivalenceHelper.INSTANCE :*/ EcoreEquivalenceHelper.INSTANCE;
			assertSameModel(equivalenceHelper, projectURI, ecoreResource, referenceURI, null);
		}
	}

	protected void problemTest(String fileStem, ProblemLog expectedProblems) throws IOException, CoreException {
		URI uri = URI.createFileURI(fileStem + "." + getTextExtension());
		ProblemLog actualProblems = new ProblemLog();
		ICSTFileEnvironment environment = createEnvironment(fileStem + "." + getTextExtension(), uri);
		environment.setProblemHandler(actualProblems);
		ICSTRootEnvironment rootEnvironment = environment.parse(null, environment.getFile(), null);
		if (doValidate && (rootEnvironment != null))
			rootEnvironment.validate();
		actualProblems.flush(null);
		expectedProblems.setParser(environment.getParser());
		assertEquals(expectedProblems, actualProblems);
	}

	/*
	 * Load an Ecore/EMOF file, unparse to text, reparse to Ecore/EMOF, check for no errors and check against original.
	 */
	@Deprecated
	protected void unparserTest(String fileStem, boolean asEMOF) throws IOException, CoreException, MappingConfigurationException {
		this.asEMOF = asEMOF;
		unparserTest(fileStem);
	}
	protected void unparserTest(String fileStem) throws IOException, CoreException, MappingConfigurationException {
		getMappingMetaDataRegistry().initialize();
		String referenceName = fileStem + ".reference." + getXMLExtension(asEMOF);
		URI loadURI = getProjectFileURI(referenceName);
		Resource referenceResource = resourceSet.getResource(loadURI, true);;
		//
		IUnparser unParser = createUnparser(referenceResource);
		unParser.unparse();
		String unparsedString = unParser.getString();
		//
		JavaFileHandle fileHandle = getFileHandle(fileStem + ".unparsed." + getTextExtension());
		FileWriter fileWriter = new FileWriter(fileHandle.getFile());
		fileWriter.append(unparsedString);
		fileWriter.close();
		//
		String generatedName = fileStem + ".unparsed." + getXMLExtension(asEMOF);
		URI generatedURI = getProjectFileURI(generatedName);
		//
		ICSTFileEnvironment environment = createEnvironment(fileStem + ".unparsed." + getTextExtension(), generatedURI);
		StringProblemHandler problemHandler = new StringProblemHandler(null);
		environment.setProblemHandler(problemHandler);
		//
		ICSTRootEnvironment rootEnvironment = environment.parse(null, environment.getFile(), null);
		//
		int errorCount = problemHandler.getProblemCount();
		if (errorCount > 0)
			fail("Parser errors\n" + problemHandler.getProblemString());
		Resource ecoreResource = rootEnvironment.getASTNode();
		if (asEMOF) {
			Resource emofResource = getMappingMetaDataRegistry().getAdapter(ecoreResource, generatedURI);
			emofResource.save(null);
		}
		else
			ecoreResource.save(null);
		if (doValidate && (rootEnvironment != null))
			rootEnvironment.validate();
		problemHandler.flush(null);
		EquivalenceHelper equivalenceHelper = /* generateEMOF ? EMOFEquivalenceHelper.INSTANCE :*/ EcoreEquivalenceHelper.INSTANCE;
		assertSameModel(equivalenceHelper, getProjectURI(), ecoreResource, referenceResource, null);
	}

	@Deprecated
	protected void validationTest(String fileStem, ProblemLog expectedProblems, boolean asEMOF) throws IOException, CoreException {
		this.asEMOF = asEMOF;
		validationTest(fileStem, expectedProblems);
	}
	protected void validationTest(String fileStem, ProblemLog expectedProblems) throws IOException, CoreException {
		AbstractProblemHandler actualProblems;
		if (expectedProblems != null)
			actualProblems = new ProblemLog();
		else
			actualProblems = new TestProblemHandler();
		String referenceName = fileStem + ".reference." + getXMLExtension(asEMOF);
		URI loadURI = getProjectFileURI(referenceName);
		Resource resource = resourceSet.getResource(loadURI, true);
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
