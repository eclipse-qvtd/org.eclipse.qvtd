/*******************************************************************************
 * Copyright (c) 2014, 2015 The University of York and Willink Transformations.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Horacio Hoyos - initial API and implementation
 ******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvtr2qvtc.impl;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.qvtd.compiler.internal.qvtr2qvtc.QvtrToQvtcTransformation;
import org.eclipse.qvtd.pivot.qvtbase.QVTbaseFactory;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtrelation.RelationalTransformation;

public class RelationalTransformationToMappingTransformation
{	
	private class SubRecord 
	{		
		// Relations
	//	@NonNull public TypedModel rtm;
		@NonNull public String tmn;
		@NonNull public List<org.eclipse.ocl.pivot.Package> up;
		
		// Core
		@Nullable public TypedModel mtm;
		
		public SubRecord(@NonNull TypedModel rtm, @NonNull String tmn, @NonNull List<org.eclipse.ocl.pivot.Package> up) {
	//		this.rtm = rtm;
			this.tmn = tmn;
			this.up = up;
		}
	}
	 
	protected final @NonNull QvtrToQvtcTransformation qvtr2qvtc;

	public RelationalTransformationToMappingTransformation(@NonNull QvtrToQvtcTransformation qvtr2qvtc) {
		this.qvtr2qvtc = qvtr2qvtc;
	}
	
	public @NonNull Transformation doRelationalTransformationToMappingTransformation(@NonNull RelationalTransformation rt) {
		@NonNull List<@NonNull SubRecord> subRecords = new ArrayList<@NonNull SubRecord>();
		// check
		String rtn = rt.getName();
		org.eclipse.ocl.pivot.Package p = qvtr2qvtc.getTracePackage(rt);
		assert p != null;
		for (TypedModel rtm : rt.getModelParameter()) {
			@NonNull List<org.eclipse.ocl.pivot.Package> usedPackage = rtm.getUsedPackage();
			String tmn = rtm.getName();
			assert tmn != null;
			subRecords.add(new SubRecord(rtm, tmn, usedPackage));
		}
		// instantiateOutput() {
		Transformation mt = QVTbaseFactory.eINSTANCE.createTransformation();
		mt.setName(rtn);
		qvtr2qvtc.putCoreTransformation(rt, mt);
		// One TypeModel for the middle model
		TypedModel mmtm =  QVTbaseFactory.eINSTANCE.createTypedModel();
		for (SubRecord subRecord : subRecords) {
			TypedModel mtm =  QVTbaseFactory.eINSTANCE.createTypedModel();
			subRecord.mtm = mtm;
		}
		// setAttributes
		mmtm.setName("");
		mmtm.getUsedPackage().add(p);
		mt.getModelParameter().add(mmtm);
		for (SubRecord subRecord : subRecords) {
			TypedModel mtm = subRecord.mtm;
			assert mtm != null;
			mtm.setName(subRecord.tmn);
			mtm.getUsedPackage().addAll(subRecord.up);
			mt.getModelParameter().add(mtm);
		}
		return mt;
	}
}
