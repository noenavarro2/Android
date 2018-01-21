package com.example.a2h.proyecto1holamundo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //es como un metodo constructor y se ejecuta el solo al entrar
        setContentView(R.layout.activity_main);
        //view es la vista y set es la configuracion, esta controlando la vista con el controlador
        //R. es el registro y cada proyecto tiene un registro y el propio android tiene uno que se llama R tambien
        //match parent es que se adapte al tamaño de la ventana


        final EditText txtNombre = (EditText) findViewById(R.id.TxtNombre) ;
        //txtNombre es una variable
        //de tipo puntero donde cabe una direccion de memoria o null, lo de la derecha pasa a la izquierda
        // (EditText)esto es parsear porque en el registro te lo devuelve de forma general
        //aqui final se puede utilizar en otros metodos es una variable global
        final Button boton = (Button) findViewById(R.id.btnHola);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            //creamos el intent ,creamos el bundle, se carga en bundle , meter el bundle al intent , y lanzar el intent
            public void onClick(View v) {
                //crear un intent que sirve para abrir otras ventanas y poder psarle parametros
                Intent intent = new Intent(MainActivity.this, frmSaludo.class);//examen
                //se le pasan dos parametros la primera ventana que es esta MainActivity.this y la segunda es la que se va a abrir
                //para pasar parametros con la clase Bundle para guardar variables
                //crear la informacion mediante el metodo bundle para pasar entre activitis(pantallas).
                Bundle b = new Bundle();
                //para meter los valores en bundle se utiliza un metodo de bundle en este caso putString
                //intent.putExtra("nombre", intent); asi se hacen con otro metodo las dos lineas
                b.putString("Nombre", txtNombre.getText().toString()); //aqui es dupla valor es decir al string le pasa el valor
                //metemos b mediante el metodo putExtras
                intent.putExtras(b);
                //iniciamos el nuevo activity
                startActivity(intent);


            }
        });

    }
}
