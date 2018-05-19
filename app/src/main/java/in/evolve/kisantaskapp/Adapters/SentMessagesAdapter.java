package in.evolve.kisantaskapp.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import in.evolve.kisantaskapp.Models.Message;
import in.evolve.kisantaskapp.R;

public class SentMessagesAdapter extends RecyclerView.Adapter<SentMessagesAdapter.SentMessagesViewHolder>{


    private Context context;
    private List<Message> messages;
    public SentMessagesAdapter(Context context, List<Message>  messages) {
        this.context = context;
        this.messages = messages;
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @Override
    public SentMessagesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new SentMessagesViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sent_message,parent,false));

    }

    @Override
    public void onBindViewHolder(SentMessagesViewHolder holder, int position) {

        holder.name.setText(messages.get(position).getName());
        holder.time.setText(messages.get(position).getTime());
        holder.otp.setText(messages.get(position).getOtp());
    }

    @Override
    public int getItemCount() {
        return messages.size();
    }

    class SentMessagesViewHolder extends RecyclerView.ViewHolder{

        private TextView name;
        private TextView time;
        private TextView  otp;

        public SentMessagesViewHolder(View itemView) {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.name);
            time = (TextView) itemView.findViewById(R.id.time);
            otp = (TextView) itemView.findViewById(R.id.otp);
        }
    }
}
