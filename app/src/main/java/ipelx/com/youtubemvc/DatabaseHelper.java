package ipelx.com.youtubemvc;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "movies_db";
    private static final String TB_NAME = "movie";
    private static final String COL_TITLE = "title";
    private static final String COL_ID = "id";
    public static final String CREATE_TABLE =
            "CREATE TABLE " + TB_NAME + "("
                    + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COL_TITLE + " TEXT"
                    + ")";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public long insert(String title){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COL_TITLE,title);
        long id = sqLiteDatabase.insert(TB_NAME,null,cv);
        sqLiteDatabase.close();
        return id;
    }

    public ArrayList<MovieModel> getAllMovies(){
        ArrayList<MovieModel> models = new ArrayList<>();
        String selectQuery = "SELECT  * FROM " + TB_NAME + " ORDER BY " +
                COL_ID + " DESC";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery,null);

        if(cursor.moveToFirst()){
            do {
                MovieModel movieModel = new MovieModel(cursor.getString(cursor.getColumnIndex(COL_TITLE)));
                models.add(movieModel);
            }while (cursor.moveToNext());
        }

        db.close();
        return models;
    }
}
