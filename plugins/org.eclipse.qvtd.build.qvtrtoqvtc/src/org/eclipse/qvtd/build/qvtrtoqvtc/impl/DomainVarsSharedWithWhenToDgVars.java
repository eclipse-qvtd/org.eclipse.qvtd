package org.eclipse.qvtd.build.qvtrtoqvtc.impl;

import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.qvtd.build.qvtrtoqvtc.CoreBindings;
import org.eclipse.qvtd.build.qvtrtoqvtc.QvtrToQvtcTransformation;
import org.eclipse.qvtd.build.qvtrtoqvtc.RelationsBindings;
import org.eclipse.qvtd.pivot.qvtcorebase.GuardPattern;

public class DomainVarsSharedWithWhenToDgVars extends AbstractRule
{
	// Relations
	private static final @NonNull RelationsBindings.KeySet RELATIONS_BINDINGS = new RelationsBindings.KeySet();
	public static final @NonNull RelationsBindings.Key<Set<Variable>> RELATIONS_domainVarsSharedWithWhen = RELATIONS_BINDINGS.create((Set<Variable>)null, "domainVarsSharedWithWhen");

	// Core
	private static final @NonNull CoreBindings.KeySet CORE_BINDINGS = new CoreBindings.KeySet();
	public static final @NonNull CoreBindings.Key<GuardPattern> CORE_dg = CORE_BINDINGS.create((GuardPattern)null, "dg");

	public DomainVarsSharedWithWhenToDgVars(@NonNull QvtrToQvtcTransformation transformation) {
		super(transformation);
	}
	
	public @NonNull CoreBindings.KeySet getCoreBindingsKeys() {
		return CORE_BINDINGS;
	}

	public @NonNull RelationsBindings.KeySet getRelationsBindingsKeys() {
		return RELATIONS_BINDINGS;
	}
}
