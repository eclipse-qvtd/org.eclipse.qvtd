/*******************************************************************************
 * Copyright (c) 2015, 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtcore.analysis;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtcore.CoreModel;
import org.eclipse.qvtd.pivot.qvtcore.Mapping;
import org.eclipse.qvtd.pivot.qvtcore.util.QVTcoreVisitor;

/**
 * A QVTcoreDomainUsageAnalysis identifies a constrained domain result from the DomainUsageAnalysis of an OCL AST node.
 */
public class QVTcoreDomainUsageAnalysis extends RootDomainUsageAnalysis implements QVTcoreVisitor<DomainUsage>
{
	public QVTcoreDomainUsageAnalysis(@NonNull EnvironmentFactory environmentFactory) {
		super(environmentFactory);
	}

	@Override
	protected void setBoundVariablesUsages(@NonNull Rule rule) {
		super.setBoundVariablesUsages(rule);
		if (rule instanceof Mapping) {
			for (Mapping local : ((Mapping)rule).getLocal()) {
				if (local != null) {
					setBoundVariablesUsages(local);
				}
			}
		}
	}

	@Override
	public @NonNull DomainUsage visitCoreModel(@NonNull CoreModel object) {
		return visitBaseModel(object);
	}

	@Override
	public @NonNull DomainUsage visitMapping(@NonNull Mapping object) {
		DomainUsage usage = getRootAnalysis().getNoneUsage();
		setUsage(object, usage);
		visitRule(object);
		visit(object.getGuardPattern());
		visit(object.getBottomPattern());
		for (Mapping local : object.getLocal()) {
			visit(local);
		}
		return usage;
	}
}
