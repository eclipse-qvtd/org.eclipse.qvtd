/*******************************************************************************
 * Copyright (c) 2015, 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtimperative.analysis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Annotation;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.CompleteModel;
import org.eclipse.ocl.pivot.CompletePackage;
import org.eclipse.ocl.pivot.DataType;
import org.eclipse.ocl.pivot.Detail;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.NullLiteralExp;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.StandardLibrary;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.ids.OperationId;
import org.eclipse.ocl.pivot.internal.complete.StandardLibraryInternal;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.ocl.pivot.utilities.LabelUtil;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.qvtd.pivot.qvtbase.QVTbaseFactory;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.analysis.DomainUsage;
import org.eclipse.qvtd.pivot.qvtbase.analysis.DomainUsageAnalysis;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeTypedModel;
import org.eclipse.qvtd.pivot.qvtimperative.SetStatement;
import org.eclipse.qvtd.pivot.qvtimperative.util.QVTimperativeVisitor;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeUtil;

public class RootDomainUsageAnalysis extends AbstractDomainUsageAnalysis implements QVTimperativeVisitor<org.eclipse.qvtd.pivot.qvtbase.analysis.DomainUsage>, DomainUsageAnalysis.Root
{
	protected abstract class AbstractDomainUsage implements DomainUsage.Internal
	{
		protected final int bitMask;

		protected AbstractDomainUsage(int bitMask) {
			this.bitMask = bitMask;
		}

		@Override
		public int compareTo(DomainUsage.Internal o) {
			return getMask() - o.getMask();
		}

		@Override
		public int getMask() {
			return bitMask;
		}

		@Override
		public @Nullable TypedModel getTypedModel() throws IllegalStateException {
			return getTypedModel(null);
		}

		@Override
		public @Nullable TypedModel getTypedModel(@Nullable Element context) throws IllegalStateException {
			int residue = bitMask;
			for (int i = 0; residue != 0; i++) {
				int bit = 1 << i;
				if ((residue & bit) != 0) {
					residue &= ~bit;
					if (residue == 0) {
						return RootDomainUsageAnalysis.this.getTypedModel(i);
					}
					if (!(context instanceof NullLiteralExp)) {
						System.err.println("Ambiguous TypedModel: " + this + " for " + LabelUtil.getLabel(context));
					}
					//					throw new IllegalStateException("Ambiguous TypedModel: " + this);
					return RootDomainUsageAnalysis.this.getTypedModel(i);
				}
			}
			return null;
		}

		@Override
		public @NonNull Iterable<@NonNull TypedModel> getTypedModels() {
			List<@NonNull TypedModel> typedModels = new ArrayList<>();
			int residue = bitMask;
			for (int i = 0; residue != 0; i++) {
				int bit = 1 << i;
				if ((residue & bit) != 0) {
					residue &= ~bit;
					typedModels.add(RootDomainUsageAnalysis.this.getTypedModel(i));
				}
			}
			return typedModels;
		}

		@Override
		public boolean isCheckable() {
			return isInput();
		}

		@Override
		public boolean isEnforceable() {
			return isOutput();
		}

		@Override
		public boolean isInput() {
			return (bitMask & inputUsage.bitMask) != 0;
		}

		@Override
		public boolean isMiddle() {
			return (bitMask & middleUsage.bitMask) != 0;
		}

		@Override
		public boolean isNone() {
			return bitMask == 0;
		}

		@Override
		public boolean isOutput() {
			return (bitMask & outputUsage.bitMask) != 0;
		}

		@Override
		public boolean isPrimitive() {
			return (bitMask & PRIMITIVE_USAGE_BIT_MASK) != 0;
		}

		protected String toString(@NonNull String prefix) {
			StringBuilder s = new StringBuilder();
			s.append(prefix);
			boolean first = true;
			for (int i = 0; i < bit2typedModel.size(); i++) {
				int iMask = 1 << i;
				if ((bitMask & iMask) != 0) {
					if (!first) {
						s.append("|");
					}
					String name = bit2typedModel.get(i).getName();
					s.append(name != null ? name : "$middle$");
					first = false;
				}
			}
			if (first) {
				s.append("$none$");
			}
			return s.toString();
		}
	}

	/**
	 * A DomainUsageConstant identifies a specific domain result from the DomainUsageAnalysis of an OCL AST node.
	 */
	protected class DomainUsageConstant extends AbstractDomainUsage
	{
		protected DomainUsageConstant(int bitMask) {
			super(bitMask);
		}

		@Override
		public void addUsedBy(@NonNull Element element) {}

		@Override
		public @NonNull DomainUsage cloneVariable() {
			return this;
		}

		@Override
		public @Nullable Iterable<Element> getElements() {
			return null;
		}

		@Override
		public boolean isConstant() {
			return true;
		}

		@Override
		public String toString() {
			return toString("«constant»");
		}

		public @NonNull DomainUsageConstant union(@NonNull DomainUsageConstant usage) {
			return RootDomainUsageAnalysis.this.getConstantUsage(bitMask | usage.bitMask);
		}
	}

	/**
	 * A DomainUsageVariable identifies a constrained domain result from the DomainUsageAnalysis of an OCL AST node.
	 */
	protected class DomainUsageVariable extends AbstractDomainUsage
	{
		protected final @NonNull List<Element> usedBy = new ArrayList<>();

		protected DomainUsageVariable(int bitMask) {
			super(bitMask);
			assert bitMask != 0;
		}

		@Override
		public void addUsedBy(@NonNull Element element) {
			usedBy.add(element);
		}

		@Override
		public @NonNull DomainUsage cloneVariable() {
			return new DomainUsageVariable(bitMask);
		}

		@Override
		public @Nullable Iterable<Element> getElements() {
			return usedBy;
		}

		@Override
		public boolean isConstant() {
			return false;
		}

		@Override
		public String toString() {
			return toString("«variable»");
		}
	}

	/**
	 * A Nested DomainUsageAnalysis is used for a nested context such as an operation which is analyzed without
	 * regard to its invocation parameters. The invoking context is responsible for 'specializing' the generic
	 * domain analysis to suit the invocations.
	 */
	protected class Nested extends AbstractDomainUsageAnalysis
	{
		protected Nested() {
			super(RootDomainUsageAnalysis.this.getEnvironmentFactory());
		}

		@Override
		protected @NonNull RootDomainUsageAnalysis getRootAnalysis() {
			return RootDomainUsageAnalysis.this;
		}
	}

	/**
	 * No TypedModels is used by control infrastructure such as MappingLoops.
	 */
	private static final @NonNull Integer NONE_USAGE_BIT_MASK = 0;

	/**
	 * The first bit is reserved for the primitive TypedModel that is used by DataTypes.
	 */
	private static final @NonNull Integer PRIMITIVE_USAGE_BIT_MASK = 1;

	protected final @NonNull StandardLibrary standardLibrary;

	/**
	 * The model name to typed model bit mapping.
	 */
	protected final @NonNull Map<@Nullable String, @NonNull Integer> name2bit = new HashMap<>();

	/**
	 * The bit number to typed model 'mapping'.
	 */
	protected final @NonNull List<@NonNull TypedModel> bit2typedModel = new ArrayList<>();

	/**
	 * Map from Integer to all in-use Constant Usages
	 */
	private final @NonNull Map<@NonNull Integer, @NonNull DomainUsageConstant> constantUsages = new HashMap<>();

	/**
	 * Map from Integer to all single TypedModel Constant Usages
	 */
	private final @NonNull Map<@NonNull Integer, @NonNull DomainUsageConstant> validUsages = new HashMap<>();

	/**
	 * The TypedModels that are not primitive and not checkable and not enforceable.
	 */
	private DomainUsageConstant middleUsage = null;

	/**
	 * The TypedModels that are not enforceable.
	 */
	private DomainUsageConstant inputUsage = null;

	/**
	 * The TypedModels that are enforceable.
	 */
	private DomainUsageConstant outputUsage = null;

	/**
	 * The domains in which each class may be used.
	 */
	protected final @NonNull Map<org.eclipse.ocl.pivot.@NonNull Class, @NonNull DomainUsageConstant> class2usage = new HashMap<>();

	/**
	 * The domains in which the containing class of a property may be used.
	 */
	protected final @NonNull Map<@NonNull Property, org.eclipse.qvtd.pivot.qvtbase.analysis.DomainUsage> property2containingClassUsage = new HashMap<>();

	/**
	 * The nested analyses for declared operations.
	 */
	protected final @NonNull Map<@NonNull Operation, DomainUsageAnalysis.@NonNull Internal> operation2analysis = new HashMap<>();

	private final @NonNull TypedModel primitiveTypeModel = QVTbaseFactory.eINSTANCE.createTypedModel();

	private /*@LazyNonNull*/ OperationId oclAnyEqualsOperationId;
	private /*@LazyNonNull*/ OperationId oclAnyNotEqualsOperationId;
	private /*@LazyNonNull*/ OperationId oclElementOclContainerId;
	private /*@LazyNonNull*/ OperationId oclElementOclContentsId;
	private /*@LazyNonNull*/ Property oclElementOclContainerProperty;
	private /*@LazyNonNull*/ Property oclElementOclContentsProperty;
	/**
	 * The properties of the input models that are assigned by mappings and which cannot therefore
	 * be trusted to be loaded from the input models.
	 */
	private final @NonNull Set<@NonNull Property> dirtyProperties = new HashSet<>();
	private final @NonNull Set<@NonNull EReference> dirtyEReferences = new HashSet<>();

	protected RootDomainUsageAnalysis(@NonNull EnvironmentFactory environmentFactory) {
		super(environmentFactory);
		this.standardLibrary = context.getStandardLibrary();
		primitiveTypeModel.setName("$primitive$");
		add(primitiveTypeModel);
		validUsages.put(NONE_USAGE_BIT_MASK, getConstantUsage(NONE_USAGE_BIT_MASK));
		validUsages.put(PRIMITIVE_USAGE_BIT_MASK, getConstantUsage(PRIMITIVE_USAGE_BIT_MASK));
		setUsage(primitiveTypeModel, getPrimitiveUsage());
	}

	protected int add(@NonNull TypedModel typedModel) {
		int nextBit = bit2typedModel.size();
		bit2typedModel.add(typedModel);
		name2bit.put(typedModel.getName(), nextBit);
		return nextBit;
	}

	public @NonNull DomainUsageAnalysis analyzeOperation(@NonNull Operation object) {
		DomainUsageAnalysis.Internal analysis = operation2analysis.get(object);
		if (analysis == null) {
			analysis = createNestedAnalysis();
			operation2analysis.put(object, analysis);
			DomainUsage usage = analysis.visit(object);
			setUsage(object, usage);
		}
		return analysis;
	}

	protected void analyzeSetStatements(@NonNull Transformation transformation) {
		for (TreeIterator<EObject> tit = transformation.eAllContents(); tit.hasNext(); ) {
			EObject eObject = tit.next();
			if (eObject instanceof SetStatement) {
				SetStatement setStatement = (SetStatement)eObject;
				//				if ("s.name := sn".equals(eObject.toString())) {
				//					eObject.toString();
				//				}
				VariableDeclaration targetVariable = setStatement.getTargetVariable();
				assert targetVariable != null;
				DomainUsage domainUsage = getUsage(targetVariable);
				if (!domainUsage.isOutput() && !domainUsage.isMiddle()) {
					Property targetProperty = QVTimperativeUtil.getTargetProperty(setStatement);
					//					System.out.println("Dirty " + targetProperty + " for " + eObject);
					dirtyProperties.add(targetProperty);
					EObject eProperty = targetProperty.getESObject();
					if (eProperty instanceof EReference) {
						dirtyEReferences.add((EReference) eProperty);
					}
				}
			}
		}
		for (@NonNull Property dirtyProperty : dirtyProperties) {
			if (!dirtyProperty.isIsTransient()) {
				System.err.println("Dirty " + dirtyProperty + " is not transient");
			}
			if (dirtyProperty.isIsReadOnly()) {
				System.err.println("Dirty " + dirtyProperty + " is readonly");
			}
			if (dirtyProperty.isIsRequired()) {
				System.err.println("Dirty " + dirtyProperty + " is required");
			}
		}
	}

	public @NonNull Map<Element, DomainUsage> analyzeTransformation(@NonNull Transformation transformation) {
		int unenforceableMask = 0;
		int enforceableMask = 0;
		CompleteModel completeModel = context.getCompleteModel();
		for (@NonNull TypedModel typedModel : ClassUtil.nullFree(transformation.getModelParameter())) {
			int nextBit = add(typedModel);
			int bitMask = 1 << nextBit;
			@NonNull DomainUsageConstant typedModelUsage = getConstantUsage(bitMask);
			validUsages.put(bitMask, typedModelUsage);
			boolean isEnforceable = ((ImperativeTypedModel)typedModel).isIsEnforced();
			boolean isUnenforceable = !isEnforceable;//((ImperativeTypedModel)typedModel).isIsChecked();
			if (isEnforceable) {
				enforceableMask |= bitMask;
			}
			if (isUnenforceable) {
				unenforceableMask |= bitMask;
			}
			setUsage(typedModel, typedModelUsage);
			Variable ownedContext = typedModel.getOwnedContext();
			if (ownedContext != null) {
				setUsage(ownedContext, typedModelUsage);
			}
			Set<@NonNull CompleteClass> completeClasses = new HashSet<>();
			// TODO		There is an issue with extending transformations, because just classes extended by the
			//			the extending metamodel are tracked. Following code tries to workaround this issue. Also take into account
			//			that pivot/ocl are filtered. This might be an issue, when the transformations involve the own pivot metamodel
			//			(e.g. the CS2AS transformation for QVTo, Pivot-based QVTo AS extends Pivot metamodel).
			//			Set<Package> allPackages = QVTbaseUtil.getAllUsedPackages(typedModel);
			//			Deque<Package> pckQueue = new LinkedList<Package>();	// To track new discovered packages
			//			pckQueue.addAll(allPackages);
			//			while (!pckQueue.isEmpty()) {
			//			Package asPackage = pckQueue.pop();
			for (org.eclipse.ocl.pivot.@NonNull Package asPackage : QVTbaseUtil.getAllUsedPackages(typedModel)) {
				CompletePackage completePackage = completeModel.getCompletePackage(asPackage);
				for (@NonNull CompleteClass completeClass : ClassUtil.nullFree(completePackage.getOwnedCompleteClasses())) {
					for (@NonNull CompleteClass superCompleteClass : completeClass.getSuperCompleteClasses()) {
						completeClasses.add(superCompleteClass);
					}
				}
			}
			for (@NonNull CompleteClass completeClass : completeClasses) {
				for (org.eclipse.ocl.pivot.@NonNull Class asClass : ClassUtil.nullFree(completeClass.getPartialClasses())) {
					DomainUsageConstant oldUsage = class2usage.get(asClass);
					DomainUsageConstant classUsage = typedModelUsage;
					if ((asClass instanceof DataType) && !(asClass instanceof CollectionType)) {	// FIXME use a visitor ? perhaps CollectionTypes are not evidence of usage
						classUsage = getPrimitiveUsage();
					}
					DomainUsageConstant newUsage = oldUsage != null ? classUsage.union(oldUsage) : classUsage;
					class2usage.put(asClass, newUsage);
				}
			}
		}
		for (org.eclipse.ocl.pivot.@NonNull Class asClass : class2usage.keySet()) {
			DomainUsage newUsage = class2usage.get(asClass);
			assert newUsage != null;
			for (@NonNull Property property : ClassUtil.nullFree(asClass.getOwnedProperties())) {
				property2containingClassUsage.put(property, newUsage);
				DomainUsage referredTypeUsage = getAnnotatedUsage(property);
				if (referredTypeUsage == null) {
					referredTypeUsage = visit(property.getType());
				}
				//				System.out.println(property + " => " + referredTypeUsage);
				//				property2referredTypeUsage.put(property, referredTypeUsage);
			}
		}
		class2usage.put(((StandardLibraryInternal)standardLibrary).getOclTypeType(), getAnyUsage());		// Needed by oclIsKindOf() etc
		inputUsage = getConstantUsage(getAnyMask() & unenforceableMask);
		outputUsage = getConstantUsage(getAnyMask() & enforceableMask);
		middleUsage = getConstantUsage(getAnyMask() & ~unenforceableMask & ~enforceableMask & ~PRIMITIVE_USAGE_BIT_MASK);
		Variable ownedContext = transformation.getOwnedContext();
		if (ownedContext != null) {
			setUsage(ownedContext, getAnyUsage());
		}
		visit(transformation);
		analyzeSetStatements(transformation);
		return element2usage;
	}

	@Override
	public @Nullable DomainUsage basicGetUsage(@Nullable Element element) {
		DomainUsage usage = super.basicGetUsage(element);
		if (usage != null) {
			return usage;
		}
		Operation operation = PivotUtil.getContainingOperation(element);
		if (operation == null) {
			return null;
		}
		DomainUsageAnalysis analyzeOperation = analyzeOperation(operation);
		usage = analyzeOperation.basicGetUsage(element);
		return usage;
	}

	protected @NonNull Nested createNestedAnalysis() {
		return new Nested();
	}

	public @NonNull DomainUsage createVariableUsage(int intersectionMask) {
		return new DomainUsageVariable(intersectionMask);
	}

	/*	@Override				// FIXME BUG 487257 Revise this
	protected @NonNull DomainUsage getAllInstancesUsage(@NonNull OperationCallExp asCallExp, @NonNull DomainUsage sourceUsage) {
		if (asCallExp.getOwnedSource().getTypeValue() instanceof DataType) {
			return getPrimitiveUsage();
		}
		Domain aDomain = QVTimperativeUtil.getContainingDomain(asCallExp);
		if (aDomain instanceof ImperativeDomain) {
			DomainUsage areaUsage = getUsage(aDomain);
			return intersection(sourceUsage, areaUsage);
		}
		Mapping mapping = QVTimperativeUtil.getContainingMapping(asCallExp);
		assert mapping != null;
		DomainUsage inputUsage = getNoneUsage();
		for (Domain domain : mapping.getDomain()) {
			if (!domain.isIsEnforceable()) {
				inputUsage = union(inputUsage, getUsage(domain));
			}
		}
		if (inputUsage != getNoneUsage()) {
			return intersection(sourceUsage, inputUsage);
		}
		else {				// Att root so no domains, use input
			return intersection(sourceUsage, getInputUsage());
		}
	} */

	public @NonNull DomainUsageAnalysis getAnalysis(@NonNull Operation operation) {
		DomainUsageAnalysis analysis = operation2analysis.get(operation);
		if (analysis == null) {
			analysis = analyzeOperation(operation);
		}
		return analysis;
	}

	protected @Nullable DomainUsage getAnnotatedUsage(@NonNull Property property) {
		DomainUsage referredTypeUsage = null;
		for (Element annotation : property.getOwnedAnnotations()) {
			if (annotation instanceof Annotation) {
				Annotation annotation2 = (Annotation)annotation;
				if (DomainUsage.QVT_DOMAINS_ANNOTATION_SOURCE.equals(annotation2.getName())) {
					for (Detail detail : annotation2.getOwnedDetails()) {
						if (DomainUsage.QVT_DOMAINS_ANNOTATION_REFERRED_DOMAIN.equals(detail.getName())) {
							int mask = 0;
							for (String value : detail.getValues()) {
								Integer bit = name2bit.get(value.trim());
								if (bit != null) {
									mask |= 1 << bit;
								}
							}
							referredTypeUsage = getValidUsage(mask);
						}
					}
				}

			}
		}
		return referredTypeUsage;
	}

	protected int getAnyMask() {
		return (1 << bit2typedModel.size()) - 1;
	}

	public @NonNull DomainUsageConstant getAnyUsage() {
		return getConstantUsage(getAnyMask());
	}

	/**
	 * @deprecated use getInputUsage();
	 */
	@Deprecated
	public @NonNull DomainUsage getCheckableUsage() {
		return getInputUsage();
	}

	@Override
	public @NonNull DomainUsageConstant getConstantUsage(int bitMask) {
		DomainUsageConstant usage = constantUsages.get(bitMask);
		if (usage == null) {
			usage = new DomainUsageConstant(bitMask);
			constantUsages.put(bitMask, usage);
		}
		return usage;
	}

	/**
	 * @deprecated use getOutputUsage();
	 */
	@Deprecated
	public @NonNull DomainUsage getEnforceableUsage() {
		return getOutputUsage();
	}

	public @NonNull DomainUsage getInputUsage() {
		return ClassUtil.nonNullState(inputUsage);
	}

	public @NonNull DomainUsage getMiddleUsage() {
		return ClassUtil.nonNullState(middleUsage);
	}

	public @NonNull DomainUsage getNoneUsage() {
		DomainUsageConstant noneUsage = constantUsages.get(NONE_USAGE_BIT_MASK);
		assert noneUsage != null;
		return noneUsage;
	}

	public @NonNull DomainUsage getOutputUsage() {
		return ClassUtil.nonNullState(outputUsage);
	}

	//	public @NonNull TypedModel getPrimitiveTypeModel() {
	//		return primitiveTypeModel;
	//	}

	public @NonNull OperationId getOclContainerId() {
		OperationId oclElementOclContainerId2 = oclElementOclContainerId;
		if (oclElementOclContainerId2 == null) {
			org.eclipse.ocl.pivot.Class oclElementType = standardLibrary.getOclElementType();
			Operation operation = NameUtil.getNameable(oclElementType.getOwnedOperations(), "oclContainer");
			assert operation != null;
			oclElementOclContainerId = oclElementOclContainerId2 = operation.getOperationId();
		}
		return oclElementOclContainerId2;
	}

	public @NonNull Property getOclContainerProperty() {
		Property oclElementOclContainerProperty2 = oclElementOclContainerProperty;
		if (oclElementOclContainerProperty2 == null) {
			org.eclipse.ocl.pivot.Class oclElementType = standardLibrary.getOclElementType();
			oclElementOclContainerProperty2 = NameUtil.getNameable(oclElementType.getOwnedProperties(), "oclContainer");
			assert oclElementOclContainerProperty2 != null;
			oclElementOclContainerProperty = oclElementOclContainerProperty2;
		}
		return oclElementOclContainerProperty2;
	}

	public @NonNull OperationId getOclContentsId() {
		OperationId oclElementOclContentsId2 = oclElementOclContentsId;
		if (oclElementOclContentsId2 == null) {
			org.eclipse.ocl.pivot.Class oclElementType = standardLibrary.getOclElementType();
			Operation operation = NameUtil.getNameable(oclElementType.getOwnedOperations(), "oclContents");
			assert operation != null;
			oclElementOclContentsId = oclElementOclContentsId2 = operation.getOperationId();
		}
		return oclElementOclContentsId2;
	}

	public @NonNull Property getOclContentsProperty() {
		Property oclElementOclContentsProperty2 = oclElementOclContentsProperty;
		if (oclElementOclContentsProperty2 == null) {
			org.eclipse.ocl.pivot.Class oclElementType = standardLibrary.getOclElementType();
			oclElementOclContentsProperty2 = NameUtil.getNameable(oclElementType.getOwnedProperties(), "oclContents");
			assert oclElementOclContentsProperty2 != null;
			oclElementOclContentsProperty = oclElementOclContentsProperty2;
		}
		return oclElementOclContentsProperty2;
	}

	public @NonNull OperationId getOclAnyEqualsOperationId() {
		OperationId oclAnyEqualsOperationId2 = oclAnyEqualsOperationId;
		if (oclAnyEqualsOperationId2 == null) {
			org.eclipse.ocl.pivot.Class oclAnyType = standardLibrary.getOclAnyType();
			Operation operation = NameUtil.getNameable(oclAnyType.getOwnedOperations(), "=");
			assert operation != null;
			oclAnyEqualsOperationId = oclAnyEqualsOperationId2 = operation.getOperationId();
		}
		return oclAnyEqualsOperationId2;
	}

	public @NonNull OperationId getOclAnyNotEqualsOperationId() {
		OperationId oclAnyNotEqualsOperationId2 = oclAnyNotEqualsOperationId;
		if (oclAnyNotEqualsOperationId2 == null) {
			org.eclipse.ocl.pivot.Class oclAnyType = standardLibrary.getOclAnyType();
			Operation operation = NameUtil.getNameable(oclAnyType.getOwnedOperations(), "<>");
			assert operation != null;
			oclAnyNotEqualsOperationId = oclAnyNotEqualsOperationId2 = operation.getOperationId();
		}
		return oclAnyNotEqualsOperationId2;
	}

	public @NonNull TypedModel getPrimitiveTypeModel() {
		return primitiveTypeModel;
	}

	public @NonNull DomainUsageConstant getPrimitiveUsage() {
		DomainUsageConstant primitiveUsage = constantUsages.get(PRIMITIVE_USAGE_BIT_MASK);
		assert primitiveUsage != null;
		return primitiveUsage;
	}

	@Override
	protected @NonNull RootDomainUsageAnalysis getRootAnalysis() {
		return this;
	}

	public @NonNull TypedModel getTypedModel(int i) {
		return bit2typedModel.get(i);
	}

	/*	@Override
	public @Nullable DomainUsage getUsage(@Nullable EObject element) {
		DomainUsage domainUsage = super.getUsage(element);
		if ((domainUsage == null) && (element instanceof Property)) {
			domainUsage = property2referredTypeUsage.get(element);
		}
		return domainUsage;
	} */

	@Override
	public @NonNull DomainUsage getUsage(@NonNull Element element) {
		Operation operation = PivotUtil.getContainingOperation(element);
		if (operation != null) {
			DomainUsageAnalysis analyzeOperation = analyzeOperation(operation);
			return ClassUtil.nonNullState(analyzeOperation.getUsage(element));
		}
		else {
			return super.getUsage(element);
		}
	}

	/**
	 * Return a corresponding non-null usage if bitMask identifies a single domain.
	 */
	public @Nullable DomainUsageConstant getValidUsage(int bitMask) {
		return validUsages.get(bitMask);
	}

	/**
	 * Return either a constant usage if usage is for a single domain,
	 * else re-use a variable usgae else or create
	 * a variable usage for the multiple domains.
	 */
	public @NonNull DomainUsage getValidOrVariableUsage(@NonNull DomainUsage usage) {
		int bitMask = ((DomainUsage.Internal)usage).getMask();
		DomainUsage validUsage = getValidUsage(bitMask);
		if (validUsage != null) {
			return validUsage;
		}
		else if (!usage.isConstant()) {
			return usage;
		}
		else {
			return createVariableUsage(bitMask);
		}
	}

	/**
	 * Return true if a mapping may assign this property in an input model.
	 */
	public boolean isDirty(@NonNull EReference eReference) {
		return dirtyEReferences.contains(eReference);
	}

	/**
	 * Return true if a mapping may assign this property in an input model.
	 */
	public boolean isDirty(@NonNull Property property) {
		return property.isIsTransient() || dirtyProperties.contains(property);
	}

	//	private boolean isPivotMMPackage(Package p) {
	//		String pURI = p.getURI();
	//		return PivotPackage.eNS_URI.equals(pURI) ||
	//				OCLstdlib.STDLIB_URI.equals(pURI);
	//	}
}
