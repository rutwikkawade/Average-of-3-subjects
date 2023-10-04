package com.example.testtwo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText editTextName, editTextSubject1, editTextSubject2, editTextSubject3;
    Spinner spinnerCourses;
    Button btnSubmit;
    TextView textViewResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = findViewById(R.id.editTextName);
        editTextSubject1 = findViewById(R.id.editTextSubject1);
        editTextSubject2 = findViewById(R.id.editTextSubject2);
        editTextSubject3 = findViewById(R.id.editTextSubject3);
        spinnerCourses = findViewById(R.id.spinnerCourses);
        btnSubmit = findViewById(R.id.btnSubmit);
        textViewResult = findViewById(R.id.textViewResult);

        // Set up the spinner with the array of courses
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.courses,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCourses.setAdapter(adapter);

        // Spinner item selection listener
        spinnerCourses.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // Handle selection (if needed)
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Do nothing here
            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculatePercentage();
            }
        });
    }

    private void calculatePercentage() {
        try {
            String studentName = editTextName.getText().toString();
            String selectedCourse = spinnerCourses.getSelectedItem().toString();
            double subject1Marks = Double.parseDouble(editTextSubject1.getText().toString());
            double subject2Marks = Double.parseDouble(editTextSubject2.getText().toString());
            double subject3Marks = Double.parseDouble(editTextSubject3.getText().toString());

            double totalMarks = subject1Marks + subject2Marks + subject3Marks;
            double percentage = (totalMarks / 3.0);

            // Display the result
            String resultMessage = String.format("%s, %s\nटक्केवारी: %.2f%%", studentName, selectedCourse, percentage);
            textViewResult.setText(resultMessage);
        } catch (NumberFormatException e) {
            textViewResult.setText("Please enter valid marks for all subjects.");
        }
    }
}