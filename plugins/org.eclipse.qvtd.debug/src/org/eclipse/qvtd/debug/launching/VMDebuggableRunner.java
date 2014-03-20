package org.eclipse.qvtd.debug.launching;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.debug.stubs.ExecutionDiagnostic;
import org.eclipse.ocl.examples.debug.stubs.QVTODebugUtil;
import org.eclipse.ocl.examples.debug.utils.CompiledUnit;
import org.eclipse.ocl.examples.debug.utils.IVMStackTraceElement;
import org.eclipse.ocl.examples.debug.vm.DebuggableExecutorAdapter;
import org.eclipse.ocl.examples.debug.vm.IVMDebuggerShell;
import org.eclipse.ocl.examples.pivot.utilities.PivotEnvironmentFactory;
import org.eclipse.qvtd.debug.core.QVTiEvaluationContext;
import org.eclipse.qvtd.debug.evaluator.QVTiVMEnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEnvironmentFactory;

public class VMDebuggableRunner extends DebuggableRunner
{
	private IVMDebuggerShell fDebugShell;
	private PrintWriter fErrorLog;
	
	public VMDebuggableRunner(@NonNull QVTiEvaluationContext evaluationContext, @NonNull QVTiEnvironmentFactory envFactory) {
		super(evaluationContext, envFactory);
		
		fErrorLog = new PrintWriter(new OutputStream() {
			@Override
			public void write(int b) throws IOException {
				// do nothing I'm a <null> log
			}
		}, true);
	}
	
	public void setErrorLog(PrintWriter errorLog) {
		if(errorLog == null) {
			throw new IllegalArgumentException();
		}
		this.fErrorLog = errorLog;
	}
	
//	@Override
//	protected  @NonNull QVTiEnvironmentFactory getEnvFactory() {
//		if (fDebugShell != null) {
//			return new DebugQVTiEnvironmentFactory(null, fDebugShell);
//		}
//		return super.getEnvFactory();
//	}
	
	@Override
	protected void handleLoadExtents(Diagnostic diagnostic) {
	}
	
	@Override
	protected void handleLoadTransformation(Diagnostic diagnostic) {
	}
	
	protected void handleExecution(ExecutionDiagnostic execDiagnostic) {
		List<IVMStackTraceElement> stackTrace = execDiagnostic.getStackTrace();
		if(stackTrace != null && execDiagnostic.getCode() != ExecutionDiagnostic.USER_INTERRUPTED) {
			fErrorLog.println(execDiagnostic);
			
			if (!stackTrace.isEmpty()) {
				fErrorLog.println("[QVTO Stack trace:]");				
				execDiagnostic.printStackTrace(fErrorLog);
				fErrorLog.println();
			}
		}
		
		if(execDiagnostic.getException() != null) {
			fErrorLog.println("[Java cause:]");
			execDiagnostic.getException().printStackTrace(fErrorLog);
		}
		
		fErrorLog.flush();
	}	
	
	@Override
	protected void handleSaveExtents(Diagnostic diagnostic) {
		
	}

	@Override
	public Diagnostic initialize() {
		PivotEnvironmentFactory envFactory = getEnvFactory();
		if (envFactory instanceof QVTiVMEnvironmentFactory) {
			((QVTiVMEnvironmentFactory)envFactory).setShell(fDebugShell);
		}
		return super.initialize();
	}

	public @NonNull DebuggableExecutorAdapter createDebugableAdapter(final @NonNull QVTiEvaluationContext evaluationContext) {
		
		return new DebuggableExecutorAdapter() {
			public Diagnostic execute() throws IllegalStateException {
				if(fDebugShell == null) {
					throw new IllegalStateException("Executor not connected to debugger"); //$NON-NLS-1$
				}

				CompiledUnit mainUnit = VMDebuggableRunner.this.getExecutor().getUnit();
				if (mainUnit != null) {
					QVTODebugUtil.attachEnvironment(mainUnit);
				}
				
				Diagnostic execDiagnostic = VMDebuggableRunner.this.execute(evaluationContext);
				
				if(execDiagnostic.getSeverity() != Diagnostic.OK) {
					fErrorLog.println(execDiagnostic);
				}

				return execDiagnostic;
			}

			public @Nullable CompiledUnit getUnit() {
				return getExecutor().getUnit();
			}
			
			public void connect(@NonNull IVMDebuggerShell debugShell) {
				fDebugShell = debugShell;			
			}			
		};
	}
}
