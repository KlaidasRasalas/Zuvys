package com.example.zuvys;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IkeltiZuvi extends AppCompatActivity {

    DatabaseReference reff;
    EditText mEditText, mEditText2;
    Button mButton4,mButton5,mButton6;
    RadioButton radioButton,radioButton1;
    RadioGroup radioGroup;
    ImageView image;
    StorageReference mStorageRef;
    public Uri imguri;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_ikelti_zuvi);

        mEditText = findViewById(R.id.editText);
        mEditText2 = findViewById(R.id.editText2);
        mButton5 = findViewById(R.id.button5);
        radioGroup = findViewById(R.id.radioGroup2);
        mButton4 = findViewById(R.id.button4);
        mButton6 = findViewById(R.id.button6);
        image = findViewById(R.id.imageView);
        mStorageRef = FirebaseStorage.getInstance().getReference("Images");

        mButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Filechooser();
            }
        });
        reff = FirebaseDatabase.getInstance().getReference().child("Žuvys");


        mButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String zuvis1 = reff.child("Karpis").getKey();
                String zuvis2 = reff.child("Ešerys").getKey();
                String zuvis3 = reff.child("Lydeka").getKey();
                String zuvis = mEditText.getText().toString().trim();
                if (!zuvis.equals(zuvis1) && !zuvis.equals(zuvis2) && !zuvis.equals(zuvis3)) {
                    addZuvis();
                } else {
                    mEditText.setError("Tokia žuvis jau yra");
                }
            }
        });

        mButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAtsaukti();

            }
        });
    }

    public void checkButton(View v) {
        int radioID = radioGroup.getCheckedRadioButtonId();
        radioButton = findViewById(radioID);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode== 1 && resultCode==RESULT_OK && data!=null && data.getData()!=null) {
            imguri=data.getData();
            image.setImageURI(imguri);
        }
    }

    private String getExtension(Uri uri) {
        ContentResolver cr = getContentResolver();
        MimeTypeMap mimeTypeMap = MimeTypeMap.getSingleton();
        return mimeTypeMap.getExtensionFromMimeType(cr.getType(uri));

    }

    public void Filechooser() {

        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, 1);

    }

        public void addZuvis () {
            String pavadinimas = mEditText.getText().toString().trim();
            String aprasymas = mEditText2.getText().toString().trim();

            StorageReference Ref = mStorageRef.child(System.currentTimeMillis() + "." + getExtension(imguri));

            Ref.putFile(imguri)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            // Get a URL to the uploaded content
                            // Uri downloadUrl = taskSnapshot.getDownloadUrl();

                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception exception) {
                            // Handle unsuccessful uploads
                            // ...
                        }
                    });

            String id = pavadinimas;
            int radioID = radioGroup.getCheckedRadioButtonId();
            radioButton = findViewById(radioID);
            Pattern digit = Pattern.compile("1");
            Matcher hasDigit = digit.matcher(id);
            String zuvis1 = reff.child("Žuvys").getKey();

            if (radioID == 2131165401) {
                Zuvis Zuvis = new Zuvis(pavadinimas, aprasymas);
                reff.child(id+"2").setValue(Zuvis);
                Toast.makeText(this, "Žuvis išsaugota administracijos patikrinimui " +zuvis1, Toast.LENGTH_LONG).show();
                openAtsaukti();
            } else if (radioID ==2131165402) {
                Zuvis Zuvis = new Zuvis(pavadinimas, aprasymas);
                reff.child(id + "22").setValue(Zuvis);
                Toast.makeText(this, "Žuvis išsaugota administracijos patikrinimui", Toast.LENGTH_LONG).show();
                openAtsaukti();
            }
        }




    public void openAtsaukti() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}


