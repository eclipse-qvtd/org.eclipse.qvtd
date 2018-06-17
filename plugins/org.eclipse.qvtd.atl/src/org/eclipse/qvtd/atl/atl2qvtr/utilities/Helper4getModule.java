/*******************************************************************************
 * Copyright (c) 2018 Willink Transformations and others.
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
import org.eclipse.m2m.atl.common.ATL.LocatedElement;
import org.eclipse.m2m.atl.common.ATL.Module;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.library.AbstractUnaryOperation;

public class Helper4getModule extends AbstractUnaryOperation
{
	public static final @NonNull Helper4getModule INSTANCE = new Helper4getModule();

	//		query getHelper(element : atlMM::LocatedElement) : atlMM::Helper[1] {
	//			element->closure(e : ocl::OclElement | e.oclContainer())->selectByKind(atlMM::Helper)->any(true)
	//		}
	@Override
	public @NonNull Module evaluate(@NonNull Executor executor, @NonNull TypeId returnTypeId, @Nullable Object sourceValue) {
		for (EObject eObject = (LocatedElement)sourceValue; eObject != null; eObject = eObject.eContainer()) {
			if (eObject instanceof Module) {
				return (Module) eObject;
			}
		}
		return (Module) throwInvalidValueException();
	}
}
