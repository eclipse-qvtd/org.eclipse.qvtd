/*******************************************************************************
 * <copyright>
 * 
 * </copyright>
 *
 * This code is auto-generated
 * from: org.eclipse.qvtd.doc.miniocl/model/MiniOCL.genmodel
 *
 * Only the copyright statement is editable.
 *******************************************************************************/
package	org.eclipse.qvtd.doc.miniocl.util;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface Visitor<R>
{
	/**
	 * Returns an object which is an instance of the given class
	 * associated with this object. Returns <code>null</code> if
	 * no such object can be found.
	 *
	 * @param adapter the adapter class to look up
	 * @return an object of the given class,
	 *    or <code>null</code> if this object does not
	 *    have an adapter for the given class
	 */
	@Nullable <A> A getAdapter(@NonNull Class<A> adapter);

	/**
	 * Return the result of visiting a visitable for which no more specific pivot type method
	 * is available.
	 */
	R visiting(org.eclipse.qvtd.doc.miniocl.util.@NonNull Visitable visitable);

	R visitBooleanLiteralExp(org.eclipse.qvtd.doc.miniocl.@NonNull BooleanLiteralExp object);
	R visitCallExp(org.eclipse.qvtd.doc.miniocl.@NonNull CallExp object);
	R visitClass(org.eclipse.qvtd.doc.miniocl.@NonNull Class object);
	R visitCollectionItem(org.eclipse.qvtd.doc.miniocl.@NonNull CollectionItem object);
	R visitCollectionLiteralExp(org.eclipse.qvtd.doc.miniocl.@NonNull CollectionLiteralExp object);
	R visitCollectionLiteralPart(org.eclipse.qvtd.doc.miniocl.@NonNull CollectionLiteralPart object);
	R visitCollectionRange(org.eclipse.qvtd.doc.miniocl.@NonNull CollectionRange object);
	R visitConstraint(org.eclipse.qvtd.doc.miniocl.@NonNull Constraint object);
	R visitElement(org.eclipse.qvtd.doc.miniocl.@NonNull Element object);
	R visitExpressionInOCL(org.eclipse.qvtd.doc.miniocl.@NonNull ExpressionInOCL object);
	R visitFeature(org.eclipse.qvtd.doc.miniocl.@NonNull Feature object);
	R visitImport(org.eclipse.qvtd.doc.miniocl.@NonNull Import object);
	R visitIntegerLiteralExp(org.eclipse.qvtd.doc.miniocl.@NonNull IntegerLiteralExp object);
	R visitIterateExp(org.eclipse.qvtd.doc.miniocl.@NonNull IterateExp object);
	R visitIteratorExp(org.eclipse.qvtd.doc.miniocl.@NonNull IteratorExp object);
	R visitLetExp(org.eclipse.qvtd.doc.miniocl.@NonNull LetExp object);
	R visitLiteralExp(org.eclipse.qvtd.doc.miniocl.@NonNull LiteralExp object);
	R visitLoopExp(org.eclipse.qvtd.doc.miniocl.@NonNull LoopExp object);
	R visitNamedElement(org.eclipse.qvtd.doc.miniocl.@NonNull NamedElement object);
	R visitNamespace(org.eclipse.qvtd.doc.miniocl.@NonNull Namespace object);
	R visitNullLiteralExp(org.eclipse.qvtd.doc.miniocl.@NonNull NullLiteralExp object);
	R visitOCLExpression(org.eclipse.qvtd.doc.miniocl.@NonNull OCLExpression object);
	R visitOpaqueExpression(org.eclipse.qvtd.doc.miniocl.@NonNull OpaqueExpression object);
	R visitOperation(org.eclipse.qvtd.doc.miniocl.@NonNull Operation object);
	R visitOperationCallExp(org.eclipse.qvtd.doc.miniocl.@NonNull OperationCallExp object);
	R visitPackage(org.eclipse.qvtd.doc.miniocl.@NonNull Package object);
	R visitParameter(org.eclipse.qvtd.doc.miniocl.@NonNull Parameter object);
	R visitPrimitiveLiteralExp(org.eclipse.qvtd.doc.miniocl.@NonNull PrimitiveLiteralExp object);
	R visitProperty(org.eclipse.qvtd.doc.miniocl.@NonNull Property object);
	R visitPropertyCallExp(org.eclipse.qvtd.doc.miniocl.@NonNull PropertyCallExp object);
	R visitRoot(org.eclipse.qvtd.doc.miniocl.@NonNull Root object);
	R visitTypedElement(org.eclipse.qvtd.doc.miniocl.@NonNull TypedElement object);
	R visitVariable(org.eclipse.qvtd.doc.miniocl.@NonNull Variable object);
	R visitVariableExp(org.eclipse.qvtd.doc.miniocl.@NonNull VariableExp object);
}
