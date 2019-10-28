/*******************************************************************************
 * Copyright (c) 2018, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvti.analysis;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.qvtd.compiler.ProblemHandler;
import org.eclipse.qvtd.compiler.internal.common.TypedModelsConfiguration;
import org.eclipse.qvtd.compiler.internal.usage.DirectedDomainUsageAnalysis;
import org.eclipse.qvtd.compiler.internal.usage.RootDomainUsageAnalysis;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtimperative.AddStatement;
import org.eclipse.qvtd.pivot.qvtimperative.AppendParameter;
import org.eclipse.qvtd.pivot.qvtimperative.AppendParameterBinding;
import org.eclipse.qvtd.pivot.qvtimperative.BufferStatement;
import org.eclipse.qvtd.pivot.qvtimperative.CheckStatement;
import org.eclipse.qvtd.pivot.qvtimperative.ConnectionVariable;
import org.eclipse.qvtd.pivot.qvtimperative.DeclareStatement;
import org.eclipse.qvtd.pivot.qvtimperative.EntryPoint;
import org.eclipse.qvtd.pivot.qvtimperative.GuardParameter;
import org.eclipse.qvtd.pivot.qvtimperative.GuardParameterBinding;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeModel;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeTransformation;
import org.eclipse.qvtd.pivot.qvtimperative.LoopParameterBinding;
import org.eclipse.qvtd.pivot.qvtimperative.LoopVariable;
import org.eclipse.qvtd.pivot.qvtimperative.Mapping;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCall;
import org.eclipse.qvtd.pivot.qvtimperative.MappingLoop;
import org.eclipse.qvtd.pivot.qvtimperative.MappingParameter;
import org.eclipse.qvtd.pivot.qvtimperative.MappingParameterBinding;
import org.eclipse.qvtd.pivot.qvtimperative.MappingStatement;
import org.eclipse.qvtd.pivot.qvtimperative.NewStatement;
import org.eclipse.qvtd.pivot.qvtimperative.NewStatementPart;
import org.eclipse.qvtd.pivot.qvtimperative.ObservableStatement;
import org.eclipse.qvtd.pivot.qvtimperative.SetStatement;
import org.eclipse.qvtd.pivot.qvtimperative.SimpleParameter;
import org.eclipse.qvtd.pivot.qvtimperative.SimpleParameterBinding;
import org.eclipse.qvtd.pivot.qvtimperative.Statement;
import org.eclipse.qvtd.pivot.qvtimperative.VariableStatement;
import org.eclipse.qvtd.pivot.qvtimperative.util.QVTimperativeVisitor;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeUtil;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.DomainUsage;

/**
 * A QVTimperativeDomainUsageAnalysis identifies a constrained domain result from the DomainUsageAnalysis of a QVTi AST node.
 */
public class QVTimperativeDomainUsageAnalysis extends RootDomainUsageAnalysis implements QVTimperativeVisitor<@NonNull DomainUsage>
{
	protected static class QVTimperativeDirectedDomainUsageAnalysis extends DirectedDomainUsageAnalysis
	{
		public QVTimperativeDirectedDomainUsageAnalysis(@NonNull QVTimperativeDomainUsageAnalysis domainUsageAnalysis, @NonNull TypedModelsConfiguration typedModelsConfiguration) {
			super(domainUsageAnalysis, typedModelsConfiguration);
		}

		@Override
		public void analyzeTransformation() {
			int inputMask = 0;
			int outputMask = 0;
			for (@NonNull TypedModel typedModel : QVTbaseUtil.getModelParameters(domainUsageAnalysis.getTransformation())) {
				if (!typedModel.isIsPrimitive() && !typedModel.isIsTrace()) {
					boolean isInput = QVTimperativeUtil.isInput(typedModel);
					boolean isOutput = QVTimperativeUtil.isOutput(typedModel);
					DomainUsage domainUsage = domainUsageAnalysis.getUsage(typedModel);
					int bitMask = domainUsage.getMask();
					if (isInput) {
						inputMask |= bitMask;
					}
					if (isOutput) {
						outputMask |= bitMask;
					}
				}
			}
			setInputUsage(inputMask);
			setOutputUsage(outputMask);
			analyzePropertyAssignments(domainUsageAnalysis.getTransformation());
		}
	}

	public QVTimperativeDomainUsageAnalysis(@NonNull EnvironmentFactory environmentFactory, @NonNull ProblemHandler problemHandler, @NonNull Transformation transformation) {
		super(environmentFactory, problemHandler, transformation);
	}

	@Override
	public @NonNull QVTimperativeDirectedDomainUsageAnalysis createDirectedDomainUsageAnalysis(@NonNull TypedModelsConfiguration typedModelsConfiguration) {
		return new QVTimperativeDirectedDomainUsageAnalysis(this, typedModelsConfiguration);
	}

	@Override
	public @NonNull DomainUsage visitAddStatement(@NonNull AddStatement object) {
		return getNoneUsage();
	}

	@Override
	public @NonNull DomainUsage visitAppendParameter(@NonNull AppendParameter object) {
		return getNoneUsage();
	}

	@Override
	public @NonNull DomainUsage visitAppendParameterBinding(@NonNull AppendParameterBinding object) {
		return getNoneUsage();
	}

	@Override
	public @NonNull DomainUsage visitBufferStatement(@NonNull BufferStatement object) {
		return getNoneUsage();
	}

	@Override
	public @NonNull DomainUsage visitCheckStatement(@NonNull CheckStatement object) {
		return getNoneUsage();
	}

	@Override
	public @NonNull DomainUsage visitConnectionVariable(@NonNull ConnectionVariable object) {
		return getNoneUsage();
	}

	@Override
	public @NonNull DomainUsage visitDeclareStatement(@NonNull DeclareStatement object) {
		return getUsage(PivotUtil.getType(object));
	}

	@Override
	public @NonNull DomainUsage visitEntryPoint(@NonNull EntryPoint entryPoint) {
		return visitMapping(entryPoint);
	}

	@Override
	public @NonNull DomainUsage visitGuardParameter(@NonNull GuardParameter object) {
		return getUsage(QVTimperativeUtil.getReferredTypedModel(object));
	}

	@Override
	public @NonNull DomainUsage visitGuardParameterBinding(@NonNull GuardParameterBinding object) {
		return getNoneUsage();
	}

	@Override
	public @NonNull DomainUsage visitImperativeModel(@NonNull ImperativeModel object) {
		return getNoneUsage();
	}

	@Override
	public @NonNull DomainUsage visitImperativeTransformation(@NonNull ImperativeTransformation object) {
		return getNoneUsage();
	}

	@Override
	public @NonNull DomainUsage visitLoopParameterBinding(@NonNull LoopParameterBinding object) {
		return getNoneUsage();
	}

	@Override
	public @NonNull DomainUsage visitLoopVariable(@NonNull LoopVariable object) {
		return getNoneUsage();
	}

	@Override
	public @NonNull DomainUsage visitMapping(@NonNull Mapping object) {
		// QVTi has no domains for accurate usages
		return getAnyUsage();
	}

	@Override
	public @NonNull DomainUsage visitMappingCall(@NonNull MappingCall object) {
		return getNoneUsage();
	}

	@Override
	public @NonNull DomainUsage visitMappingLoop(@NonNull MappingLoop object) {
		return getNoneUsage();
	}

	@Override
	public @NonNull DomainUsage visitMappingParameter(@NonNull MappingParameter object) {
		return getNoneUsage();
	}

	@Override
	public @NonNull DomainUsage visitMappingParameterBinding(@NonNull MappingParameterBinding object) {
		return getNoneUsage();
	}

	@Override
	public @NonNull DomainUsage visitMappingStatement(@NonNull MappingStatement object) {
		return getNoneUsage();
	}

	@Override
	public @NonNull DomainUsage visitNewStatement(@NonNull NewStatement object) {
		return getUsage(QVTimperativeUtil.getReferredTypedModel(object));
	}

	@Override
	public @NonNull DomainUsage visitNewStatementPart(@NonNull NewStatementPart object) {
		return getUsage(QVTimperativeUtil.getReferredProperty(object));
	}

	@Override
	public @NonNull DomainUsage visitObservableStatement(@NonNull ObservableStatement object) {
		return getNoneUsage();
	}

	@Override
	public @NonNull DomainUsage visitSetStatement(@NonNull SetStatement object) {
		return getNoneUsage();
	}

	@Override
	public @NonNull DomainUsage visitSimpleParameter(@NonNull SimpleParameter object) {
		return getUsage(QVTimperativeUtil.getReferredTypedModel(object));
	}

	@Override
	public @NonNull DomainUsage visitSimpleParameterBinding(@NonNull SimpleParameterBinding object) {
		return getNoneUsage();
	}

	@Override
	public @NonNull DomainUsage visitStatement(@NonNull Statement object) {
		return getNoneUsage();
	}

	@Override
	public @NonNull DomainUsage visitTypedModel(@NonNull TypedModel object) {
		return getNoneUsage();
	}

	@Override
	public @NonNull DomainUsage visitVariableStatement(@NonNull VariableStatement object) {
		return getNoneUsage();
	}
}
