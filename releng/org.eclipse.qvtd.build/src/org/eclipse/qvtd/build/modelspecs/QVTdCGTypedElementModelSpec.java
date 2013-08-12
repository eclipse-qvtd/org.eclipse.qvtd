/**
 * <copyright>
 *
 * Copyright (c) 2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *	 E.D.Willink - initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.qvtd.build.modelspecs;

import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.build.modelspecs.CGTypedElementModelSpec;
import org.eclipse.ocl.examples.domain.ids.TypeId;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMapping;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMappingExp;
import org.eclipse.qvtd.codegen.qvticgmodel.CGPredicate;

/**
 * CGTypedElementModelSpec supports generation of the CGTypedElement.getPivotTypeId() method hierarchy.
 */
public class QVTdCGTypedElementModelSpec extends CGTypedElementModelSpec
{
	/**
	 * The algorithm options for getPivotTypeId()
	 */
	public static final @NonNull Pti PTI_BOOL = new Pti() { public @NonNull String generate() {
		return "return " + classRef(TypeId.class) + ".BOOLEAN;";
	}};

	public static void register() {
		new QVTdCGTypedElementModelSpec(CGMapping.class, PTI_BOOL);
		new QVTdCGTypedElementModelSpec(CGMappingExp.class, PTI_BOOL);
		new QVTdCGTypedElementModelSpec(CGPredicate.class, PTI_BOOL);
	}
	
	protected QVTdCGTypedElementModelSpec(@NonNull Class<?> cgClass, @Nullable Pti pti) {
		super(cgClass, pti);
	}
	
	@Override
	public void generate(@NonNull StringBuilder s, @NonNull GenModel genModel, boolean isImplementation) {
		getPivotTypeId.generate(s, this, genModel, isImplementation);
	}
}
