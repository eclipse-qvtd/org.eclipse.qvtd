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
import org.eclipse.ocl.examples.build.modelspecs.CGValuedElementModelSpec;
import org.eclipse.ocl.examples.codegen.cgmodel.CGInvalid;
import org.eclipse.ocl.examples.codegen.java.ImportUtils;
import org.eclipse.qvtd.codegen.qvti.cse.MappingExpPlaces;
import org.eclipse.qvtd.codegen.qvti.cse.PredicatePlaces;
import org.eclipse.qvtd.codegen.qvticgmodel.CGEcoreRealizedVariable;
import org.eclipse.qvtd.codegen.qvticgmodel.CGFunction;
import org.eclipse.qvtd.codegen.qvticgmodel.CGFunctionCallExp;
import org.eclipse.qvtd.codegen.qvticgmodel.CGFunctionParameter;
import org.eclipse.qvtd.codegen.qvticgmodel.CGGuardVariable;
import org.eclipse.qvtd.codegen.qvticgmodel.CGConnectionAssignment;
import org.eclipse.qvtd.codegen.qvticgmodel.CGConnectionVariable;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMapping;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMappingCall;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMappingCallBinding;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMappingExp;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMappingLoop;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMiddlePropertyCallExp;
import org.eclipse.qvtd.codegen.qvticgmodel.CGPredicate;
import org.eclipse.qvtd.codegen.qvticgmodel.CGPropertyAssignment;
import org.eclipse.qvtd.codegen.qvticgmodel.CGRealizedVariable;
import org.eclipse.qvtd.codegen.qvticgmodel.CGSequence;
import org.eclipse.qvtd.codegen.utilities.QVTiEquivalenceUtil;

/**
 * CGValuedElementModelSpec supports generation of the many methods that contribute to the CGValuedElement.xxxx() method hierarchy.
 * <p>
 * The exposition here as a two-dimensional Java table provides a readable, type-checked presentation that would be harder to achieve
 * using a spreadsheet (poor checking) or a model (no 2D tools).  
 */
public class QVTdCGValuedElementModelSpec extends CGValuedElementModelSpec
{
	public static final @NonNull Ctl CTL_MEXP = new Ctl() { public @NonNull String generate(@NonNull CGValuedElementModelSpec cgModelSpec, @NonNull GenModel genModel) {
		return "return " + classRef(MappingExpPlaces.class) + ".createMappingExpPlaces(element2place, this);";
	}};

	public static final @NonNull Ctl CTL_PRED = new Ctl() { public @NonNull String generate(@NonNull CGValuedElementModelSpec cgModelSpec, @NonNull GenModel genModel) {
		return "return " + classRef(PredicatePlaces.class) + ".createPredicatePlaces(element2place, this);";
	}};

	public static final @NonNull Inv INV_PRED = new Inv() {
		@Override public @Nullable String generateGetInvalidValue(@NonNull CGValuedElementModelSpec cgModelSpec, @NonNull GenModel genModel) {
			return classRef(CGInvalid.class) + " invalidValue = (conditionExpression != null) ? conditionExpression.getInvalidValue() : null;\n" +
			"		if (invalidValue == null) {\n" +
			"			invalidValue = (thenExpression != null) ? thenExpression.getInvalidValue() : null;\n" +
			"		}\n" +
			"		return invalidValue;";
		}
		@Override public @Nullable String generateIsInvalid(@NonNull CGValuedElementModelSpec cgModelSpec, @NonNull GenModel genModel) {
			return null;
		}
		@Override public @Nullable String generateIsNonInvalid(@NonNull CGValuedElementModelSpec cgModelSpec, @NonNull GenModel genModel) {
			return "return ((conditionExpression != null) && conditionExpression.isNonInvalid()) && ((thenExpression != null) && thenExpression.isNonInvalid());";	
		}
	};

	public static final @NonNull Log LOG_PRED = new Log() {
		@Override public @NonNull String generateIsFalse(@NonNull CGValuedElementModelSpec cgModelSpec, @NonNull GenModel genModel) {
			return "return ((conditionExpression != null) && conditionExpression.isFalse()) || ((thenExpression != null) && thenExpression.isFalse());";	
		}
		@Override public @NonNull String generateIsTrue(@NonNull CGValuedElementModelSpec cgModelSpec, @NonNull GenModel genModel) {
			return "return ((conditionExpression != null) && conditionExpression.isTrue()) && ((thenExpression != null) && thenExpression.isTrue());";	
		}
	};
	
	public static final @NonNull Eq EQ_EQUIV = new Eq() {
		@Override public @Nullable String generateIsEquivalentTo(@NonNull CGValuedElementModelSpec cgModelSpec, @NonNull GenModel genModel) {
			return null;
		}
		@Override public @Nullable String generateIsEquivalentToInternal(@NonNull CGValuedElementModelSpec cgModelSpec, @NonNull GenModel genModel) {
			String equivalenceUtilImport = ImportUtils.getAffixedName(QVTiEquivalenceUtil.class);
			return "return (getClass() == thatValue.getClass()) ? "+ equivalenceUtilImport + ".isEquivalent(this, (" + cgModelSpec.getCgClass().getSimpleName() + ")thatValue) : null;";
		}
	};

	public static class Register {
	  public Register() {
//		new CGValuedElementModelSpec(CGVariable.class, "init",							null     , Ref.DELEG, null     , Nul.VAR  , Inv.VAR  , null     , null     , null     , null    , null     , null     , null     , null     , null     );
		new QVTdCGValuedElementModelSpec(CGGuardVariable.class, null,					Box.UNBOX, null     , null     , Nul.NEVER, null     , Glo.FALSE, null     , null     , null    , null     , null     , null     , null     , null     , null     , null     , null    );
		new QVTdCGValuedElementModelSpec(CGConnectionVariable.class, null,					Box.BOX,   null     , null     , Nul.NEVER, null     , Glo.FALSE, null     , null     , null    , null     , null     , null     , null     , null     , null     , null     , null    );
		new QVTdCGValuedElementModelSpec(CGRealizedVariable.class, null,				Box.UNBOX, null     , null     , Nul.NEVER, null     , Glo.FALSE, null     , null     , null    , null     , null     , null     , null     , null     , null     , null     , null    );
		new QVTdCGValuedElementModelSpec(CGEcoreRealizedVariable.class, null,			null     , null     , null     , Nul.ASSRT, null     , null     , null     , null     , null    , null     , null     , null     , null     , null     , null     , null     , null    );

		new QVTdCGValuedElementModelSpec(CGFunctionCallExp.class, null,					Box.UNBOX, null     , null     , null     , null     , Glo.FALSE, null     , null     , null    , null     , null     , null     , null     , null     , null     , null     , null    );
		new QVTdCGValuedElementModelSpec(CGFunctionParameter.class, null,				Box.UNBOX, null     , null     , null     , null     , Glo.FALSE, null     , null     , null    , null     , null     , null     , null     , null     , null     , null     , null    );
		new QVTdCGValuedElementModelSpec(CGConnectionAssignment.class, "initValue",			Box.DELEG, null     , null     , null     , null     , Glo.FALSE, null     , null     , null    , null     , null     , null     , null     , null     , Com.FALSE, null     , Eq.UNSUP);
		new QVTdCGValuedElementModelSpec(CGMappingCallBinding.class, "value",			Box.DELEG, null     , null     , null     , null     , Glo.FALSE, null     , null     , null    , null     , null     , null     , null     , null     , Com.FALSE, null     , Eq.SELF );
		new QVTdCGValuedElementModelSpec(CGMiddlePropertyCallExp.class, null,			Box.UNBOX, null     , null     , null     , null     , Glo.FALSE, null     , null     , null    , null     , null     , null     , null     , null     , null     , null     , null    );
		new QVTdCGValuedElementModelSpec(CGPredicate.class, "conditionExpression",		Box.ALL  , null     , LOG_PRED , Nul.NEVER, INV_PRED , Glo.FALSE, null     , null     , null    , null     , null     , null     , null     , CTL_PRED , null     , null     , Eq.SELF );
		new QVTdCGValuedElementModelSpec(CGPropertyAssignment.class, "initValue",		Box.DELEG, null     , null     , null     , null     , Glo.FALSE, null     , null     , null    , null     , null     , null     , null     , null     , null     , null     , EQ_EQUIV);

		new QVTdCGValuedElementModelSpec(CGFunction.class, null,						Box.BOX  , null     , null     , null     , null     , null     , null     , null     , null    , null     , null     , null     , null     , null     , null     , null     , null    );

		new QVTdCGValuedElementModelSpec(CGMapping.class, null,							Box.ALL  , null     , null     , null     , null     , null     , null     , null     , Ct.TRUE , null     , null     , null     , Ctx.TRUE , Ctl.BODY , null     , null     , null    );
		new QVTdCGValuedElementModelSpec(CGMappingExp.class, null,						Box.ALL  , null     , null     , null     , null     , null     , null     , null     , null    , null     , null     , null     , null     , CTL_MEXP , null     , null     , EQ_EQUIV);
		new QVTdCGValuedElementModelSpec(CGSequence.class, null,						null,      null     , null     , null     , null     , null     , null     , null     , null    , null     , null     , null     , null     , null     , null     , null     , Eq.SELF );

		new QVTdCGValuedElementModelSpec(CGMappingCall.class, null,						null     , null     , null     , null     , null     , null     , null     , null     , null    , null     , null     , null     , null     , null     , Com.FALSE, null     , Eq.SELF );
		new QVTdCGValuedElementModelSpec(CGMappingLoop.class, null,						null     , null     , null     , null     , null     , null     , null     , null     , null    , null     , null     , null     , null     , null     , Com.FALSE, null     , Eq.SELF );
	  }
	}
	
	protected QVTdCGValuedElementModelSpec(@NonNull Class<?> cgClass, @Nullable String delegate,
			@Nullable Box box, @Nullable Ths ths, @Nullable Log log, @Nullable Nul nul, @Nullable Inv inv,
			@Nullable Glo glo, @Nullable Inl inl, @Nullable Set set, @Nullable Ct ct, @Nullable Con con,
			@Nullable Val val, @Nullable Cvl cvl, @Nullable Ctx ctx, @Nullable Ctl ctl, @Nullable Com com, @Nullable Rew rew, @Nullable Eq eq) {
		super(cgClass, delegate, box, ths, log, nul, inv, glo, inl, set, ct, con, val, cvl, ctx, ctl, com, rew, eq);
	}
}
