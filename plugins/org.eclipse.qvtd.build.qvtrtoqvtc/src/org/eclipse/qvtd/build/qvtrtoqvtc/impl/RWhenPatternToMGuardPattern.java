package org.eclipse.qvtd.build.qvtrtoqvtc.impl;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.build.qvtrtoqvtc.CoreBindings;
import org.eclipse.qvtd.build.qvtrtoqvtc.QvtrToQvtcTransformation;
import org.eclipse.qvtd.build.qvtrtoqvtc.RelationsBindings;

public class RWhenPatternToMGuardPattern extends AbstractRule
{
	private static final @NonNull RelationsBindings.KeySet RELATIONS_BINDINGS = new RelationsBindings.KeySet();

	private static final @NonNull CoreBindings.KeySet CORE_BINDINGS = new CoreBindings.KeySet();

	public RWhenPatternToMGuardPattern(@NonNull QvtrToQvtcTransformation transformation) {
		super(transformation);
	}

	public @NonNull CoreBindings.KeySet getCoreBindingsKeys() {
		return CORE_BINDINGS;
	}

	public @NonNull RelationsBindings.KeySet getRelationsBindingsKeys() {
		return RELATIONS_BINDINGS;
	}
	
	
/*	public class RWhenPatternToMGuardPatternRecord
		extends AbstractTraceRecord implements TraceRecord {
		
		// Relations
		Relation r;
		
		// Core
		GuardPattern mg;

		/**

		 * @return the r
		 * /
		public Relation getR() {
			return r;
		}

		/**
		 * @param r the r to set
		 * /
		public void setR(Relation r) {
			this.r = r;
		}

		/**
		 * @return the mg
		 * /
		public GuardPattern getMg() {
			return mg;
		}

		/**
		 * @param mg the mg to set
		 * /
		public void setMg(GuardPattern mg) {
			this.mg = mg;
		}
		
		
		
	} */
}
