package in.evolve.kisantaskapp.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import in.evolve.kisantaskapp.Adapters.TaskListAdapter;
import in.evolve.kisantaskapp.Db.DbHelper;
import in.evolve.kisantaskapp.Models.Task;
import in.evolve.kisantaskapp.R;

public class TasksList extends AppCompatActivity {

    private RecyclerView taskRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks_list);

        taskRecyclerView = (RecyclerView) findViewById(R.id.task_list_view);
        taskRecyclerView.setLayoutManager(new LinearLayoutManager(TasksList.this));

        DbHelper helper = new DbHelper(TasksList.this);

        List<Task> arr = helper.retrieveListFromDb();
        TaskListAdapter adapter = new TaskListAdapter(arr,TasksList.this);
        taskRecyclerView.setAdapter(adapter);
    }
}
