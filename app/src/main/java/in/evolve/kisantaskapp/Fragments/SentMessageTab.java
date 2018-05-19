package in.evolve.kisantaskapp.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Collections;
import java.util.List;

import in.evolve.kisantaskapp.Adapters.ContactsListAdapter;
import in.evolve.kisantaskapp.Adapters.SentMessagesAdapter;
import in.evolve.kisantaskapp.Db.DbHelper;
import in.evolve.kisantaskapp.Models.Message;
import in.evolve.kisantaskapp.R;

public class SentMessageTab extends Fragment {

    private RecyclerView sentMessagesRecyclerView;
    private SentMessagesAdapter sentMessagesAdapter;

    public SentMessageTab() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View fragmentView = inflater.inflate(R.layout.fragment_sent_messages, container, false);

        sentMessagesRecyclerView = (RecyclerView) fragmentView.findViewById(R.id.send_messages_recycler_view);
        sentMessagesRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        DbHelper dbHelper  = new DbHelper(getActivity());


        return fragmentView;}
}
