/*******************************************************************************
 * Copyright (c) 2014, 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - initial API and implementation
 * 	 E.D.Willink (Obeo) - Bug 416287 - tuple-valued constraints
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtimperative.as2cs;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.Import;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.Namespace;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.Package;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VoidType;
import org.eclipse.ocl.pivot.internal.manager.Orphanage;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.xtext.base.as2cs.AS2CSConversion;
import org.eclipse.ocl.xtext.base.as2cs.AliasAnalysis;
import org.eclipse.ocl.xtext.base.utilities.BaseCSResource;
import org.eclipse.ocl.xtext.basecs.BaseCSFactory;
import org.eclipse.ocl.xtext.basecs.BaseCSPackage;
import org.eclipse.ocl.xtext.basecs.ClassCS;
import org.eclipse.ocl.xtext.basecs.ElementCS;
import org.eclipse.ocl.xtext.basecs.ImportCS;
import org.eclipse.ocl.xtext.basecs.PackageCS;
import org.eclipse.ocl.xtext.basecs.PackageOwnerCS;
import org.eclipse.ocl.xtext.basecs.PathElementCS;
import org.eclipse.ocl.xtext.basecs.PathElementWithURICS;
import org.eclipse.ocl.xtext.basecs.PathNameCS;
import org.eclipse.ocl.xtext.basecs.RootPackageCS;
import org.eclipse.ocl.xtext.basecs.TypedRefCS;
import org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage;
import org.eclipse.ocl.xtext.essentialoclcs.ExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.VariableCS;
import org.eclipse.qvtd.pivot.qvtbase.BaseModel;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.Function;
import org.eclipse.qvtd.pivot.qvtbase.FunctionParameter;
import org.eclipse.qvtd.pivot.qvtbase.Pattern;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
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
import org.eclipse.qvtd.xtext.qvtbase.as2cs.QVTbaseDeclarationVisitor;
import org.eclipse.qvtd.xtext.qvtbasecs.AbstractTransformationCS;
import org.eclipse.qvtd.xtext.qvtbasecs.QVTbaseCSPackage;
import org.eclipse.qvtd.xtext.qvtbasecs.QualifiedPackageCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.AddStatementCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.AppendParameterBindingCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.AppendParameterCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.BufferStatementCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.CheckStatementCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.DeclareStatementCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.DirectionCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.GuardParameterBindingCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.GuardParameterCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.LoopParameterBindingCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.MappingCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.MappingCallCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.MappingLoopCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.MappingParameterBindingCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.MappingParameterCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.MappingStatementCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.NewStatementCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.ParamDeclarationCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.QVTimperativeCSPackage;
import org.eclipse.qvtd.xtext.qvtimperativecs.QueryCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.SetStatementCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.SimpleParameterBindingCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.SimpleParameterCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.StatementCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.TopLevelCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.TransformationCS;

public class QVTimperativeDeclarationVisitor extends QVTbaseDeclarationVisitor implements QVTimperativeVisitor<ElementCS>
{
	/**
	 * QVTimperativeAliasAnalysis revises AliasAnalysis to support only those names explicitly defined (as a consequence
	 * of Unit AS elements).
	 */
	public static class QVTimperativeAliasAnalysis extends AliasAnalysis
	{
		public static @NonNull QVTimperativeAliasAnalysis getAdapter(@NonNull Resource resource, @NonNull EnvironmentFactoryInternal environmentFactory) {
			List<Adapter> eAdapters = resource.eAdapters();
			for (Adapter adapter : eAdapters) {
				if (adapter instanceof QVTimperativeAliasAnalysis) {
					QVTimperativeAliasAnalysis aliasAnalysis = (QVTimperativeAliasAnalysis)adapter;
					if (aliasAnalysis.environmentFactory == environmentFactory) {
						return aliasAnalysis;
					}
				}
			}
			return new QVTimperativeAliasAnalysis(resource, environmentFactory);
		}

		public QVTimperativeAliasAnalysis(@NonNull Resource resource, @NonNull EnvironmentFactoryInternal environmentFactory) {
			super(resource, environmentFactory);
		}
	}

	public static @Nullable PathNameCS createPathNameCS(@Nullable List<? extends @NonNull NamedElement> csPath) {
		PathNameCS csPathName = null;
		if (csPath != null) {
			csPathName = BaseCSFactory.eINSTANCE.createPathNameCS();
			List<@NonNull PathElementCS> csPathElements = ClassUtil.nullFree(csPathName.getOwnedPathElements());
			for (@NonNull NamedElement csElement : csPath) {
				PathElementCS csPathElement = BaseCSFactory.eINSTANCE.createPathElementCS();
				csPathElement.setReferredElement(csElement);
				csPathElements.add(csPathElement);
			}
		}
		return csPathName;
	}

	public QVTimperativeDeclarationVisitor(@NonNull AS2CSConversion context) {
		super(context);
	}

	protected void addClass(@NonNull PackageOwnerCS csParentPackage, @NonNull ClassCS csClass) {
		/*if (csParentPackage instanceof AbstractTopLevelCS) {
			((AbstractTopLevelCS)csParentPackage).getOwnedClasses().add(csClass);
		}
		else*/ if (csParentPackage instanceof PackageCS) {
			((PackageCS)csParentPackage).getOwnedClasses().add(csClass);
		}
		else {
			throw new UnsupportedOperationException(getClass().getSimpleName() + " addClass for a " + csClass.eClass().getName());
		}
	}

	protected void addPackage(@NonNull PackageOwnerCS csParentPackage, @NonNull QualifiedPackageCS csPackage) {
		csParentPackage.getOwnedPackages().add(csPackage);
	}

	protected void addTransformation(@NonNull PackageOwnerCS csParentPackage, @NonNull AbstractTransformationCS csTransformation) {
		if (csParentPackage instanceof TopLevelCS) {
			((TopLevelCS)csParentPackage).getOwnedTransformations().add((TransformationCS)csTransformation);
		}
		else if (csParentPackage instanceof PackageCS) {
			((PackageCS)csParentPackage).getOwnedClasses().add(csTransformation);
		}
		else {
			throw new UnsupportedOperationException(getClass().getSimpleName() + " addClass for a " + csTransformation.eClass().getName());
		}
	}

	public void buildModel(@NonNull RootPackageCS csRootPackage, @NonNull Model asModel) {
		for (org.eclipse.ocl.pivot.@NonNull Package asPackage : ClassUtil.nullFree(asModel.getOwnedPackages())) {
			if (!Orphanage.isTypeOrphanage(asPackage)) {
				buildPackage(csRootPackage, null, asPackage);
			}
		}
	}

	private void buildPackage(@NonNull PackageOwnerCS csParentPackage, @Nullable List<@NonNull NamedElement> csParentPath, org.eclipse.ocl.pivot.@NonNull Package asPackage) {
		if (needsQualifiedPackageCS(asPackage)) {
			QualifiedPackageCS csPackage = context.visitDeclaration(QualifiedPackageCS.class, asPackage);
			if (csPackage != null) {
				csPackage.setOwnedPathName(createPathNameCS(csParentPath));
				addPackage(csParentPackage, csPackage);
				csParentPackage = csPackage;
			}
			csParentPath = null;
		}
		else {
			List<@NonNull NamedElement> csPath = new ArrayList<>();
			if (csParentPath != null) {
				csPath.addAll(csParentPath);
			}
			csPath.add(asPackage);
			csParentPath = csPath;
		}
		for (org.eclipse.ocl.pivot.@NonNull Package asChildPackage : ClassUtil.nullFree(asPackage.getOwnedPackages())) {
			buildPackage(csParentPackage, csParentPath, asChildPackage);
		}
		for (org.eclipse.ocl.pivot.@NonNull Class asChildClass : ClassUtil.nullFree(asPackage.getOwnedClasses())) {
			buildClass(csParentPackage, csParentPath, asChildClass);
		}
	}

	private void buildClass(@NonNull PackageOwnerCS csParentPackage, @Nullable List<@NonNull NamedElement> csPath, org.eclipse.ocl.pivot.@NonNull Class asClass) {
		ClassCS csClass = context.visitDeclaration(ClassCS.class, asClass);
		if (csClass instanceof AbstractTransformationCS) {
			AbstractTransformationCS csTransformation = (AbstractTransformationCS)csClass;
			if ((csPath != null) && ((csParentPackage instanceof QualifiedPackageCS) || (csPath.size() != 1) || !"".equals(csPath.get(0).getName()))) {
				csTransformation.setOwnedPathName(createPathNameCS(csPath));
			}
			addTransformation(csParentPackage, csTransformation);
		}
		else if (csClass != null) {
			addClass(csParentPackage, csClass);
		}
	}

	protected void gatherTransformations(@NonNull List<@NonNull ImperativeTransformation> asTransformations, @NonNull List<Package> ownedPackages) {
		for (org.eclipse.ocl.pivot.Package asPackage : ownedPackages) {
			for (org.eclipse.ocl.pivot.Class asClass : asPackage.getOwnedClasses()) {
				if (asClass instanceof ImperativeTransformation) {
					asTransformations.add((ImperativeTransformation) asClass);
				}
			}
			gatherTransformations(asTransformations, asPackage.getOwnedPackages());
		}
	}

	/**
	 * Return true if a QualifiedPackageCS is needed to avoid information loss when serializing asPackage.
	 */
	protected boolean needsQualifiedPackageCS(org.eclipse.ocl.pivot.@NonNull Package asPackage) {
		if (asPackage.getNsPrefix() != null) {
			return true;
		}
		if (asPackage.getURI() != null) {
			return true;
		}
		if (asPackage.getOwnedPackages().size() > 1) {
			return true;
		}
		for (org.eclipse.ocl.pivot.@NonNull Class asClass : ClassUtil.nullFree(asPackage.getOwnedClasses())) {
			if (!(asClass instanceof Transformation)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Post-processing sets up the AliasAdapter with the names from the Unit declarations
	 */
	@Override
	public void postProcess(@NonNull BaseCSResource csResource, @NonNull Map<@NonNull Namespace, @NonNull List<@NonNull String>> importedNamespaces) {
		AliasAnalysis.dispose(csResource);
		QVTimperativeAliasAnalysis aliasAdapter = QVTimperativeAliasAnalysis.getAdapter(csResource, context.getEnvironmentFactory());
		List<EObject> contents = csResource.getContents();
		if (contents.size() > 0) {
			EObject root = contents.get(0);
			if (root instanceof RootPackageCS) {
				for (ImportCS csImport : ((RootPackageCS)root).getOwnedImports()) {
					Element pivot = csImport.getPivot();
					if (pivot instanceof Import) {
						Import asImport = (Import)pivot;
						String alias = asImport.getName();
						Namespace asNamespace = asImport.getImportedNamespace();
						if ((asNamespace != null) && (alias != null)) {
							aliasAdapter.getAlias(asNamespace, alias);
						}
					}
				}
			}
		}
	}

	protected void refreshObservedProperties(@NonNull ObservableStatement asStatement, /*@NonNull*/ List<PathNameCS> csPathNames, /*@NonNull*/ List<@NonNull Property> asProperties) {
		List<PathNameCS> pathNames = new ArrayList<PathNameCS>();
		for (@NonNull Property asProperty : asProperties) {
			@NonNull PathNameCS csPathName = BaseCSFactory.eINSTANCE.createPathNameCS();
			pathNames.add(csPathName);
			context.refreshPathName(csPathName, asProperty, PivotUtil.getContainingNamespace(asStatement));
		}
		context.refreshList(csPathNames, pathNames);
	}

	protected void refreshOwnedInTransformation(@NonNull MappingCS csMapping, @NonNull Mapping asMapping) {
		Transformation asTransformation = asMapping.getTransformation();
		if (asTransformation != null) {
			PathNameCS csPathName = BaseCSFactory.eINSTANCE.createPathNameCS();
			csMapping.setOwnedInPathName(csPathName);
			org.eclipse.ocl.pivot.Package asPackage = asTransformation.getOwningPackage();
			String asPackageName = asPackage != null ? asPackage.getName() : null;
			if ((asPackageName == null) || "".equals(asPackageName)) {
				PathElementCS csPathElement = BaseCSFactory.eINSTANCE.createPathElementCS();
				csPathName.getOwnedPathElements().add(csPathElement);
				csPathElement.setReferredElement(asTransformation);
			}
			else {
				context.refreshPathName(csPathName, asTransformation, null);
			}
		}
		else {
			csMapping.setOwnedInPathName(null);
		}
	}

	protected void refreshReferredMapping(@NonNull MappingCallCS csMappingCall, @NonNull MappingCall asMappingCall) {
		Mapping asMapping = asMappingCall.getReferredMapping();
		if (asMapping != null) {
			@NonNull PathNameCS csPathName = BaseCSFactory.eINSTANCE.createPathNameCS();
			csMappingCall.setOwnedPathName(csPathName);
			context.refreshPathName(csPathName, asMapping, QVTbaseUtil.getContainingTransformation(asMappingCall));
		}
		else {
			csMappingCall.setOwnedPathName(null);
		}
	}

	protected void refreshUsedProperties(@NonNull Transformation asTransformation, /*@NonNull*/ List<PathNameCS> csPathNames, /*@NonNull*/ List<@NonNull Property> asProperties) {
		List<PathNameCS> pathNames = new ArrayList<PathNameCS>();
		for (@NonNull Property asProperty : asProperties) {
			@NonNull PathNameCS csPathName = BaseCSFactory.eINSTANCE.createPathNameCS();
			pathNames.add(csPathName);
			context.refreshPathName(csPathName, asProperty, asTransformation);
		}
		context.refreshList(csPathNames, pathNames);
	}

	@Override
	public ElementCS visitAddStatement(@NonNull AddStatement asAddStatement) {
		AddStatementCS csStatement = context.refreshElement(AddStatementCS.class, QVTimperativeCSPackage.Literals.ADD_STATEMENT_CS, asAddStatement);
		csStatement.setPivot(asAddStatement);
		ConnectionVariable asVariable = asAddStatement.getTargetVariable();
		assert asVariable != null;
		csStatement.setTargetVariable(asVariable);
		csStatement.setOwnedExpression(context.visitDeclaration(ExpCS.class, asAddStatement.getOwnedExpression()));
		refreshObservedProperties(asAddStatement, csStatement.getObservedProperties(), ClassUtil.nullFree(asAddStatement.getObservedProperties()));
		return csStatement;
	}

	@Override
	public ElementCS visitAppendParameter(@NonNull AppendParameter asVariable) {
		AppendParameterCS csVariable = context.refreshNamedElement(AppendParameterCS.class, QVTimperativeCSPackage.Literals.APPEND_PARAMETER_CS, asVariable);
		csVariable.setPivot(asVariable);
		csVariable.setOwnedType(createTypeRefCS(asVariable.getType(), null)); //getScope(asVariable)));
		return csVariable;
	}

	@Override
	public ElementCS visitAppendParameterBinding(@NonNull AppendParameterBinding asMappingParameterBinding) {
		AppendParameterBindingCS csMappingParameterBinding = context.refreshElement(AppendParameterBindingCS.class, QVTimperativeCSPackage.Literals.APPEND_PARAMETER_BINDING_CS, asMappingParameterBinding);
		csMappingParameterBinding.setPivot(asMappingParameterBinding);
		csMappingParameterBinding.setReferredVariable((AppendParameter) asMappingParameterBinding.getBoundVariable());
		csMappingParameterBinding.setValue(asMappingParameterBinding.getValue());
		return csMappingParameterBinding;
	}

	@Override
	public ElementCS visitBaseModel(@NonNull BaseModel object) {
		throw new UnsupportedOperationException();
	}

	@Override
	public ElementCS visitBufferStatement(@NonNull BufferStatement asVariable) {
		BufferStatementCS csVariable = context.refreshTypedElement(BufferStatementCS.class, QVTimperativeCSPackage.Literals.BUFFER_STATEMENT_CS, asVariable);
		csVariable.setOwnedExpression(context.visitDeclaration(ExpCS.class, asVariable.getOwnedExpression()));
		csVariable.setIsStrict(asVariable.isIsStrict());
		return csVariable;
	}

	@Override
	public ElementCS visitCheckStatement(@NonNull CheckStatement asPredicate) {
		assert asPredicate.eContainer() instanceof Mapping;
		CheckStatementCS csPredicate = context.refreshElement(CheckStatementCS.class, QVTimperativeCSPackage.Literals.CHECK_STATEMENT_CS, asPredicate);
		csPredicate.setPivot(asPredicate);
		csPredicate.setOwnedCondition(createExpCS(asPredicate.getOwnedExpression()));
		refreshObservedProperties(asPredicate, csPredicate.getObservedProperties(), ClassUtil.nullFree(asPredicate.getObservedProperties()));
		return csPredicate;
	}

	@Override
	public ElementCS visitConnectionVariable(@NonNull ConnectionVariable object) {
		throw new UnsupportedOperationException();
	}

	@Override
	public ElementCS visitDeclareStatement(@NonNull DeclareStatement asVariable) {
		DeclareStatementCS csVariable = refreshTypedElement(DeclareStatementCS.class, QVTimperativeCSPackage.Literals.DECLARE_STATEMENT_CS, asVariable);
		csVariable.setOwnedExpression(context.visitDeclaration(ExpCS.class, asVariable.getOwnedExpression()));
		csVariable.setIsCheck(asVariable.isIsCheck());
		refreshObservedProperties(asVariable, csVariable.getObservedProperties(), ClassUtil.nullFree(asVariable.getObservedProperties()));
		return csVariable;
	}

	@Override
	public ElementCS visitDomain(@NonNull Domain object) {
		throw new UnsupportedOperationException();
	}

	@Override
	public ElementCS visitFunction(@NonNull Function asFunction) {
		QueryCS csQuery = refreshTypedElement(QueryCS.class, QVTimperativeCSPackage.Literals.QUERY_CS, asFunction);
		csQuery.setOwnedPathName(createPathNameCS(asFunction.getOwningClass()));
		context.refreshList(csQuery.getOwnedParameters(), context.visitDeclarations(ParamDeclarationCS.class, asFunction.getOwnedParameters(), null));
		csQuery.setOwnedExpression(createExpCS(asFunction.getQueryExpression()));
		csQuery.setIsTransient(asFunction.isIsTransient());
		return csQuery;
	}

	@Override
	public ElementCS visitFunctionParameter(@NonNull FunctionParameter asFunctionParameter) {
		ParamDeclarationCS csParamDeclaration = refreshTypedElement(ParamDeclarationCS.class, QVTimperativeCSPackage.Literals.PARAM_DECLARATION_CS, asFunctionParameter);
		return csParamDeclaration;
	}

	@Override
	public ElementCS visitGuardParameter(@NonNull GuardParameter asVariable) {
		ImperativeTypedModel asTypedModel = asVariable.getReferredTypedModel();
		Mapping containingMapping = QVTimperativeUtil.getContainingMapping(asVariable);
		assert containingMapping != null;
		GuardParameterCS csUnrealizedVariable = context.refreshNamedElement(GuardParameterCS.class, QVTimperativeCSPackage.Literals.GUARD_PARAMETER_CS, asVariable);
		csUnrealizedVariable.setPivot(asVariable);
		csUnrealizedVariable.setReferredTypedModel(asTypedModel);
		csUnrealizedVariable.setOwnedType(createTypeRefCS(asVariable.getType(), null));
		return csUnrealizedVariable;
	}

	@Override
	public ElementCS visitGuardParameterBinding(@NonNull GuardParameterBinding asMappingParameterBinding) {
		GuardParameterBindingCS csMappingParameterBinding = context.refreshElement(GuardParameterBindingCS.class, QVTimperativeCSPackage.Literals.GUARD_PARAMETER_BINDING_CS, asMappingParameterBinding);
		csMappingParameterBinding.setPivot(asMappingParameterBinding);
		csMappingParameterBinding.setReferredVariable((GuardParameter) asMappingParameterBinding.getBoundVariable());
		csMappingParameterBinding.setValue(asMappingParameterBinding.getValue());
		csMappingParameterBinding.setIsCheck(asMappingParameterBinding.isIsCheck());
		return csMappingParameterBinding;
	}

	@Override
	public ElementCS visitImperativeModel(@NonNull ImperativeModel asModel) {
		assert asModel.eContainer() == null;
		TopLevelCS csDocument = context.refreshElement(TopLevelCS.class, QVTimperativeCSPackage.Literals.TOP_LEVEL_CS, asModel);
		csDocument.setPivot(asModel);
		context.refreshList(csDocument.getOwnedImports(), context.visitDeclarations(ImportCS.class, asModel.getOwnedImports(), null));

		buildModel(csDocument, asModel);

		List<@NonNull Mapping> asMappings = null;
		List<@NonNull Function> asQueries = null;
		List<@NonNull ImperativeTransformation> asTransformations = new ArrayList<>();
		gatherTransformations(asTransformations, asModel.getOwnedPackages());
		for (@NonNull ImperativeTransformation asTransformation : asTransformations) {
			for (@NonNull Mapping asMapping : QVTimperativeUtil.getOwnedMappings(asTransformation)) {
				if (asMappings == null) {
					asMappings = new ArrayList<>();
				}
				asMappings.add(asMapping);
			}
			for (Operation asOperation : asTransformation.getOwnedOperations()) {
				if (asOperation instanceof Function) {
					if (asQueries == null) {
						asQueries = new ArrayList<>();
					}
					asQueries.add((Function) asOperation);
				}
			}
		}
		//		context.refreshList(csDocument.getOwnedTransformations(), context.visitDeclarations(TransformationCS.class, asTransformations, null));
		if (asMappings != null) {
			context.refreshList(csDocument.getOwnedMappings(), context.visitDeclarations(MappingCS.class, asMappings, null));
		}
		else {
			csDocument.getOwnedMappings().clear();
		}
		if (asQueries != null) {
			context.refreshList(csDocument.getOwnedQueries(), context.visitDeclarations(QueryCS.class, asQueries, null));
		}
		else {
			csDocument.getOwnedQueries().clear();
		}
		return csDocument;
	}

	@Override
	public ElementCS visitImperativeTransformation(@NonNull ImperativeTransformation asTransformation) {
		TransformationCS csTransformation = context.refreshNamedElement(TransformationCS.class, QVTimperativeCSPackage.Literals.TRANSFORMATION_CS, asTransformation);
		context.refreshList(csTransformation.getOwnedDirections(), context.visitDeclarations(DirectionCS.class, asTransformation.getModelParameter(), null));
		return csTransformation;
	}

	@Override
	public ElementCS visitImperativeTypedModel(@NonNull ImperativeTypedModel asTypedModel) {
		DirectionCS csDirection = context.refreshNamedElement(DirectionCS.class, QVTimperativeCSPackage.Literals.DIRECTION_CS, asTypedModel, null);
		if ("".equals(asTypedModel.getName())) {
			csDirection.setName(null);
		}
		csDirection.setIsChecked(asTypedModel.isIsChecked());
		csDirection.setIsEnforced(asTypedModel.isIsEnforced());
		PivotUtilInternal.refreshList(csDirection.getImports(), asTypedModel.getUsedPackage());
		//		PivotUtil.refreshList(csDirection.getUses(), asTypedModel.getDependsOn());
		return csDirection;
	}

	@Override
	public @Nullable ElementCS visitImport(@NonNull Import asUnit) {
		BaseCSResource csResource = context.getCSResource();
		Namespace asNamespace = asUnit.getImportedNamespace();
		EObject eObject = asNamespace.getESObject();
		String importURI = null;
		if (eObject instanceof EPackage) {
			EPackage ePackage = (EPackage)eObject;
			Resource resource = ePackage.eResource();
			if (ClassUtil.isRegistered(resource)) {
				importURI = ePackage.getNsURI();
			}
		}
		if ((importURI == null) && (csResource != null)) {
			URI fullURI = EcoreUtil.getURI(eObject != null ? eObject : asNamespace);
			URI csURI = csResource.getURI();
			URI deresolvedURI = fullURI.deresolve(csURI, true, true, false);
			importURI = deresolvedURI.toString();
		}
		ImportCS csImport = context.refreshElement(ImportCS.class, BaseCSPackage.Literals.IMPORT_CS, asUnit);
		csImport.setPivot(asUnit);
		csImport.setName(asUnit.getName());
		PathNameCS csPathName = BaseCSFactory.eINSTANCE.createPathNameCS();
		List<PathElementCS> csPath = csPathName.getOwnedPathElements();
		PathElementWithURICS csSimpleRef = BaseCSFactory.eINSTANCE.createPathElementWithURICS();
		csSimpleRef.setReferredElement(asNamespace);
		csSimpleRef.setUri(importURI);
		csPath.add(csSimpleRef);
		csImport.setOwnedPathName(csPathName);
		return csImport;
	}

	@Override
	public ElementCS visitLoopParameterBinding(@NonNull LoopParameterBinding asMappingParameterBinding) {
		LoopParameterBindingCS csMappingParameterBinding = context.refreshElement(LoopParameterBindingCS.class, QVTimperativeCSPackage.Literals.LOOP_PARAMETER_BINDING_CS, asMappingParameterBinding);
		csMappingParameterBinding.setPivot(asMappingParameterBinding);
		csMappingParameterBinding.setReferredVariable((GuardParameter) asMappingParameterBinding.getBoundVariable());
		csMappingParameterBinding.setValue(asMappingParameterBinding.getValue());
		csMappingParameterBinding.setIsCheck(asMappingParameterBinding.isIsCheck());
		return csMappingParameterBinding;
	}

	@Override
	public ElementCS visitLoopVariable(@NonNull LoopVariable asVariable) {
		VariableCS csVariable = context.refreshNamedElement(VariableCS.class, EssentialOCLCSPackage.Literals.VARIABLE_CS, asVariable);
		Type type = asVariable.getType();
		if ((type instanceof CollectionType) && (((CollectionType)type).getUnspecializedElement() != context.getMetamodelManager().getStandardLibrary().getCollectionType())) {
			PivotUtil.debugWellContainedness(type);
			type = ((CollectionType)type).getElementType();
		}
		else if (type instanceof VoidType) {
			type = null;
		}
		if (type != null) {
			PivotUtil.debugWellContainedness(type);
			TypedRefCS typeRef = context.visitReference(TypedRefCS.class, type, null);
			csVariable.setOwnedType(typeRef);
		}
		else {
			csVariable.setOwnedType(null);
		}
		return csVariable;
	}

	@Override
	public ElementCS visitMapping(@NonNull Mapping asMapping) {
		MappingCS csMapping = context.refreshNamedElement(MappingCS.class, QVTimperativeCSPackage.Literals.MAPPING_CS, asMapping);
		csMapping.setPivot(asMapping);
		refreshOwnedInTransformation(csMapping, asMapping);
		context.refreshList(csMapping.getOwnedParameters(), context.visitDeclarations(MappingParameterCS.class, asMapping.getOwnedParameters(), null));
		context.refreshList(csMapping.getOwnedStatements(), context.visitDeclarations(StatementCS.class, asMapping.getOwnedStatements(), null));
		csMapping.setIsStrict(asMapping.isIsStrict());
		return csMapping;
	}

	@Override
	public ElementCS visitMappingCall(@NonNull MappingCall asMappingCall) {
		MappingCallCS csMappingCall = context.refreshElement(MappingCallCS.class, QVTimperativeCSPackage.Literals.MAPPING_CALL_CS, asMappingCall);
		csMappingCall.setPivot(asMappingCall);
		context.refreshList(csMappingCall.getOwnedBindings(), context.visitDeclarations(MappingParameterBindingCS.class, asMappingCall.getBinding(), null));
		csMappingCall.setIsInstall(asMappingCall.isIsInstall());
		csMappingCall.setIsInvoke(asMappingCall.isIsInvoke());
		refreshReferredMapping(csMappingCall, asMappingCall);
		return csMappingCall;
	}

	@Override
	public ElementCS visitMappingLoop(@NonNull MappingLoop asMappingLoop) {
		MappingLoopCS csMappingLoop = context.refreshElement(MappingLoopCS.class, QVTimperativeCSPackage.Literals.MAPPING_LOOP_CS, asMappingLoop);
		csMappingLoop.setPivot(asMappingLoop);
		csMappingLoop.setOwnedIterator(context.visitDeclaration(VariableCS.class, asMappingLoop.getOwnedIterators().get(0)));
		csMappingLoop.setOwnedInExpression(createExpCS(asMappingLoop.getOwnedExpression()));
		context.refreshList(csMappingLoop.getOwnedMappingStatements(), context.visitDeclarations(MappingStatementCS.class, asMappingLoop.getOwnedMappingStatements(), null));
		refreshObservedProperties(asMappingLoop, csMappingLoop.getObservedProperties(), ClassUtil.nullFree(asMappingLoop.getObservedProperties()));
		return csMappingLoop;
	}

	@Override
	public ElementCS visitMappingParameter(@NonNull MappingParameter object) {
		return visiting(object);
	}

	@Override
	public ElementCS visitMappingParameterBinding(@NonNull MappingParameterBinding object) {
		return visiting(object);
	}

	@Override
	public ElementCS visitMappingStatement(@NonNull MappingStatement object) {
		return visiting(object);
	}

	@Override
	public ElementCS visitNewStatement(@NonNull NewStatement asNewStatement) {
		NewStatementCS csNewStatement = context.refreshTypedElement(NewStatementCS.class, QVTimperativeCSPackage.Literals.NEW_STATEMENT_CS, asNewStatement);
		csNewStatement.setReferredTypedModel(asNewStatement.getReferredTypedModel());
		csNewStatement.setOwnedExpression(context.visitDeclaration(ExpCS.class, asNewStatement.getOwnedExpression()));
		refreshObservedProperties(asNewStatement, csNewStatement.getObservedProperties(), ClassUtil.nullFree(asNewStatement.getObservedProperties()));
		return csNewStatement;
	}

	@Override
	public ElementCS visitObservableStatement(@NonNull ObservableStatement object) {
		return visiting(object);
	}

	@Override
	public ElementCS visitPackage(org.eclipse.ocl.pivot.@NonNull Package asPackage) {
		QualifiedPackageCS csPackage = context.refreshNamedElement(QualifiedPackageCS.class, QVTbaseCSPackage.Literals.QUALIFIED_PACKAGE_CS, asPackage);
		csPackage.setNsPrefix(asPackage.getNsPrefix());
		csPackage.setNsURI(asPackage.getURI());
		return csPackage;
	}

	@Override
	public ElementCS visitPattern(@NonNull Pattern object) {
		throw new UnsupportedOperationException();
	}

	@Override
	public ElementCS visitPredicate(@NonNull Predicate asPredicate) {
		throw new UnsupportedOperationException();
	}

	@Override
	public ElementCS visitRule(@NonNull Rule object) {
		throw new UnsupportedOperationException();
	}

	@Override
	public ElementCS visitSetStatement(@NonNull SetStatement asSetStatement) {
		SetStatementCS csStatement = context.refreshElement(SetStatementCS.class, QVTimperativeCSPackage.Literals.SET_STATEMENT_CS, asSetStatement);
		csStatement.setReferredVariable(asSetStatement.getTargetVariable());
		csStatement.setReferredProperty(QVTimperativeUtil.getTargetProperty(asSetStatement));
		csStatement.setOwnedExpression(createExpCS(asSetStatement.getOwnedExpression()));
		csStatement.setIsNotify(asSetStatement.isIsNotify());
		refreshObservedProperties(asSetStatement, csStatement.getObservedProperties(), ClassUtil.nullFree(asSetStatement.getObservedProperties()));
		return csStatement;
	}

	@Override
	public ElementCS visitSimpleParameter(@NonNull SimpleParameter asVariable) {
		Mapping containingMapping = QVTimperativeUtil.getContainingMapping(asVariable);
		assert containingMapping != null;
		SimpleParameterCS csUnrealizedVariable = context.refreshNamedElement(SimpleParameterCS.class, QVTimperativeCSPackage.Literals.SIMPLE_PARAMETER_CS, asVariable);
		csUnrealizedVariable.setPivot(asVariable);
		csUnrealizedVariable.setReferredTypedModel(asVariable.getReferredTypedModel());
		csUnrealizedVariable.setOwnedType(createTypeRefCS(asVariable.getType(), null));
		return csUnrealizedVariable;
	}

	@Override
	public ElementCS visitSimpleParameterBinding(@NonNull SimpleParameterBinding asMappingParameterBinding) {
		SimpleParameterBindingCS csMappingParameterBinding = context.refreshElement(SimpleParameterBindingCS.class, QVTimperativeCSPackage.Literals.SIMPLE_PARAMETER_BINDING_CS, asMappingParameterBinding);
		csMappingParameterBinding.setPivot(asMappingParameterBinding);
		csMappingParameterBinding.setReferredVariable((SimpleParameter) asMappingParameterBinding.getBoundVariable());
		csMappingParameterBinding.setOwnedValue(createExpCS(asMappingParameterBinding.getValue()));
		csMappingParameterBinding.setIsCheck(asMappingParameterBinding.isIsCheck());
		return csMappingParameterBinding;
	}

	@Override
	public ElementCS visitStatement(@NonNull Statement object) {
		return visiting(object);
	}

	@Override
	public ElementCS visitTransformation(@NonNull Transformation object) {
		return visiting(object);
	}

	@Override
	public ElementCS visitTypedModel(@NonNull TypedModel object) {
		return visiting(object);
	}

	@Override
	public ElementCS visitVariable(@NonNull Variable asVariable) {
		assert !(asVariable.eContainer() instanceof Mapping);
		return super.visitVariable(asVariable);
	}

	@Override
	public ElementCS visitVariableStatement(@NonNull VariableStatement object) {
		return visiting(object);
	}
}
