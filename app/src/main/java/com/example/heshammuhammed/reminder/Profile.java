package com.example.heshammuhammed.reminder;



import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.heshammuhammed.reminder.R;

import org.json.JSONException;
import org.json.JSONObject;

public class Profile extends AppCompatActivity {
//    TextView username;
//    TextView email;
//    TextView gender;
//    ImageView profilepic;
//    Button logout;
//    String check;
//    SharedPreferences share;
//    SharedPreferences.Editor editor;
//    JSONObject obj,profile_pic_data,profile_pic_url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
//        share = getSharedPreferences("mypre", 0);
//        editor=share.edit();
//        Intent intent = getIntent();
//        String jsondata = intent.getStringExtra("userProfile");
//        profilepic = findViewById(R.id.imageView);
//        username = findViewById(R.id.username);
//        email = findViewById(R.id.email);
//        logout=findViewById(R.id.logout);
//        check = share.getString("form", "no");
//        logout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//             //   FacebookSdk.sdkInitialize(getApplicationContext());
//                LoginManager.getInstance().logOut();
//                Intent intt = new Intent(Profile.this,MainActivity.class);
//                intt.putExtra("log","out");
//                Log.i("tst1 ","logout");
//                check ="ss";
//                editor.remove("logged");
//                editor.commit();
//                finish();
//                startActivity(new Intent(intt));
//            }
//        });
//        if (share .getString("logged", "").toString().equals("logged")) {
//            username.setText(share.getString("name","NA"));
//            email.setText(share.getString("mail","NA"));
//            String image = share.getString("image"," ");
//            if( !image.equalsIgnoreCase("") ){
//                byte[] b = Base64.decode(image, Base64.DEFAULT);
//                Bitmap bitmap = BitmapFactory.decodeByteArray(b, 0, b.length);
//                profilepic.setImageBitmap(bitmap);
//            }
//
//        } else {
//            try {
//                obj = new JSONObject(jsondata);
//                username.setText(obj.get("name").toString());
//                email.setText(obj.get("email").toString());
//                // gender.setText(obj.get("gender").toString());
//               profile_pic_data = new JSONObject(obj.getString("picture").toString());
//                profile_pic_url = new JSONObject(profile_pic_data.getString("data"));
//                Picasso.with(this).load(profile_pic_url.getString("url")).into(profilepic);
//
//            } catch (JSONException e) {
//               e.printStackTrace();
//            }
//        }
   }
}
