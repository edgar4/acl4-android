package ke.co.edgar.alc4;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

import ke.co.edgar.alc4.adapter.ProfileAdapter;
import ke.co.edgar.alc4.model.MyProfile;

public class ProfileActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<MyProfile> myProfile;
    private TextView name;
    private ImageView pic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        name = findViewById(R.id.my_name);
        pic = findViewById(R.id.profile_img);
        myProfile = new ArrayList<>();
        recyclerView = findViewById(R.id.recylerView);
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new ProfileAdapter(this, myProfile);
        recyclerView.setAdapter(mAdapter);

        setUpProfile();

    }

    void setUpProfile() {

        Glide.with(this).load(this.getResources()
                .getIdentifier("ic_my_pic", "drawable", this.getPackageName()))
                .transition(new DrawableTransitionOptions().crossFade())
                .apply(new RequestOptions().circleCrop())
                .into(pic);
        name.setText("Edgar Chris");
        myProfile.add(new MyProfile("Track:", "Android"));
        myProfile.add(new MyProfile("Country:", "Kenya"));
        myProfile.add(new MyProfile("Email:", "me@edgar.co.ke"));
        myProfile.add(new MyProfile("Phone Number:", "+254 717 11 38 86"));
        myProfile.add(new MyProfile("Slack Username:", "@Edgar chris"));
        mAdapter.notifyDataSetChanged();
    }

}
