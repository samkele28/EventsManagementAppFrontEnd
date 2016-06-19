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
import java.util.Date;

import za.samkele.com.eventsmanagementsystem.config.databases.DBConnClass;
import za.samkele.com.eventsmanagementsystem.domain.Reservation;
import za.samkele.com.eventsmanagementsystem.repository.domain.ReservationRepository;

/**
 * Created by Samkele on 6/18/2016.
 */
public class ReservationRepositoryImpl extends SQLiteOpenHelper implements ReservationRepository{
    public static final String TABLE_RESERVATION = "reservation";
    private SQLiteDatabase db;

    public static final String COLUMN_RESERVE_ID = "reserveId";
    public static final String COLUMN_CUST_ID = "custId";
    public static final String COLUMN_EVENT_ID = "eventId";
    public static final String COLUMN_RESERVE_DATE = "reserveDate";
    public static final String COLUMN_DEPOSIT_DUE = "depositDue";
    public static final String COLUMN_AMOUNT_PAID = "amountPaid";
    public static final String COLUMN_CONFIRMED = "confirmed";

    // Database creation sql statement
    private static final String CREATE_RESERVATION_TABLE = "CREATE TABLE "
            + TABLE_RESERVATION + "("
            + COLUMN_RESERVE_ID + "INTEGER PRIMARY KEY,"
            + COLUMN_CUST_ID + "INTEGER,"
            + COLUMN_EVENT_ID + "INTEGER, "
            + COLUMN_RESERVE_DATE + "DATE, "
            + COLUMN_DEPOSIT_DUE + "NUMBER,"
            + COLUMN_AMOUNT_PAID + "NUMBER, "
            + COLUMN_CONFIRMED + "TEXT" + ")";

    public ReservationRepositoryImpl(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context, DBConnClass.DATABASE_NAME, factory, DBConnClass.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(CREATE_RESERVATION_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        Log.w(this.getClass().getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_RESERVATION);
        onCreate(db);
    }

    public void open() throws SQLException {
        db = this.getWritableDatabase();
    }

    public void close() {
        this.close();
    }

    @Override
    public Reservation save(Reservation entity) {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_RESERVE_ID, entity.getReserveId());
        values.put(COLUMN_CUST_ID, entity.getCustId());
        values.put(COLUMN_EVENT_ID, entity.getEventId());
        values.put(COLUMN_RESERVE_DATE, entity.getReserveDate().toString());
        values.put(COLUMN_DEPOSIT_DUE, entity.getDepositDue());
        values.put(COLUMN_AMOUNT_PAID, entity.getAmountPaid());
        values.put(COLUMN_CONFIRMED, entity.getConfirmed());
        long id = db.insertOrThrow(TABLE_RESERVATION, null, values);
        Reservation insertedEntity = new Reservation.Builder()
                .copy(entity)
                .reserveId(new Long(id))
                .build();
        return insertedEntity;
    }

    @Override
    public Set<Reservation> findAll() {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectAll = " SELECT * FROM " + TABLE_RESERVATION;
        Set<Reservation> reservations = new HashSet<>();
        open();
        Cursor cursor = db.rawQuery(selectAll, null);
        if (cursor.moveToFirst()) {
            do {
                final Reservation res = new Reservation.Builder()
                        .reserveId(cursor.getLong(0))
                        /*.reserveDate(cursor.getString(1))
                        .depositDue(cursor.getString(2))
                        .amountPaid(cursor.getString(3))
                        .confirmed(cursor.getString(4))*/
                        .build();
                reservations.add(res);
            } while (cursor.moveToNext());
        }

        return reservations;
    }

    @Override
    public Reservation findById(Long id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(
                TABLE_RESERVATION,
                new String[]{
                        COLUMN_RESERVE_ID,
                        COLUMN_RESERVE_DATE,
                        COLUMN_DEPOSIT_DUE,
                        COLUMN_AMOUNT_PAID,
                        COLUMN_CONFIRMED},
                COLUMN_RESERVE_ID + " =? ",
                new String[]{String.valueOf(id)},
                null,
                null,
                null,
                null);
        if (cursor.moveToFirst()) {
            final Reservation reservation = new Reservation.Builder()
                    .reserveId(cursor.getLong(0))
                    /*.reserveDate(cursor.getString(1))
                    .depositDue(cursor.getString(2))
                    .amountPaid(cursor.getString(3))
                    .confirmed(cursor.getString(4))*/
                    .build();

            return reservation;
        } else {
            return null;
        }
    }

    @Override
    public Reservation update(Reservation entity) {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_RESERVE_ID, entity.getReserveId());
        values.put(COLUMN_CUST_ID, entity.getCustId());
        values.put(COLUMN_EVENT_ID, entity.getEventId());
        values.put(COLUMN_RESERVE_DATE, entity.getReserveDate().toString());
        values.put(COLUMN_DEPOSIT_DUE, entity.getDepositDue());
        values.put(COLUMN_AMOUNT_PAID, entity.getAmountPaid());
        values.put(COLUMN_CONFIRMED, entity.getConfirmed());
        db.update(
                TABLE_RESERVATION,
                values,
                COLUMN_RESERVE_ID + " =? ",
                new String[]{String.valueOf(entity.getReserveId())}
        );
        return entity;
    }

    /*public boolean deleteReservation(String employeeNumber){
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
    public Reservation delete(Reservation entity) {
        open();
        db.delete(
                TABLE_RESERVATION,
                COLUMN_RESERVE_ID + " =? ",
                new String[]{String.valueOf(entity.getReserveId())});
        return entity;
    }

    @Override
    public int deleteAll() {
        open();
        int rowsDeleted = db.delete(TABLE_RESERVATION,null,null);
        close();
        return rowsDeleted;
    }
}
