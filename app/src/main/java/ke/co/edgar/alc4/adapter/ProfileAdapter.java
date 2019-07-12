package ke.co.edgar.alc4.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ke.co.edgar.alc4.R;
import ke.co.edgar.alc4.model.MyProfile;

public class ProfileAdapter extends RecyclerView.Adapter<ProfileAdapter.MyViewHolder> {
    private List<MyProfile> profileList;
    private Context mContext;


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView label, value;

        public MyViewHolder(View view) {
            super(view);
            label = view.findViewById(R.id.profile_label);
            value = view.findViewById(R.id.profile_value);

        }
    }


    public ProfileAdapter(Context mContext, List<MyProfile> profileList) {
        this.mContext = mContext;
        this.profileList = profileList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.profile_list_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        MyProfile myProfile = profileList.get(position);

        holder.label.setText(myProfile.getLabel());
        holder.value.setText(myProfile.getValue());


    }

    @Override
    public int getItemCount() {
        return profileList.size();
    }
}
