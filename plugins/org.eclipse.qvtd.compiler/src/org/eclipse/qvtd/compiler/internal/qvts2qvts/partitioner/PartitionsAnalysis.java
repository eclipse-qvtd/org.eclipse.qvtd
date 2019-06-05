/*******************************************************************************
 * Copyright (c) 2018, 2019 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvts2qvts.partitioner;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.analysis.PartialRegionsAnalysis;

/**
 * PartitionsAnalysis manages the ClassDatum and PropertyDatum usage by partitions for a PartitionsAnalysis.
 */
public interface PartitionsAnalysis extends PartialRegionsAnalysis<@NonNull PartitionsAnalysis>
{
}