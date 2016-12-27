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
 * An AbstractExtendingVisitor provides a default implementation for each
 * visitXxx method that delegates to the visitYyy method of the first
 * super class, (or transitively its first super class' first super class
 * until a non-interface super-class is found). In the absence of any
 * suitable first super class, the method delegates to visiting().
 */
public abstract class AbstractExtendingVisitor<R, C>
	extends AbstractVisitor<R, C>
	implements Visitor<R>
{
	/**
	 * Initializes me with an initial value for my result.
	 *
	 * @param context my initial result value
	 */
	protected AbstractExtendingVisitor(C context) {
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
		return visitActualParameter(object);
	}

	@Override
	public R visitAdd(astm.@NonNull Add object) {
		return visitBinaryOperator(object);
	}

	@Override
	public R visitAddressOf(astm.@NonNull AddressOf object) {
		return visitUnaryOperator(object);
	}

	@Override
	public R visitAggregateExpression(astm.@NonNull AggregateExpression object) {
		return visitExpression(object);
	}

	@Override
	public R visitAggregateScope(astm.@NonNull AggregateScope object) {
		return visitScope(object);
	}

	@Override
	public R visitAggregateType(astm.@NonNull AggregateType object) {
		return visitDataType(object);
	}

	@Override
	public R visitAggregateTypeDefinition(astm.@NonNull AggregateTypeDefinition object) {
		return visitTypeDefinition(object);
	}

	@Override
	public R visitAnd(astm.@NonNull And object) {
		return visitBinaryOperator(object);
	}

	@Override
	public R visitAnnotationExpression(astm.@NonNull AnnotationExpression object) {
		return visitExpression(object);
	}

	@Override
	public R visitAnnotationType(astm.@NonNull AnnotationType object) {
		return visitAggregateType(object);
	}

	@Override
	public R visitArrayAccess(astm.@NonNull ArrayAccess object) {
		return visitExpression(object);
	}

	@Override
	public R visitArrayType(astm.@NonNull ArrayType object) {
		return visitConstructedType(object);
	}

	@Override
	public R visitAssign(astm.@NonNull Assign object) {
		return visitBinaryOperator(object);
	}

	@Override
	public R visitBinaryExpression(astm.@NonNull BinaryExpression object) {
		return visitExpression(object);
	}

	@Override
	public R visitBinaryOperator(astm.@NonNull BinaryOperator object) {
		return visitOperator(object);
	}

	@Override
	public R visitBitAnd(astm.@NonNull BitAnd object) {
		return visitBinaryOperator(object);
	}

	@Override
	public R visitBitFieldDefinition(astm.@NonNull BitFieldDefinition object) {
		return visitDataDefinition(object);
	}

	@Override
	public R visitBitLeftShift(astm.@NonNull BitLeftShift object) {
		return visitBinaryOperator(object);
	}

	@Override
	public R visitBitLiteral(astm.@NonNull BitLiteral object) {
		return visitLiteral(object);
	}

	@Override
	public R visitBitNot(astm.@NonNull BitNot object) {
		return visitUnaryOperator(object);
	}

	@Override
	public R visitBitOr(astm.@NonNull BitOr object) {
		return visitBinaryOperator(object);
	}

	@Override
	public R visitBitRightShift(astm.@NonNull BitRightShift object) {
		return visitBinaryOperator(object);
	}

	@Override
	public R visitBitXor(astm.@NonNull BitXor object) {
		return visitBinaryOperator(object);
	}

	@Override
	public R visitBlockScope(astm.@NonNull BlockScope object) {
		return visitScope(object);
	}

	@Override
	public R visitBlockStatement(astm.@NonNull BlockStatement object) {
		return visitStatement(object);
	}

	@Override
	public R visitBoolean(astm.@NonNull Boolean object) {
		return visitPrimitiveType(object);
	}

	@Override
	public R visitBooleanLiteral(astm.@NonNull BooleanLiteral object) {
		return visitLiteral(object);
	}

	@Override
	public R visitBreakStatement(astm.@NonNull BreakStatement object) {
		return visitStatement(object);
	}

	@Override
	public R visitByReferenceActualParameterExpression(astm.@NonNull ByReferenceActualParameterExpression object) {
		return visitActualParameterExpression(object);
	}

	@Override
	public R visitByReferenceFormalParameterType(astm.@NonNull ByReferenceFormalParameterType object) {
		return visitFormalParameterType(object);
	}

	@Override
	public R visitByValueActualParameterExpression(astm.@NonNull ByValueActualParameterExpression object) {
		return visitActualParameterExpression(object);
	}

	@Override
	public R visitByValueFormalParameterType(astm.@NonNull ByValueFormalParameterType object) {
		return visitFormalParameterType(object);
	}

	@Override
	public R visitByte(astm.@NonNull Byte object) {
		return visitPrimitiveType(object);
	}

	@Override
	public R visitCaseBlock(astm.@NonNull CaseBlock object) {
		return visitSwitchCase(object);
	}

	@Override
	public R visitCastExpression(astm.@NonNull CastExpression object) {
		return visitExpression(object);
	}

	@Override
	public R visitCatchBlock(astm.@NonNull CatchBlock object) {
		return visitOtherSyntaxObject(object);
	}

	@Override
	public R visitCharLiteral(astm.@NonNull CharLiteral object) {
		return visitLiteral(object);
	}

	@Override
	public R visitCharacter(astm.@NonNull Character object) {
		return visitPrimitiveType(object);
	}

	@Override
	public R visitClassType(astm.@NonNull ClassType object) {
		return visitAggregateType(object);
	}

	@Override
	public R visitCollectionType(astm.@NonNull CollectionType object) {
		return visitConstructedType(object);
	}

	@Override
	public R visitComment(astm.@NonNull Comment object) {
		return visitPreprocessorElement(object);
	}

	@Override
	public R visitCompilationUnit(astm.@NonNull CompilationUnit object) {
		return visitOtherSyntaxObject(object);
	}

	@Override
	public R visitConditionalExpression(astm.@NonNull ConditionalExpression object) {
		return visitExpression(object);
	}

	@Override
	public R visitConstructedType(astm.@NonNull ConstructedType object) {
		return visitDataType(object);
	}

	@Override
	public R visitContinueStatement(astm.@NonNull ContinueStatement object) {
		return visitStatement(object);
	}

	@Override
	public R visitDataDefinition(astm.@NonNull DataDefinition object) {
		return visitDefinition(object);
	}

	@Override
	public R visitDataType(astm.@NonNull DataType object) {
		return visitType(object);
	}

	@Override
	public R visitDeclaration(astm.@NonNull Declaration object) {
		return visitDeclarationOrDefinition(object);
	}

	@Override
	public R visitDeclarationOrDefinition(astm.@NonNull DeclarationOrDefinition object) {
		return visitDefinitionObject(object);
	}

	@Override
	public R visitDeclarationOrDefinitionStatement(astm.@NonNull DeclarationOrDefinitionStatement object) {
		return visitStatement(object);
	}

	@Override
	public R visitDecrement(astm.@NonNull Decrement object) {
		return visitUnaryOperator(object);
	}

	@Override
	public R visitDefaultBlock(astm.@NonNull DefaultBlock object) {
		return visitSwitchCase(object);
	}

	@Override
	public R visitDefinition(astm.@NonNull Definition object) {
		return visitDeclarationOrDefinition(object);
	}

	@Override
	public R visitDefinitionObject(astm.@NonNull DefinitionObject object) {
		return visitGASTMSyntaxObject(object);
	}

	@Override
	public R visitDeleteStatement(astm.@NonNull DeleteStatement object) {
		return visitStatement(object);
	}

	@Override
	public R visitDelphiBlockStatement(astm.@NonNull DelphiBlockStatement object) {
		return visitBlockStatement(object);
	}

	@Override
	public R visitDelphiFunctionCallExpression(astm.@NonNull DelphiFunctionCallExpression object) {
		return visitFunctionCallExpression(object);
	}

	@Override
	public R visitDelphiImplementationSection(astm.@NonNull DelphiImplementationSection object) {
		return visitCompilationUnit(object);
	}

	@Override
	public R visitDelphiInterfaceSection(astm.@NonNull DelphiInterfaceSection object) {
		return visitCompilationUnit(object);
	}

	@Override
	public R visitDelphiUnit(astm.@NonNull DelphiUnit object) {
		return visitCompilationUnit(object);
	}

	@Override
	public R visitDelphiWithStatement(astm.@NonNull DelphiWithStatement object) {
		return visitBlockStatement(object);
	}

	@Override
	public R visitDeref(astm.@NonNull Deref object) {
		return visitUnaryOperator(object);
	}

	@Override
	public R visitDerivesFrom(astm.@NonNull DerivesFrom object) {
		return visitOtherSyntaxObject(object);
	}

	@Override
	public R visitDimension(astm.@NonNull Dimension object) {
		return visitOtherSyntaxObject(object);
	}

	@Override
	public R visitDivide(astm.@NonNull Divide object) {
		return visitBinaryOperator(object);
	}

	@Override
	public R visitDoWhileStatement(astm.@NonNull DoWhileStatement object) {
		return visitLoopStatement(object);
	}

	@Override
	public R visitDouble(astm.@NonNull Double object) {
		return visitPrimitiveType(object);
	}

	@Override
	public R visitEmptyStatement(astm.@NonNull EmptyStatement object) {
		return visitStatement(object);
	}

	@Override
	public R visitEntryDefinition(astm.@NonNull EntryDefinition object) {
		return visitDefinition(object);
	}

	@Override
	public R visitEnumLiteralDefinition(astm.@NonNull EnumLiteralDefinition object) {
		return visitDefinition(object);
	}

	@Override
	public R visitEnumType(astm.@NonNull EnumType object) {
		return visitDataType(object);
	}

	@Override
	public R visitEqual(astm.@NonNull Equal object) {
		return visitBinaryOperator(object);
	}

	@Override
	public R visitExceptionType(astm.@NonNull ExceptionType object) {
		return visitDataType(object);
	}

	@Override
	public R visitExponent(astm.@NonNull Exponent object) {
		return visitBinaryOperator(object);
	}

	@Override
	public R visitExpression(astm.@NonNull Expression object) {
		return visitGASTMSyntaxObject(object);
	}

	@Override
	public R visitExpressionStatement(astm.@NonNull ExpressionStatement object) {
		return visitStatement(object);
	}

	@Override
	public R visitExternal(astm.@NonNull External object) {
		return visitStorageSpecification(object);
	}

	@Override
	public R visitFileLocal(astm.@NonNull FileLocal object) {
		return visitStorageSpecification(object);
	}

	@Override
	public R visitFloat(astm.@NonNull Float object) {
		return visitPrimitiveType(object);
	}

	@Override
	public R visitForCheckAfterStatement(astm.@NonNull ForCheckAfterStatement object) {
		return visitForStatement(object);
	}

	@Override
	public R visitForCheckBeforeStatement(astm.@NonNull ForCheckBeforeStatement object) {
		return visitForStatement(object);
	}

	@Override
	public R visitForStatement(astm.@NonNull ForStatement object) {
		return visitLoopStatement(object);
	}

	@Override
	public R visitFormalParameterDeclaration(astm.@NonNull FormalParameterDeclaration object) {
		return visitDeclaration(object);
	}

	@Override
	public R visitFormalParameterDefinition(astm.@NonNull FormalParameterDefinition object) {
		return visitDataDefinition(object);
	}

	@Override
	public R visitFormalParameterType(astm.@NonNull FormalParameterType object) {
		return visitDataType(object);
	}

	@Override
	public R visitFunctionCallExpression(astm.@NonNull FunctionCallExpression object) {
		return visitExpression(object);
	}

	@Override
	public R visitFunctionDeclaration(astm.@NonNull FunctionDeclaration object) {
		return visitDeclaration(object);
	}

	@Override
	public R visitFunctionDefinition(astm.@NonNull FunctionDefinition object) {
		return visitDefinition(object);
	}

	@Override
	public R visitFunctionMemberAttribute(astm.@NonNull FunctionMemberAttribute object) {
		return visitOtherSyntaxObject(object);
	}

	@Override
	public R visitFunctionMemberAttributes(astm.@NonNull FunctionMemberAttributes object) {
		return visiting(object);
	}

	@Override
	public R visitFunctionPersistent(astm.@NonNull FunctionPersistent object) {
		return visitStorageSpecification(object);
	}

	@Override
	public R visitFunctionScope(astm.@NonNull FunctionScope object) {
		return visitScope(object);
	}

	@Override
	public R visitFunctionType(astm.@NonNull FunctionType object) {
		return visitType(object);
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
		return visitGASTMObject(object);
	}

	@Override
	public R visitGlobalScope(astm.@NonNull GlobalScope object) {
		return visitScope(object);
	}

	@Override
	public R visitGreater(astm.@NonNull Greater object) {
		return visitBinaryOperator(object);
	}

	@Override
	public R visitIdentifierReference(astm.@NonNull IdentifierReference object) {
		return visitNameReference(object);
	}

	@Override
	public R visitIfStatement(astm.@NonNull IfStatement object) {
		return visitStatement(object);
	}

	@Override
	public R visitIncludeUnit(astm.@NonNull IncludeUnit object) {
		return visitPreprocessorElement(object);
	}

	@Override
	public R visitIncrement(astm.@NonNull Increment object) {
		return visitUnaryOperator(object);
	}

	@Override
	public R visitInteger(astm.@NonNull Integer object) {
		return visitPrimitiveType(object);
	}

	@Override
	public R visitIntegerLiteral(astm.@NonNull IntegerLiteral object) {
		return visitLiteral(object);
	}

	@Override
	public R visitJumpStatement(astm.@NonNull JumpStatement object) {
		return visitStatement(object);
	}

	@Override
	public R visitLabelAccess(astm.@NonNull LabelAccess object) {
		return visitExpression(object);
	}

	@Override
	public R visitLabelDefinition(astm.@NonNull LabelDefinition object) {
		return visitDefinitionObject(object);
	}

	@Override
	public R visitLabelType(astm.@NonNull LabelType object) {
		return visitType(object);
	}

	@Override
	public R visitLabeledStatement(astm.@NonNull LabeledStatement object) {
		return visitStatement(object);
	}

	@Override
	public R visitLess(astm.@NonNull Less object) {
		return visitBinaryOperator(object);
	}

	@Override
	public R visitLiteral(astm.@NonNull Literal object) {
		return visitExpression(object);
	}

	@Override
	public R visitLongDouble(astm.@NonNull LongDouble object) {
		return visitPrimitiveType(object);
	}

	@Override
	public R visitLongInteger(astm.@NonNull LongInteger object) {
		return visitPrimitiveType(object);
	}

	@Override
	public R visitLoopStatement(astm.@NonNull LoopStatement object) {
		return visitStatement(object);
	}

	@Override
	public R visitMacroCall(astm.@NonNull MacroCall object) {
		return visitPreprocessorElement(object);
	}

	@Override
	public R visitMacroDefinition(astm.@NonNull MacroDefinition object) {
		return visitPreprocessorElement(object);
	}

	@Override
	public R visitMissingActualParameter(astm.@NonNull MissingActualParameter object) {
		return visitActualParameter(object);
	}

	@Override
	public R visitModulus(astm.@NonNull Modulus object) {
		return visitBinaryOperator(object);
	}

	@Override
	public R visitMultiply(astm.@NonNull Multiply object) {
		return visitBinaryOperator(object);
	}

	@Override
	public R visitName(astm.@NonNull Name object) {
		return visitOtherSyntaxObject(object);
	}

	@Override
	public R visitNameReference(astm.@NonNull NameReference object) {
		return visitExpression(object);
	}

	@Override
	public R visitNameSpaceDefinition(astm.@NonNull NameSpaceDefinition object) {
		return visitDefinitionObject(object);
	}

	@Override
	public R visitNameSpaceType(astm.@NonNull NameSpaceType object) {
		return visitType(object);
	}

	@Override
	public R visitNamedType(astm.@NonNull NamedType object) {
		return visitDataType(object);
	}

	@Override
	public R visitNamedTypeDefinition(astm.@NonNull NamedTypeDefinition object) {
		return visitTypeDefinition(object);
	}

	@Override
	public R visitNamedTypeReference(astm.@NonNull NamedTypeReference object) {
		return visitTypeReference(object);
	}

	@Override
	public R visitNegate(astm.@NonNull Negate object) {
		return visitUnaryOperator(object);
	}

	@Override
	public R visitNewExpression(astm.@NonNull NewExpression object) {
		return visitExpression(object);
	}

	@Override
	public R visitNoDef(astm.@NonNull NoDef object) {
		return visitStorageSpecification(object);
	}

	@Override
	public R visitNonVirtual(astm.@NonNull NonVirtual object) {
		return visitVirtualSpecification(object);
	}

	@Override
	public R visitNot(astm.@NonNull Not object) {
		return visitUnaryOperator(object);
	}

	@Override
	public R visitNotEqual(astm.@NonNull NotEqual object) {
		return visitBinaryOperator(object);
	}

	@Override
	public R visitNotGreater(astm.@NonNull NotGreater object) {
		return visitBinaryOperator(object);
	}

	@Override
	public R visitNotLess(astm.@NonNull NotLess object) {
		return visitBinaryOperator(object);
	}

	@Override
	public R visitOperator(astm.@NonNull Operator object) {
		return visitOtherSyntaxObject(object);
	}

	@Override
	public R visitOperatorAssign(astm.@NonNull OperatorAssign object) {
		return visitBinaryOperator(object);
	}

	@Override
	public R visitOr(astm.@NonNull Or object) {
		return visitBinaryOperator(object);
	}

	@Override
	public R visitOtherSyntaxObject(astm.@NonNull OtherSyntaxObject object) {
		return visitGASTMSyntaxObject(object);
	}

	@Override
	public R visitPerClassMember(astm.@NonNull PerClassMember object) {
		return visitStorageSpecification(object);
	}

	@Override
	public R visitPointerType(astm.@NonNull PointerType object) {
		return visitConstructedType(object);
	}

	@Override
	public R visitPostDecrement(astm.@NonNull PostDecrement object) {
		return visitUnaryOperator(object);
	}

	@Override
	public R visitPostIncrement(astm.@NonNull PostIncrement object) {
		return visitUnaryOperator(object);
	}

	@Override
	public R visitPreprocessorElement(astm.@NonNull PreprocessorElement object) {
		return visitGASTMSyntaxObject(object);
	}

	@Override
	public R visitPrimitiveType(astm.@NonNull PrimitiveType object) {
		return visitDataType(object);
	}

	@Override
	public R visitPrivate(astm.@NonNull Private object) {
		return visitAccessKind(object);
	}

	@Override
	public R visitProgramScope(astm.@NonNull ProgramScope object) {
		return visitScope(object);
	}

	@Override
	public R visitProject(astm.@NonNull Project object) {
		return visitGASTMSemanticObject(object);
	}

	@Override
	public R visitProtected(astm.@NonNull Protected object) {
		return visitAccessKind(object);
	}

	@Override
	public R visitPublic(astm.@NonNull Public object) {
		return visitAccessKind(object);
	}

	@Override
	public R visitPureVirtual(astm.@NonNull PureVirtual object) {
		return visitVirtualSpecification(object);
	}

	@Override
	public R visitQualifiedIdentifierReference(astm.@NonNull QualifiedIdentifierReference object) {
		return visitNameReference(object);
	}

	@Override
	public R visitQualifiedOverData(astm.@NonNull QualifiedOverData object) {
		return visitQualifiedIdentifierReference(object);
	}

	@Override
	public R visitQualifiedOverPointer(astm.@NonNull QualifiedOverPointer object) {
		return visitQualifiedIdentifierReference(object);
	}

	@Override
	public R visitRangeExpression(astm.@NonNull RangeExpression object) {
		return visitExpression(object);
	}

	@Override
	public R visitRangeType(astm.@NonNull RangeType object) {
		return visitConstructedType(object);
	}

	@Override
	public R visitRealLiteral(astm.@NonNull RealLiteral object) {
		return visitLiteral(object);
	}

	@Override
	public R visitReferenceType(astm.@NonNull ReferenceType object) {
		return visitConstructedType(object);
	}

	@Override
	public R visitReturnStatement(astm.@NonNull ReturnStatement object) {
		return visitStatement(object);
	}

	@Override
	public R visitScope(astm.@NonNull Scope object) {
		return visitGASTMSemanticObject(object);
	}

	@Override
	public R visitShortInteger(astm.@NonNull ShortInteger object) {
		return visitPrimitiveType(object);
	}

	@Override
	public R visitSourceFile(astm.@NonNull SourceFile object) {
		return visitGASTMSourceObject(object);
	}

	@Override
	public R visitSourceLocation(astm.@NonNull SourceLocation object) {
		return visitGASTMSourceObject(object);
	}

	@Override
	public R visitSpecificConcatString(astm.@NonNull SpecificConcatString object) {
		return visitBinaryOperator(object);
	}

	@Override
	public R visitSpecificGreaterEqual(astm.@NonNull SpecificGreaterEqual object) {
		return visitBinaryOperator(object);
	}

	@Override
	public R visitSpecificIn(astm.@NonNull SpecificIn object) {
		return visitBinaryOperator(object);
	}

	@Override
	public R visitSpecificLessEqual(astm.@NonNull SpecificLessEqual object) {
		return visitBinaryOperator(object);
	}

	@Override
	public R visitSpecificLike(astm.@NonNull SpecificLike object) {
		return visitBinaryOperator(object);
	}

	@Override
	public R visitSpecificSelectStatement(astm.@NonNull SpecificSelectStatement object) {
		return visitStatement(object);
	}

	@Override
	public R visitSpecificTriggerDefinition(astm.@NonNull SpecificTriggerDefinition object) {
		return visitDefinition(object);
	}

	@Override
	public R visitStatement(astm.@NonNull Statement object) {
		return visitGASTMSyntaxObject(object);
	}

	@Override
	public R visitStorageSpecification(astm.@NonNull StorageSpecification object) {
		return visiting(object);
	}

	@Override
	public R visitString(astm.@NonNull String object) {
		return visitPrimitiveType(object);
	}

	@Override
	public R visitStringLiteral(astm.@NonNull StringLiteral object) {
		return visitLiteral(object);
	}

	@Override
	public R visitStructureType(astm.@NonNull StructureType object) {
		return visitAggregateType(object);
	}

	@Override
	public R visitSubtract(astm.@NonNull Subtract object) {
		return visitBinaryOperator(object);
	}

	@Override
	public R visitSwitchCase(astm.@NonNull SwitchCase object) {
		return visitOtherSyntaxObject(object);
	}

	@Override
	public R visitSwitchStatement(astm.@NonNull SwitchStatement object) {
		return visitStatement(object);
	}

	@Override
	public R visitTerminateStatement(astm.@NonNull TerminateStatement object) {
		return visitStatement(object);
	}

	@Override
	public R visitThrowStatement(astm.@NonNull ThrowStatement object) {
		return visitStatement(object);
	}

	@Override
	public R visitTryStatement(astm.@NonNull TryStatement object) {
		return visitStatement(object);
	}

	@Override
	public R visitType(astm.@NonNull Type object) {
		return visitGASTMSyntaxObject(object);
	}

	@Override
	public R visitTypeDefinition(astm.@NonNull TypeDefinition object) {
		return visitDefinitionObject(object);
	}

	@Override
	public R visitTypeQualifiedIdentifierReference(astm.@NonNull TypeQualifiedIdentifierReference object) {
		return visitNameReference(object);
	}

	@Override
	public R visitTypeReference(astm.@NonNull TypeReference object) {
		return visitType(object);
	}

	@Override
	public R visitTypesCatchBlock(astm.@NonNull TypesCatchBlock object) {
		return visitCatchBlock(object);
	}

	@Override
	public R visitUnaryExpression(astm.@NonNull UnaryExpression object) {
		return visitExpression(object);
	}

	@Override
	public R visitUnaryOperator(astm.@NonNull UnaryOperator object) {
		return visitOperator(object);
	}

	@Override
	public R visitUnaryPlus(astm.@NonNull UnaryPlus object) {
		return visitUnaryOperator(object);
	}

	@Override
	public R visitUnionType(astm.@NonNull UnionType object) {
		return visitAggregateType(object);
	}

	@Override
	public R visitUnnamedTypeReference(astm.@NonNull UnnamedTypeReference object) {
		return visitTypeReference(object);
	}

	@Override
	public R visitVariableCatchBlock(astm.@NonNull VariableCatchBlock object) {
		return visitCatchBlock(object);
	}

	@Override
	public R visitVariableDeclaration(astm.@NonNull VariableDeclaration object) {
		return visitDeclaration(object);
	}

	@Override
	public R visitVariableDefinition(astm.@NonNull VariableDefinition object) {
		return visitDataDefinition(object);
	}

	@Override
	public R visitVirtual(astm.@NonNull Virtual object) {
		return visitVirtualSpecification(object);
	}

	@Override
	public R visitVirtualSpecification(astm.@NonNull VirtualSpecification object) {
		return visitOtherSyntaxObject(object);
	}

	@Override
	public R visitVoid(astm.@NonNull Void object) {
		return visitPrimitiveType(object);
	}

	@Override
	public R visitWhileStatement(astm.@NonNull WhileStatement object) {
		return visitLoopStatement(object);
	}

	@Override
	public R visitWideCharacter(astm.@NonNull WideCharacter object) {
		return visitPrimitiveType(object);
	}
}
