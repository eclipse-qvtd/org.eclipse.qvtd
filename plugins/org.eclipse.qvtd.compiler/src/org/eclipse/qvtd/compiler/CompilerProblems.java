/*******************************************************************************
 * Copyright (c) 2016, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation based on MtcBroker
 ******************************************************************************/
package org.eclipse.qvtd.compiler;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.utilities.PivotUtil;

/**
 * CompilerProblems accumulates problems during the execution of a transformation and
 * throws a CompilerChainException on completion of the transfoemation.
 */
public class CompilerProblems
{
	private /*@LazyNonNull*/ List<@NonNull CompilerProblem> errors = null;
	private /*@LazyNonNull*/ List<@NonNull CompilerProblem> infos = null;
	private /*@LazyNonNull*/ List<@NonNull CompilerProblem> warnings = null;

	public void addProblem(@NonNull CompilerProblem problem) {
		List<@NonNull CompilerProblem> problems = null;
		switch (problem.getSeverity()) {
			case ERROR: {
				if (errors == null) {
					errors = new ArrayList<>();
				}
				problems = errors;
				PivotUtil.errPrintln(String.valueOf(problem));
				break;
			}
			case INFO: {
				if (infos == null) {
					infos = new ArrayList<>();
				}
				problems = infos;
				System.out.println(problem);
				break;
			}
			case WARNING: {
				if (warnings == null) {
					warnings = new ArrayList<>();
				}
				problems = warnings;
				System.out.println(problem);
				break;
			}
		}
		assert problems != null;
		problems.add(problem);
	}

	public void throwCompilerChainExceptionForErrors() throws CompilerChainException {
		if (errors != null) {
			StringBuilder s = new StringBuilder();
			for (@NonNull CompilerProblem error : errors) {
				s.append("\n" + error);
			}
			throw new CompilerChainException("{0}", s.toString());
		}
		if (warnings != null) {
			for (CompilerProblem warning : warnings) {
				PivotUtil.errPrintln(String.valueOf(warning));
			}
			//	throw new CompilerChainException("{0}", String.valueOf(warnings));
		}
	}

	/*	public void throwCompilerChainExceptionForWarnings() throws CompilerChainException {
		if (errors != null) {
			throw new CompilerChainException(String.valueOf(errors));
		}
		if (warnings != null) {
			throw new CompilerChainException(String.valueOf(warnings));
		}
	} */
}
