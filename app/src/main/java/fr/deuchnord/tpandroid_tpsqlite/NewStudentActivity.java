package fr.deuchnord.tpandroid_tpsqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class NewStudentActivity extends AppCompatActivity implements View.OnClickListener
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_student);

        findViewById(R.id.saveButton).setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
        if(view.getId() == R.id.saveButton)
        {
            EditText nameField = (EditText) findViewById(R.id.studentName);

            if(nameField.getText().toString().equals(""))
                Toast.makeText(this, getString(R.string.student_cant_be_void), Toast.LENGTH_SHORT).show();
            else
            {
                StudentDb studentDb = new StudentDb(getApplicationContext());

                long id = studentDb.putStudent(nameField.getText().toString());
                Toast.makeText(getApplicationContext(), "New ID: " + id, Toast.LENGTH_SHORT).show();

                setResult(RESULT_OK);
                finish();
            }
        }
    }
}
