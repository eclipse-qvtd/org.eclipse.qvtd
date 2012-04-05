/**
 * <copyright>
 * 
 * Copyright (c) 2007, 2008 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * </copyright>
 * 
 * Contributors:
 *     Quentin Glineur - initial API and implementation
 *
 * $Id: ATLVMCompiler.java,v 1.22 2009/03/05 18:06:12 qglineur Exp $
 */
package org.eclipse.qvt.declarative.relations.atlvm;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.InvalidPropertiesFormatException;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.m2m.atl.drivers.emf4atl.ASMEMFModel;
import org.eclipse.m2m.atl.drivers.emf4atl.EMFModelLoader;
import org.eclipse.m2m.atl.engine.vm.ASM;
import org.eclipse.m2m.atl.engine.vm.ASMExecEnv;
import org.eclipse.m2m.atl.engine.vm.ASMInterpreter;
import org.eclipse.m2m.atl.engine.vm.ASMXMLReader;
import org.eclipse.m2m.atl.engine.vm.Debugger;
import org.eclipse.m2m.atl.engine.vm.SimpleDebugger;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMModel;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMModule;
import org.eclipse.qvt.declarative.atlvm.problems.problems.Problem;
import org.eclipse.qvt.declarative.atlvm.problems.problems.ProblemsPackage;
import org.eclipse.qvt.declarative.common.framework.service.Operation;
import org.eclipse.qvt.declarative.compilation.CompilationProvider;
import org.eclipse.qvt.declarative.compilation.CompileOperation;
import org.eclipse.qvt.declarative.compilation.DeclarativeQVTCompilationException;
import org.eclipse.qvt.declarative.compilation.QVTRelationsCompilationException;
import org.eclipse.qvt.declarative.ecore.QVTBase.TypedModel;
import org.eclipse.qvt.declarative.ecore.QVTRelation.QVTRelationPackage;
import org.eclipse.qvt.declarative.ecore.QVTRelation.RelationalTransformation;
import org.eclipse.qvt.declarative.relations.atlvm.relationsToTraceClass.RelationsToTraceClassPackage;
import org.eclipse.qvt.declarative.relations.atlvm.utils.ASMUtils;
import org.osgi.framework.Bundle;

/**
 * A client implementation to provide a compilation of QVT Relations in ATLVM
 * byte code
 * 
 * @author Quentin Glineur
 * 
 */
public class ATLVMCompiler implements CompilationProvider {

	private static final String COMPILER_ASM_LOCATION = "resources/QVTR.asm"; //$NON-NLS-1$

	private static final String TRACE_CLASS_ASM_LOCATION = "resources/RelationsToTraceClass.asm"; //$NON-NLS-1$

	private static final ASM RELATION_TO_TRACE_CLASS;

	private static final String DEFAULT_DEBUGGER_PROPERTIES_LOCATION = "debugger.properties.xml"; //$NON-NLS-1$

	protected static final String EXECUTABLE_SUFFIX = "asm"; //$NON-NLS-1$

	public static final String OUT_FILE_PARAMETER_NAME = "WriteTo"; //$NON-NLS-1$

	public static final String DIRECTION_PARAMETER_NAME = "direction"; //$NON-NLS-1$

	public static final String TRANSFORMATION_MODEL_NAME = "IN"; //$NON-NLS-1$

	private static final String PROBLEM_MODEL_FILE_EXTENSION = "pbm.xmi"; //$NON-NLS-1$

	private static final String PROBLEM_MODEL_NAME = "OUT";

	private static final ASM COMPILER_ASM;

	private static final String RELATION_METAMODEL_ALIAS = "QVTR";

	/**
	 * The Problem metamodel. This is the way problems are reported during the
	 * compilation: instances of the Problem class are created inside a model.
	 * This model can be then interpreted to exhibit problems.
	 */
	private static final ASMModel PROBLEM_METAMODEL;

	private static final Debugger DEFAULT_DEBUGGER;


	private static final ASMModel QVTR_METAMODEL;

	static {
		// static initializations
		COMPILER_ASM = loadQVTRCompiler();
		PROBLEM_METAMODEL = loadProblemMetamodel();
		DEFAULT_DEBUGGER = createDefaultDebugger();
		QVTR_METAMODEL = loadQVTRMetamodel();
		RELATION_TO_TRACE_CLASS = loadRelationToTraceClass();
	}

	/**
	 * Construct a new compiler producing ATLVM byte code from a QVT Relations
	 * source
	 */
	public ATLVMCompiler() {

	}

	private static ASM loadRelationToTraceClass() {
		Bundle bundle = Activator.getDefault().getBundle();

		ASM compilerASM = null;
		URL compilerUrl = FileLocator.find(bundle, new Path(
				TRACE_CLASS_ASM_LOCATION), Collections.EMPTY_MAP);
		try {
			compilerASM = new ASMXMLReader().read(new BufferedInputStream(
					compilerUrl.openStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return compilerASM;
	}

	private static ASMModel loadQVTRMetamodel() {
		ASMModel model = null;
		try {
			EMFModelLoader emfModelLoader = new EMFModelLoader();
			model = emfModelLoader.loadModel("QVTR", emfModelLoader.getMOF(),
					URI.createURI(QVTRelationPackage.eNS_URI));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return model;
	}

	private static ASMModel loadProblemMetamodel() {
		ASMModel model = null;
		try {
			EMFModelLoader emfModelLoader = new EMFModelLoader();
			model = emfModelLoader.loadModel(ProblemsPackage.eNAME,
					emfModelLoader.getMOF(), URI
							.createURI(ProblemsPackage.eNS_URI));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return model;
	}

	/**
	 * Load the compiled version (i.e ASM codes) of the QVTR compiler.
	 */
	private static final ASM loadQVTRCompiler() {
		Bundle bundle = Activator.getDefault().getBundle();

		ASM compilerASM = null;
		URL compilerUrl = FileLocator.find(bundle, new Path(
				COMPILER_ASM_LOCATION), Collections.EMPTY_MAP);
		try {
			compilerASM = new ASMXMLReader().read(new BufferedInputStream(
					compilerUrl.openStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return compilerASM;
	}

	/**
	 * Create a default debugger with the parameters stored in the corresponding
	 * configuration file
	 */
	private static Debugger createDefaultDebugger() {
		Properties debuggerProperties = new Properties();
		URL debuggerPropertiesURL = ATLVMCompiler.class
				.getResource(DEFAULT_DEBUGGER_PROPERTIES_LOCATION);
		try {
			debuggerProperties.loadFromXML(debuggerPropertiesURL.openStream());
		} catch (InvalidPropertiesFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Debugger result = new SimpleDebugger(
		/* step = */Boolean.toString(true).equals(
				debuggerProperties.get("step")), //$NON-NLS-1$
				/* stepops = */new ArrayList<String>(),
				/* deepstepops = */new ArrayList<String>(),
				/* nostepops = */new ArrayList<String>(),
				/* deepnostepops = */new ArrayList<String>(),
				/* showStackTrace = */true, Boolean.toString(true).equals(
						debuggerProperties.get("showSummary")), //$NON-NLS-1$
				Boolean.toString(true)
						.equals(debuggerProperties.get("profile")), //$NON-NLS-1$
				Boolean.toString(true).equals(
						debuggerProperties.get("continueAfterError")) //$NON-NLS-1$
		);
		return result;
	}

	protected String getDefaultExecutablePath(
			URI relativeAbstractSyntaxTreeURI, String direction) {

		URI executableURI = relativeAbstractSyntaxTreeURI.trimFileExtension()
				.appendFileExtension(direction).appendFileExtension(
						EXECUTABLE_SUFFIX);
		if (executableURI.isPlatformResource()) {
			IPath workspacePath = ResourcesPlugin.getWorkspace().getRoot().getLocation();
			IPath executablePath = workspacePath.append(new Path(executableURI.toPlatformString(true)));
			return executablePath.toString();
		}
		if (executableURI.isFile()) {
			return executableURI.toFileString();
		}
		return null;
	}

	protected ASMModel createProblemModelFor(Resource abstractSyntaxTree)
			throws Exception {
		URI abstractSyntaxTreeURI = abstractSyntaxTree.getURI();
		String problemFileName = abstractSyntaxTreeURI.trimFileExtension()
				.appendFileExtension(PROBLEM_MODEL_FILE_EXTENSION).toString();
		return new EMFModelLoader().newModel(PROBLEM_MODEL_NAME,
				problemFileName, PROBLEM_METAMODEL);

	}

	protected Properties createCompilationsProperties(
			URI relativeAbstractSyntaxTreeURI,
			final Map<String, String> parameters, String direction) {
		Properties effectiveParameters = new Properties();
		effectiveParameters.putAll(parameters);

		if (!effectiveParameters.containsKey(OUT_FILE_PARAMETER_NAME)) {
			String executablePath = getDefaultExecutablePath(
					relativeAbstractSyntaxTreeURI, direction);
			effectiveParameters.put(OUT_FILE_PARAMETER_NAME, executablePath);
		}
		return effectiveParameters;
	}

	protected URI[] getSplittedSourceURI(File binFolder, File sourceFile) {
		URI sourceFileURI = URI.createFileURI(sourceFile.getAbsolutePath());
		URI currentFolderURI = URI.createURI("./");
		URI relativeURI = null;

		URI folderURI = URI.createFileURI(binFolder.getAbsolutePath())
				.appendSegment("");
		relativeURI = sourceFileURI.replacePrefix(folderURI, currentFolderURI);
		if (relativeURI != null) {
			return new URI[] { folderURI, relativeURI };
		}

		return new URI[] { null, null };
	}

	private ASMModel loadModelForTraceClassTransformation(ASMExecEnv env,
			Resource relationsTransformation) throws IOException {

		URI transfoURI = relationsTransformation.getURI();
		EMFModelLoader modelLoader = new EMFModelLoader();

		ASMModel tracebilityMetamodel = modelLoader.loadModel("Traceability",
				modelLoader.getMOF(), URI
						.createURI(RelationsToTraceClassPackage.eINSTANCE
								.getNsURI()));
		env.addModel(tracebilityMetamodel);

		ASMModel traceModel = modelLoader.newModel("traces", "traces.xmi",
				tracebilityMetamodel);
		((ASMEMFModel) traceModel).setCheckSameModel(false);
		env.addModel(traceModel);

		ASMModel relationsMM = modelLoader.loadModel("relationsMM", modelLoader
				.getMOF(), URI.createURI(QVTRelationPackage.eINSTANCE
				.getNsURI()));
		env.addModel(relationsMM);

		ASMModel relations = modelLoader.loadModel("relations", relationsMM,
				transfoURI);
		env.addModel(relations);

		ASMModel coreMM = modelLoader.getMOF();
		env.addModel("coreMM", modelLoader.getMOF());

		String traceClassFileName = 'T' + transfoURI.trimFileExtension()
				.lastSegment();
		URI traceClassURI = transfoURI.trimSegments(1).appendSegment(
				traceClassFileName).appendFileExtension("ecore");
		ASMModel core = modelLoader.newModel("core", traceClassURI.toString(),
				coreMM);
		((ASMEMFModel) core).setCheckSameModel(false);

		env.addModel(core);

		return core;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.qvt.declarative.compilation.CompilationProvider#compile(java
	 * .lang.Object, java.util.Map, org.eclipse.core.resources.IFolder,
	 * org.eclipse.core.resources.IFolder)
	 */
	public List<File> compile(Object abstractSyntaxTree,
			Map<String, String> parameters)
			throws DeclarativeQVTCompilationException {

		if (!(abstractSyntaxTree instanceof Resource)) {
			String message = "Abstract Syntax is not a Resource: "
					+ abstractSyntaxTree.toString();
			DeclarativeQVTCompilationException exception = new QVTRelationsCompilationException(
					message, 0, 0, 0);
			throw exception;
		}

		Resource abstractSyntaxTreeResource = (Resource) abstractSyntaxTree;

		executeRelationsToTraceClass(abstractSyntaxTreeResource);

		ASMModel qvtrTransformation = null;
		try {
			qvtrTransformation = new EMFModelLoader().loadModel(
					TRANSFORMATION_MODEL_NAME, QVTR_METAMODEL,
					abstractSyntaxTreeResource.getURI());
		} catch (Exception e) {
			String message = "Unable to load the AST in the ATLVM : "
					+ e.getMessage();
			QVTRelationsCompilationException exception = new QVTRelationsCompilationException(
					message, 0, 0, 0);
			throw exception;
		}

		List<String> directions = getDirections(abstractSyntaxTreeResource);

		List<File> result = new ArrayList<File>(directions.size());
		for (String directionDomainName : directions) {
			ASM directionASM = ASMUtils
					.createDirectionLibrary(directionDomainName);
			ASMModel myProblems = null;
			try {
				myProblems = createProblemModelFor(abstractSyntaxTreeResource);
			} catch (Exception e) {
				String message = "Unable to create a problem model for the ATLVM : "
						+ e.getMessage();
				QVTRelationsCompilationException exception = new QVTRelationsCompilationException(
						message, 0, 0, 0);
				throw exception;
			}
			Properties effectiveParameters = createCompilationsProperties(
					abstractSyntaxTreeResource.getURI(), parameters,
					directionDomainName);
			if (qvtrTransformation != null && myProblems != null) {
				File resultFile = compile(qvtrTransformation, directionASM,
						myProblems, DEFAULT_DEBUGGER, effectiveParameters);
				result.add(resultFile);
				handleProblems(myProblems);
			}
		}
		return result;

	}

	protected List<String> getDirections(Resource resource) {
		List<String> result = new ArrayList<String>();
		RelationalTransformation relationalTransformation = getTransformation(resource);
		if (relationalTransformation != null) {
			for (TypedModel typedModel : relationalTransformation.getModelParameter()) {
				result.add(typedModel.getName());
			}
			return result;
		}
		return null;
	}

	protected void handleProblems(ASMModel problems)
			throws QVTRelationsCompilationException {
		Set<?> problemSet = problems.getElementsByType("Problem");
		for (Object object : problemSet) {
			if (object instanceof Problem) {
				Problem problem = (Problem) object;
				String message = problem.getDescription();
				int startLine = problem.getStartLine().intValue();
				int startColumn = problem.getStartColumn().intValue();
				int endColumn = problem.getEndColumn().intValue();
				throw new QVTRelationsCompilationException(message, startLine,
						startColumn, endColumn);
			}
		}
	}

	private RelationalTransformation getTransformation(Resource resource) {
		List<EObject> contents = resource.getContents();
		if (!contents.isEmpty()) {
			EObject eObject = resource.getContents().get(0);
			if (eObject instanceof RelationalTransformation) {
				return (RelationalTransformation) eObject;
			}
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.qvt.declarative.common.framework.service.Provider#provides
	 * (org.eclipse.qvt.declarative.common.framework.service.Operation)
	 */
	public boolean provides(Operation operation) {
		if (operation instanceof CompileOperation) {
			CompileOperation compileOperation = (CompileOperation) operation;
			Object source = compileOperation.getSource();
			if (source instanceof Resource) {
				Resource resource = (Resource) source;
				boolean contentIsValid = getTransformation(resource) != null;
				return contentIsValid;
			}
		}
		return false;
	}

	protected File compile(final ASMModel qvtrTransformation,
			final ASM directionLibary, final ASMModel myProblems,
			final Debugger debugger, final Properties compilationParameters)
			throws QVTRelationsCompilationException {

		ASMModule asmModule = new ASMModule(COMPILER_ASM);

		/*
		 * Create an execution environment with the handled models
		 */
		ASMExecEnv env = new ASMExecEnv(asmModule, debugger, true);
		env.addPermission("file.read"); //$NON-NLS-1$
		env.addPermission("file.write"); //$NON-NLS-1$

		env.addModel(RELATION_METAMODEL_ALIAS, qvtrTransformation
				.getMetamodel());
		env.addModel(qvtrTransformation.getName(), qvtrTransformation);
		env.addModel(myProblems.getMetamodel().getName(), myProblems
				.getMetamodel());
		env.addModel(myProblems.getName(), myProblems);
		env.registerOperations(directionLibary);
		env.registerOperations(COMPILER_ASM);

		/*
		 * Launch the interpretation of the compiler on the QVTR abstract syntax
		 * tree
		 */
		try {
			new ASMInterpreter(COMPILER_ASM, asmModule, env,
					compilationParameters);
		} catch (Exception e) {
			String message = e.getMessage();
			QVTRelationsCompilationException exception = new QVTRelationsCompilationException(
					message, 0, 0, 0);
			throw exception;
		}

		File resultFile = new File(compilationParameters
				.getProperty(OUT_FILE_PARAMETER_NAME));
		return resultFile;
	}

	protected void executeRelationsToTraceClass(
			final Resource relationsTransformation)
			throws QVTRelationsCompilationException {

		ASMModule asmModule = new ASMModule(RELATION_TO_TRACE_CLASS);

		/*
		 * Create an execution environment with the handled models
		 */
		ASMExecEnv env = new ASMExecEnv(asmModule, DEFAULT_DEBUGGER, true);
		env.addPermission("file.read"); //$NON-NLS-1$
		env.addPermission("file.write"); //$NON-NLS-1$

		try {
			ASMModel result = loadModelForTraceClassTransformation(env,
					relationsTransformation);

			env.registerOperations(RELATION_TO_TRACE_CLASS);

			Map<String, String> parameters = new HashMap<String, String>();
			parameters.put("enforce", "true");

			new ASMInterpreter(RELATION_TO_TRACE_CLASS, asmModule, env,
					parameters);

			URI transfoURI = relationsTransformation.getURI();
			String traceClassFileName = 'T' + transfoURI.trimFileExtension()
					.lastSegment();
			URI traceClassURI = transfoURI.trimSegments(1).appendSegment(
					traceClassFileName).appendFileExtension("ecore");
			result.getModelLoader().save(result,
					traceClassURI.toPlatformString(true));

		} catch (Exception e) {
			String message = "Problem creating the Trace Classes \n"
					+ e.getMessage();
			throw new QVTRelationsCompilationException(message, 0, 0, 0);
		}

	}

}
