package com.marcelobarbacovi.how6gerenciarong.alunos;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.marcelobarbacovi.how6gerenciarong.R;
import com.marcelobarbacovi.how6gerenciarong.database.DataBaseHelper;

public class AlunosFragmentEditar extends Fragment {
 // variaveis criados do fragment adcionar Alunos
    TextInputEditText editarNomeAluno, editarResponsavelAluno, editarEnderecoAluno, editarObservacaoAluno;
    EditText editarTelefoneAluno;
    private DataBaseHelper   databaseHelper;
    private Aluno a;


    public AlunosFragmentEditar() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {

            // Inflate the layout for this fragment
            View v = inflater.inflate(R.layout.alunos_fragment_editar, container, false);

            // recuperar os  campos do fragment editar alunos
            editarNomeAluno = v.findViewById(R.id.Editar_Nome_aluno);
            editarResponsavelAluno = v.findViewById(R.id.Editar_Responsavel_Aluno);
            editarTelefoneAluno = v.findViewById(R.id.Editar_telefone_Aluno);
            editarEnderecoAluno = v.findViewById(R.id.Editar_Endereco_Aluno);
            editarObservacaoAluno = v.findViewById(R.id.Editar_observacao_Aluno);

            // instancia a classe DataBasehelper

            Bundle b = getArguments();
            int id_aluno = b.getInt("id");
            databaseHelper = new DataBaseHelper(getActivity());
            Aluno aluno = databaseHelper.getByIdAluno(id_aluno);

            // configura para as variaveis o que esta preenchido dentro dos campos do fragment
            editarNomeAluno.setText(aluno.getNome());
            editarResponsavelAluno.setText(aluno.getResponsavel());
            editarTelefoneAluno.setText(aluno.getTelefone());
            editarEnderecoAluno.setText(aluno.getEndereco());
            editarObservacaoAluno.setText(aluno.getObservao());

            // configurar o click editat do fragment alunos

            Button btnEditar = v.findViewById(R.id.button_editar_aluno);
            btnEditar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    editar(id_aluno);
                }
            });

            /* configura o click do button excluir do fragment editar alunos
            e depois configura a mensagem para confiarmar a exclusão por meio do alertDialog

             */
            Button btnExcluir = v.findViewById(R.id.button_excluir_aluno);
            btnExcluir.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setTitle("excluir Aluno");
                    builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            excluir(id_aluno);
                        }
                    });
                    builder.setNegativeButton("Não", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            // Não faz nada
                        }
                    });
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                }
            });
            return v;
        }

        // valida dos campos para saber se não estão vazios do fragment editar alunos

        private void editar(int id) {
            if (editarNomeAluno.getText().toString().equals("")) {
                Toast.makeText(getActivity(), "Por favor, informe o nome do Aluno", Toast.LENGTH_LONG).show();
            } else if (editarResponsavelAluno.getText().toString().equals("")) {
                Toast.makeText(getActivity(), "Por favor, informe o responsável do Aluno", Toast.LENGTH_LONG).show();
            } else if (editarTelefoneAluno.getText().toString().equals("")) {
                Toast.makeText(getActivity(), "Por favor, informe o número do telefone do aluno", Toast.LENGTH_LONG).show();
            } else if (editarEnderecoAluno.getText().toString().equals("")) {
                Toast.makeText(getActivity(), "Por favor, informe o endereco do aluno ", Toast.LENGTH_LONG).show();

          /* instancia o objeto da classe aluno e grava dentro
           os dados na variaveis da classe aluno por meio do metodo set
           */
            } else {
                a = new Aluno();
                a.setId(id);
                a.setNome(editarNomeAluno.getText().toString());
                a.setResponsavel(editarResponsavelAluno.getText().toString());
                a.setTelefone(editarTelefoneAluno.getText().toString());
                a.setEndereco(editarEnderecoAluno.getText().toString());
                a.setObservao(editarObservacaoAluno.getText().toString());
                databaseHelper.updateAluno(a);
                Toast.makeText(getActivity(), "Aluno atualizado", Toast.LENGTH_LONG).show();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame_alunos, new AlunosFragmentListar()).commit();
            }
        }
// chama o metodo exluir aluno da classe DataBaseHelper
        private void excluir (int id) {
            a = new Aluno();
            a.setId(id);
            databaseHelper.deleteAluno(a);
            Toast.makeText(getActivity(), "Aluno excluído", Toast.LENGTH_LONG).show();
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame_alunos, new AlunosFragmentListar()).commit();
        }
    }