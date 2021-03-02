package com.amoa.studentsdb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

public class EtudiantService {
    Context context;
    SQLiteDatabase dBWritable;
    SQLiteDatabase dBReadable;
    // constructor
    public EtudiantService(Context context){
        InptDBHelper dbHelper = new InptDBHelper(context);
        dBWritable = dbHelper.getWritableDatabase();
        dBReadable = dbHelper.getReadableDatabase();
    }

    // idDernierEtudiantEnregistrer
    public long idDernierEtudiantEnregistre(){
        return 0;
    }

    // sauvegarde un etudiant dans la BD
    public long sauvegarderEtudiant (Etudiant etudiant){
        ContentValues values = new ContentValues();
        values.put("nom",etudiant.getNom());
        values.put("prenom",etudiant.getPrenom());
        values.put("filiere",etudiant.getFiliere());
        values.put("phone",etudiant.getPhone());
        values.put("email",etudiant.getEmail());
        long row = dBWritable.insert("etudiants",null,values);
        return row;
    }

    // update method
    public boolean majEtudiant(long idEtudiant1, Etudiant etudiant2){
        ContentValues values = new ContentValues();
        values.put("nom",etudiant2.getNom());
        values.put("prenom",etudiant2.getPrenom());
        values.put("filiere",etudiant2.getFiliere());
        values.put("phone",etudiant2.getPhone());
        values.put("email",etudiant2.getEmail());
        return dBWritable.update("etudiants",values,"id="+idEtudiant1,null)>0;
    }

    // list of students method
    public ArrayList<Etudiant> listerEtudiants(){
        ArrayList<Etudiant> uneList = new ArrayList<>();
        String colonnes[] = {"id","nom","prenom","filiere"};
        Cursor c = dBReadable.query("etudiants",colonnes,
                null,null,null,null,null);
        if(c != null) {
            c.moveToFirst();
            int numberOfRows = c.getCount();
            for (int counter = 1; counter <= numberOfRows; counter++ ){
                uneList.add(new Etudiant(Long.valueOf(c.getString(0)),
                        c.getString(1),
                        c.getString(2),c.getString(3)));
                c.moveToNext();
            }
        }
        return uneList;

    }

    public ArrayList<Etudiant> displayStudents(){
        ArrayList<Etudiant> uneList = new ArrayList<>();
        String colonnes[] = {"nom","prenom","filiere","phone","email"};
        Cursor c = dBReadable.query("etudiants",colonnes,
                null,null,null,null,null);
        if(c != null) {
            c.moveToFirst();
            int numberOfRows = c.getCount();
            for (int counter = 1; counter <= numberOfRows; counter++ ){
                uneList.add(new Etudiant(
                        c.getString(0),
                        c.getString(1),
                        c.getString(2),
                        c.getString(3),
                        c.getString(4))
                );
                c.moveToNext();
            }
        }
        return uneList;

    }


    // search students by name
    public ArrayList<Etudiant> searchStudentByName(String nom) {
        ArrayList<Etudiant> uneList = new ArrayList<>();
        String colonnes[] = {"id","nom","prenom","filiere"};
        Cursor c = dBReadable.query("etudinats",colonnes,
                "nom like "+nom,null,null,
                null,null);
        if (c != null){
            c.moveToFirst();
            int numberOfRows = c.getCount();
            for (int counter = 1; counter <= numberOfRows; counter++ ){
                uneList.add(new Etudiant(Long.valueOf(c.getString(0)),
                        c.getString(1),
                        c.getString(2),c.getString(3)));
                c.moveToNext();
            }
        }
        return uneList;

    }

    // delete method
    public boolean deleteStudent(long id){
        return dBWritable.delete("etudiants","id="+id,null)>0;
    }
}
