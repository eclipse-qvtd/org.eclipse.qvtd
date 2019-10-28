/*******************************************************************************
 * Copyright (c) 2015, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.usage;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Parameter;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.qvtd.compiler.ProblemHandler;
import org.eclipse.qvtd.pivot.qvtbase.BaseModel;
import org.eclipse.qvtd.pivot.qvtbase.CompoundTargetElement;
import org.eclipse.qvtd.pivot.qvtbase.Target;
import org.eclipse.qvtd.pivot.qvtbase.TargetElement;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.Function;
import org.eclipse.qvtd.pivot.qvtbase.FunctionBody;
import org.eclipse.qvtd.pivot.qvtbase.FunctionParameter;
import org.eclipse.qvtd.pivot.qvtbase.Pattern;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.SimpleTargetElement;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.util.QVTbaseVisitor;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.DomainUsage;

/**
 * AbstractDomainUsageAnalysis provides shared functionality for the overall analysis and for nested operational analyses.
 */
public abstract class AbstractBaseDomainUsageAnalysis extends AbstractDomainUsageAnalysis implements QVTbaseVisitor<@NonNull DomainUsage>
{
	protected AbstractBaseDomainUsageAnalysis(@NonNull EnvironmentFactory environmentFactory, @NonNull ProblemHandler problemHandler) {
		super(environmentFactory, problemHandler);
	}

	protected @NonNull DomainUsage getDomainUsage(@Nullable EObject object) {
		Domain domain = QVTbaseUtil.basicGetContainingDomain(object);
		if (domain !=  null) {
			return visit(domain.getTypedModel());
		}
		else {
			return getRootAnalysis().getMiddleUsage();
		}
	}

	@Override
	public @NonNull DomainUsage visitBaseModel(@NonNull BaseModel object) {
		return visitModel(object);
	}

	@Override
	public @NonNull DomainUsage visitCompoundTargetElement(@NonNull CompoundTargetElement object) {
		return visitTargetElement(object);
	}

	@Override
	public @NonNull DomainUsage visitDomain(@NonNull Domain object) {
		return visitNamedElement(object);
	}

	@Override
	public @NonNull DomainUsage visitFunction(@NonNull Function object) {
		for (@NonNull Parameter parameter : QVTbaseUtil.getOwnedParameters(object)) {
			visit(parameter);
		}
		OCLExpression queryExpression = object.getQueryExpression();
		if (queryExpression != null) {
			return visit(queryExpression);
		}
		else {
			return visit(object.getType());
		}
	}

	@Override
	public @NonNull DomainUsage visitFunctionBody(@NonNull FunctionBody object) {
		return visitExpressionInOCL(object);
	}

	@Override
	public @NonNull DomainUsage visitFunctionParameter(@NonNull FunctionParameter object) {
		return visitParameter(object);
	}

	@Override
	public @NonNull DomainUsage visitPattern(@NonNull Pattern object) {
		return visitElement(object);
	}

	@Override
	public @NonNull DomainUsage visitPredicate(@NonNull Predicate object) {
		return visit(object.getConditionExpression());
	}

	@Override
	public @NonNull DomainUsage visitRule(@NonNull Rule object) {
		for (Domain domain : object.getDomain()) {
			visit(domain);
		}
		return getRootAnalysis().getNoneUsage();
	}

	@Override
	public @NonNull DomainUsage visitSimpleTargetElement(@NonNull SimpleTargetElement object) {
		return visitTargetElement(object);
	}

	@Override
	public @NonNull DomainUsage visitTarget(@NonNull Target object) {
		return visitNamedElement(object);
	}

	@Override
	public @NonNull DomainUsage visitTargetElement(@NonNull TargetElement object) {
		return visitElement(object);
	}

	@Override
	public @NonNull DomainUsage visitTransformation(@NonNull Transformation object) {
		return getRootAnalysis().getThisUsage();
	}

	@Override
	public @NonNull DomainUsage visitTypedModel(@NonNull TypedModel object) {
		RootDomainUsageAnalysis rootAnalysis = getRootAnalysis();
		if (rootAnalysis != this) {
			return ClassUtil.nonNullState(rootAnalysis.basicGetUsage(object));
		}
		return ClassUtil.nonNullState(element2usage.get(object));
	}
}
