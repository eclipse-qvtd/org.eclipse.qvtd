/*******************************************************************************
 * Copyright (c) 2015 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/

package org.eclipse.qvtd.pivot.qvtimperative.evaluation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.NavigationCallExp;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.evaluation.EvaluationVisitor;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtcorebase.PropertyAssignment;
import org.eclipse.qvtd.pivot.qvtcorebase.RealizedVariable;
import org.eclipse.qvtd.pivot.qvtcorebase.analysis.DomainUsage;
import org.eclipse.qvtd.pivot.qvtimperative.Mapping;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCall;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCallBinding;
import org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.AssociationStatus;
import org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.AttributeStatus;
import org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.ClassStatus;
import org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.ElementStatus;
import org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.EvaluationStatusFactory;
import org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.MappingStatus;
import org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.PropertyStatus;
import org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.TransformationStatus;

/**
 * An evaluator implementation for OCL expressions.
 */
public class QVTiIncrementalExecutor extends BasicQVTiExecutor
{
	public enum Mode {
		LAZY,						// EvaluationStatus is created lazily where necessary
		INCREMENTAL,				// EvaluationStatus is created for all mapping elements
		REPAIR						// EvaluationStatus is updated for all mapping elements
	};
	
	/**
	 * EvaluationStatusManager creates and locates elements of the EvaluationStatus model.
	 */
	private static class EvaluationStatusManager
	{
		protected final@NonNull MappingAnalysis mappingAnalysis;
		protected final @NonNull TransformationStatus transformationStatus = EvaluationStatusFactory.eINSTANCE.createTransformationStatus();

		private final @NonNull Map<Object, ClassStatus> object2ClassStatus = new HashMap<Object, ClassStatus>();
		
		/**
		 * Non-null list while accumulating damage.
		 */
		private @Nullable Set<MappingStatus> dirtyMappingStatuses = new HashSet<MappingStatus>();

		public EvaluationStatusManager(@NonNull MappingAnalysis mappingAnalysis) {
			this.mappingAnalysis = mappingAnalysis;
		}

		private void allocateDirtyMappingStatuses(@NonNull List<Set<MappingStatus>> depth2dirtyMappingStatuses,
				@NonNull Set<MappingStatus> dirtyMappingStatuses) {
			for (MappingStatus mappingStatus : dirtyMappingStatuses) {
				if (mappingStatus != null) {
					int mappingDepth = EvaluationStatus2DepthVisitor.INSTANCE.visit(mappingStatus);
					while (depth2dirtyMappingStatuses.size() <= mappingDepth) {
						depth2dirtyMappingStatuses.add(null);
					}
					Set<MappingStatus> mappingStatuses = depth2dirtyMappingStatuses.get(mappingDepth);
					if (mappingStatuses == null) {
						mappingStatuses = new HashSet<MappingStatus>();
						depth2dirtyMappingStatuses.set(mappingDepth, mappingStatuses);
					}
					mappingStatuses.add(mappingStatus);
				}
			}
			dirtyMappingStatuses.clear();
		}

		public void checkForDamage(@NonNull Resource resource) {
			for (TreeIterator<EObject> tit = resource.getAllContents(); tit.hasNext(); ) {
				EObject eObject = tit.next();
				ClassStatus classStatus = object2ClassStatus.get(eObject);
				if (classStatus != null) {
					for (AttributeStatus attributeStatus : classStatus.getOwnedAttributeStatuses()) {
						EStructuralFeature eFeature = attributeStatus.getEFeature();
						Object newValue = eObject.eGet(eFeature);
						setNewValue(attributeStatus, newValue);
					}
				}
			}
		}

		private void computeAssociationRecursion(@NonNull EObject aThat, @NonNull EReference that2this, @NonNull Set<EObject> allThese, @NonNull EReference this2that, @NonNull Set<EObject> allThose) {
			Object object = aThat.eGet(that2this);
			if (!that2this.isMany()) {
				allThese.add((EObject)object);
			}
			else {
				@SuppressWarnings("unchecked") List<EObject> moreThese = (List<EObject>)object;
				for (EObject aThis : moreThese) {
					if ((aThis != null) && !allThese.contains(aThis)) {
						allThese.add(aThis);
						computeAssociationRecursion(aThis, this2that, allThose, that2this, allThese);
					}
				}
			}
		}
		
		private @NonNull ClassStatus createClassStatus(/*@NonNull*/ Type type, @NonNull EObject eObject) {
			ClassStatus classStatus = EvaluationStatusFactory.eINSTANCE.createClassStatus();
			classStatus.setType(type);
			classStatus.setEObject(eObject);
			object2ClassStatus.put(eObject, classStatus);
			transformationStatus.getOwnedClassStatuses().add(classStatus);
			return classStatus;
		}

		public @NonNull MappingStatus createMappingStatus(@NonNull MappingCall mappingCall, @NonNull List<Object> boundValues) {
			MappingStatus newMappingStatus = EvaluationStatusFactory.eINSTANCE.createMappingStatus();
			newMappingStatus.setReferredMappingCall(mappingCall);
			newMappingStatus.getBoundValues().addAll(boundValues);
			transformationStatus.getOwnedMappingStatuses().add(newMappingStatus);
			return newMappingStatus;
		}

		private @Nullable PropertyStatus findAssociationStatus(@NonNull ClassStatus classStatus, @NonNull EObject thisObject, @NonNull EReference this2thatEReference) {
			EReference that2thisEReference = this2thatEReference.getEOpposite();
			assert that2thisEReference != null;
			//
			//	Return a pre-existing AssociationStatus
			//
			for (AssociationStatus associationStatus : classStatus.getAssociationStatuses()) {
				EReference eReference = associationStatus.getForwardEReference();
				if (eReference == this2thatEReference) {
					if (associationStatus.getFromClassStatuses().contains(classStatus)) {
						return associationStatus;
					}
				}
				if (eReference == that2thisEReference) {
					if (associationStatus.getToClassStatuses().contains(classStatus)) {
						return associationStatus;
					}
				}
			}
			return null;
		}
		
		private @Nullable AttributeStatus findAttributeStatus(@NonNull ClassStatus classStatus, @NonNull EStructuralFeature eFeature) {
			//
			//	Return a pre-existing AttributeStatus
			//
			for (AttributeStatus attributeStatus : classStatus.getOwnedAttributeStatuses()) {
				if (attributeStatus.getEFeature() == eFeature) {
					return attributeStatus;
				}
			}
			return null;
		}

		private @Nullable ClassStatus findClassStatus(@NonNull EObject eObject) {
			return object2ClassStatus.get(eObject);
		}
		
		public @Nullable PropertyStatus findPropertyStatus(@NonNull EObject thisObject, @NonNull Property property) {
			EObject eFeature = property.getESObject();
			ClassStatus classStatus = findClassStatus(thisObject);
			if (classStatus == null) {
				return null;
			}
			if (eFeature instanceof EReference) {
				EReference eReference = (EReference)eFeature;
				if (eReference.getEOpposite() != null) {
					return findAssociationStatus(classStatus, thisObject, eReference);
				}
			}
			if (eFeature instanceof EStructuralFeature) {
				return findAttributeStatus(classStatus, (EStructuralFeature)eFeature);
			}
			else if (property.isIsImplicit()) {				// Workaround Bug 463966
				throw new UnsupportedOperationException();
			}
			else {
				throw new UnsupportedOperationException();
			}
		}

		private @NonNull PropertyStatus getAssociationStatus(@NonNull ClassStatus classStatus, @NonNull EObject thisObject, @NonNull EReference this2thatEReference) {
			EReference that2thisEReference = this2thatEReference.getEOpposite();
			assert that2thisEReference != null;
			//
			//	Return a pre-existing AssociationStatus
			//
			for (AssociationStatus associationStatus : classStatus.getAssociationStatuses()) {
				EReference eReference = associationStatus.getForwardEReference();
				if (eReference == this2thatEReference) {
					if (associationStatus.getFromClassStatuses().contains(classStatus)) {
						return associationStatus;
					}
				}
				if (eReference == that2thisEReference) {
					if (associationStatus.getToClassStatuses().contains(classStatus)) {
						return associationStatus;
					}
				}
			}
			//
			//	Identify the participating EObjects, recursing for M:N associations
			//
			Set<EObject> allThese = new HashSet<EObject>();
			allThese.add(thisObject);
			Set<EObject> allThose = new HashSet<EObject>();
			computeAssociationRecursion(thisObject, this2thatEReference, allThose, that2thisEReference, allThese);
			//
			//	Create a new AssociationStatus
			//
			AssociationStatus associationStatus = EvaluationStatusFactory.eINSTANCE.createAssociationStatus();
			associationStatus.setForwardEReference(this2thatEReference);
			//
			List<ClassStatus> fromClassStatuses = associationStatus.getFromClassStatuses();
			for (EObject aThis : allThese) {
				ClassStatus fromClassStatus = object2ClassStatus.get(aThis);
				if (fromClassStatus != null) {
					fromClassStatuses.add(fromClassStatus);
					fromClassStatus.getAssociationStatuses().add(associationStatus);
					if (fromClassStatus.isIsInput()) {
						associationStatus.setIsInput(true);
					}
					if (fromClassStatus.isIsOutput()) {
						associationStatus.setIsOutput(true);
						associationStatus.setIsAssignable(true);
					}
					else {
						associationStatus.setIsAssigned(true);
					}
				}
			}
			//
			List<ClassStatus> toClassStatuses = associationStatus.getToClassStatuses();
			for (EObject aThat : allThose) {
				ClassStatus toClassStatus = object2ClassStatus.get(aThat);
				if (toClassStatus != null) {
					toClassStatuses.add(toClassStatus);
					toClassStatus.getAssociationStatuses().add(associationStatus);
					if (toClassStatus.isIsInput()) {
						associationStatus.setIsInput(true);
					}
					if (toClassStatus.isIsOutput()) {
						associationStatus.setIsOutput(true);
						associationStatus.setIsAssignable(true);
					}
					else {
						associationStatus.setIsAssigned(true);
					}
				}
			}
			//
			transformationStatus.getOwnedAssociationStatuses().add(associationStatus);
			return associationStatus;
		}
		
		private @NonNull AttributeStatus getAttributeStatus(@NonNull ClassStatus classStatus, @NonNull EStructuralFeature eFeature) {
			//
			//	Return a pre-existing AttributeStatus
			//
			for (AttributeStatus attributeStatus : classStatus.getOwnedAttributeStatuses()) {
				if (attributeStatus.getEFeature() == eFeature) {
					return attributeStatus;
				}
			}
			//
			//	Create a new AttributeStatus
			//
			AttributeStatus attributeStatus = EvaluationStatusFactory.eINSTANCE.createAttributeStatus();
			attributeStatus.setEFeature(eFeature);
			classStatus.getOwnedAttributeStatuses().add(attributeStatus);
			if (classStatus.isIsOutput()) {
				attributeStatus.setIsAssignable(true);
			}
			else {
				attributeStatus.setIsAssigned(true);
			}
			return attributeStatus;
		}

		public @NonNull ClassStatus getClassStatus(@Nullable DomainUsage domainUsage, /*@NonNull*/ Type type, @NonNull EObject eObject) {
			ClassStatus classStatus = object2ClassStatus.get(eObject);
			if (classStatus == null) {
				classStatus = createClassStatus(type, eObject);
				if ((domainUsage == null) || !isOut(domainUsage)) {
					classStatus.setIsInput(true);
				}
				if ((domainUsage == null) || !isIn(domainUsage)) {
					classStatus.setIsOutput(true);
				}
			}
			return classStatus;
		}
		
		public @NonNull PropertyStatus getPropertyStatus(@Nullable DomainUsage domainUsage, @NonNull EObject thisObject, @NonNull Property property) {
			EObject eFeature = property.getESObject();
			ClassStatus classStatus = getClassStatus(domainUsage, property.getOwningClass(), thisObject);
			PropertyStatus propertyStatus = null;
			if (eFeature instanceof EReference) {
				EReference eReference = (EReference)eFeature;
				if (eReference.getEOpposite() != null) {
					propertyStatus = getAssociationStatus(classStatus, thisObject, eReference);
				}
			}
			if (propertyStatus == null) {
				if (eFeature instanceof EStructuralFeature) {
					propertyStatus = getAttributeStatus(classStatus, (EStructuralFeature)eFeature);
				}
				else if (property.isIsImplicit()) {				// Workaround Bug 463966
					throw new UnsupportedOperationException();
				}
				else {
					throw new UnsupportedOperationException();
				}
			}
			if ((domainUsage != null) && /*(propertyStatus != null) && */isIn(domainUsage) && !mappingAnalysis.isAssigned(property, domainUsage)) {
				propertyStatus.setIsAssignable(false);
				propertyStatus.setIsAssigned(true);
			}
			return propertyStatus;
		}
		
		public @NonNull TransformationStatus getTransformationStatus() {
			return transformationStatus;
		}

		private boolean isIn(@NonNull DomainUsage domainUsage) {
			return !domainUsage.isEnforceable();
		}

		private boolean isOut(@NonNull DomainUsage domainUsage) {
			return domainUsage.isEnforceable() && !domainUsage.isCheckable();
		}
		
		/**
		 * Re-execute the dirtyMappingStatuses resulting from property value changes, and transitively any
		 * downstream mappingStatuses affected by the re-execution.
		 */
		public void repairDamage() {
			Set<MappingStatus> dirtyMappingStatuses2 = dirtyMappingStatuses;
			if (dirtyMappingStatuses2 != null) {
				List<Set<MappingStatus>> depth2dirtyMappingStatuses = new ArrayList<Set<MappingStatus>>();
				for (int cleanDepth = 0; cleanDepth < depth2dirtyMappingStatuses.size(); cleanDepth++) {
					if (dirtyMappingStatuses2.size() > 0) {
						allocateDirtyMappingStatuses(depth2dirtyMappingStatuses, dirtyMappingStatuses2);
					}
					Set<MappingStatus> mappingStatuses = depth2dirtyMappingStatuses.get(cleanDepth);
					if (mappingStatuses != null) {
//						for (MappingStatus mappingStatus : mappingStatuses) {
//						}
					}
					depth2dirtyMappingStatuses.set(cleanDepth, null);
				}
				dirtyMappingStatuses = null;
			}
		}

		protected void setNewValue(@NonNull PropertyStatus propertyStatus, @Nullable Object newValue) {
			if (!propertyStatus.isIsDirty()) {
				if (propertyStatus instanceof AttributeStatus) {
					AttributeStatus attributeStatus = (AttributeStatus)propertyStatus;
					Object oldValue = attributeStatus.getObject();
					if (!ClassUtil.safeEquals(newValue, oldValue)) {
						attributeStatus.setIsDirty(true);
						attributeStatus.setObject(newValue);
					}
				}
				else {
				}
				for (MappingStatus mappingStatus : propertyStatus.getTargets()) {
					mappingStatus.setIsDirty(true);
					Set<MappingStatus> dirtyMappingStatuses2 = dirtyMappingStatuses;
					if (dirtyMappingStatuses2 == null) {
						dirtyMappingStatuses = dirtyMappingStatuses2 = new HashSet<MappingStatus>();
					}
					dirtyMappingStatuses2.add(mappingStatus);
				}
			}
		}
	}

	/**
	 * MappingAnalysis manages additional properties determined by analysis of the Transformation or Mappings.. 
	 */
	private static class MappingAnalysis
	{
		private final @NonNull QVTiTransformationAnalysis transformationAnalysis;
		private final @NonNull Set<Property> hazardousProperties = new HashSet<Property>();
		private final @NonNull Map<Mapping, Set<PropertyAssignment>> mapping2propertyAssignments;
		private final @NonNull Map<Property, Set<PropertyAssignment>> property2propertyAssignments = new HashMap<Property, Set<PropertyAssignment>>();

		public MappingAnalysis(@NonNull QVTiTransformationAnalysis transformationAnalysis) {
			this.transformationAnalysis = transformationAnalysis;
			Set<Mapping> hazardousMappings = transformationAnalysis.getHazardousMappings();
			for (Map.Entry<Mapping, Set<Property>> entry : transformationAnalysis.getMapping2Property().entrySet()) {
				Mapping mapping = entry.getKey();
				if (hazardousMappings.contains(mapping)) {
					hazardousProperties.addAll(entry.getValue());
				}
			}
			mapping2propertyAssignments = transformationAnalysis.getMapping2PropertyAssignments();
			for (Set<PropertyAssignment> propertyAssignments : mapping2propertyAssignments.values()) {
				for (PropertyAssignment propertyAssignment : propertyAssignments) {
					Property property = propertyAssignment.getTargetProperty();
					Set<PropertyAssignment> assignments = property2propertyAssignments.get(property);
					if (assignments == null) {
						assignments = new HashSet<PropertyAssignment>();
						property2propertyAssignments.put(property, assignments);
					}
					assignments.add(propertyAssignment);
				}
			}
		}

		public boolean hasHazardousRead(@NonNull MappingCall mappingCall) {
			for (MappingCallBinding callBinding : mappingCall.getBinding()) {
				if (callBinding.isIsPolled()) {
					return true;
				}
			}
			return false;
		}

		public boolean hasHazardousWrite(@NonNull MappingCall mappingCall) {
			Mapping mapping = mappingCall.getReferredMapping();
			Set<PropertyAssignment> propertyAssignments = mapping2propertyAssignments.get(mapping);
			if (propertyAssignments == null) {
				return false;
			}
			for (PropertyAssignment propertyAssignment : propertyAssignments) {
				Property assignedProperty = propertyAssignment.getTargetProperty();
				if (hazardousProperties.contains(assignedProperty)) {
					return true;
				}
			}
			return false;
		}

		public boolean isAssigned(@NonNull Property targetProperty, @NonNull DomainUsage domainUsage) {
			Set<PropertyAssignment> propertyAssignments = property2propertyAssignments.get(targetProperty);
			if (propertyAssignments == null) {
				return false;
			}
			for (PropertyAssignment propertyAssignment : propertyAssignments) {
				OCLExpression slotExpression = propertyAssignment.getSlotExpression();
				DomainUsage slotUsage = transformationAnalysis.getDomainUsageAnalysis().getUsage(slotExpression);
				if (domainUsage == slotUsage) {
					return true;
				}
			}
			return false;
		}

		public boolean isHazardous(@NonNull Property targetProperty) {
			return hazardousProperties.contains(targetProperty);
		}

	}
	
	/**
	 * MappingInvocations manages the potentially repested mapping invocations, ensuring that repetitions are suppressed. 
	 */
	private static class MappingInvocations
	{
		protected final @NonNull EvaluationStatusManager statusManager;
		
		private final @NonNull Map<Integer, List<MappingStatus>> map = new HashMap<Integer, List<MappingStatus>>();
		
		public MappingInvocations(@NonNull EvaluationStatusManager statusManager) {
			this.statusManager = statusManager;
		}

		/**
		 * Return a new MappingStatus if mappingCall and boundValues represent a new mapping invocation.
		 * Return null if they represent a repeated invocation.
		 */
		public @Nullable MappingStatus createUnrepeatedMappingStatus(@NonNull MappingCall mappingCall, @NonNull List<Object> boundValues) {
			Mapping referredMapping = mappingCall.getReferredMapping();
			int newHashCode = referredMapping.hashCode();
			for (Object boundValue : boundValues) {
				newHashCode = 3 * newHashCode + (boundValue != null ? boundValue.hashCode() : null);
			}
			List<MappingStatus> mappingStatuses = map.get(newHashCode);
			if (mappingStatuses != null) {
				for (MappingStatus oldMappingStatus : mappingStatuses) {
					if (oldMappingStatus.getReferredMappingCall() == referredMapping) {
						List<Object> oldValues = oldMappingStatus.getBoundValues();
						if (oldValues.equals(boundValues)) {
							return null;
						}
					}
				}
			}
			else {
				mappingStatuses = new ArrayList<MappingStatus>();
				map.put(newHashCode, mappingStatuses);
			}
			MappingStatus newMappingStatus = statusManager.createMappingStatus(mappingCall, boundValues);
			mappingStatuses.add(newMappingStatus);
			return newMappingStatus;
		}
	}
	
	/**
	 * PendingInvocations manges the Mapping invocations that are initially blockeed as a result of a failure to excute
	 * and then unblocked once the problme is resulved and theya rea ready for a re-invocation.
	 */
	private static class PendingInvocations
	{
		/**
		 * Mapping invocations that failed due to a not-ready value that is still not-ready.
		 */
		private final @NonNull Set<MappingStatus> blockedMappingStatuses = new HashSet<MappingStatus>();
		
		/**
		 * Non-null while mapping invocations that failed due to a not-ready value that is now ready.
		 */
		private @Nullable Set<MappingStatus> unblockedMappingStatuses = null;

		public void block(@NonNull MappingStatus mappingStatus) {
			assert !mappingStatus.isIsBlocked();
			mappingStatus.setIsBlocked(true);
			blockedMappingStatuses.add(mappingStatus);
			Set<MappingStatus> unblockedMappingStatuses2 = unblockedMappingStatuses;
			if (unblockedMappingStatuses2 != null) {
				unblockedMappingStatuses2.remove(mappingStatus);
			}
		}

		public void flush(@NonNull QVTiIncrementalExecutor executor, @NonNull EvaluationVisitor undecoratedVisitor) {
			while (unblockedMappingStatuses != null) {
				List<MappingStatus> unblockingMappingStatuses = new ArrayList<MappingStatus>(unblockedMappingStatuses);
				unblockedMappingStatuses = null;
				for (@SuppressWarnings("null")@NonNull MappingStatus unblockingMappingStatus : unblockingMappingStatuses) {
					executor.internalExecuteMappingCallRetry(unblockingMappingStatus, undecoratedVisitor);
				}
			}
		}

		public void unblock(@NonNull MappingStatus mappingStatus) {
			assert mappingStatus.isIsBlocked();
			boolean didRemove = blockedMappingStatuses.remove(mappingStatus);
			assert didRemove;
			mappingStatus.setIsBlocked(false);
			Set<MappingStatus> unblockedMappingStatuses2 = unblockedMappingStatuses;
			if (unblockedMappingStatuses2 == null) {
				unblockedMappingStatuses = unblockedMappingStatuses2 = new HashSet<MappingStatus>();
			}
			boolean didAdd = unblockedMappingStatuses2.add(mappingStatus);
			assert didAdd;
		}
	}
	
	protected final @NonNull Mode mode;
	protected final @NonNull PendingInvocations pendingInvocations = new PendingInvocations();
	protected final @NonNull MappingAnalysis mappingAnalysis;
	protected final @NonNull Stack<MappingStatus> mappingStatusStack = new Stack<MappingStatus>();
	protected final @NonNull EvaluationStatusManager statusManager;
	protected final @NonNull MappingInvocations mappingInvocations;
	
	public QVTiIncrementalExecutor(@NonNull QVTiEnvironmentFactory environmentFactory, @NonNull URI transformationURI, @NonNull Mode mode) throws IOException {
		super(environmentFactory, transformationURI);
		this.mode = mode;
		QVTiTransformationAnalysis transformationAnalysis = getModelManager().getTransformationAnalysis();
		this.mappingAnalysis = new MappingAnalysis(transformationAnalysis);
		this.statusManager = new EvaluationStatusManager(mappingAnalysis);
		this.mappingInvocations = new MappingInvocations(statusManager);
	}

	protected @Nullable MappingStatus findMappingStatus() {
		if (mappingStatusStack.isEmpty()) {
			return null;
		}
		MappingStatus mappingStatus = mappingStatusStack.peek();
//		assert mappingStatus != null;
		return mappingStatus;
	}
	
	public @NonNull TransformationStatus getTransformationStatus() {
		return statusManager.getTransformationStatus();
	}
	
	@Override
	public @Nullable Object internalExecuteMappingCall(@NonNull MappingCall mappingCall, @NonNull EvaluationVisitor undecoratedVisitor) {
		List<Object> newBoundValues = new ArrayList<Object>();
		for (MappingCallBinding binding : mappingCall.getBinding()) {
			Variable boundVariable = ClassUtil.nonNullModel(binding.getBoundVariable());
			Object valueOrValues = getValueOf(boundVariable);
			newBoundValues.add(valueOrValues);
		}
		MappingStatus mappingStatus = null;
		if (mappingCall.isIsInfinite()) {
			mappingStatus = mappingInvocations.createUnrepeatedMappingStatus(mappingCall, newBoundValues);
			if (mappingStatus == null) {
				return false;
			}
		}
		if ((mode != Mode.LAZY) || mappingAnalysis.hasHazardousRead(mappingCall) || mappingAnalysis.hasHazardousWrite(mappingCall)) {
			mappingStatus = statusManager.createMappingStatus(mappingCall, newBoundValues);
		}
		mappingStatusStack.push(mappingStatus);
		try {
			Object returnStatus = super.internalExecuteMappingCall(mappingCall, undecoratedVisitor);
			mappingStatusStack.pop();
			pendingInvocations.flush(this, undecoratedVisitor);
			return returnStatus;
		}
		catch (NotReadyValueException e) {
			mappingStatusStack.pop();
			if (mappingStatus == null) {			// If LAZY execution deferred creating the MappingStatus
				mappingStatus = statusManager.createMappingStatus(mappingCall, newBoundValues);
			}
			if (!mappingStatus.isIsBlocked()) {
				pendingInvocations.block(mappingStatus);
			}
			return false;
		}
	}

	protected void internalExecuteMappingCallRetry(@NonNull MappingStatus mappingStatus, @NonNull EvaluationVisitor undecoratedVisitor) {
		try {
			mappingStatusStack.push(mappingStatus);
			MappingCall mappingCall = mappingStatus.getReferredMappingCall();
			assert mappingCall != null;
			EList<Object> boundValues = mappingStatus.getBoundValues();
			List<MappingCallBinding> bindings = mappingCall.getBinding();
			int iMax = bindings.size();
			for (int i = 0; i < iMax; i++) {
				MappingCallBinding binding = bindings.get(i);
				Variable boundVariable = ClassUtil.nonNullModel(binding.getBoundVariable());
				Object valueOrValues = boundValues.get(i);
				replace(boundVariable, valueOrValues);
			}
			super.internalExecuteMappingCall(mappingCall, undecoratedVisitor);
		}
		catch (NotReadyValueException e) {
			if (!mappingStatus.isIsBlocked()) {
				pendingInvocations.block(mappingStatus);
			}
		}
		finally {
			mappingStatusStack.pop();
		}
	}

	@Override
	public @Nullable Object internalExecuteNavigationCallExp(@NonNull NavigationCallExp navigationCallExp, @NonNull Property referredProperty, @Nullable Object object) {
		MappingStatus mappingStatus = findMappingStatus();
		PropertyStatus propertyStatus = null;
		if ((mappingStatus != null) && mappingAnalysis.isHazardous(referredProperty)) {
			assert object != null;
			OCLExpression source = navigationCallExp.getOwnedSource();
			DomainUsage domainUsage = source != null ? getEvaluationEnvironment().getUsageFor(source) : null;
			propertyStatus = statusManager.getPropertyStatus(domainUsage, (EObject)object, referredProperty);
			List<ElementStatus> mappingInputs = mappingStatus.getInputs();
			if (!mappingInputs.contains(propertyStatus)) {
				mappingInputs.add(propertyStatus);
			}
			if (!propertyStatus.isIsAssigned()) {
				Type type = referredProperty.getType();
				if (!(type instanceof CollectionType) || (((CollectionType)type).getLowerValue().signum() > 0)) {
					propertyStatus.setIsError(true);
					throw new NotReadyValueException("Reading unassigned value");
				}
			}
			propertyStatus.setIsAssignable(false);
		}
		Object propertyValue = super.internalExecuteNavigationCallExp(navigationCallExp, referredProperty, object);		// FIXME values
		if (mode == Mode.LAZY) {
			return propertyValue;
		}
//		MappingStatus mappingStatus = findMappingStatus();
		if (mappingStatus == null) {
			return propertyValue;
		}
				
			if (propertyStatus instanceof AttributeStatus) {
				AttributeStatus attributeStatus = (AttributeStatus)propertyStatus;
				ClassStatus classStatus = attributeStatus.getOwningClassStatus();
				if (!classStatus.isIsOutput()) {				// Pure input
					attributeStatus.setObject(propertyValue);
					attributeStatus.setIsDirty(false);
					attributeStatus.setIsError(false);
				}
				else {											// Pure output or intermediate output-input
					if (!attributeStatus.isIsAssigned()) {
						propertyValue = new NotReadyValueException("Missing required value");
						attributeStatus.setIsError(true);
						throw (NotReadyValueException)propertyValue;
					}
//					propertyStatus.setRuntimeObject(propertyValue);
//					propertyStatus.setIsDirty(false);
				}
			}
/*			ClassStatus classStatus = propertyStatus.getOwningClassStatus();
			if (!classStatus.isIsOutput()) {				// Pure input
				propertyStatus.setRuntimeObject(propertyValue);
				propertyStatus.setIsDirty(false);
			}
			else {											// Pure output or intermediate output-input
				if (!propertyStatus.isIsAssigned()) {
					propertyValue = new NotReadyValueException("Missing required value");
					propertyStatus.setIsError(true);
					throw (NotReadyValueException)propertyValue;
				}
//				propertyStatus.setRuntimeObject(propertyValue);
//				propertyStatus.setIsDirty(false);
			} */
//		}
		return propertyValue;
	}

	@Override
	public @Nullable Object internalExecutePropertyAssignment(@NonNull PropertyAssignment propertyAssignment, @NonNull Object object, @Nullable Object ecoreValue) {
		Object propertyValue = super.internalExecutePropertyAssignment(propertyAssignment, object, ecoreValue);
		Property targetProperty = propertyAssignment.getTargetProperty();
		assert targetProperty != null;
		PropertyStatus propertyStatus;
		if ((mode == Mode.LAZY) && !mappingAnalysis.isHazardous(targetProperty)) {
			propertyStatus = statusManager.findPropertyStatus((EObject)object, targetProperty);
			if (propertyStatus == null) {
				return propertyValue;
			}
		}
		else {
			DomainUsage domainUsage = getEvaluationEnvironment().getUsageFor(propertyAssignment.getSlotExpression());
			propertyStatus = statusManager.getPropertyStatus(domainUsage, (EObject)object, targetProperty);
			MappingStatus mappingStatus = findMappingStatus();
			assert mappingStatus !=  null;
			mappingStatus.getOutputs().add(propertyStatus);
		}
		if (!propertyStatus.isIsAssignable()) {				// Pure input
			propertyValue = new InvalidValueException("Illegal assignment");
			propertyStatus.setIsError(true);
		}
		else {
			propertyStatus.setIsAssigned(true);		// ?? not isAssignable for Attributes ?
			propertyStatus.setIsError(false);
			for (MappingStatus targetMappingStatus : propertyStatus.getTargets()) {
				if (targetMappingStatus.isIsBlocked()) {
					pendingInvocations.unblock(targetMappingStatus);
				}
			}
			if (propertyStatus instanceof AttributeStatus) {
				AttributeStatus attributeStatus = (AttributeStatus)propertyStatus;
				attributeStatus.setObject(propertyValue);
				attributeStatus.setIsAssignable(false);
	//			propertyStatus.setIsDirty(false);
				if (!attributeStatus.isIsDirty()) {
					Object oldValue = attributeStatus.getObject();
					if (!ClassUtil.safeEquals(propertyValue, oldValue)) {
						for (MappingStatus targetMappingStatus : attributeStatus.getTargets()) {
							targetMappingStatus.setIsDirty(true);
							pendingInvocations.unblock(targetMappingStatus);
						}
					}
				}
			}
			else if (propertyStatus instanceof AssociationStatus) {
				AssociationStatus associationStatus = (AssociationStatus)propertyStatus;
//				attributeStatus.setObject(propertyValue);
				associationStatus.setIsAssigned(true);
	//			propertyStatus.setIsDirty(false);
/*				Set<MappingStatus> dirtyMappingStatuses2 = dirtyMappingStatuses;
				if (dirtyMappingStatuses2 != null) {
					if (!attributeStatus.isIsDirty()) {
						Object oldValue = attributeStatus.getObject();
						if (!ClassUtil.safeEquals(propertyValue, oldValue)) {
							for (MappingStatus mappingStatus : attributeStatus.getTargets()) {
								mappingStatus.setIsDirty(true);
								dirtyMappingStatuses2.add(mappingStatus) ;
							}
						}
					}
				} */
			}
		}
		return propertyValue;
	}
	@Override
	public @Nullable Object internalExecuteRealizedVariable(@NonNull RealizedVariable realizedVariable, @NonNull EvaluationVisitor undecoratedVisitor) {
		Object element = super.internalExecuteRealizedVariable(realizedVariable, undecoratedVisitor);
		if ((element != null) && (mode == Mode.INCREMENTAL)) {
			DomainUsage domainUsage = getEvaluationEnvironment().getUsageFor(realizedVariable);
			ClassStatus classStatus = statusManager.getClassStatus(domainUsage, realizedVariable.getType(), (EObject)element);
			MappingStatus mappingStatus = findMappingStatus();
			assert mappingStatus != null;
			mappingStatus.getOutputs().add(classStatus);
		}
		return element;
	}

	@Override
	public @Nullable Object internalExecuteTransformation(@NonNull Transformation transformation, @NonNull EvaluationVisitor undecoratedVisitor) {
		Object returnStatus = super.internalExecuteTransformation(transformation, undecoratedVisitor);
		pendingInvocations.flush(this, undecoratedVisitor);
		return returnStatus;
	}
}
