package com.example.amin.gs2204;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBConnections extends SQLiteOpenHelper {
    public static final String  DbName="aaa.db";
    public static final int Verson=1;
    // public static final int NAME_COLUMN = 1;


    public  DBConnections(Context context){

        super(context, DbName, null, Verson);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table IF NOT EXISTS employe(id INTEGER primary key,name TEXT,Role TEXT,nomutilisateur TEXT,motdepasse INTEGER)");
        db.execSQL("create table IF NOT EXISTS projet(ID_P INTEGER primary key,Nom_P TEXT,montant_P INTEGER,datedeb_P TEXT,datefin_P TEXT,Responsable_P TEXT)");
        db.execSQL("create table IF NOT EXISTS operation(ID_O INTEGER primary key,Nom_O TEXT,datedeb_O TEXT,datefin_O TEXT,Responsable_O TEXT)");
        db.execSQL("create table IF NOT EXISTS activite(ID_A INTEGER primary key,Nom_A TEXT,datedeb_A TEXT,datefin_A TEXT,Responsable_A TEXT)");
        db.execSQL("create table IF NOT EXISTS tache(ID_T INTEGER primary key,Nom_T TEXT,datedeb_T TEXT,datefin_T TEXT,Responsable_T TEXT)");
        db.execSQL("create table IF NOT EXISTS admin(nom TEXT,mdp INTEGER)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop table if EXISTS employe");
        db.execSQL("Drop table if EXISTS projet");
        db.execSQL("Drop table if EXISTS operationne");
        db.execSQL("Drop table if EXISTS activite");
        db.execSQL("Drop table if EXISTS tache");
        db.execSQL("Drop table if EXISTS admin");
        onCreate(db);
    }

    public String getSinlgeEntry(String nomutilisateur,String Role)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select nomutilisateur,motdepasse,Role from employe where nomutilisateur='" + nomutilisateur + "' AND Role='" + Role + "'",null);
        //Cursor res =  db.query("employe", null, " nomutilisateur=?", new String[]{nomutilisateur}, null, null, null);


        if(res.getCount()<1) // UserName Not Exist
        {
            res.close();
            return "NOT EXIST";
        }
        res.moveToFirst();
        String password= res.getString(res.getColumnIndex("motdepasse"));
       // String var1= res.getString(res.getColumnIndex("Role"));

        res.close();
        return password;

    }

    public void  InsertE(String name,String nomutilisateur,Integer motdepasse, String Role){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("Role", Role);
        contentValues.put("nomutilisateur", nomutilisateur);
        contentValues.put("motdepasse", motdepasse);
        db.insert("employe", null, contentValues);
        //  db.execSQL("INSERT INTO admin(name,Role) VALUES (?,?)");

    }
    // Indert projet
    public void  InsertP(String Nom_P,Integer montant_P,String datedeb_P,String datefin_P,String Responsable_P){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("Nom_P", Nom_P);
        contentValues.put("montant_P", montant_P);
        contentValues.put("datedeb_P", datedeb_P);
        contentValues.put("datefin_P", datefin_P);
        contentValues.put("Responsable_P", Responsable_P);
        db.insert("projet", null, contentValues);

        //  db.execSQL("INSERT INTO admin(name,Role) VALUES (?,?)");
    }
    // InSert OPERATION
    public void  InsertO(String Nom_O,String datedeb_O,String datefin_O,String Responsable_O){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("Nom_O", Nom_O);

        contentValues.put("datedeb_O", datedeb_O);
        contentValues.put("datefin_O", datefin_O);
        contentValues.put("Responsable_O", Responsable_O);
        db.insert("operation", null, contentValues);

        //  db.execSQL("INSERT INTO admin(name,Role) VALUES (?,?)");
    }
    // InSert ACTIVITE
    public void  InsertA(String Nom_A,String datedeb_A,String datefin_A,String Responsable_A){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Nom_A", Nom_A);
        contentValues.put("datedeb_A", datedeb_A);
        contentValues.put("datefin_A", datefin_A);
        contentValues.put("Responsable_A", Responsable_A);
        db.insert("activite", null, contentValues);
        //  db.execSQL("INSERT INTO admin(name,Role) VALUES (?,?)");
    }
    // InSert tache
    public void  InsertT(String Nom_T,String datedeb_T,String datefin_T,String Responsable_T){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Nom_T", Nom_T);
        contentValues.put("datedeb_T", datedeb_T);
        contentValues.put("datefin_T", datefin_T);
        contentValues.put("Responsable_T", Responsable_T);
        db.insert("tache", null, contentValues);

        //  db.execSQL("INSERT INTO admin(name,Role) VALUES (?,?)");
    }


    // get all record employe
    public ArrayList getAllrecord()
    {
        ArrayList array_list = new ArrayList();
        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from employe", null );
        res.moveToFirst();
        while(res.isAfterLast() == false) {
            array_list.add(res.getString(res.getColumnIndex("id")) + ":" + res.getString(res.getColumnIndex("name"))
                    + ":" + res.getString(res.getColumnIndex("Role"))+ ":" + res.getString(res.getColumnIndex("nomutilisateur"))+ ":" + res.getString(res.getColumnIndex("motdepasse")));
            res.moveToNext();

        }
        return array_list;
    }
    // get all record projet
    public ArrayList getAllrecordP()
    {
        ArrayList array_list = new ArrayList();
        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from projet", null );
        res.moveToFirst();
        while(res.isAfterLast() == false) {
            array_list.add(res.getString(res.getColumnIndex("ID_P")) + ":" + res.getString(res.getColumnIndex("Nom_P"))
                    + ":" + res.getString(res.getColumnIndex("montant_P"))+ ":" + res.getString(res.getColumnIndex("datedeb_P"))
                    + ":" + res.getString(res.getColumnIndex("datefin_P"))+ ":" + res.getString(res.getColumnIndex("Responsable_P")));
            ;
            res.moveToNext();

        }
        return array_list;
    }
    // get all record OPERATION
    public ArrayList getAllrecordO()
    {
        ArrayList array_list = new ArrayList();
        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from operation", null );
        res.moveToFirst();
        while(res.isAfterLast() == false) {
            array_list.add(res.getString(res.getColumnIndex("ID_O")) + ":" + res.getString(res.getColumnIndex("Nom_O"))
                    + ":" + res.getString(res.getColumnIndex("datedeb_O"))
                    + ":" + res.getString(res.getColumnIndex("datefin_O"))+ ":" + res.getString(res.getColumnIndex("Responsable_O")));
            ;
            res.moveToNext();

        }
        return array_list;
    }
    // get all record ACTIVITE
    public ArrayList getAllrecordA()
    {
        ArrayList array_list = new ArrayList();
        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from activite", null );
        res.moveToFirst();
        while(res.isAfterLast() == false) {
            array_list.add(res.getString(res.getColumnIndex("ID_A")) + ":" + res.getString(res.getColumnIndex("Nom_A"))
                    + ":" + res.getString(res.getColumnIndex("datedeb_A"))
                    + ":" + res.getString(res.getColumnIndex("datefin_A"))+ ":" + res.getString(res.getColumnIndex("Responsable_A")));
            ;
            res.moveToNext();

        }
        return array_list;
    }
    // get all record TACHE
    public ArrayList getAllrecordT()
    {
        ArrayList array_list = new ArrayList();
        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery("select * from tache", null);
        res.moveToFirst();
        while(res.isAfterLast() == false) {
            array_list.add(res.getString(res.getColumnIndex("ID_T")) + ":" + res.getString(res.getColumnIndex("Nom_T"))
                    + ":" + res.getString(res.getColumnIndex("datedeb_T"))
                    + ":" + res.getString(res.getColumnIndex("datefin_T"))+ ":" + res.getString(res.getColumnIndex("Responsable_T")));
            ;
            res.moveToNext();

        }
        return array_list;
    }


    // delete employe
    public void deleteE (Integer id)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from employe where id=" + Integer.toString(id));
        // db.delete("admin", "id = ?,name=? ", new String[] { Integer.toString(id) ,"hussien"});
    }
    // delete projet
    public void deleteP (Integer ID_P)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from projet where ID_P=" + Integer.toString(ID_P));
        // db.delete("admin", "id = ?,name=? ", new String[] { Integer.toString(id) ,"hussien"});
    }
    // delete OPERATION
    public void deleteO (Integer ID_O)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from operation where ID_O="+ Integer.toString(ID_O));
        // db.delete("admin", "id = ?,name=? ", new String[] { Integer.toString(id) ,"hussien"});
    }
    // delete ACTIVITE
    public void deleteA (Integer ID_A)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from activite where ID_A="+ Integer.toString(ID_A));
        // db.delete("admin", "id = ?,name=? ", new String[] { Integer.toString(id) ,"hussien"});
    }
    // delete TACHE
    public void deleteT (Integer ID_T)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from tache where ID_T="+ Integer.toString(ID_T));
        // db.delete("admin", "id = ?,name=? ", new String[] { Integer.toString(id) ,"hussien"});
    }
    //update employe

    public void  updateE (String name,String nomutilisateur,Integer motdepasse,String Role,Integer id )
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("name",name);
        contentValues.put("Role",Role);
        contentValues.put("nomutilisateur",nomutilisateur);
        contentValues.put("motdepasse",motdepasse);


        db.execSQL("update employe set name='"+name+"',Role='"+Role+"',nomutilisateur='"+nomutilisateur+"',motdepasse='"+motdepasse+"' where id="+ Integer.toString(id));
  /* ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        db.update("admin", contentValues, "id = ? ", new String[] { Integer.toString(id) } );*//**//**/

    }
    // update projet
    public void  updateP (String Nom_P,Integer montant_P,String datedeb_P,String datefin_P,String Responsable_P,Integer ID_P )
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("Nom_P", Nom_P);
        contentValues.put("montant_P", montant_P);
        contentValues.put("datedeb_P", datedeb_P);
        contentValues.put("datefin_P", datefin_P);
        contentValues.put("Responsable_P", Responsable_P);
        db.execSQL("update projet set Nom_P='"+Nom_P+"',montant_P='"+montant_P+"',datedeb_P='"+datedeb_P+"',datefin_P='"+datefin_P+"',Responsable_P='"+Responsable_P+"' where ID_P="+ Integer.toString(ID_P));

    }
    // update OPEARATION
    public void  updateO (String Nom_O,String datedeb_O,String datefin_O,String Responsable_O,Integer ID_O )
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("Nom_O", Nom_O);
        contentValues.put("datedeb_O", datedeb_O);
        contentValues.put("datefin_O", datefin_O);
        contentValues.put("Responsable_O", Responsable_O);
        db.execSQL("update operation set Nom_O='"+Nom_O+"',datedeb_O='"+datedeb_O+"',datefin_O='"+datefin_O+"',Responsable_O='"+Responsable_O+"' where ID_O="+ Integer.toString(ID_O));
    }
    // update ACTIVITE
    public void  updateA (String Nom_A,String datedeb_A,String datefin_A,String Responsable_A,Integer ID_A )
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("Nom_A", Nom_A);
        contentValues.put("datedeb_A", datedeb_A);
        contentValues.put("datefin_A", datefin_A);
        contentValues.put("Responsable_A", Responsable_A);
        db.execSQL("update activite set Nom_A='"+Nom_A+"',datedeb_A='"+datedeb_A+"',datefin_A='"+datefin_A+"',Responsable_A='"+Responsable_A+"' where ID_A="+ Integer.toString(ID_A));
    }
    // update TACHE
    public void  updateT (String Nom_T,String datedeb_T,String datefin_T,String Responsable_T,Integer ID_T )
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("Nom_T", Nom_T);
        contentValues.put("datedeb_T", datedeb_T);
        contentValues.put("datefin_T", datefin_T);
        contentValues.put("Responsable_T", Responsable_T);
        db.execSQL("update tache set Nom_T='"+Nom_T+"',datedeb_T='"+datedeb_T+"',datefin_T='"+datefin_T+"',Responsable_T='"+Responsable_T+"' where ID_T="+ Integer.toString(ID_T));


    }


}