/**
 * <copyright>
 *
 * Copyright (c) 2011 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.qvtd.xtext.qvtcore;

import org.antlr.runtime.TokenSource;
import org.eclipse.ocl.examples.xtext.essentialocl.services.RetokenizingTokenSource;
import org.eclipse.qvtd.xtext.qvtcore.parser.antlr.QVTcoreParser;
import org.eclipse.qvtd.xtext.qvtcore.scoping.QVTcoreScopeProvider;
import org.eclipse.qvtd.xtext.qvtcore.utilities.QVTcoreCSResource;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.scoping.IScopeProvider;

import com.google.inject.Binder;
import com.google.inject.name.Names;

/**
 * Use this class to register components to be used at runtime / without the Equinox extension registry.
 */
public class QVTcoreRuntimeModule extends AbstractQVTcoreRuntimeModule
{
	@Override
	public void configure(Binder binder) {
		super.configure(binder);
		binder.bindConstant().annotatedWith(Names.named(org.eclipse.xtext.validation.CompositeEValidator.USE_EOBJECT_VALIDATOR)).to(false);
	}
	
	@Override
	public Class<? extends org.eclipse.xtext.parser.IParser> bindIParser() {
		return RetokenizingQVTcoreParser.class;
	}

	public static class RetokenizingQVTcoreParser extends QVTcoreParser
	{
		@Override
		protected XtextTokenStream createTokenStream(TokenSource tokenSource) {
			return super.createTokenStream(new RetokenizingTokenSource(tokenSource, getTokenDefProvider().getTokenDefMap()));
		}
	}

	@Override
	public Class<? extends IScopeProvider> bindIScopeProvider() {
		return QVTcoreScopeProvider.class;
	}
	
	@Override
	public Class<? extends XtextResource> bindXtextResource() {
		return QVTcoreCSResource.class;
	}
}
