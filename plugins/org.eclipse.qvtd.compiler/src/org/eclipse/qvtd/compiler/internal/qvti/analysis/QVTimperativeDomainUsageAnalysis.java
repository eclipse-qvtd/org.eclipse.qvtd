/*******************************************************************************
 * Copyright (c) 2018, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvti.analysis;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.CompleteModel;
import org.eclipse.ocl.pivot.CompletePackage;
import org.eclipse.ocl.pivot.DataType;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.internal.complete.StandardLibraryInternal;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtcore.analysis.RootDomainUsageAnalysis;
import org.eclipse.qvtd.pivot.qvtimperative.AddStatement;
import org.eclipse.qvtd.pivot.qvtimperative.AppendParameter;
import org.eclipse.qvtd.pivot.qvtimperative.AppendParameterBinding;
import org.eclipse.qvtd.pivot.qvtimperative.BufferStatement;
import org.eclipse.qvtd.pivot.qvtimperative.CheckStatement;
import org.eclipse.qvtd.pivot.qvtimperative.ConnectionVariable;
import org.eclipse.qvtd.pivot.qvtimperative.DeclareStatement;
import org.eclipse.qvtd.pivot.qvtimperative.GuardParameter;
import org.eclipse.qvtd.pivot.qvtimperative.GuardParameterBinding;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeModel;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeTransformation;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeTypedModel;
import org.eclipse.qvtd.pivot.qvtimperative.LoopParameterBinding;
import org.eclipse.qvtd.pivot.qvtimperative.LoopVariable;
import org.eclipse.qvtd.pivot.qvtimperative.Mapping;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCall;
import org.eclipse.qvtd.pivot.qvtimperative.MappingLoop;
import org.eclipse.qvtd.pivot.qvtimperative.MappingParameter;
import org.eclipse.qvtd.pivot.qvtimperative.MappingParameterBinding;
import org.eclipse.qvtd.pivot.qvtimperative.MappingStatement;
import org.eclipse.qvtd.pivot.qvtimperative.NewStatement;
import org.eclipse.qvtd.pivot.qvtimperative.ObservableStatement;
import org.eclipse.qvtd.pivot.qvtimperative.SetStatement;
import org.eclipse.qvtd.pivot.qvtimperative.SimpleParameter;
import org.eclipse.qvtd.pivot.qvtimperative.SimpleParameterBinding;
import org.eclipse.qvtd.pivot.qvtimperative.Statement;
import org.eclipse.qvtd.pivot.qvtimperative.VariableStatement;
import org.eclipse.qvtd.pivot.qvtimperative.util.QVTimperativeVisitor;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeUtil;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.DomainUsage;

/**
 * A QVTimperativeDomainUsageAnalysis identifies a constrained domain result from the DomainUsageAnalysis of a QVTr AST node.
 */
public class QVTimperativeDomainUsageAnalysis extends RootDomainUsageAnalysis implements QVTimperativeVisitor<@NonNull DomainUsage>
{
	public QVTimperativeDomainUsageAnalysis(@NonNull EnvironmentFactory environmentFactory) {
		super(environmentFactory);
	}

	// FIXME Remove dupliucation wrt RootDomainUsageAnalysis
	public @NonNull Map<Element, DomainUsage> analyzeTransformation(@NonNull Transformation transformation) {
		int checkedMask = 0;
		int enforcedMask = 0;
		CompleteModel completeModel = context.getCompleteModel();
		for (@NonNull TypedModel typedModel : ClassUtil.nullFree(transformation.getModelParameter())) {
			boolean isEnforced = false;
			boolean isChecked = false;
			ImperativeTypedModel imperativeTypedModel = (ImperativeTypedModel)typedModel;
			if (imperativeTypedModel.isIsTrace()) {
				setTraceTypedModel(typedModel);
			}
			else if (imperativeTypedModel.isIsEnforced()) {
				isEnforced = true;
			}
			else if (imperativeTypedModel.isIsChecked()) {
				isChecked = true;
			}
			else if (imperativeTypedModel.isIsPrimitive()) {
				continue;
			}
			int nextBit = add(typedModel);
			int bitMask = 1 << nextBit;
			@NonNull DomainUsageConstant typedModelUsage = getConstantUsage(bitMask);
			addValidUsage(bitMask, typedModelUsage);
			if (isEnforced) {
				enforcedMask |= bitMask;
			}
			if (isChecked) {
				checkedMask |= bitMask;
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
		setInputUsage(checkedMask);
		setOutputUsage(enforcedMask);
		DomainUsage middleUsage = setMiddleUsage(~checkedMask & ~enforcedMask & ~PRIMITIVE_USAGE_BIT_MASK);
		TypedModel traceTypedModel = basicGetTraceTypedModel();
		if (traceTypedModel != null) {
			setUsage(traceTypedModel, middleUsage);
		}
		Variable ownedContext = transformation.getOwnedContext();
		if (ownedContext != null) {
			setUsage(ownedContext, getAnyUsage());
		}
		analyzePropertyAssignments(transformation);
		visit(transformation);
		return element2usage;
	}

	@Override
	public @NonNull DomainUsage visitAddStatement(@NonNull AddStatement object) {
		return getNoneUsage();
	}

	@Override
	public @NonNull DomainUsage visitAppendParameter(@NonNull AppendParameter object) {
		return getNoneUsage();
	}

	@Override
	public @NonNull DomainUsage visitAppendParameterBinding(@NonNull AppendParameterBinding object) {
		return getNoneUsage();
	}

	@Override
	public @NonNull DomainUsage visitBufferStatement(@NonNull BufferStatement object) {
		return getNoneUsage();
	}

	@Override
	public @NonNull DomainUsage visitCheckStatement(@NonNull CheckStatement object) {
		return getNoneUsage();
	}

	@Override
	public @NonNull DomainUsage visitConnectionVariable(@NonNull ConnectionVariable object) {
		return getNoneUsage();
	}

	@Override
	public @NonNull DomainUsage visitDeclareStatement(@NonNull DeclareStatement object) {
		return getUsage(PivotUtil.getType(object));
	}

	@Override
	public @NonNull DomainUsage visitGuardParameter(@NonNull GuardParameter object) {
		return getUsage(QVTimperativeUtil.getReferredTypedModel(object));
	}

	@Override
	public @NonNull DomainUsage visitGuardParameterBinding(@NonNull GuardParameterBinding object) {
		return getNoneUsage();
	}

	@Override
	public @NonNull DomainUsage visitImperativeModel(@NonNull ImperativeModel object) {
		return getNoneUsage();
	}

	@Override
	public @NonNull DomainUsage visitImperativeTransformation(@NonNull ImperativeTransformation object) {
		return getNoneUsage();
	}

	@Override
	public @NonNull DomainUsage visitImperativeTypedModel(@NonNull ImperativeTypedModel object) {
		return getNoneUsage();
	}

	@Override
	public @NonNull DomainUsage visitLoopParameterBinding(@NonNull LoopParameterBinding object) {
		return getNoneUsage();
	}

	@Override
	public @NonNull DomainUsage visitLoopVariable(@NonNull LoopVariable object) {
		return getNoneUsage();
	}

	@Override
	public @NonNull DomainUsage visitMapping(@NonNull Mapping object) {
		return getNoneUsage();
	}

	@Override
	public @NonNull DomainUsage visitMappingCall(@NonNull MappingCall object) {
		return getNoneUsage();
	}

	@Override
	public @NonNull DomainUsage visitMappingLoop(@NonNull MappingLoop object) {
		return getNoneUsage();
	}

	@Override
	public @NonNull DomainUsage visitMappingParameter(@NonNull MappingParameter object) {
		return getNoneUsage();
	}

	@Override
	public @NonNull DomainUsage visitMappingParameterBinding(@NonNull MappingParameterBinding object) {
		return getNoneUsage();
	}

	@Override
	public @NonNull DomainUsage visitMappingStatement(@NonNull MappingStatement object) {
		return getNoneUsage();
	}

	@Override
	public @NonNull DomainUsage visitNewStatement(@NonNull NewStatement object) {
		return getUsage(QVTimperativeUtil.getReferredTypedModel(object));
	}

	@Override
	public @NonNull DomainUsage visitObservableStatement(@NonNull ObservableStatement object) {
		return getNoneUsage();
	}

	@Override
	public @NonNull DomainUsage visitSetStatement(@NonNull SetStatement object) {
		return getNoneUsage();
	}

	@Override
	public @NonNull DomainUsage visitSimpleParameter(@NonNull SimpleParameter object) {
		return getUsage(QVTimperativeUtil.getReferredTypedModel(object));
	}

	@Override
	public @NonNull DomainUsage visitSimpleParameterBinding(@NonNull SimpleParameterBinding object) {
		return getNoneUsage();
	}

	@Override
	public @NonNull DomainUsage visitStatement(@NonNull Statement object) {
		return getNoneUsage();
	}

	@Override
	public @NonNull DomainUsage visitVariableStatement(@NonNull VariableStatement object) {
		return getNoneUsage();
	}

	/*	@Override
	public void analyzeTracePackage(@NonNull TypedModel typedModel, org.eclipse.ocl.pivot.@NonNull Package tracePackage) {
		assert typedModel == getTraceTypedModel();
		setUsage(typedModel, getMiddleUsage());
		@NonNull DomainUsage typedModelUsage = getMiddleUsage();
		for (org.eclipse.ocl.pivot.@NonNull Class traceClass : QVTrelationUtil.getOwnedClasses(tracePackage)) {
			setUsage(traceClass, typedModelUsage);
		}
	}

	@Override
	public @NonNull DomainUsage visitCollectionTemplateExp(org.eclipse.qvtd.pivot.qvttemplate.@NonNull CollectionTemplateExp object) {
		for (@NonNull OCLExpression member : QVTrelationUtil.getOwnedMembers(object)) {
			visit(member);
		}
		Variable rest = object.getRest();
		if (rest != null) {
			visit(rest);
		}
		return visitTemplateExp(object);
	}

	@Override
	public @NonNull DomainUsage visitDomainPattern(@NonNull DomainPattern object) {
		DomainUsage usage = getUsage(QVTrelationUtil.getTypedModel(QVTrelationUtil.getContainingDomain(object)));
		setUsage(object, usage);
		visit(QVTrelationUtil.getOwnedTemplateExpression(object));
		return usage;
	}

	@Override
	public @NonNull DomainUsage visitKey(@NonNull Key object) {
		return getUsage(QVTrelationUtil.getIdentifies(object));
	}

	@Override
	public @NonNull DomainUsage visitObjectTemplateExp(org.eclipse.qvtd.pivot.qvttemplate.@NonNull ObjectTemplateExp object) {
		DomainUsage usage = visitTemplateExp(object);
		for (@NonNull PropertyTemplateItem part : QVTrelationUtil.getOwnedParts(object)) {
			visit(part);
		}
		return usage;
	}

	@Override
	public @NonNull DomainUsage visitPattern(@NonNull Pattern object) {
		DomainUsage domainUsage = getDomainUsage(object);
		for (@NonNull Predicate predicate : QVTrelationUtil.getOwnedPredicates(object)) {
			visit(predicate);
		}
		return domainUsage;
	}

	@Override
	public @NonNull DomainUsage visitPropertyTemplateItem(org.eclipse.qvtd.pivot.qvttemplate.@NonNull PropertyTemplateItem object) {
		DomainUsage usage = visit(QVTrelationUtil.getReferredProperty(object));
		visit(QVTrelationUtil.getOwnedValue(object));
		return usage;
	}

	@Override
	public @NonNull DomainUsage visitRelation(@NonNull Relation object) {
		DomainUsage usage = getRootAnalysis().getNoneUsage();
		setUsage(object, usage);
		Variable traceClassVariable = NameUtil.getNameable(object.getVariable(), QVTbaseUtil.TRACE_CLASS_NAME);
		if (traceClassVariable != null) {
			setUsage(traceClassVariable, getMiddleUsage());
		}
		for (@NonNull Domain domain : QVTrelationUtil.getOwnedDomains(object)) {
			visit(domain);
		}
		Pattern when = object.getWhen();
		if (when != null) {
			visit(when);
		}
		Pattern where = object.getWhere();
		if (where != null) {
			visit(where);
		}
		return usage;
	}

	@Override
	public @NonNull DomainUsage visitRelationCallExp(@NonNull RelationCallExp object) {
		int i = 0;
		for (@NonNull OCLExpression argument : QVTrelationUtil.getOwnedArguments(object)) {
			if (argument instanceof VariableExp) {
				RelationDomain relationDomain = QVTrelationUtil.getRelationCallExpArgumentDomain(object, i);
				DomainUsage usage = getUsage(QVTrelationUtil.getTypedModel(relationDomain));
				setUsage(QVTrelationUtil.getReferredVariable((VariableExp)argument), usage);
			}
			visit(argument);
			i++;
		}
		return getRootAnalysis().getPrimitiveUsage();
	}

	@Override
	public @NonNull DomainUsage visitRelationDomain(@NonNull RelationDomain object) {
		DomainUsage usage = visit(object.getTypedModel());
		setUsage(object, usage);
		for (@NonNull DomainPattern domainPattern : QVTrelationUtil.getOwnedPatterns(object)) {
			visit(domainPattern);
		}
		return usage;
	}

	@Override
	public @NonNull DomainUsage visitRelationDomainAssignment(@NonNull RelationDomainAssignment object) {
		return visitElement(object);	// FIXME
	}

	@Override
	public @NonNull DomainUsage visitRelationImplementation(@NonNull RelationImplementation object) {
		return visitElement(object);	// FIXME
	}

	@Override
	public @NonNull DomainUsage visitRelationModel(@NonNull RelationModel object) {
		return visitBaseModel(object);
	}

	@Override
	public @NonNull DomainUsage visitRelationalTransformation(@NonNull RelationalTransformation object) {
		DomainUsage usage = getRootAnalysis().getNoneUsage();
		setUsage(object, usage);
		//
		//	Ensure all operations are analyzed even if not used.
		//
		for (Operation operation : object.getOwnedOperations()) {
			if (operation != null) {
				DomainUsageAnalysis operationAnalysis = getRootAnalysis().analyzeOperation(operation);
				setUsage(operation, operationAnalysis.getUsage(operation));
			}
		}
		for (@NonNull Key key : QVTrelationUtil.getOwnedKey(object)) {
			visit(key);
		}
		for (@NonNull Relation relation : QVTrelationUtil.getOwnedRelations(object)) {
			visit(relation);
		}
		visitTransformation(object);
		return usage;
	}

	@Override
	public @NonNull DomainUsage visitSharedVariable(@NonNull SharedVariable object) {
		OCLExpression ownedInit = object.getOwnedInit();
		if (ownedInit != null) {
			visit(ownedInit);
		}
		return visitVariable(object);
	}

	@Override
	public @NonNull DomainUsage visitTemplateExp(org.eclipse.qvtd.pivot.qvttemplate.@NonNull TemplateExp object) {
		DomainUsage usage = getUsage(QVTrelationUtil.getTypedModel(QVTrelationUtil.getContainingDomain(object)));
		setUsage(object, usage);
		Variable bindsTo = QVTrelationUtil.getBindsTo(object);
		DomainUsage oldUsage = basicGetUsage(bindsTo);
		if (oldUsage != null) {
			usage = union(usage, oldUsage);
		}
		setUsage(QVTrelationUtil.getBindsTo(object), usage);
		OCLExpression where = object.getWhere();
		if (where != null) {
			visit(where);
		}
		return usage;
	}

	@Override
	public @NonNull DomainUsage visitTemplateVariable(@NonNull TemplateVariable object) {
		return visitVariable(object);
	} */
}
