package com.example.clase1.clase1;



        import android.content.Intent;
        import android.graphics.Color;
        import android.net.Uri;
        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.util.Log;
        import android.view.View;
        import android.widget.EditText;
        import android.widget.ImageView;
        import android.widget.RadioButton;
        import android.widget.RadioGroup;
        import android.widget.Toast;

        import com.example.clase1.clase1.Model.Alumno;
        import com.example.clase1.clase1.Model.Person;
        import com.example.clase1.clase1.Model.Profesor;
        import com.google.android.gms.appindexing.Action;
        import com.google.android.gms.appindexing.AppIndex;
        import com.google.android.gms.common.api.GoogleApiClient;

        import java.util.ArrayList;


public class ActividadP extends AppCompatActivity {

    int sexo;
    int tipopersona;
    int tipoprocesar;
    EditText nombre;
    EditText apellido;
    EditText anio;
    EditText materia;
    RadioGroup sexog;
    RadioGroup tipop;
    ArrayList<Person> personas;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        personas = new ArrayList<>();
        setContentView(R.layout.activity_actividad_p);
        nombre = (EditText) findViewById(R.id.nombre);
        apellido = (EditText) findViewById(R.id.apellido);
        anio = (EditText) findViewById(R.id.anio);
        materia = (EditText) findViewById(R.id.materia);
        sexog= (RadioGroup) findViewById(R.id.sexo);
        tipop= (RadioGroup) findViewById(R.id.tipop);


        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    public void btnAgregar(View v) {

        if (nombre.getText().toString().isEmpty() || apellido.getText().toString().isEmpty() && (anio.getText().toString().isEmpty() || materia.getText().toString().isEmpty())) {
            Toast.makeText(this, "Campos incompletos", Toast.LENGTH_SHORT).show();
            return;

        }
        ImageView vv;
        Person p;

        if (tipopersona == 1) {
            p = new Profesor(nombre.getText().toString(), apellido.getText().toString(), sexo, materia.getText().toString());
        } else {
            p = new Alumno(nombre.getText().toString(), apellido.getText().toString(), sexo, anio.getText().toString());
        }
        personas.add(p);
        nombre.setText("");
        apellido.setText("");
        anio.setText("");
        materia.setText("");
        sexog.clearCheck();
        tipop.clearCheck();
        Toast.makeText(this, "Agregado", Toast.LENGTH_SHORT).show();
        // intent.putExtra("pers1", p);
        // startActivity(intent);

    }

    public void btnListar(View V) {
        for (Person per: personas){
            try {
                Log.d("persona", per.imprimir());
                Toast.makeText(this, "Listado", Toast.LENGTH_SHORT).show();
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public void btnProcesar(View view) {
        Intent intent = new Intent(this, Actividadsec.class);

        if (tipoprocesar==1) {
            int mas = 0;
            String masnombre = "";
            for (int i = 0; i < personas.size(); i++) {
                String nombre = personas.get(i).getNombre();
                if (nombre.length() > masnombre.length()) {
                    mas = i;
                    masnombre = nombre;
                }
            }
            intent.putExtra("persona", personas.get(mas));
            startActivity(intent);
        }else {
            if (tipoprocesar==2){
                Person masa=personas.get(0);
                int canta= 0;
                for (Person per:personas ){
                    String s = per.getNombre();
                    s.toLowerCase();
                    int counter = 0;
                    for( int i=0; i<s.length(); i++ ) {
                        if( s.charAt(i) == 'a' ) {
                            counter++;
                        }
                    }
                    if (counter>canta){
                        masa=per;
                        canta=counter;
                    }
                }
                intent.putExtra("persona", masa);
                startActivity(intent);
            }
            if (tipoprocesar==0){
                Toast.makeText(this, "Seleccione una opción.", Toast.LENGTH_SHORT).show();
            }
        }





        }


    public void eligeProceso (View view) {
        tipoprocesar = 0;
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.maslargo:
                if (checked)
                    tipoprocesar = 1;
                break;
            case R.id.masa:
                if (checked)
                    tipoprocesar = 2;
                break;
        }
    }



    public void eligeSexo(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.masculino:
                if (checked)
                    sexo = Person.MASCULINO;
                break;
            case R.id.femenino:
                if (checked)
                    sexo = Person.FEMENINO;
                break;
        }
        switch (view.getId()) {
            case R.id.profesor:
                if (checked)
                    tipopersona = 1;
                View chauanio = findViewById(R.id.anio);
                chauanio.setVisibility(View.INVISIBLE);
                View materia = findViewById(R.id.materia);
                materia.setVisibility(View.VISIBLE);

                break;
            case R.id.alumno:
                if (checked)
                    tipopersona = 2;
                View materiachau = findViewById(R.id.materia);
                materiachau.setVisibility(View.INVISIBLE);
                View anio = findViewById(R.id.anio);
                anio.setVisibility(View.VISIBLE);
                break;
        }


    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "ActividadP Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.clase1.clase1/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "ActividadP Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.clase1.clase1/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}