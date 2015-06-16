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
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.NavigationCallExp;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.evaluation.EvaluationVisitor;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.qvtd.pivot.qvtcorebase.PropertyAssignment;
import org.eclipse.qvtd.pivot.qvtcorebase.RealizedVariable;
import org.eclipse.qvtd.pivot.qvtcorebase.analysis.DomainUsage;
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
import org.eclipse.qvtd.pivot.qvtimperative.utilities.GraphMLBuilder;

/**
 * An evaluator implementation for OCL expressions.
 */
public class QVTiIncrementalExecutor extends BasicQVTiExecutor
{
	private enum Mode {
		EXECUTE,					// EvaluationStatus is created lazily where necessary
		INCREMENTAL,				// EvaluationStatus is created for all mapping elements
		REPAIR						// EvaluationStatus is updated for all mapping elements
	};
	private enum Usage { IN, OUT, INOUT };
	
	protected final @NonNull TransformationStatus transformationStatus = EvaluationStatusFactory.eINSTANCE.createTransformationStatus();
	protected final @NonNull Map<Object, ClassStatus> object2ClassStatus = new HashMap<Object, ClassStatus>();
	protected final @NonNull Stack<MappingStatus> mappingStatusStack = new Stack<MappingStatus>();
	
	/**
	 * Non-null list while accumulating damage.
	 */
	private @Nullable Set<MappingStatus> dirtyMappingStatuses = new HashSet<MappingStatus>();
	
	/**
	 * Mapping invocations that failed due to a not-ready value that is still not-ready.
	 */
	private final @NonNull Set<MappingStatus> blockedMappingStatuses = new HashSet<MappingStatus>();
	
	/**
	 * Non-null while mapping invocations that failed due to a not-ready value that is now ready.
	 */
	private @Nullable Set<MappingStatus> unblockedMappingStatuses = null;
	
	private @NonNull Mode mode;
	
	public QVTiIncrementalExecutor(@NonNull QVTiEnvironmentFactory environmentFactory, @NonNull URI transformationURI) throws IOException {
		super(environmentFactory, transformationURI);
		mode = Mode.EXECUTE;
	}

	protected void allocateDirtyMappingStatuses(@NonNull List<Set<MappingStatus>> depth2dirtyMappingStatuses,
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

	protected void block(@NonNull MappingStatus mappingStatus) {
		assert !mappingStatus.isIsBlocked();
		mappingStatus.setIsBlocked(true);
		blockedMappingStatuses.add(mappingStatus);
		Set<MappingStatus> unblockedMappingStatuses2 = unblockedMappingStatuses;
		if (unblockedMappingStatuses2 != null) {
			unblockedMappingStatuses2.remove(mappingStatus);
		}
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

	protected @NonNull ClassStatus createClassStatus(/*@NonNull*/ Type type, @NonNull EObject eObject) {
		ClassStatus classStatus = EvaluationStatusFactory.eINSTANCE.createClassStatus();
		classStatus.setType(type);
		classStatus.setEObject(eObject);
		object2ClassStatus.put(eObject, classStatus);
		transformationStatus.getOwnedClassStatuses().add(classStatus);
		return classStatus;
	}

	protected @NonNull MappingStatus createMappingStatus(@NonNull MappingCall mappingCall) {
		MappingStatus mappingStatus = EvaluationStatusFactory.eINSTANCE.createMappingStatus();
		mappingStatus.setReferredMappingCall(mappingCall);
		List<Object> boundValues = mappingStatus.getBoundValues();
		for (MappingCallBinding binding : mappingCall.getBinding()) {
			Variable boundVariable = ClassUtil.nonNullModel(binding.getBoundVariable());
			Object valueOrValues = getValueOf(boundVariable);
			boundValues.add(valueOrValues);
		}
		transformationStatus.getOwnedMappingStatuses().add(mappingStatus);
		return mappingStatus;
	}

	protected @NonNull PropertyStatus getAssociationStatus(@NonNull ClassStatus classStatus, @NonNull EObject thisObject, @NonNull EReference this2thatEReference) {
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
	
	protected @NonNull AttributeStatus getAttributeStatus(@NonNull ClassStatus classStatus, @NonNull EStructuralFeature eFeature) {
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

	protected @NonNull ClassStatus getClassStatus(@NonNull Usage usage, /*@NonNull*/ Type type, @NonNull EObject eObject) {
		ClassStatus classStatus = object2ClassStatus.get(eObject);
		if (classStatus == null) {
			classStatus = createClassStatus(type, eObject);
			if (usage != Usage.OUT) {
				classStatus.setIsInput(true);
			}
			if (usage != Usage.IN) {
				classStatus.setIsOutput(true);
			}
		}
		return classStatus;
	}

	public String getEvaluationStatusGraph() {
		GraphMLBuilder s = new GraphMLBuilder();
		transformationStatus.accept(new EvaluationStatus2GraphVisitor(s));
		return s.toString();
	}

	protected @Nullable MappingStatus getMappingStatus() {
		if (mappingStatusStack.isEmpty()) {
			return null;
		}
		MappingStatus mappingStatus = mappingStatusStack.peek();
		assert mappingStatus != null;
		return mappingStatus;
	}
	
	protected @NonNull PropertyStatus getPropertyStatus(@NonNull Usage usage, @NonNull EObject thisObject, @NonNull Property property) {
		EObject eFeature = property.getESObject();
		ClassStatus classStatus = getClassStatus(usage, property.getOwningClass(), thisObject);
		if (eFeature instanceof EReference) {
			EReference eReference = (EReference)eFeature;
			if (eReference.getEOpposite() != null) {
				return getAssociationStatus(classStatus, thisObject, eReference);
			}
		}
		if (eFeature instanceof EStructuralFeature) {
			return getAttributeStatus(classStatus, (EStructuralFeature)eFeature);
		}
		else if (property.isIsImplicit()) {				// Workaround Bug 463966
			throw new UnsupportedOperationException();
		}
		else {
			throw new UnsupportedOperationException();
		}
	}

	protected @NonNull Usage getUsageForMetamodelElement(@NonNull Element element) {
/*		EObject eContainer = null;
		ExpressionInOCL expressionInOCL = null;
		EReference eFeature = null;
		for (EObject eChild = element; (eContainer = eChild.eContainer()) != null; eChild = eContainer) {
//			if (eContainer instanceof ExpressionInOCL) {
//				expressionInOCL = (ExpressionInOCL)eContainer;
//				eFeature = eChild.eContainmentFeature();
//				break;
//			}
			if (eContainer instanceof Operation) {
				DomainUsageAnalysis operationUsageAnalysis = usageAnalysis.analyzeOperation((Operation)eContainer);
				QVTiEvaluationEnvironment evaluationEnvironment = getEvaluationEnvironment();
				break;
			}
			if (eContainer instanceof Pattern) {
				break;
			}
			if (eContainer instanceof Rule) {
				break;
			}
			if (eContainer instanceof org.eclipse.ocl.pivot.Class) {
				break;
			}
			if (eContainer instanceof org.eclipse.ocl.pivot.Package) {
				break;
			}
		}
		if (expressionInOCL != null) {
			DomainUsage domainUsage1 = transformationAnalysis.get(element);
			DomainUsage domainUsage3 = transformationAnalysis.get(expressionInOCL);
			DomainUsage domainUsage2 = transformationAnalysis.get(eFeature);
			
		}
		DomainUsage domainUsage = transformationAnalysis.get(element); */
		DomainUsage domainUsage = getEvaluationEnvironment().getUsageFor(element);
		if (domainUsage == null) {
			return Usage.INOUT;
		}
		else if (!domainUsage.isEnforceable()) {
			return Usage.IN;
		}
		else if (domainUsage.isCheckable()) {
			return Usage.INOUT;
		}
		else {
			return Usage.OUT;
		}
/*		org.eclipse.ocl.pivot.Package asPackage = PivotUtil.getContainingPackage(element);
		if (!checkablePackages.contains(asPackage)) {
			return Usage.OUT;
		}
		else if (!enforceablePackages.contains(asPackage)) {
			return Usage.IN;
		}
		else {
			return Usage.INOUT;
		} */
	}

//	protected @NonNull Usage getUsageForTransformationElement(@NonNull Element element) {
//		Domain domain = QVTimperativeUtil.getContainingDomain(element);
//		return domain == null ? Usage.INOUT : Usage.OUT;
//	}

	@Override
	public @Nullable Object internalExecuteMappingCall(@NonNull MappingCall mappingCall, @NonNull EvaluationVisitor undecoratedVisitor) {
		MappingStatus mappingStatus = createMappingStatus(mappingCall);
		mappingStatusStack.push(mappingStatus);
		try {
			return super.internalExecuteMappingCall(mappingCall, undecoratedVisitor);
		}
		catch (NotReadyValueException e) {
			if (!mappingStatus.isIsBlocked()) {
				block(mappingStatus);
			}
		}
		finally {
			mappingStatusStack.pop();
		}
		while (unblockedMappingStatuses != null) {
			List<MappingStatus> unblockingMappingStatuses = new ArrayList<MappingStatus>(unblockedMappingStatuses);
			unblockedMappingStatuses = null;
			for (@SuppressWarnings("null")@NonNull MappingStatus unblockingMappingStatus : unblockingMappingStatuses) {
				internalExecuteMappingCallRetry(unblockingMappingStatus, undecoratedVisitor);
			}
		}
		return null;
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
				block(mappingStatus);
			}
		}
		finally {
			mappingStatusStack.pop();
		}
	}

	@Override
	public @Nullable Object internalExecuteNavigationCallExp(@NonNull NavigationCallExp navigationCallExp, @NonNull Property referredProperty, @Nullable Object object) {
		Object propertyValue = super.internalExecuteNavigationCallExp(navigationCallExp, referredProperty, object);		// FIXME values
		MappingStatus mappingStatus = getMappingStatus();
		if (mappingStatus == null) {
			return propertyValue;
		}
		assert object != null;
		Usage usage = getUsageForMetamodelElement(navigationCallExp);
		PropertyStatus propertyStatus = getPropertyStatus(usage, (EObject)object, referredProperty);
		if (usage == Usage.IN) {
			propertyStatus.setIsAssignable(false);
			propertyStatus.setIsAssigned(true);
		}
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
				
			if (propertyStatus instanceof AttributeStatus) {
				AttributeStatus attributeStatus = (AttributeStatus)propertyStatus;
				ClassStatus classStatus = attributeStatus.getOwningClassStatus();
				if (!classStatus.isIsOutput()) {				// Pure input
					attributeStatus.setObject(propertyValue);
					attributeStatus.setIsDirty(false);
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
		Usage usage = getUsageForMetamodelElement(propertyAssignment);
		Property targetProperty = propertyAssignment.getTargetProperty();
		assert targetProperty != null;
		PropertyStatus propertyStatus = getPropertyStatus(usage, (EObject)object, targetProperty);
		MappingStatus mappingStatus = getMappingStatus();
		assert mappingStatus !=  null;
		mappingStatus.getOutputs().add(propertyStatus);
		if (!propertyStatus.isIsAssignable()) {				// Pure input
			propertyValue = new InvalidValueException("Illegal assignment");
			propertyStatus.setIsError(true);
		}
		else {
			propertyStatus.setIsAssigned(true);		// ?? not isAssignable for Attributes ?
			for (MappingStatus targetMappingStatus : propertyStatus.getTargets()) {
				if (targetMappingStatus.isIsBlocked()) {
					unblock(targetMappingStatus);
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
							unblock(targetMappingStatus);
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
		if (element != null) {
			Usage usage = getUsageForMetamodelElement(realizedVariable);
			ClassStatus classStatus = getClassStatus(usage, realizedVariable.getType(), (EObject)element);
			MappingStatus mappingStatus = getMappingStatus();
			assert mappingStatus != null;
			mappingStatus.getOutputs().add(classStatus);
		}
		return element;
	}

	public void printEvaluationStatus() {
		System.out.println(transformationStatus.toString());
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
//					for (MappingStatus mappingStatus : mappingStatuses) {
//					}
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

	protected void unblock(@NonNull MappingStatus mappingStatus) {
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
