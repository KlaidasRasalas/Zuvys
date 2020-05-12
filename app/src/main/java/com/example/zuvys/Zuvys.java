package com.example.zuvys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;

import com.bumptech.glide.Glide;

public class Zuvys extends AppCompatActivity {

    Toolbar toolbar;
    ImageView imageView;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_zuvys);

        toolbar = findViewById(R.id.toolbar2);
        imageView = findViewById(R.id.imageView2);
        textView = findViewById(R.id.textView4);



        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {
            getSupportActionBar().setTitle(bundle.getString("Pavadinimas"));

            textView.setText(bundle.getString("Aprasymas"));
            String name = bundle.getString("Pavadinimas");
            if (name.equals("Ešerys")) {
                String url = "https://firebasestorage.googleapis.com/v0/b/zuvys-e23a1.appspot.com/o/Images%2Feserys.png?alt=media&token=a8eeaa2f-ff4d-4e68-9dcc-e4be2489e609";
                Glide.with(getApplicationContext()).load(url).into(imageView);
            } else if (name.equals("Lašiša")) {
                String url = "https://firebasestorage.googleapis.com/v0/b/zuvys-e23a1.appspot.com/o/Images%2Flasisa.jpg?alt=media&token=9153c3af-6434-4477-9255-a8995dee8a34";
                Glide.with(getApplicationContext()).load(url).into(imageView);
            } else if (name.equals("Lydeka")) {
                String url = "https://firebasestorage.googleapis.com/v0/b/zuvys-e23a1.appspot.com/o/Images%2Flydeka.jpg?alt=media&token=7d9fab00-9936-42d9-b7c4-f0f2a5b38119";
                Glide.with(getApplicationContext()).load(url).into(imageView);
            } else if (name.equals("Lynas")) {
                String url = "https://firebasestorage.googleapis.com/v0/b/zuvys-e23a1.appspot.com/o/Images%2Flynas.jpg?alt=media&token=826518ca-0b13-4a0c-9052-35dfc3522da4";
                Glide.with(getApplicationContext()).load(url).into(imageView);
            } else if (name.equals("Karšis")) {
                String url = "https://firebasestorage.googleapis.com/v0/b/zuvys-e23a1.appspot.com/o/Images%2Fkarsis.jpg?alt=media&token=598ca133-b5ac-4c4d-8d8e-afaa8f997ab8";
                Glide.with(getApplicationContext()).load(url).into(imageView);
            } else if (name.equals("Plekšnė")) {
                String url = "https://firebasestorage.googleapis.com/v0/b/zuvys-e23a1.appspot.com/o/Images%2Fpleksne.jpg?alt=media&token=ee69bc3b-3d74-4c08-b1ea-51e218220a36";
                Glide.with(getApplicationContext()).load(url).into(imageView);
            } else if (name.equals("Saulešeris")) {
                String url = "https://firebasestorage.googleapis.com/v0/b/zuvys-e23a1.appspot.com/o/Images%2Fsaleseris.jpg?alt=media&token=791f7a64-0f83-4c90-b679-f9d2b3e8ce2e";
                Glide.with(getApplicationContext()).load(url).into(imageView);
            } else if (name.equals("Šamas")) {
                String url = "https://firebasestorage.googleapis.com/v0/b/zuvys-e23a1.appspot.com/o/Images%2Fsamas.jpeg?alt=media&token=e459208a-6198-449a-8286-3eaaefc99d36";
                Glide.with(getApplicationContext()).load(url).into(imageView);
            } else if (name.equals("Skumbrė")) {
                String url = "https://firebasestorage.googleapis.com/v0/b/zuvys-e23a1.appspot.com/o/Images%2Fskumbre.jpg?alt=media&token=bf7ed06c-e966-442d-aaff-3ddb8ef31d65";
                Glide.with(getApplicationContext()).load(url).into(imageView);
            } else if (name.equals("Starkis")) {
                String url = "https://firebasestorage.googleapis.com/v0/b/zuvys-e23a1.appspot.com/o/Images%2Fstarkis.jpg?alt=media&token=50454c3e-1190-4e37-bff1-3c5871b21b9b";
                Glide.with(getApplicationContext()).load(url).into(imageView);
            } else if (name.equals("Šapalas")) {
                String url = "https://firebasestorage.googleapis.com/v0/b/zuvys-e23a1.appspot.com/o/Images%2Fsapalas.jpg?alt=media&token=d6ebc9bc-22cf-4ca5-856b-e99b390422f7";
                Glide.with(getApplicationContext()).load(url).into(imageView);
            } else if (name.equals("Upėtakis")) {
                String url = "https://firebasestorage.googleapis.com/v0/b/zuvys-e23a1.appspot.com/o/Images%2Fupetakis.jpg?alt=media&token=26298dc3-f078-4583-887d-67935e8e43bc";
                Glide.with(getApplicationContext()).load(url).into(imageView);
            } else if (name.equals("Karpis")) {
                String url = "https://firebasestorage.googleapis.com/v0/b/zuvys-e23a1.appspot.com/o/Images%2Fkarpis.jpg?alt=media&token=be4762ef-aa3d-4178-b329-190d12107fe0";
                Glide.with(getApplicationContext()).load(url).into(imageView);
            } else if (name.equals("Menkė")) {
                String url = "https://firebasestorage.googleapis.com/v0/b/zuvys-e23a1.appspot.com/o/Images%2Fmenke.jpg?alt=media&token=0782cf56-9872-439e-baca-473ecea183bb";
                Glide.with(getApplicationContext()).load(url).into(imageView);
            } else if (name.equals("Adatžuvė")) {
                String url = "https://firebasestorage.googleapis.com/v0/b/zuvys-e23a1.appspot.com/o/Images%2Fadatzuve.jpg?alt=media&token=8e760461-7f8c-4be9-bb02-f175400adbec";
                Glide.with(getApplicationContext()).load(url).into(imageView);
            } else if (name.equals("Alsė")) {
                String url = "https://firebasestorage.googleapis.com/v0/b/zuvys-e23a1.appspot.com/o/Images%2False.jpg?alt=media&token=d6317eb8-1f34-48d3-96a5-5cfab9832f89";
                Glide.with(getApplicationContext()).load(url).into(imageView);
            } else if (name.equals("Builis")) {
                String url = "https://firebasestorage.googleapis.com/v0/b/zuvys-e23a1.appspot.com/o/Images%2Fbuilis.jpg?alt=media&token=0b8dc262-6900-4142-9018-13e01d90cbc8";
                Glide.with(getApplicationContext()).load(url).into(imageView);
            } else if (name.equals("Dyglė")) {
                String url = "https://firebasestorage.googleapis.com/v0/b/zuvys-e23a1.appspot.com/o/Images%2Fdygle.jpg?alt=media&token=df3f7c53-9fdd-46d5-9b0e-a149e13edf88";
                Glide.with(getApplicationContext()).load(url).into(imageView);
            } else if (name.equals("Grundalas")) {
                String url = "https://firebasestorage.googleapis.com/v0/b/zuvys-e23a1.appspot.com/o/Images%2Fgrundalas.jpg?alt=media&token=2c72ca05-cbd0-4860-9926-a4c32626216e";
                Glide.with(getApplicationContext()).load(url).into(imageView);
            } else if (name.equals("Limanda")) {
                String url = "https://firebasestorage.googleapis.com/v0/b/zuvys-e23a1.appspot.com/o/Images%2Flimanda.jpg?alt=media&token=56c9aae3-900d-4e27-ac28-d716b5a3fa76";
                Glide.with(getApplicationContext()).load(url).into(imageView);
            } else if (name.equals("Otas")) {
                String url = "https://firebasestorage.googleapis.com/v0/b/zuvys-e23a1.appspot.com/o/Images%2Fotas.jpg?alt=media&token=eff02a80-ea54-4822-8fa5-46a552ee4f14";
                Glide.with(getApplicationContext()).load(url).into(imageView);
            } else if (name.equals("Ragys")) {
                String url = "https://firebasestorage.googleapis.com/v0/b/zuvys-e23a1.appspot.com/o/Images%2Fragys.jpg?alt=media&token=834e62ac-e934-4d9c-9c18-344d6cb50ecc";
                Glide.with(getApplicationContext()).load(url).into(imageView);
            } else if (name.equals("Tobis")) {
                String url = "https://firebasestorage.googleapis.com/v0/b/zuvys-e23a1.appspot.com/o/Images%2Ftobis.jpg?alt=media&token=f7698a14-2300-4c4d-9a32-902b21013073";
                Glide.with(getApplicationContext()).load(url).into(imageView);
            }
            else if (name.equals("Vėgėlė")) {
                String url = "https://firebasestorage.googleapis.com/v0/b/zuvys-e23a1.appspot.com/o/Images%2Fvegele.jpg?alt=media&token=f0a92db3-2ec3-4f39-8b1f-7fb3f61a3642";
                Glide.with(getApplicationContext()).load(url).into(imageView);
            }
            else if (name.equals("Vėjažuvė")) {
                String url = "https://firebasestorage.googleapis.com/v0/b/zuvys-e23a1.appspot.com/o/Images%2Fvejazuve.jpg?alt=media&token=da569736-97d7-4620-a421-76e3bac57b61";
                Glide.with(getApplicationContext()).load(url).into(imageView);
            } else if (name.equals("Strimelė")) {
                String url = "https://firebasestorage.googleapis.com/v0/b/zuvys-e23a1.appspot.com/o/Images%2Fstrimele.jpg?alt=media&token=9ebe01c5-8a32-4a4f-9491-42c02f1da34d";
                Glide.with(getApplicationContext()).load(url).into(imageView);
            }

        }
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==android.R.id.home)
        {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
