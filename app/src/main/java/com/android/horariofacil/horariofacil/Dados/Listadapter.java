package com.android.horariofacil.horariofacil.Dados;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.android.horariofacil.horariofacil.R;

import java.util.HashMap;
import java.util.List;

/**
 * Created by lucas on 25/06/17.
 */

public class Listadapter extends BaseExpandableListAdapter {

    private Cursor materias;

    private List<String> header_titles;
    private HashMap<String,List<String>> child_titles;
    private Context context;

    public Listadapter(List<String> header_titles, HashMap<String, List<String>> child_titles, Context context, Cursor materias) {
        this.header_titles = header_titles;
        this.child_titles = child_titles;
        this.context = context;
        this.materias = materias;
    }

    @Override
    public int getGroupCount() {
        return header_titles.size();
    }

    public void setCheckBoxChild(CheckBox checkBox, int groupPosition, int childPosition) {
        if (getChildMateriaCod(groupPosition, childPosition).equals("000000"))
            checkBox.setVisibility(View.GONE);
        else{
            switch (groupPosition) {
                case 0:
                    checkBox.setChecked(true);
                    break;
                case 1:
                    checkBox.setChecked(false);
                    break;
                case 2:
                    checkBox.setVisibility(View.GONE);
                    break;
            }
        }
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return child_titles.get(header_titles.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return header_titles.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        materias.moveToFirst();
        do{
            if(materias.getString(materias.getColumnIndexOrThrow(HorarioFacilContract.MateriasEntry.COLUMN_COD_MATERIA))
                    .equals(child_titles.get(header_titles.get(groupPosition)).get(childPosition)))
                return materias.getString(materias.getColumnIndexOrThrow(HorarioFacilContract.MateriasEntry.COLUMN_DISCIPLINA));
            materias.moveToNext();
        }while(!materias.isLast());
        if(child_titles.get(header_titles.get(groupPosition)).get(childPosition).equals("000000"))
            return context.getResources().getString(R.string.prompt_concluida_vazia);
        return child_titles.get(header_titles.get(groupPosition)).get(childPosition);
    }

    public String getChildMateriaCod(int groupPosition, int childPosition) {
        return child_titles.get(header_titles.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String title = (String)this.getGroup(groupPosition);
        if(convertView == null){
            LayoutInflater layoutInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView =layoutInflater.inflate(R.layout.parent_layout,null);
        }

        TextView textView = (TextView)convertView.findViewById(R.id.heading_item);
        textView.setTypeface(null, Typeface.BOLD);
        textView.setText(title);

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        if(convertView == null){
            LayoutInflater layoutInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView =layoutInflater.inflate(R.layout.child_layout,null);
        }

        final EditText codMateriaText = (EditText) convertView.findViewById(R.id.cod_Materia);
        codMateriaText.setText(getChildMateriaCod(groupPosition, childPosition));

        String title = (String) this.getChild(groupPosition,childPosition);

        final TextView textView = (TextView) convertView.findViewById(R.id.child_item);
        textView.setText(title);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                descricaoMateria(codMateriaText.getText().toString());
            }
        });

        CheckBox checkBox = (CheckBox) convertView.findViewById(R.id.check_disciplina);
        setCheckBoxChild(checkBox, groupPosition, childPosition);



        return convertView;
    }

    private void descricaoMateria(String codMateria){
        Context context = this.context;
        Class descricaoMateria = com.android.horariofacil.horariofacil.MateriaActivity.class;

        Intent intentDescricao = new Intent(context, descricaoMateria);
        intentDescricao.putExtra("codMateria", codMateria);
        context.startActivity(intentDescricao);
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
