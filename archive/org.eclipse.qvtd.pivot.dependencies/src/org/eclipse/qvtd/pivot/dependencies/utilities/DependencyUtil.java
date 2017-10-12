package org.eclipse.qvtd.pivot.dependencies.utilities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.pivot.dependencies.AbstractAction;
import org.eclipse.qvtd.pivot.dependencies.AbstractDatum;
import org.eclipse.qvtd.pivot.dependencies.ClassDatum;
import org.eclipse.qvtd.pivot.dependencies.DependencyGraph;
import org.eclipse.qvtd.pivot.dependencies.PropertyDatum;

public class DependencyUtil 
{
	private enum Readyness {
		NONE,
		FULLY,
		PARTIALlY,
	}
	
	public static class OrderingResult {
		
		public static class LoopStart {
			
			private AbstractAction loopEntryAction;
			
			private List<AbstractDatum> partiallyReadyDatums;

			public LoopStart(AbstractAction loopActionEntry, List<AbstractDatum> partiallyReadyDatums) {
				this.loopEntryAction = loopActionEntry;
				this.partiallyReadyDatums = partiallyReadyDatums;
			}
			
			public AbstractAction getLoopActionEntrance() {
				return loopEntryAction;
			}

			public List<AbstractDatum> getPartiallyReadyDatums() {
				return partiallyReadyDatums;
			}
		}	
		
		@NonNull
		private List<LoopStart> loopStarts = new ArrayList<>();
		private List<AbstractAction> unresolvedActions = new ArrayList<>();
		
		@SuppressWarnings("null")
		@NonNull
		public  List<LoopStart> getLoopStarts() {
			return Collections.unmodifiableList(loopStarts);
		}
		
		protected void addLoopStart(LoopStart loopStart) {
			loopStarts.add(loopStart);
		}
		
		@SuppressWarnings("null")
		@NonNull 
		public List<AbstractAction> getUnresolvedActions() {
			return Collections.unmodifiableList(unresolvedActions);
		}
		
		protected void addUnresolvedAction(AbstractAction action) {
			unresolvedActions.add(action);
		}
	}
	
	private static class NaturalOrderer
	{
		private final @NonNull DependencyGraph dependencyGraph;

		/**
		 * Set of AbstractDatums that have been fully-produced (all producing actions have been ordered).
		 */
		private final Set<AbstractDatum> fullyProducedDatums = new HashSet<AbstractDatum>();

		/**
		 * Set of AbstractDatums that have been partially-produced (at least one producing actions has been ordered).
		 */
		private final Set<AbstractDatum> partiallyProducedDatums = new HashSet<AbstractDatum>();

		/**
		 * Queue of AbstractDatums that have been fully produced but whose consumer have yet to be ordered.
		 */
		private final Deque<AbstractDatum> fullyReadyDatums = new LinkedList<AbstractDatum>();

		/**
		 * Set of MappingActions whose order has been determined. 
		 */
		private final Set<AbstractAction> orderedActions = new HashSet<AbstractAction>();
		private final List<AbstractAction> debugOrderedActionList = new ArrayList<AbstractAction>();
		
		private final DependencyCaches depCaches;
		
		private OrderingResult result;
		
		public NaturalOrderer(@NonNull DependencyGraph dependencyGraph) {
			this.dependencyGraph = dependencyGraph;
			this.depCaches = new DependencyCaches(dependencyGraph);
		}

		/**
		 * Assign the next ordered index to abstractAction and update the produced datums accordingly.
		 */
		private void addOrderedAction(@NonNull AbstractAction abstractAction) {
			assert !orderedActions.contains(abstractAction) : abstractAction.getClass().getSimpleName() + " " + abstractAction + " has already been ordered";
			orderedActions.add(abstractAction);
			debugOrderedActionList.add(abstractAction);
			abstractAction.setOrder(orderedActions.size());
			for (AbstractDatum abstractDatum : depCaches.getProductions(abstractAction)) {
				partiallyProducedDatums.add(abstractDatum);
				boolean fullyProduced = true;
				for (AbstractAction producingAction : depCaches.getProducers(abstractDatum)) { 
					if (!hasBeenOrdered(producingAction)) {
						fullyProduced = false;
						break;
					}
				}
				if (fullyProduced) {
					boolean isNew = fullyProducedDatums.add(abstractDatum);
					assert isNew : abstractDatum.getClass().getSimpleName() + " " + abstractDatum + " has already been fully produced";
					fullyReadyDatums.add(abstractDatum);
				}
			}
		}
		
		private void initialDatumProcessing (AbstractDatum abstractDatum) {
			//	Assign all un-produced AbstractDatum (inputs) to the readyDatums Set.
			if (depCaches.getProducers(abstractDatum).size() == 0) {
				fullyProducedDatums.add(abstractDatum);
				partiallyProducedDatums.add(abstractDatum);
				fullyReadyDatums.add(abstractDatum);
			}
			
		}
		
		private boolean hasBeenOrdered(AbstractAction action) {
			return orderedActions.contains(action);
		}
		/**
		 * Assign an ordering to all the actions so that in so far as possible no action is ordered after an
		 * action that produces one of the requisite inputs. Violations occur for loops.
		 * 
		 * @return an OrderingResult instance with the carried result
		 */
		public @NonNull OrderingResult assignNaturalOrdering() {
			//
			//	Check that ordering has not yet been attempted
			//
			assert assertGraphIsNotOrdered(dependencyGraph);
			/**
			 * Queue of AbstractDatums that have been partially produced but whose consumers have yet to be ordered.
			 */
			Deque<AbstractAction> partiallyReadyActions = new LinkedList<AbstractAction>();
			
			result = new OrderingResult();
					
			// DependencyGraph -> contains ClassDatums -> contain PropertyDatums
			for (AbstractDatum abstractDatum : dependencyGraph.getDatums()) {
				initialDatumProcessing(abstractDatum);
				if (abstractDatum instanceof ClassDatum) {
					for (PropertyDatum pDatum : ((ClassDatum) abstractDatum).getPropertyDatums()) {
						initialDatumProcessing(pDatum);
					}
				}
			}
	
			int totalNumberOfActions = dependencyGraph.getActions().size();
			//
			//	Service the fully ready datum queue when not empty falling back to partially ready action queue.
			//	Each requiring action of a full ready datum is ordered if all its requisites have already been fully produced,
			//	otherwise the requiring action is placed in the partially ready action queue.
			//	Partially ready actions are also ordered, but may require run-time support to resolve their partially ready requisites. 
			//
			for (boolean hasFullyReadyDatum; (hasFullyReadyDatum = !fullyReadyDatums.isEmpty()) || (!partiallyReadyActions.isEmpty()
					||  (orderedActions.size() < totalNumberOfActions) );) {
				if (hasFullyReadyDatum) {
					AbstractDatum readyDatum = fullyReadyDatums.pop();
					for (AbstractAction candidateAction : depCaches.getConsumers(readyDatum)) {
						if (!hasBeenOrdered(candidateAction)) {
							Readyness actionIsReady = getReadyness(candidateAction);
							switch (actionIsReady) {
							case FULLY:
								addOrderedAction(candidateAction);
								break;
							case PARTIALlY:
								if (!partiallyReadyActions.contains(candidateAction)) {
									partiallyReadyActions.add(candidateAction);
								}
								break;
							case NONE:
								// Some requisite hasn't been produced at all. When it is, it will be reanalyzed.
								break;
							}
						}
					}
				}
				else if (!partiallyReadyActions.isEmpty()) {
					AbstractAction partiallyReadyAction = partiallyReadyActions.pop();
					if (!hasBeenOrdered(partiallyReadyAction)) {			// Might have been fully ordered while queued.
						// Partially ready actions, processed at this point, are the start of the loop :
						// They don't have fullyReady requirement, because the execution of the action
						// will produce them
						addOrderedAction(partiallyReadyAction);
						processLoopStart(partiallyReadyAction);
						
					}
				} else {
					// Actions not reached from initially ready input datums
					// These action can:
					//    - either require an output never produced
					//    - or belong to a loop start whose inputs are never partially produced (e.g. they produce the input they consume)
					// 
					// For the time being we will order them and add them to the result list of non reachable mappings
					// Note that Action-Datum dependencies don't distinguish those dependencies belonging to branched code (eg. ifExps). Those dependencies
					// are conditional and shouldn't prevent a mapping to be executed, even though, they are not partially produced. This
					// situation prevents some special mappings which partially provide property datums which are further consumed.
					for (AbstractAction action : dependencyGraph.getActions()) {
						if (!hasBeenOrdered(action)) {
							addOrderedAction(action);
							processNonInvokedAction(action);	
							break; // Give another chance to pending actions to be ordered in the normal algorithm
						}
					}
				}
			}
			//
			//	Check that ordering happened.
			//
			assert assertGraphIsOrdered(dependencyGraph);
			
			return result;
		}
		
				private Readyness getReadyness(AbstractDatum datum) {		
			// note that the algorithm ensure that a fullyProduced datum is in the both partially and fully produced queues 
			if (!partiallyProducedDatums.contains(datum)) {
				return Readyness.NONE;
			}
			else if (!fullyProducedDatums.contains(datum)) {
				return Readyness.PARTIALlY;
			} else {
				return Readyness.FULLY; 
			}
			
		}
		
		private Readyness getReadyness(AbstractAction action) {
			boolean allRequisitesFullyProduced = true;
			boolean allRequisitesPartiallyProduced = true;
			for (AbstractDatum abstractDatum : action.getRequisites()) {
				Readyness datumReady = getReadyness(abstractDatum);				
				if (datumReady == Readyness.NONE) {
					allRequisitesFullyProduced = false;
					allRequisitesPartiallyProduced = false;
					break;
				}
				else if (datumReady == Readyness.PARTIALlY) {
					allRequisitesFullyProduced = false;
				}
			}
			if (allRequisitesFullyProduced) {
				return Readyness.FULLY;
			}
			else if (allRequisitesPartiallyProduced) {
				return Readyness.PARTIALlY;
			}
			else {
				return Readyness.NONE;
			}
		}
		
		
		private void processLoopStart(AbstractAction partiallyReadyAction) {
			
			List<AbstractDatum> pReadyDatums = new ArrayList<AbstractDatum>();
			for (AbstractDatum pDatum : partiallyReadyAction.getRequisites()) {
				if (getReadyness(pDatum) == Readyness.PARTIALlY) {
					pReadyDatums.add(pDatum);
				}
			}
			
			result.addLoopStart(new OrderingResult.LoopStart(partiallyReadyAction, pReadyDatums));
		}
		private void processNonInvokedAction(AbstractAction nonInvokedAction) {
			result.addUnresolvedAction(nonInvokedAction);
		}
	}
	
	
	
	
	/**
	 * Assign the natural ordering to the dependency graph. Loops in the dependencies
	 * are broken by keeping track of previously ordered mappings.
	 * Although the nested schedule is not affected by this order, it is needed if we want a flat
	 * schedule, or if the nested scheduling fails and we need to fall back to the flat one.
	 * 
	 */
	@NonNull
	public static OrderingResult assignNaturalOrdering(@NonNull DependencyGraph dependencyGraph) {
		NaturalOrderer naturalOrderer = new NaturalOrderer(dependencyGraph);
		return naturalOrderer.assignNaturalOrdering();
	}
	
	private static boolean assertGraphIsNotOrdered(DependencyGraph dependencyGraph) {
		for (AbstractAction abstractAction : dependencyGraph.getActions()) {
			assert abstractAction.getOrder() == 0 : abstractAction.getClass().getSimpleName() + " " + abstractAction + " has been pre-ordered";
		}
		return true;
	}
	
	public static boolean assertGraphIsOrdered(DependencyGraph dependencyGraph) {
		AbstractAction[] orderedChecks = new AbstractAction[dependencyGraph.getActions().size()];
		for (AbstractAction abstractAction : dependencyGraph.getActions()) {
			int order = abstractAction.getOrder();
			assert order != 0 : abstractAction.getClass().getSimpleName() + " " + abstractAction + " has not been ordered";
			assert orderedChecks[order-1] == null : "conflicting AbstractAction order";
			orderedChecks[order-1] = abstractAction;
		}
		return true;
	}
}
