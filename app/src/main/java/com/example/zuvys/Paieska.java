package com.example.zuvys;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.MimeTypeMap;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.appcompat.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;



import com.baoyz.swipemenulistview.SwipeMenu;
import com.baoyz.swipemenulistview.SwipeMenuCreator;
import com.baoyz.swipemenulistview.SwipeMenuItem;
import com.baoyz.swipemenulistview.SwipeMenuListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import static android.media.CamcorderProfile.get;

public class Paieska extends AppCompatActivity {
    DatabaseReference reff;
   // ListView mlistView;
    Toolbar toolbar1;
    SearchView searchView;
    SwipeMenuListView mlistView;
    ArrayList<String> arrayList = new ArrayList<>();
    ArrayList<String> aprasymuArrayList = new ArrayList<>();
    ArrayAdapter<String> arrayAdapter;
    TextView mTextView,mTextView6;
    Button mButton8,mButton7;
    Zuvis zuvis;
    public Uri imguri;
    ImageView mImageView;
    EditText mEditText3;
    int [] image = {R.drawable.back1};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_paieska);

        mlistView = findViewById(R.id.ListView);
       // mButton8 = findViewById(R.id.button8);
       // mEditText3 = findViewById(R.id.editText3);
       // toolbar = findViewById(R.id.toolbar);
     //   searchView = findViewById(R.id.searchView);
        toolbar1 = findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar1);
        getSupportActionBar().setTitle("Gėlavandenės");


        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayList);
        mlistView.setAdapter(arrayAdapter);



        SwipeMenuCreator creator = new SwipeMenuCreator() {

            @Override
            public void create(SwipeMenu menu) {


                // create "delete" item
                SwipeMenuItem deleteItem = new SwipeMenuItem(
                        getApplicationContext());
                // set item background
                deleteItem.setBackground(new ColorDrawable(Color.rgb(0xF9,
                        0x3F, 0x25)));
                // set item width
                deleteItem.setWidth(180);
                // set a icon
                deleteItem.setIcon(R.drawable.ic_delete);
                // add to menu
                menu.addMenuItem(deleteItem);
            }
        };
        mlistView.setMenuCreator(creator);

        mlistView.setOnMenuItemClickListener(new SwipeMenuListView.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(final int position, SwipeMenu menu, int index) {
                switch (index) {
                    case 0:
                        AlertDialog.Builder adb=new AlertDialog.Builder(Paieska.this);
                        adb.setTitle("Ištrinti?");
                        adb.setMessage("Tikrai norite išsiųsti " + arrayList.get(position).trim() + " ištrynimo užklausą?");
            //            final int positionToRemove = position;
                        adb.setNegativeButton("Atšaukti", null);
                        adb.setPositiveButton("Gerai", new AlertDialog.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                         final String ID = arrayList.get(position).trim().toString();
                                Intent intent = new Intent(Paieska.this, Zuvys.class);
                                intent.putExtra("Pavadinimas", arrayList.get(position));
                                intent.putExtra("Aprasymas", aprasymuArrayList.get(position));


                                Zuvis Zuvis = new Zuvis(arrayList.get(position), aprasymuArrayList.get(position));
                                reff.child(ID).removeValue();
                                arrayAdapter.notifyDataSetChanged();
                                reff.child(ID+"d").setValue(Zuvis);
                                Toast.makeText(Paieska.this, "Ištrinimo užklausa išsiųsta" , Toast.LENGTH_SHORT).show();

                         /*
                                arrayList.remove(ID);
                                arrayAdapter.notifyDataSetChanged();
                                Toast.makeText(getApplicationContext(),"Žuvis ištrinta",Toast.LENGTH_LONG).show();
                                reff.child("Žuvis").child(ID).addListenerForSingleValueEvent(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                        reff.child(ID).removeValue();

                                    }

                                    @Override
                                    public void onCancelled(@NonNull DatabaseError databaseError) {

                                    }
                                });
*/
                            }});
                        adb.show();



                        break;
                }
                // false : close the menu; true : not close the menu
                return false;
            }
        });
    //    mTextView5 = findViewById(R.id.textView5);
     //   mTextView6 = findViewById(R.id.textView6);
      //  mButton7 = findViewById(R.id.button7);
      //  mImageView = findViewById(R.id.imageView2);


        reff = FirebaseDatabase.getInstance().getReference("Žuvys");

        reff.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                String value = dataSnapshot.getValue(Zuvis.class).toString();
                String value1 = dataSnapshot.getKey();

                if (!value1.matches(".*\\d.*")) {
                    arrayList.add(value);
                    arrayAdapter.notifyDataSetChanged();
                    aprasymuArrayList.add(dataSnapshot.getValue(Zuvis.class).aprasymas);
                    arrayAdapter.notifyDataSetChanged();


                    mlistView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                            Intent intent = new Intent(Paieska.this, Zuvys.class);
                            intent.putExtra("Pavadinimas", arrayList.get(position));
                            intent.putExtra("Aprasymas", aprasymuArrayList.get(position));

                            startActivity(intent);

                        }
                    });
                }
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                arrayAdapter.notifyDataSetChanged();

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {


            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        }

        public boolean onCreateOptionsMenu (Menu menu) {

            getMenuInflater().inflate(R.menu.toolbar, menu);

            MenuItem menuItem = menu.findItem(R.id.app_bar_search);
            SearchView searchView = (SearchView) menuItem.getActionView();
            searchView.setQueryHint("Įveskite pavadinimą");

            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);


            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String newText) {
                    arrayAdapter.getFilter().filter(newText);
                    arrayAdapter.notifyDataSetChanged();
                    return true;
                }
            });

            return super.onCreateOptionsMenu(menu);



        }

        public boolean onOptionsItemSelected(MenuItem item) {
            if (item.getItemId()==android.R.id.home)
            {
                finish();
            }
            return super.onOptionsItemSelected(item);
        }

    private String getExtension(Uri uri) {
        ContentResolver cr = getContentResolver();
        MimeTypeMap mimeTypeMap = MimeTypeMap.getSingleton();
        return mimeTypeMap.getExtensionFromMimeType(cr.getType(uri));

    }
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode== 1 && resultCode==RESULT_OK && data!=null && data.getData()!=null) {
            imguri=data.getData();
            mImageView.setImageURI(imguri);
        }

    }
    public void openPradzia() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }

}

