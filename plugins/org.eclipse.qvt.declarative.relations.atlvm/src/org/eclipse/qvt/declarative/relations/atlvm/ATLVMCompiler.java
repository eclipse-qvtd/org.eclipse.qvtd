package org.eclipse.qvt.declarative.relations.atlvm;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InvalidPropertiesFormatException;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
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
import org.eclipse.qvt.declarative.ecore.QVTBase.TypedModel;
import org.eclipse.qvt.declarative.ecore.QVTRelation.RelationalTransformation;
import org.eclipse.qvt.declarative.relations.atlvm.runner.ATLVMCodeJavaRunnerWriter;
import org.eclipse.qvt.declarative.relations.atlvm.runner.ATLVMCodeJavaRunnerWriterParameters;
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

	private static final String DEFAULT_DEBUGGER_PROPERTIES_LOCATION = "debugger.properties.xml"; //$NON-NLS-1$

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

	static {
		// static initializations
		COMPILER_ASM = loadQVTRCompiler();
		PROBLEM_METAMODEL = ASMEMFModelUtils.getASMEMFModelFrom(
				ProblemsPackage.eINSTANCE, null);
		DEFAULT_DEBUGGER = createDefaultDebugger();
		DEFAULT_COMPILATION_PARAMETERS = loadDefaultCompilationProperties();
	}

	/**
	 * Construct a new compiler producing ATLVM byte code from a QVT Relations
	 * source
	 */
	public ATLVMCompiler() {

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

	protected String getDefaultExecutablePath(
			URI relativeAbstractSyntaxTreeURI, String direction,
			URI binFolderURI) {

		URI result = relativeAbstractSyntaxTreeURI.resolve(binFolderURI);
		result = result.trimFileExtension().appendFileExtension(direction)
				.appendFileExtension(EXECUTABLE_SUFFIX);
		return result.toFileString();
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
			URI relativeAbstractSyntaxTreeURI,
			final Map<String, String> parameters, String direction,
			URI binFolderURI) {
		Properties effectiveParameters = new Properties();
		effectiveParameters.putAll(DEFAULT_COMPILATION_PARAMETERS);
		effectiveParameters.putAll(parameters);

		if (!effectiveParameters.containsKey(OUT_FILE_PARAMETER_NAME)) {
			String executablePath = getDefaultExecutablePath(
					relativeAbstractSyntaxTreeURI, direction, binFolderURI);
			effectiveParameters.put(OUT_FILE_PARAMETER_NAME, executablePath);
		}
		return effectiveParameters;
	}

	protected URI[] getSplittedSourceURI(List<File> sourceFolders,
			File sourceFile) {
		URI sourceFileURI = URI.createFileURI(sourceFile.getAbsolutePath());
		URI currentFolderURI = URI.createURI("./");
		URI relativeURI = null;
		for (File folder : sourceFolders) {
			URI folderURI = URI.createFileURI(folder.getAbsolutePath())
					.appendSegment("");
			relativeURI = sourceFileURI.replacePrefix(folderURI,
					currentFolderURI);
			if (relativeURI != null) {
				return new URI[] { folderURI, relativeURI };
			}
		}
		return new URI[] { null, null };
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
			Map<String, String> parameters, List<File> sourceFolders,
			File binFolder) throws DeclarativeQVTCompilationException {
		if (!(abstractSyntaxTree instanceof File)) {
			throw new IllegalArgumentException(
					"Abstract Syntax is not a file: "
							+ abstractSyntaxTree.toString());
		}

		File abstractSyntaxTreeFile = (File) abstractSyntaxTree;
		URI[] splittedSourceURI = getSplittedSourceURI(sourceFolders,
				abstractSyntaxTreeFile);
		URI sourceFolderURI = splittedSourceURI[0];
		URI relativeAbstractSyntaxTreeURI = splittedSourceURI[1];

		if (sourceFolderURI != null && relativeAbstractSyntaxTreeURI != null) {

			URI binFolderURI = URI.createFileURI(binFolder.getAbsolutePath())
					.appendSegment("");
			URI abstractSyntaxTreeURI = URI
					.createFileURI(abstractSyntaxTreeFile.getAbsolutePath());

			ResourceSet resourceSet = new ResourceSetImpl();
			Resource abstractSyntaxTreeResource = resourceSet
					.createResource(abstractSyntaxTreeURI);

			try {
				ASMEMFModel qvtrTransformation = ASMEMFModelUtils
						.getASMEMFModelFrom(abstractSyntaxTreeResource,
								TRANSFORMATION_MODEL_NAME);

				List<String> directions = getDirections(abstractSyntaxTreeResource);

				List<File> result = new ArrayList<File>(directions.size());
				for (String directionDomainName : directions) {
					ASM directionASM = ASMUtils
							.createDirectionLibrary(directionDomainName);
					ASMEMFModel myProblems = createProblemModelFor(abstractSyntaxTreeResource);
					Properties effectiveParameters = createCompilationsProperties(
							relativeAbstractSyntaxTreeURI, parameters,
							directionDomainName, binFolderURI);

					File resultFile = compile(qvtrTransformation, directionASM,
							myProblems, DEFAULT_DEBUGGER, effectiveParameters);
					result.add(resultFile);
					handleProblems(myProblems);
				}
//				createJavaLauncher(abstractSyntaxTreeResource, sourceFolderURI);

				return result;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	protected List<String> getDirections(Resource resource) {
		List<String> result = new ArrayList<String>();
		List<EObject> contents = resource.getContents();
		if (!contents.isEmpty()) {
			if (contents.get(0) instanceof RelationalTransformation) {
				RelationalTransformation relationalTransformation = (RelationalTransformation) contents
						.get(0);
				for (TypedModel typedModel : relationalTransformation
						.getModelParameter()) {
					result.add(typedModel.getName());
				}
				return result;
			}
		}
		return null;
	}

	protected void handleProblems(ASMEMFModel problems)
			throws QVTRelationsCompilationException {
		Set<?> problemSet = problems.getElementsByType("Problem");
		for (Object object : problemSet) {
			if (object instanceof Problem) {
				Problem problem = (Problem) object;
				int startLine = problem.getStartLine().intValue();
				int startColumn = problem.getStartColumn().intValue();
				int endColumn = problem.getEndColumn().intValue();
				throw new QVTRelationsCompilationException(startLine,
						startColumn, endColumn);
			}
		}
	}

	protected void createJavaLauncher(Resource abstractSyntaxTreeResource,
			URI sourceFolderURI) throws IOException {
		String javaLoaderSourcePath = abstractSyntaxTreeResource.getURI()
				.trimSegments(1).appendSegment(
						getClassName(abstractSyntaxTreeResource))
				.appendFileExtension("java").toFileString();
		File javaLoaderSourceFile = new File(javaLoaderSourcePath);
		javaLoaderSourceFile.createNewFile();
		BufferedWriter writer = new BufferedWriter(new FileWriter(
				javaLoaderSourceFile));
		ATLVMCodeJavaRunnerWriterParameters writerParameters = new ATLVMCodeJavaRunnerWriterParameters(
				abstractSyntaxTreeResource, sourceFolderURI);
		ATLVMCodeJavaRunnerWriter javaRunnerWriter = new ATLVMCodeJavaRunnerWriter();
		String content = javaRunnerWriter.generate(writerParameters);
		writer.write(content);
		writer.close();
	}

	protected RelationalTransformation getTransformation(Resource resource) {
		EObject eObject = resource.getContents().get(0);
		if (eObject instanceof RelationalTransformation) {
			return (RelationalTransformation) eObject;
		}
		return null;
	}

	protected String getClassName(Resource abstractSyntaxTreeResource) {
		RelationalTransformation transformation = getTransformation(abstractSyntaxTreeResource);
		String unformatedName = transformation.getName();
		return unformatedName.substring(0, 1).toUpperCase()
				+ unformatedName.substring(1);
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
			if (source instanceof File
					&& compileOperation.getSourceFolders() != null
					&& compileOperation.getBinFolder() != null) {
				File sourceFile = (File) source;
				boolean canHandleSource = sourceFile.canRead()
						&& sourceFile.isFile();
				if (canHandleSource) {
					URI sourceURI = URI.createFileURI(sourceFile.getPath());
					ResourceSet resourceSet = new ResourceSetImpl();
					Resource resource = resourceSet
							.getResource(sourceURI, true);
					if (!resource.getContents().isEmpty()) {
						EObject eObject = resource.getContents().get(0);
						canHandleSource = eObject instanceof RelationalTransformation;
					} else { // resource is empty
						canHandleSource = false;
					}
					resource.unload();
				}
				return canHandleSource;
			}
		}
		return false;
	}

	protected File compile(final ASMEMFModel qvtrTransformation,
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

		File resultFile = new File(compilationParameters
				.getProperty(OUT_FILE_PARAMETER_NAME));
		return resultFile;
	}

}
