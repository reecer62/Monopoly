package com.example.reece.hackupstatex.error_dialogs;

import android.app.*;
import android.content.DialogInterface;
import android.os.Bundle;

/**
 * Created by honey on 11/4/2017.
 */

public class FieldIncorrectDialogFragment extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle davedInstanceState) {
        System.out.println("we made it!");
        AlertDialog.Builder builder = new AlertDialog.Builder((getActivity()));
        builder.setMessage("A field was not filled out properly.")
                .setNegativeButton("Close", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id){}
                });
        return builder.create();
    }
}
