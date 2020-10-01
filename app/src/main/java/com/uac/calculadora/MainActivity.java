package com.uac.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, bmas, bmenos, bpor, bdiv, bsqrt, binv, bc, bigual, bpunto;
    EditText dato;
    DecimalFormat formatodecimal = new DecimalFormat("###.#########", new DecimalFormatSymbols(Locale.US));
    double acum = 0;
    boolean operadorsuma = false;
    boolean operadorresta = false;
    boolean operadormultiplicar = false;
    boolean operadordivision = false;
    boolean operatorsqrt = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b0 = (Button) findViewById(R.id.b0);
        b0.setOnClickListener(this);
        b1 = findViewById(R.id.b1);
        b1.setOnClickListener(this);
        b2 = findViewById(R.id.b2);
        b2.setOnClickListener(this);
        b3 = findViewById(R.id.b3);
        b3.setOnClickListener(this);
        b4 = findViewById(R.id.b4);
        b4.setOnClickListener(this);
        b5 = findViewById(R.id.b5);
        b5.setOnClickListener(this);
        b6 = findViewById(R.id.b6);
        b6.setOnClickListener(this);
        b7 = findViewById(R.id.b7);
        b7.setOnClickListener(this);
        b8 = findViewById(R.id.b8);
        b8.setOnClickListener(this);
        b9 = findViewById(R.id.b9);
        b9.setOnClickListener(this);
        bmas = findViewById(R.id.bmas);
        bmas.setOnClickListener(this);
        bmenos = findViewById(R.id.bmenos);
        bmenos.setOnClickListener(this);
        bpor = findViewById(R.id.bpor);
        bpor.setOnClickListener(this);
        bdiv = findViewById(R.id.bdiv);
        bdiv.setOnClickListener(this);
        bsqrt = findViewById(R.id.bsqrt);
        bsqrt.setOnClickListener(this);
        binv = findViewById(R.id.binv);
        binv.setOnClickListener(this);
        bigual = findViewById(R.id.bigual);
        bigual.setOnClickListener(this);
        bc = findViewById(R.id.bc);
        bc.setOnClickListener(this);
        bpunto = findViewById(R.id.bpunto);
        bpunto.setOnClickListener(this);
        dato = findViewById(R.id.edtdato);
    }


    @Override
    public void onClick(View view) {

        String valor;
        double num = 0;
        if (!TextUtils.isEmpty(dato.getText().toString())) {
            num = Double.parseDouble(dato.getText().toString());
            valor = dato.getText().toString();
        } else {
            valor = "";
        }
        switch (view.getId()) {
            case R.id.b0:
                if (num != 0) {
                    valor = valor + "0";
                    dato.setText(valor);
                }
                break;

            case R.id.b1:
                valor = valor + "1";
                dato.setText(valor);
                break;

            case R.id.b2:
                valor = valor + "2";
                dato.setText(valor);
                break;

            case R.id.b3:
                valor = valor + "3";
                dato.setText(valor);
                break;

            case R.id.b4:
                valor = valor + "4";
                dato.setText(valor);
                break;

            case R.id.b5:
                valor = valor + "5";
                dato.setText(valor);
                break;

            case R.id.b6:
                valor = valor + "6";
                dato.setText(valor);
                break;

            case R.id.b7:
                valor = valor + "7";
                dato.setText(valor);
                break;

            case R.id.b8:
                valor = valor + "8";
                dato.setText(valor);
                break;

            case R.id.b9:
                valor = valor + "9";
                dato.setText(valor);
                break;

            case R.id.bpunto:
                if (valor == "") {
                    dato.setText("0.");
                } else if (!haypunto(valor, '.'))
                    valor = valor + ".";
                    dato.setText(valor);
                break;

            case R.id.bigual:
                if (operadorsuma) {
                    acum = acum + Double.parseDouble(dato.getText().toString());
                    dato.setText(formatodecimal.format(acum));
                    operadoresafalso();
                } else {
                    if (operadorresta) {
                        acum = acum - Double.parseDouble(dato.getText().toString());
                        dato.setText(formatodecimal.format(acum));
                        operadoresafalso();
                    } else {
                        if (operadormultiplicar) {
                            acum = acum * Integer.parseInt(dato.getText().toString());
                            dato.setText(formatodecimal.format(acum));
                            operadoresafalso();

                        } else {
                            if (operadordivision) {
                                acum = acum / Double.parseDouble(dato.getText().toString());
                                dato.setText(formatodecimal.format(acum));
                                operadoresafalso();
                            }
                        }

                    }
                }
                break;

            case R.id.bc:
                operadoresafalso();
                acum = 0;
                dato.setText("");
                break;

            case R.id.bmas:
                if (!operadorsuma)
                    acum = Double.parseDouble(dato.getText().toString());
                dato.setText("");
                operadorsuma = true;
                break;

            case R.id.bmenos:
                if (!operadorresta)
                    acum = Double.parseDouble(dato.getText().toString());
                dato.setText("");
                operadorresta = true;
                break;

            case R.id.bpor:
                if (!operadormultiplicar)
                    acum = Double.parseDouble(dato.getText().toString());
                dato.setText("");
                operadormultiplicar = true;
                break;

            case R.id.bdiv:
                if (!operadormultiplicar)
                    acum = Double.parseDouble(dato.getText().toString());
                dato.setText("");
                operadordivision = true;
                break;

            case R.id.binv:
                if (valor != "")
                    acum = 1 / Double.parseDouble(dato.getText().toString());
                dato.setText(formatodecimal.format(acum));
                break;

            case R.id.bsqrt:
                if (valor != "")
                    acum = Math.sqrt(Double.parseDouble(dato.getText().toString()));
                dato.setText(formatodecimal.format(acum));
                break;
        }
    }

    public void operadoresafalso() {
        operadorsuma = false;
        operadorresta = false;
        operadormultiplicar = false;
    }

    static boolean haypunto(String s, char ch) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ch)
                return true;
        }
        return false;
    }
}