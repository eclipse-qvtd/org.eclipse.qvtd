package org.eclipse.qvtd.pivot.dependencies.utilities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Class;
import org.eclipse.qvtd.pivot.dependencies.AbstractAction;
import org.eclipse.qvtd.pivot.dependencies.AbstractDatum;
import org.eclipse.qvtd.pivot.dependencies.DependencyGraph;
import org.eclipse.qvtd.pivot.dependencies.MappingAction;


public class DependencyCaches {
	
	private final @NonNull Map<AbstractAction, List<MappingAction>> action2nextActions = new HashMap<AbstractAction, List<MappingAction>>();
	private final @NonNull Map<AbstractAction, Set<MappingAction>> action2previousActions = new HashMap<AbstractAction, Set<MappingAction>>();
	private final @NonNull Map<Class, Set<Class>> class2superClassClosure = new HashMap<Class, Set<Class>>();
	private final @NonNull Map<AbstractDatum, Set<AbstractDatum>> datum2superDatumClosure = new HashMap<AbstractDatum, Set<AbstractDatum>>();
	private final @NonNull Map<AbstractDatum, Set<AbstractDatum>> datum2subDatumClosure = new HashMap<AbstractDatum, Set<AbstractDatum>>();
	private final @NonNull Map<AbstractDatum, Set<AbstractAction>> datum2producers = new HashMap<AbstractDatum, Set<AbstractAction>>();
	private final @NonNull Map<AbstractDatum, Set<AbstractAction>> datum2consumers = new HashMap<AbstractDatum, Set<AbstractAction>>();
	private final @NonNull Map<AbstractAction, Set<AbstractDatum>> action2productions = new HashMap<AbstractAction, Set<AbstractDatum>>();
	private final @NonNull Map<AbstractAction, Set<AbstractDatum>> action2requisites = new HashMap<AbstractAction, Set<AbstractDatum>>();
	private final @NonNull List<MappingAction> mappingActions = new ArrayList<MappingAction>();
	private final @NonNull MappingActionsChecker gChecker = new MappingActionsChecker();


	public DependencyCaches(@NonNull DependencyGraph dependencyGraph) {
		for (AbstractAction abstractAction : dependencyGraph.getActions()) {
			if (abstractAction instanceof MappingAction) {
				mappingActions.add((MappingAction) abstractAction);
			}
		}
	}
	
	public @NonNull List<MappingAction> getMappingActions() {
		return Collections.unmodifiableList(mappingActions);
	}
	
	public @NonNull List<MappingAction> getNextActions(@NonNull MappingAction mappingAction) {
		List<MappingAction> nextActionsList = action2nextActions.get(mappingAction);
		if (nextActionsList == null) {
			Set<MappingAction> nextActionsSet = new HashSet<MappingAction>();
			for (AbstractDatum producedDatum : mappingAction.getProductions()) {
				for (AbstractAction nextAction : getConsumers(producedDatum)) {
					if (nextAction instanceof MappingAction) {
						nextActionsSet.add((MappingAction) nextAction);
					}
				}
			}
			nextActionsList = new ArrayList<MappingAction>(nextActionsSet);
			Collections.sort(nextActionsList, MappingActionComparator.INSTANCE);
			action2nextActions.put(mappingAction, nextActionsList);
		}
		return Collections.unmodifiableList(nextActionsList);
	}
	
	public @NonNull Set<MappingAction> getPreviousActions(@NonNull MappingAction mappingAction) {
		Set<MappingAction> previousActions = action2previousActions.get(mappingAction);
		if (previousActions == null) {
			previousActions = new HashSet<MappingAction>();
			for (AbstractDatum requiredDatum : mappingAction.getRequisites()) {
				for (AbstractAction previousAction : getProducers(requiredDatum)) {
					if (previousAction instanceof MappingAction) {
//						previousActions.add((MappingAction) previousAction);
						MappingAction pred = (MappingAction) previousAction;
						if (gChecker.haveCompatibleInputs(mappingAction, pred)&&
							gChecker.isGuardedAction(pred) &&
							gChecker.isGuardedAction(mappingAction)) {
							if (gChecker.haveEquivalentGuards(mappingAction, pred)) {
								previousActions.add(pred);
							}	
						} else {
							previousActions.add(pred);
						}
					}
				}
			}
			action2previousActions.put(mappingAction, previousActions);
		}
		return Collections.unmodifiableSet(previousActions);
	}
	
	private @NonNull Set<AbstractDatum> doSubDatumClosure(@NonNull AbstractDatum abstractDatum) {
		Set<AbstractDatum> subClosure = datum2subDatumClosure.get(abstractDatum);
		if (subClosure == null) {
			subClosure = new HashSet<AbstractDatum>();
			subClosure.add(abstractDatum);
			datum2subDatumClosure.put(abstractDatum, subClosure);
			for (@SuppressWarnings("null")@NonNull AbstractDatum subAbstractDatum : abstractDatum.getSub()) {
				subClosure.addAll(doSubDatumClosure(subAbstractDatum));
			}
		}
		return subClosure;
	}
	
	public @NonNull Set<AbstractDatum> getSubDatumClosure(@NonNull AbstractDatum abstractDatum) {
		return Collections.unmodifiableSet(doSubDatumClosure(abstractDatum));
	}
	
	
	private @NonNull Set<Class> doSuperClassClosure(@NonNull Class asClass) {
		Set<Class> superClassClosure = class2superClassClosure.get(asClass);
		if (superClassClosure == null) {
			superClassClosure = new HashSet<Class>();
			superClassClosure.add(asClass);
			class2superClassClosure.put(asClass, superClassClosure);
			for (@SuppressWarnings("null")@NonNull Class superClass : asClass.getSuperClasses()) {
				superClassClosure.addAll(doSuperClassClosure(superClass));
			}
		}
		return superClassClosure;
	}
	
	public @NonNull Set<Class> getSuperClassClosure(@NonNull Class asClass) {
		return Collections.unmodifiableSet(doSuperClassClosure(asClass));
	}

	private @NonNull Set<AbstractDatum> doSuperDatumClosure(@NonNull AbstractDatum abstractDatum) {
		Set<AbstractDatum> superClosure = datum2superDatumClosure.get(abstractDatum);
		if (superClosure == null) {
			superClosure = new HashSet<AbstractDatum>();
			superClosure.add(abstractDatum);
			datum2superDatumClosure.put(abstractDatum, superClosure);
			for (@SuppressWarnings("null")@NonNull AbstractDatum superAbstractDatum : abstractDatum.getSuper()) {
				superClosure.addAll(doSuperDatumClosure(superAbstractDatum));
			}
		}
		return superClosure;
	}
	
	public @NonNull Set<AbstractDatum> getSuperDatumClosure(@NonNull AbstractDatum abstractDatum) {
		return Collections.unmodifiableSet(doSuperDatumClosure(abstractDatum));
	}
	
	/**
	 * @param abstractDatum a given {@link AbstractDatum datum}
	 * @return a set of actions that fully o partially produce the given datum 
	 */
	public Set<AbstractAction> getProducers(@NonNull AbstractDatum abstractDatum) {
		Set<AbstractAction> producers = datum2producers.get(abstractDatum);
		if (producers == null) {
			producers = new HashSet<AbstractAction>();
			datum2producers.put(abstractDatum, producers);
			for (AbstractDatum subDatum :  doSubDatumClosure(abstractDatum)) {
				producers.addAll(subDatum.getProducedBy());
			}
		}
		return producers;
	}
	
	/**
	 * @param abstractDatum a given {@link AbstractDatum datum}
	 * @return a set of actions that fully o partially consume the given datum 
	 */
	public Set<AbstractAction> getConsumers(@NonNull AbstractDatum abstractDatum) {
		Set<AbstractAction> consumers = datum2consumers.get(abstractDatum);
		if (consumers == null) {
			consumers = new HashSet<AbstractAction>();
			datum2consumers.put(abstractDatum, consumers);
			for (AbstractDatum superDatum :  doSuperDatumClosure(abstractDatum)) {
				consumers.addAll(superDatum.getRequiredBy());
			}
		}
		return consumers;
	}
	
	/**
	 * @param abstractAction a given {@link AbstractAction action}
	 * @return a set of datums that that are fully o partially produced by the given action 
	 */
	@NonNull
	public Set<AbstractDatum> getProductions(@NonNull AbstractAction  abstractAction) {
		Set<AbstractDatum> productions = action2productions.get(abstractAction);
		if (productions == null) {
			productions = new HashSet<AbstractDatum>();
			action2productions.put(abstractAction, productions);
			for (AbstractDatum production : abstractAction.getProductions()) {
				productions.add(production);
				productions.addAll(doSuperDatumClosure(production));
			}
		}
		return productions;
	}
	
	/**
	 * @param abstractAction a given {@link AbstractAction action}
	 * @return a set of datums that that are fully o partially consumed by the given action 
	 */
	@NonNull
	public Set<AbstractDatum> getRequisites(@NonNull AbstractAction  abstractAction) {
		Set<AbstractDatum> reqs = action2requisites.get(abstractAction);
		if (reqs == null) {
			reqs = new HashSet<AbstractDatum>();
			action2requisites.put(abstractAction, reqs);
			for (AbstractDatum production : abstractAction.getRequisites()) {
				reqs.add(production);
				reqs.addAll(doSubDatumClosure(production));
			}
		}
		return reqs;
	}
}
