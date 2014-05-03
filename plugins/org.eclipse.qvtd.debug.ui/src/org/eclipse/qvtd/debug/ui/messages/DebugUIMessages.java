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
package org.eclipse.qvtd.debug.ui.messages;

import org.eclipse.osgi.util.NLS;

public class DebugUIMessages
{
	static {
		NLS.initializeMessages(DebugUIMessages.class.getName(), DebugUIMessages.class);
	}

	public static String StatusDialog_Error;
    public static String StatusDialog_Warning;
    public static String StatusDialog_Information;

    public static String BreakpointConditionEditor_EnterCondition;

    public static String QVTiBreakpointPage_CancelBreakpointCreationError;
    public static String QVTiBreakpointPage_CreateBreakpointForModule;
    public static String QVTiBreakpointPage_Enabled;
    public static String QVTiBreakpointPage_HitCount;
    public static String QVTiBreakpointPage_HitCountErrorMessage;
    public static String QVTiBreakpointPage_Module;
    public static String QVTiBreakpointPage_ModulePrepareBreakpoint;

	public static String QVTiDebugModelPresentation_Running;

	public static String QVTiDebugModelPresentation_Suspended;

	public static String QVTiDebugModelPresentation_ThreadLabel;

	public static String QVTiDebugModelPresentation_TransformationLabel;

    public static String QVTiToggleBreakpointAdapter_VerifyBreakpointJob;
	public static String QVTiToggleBreakpointAdapter_CannotSetBreakpoint;
	
	public static String QVTiLineBreakpointPage_ConditionTrue;
    public static String QVTiLineBreakpointPage_ConditionValueChange;
    public static String QVTiLineBreakpointPage_EnableCondition;
    public static String QVTiLineBreakpointPage_LineBreakpoint;
    public static String QVTiLineBreakpointPage_LineNumber;
    public static String QVTiLineBreakpointPage_SuspendCondition;

	public static String QVTiMainTab_mustRunAsQVTApp;

	public static String QVTiRunToLineAdapter_invalidLocation;

	public static String QVTiRunToLineAdapter_runFailed;
 
	public static String QVTiRunToLineAdapter_NoFile;
	public static String QVTiRunToLineAdapter_NoDocument;
	public static String QVTiRunToLineAdapter_NoInput;
	
    public static String BreakpointCondErrorHandler_EditConditionButtonLabel;
    public static String BreakpointCondErrorHandler_DialogTitle;

	public static String ModifiedSourceFileHandler_HotReplaceNotSupported;

	public static String ModifiedSourceFileHandler_ModifiedDebuggedSource;
    
    public static String QVTiBreakpointProperties_RulerActionLabel;
}
