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

/**
 * An AbstractDelegatingVisitor delegates all visits.
 */
public abstract class AbstractDelegatingVisitor<R, C, @NonNull D extends Visitor<R>>
	extends AbstractVisitor<R, C>
	implements Visitor<R>
{
	protected final @NonNull D delegate;

	protected AbstractDelegatingVisitor(@NonNull D delegate, C context) {
		super(context);
	//	assert delegate != null : "cannot decorate a null visitor"; //$NON-NLS-1$
		this.delegate = delegate;
	//	delegate.setUndecoratedVisitor(this);
	}

	/**
	 * Delegates to my decorated visitor.
	 */
	//	public @NonNull DecorableVisitor<R> createNestedVisitor() {
	//		return delegate.createNestedVisitor();
	//	}

	/**
	 * Obtains the visitor that I decorate.
	 *
	 * @return my decorated visitor
	 */
	protected final @NonNull D getDelegate() {
		return delegate;
	}

	@Override
	public R visiting(astm.util.@NonNull Visitable visitable) {
		return delegate.visiting(visitable);
	}

	@Override
	public R visitAccessKind(astm.@NonNull AccessKind object) {
		return delegate.visitAccessKind(object);
	}

	@Override
	public R visitActualParameter(astm.@NonNull ActualParameter object) {
		return delegate.visitActualParameter(object);
	}

	@Override
	public R visitActualParameterExpression(astm.@NonNull ActualParameterExpression object) {
		return delegate.visitActualParameterExpression(object);
	}

	@Override
	public R visitAdd(astm.@NonNull Add object) {
		return delegate.visitAdd(object);
	}

	@Override
	public R visitAddressOf(astm.@NonNull AddressOf object) {
		return delegate.visitAddressOf(object);
	}

	@Override
	public R visitAggregateExpression(astm.@NonNull AggregateExpression object) {
		return delegate.visitAggregateExpression(object);
	}

	@Override
	public R visitAggregateScope(astm.@NonNull AggregateScope object) {
		return delegate.visitAggregateScope(object);
	}

	@Override
	public R visitAggregateType(astm.@NonNull AggregateType object) {
		return delegate.visitAggregateType(object);
	}

	@Override
	public R visitAggregateTypeDefinition(astm.@NonNull AggregateTypeDefinition object) {
		return delegate.visitAggregateTypeDefinition(object);
	}

	@Override
	public R visitAnd(astm.@NonNull And object) {
		return delegate.visitAnd(object);
	}

	@Override
	public R visitAnnotationExpression(astm.@NonNull AnnotationExpression object) {
		return delegate.visitAnnotationExpression(object);
	}

	@Override
	public R visitAnnotationType(astm.@NonNull AnnotationType object) {
		return delegate.visitAnnotationType(object);
	}

	@Override
	public R visitArrayAccess(astm.@NonNull ArrayAccess object) {
		return delegate.visitArrayAccess(object);
	}

	@Override
	public R visitArrayType(astm.@NonNull ArrayType object) {
		return delegate.visitArrayType(object);
	}

	@Override
	public R visitAssign(astm.@NonNull Assign object) {
		return delegate.visitAssign(object);
	}

	@Override
	public R visitBinaryExpression(astm.@NonNull BinaryExpression object) {
		return delegate.visitBinaryExpression(object);
	}

	@Override
	public R visitBinaryOperator(astm.@NonNull BinaryOperator object) {
		return delegate.visitBinaryOperator(object);
	}

	@Override
	public R visitBitAnd(astm.@NonNull BitAnd object) {
		return delegate.visitBitAnd(object);
	}

	@Override
	public R visitBitFieldDefinition(astm.@NonNull BitFieldDefinition object) {
		return delegate.visitBitFieldDefinition(object);
	}

	@Override
	public R visitBitLeftShift(astm.@NonNull BitLeftShift object) {
		return delegate.visitBitLeftShift(object);
	}

	@Override
	public R visitBitLiteral(astm.@NonNull BitLiteral object) {
		return delegate.visitBitLiteral(object);
	}

	@Override
	public R visitBitNot(astm.@NonNull BitNot object) {
		return delegate.visitBitNot(object);
	}

	@Override
	public R visitBitOr(astm.@NonNull BitOr object) {
		return delegate.visitBitOr(object);
	}

	@Override
	public R visitBitRightShift(astm.@NonNull BitRightShift object) {
		return delegate.visitBitRightShift(object);
	}

	@Override
	public R visitBitXor(astm.@NonNull BitXor object) {
		return delegate.visitBitXor(object);
	}

	@Override
	public R visitBlockScope(astm.@NonNull BlockScope object) {
		return delegate.visitBlockScope(object);
	}

	@Override
	public R visitBlockStatement(astm.@NonNull BlockStatement object) {
		return delegate.visitBlockStatement(object);
	}

	@Override
	public R visitBoolean(astm.@NonNull Boolean object) {
		return delegate.visitBoolean(object);
	}

	@Override
	public R visitBooleanLiteral(astm.@NonNull BooleanLiteral object) {
		return delegate.visitBooleanLiteral(object);
	}

	@Override
	public R visitBreakStatement(astm.@NonNull BreakStatement object) {
		return delegate.visitBreakStatement(object);
	}

	@Override
	public R visitByReferenceActualParameterExpression(astm.@NonNull ByReferenceActualParameterExpression object) {
		return delegate.visitByReferenceActualParameterExpression(object);
	}

	@Override
	public R visitByReferenceFormalParameterType(astm.@NonNull ByReferenceFormalParameterType object) {
		return delegate.visitByReferenceFormalParameterType(object);
	}

	@Override
	public R visitByValueActualParameterExpression(astm.@NonNull ByValueActualParameterExpression object) {
		return delegate.visitByValueActualParameterExpression(object);
	}

	@Override
	public R visitByValueFormalParameterType(astm.@NonNull ByValueFormalParameterType object) {
		return delegate.visitByValueFormalParameterType(object);
	}

	@Override
	public R visitByte(astm.@NonNull Byte object) {
		return delegate.visitByte(object);
	}

	@Override
	public R visitCaseBlock(astm.@NonNull CaseBlock object) {
		return delegate.visitCaseBlock(object);
	}

	@Override
	public R visitCastExpression(astm.@NonNull CastExpression object) {
		return delegate.visitCastExpression(object);
	}

	@Override
	public R visitCatchBlock(astm.@NonNull CatchBlock object) {
		return delegate.visitCatchBlock(object);
	}

	@Override
	public R visitCharLiteral(astm.@NonNull CharLiteral object) {
		return delegate.visitCharLiteral(object);
	}

	@Override
	public R visitCharacter(astm.@NonNull Character object) {
		return delegate.visitCharacter(object);
	}

	@Override
	public R visitClassType(astm.@NonNull ClassType object) {
		return delegate.visitClassType(object);
	}

	@Override
	public R visitCollectionType(astm.@NonNull CollectionType object) {
		return delegate.visitCollectionType(object);
	}

	@Override
	public R visitComment(astm.@NonNull Comment object) {
		return delegate.visitComment(object);
	}

	@Override
	public R visitCompilationUnit(astm.@NonNull CompilationUnit object) {
		return delegate.visitCompilationUnit(object);
	}

	@Override
	public R visitConditionalExpression(astm.@NonNull ConditionalExpression object) {
		return delegate.visitConditionalExpression(object);
	}

	@Override
	public R visitConstructedType(astm.@NonNull ConstructedType object) {
		return delegate.visitConstructedType(object);
	}

	@Override
	public R visitContinueStatement(astm.@NonNull ContinueStatement object) {
		return delegate.visitContinueStatement(object);
	}

	@Override
	public R visitDataDefinition(astm.@NonNull DataDefinition object) {
		return delegate.visitDataDefinition(object);
	}

	@Override
	public R visitDataType(astm.@NonNull DataType object) {
		return delegate.visitDataType(object);
	}

	@Override
	public R visitDeclaration(astm.@NonNull Declaration object) {
		return delegate.visitDeclaration(object);
	}

	@Override
	public R visitDeclarationOrDefinition(astm.@NonNull DeclarationOrDefinition object) {
		return delegate.visitDeclarationOrDefinition(object);
	}

	@Override
	public R visitDeclarationOrDefinitionStatement(astm.@NonNull DeclarationOrDefinitionStatement object) {
		return delegate.visitDeclarationOrDefinitionStatement(object);
	}

	@Override
	public R visitDecrement(astm.@NonNull Decrement object) {
		return delegate.visitDecrement(object);
	}

	@Override
	public R visitDefaultBlock(astm.@NonNull DefaultBlock object) {
		return delegate.visitDefaultBlock(object);
	}

	@Override
	public R visitDefinition(astm.@NonNull Definition object) {
		return delegate.visitDefinition(object);
	}

	@Override
	public R visitDefinitionObject(astm.@NonNull DefinitionObject object) {
		return delegate.visitDefinitionObject(object);
	}

	@Override
	public R visitDeleteStatement(astm.@NonNull DeleteStatement object) {
		return delegate.visitDeleteStatement(object);
	}

	@Override
	public R visitDelphiBlockStatement(astm.@NonNull DelphiBlockStatement object) {
		return delegate.visitDelphiBlockStatement(object);
	}

	@Override
	public R visitDelphiFunctionCallExpression(astm.@NonNull DelphiFunctionCallExpression object) {
		return delegate.visitDelphiFunctionCallExpression(object);
	}

	@Override
	public R visitDelphiImplementationSection(astm.@NonNull DelphiImplementationSection object) {
		return delegate.visitDelphiImplementationSection(object);
	}

	@Override
	public R visitDelphiInterfaceSection(astm.@NonNull DelphiInterfaceSection object) {
		return delegate.visitDelphiInterfaceSection(object);
	}

	@Override
	public R visitDelphiUnit(astm.@NonNull DelphiUnit object) {
		return delegate.visitDelphiUnit(object);
	}

	@Override
	public R visitDelphiWithStatement(astm.@NonNull DelphiWithStatement object) {
		return delegate.visitDelphiWithStatement(object);
	}

	@Override
	public R visitDeref(astm.@NonNull Deref object) {
		return delegate.visitDeref(object);
	}

	@Override
	public R visitDerivesFrom(astm.@NonNull DerivesFrom object) {
		return delegate.visitDerivesFrom(object);
	}

	@Override
	public R visitDimension(astm.@NonNull Dimension object) {
		return delegate.visitDimension(object);
	}

	@Override
	public R visitDivide(astm.@NonNull Divide object) {
		return delegate.visitDivide(object);
	}

	@Override
	public R visitDoWhileStatement(astm.@NonNull DoWhileStatement object) {
		return delegate.visitDoWhileStatement(object);
	}

	@Override
	public R visitDouble(astm.@NonNull Double object) {
		return delegate.visitDouble(object);
	}

	@Override
	public R visitEmptyStatement(astm.@NonNull EmptyStatement object) {
		return delegate.visitEmptyStatement(object);
	}

	@Override
	public R visitEntryDefinition(astm.@NonNull EntryDefinition object) {
		return delegate.visitEntryDefinition(object);
	}

	@Override
	public R visitEnumLiteralDefinition(astm.@NonNull EnumLiteralDefinition object) {
		return delegate.visitEnumLiteralDefinition(object);
	}

	@Override
	public R visitEnumType(astm.@NonNull EnumType object) {
		return delegate.visitEnumType(object);
	}

	@Override
	public R visitEqual(astm.@NonNull Equal object) {
		return delegate.visitEqual(object);
	}

	@Override
	public R visitExceptionType(astm.@NonNull ExceptionType object) {
		return delegate.visitExceptionType(object);
	}

	@Override
	public R visitExponent(astm.@NonNull Exponent object) {
		return delegate.visitExponent(object);
	}

	@Override
	public R visitExpression(astm.@NonNull Expression object) {
		return delegate.visitExpression(object);
	}

	@Override
	public R visitExpressionStatement(astm.@NonNull ExpressionStatement object) {
		return delegate.visitExpressionStatement(object);
	}

	@Override
	public R visitExternal(astm.@NonNull External object) {
		return delegate.visitExternal(object);
	}

	@Override
	public R visitFileLocal(astm.@NonNull FileLocal object) {
		return delegate.visitFileLocal(object);
	}

	@Override
	public R visitFloat(astm.@NonNull Float object) {
		return delegate.visitFloat(object);
	}

	@Override
	public R visitForCheckAfterStatement(astm.@NonNull ForCheckAfterStatement object) {
		return delegate.visitForCheckAfterStatement(object);
	}

	@Override
	public R visitForCheckBeforeStatement(astm.@NonNull ForCheckBeforeStatement object) {
		return delegate.visitForCheckBeforeStatement(object);
	}

	@Override
	public R visitForStatement(astm.@NonNull ForStatement object) {
		return delegate.visitForStatement(object);
	}

	@Override
	public R visitFormalParameterDeclaration(astm.@NonNull FormalParameterDeclaration object) {
		return delegate.visitFormalParameterDeclaration(object);
	}

	@Override
	public R visitFormalParameterDefinition(astm.@NonNull FormalParameterDefinition object) {
		return delegate.visitFormalParameterDefinition(object);
	}

	@Override
	public R visitFormalParameterType(astm.@NonNull FormalParameterType object) {
		return delegate.visitFormalParameterType(object);
	}

	@Override
	public R visitFunctionCallExpression(astm.@NonNull FunctionCallExpression object) {
		return delegate.visitFunctionCallExpression(object);
	}

	@Override
	public R visitFunctionDeclaration(astm.@NonNull FunctionDeclaration object) {
		return delegate.visitFunctionDeclaration(object);
	}

	@Override
	public R visitFunctionDefinition(astm.@NonNull FunctionDefinition object) {
		return delegate.visitFunctionDefinition(object);
	}

	@Override
	public R visitFunctionMemberAttribute(astm.@NonNull FunctionMemberAttribute object) {
		return delegate.visitFunctionMemberAttribute(object);
	}

	@Override
	public R visitFunctionMemberAttributes(astm.@NonNull FunctionMemberAttributes object) {
		return delegate.visitFunctionMemberAttributes(object);
	}

	@Override
	public R visitFunctionPersistent(astm.@NonNull FunctionPersistent object) {
		return delegate.visitFunctionPersistent(object);
	}

	@Override
	public R visitFunctionScope(astm.@NonNull FunctionScope object) {
		return delegate.visitFunctionScope(object);
	}

	@Override
	public R visitFunctionType(astm.@NonNull FunctionType object) {
		return delegate.visitFunctionType(object);
	}

	@Override
	public R visitGASTMObject(astm.@NonNull GASTMObject object) {
		return delegate.visitGASTMObject(object);
	}

	@Override
	public R visitGASTMSemanticObject(astm.@NonNull GASTMSemanticObject object) {
		return delegate.visitGASTMSemanticObject(object);
	}

	@Override
	public R visitGASTMSourceObject(astm.@NonNull GASTMSourceObject object) {
		return delegate.visitGASTMSourceObject(object);
	}

	@Override
	public R visitGASTMSyntaxObject(astm.@NonNull GASTMSyntaxObject object) {
		return delegate.visitGASTMSyntaxObject(object);
	}

	@Override
	public R visitGlobalScope(astm.@NonNull GlobalScope object) {
		return delegate.visitGlobalScope(object);
	}

	@Override
	public R visitGreater(astm.@NonNull Greater object) {
		return delegate.visitGreater(object);
	}

	@Override
	public R visitIdentifierReference(astm.@NonNull IdentifierReference object) {
		return delegate.visitIdentifierReference(object);
	}

	@Override
	public R visitIfStatement(astm.@NonNull IfStatement object) {
		return delegate.visitIfStatement(object);
	}

	@Override
	public R visitIncludeUnit(astm.@NonNull IncludeUnit object) {
		return delegate.visitIncludeUnit(object);
	}

	@Override
	public R visitIncrement(astm.@NonNull Increment object) {
		return delegate.visitIncrement(object);
	}

	@Override
	public R visitInteger(astm.@NonNull Integer object) {
		return delegate.visitInteger(object);
	}

	@Override
	public R visitIntegerLiteral(astm.@NonNull IntegerLiteral object) {
		return delegate.visitIntegerLiteral(object);
	}

	@Override
	public R visitJumpStatement(astm.@NonNull JumpStatement object) {
		return delegate.visitJumpStatement(object);
	}

	@Override
	public R visitLabelAccess(astm.@NonNull LabelAccess object) {
		return delegate.visitLabelAccess(object);
	}

	@Override
	public R visitLabelDefinition(astm.@NonNull LabelDefinition object) {
		return delegate.visitLabelDefinition(object);
	}

	@Override
	public R visitLabelType(astm.@NonNull LabelType object) {
		return delegate.visitLabelType(object);
	}

	@Override
	public R visitLabeledStatement(astm.@NonNull LabeledStatement object) {
		return delegate.visitLabeledStatement(object);
	}

	@Override
	public R visitLess(astm.@NonNull Less object) {
		return delegate.visitLess(object);
	}

	@Override
	public R visitLiteral(astm.@NonNull Literal object) {
		return delegate.visitLiteral(object);
	}

	@Override
	public R visitLongDouble(astm.@NonNull LongDouble object) {
		return delegate.visitLongDouble(object);
	}

	@Override
	public R visitLongInteger(astm.@NonNull LongInteger object) {
		return delegate.visitLongInteger(object);
	}

	@Override
	public R visitLoopStatement(astm.@NonNull LoopStatement object) {
		return delegate.visitLoopStatement(object);
	}

	@Override
	public R visitMacroCall(astm.@NonNull MacroCall object) {
		return delegate.visitMacroCall(object);
	}

	@Override
	public R visitMacroDefinition(astm.@NonNull MacroDefinition object) {
		return delegate.visitMacroDefinition(object);
	}

	@Override
	public R visitMissingActualParameter(astm.@NonNull MissingActualParameter object) {
		return delegate.visitMissingActualParameter(object);
	}

	@Override
	public R visitModulus(astm.@NonNull Modulus object) {
		return delegate.visitModulus(object);
	}

	@Override
	public R visitMultiply(astm.@NonNull Multiply object) {
		return delegate.visitMultiply(object);
	}

	@Override
	public R visitName(astm.@NonNull Name object) {
		return delegate.visitName(object);
	}

	@Override
	public R visitNameReference(astm.@NonNull NameReference object) {
		return delegate.visitNameReference(object);
	}

	@Override
	public R visitNameSpaceDefinition(astm.@NonNull NameSpaceDefinition object) {
		return delegate.visitNameSpaceDefinition(object);
	}

	@Override
	public R visitNameSpaceType(astm.@NonNull NameSpaceType object) {
		return delegate.visitNameSpaceType(object);
	}

	@Override
	public R visitNamedType(astm.@NonNull NamedType object) {
		return delegate.visitNamedType(object);
	}

	@Override
	public R visitNamedTypeDefinition(astm.@NonNull NamedTypeDefinition object) {
		return delegate.visitNamedTypeDefinition(object);
	}

	@Override
	public R visitNamedTypeReference(astm.@NonNull NamedTypeReference object) {
		return delegate.visitNamedTypeReference(object);
	}

	@Override
	public R visitNegate(astm.@NonNull Negate object) {
		return delegate.visitNegate(object);
	}

	@Override
	public R visitNewExpression(astm.@NonNull NewExpression object) {
		return delegate.visitNewExpression(object);
	}

	@Override
	public R visitNoDef(astm.@NonNull NoDef object) {
		return delegate.visitNoDef(object);
	}

	@Override
	public R visitNonVirtual(astm.@NonNull NonVirtual object) {
		return delegate.visitNonVirtual(object);
	}

	@Override
	public R visitNot(astm.@NonNull Not object) {
		return delegate.visitNot(object);
	}

	@Override
	public R visitNotEqual(astm.@NonNull NotEqual object) {
		return delegate.visitNotEqual(object);
	}

	@Override
	public R visitNotGreater(astm.@NonNull NotGreater object) {
		return delegate.visitNotGreater(object);
	}

	@Override
	public R visitNotLess(astm.@NonNull NotLess object) {
		return delegate.visitNotLess(object);
	}

	@Override
	public R visitOperator(astm.@NonNull Operator object) {
		return delegate.visitOperator(object);
	}

	@Override
	public R visitOperatorAssign(astm.@NonNull OperatorAssign object) {
		return delegate.visitOperatorAssign(object);
	}

	@Override
	public R visitOr(astm.@NonNull Or object) {
		return delegate.visitOr(object);
	}

	@Override
	public R visitOtherSyntaxObject(astm.@NonNull OtherSyntaxObject object) {
		return delegate.visitOtherSyntaxObject(object);
	}

	@Override
	public R visitPerClassMember(astm.@NonNull PerClassMember object) {
		return delegate.visitPerClassMember(object);
	}

	@Override
	public R visitPointerType(astm.@NonNull PointerType object) {
		return delegate.visitPointerType(object);
	}

	@Override
	public R visitPostDecrement(astm.@NonNull PostDecrement object) {
		return delegate.visitPostDecrement(object);
	}

	@Override
	public R visitPostIncrement(astm.@NonNull PostIncrement object) {
		return delegate.visitPostIncrement(object);
	}

	@Override
	public R visitPreprocessorElement(astm.@NonNull PreprocessorElement object) {
		return delegate.visitPreprocessorElement(object);
	}

	@Override
	public R visitPrimitiveType(astm.@NonNull PrimitiveType object) {
		return delegate.visitPrimitiveType(object);
	}

	@Override
	public R visitPrivate(astm.@NonNull Private object) {
		return delegate.visitPrivate(object);
	}

	@Override
	public R visitProgramScope(astm.@NonNull ProgramScope object) {
		return delegate.visitProgramScope(object);
	}

	@Override
	public R visitProject(astm.@NonNull Project object) {
		return delegate.visitProject(object);
	}

	@Override
	public R visitProtected(astm.@NonNull Protected object) {
		return delegate.visitProtected(object);
	}

	@Override
	public R visitPublic(astm.@NonNull Public object) {
		return delegate.visitPublic(object);
	}

	@Override
	public R visitPureVirtual(astm.@NonNull PureVirtual object) {
		return delegate.visitPureVirtual(object);
	}

	@Override
	public R visitQualifiedIdentifierReference(astm.@NonNull QualifiedIdentifierReference object) {
		return delegate.visitQualifiedIdentifierReference(object);
	}

	@Override
	public R visitQualifiedOverData(astm.@NonNull QualifiedOverData object) {
		return delegate.visitQualifiedOverData(object);
	}

	@Override
	public R visitQualifiedOverPointer(astm.@NonNull QualifiedOverPointer object) {
		return delegate.visitQualifiedOverPointer(object);
	}

	@Override
	public R visitRangeExpression(astm.@NonNull RangeExpression object) {
		return delegate.visitRangeExpression(object);
	}

	@Override
	public R visitRangeType(astm.@NonNull RangeType object) {
		return delegate.visitRangeType(object);
	}

	@Override
	public R visitRealLiteral(astm.@NonNull RealLiteral object) {
		return delegate.visitRealLiteral(object);
	}

	@Override
	public R visitReferenceType(astm.@NonNull ReferenceType object) {
		return delegate.visitReferenceType(object);
	}

	@Override
	public R visitReturnStatement(astm.@NonNull ReturnStatement object) {
		return delegate.visitReturnStatement(object);
	}

	@Override
	public R visitScope(astm.@NonNull Scope object) {
		return delegate.visitScope(object);
	}

	@Override
	public R visitShortInteger(astm.@NonNull ShortInteger object) {
		return delegate.visitShortInteger(object);
	}

	@Override
	public R visitSourceFile(astm.@NonNull SourceFile object) {
		return delegate.visitSourceFile(object);
	}

	@Override
	public R visitSourceLocation(astm.@NonNull SourceLocation object) {
		return delegate.visitSourceLocation(object);
	}

	@Override
	public R visitSpecificConcatString(astm.@NonNull SpecificConcatString object) {
		return delegate.visitSpecificConcatString(object);
	}

	@Override
	public R visitSpecificGreaterEqual(astm.@NonNull SpecificGreaterEqual object) {
		return delegate.visitSpecificGreaterEqual(object);
	}

	@Override
	public R visitSpecificIn(astm.@NonNull SpecificIn object) {
		return delegate.visitSpecificIn(object);
	}

	@Override
	public R visitSpecificLessEqual(astm.@NonNull SpecificLessEqual object) {
		return delegate.visitSpecificLessEqual(object);
	}

	@Override
	public R visitSpecificLike(astm.@NonNull SpecificLike object) {
		return delegate.visitSpecificLike(object);
	}

	@Override
	public R visitSpecificSelectStatement(astm.@NonNull SpecificSelectStatement object) {
		return delegate.visitSpecificSelectStatement(object);
	}

	@Override
	public R visitSpecificTriggerDefinition(astm.@NonNull SpecificTriggerDefinition object) {
		return delegate.visitSpecificTriggerDefinition(object);
	}

	@Override
	public R visitStatement(astm.@NonNull Statement object) {
		return delegate.visitStatement(object);
	}

	@Override
	public R visitStorageSpecification(astm.@NonNull StorageSpecification object) {
		return delegate.visitStorageSpecification(object);
	}

	@Override
	public R visitString(astm.@NonNull String object) {
		return delegate.visitString(object);
	}

	@Override
	public R visitStringLiteral(astm.@NonNull StringLiteral object) {
		return delegate.visitStringLiteral(object);
	}

	@Override
	public R visitStructureType(astm.@NonNull StructureType object) {
		return delegate.visitStructureType(object);
	}

	@Override
	public R visitSubtract(astm.@NonNull Subtract object) {
		return delegate.visitSubtract(object);
	}

	@Override
	public R visitSwitchCase(astm.@NonNull SwitchCase object) {
		return delegate.visitSwitchCase(object);
	}

	@Override
	public R visitSwitchStatement(astm.@NonNull SwitchStatement object) {
		return delegate.visitSwitchStatement(object);
	}

	@Override
	public R visitTerminateStatement(astm.@NonNull TerminateStatement object) {
		return delegate.visitTerminateStatement(object);
	}

	@Override
	public R visitThrowStatement(astm.@NonNull ThrowStatement object) {
		return delegate.visitThrowStatement(object);
	}

	@Override
	public R visitTryStatement(astm.@NonNull TryStatement object) {
		return delegate.visitTryStatement(object);
	}

	@Override
	public R visitType(astm.@NonNull Type object) {
		return delegate.visitType(object);
	}

	@Override
	public R visitTypeDefinition(astm.@NonNull TypeDefinition object) {
		return delegate.visitTypeDefinition(object);
	}

	@Override
	public R visitTypeQualifiedIdentifierReference(astm.@NonNull TypeQualifiedIdentifierReference object) {
		return delegate.visitTypeQualifiedIdentifierReference(object);
	}

	@Override
	public R visitTypeReference(astm.@NonNull TypeReference object) {
		return delegate.visitTypeReference(object);
	}

	@Override
	public R visitTypesCatchBlock(astm.@NonNull TypesCatchBlock object) {
		return delegate.visitTypesCatchBlock(object);
	}

	@Override
	public R visitUnaryExpression(astm.@NonNull UnaryExpression object) {
		return delegate.visitUnaryExpression(object);
	}

	@Override
	public R visitUnaryOperator(astm.@NonNull UnaryOperator object) {
		return delegate.visitUnaryOperator(object);
	}

	@Override
	public R visitUnaryPlus(astm.@NonNull UnaryPlus object) {
		return delegate.visitUnaryPlus(object);
	}

	@Override
	public R visitUnionType(astm.@NonNull UnionType object) {
		return delegate.visitUnionType(object);
	}

	@Override
	public R visitUnnamedTypeReference(astm.@NonNull UnnamedTypeReference object) {
		return delegate.visitUnnamedTypeReference(object);
	}

	@Override
	public R visitVariableCatchBlock(astm.@NonNull VariableCatchBlock object) {
		return delegate.visitVariableCatchBlock(object);
	}

	@Override
	public R visitVariableDeclaration(astm.@NonNull VariableDeclaration object) {
		return delegate.visitVariableDeclaration(object);
	}

	@Override
	public R visitVariableDefinition(astm.@NonNull VariableDefinition object) {
		return delegate.visitVariableDefinition(object);
	}

	@Override
	public R visitVirtual(astm.@NonNull Virtual object) {
		return delegate.visitVirtual(object);
	}

	@Override
	public R visitVirtualSpecification(astm.@NonNull VirtualSpecification object) {
		return delegate.visitVirtualSpecification(object);
	}

	@Override
	public R visitVoid(astm.@NonNull Void object) {
		return delegate.visitVoid(object);
	}

	@Override
	public R visitWhileStatement(astm.@NonNull WhileStatement object) {
		return delegate.visitWhileStatement(object);
	}

	@Override
	public R visitWideCharacter(astm.@NonNull WideCharacter object) {
		return delegate.visitWideCharacter(object);
	}
}
