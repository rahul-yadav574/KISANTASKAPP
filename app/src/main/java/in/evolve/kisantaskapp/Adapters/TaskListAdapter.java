package in.evolve.kisantaskapp.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import in.evolve.kisantaskapp.Db.DbHelper;
import in.evolve.kisantaskapp.Models.Task;
import in.evolve.kisantaskapp.R;

public class TaskListAdapter extends RecyclerView.Adapter<TaskListAdapter.TaskListViewHolder> {


    private List<Task> taskList;
    private Context context;

    public TaskListAdapter(List<Task> taskList, Context context) {
        this.taskList = taskList;
        this.context = context;
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @Override
    public TaskListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new TaskListViewHolder(LayoutInflater.from(context).inflate(R.layout.item_task_list,parent,false));
    }

    @Override
    public void onBindViewHolder(final TaskListViewHolder holder, final int position) {


        holder.task_name.setText(taskList.get(position).getName());
        if (taskList.get(position).getCompleted().equals("0")){
            holder.completeTask.setVisibility(View.VISIBLE);
            holder.task_name.setTextColor(context.getResources().getColor(android.R.color.holo_red_dark));

        }else{
            holder.completeTask.setVisibility(View.GONE);
            holder.task_name.setTextColor(context.getResources().getColor(android.R.color.holo_green_dark));
        }

        holder.completeTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //change task status in database
                DbHelper helper = new DbHelper(context);
                helper.updateStatus(taskList.get(position).get_id());
                holder.completeTask.setVisibility(View.GONE);
                holder.task_name.setTextColor(context.getResources().getColor(android.R.color.holo_green_dark));
            }
        });
    }

    @Override
    public int getItemCount() {
        return taskList.size();
    }

    protected class TaskListViewHolder extends RecyclerView.ViewHolder{

        private TextView task_name;
        private Button completeTask;

        public TaskListViewHolder(View itemView) {
            super(itemView);

            task_name = (TextView)  itemView.findViewById(R.id.txt_task_name);
            completeTask = (Button) itemView.findViewById(R.id.btn_cmp_task);
        }
    }
}
