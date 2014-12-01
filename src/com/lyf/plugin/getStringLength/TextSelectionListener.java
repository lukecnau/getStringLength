package com.lyf.plugin.getStringLength;

import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;


public class TextSelectionListener implements ISelectionListener {
	private SelectedTextInfoControlContribution callback;
	
	public TextSelectionListener() {
		
	}
	
	public void setCallback( SelectedTextInfoControlContribution callback ) {
		this.callback = callback;
	}
	
	@Override
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		
		if ( selection instanceof ITextSelection ) {
			ITextSelection t = (ITextSelection) selection;
			if ( this.callback != null )
				callback.updateLength(t.getLength());
		}
	}

}
