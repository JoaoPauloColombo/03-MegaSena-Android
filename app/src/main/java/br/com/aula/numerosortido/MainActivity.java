package br.com.aula.numerosortido;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View mainView = findViewById(R.id.main);
        ViewCompat.setOnApplyWindowInsetsListener(mainView, (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    // Executa em btn Jogar - Sorteia um número
    public void sortearNumero(View view) {
        TextView[] resultados = {
                findViewById(R.id.textoResultado1),
                findViewById(R.id.textoResultado2),
                findViewById(R.id.textoResultado3),
                findViewById(R.id.textoResultado4),
                findViewById(R.id.textoResultado5),
                findViewById(R.id.textoResultado6),
        };

        Set<Integer> numerosSorteados = new HashSet<>();
        Random random = new Random();

        while (numerosSorteados.size() < 6) {
            numerosSorteados.add(random.nextInt(60) + 1);
        }

        // Criando uma lista de até 6 números
        List<Integer> numerosOrdenados = new ArrayList<>(numerosSorteados);
        Collections.sort(numerosOrdenados);

        // Atualiza os TextViews com os números sorteados
        for (int i = 0; i < 6; i++) {
            resultados[i].setText(String.valueOf(numerosOrdenados.get(i)));
        }
    }

    public void reiniciarNumero(View view) {
        TextView[] resultados = {
                findViewById(R.id.textoResultado1),
                findViewById(R.id.textoResultado2),
                findViewById(R.id.textoResultado3),
                findViewById(R.id.textoResultado4),
                findViewById(R.id.textoResultado5),
                findViewById(R.id.textoResultado6),
        };

        for (TextView resultado : resultados) {
            resultado.setText("----");
        }
    }
}
