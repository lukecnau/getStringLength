package com.lyf.plugin.getStringLength;

public interface IEditorFocusInfo {
	/**
	 * Method that notifies of a change in the focus 
	 * on editor views inside the workbench window.
	 * 
	 * @param focused true if an editor is focused, false otherwise 
	 */
	public void updateFocus(final boolean focused);
}
