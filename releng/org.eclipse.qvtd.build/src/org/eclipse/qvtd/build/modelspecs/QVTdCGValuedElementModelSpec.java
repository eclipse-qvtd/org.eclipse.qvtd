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

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.build.modelspecs.CGValuedElementModelSpec;
import org.eclipse.qvtd.codegen.qvti.cse.PredicatePlaces;
import org.eclipse.qvtd.codegen.qvticgmodel.CGFunctionCallExp;
import org.eclipse.qvtd.codegen.qvticgmodel.CGFunctionParameter;
import org.eclipse.qvtd.codegen.qvticgmodel.CGGuardVariable;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMapping;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMappingCallBinding;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMappingExp;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMiddlePropertyCallExp;
import org.eclipse.qvtd.codegen.qvticgmodel.CGPredicate;
import org.eclipse.qvtd.codegen.qvticgmodel.CGPropertyAssignment;
import org.eclipse.qvtd.codegen.qvticgmodel.CGRealizedVariable;

/**
 * CGValuedElementModelSpec supports generation of the many methods that contribute to the CGValuedElement.xxxx() method hierarchy.
 * <p>
 * The exposition here as a two-dimensional Java table provides a readable, type-checked preserntation that would be harder to achieve
 * using a spreadsheet (poor checking) or a model (no 2D tools).  
 */
public class QVTdCGValuedElementModelSpec extends CGValuedElementModelSpec
{
	public static final @NonNull Ctl CTL_PRED = new Ctl() { public @NonNull String generate() {
		return "return " + classRef(PredicatePlaces.class) + ".createPredicatePlaces(element2place, this);";
	}};

	public static void register() {
//		new CGValuedElementModelSpec(CGVariable.class, "init",							null     , Ref.DELEG, null     , Nul.VAR  , Inv.VAR  , null     , null     , null     , null    , null     , null     , null     , null     , null     );
		new QVTdCGValuedElementModelSpec(CGGuardVariable.class, null,					Box.FALSE, null     , null     , Nul.FALSE, null     , Glo.FALSE, null     , null     , null    , null     , null     , null     , null     , null     , null     , null     );
		new QVTdCGValuedElementModelSpec(CGRealizedVariable.class, null,				Box.FALSE, Ref.THIS , null     , Nul.UNDEC, null     , Glo.FALSE, null     , null     , null    , null     , null     , null     , null     , null     , null     , null     );

		new QVTdCGValuedElementModelSpec(CGFunctionCallExp.class, null,					Box.FALSE, null     , null     , null     , null     , Glo.FALSE, null     , null     , null    , null     , null     , null     , null     , null     , null     , null     );
		new QVTdCGValuedElementModelSpec(CGFunctionParameter.class, null,				Box.FALSE, null     , null     , null     , null     , Glo.FALSE, null     , null     , null    , null     , null     , null     , null     , null     , null     , null     );
		new QVTdCGValuedElementModelSpec(CGMappingCallBinding.class, "valueOrValues",	Box.DELEG, Ref.DELEG, null     , null     , null     , Glo.FALSE, null     , null     , null    , null     , null     , null     , null     , null     , null     , null     );
		new QVTdCGValuedElementModelSpec(CGMiddlePropertyCallExp.class, null,			Box.FALSE, null     , null     , null     , null     , Glo.FALSE, null     , null     , null    , null     , null     , null     , null     , null     , null     , null     );
		new QVTdCGValuedElementModelSpec(CGPredicate.class, "conditionExpression",		Box.TRUE , Ref.THIS , Log.DELEG, Nul.FALSE, Inv.FALSE, Glo.FALSE, null     , null     , null    , null     , null     , null     , null     , CTL_PRED , null     , null     );
		new QVTdCGValuedElementModelSpec(CGPropertyAssignment.class, "initValue",		Box.DELEG, Ref.DELEG, null     , null     , null     , Glo.FALSE, null     , null     , null    , null     , null     , null     , null     , null     , null     , null     );

		new QVTdCGValuedElementModelSpec(CGMapping.class, null,							Box.BIBOX, null     , null     , null     , null     , null     , null     , null     , Ct.TRUE , null     , null     , null     , Ctx.TRUE , CTL_BODY , null     , null     );
		new QVTdCGValuedElementModelSpec(CGMappingExp.class, null,						Box.BIBOX, null     , null     , null     , null     , null     , null     , null     , null    , null     , null     , null     , null     , null     , null     , null     );
	}
	
	protected QVTdCGValuedElementModelSpec(@NonNull Class<?> cgClass, @Nullable String delegate,
			@Nullable Box box, @Nullable Ref ref, @Nullable Log log, @Nullable Nul nul, @Nullable Inv inv,
			@Nullable Glo glo, @Nullable Inl inl, @Nullable Set set, @Nullable Ct ct, @Nullable Con con,
			@Nullable Val val, @Nullable Cvl cvl, @Nullable Ctx ctx, @Nullable Ctl ctl, @Nullable Com com, @Nullable Rew rew) {
		super(cgClass, delegate, box, ref, log, nul, inv, glo, inl, set, ct, con, val, cvl, ctx, ctl, com, rew);
	}
}
