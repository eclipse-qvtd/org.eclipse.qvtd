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
import java.util.Set;

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
import org.eclipse.qvt.declarative.atlvm.problems.problems.Problem;
import org.eclipse.qvt.declarative.atlvm.problems.problems.ProblemsPackage;
import org.eclipse.qvt.declarative.common.framework.service.Operation;
import org.eclipse.qvt.declarative.compilation.CompilationProvider;
import org.eclipse.qvt.declarative.compilation.CompileOperation;
import org.eclipse.qvt.declarative.compilation.DeclarativeQVTCompilationException;
import org.eclipse.qvt.declarative.compilation.QVTRelationsCompilationException;
import org.eclipse.qvt.declarative.ecore.QVTRelation.RelationalTransformation;
import org.eclipse.qvt.declarative.relations.atlvm.utils.ASMEMFModelUtils;
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

	private static final String DEFAULT_DEBUGGER_PROPERTIES_LOCATION = "resources/debugger.properties.xml"; //$NON-NLS-1$

	private static final String DEFAULT_COMPILATION_PARAMETERS_LOCATION = "resources/compilation.parameters.xml"; //$NON-NLS-1$

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
	private static final ASMEMFModel PROBLEM_METAMODEL;

	private static final Debugger DEFAULT_DEBUGGER;

	private static final Properties DEFAULT_COMPILATION_PARAMETERS;

	private static final ATLVMCompiler instance = new ATLVMCompiler();

	static {
		// static initializations
		COMPILER_ASM = loadQVTRCompiler();
		PROBLEM_METAMODEL = ASMEMFModelUtils.getASMEMFModelFrom(
				ProblemsPackage.eINSTANCE, null);
		DEFAULT_DEBUGGER = createDefaultDebugger();
		DEFAULT_COMPILATION_PARAMETERS = loadDefaultCompilationProperties();
	}

	protected ATLVMCompiler() {

	}

	protected static ATLVMCompiler getInstance() {
		return instance;
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

	protected URI getPrefixURI(IFolder folder) {
		IPath path = folder.getLocation().addTrailingSeparator();
		return URI.createFileURI(path.toString());
	}

	protected IPath getDefaultExecutablePath(IPath abstractSyntaxTreePath,
			String direction, IFolder sourceFolder, IFolder buildFolder) {
		IPath sourceFolderPath = sourceFolder.getLocation();
		if (sourceFolderPath.isPrefixOf(abstractSyntaxTreePath)) {
			IPath relativeASTPath = abstractSyntaxTreePath
					.removeFirstSegments(sourceFolderPath.segmentCount());
			IPath relativeExecutablePath = relativeASTPath
					.removeFileExtension().addFileExtension(direction)
					.addFileExtension(EXECUTABLE_SUFFIX);
			IPath result = buildFolder.getLocation().append(
					relativeExecutablePath);
			return result;
		}
		return null;
	}

	protected String getDefaultExecutablePath(Resource abstractSyntaxTree,
			String direction, IFolder sourceFolder, IFolder buildFolder) {
		IPath abstractSyntaxTreePath = new Path(abstractSyntaxTree.getURI()
				.toFileString());
		return getDefaultExecutablePath(abstractSyntaxTreePath, direction,
				sourceFolder, buildFolder).toOSString();
	}

	protected ASMEMFModel createProblemModelFor(Resource abstractSyntaxTree)
			throws Exception {
		URI abstractSyntaxTreeURI = abstractSyntaxTree.getURI();
		String problemFileName = abstractSyntaxTreeURI.trimFileExtension()
				.appendFileExtension(PROBLEM_MODEL_FILE_EXTENSION).toString();
		return ASMEMFModel.newASMEMFModel(PROBLEM_MODEL_NAME, problemFileName,
				PROBLEM_METAMODEL, null);

	}

	protected Properties createCompilationsProperties(
			Resource abstractSyntaxTree, final Map<String, String> parameters,
			String direction, IFolder sourceFolder, IFolder buildFolder) {
		Properties effectiveParameters = new Properties();
		effectiveParameters.putAll(DEFAULT_COMPILATION_PARAMETERS);
		effectiveParameters.putAll(parameters);
		if (!effectiveParameters.containsKey(OUT_FILE_PARAMETER_NAME)) {
			String executablePath = getDefaultExecutablePath(
					abstractSyntaxTree, direction, sourceFolder, buildFolder);
			effectiveParameters.put(OUT_FILE_PARAMETER_NAME, executablePath);
		}
		return effectiveParameters;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.qvt.declarative.compilation.CompilationProvider#compile(java
	 * .lang.Object, java.util.Map, org.eclipse.core.resources.IFolder,
	 * org.eclipse.core.resources.IFolder)
	 */
	public List<IFile> compile(Object abstractSyntaxTree,
			Map<String, String> parameters, IFolder sourceFolder,
			IFolder buildFolder) throws DeclarativeQVTCompilationException {
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
			ASMEMFModel qvtrTransformation = ASMEMFModelUtils
					.getASMEMFModelFrom(abstractSyntaxTreeResource,
							TRANSFORMATION_MODEL_NAME);
			String directionDomainName = parameters
					.remove(DIRECTION_PARAMETER_NAME);
			ASM directionASM = ASMUtils
					.createDirectionLibrary(directionDomainName);

			ASMEMFModel myProblems = createProblemModelFor(abstractSyntaxTreeResource);

			Properties effectiveParameters = createCompilationsProperties(
					abstractSyntaxTreeResource, parameters,
					directionDomainName, sourceFolder, buildFolder);

			IFile resultFile = compile(qvtrTransformation, directionASM,
					myProblems, DEFAULT_DEBUGGER, effectiveParameters);

			Set<?> problemSet = myProblems.getElementsByType("Problem");
			for (Object object : problemSet) {
				if (object instanceof Problem) {
					Problem problem = (Problem) object;
					throw new QVTRelationsCompilationException(problem
							.getStartLine().intValue(), problem
							.getStartColumn().intValue(), problem
							.getEndColumn().intValue());
				}
			}

			return Collections.singletonList(resultFile);
		} catch (Exception e) {
			throw new IllegalArgumentException("Problem loading models");
		}
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
			Map<String, String> parameters = compileOperation.getParameters();
			boolean canHandleSource = source instanceof Resource;
			boolean canHandleDirection = parameters != null;

			if (canHandleSource && canHandleDirection) {
				Resource resource = (Resource) source;
				if (!resource.getContents().isEmpty()) {
					EObject object = resource.getContents().get(0);
					if (object instanceof RelationalTransformation) {
						RelationalTransformation relationalTransformation = (RelationalTransformation) object;
						String direction = compileOperation.getParameters()
								.get(DIRECTION_PARAMETER_NAME);
						canHandleDirection = relationalTransformation
								.getModelParameter(direction) != null;
					} else { // base object is not a relational transformation
						return false;
					}
				} else { // resource is empty
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
			e.printStackTrace();
			return null;
		}

		IPath resultPath = new Path(compilationParameters
				.getProperty(OUT_FILE_PARAMETER_NAME));
		return ResourcesPlugin.getWorkspace().getRoot().getFile(resultPath);
	}

}
