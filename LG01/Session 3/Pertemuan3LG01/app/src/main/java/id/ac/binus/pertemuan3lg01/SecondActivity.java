package id.ac.binus.pertemuan3lg01;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class SecondActivity extends AppCompatActivity {
    Spinner spinner;
    EditText datePicker;

    Button callAlert;

    AlertDialog.Builder dialogBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        spinner = findViewById(R.id.spinner);
        datePicker = findViewById(R.id.editTextDate);
        callAlert = findViewById(R.id.callAlertBtn);
        dialogBuilder = new AlertDialog.Builder(this);

        callAlert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogBuilder.setTitle("Alert");
                dialogBuilder.setMessage("This a message");
                dialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                dialogBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                AlertDialog dialog = dialogBuilder.create();
                dialog.show();
            }
        });

        datePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog dialog = new DatePickerDialog(SecondActivity.this);
                dialog.show();
            }
        });

        String selectedItem = spinner.getSelectedItem().toString();
    }
}