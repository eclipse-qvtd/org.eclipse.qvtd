/*******************************************************************************
 * Copyright (c) 2015 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.scheduler;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CollectionItem;
import org.eclipse.ocl.pivot.CollectionLiteralExp;
import org.eclipse.ocl.pivot.CollectionRange;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.EnumLiteralExp;
import org.eclipse.ocl.pivot.IfExp;
import org.eclipse.ocl.pivot.LetExp;
import org.eclipse.ocl.pivot.LoopExp;
import org.eclipse.ocl.pivot.MapLiteralExp;
import org.eclipse.ocl.pivot.MapLiteralPart;
import org.eclipse.ocl.pivot.NavigationCallExp;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.PrimitiveLiteralExp;
import org.eclipse.ocl.pivot.ShadowExp;
import org.eclipse.ocl.pivot.ShadowPart;
import org.eclipse.ocl.pivot.TupleLiteralExp;
import org.eclipse.ocl.pivot.TupleLiteralPart;
import org.eclipse.ocl.pivot.TypeExp;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableExp;
import org.eclipse.ocl.pivot.util.AbstractExtendingVisitor;
import org.eclipse.ocl.pivot.util.Visitable;

/**
 * The INSTANCE of the IsConstantExpressionVisitor visits an expression tree to determine whether
 * the tree evaluates to an unconditionally constant value.
 * 
 * Any use of a VariableExp with an indeterminate initializer causes a non-constant verdict. 
 * 
 * Use of a LoopExp iterator within its loop is constant, provided the loop source is constant.
 * 
 * Use of NavigationCallExp is constant, provided the navigation source is constant.
 * 
 * Use of OperationCallExp is constant, provided the source and arguments are constant; OCL has only queries.
 */
public class IsConstantExpressionVisitor extends AbstractExtendingVisitor<Boolean, Object>
{
	/**
	 * Objects (variables) asserted to be constant by the caller.
	 */
	protected final @Nullable Set<Object> knownConstants;

	/**
	 * Objects (variables) asserted to be constant by the caller or effectively constant as a consequence
	 * of use within an iteration.
	 */
	private /*@LazyNonNull*/ Set<Object> myConstants = null;

	/**
	 * Construct an IsConstantExpressionVisitor that may be used to determine whether expressions
	 * are constant-valued. If knownConstants is provided any references to them are interpreted
	 * as constant-valued.
	 */
	public IsConstantExpressionVisitor(@Nullable Set<Object> knownConstants) {
		super(IsConstantExpressionVisitor.class);
		this.knownConstants = knownConstants;
	}

	/**
	 * Return true if visitable is a constant-valued expression.
	 */
	public boolean isConstant(@Nullable Visitable visitable) {
		if ((visitable != null) && (visitable.accept(this) == true)) {
			return true;
		}
		return false;
	}

	/**
	 * Return true if all visitables are constant-valued expressions.
	 */
	public boolean isConstant(@Nullable Iterable<? extends Visitable> visitables) {
		if (visitables != null) {
			for (@SuppressWarnings("null")@NonNull Visitable visitable : visitables) {
				if (!isConstant(visitable)) {
					return false;
				}
			}
		}
		return true;
	}

	@Override
	public @NonNull Boolean visiting(@NonNull Visitable visitable) {
		throw new UnsupportedOperationException(getClass().getSimpleName() + ": " + visitable.getClass().getSimpleName());
	}

	@Override
	public @NonNull Boolean visitCollectionItem(@NonNull CollectionItem collectionItem) {
		return isConstant(collectionItem.getOwnedItem());
	}

	@Override
	public @NonNull Boolean visitCollectionLiteralExp(@NonNull CollectionLiteralExp collectionLiteralExp) {
		return isConstant(collectionLiteralExp.getOwnedParts());
	}

	@Override
	public @NonNull Boolean visitCollectionRange(@NonNull CollectionRange collectionRange) {
		return isConstant(collectionRange.getOwnedFirst()) && isConstant(collectionRange.getOwnedLast());
	}

	@Override
	public @NonNull Boolean visitElement(@NonNull Element element) {
		return false;
	}

	@Override
	public @NonNull Boolean visitEnumLiteralExp(@NonNull EnumLiteralExp enumLiteralExp) {
		return true;
	}

	@Override
	public @NonNull Boolean visitIfExp(@NonNull IfExp ifExp) {
		return isConstant(ifExp.getOwnedCondition()) && isConstant(ifExp.getOwnedThen()) && isConstant(ifExp.getOwnedElse());
	}

	@Override
	public @NonNull Boolean visitLetExp(@NonNull LetExp letExp) {
		return isConstant(letExp.getOwnedVariable()) && isConstant(letExp.getOwnedIn());
	}

	@Override
	public @NonNull Boolean visitLoopExp(@NonNull LoopExp loopExp) {
		if (!isConstant(loopExp.getOwnedSource())) {
			return false;
		}
		if (myConstants == null) {
			if (knownConstants != null) {
				myConstants = new HashSet<Object>(knownConstants);
			}
			else {
				myConstants = new HashSet<Object>();
			}
		}
		List<Variable> ownedIterators = loopExp.getOwnedIterators();
		myConstants.addAll(ownedIterators);
		return isConstant(ownedIterators) && isConstant(loopExp.getOwnedBody());
	}

	@Override
	public @NonNull Boolean visitMapLiteralExp(@NonNull MapLiteralExp mapLiteralExp) {
		return isConstant(mapLiteralExp.getOwnedParts());
	}

	@Override
	public @NonNull Boolean visitMapLiteralPart(@NonNull MapLiteralPart mapLiteralPart) {
		return isConstant(mapLiteralPart.getOwnedKey()) && isConstant(mapLiteralPart.getOwnedValue());
	}

	@Override
	public @NonNull Boolean visitNavigationCallExp(@NonNull NavigationCallExp navigationCallExp) {
		return isConstant(navigationCallExp.getOwnedSource());
	}

	@Override
	public @NonNull Boolean visitOperationCallExp(@NonNull OperationCallExp operationCallExp) {
		return isConstant(operationCallExp.getOwnedSource()) && isConstant(operationCallExp.getOwnedArguments());
	}

	@Override
	public @NonNull Boolean visitPrimitiveLiteralExp(@NonNull PrimitiveLiteralExp object) {
		return true;
	}

	@Override
	public @NonNull Boolean visitShadowExp(@NonNull ShadowExp shadowExp) {
		return isConstant(shadowExp.getOwnedParts());
	}

	@Override
	public @NonNull Boolean visitShadowPart(@NonNull ShadowPart shadowPart) {
		return isConstant(shadowPart.getOwnedInit());
	}

	@Override
	public @NonNull Boolean visitTupleLiteralExp(@NonNull TupleLiteralExp tupleLiteralExp) {
		return isConstant(tupleLiteralExp.getOwnedParts());
	}

	@Override
	public @NonNull Boolean visitTupleLiteralPart(@NonNull TupleLiteralPart tupleLiteralPart) {
		return isConstant(tupleLiteralPart.getOwnedInit());
	}

	@Override
	public @NonNull Boolean visitTypeExp(@NonNull TypeExp typeExp) {
		return true;
	}

	@Override
	public @NonNull Boolean visitVariable(@NonNull Variable variable) {
		if (isConstant(variable.getOwnedInit())) {
			return true;
		}
		if (myConstants != null) {
			return myConstants.contains(variable);
		}
		if (knownConstants != null) {
			return knownConstants.contains(variable);
		}
		return false;
	}

	@Override
	public @NonNull Boolean visitVariableExp(@NonNull VariableExp variableExp) {
		return isConstant(variableExp.getReferredVariable());
	}
}