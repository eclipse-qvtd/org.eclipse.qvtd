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
package org.eclipse.qvtd.debug.ui.actions;

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

    public static String QVTOBreakpointPage_CancelBreakpointCreationError;
    public static String QVTOBreakpointPage_CreateBreakpointForModule;
    public static String QVTOBreakpointPage_Enabled;
    public static String QVTOBreakpointPage_HitCount;
    public static String QVTOBreakpointPage_HitCountErrorMessage;
    public static String QVTOBreakpointPage_Module;
    public static String QVTOBreakpointPage_ModulePrepareBreakpoint;

	public static String QVTODebugModelPresentation_Running;

	public static String QVTODebugModelPresentation_Suspended;

	public static String QVTODebugModelPresentation_ThreadLabel;

	public static String QVTODebugModelPresentation_TransformationLabel;

    public static String QVTOToggleBreakpointAdapter_VerifyBreakpointJob;
	public static String QVTOToggleBreakpointAdapter_CannotSetBreakpoint;
	
	public static String QVTOLineBreakpointPage_ConditionTrue;
    public static String QVTOLineBreakpointPage_ConditionValueChange;
    public static String QVTOLineBreakpointPage_EnableCondition;
    public static String QVTOLineBreakpointPage_LineBreakpoint;
    public static String QVTOLineBreakpointPage_LineNumber;
    public static String QVTOLineBreakpointPage_SuspendCondition;

	public static String QVTOMainTab_mustRunAsQVTApp;

	public static String QVTORunToLineAdapter_invalidLocation;

	public static String QVTORunToLineAdapter_runFailed;
 
	public static String QVTORunToLineAdapter_NoFile;
	public static String QVTORunToLineAdapter_NoDocument;
	public static String QVTORunToLineAdapter_NoInput;
	
    public static String BreakpointCondErrorHandler_EditConditionButtonLabel;
    public static String BreakpointCondErrorHandler_DialogTitle;

	public static String ModifiedSourceFileHandler_HotReplaceNotSupported;

	public static String ModifiedSourceFileHandler_ModifiedDebuggedSource;
    
    public static String QVTOBreakpointProperties_RulerActionLabel;
}
