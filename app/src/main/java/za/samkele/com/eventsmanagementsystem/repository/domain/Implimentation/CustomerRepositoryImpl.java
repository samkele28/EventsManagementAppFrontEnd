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
import za.samkele.com.eventsmanagementsystem.domain.Customer;
//import za.samkele.com.eventsmanagementsystem.domain.settings.Settings;
import za.samkele.com.eventsmanagementsystem.repository.domain.CustomerRepository;

/**
 * Created by Samkele on 4/26/2016.
 */
public class CustomerRepositoryImpl extends SQLiteOpenHelper implements CustomerRepository {
    public static final String TABLE_CUSTOMER = "customer";
    private SQLiteDatabase db;

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_CUST_NAME = "customer_name";
    public static final String COLUMN_LAST_NAME = "last_name";
    public static final String COLUMN_CONTACT_NUM = "contact_number";

    // Database creation sql statement
    private static final String CREATE_EMPLOYEE_TABLE = " CREATE TABLE "
            + TABLE_CUSTOMER + "("
            + COLUMN_ID + " INTEGER  PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_CUST_NAME + " TEXT NOT NULL , "
            + COLUMN_LAST_NAME + " TEXT NOT NULL , "
            + COLUMN_CONTACT_NUM + " TEXT NOT NULL );";

    public CustomerRepositoryImpl(Context context) {
        super(context, DBConnClass.DATABASE_NAME, null, DBConnClass.DATABASE_VERSION);
    }

    public void open() throws SQLException {
        db = this.getWritableDatabase();
    }

    public void close() {
        this.close();
    }

    @Override
    public Customer findById(Long id) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(
                TABLE_CUSTOMER,
                new String[]{
                        COLUMN_ID,
                        COLUMN_CUST_NAME,
                        COLUMN_LAST_NAME,
                        COLUMN_CONTACT_NUM},
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(id)},
                null,
                null,
                null,
                null);
        if (cursor.moveToFirst()) {
            final Customer customer = new Customer.Builder()
                    .custId(cursor.getLong(0))
                    .customerName(cursor.getString(1))
                    .contactLastName(cursor.getString(2))
                    .contactNumber(cursor.getString(3))
                    .build();

            return customer;
        } else {
            return null;
        }
    }

    @Override
    public Customer save(Customer entity) {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getCustId());
        values.put(COLUMN_CUST_NAME, entity.getCustomerName());
        values.put(COLUMN_LAST_NAME, entity.getContactLastName());
        values.put(COLUMN_CONTACT_NUM, entity.getContactNumber());
        long id = db.insertOrThrow(TABLE_CUSTOMER, null, values);
        Customer insertedEntity = new Customer.Builder()
                .copy(entity)
                .custId(new Long(id))
                .build();
        return insertedEntity;
    }

    @Override
    public Customer update(Customer entity) {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getCustId());
        values.put(COLUMN_CUST_NAME, entity.getCustomerName());
        values.put(COLUMN_LAST_NAME, entity.getContactLastName());
        values.put(COLUMN_CONTACT_NUM, entity.getContactNumber());
        db.update(
                TABLE_CUSTOMER,
                values,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getCustId())}
        );
        return entity;
    }

    @Override
    public Customer delete(Customer entity) {
        open();
        db.delete(
                TABLE_CUSTOMER,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getCustId())});
        return entity;
    }

    @Override
    public Set<Customer> findAll() {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectAll = " SELECT * FROM " + TABLE_CUSTOMER;
        Set<Customer> customers = new HashSet<>();
        open();
        Cursor cursor = db.rawQuery(selectAll, null);
        if (cursor.moveToFirst()) {
            do {
                final Customer cust = new Customer.Builder()
                        .custId(cursor.getLong(0))
                        .customerName(cursor.getString(1))
                        .contactLastName(cursor.getString(2))
                        .contactNumber(cursor.getString(3))
                        .build();
                customers.add(cust);
            } while (cursor.moveToNext());
        }

        return customers;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_EMPLOYEE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(this.getClass().getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CUSTOMER);
        onCreate(db);

    }

}
