package org.ieeedtu.ieee_dtu;

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
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Objects;

public class ProjectsActivity extends AppCompatActivity {
    
    String[] title = {"Tic-Tac-Toe", "LFR", "Robots", "ChatBot", "Project 2", "Project 3"};
    String[][] tags = new String[title.length][5];
    String[] made_by = {};
    
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projects);

        ArrayList<Projects> projects = new ArrayList<>();
        for(int i=0;i<title.length;i++){
            Projects project = new Projects();
            project.setTitle(title[i]);
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

    ProjectAdapter(ArrayList<Projects> projects) {
        this.projects = projects;
    }

    @NonNull
    @Override
    public ProjectAdapter.ProjectHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ProjectAdapter.ProjectHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_project_recycler, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ProjectAdapter.ProjectHolder holder, int position) {
        holder.tv_topic.setText(projects.get(position).getTitle());
    }


    @Override
    public int getItemCount() {
        return projects.size();
    }

    class ProjectHolder extends RecyclerView.ViewHolder {
        TextView tv_topic;

        ProjectHolder(View itemView) {
            super(itemView);
            tv_topic = (TextView) itemView.findViewById(R.id.tv_pro_title);
        }
    }


}

