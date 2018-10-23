package org.ieeedtu.ieee_dtu;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CouncilMembersActivity extends AppCompatActivity {
    TextView desc, heading;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    List<CouncilMembers> members = new ArrayList<>();
    // total 16 members
    String[] member_name = {"Nikhil Mishra", "Sagnik Bhowmik", "Ashutosh Kumar", "Utkarsh Verma",
            "Prithu Verma", "Shubhi Sareen", "Richa Mishra", "Millikarjun Shandilya", "Kanchan Yadav",
            "Abhishek Gangwar", "Ayush Shakya", "Rattan Kaur", "Ramjan Ali", "Deekhsha Mittal",
            "Aarushi Aggarwal", "Pranshu Goyal"};
    Integer[] profilePic = {R.drawable.nikhil,
            R.drawable.sagnik,
            R.drawable.ashutosh,
            R.drawable.utkarsh,
            R.drawable.prithu,
            null, null,
            R.drawable.mallik,
            R.drawable.kanchan,
            R.drawable.gangwar,
            R.drawable.ayush,
            R.drawable.rattan,
            R.drawable.ramjan,
            null,
            R.drawable.arushi,
            R.drawable.pranshu};

    String[] facebookLink = {
            "https://www.facebook.com/nikhilmishra1997",
            "https://www.facebook.com/sagnik.bhowmick.90",
            "https://www.facebook.com/people/Ashutosh-Kumar/100005462087516",
            "https://www.facebook.com/utkarshvermaa",
            "https://www.facebook.com/prithu.verma",
            "https://www.facebook.com/shubhisareen",
            "https://www.facebook.com/yadav.richa",
            "https://www.facebook.com/mallikarjun.shandilya",
            "https://www.facebook.com/kanchan.yadav.98434",
            "https://www.facebook.com/abhishek.gangwar.35",
            "https://www.facebook.com/ayushdtu",
            "https://www.facebook.com/rattan.kaur.71",
            "https://www.facebook.com/Remo5692",
            "https://www.facebook.com/profile.php?id=100010299794710",
            "https://www.facebook.com/aarushi.aggarwal.10",
            "https://www.facebook.com/pranshu.goyal.351"
    };

    String[] linkedin = {"https://www.linkedin.com/in/nkmishra1997/",
            "https://www.linkedin.com/in/hellosagnik/",
            "https://www.linkedin.com/in/ashutosh-kumar-42859815b/",
            "https://www.linkedin.com/in/utkarshver/",
            "https://www.linkedin.com/in/prithu-verma/",
            "https://www.linkedin.com/in/shubhi-sareen/",
            "https://www.linkedin.com/in/richa-mishra-548783110/",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_council_members);

        CouncilMembers cm;
        for (int i = 0; i < member_name.length; i++) {
            cm = new CouncilMembers(member_name[i], facebookLink[i], linkedin[i], profilePic[i] );
            members.add(cm);
        }
        recyclerView = findViewById(R.id.rv_council);
        adapter = new MemberAdapter(members, getApplicationContext());
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
    }
}


class MemberAdapter extends RecyclerView.Adapter<MemberAdapter.RecyclerViewHolder> {

    private List<CouncilMembers> MemList;
    private Context context;
    public MemberAdapter(List<CouncilMembers> members, Context context) {
        this.MemList = members;
        this.context = context;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_council_member, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, final int position) {
        holder.tv_name.setText(MemList.get(position).getName());
        if(MemList.get(position).getProfile_pic()!=null){
            holder.imageView.setImageResource(MemList.get(position).getProfile_pic());
        }else {
            holder.imageView.setImageResource(R.drawable.demo_photo);
        }
        holder.iv_linkedin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startLinkedin(position);
            }

        });
        if (position != 5)
            holder.iv_facebook.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startFacebook(position);
                }
            });
        else holder.iv_facebook.setVisibility(View.INVISIBLE);
    }

    public void sendMail(String link) {
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                "mailto", link, null));
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, " ");
        context.startActivity(Intent.createChooser(emailIntent, null));
    }


    private void startLinkedin(int position) {
        if (position == 0) {
            OpenLinkedIn(MemList.get(0).getLinkedin());
        } else if (position == 1) {
            OpenLinkedIn(MemList.get(1).getLinkedin());
        } else if (position == 2) {
            OpenLinkedIn(MemList.get(2).getLinkedin());
        } else if (position == 3) {
            OpenLinkedIn(MemList.get(3).getLinkedin());
        } else if (position == 4) {
            OpenLinkedIn(MemList.get(4).getLinkedin());
        } else if (position == 5) {
            OpenLinkedIn(MemList.get(5).getLinkedin());
        } else if (position == 6) {
            OpenLinkedIn(MemList.get(6).getLinkedin());
        } else if (position == 7) {
            OpenLinkedIn(MemList.get(7).getLinkedin());
        }else if (position == 8) {
            OpenLinkedIn(MemList.get(8).getLinkedin());
        }else if (position == 9) {
            OpenLinkedIn(MemList.get(9).getLinkedin());
        }else if (position == 10) {
            OpenLinkedIn(MemList.get(10).getLinkedin());
        }else if (position == 11) {
            OpenLinkedIn(MemList.get(11).getLinkedin());
        }else if (position == 12) {
            OpenLinkedIn(MemList.get(12).getLinkedin());
        }else if (position == 13) {
            OpenLinkedIn(MemList.get(13).getLinkedin());
        }else if (position == 14) {
            OpenLinkedIn(MemList.get(14).getLinkedin());
        }else if (position == 15) {
            OpenLinkedIn(MemList.get(15).getLinkedin());
        }else if (position == 16) {
            OpenLinkedIn(MemList.get(16).getLinkedin());
        }

    }

    private void startFacebook(int position) {
        if (position == 0) {
            OpenFacebook(MemList.get(0).getFacebook());
        }
        if (position == 1) {
            OpenFacebook(MemList.get(1).getFacebook());
        } else if (position == 2) {
            OpenFacebook(MemList.get(2).getFacebook());
        } else if (position == 3) {
            OpenFacebook(MemList.get(3).getFacebook());
        } else if (position == 4) {
            OpenFacebook(MemList.get(4).getFacebook());
        } else if (position == 5) {
            OpenFacebook(MemList.get(5).getFacebook());
        } else if (position == 6) {
            OpenFacebook(MemList.get(6).getFacebook());
        } else if (position == 7) {
            OpenFacebook(MemList.get(7).getFacebook());
        } else if (position == 8) {
            OpenFacebook(MemList.get(8).getFacebook());
        } else if (position == 9) {
            OpenFacebook(MemList.get(9).getFacebook());
        } else if (position == 10) {
            OpenFacebook(MemList.get(10).getFacebook());
        } else if (position == 11) {
            OpenFacebook(MemList.get(11).getFacebook());
        } else if (position == 12) {
            OpenFacebook(MemList.get(112).getFacebook());
        } else if (position == 13) {
            OpenFacebook(MemList.get(13).getFacebook());
        } else if (position == 14) {
            OpenFacebook(MemList.get(14).getFacebook());
        } else if (position == 15) {
            OpenFacebook(MemList.get(15).getFacebook());
        } else if (position == 16) {
            OpenFacebook(MemList.get(16).getFacebook());
        }
    }

    private void OpenLinkedIn(String links) {

    }

    private void OpenFacebook(String links) {
        PackageManager packageManager = context.getPackageManager();
        Intent facebookIntent = new Intent(Intent.ACTION_VIEW);
        String facebookUrl = links;
        if (links == null) ;
        boolean activated = false;
        //Checks whether app present or not @author hg2199
        try {
            activated = packageManager.getApplicationInfo("com.facebook.katana", 0).enabled;
            //Assigns the app url
            if (activated) {
                String inital = "fb://facewebmodal/f?href=";
                facebookUrl = inital + links;

            }
        } catch (PackageManager.NameNotFoundException e) {
            facebookUrl = links;
        }
        facebookIntent.setData(Uri.parse(facebookUrl));
        context.startActivity(Intent.createChooser(facebookIntent, null));
    }


    @Override
    public int getItemCount() {
        return MemList.size();
    }


    public static class RecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView tv_name;
        ImageView imageView;
        ImageView iv_linkedin;
        ImageView iv_facebook;

        public RecyclerViewHolder(View view) {
            super(view);
            imageView = view.findViewById(R.id.iv_pic);
            tv_name = view.findViewById(R.id.tv_name);
            iv_linkedin = view.findViewById(R.id.iv_linkedin);
            iv_facebook = view.findViewById(R.id.iv_facebook);

        }
    }
}