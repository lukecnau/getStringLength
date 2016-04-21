package com.lyf.plugin.getStringLength;

import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IPartListener2;
import org.eclipse.ui.IWorkbenchPartReference;

/**
 * ViewSelectionListener that detects the currently open view 
 * inside the eclipse workbench window and update the IFocusInfo callback.
 * 
 * @author Alessio Pollero
 * @version 1.0
 */
final class ViewSelectionListener implements IPartListener2 {
	
	private IEditorFocusInfo callback;
	
	public void setCallback( IEditorFocusInfo callback ) {
		this.callback = callback;
	}
	
	@Override
	public void partVisible(IWorkbenchPartReference part) {
	}

	@Override
	public void partOpened(IWorkbenchPartReference part) {
	}

	@Override
	public void partInputChanged(IWorkbenchPartReference part) {
	}

	@Override
	public void partHidden(IWorkbenchPartReference part) {
	}

	@Override
	public void partDeactivated(IWorkbenchPartReference part) {
	}

	@Override
	public void partClosed(IWorkbenchPartReference part) {
	}

	@Override
	public void partBroughtToTop(IWorkbenchPartReference part) {
	}

	@Override
	public void partActivated(IWorkbenchPartReference part) {
		
		if(callback != null)
			callback.updateFocus(part instanceof IEditorReference);
		
	}
}