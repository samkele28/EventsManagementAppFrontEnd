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

import za.samkele.com.eventsmanagementsystem.config.DBConnClass;
import za.samkele.com.eventsmanagementsystem.domain.Event;
import za.samkele.com.eventsmanagementsystem.repository.domain.EventRepository;

/**
 * Created by Samkele on 4/27/2016.
 */
public class EventRepositoryImpl extends SQLiteOpenHelper implements EventRepository {
    public static final String TABLE_EVENT = "event";
    private SQLiteDatabase db;

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_DESCRIPTION = "description";
    public static final String COLUMN_START_DATE = "start_date";
    public static final String COLUMN_START_TIME = "start_time";
    public static final String COLUMN_AVAILABLE_SPACE = "available_space";
    public static final String COLUMN_COST_PER_PERSON = "cost_per_person";
    public static final String COLUMN_EMAIL_ADDRESS = "email_address";

    // Database creation sql statement
    private static final String CREATE_EVENT_TABLE = "CREATE TABLE "
            + TABLE_EVENT + "("
            + COLUMN_ID + "INTEGER PRIMARY KEY,"
            + COLUMN_NAME + "TEXT,"
            + COLUMN_DESCRIPTION + "TEXT, "
            + COLUMN_START_DATE + "DATE,"
            + COLUMN_START_TIME + "TIME, "
            + COLUMN_AVAILABLE_SPACE + "NUMBER,"
            + COLUMN_COST_PER_PERSON + "NUMBER, "
            + COLUMN_EMAIL_ADDRESS + "TEXT" + ")";

    public EventRepositoryImpl(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context, DBConnClass.DATABASE_NAME, factory, DBConnClass.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(CREATE_EVENT_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        Log.w(this.getClass().getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_EVENT);
        onCreate(db);
    }

    public void open() throws SQLException {
        db = this.getWritableDatabase();
    }

    public void close() {
        this.close();
    }

    @Override
    public Event save(Event entity) {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getEventId());
        values.put(COLUMN_NAME, entity.getEventName());
        values.put(COLUMN_DESCRIPTION, entity.getEventDescription());
        values.put(COLUMN_START_DATE, entity.getStartDate().toString());
        values.put(COLUMN_START_TIME, entity.getStartTime().toString());
        values.put(COLUMN_AVAILABLE_SPACE, entity.getAvailableSpace());
        values.put(COLUMN_COST_PER_PERSON, entity.getCostPerPerson());
        values.put(COLUMN_EMAIL_ADDRESS, entity.getEmailAddress());
        long id = db.insertOrThrow(TABLE_EVENT, null, values);
        Event insertedEntity = new Event.Builder()
                .copy(entity)
                .eventId(new Long(id))
                .build();
        return insertedEntity;
    }

    @Override
    public Set<Event> findAll() {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectAll = " SELECT * FROM " + TABLE_EVENT;
        Set<Event> events = new HashSet<>();
        open();
        Cursor cursor = db.rawQuery(selectAll, null);
        if (cursor.moveToFirst()) {
            do {
                final Event event = new Event.Builder()
                        .eventId(cursor.getLong(0))
                        .eventName(cursor.getString(1))
                        .eventDescription(cursor.getString(2))
                        //.startDate(cursor.getString(3))
                        .build();
                events.add(event);
            } while (cursor.moveToNext());
        }

        return events;
    }

    @Override
    public Event findById(Long id) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(
                TABLE_EVENT,
                new String[]{
                        COLUMN_ID,
                        COLUMN_ID,
                        COLUMN_NAME,
                        COLUMN_DESCRIPTION,
                        COLUMN_START_DATE,
                        COLUMN_START_TIME,
                        COLUMN_AVAILABLE_SPACE,
                        COLUMN_COST_PER_PERSON,
                        COLUMN_EMAIL_ADDRESS},
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(id)},
                null,
                null,
                null,
                null);
        if (cursor.moveToFirst()) {
            final Event event = new Event.Builder()
                    .eventId(cursor.getLong(0))
                    .eventName(cursor.getString(1))
                    .eventDescription(cursor.getString(2))
                    //.startDate(cursor.getString(3))
                    .build();

            return event;
        } else {
            return null;
        }
    }

    @Override
    public Event update(Event entity) {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getEventId());
        values.put(COLUMN_NAME, entity.getEventName());
        values.put(COLUMN_DESCRIPTION, entity.getEventDescription());
        values.put(COLUMN_START_DATE, entity.getStartDate().toString());
        values.put(COLUMN_START_TIME, entity.getStartTime().toString());
        values.put(COLUMN_AVAILABLE_SPACE, entity.getAvailableSpace());
        values.put(COLUMN_COST_PER_PERSON, entity.getCostPerPerson());
        values.put(COLUMN_EMAIL_ADDRESS, entity.getEmailAddress());
        db.update(
                TABLE_EVENT,
                values,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getEventId())}
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
    public Event delete(Event entity) {
        open();
        db.delete(
                TABLE_EVENT,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getEventId())});
        return entity;
    }
}
