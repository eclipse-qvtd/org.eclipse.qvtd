package org.eclipse.qvt.declarative.relations.atlvm;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.InvalidPropertiesFormatException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.m2m.atl.drivers.emf4atl.ASMEMFModel;
import org.eclipse.m2m.atl.engine.vm.ASM;
import org.eclipse.m2m.atl.engine.vm.ASMExecEnv;
import org.eclipse.m2m.atl.engine.vm.ASMInterpreter;
import org.eclipse.m2m.atl.engine.vm.ASMXMLReader;
import org.eclipse.m2m.atl.engine.vm.Debugger;
import org.eclipse.m2m.atl.engine.vm.SimpleDebugger;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMModule;
import org.eclipse.qvt.declarative.common.framework.service.Operation;
import org.eclipse.qvt.declarative.execution.ExecuteOperation;
import org.eclipse.qvt.declarative.execution.ExecutionContext;
import org.eclipse.qvt.declarative.execution.ExecutionProvider;
import org.eclipse.qvt.declarative.execution.LabelledModel;
import org.eclipse.qvt.declarative.relations.atlvm.utils.ASMEMFModelUtils;
import org.osgi.framework.Bundle;

public class ATLVMExecutor implements ExecutionProvider {

	private static final String DEFAULT_DEBUGGER_PROPERTIES_LOCATION = "resources/debugger.properties.xml"; //$NON-NLS-1$
	private static final Debugger DEFAULT_DEBUGGER;

	static {
		// start the static initializations
		DEFAULT_DEBUGGER = createDefaultDebugger();
	}

	// TODO: remove duplicate with ATLVM compiler
	/**
	 * Create a default debugger with the parameters stored in the corresponding
	 * configuration file
	 */
	private static Debugger createDefaultDebugger() {
		Bundle bundle = Activator.getDefault().getBundle();
		Properties debuggerProperties = new Properties();
		URL debuggerPropertiesURL = FileLocator.find(bundle, new Path(
				DEFAULT_DEBUGGER_PROPERTIES_LOCATION), Collections.EMPTY_MAP);
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

	public boolean provides(Operation operation) {
		if (operation instanceof ExecuteOperation) {
			try {
				ExecuteOperation executeOperation = (ExecuteOperation) operation;
				IPath abstractSyntaxTreePath = executeOperation.getSourceFile()
						.getLocation();
				String direction = executeOperation.getParameters()
						.getDirectionModel().getName();
				IFolder sourceFolder = executeOperation.getSourceFolder();
				IFolder buildFolder = executeOperation.getBuildFolder();

				IPath executablePath = ATLVMCompiler.getInstance()
						.getDefaultExecutablePath(abstractSyntaxTreePath,
								direction, sourceFolder, buildFolder);
				return executablePath.toFile().canRead();
			} catch (ClassCastException exception) {
				return false;
			}
		}
		return false;
	}

	// FIXME: libraries for overriding transformations
	public List<?> execute(IFile sourceFile, ExecutionContext parameters,
			IFolder sourceFolder, IFolder buildFolder) {

		IPath executablePath = ATLVMCompiler.getInstance()
				.getDefaultExecutablePath(sourceFile.getLocation(),
						parameters.getDirectionModel().getName(), sourceFolder,
						buildFolder);
		IFile executableFile = ResourcesPlugin.getWorkspace().getRoot()
				.getFileForLocation(executablePath);

		LabelledModel direction = parameters.getDirectionModel();
		String directionName = direction.getName();

		Map<String, String> transformationParameters = new HashMap<String, String>();
		transformationParameters.put("direction", directionName);

		List<ASMEMFModel> linkedModels = new ArrayList<ASMEMFModel>();
		try {
			for (LabelledModel namedModel : parameters.getSourceModels()) {
				linkedModels.add(ASMEMFModelUtils.getASMEMFModelFrom(
						namedModel, false));
			}
			LabelledModel directionNamedModel = parameters.getDirectionModel();
			linkedModels.add(ASMEMFModelUtils.getASMEMFModelFrom(
					directionNamedModel, true));
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			ASM qvtrTransformation = new ASMXMLReader().read(executableFile
					.getContents());
			Object result = execute(qvtrTransformation, linkedModels,
					Collections.EMPTY_LIST, transformationParameters,
					DEFAULT_DEBUGGER);
			return Collections.singletonList(result);

		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	protected Object execute(final ASM qvtrTransformation,
			final List<ASMEMFModel> linkedModels, final List<ASM> libraries,
			final Map<String, String> parameters, final Debugger debugger) {

		ASMModule asmModule = new ASMModule(qvtrTransformation);

		/*
		 * Create an execution environment with the handled models
		 */
		ASMExecEnv env = new ASMExecEnv(asmModule, debugger, true);
		env.addPermission("file.read"); //$NON-NLS-1$
		env.addPermission("file.write"); //$NON-NLS-1$

		for (ASMEMFModel model : linkedModels) {
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
			new ASMInterpreter(qvtrTransformation, asmModule, env,
					Collections.EMPTY_MAP);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return linkedModels.get(linkedModels.size() - 1);
	}

	// public <M> List<?> execute(IFile sourceFile,
	// ExecutionContext<M> parameters, IFolder sourceFolder,
	// IFolder buildFolder) {
	// // TODO Auto-generated method stub
	// return null;
	// }
}
