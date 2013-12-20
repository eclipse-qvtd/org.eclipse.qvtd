/*******************************************************************************
 * Copyright (c) 2009 R.Dvorak and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Radek Dvorak - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.debug.vm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.LoopExp;
import org.eclipse.ocl.examples.pivot.Namespace;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.OperationCallExp;
import org.eclipse.qvtd.debug.stubs.ASTBindingHelper;
import org.eclipse.qvtd.debug.utils.CompiledUnit;
import org.eclipse.qvtd.debug.utils.LineNumberProvider;
import org.eclipse.qvtd.pivot.qvtimperative.util.AbstractExtendingQVTimperativeVisitor;

public class ValidBreakpointLocator extends AbstractExtendingQVTimperativeVisitor<Boolean, CompiledUnit>
{
	private static final @NonNull ValidBreakpointLocator INSTANCE = new ValidBreakpointLocator();
	@SuppressWarnings("null")
	public static final @NonNull Boolean IS_START = Boolean.TRUE;
	@SuppressWarnings("null")
	public static final @NonNull Boolean IS_END = Boolean.FALSE;
	
	public static @NonNull List<Element> getBreakpointableElementsForLine(@NonNull CompiledUnit compiledModule, final LineNumberProvider lineNumbers, final int lineNumber) {
		ValidBreakpointLocator locator = new ValidBreakpointLocator(compiledModule, lineNumbers, lineNumber);
		return locator.gatherElements();
	}

	public static boolean isBreakpointableElementEnd(@NonNull Element element) {
		return element.accept(INSTANCE) == IS_END;
	}

	public static boolean isBreakpointableElementStart(@NonNull Element element) {
		return element.accept(INSTANCE) == IS_START;
	}
	
	private final @NonNull List<Element> elements = new ArrayList<Element>();
	private final int lineNumber;
	private final LineNumberProvider lineNumbers;

	private ValidBreakpointLocator() {
		super(new CompiledUnit());
		this.lineNumber = 0;
		this.lineNumbers = null;
	}

	protected ValidBreakpointLocator(@NonNull CompiledUnit compiledModule, final LineNumberProvider lineNumbers, final int lineNumber) {
		super(compiledModule);
		this.lineNumber = lineNumber;
		this.lineNumbers = lineNumbers;
	}

	protected @NonNull List<Element> gatherElements() {
		for (Namespace nextModule : context.getModules()) {
			for (TreeIterator<EObject> tit = nextModule.eAllContents(); tit.hasNext(); ) {
				EObject eObject = tit.next();
				if (eObject instanceof Element) {
					Element element = (Element)eObject;
					boolean found = false;
					Boolean isStartNotEnd = element.accept(this);
					if (isStartNotEnd == IS_START) {
				        int line = lineNumbers.getLineNumber(ASTBindingHelper.getStartPosition(element));
						if(line == lineNumber) {
							elements.add(element);
							found = true;
						}
					}
					
					if (!found && (isStartNotEnd == IS_END)) {
				        int line = lineNumbers.getLineNumber(ASTBindingHelper.getEndPosition(element));
						if (line == lineNumber) {
							elements.add(element);
						}
					}	
				}
			}
		}
		if (!elements.isEmpty()) {
			// already found, can't be spread across multiple modules
			return elements;
		}
		@SuppressWarnings("null")@NonNull List<Element> emptyList = Collections.emptyList();
		return emptyList;
	}
	

	@Override
	public @Nullable Boolean visitElement(@NonNull Element object) {
		return IS_START; //null;
	}

	@Override
	public @Nullable Boolean visitLoopExp(@NonNull LoopExp object) {
		return null;
	}

	@Override
	public @Nullable Boolean visitOCLExpression(@NonNull OCLExpression object) {
		return IS_START;
	}

	
	@Override
	public @Nullable Boolean visitOperationCallExp(@NonNull OperationCallExp object) {
		return IS_END;
	}

	@Override
	public @Nullable Boolean visiting(@NonNull org.eclipse.ocl.examples.pivot.util.Visitable visitable) {
		throw new UnsupportedOperationException("Unimplemented " + getClass().getName() + " for " + visitable.eClass().getName());
	}
}
