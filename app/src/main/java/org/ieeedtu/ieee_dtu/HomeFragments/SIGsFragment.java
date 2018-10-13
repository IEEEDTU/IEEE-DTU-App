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
import android.widget.LinearLayout;
import android.widget.TextView;

import org.ieeedtu.ieee_dtu.R;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


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



    // String arrays of mentors

    String [] anroid = {"Shivam Kumar","Kunal Farmah"};
    String [] ml = {"Shivam Kumar","Kunal Farmah"};
    String [] robotics = {"Shivam Kumar","Kunal Farmah"};
    String [] embed = {"Shivam Kumar","Kunal Farmah"};
    String [] web = {"Shivam Kumar","Kunal Farmah"};
    String [] gd = {"Shivam Kumar","Kunal Farmah"};
    String [] datas = {"Shivam Kumar","Kunal Farmah"};
    String [] cx = {"Shivam Kumar","Kunal Farmah"};
    String [] bp = {"Shivam Kumar","Kunal Farmah","Mentor3"};
    String [] dsa = {"Shivam Kumar","Kunal Farmah","Mentor4"};
    String [] solidworks = {"Shivam Kumar","Kunal Farmah"};



   ArrayList<String[]> mentors = new ArrayList<>();








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

        mentors.add(anroid);
        mentors.add(ml);
        mentors.add(robotics);
        mentors.add(embed);
        mentors.add(web);
        mentors.add(gd);
        mentors.add(datas);
        mentors.add(cx);
        mentors.add(bp);
        mentors.add(dsa);
        mentors.add(solidworks);


        ArrayList<SIG> sigs = new ArrayList<>();


        for (int i = 0; i < topic.length; i++) {

            SIG sig = new SIG();
            sig.setFrom(time_from[i]);
            sig.setTo(time_to[i]);
            sig.setTopic(topic[i]);
            // setting mentors names
            sig.setMentors(mentors.get(i));
            sigs.add(sig);
           // Log.e("SIG-", sig.getTopic());
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

    public String m1="",m2="",m3="";

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

        String [] mentors_ = sig.get(position).getMentors();
        extract_mentors(mentors_);

        holder.tv_mentor1.setText(m1);
        holder.tv_mentor2.setText(m2);

        if(!m3.equals("")){
            holder.tv_mentor3.setVisibility(View.VISIBLE);
            holder.tv_mentor3.setText(m3);
            holder.call3.setVisibility(View.VISIBLE);
        }
        if(m3.equals("")){
            holder.tv_mentor3.setVisibility(View.GONE);
            holder.call3.setVisibility(View.GONE);

        }
    }


    @Override
    public int getItemCount() {

        return sig.size();

    }

    public class SIGHolder extends RecyclerView.ViewHolder {
        TextView tv_topic, tv_from, tv_to, tv_mentor1,tv_mentor2,tv_mentor3;
        LinearLayout call3;

        public SIGHolder(View itemView) {
            super(itemView);
            tv_topic = (TextView) itemView.findViewById(R.id.tv_sig_topic);
            tv_from = (TextView) itemView.findViewById(R.id.tv_sig_from);
            tv_to = (TextView) itemView.findViewById(R.id.tv_sig_to);
            tv_mentor1 = itemView.findViewById(R.id.tv_sid_mentors1);
            tv_mentor2 = itemView.findViewById(R.id.tv_sid_mentors2);
            tv_mentor3 = itemView.findViewById(R.id.tv_sid_mentors3);
            call3=itemView.findViewById(R.id.calling3);

        }
    }


    public void extract_mentors(String[] mentors){

        if(mentors.length==2){
            m1=mentors[0];
            m2=mentors[1];
            m3="";
        }

        else if(mentors.length==3){
            m1=mentors[0];
            m2=mentors[1];
            m3=mentors[2];

        }

    }


}

