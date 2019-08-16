package com.example.hp.oouattendance;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextInputLayout user_email, user_password;
    Button login_btn;
    private String email;
    private String password;
    TextView registerText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user_email = findViewById(R.id.user_id);
        user_password = findViewById(R.id.user_password);
        login_btn = findViewById(R.id.login_btn);
        registerText = findViewById(R.id.register_btn);

        email = user_email.getEditText().getText().toString().trim();
        password = user_password.getEditText().getText().toString().trim();

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                verify(email, password);

            }
        });

        registerText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // code to lead to the registration page
                Intent intent = new Intent(getApplicationContext(), RegistrationActivity.class);
                startActivity(intent);
            }
        });

    }

//    public boolean verify(String email, String password){
//        if(!email.isEmpty()){
//            user_email.setError("This field cannot be empty");
//            return false;
//        }else{
//            user_email.setError(null);
//            if(password.isEmpty()){
//                user_password.setError("This field cannot be empty");
//                return false;
//            }else{
//                user_password.setError(null);
//                return true;
//            }
//        }
//    }


}
