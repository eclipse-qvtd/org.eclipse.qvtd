/*******************************************************************************
 * Copyright (c) 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtrelation.tests.hstm2fstm;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.xtext.tests.XtextTestCase.Normalizer;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.TreeIterable;
import org.eclipse.qvtd.xtext.qvtbase.tests.ModelNormalizer;

/**
 * UpperToLowerNormalizer normalises the results of the UpperToLower transformation.
 *
 * Even though everything is ordered in the input/output model, the edges/incoming/outgoing lists cn be independently ordered, and only
 * the edges order is preserved in the middle model.
 */
public class FlatStateMachineNormalizer implements ModelNormalizer
{
	public static final @NonNull FlatStateMachineNormalizer INSTANCE = new FlatStateMachineNormalizer();

	protected abstract class AbstractComparator implements Comparator<@NonNull EObject>
	{
		protected final @NonNull EClass eClass;

		public AbstractComparator(@NonNull EClass eClass) {
			this.eClass = eClass;
			eClass2comparator.put(eClass, this);
		}
	}

	protected class StateComparator extends AbstractComparator
	{
		private final @NonNull EAttribute stateName;

		public StateComparator(@NonNull EClass stateClass, @NonNull EAttribute stateName) {
			super(stateClass);
			this.stateName = stateName;
		}

		@Override
		public int compare(@NonNull EObject o1, @NonNull EObject o2) {
			if (eClass.isInstance(o1)) {
				if (!eClass.isInstance(o2)) {
					return 1;
				}
			}
			else {
				if (eClass.isInstance(o2)) {
					return -1;
				}
			}
			String n1 = (String) o1.eGet(stateName);
			String n2 = (String) o2.eGet(stateName);
			return ClassUtil.safeCompareTo(n1, n2);
		}
	}

	protected class StateMachineComparator extends AbstractComparator
	{
		private final @NonNull EAttribute stateMachineName;

		public StateMachineComparator(@NonNull EClass stateMachineClass, @NonNull EAttribute stateMachineName) {
			super(stateMachineClass);
			this.stateMachineName = stateMachineName;
		}

		@Override
		public int compare(@NonNull EObject o1, @NonNull EObject o2) {
			if (eClass.isInstance(o1)) {
				if (!eClass.isInstance(o2)) {
					return 1;
				}
			}
			else {
				if (eClass.isInstance(o2)) {
					return -1;
				}
			}
			String n1 = (String) o1.eGet(stateMachineName);
			String n2 = (String) o2.eGet(stateMachineName);
			return ClassUtil.safeCompareTo(n1, n2);
		}
	}

	protected class TransitionComparator extends AbstractComparator
	{
		private final @NonNull EAttribute transitionName;
		private final @NonNull EReference transitionFromState;
		private final @NonNull EReference transitionToState;
		private final @NonNull EAttribute stateName;

		public TransitionComparator(@NonNull EClass transitionClass, @NonNull EAttribute transitionName,
				@NonNull EReference transitionFromState, @NonNull EReference transitionToState, @NonNull EAttribute stateName) {
			super(transitionClass);
			this.transitionName = transitionName;
			this.transitionFromState = transitionFromState;
			this.transitionToState = transitionToState;
			this.stateName = stateName;
		}

		@Override
		public int compare(@NonNull EObject o1, @NonNull EObject o2) {
			if (eClass.isInstance(o1)) {
				if (!eClass.isInstance(o2)) {
					return 1;
				}
			}
			else {
				if (eClass.isInstance(o2)) {
					return -1;
				}
			}
			String n1 = (String) o1.eGet(transitionName);
			String n2 = (String) o2.eGet(transitionName);
			int diff = ClassUtil.safeCompareTo(n1, n2);
			if (diff != 0) {
				return diff;
			}
			n1 = (String) ((EObject)o1.eGet(transitionFromState)).eGet(stateName);
			n2 = (String) ((EObject)o2.eGet(transitionFromState)).eGet(stateName);
			diff = ClassUtil.safeCompareTo(n1, n2);
			if (diff != 0) {
				return diff;
			}
			n1 = (String) ((EObject)o1.eGet(transitionToState)).eGet(stateName);
			n2 = (String) ((EObject)o2.eGet(transitionToState)).eGet(stateName);
			diff = ClassUtil.safeCompareTo(n1, n2);
			return diff;
		}
	}

	protected abstract class AbstractNormalizer
	{
		protected final @NonNull EClass eClass;

		public AbstractNormalizer(@NonNull EClass eClass) {
			this.eClass = eClass;
			eClass2normalizer.put(eClass, this);
		}

		public abstract void normalize(@NonNull EObject eObject);
	}

	protected class ResourceNormalizer extends AbstractNormalizer
	{
		private final @NonNull EReference stateMachineOwnedStates;
		private final @NonNull StateComparator stateComparator;
		private final @NonNull EReference stateMachineOwnedTransitions;
		private final @NonNull TransitionComparator transitionComparator;

		public ResourceNormalizer(@NonNull EClass stateMachineClass,
				@NonNull EReference stateMachineOwnedStates, @NonNull StateComparator stateComparator,
				@NonNull EReference stateMachineOwnedTransitions, @NonNull TransitionComparator transitionComparator) {
			super(stateMachineClass);
			this.stateMachineOwnedStates = stateMachineOwnedStates;
			this.stateComparator = stateComparator;
			this.stateMachineOwnedTransitions = stateMachineOwnedTransitions;
			this.transitionComparator = transitionComparator;
		}

		@SuppressWarnings("unchecked")
		@Override
		public void normalize(@NonNull EObject eObject) {
			ECollections.sort((EList<EObject>)eObject.eGet(stateMachineOwnedStates), stateComparator);
			ECollections.sort((EList<EObject>)eObject.eGet(stateMachineOwnedTransitions), transitionComparator);
		}
	}

	protected class StateNormalizer extends AbstractNormalizer
	{
		private final @NonNull EReference stateOutTransitions;
		private final @NonNull EReference stateInTransitions;
		private final @NonNull TransitionComparator transitionComparator;

		public StateNormalizer(@NonNull EClass stateClass, @NonNull EReference stateOutTransitions,
				@NonNull EReference stateInTransitions, @NonNull TransitionComparator transitionComparator) {
			super(stateClass);
			this.stateOutTransitions = stateOutTransitions;
			this.stateInTransitions = stateInTransitions;
			this.transitionComparator = transitionComparator;
		}

		@SuppressWarnings("unchecked")
		@Override
		public void normalize(@NonNull EObject eObject) {
			ECollections.sort((EList<EObject>)eObject.eGet(stateOutTransitions), transitionComparator);
			ECollections.sort((EList<EObject>)eObject.eGet(stateInTransitions), transitionComparator);
		}
	}

	protected class StateMachineNormalizer extends AbstractNormalizer
	{
		private final @NonNull EReference stateMachineOwnedStates;
		private final @NonNull StateComparator stateComparator;
		private final @NonNull EReference stateMachineOwnedTransitions;
		private final @NonNull TransitionComparator transitionComparator;

		public StateMachineNormalizer(@NonNull EClass stateMachineClass,
				@NonNull EReference stateMachineOwnedStates, @NonNull StateComparator stateComparator,
				@NonNull EReference stateMachineOwnedTransitions, @NonNull TransitionComparator transitionComparator) {
			super(stateMachineClass);
			this.stateMachineOwnedStates = stateMachineOwnedStates;
			this.stateComparator = stateComparator;
			this.stateMachineOwnedTransitions = stateMachineOwnedTransitions;
			this.transitionComparator = transitionComparator;
		}

		@SuppressWarnings("unchecked")
		@Override
		public void normalize(@NonNull EObject eObject) {
			ECollections.sort((EList<EObject>)eObject.eGet(stateMachineOwnedStates), stateComparator);
			ECollections.sort((EList<EObject>)eObject.eGet(stateMachineOwnedTransitions), transitionComparator);
		}
	}

	protected final @NonNull Map<@NonNull EClass, @NonNull AbstractComparator> eClass2comparator = new HashMap<@NonNull EClass, @NonNull AbstractComparator>();
	protected final @NonNull Map<@NonNull EClass, @NonNull AbstractNormalizer> eClass2normalizer = new HashMap<@NonNull EClass, @NonNull AbstractNormalizer>();

	@Override
	public @NonNull List<@NonNull Normalizer> normalize(@NonNull Resource resource) {
		EObject eRoot = resource.getContents().get(0);
		EPackage ePackage = eRoot.eClass().getEPackage();
		EClass stateClass = (EClass) ClassUtil.nonNullState(ePackage.getEClassifier("State"));
		EClass stateMachineClass = (EClass) ClassUtil.nonNullState(ePackage.getEClassifier("StateMachine"));
		EClass transitionClass = (EClass) ClassUtil.nonNullState(ePackage.getEClassifier("Transition"));
		//
		@NonNull EReference stateMachineOwnedStates = (EReference) ClassUtil.nonNullState(stateMachineClass.getEStructuralFeature("ownedStates"));
		@NonNull EReference stateMachineOwnedTransitions = (EReference) ClassUtil.nonNullState(stateMachineClass.getEStructuralFeature("ownedTransitions"));
		@NonNull EReference stateInTransitions = (EReference) ClassUtil.nonNullState(stateClass.getEStructuralFeature("inTransitions"));
		@NonNull EReference stateOutTransitions = (EReference) ClassUtil.nonNullState(stateClass.getEStructuralFeature("outTransitions"));
		@NonNull EReference transitionFromState = (EReference) ClassUtil.nonNullState(transitionClass.getEStructuralFeature("fromState"));
		@NonNull EReference transitionToState = (EReference) ClassUtil.nonNullState(transitionClass.getEStructuralFeature("toState"));
		//
		@NonNull EAttribute stateName = (EAttribute) ClassUtil.nonNullState(stateClass.getEStructuralFeature("name"));
		@NonNull EAttribute stateMachineName = (EAttribute) ClassUtil.nonNullState(stateMachineClass.getEStructuralFeature("name"));
		@NonNull EAttribute transitionName = (EAttribute) ClassUtil.nonNullState(transitionClass.getEStructuralFeature("name"));
		StateComparator stateComparator = new StateComparator(stateClass, stateName);
		TransitionComparator transitionComparator = new TransitionComparator(transitionClass, transitionName, transitionFromState, transitionToState, stateName);
		StateMachineComparator stateMachineComparator = new StateMachineComparator(stateMachineClass, stateMachineName);
		new StateNormalizer(stateClass, stateOutTransitions, stateInTransitions, transitionComparator);
		new StateMachineNormalizer(stateMachineClass, stateMachineOwnedStates, stateComparator, stateMachineOwnedTransitions, transitionComparator);
		List<@NonNull EObject> eObjects = new ArrayList<@NonNull EObject>();
		for (EObject eContent : resource.getContents()) {
			for (EObject eObject : new TreeIterable(eContent, true)) {
				EClass eClass = eObject.eClass();
				AbstractNormalizer normalizer = eClass2normalizer.get(eClass);
				if (normalizer != null) {
					eObjects.add(eObject);
				}
			}
		}
		for (@NonNull EObject eObject : eObjects) {
			EClass eClass = eObject.eClass();
			AbstractNormalizer normalizer = ClassUtil.nonNullState(eClass2normalizer.get(eClass));
			normalizer.normalize(eObject);
		}
		ECollections.sort(resource.getContents(), stateMachineComparator);
		List<@NonNull Normalizer> normalizers = new ArrayList<>();
		return normalizers;
	}
}