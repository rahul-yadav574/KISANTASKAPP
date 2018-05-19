package in.evolve.kisantaskapp.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import in.evolve.kisantaskapp.Db.DbHelper;
import in.evolve.kisantaskapp.R;

public class AddNewTask extends AppCompatActivity {


    private EditText newTaskName;
    private Button addTaskButton;
    private Button showListButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_task);

        newTaskName = (EditText) findViewById(R.id.new_task_text);
        addTaskButton = (Button) findViewById(R.id.btn_add_new_task);
        showListButton = (Button) findViewById(R.id.show_task_list);

        final DbHelper helper  = new DbHelper(AddNewTask.this);

        addTaskButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(newTaskName.getText().toString().trim().length()==0){
                    Toast.makeText(AddNewTask.this,"Enter Valid Task Name",Toast.LENGTH_LONG).show();
                }else{
                    helper.addNewTaskToDb(newTaskName.getText().toString());
                    Toast.makeText(AddNewTask.this,"Task Added To List",Toast.LENGTH_LONG).show();

                }

            }
        });

        showListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent listIntent = new Intent(AddNewTask.this,TasksList.class);
                startActivity(listIntent);
            }
        });


    }
}
