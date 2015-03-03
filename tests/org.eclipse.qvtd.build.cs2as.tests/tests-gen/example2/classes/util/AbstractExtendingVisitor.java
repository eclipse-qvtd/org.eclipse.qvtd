/*******************************************************************************
 * <copyright>
 * 
 * </copyright>
 *
 * This code is auto-generated
 * from: org.eclipse.qvtd.build.cs2as.tests/src/org/eclipse/qvtd/build/cs2as/tests/models/example2/Classes.genmodel
 *
 * Only the copyright statement is editable.
 *******************************************************************************/
package	example2.classes.util;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

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
	protected AbstractExtendingVisitor(@NonNull C context) {
		super(context);
	}	

	@Override
	public @Nullable R visitClass(@NonNull example2.classes.Class object) {
		return visitNamedElement(object);
	}

	@Override
	public @Nullable R visitElement(@NonNull example2.classes.Element object) {
		return visiting(object);
	}

	@Override
	public @Nullable R visitNamedElement(@NonNull example2.classes.NamedElement object) {
		return visitElement(object);
	}

	@Override
	public @Nullable R visitNamespace(@NonNull example2.classes.Namespace object) {
		return visitElement(object);
	}

	@Override
	public @Nullable R visitPackage(@NonNull example2.classes.Package object) {
		return visitNamedElement(object);
	}

	@Override
	public @Nullable R visitRoot(@NonNull example2.classes.Root object) {
		return visitElement(object);
	}
}
