/*******************************************************************************
 * Copyright (c) 2014, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     R.Dvorak and others - QVTo debugger framework
 *     E.D.Willink - revised API for OCL/QVTi debugger framework
 *******************************************************************************/
package org.eclipse.qvtd.debug.ui.launching;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.compiler.CompilerChain;
import org.eclipse.qvtd.compiler.QVTrCompilerChain;
import org.eclipse.qvtd.compiler.CompilerOptions;
import org.eclipse.qvtd.compiler.DefaultCompilerOptions;
import org.eclipse.qvtd.debug.launching.QVTrLaunchConfigurationDelegate;
import org.eclipse.qvtd.debug.ui.QVTdDebugUIPlugin;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtrelation.RelationalTransformation;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrelationUtil;
import org.eclipse.qvtd.xtext.qvtcore.QVTcoreStandaloneSetup;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;

import com.google.common.collect.Lists;

public class QVTrMainTab extends QVTDirectionalMainTab<RelationalTransformation>
{
	@Override
	protected @NonNull CompilerChain createCompilerChain(@NonNull URI txURI, @NonNull CompilerOptions options) {
		QVTcoreStandaloneSetup.class.getName();			// QVTrCompilerChain doesn't initialize QVTc
		return new QVTrCompilerChain(txURI, txURI, options);
	}

	@Override
	protected void createGenmodelGroup(Composite control) {}

	@Override
	public Image getImage() {
		return QVTdDebugUIPlugin.getDefault().createImage("icons/QVTrModelFile.gif");
	}

	@Override
	protected @NonNull List<@NonNull String> getIntermediateKeys() {
		List<@NonNull String> asList = Lists.newArrayList(QVTrLaunchConfigurationDelegate.compileStepKeys);
		if (!isInterpreted()) {
			for (@NonNull String stepKey : QVTrLaunchConfigurationDelegate.generateStepKeys) {
				asList.add(stepKey);
			}
		}
		return asList;
	}

	@Override
	protected void initializeOptions(@NonNull DefaultCompilerOptions compilerOptions) throws IOException {
		Map<@NonNull String, @NonNull URI> intermediatesMap = getIntermediatesMap(QVTrLaunchConfigurationDelegate.compileStepKeys);
		compilerOptions.setURIs2(QVTrLaunchConfigurationDelegate.compileStepKeys, intermediatesMap);
		compilerOptions.setDebugGraphs(doDotGraphs(), doYedGraphs());
		if (!isInterpreted()) {
			URI txURI = getTxURI();
			URI genModelURI = getResolvedCompilerStep(CompilerChain.GENMODEL_STEP);
			URI javaURI = getResolvedCompilerStep(CompilerChain.JAVA_STEP);
			URI classURI = getResolvedCompilerStep(CompilerChain.CLASS_STEP);
			compilerOptions.setQVTrGenerateOptions(getProjectName(), txURI, genModelURI, javaURI, classURI);
		}
	}

	@Override
	protected @NonNull RelationalTransformation updateTransformation(@NonNull URI txURI) throws IOException {
		QVTiEnvironmentFactory environmentFactory = getEnvironmentFactory();
		return QVTrelationUtil.loadTransformation(environmentFactory, txURI, environmentFactory.keepDebug());
	}
}
