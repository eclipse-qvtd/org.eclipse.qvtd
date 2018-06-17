/*******************************************************************************
 * Copyright (c) 2014, 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtrelation;

import org.antlr.runtime.TokenSource;
import org.eclipse.ocl.xtext.base.services.RetokenizingTokenSource;
import org.eclipse.qvtd.xtext.qvtrelation.parser.antlr.QVTrelationParser;
import org.eclipse.qvtd.xtext.qvtrelation.scoping.QVTrelationScopeProvider;
import org.eclipse.qvtd.xtext.qvtrelation.serializer.QVTrelationCrossReferenceSerializer;
import org.eclipse.qvtd.xtext.qvtrelation.utilities.QVTrelationCSResource;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.scoping.IScopeProvider;

import com.google.inject.Binder;
import com.google.inject.name.Names;

/**
 * Use this class to register components to be used at runtime / without the Equinox extension registry.
 */
public class QVTrelationRuntimeModule extends org.eclipse.qvtd.xtext.qvtrelation.AbstractQVTrelationRuntimeModule
{
	@Override
	public void configure(Binder binder) {
		super.configure(binder);
		binder.bindConstant().annotatedWith(Names.named(org.eclipse.xtext.validation.CompositeEValidator.USE_EOBJECT_VALIDATOR)).to(false);
	}

	@Override
	public Class<? extends org.eclipse.xtext.parser.IParser> bindIParser() {
		return RetokenizingQVTrelationParser.class;
	}

	@Override
	@SuppressWarnings("restriction")
	public Class<? extends org.eclipse.xtext.serializer.tokens.ICrossReferenceSerializer> bindICrossReferenceSerializer() {
		return QVTrelationCrossReferenceSerializer.class;
	}

	public static class RetokenizingQVTrelationParser extends QVTrelationParser
	{
		@Override
		protected XtextTokenStream createTokenStream(TokenSource tokenSource) {
			return super.createTokenStream(new RetokenizingTokenSource(tokenSource, getTokenDefProvider().getTokenDefMap()));
		}
	}

	@Override
	public Class<? extends IScopeProvider> bindIScopeProvider() {
		return QVTrelationScopeProvider.class;
	}

	@Override
	public Class<? extends XtextResource> bindXtextResource() {
		return QVTrelationCSResource.class;
	}
}
