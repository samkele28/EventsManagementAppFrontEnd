package za.samkele.com.eventsmanagementsystem.repository.domain.Implimentation;

import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.database.SQLException;
import android.content.Context;
import android.content.ContentValues;
import android.database.Cursor;
import android.util.Log;

import java.util.HashSet;
import java.util.Set;

import za.samkele.com.eventsmanagementsystem.config.DBConnClass;
import za.samkele.com.eventsmanagementsystem.domain.Employee;
import za.samkele.com.eventsmanagementsystem.repository.domain.EmployeeRepository;

/**
 * Created by Samkele on 4/26/2016.
 */
public class EmployeeRepositoryImpl extends SQLiteOpenHelper implements EmployeeRepository{
    public static final String TABLE_EMPLOYEE = "employee";
    private SQLiteDatabase db;

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_FNAME = "firstName";
    public static final String COLUMN_LNAME = "lastName";
    public static final String COLUMN_EMPNUMBER = "employeeNumber";

    // Database creation sql statement
    private static final String CREATE_EMPLOYEE_TABLE = "CREATE TABLE "
            + TABLE_EMPLOYEE + "("
            + COLUMN_ID + "INTEGER PRIMARY KEY,"
            + COLUMN_FNAME + "TEXT,"
            + COLUMN_LNAME + "TEXT, "
            + COLUMN_EMPNUMBER + "TEXT" + ")";

    public EmployeeRepositoryImpl(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context, DBConnClass.DATABASE_NAME, factory, DBConnClass.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(CREATE_EMPLOYEE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        Log.w(this.getClass().getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_EMPLOYEE);
        onCreate(db);
    }

    public void open() throws SQLException {
        db = this.getWritableDatabase();
    }

    public void close() {
        this.close();
    }

    @Override
    public Employee save(Employee entity) {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getEmpId());
        values.put(COLUMN_FNAME, entity.getFirstName());
        values.put(COLUMN_LNAME, entity.getLastName());
        values.put(COLUMN_EMPNUMBER, entity.getEmployeeNumber());
        long id = db.insertOrThrow(TABLE_EMPLOYEE, null, values);
        Employee insertedEntity = new Employee.Builder()
                .copy(entity)
                .empId(new Long(id))
                .build();
        return insertedEntity;
    }

    @Override
    public Set<Employee> findAll() {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectAll = " SELECT * FROM " + TABLE_EMPLOYEE;
        Set<Employee> employees = new HashSet<>();
        open();
        Cursor cursor = db.rawQuery(selectAll, null);
        if (cursor.moveToFirst()) {
            do {
                final Employee emp = new Employee.Builder()
                        .empId(cursor.getLong(0))
                        .firstName(cursor.getString(1))
                        .lastName(cursor.getString(2))
                        .employeeNumber(cursor.getString(3))
                        .build();
                employees.add(emp);
            } while (cursor.moveToNext());
        }

        return employees;
    }

    @Override
    public Employee findById(Long id) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(
                TABLE_EMPLOYEE,
                new String[]{
                        COLUMN_ID,
                        COLUMN_FNAME,
                        COLUMN_LNAME,
                        COLUMN_EMPNUMBER},
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(id)},
                null,
                null,
                null,
                null);
        if (cursor.moveToFirst()) {
            final Employee employee = new Employee.Builder()
                    .empId(cursor.getLong(0))
                    .firstName(cursor.getString(1))
                    .lastName(cursor.getString(2))
                    .employeeNumber(cursor.getString(3))
                    .build();

            return employee;
        } else {
            return null;
        }
    }

    @Override
    public Employee update(Employee entity) {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getEmpId());
        values.put(COLUMN_FNAME, entity.getFirstName());
        values.put(COLUMN_LNAME, entity.getLastName());
        values.put(COLUMN_EMPNUMBER, entity.getEmployeeNumber());
        db.update(
                TABLE_EMPLOYEE,
                values,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getEmpId())}
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
    public Employee delete(Employee entity) {
        open();
        db.delete(
                TABLE_EMPLOYEE,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getEmpId())});
        return entity;
    }
}
