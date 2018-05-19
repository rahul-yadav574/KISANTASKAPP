package in.evolve.kisantaskapp.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import in.evolve.kisantaskapp.Adapters.ContactsListAdapter;
import in.evolve.kisantaskapp.Models.Contact;
import in.evolve.kisantaskapp.R;

public class ContactsTab extends Fragment {

    private RecyclerView contactsRecyclerView;
    private ContactsListAdapter contactsListAdapter;

    public ContactsTab() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View fragmentView = inflater.inflate(R.layout.fragment_contacts_list, container, false);

        contactsRecyclerView = (RecyclerView) fragmentView.findViewById(R.id.contact_list_recycler_view);
        contactsRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        contactsListAdapter = new ContactsListAdapter(getActivity(),getContactsList());
        contactsRecyclerView.setAdapter(contactsListAdapter);

        return fragmentView;
    }

    private List<Contact> getContactsList(){

        List<Contact> contacts = new ArrayList<>();
        contacts.add(new Contact("Kisan","Number","+919971792703"));
        contacts.add(new Contact("Rahul","Yadav","+918295542986"));
        contacts.add(new Contact("Pawan","Yadav","+919050567809"));
        contacts.add(new Contact("Randeep","Yadav","+917982835844"));
        contacts.add(new Contact("Ekta","Varshney","+919599431755"));

        return contacts;
    }
}
