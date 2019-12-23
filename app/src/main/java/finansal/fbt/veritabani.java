package finansal.fbt;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;



public class veritabani extends SQLiteOpenHelper {
    private static final String dbname = "veritabani";
    private static String table_name = "kisiler";
    private static final int dbversion = 1;
    private static final String row_id = "id";
    private static final String row_name = "name";
    private static final String row_phone = "telefon";


    public veritabani(Context contex) {
        super(contex, dbname, null, dbversion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table kisiler (id integer primary key,name text,telefon text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop table if exists kisiler");
        onCreate(db);
    }

    public void veriekle(String ad, String telefon) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("name", ad.trim());
        cv.put("telefon", telefon.trim());
        db.insert("kisiler", null, cv);
        db.close();


    }

    public List<sozluk_veritipi> verilistele() {

        List<sozluk_veritipi> veriler = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String[] sutunlar = {"id", "name", "telefon"};
        Cursor cursor = db.query("kisiler", sutunlar, null, null, null, null, null);
        while (cursor.moveToNext()) {
            veriler.add(new sozluk_veritipi(cursor.getString(1).toString(), cursor.getString(2).toString()  ));
        }
        db.close();
        return veriler;
    }
        public Boolean kontrol(String kelime)
        {

            SQLiteDatabase db = getReadableDatabase();
            String[] sutun = {kelime};
            Cursor cursor = db.rawQuery("select telefon from kisiler where telefon=?",sutun);

            if (cursor.getCount()>0)
                return true;

            else
            return false;

        }

}
