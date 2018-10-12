package org.ieeedtu.ieee_dtu.HomeFragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.ieeedtu.ieee_dtu.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFragment extends Fragment {


    public NewsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_news, container, false);
    }

}
//
//public class HomeNoticeAdapter extends RecyclerView.Adapter<HomeNoticeAdapter.NoticeHolder> {
//    private Notice notices[];
//
//    public HomeNoticeAdapter(Notice[] notices) {
//        this.notices = notices;
//    }
//
//    @Override
//    public NoticeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        return new NoticeHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_notice_display, parent, false));
//    }
//
//    @Override
//    public void onBindViewHolder(NoticeHolder holder, int position) {
//
//        String noticeDate = notices[notices.length - position - 1].getDate();
//
//        holder.tv_date.setText(convertDateFromUTC(noticeDate, "EEE, d MMM yyyy HH:mm:ss"));
//        holder.tv_title.setText(notices[notices.length - position - 1].getTitle());
//        holder.tv_body.setText(notices[notices.length - position - 1].getBody());
//        holder.tv_num.setText(notices[notices.length - position - 1].getnoticeBy());
//    }
//
//
//    @Override
//    public int getItemCount() {
//
//        //Only show max 5 latest notices
//        int len = this.notices.length;
//        if (len <= 5) {
//            return len;
//        } else {
//            return 5;
//        }
//
//    }
//
//    public class NoticeHolder extends RecyclerView.ViewHolder {
//        TextView tv_topic, tv_from, tv_to;
//
//        public NoticeHolder(View itemView) {
//            super(itemView);
//            tv_topic = (TextView) itemView.findViewById(R.id.tv_notice_resp_date);
//            tv_from = (TextView) itemView.findViewById(R.id.tv_notice_title);
//            tv_to = (TextView) itemView.findViewById(R.id.tv_notice_body);
//
//        }
//    }
//
//
//}
//
