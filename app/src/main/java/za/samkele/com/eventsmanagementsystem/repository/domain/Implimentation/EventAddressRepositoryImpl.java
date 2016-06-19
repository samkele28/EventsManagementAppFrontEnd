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
import za.samkele.com.eventsmanagementsystem.domain.EventAddress;
import za.samkele.com.eventsmanagementsystem.factories.EventAddressFactory;

/**
 * Created by Samkele on 4/27/2016.
 */
public class EventAddressRepositoryImpl extends SQLiteOpenHelper implements EventAddressFactory {
    public static final String TABLE_EVENT_ADDRESS = "event_address";
    private SQLiteDatabase db;

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_STREET_ADDRESS = "street_address";
    public static final String COLUMN_SURBURD = "surburb";
    public static final String COLUMN_TOWN = "town";
    public static final String COLUMN_POSTAL_CODE = "postal_code";
    public static final String COLUMN_PROVINCE = "province";

    // Database creation sql statement
    private static final String CREATE_EVENT_ADDRESS_TABLE = "CREATE TABLE "
            + TABLE_EVENT_ADDRESS + "("
            + COLUMN_ID + "INTEGER PRIMARY KEY,"
            + COLUMN_STREET_ADDRESS + "TEXT,"
            + COLUMN_SURBURD + "TEXT, "
            + COLUMN_TOWN + "TEXT,"
            + COLUMN_POSTAL_CODE + "TEXT, "
            + COLUMN_PROVINCE + "TEXT" + ")";

    public EventAddressRepositoryImpl(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context, DBConnClass.DATABASE_NAME, factory, DBConnClass.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(CREATE_EVENT_ADDRESS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        Log.w(this.getClass().getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_EVENT_ADDRESS);
        onCreate(db);
    }

    public void open() throws SQLException {
        db = this.getWritableDatabase();
    }

    public void close() {
        this.close();
    }

    @Override
    public EventAddress save(EventAddress entity) {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getEventAddrId());
        values.put(COLUMN_STREET_ADDRESS, entity.getStreetAddress());
        values.put(COLUMN_SURBURD, entity.getSurburb());
        values.put(COLUMN_TOWN, entity.getTown());
        values.put(COLUMN_POSTAL_CODE, entity.getPostalCode());
        values.put(COLUMN_PROVINCE, entity.getProvince());
        long id = db.insertOrThrow(TABLE_EVENT_ADDRESS, null, values);
        EventAddress insertedEntity = new EventAddress.Builder()
                .copy(entity)
                .eventAddrId(new Long(id))
                .build();
        return insertedEntity;
    }

    @Override
    public Set<EventAddress> findAll() {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectAll = " SELECT * FROM " + TABLE_EVENT_ADDRESS;
        Set<EventAddress> eventsAdd = new HashSet<>();
        open();
        Cursor cursor = db.rawQuery(selectAll, null);
        if (cursor.moveToFirst()) {
            do {
                final EventAddress eventAdd = new EventAddress.Builder()
                        .eventAddrId(cursor.getLong(0))
                        .streetAddress(cursor.getString(1))
                        .surburb(cursor.getString(2))
                        .postalCode(cursor.getString(3))
                        .build();
                eventsAdd.add(eventAdd);
            } while (cursor.moveToNext());
        }

        return eventsAdd;
    }

    @Override
    public EventAddress findById(Long id) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(
                TABLE_EVENT_ADDRESS,
                new String[]{
                        COLUMN_ID,
                        COLUMN_ID,
                        COLUMN_STREET_ADDRESS,
                        COLUMN_SURBURD,
                        COLUMN_TOWN,
                        COLUMN_POSTAL_CODE,
                        COLUMN_PROVINCE},
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(id)},
                null,
                null,
                null,
                null);
        if (cursor.moveToFirst()) {
            final EventAddress eventAdd = new EventAddress.Builder()
                    .eventAddrId(cursor.getLong(0))
                    .streetAddress(cursor.getString(1))
                    .surburb(cursor.getString(2))
                    .postalCode(cursor.getString(3))
                    .build();
            return eventAdd;
        } else {
            return null;
        }
    }

    @Override
    public EventAddress update(EventAddress entity) {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getEventAddrId());
        values.put(COLUMN_STREET_ADDRESS, entity.getStreetAddress());
        values.put(COLUMN_SURBURD, entity.getSurburb());
        values.put(COLUMN_TOWN, entity.getTown());
        values.put(COLUMN_POSTAL_CODE, entity.getPostalCode());
        values.put(COLUMN_PROVINCE, entity.getProvince());
        db.update(
                TABLE_EVENT_ADDRESS,
                values,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getEventAddrId())}
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
    public EventAddress delete(EventAddress entity) {
        open();
        db.delete(
                TABLE_EVENT_ADDRESS,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getEventAddrId())});
        return entity;
    }

    @Override
    public int deleteAll() {
        open();
        int rowsDeleted = db.delete(TABLE_EVENT_ADDRESS,null,null);
        close();
        return rowsDeleted;
    }
}
