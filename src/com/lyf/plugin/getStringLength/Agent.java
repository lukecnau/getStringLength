package com.lyf.plugin.getStringLength;

import org.eclipse.ui.IWorkbenchWindow;


public class Agent {

	private final ViewSelectionListener myviewListener = new ViewSelectionListener();
	private final TextSelectionListener mytextlistener = new TextSelectionListener();

	private boolean is_started = false;

	IWorkbenchWindow window;

	public Agent(SelectedTextInfoControlContribution callback) {
		if (callback == null)
			throw new IllegalArgumentException("Please provide a callback.");

		myviewListener.setCallback(callback);
		mytextlistener.setCallback(callback);
		
	}

	
	public void start(IWorkbenchWindow window) {
		if (!is_started && window != null) {
			is_started = true;
			this.window = window;

			window.getPartService().addPartListener(myviewListener);
			window.getSelectionService().addPostSelectionListener(
					mytextlistener);
			
		}
	}

	public void stop() {
		if (is_started && window != null) {
			// Remove listeners.
			window.getSelectionService().removePostSelectionListener(mytextlistener);
			window.getPartService().removePartListener(myviewListener);

			window = null;
			is_started = false;
		}
	}
}
