/*******************************************************************************
 * Copyright (c) 2013, 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *	 E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.build.modelspecs;

import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.build.modelspecs.CGTypedElementModelSpec;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMapping;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMappingExp;
import org.eclipse.qvtd.codegen.qvticgmodel.CGPredicate;

/**
 * QVTdCGTypedElementModelSpec supports generation of the CGTypedElement.getASTypeId() method hierarchy.
 */
public class QVTdCGTypedElementModelSpec extends CGTypedElementModelSpec
{
	/**
	 * The algorithm options for getASTypeId()
	 */
	public static final @NonNull Ati ATI_BOOL = new Ati() { public @NonNull String generate() {
		return "return " + classRef(TypeId.class) + ".BOOLEAN;";
	}};

	public static class Register {
	  public Register() {
		new QVTdCGTypedElementModelSpec(CGMapping.class, ATI_BOOL);
		new QVTdCGTypedElementModelSpec(CGMappingExp.class, ATI_BOOL);
		new QVTdCGTypedElementModelSpec(CGPredicate.class, ATI_BOOL);
	  }
	}
	
	protected QVTdCGTypedElementModelSpec(@NonNull Class<?> cgClass, @Nullable Ati ati) {
		super(cgClass, ati);
	}
	
	@Override
	public void generate(@NonNull StringBuilder s, @NonNull GenModel genModel, boolean isImplementation) {
		getASTypeId.generate(s, this, genModel, isImplementation);
	}
}
