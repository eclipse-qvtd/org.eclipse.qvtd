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
import org.eclipse.qvtd.compiler.QVTcCompilerChain;
import org.eclipse.qvtd.compiler.CompilerOptions;
import org.eclipse.qvtd.compiler.DefaultCompilerOptions;
import org.eclipse.qvtd.debug.launching.QVTcLaunchConfigurationDelegate;
import org.eclipse.qvtd.debug.ui.QVTdDebugUIPlugin;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtcore.utilities.QVTcoreUtil;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEnvironmentFactory;
import org.eclipse.swt.graphics.Image;

import com.google.common.collect.Lists;

public class QVTcMainTab extends QVTDirectionalMainTab<Transformation>
{
	@Override
	protected @NonNull QVTcCompilerChain createCompilerChain(@NonNull URI txURI, @NonNull CompilerOptions options) {
		return new QVTcCompilerChain(txURI, txURI, options);
	}

	@Override
	public Image getImage() {
		return QVTdDebugUIPlugin.getDefault().createImage("icons/QVTcModelFile.gif");
	}

	@Override
	protected @NonNull List<@NonNull String> getIntermediateKeys() {
		List<@NonNull String> asList = Lists.newArrayList(QVTcLaunchConfigurationDelegate.compileStepKeys);
		if (!isInterpreted()) {
			for (@NonNull String stepKey : QVTcLaunchConfigurationDelegate.generateStepKeys) {
				asList.add(stepKey);
			}
		}
		return asList;
	}

	@Override
	protected void initializeOptions(@NonNull DefaultCompilerOptions compilerOptions) throws IOException {
		Map<@NonNull String, @NonNull URI> intermediatesMap = getIntermediatesMap(QVTcLaunchConfigurationDelegate.compileStepKeys);
		compilerOptions.setURIs2(QVTcLaunchConfigurationDelegate.compileStepKeys, intermediatesMap);
		compilerOptions.setDebugGraphs(doDotGraphs(), doYedGraphs());
		if (!isInterpreted()) {
			URI txURI = getTxURI();
			URI genModelURI = getResolvedGenModel();
			URI javaURI = getResolvedCompilerStep(CompilerChain.JAVA_STEP);
			URI classURI = getResolvedCompilerStep(CompilerChain.CLASS_STEP);
			compilerOptions.setQVTcGenerateOptions(getProjectName(), txURI, genModelURI, javaURI, classURI);
		}
	}

	@Override
	protected @NonNull Transformation updateTransformation(@NonNull URI txURI) throws IOException {
		//		System.out.println("QVTc::updateTransformation");
		QVTiEnvironmentFactory environmentFactory = getEnvironmentFactory();
		return QVTcoreUtil.loadTransformation(environmentFactory, txURI, environmentFactory.keepDebug());
	}
}
