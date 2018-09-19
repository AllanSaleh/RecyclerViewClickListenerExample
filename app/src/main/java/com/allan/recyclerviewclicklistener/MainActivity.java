package com.allan.recyclerviewclicklistener;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements PersonAdapter.ListItemClickListener{
    RecyclerView recyclerView;
    ArrayList<Person> people;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recycler_view);
        people = new ArrayList<>();

        people.add(new Person("Allan"));
        people.add(new Person("Ehsan"));
        people.add(new Person("Alan"));
        people.add(new Person("Mohammad"));
        people.add(new Person("Xoshnaw"));

        PersonAdapter personAdapter = new PersonAdapter(people,this);
        recyclerView.setAdapter(personAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
    }

    @Override
    public void onItemClicked(int itemClickedPosition) {
        Person person = people.get(itemClickedPosition);
        Toast.makeText(this, person.getName(), Toast.LENGTH_SHORT).show();
    }
}
