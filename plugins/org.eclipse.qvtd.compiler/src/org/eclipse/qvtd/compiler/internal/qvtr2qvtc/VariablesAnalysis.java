/*******************************************************************************
 * Copyright (c) 2014, 2015 The University of York and Willink Transformations.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Horacio Hoyos - initial API and implementation
 ******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvtr2qvtc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.VariableExp;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.utilities.TreeIterable;
import org.eclipse.qvtd.pivot.qvtcore.Mapping;
import org.eclipse.qvtd.pivot.qvtcore.utilities.QVTcoreHelper;
import org.eclipse.qvtd.pivot.qvtcore.utilities.QVTcoreUtil;
import org.eclipse.qvtd.pivot.qvtcorebase.Area;
import org.eclipse.qvtd.pivot.qvtcorebase.BottomPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.CoreDomain;
import org.eclipse.qvtd.pivot.qvtcorebase.CorePattern;
import org.eclipse.qvtd.pivot.qvtcorebase.RealizedVariable;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvttemplate.CollectionTemplateExp;
import org.eclipse.qvtd.pivot.qvttemplate.TemplateExp;

/**
 * VariablesAnalysis manages all the variables in use by a Relation and its corresponding Mapping.
 */
/*public*/ class VariablesAnalysis extends QVTcoreHelper
{
	/**
	 * Return all variables bound to a single variable within the composition tree of each of asRoots.
	 */
	public static void gatherBoundVariables(@NonNull Set<@NonNull Variable> boundVariables, @NonNull Iterable<@NonNull ? extends Element> asRoots) {		
		for (Element asRoot : asRoots) {
			gatherBoundVariables(boundVariables, asRoot);		
		}
	}
	public static void gatherBoundVariables(@NonNull Set<@NonNull Variable> boundVariables, @NonNull Element asRoot) {		
		for (EObject eObject : new TreeIterable(asRoot, true)) {
			if (eObject instanceof TemplateExp) {
				Variable bindsTo = ((TemplateExp)eObject).getBindsTo();				// ?? CollectionTemplateExp collection is not bound
				if (bindsTo != null) {
					boundVariables.add(bindsTo);
				}
				if (eObject instanceof CollectionTemplateExp) {						// ?? VariableExp members are bound
					Variable rest = ((CollectionTemplateExp)eObject).getRest();		// ?? not bound
					if (rest != null) {
						boundVariables.add(rest);
					}
				}
			}
		}
	}
	
	/**
	 * Return all variables referenced within the composition tree of each of asRoots.
	 */
	public static void gatherReferredVariables(@NonNull Set<@NonNull Variable> referredVariables, @NonNull Iterable<@NonNull ? extends Element> asRoots) {		
		for (Element asRoot : asRoots) {
			gatherReferredVariables(referredVariables, asRoot);		
		}
	}
	public static void gatherReferredVariables(@NonNull Set<@NonNull Variable> referredVariables, @NonNull Element asRoot) {		
		for (EObject eObject : new TreeIterable(asRoot, true)) {
			if (eObject instanceof VariableExp) {
				VariableDeclaration referredVariable = ((VariableExp)eObject).getReferredVariable();
				if (referredVariable instanceof Variable) {
					referredVariables.add((Variable)referredVariable);
				}
			}
			else if (eObject instanceof Variable) {
				referredVariables.add((Variable)eObject);
			}
			else if (eObject instanceof TemplateExp) {
				Variable bindsTo = ((TemplateExp)eObject).getBindsTo();
				if (bindsTo != null) {
					referredVariables.add(bindsTo);
				}
				if (eObject instanceof CollectionTemplateExp) {
					Variable rest = ((CollectionTemplateExp)eObject).getRest();
					if (rest != null) {
						referredVariables.add(rest);
					}
				}
			}
		}
	}
	// TODO bug 453863 // ?? this is suspect for more than 2 domains. // FIXME What is 'shared'? a) any two domains b) output/any-input c) all domains
	/**
	 * Return the variables that are used by more than one domain of the relation and so must be middle variables.
	 */
	public static @NonNull Set<@NonNull Variable> getMiddleDomainVariables(@NonNull Relation rRelation) {	
		Set<@NonNull Variable> rSomeDomainVariables = new HashSet<@NonNull Variable>();
		Set<@NonNull Variable> rMiddleDomainVariables = new HashSet<@NonNull Variable>();
		for (@NonNull Domain rDomain : ClassUtil.nullFree(rRelation.getDomain())) {
			Set<@NonNull Variable> rThisDomainVariables = new HashSet<@NonNull Variable>();
			VariablesAnalysis.gatherReferredVariables(rThisDomainVariables, rDomain);
			for (@NonNull Variable rVariable : rThisDomainVariables) {
				if (!rSomeDomainVariables.add(rVariable)) {
					rMiddleDomainVariables.add(rVariable);				// Accumulate second (and higher) usages
				}
			}
		}
		return rMiddleDomainVariables;
	}

	/**
	 * A VariableAnalysis accumulates the usage of a relation varaible and eventually synthesizes an appropriate core variable.
	 */
	protected class VariableAnalysis
	{
		protected final @NonNull Variable rVariable;
		protected final @NonNull String name;

		private boolean isEnforcedBound = false;
		private boolean isEnforcedReferred = false;
		private @Nullable CoreDomain otherBound = null;
		private boolean isOtherReferred = false;
		private boolean isRoot = false;
		private boolean isWhen = false;
		private boolean isWhere = false;
		private @Nullable Variable cVariable;
		
		private VariableAnalysis(@NonNull Variable rVariable) {
			this.rVariable = rVariable;
			this.name = getUniqueVariableName(ClassUtil.nonNullState(rVariable.getName()), this);
		}

		public @Nullable RealizedVariable basicGetCoreRealizedVariable() {
			return (RealizedVariable)cVariable;
		}

		public @Nullable Variable basicGetCoreVariable() {
			return cVariable;
		}
		
		public void check() {
			if (cVariable == null) {
				System.err.println("No cVariable for " + this);
				return;
			}
			CorePattern cPattern = getCorePattern();
			boolean isRealized = isRealized();
			assert (cVariable != null) && (cVariable.eContainer() == cPattern);
			assert (cVariable instanceof RealizedVariable) == isRealized;
		}

//			public @NonNull TemplateExp getTemplateExp() {
//				return ClassUtil.nonNullState(rTemplateExp);
//			}
		
		private @NonNull CorePattern getCorePattern() {
			Area cArea = null;
			boolean isGuard = false;
			if (isWhen) {
				isGuard = true;
				assert isEnforcedBound || (otherBound != null);
				cArea = isEnforcedBound ? cEnforcedDomain : otherBound;
			}
//				else if (isWhere) {
//				}
			else if (isEnforcedBound) {
				isGuard = false;
				cArea = cEnforcedDomain;
			}
			else if (otherBound != null) {
				isGuard = isRoot;
				cArea = otherBound;
			}
			else if (isEnforcedReferred && isOtherReferred) {
				isGuard = false;
				cArea = cMapping;
			}			
			assert cArea != null;
			return ClassUtil.nonNullState(isGuard ? cArea.getGuardPattern() : cArea.getBottomPattern());
		}

		public @NonNull Variable getCoreVariable() {
			return ClassUtil.nonNullState(cVariable);
		}

		public @NonNull Variable getRelationVariable() {
			return rVariable;
		}
		
		private boolean isRealized() {
			boolean isRealized = false;
			if (isWhen) {
			}
//				else if (isWhere) {
//				}
			else if (isEnforcedBound) {
				isRealized = true;
			}
			return isRealized;
		}

		public void setIsEnforcedBound() {
			assert !isEnforcedBound;
			assert this.otherBound == null;
			this.isEnforcedBound = true;
		}

		public void setIsEnforcedReferred() {
			this.isEnforcedReferred = true;
		}

		public void setIsRoot() {
			this.isRoot = true;
		}

		public void setIsWhen() {
			this.isWhen = true;
		}

		public void setIsWhere() {
			this.isWhere = true;
		}

		public void setOtherBound(@NonNull CoreDomain otherDomain) {
			assert !isEnforcedBound;
			assert this.otherBound == null;
			this.otherBound = otherDomain;
		}

		public void setOtherReferred(@NonNull CoreDomain otherDomain) {
			this.isOtherReferred = true;
		}

		public @NonNull Variable synthesize() {
			CorePattern cPattern = getCorePattern();
			boolean isRealized = isRealized();
			//
			Variable cVariable2 = cVariable;
			assert cVariable2 == null; 
			Type type = ClassUtil.nonNullState(rVariable.getType());
			if (isRealized) {
				RealizedVariable cRealizedVariable = createRealizedVariable(name, type);
				((BottomPattern)cPattern).getRealizedVariable().add(cRealizedVariable);
				cVariable = cVariable2 = cRealizedVariable;
			}
			else {
				cVariable = cVariable2 = createVariable(name, type, rVariable.isIsRequired(), null);
				cPattern.getVariable().add(cVariable2);
			}
			return cVariable2;
		}

		@Override
		public String toString() {
			StringBuilder s = new StringBuilder();
			s.append(rVariable.toString());
			if (isWhen) {
				s.append(" WHEN");
			}
			if (isWhere) {
				s.append(" WHERE");
			}
			if (isRoot) {
				s.append(" ROOT");
			}
			if (isEnforcedBound) {
				s.append(" ENFORCED");
			}
			else if (isEnforcedReferred) {
				s.append(" enforced");
			}
			if (otherBound != null) {
				s.append(" OTHER");
			}
			else if (isOtherReferred) {
				s.append(" other");
			}			
			return s.toString();
		}
	}
	
	protected final @NonNull CoreDomain cEnforcedDomain;						// md: The resultant enforced domain
	protected final @NonNull Mapping cMapping;									// m: The resultant mapping

	/**
	 * Map from the each core variable name in use to an originating object, typically the VariableAnalysis of a relation variable,
	 * but the RElationCallExp of a where, the invoking relation of a call-from invocation, or this for the middle variable.
	 */
	private @NonNull Map<@NonNull String, @NonNull Object> name2originator = new HashMap<@NonNull String, @NonNull Object>();	
	
	/**
	 * The analysis of each relation variable.
	 */
	private final @NonNull Map<@NonNull Variable, @NonNull VariableAnalysis> rVariable2analysis = new HashMap<@NonNull Variable, @NonNull VariableAnalysis>();
	
	public VariablesAnalysis(@NonNull QVTrToQVTc qvtr2qvtc, @NonNull CoreDomain cEnforcedDomain) {
		super(qvtr2qvtc.getEnvironmentFactory());
		this.cEnforcedDomain = cEnforcedDomain;
		this.cMapping = ClassUtil.nonNullState(QVTcoreUtil.getContainingMapping(cEnforcedDomain));
	}
	
	public void check() {
		for (@NonNull VariableAnalysis analysis : rVariable2analysis.values()) {
			analysis.check();
		}
	}
	
	/**
	 * Create a core Variable with a name and type in the middle guard pattern. The variable has no corresponding relation variable.
	 * @param originator 
	 */
	public @NonNull Variable createCoreOnlyVariable(@NonNull String name, @NonNull Type type, @NonNull Element originator) {
		String uniqueName = getUniqueVariableName(name, originator);
		return createVariable(uniqueName, type, true, null);
	}

	public @NonNull Iterable<@NonNull VariableAnalysis> getAnalyses() {
		return rVariable2analysis.values();
	}
	
	public @NonNull Variable getCoreVariable(@NonNull Variable rVariable) {			// doRVarToMVar
		return getVariableAnalysis(rVariable).getCoreVariable();
	}

	public @NonNull String getUniqueVariableName(@NonNull String name, @NonNull Object originator) {
		Object oldOriginator = name2originator.get(name);
		if (oldOriginator != null) {
			assert oldOriginator != originator;		// Lazy re-creation should not occur.
			for (int i = 0; true; i++) {
				String newName = name + "_" + i;
				if (!name2originator.containsKey(newName)) {
					name = newName;
					break;
				}
			}
		}
		name2originator.put(name, originator);
		return name;
	}

	protected @NonNull VariableAnalysis getVariableAnalysis(@NonNull Variable relationVariable) {
		VariableAnalysis analysis = rVariable2analysis.get(relationVariable);
		if (analysis == null) {
			analysis = new VariableAnalysis(relationVariable);
			rVariable2analysis.put(relationVariable, analysis);
		}
		return analysis;
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		List<@NonNull String> names = new ArrayList<@NonNull String>(name2originator.keySet());
		Collections.sort(names);
		for (@NonNull String name : names) {
			if (s.length() > 0) {
				s.append("\n");
			}
			s.append(name + " => " );
			s.append(name2originator.get(name));
		}
		return s.toString();
	}
}
