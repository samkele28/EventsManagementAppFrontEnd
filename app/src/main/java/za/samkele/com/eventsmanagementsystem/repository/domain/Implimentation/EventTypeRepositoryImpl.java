package za.samkele.com.eventsmanagementsystem.repository.domain.Implimentation;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.HashSet;
import java.util.Set;

import za.samkele.com.eventsmanagementsystem.config.databases.DBConnClass;
import za.samkele.com.eventsmanagementsystem.domain.EventType;
import za.samkele.com.eventsmanagementsystem.repository.domain.EventTypeRepository;

/**
 * Created by Samkele on 5/14/2016.
 */
public class EventTypeRepositoryImpl extends SQLiteOpenHelper implements EventTypeRepository {
    public static final String TABLE_EVENT_TYPE = "event_type";
    private SQLiteDatabase db;

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_STATUS = "description";

    // Database creation sql statement
    private static final String CREATE_EVENT_TYPE_TABLE = "CREATE TABLE "
            + TABLE_EVENT_TYPE + "("
            + COLUMN_ID + "INTEGER PRIMARY KEY,"
            + COLUMN_NAME + "TEXT,"
            + COLUMN_STATUS + "TEXT" + ")";

    public EventTypeRepositoryImpl(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context, DBConnClass.DATABASE_NAME, factory, DBConnClass.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(CREATE_EVENT_TYPE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        Log.w(this.getClass().getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_EVENT_TYPE);
        onCreate(db);
    }

    public void open() throws SQLException {
        db = this.getWritableDatabase();
    }

    public void close() {
        this.close();
    }

    @Override
    public EventType save(EventType entity) {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getEventTypeId());
        values.put(COLUMN_NAME, entity.getEventTypeName());
        values.put(COLUMN_STATUS, entity.getStatus());
        long id = db.insertOrThrow(TABLE_EVENT_TYPE, null, values);
        EventType insertedEntity = new EventType.Builder()
                .copy(entity)
                .eventTypeId(new Long(id))
                .build();
        return insertedEntity;
    }

    @Override
    public Set<EventType> findAll() {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectAll = " SELECT * FROM " + TABLE_EVENT_TYPE;
        Set<EventType> eventsType = new HashSet<>();
        open();
        Cursor cursor = db.rawQuery(selectAll, null);
        if (cursor.moveToFirst()) {
            do {
                final EventType eventType = new EventType.Builder()
                        .eventTypeId(cursor.getLong(0))
                        .eventTypeName(cursor.getString(1))
                        .status(cursor.getString(2))
                        //.startDate(cursor.getString(3))
                        .build();
                eventsType.add(eventType);
            } while (cursor.moveToNext());
        }

        return eventsType;
    }

    @Override
    public EventType findById(Long id) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(
                TABLE_EVENT_TYPE,
                new String[]{
                        COLUMN_ID,
                        COLUMN_NAME,
                        COLUMN_STATUS},
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(id)},
                null,
                null,
                null,
                null);
        if (cursor.moveToFirst()) {
            final EventType eventType = new EventType.Builder()
                    .eventTypeId(cursor.getLong(0))
                    .eventTypeName(cursor.getString(1))
                    .status(cursor.getString(2))
                    .build();

            return eventType;
        } else {
            return null;
        }
    }

    @Override
    public EventType update(EventType entity) {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getEventTypeId());
        values.put(COLUMN_NAME, entity.getEventTypeName());
        values.put(COLUMN_STATUS, entity.getStatus());
        db.update(
                TABLE_EVENT_TYPE,
                values,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getEventTypeId())}
        );
        return entity;
    }

    /*public boolean deleteEmployee(String employeeNumber){
        boolean result = false;

        String query = "SELECT * " + TABLE_EMPLOYEE + " WHERE " + COLUMN_EMPNUMBER + " = \"" + employeeNumber + "\"";
        db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        Employee employee = new Employee();

        if(cursor.moveToFirst()){
            employee.setEmpId(Long.parseLong(cursor.getString(0)));
            db.delete(TABLE_EMPLOYEE, COLUMN_ID + " = ?",
                    new String[]{
                            String.valueOf(employee.getEmpId())
                    });
            cursor.close();
            result = true;
            }
        db.close();
        return result;
    }*/

    @Override
    public EventType delete(EventType entity) {
        open();
        db.delete(
                TABLE_EVENT_TYPE,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getEventTypeId())});
        return entity;
    }

    @Override
    public int deleteAll() {
        open();
        int rowsDeleted = db.delete(TABLE_EVENT_TYPE,null,null);
        close();
        return rowsDeleted;
    }
}
