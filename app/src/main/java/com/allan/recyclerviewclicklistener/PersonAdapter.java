package com.allan.recyclerviewclicklistener;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.Holder> {

    private ArrayList<Person> personArrayList;
    private ListItemClickListener listItemClickListener;

    public PersonAdapter(ArrayList<Person> personArrayList, ListItemClickListener listItemClickListener) {
        this.personArrayList = personArrayList;
        this.listItemClickListener = listItemClickListener;
    }

    public interface ListItemClickListener{
        void onItemClicked(int itemClickedPosition);
    }

    @NonNull
    @Override
    public PersonAdapter.Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.list_item, viewGroup, false);
        Holder holder = new Holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull PersonAdapter.Holder holder, int i) {
        Person person = personArrayList.get(i);
        holder.name.setText(person.getName());
    }

    @Override
    public int getItemCount() {
        return personArrayList.size();
    }

    public class Holder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView name;

        public Holder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            listItemClickListener.onItemClicked(getAdapterPosition());
        }
    }
}
