package org.eclipse.qvt.declarative.relations.atlvm;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InvalidPropertiesFormatException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.m2m.atl.drivers.emf4atl.ASMEMFModel;
import org.eclipse.m2m.atl.engine.vm.ASM;
import org.eclipse.m2m.atl.engine.vm.ASMExecEnv;
import org.eclipse.m2m.atl.engine.vm.ASMInterpreter;
import org.eclipse.m2m.atl.engine.vm.ASMXMLReader;
import org.eclipse.m2m.atl.engine.vm.Debugger;
import org.eclipse.m2m.atl.engine.vm.SimpleDebugger;
import org.eclipse.m2m.atl.engine.vm.nativelib.ASMModule;
import org.eclipse.qvt.declarative.atlvm.problems.problems.ProblemsPackage;
import org.eclipse.qvt.declarative.common.framework.service.Operation;
import org.eclipse.qvt.declarative.compilation.CompilationProvider;
import org.eclipse.qvt.declarative.compilation.CompileOperation;
import org.eclipse.qvt.declarative.ecore.QVTRelation.QVTRelationPackage;
import org.eclipse.qvt.declarative.ecore.QVTRelation.RelationalTransformation;
import org.eclipse.qvt.declarative.relations.atlvm.utils.ATLVMUtils;
import org.eclipse.qvt.declarative.relations.atlvm.utils.DirectionUtilies;
import org.osgi.framework.Bundle;

public class ATLVMCompiler implements CompilationProvider {

	private static final String COMPILER_ASM_LOCATION = "resources/QVTR.asm"; //$NON-NLS-1$

	private static final String DEFAULT_DEBUGGER_PROPERTIES_LOCATION = "resources/debugger.properties.xml"; //$NON-NLS-1$

	private static final String DEFAULT_COMPILATION_PARAMETERS_LOCATION = "resources/compilation.parameters.xml"; //$NON-NLS-1$

	protected static final String EXECUTABLE_SUFFIX = "asm"; //$NON-NLS-1$

	public static final String OUT_FILE_PARAMETER_NAME = "WriteTo"; //$NON-NLS-1$

	public static final String DIRECTION_PARAMETER_NAME = "direction"; //$NON-NLS-1$

	public static final String TRANSFORMATION_MODEL_NAME = "transformation"; //$NON-NLS-1$

	private static final String PROBLEM_MODEL_FILE_EXTENSION = "pbm.xmi"; //$NON-NLS-1$

	private static final String PROBLEM_MODEL_NAME = DIRECTION_PARAMETER_NAME
			+ "CompilationProblems";

	private static final ASM COMPILER_ASM;

	private static final ASMEMFModel QVTR_METAMODEL;

	/**
	 * The Problem metamodel. This is the way problems are reported during the
	 * compilation: instances of the Problem class are created inside a model.
	 * This model can be then interpreted to exhibit problems.
	 */
	private static final ASMEMFModel PROBLEM_METAMODEL;

	private static final Debugger DEFAULT_DEBUGGER;

	private static final Properties DEFAULT_COMPILATION_PARAMETERS;

	static {
		// start the static initializations
		COMPILER_ASM = loadQVTRCompiler();
		QVTR_METAMODEL = ATLVMUtils.loadModel(QVTRelationPackage.eINSTANCE);
		PROBLEM_METAMODEL = ATLVMUtils.loadModel(ProblemsPackage.eINSTANCE);
		DEFAULT_DEBUGGER = createDefaultDebugger();
		DEFAULT_COMPILATION_PARAMETERS = loadDefaultCompilationProperties();
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

	/**
	 * Load the default compilation properties.
	 */
	private static Properties loadDefaultCompilationProperties() {
		Bundle bundle = Activator.getDefault().getBundle();
		Properties compilationParameters = new Properties();
		URL compilationParametersUrl = FileLocator
				.find(bundle,
						new Path(DEFAULT_COMPILATION_PARAMETERS_LOCATION),
						Collections.EMPTY_MAP);
		try {
			compilationParameters.loadFromXML(compilationParametersUrl
					.openStream());
		} catch (InvalidPropertiesFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return compilationParameters;
	}
	
	protected URI getPrefixURI (IFolder folder) {
		IPath path = folder.getLocation().addTrailingSeparator();
		return URI.createFileURI(path.toString());
	}

	protected String getDefaultExecutablePath(Resource abstractSyntaxTree,
			IFolder sourceFolder, IFolder buildFolder) {
		URI sourceFolderURI = getPrefixURI(sourceFolder);
		URI buildFolderURI = getPrefixURI(buildFolder);

		URI executableURI = abstractSyntaxTree.getURI().replacePrefix(
				sourceFolderURI, buildFolderURI);
		executableURI = executableURI.trimFileExtension();
		executableURI = executableURI.appendFileExtension(EXECUTABLE_SUFFIX);
		return executableURI.toFileString();
	}

	protected ASMEMFModel loadQVTTransformation(Resource abstractSyntaxTree)
			throws Exception {
		return ASMEMFModel.loadASMEMFModel(TRANSFORMATION_MODEL_NAME,
				QVTR_METAMODEL, abstractSyntaxTree.getURI(), null); //$NON-NLS-1$
	}

	protected ASMEMFModel createProblemModel(Resource abstractSyntaxTree)
			throws Exception {
		URI abstractSyntaxTreeURI = abstractSyntaxTree.getURI();
		String problemFileName = abstractSyntaxTreeURI.trimFileExtension()
				.appendFileExtension(PROBLEM_MODEL_FILE_EXTENSION).toString();
		return ASMEMFModel.newASMEMFModel(PROBLEM_MODEL_NAME, problemFileName,
				PROBLEM_METAMODEL, null);

	}

	protected Properties createCompilationsProperties(
			Resource abstractSyntaxTree,
			final Map<String, String> parameters, IFolder sourceFolder,
			IFolder buildFolder) {
		String executablePath = getDefaultExecutablePath(
				abstractSyntaxTree, sourceFolder, buildFolder);
		Properties effectiveParameters = new Properties();
		effectiveParameters.putAll(DEFAULT_COMPILATION_PARAMETERS);
		effectiveParameters.putAll(parameters);
		effectiveParameters.put(OUT_FILE_PARAMETER_NAME, executablePath);
		return effectiveParameters;
	}

	public List<IFile> compile(Object abstractSyntaxTree,
			Map<String, String> parameters, IFolder sourceFolder,
			IFolder buildFolder) {
		if (!(abstractSyntaxTree instanceof Resource)) {
			throw new IllegalArgumentException(
					"Abstract Syntax is not in an EMF Resource form: "
							+ abstractSyntaxTree.toString());
		}
		if (!parameters.containsKey(DIRECTION_PARAMETER_NAME)) {
			throw new IllegalArgumentException(
					"No direction given in parameters: "
							+ parameters.toString());
		}
		Resource abstractSyntaxTreeResource = (Resource) abstractSyntaxTree;

		try {
			ASMEMFModel qvtrTransformation = loadQVTTransformation(abstractSyntaxTreeResource);

			String directionDomainName = parameters
					.remove(DIRECTION_PARAMETER_NAME);
			ASM directionASM = DirectionUtilies
					.createDirectionLibrary(directionDomainName);

			ASMEMFModel myProblems = createProblemModel(abstractSyntaxTreeResource);

			Properties effectiveParameters = createCompilationsProperties(
					abstractSyntaxTreeResource, parameters, sourceFolder,
					buildFolder);

			IFile resultFile = compile(qvtrTransformation, directionASM,
					myProblems, DEFAULT_DEBUGGER, effectiveParameters);

			return Collections.singletonList(resultFile);
		} catch (Exception e) {
			e.printStackTrace();
			throw new IllegalArgumentException("Problem loading models");
		}
	}

	public boolean provides(Operation operation) {
		if (operation instanceof CompileOperation) {
			CompileOperation compileOperation = (CompileOperation) operation;
			Object source = compileOperation.getSource();
			Map<String, String> parameters = compileOperation.getParameters();
			boolean canHandleSource = source instanceof Resource;
			boolean canHandleDirection = parameters != null;

			if (canHandleSource && canHandleDirection) {
				Resource resource = (Resource) source;
				if (! resource.getContents().isEmpty()) {
					EObject object = resource.getContents().get(0);
					if (object instanceof RelationalTransformation) {
						RelationalTransformation relationalTransformation = (RelationalTransformation) object;
						String direction = compileOperation.getParameters().get(DIRECTION_PARAMETER_NAME);
						canHandleDirection = relationalTransformation.getModelParameter(direction) != null  ;
					} else { //base object is not a relational transformation
						return false;
					}
				}
				else { //resource is empty
					return false;
				}
			}
			return canHandleSource && canHandleDirection;
		}
		return false;
	}

	protected IFile compile(final ASMEMFModel qvtrTransformation,
			final ASM directionLibary, final ASMEMFModel myProblems,
			final Debugger debugger, final Properties compilationParameters) {

		ASMModule asmModule = new ASMModule(COMPILER_ASM);

		/*
		 * Create an execution environment with the handled models
		 */
		ASMExecEnv env = new ASMExecEnv(asmModule, debugger, true);
		env.addPermission("file.read"); //$NON-NLS-1$
		env.addPermission("file.write"); //$NON-NLS-1$

		env.addModel("QVTR", QVTR_METAMODEL); //$NON-NLS-1$
		env.addModel("IN", qvtrTransformation); //$NON-NLS-1$
		env.addModel("Problem", PROBLEM_METAMODEL); //$NON-NLS-1$
		env.addModel("OUT", myProblems); //$NON-NLS-1$
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
			e.printStackTrace();
			return null;
		}

		IPath resultPath = new Path(compilationParameters
				.getProperty(OUT_FILE_PARAMETER_NAME));
		return ResourcesPlugin.getWorkspace().getRoot().getFile(resultPath);
	}

}
