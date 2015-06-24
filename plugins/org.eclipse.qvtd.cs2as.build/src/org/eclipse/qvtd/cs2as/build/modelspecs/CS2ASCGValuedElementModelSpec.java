/*******************************************************************************
 * Copyright (c) 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *	 E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.cs2as.build.modelspecs;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.build.modelspecs.CGValuedElementModelSpec;
import org.eclipse.qvtd.cs2as.compiler.cgmodel.CGLookupCallExp;

/**
 * CGValuedElementModelSpec supports generation of the many methods that contribute to the CGValuedElement.xxxx() method hierarchy.
 * <p>
 * The exposition here as a two-dimensional Java table provides a readable, type-checked preserntation that would be harder to achieve
 * using a spreadsheet (poor checking) or a model (no 2D tools).  
 */
public class CS2ASCGValuedElementModelSpec extends CGValuedElementModelSpec
{

	public static class Register {
	  public Register() {
//		new CGValuedElementModelSpec(CGVariable.class, "init",							null     , Ref.DELEG, null     , Nul.VAR  , Inv.VAR  , null     , null     , null     , null    , null     , null     , null     , null     , null     );
		new CS2ASCGValuedElementModelSpec(CGLookupCallExp.class, null,					Box.UNBOX, null     , null     , null     , null     , Glo.FALSE, null     , null     , null    , null     , null     , null     , null     , null     , null     , null     , null    );
	  }
	}
	
	protected CS2ASCGValuedElementModelSpec(@NonNull Class<?> cgClass, @Nullable String delegate,
			@Nullable Box box, @Nullable Ths ths, @Nullable Log log, @Nullable Nul nul, @Nullable Inv inv,
			@Nullable Glo glo, @Nullable Inl inl, @Nullable Set set, @Nullable Ct ct, @Nullable Con con,
			@Nullable Val val, @Nullable Cvl cvl, @Nullable Ctx ctx, @Nullable Ctl ctl, @Nullable Com com, @Nullable Rew rew, @Nullable Eq eq) {
		super(cgClass, delegate, box, ths, log, nul, inv, glo, inl, set, ct, con, val, cvl, ctx, ctl, com, rew, eq);
	}
}
