package com.marcelobarbacovi.how6gerenciarong.parceiros;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.marcelobarbacovi.how6gerenciarong.R;

public class ParceirosMainActivity extends AppCompatActivity {
    ParceirosFragmentAdicionar adcionarparceiro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.parceiros_activity_main);

        // click para chamar um fragment adcionarparceiros dentro da activity parceiros
        Button btnAdicionar = findViewById(R.id.buttton_Adiconar_parceirosss);
        btnAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                adcionarparceiro     = new ParceirosFragmentAdicionar();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_parceiro, adcionarparceiro);
                transaction.commit();
            }
        });

        // voltar a tela principal parceiros com botão listar

        Button btnListar = findViewById(R.id.button_listar_parceiro);
        btnListar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_parceiro, new ParceirosFragmentListar()).commit();
            }
        });


    }
}