package com.marcelobarbacovi.how6gerenciarong.alunos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.marcelobarbacovi.how6gerenciarong.R;
import com.marcelobarbacovi.how6gerenciarong.parceiros.ParceirosFragmentAdicionar;
import com.marcelobarbacovi.how6gerenciarong.parceiros.ParceirosFragmentListar;

public class AlunosActivity extends AppCompatActivity {
    AlunosFragmentAdcionar adcionaralunos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alunos_activity_main);

       // click button adicionar alunos para ir para o fragment alunos
       Button btnAdicionar = findViewById(R.id.buttton_Adiconar_alunos);
       btnAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    // metodo para acessar um fragment alunos a partir da activity alunos quando clicado no button adicionar alunos
                adcionaralunos     = new AlunosFragmentAdcionar();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_alunos, adcionaralunos);
                transaction.commit();
            }
        });

        // voltar a tela principal da lista de alunos com botão listar

        Button btnListar = findViewById(R.id.button_listar_alunos);
        btnListar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_alunos, new AlunosFragmentListar()).commit();
            }
        });



    }
}