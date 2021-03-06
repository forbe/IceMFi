package com.og.filemanager.dialogs;

import com.og.filemanager.util.UIUtils;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

public class OverwriteFileDialog extends DialogFragment {
	
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		return new AlertDialog.Builder(getActivity())
				.setInverseBackgroundForced(UIUtils.shouldDialogInverseBackground(getActivity()))
				.setTitle(com.og.filemanager.R.string.file_exists)
				.setMessage(com.og.filemanager.R.string.overwrite_question)
				.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								((Overwritable) getTargetFragment()).overwrite();
							}
						}).setNegativeButton(android.R.string.cancel, null)
				.create();
	}
	
	public interface Overwritable {
		public void overwrite();
	}
}