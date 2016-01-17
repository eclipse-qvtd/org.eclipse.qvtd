/*******************************************************************************
 * Copyright (c) 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtcorebase.analysis;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Element;

/**
 * The DomainUsageAnalysis supports analysis of a Transformation's Domains to associated a bitmask of possible TypedModels with
 * each element in the transformation.
 * <p>
 * The bitmask is maintained by a DomainUsage and may be a resolved value (a DomainUsageConstant) or an unresolved value
 * (a DomainUsageVariable).
 * <p>
 * Some usages such as those of guard pattern variables can be determined directly from the domain. Many more can be determined
 * from the expression type which is often associated with only a single TypedModel.
 * <p>
 * For homogeneous transformation input and output TypedModels are the same and so the QVT_DOMAINS_ANNOTATION_SOURCE annotation
 * on the middle-to-side properties provides the only way to distinguish them.
 * <p>
 * Some facilities such as Operations may be used for more than one TypedModel. The possible usages are analyzed as a
 * DomainUsageVariable for resolution in the invoking context.
 * <p>
 * A bottom-up traversal of the AST enables known domain usages to be unified resolving all variable usages to usually just a single domain.
 * <p>
 * DataTypes of course have no domain and so they are allocated to the primitive TypedModel.
 * <p>
 * Control structures such as Mapping have no associated TypedModel.
 * <p>
 * <p>
 * AbstractDomainUsageAnalysis provides shared functionality for the overall analysis and for nested operational analyses.
 * An analysis should be started by creating a derived RootDomainUsageAnalaysis such as QVTcoreDomainUsageAnalaysis or 
 * QVTimperativeDomainUsageAnalaysis and then invoking analyzeTransformation. The returned map identifies the usage for all elements
 * in the transformation.
 */
public interface DomainUsageAnalysis
{
	/**
	 * Return the DomainUsage bit mask for an AST element or null if not determined.
	 */
	@Nullable DomainUsage basicGetUsage(@Nullable EObject element);
	
	/**
	 * Return the DomainUsage bit mask for an AST element.
	 */
	@NonNull DomainUsage getUsage(@NonNull EObject element);
	
	public interface Internal extends DomainUsageAnalysis {
		@NonNull DomainUsage visit(@Nullable Element element);
	}
}
