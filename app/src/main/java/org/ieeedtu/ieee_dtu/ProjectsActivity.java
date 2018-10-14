package org.ieeedtu.ieee_dtu;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Objects;

public class ProjectsActivity extends AppCompatActivity {

    String[] title = {"Tic-Tac-Toe-Online","RealtimeTicTacToe", "LFR", "Robots", "ChatBot", "Project 2", "Project 3"};

    String[] tags = {"android  game  online  firebase  java  ","android  game  online  firebase  java  ","lfrdesc1  IOT  lfrdesc2","AI  ML  robotics  robotdesc1", "python  ML  AI",
        "project2.1  project 2.2","asa  asedf  ererere"};

    String[] year = {"2018","2018","2018","2018","2018","2018","2018"};

    String[] links = {"https://github.com/shivamkumard107/TicTacToe-Online","https://github.com/KunalFarmah98/tictactoe","https://www.google.com","https://www.google.com",
            "https://www.google.com","https://www.google.com","https://www.google.com"};

    String[] tictactoe = {"Shivam Kumar"};
    String[] realtimetictactoe = {"Kunal Farmah"};
    String[] lfr = {"Sm1","Sm2"};
    String[] robots = {"Sm1","Sm2"};
    String[] catbot = {"Sm3","Sm4"};
    String[] p2 = {"Sm5","Sm6","Sm7","Sm8"};
    String[] p3 = {"Sm9"};

    ArrayList<String[]> made_by;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projects);

        made_by=new ArrayList<>();
        made_by.add(tictactoe);
        made_by.add(realtimetictactoe);
        made_by.add(lfr);
        made_by.add(robots);
        made_by.add(catbot);
        made_by.add(p2);
        made_by.add(p3);

        ArrayList<Projects> projects = new ArrayList<>();
        for(int i=0;i<title.length;i++){
            Projects project = new Projects();
            project.setTitle(title[i]);
            project.setYear(year[i]);
            project.setTags(tags);
            project.setLink(links[i]);

            project.setMadeBy(made_by);

            projects.add(project);
        }

        RecyclerView recyclerView = findViewById(R.id.rv_projects);
        RecyclerView.Adapter adapter = new ProjectAdapter(projects);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}

class ProjectAdapter extends RecyclerView.Adapter<ProjectAdapter.ProjectHolder> {
    private ArrayList<Projects> projects;

    String m1="",m2="",m3="",m4="";

    ProjectAdapter(ArrayList<Projects> projects) {
        this.projects = projects;
    }

    @NonNull
    @Override
    public ProjectAdapter.ProjectHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ProjectAdapter.ProjectHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_project_recycler, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final ProjectAdapter.ProjectHolder holder, final int position) {
        holder.tv_topic.setText(projects.get(position).getTitle());

        holder.tv_pro_year.setText(projects.get(position).getYear());
        setMakers(projects.get(position).getMadeBy().get(position));

        holder.tv_made_by1.setText(m1);
        holder.tv_made_by2.setText(m2);
        holder.tv_made_by3.setText(m3);
        holder.tv_made_by4.setText(m4);
        holder.tv_tags.setText(projects.get(position).getTags(position));

        holder.tv_made_by3.setVisibility(View.GONE);
        holder.tv_made_by4.setVisibility(View.GONE);
        holder.c3.setVisibility(View.GONE);
        holder.c4.setVisibility(View.GONE);

        if (m2.equals("")) {
            holder.tv_made_by2.setVisibility(View.GONE);
            holder.c2.setVisibility(View.GONE);
        }
        else {
            holder.tv_made_by2.setVisibility(View.VISIBLE);
            holder.c2.setVisibility(View.VISIBLE);

        }

        if(!m3.equals("")) {
            holder.tv_made_by3.setVisibility(View.VISIBLE);
            holder.c3.setVisibility(View.VISIBLE);
        }

//        else
//            holder.tv_made_by3.setVisibility(View.GONE);

        if(!m4.equals("")) {
            holder.tv_made_by4.setVisibility(View.VISIBLE);
            holder.c4.setVisibility(View.VISIBLE);
        }
//        else
//            holder.tv_made_by4.setVisibility(View.GONE);


        // starting a webview with the github repo
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(context,RepoActivity.class);
                intent.putExtra("URL",projects.get(position).getLink());
                context.startActivity(intent);
            }
        });


    }



    @Override
    public int getItemCount() {
        return projects.size();
    }

    class ProjectHolder extends RecyclerView.ViewHolder {
        TextView tv_topic, tv_pro_year;
        TextView tv_made_by1,tv_made_by2,tv_made_by3,tv_made_by4;
        TextView tv_tags;
        LinearLayout c1,c2,c3,c4;

        ProjectHolder(View itemView) {
            super(itemView);
            tv_topic = (TextView) itemView.findViewById(R.id.tv_pro_title);
            tv_pro_year = itemView.findViewById(R.id.tv_pro_year);
            tv_made_by1 = itemView.findViewById(R.id.tv_made_by1);
            tv_made_by2 = itemView.findViewById(R.id.tv_made_by2);
            tv_made_by3 = itemView.findViewById(R.id.tv_made_by3);
            tv_made_by4 = itemView.findViewById(R.id.tv_made_by4);
            tv_tags = itemView.findViewById(R.id.tv_pro_tags);
            c1= itemView.findViewById(R.id.calling1);
            c2= itemView.findViewById(R.id.calling2);
            c3= itemView.findViewById(R.id.calling3);
            c4= itemView.findViewById(R.id.calling4);
        }
    }


    public void setMakers(String[] makers){

        if(makers.length==1){
           m1=makers[0];m2=m3=m4="";
        }
        else if(makers.length==2){
            m1=makers[0];m2=makers[1];m3=m4="";
        }
        else if(makers.length==3){
            m1=makers[0];m2=makers[1];m3=makers[2];m4="";
        }
        else if(makers.length==4){
            m1=makers[0];m2=makers[1];m3=makers[2];m4=makers[3];
        }

    }




}

