package org.eclipse.qvtd.build.qvtrtoqvtc.impl;

import org.eclipse.qvtd.build.qvtrtoqvtc.ConstrainedRule;
import org.eclipse.qvtd.build.qvtrtoqvtc.TraceRecord;
import org.eclipse.qvtd.pivot.qvtcorebase.GuardPattern;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;

public class RWhenPatternToMGuardPattern extends AbstractRule implements
		ConstrainedRule {
	
	public class RWhenPatternToMGuardPatternRecord
		extends AbstractTraceRecord implements TraceRecord {
		
		// Relations
		Relation r;
		
		// Core
		GuardPattern mg;

		/**

		 * @return the r
		 */
		public Relation getR() {
			return r;
		}

		/**
		 * @param r the r to set
		 */
		public void setR(Relation r) {
			this.r = r;
		}

		/**
		 * @return the mg
		 */
		public GuardPattern getMg() {
			return mg;
		}

		/**
		 * @param mg the mg to set
		 */
		public void setMg(GuardPattern mg) {
			this.mg = mg;
		}
		
		
		
	}
	
	private RWhenPatternToMGuardPatternRecord record;

	@Override
	public TraceRecord creareTraceRecord() {
		// TODO Auto-generated method stub
		return null;
	}

}
