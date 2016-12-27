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
 * An AbstractMergedVisitor merges all visits direct to visiting().
 * This can be used by a decorating visitor to execute shared code before redispatching to a decorated visitor.
 */
public abstract class AbstractMergedVisitor<R, C>
	extends AbstractVisitor<R, C>
	implements Visitor<R>
{
	protected AbstractMergedVisitor(C context) {
		super(context);
	}

	@Override
	public R visitAccessKind(astm.@NonNull AccessKind object) {
		return visiting(object);
	}

	@Override
	public R visitActualParameter(astm.@NonNull ActualParameter object) {
		return visiting(object);
	}

	@Override
	public R visitActualParameterExpression(astm.@NonNull ActualParameterExpression object) {
		return visiting(object);
	}

	@Override
	public R visitAdd(astm.@NonNull Add object) {
		return visiting(object);
	}

	@Override
	public R visitAddressOf(astm.@NonNull AddressOf object) {
		return visiting(object);
	}

	@Override
	public R visitAggregateExpression(astm.@NonNull AggregateExpression object) {
		return visiting(object);
	}

	@Override
	public R visitAggregateScope(astm.@NonNull AggregateScope object) {
		return visiting(object);
	}

	@Override
	public R visitAggregateType(astm.@NonNull AggregateType object) {
		return visiting(object);
	}

	@Override
	public R visitAggregateTypeDefinition(astm.@NonNull AggregateTypeDefinition object) {
		return visiting(object);
	}

	@Override
	public R visitAnd(astm.@NonNull And object) {
		return visiting(object);
	}

	@Override
	public R visitAnnotationExpression(astm.@NonNull AnnotationExpression object) {
		return visiting(object);
	}

	@Override
	public R visitAnnotationType(astm.@NonNull AnnotationType object) {
		return visiting(object);
	}

	@Override
	public R visitArrayAccess(astm.@NonNull ArrayAccess object) {
		return visiting(object);
	}

	@Override
	public R visitArrayType(astm.@NonNull ArrayType object) {
		return visiting(object);
	}

	@Override
	public R visitAssign(astm.@NonNull Assign object) {
		return visiting(object);
	}

	@Override
	public R visitBinaryExpression(astm.@NonNull BinaryExpression object) {
		return visiting(object);
	}

	@Override
	public R visitBinaryOperator(astm.@NonNull BinaryOperator object) {
		return visiting(object);
	}

	@Override
	public R visitBitAnd(astm.@NonNull BitAnd object) {
		return visiting(object);
	}

	@Override
	public R visitBitFieldDefinition(astm.@NonNull BitFieldDefinition object) {
		return visiting(object);
	}

	@Override
	public R visitBitLeftShift(astm.@NonNull BitLeftShift object) {
		return visiting(object);
	}

	@Override
	public R visitBitLiteral(astm.@NonNull BitLiteral object) {
		return visiting(object);
	}

	@Override
	public R visitBitNot(astm.@NonNull BitNot object) {
		return visiting(object);
	}

	@Override
	public R visitBitOr(astm.@NonNull BitOr object) {
		return visiting(object);
	}

	@Override
	public R visitBitRightShift(astm.@NonNull BitRightShift object) {
		return visiting(object);
	}

	@Override
	public R visitBitXor(astm.@NonNull BitXor object) {
		return visiting(object);
	}

	@Override
	public R visitBlockScope(astm.@NonNull BlockScope object) {
		return visiting(object);
	}

	@Override
	public R visitBlockStatement(astm.@NonNull BlockStatement object) {
		return visiting(object);
	}

	@Override
	public R visitBoolean(astm.@NonNull Boolean object) {
		return visiting(object);
	}

	@Override
	public R visitBooleanLiteral(astm.@NonNull BooleanLiteral object) {
		return visiting(object);
	}

	@Override
	public R visitBreakStatement(astm.@NonNull BreakStatement object) {
		return visiting(object);
	}

	@Override
	public R visitByReferenceActualParameterExpression(astm.@NonNull ByReferenceActualParameterExpression object) {
		return visiting(object);
	}

	@Override
	public R visitByReferenceFormalParameterType(astm.@NonNull ByReferenceFormalParameterType object) {
		return visiting(object);
	}

	@Override
	public R visitByValueActualParameterExpression(astm.@NonNull ByValueActualParameterExpression object) {
		return visiting(object);
	}

	@Override
	public R visitByValueFormalParameterType(astm.@NonNull ByValueFormalParameterType object) {
		return visiting(object);
	}

	@Override
	public R visitByte(astm.@NonNull Byte object) {
		return visiting(object);
	}

	@Override
	public R visitCaseBlock(astm.@NonNull CaseBlock object) {
		return visiting(object);
	}

	@Override
	public R visitCastExpression(astm.@NonNull CastExpression object) {
		return visiting(object);
	}

	@Override
	public R visitCatchBlock(astm.@NonNull CatchBlock object) {
		return visiting(object);
	}

	@Override
	public R visitCharLiteral(astm.@NonNull CharLiteral object) {
		return visiting(object);
	}

	@Override
	public R visitCharacter(astm.@NonNull Character object) {
		return visiting(object);
	}

	@Override
	public R visitClassType(astm.@NonNull ClassType object) {
		return visiting(object);
	}

	@Override
	public R visitCollectionType(astm.@NonNull CollectionType object) {
		return visiting(object);
	}

	@Override
	public R visitComment(astm.@NonNull Comment object) {
		return visiting(object);
	}

	@Override
	public R visitCompilationUnit(astm.@NonNull CompilationUnit object) {
		return visiting(object);
	}

	@Override
	public R visitConditionalExpression(astm.@NonNull ConditionalExpression object) {
		return visiting(object);
	}

	@Override
	public R visitConstructedType(astm.@NonNull ConstructedType object) {
		return visiting(object);
	}

	@Override
	public R visitContinueStatement(astm.@NonNull ContinueStatement object) {
		return visiting(object);
	}

	@Override
	public R visitDataDefinition(astm.@NonNull DataDefinition object) {
		return visiting(object);
	}

	@Override
	public R visitDataType(astm.@NonNull DataType object) {
		return visiting(object);
	}

	@Override
	public R visitDeclaration(astm.@NonNull Declaration object) {
		return visiting(object);
	}

	@Override
	public R visitDeclarationOrDefinition(astm.@NonNull DeclarationOrDefinition object) {
		return visiting(object);
	}

	@Override
	public R visitDeclarationOrDefinitionStatement(astm.@NonNull DeclarationOrDefinitionStatement object) {
		return visiting(object);
	}

	@Override
	public R visitDecrement(astm.@NonNull Decrement object) {
		return visiting(object);
	}

	@Override
	public R visitDefaultBlock(astm.@NonNull DefaultBlock object) {
		return visiting(object);
	}

	@Override
	public R visitDefinition(astm.@NonNull Definition object) {
		return visiting(object);
	}

	@Override
	public R visitDefinitionObject(astm.@NonNull DefinitionObject object) {
		return visiting(object);
	}

	@Override
	public R visitDeleteStatement(astm.@NonNull DeleteStatement object) {
		return visiting(object);
	}

	@Override
	public R visitDelphiBlockStatement(astm.@NonNull DelphiBlockStatement object) {
		return visiting(object);
	}

	@Override
	public R visitDelphiFunctionCallExpression(astm.@NonNull DelphiFunctionCallExpression object) {
		return visiting(object);
	}

	@Override
	public R visitDelphiImplementationSection(astm.@NonNull DelphiImplementationSection object) {
		return visiting(object);
	}

	@Override
	public R visitDelphiInterfaceSection(astm.@NonNull DelphiInterfaceSection object) {
		return visiting(object);
	}

	@Override
	public R visitDelphiUnit(astm.@NonNull DelphiUnit object) {
		return visiting(object);
	}

	@Override
	public R visitDelphiWithStatement(astm.@NonNull DelphiWithStatement object) {
		return visiting(object);
	}

	@Override
	public R visitDeref(astm.@NonNull Deref object) {
		return visiting(object);
	}

	@Override
	public R visitDerivesFrom(astm.@NonNull DerivesFrom object) {
		return visiting(object);
	}

	@Override
	public R visitDimension(astm.@NonNull Dimension object) {
		return visiting(object);
	}

	@Override
	public R visitDivide(astm.@NonNull Divide object) {
		return visiting(object);
	}

	@Override
	public R visitDoWhileStatement(astm.@NonNull DoWhileStatement object) {
		return visiting(object);
	}

	@Override
	public R visitDouble(astm.@NonNull Double object) {
		return visiting(object);
	}

	@Override
	public R visitEmptyStatement(astm.@NonNull EmptyStatement object) {
		return visiting(object);
	}

	@Override
	public R visitEntryDefinition(astm.@NonNull EntryDefinition object) {
		return visiting(object);
	}

	@Override
	public R visitEnumLiteralDefinition(astm.@NonNull EnumLiteralDefinition object) {
		return visiting(object);
	}

	@Override
	public R visitEnumType(astm.@NonNull EnumType object) {
		return visiting(object);
	}

	@Override
	public R visitEqual(astm.@NonNull Equal object) {
		return visiting(object);
	}

	@Override
	public R visitExceptionType(astm.@NonNull ExceptionType object) {
		return visiting(object);
	}

	@Override
	public R visitExponent(astm.@NonNull Exponent object) {
		return visiting(object);
	}

	@Override
	public R visitExpression(astm.@NonNull Expression object) {
		return visiting(object);
	}

	@Override
	public R visitExpressionStatement(astm.@NonNull ExpressionStatement object) {
		return visiting(object);
	}

	@Override
	public R visitExternal(astm.@NonNull External object) {
		return visiting(object);
	}

	@Override
	public R visitFileLocal(astm.@NonNull FileLocal object) {
		return visiting(object);
	}

	@Override
	public R visitFloat(astm.@NonNull Float object) {
		return visiting(object);
	}

	@Override
	public R visitForCheckAfterStatement(astm.@NonNull ForCheckAfterStatement object) {
		return visiting(object);
	}

	@Override
	public R visitForCheckBeforeStatement(astm.@NonNull ForCheckBeforeStatement object) {
		return visiting(object);
	}

	@Override
	public R visitForStatement(astm.@NonNull ForStatement object) {
		return visiting(object);
	}

	@Override
	public R visitFormalParameterDeclaration(astm.@NonNull FormalParameterDeclaration object) {
		return visiting(object);
	}

	@Override
	public R visitFormalParameterDefinition(astm.@NonNull FormalParameterDefinition object) {
		return visiting(object);
	}

	@Override
	public R visitFormalParameterType(astm.@NonNull FormalParameterType object) {
		return visiting(object);
	}

	@Override
	public R visitFunctionCallExpression(astm.@NonNull FunctionCallExpression object) {
		return visiting(object);
	}

	@Override
	public R visitFunctionDeclaration(astm.@NonNull FunctionDeclaration object) {
		return visiting(object);
	}

	@Override
	public R visitFunctionDefinition(astm.@NonNull FunctionDefinition object) {
		return visiting(object);
	}

	@Override
	public R visitFunctionMemberAttribute(astm.@NonNull FunctionMemberAttribute object) {
		return visiting(object);
	}

	@Override
	public R visitFunctionMemberAttributes(astm.@NonNull FunctionMemberAttributes object) {
		return visiting(object);
	}

	@Override
	public R visitFunctionPersistent(astm.@NonNull FunctionPersistent object) {
		return visiting(object);
	}

	@Override
	public R visitFunctionScope(astm.@NonNull FunctionScope object) {
		return visiting(object);
	}

	@Override
	public R visitFunctionType(astm.@NonNull FunctionType object) {
		return visiting(object);
	}

	@Override
	public R visitGASTMObject(astm.@NonNull GASTMObject object) {
		return visiting(object);
	}

	@Override
	public R visitGASTMSemanticObject(astm.@NonNull GASTMSemanticObject object) {
		return visiting(object);
	}

	@Override
	public R visitGASTMSourceObject(astm.@NonNull GASTMSourceObject object) {
		return visiting(object);
	}

	@Override
	public R visitGASTMSyntaxObject(astm.@NonNull GASTMSyntaxObject object) {
		return visiting(object);
	}

	@Override
	public R visitGlobalScope(astm.@NonNull GlobalScope object) {
		return visiting(object);
	}

	@Override
	public R visitGreater(astm.@NonNull Greater object) {
		return visiting(object);
	}

	@Override
	public R visitIdentifierReference(astm.@NonNull IdentifierReference object) {
		return visiting(object);
	}

	@Override
	public R visitIfStatement(astm.@NonNull IfStatement object) {
		return visiting(object);
	}

	@Override
	public R visitIncludeUnit(astm.@NonNull IncludeUnit object) {
		return visiting(object);
	}

	@Override
	public R visitIncrement(astm.@NonNull Increment object) {
		return visiting(object);
	}

	@Override
	public R visitInteger(astm.@NonNull Integer object) {
		return visiting(object);
	}

	@Override
	public R visitIntegerLiteral(astm.@NonNull IntegerLiteral object) {
		return visiting(object);
	}

	@Override
	public R visitJumpStatement(astm.@NonNull JumpStatement object) {
		return visiting(object);
	}

	@Override
	public R visitLabelAccess(astm.@NonNull LabelAccess object) {
		return visiting(object);
	}

	@Override
	public R visitLabelDefinition(astm.@NonNull LabelDefinition object) {
		return visiting(object);
	}

	@Override
	public R visitLabelType(astm.@NonNull LabelType object) {
		return visiting(object);
	}

	@Override
	public R visitLabeledStatement(astm.@NonNull LabeledStatement object) {
		return visiting(object);
	}

	@Override
	public R visitLess(astm.@NonNull Less object) {
		return visiting(object);
	}

	@Override
	public R visitLiteral(astm.@NonNull Literal object) {
		return visiting(object);
	}

	@Override
	public R visitLongDouble(astm.@NonNull LongDouble object) {
		return visiting(object);
	}

	@Override
	public R visitLongInteger(astm.@NonNull LongInteger object) {
		return visiting(object);
	}

	@Override
	public R visitLoopStatement(astm.@NonNull LoopStatement object) {
		return visiting(object);
	}

	@Override
	public R visitMacroCall(astm.@NonNull MacroCall object) {
		return visiting(object);
	}

	@Override
	public R visitMacroDefinition(astm.@NonNull MacroDefinition object) {
		return visiting(object);
	}

	@Override
	public R visitMissingActualParameter(astm.@NonNull MissingActualParameter object) {
		return visiting(object);
	}

	@Override
	public R visitModulus(astm.@NonNull Modulus object) {
		return visiting(object);
	}

	@Override
	public R visitMultiply(astm.@NonNull Multiply object) {
		return visiting(object);
	}

	@Override
	public R visitName(astm.@NonNull Name object) {
		return visiting(object);
	}

	@Override
	public R visitNameReference(astm.@NonNull NameReference object) {
		return visiting(object);
	}

	@Override
	public R visitNameSpaceDefinition(astm.@NonNull NameSpaceDefinition object) {
		return visiting(object);
	}

	@Override
	public R visitNameSpaceType(astm.@NonNull NameSpaceType object) {
		return visiting(object);
	}

	@Override
	public R visitNamedType(astm.@NonNull NamedType object) {
		return visiting(object);
	}

	@Override
	public R visitNamedTypeDefinition(astm.@NonNull NamedTypeDefinition object) {
		return visiting(object);
	}

	@Override
	public R visitNamedTypeReference(astm.@NonNull NamedTypeReference object) {
		return visiting(object);
	}

	@Override
	public R visitNegate(astm.@NonNull Negate object) {
		return visiting(object);
	}

	@Override
	public R visitNewExpression(astm.@NonNull NewExpression object) {
		return visiting(object);
	}

	@Override
	public R visitNoDef(astm.@NonNull NoDef object) {
		return visiting(object);
	}

	@Override
	public R visitNonVirtual(astm.@NonNull NonVirtual object) {
		return visiting(object);
	}

	@Override
	public R visitNot(astm.@NonNull Not object) {
		return visiting(object);
	}

	@Override
	public R visitNotEqual(astm.@NonNull NotEqual object) {
		return visiting(object);
	}

	@Override
	public R visitNotGreater(astm.@NonNull NotGreater object) {
		return visiting(object);
	}

	@Override
	public R visitNotLess(astm.@NonNull NotLess object) {
		return visiting(object);
	}

	@Override
	public R visitOperator(astm.@NonNull Operator object) {
		return visiting(object);
	}

	@Override
	public R visitOperatorAssign(astm.@NonNull OperatorAssign object) {
		return visiting(object);
	}

	@Override
	public R visitOr(astm.@NonNull Or object) {
		return visiting(object);
	}

	@Override
	public R visitOtherSyntaxObject(astm.@NonNull OtherSyntaxObject object) {
		return visiting(object);
	}

	@Override
	public R visitPerClassMember(astm.@NonNull PerClassMember object) {
		return visiting(object);
	}

	@Override
	public R visitPointerType(astm.@NonNull PointerType object) {
		return visiting(object);
	}

	@Override
	public R visitPostDecrement(astm.@NonNull PostDecrement object) {
		return visiting(object);
	}

	@Override
	public R visitPostIncrement(astm.@NonNull PostIncrement object) {
		return visiting(object);
	}

	@Override
	public R visitPreprocessorElement(astm.@NonNull PreprocessorElement object) {
		return visiting(object);
	}

	@Override
	public R visitPrimitiveType(astm.@NonNull PrimitiveType object) {
		return visiting(object);
	}

	@Override
	public R visitPrivate(astm.@NonNull Private object) {
		return visiting(object);
	}

	@Override
	public R visitProgramScope(astm.@NonNull ProgramScope object) {
		return visiting(object);
	}

	@Override
	public R visitProject(astm.@NonNull Project object) {
		return visiting(object);
	}

	@Override
	public R visitProtected(astm.@NonNull Protected object) {
		return visiting(object);
	}

	@Override
	public R visitPublic(astm.@NonNull Public object) {
		return visiting(object);
	}

	@Override
	public R visitPureVirtual(astm.@NonNull PureVirtual object) {
		return visiting(object);
	}

	@Override
	public R visitQualifiedIdentifierReference(astm.@NonNull QualifiedIdentifierReference object) {
		return visiting(object);
	}

	@Override
	public R visitQualifiedOverData(astm.@NonNull QualifiedOverData object) {
		return visiting(object);
	}

	@Override
	public R visitQualifiedOverPointer(astm.@NonNull QualifiedOverPointer object) {
		return visiting(object);
	}

	@Override
	public R visitRangeExpression(astm.@NonNull RangeExpression object) {
		return visiting(object);
	}

	@Override
	public R visitRangeType(astm.@NonNull RangeType object) {
		return visiting(object);
	}

	@Override
	public R visitRealLiteral(astm.@NonNull RealLiteral object) {
		return visiting(object);
	}

	@Override
	public R visitReferenceType(astm.@NonNull ReferenceType object) {
		return visiting(object);
	}

	@Override
	public R visitReturnStatement(astm.@NonNull ReturnStatement object) {
		return visiting(object);
	}

	@Override
	public R visitScope(astm.@NonNull Scope object) {
		return visiting(object);
	}

	@Override
	public R visitShortInteger(astm.@NonNull ShortInteger object) {
		return visiting(object);
	}

	@Override
	public R visitSourceFile(astm.@NonNull SourceFile object) {
		return visiting(object);
	}

	@Override
	public R visitSourceLocation(astm.@NonNull SourceLocation object) {
		return visiting(object);
	}

	@Override
	public R visitSpecificConcatString(astm.@NonNull SpecificConcatString object) {
		return visiting(object);
	}

	@Override
	public R visitSpecificGreaterEqual(astm.@NonNull SpecificGreaterEqual object) {
		return visiting(object);
	}

	@Override
	public R visitSpecificIn(astm.@NonNull SpecificIn object) {
		return visiting(object);
	}

	@Override
	public R visitSpecificLessEqual(astm.@NonNull SpecificLessEqual object) {
		return visiting(object);
	}

	@Override
	public R visitSpecificLike(astm.@NonNull SpecificLike object) {
		return visiting(object);
	}

	@Override
	public R visitSpecificSelectStatement(astm.@NonNull SpecificSelectStatement object) {
		return visiting(object);
	}

	@Override
	public R visitSpecificTriggerDefinition(astm.@NonNull SpecificTriggerDefinition object) {
		return visiting(object);
	}

	@Override
	public R visitStatement(astm.@NonNull Statement object) {
		return visiting(object);
	}

	@Override
	public R visitStorageSpecification(astm.@NonNull StorageSpecification object) {
		return visiting(object);
	}

	@Override
	public R visitString(astm.@NonNull String object) {
		return visiting(object);
	}

	@Override
	public R visitStringLiteral(astm.@NonNull StringLiteral object) {
		return visiting(object);
	}

	@Override
	public R visitStructureType(astm.@NonNull StructureType object) {
		return visiting(object);
	}

	@Override
	public R visitSubtract(astm.@NonNull Subtract object) {
		return visiting(object);
	}

	@Override
	public R visitSwitchCase(astm.@NonNull SwitchCase object) {
		return visiting(object);
	}

	@Override
	public R visitSwitchStatement(astm.@NonNull SwitchStatement object) {
		return visiting(object);
	}

	@Override
	public R visitTerminateStatement(astm.@NonNull TerminateStatement object) {
		return visiting(object);
	}

	@Override
	public R visitThrowStatement(astm.@NonNull ThrowStatement object) {
		return visiting(object);
	}

	@Override
	public R visitTryStatement(astm.@NonNull TryStatement object) {
		return visiting(object);
	}

	@Override
	public R visitType(astm.@NonNull Type object) {
		return visiting(object);
	}

	@Override
	public R visitTypeDefinition(astm.@NonNull TypeDefinition object) {
		return visiting(object);
	}

	@Override
	public R visitTypeQualifiedIdentifierReference(astm.@NonNull TypeQualifiedIdentifierReference object) {
		return visiting(object);
	}

	@Override
	public R visitTypeReference(astm.@NonNull TypeReference object) {
		return visiting(object);
	}

	@Override
	public R visitTypesCatchBlock(astm.@NonNull TypesCatchBlock object) {
		return visiting(object);
	}

	@Override
	public R visitUnaryExpression(astm.@NonNull UnaryExpression object) {
		return visiting(object);
	}

	@Override
	public R visitUnaryOperator(astm.@NonNull UnaryOperator object) {
		return visiting(object);
	}

	@Override
	public R visitUnaryPlus(astm.@NonNull UnaryPlus object) {
		return visiting(object);
	}

	@Override
	public R visitUnionType(astm.@NonNull UnionType object) {
		return visiting(object);
	}

	@Override
	public R visitUnnamedTypeReference(astm.@NonNull UnnamedTypeReference object) {
		return visiting(object);
	}

	@Override
	public R visitVariableCatchBlock(astm.@NonNull VariableCatchBlock object) {
		return visiting(object);
	}

	@Override
	public R visitVariableDeclaration(astm.@NonNull VariableDeclaration object) {
		return visiting(object);
	}

	@Override
	public R visitVariableDefinition(astm.@NonNull VariableDefinition object) {
		return visiting(object);
	}

	@Override
	public R visitVirtual(astm.@NonNull Virtual object) {
		return visiting(object);
	}

	@Override
	public R visitVirtualSpecification(astm.@NonNull VirtualSpecification object) {
		return visiting(object);
	}

	@Override
	public R visitVoid(astm.@NonNull Void object) {
		return visiting(object);
	}

	@Override
	public R visitWhileStatement(astm.@NonNull WhileStatement object) {
		return visiting(object);
	}

	@Override
	public R visitWideCharacter(astm.@NonNull WideCharacter object) {
		return visiting(object);
	}
}
