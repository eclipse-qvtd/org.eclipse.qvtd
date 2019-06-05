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
package org.eclipse.qvtd.atl.atl2qvtr.utilities;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.m2m.atl.common.ATL.Helper;
import org.eclipse.m2m.atl.common.ATL.LocatedElement;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.library.AbstractBinaryOperation;

public class Helper4getHelper extends AbstractBinaryOperation
{
	public static final @NonNull Helper4getHelper INSTANCE = new Helper4getHelper();

	//		query getHelper(element : atlMM::LocatedElement) : atlMM::Helper[1] {
	//			element->closure(e : ocl::OclElement | e.oclContainer())->selectByKind(atlMM::Helper)->any(true)
	//		}
	@Override
	public @Nullable Helper evaluate(@NonNull Executor executor, @NonNull TypeId returnTypeId, @Nullable Object selfValue, @Nullable Object sourceValue) {
		for (EObject eObject = (LocatedElement)sourceValue; eObject != null; eObject = eObject.eContainer()) {
			if (eObject instanceof Helper) {
				return (Helper) eObject;
			}
		}
		return null; //throwInvalidValueException();
	}
}
