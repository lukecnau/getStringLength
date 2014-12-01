package com.lyf.plugin.getStringLength;

import org.eclipse.ui.IWorkbenchWindow;


public class Agent {
	private TextSelectionListener mytextlistener = new TextSelectionListener();

	private boolean is_started = false;

	IWorkbenchWindow window;

	public Agent(SelectedTextInfoControlContribution callback) {
		if (callback == null)
			throw new IllegalArgumentException("Please provide a callback.");

		mytextlistener.setCallback(callback);
	}

	
	public void start(IWorkbenchWindow window) {
		if (!is_started) {
			if (window != null) {
				is_started = true;
				this.window = window;

				window.getSelectionService().addPostSelectionListener(
						mytextlistener);
			}
		}
	}

	public void stop() {
		if (is_started) {
			// Remove listeners.
			if (window != null) {
				window.getSelectionService().removePostSelectionListener(
						mytextlistener);

				window = null;
				is_started = false;
			}
		}
	}
}
