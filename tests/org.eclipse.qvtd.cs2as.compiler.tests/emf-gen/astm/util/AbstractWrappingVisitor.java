/*******************************************************************************
 * Copyright (c)  2016 Willink Transformations, Univesity of York and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *      Adolfo Sanchez-Barbudo Herrera - initial API and implementation
 *
 * This code is auto-generated
 * from: org.eclipse.qvtd.cs2as.compiler.tests/src/org/eclipse/qvtd/cs2as/compiler/tests/models/delphi/astm.genmodel
 *
 * Only the copyright statement is editable.
 *******************************************************************************/
package	astm.util;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * An AbstractWrappingVisitor delegates all visits wrapping the delegation in a call to a preVisit function and a postVisit function.
 */
public abstract class AbstractWrappingVisitor<R, C, @NonNull D extends Visitor<R>, P>
	extends AbstractVisitor<R, C>
	implements Visitor<R>
{
	protected final @NonNull D delegate;

	protected AbstractWrappingVisitor(@NonNull D delegate, C context) {
		super(context);
		this.delegate = delegate;
	//	delegate.setUndecoratedVisitor(this);
	}

	/**
	 * Intercept an exception thrown by the delegated visit to perform some post-functionality that may use the visitable object,
	 * the result of preVisit and the thrown exception to determine the overall wrapped result.
	 *
	 * @return a rethrown RuntimeException or a RuntimeException-wrapped non-RuntimeException.
	 */
	protected R badVisit(astm.util.@NonNull Visitable visitable, @Nullable P prologue, @NonNull Throwable e) throws RuntimeException {
		if (e instanceof Exception) {
			throw (RuntimeException)e;
		}
		else {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Obtains the visitor that I wrap.
	 *
	 * @return my wrapped visitor
	 */
	protected @NonNull D getDelegate() {
		return delegate;
	}

	/**
	 * Intercept the result of the delegated visit to perform some post-functionality that may use the visitable object,
	 * the result of preVisit and the result of the delegated visit to determine the overall wrapped result.
	 *
	 * @return the epilogue result, which defaults to the delegated result.
	 */
	protected R postVisit(astm.util.@NonNull Visitable visitable, @Nullable P prologue, R result) {
		return result;
	}

	/**
	 * Compute and return some value before performing the delegated visit.
	 *
	 * @return the prologue result, which defauilts to null.
	 */
	protected @Nullable P preVisit(astm.util.@NonNull Visitable visitable) {
		return null;
	}

	@Override
	public R visiting(astm.util.@NonNull Visitable visitable) {
		throw new UnsupportedOperationException();		// Cannot happen since all methods delegate.
	}

	@Override
	public R visitAccessKind(astm.@NonNull AccessKind object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitAccessKind(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitActualParameter(astm.@NonNull ActualParameter object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitActualParameter(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitActualParameterExpression(astm.@NonNull ActualParameterExpression object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitActualParameterExpression(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitAdd(astm.@NonNull Add object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitAdd(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitAddressOf(astm.@NonNull AddressOf object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitAddressOf(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitAggregateExpression(astm.@NonNull AggregateExpression object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitAggregateExpression(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitAggregateScope(astm.@NonNull AggregateScope object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitAggregateScope(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitAggregateType(astm.@NonNull AggregateType object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitAggregateType(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitAggregateTypeDefinition(astm.@NonNull AggregateTypeDefinition object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitAggregateTypeDefinition(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitAnd(astm.@NonNull And object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitAnd(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitAnnotationExpression(astm.@NonNull AnnotationExpression object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitAnnotationExpression(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitAnnotationType(astm.@NonNull AnnotationType object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitAnnotationType(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitArrayAccess(astm.@NonNull ArrayAccess object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitArrayAccess(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitArrayType(astm.@NonNull ArrayType object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitArrayType(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitAssign(astm.@NonNull Assign object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitAssign(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitBinaryExpression(astm.@NonNull BinaryExpression object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitBinaryExpression(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitBinaryOperator(astm.@NonNull BinaryOperator object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitBinaryOperator(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitBitAnd(astm.@NonNull BitAnd object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitBitAnd(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitBitFieldDefinition(astm.@NonNull BitFieldDefinition object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitBitFieldDefinition(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitBitLeftShift(astm.@NonNull BitLeftShift object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitBitLeftShift(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitBitLiteral(astm.@NonNull BitLiteral object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitBitLiteral(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitBitNot(astm.@NonNull BitNot object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitBitNot(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitBitOr(astm.@NonNull BitOr object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitBitOr(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitBitRightShift(astm.@NonNull BitRightShift object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitBitRightShift(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitBitXor(astm.@NonNull BitXor object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitBitXor(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitBlockScope(astm.@NonNull BlockScope object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitBlockScope(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitBlockStatement(astm.@NonNull BlockStatement object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitBlockStatement(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitBoolean(astm.@NonNull Boolean object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitBoolean(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitBooleanLiteral(astm.@NonNull BooleanLiteral object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitBooleanLiteral(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitBreakStatement(astm.@NonNull BreakStatement object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitBreakStatement(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitByReferenceActualParameterExpression(astm.@NonNull ByReferenceActualParameterExpression object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitByReferenceActualParameterExpression(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitByReferenceFormalParameterType(astm.@NonNull ByReferenceFormalParameterType object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitByReferenceFormalParameterType(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitByValueActualParameterExpression(astm.@NonNull ByValueActualParameterExpression object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitByValueActualParameterExpression(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitByValueFormalParameterType(astm.@NonNull ByValueFormalParameterType object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitByValueFormalParameterType(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitByte(astm.@NonNull Byte object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitByte(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitCaseBlock(astm.@NonNull CaseBlock object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitCaseBlock(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitCastExpression(astm.@NonNull CastExpression object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitCastExpression(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitCatchBlock(astm.@NonNull CatchBlock object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitCatchBlock(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitCharLiteral(astm.@NonNull CharLiteral object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitCharLiteral(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitCharacter(astm.@NonNull Character object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitCharacter(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitClassType(astm.@NonNull ClassType object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitClassType(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitCollectionType(astm.@NonNull CollectionType object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitCollectionType(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitComment(astm.@NonNull Comment object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitComment(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitCompilationUnit(astm.@NonNull CompilationUnit object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitCompilationUnit(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitConditionalExpression(astm.@NonNull ConditionalExpression object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitConditionalExpression(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitConstructedType(astm.@NonNull ConstructedType object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitConstructedType(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitContinueStatement(astm.@NonNull ContinueStatement object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitContinueStatement(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitDataDefinition(astm.@NonNull DataDefinition object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitDataDefinition(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitDataType(astm.@NonNull DataType object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitDataType(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitDeclaration(astm.@NonNull Declaration object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitDeclaration(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitDeclarationOrDefinition(astm.@NonNull DeclarationOrDefinition object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitDeclarationOrDefinition(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitDeclarationOrDefinitionStatement(astm.@NonNull DeclarationOrDefinitionStatement object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitDeclarationOrDefinitionStatement(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitDecrement(astm.@NonNull Decrement object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitDecrement(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitDefaultBlock(astm.@NonNull DefaultBlock object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitDefaultBlock(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitDefinition(astm.@NonNull Definition object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitDefinition(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitDefinitionObject(astm.@NonNull DefinitionObject object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitDefinitionObject(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitDeleteStatement(astm.@NonNull DeleteStatement object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitDeleteStatement(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitDelphiBlockStatement(astm.@NonNull DelphiBlockStatement object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitDelphiBlockStatement(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitDelphiFunctionCallExpression(astm.@NonNull DelphiFunctionCallExpression object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitDelphiFunctionCallExpression(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitDelphiImplementationSection(astm.@NonNull DelphiImplementationSection object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitDelphiImplementationSection(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitDelphiInterfaceSection(astm.@NonNull DelphiInterfaceSection object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitDelphiInterfaceSection(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitDelphiUnit(astm.@NonNull DelphiUnit object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitDelphiUnit(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitDelphiWithStatement(astm.@NonNull DelphiWithStatement object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitDelphiWithStatement(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitDeref(astm.@NonNull Deref object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitDeref(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitDerivesFrom(astm.@NonNull DerivesFrom object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitDerivesFrom(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitDimension(astm.@NonNull Dimension object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitDimension(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitDivide(astm.@NonNull Divide object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitDivide(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitDoWhileStatement(astm.@NonNull DoWhileStatement object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitDoWhileStatement(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitDouble(astm.@NonNull Double object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitDouble(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitEmptyStatement(astm.@NonNull EmptyStatement object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitEmptyStatement(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitEntryDefinition(astm.@NonNull EntryDefinition object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitEntryDefinition(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitEnumLiteralDefinition(astm.@NonNull EnumLiteralDefinition object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitEnumLiteralDefinition(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitEnumType(astm.@NonNull EnumType object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitEnumType(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitEqual(astm.@NonNull Equal object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitEqual(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitExceptionType(astm.@NonNull ExceptionType object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitExceptionType(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitExponent(astm.@NonNull Exponent object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitExponent(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitExpression(astm.@NonNull Expression object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitExpression(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitExpressionStatement(astm.@NonNull ExpressionStatement object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitExpressionStatement(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitExternal(astm.@NonNull External object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitExternal(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitFileLocal(astm.@NonNull FileLocal object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitFileLocal(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitFloat(astm.@NonNull Float object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitFloat(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitForCheckAfterStatement(astm.@NonNull ForCheckAfterStatement object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitForCheckAfterStatement(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitForCheckBeforeStatement(astm.@NonNull ForCheckBeforeStatement object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitForCheckBeforeStatement(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitForStatement(astm.@NonNull ForStatement object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitForStatement(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitFormalParameterDeclaration(astm.@NonNull FormalParameterDeclaration object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitFormalParameterDeclaration(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitFormalParameterDefinition(astm.@NonNull FormalParameterDefinition object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitFormalParameterDefinition(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitFormalParameterType(astm.@NonNull FormalParameterType object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitFormalParameterType(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitFunctionCallExpression(astm.@NonNull FunctionCallExpression object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitFunctionCallExpression(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitFunctionDeclaration(astm.@NonNull FunctionDeclaration object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitFunctionDeclaration(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitFunctionDefinition(astm.@NonNull FunctionDefinition object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitFunctionDefinition(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitFunctionMemberAttribute(astm.@NonNull FunctionMemberAttribute object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitFunctionMemberAttribute(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitFunctionMemberAttributes(astm.@NonNull FunctionMemberAttributes object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitFunctionMemberAttributes(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitFunctionPersistent(astm.@NonNull FunctionPersistent object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitFunctionPersistent(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitFunctionScope(astm.@NonNull FunctionScope object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitFunctionScope(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitFunctionType(astm.@NonNull FunctionType object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitFunctionType(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitGASTMObject(astm.@NonNull GASTMObject object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitGASTMObject(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitGASTMSemanticObject(astm.@NonNull GASTMSemanticObject object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitGASTMSemanticObject(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitGASTMSourceObject(astm.@NonNull GASTMSourceObject object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitGASTMSourceObject(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitGASTMSyntaxObject(astm.@NonNull GASTMSyntaxObject object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitGASTMSyntaxObject(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitGlobalScope(astm.@NonNull GlobalScope object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitGlobalScope(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitGreater(astm.@NonNull Greater object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitGreater(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitIdentifierReference(astm.@NonNull IdentifierReference object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitIdentifierReference(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitIfStatement(astm.@NonNull IfStatement object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitIfStatement(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitIncludeUnit(astm.@NonNull IncludeUnit object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitIncludeUnit(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitIncrement(astm.@NonNull Increment object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitIncrement(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitInteger(astm.@NonNull Integer object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitInteger(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitIntegerLiteral(astm.@NonNull IntegerLiteral object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitIntegerLiteral(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitJumpStatement(astm.@NonNull JumpStatement object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitJumpStatement(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitLabelAccess(astm.@NonNull LabelAccess object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitLabelAccess(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitLabelDefinition(astm.@NonNull LabelDefinition object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitLabelDefinition(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitLabelType(astm.@NonNull LabelType object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitLabelType(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitLabeledStatement(astm.@NonNull LabeledStatement object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitLabeledStatement(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitLess(astm.@NonNull Less object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitLess(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitLiteral(astm.@NonNull Literal object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitLiteral(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitLongDouble(astm.@NonNull LongDouble object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitLongDouble(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitLongInteger(astm.@NonNull LongInteger object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitLongInteger(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitLoopStatement(astm.@NonNull LoopStatement object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitLoopStatement(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitMacroCall(astm.@NonNull MacroCall object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitMacroCall(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitMacroDefinition(astm.@NonNull MacroDefinition object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitMacroDefinition(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitMissingActualParameter(astm.@NonNull MissingActualParameter object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitMissingActualParameter(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitModulus(astm.@NonNull Modulus object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitModulus(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitMultiply(astm.@NonNull Multiply object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitMultiply(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitName(astm.@NonNull Name object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitName(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitNameReference(astm.@NonNull NameReference object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitNameReference(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitNameSpaceDefinition(astm.@NonNull NameSpaceDefinition object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitNameSpaceDefinition(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitNameSpaceType(astm.@NonNull NameSpaceType object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitNameSpaceType(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitNamedType(astm.@NonNull NamedType object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitNamedType(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitNamedTypeDefinition(astm.@NonNull NamedTypeDefinition object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitNamedTypeDefinition(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitNamedTypeReference(astm.@NonNull NamedTypeReference object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitNamedTypeReference(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitNegate(astm.@NonNull Negate object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitNegate(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitNewExpression(astm.@NonNull NewExpression object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitNewExpression(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitNoDef(astm.@NonNull NoDef object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitNoDef(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitNonVirtual(astm.@NonNull NonVirtual object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitNonVirtual(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitNot(astm.@NonNull Not object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitNot(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitNotEqual(astm.@NonNull NotEqual object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitNotEqual(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitNotGreater(astm.@NonNull NotGreater object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitNotGreater(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitNotLess(astm.@NonNull NotLess object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitNotLess(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitOperator(astm.@NonNull Operator object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitOperator(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitOperatorAssign(astm.@NonNull OperatorAssign object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitOperatorAssign(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitOr(astm.@NonNull Or object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitOr(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitOtherSyntaxObject(astm.@NonNull OtherSyntaxObject object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitOtherSyntaxObject(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitPerClassMember(astm.@NonNull PerClassMember object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitPerClassMember(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitPointerType(astm.@NonNull PointerType object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitPointerType(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitPostDecrement(astm.@NonNull PostDecrement object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitPostDecrement(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitPostIncrement(astm.@NonNull PostIncrement object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitPostIncrement(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitPreprocessorElement(astm.@NonNull PreprocessorElement object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitPreprocessorElement(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitPrimitiveType(astm.@NonNull PrimitiveType object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitPrimitiveType(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitPrivate(astm.@NonNull Private object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitPrivate(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitProgramScope(astm.@NonNull ProgramScope object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitProgramScope(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitProject(astm.@NonNull Project object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitProject(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitProtected(astm.@NonNull Protected object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitProtected(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitPublic(astm.@NonNull Public object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitPublic(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitPureVirtual(astm.@NonNull PureVirtual object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitPureVirtual(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitQualifiedIdentifierReference(astm.@NonNull QualifiedIdentifierReference object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitQualifiedIdentifierReference(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitQualifiedOverData(astm.@NonNull QualifiedOverData object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitQualifiedOverData(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitQualifiedOverPointer(astm.@NonNull QualifiedOverPointer object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitQualifiedOverPointer(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitRangeExpression(astm.@NonNull RangeExpression object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitRangeExpression(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitRangeType(astm.@NonNull RangeType object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitRangeType(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitRealLiteral(astm.@NonNull RealLiteral object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitRealLiteral(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitReferenceType(astm.@NonNull ReferenceType object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitReferenceType(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitReturnStatement(astm.@NonNull ReturnStatement object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitReturnStatement(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitScope(astm.@NonNull Scope object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitScope(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitShortInteger(astm.@NonNull ShortInteger object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitShortInteger(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitSourceFile(astm.@NonNull SourceFile object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitSourceFile(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitSourceLocation(astm.@NonNull SourceLocation object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitSourceLocation(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitSpecificConcatString(astm.@NonNull SpecificConcatString object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitSpecificConcatString(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitSpecificGreaterEqual(astm.@NonNull SpecificGreaterEqual object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitSpecificGreaterEqual(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitSpecificIn(astm.@NonNull SpecificIn object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitSpecificIn(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitSpecificLessEqual(astm.@NonNull SpecificLessEqual object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitSpecificLessEqual(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitSpecificLike(astm.@NonNull SpecificLike object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitSpecificLike(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitSpecificSelectStatement(astm.@NonNull SpecificSelectStatement object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitSpecificSelectStatement(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitSpecificTriggerDefinition(astm.@NonNull SpecificTriggerDefinition object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitSpecificTriggerDefinition(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitStatement(astm.@NonNull Statement object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitStatement(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitStorageSpecification(astm.@NonNull StorageSpecification object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitStorageSpecification(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitString(astm.@NonNull String object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitString(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitStringLiteral(astm.@NonNull StringLiteral object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitStringLiteral(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitStructureType(astm.@NonNull StructureType object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitStructureType(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitSubtract(astm.@NonNull Subtract object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitSubtract(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitSwitchCase(astm.@NonNull SwitchCase object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitSwitchCase(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitSwitchStatement(astm.@NonNull SwitchStatement object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitSwitchStatement(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitTerminateStatement(astm.@NonNull TerminateStatement object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitTerminateStatement(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitThrowStatement(astm.@NonNull ThrowStatement object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitThrowStatement(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitTryStatement(astm.@NonNull TryStatement object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitTryStatement(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitType(astm.@NonNull Type object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitType(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitTypeDefinition(astm.@NonNull TypeDefinition object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitTypeDefinition(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitTypeQualifiedIdentifierReference(astm.@NonNull TypeQualifiedIdentifierReference object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitTypeQualifiedIdentifierReference(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitTypeReference(astm.@NonNull TypeReference object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitTypeReference(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitTypesCatchBlock(astm.@NonNull TypesCatchBlock object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitTypesCatchBlock(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitUnaryExpression(astm.@NonNull UnaryExpression object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitUnaryExpression(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitUnaryOperator(astm.@NonNull UnaryOperator object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitUnaryOperator(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitUnaryPlus(astm.@NonNull UnaryPlus object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitUnaryPlus(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitUnionType(astm.@NonNull UnionType object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitUnionType(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitUnnamedTypeReference(astm.@NonNull UnnamedTypeReference object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitUnnamedTypeReference(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitVariableCatchBlock(astm.@NonNull VariableCatchBlock object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitVariableCatchBlock(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitVariableDeclaration(astm.@NonNull VariableDeclaration object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitVariableDeclaration(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitVariableDefinition(astm.@NonNull VariableDefinition object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitVariableDefinition(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitVirtual(astm.@NonNull Virtual object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitVirtual(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitVirtualSpecification(astm.@NonNull VirtualSpecification object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitVirtualSpecification(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitVoid(astm.@NonNull Void object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitVoid(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitWhileStatement(astm.@NonNull WhileStatement object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitWhileStatement(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitWideCharacter(astm.@NonNull WideCharacter object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitWideCharacter(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}
}
