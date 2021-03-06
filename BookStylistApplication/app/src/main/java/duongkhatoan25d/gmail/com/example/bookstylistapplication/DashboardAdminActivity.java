package duongkhatoan25d.gmail.com.example.bookstylistapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import duongkhatoan25d.gmail.com.example.bookstylistapplication.databinding.ActivityDashboardAdminBinding;

public class DashboardAdminActivity extends AppCompatActivity {
    private FirebaseAuth firebaseAuth;

    private ActivityDashboardAdminBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDashboardAdminBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        firebaseAuth = FirebaseAuth.getInstance();
        checkUser();

        binding.btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firebaseAuth.signOut();
                checkUser();
            }
        });

    }

    private void checkUser() {
        FirebaseUser firebaseUser= firebaseAuth.getCurrentUser();
        if(firebaseUser==null){
            startActivity(new Intent(DashboardAdminActivity.this,MainActivity.class));
            finish();

        }
        else{
            String email = firebaseUser.getEmail();
            binding.subTitleTv.setText(email);

        }
    }
}