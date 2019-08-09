package iks.market.testcard;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import iks.market.testcard.Database.DocPartnersDao;
import iks.market.testcard.Database.DocBody;
import iks.market.testcard.Database.DocHeader;
import iks.market.testcard.Database.DocHeaderDao;
import iks.market.testcard.Database.DocPartners;
import iks.market.testcard.Database.DocumentBodyDao;


@Database(entities = {DocBody.class, DocHeader.class, DocPartners.class}, exportSchema = false, version = 1)
public abstract class DocumentsDatabase extends RoomDatabase {
    private static final String DOCUMENTS_DB = "documents_db";
    private static DocumentsDatabase instance;

    public static synchronized DocumentsDatabase getInstance(Context context){
        if (instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(), DocumentsDatabase.class, DOCUMENTS_DB)
                    .fallbackToDestructiveMigration().allowMainThreadQueries().build();
        }
        return instance;
    }

    public abstract DocHeaderDao docHeaderDao();
    public abstract DocumentBodyDao docBodyDao();
    public abstract DocPartnersDao partnersDao();


}
