/*******************************************************************************
 * Copyright (c) 2014, 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     R.Dvorak and others - QVTo debugger framework
 *     E.D.Willink - revised API for OCL/QVTi debugger framework
 *******************************************************************************/
package org.eclipse.qvtd.umlx.ui.launching;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.utilities.TreeIterable;
import org.eclipse.qvtd.compiler.AbstractCompilerChain;
import org.eclipse.qvtd.compiler.CompilerChain;
import org.eclipse.qvtd.compiler.CompilerChain.Key;
import org.eclipse.qvtd.compiler.CompilerChainException;
import org.eclipse.qvtd.debug.launching.QVTiLaunchConstants;
import org.eclipse.qvtd.debug.ui.QVTdDebugUIPlugin;
import org.eclipse.qvtd.debug.ui.launching.DirectionalMainTab;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEnvironmentFactory;
import org.eclipse.qvtd.umlx.TxDiagram;
import org.eclipse.qvtd.umlx.TxTypedModelNode;
import org.eclipse.qvtd.umlx.compiler.UMLXCompilerChain;
import org.eclipse.qvtd.xtext.qvtcore.QVTcoreStandaloneSetup;
import org.eclipse.swt.graphics.Image;

public class UMLXMainTab extends DirectionalMainTab<TxDiagram>
{
	private static final @NonNull String @NonNull [] intermediateKeys = new @NonNull String[] {
		CompilerChain.QVTR_STEP,
		CompilerChain.QVTC_STEP,
		CompilerChain.QVTU_STEP,
		CompilerChain.QVTM_STEP,
		CompilerChain.QVTS_STEP,
		CompilerChain.QVTI_STEP,
		CompilerChain.JAVA_STEP,
		CompilerChain.CLASS_STEP
	};

	@Override
	protected @NonNull CompilerChain createCompilerChain(@NonNull QVTiEnvironmentFactory environmentFactory, @NonNull URI txURI,
			@NonNull Map<@NonNull String, @Nullable Map<@NonNull Key<Object>, @Nullable Object>> options) {
		QVTcoreStandaloneSetup.class.getName();			// QVTrCompilerChain doesn't initialize QVTc
		return new UMLXCompilerChain(environmentFactory, txURI, options);
	}

	private void gatherOutputModels(@NonNull List<TxTypedModelNode> outputModels, @NonNull TxTypedModelNode typedModel) {
		if (!outputModels.contains(typedModel)) {
			outputModels.add(typedModel);
			//			for (TypedModel anotherTypedModel : typedModel.getDependsOn()) {
			//				if (anotherTypedModel != null) {
			//					gatherOutputModels(outputModels, anotherTypedModel);
			//				}
			//			}
		}
	}

	@Override
	public Image getImage() {
		return QVTdDebugUIPlugin.getDefault().createImage("icons/UMLXModelFile.gif");
	}

	@Override
	protected @NonNull String @NonNull [] getIntermediateKeysInternal() {
		return intermediateKeys;
	}

	@Override
	protected void initializeOptions(@NonNull Map<@NonNull String, @Nullable Map<@NonNull Key<Object>, @Nullable Object>> options) {
		super.initializeOptions(options);
		initializeURIOption(options, CompilerChain.QVTR_STEP);
		initializeURIOption(options, CompilerChain.QVTC_STEP);
		AbstractCompilerChain.setOption(options, CompilerChain.GENMODEL_STEP, CompilerChain.URI_KEY, getResolvedGenModel());
		Map<@NonNull String, @Nullable String> genModelOptions = new HashMap<@NonNull String, @Nullable String>();
		genModelOptions.put(CompilerChain.GENMODEL_BASE_PREFIX, getProjectName());
		AbstractCompilerChain.setOption(options, CompilerChain.GENMODEL_STEP, CompilerChain.GENMODEL_OPTIONS_KEY, genModelOptions);
	}

	@Override
	protected void updateDirection(@NonNull TxDiagram txDiagram) {
		//		System.out.println("updateDirection");
		Set<@NonNull String> enforceableDirectionNames = new HashSet<>();
		for (TxTypedModelNode txTypedModelNode : txDiagram.getOwnedTxTypedModelNodes()) {
			if (txTypedModelNode.isEnforce()) {
				String name = txTypedModelNode.getName();
				if (name != null) {
					enforceableDirectionNames.add(name);
				}
			}
		}
		setDirections(enforceableDirectionNames);
	}

	@Override
	protected void updateGroups(@NonNull TxDiagram txDiagram,
			@NonNull Map<@NonNull String, @Nullable String> oldInputsMap, @NonNull Map<@NonNull String, @Nullable String> newInputsMap,
			@NonNull Map<@NonNull String, @Nullable String> oldOutputsMap, @NonNull Map<@NonNull String, @Nullable String> newOutputsMap,
			@NonNull Map<@NonNull String, @Nullable String> intermediateMap) {
		super.updateGroups(txDiagram, oldInputsMap, newInputsMap, oldOutputsMap, newOutputsMap, intermediateMap);
		Set<@NonNull TxTypedModelNode> inputs = new HashSet<>();
		Set<@NonNull TxTypedModelNode> outputs = new HashSet<>();
		String directionName = directionCombo.getText();
		List<@NonNull TxTypedModelNode> inputModels = new ArrayList<>();
		List<@NonNull TxTypedModelNode> outputModels = new ArrayList<>();
		for (@NonNull TxTypedModelNode typedModel : ClassUtil.nullFree(txDiagram.getOwnedTxTypedModelNodes())) {
			if (ClassUtil.safeEquals(typedModel.getName(), directionName)) {
				gatherOutputModels(outputModels, typedModel);
			}
		}
		for (TxTypedModelNode inputModel : ClassUtil.nullFree(txDiagram.getOwnedTxTypedModelNodes())) {
			if (inputModel.getName() != null) {
				inputModels.add(inputModel);
			}
		}
		inputModels.removeAll(outputModels);
		String modeName = modeCombo.getText();
		if (QVTiLaunchConstants.CHECK_MODE.equals(modeName)) {
			for (TxTypedModelNode inputModel : inputModels) {
				if (inputs.add(inputModel)) {
					String name = inputModel.getName();
					if (name != null) {
						newInputsMap.put(name, null); //getDefaultPath(outputsGroup, name));
					}
				}
			}
			for (TxTypedModelNode outputModel : outputModels) {
				if (outputs.add(outputModel)) {
					String name = outputModel.getName();
					if (name != null) {
						oldOutputsMap.put(name, null); //getDefaultPath(outputsGroup, name));
					}
				}
			}
		}
		else if (QVTiLaunchConstants.ENFORCE_CREATE_MODE.equals(modeName)) {
			for (TxTypedModelNode inputModel : inputModels) {
				if (inputs.add(inputModel)) {
					String name = inputModel.getName();
					if (name != null) {
						newInputsMap.put(name, null); //getDefaultPath(outputsGroup, name));
					}
				}
			}
			for (TxTypedModelNode outputModel : outputModels) {
				if (outputs.add(outputModel)) {
					String name = outputModel.getName();
					if (name != null) {
						newOutputsMap.put(name, null); //getDefaultPath(outputsGroup, name));
					}
				}
			}
		}
		if (QVTiLaunchConstants.ENFORCE_UPDATE_MODE.equals(modeName)) {
			for (TxTypedModelNode inputModel : inputModels) {
				if (inputs.add(inputModel)) {
					String name = inputModel.getName();
					if (name != null) {
						oldInputsMap.put(name, null); //getDefaultPath(outputsGroup, name));
						newInputsMap.put(name, null); //getDefaultPath(outputsGroup, name));
					}
				}
			}
			for (TxTypedModelNode outputModel : outputModels) {
				if (outputs.add(outputModel)) {
					String name = outputModel.getName();
					if (name != null) {
						oldOutputsMap.put(name, null); //getDefaultPath(outputsGroup, name));
						newOutputsMap.put(name, null); //getDefaultPath(outputsGroup, name));
					}
				}
			}
		}
		/*		for (TypedModel outputModel : outputModels) {
			if (outputs.add(outputModel)) {
				String name = outputModel.getName();
				assert name != null;
				if (name != null) {
					newOutputsMap.put(name, null); //getDefaultPath(outputsGroup, name));
				}
			}
		}
		checkables.addAll(enforceables);
		checkables.removeAll(outputModels);
		for (TypedModel inputModel : checkables) {
			if (inputs.add(inputModel)) {
				String name = inputModel.getName();
				assert name != null;
				if (name != null) {
					newInputsMap.put(name, null); //getDefaultPath(inputsGroup, name));
				}
			}
		} */
	}

	@Override
	protected @NonNull TxDiagram updateTransformation(@NonNull URI umlxURI) throws IOException {
		QVTiEnvironmentFactory environmentFactory = getEnvironmentFactory();
		Resource umlxResource = environmentFactory.getResourceSet().getResource(umlxURI, true);
		if (umlxResource.getErrors().size() > 0) {
			String message = PivotUtil.formatResourceDiagnostics(umlxResource.getErrors(), "", "\n");
			if (message != null) {
				throw new CompilerChainException(message);
			}
		}
		for (EObject eObject : new TreeIterable(umlxResource)) {
			if (eObject instanceof TxDiagram) {
				return (TxDiagram) eObject;
			}
		}
		throw new IllegalStateException();
	}
}
