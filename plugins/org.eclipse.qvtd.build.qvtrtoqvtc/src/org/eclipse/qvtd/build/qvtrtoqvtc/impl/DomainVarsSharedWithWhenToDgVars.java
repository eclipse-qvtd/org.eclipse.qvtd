package org.eclipse.qvtd.build.qvtrtoqvtc.impl;

import java.util.Set;

import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.qvtd.build.qvtrtoqvtc.Bindings;
import org.eclipse.qvtd.build.qvtrtoqvtc.ConstrainedRule;
import org.eclipse.qvtd.build.qvtrtoqvtc.TraceRecord;
import org.eclipse.qvtd.pivot.qvtcorebase.GuardPattern;

public class DomainVarsSharedWithWhenToDgVars extends AbstractRule implements
		ConstrainedRule {
	
	public class DomainVarsSharedWithWhenToDgVarsRecord
			extends AbstractTraceRecord implements TraceRecord {

		// Relations
		private Set<Variable> domainVarsSharedWithWhen;
		
		// Core
		private GuardPattern dg;

		/**
		 * @return the domainVarsSharedWithWhen
		 */
		public Set<Variable> getDomainVarsSharedWithWhen() {
			return domainVarsSharedWithWhen;
		}

		/**
		 * @param domainVarsSharedWithWhen the domainVarsSharedWithWhen to set
		 */
		public void setDomainVarsSharedWithWhen(Set<Variable> domainVarsSharedWithWhen) {
			this.domainVarsSharedWithWhen = domainVarsSharedWithWhen;
		}

		/**
		 * @return the dg
		 */
		public GuardPattern getDg() {
			return dg;
		}

		/**
		 * @param dg the dg to set
		 */
		public void setDg(GuardPattern dg) {
			this.dg = dg;
		}
		
		
		
	}
	
	private DomainVarsSharedWithWhenToDgVarsRecord record;
	
	@Override
	public TraceRecord creareTraceRecord() {
		
		record = new DomainVarsSharedWithWhenToDgVarsRecord();
		return record;
	}

	@Override
	public TraceRecord creareTraceRecord(Bindings bindings) {
		// TODO Auto-generated method stub
		return null;
	}

}
