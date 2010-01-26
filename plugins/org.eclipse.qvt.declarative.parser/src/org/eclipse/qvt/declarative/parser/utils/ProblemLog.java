/*******************************************************************************
 * Copyright (c) 2007 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvt.declarative.parser.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.ocl.lpg.AbstractProblemHandler;
import org.eclipse.ocl.lpg.DerivedPrsStream;
import org.eclipse.ocl.lpg.ProblemHandler;
import org.eclipse.osgi.util.NLS;
import org.eclipse.qvt.declarative.ecore.operations.EValidatorWithOperations;

public class ProblemLog extends AbstractProblemHandler
{
	public static class Problem implements Comparable<Problem>
	{
		public final String problemMessage;
		public final String processingContext;
		public final int startOffset;
		public int endOffset;
		
		public Problem(String problemMessage, String processingContext, int startOffset, int endOffset) {
			this.problemMessage = problemMessage != null ? problemMessage : "";
			this.processingContext = processingContext;
			this.startOffset = startOffset;
			this.endOffset = endOffset;
		}

		public int compareTo(Problem o) {
			return problemMessage.compareTo(o.problemMessage);
		}		
	}
	
	private Map<ProblemHandler.Phase, Map<ProblemHandler.Severity, List<Problem>>> problems = new HashMap<ProblemHandler.Phase, Map<ProblemHandler.Severity, List<Problem>>>();
	private int allProblemCount = 0;

	public ProblemLog() {
		super(null);
	}
	
	public void expectValidatorError(EValidatorWithOperations validator, String problemMessage, String... substitutions) {
		String message = NLS.bind(problemMessage, substitutions);
		String processingContext = validator.getDiagnosticSource();
		handleProblem(ProblemHandler.Severity.ERROR, ProblemHandler.Phase.VALIDATOR, message,
				processingContext, -1, -1);
	}
	
	public void expectValidatorWarning(EValidatorWithOperations validator, String problemMessage, String... substitutions) {
		String message = NLS.bind(problemMessage, substitutions);
		String processingContext = validator.getDiagnosticSource();
		handleProblem(ProblemHandler.Severity.WARNING, ProblemHandler.Phase.VALIDATOR, message,
				processingContext, -1, -1);
	}

	public int getAllProblems() {
		return allProblemCount;
	}

	public Set<ProblemHandler.Phase> getProcessingPhases() {
		return problems.keySet();
	}
	
	public Map<ProblemHandler.Severity, List<Problem>> getProblems(ProblemHandler.Phase processingPhase) {
		Map<ProblemHandler.Severity, List<Problem>> phaseProblems = problems.get(processingPhase);
		if (phaseProblems != null)
			return phaseProblems;
		else
			return Collections.emptyMap();
	}
	
	public List<Problem> getProblems(ProblemHandler.Severity problemSeverity, ProblemHandler.Phase processingPhase) {
		Map<ProblemHandler.Severity, List<Problem>> phaseProblems = problems.get(processingPhase);
		List<Problem> phaseSeverityProblems = phaseProblems != null ? phaseProblems.get(problemSeverity) : null;
		if (phaseSeverityProblems != null)
			return phaseSeverityProblems;
		else
			return Collections.emptyList();
	}

	@Override public void handleProblem(Severity problemSeverity, Phase processingPhase,
			String problemMessage, String processingContext, int startOffset, int endOffset) {
		Map<ProblemHandler.Severity, List<Problem>> phaseProblems = problems.get(processingPhase);
		if (phaseProblems == null) {
			phaseProblems = new HashMap<ProblemHandler.Severity, List<Problem>>();
			problems.put(processingPhase, phaseProblems);
		}
		List<Problem> phaseSeverityProblems = phaseProblems.get(problemSeverity);
		if (phaseSeverityProblems == null) {
			phaseSeverityProblems = new ArrayList<Problem>();
			phaseProblems.put(problemSeverity, phaseSeverityProblems);
		}
		phaseSeverityProblems.add(new Problem(problemMessage, processingContext, startOffset, endOffset));
		allProblemCount++;
	}
	
	public StringBuffer toString(StringBuffer s, String prefix) {
		List<ProblemHandler.Phase> phases = new ArrayList<ProblemHandler.Phase>(getProcessingPhases());
		Collections.sort(phases);
		for (ProblemHandler.Phase phase : phases) {
			Map<ProblemHandler.Severity, List<Problem>> phaseProblems = getProblems(phase);
			List<ProblemHandler.Severity> severities = new ArrayList<ProblemHandler.Severity>(phaseProblems.keySet());
			for (ProblemHandler.Severity severity : severities) {
				if (s.length() > 0) {
					s.append("\n");
					s.append(prefix);
				}
				s.append(phase);
				s.append("-");
				s.append(severity);
				for (Problem problem : phaseProblems.get(severity)) {
					s.append("\n");
					s.append(prefix);
					s.append("  ");
					s.append(problem.problemMessage);
					if (problem.processingContext != null) {
						s.append(" @");
						s.append(problem.processingContext);
					}
					if (problem.startOffset >= 0) {
						s.append(" : ");
						s.append(problem.startOffset);
						if (problem.endOffset >= 0) {
							s.append(" : ");
							s.append(problem.endOffset);
							if (getParser() != null) {
								DerivedPrsStream iPrsStream = getParser().getIPrsStream();
								int token = iPrsStream.getTokenIndexAtCharacter(problem.startOffset);
								s.append(" ");
								try {
									s.append(iPrsStream.getLine(token));
								} catch (ArrayIndexOutOfBoundsException e) {
									s.append("???");
								}
								s.append(":");
								try {
									s.append(iPrsStream.getColumn(token));
								} catch (ArrayIndexOutOfBoundsException e) {
									s.append("???");
								}
								s.append(" '");
								s.append(getParser().computeInputString(problem.startOffset, problem.endOffset));
								s.append("'");
							}
						}
					}
				}
			}
		}		
		return s;
	}
}