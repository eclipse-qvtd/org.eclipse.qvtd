/*******************************************************************************
 * Copyright (c) 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation based on MtcBroker
 ******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvti.analysis;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.CompleteInheritance;
import org.eclipse.ocl.pivot.internal.complete.CompleteInheritanceImpl;
import org.eclipse.ocl.pivot.CompleteModel;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.InheritanceFragment;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.NavigationCallExp;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.util.Visitable;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.TreeIterable;
import org.eclipse.qvtd.compiler.CompilerProblem;
import org.eclipse.qvtd.compiler.CompilerStep;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.MappingProblem;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtimperative.GuardParameter;
import org.eclipse.qvtd.pivot.qvtimperative.Mapping;
import org.eclipse.qvtd.pivot.qvtimperative.NewStatement;
import org.eclipse.qvtd.pivot.qvtimperative.ObservableStatement;
import org.eclipse.qvtd.pivot.qvtimperative.SetStatement;
import org.eclipse.qvtd.pivot.qvtimperative.Statement;
import org.eclipse.qvtd.pivot.qvtimperative.util.AbstractExtendingQVTimperativeVisitor;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeUtil;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.DomainUsage;

public class QVTiProductionConsumption extends AbstractExtendingQVTimperativeVisitor<@Nullable Object, @Nullable Object>
{
	/**
	 * Connection aggregates the producer/consumer analysis of a CompleteClass property slot value.
	 *
	 * This is for an exact type. The source producer analysis registers production with each
	 * supertype of the actual produced class.
	 */
	private class ConnectionAnalysis
	{
		private final @NonNull CompleteClass completeClass;
		private final @NonNull Property property;
		private final @NonNull List<@NonNull NamedElement> producers = new ArrayList<>();
		private final @NonNull List<@NonNull NavigationCallExp> consumers = new ArrayList<>();

		public ConnectionAnalysis(@NonNull CompleteClass completeClass, @NonNull Property property) {
			this.completeClass = completeClass;
			this.property = property;
		}

		public void addConsumer(@NonNull NavigationCallExp consumer) {
			isDebugTarget(QVTimperativeUtil.getReferredProperty(consumer));
			consumers.add(consumer);
		}

		private void isDebugTarget(@NonNull Property property) {
			String name1 = property.getName();
			if ("fromAttributes".equals(name1)) {
				getClass();
			}
			Property opposite = property.getOpposite();
			if (opposite != null) {
				String name2 = opposite.getName();
				if ("fromAttributes".equals(name2)) {
					getClass();
				}
			}
		}

		public void addProducer(@NonNull NamedElement producer) {
			if (producer instanceof SetStatement) {
				isDebugTarget(QVTimperativeUtil.getTargetProperty((SetStatement)producer));
			}
			else if (producer instanceof GuardParameter) {
				Property successProperty = ((GuardParameter)producer).getSuccessProperty();
				if (successProperty != null) {
					isDebugTarget(successProperty);
				}
			}
			producers.add(producer);
		}

		public void addProducers(@NonNull ConnectionAnalysis connectionAnalysis) {
			isDebugTarget(connectionAnalysis.property);
			producers.addAll(connectionAnalysis.producers);
		}

		//	public @NonNull Property getProperty() {
		//		return property;
		//	}

		public @NonNull List<@NonNull CompleteClass> getAncestors() {
			List<@NonNull CompleteClass> ancestors = new ArrayList<>();
			CompleteClass baseCompleteClass = completeModel.getCompleteClass(QVTimperativeUtil.getOwningClass(property));
			CompleteInheritance baseInheritance = baseCompleteClass.getCompleteInheritance();
			CompleteInheritance derivedInheritance = completeClass.getCompleteInheritance();
			int baseDepth = baseInheritance.getDepth();
			int derivedDepth = derivedInheritance.getDepth();
			for (int i = baseDepth; i <= derivedDepth; i++) {
				Iterable<@NonNull InheritanceFragment> derivedSuperFragments = derivedInheritance.getSuperFragments(i);
				for (@NonNull InheritanceFragment superFragment : derivedSuperFragments) {
					Iterable<@NonNull InheritanceFragment> owningSuperFragments = superFragment.getDerivedInheritance().getSuperFragments(baseDepth);
					for (@NonNull InheritanceFragment owningSuperFragment : owningSuperFragments) {
						if (owningSuperFragment.getBaseInheritance() == baseInheritance) {
							CompleteClass superClass = ((CompleteInheritanceImpl)superFragment.getBaseInheritance()).getCompleteClass();
							ancestors.add(superClass);
						}
					}
				}
			}
			return ancestors;
		}

		@Override
		public String toString() {
			StringBuilder s = new StringBuilder();
			s.append(completeClass.getName());
			s.append("::");
			s.append(property.getName());
			return s.toString();
		}

		public void validate() {
			if ("ClassToTable::fromAttributes".equals(toString())) {
				getClass();
			}
			Summary summary = new Summary(this, null);
			for (@NonNull NamedElement producer : producers) {
				Mapping mapping = QVTimperativeUtil.getContainingMapping(producer);
				summary.setProducer(mapping, completeClass, producer);
			}
			for (@NonNull NavigationCallExp consumer : consumers) {
				Mapping mapping = QVTimperativeUtil.getContainingMapping(consumer);
				summary.setConsumer(mapping, completeClass, consumer);
			}
			System.out.println(summary.appendConnectionAnalysis());
			//	for (@NonNull NamedElement producer : producers) {
			summary.checkProducers();
			//	}
			for (@NonNull NavigationCallExp consumer : consumers) {
				summary.checkConsumer(consumer);
			}
		}
	}

	/**
	 * Summary aggregates the production/consumption timing on a specific Connection.
	 */
	private class Summary
	{
		private final @NonNull ConnectionAnalysis connectionAnalysis;
		private final @Nullable ConnectionAnalysis forConnectionAnalysis;
		private @Nullable Integer firstProducer = null;
		private @Nullable Integer lastProducer = null;
		private @Nullable Integer firstConsumer = null;
		private @Nullable Integer lastConsumer = null;
		private final @NonNull StringBuilder s = new StringBuilder();
		private boolean anyObserve = false;
		private @NonNull List<@NonNull NavigationCallExp> debugConsumers = new ArrayList<>();
		private @NonNull List<@NonNull NamedElement> debugProducers = new ArrayList<>();

		public Summary(@NonNull ConnectionAnalysis connectionAnalysis, @Nullable ConnectionAnalysis forConnectionAnalysis) {
			this.connectionAnalysis = connectionAnalysis;
			this.forConnectionAnalysis = forConnectionAnalysis;
			s.append(connectionAnalysis.toString());
			if (forConnectionAnalysis != null) {
				s.append(" for ");
				s.append(forConnectionAnalysis.toString());
			}
		}

		public @NonNull String appendConnectionAnalysis() {
			Integer firstProducer2 = firstProducer;
			s.append("\n\tproduce " + firstProducer2);
			if (firstProducer2 != null) {
				if ((lastProducer != null) && (lastProducer > firstProducer2)) {
					s.append(".." + lastProducer);
				}
			}
			Integer firstConsumer2 = firstConsumer;
			s.append(" consume " + firstConsumer2);
			if (firstConsumer2 != null) {
				if ((lastConsumer != null) && (lastConsumer > firstConsumer2)) {
					s.append(".." + lastConsumer);
				}
			}
			return s.toString();
		}

		public void checkConsumer(@NonNull NavigationCallExp consumer) {
			//	Property referredProperty = QVTimperativeUtil.getReferredProperty(consumer);
			//	Map<@NonNull CompleteClass, @NonNull ConnectionAnalysis> class2connection = property2class2connection.get(referredProperty);
			//	assert class2connection != null;
			//	CompleteClass completeClass = completeModel.getCompleteClass(QVTimperativeUtil.getOwningClass(referredProperty));
			//	ConnectionAnalysis zbaseConnectionAnalysis = connectionAnalysis; //class2connection.get(completeClass);
			//	assert zbaseConnectionAnalysis != null;
			CompleteClass completeClass = connectionAnalysis.completeClass;
			//	Map<@NonNull CompleteClass, List<@NonNull NamedElement>> class2producers = property2class2producers.get(property);
			//	assert class2producers != null;
			//	List<@NonNull NamedElement> producers = connection.producers;
			//	if (producers != null) {
			//		for (@NonNull NavigationCallExp callExp : connection.consumers) {
			///			Mapping mapping = QVTimperativeUtil.getContainingMapping(callExp);
			//			connection.setConsumer(mapping, asClass, callExp);
			//		}
			//	}
			boolean isObserve = isObserve(consumer);
			Mapping mapping = QVTimperativeUtil.getContainingMapping(consumer);
			int firstPass = mapping.getFirstPass();
			Integer lastProducer2 = lastProducer;
			if (lastProducer2 == null) {
				if (isObserve) {
					StringBuilder s2 = initProblem("Not-produced ", " should not be observed");
					compilerStep.addProblem(new MappingProblem(CompilerProblem.Severity.ERROR, mapping, s2.toString()));
				}
				else {
					Property referredProperty = QVTimperativeUtil.getReferredProperty(consumer);
					CompleteClass baseCompleteClass = completeModel.getCompleteClass(QVTimperativeUtil.getOwningClass(referredProperty));
					Map<@NonNull CompleteClass, @NonNull ConnectionAnalysis> class2connection = property2class2connection.get(referredProperty);
					assert class2connection != null;
					ConnectionAnalysis baseConnectionAnalysis = class2connection.get(baseCompleteClass);
					assert baseConnectionAnalysis != null;
					assert baseConnectionAnalysis != connectionAnalysis;
					Summary summary = new Summary(baseConnectionAnalysis, connectionAnalysis);
					for (@NonNull NamedElement producer2 : baseConnectionAnalysis.producers) {
						Mapping mapping2 = QVTimperativeUtil.getContainingMapping(producer2);
						summary.setProducer(mapping2, completeClass, producer2);
					}
					for (@NonNull NavigationCallExp consumer2 : connectionAnalysis.consumers) {
						Mapping mapping2 = QVTimperativeUtil.getContainingMapping(consumer2);
						summary.setConsumer(mapping2, completeClass, consumer2);
					}
					System.out.println(summary.appendConnectionAnalysis());
					summary.checkConsumer(consumer);
					//	DomainUsage usage = domainUsageAnalysis.getUsage(callExp);
					//	if (!usage.isInput() && !usage.isPrimitive()) {
					//	StringBuilder s2 = initProblem(null, " should be produced");
					//	compilerStep.addProblem(new MappingProblem(CompilerProblem.Severity.ERROR, mapping, s2.toString()));
					//	}
				}
			}
			else if (!isObserve) {
				if (firstPass <= lastProducer2) {
					StringBuilder s2 = initProblem(null, " should be observed");
					compilerStep.addProblem(new MappingProblem(CompilerProblem.Severity.ERROR, mapping, s2.toString()));
				}
			}
			else {
				if (firstPass > lastProducer2) {
					StringBuilder s2 = initProblem(null, " should not be observed");
					compilerStep.addProblem(new MappingProblem(CompilerProblem.Severity.ERROR, mapping, s2.toString()));
				}
			}
		}

		public void checkProducers() {
			if (anyObserve) {
				Integer firstConsumer2 = firstConsumer;
				Integer lastProducer2 = lastProducer;
				if ((firstConsumer2 != null) && (lastProducer2 != null) && (firstConsumer2 <= lastProducer2)) {
					for (@NonNull NamedElement producer : connectionAnalysis.producers) {
						if (!isNotify(producer)) {
							StringBuilder s = initProblem("", " should be notified");
							Mapping mapping = QVTimperativeUtil.getContainingMapping(producer);
							compilerStep.addProblem(new MappingProblem(CompilerProblem.Severity.ERROR, mapping, s.toString()));
						}
					}
				}
			}
		}

		private @NonNull StringBuilder initProblem(@Nullable String prefix, @Nullable String suffix) {
			StringBuilder s = new StringBuilder();
			if (prefix != null) {
				s.append(prefix);
			}
			s.append(connectionAnalysis);
			Integer firstProducer2 = firstProducer;
			s.append(" produced " + firstProducer2);
			if (firstProducer2 != null) {
				Integer lastProducer2 = lastProducer;
				if ((lastProducer2 != null) && (lastProducer2 > firstProducer2)) {
					s.append(".." + lastProducer2);
				}
			}
			Integer firstConsumer2 = firstConsumer;
			s.append(" consumed " + firstConsumer2);
			if (firstConsumer2 != null) {
				if ((lastConsumer != null) && (lastConsumer > firstConsumer2)) {
					s.append(".." + lastConsumer);
				}
			}
			if (suffix != null) {
				s.append(suffix);
			}
			return s;
		}

		private boolean isNotify(NamedElement producer) {
			if (producer instanceof SetStatement) {
				return ((SetStatement)producer).isIsNotify();
			}
			else {
				return false;
			}
		}

		private boolean isObserve(@NonNull NavigationCallExp callExp) {
			Statement statement = QVTimperativeUtil.getContainingStatement(callExp);
			if (statement instanceof ObservableStatement) {
				List<Property> observedProperties = ((ObservableStatement)statement).basicGetObservedProperties();
				if (observedProperties != null) {
					return observedProperties.contains(connectionAnalysis.property);
				}
			}
			return false;
		}

		public void setConsumer(@NonNull Mapping mapping, @NonNull CompleteClass completeClass, @NonNull NavigationCallExp callExp) {
			debugConsumers.add(callExp);
			boolean anObserve = isObserve(callExp);
			if (anObserve) {
				anyObserve  = true;
			}
			int firstPass = mapping.getFirstPass();
			Integer lastPassOrNull = mapping.getLastPass();
			int lastPass = lastPassOrNull != null ? lastPassOrNull : firstPass;
			Integer firstConsumer2 = firstConsumer;
			if ((firstConsumer2 == null) || (firstPass < firstConsumer2)) {
				firstConsumer = firstConsumer2 = firstPass;
			}
			Integer lastConsumer2 = lastConsumer;
			if ((lastConsumer2 == null) || (lastPass > lastConsumer2)) {
				lastConsumer = lastConsumer2 = lastPass;
			}
			s.append("\n\tconsume ");
			s.append(connectionAnalysis);
			s.append(" in ");
			s.append(mapping.getName());
			s.append(" at " + firstPass);
			if (lastPassOrNull != null) {
				s.append(".." + lastPass);
			}
			s.append(" " + (anObserve ? "observe" : "no-observe"));
		}

		public void setProducer(@NonNull Mapping mapping, @NonNull CompleteClass completeClass, @NonNull NamedElement producer) {
			debugProducers.add(producer);
			boolean isNotify = isNotify(producer);
			int firstPass = mapping.getFirstPass();
			@Nullable Integer lastPassOrNull = mapping.getLastPass();
			int lastPass = lastPassOrNull != null ? lastPassOrNull : firstPass;
			Integer firstProducer2 = firstProducer;
			if ((firstProducer2 == null) || (firstPass < firstProducer2)) {
				firstProducer = firstProducer2 = firstPass;
			}
			Integer lastProducer2 = lastProducer;
			if ((lastProducer2 == null) || (lastPass > lastProducer2)) {
				lastProducer = lastProducer2 = lastPass;
			}
			s.append("\n\tproduce ");
			s.append(connectionAnalysis);
			s.append(" in ");
			s.append(mapping.getName());
			s.append(" at " + firstPass);
			if (lastPassOrNull != null) {
				s.append(".." + lastPass);
			}
			s.append(" " + (isNotify ? "notify" : "no-notify"));
		}

		@Override
		public String toString() {
			StringBuilder s = new StringBuilder();
			s.append(connectionAnalysis.toString());
			s.append(" produce ");
			s.append(firstProducer);
			s.append("..");
			s.append(lastProducer);
			s.append(" consume ");
			s.append(firstConsumer);
			s.append("..");
			s.append(lastConsumer);
			return s.toString();
		}
	}

	protected final @NonNull CompilerStep compilerStep;
	protected final @NonNull Resource iResource;
	protected final @NonNull QVTimperativeDomainUsageAnalysis domainUsageAnalysis;
	//	protected final @NonNull Map<org.eclipse.ocl.pivot.@NonNull Class, @NonNull List<@NonNull NamedElement>> class2producers = new HashMap<>();
	protected final @NonNull Map<@NonNull Property, Map<@NonNull CompleteClass, @NonNull ConnectionAnalysis>> property2class2connection = new HashMap<>();
	protected final @NonNull CompleteModel completeModel;

	public QVTiProductionConsumption(@NonNull CompilerStep compilerStep, @NonNull Resource iResource) {
		super(null);
		this.compilerStep = compilerStep;
		this.iResource = iResource;
		this.domainUsageAnalysis = new QVTimperativeDomainUsageAnalysis(compilerStep.getEnvironmentFactory());
		this.completeModel = compilerStep.getEnvironmentFactory().getCompleteModel();
	}

	public void analyze() {
		//
		//	Traverse the model to discover the producers and consumers
		//
		for (@NonNull EObject eObject : new TreeIterable(iResource)) {
			if (eObject instanceof Visitable) {
				((Visitable)eObject).accept(this);
			}
		}
		//
		//	Propagate explicit producers to their sub producers.
		//
		for (@NonNull Property property : property2class2connection.keySet()) {
			Map<@NonNull CompleteClass, @NonNull ConnectionAnalysis> class2connection = property2class2connection.get(property);
			assert class2connection != null;
			for (@NonNull CompleteClass completeClass : class2connection.keySet()) {
				ConnectionAnalysis connectionAnalysis = class2connection.get(completeClass);
				assert connectionAnalysis != null;
				for (@NonNull CompleteClass ancestorClass : connectionAnalysis.getAncestors()) {
					if (ancestorClass != completeClass) {
						ConnectionAnalysis ancestorConnectionAnalysis = class2connection.get(ancestorClass);
						if (ancestorConnectionAnalysis != null) {		// May be null if never explicitly produced/consumed
							connectionAnalysis.addProducers(ancestorConnectionAnalysis);
						}
					}
				}
			}
		}
		//
		//	Propagate explicit derived producers to their super producers.
		//
		for (@NonNull Property property : property2class2connection.keySet()) {
			Map<@NonNull CompleteClass, @NonNull ConnectionAnalysis> class2connection = property2class2connection.get(property);
			assert class2connection != null;
			for (@NonNull CompleteClass completeClass : class2connection.keySet()) {
				ConnectionAnalysis connectionAnalysis = class2connection.get(completeClass);
				assert connectionAnalysis != null;
				for (@NonNull CompleteClass ancestorClass : connectionAnalysis.getAncestors()) {
					if (ancestorClass != completeClass) {
						ConnectionAnalysis ancestorConnectionAnalysis = class2connection.get(ancestorClass);
						if (ancestorConnectionAnalysis != null) {		// May be null if never explicitly produced/consumed
							ancestorConnectionAnalysis.addProducers(connectionAnalysis);
						}
					}
				}
			}
		}
	}

	protected void doProducer(@NonNull NamedElement producer, @NonNull CompleteClass targetClass, @NonNull Property setProperty) {
		//	CompleteClass owningClass = completeModel.getCompleteClass(QVTimperativeUtil.getOwningClass(setProperty));
		//	CompleteInheritance owningInheritance = owningClass.getCompleteInheritance();
		//	CompleteInheritance targetInheritance = targetClass.getCompleteInheritance();
		//	int owningDepth = owningInheritance.getDepth();
		//	int targetDepth = targetInheritance.getDepth();
		//	for (int i = owningDepth; i <= targetDepth; i++) {
		//		Iterable<@NonNull InheritanceFragment> superFragments = targetInheritance.getSuperFragments(i);
		//		for (@NonNull InheritanceFragment superFragment : superFragments) {
		//			Iterable<@NonNull InheritanceFragment> owningSuperFragments = superFragment.getDerivedInheritance().getSuperFragments(owningDepth);
		//			for (@NonNull InheritanceFragment owningSuperFragment : owningSuperFragments) {
		//				if (owningSuperFragment.getBaseInheritance() == owningInheritance) {
		//					CompleteClass superClass = ((CompleteInheritanceImpl)superFragment.getBaseInheritance()).getCompleteClass();
		ConnectionAnalysis connectionAnalysis = getConnectionAnalysis(targetClass, setProperty);
		connectionAnalysis.addProducer(producer);
		//				}
		//			}
		//		}
		//	}
	}

	protected @NonNull ConnectionAnalysis getConnectionAnalysis(@NonNull CompleteClass competeClass, @NonNull Property property) {
		Map<@NonNull CompleteClass, @NonNull ConnectionAnalysis> class2connection = property2class2connection.get(property);
		if (class2connection == null) {
			class2connection = new HashMap<>();
			property2class2connection.put(property, class2connection);
		}
		ConnectionAnalysis connectionAnalysis = class2connection.get(competeClass);
		if (connectionAnalysis == null) {
			connectionAnalysis = new ConnectionAnalysis(competeClass, property);
			class2connection.put(competeClass, connectionAnalysis);
		}
		return connectionAnalysis;
	}

	public void validate() {
		Set<@NonNull Property> allProperties = new HashSet<>(property2class2connection.keySet());
		List<@NonNull Property> sortedProperties = new ArrayList<>(allProperties);
		Collections.sort(sortedProperties, NameUtil.NAMEABLE_COMPARATOR);
		for (@NonNull Property property : sortedProperties) {
			Map<@NonNull CompleteClass, @NonNull ConnectionAnalysis> class2connection = property2class2connection.get(property);
			if (class2connection != null) {
				List<@NonNull CompleteClass> sortedClasses = new ArrayList<>(class2connection.keySet());
				Collections.sort(sortedClasses, NameUtil.NAMEABLE_COMPARATOR);
				for (@NonNull CompleteClass asClass : sortedClasses) {
					ConnectionAnalysis connection = class2connection.get(asClass);
					assert connection != null;
					connection.validate();
				}
			}
		}
	}

	@Override
	public @Nullable Object visiting(@NonNull Visitable visitable) {
		throw new UnsupportedOperationException("Unimplemented " + getClass().getName() + " for " + visitable.eClass().getName());
	}

	@Override
	public @Nullable Object visitElement(@NonNull Element object) {
		return null;
	}

	@Override
	public @Nullable Object visitGuardParameter(@NonNull GuardParameter guardParameter) {
		Property successProperty = guardParameter.getSuccessProperty();
		if (successProperty != null) {
			CompleteClass targetClass = completeModel.getCompleteClass(QVTimperativeUtil.getOwningClass(successProperty));
			doProducer(guardParameter, targetClass, successProperty);
		}
		return null;
	}

	@Override
	public @Nullable Object visitNavigationCallExp(@NonNull NavigationCallExp navigationCallExp) {
		String name = navigationCallExp.getName();
		if (name.equals("owningSource")) {
			getClass();
		}
		Mapping mapping = QVTimperativeUtil.basicGetContainingMapping(navigationCallExp);
		if (mapping != null) {
			Property getProperty = QVTimperativeUtil.getReferredProperty(navigationCallExp);
			DomainUsage usage = domainUsageAnalysis.getUsage(getProperty);
			if (!usage.isInput() && !usage.isPrimitive()) {		// Skip endogenously confusing input
				OCLExpression ownedSource = QVTimperativeUtil.getOwnedSource(navigationCallExp);
				Type sourceType = QVTimperativeUtil.getType(ownedSource);
				CompleteClass sourceCompleteClass = completeModel.getCompleteClass(sourceType);
				ConnectionAnalysis connectionAnalysis = getConnectionAnalysis(sourceCompleteClass, getProperty);
				connectionAnalysis.addConsumer(navigationCallExp);
				Property oppositeProperty = getProperty.getOpposite();
				//	if (oppositeProperty != null) {
				//		Type targetType = QVTimperativeUtil.getType(getProperty);
				//		CompleteClass oppositeCompleteClass = completeModel.getCompleteClass(targetType);
				//		Connection oppositeConnection = getConnection(oppositeCompleteClass, oppositeProperty);
				//		oppositeConnection.addConsumer(navigationCallExp);
				//	}
			}
		}
		return null;
	}

	@Override
	public @Nullable Object visitNewStatement(@NonNull NewStatement newStatement) {
		//	org.eclipse.ocl.pivot.Class newClass = (Class) QVTimperativeUtil.getType(newStatement);
		//	List<@NonNull NamedElement> producers = class2producers.get(newClass);
		//	if (producers == null) {
		//		producers = new ArrayList<>();
		//		class2producers.put(newClass, producers);
		//	}
		//	producers.add(newStatement);
		return null;
	}

	@Override
	public @Nullable Object visitSetStatement(@NonNull SetStatement setStatement) {
		Property setProperty = QVTimperativeUtil.getTargetProperty(setStatement);
		String name = setProperty.getName();
		if (name.equals("fromAttributes")) {
			getClass();
		}
		else if (name.equals("owner")) {
			getClass();
		}
		CompleteClass targetClass = completeModel.getCompleteClass(QVTimperativeUtil.getType(QVTimperativeUtil.getTargetVariable(setStatement)));
		doProducer(setStatement, targetClass, setProperty);
		Property oppositeProperty = setProperty.getOpposite();
		if (oppositeProperty != null) {
			targetClass = completeModel.getCompleteClass(QVTimperativeUtil.getOwningClass(oppositeProperty));
			doProducer(setStatement, targetClass, oppositeProperty);
		}
		return null;
	}

	@Override
	public @Nullable Object visitTransformation(@NonNull Transformation transformation) {
		domainUsageAnalysis.analyzeTransformation(transformation);
		return null;
	}

}
