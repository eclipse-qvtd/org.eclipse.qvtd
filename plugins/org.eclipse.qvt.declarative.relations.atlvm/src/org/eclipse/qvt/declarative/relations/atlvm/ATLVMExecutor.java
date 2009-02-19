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
 * $Id: ATLVMExecutor.java,v 1.9 2009/02/19 14:28:27 qglineur Exp $
 */
package org.eclipse.qvt.declarative.relations.atlvm;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.InvalidPropertiesFormatException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.xmi.XMLResource;
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
import org.eclipse.qvt.declarative.common.framework.service.Operation;
import org.eclipse.qvt.declarative.execution.ExecuteOperation;
import org.eclipse.qvt.declarative.execution.ExecutionContext;
import org.eclipse.qvt.declarative.execution.ExecutionProvider;
import org.eclipse.qvt.declarative.execution.LabelledModel;
import org.eclipse.qvt.declarative.execution.QVTRealtionsExecutionException;
import org.eclipse.qvt.declarative.execution.ExecutionContext.ExecutionMode;


/**
 * A client implementation to provide an execution of QVT Relations by the
 * regular ATL VM.
 * 
 * @author Quentin Glineur
 * 
 */
public class ATLVMExecutor implements ExecutionProvider {

	private static final String DEFAULT_DEBUGGER_PROPERTIES_LOCATION = "debugger.properties.xml"; //$NON-NLS-1$
	private static final Debugger DEFAULT_DEBUGGER;
	private static final String STEP_PROPERTY = "step"; //$NON-NLS-1$
	private static final String SHOW_SUMMARY_PROPERTY = "showSummary"; //$NON-NLS-1$
	private static final String PROFILE_PROPERTY = "profile"; //$NON-NLS-1$
	private static final String CONTINUE_AFTER_ERROR_PROPERTY = "continueAfterError"; //$NON-NLS-1$

	static {
		// start the static initializations
		DEFAULT_DEBUGGER = createDefaultDebugger();
	}

	// TODO remove duplicate with ATLVM compiler
	/**
	 * Create a default debugger with the parameters stored in the corresponding
	 * configuration file
	 */
	private static Debugger createDefaultDebugger() {
		Properties debuggerProperties = new Properties();
		URL debuggerPropertiesURL = ATLVMExecutor.class
				.getResource(DEFAULT_DEBUGGER_PROPERTIES_LOCATION);

		try {
			debuggerProperties.loadFromXML(debuggerPropertiesURL.openStream());
		} catch (InvalidPropertiesFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		boolean showSummary = Boolean.toString(true).equals(
				debuggerProperties.get(SHOW_SUMMARY_PROPERTY));
		boolean profile = Boolean.toString(true).equals(
				debuggerProperties.get(PROFILE_PROPERTY));
		boolean continueAfterError = Boolean.toString(true).equals(
				debuggerProperties.get(CONTINUE_AFTER_ERROR_PROPERTY));

		Debugger result = new SimpleDebugger(Boolean.toString(true).equals(
				debuggerProperties.get(STEP_PROPERTY)),
				new ArrayList<String>(), new ArrayList<String>(),
				new ArrayList<String>(), new ArrayList<String>(), true,
				showSummary, profile, continueAfterError);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.qvt.declarative.common.framework.service.Provider#provides
	 * (org.eclipse.qvt.declarative.common.framework.service.Operation)
	 */
	public boolean provides(Operation operation) {
		if (operation instanceof ExecuteOperation) {
			try {
				// TODO
				// ExecuteOperation executeOperation = (ExecuteOperation)
				// operation;
				// IPath abstractSyntaxTreePath =
				// executeOperation.getSourceFile()
				// .getLocation();
				// String direction = executeOperation.getParameters()
				// .getDirectionModel().getName();
				// IFolder sourceFolder = executeOperation.getSourceFolder();
				// IFolder buildFolder = executeOperation.getBinFolder();
				// TODO
				//
				// IPath executablePath =
				// ATLVMCompiler.getDefaultExecutablePath(
				// abstractSyntaxTreePath,
				// direction, sourceFolder, buildFolder);
				// return executablePath.toFile().canRead();
				return true;
			} catch (ClassCastException exception) {
				return false;
			}
		}
		return false;
	}

	// FIXME libraries for overriding transformations
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.qvt.declarative.execution.ExecutionProvider#execute(org.eclipse
	 * .core.resources.IFile,
	 * org.eclipse.qvt.declarative.execution.ExecutionContext,
	 * org.eclipse.core.resources.IFolder, org.eclipse.core.resources.IFolder)
	 */
	public List<?> execute(File executableFile, ExecutionContext parameters)
			throws QVTRealtionsExecutionException {
		Map<String, String> transformationParameters = new HashMap<String, String>();
		boolean isCheckOnly = parameters.getMode() == ExecutionMode.checkOnly;
		transformationParameters
				.put("checkOnly", Boolean.toString(isCheckOnly));

		List<ASMModel> linkedModels = new ArrayList<ASMModel>();
		EMFModelLoader emfModelLoader = new EMFModelLoader();
		try {
			for (LabelledModel namedModel : parameters.getSourceModels()) {
				ASMModel metamodel = emfModelLoader.loadModel(namedModel.getName()+"MM", emfModelLoader.getMOF(), URI.createURI(namedModel.getMetamodel().getAccessor()));
				linkedModels.add(metamodel);
				linkedModels.add(emfModelLoader.loadModel(namedModel.getName(), metamodel, URI.createURI(namedModel.getAccessor())));
			}
			LabelledModel directionNamedModel = parameters.getDirectionModel();
			ASMModel metamodel = emfModelLoader.loadModel(directionNamedModel.getName()+"MM", emfModelLoader.getMOF(), URI.createURI(directionNamedModel.getMetamodel().getAccessor()));
			linkedModels.add(metamodel);
			linkedModels.add(emfModelLoader.loadModel(directionNamedModel.getName(), metamodel, URI.createURI(directionNamedModel.getAccessor())));
		} catch (Exception e) {
			String message = "Unable to load models into the ATLVM \n"
					+ e.getMessage();
			throw new QVTRealtionsExecutionException(message);
		}

		ASM qvtrTransformation;
		try {
			qvtrTransformation = new ASMXMLReader()
					.read(new BufferedInputStream(new FileInputStream(
							executableFile)));
		} catch (FileNotFoundException e) {
			String message = "Unable to load ASM code in the ATLVM \n"
					+ e.getMessage();
			throw new QVTRealtionsExecutionException(message);
		}
		Object result = execute(qvtrTransformation, linkedModels, Collections
				.<ASM> emptyList(), transformationParameters, DEFAULT_DEBUGGER);
		for (ASMModel model : linkedModels) {
			Map<String, Boolean> serializationParameters = new HashMap<String, Boolean>();
			URI metamodelURI = ((ASMEMFModel) model.getMetamodel()).getExtent()
					.getURI();
			if (metamodelURI.isFile()) {
				serializationParameters.put(XMLResource.OPTION_SCHEMA_LOCATION,
						Boolean.TRUE);
			}
			try {
				ASMEMFModel emfModel = (ASMEMFModel) model;
				emfModel.getExtent().save(serializationParameters);
			} catch (IOException e) {
				String message = "Unable to save the model \n" + e.getMessage();
				throw new QVTRealtionsExecutionException(message);
			}
		}
		return Collections.singletonList(result);
	}

	protected Object execute(final ASM qvtrTransformation,
			final List<ASMModel> linkedModels, final List<ASM> libraries,
			final Map<String, String> parameters, final Debugger debugger) throws QVTRealtionsExecutionException {

		ASMModule asmModule = new ASMModule(qvtrTransformation);

		/*
		 * Create an execution environment with the handled models
		 */
		ASMExecEnv env = new ASMExecEnv(asmModule, debugger, true);
		env.addPermission("file.read"); //$NON-NLS-1$
		env.addPermission("file.write"); //$NON-NLS-1$

		for (ASMModel model : linkedModels) {
			env.addModel(model.getMetamodel().getName(), model.getMetamodel());
			env.addModel(model.getName(), model);
		}
		env.registerOperations(qvtrTransformation);

		/*
		 * libraries overriding operations
		 */
		for (ASM asm : libraries) {
			env.registerOperations(asm);
		}

		/*
		 * Launch the interpretation of the compiler on the QVTR abstract syntax
		 * tree
		 */
		try {
			new ASMInterpreter(qvtrTransformation, asmModule, env, parameters);
		} catch (Exception e) {
			String message = "Problem interpreting the compiled transformation \n"+e.getMessage();
			throw new QVTRealtionsExecutionException(message);
		}

		return linkedModels.get(linkedModels.size() - 1);
	}
}
