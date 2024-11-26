package com.example.spinnerteacherappnew;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    String[][] classes = {
            {"Alice", "Bob", "Charlie", "Diana", "Ethan", "Fiona", "George", "Hannah", "Ian", "Julia"}, // Class 1
            {"Kevin", "Laura", "Michael", "Nina", "Oliver", "Paula", "Quincy", "Rachel", "Sam", "Tina"}, // Class 2
            {"Uma", "Victor", "Wendy", "Xander", "Yvonne", "Zach", "Ava", "Ben", "Clara", "Daniel"},     // Class 3
            {"Ella", "Frank", "Grace", "Henry", "Ivy", "Jack", "Karen", "Leo", "Mona", "Nate"}          // Class 4
    };

    String[][] lastNames = {
            {"Smith", "Johnson", "Brown", "Taylor", "Anderson", "Thomas", "Jackson", "White", "Harris", "Martin"}, // Class 1
            {"Clark", "Lewis", "Walker", "Hall", "Allen", "Young", "Hernandez", "King", "Wright", "Lopez"},        // Class 2
            {"Hill", "Scott", "Green", "Adams", "Baker", "Gonzalez", "Nelson", "Carter", "Mitchell", "Perez"},    // Class 3
            {"Roberts", "Phillips", "Campbell", "Parker", "Evans", "Edwards", "Collins", "Stewart", "Sanchez", "Morris"} // Class 4
    };

    String[][] birthDates = {
            {"01/01/2005", "15/03/2004", "22/06/2005", "30/08/2004", "12/12/2005", "05/05/2004", "14/02/2005", "18/07/2004", "25/09/2005", "10/10/2004"}, // Class 1
            {"03/02/2004", "20/04/2005", "13/06/2004", "07/08/2005", "29/12/2004", "16/05/2005", "01/09/2004", "11/11/2005", "08/03/2004", "23/07/2005"}, // Class 2
            {"09/01/2005", "26/03/2004", "19/06/2005", "04/08/2004", "30/12/2005", "21/05/2004", "17/02/2005", "28/07/2004", "12/09/2005", "02/10/2004"}, // Class 3
            {"15/01/2004", "03/04/2005", "25/06/2004", "14/08/2005", "07/12/2004", "22/05/2005", "06/09/2004", "19/11/2005", "31/03/2004", "13/07/2005"}  // Class 4
    };

    String[][] phoneNumbers = {
            {"050-1111111", "050-2222222", "050-3333333", "050-4444444", "050-5555555", "050-6666666", "050-7777777", "050-8888888", "050-9999999", "050-1010101"}, // Class 1
            {"052-1111111", "052-2222222", "052-3333333", "052-4444444", "052-5555555", "052-6666666", "052-7777777", "052-8888888", "052-9999999", "052-1010101"}, // Class 2
            {"053-1111111", "053-2222222", "053-3333333", "053-4444444", "053-5555555", "053-6666666", "053-7777777", "053-8888888", "053-9999999", "053-1010101"}, // Class 3
            {"054-1111111", "054-2222222", "054-3333333", "054-4444444", "054-5555555", "054-6666666", "054-7777777", "054-8888888", "054-9999999", "054-1010101"}  // Class 4
    };

    String[] classNumbers = {"Class 1", "Class 2", "Class 3", "Class 4"};

    ListView IV;
    Spinner spinner1;
    TextView lastNameTV;
    TextView firstNameTV;
    TextView birthDateTV;
    TextView phoneNumberTV;

    String[] currentClass = {};
    String[] currentLastNames = {};
    String[] currentBirthDates = {};
    String[] currentPhoneNumbers = {};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IV = findViewById(R.id.IV);

        spinner1 = findViewById(R.id.spinner1);

        spinner1.setOnItemSelectedListener(this);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, classNumbers);
        spinner1.setAdapter(adapter);

        lastNameTV = findViewById(R.id.lastNameTV);

        firstNameTV = findViewById(R.id.firstNameTV);
        birthDateTV = findViewById(R.id.birthDateTV);
        phoneNumberTV = findViewById(R.id.phoneNumberTV);




        IV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                firstNameTV.setText(currentClass[position]);
                lastNameTV.setText(currentLastNames[position]);
                birthDateTV.setText(currentBirthDates[position]);
                phoneNumberTV.setText(currentPhoneNumbers[position]);
            }

        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        currentClass=classes[position];
        currentLastNames=lastNames[position];
        currentBirthDates=birthDates[position];
        currentPhoneNumbers=phoneNumbers[position];

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, currentClass);
        IV.setAdapter(adapter);

        firstNameTV.setText("");
        lastNameTV.setText("");
        birthDateTV.setText("");
        phoneNumberTV.setText("");
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }



}
