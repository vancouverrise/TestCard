package iks.market.testcard;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;

import net.steamcrafted.loadtoast.LoadToast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import iks.market.testcard.Database.DocHeader;

public class MainActivity extends AppCompatActivity {
    MaterialButton buttonAdd, buttonSearch;
    RecyclerView recyclerView;
    MyAdapter myAdapter;
    Context context;
    DocumentsDatabase documentsDatabase;
    Model model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler);
        buttonAdd = findViewById(R.id.buttonAdd);
        buttonSearch = findViewById(R.id.buttonSearch);
        context = this.getApplicationContext();

        documentsDatabase = DocumentsDatabase.getInstance(this);
        documentsDatabase.docHeaderDao().getDocumentsHeaderList();
        documentsDatabase.docBodyDao().getDocBodyList();

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random random = new Random();
                int n = random.nextInt(500000);
                n += 1;
                DocHeader docHeader = new DocHeader(String.valueOf(n), "313131", "Рандом компания", "Подсчет склада");
                documentsDatabase.docHeaderDao().insertDocuments(docHeader);

            }
        });

        buttonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }});


        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        myAdapter = new MyAdapter(this, getAnotherStuff());
        recyclerView.setAdapter(myAdapter);
    }

    private ArrayList<Model> getAnotherStuff() {
        ArrayList<Model> othermodels = new ArrayList<>();
        List<DocHeader> tempheader = documentsDatabase.docHeaderDao().getDocumentsHeaderList();

        if (tempheader.size() > 0){
            for (int i = 0; i < tempheader.size(); i++) {
                model = new Model();
                model.setTitle("#" + tempheader.get(i).documentNumber);
                model.setVendoirId("Код: " +tempheader.get(i).code);
                model.setDescription("Описание: " + tempheader.get(i).description);
                model.setVendorName("Лицо: " + tempheader.get(i).name);
                othermodels.add(model);
            }
        }


        System.out.println("Size" + tempheader.size());

        return othermodels;
    }

    private ArrayList<Model> getStuff() {
        ArrayList<Model> models = new ArrayList<>();
        Model p = new Model();
        return models;
    }
}
