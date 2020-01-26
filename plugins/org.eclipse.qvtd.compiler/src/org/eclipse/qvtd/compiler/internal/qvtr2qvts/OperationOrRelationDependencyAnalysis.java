/*******************************************************************************
 * Copyright (c) 2015, 2019 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvtr2qvts;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.ContainmentAnalysis;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.OperationDependencyAnalysis;
import org.eclipse.qvtd.compiler.internal.usage.RootDomainUsageAnalysis;
import org.eclipse.qvtd.pivot.qvtrelation.DomainPattern;
import org.eclipse.qvtd.pivot.qvtrelation.Key;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationCallExp;
import org.eclipse.qvtd.pivot.qvtrelation.RelationDomain;
import org.eclipse.qvtd.pivot.qvtrelation.RelationDomainAssignment;
import org.eclipse.qvtd.pivot.qvtrelation.RelationImplementation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationModel;
import org.eclipse.qvtd.pivot.qvtrelation.RelationalTransformation;
import org.eclipse.qvtd.pivot.qvtrelation.SharedVariable;
import org.eclipse.qvtd.pivot.qvtrelation.TemplateVariable;
import org.eclipse.qvtd.pivot.qvtrelation.util.QVTrelationVisitor;
import org.eclipse.qvtd.pivot.qvttemplate.CollectionTemplateExp;
import org.eclipse.qvtd.pivot.qvttemplate.ObjectTemplateExp;
import org.eclipse.qvtd.pivot.qvttemplate.PropertyTemplateItem;
import org.eclipse.qvtd.pivot.qvttemplate.TemplateExp;

/**
 * The DependencyAnalyzer performs an simulated execution of an expression tree propagating dependencies to called operations
 * and returning the referenced types and the hidden type/property-path accesses within the execution.
 * Cached Operation analyses are specialized wrt their invocation arguments so that the analysis of each OperationCallExp
 * is sensitive to actual usage.
 */
public class OperationOrRelationDependencyAnalysis extends OperationDependencyAnalysis
{
	protected class RelationDependencyAnalyzerVisitor extends DependencyAnalyzerVisitor implements QVTrelationVisitor<@Nullable BasicDependencyPaths>
	{
		protected RelationDependencyAnalyzerVisitor(@NonNull AbstractOperationAnalysis analysis, boolean exactResult) {
			super(analysis, exactResult);
		}

		protected RelationDependencyAnalyzerVisitor(@NonNull DependencyAnalyzerVisitor parent) {
			super(parent);
		}

		@Override
		public @Nullable BasicDependencyPaths visitCollectionTemplateExp(@NonNull CollectionTemplateExp object) {
			return visiting(object);
		}

		@Override
		public @Nullable BasicDependencyPaths visitDomainPattern(@NonNull DomainPattern object) {
			return visiting(object);
		}

		@Override
		public @Nullable BasicDependencyPaths visitKey(@NonNull Key object) {
			return visiting(object);
		}

		@Override
		public @Nullable BasicDependencyPaths visitObjectTemplateExp(@NonNull ObjectTemplateExp object) {
			return visiting(object);
		}

		@Override
		public @Nullable BasicDependencyPaths visitPropertyTemplateItem(@NonNull PropertyTemplateItem object) {
			return visiting(object);
		}

		@Override
		public @Nullable BasicDependencyPaths visitRelation(@NonNull Relation object) {
			return visiting(object);
		}

		@Override
		public @Nullable BasicDependencyPaths visitRelationCallExp(@NonNull RelationCallExp relationCallExp) {
			//FIXME cf NavigationCallExp
			return emptyDependencyPaths;	// Relations have no hidden dependencies - they are all overt and understood
		}

		@Override
		public @Nullable BasicDependencyPaths visitRelationDomain(@NonNull RelationDomain object) {
			return visiting(object);
		}

		@Override
		public @Nullable BasicDependencyPaths visitRelationDomainAssignment(@NonNull RelationDomainAssignment object) {
			return visiting(object);
		}

		@Override
		public @Nullable BasicDependencyPaths visitRelationImplementation(@NonNull RelationImplementation object) {
			return visiting(object);
		}

		@Override
		public @Nullable BasicDependencyPaths visitRelationModel(@NonNull RelationModel object) {
			return visiting(object);
		}

		@Override
		public @Nullable BasicDependencyPaths visitRelationalTransformation(@NonNull RelationalTransformation object) {
			return visiting(object);
		}

		@Override
		public @Nullable BasicDependencyPaths visitSharedVariable(@NonNull SharedVariable object) {
			return visiting(object);
		}

		@Override
		public @Nullable BasicDependencyPaths visitTemplateExp(@NonNull TemplateExp object) {
			return visiting(object);
		}

		@Override
		public @Nullable BasicDependencyPaths visitTemplateVariable(@NonNull TemplateVariable object) {
			return visiting(object);
		}
	}

	public OperationOrRelationDependencyAnalysis(@NonNull ContainmentAnalysis containmentAnalysis, @NonNull RootDomainUsageAnalysis domainUsageAnalysis) {
		super(containmentAnalysis, domainUsageAnalysis);
	}

	@Override
	protected @NonNull DependencyAnalyzerVisitor createDependencyAnalyzerVisitor(@NonNull AbstractOperationAnalysis operationAnalysis, boolean exactResult) {
		return new RelationDependencyAnalyzerVisitor(operationAnalysis, exactResult);
	}

	@Override
	protected @NonNull DependencyAnalyzerVisitor createDependencyAnalyzerVisitor(@NonNull DependencyAnalyzerVisitor parent) {
		return new RelationDependencyAnalyzerVisitor(parent);
	}
}