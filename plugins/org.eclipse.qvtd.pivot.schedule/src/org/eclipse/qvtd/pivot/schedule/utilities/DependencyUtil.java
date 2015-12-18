package org.eclipse.qvtd.pivot.schedule.utilities;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.qvtd.pivot.schedule.AbstractAction;
import org.eclipse.qvtd.pivot.schedule.AbstractDatum;
import org.eclipse.qvtd.pivot.schedule.Schedule;

public class DependencyUtil 
{
	public static class NaturalOrderer
	{
		private final @NonNull Schedule schedule;

		/**
		 * Set of AbstractDatums that have been fully-produced (all producing actions have been ordered).
		 */
		private final @NonNull Set<AbstractDatum> fullyProducedDatums = new HashSet<AbstractDatum>();

		/**
		 * Set of AbstractDatums that have been partially-produced (at least one producing actions has been ordered).
		 */
		private final @NonNull Set<AbstractDatum> partiallyProducedDatums = new HashSet<AbstractDatum>();

		/**
		 * Queue of AbstractDatums that have been fully produced but whose requirers have yet to be ordered.
		 */
		private final @NonNull Deque<AbstractDatum> fullyReadyDatums = new LinkedList<AbstractDatum>();

		/**
		 * Set of MappingActions whose order has been determined. 
		 */
		private final @NonNull Set<AbstractAction> orderedActions = new HashSet<AbstractAction>();
		private final @NonNull List<AbstractAction> orderedActionList = new ArrayList<AbstractAction>();
		
		public NaturalOrderer(@NonNull Schedule schedule) {
			this.schedule = schedule;
		}

		/**
		 * Assign the next ordered index to abstractAction and update the produced datums accordingly.
		 */
		private void addOrderedAction(@NonNull AbstractAction abstractAction) {
//			System.out.println("Add ordered " + abstractAction);
			assert !orderedActions.contains(abstractAction) : abstractAction.getClass().getSimpleName() + " " + abstractAction + " has already been ordered";
			orderedActions.add(abstractAction);
			orderedActionList.add(abstractAction);
			for (AbstractDatum abstractDatum : abstractAction.getProductions()) {
				partiallyProducedDatums.add(abstractDatum);
//				System.out.println("Partially produced " + abstractDatum);
				boolean fullyProduced = true;
				for (AbstractAction producingAction : abstractDatum.getProducedBy()) {
					if (!orderedActions.contains(producingAction)) {
						fullyProduced = false;
						break;
					}
				}
				if (fullyProduced) {
					boolean isNew = fullyProducedDatums.add(abstractDatum);
//					System.out.println("Fully produced " + abstractDatum);
					assert isNew : abstractDatum.getClass().getSimpleName() + " " + abstractDatum + " has already been fully produced";
					fullyReadyDatums.add(abstractDatum);
//					System.out.println("Fully ready " + abstractDatum);
				}
			}
		}

		/**
		 * Assign an ordering to all the actions so that in so far as possible no action is ordered after an
		 * action that produces one of the requisite inputs. Violations occur for loops.
		 * 
		 * @return null if ok, or a diagnostic message describing the failure to assign an ordering.
		 */
		public @Nullable String assignNaturalOrdering() {

			//
			//	Check that ordering has not yet been attempted
			//
			for (AbstractAction abstractAction : schedule.getActions()) {
				assert abstractAction.getOrder() == 0 : abstractAction.getClass().getSimpleName() + " " + abstractAction + " has been pre-ordered";
			}
			//
			computeOrdering();
			for (int i = 0; i < orderedActionList.size(); i++) {
				orderedActionList.get(i).setOrder(i+1);
			}
			//
			//	Check that ordering happened.
			//
			return diagnoseOrderingFailure();
		}

		/**
		 * Return the actions as an ordered list, or null if an ordering could not be established.
		 */
		public @Nullable List<AbstractAction> computeOrdering() {
			/**
			 * Queue of AbstractDatums that have been partially produced but whose requirers have yet to be ordered.
			 */
			Deque<AbstractAction> partiallyReadyActions = new LinkedList<AbstractAction>();
			/**
			 * Queue of AbstractDatums that have been partially produced but whose requirers have yet to be ordered.
			 */
			Deque<AbstractAction> notReadyActions = new LinkedList<AbstractAction>();
			//
			//	Assign all un-produced AbstractDatum (inputs) to the readyDatums Set.
			//
			// FIXME eAllContents copes with arbitrary depth. Is it more than CallDatum contains PropertyDatum?
			for (TreeIterator<EObject> tit = schedule.eAllContents(); tit.hasNext(); ) {
				EObject eObject = tit.next();
				if (eObject instanceof AbstractDatum) {
//					System.out.println("For " + eObject);
					AbstractDatum abstractDatum = (AbstractDatum) eObject;
					if (abstractDatum.getProducedBy().size() == 0) {
						fullyProducedDatums.add(abstractDatum);
//						System.out.println("Fully produced " + eObject);
						partiallyProducedDatums.add(abstractDatum);
//						System.out.println("Partially produced " + eObject);
						if (!fullyReadyDatums.contains(abstractDatum)) {
							fullyReadyDatums.add(abstractDatum);
//							System.out.println("Fully ready " + eObject);
						}
					}
				}
				else {
					tit.prune();
				}
			}
			//
			//	Service the fully ready datum queue when not empty falling back to partially ready action queue.
			//	Each requiring action of a full ready datum is ordered if all its requisites have already been fully produced,
			//	otherwise the requiring action is placed in the partially ready action queue.
			//	Partially ready actions are also ordered, but may require run-time support to resolve their partially ready requisites. 
			//
			for (boolean hasFullyReadyDatum; (hasFullyReadyDatum = !fullyReadyDatums.isEmpty()) || !partiallyReadyActions.isEmpty() || !notReadyActions.isEmpty(); ) {
				if (hasFullyReadyDatum) {
					AbstractDatum readyDatum = fullyReadyDatums.pop();
					for (AbstractAction candidateAction : readyDatum.getRequiredBy()) {
//						System.out.println("candidateAction " + candidateAction);
						if (!orderedActions.contains(candidateAction)) {
							boolean allRequisitesFullyProduced = true;
							boolean allRequisitesPartiallyProduced = true;
							for (AbstractDatum abstractDatum : candidateAction.getRequisites()) {
								if (!partiallyProducedDatums.contains(abstractDatum)) {
									allRequisitesFullyProduced = false;
									allRequisitesPartiallyProduced = false;
//									System.out.println("  needs1 " + abstractDatum);
									break;
								}
								else if (!fullyProducedDatums.contains(abstractDatum)) {
									allRequisitesFullyProduced = false;
//									System.out.println("  needs2 " + abstractDatum);
								}
							}
							if (allRequisitesFullyProduced) {
								addOrderedAction(candidateAction);
							}
							else if (allRequisitesPartiallyProduced) {
								if (!partiallyReadyActions.contains(candidateAction)) {
									partiallyReadyActions.add(candidateAction);
//									System.out.println("Partially ready push " + candidateAction);
								}
							}
							else { // Some requisite hasn't been produced at all.
								if (!notReadyActions.contains(candidateAction)) {
									notReadyActions.add(candidateAction);
//									System.out.println("Not-ready push " + candidateAction);
								}
							}
						}
					}
				}
				else if (!partiallyReadyActions.isEmpty()) {
					AbstractAction partiallyReadyAction = partiallyReadyActions.pop();
//					System.out.println("Partially ready pop " + partiallyReadyAction);
					if (!orderedActions.contains(partiallyReadyAction)) {			// Might have been fully ordered while queued.
						addOrderedAction(partiallyReadyAction);
					}
				}
				else {
					AbstractAction notReadyAction = notReadyActions.pop();
//					System.out.println("Not-ready pop " + notReadyAction);
					if (!orderedActions.contains(notReadyAction)) {					// Might have been fully ordered while queued.
						addOrderedAction(notReadyAction);
					}
				}
			}
			//
			if (schedule.getActions().size() == orderedActionList.size()) {
				return orderedActionList;
			}
			else {
				return null;
			}
		}

		/**
		 * Return an explanation of the failure to find an order, or null if there was no failure.
		 * @return
		 */
		public @Nullable String diagnoseOrderingFailure() {
			if (schedule.getActions().size() == orderedActionList.size()) {
				return null;
			}
			StringBuilder s = new StringBuilder("Failed to assign an ordering:");
			for (AbstractAction abstractAction : schedule.getActions()) {
				int order = abstractAction.getOrder();
				if (order == 0) {
					s.append("\n\t" + abstractAction.getClass().getSimpleName() + " " + abstractAction + " has not been ordered");
				}
			}
			return s.toString();
		}		
	}
	
	/**
	 * Assign the natural ordering to the dependency graph. Loops in the dependencies
	 * are broken by keeping track of previously ordered mappings.
	 * Although the nested schedule is not affected by this order, it is needed if we want a flat
	 * schedule, or if the nested scheduling fails and we need to fall back to the flat one.
	 * 
	 * @return null if ok, or a diagnostic message describing the failure to assign an ordering.
	 */
	public static @Nullable String assignNaturalOrdering(@NonNull Schedule schedule) {
		NaturalOrderer naturalOrderer = new NaturalOrderer(schedule);
		return naturalOrderer.assignNaturalOrdering();
	}
}
