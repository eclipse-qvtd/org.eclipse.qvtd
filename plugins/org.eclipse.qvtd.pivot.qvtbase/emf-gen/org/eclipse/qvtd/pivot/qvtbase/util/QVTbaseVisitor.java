/**
 * <copyright>
 *
 * Copyright (c) 2010,2011 E.D.Willink and others.
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
 * This code is auto-generated
 * from: /org.eclipse.qvtd.pivot.qvtbase/model/QVTbase.ecore
 * by: org.eclipse.ocl.examples.build.acceleo.GenerateVisitor
 * defined by: org.eclipse.ocl.examples.build.acceleo.generateVisitors.mtl
 * invoked by: org.eclipse.ocl.examples.build.utilities.*
 * from: org.eclipse.ocl.examples.build.*.mwe2
 *
 * Do not edit it.
 *
 * $Id$
 */
package	org.eclipse.qvtd.pivot.qvtbase.util;

/**
 */
public interface QVTbaseVisitor<R> extends org.eclipse.ocl.examples.pivot.util.Visitor<R>
{
	R visitBaseModel(org.eclipse.qvtd.pivot.qvtbase.BaseModel object);
	R visitDomain(org.eclipse.qvtd.pivot.qvtbase.Domain object);
	R visitFunction(org.eclipse.qvtd.pivot.qvtbase.Function object);
	R visitFunctionParameter(org.eclipse.qvtd.pivot.qvtbase.FunctionParameter object);
	R visitPattern(org.eclipse.qvtd.pivot.qvtbase.Pattern object);
	R visitPredicate(org.eclipse.qvtd.pivot.qvtbase.Predicate object);
	R visitRule(org.eclipse.qvtd.pivot.qvtbase.Rule object);
	R visitTransformation(org.eclipse.qvtd.pivot.qvtbase.Transformation object);
	R visitTypedModel(org.eclipse.qvtd.pivot.qvtbase.TypedModel object);
	R visitUnit(org.eclipse.qvtd.pivot.qvtbase.Unit object);
}
