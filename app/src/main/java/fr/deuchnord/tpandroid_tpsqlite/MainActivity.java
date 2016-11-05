package fr.deuchnord.tpandroid_tpsqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        refreshList();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mainmenu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch(item.getItemId())
        {
            case R.id.addStudent:
                return callAddStudentActivity();

            default:
                return false;
        }
    }

    protected boolean callAddStudentActivity()
    {
        Intent intent = new Intent(this, NewStudentActivity.class);
        startActivityForResult(intent, 1);

        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if(resultCode == RESULT_OK)
        {
            refreshList();
        }
    }

    public void refreshList()
    {
        StudentDb studentDb = new StudentDb(getApplicationContext());
        List<String> students = studentDb.getStudents();

        String[] studentNames = new String[students.size()];
        students.toArray(studentNames);
        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, android.R.id.text1, studentNames);
        ((ListView) findViewById(R.id.studentsList)).setAdapter(adapter);
    }
}
