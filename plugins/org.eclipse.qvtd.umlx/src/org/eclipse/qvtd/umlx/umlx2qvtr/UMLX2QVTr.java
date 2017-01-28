/*******************************************************************************
 * Copyright (c) 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.umlx.umlx2qvtr;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.Import;
import org.eclipse.ocl.pivot.InvalidType;
import org.eclipse.ocl.pivot.Namespace;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.internal.context.AbstractParserContext;
import org.eclipse.ocl.pivot.internal.manager.PivotMetamodelManager;
import org.eclipse.ocl.pivot.internal.scoping.EnvironmentView;
import org.eclipse.ocl.pivot.internal.scoping.ScopeView;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.ocl.pivot.utilities.MetamodelManager;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.ParserContext;
import org.eclipse.ocl.pivot.utilities.ParserException;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.qvtd.compiler.CompilerChainException;
import org.eclipse.qvtd.pivot.qvtbase.Function;
import org.eclipse.qvtd.pivot.qvtbase.FunctionParameter;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtrelation.Key;
import org.eclipse.qvtd.pivot.qvtrelation.QVTrelationFactory;
import org.eclipse.qvtd.pivot.qvtrelation.RelationModel;
import org.eclipse.qvtd.pivot.qvtrelation.RelationalTransformation;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrelationHelper;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrelationUtil;
import org.eclipse.qvtd.umlx.RelDiagram;
import org.eclipse.qvtd.umlx.TxDiagram;
import org.eclipse.qvtd.umlx.TxImportNode;
import org.eclipse.qvtd.umlx.TxKeyNode;
import org.eclipse.qvtd.umlx.TxPackageNode;
import org.eclipse.qvtd.umlx.TxParameterNode;
import org.eclipse.qvtd.umlx.TxPartNode;
import org.eclipse.qvtd.umlx.TxQueryNode;
import org.eclipse.qvtd.umlx.TxTypedModelNode;
import org.eclipse.qvtd.umlx.UMLXElement;
import org.eclipse.qvtd.umlx.UMLXModel;
import org.eclipse.qvtd.umlx.UMLXTypedElement;
import org.eclipse.qvtd.umlx.util.AbstractExtendingUMLXVisitor;
import org.eclipse.qvtd.umlx.utilities.UMLXUtil;

import com.google.common.collect.Iterables;

public class UMLX2QVTr extends QVTrelationHelper
{
	protected static class CreateVisitor extends AbstractExtendingUMLXVisitor<@Nullable Element, @NonNull UMLX2QVTr>
	{
		protected final @NonNull MetamodelManager metamodelManager;
		protected final @NonNull RelationModel qvtrModel;

		public CreateVisitor(@NonNull UMLX2QVTr context, @NonNull RelationModel qvtrModel) {
			super(context);
			EnvironmentFactory environmentFactory = context.getEnvironmentFactory();
			this.metamodelManager = environmentFactory.getMetamodelManager();
			this.qvtrModel = qvtrModel;
		}

		private <@NonNull T1 extends UMLXElement, T2 extends Element> void createAll(/*@NonNull*/ Iterable<T1> sources, /*@NonNull*/ List<? super T2> targets) {
			for (T1 source : sources) {
				@SuppressWarnings("unchecked") T2 target = (T2) source.accept(this);
				if ((target != null) && (targets != null)) {
					targets.add(target);
				}
			}
		}

		private org.eclipse.ocl.pivot.@NonNull Package getPackage(org.eclipse.ocl.pivot.@Nullable Package asParentPackage, @NonNull String name) {
			List<org.eclipse.ocl.pivot.@NonNull Package> asPackages = (asParentPackage != null ? QVTbaseUtil.Internal.getOwnedPackagesList(asParentPackage) : QVTbaseUtil.Internal.getOwnedPackagesList(qvtrModel));
			org.eclipse.ocl.pivot.Package qvtrPackage = NameUtil.getNameable(asPackages, name);
			if (qvtrPackage ==  null) {
				@NonNull String nsURI = "http:/fixme";		// FIXME
				qvtrPackage = PivotUtil.createPackage(name, null, nsURI, null);
				qvtrPackage.setURI(null);
				asPackages.add(qvtrPackage);
			}
			return qvtrPackage;
		}

		private void visitAll(/*@NonNull*/ Iterable<? extends @NonNull UMLXElement> sources) {
			for (@NonNull UMLXElement source : sources) {
				source.accept(this);
			}
		}

		@Override
		public @Nullable Element visitRelDiagram(@NonNull RelDiagram relDiagram) {
			PatternForest patternForest = new PatternForest(context, relDiagram);
			context.patternForests.add(patternForest);
			return patternForest.create();		// Pass 1: create the elements
		}

		@Override
		public @Nullable Element visitTxDiagram(@NonNull TxDiagram txDiagram) {
			List<@NonNull Key> qvtrKeys = new ArrayList<>();
			createAll(UMLXUtil.getOwnedTxKeyNodes(txDiagram), qvtrKeys);
			List<@NonNull TypedModel> qvtrTypedModels = new ArrayList<>();
			createAll(UMLXUtil.getOwnedTxTypedModelNodes(txDiagram), qvtrTypedModels);
			RelationalTransformation qvtrRelationalTransformation = context.createRelationalTransformation(UMLXUtil.getName(txDiagram), qvtrTypedModels);
			context.install(txDiagram, qvtrRelationalTransformation);
			org.eclipse.ocl.pivot.Package asPackage = null;
			String packagePath = txDiagram.getPackage();
			if (packagePath != null) {
				for (StringTokenizer tokenizer = new StringTokenizer(packagePath, "::"); tokenizer.hasMoreTokens(); ) {
					String token = tokenizer.nextToken();
					asPackage = getPackage(asPackage, token);
				}
			}
			if (asPackage == null) {
				asPackage = getPackage(null, "");
			}
			//			Collections.sort(qvtrKeys, NameUtil.NAMEABLE_COMPARATOR);
			Iterables.addAll(QVTrelationUtil.Internal.getOwnedKeysList(qvtrRelationalTransformation), qvtrKeys);
			QVTbaseUtil.Internal.getOwnedClassesList(asPackage).add(qvtrRelationalTransformation);

			List<@NonNull Rule> allRelationsList = new ArrayList<>();
			createAll(UMLXUtil.getOwnedRelDiagrams(txDiagram), allRelationsList);
			createAll(UMLXUtil.getOwnedTxQueryNodes(txDiagram), QVTbaseUtil.Internal.getOwnedOperationsList(qvtrRelationalTransformation));
			//			Collections.sort(allRelationsList, NameUtil.NAMEABLE_COMPARATOR);
			Iterables.addAll(QVTrelationUtil.Internal.getOwnedRelationsList(qvtrRelationalTransformation), allRelationsList);
			QVTbaseUtil.getContextVariable(metamodelManager.getStandardLibrary(), qvtrRelationalTransformation);
			return qvtrRelationalTransformation;
		}

		@Override
		public @Nullable Element visitTxImportNode(@NonNull TxImportNode txImportNode) {
			String uri = txImportNode.getUri();
			EObject eObject = metamodelManager.getEnvironmentFactory().getResourceSet().getEObject(URI.createURI(uri), true);
			try {
				Namespace asNamespace = metamodelManager.getASOf(Namespace.class, eObject);
				if (asNamespace != null) {
					Import asImport = context.createImport(UMLXUtil.getName(txImportNode), asNamespace);
					context.install(txImportNode, asImport);
					return asImport;
				}
			} catch (ParserException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}

		@Override
		public @Nullable Element visitTxKeyNode(@NonNull TxKeyNode txKeyNode) {
			EClass eClass = UMLXUtil.getReferredEClass(txKeyNode);
			org.eclipse.ocl.pivot.Class asClass = metamodelManager.getASOfEcore(org.eclipse.ocl.pivot.Class.class, eClass);
			assert asClass != null;
			List<@NonNull Property> asProperties = new ArrayList<>();
			createAll(UMLXUtil.getOwnedTxPartNodes(txKeyNode), asProperties);
			Key asKey = context.createKey(asClass, asProperties);
			context.install(txKeyNode, asKey);
			return asKey;
		}

		@Override
		public @Nullable Element visitTxPackageNode(@NonNull TxPackageNode txPackageNode) {
			EPackage ePackage = UMLXUtil.getReferredEPackage(txPackageNode);
			return metamodelManager.getASOfEcore(org.eclipse.ocl.pivot.Package.class, ePackage);
		}

		@Override
		public @Nullable Element visitTxPartNode(@NonNull TxPartNode txPartNode) {
			EStructuralFeature eStructuralFeature = UMLXUtil.getReferredEStructuralFeature(txPartNode);
			Property asProperty = metamodelManager.getASOfEcore(Property.class, eStructuralFeature);
			assert asProperty != null;
			if (txPartNode.isIsOpposite()) {
				asProperty = asProperty.getOpposite();
			}
			return asProperty;
		}

		@Override
		public @Nullable Element visitTxParameterNode(@NonNull TxParameterNode txParameterNode) {
			org.eclipse.ocl.pivot.@NonNull Class asClass = context.getReferredType(txParameterNode);
			FunctionParameter asFunctionParameter = context.createFunctionParameter(UMLXUtil.getName(txParameterNode), asClass, txParameterNode.isIsRequired());
			context.install(txParameterNode, asFunctionParameter);
			return asFunctionParameter;
		}

		@Override
		public @Nullable Element visitTxQueryNode(@NonNull TxQueryNode txQueryNode) {
			List<@NonNull FunctionParameter> qvtrParameters = new ArrayList<>();
			createAll(UMLXUtil.getOwnedTxParameterNodes(txQueryNode), qvtrParameters);
			org.eclipse.ocl.pivot.@NonNull Class asClass = context.getReferredType(txQueryNode);
			Function asFunction = context.createFunction(UMLXUtil.getName(txQueryNode), asClass, txQueryNode.isIsRequired(), qvtrParameters);
			context.install(txQueryNode, asFunction);
			context.txQueryNodes.add(txQueryNode);
			return asFunction;
		}

		@Override
		public @Nullable Element visitTxTypedModelNode(@NonNull TxTypedModelNode txTypedModelNode) {
			List<org.eclipse.ocl.pivot.@NonNull Package> usedPackages = new ArrayList<>();
			createAll(UMLXUtil.getOwnedTxPackageNodes(txTypedModelNode), usedPackages);
			TypedModel asTypedModel = context.createTypedModel(UMLXUtil.getName(txTypedModelNode), usedPackages);
			context.install(txTypedModelNode, asTypedModel);
			return asTypedModel;
		}

		@Override
		public @Nullable Element visitUMLXModel(@NonNull UMLXModel umlxModel) {
			qvtrModel.setExternalURI(context.qvtrResource.getURI().toString());
			context.install(umlxModel, qvtrModel);
			Iterable<@NonNull TxDiagram> txDiagrams = UMLXUtil.getOwnedTxDiagrams(umlxModel);
			visitAll(txDiagrams);
			List<@NonNull TxImportNode> txImports = new ArrayList<>();
			for (@NonNull TxDiagram txDiagram : txDiagrams) {
				Iterables.addAll(txImports, UMLXUtil.getOwnedTxImportNodes(txDiagram));
			}
			createAll(txImports, qvtrModel.getOwnedImports());
			//			createAll(PivotUtil.getOwnedPackages(qvtrModel), null); //umlxModel.getOwnedPackages());
			//			createAll(relationModel.getOwnedComments(), umlxModel.getOwnedComments());
			return null;
		}

		@Override
		public @Nullable Element visiting(@NonNull UMLXElement umlxElement) {
			System.out.println("Unsupported " + umlxElement.eClass().getName() + " for " + getClass().getSimpleName());
			return null;
			//			throw new IllegalArgumentException("Unsupported " + visitable.eClass().getName() + " for " + getClass().getSimpleName());
		}
	}

	private final @NonNull Resource umlxResource;
	private final @NonNull Resource qvtrResource;
	private final @NonNull Map<@NonNull UMLXElement, @NonNull Element> umlxElement2qvtrElement = new HashMap<>();
	private final @NonNull List<@NonNull PatternForest> patternForests = new ArrayList<>();
	private final @NonNull List<@NonNull TxQueryNode> txQueryNodes = new ArrayList<>();

	public UMLX2QVTr(@NonNull EnvironmentFactory environmentFactory, @NonNull Resource umlxResource, @NonNull Resource qvtrResource) {
		super(environmentFactory);
		this.umlxResource = umlxResource;
		this.qvtrResource = qvtrResource;
	}

	protected <T extends Element> @Nullable T basicGetQVTrElement(@NonNull Class<T> qvtrClass, @NonNull UMLXElement umlxElement) {
		Element qvtrElement = umlxElement2qvtrElement.get(umlxElement);
		if (qvtrElement == null) {
			return null;
		}
		if (!qvtrClass.isAssignableFrom(qvtrElement.getClass())) {
			throw new ClassCastException("QVTr element " + umlxElement + " cannot be cast to " + qvtrClass);
		}
		@SuppressWarnings("unchecked")T castElement = (T)qvtrElement;
		return castElement;
	}

	protected @NonNull EnvironmentFactory getEnvironmentFactory() {
		return environmentFactory;
	}

	protected <T extends Element> @NonNull T getQVTrElement(@NonNull Class<T> qvtrClass, @NonNull UMLXElement umlxElement) {
		Element qvtrElement = umlxElement2qvtrElement.get(umlxElement);
		if (qvtrElement == null) {
			throw new IllegalArgumentException("Missing UMLX element for " + umlxElement);
		}
		if (!qvtrClass.isAssignableFrom(qvtrElement.getClass())) {
			throw new ClassCastException("QVTr element " + umlxElement + " cannot be cast to " + qvtrClass);
		}
		@SuppressWarnings("unchecked")T castElement = (T)qvtrElement;
		return castElement;
	}

	protected org.eclipse.ocl.pivot.@NonNull Class getReferredType(@NonNull UMLXTypedElement umlxTypedElement) {
		PivotMetamodelManager metamodelManager = (PivotMetamodelManager) environmentFactory.getMetamodelManager();
		EClassifier eClassifier = UMLXUtil.getReferredEClassifier(umlxTypedElement);
		org.eclipse.ocl.pivot.Class asClass = metamodelManager.getASOfEcore(org.eclipse.ocl.pivot.Class.class, eClassifier);
		assert asClass != null;
		if (umlxTypedElement.isIsMany()) {
			asClass = metamodelManager.getCollectionType(umlxTypedElement.isIsOrdered(), umlxTypedElement.isIsUnique(), asClass,
				umlxTypedElement.isIsNullFree(), null, null);
		}
		return asClass;
	}

	/**
	 * Create a new trace for the given list of generated objects for the given
	 * context.
	 */
	protected void install(@NonNull UMLXElement umlxElement, @NonNull Element qvtrElement) {
		Element oldQVTrElement = umlxElement2qvtrElement.put(umlxElement, qvtrElement);
		assert oldQVTrElement == null;
		for (@NonNull String comment : UMLXUtil.getComments(umlxElement)) {
			qvtrElement.getOwnedComments().add(createComment(comment));
		}
	}

	/**
	 * Create a new trace for the given list of generated objects for the given
	 * context.
	 *
	protected void reinstall(@NonNull UMLXElement umlxElement, @NonNull Element qvtrElement) {
		Element oldQVTrElement = umlx2qvtr.put(umlxElement, qvtrElement);
		assert oldQVTrElement != null;
		qvtrElement.getOwnedComments().addAll(oldQVTrElement.getOwnedComments());
	} */

	/*	protected @Nullable ExpressionInOCL parseContextualExpressionInOCL(@NonNull EObject eContainer, @NonNull String textExpression) {
		//			context.getEnvironmentFactory().getMetamodelManager().parseSpecification(specification);
		ParserContext parserContext = new AbstractParserContext(environmentFactory, null) {

			@Override
			public @Nullable ScopeView computeLookup(@NonNull EObject target, @NonNull EnvironmentView environmentView, @NonNull ScopeView scopeView) {

				EObject pivot = eContainer;
				if ((pivot instanceof Element) && (pivot.eResource() != null) && !(pivot instanceof InvalidType)) {
					environmentView.computeLookups((Element) pivot, null); //PivotUtil.getPivot(Element.class, scopeView.getChild());
				}
				return scopeView.getParent();
			}
		};
		//			if (parserContext == null) {
		//				throw new ParserException(PivotMessagesInternal.UnknownContextType_ERROR_, NameUtil.qualifiedNameFor(contextElement), PivotUtilInternal.getSpecificationRole(specification));
		//			}
		parserContext.setRootElement((Element) eContainer);
		try {
			return parserContext.parse(eContainer, textExpression);
		} catch (ParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	} */
	protected @Nullable OCLExpression parseContextualExpression(@NonNull EObject eContainer, @NonNull List<String> textExpression) {
		//			context.getEnvironmentFactory().getMetamodelManager().parseSpecification(specification);
		ParserContext parserContext = new AbstractParserContext(environmentFactory, null) {

			@Override
			public @Nullable ScopeView computeLookup(@NonNull EObject target, @NonNull EnvironmentView environmentView, @NonNull ScopeView scopeView) {

				EObject pivot = eContainer;
				if ((pivot instanceof Element) && (pivot.eResource() != null) && !(pivot instanceof InvalidType)) {
					environmentView.computeLookups((Element) pivot, null); //PivotUtil.getPivot(Element.class, scopeView.getChild());
				}
				return scopeView.getParent();
			}
		};
		//			if (parserContext == null) {
		//				throw new ParserException(PivotMessagesInternal.UnknownContextType_ERROR_, NameUtil.qualifiedNameFor(contextElement), PivotUtilInternal.getSpecificationRole(specification));
		//			}
		parserContext.setRootElement((Element) eContainer);
		try {
			StringBuilder s = new StringBuilder();
			for (String line : textExpression) {
				s.append(line);
				s.append("\n");
			}
			ExpressionInOCL asExpressionInOCL = parserContext.parse(eContainer, s.toString());
			OCLExpression asExpression = asExpressionInOCL.getOwnedBody();
			assert asExpression != null;
			PivotUtilInternal.resetContainer(asExpression);
			return asExpression;
		} catch (ParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	private void resolveTxQueryBody(@NonNull TxQueryNode txQueryNode) {
		Function asFunction = getQVTrElement(Function.class, txQueryNode);
		List<String> lines = txQueryNode.getInitExpressionLines();
		if (lines.size() > 0) {
			OCLExpression qvtrExpression = parseContextualExpression(asFunction, lines);
			asFunction.setQueryExpression(qvtrExpression);
		}
	}

	public void transform() throws CompilerChainException {
		for (EObject eObject : umlxResource.getContents()) {
			if (eObject instanceof UMLXModel) {
				RelationModel qvtrModel = QVTrelationFactory.eINSTANCE.createRelationModel();
				qvtrModel.setExternalURI(qvtrResource.getURI().toString());
				((UMLXModel)eObject).accept(new CreateVisitor(this, qvtrModel));
				qvtrResource.getContents().add(qvtrModel);
			}
		}
		for (@NonNull TxQueryNode txQueryNode : txQueryNodes) {
			resolveTxQueryBody(txQueryNode);
		}
		for (@NonNull PatternForest patternForest : patternForests) {
			patternForest.resolveExpressions();		// Pass 2: parse the OCL text
		}
	}
}
