package com.example.g2int101experience;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.g2int101experience.databinding.ActivityLoginBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {

     ActivityLoginBinding binding;
     FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);


        binding.tvLinkLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Registro.class));
            }
        });

        binding.editTextText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {

                if (!hasFocus) {
                    if (binding.editTextText.getText().toString().isEmpty()) {
                        binding.tvMensajeErrorCorreo.setText(R.string.el_correo_electr_nico_no_puede_estar_vacio);
                        binding.tvMensajeErrorCorreo.setVisibility(View.VISIBLE);
                    }
                } else {
                    binding.editTextText.setText("");
                    binding.tvMensajeErrorCorreo.setVisibility(View.GONE);
                }

            }
        });

        binding.editTextTextPassword.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {

                if (!hasFocus) {

                    if (binding.editTextTextPassword.getText().toString().isEmpty()) {
                        binding.tvMensajeErrorPassword.setText(R.string.la_contrase_a_no_puede_estar_vacia);
                        binding.tvMensajeErrorPassword.setVisibility(View.VISIBLE);
                    }

                } else {
                    binding.editTextTextPassword.setText("");
                    binding.tvMensajeErrorPassword.setVisibility(View.GONE);
                }

            }

        });

        // TODO Implementar botton recordarme.

        mAuth = FirebaseAuth.getInstance();

        binding.btnInicioSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email, pasword;
                email = binding.editTextText.getText().toString().trim();
                pasword = binding.editTextTextPassword.getText().toString().trim();

                // TODO Poner una progressbar

                if (email.isEmpty()) {
                    binding.tvMensajeErrorCorreo.setText(R.string.el_correo_electr_nico_no_puede_estar_vacio);
                    binding.tvMensajeErrorCorreo.setVisibility(View.VISIBLE);
                    return;
                }

                if (pasword.isEmpty()) {
                    binding.tvMensajeErrorPassword.setText(R.string.la_contrase_a_no_puede_estar_vacia);
                    binding.tvMensajeErrorPassword.setVisibility(View.VISIBLE);
                    return;
                }

                mAuth.signInWithEmailAndPassword(email, pasword)
                        .addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {

                                    binding.tvMensajeErrorCorreo.setVisibility(View.GONE);
                                    binding.tvMensajeErrorPassword.setVisibility(View.GONE);
                                    binding.editTextText.setText("");
                                    binding.editTextTextPassword.setText("");
                                    startActivity(new Intent(getApplicationContext(), MainActivity.class));


                                } else {
                                    binding.tvMensajeErrorCorreo.setText(R.string.correo_no_encontrado_revise_los_datos);
                                    binding.tvMensajeErrorPassword.setText(R.string.contrsse_a_no_encontrada_revise_los_datos);
                                    binding.tvMensajeErrorCorreo.setVisibility(View.VISIBLE);
                                    binding.tvMensajeErrorPassword.setVisibility(View.VISIBLE);
                                }
                            }
                        });

            }
        });

    }
}