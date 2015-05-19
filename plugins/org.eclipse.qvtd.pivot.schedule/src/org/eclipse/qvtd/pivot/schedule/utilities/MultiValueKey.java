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
package org.eclipse.qvtd.pivot.schedule.utilities;

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;

public interface MultiValueKey<K, T> {

	@NonNull
	K get(int index);

	@NonNull
	K[] get();
	
	List<T> getKeyIds();

	int size();

}