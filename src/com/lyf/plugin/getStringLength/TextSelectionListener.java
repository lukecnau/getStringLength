package com.lyf.plugin.getStringLength;

import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;


public class TextSelectionListener implements ISelectionListener {
	private IEditorSelectionInfo callback;
	
	public TextSelectionListener() {
		
	}
	
	public void setCallback( IEditorSelectionInfo callback ) {
		this.callback = callback;
	}
	
	@Override
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		
		if ( selection instanceof ITextSelection ) {
			if ( this.callback != null )
				callback.updateSelection((ITextSelection) selection);
		}
	}

}
