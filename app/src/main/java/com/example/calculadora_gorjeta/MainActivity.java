package com.example.calculadora_gorjeta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editvalor;
    private TextView textporcentagem;
    private TextView textTotal;
    private SeekBar seekBar;
    private TextView textgorjeta;

    private double porcentagem = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editvalor = findViewById(R.id.editValor);
        textporcentagem = findViewById(R.id.textPorcentagem);
        textTotal = findViewById(R.id.textTotal);
        seekBar = findViewById(R.id.seekBarGorjeta);
        textgorjeta = findViewById(R.id.textGorjeta);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            porcentagem = progress;

            //Math.round arredonda o numero

            textporcentagem.setText(Math.round(porcentagem) + "%");

            // chamar o metodo no onProgressChanged

            calcular();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
    public void calcular(){
        // verificar se a sting e nula ou vazia
        String valorRecuperado = editvalor.getText().toString();
        if (valorRecuperado == null|| valorRecuperado.equals("")){

            Toast.makeText(getApplicationContext(),"digite um valor primeiro",Toast.LENGTH_LONG).show();

        }else {
            //converter em double
            double valordigitado = Double.parseDouble(valorRecuperado);

            // calculo gorjeta
            double gorjeta = valordigitado * (porcentagem/100);
            double total = gorjeta + valordigitado;

            // exibe a gorjeta total
            textgorjeta.setText("RS" + Math.round(gorjeta));

            // exibe total
            textTotal.setText("RS" + Math.round(total));
        }

    }
}