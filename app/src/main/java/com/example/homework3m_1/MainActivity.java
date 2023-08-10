package com.example.homework3m_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {
    private TextInputLayout til_email;
    private TextInputLayout til_theme;
    private TextInputLayout til_content;
    private MaterialButton send_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        onClickInit();
    }

    private void init() {
        til_email = findViewById(R.id.email_ed);
        til_theme = findViewById(R.id.theme_ed);
        til_content = findViewById(R.id.content_ed);
        send_btn = findViewById(R.id.btn_send);
    }

    private void onClickInit() {
        send_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = til_email.getEditText().getText().toString();
                String theme = til_theme.getEditText().getText().toString();
                String content = til_content.getEditText().getText().toString();

                if (!email.isEmpty() && !theme.isEmpty() && !content.isEmpty()) {
                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.setType("message/rfc822");
                    intent.putExtra(Intent.EXTRA_EMAIL, new String[] { email });
                    intent.putExtra(Intent.EXTRA_SUBJECT, theme);
                    intent.putExtra(Intent.EXTRA_TEXT, content);
                    startActivity(Intent.createChooser(intent, "Отправить письмо"));

                }else {
                    Toast.makeText(MainActivity.this, "Заполните все поля", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}