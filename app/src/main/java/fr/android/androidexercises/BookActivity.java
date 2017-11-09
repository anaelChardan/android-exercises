package fr.android.androidexercises;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Date;

public class BookActivity extends AppCompatActivity {

    public static final String BOOK = "BOOK";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        Intent intent = getIntent();
        Book book = intent.getParcelableExtra(BOOK);

        TextView authorTextView = (TextView) findViewById(R.id.authorTextView);
        authorTextView.setText(book.getAuthor());

        TextView nameTextView = (TextView) findViewById(R.id.nameTextView);
        nameTextView.setText(book.getName());

        Button openButton = (Button) findViewById(R.id.buyTheBookOn);

        openButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(BookActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, final int year, final int month, final int dayOfMonth) {
                        new TimePickerDialog(BookActivity.this, new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                Toast.makeText(BookActivity.this, dayOfMonth + "/" + month + "/" + year + " " + hourOfDay + ":" + minute, Toast.LENGTH_LONG).show();
                            }
                        }, 12, 0, true).show();
                    }
                }, 2017, 10, 9).show();
            }
        });
    }

}
