package in.evolve.kisantaskapp.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import in.evolve.kisantaskapp.Activity.DetailsActivity;
import in.evolve.kisantaskapp.Models.Contact;
import in.evolve.kisantaskapp.R;

public class ContactsListAdapter extends RecyclerView.Adapter<ContactsListAdapter.ContactListViewHolder> {


    private List<Contact> contactsList;
    private Context context;

    public ContactsListAdapter(Context context,List<Contact> contactsList) {
        this.contactsList = contactsList;
        this.context = context;
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @Override
    public ContactListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ContactListViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contact,parent,false));
    }

    @Override
    public void onBindViewHolder(final ContactListViewHolder holder, final int position) {

        holder.firstName.setText(contactsList.get(position).getFirstName());
        holder.lastName.setText(contactsList.get(position).getLastName());

        holder.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context,DetailsActivity.class);
                intent.putExtra("first",contactsList.get(position).getFirstName());
                intent.putExtra("last",contactsList.get(position).getLastName());
                intent.putExtra("phone",contactsList.get(position).getPhone());

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return contactsList.size();
    }

    class ContactListViewHolder extends RecyclerView.ViewHolder{

        private TextView firstName;
        private TextView lastName;
        private LinearLayout container;

        public ContactListViewHolder(View itemView) {
            super(itemView);

            container = (LinearLayout) itemView.findViewById(R.id.container);
            firstName = (TextView) itemView.findViewById(R.id.first_name);
            lastName  = (TextView) itemView.findViewById(R.id.last_name);
        }
    }
}
