package com.example.a2h.menubasico;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView mensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         mensaje = (TextView) findViewById(R.id.lblMensaje);



    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){

        //alternativa 1 :  inflar el documento xml que hemos generado
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menuprincipal,menu);

        //alternativa 2: Manipulamos el menu que recibe el metodo
        //menu.add(Menu.NONE, Menu.NONE, Menu.NONE, "Opción 1").setIcon(R.drawable.horario);   //Para meter icono.
            //menu.add(Menu.NONE, Menu.NONE, Menu.NONE, "Opción 2");
            //menu.add(Menu.NONE, Menu.NONE, Menu.NONE, "Opción 3");

            //SubMenu subMenu = menu.addSubMenu(Menu.NONE, Menu.NONE, Menu.NONE, "Opción 4");
           // subMenu.add(Menu.NONE, Menu.NONE, Menu.NONE, "Opción 4.1");
            //subMenu.add(Menu.NONE, Menu.NONE, Menu.NONE, "Opción 4.2");

    return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.MenuOpc1:
                mensaje.setText("Opcion1 pulsada!!!");
                return true;
            case R.id.MenuOpc2:
                mensaje.setText("Opcion2 pulsada!!!");
                return true;
            case R.id.SubMenuOpc1:
                mensaje.setText("Opcion3.1 pulsada!!!");
                return true;
            case R.id.SubMenuOpc2:
                mensaje.setText("Opcion3.1 pulsada!!!");
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
