/*******************************************************************************
 * Copyright (c) 2016, 2022 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.Import;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.internal.manager.PivotMetamodelManager;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.ParserException;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.qvtd.compiler.CompilerChainException;
import org.eclipse.qvtd.pivot.qvtbase.Function;
import org.eclipse.qvtd.pivot.qvtbase.FunctionParameter;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtbase.utilities.TraceHelper;
import org.eclipse.qvtd.pivot.qvtrelation.Key;
import org.eclipse.qvtd.pivot.qvtrelation.QVTrelationFactory;
import org.eclipse.qvtd.pivot.qvtrelation.RelationModel;
import org.eclipse.qvtd.pivot.qvtrelation.RelationalTransformation;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrelationHelper;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrelationUtil;
import org.eclipse.qvtd.umlx.RelDiagram;
import org.eclipse.qvtd.umlx.TxDiagram;
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
		protected final @NonNull EnvironmentFactory environmentFactory;
		protected final @NonNull RelationModel qvtrModel;

		public CreateVisitor(@NonNull UMLX2QVTr context, @NonNull RelationModel qvtrModel) {
			super(context);
			this.environmentFactory = context.getEnvironmentFactory();
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
					assert token != null;
					asPackage = getPackage(asPackage, token);
				}
			}
			if (asPackage == null) {
				asPackage = getPackage(null, "");
			}
			//			Collections.sort(qvtrKeys, NameUtil.NAMEABLE_COMPARATOR);
			Iterables.addAll(QVTrelationUtil.Internal.getOwnedKeysList(qvtrRelationalTransformation), qvtrKeys);
			QVTbaseUtil.Internal.getOwnedClassesList(asPackage).add(qvtrRelationalTransformation);
			//
			List<@NonNull Rule> allRelationsList = new ArrayList<>();
			createAll(UMLXUtil.getOwnedRelDiagrams(txDiagram), allRelationsList);
			createAll(UMLXUtil.getOwnedTxQueryNodes(txDiagram), QVTbaseUtil.Internal.getOwnedOperationsList(qvtrRelationalTransformation));
			//
			for (@NonNull TxTypedModelNode txTypedModelNode : UMLXUtil.getOwnedTxTypedModelNodes(txDiagram)) {
				TypedModel asTypedModel = context.getQVTrElement(TypedModel.class, txTypedModelNode);
				for (@NonNull TxTypedModelNode txDependsOn : UMLXUtil.getDependsOns(txTypedModelNode)) {
					TypedModel asDependsOn = context.getQVTrElement(TypedModel.class, txDependsOn);
					asTypedModel.getDependsOn().add(asDependsOn);
				}
				for (@NonNull TxTypedModelNode txIterates : UMLXUtil.getIterates(txTypedModelNode)) {
					TypedModel asIterates = context.getQVTrElement(TypedModel.class, txIterates);
					asTypedModel.getIterates().add(asIterates);
				}
			}
			//			Collections.sort(allRelationsList, NameUtil.NAMEABLE_COMPARATOR);
			List<@NonNull Import> qvtrImports = QVTrelationUtil.Internal.getOwnedImportsList(qvtrModel);
			for (@NonNull TxPackageNode txPackageNode : UMLXUtil.getOwnedTxPackageNodes(txDiagram)) {
				for (@NonNull String name : UMLXUtil.getImportAliases(txPackageNode)) {
					try {
						org.eclipse.ocl.pivot.Package asImportedPackage = environmentFactory.getASOf(org.eclipse.ocl.pivot.Package.class, txPackageNode.getReferredEPackage());
						if (asImportedPackage != null) {
							Import qvtrImport = NameUtil.getNameable(qvtrImports, name);
							if (qvtrImport != null) {
								assert qvtrImport.getImportedNamespace() == asImportedPackage;
							}
							else {
								qvtrImport = context.createImport(name, asImportedPackage);
								qvtrImports.add(qvtrImport);
							}
						}
					} catch (ParserException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			//
			Iterables.addAll(QVTrelationUtil.Internal.getOwnedRelationsList(qvtrRelationalTransformation), allRelationsList);
			QVTbaseUtil.getContextVariable(environmentFactory.getStandardLibrary(), qvtrRelationalTransformation);
			qvtrRelationalTransformation.getModelParameter().add(context.createTraceTypedModel());
			if (QVTbaseUtil.basicGetPrimitiveTypedModel(qvtrRelationalTransformation) == null) {
				qvtrRelationalTransformation.getModelParameter().add(0, context.createPrimitiveTypedModel());
			}
			if (QVTbaseUtil.basicGetThisTypedModel(qvtrRelationalTransformation) == null) {
				qvtrRelationalTransformation.getModelParameter().add(1, context.createThisTypedModel());
			}
			return qvtrRelationalTransformation;
		}

		@Override
		public @Nullable Element visitTxKeyNode(@NonNull TxKeyNode txKeyNode) {
			EClass eClass = UMLXUtil.getReferredEClass(txKeyNode);
			Key asKey = null;
			try {
				org.eclipse.ocl.pivot.Class asClass = environmentFactory.getASOf(org.eclipse.ocl.pivot.Class.class, eClass);
				assert asClass != null;
				List<@NonNull Property> asProperties = new ArrayList<>();
				createAll(UMLXUtil.getOwnedTxPartNodes(txKeyNode), asProperties);
				asKey = context.createKey(asClass, asProperties);
				context.install(txKeyNode, asKey);
			} catch (ParserException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return asKey;
		}

		//		@Override
		//		public @Nullable Element visitTxPackageNode(@NonNull TxPackageNode txPackageNode) {
		//			EPackage ePackage = UMLXUtil.getReferredEPackage(txPackageNode);
		//			return metamodelManager.getASOfEcore(org.eclipse.ocl.pivot.Package.class, ePackage);
		//		}

		@Override
		public @Nullable Element visitTxPartNode(@NonNull TxPartNode txPartNode) {
			EStructuralFeature eStructuralFeature = UMLXUtil.getReferredEStructuralFeature(txPartNode);
			Property asProperty = null;
			try {
				asProperty = environmentFactory.getASOf(Property.class, eStructuralFeature);
				assert asProperty != null;
				if (txPartNode.isIsOpposite()) {
					asProperty = asProperty.getOpposite();
				}
			} catch (ParserException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
			for (@NonNull TxPackageNode txPackageNode : UMLXUtil.getUsedTxPackageNodes(txTypedModelNode)) {
				try {
					org.eclipse.ocl.pivot.Package asPackage = environmentFactory.getASOf(org.eclipse.ocl.pivot.Package.class, txPackageNode.getReferredEPackage());
					if (asPackage != null) {
						usedPackages.add(asPackage);
					}
				} catch (ParserException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			TypedModel asTypedModel = context.createTypedModel(UMLXUtil.getName(txTypedModelNode), usedPackages);
			context.install(txTypedModelNode, asTypedModel);
			return asTypedModel;
		}

		@Override
		public @Nullable Element visitUMLXModel(@NonNull UMLXModel umlxModel) {
			context.install(umlxModel, qvtrModel);
			Iterable<@NonNull TxDiagram> txDiagrams = UMLXUtil.getOwnedTxDiagrams(umlxModel);
			visitAll(txDiagrams);
			/*			for (@NonNull TxDiagram txDiagram : txDiagrams) {
				for (@NonNull TxTypedModelNode txTypedModelNode : UMLXUtil.getOwnedTxTypedModelNodes(txDiagram)) {
					String name = txTypedModelNode.getName();
					if (name != null) {
						String uriString = txTypedModelNode.getUri();
						if (uriString != null) {
							URI uri = URI.createURI(uriString);
							Resource umlxResource = umlxModel.eResource();
							if (umlxResource != null) {
								URI resourceURI = umlxResource.getURI();
								uri = uri.resolve(resourceURI);
							}
							EObject eObject = context.getEnvironmentFactory().getResourceSet().getEObject(uri, true);
							try {
								Namespace asNamespace = metamodelManager.getASOf(Namespace.class, eObject);
								if (asNamespace != null) {


									Import asImport = context.createImport(name, asNamespace);
									//									context.install(txImportNode, asImport);
									qvtrModel.getOwnedImports().add(asImport);
									return asImport;
								}
							} catch (ParserException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
				}
			} */
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
	private final @NonNull TraceHelper traceHelper;
	private final @NonNull Map<@NonNull UMLXElement, @NonNull Element> umlxElement2qvtrElement = new HashMap<>();
	private final @NonNull List<@NonNull PatternForest> patternForests = new ArrayList<>();
	private final @NonNull List<@NonNull TxQueryNode> txQueryNodes = new ArrayList<>();

	public UMLX2QVTr(@NonNull EnvironmentFactory environmentFactory, @NonNull Resource umlxResource, @NonNull Resource qvtrResource) {
		super(environmentFactory);
		this.umlxResource = umlxResource;
		this.qvtrResource = qvtrResource;
		this.traceHelper = new TraceHelper(environmentFactory);
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

	public @NonNull Variable createTraceClassVariable() {
		return createTraceClassVariable(traceHelper);
	}

	@Override
	public @NonNull EnvironmentFactory getEnvironmentFactory() {
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

	protected @NonNull OCLExpression parseContextualExpression(@NonNull EObject eContainer, @NonNull List<String> textExpression) throws CompilerChainException {
		UMLXParserContext parserContext = new UMLXParserContext(environmentFactory, eContainer);
		try {
			StringBuilder s = new StringBuilder();
			for (String line : textExpression) {
				if (s.length() > 0) {
					s.append("\n");
				}
				s.append(line);
			}
			OCLExpression asExpression = parserContext.parseExpression(eContainer, s.toString());
			PivotUtilInternal.resetContainer(asExpression);
			return asExpression;
		} catch (Exception e) {
			throw new CompilerChainException(e);
		}
	}

	private void resolveTxQueryBody(@NonNull TxQueryNode txQueryNode) throws CompilerChainException {
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
