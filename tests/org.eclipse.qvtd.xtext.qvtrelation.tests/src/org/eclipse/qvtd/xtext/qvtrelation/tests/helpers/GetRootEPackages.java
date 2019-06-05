/*******************************************************************************
 * Copyright (c) 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtrelation.tests.helpers;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.CollectionTypeId;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.library.AbstractBinaryOperation;
import org.eclipse.ocl.pivot.values.SetValue;

public class GetRootEPackages extends AbstractBinaryOperation
{
	public static final @NonNull GetRootEPackages INSTANCE = new GetRootEPackages();

	//		query getHelper(element : atlMM::LocatedElement) : atlMM::Helper[1] {
	//			element->closure(e : ocl::OclElement | e.oclContainer())->selectByKind(atlMM::Helper)->any(true)
	//		}
	@Override
	public @NonNull SetValue evaluate(@NonNull Executor executor, @NonNull TypeId returnTypeId, @Nullable Object self, @Nullable Object ePackage) {
		//	public @NonNull Set<@NonNull EPackage> evaluate(@NonNull Executor executor, @NonNull TypeId returnTypeId, @Nullable Object self, @Nullable Object ePackage) {
		Set<@NonNull EPackage> ePackages = new HashSet<>();
		if (ePackage instanceof EPackage) {
			for (EObject eObject : ((EPackage)ePackage).eResource().getContents()) {
				if (eObject instanceof EPackage) {
					ePackages.add((EPackage)eObject);
				}
			}
		}
		return executor.getIdResolver().createSetOfAll((CollectionTypeId)returnTypeId, ePackages);
	}

}
