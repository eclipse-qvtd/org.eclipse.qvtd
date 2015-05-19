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
package org.eclipse.qvtd.compiler.internal.qvtr2qvtc.utilities;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.qvtd.compiler.internal.qvtr2qvtc.Rule;
import org.eclipse.qvtd.compiler.internal.qvtr2qvtc.impl.RuleBindings;

public interface TransformationTraceData {

	public void addRecord(@NonNull Rule rule);

	public abstract void deleteRecord(@NonNull Rule rule);
	
	public abstract @Nullable Rule getRecord(@NonNull RuleBindings relationsBindings);
	
}