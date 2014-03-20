package org.eclipse.qvtd.debug.launching;

import java.io.IOException;
import java.util.Map;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.debug.evaluator.VMRuntimeException;
import org.eclipse.ocl.examples.debug.messages.EvaluationMessages;
import org.eclipse.ocl.examples.debug.stubs.EmfUtil;
import org.eclipse.ocl.examples.debug.stubs.ExecutionDiagnostic;
import org.eclipse.ocl.examples.debug.stubs.ExecutionDiagnosticImpl;
import org.eclipse.ocl.examples.debug.stubs.Messages;
import org.eclipse.ocl.examples.debug.stubs.VMException;
import org.eclipse.ocl.examples.debug.stubs.VMInterruptedExecutionException;
import org.eclipse.ocl.examples.debug.stubs.QvtOperationalStdLibrary;
import org.eclipse.ocl.examples.debug.stubs.VMStackOverFlowError;
import org.eclipse.ocl.examples.debug.utils.CompiledUnit;
import org.eclipse.ocl.examples.debug.utils.Log;
import org.eclipse.ocl.examples.debug.utils.Trace;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.pivot.utilities.PivotEnvironmentFactory;
import org.eclipse.osgi.util.NLS;
import org.eclipse.qvtd.debug.core.QVTiEvaluationContext;
import org.eclipse.qvtd.debug.stubs.ModelExtent;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEnvironmentFactory;
import org.eclipse.qvtd.xtext.qvtimperative.utilities.QVTiXtextEvaluator;

/**
 * Internal transformation executor
 * 
 * @since 3.0
 */
public abstract class InternalDebuggableExecutor
{
	protected final @NonNull PivotEnvironmentFactory envFactory;
	protected final @NonNull URI debuggableURI;
//	private EPackage.Registry fPackageRegistry;
	private @Nullable CompiledUnit fCompiledUnit;
	private ResourceSet fCompilationRs;
	private ExecutionDiagnosticImpl fLoadDiagnostic;
//	private Transformation fTransformation;
	private @Nullable QVTiXtextEvaluator xtextEvaluator;

	/**
	 * Constructs the executor for the given transformation URI.
	 * <p>
	 * No attempt to resolve and load the transformation is done at this step
	 * 
	 * @param uri
	 *            the URI of an existing transformation
	 */
	public InternalDebuggableExecutor(@NonNull PivotEnvironmentFactory envFactory, @NonNull URI debuggableURI) {
		this.envFactory = envFactory;
		this.debuggableURI = debuggableURI;
	}

	public QVTiXtextEvaluator getEvaluator() {
		return xtextEvaluator;
	}
	
	public @NonNull URI getURI() {
		return debuggableURI;
	}
	
	public ResourceSet getResourceSet() {
		return fCompilationRs;
	}
		
//	public InternalTransformationExecutor(@NonNull EvaluationContext evaluationContext, EPackage.Registry registry) {
//		this(evaluationContext);
		
//		if (registry == null) {
//			throw new IllegalArgumentException("null package registry"); //$NON-NLS-1$
//		}
		
//		fPackageRegistry = registry;
//	}	
			
	/**
	 * Attempts to load the transformation referred by this executor and checks
	 * if it is valid for execution.
	 * <p>
	 * <b>Remark:</b></br> Only the first performs the actual transformation
	 * loading, subsequent calls to this method will return the existing
	 * diagnostic.
	 * 
	 * @return the diagnostic indicating possible problems of the load action
	 */
	public Diagnostic loadTransformation() {

		if (fLoadDiagnostic == null) {
			doLoad();
		}
		return fLoadDiagnostic;
	}
	
	/**
	 * Retrieves compiled unit if the referencing URI gets successfully resolved
	 * <p>
	 * <b>Remark</b>: This method invocation causes the referenced transformation to
	 * load if not already done before by direct call to
	 * {@linkplain #loadTransformation()} or
	 * {@linkplain #execute(ExecutionContext, ModelExtent...)}
	 * 
	 * @return compiled unit or <code>null</code> if it failed to be obtained
	 */
	public @Nullable CompiledUnit getUnit() {
		loadTransformation();
		return fCompiledUnit;
	}	

	/**
	 * Executes the transformation referred by this executor using the given
	 * model parameters and execution context.
	 * 
	 * @param executionContext
	 *            the context object keeping the execution environment details
	 * @param modelParameters
	 *            the actual model arguments to the transformation
	 * 
	 * @return the diagnostic object indicating the execution result status,
	 *         also keeping the details of possible problems
	 * @throws IllegalArgumentException
	 *             if the context or any of the model parameters is
	 *             <code>null</code>
	 */
	public ExecutionDiagnostic execute(@NonNull QVTiEvaluationContext evaluationContext/*, ModelExtent... modelParameters*/) {
//		checkLegalModelParams(modelParameters);

		// ensure transformation unit is loaded
		loadTransformation();

		// check if we have successfully loaded the transformation unit
		if (!isSuccess(fLoadDiagnostic)) {
			return fLoadDiagnostic;
		}

		try {
			return doExecute(/*modelParameters,*/ createInternalContext(evaluationContext));
		} catch (VMRuntimeException e) {
			Log logger = evaluationContext.getLog();
			if (logger != null) {
				logger.log(EvaluationMessages.TerminatingExecution);
			}
			return createExecutionFailure(e);
		} catch (Exception e) {
			Log logger = evaluationContext.getLog();
			if (logger != null) {
				logger.log(EvaluationMessages.TerminatingExecution);
			}
			return createExecutionFailure(new VMRuntimeException(e));
		}
	}

	private ExecutionDiagnostic doExecute(/*ModelExtent[] args,*/ @NonNull QVTiEvaluationContext evaluationContext) throws IOException {
//		QvtOperationalEnvFactory factory = getEnvironmentFactory();
//		QVTiXtextEvaluator evaluator = null; //evaluationContext.getEvaluator();
		
		
//		ExecutionDiagnostic modelParamsDiagnostic = initArguments(evaluationEnv, fTransformation, args);
//		if (modelParamsDiagnostic.getSeverity() != Diagnostic.OK) {
//			return modelParamsDiagnostic;
//		}

//		QvtOperationalFileEnv rootEnv = factory.createEnvironment(fCompiledUnit.getURI());
//		EvaluationVisitor<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> evaluator = factory
//				.createEvaluationVisitor(rootEnv, evaluationEnv, null);

		// perform the actual execution
//		assert evaluator instanceof InternalEvaluator : "expecting InternalEvaluator implementation"; //$NON-NLS-1$
//		InternalEvaluator rawEvaluator = (InternalEvaluator) evaluator;

		QVTiXtextEvaluator xtextEvaluator2 = xtextEvaluator;
		if (xtextEvaluator2 != null) {
			xtextEvaluator2.execute();
		}

		// unpack the internal extents into the passed model parameters
/*		List<Object> resultArgs = evaluationEnv.getOperationArgs();
		int i = 0;
		for (Object nextResultArg : resultArgs) {
			ModelInstance modelInstance = (ModelInstance) nextResultArg;
			ModelParameterExtent extent = modelInstance.getExtent();

			List<EObject> allRootElements = extent.getContents().getAllRootElements();
			try {
				args[i++].setContents(allRootElements);
			} catch (UnsupportedOperationException e) {
				return new ExecutionDiagnosticImpl(Diagnostic.ERROR,
						ExecutionDiagnostic.MODEL_PARAMETER_MISMATCH, NLS
								.bind(Messages.ReadOnlyExtentModificationError,
										i - 1));
			}
		} */

		// do some handy processing with traces
//		Trace traces = evaluationEnv.getAdapter(InternalEvaluationEnv.class).getTraces();
//		handleExecutionTraces(traces);
		
		return ExecutionDiagnostic.OK_INSTANCE;
	}

	public @NonNull PivotEnvironmentFactory getEnvFactory() {
		return envFactory;
	}
	
	protected void handleExecutionTraces(Trace traces) {
		// nothing interesting here
	}

	private void doLoad() {
		fLoadDiagnostic = ExecutionDiagnosticImpl.OK_INSTANCE;
		try {
			QVTiXtextEvaluator xtextEvaluator2 = createEvaluator();
			xtextEvaluator = xtextEvaluator2;
			fCompiledUnit = new CompiledUnit(xtextEvaluator2.getTransformation());
		} catch (Exception e) {
			fLoadDiagnostic = new ExecutionDiagnosticImpl(Diagnostic.ERROR,
					ExecutionDiagnostic.TRANSFORMATION_LOAD_FAILED, NLS.bind(
							Messages.FailedToCompileUnitError, debuggableURI));
	
			fLoadDiagnostic.merge(BasicDiagnostic.toDiagnostic(e));
		}
/*		UnitProxy unit = UnitResolverFactory.Registry.INSTANCE.getUnit(fURI);
		if (unit == null) {
			fLoadDiagnostic = new ExecutionDiagnosticImpl(Diagnostic.ERROR,
					ExecutionDiagnostic.TRANSFORMATION_LOAD_FAILED, NLS.bind(
							Messages.UnitNotFoundError, fURI));
			return;
		}

		QVTOCompiler compiler = createCompiler();
		try {
			fCompiledUnit = compiler.compile(unit, null, null);
			fCompilationRs = compiler.getResourceSet();
		//	fCompilerKernel = compiler.getKernel();

			fLoadDiagnostic = createCompilationDiagnostic(fCompiledUnit);

		} catch (MdaException e) {
			fLoadDiagnostic = new ExecutionDiagnosticImpl(Diagnostic.ERROR,
					ExecutionDiagnostic.TRANSFORMATION_LOAD_FAILED, NLS.bind(
							Messages.FailedToCompileUnitError, fURI));

			fLoadDiagnostic.merge(BasicDiagnostic.toDiagnostic(e));
		}

		if (fCompiledUnit != null
				&& fLoadDiagnostic.getSeverity() == Diagnostic.OK) {
			fTransformation = getTransformation();
			if (fTransformation == null) {
				fLoadDiagnostic = new ExecutionDiagnosticImpl(Diagnostic.ERROR,
						ExecutionDiagnostic.TRANSFORMATION_LOAD_FAILED, NLS
								.bind(Messages.NotTransformationInUnitError,
										fURI));
				return;
			}

			ExecutionDiagnosticImpl validForExecution = checkIsExecutable(fTransformation);
			if (validForExecution.getSeverity() != Diagnostic.OK) {
				fLoadDiagnostic = validForExecution;
			}
		} */
	}

	protected abstract @NonNull QVTiXtextEvaluator createEvaluator() throws IOException;

/*	private ExecutionDiagnostic initArguments(
			QvtOperationalEvaluationEnv evalEnv,
			OperationalTransformation transformationModel, ModelExtent[] args) {

		EList<ModelParameter> modelParameters = transformationModel.getModelParameter();
		if (modelParameters.size() != args.length) {
			return new ExecutionDiagnosticImpl(Diagnostic.ERROR,
					ExecutionDiagnostic.MODEL_PARAMETER_MISMATCH, NLS.bind(
							Messages.InvalidModelParameterCountError,
							args.length, modelParameters.size()));
		}

		ExecutionDiagnostic result = ExecutionDiagnostic.OK_INSTANCE;
		List<ModelParameterExtent> extents = new ArrayList<ModelParameterExtent>(
				args.length);

		int argCount = 0;
		for (ModelParameter modelParam : modelParameters) {
			ModelParameterExtent nextExtent;
			ModelExtent nextArg = args[argCount++];

			if (modelParam.getKind() != DirectionKind.OUT) {
				nextExtent = new ModelParameterExtent(nextArg.getContents(), getResourceSet(), modelParam);
			} else {
				nextExtent = new ModelParameterExtent(getResourceSet());
			}

			extents.add(nextExtent);
		}

		List<ModelInstance> modelArgs = ModelParameterHelper
				.createModelArguments(transformationModel, extents);
		evalEnv.getOperationArgs().addAll(modelArgs);

		return result;
	} */

/*	private static ExecutionDiagnosticImpl checkIsExecutable(OperationalTransformation transformation) {
		EList<EOperation> operations = transformation.getEOperations();
		for (EOperation oper : operations) {
			if (oper instanceof ImperativeOperation
					&& QvtOperationalEnv.MAIN.equals(oper.getName())) {
				return ExecutionDiagnosticImpl.OK_INSTANCE;
			}
		}

		return new ExecutionDiagnosticImpl(Diagnostic.ERROR,
				ExecutionDiagnostic.VALIDATION, NLS.bind(
						Messages.NoTransformationEntryPointError,
						transformation.getName()));
	} */

	public Transformation getTransformation() {
		// TODO - cached the transformation selected as main
//		if (fCompiledUnit == null) {
//			return null;
//		}
		
//		List<Module> allModules = fCompiledUnit.getModules();
//		for (Module module : allModules) {
//			if (module instanceof OperationalTransformation) {
//				return (OperationalTransformation) module;
//			}
//		}

		QVTiXtextEvaluator xtextEvaluator2 = xtextEvaluator;
		return xtextEvaluator2 != null ? xtextEvaluator2.getTransformation() : null;
	}
	
//	public void setEnvironmentFactory(QvtOperationalEnvFactory factory) {
//		fEnvFactory = factory;
//	}

//	protected QvtOperationalEnvFactory getEnvironmentFactory() {
//		return fEnvFactory != null ? fEnvFactory : new QvtOperationalEnvFactory();
//	}
	
	public void cleanup() {
//		setEnvironmentFactory(null);
		if (fCompilationRs != null) {
			EmfUtil.cleanupResourceSet(fCompilationRs);
		}
	}


	private static ExecutionDiagnostic createExecutionFailure(VMRuntimeException qvtRuntimeException) {
		int code = 0;
		int severity = Diagnostic.ERROR;
		String message = qvtRuntimeException.getLocalizedMessage();
		Object[] data = null;

		if (qvtRuntimeException instanceof VMException) {
			code = ((VMException) qvtRuntimeException).getExceptionType() == QvtOperationalStdLibrary.INSTANCE.getAssertionFailedClass() ?
					ExecutionDiagnostic.FATAL_ASSERTION : ExecutionDiagnostic.EXCEPTION_THROWN;
		} else if (qvtRuntimeException instanceof VMInterruptedExecutionException) {
			code = ExecutionDiagnostic.USER_INTERRUPTED;
			severity = Diagnostic.CANCEL;
		} else {
			code = ExecutionDiagnostic.EXCEPTION_THROWN;
			if (qvtRuntimeException instanceof VMStackOverFlowError == false) {
				Throwable cause = qvtRuntimeException.getCause();
				data = new Object[] { cause != null ? cause : qvtRuntimeException };
			} else {
				message = Messages.StackTraceOverFlowError;
			}
		}

		if (message == null) {
			message = NLS.bind(Messages.QVTRuntimeExceptionCaught,
					qvtRuntimeException.getClass().getName());
		}
		ExecutionDiagnosticImpl diagnostic = new ExecutionDiagnosticImpl(severity, code, message, data);
		diagnostic.setStackTrace(qvtRuntimeException.getQvtStackTrace());
		return diagnostic;
	}

/*	private void checkLegalModelParams(ModelExtent[] extents)
			throws IllegalArgumentException {
		if (extents == null) {
			throw new IllegalArgumentException("Null model parameters"); //$NON-NLS-1$
		}

		for (int i = 0; i < extents.length; i++) {
			if (extents[i] == null) {
				throw new IllegalArgumentException(
						"Null model parameter[" + i + "]"); //$NON-NLS-1$ //$NON-NLS-2$
			}
		}
	} */

/*	private static ExecutionDiagnosticImpl createCompilationDiagnostic(
			CompiledUnit compiledUnit) {
		List<QvtMessage> errors = compiledUnit.getErrors();
		if (errors.isEmpty()) {
			return ExecutionDiagnosticImpl.OK_INSTANCE;
		}

		URI uri = compiledUnit.getURI();
		ExecutionDiagnosticImpl mainDiagnostic = new ExecutionDiagnosticImpl(
				Diagnostic.ERROR, ExecutionDiagnostic.VALIDATION, NLS.bind(
						Messages.CompilationErrorsFoundInUnit, uri.toString()));

		for (QvtMessage message : errors) {
			// FIXME - we should include warnings as well
			mainDiagnostic.add(CompilerUtils.createProblemDiagnostic(uri, message));
		}

		return mainDiagnostic;
	} */

	private static boolean isSuccess(Diagnostic diagnostic) {
		int severity = diagnostic.getSeverity();
		return severity == Diagnostic.OK || severity == Diagnostic.WARNING
				|| severity == Diagnostic.INFO;
	}

	private static @NonNull QVTiEvaluationContext createInternalContext(@NonNull QVTiEvaluationContext evaluationContext) {
		QVTiEvaluationContext ctx = evaluationContext; //new Context();
//		ctx.setLog(xtextEvaluator.getLog());
//		ctx.setMonitor(xtextEvaluator.getMonitor());

//		for (String key : xtextEvaluator.getConfigPropertyNames()) {
//			String value = xtextEvaluator.getConfigProperty(key);
//			ctx.setConfigProperty(key, value);
//		}

		return ctx;
	}

	@Override
	public String toString() {
		return "QVTO-Executor: " + debuggableURI; //$NON-NLS-1$
	}
	
/*	private QVTOCompiler createCompiler() {
		if(fPackageRegistry == null) {
			return CompilerUtils.createCompiler();
		}
		
		return QVTOCompiler.createCompiler(fPackageRegistry);
	} */

}
