package org.ieeedtu.ieee_dtu.HomeFragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.ieeedtu.ieee_dtu.R;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class EventsFragments extends Fragment {

    String[] topic = {
            "Android", "ML", "Robotics", "Embedded", "Web Dev", "Graphic Design", "Data Science", "CurrentX", "Basic Programming", "DS Algo", "SolidWorks"
    };


    public EventsFragments() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_events, container, false);

        ArrayList<Events> events= new ArrayList<>();
        Events event = new Events();
        for (int i = 0; i < topic.length; i++) {
            event.setTopic(topic[i]);
            events.add(event);
            Log.e("_EVENTS", event.getTopic());
        }
        RecyclerView recyclerView = v.findViewById(R.id.rv_events);
        RecyclerView.Adapter adapter = new EventsAdapter(events);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);


        return v;
    }

}

class EventsAdapter extends RecyclerView.Adapter<EventsAdapter.EventHolder> {
    private ArrayList<Events> events;

    EventsAdapter(ArrayList<Events> events) {
        this.events = events;
    }

    @NonNull
    @Override
    public EventHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new EventHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_event_recycler, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull EventHolder holder, int position) {
        holder.tv_topic.setText(events.get(position).getTopic());
    }


    @Override
    public int getItemCount() {

        return events.size();
    }

    class EventHolder extends RecyclerView.ViewHolder {
        TextView tv_topic;

        EventHolder(View itemView) {
            super(itemView);
            tv_topic = (TextView) itemView.findViewById(R.id.tv_eve_topic);
        }
    }


}

