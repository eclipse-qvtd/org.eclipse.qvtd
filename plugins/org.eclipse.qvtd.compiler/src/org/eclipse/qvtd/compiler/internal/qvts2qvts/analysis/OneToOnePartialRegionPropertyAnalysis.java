/*******************************************************************************
 * Copyright (c) 2019, 2020 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvts2qvts.analysis;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.pivot.qvtschedule.PropertyDatum;

/**
 * Each ClassAnalysis identifies the usage of one middle trace class or property.
 */
public class OneToOnePartialRegionPropertyAnalysis<@NonNull PRA extends PartialRegionsAnalysis<@NonNull PRA>> extends ActualPartialRegionPropertyAnalysis<@NonNull PRA>
{
	public OneToOnePartialRegionPropertyAnalysis(@NonNull BasePartialRegionPropertyAnalysis<PRA> basePropertyAnalysis, @NonNull PartialRegionClassAnalysis<@NonNull PRA> classAnalysis, @NonNull PropertyDatum propertyDatum) {
		super(basePropertyAnalysis, classAnalysis, propertyDatum);
	}
}
