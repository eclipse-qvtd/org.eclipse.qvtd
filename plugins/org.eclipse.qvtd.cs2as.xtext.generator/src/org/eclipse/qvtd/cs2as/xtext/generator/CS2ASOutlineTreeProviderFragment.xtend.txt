/*******************************************************************************
 * Copyright (c) 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.cs2as.xtext.generator;

import org.eclipse.xtext.xtext.generator.ui.outline.OutlineTreeProviderFragment2;
import com.google.inject.Inject
import org.eclipse.xtext.xtext.generator.model.FileAccessFactory
import org.eclipse.xtext.Grammar
import org.eclipse.xtext.xtext.generator.model.TypeReference
import org.eclipse.xtext.GrammarUtil

import static extension org.eclipse.xtext.xtext.generator.model.TypeReference.typeRef
import org.eclipse.xtext.xtext.generator.XtextGeneratorNaming

public class CS2ASOutlineTreeProviderFragment extends OutlineTreeProviderFragment2 {

	@Inject FileAccessFactory fileAccessFactory;
	@Inject Grammar grammar;
	
	
	override TypeReference getOutlineTreeProviderClass(Grammar grammar) {
		new TypeReference(GrammarUtil.getNamespace(grammar)
			+ ".ui.outline." + GrammarUtil.getSimpleName(grammar) + "CS2ASOutlineTreeProvider"
		)
	}
	override generateJavaOutlineTreeProvider() {
		
	fileAccessFactory.createJavaFile(grammar.outlineTreeProviderClass, '''
		/**
		 * Customization of the default outline structure.
		 *
		 * See https://www.eclipse.org/Xtext/documentation/304_ide_concepts.html#outline
		 */
		public class «grammar.outlineTreeProviderClass.simpleName» extends 
			«GrammarUtil.getNamespace(grammar)+ ".ui.outline.CS2ASOutlineTreeProvider" » {
			
		}
	''').writeTo(projectConfig.eclipsePlugin.src)
	}
	
	
	override generateXtendOutlineTreeProvider() {
		fileAccessFactory.createXtendFile(grammar.outlineTreeProviderClass, '''
		/**
		 * Customization of the default outline structure.
		 *
		 * See https://www.eclipse.org/Xtext/documentation/304_ide_concepts.html#outline
		 */
		public class «grammar.outlineTreeProviderClass.simpleName» extends 
			«GrammarUtil.getNamespace(grammar)+ ".ui.outline.CS2ASOutlineTreeProvider" » {
			
		}
		''').writeTo(projectConfig.eclipsePlugin.src)
	}
}