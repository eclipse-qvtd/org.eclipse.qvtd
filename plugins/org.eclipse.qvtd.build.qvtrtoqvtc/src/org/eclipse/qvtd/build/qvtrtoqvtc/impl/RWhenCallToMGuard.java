package org.eclipse.qvtd.build.qvtrtoqvtc.impl;

import org.eclipse.qvtd.build.qvtrtoqvtc.Bindings;
import org.eclipse.qvtd.build.qvtrtoqvtc.QvtrToQvtcTransformation;
import org.eclipse.qvtd.build.qvtrtoqvtc.TraceRecord;
import org.eclipse.qvtd.pivot.qvtbase.Pattern;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;
import org.eclipse.qvtd.pivot.qvtcorebase.GuardPattern;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationCallExp;

public class RWhenCallToMGuard extends AbstractRule {

	// Relations
	public static BindingKey<Pattern> rp = new BindingKey<Pattern>("whenp");
	public static BindingKey<Predicate> pd;
	public static BindingKey<RelationCallExp> e;
	public static BindingKey<Relation> r;
	
	// Core
	public static BindingKey<GuardPattern> mg = new BindingKey<GuardPattern>("mg");
	
	@Override
	public void where(QvtrToQvtcTransformation transformation) {
		
		
	}

}
