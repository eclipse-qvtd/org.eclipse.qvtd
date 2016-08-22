package org.eclipse.qvtd.compiler;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.compiler.CompilerProblem;

public abstract class AbstractCompilerProblem implements CompilerProblem
{
	protected final @NonNull Severity severity;

	protected AbstractCompilerProblem(@NonNull Severity severity) {
		this.severity = severity;
	}

	@Override
	public @NonNull Severity getSeverity() {
		return severity;
	}
}
