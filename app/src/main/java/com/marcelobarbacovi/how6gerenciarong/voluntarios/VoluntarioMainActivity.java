package com.marcelobarbacovi.how6gerenciarong.voluntarios;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.marcelobarbacovi.how6gerenciarong.R;
import com.marcelobarbacovi.how6gerenciarong.parceiros.ParceirosFragmentAdicionar;

public class VoluntarioMainActivity extends AppCompatActivity {
    VoluntariosFragmentAdicionar adcionarvoluntario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voluntario_main);


        // configurar o button adcionar para chamar o fragment Voluntarios adcionar dentro da activity dos voluntarios
        Button btnAdicionar = findViewById(R.id.buttton_Adiconar_voluntario);
        btnAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                adcionarvoluntario = new VoluntariosFragmentAdicionar();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_voluntario, adcionarvoluntario);
                transaction.commit();

            }
        });
            // button para vhamar o fragment listarVoluntarios dentro da activity voluntarios
                Button btnListarVoluntario = findViewById(R.id.button_listar_voluntario);
                btnListarVoluntario.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_voluntario, new VoluntariosFragmentListar()).commit();
                    }
                });

            }


        }