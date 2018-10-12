package org.ieeedtu.ieee_dtu.HomeFragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.GridLayoutManager;
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
public class SIGsFragment extends Fragment {
    String[] topic = {
            "Android", "ML", "Robotics", "Embedded", "Web Dev", "Graphic Design", "Data Science", "CurrentX", "Basic Programming", "DS Algo", "SolidWorks"
    };
    String[] time_from = {
            "5 PM", "5 PM", "5 PM", "5 PM", "5 PM", "5 PM", "5 PM", "5 PM", "5 PM", "5 PM", "5 PM",
    };
    String[] time_to = {
            "7 PM", "7 PM", "7 PM", "7 PM", "7 PM", "7 PM", "7 PM", "7 PM", "7 PM", "7 PM", "7 PM",
    };

    public SIGsFragment() {
        // Required empty public constructor
    }
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_sigs, container, false);

        ArrayList<SIG> sigs = new ArrayList<>();

        SIG sig = new SIG();
        for (int i = 0; i < topic.length; i++) {
            sig.setFrom(time_from[i]);
            sig.setTo(time_to[i]);
            sig.setTopic(topic[i]);
            sigs.add(sig);
            Log.e("SIG-", sig.getTopic());
        }

        recyclerView =v.findViewById(R.id.rv_sig) ;
        adapter = new SIGAdapter(sigs) ;
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);

        return v;

    }

}

class SIGAdapter extends RecyclerView.Adapter<SIGAdapter.SIGHolder> {
    private ArrayList<SIG> sig;

    public SIGAdapter(ArrayList<SIG> sig) {
        this.sig = sig;
    }

    @Override
    public SIGHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new SIGHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_sig_recycler, parent, false));
    }

    @Override
    public void onBindViewHolder(SIGHolder holder, int position) {


        holder.tv_topic.setText(sig.get(position).getTopic());
        holder.tv_from.setText(sig.get(position).getFrom());
        holder.tv_to.setText(sig.get(position).getTo());
    }


    @Override
    public int getItemCount() {

        return sig.size();

    }

    public class SIGHolder extends RecyclerView.ViewHolder {
        TextView tv_topic, tv_from, tv_to;

        public SIGHolder(View itemView) {
            super(itemView);
            tv_topic = (TextView) itemView.findViewById(R.id.tv_sig_topic);
            tv_from = (TextView) itemView.findViewById(R.id.tv_sig_from);
            tv_to = (TextView) itemView.findViewById(R.id.tv_sig_to);

        }
    }


}

