package fr.android.androidexercises;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

public class AbstractAdapter<T> extends BaseAdapter {
    private final List<T> collection;
    private final LayoutInflater inflater;
    private final int ressourceToBind;

    public AbstractAdapter(Context context, List<T> books, int ressourceToBind) {
        this.collection = books;
        this.inflater = LayoutInflater.from(context);
        this.ressourceToBind = ressourceToBind;
    }

    @Override
    public int getCount() {
        return collection.size();
    }

    @Override
    public T getItem(int position) {
        return collection.get(position);
    }

    @Override
    public long getItemId(int position) {
        return getItem(position).hashCode();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(this.ressourceToBind, parent, false);
        }

        return ((ItemView<T>) convertView).bind(getItem(position));
    }

}
