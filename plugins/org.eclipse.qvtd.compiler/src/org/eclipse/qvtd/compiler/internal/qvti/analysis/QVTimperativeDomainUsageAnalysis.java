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

import java.util.Map;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtcore.analysis.RootDomainUsageAnalysis;
import org.eclipse.qvtd.pivot.qvtimperative.AddStatement;
import org.eclipse.qvtd.pivot.qvtimperative.AppendParameter;
import org.eclipse.qvtd.pivot.qvtimperative.AppendParameterBinding;
import org.eclipse.qvtd.pivot.qvtimperative.BufferStatement;
import org.eclipse.qvtd.pivot.qvtimperative.CheckStatement;
import org.eclipse.qvtd.pivot.qvtimperative.ConnectionVariable;
import org.eclipse.qvtd.pivot.qvtimperative.DeclareStatement;
import org.eclipse.qvtd.pivot.qvtimperative.GuardParameter;
import org.eclipse.qvtd.pivot.qvtimperative.GuardParameterBinding;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeModel;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeTransformation;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeTypedModel;
import org.eclipse.qvtd.pivot.qvtimperative.LoopParameterBinding;
import org.eclipse.qvtd.pivot.qvtimperative.LoopVariable;
import org.eclipse.qvtd.pivot.qvtimperative.Mapping;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCall;
import org.eclipse.qvtd.pivot.qvtimperative.MappingLoop;
import org.eclipse.qvtd.pivot.qvtimperative.MappingParameter;
import org.eclipse.qvtd.pivot.qvtimperative.MappingParameterBinding;
import org.eclipse.qvtd.pivot.qvtimperative.MappingStatement;
import org.eclipse.qvtd.pivot.qvtimperative.NewStatement;
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
	public QVTimperativeDomainUsageAnalysis(@NonNull EnvironmentFactory environmentFactory) {
		super(environmentFactory);
	}

	public @NonNull Map<Element, DomainUsage> analyzeTransformation(@NonNull Transformation transformation) {
		int checkedMask = 0;
		int enforcedMask = 0;
		for (@NonNull TypedModel typedModel : ClassUtil.nullFree(transformation.getModelParameter())) {
			boolean isEnforced = false;
			boolean isChecked = false;
			ImperativeTypedModel imperativeTypedModel = (ImperativeTypedModel)typedModel;
			if (imperativeTypedModel.isIsTrace()) {
				setTraceTypedModel(typedModel);
			}
			else if (imperativeTypedModel.isIsEnforced()) {
				isEnforced = true;
			}
			else if (imperativeTypedModel.isIsChecked()) {
				isChecked = true;
			}
			else if (imperativeTypedModel.isIsPrimitive()) {
				continue;
			}
			int nextBit = add(typedModel);
			int bitMask = 1 << nextBit;
			@NonNull DomainUsageConstant typedModelUsage = getConstantUsage(bitMask);
			addValidUsage(bitMask, typedModelUsage);
			if (isEnforced) {
				enforcedMask |= bitMask;
			}
			if (isChecked) {
				checkedMask |= bitMask;
			}
			setUsage(typedModel, typedModelUsage);
			Variable ownedContext = typedModel.getOwnedContext();
			if (ownedContext != null) {
				setUsage(ownedContext, typedModelUsage);
			}
			analyzeTypedModelTypes(typedModel, typedModelUsage);
		}
		analyzeTransformation2(transformation, checkedMask, enforcedMask);
		return element2usage;
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
	public @NonNull DomainUsage visitImperativeTypedModel(@NonNull ImperativeTypedModel object) {
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
		return getNoneUsage();
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
	public @NonNull DomainUsage visitVariableStatement(@NonNull VariableStatement object) {
		return getNoneUsage();
	}
}
