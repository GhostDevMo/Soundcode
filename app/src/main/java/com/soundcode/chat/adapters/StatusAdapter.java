package com.soundcode.chat.adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.devlomi.circularstatusview.CircularStatusView;
import com.soundcode.chat.R;
import com.soundcode.chat.model.realms.Status;
import com.soundcode.chat.model.realms.User;
import com.soundcode.chat.model.realms.UserStatuses;
import com.soundcode.chat.utils.BitmapUtils;
import com.soundcode.chat.utils.RealmHelper;
import com.soundcode.chat.utils.SharedPreferencesManager;
import com.soundcode.chat.utils.TimeHelper;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import io.realm.OrderedRealmCollection;
import io.realm.RealmRecyclerViewAdapter;
import io.realm.RealmResults;

public class StatusAdapter extends RealmRecyclerViewAdapter<UserStatuses, StatusAdapter.StatusHolder> {

    private List<UserStatuses> statusesList;
    private List<UserStatuses> originalList;
    private Context context;
    private OnClickListener onStatusClick;

    public StatusAdapter(@Nullable OrderedRealmCollection data, boolean autoUpdate, Context context, OnClickListener onStatusClick) {
        super(data, autoUpdate);
        statusesList = data;
        originalList = statusesList;
        this.context = context;
        this.onStatusClick = onStatusClick;
    }


    @NonNull
    @Override
    public StatusHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_status, parent, false);
        return new StatusHolder(row);
    }


    @Override
    public void onBindViewHolder(@NonNull StatusHolder holder, int position) {
        holder.bind(statusesList.get(position));
    }

    @Override
    public int getItemCount() {
        return statusesList.size();
    }

    public void filter(String query) {

        if (query.trim().isEmpty()) {
            statusesList = originalList;
        } else {
            RealmResults<UserStatuses> userStatuses = RealmHelper.getInstance().searchForStatus(query);
            statusesList = userStatuses;
        }

        notifyDataSetChanged();

    }

    class StatusHolder extends RecyclerView.ViewHolder {
        private CircleImageView profileImage;
        private TextView tvUsername;
        private TextView tvLastStatusTime;
        private CircularStatusView circularStatusView;


        public StatusHolder(View itemView) {
            super(itemView);
            profileImage = itemView.findViewById(R.id.profile_image);
            tvUsername = itemView.findViewById(R.id.tv_username);
            tvLastStatusTime = itemView.findViewById(R.id.tv_last_status_time);
            circularStatusView = itemView.findViewById(R.id.circular_status_view);

        }

        public void bind(final UserStatuses statuses) {
            User user = statuses.getUser();
            if (user == null)
                user = SharedPreferencesManager.getCurrentUser();


            tvUsername.setText(user.getUserName());
            RealmResults<Status> filteredStatuses = statuses.getFilteredStatuses();

            if (!filteredStatuses.isEmpty()) {
                Status lastStatus = filteredStatuses.last();
                tvLastStatusTime.setText(TimeHelper.getStatusTime(lastStatus.getTimestamp()));

                circularStatusView.setPortionsCount(filteredStatuses.size());
                if (statuses.isAreAllSeen()) {
                    circularStatusView.setPortionsColor(Color.DKGRAY);
                } else {
                    for (int i = 0; i < filteredStatuses.size(); i++) {
                        Status status = filteredStatuses.get(i);
                        int color = status.isSeen()
                                ? context.getResources().getColor(R.color.status_seen_color)
                                : context.getResources().getColor(R.color.status_not_seen_color);
                        circularStatusView.setPortionColorForIndex(i, color);
                    }
                }
                Glide.with(context).load(BitmapUtils.encodeImageAsBytes(lastStatus.getThumbImg())).asBitmap().into(profileImage);
            } else {
                Glide.with(context).load(BitmapUtils.encodeImageAsBytes(user.getThumbImg())).asBitmap().into(profileImage);
            }

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (onStatusClick != null)
                        onStatusClick.onStatusClick(view, statuses);
                }
            });


        }
    }

    public interface OnClickListener {
        void onStatusClick(View view, UserStatuses userStatuses);
    }


}
