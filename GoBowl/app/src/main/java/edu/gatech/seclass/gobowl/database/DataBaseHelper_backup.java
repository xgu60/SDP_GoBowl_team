//package seclass.gatech.edu.gobowl.database;
//
//import android.content.Context;
//import android.database.sqlite.SQLiteDatabase;
//import android.database.sqlite.SQLiteOpenHelper;
//
///**
// * Created by Yijin on 7/7/2016.
// */
//public class DataBaseHelper_backup extends SQLiteOpenHelper {
//    private static final String DBName = "GoBowlDB";
//    public static final String CreateTable = "CREATE TABLE";
//    public static final String Space = " ";
//    public static final String Text = "Text";
//    public static final String Comma = ",";
//    public static final String PRIMARYKEY = "PRIMARY KEY";
//    public static final String Unique = "UNIQUE";
//    public static final String Integer = "INTEGER";
//    public static final String Real = "REAL";
//    public static final String DropTable = "DROP TABLE IF EXISTS";
//    public static final int DBVersion = 4;
//    //Column_Name,Column_Email,Column_ID,Column_IsVip,Column_CreditForThisYear,Column_QRCode
//    public static final String CreateCustomer = CreateTable + Space + CustomerDataSource.Table_Customer
//            + Space + "(" + CustomerDataSource.Column_Name + Space + Text + Comma
//            + CustomerDataSource.Column_Email + Space + Text + Space + Unique + Comma
//            + CustomerDataSource.Column_ID + Space + Integer + Space + PRIMARYKEY + Comma
//            + CustomerDataSource.Column_IsVip + Space + Integer  + Comma
//            + CustomerDataSource.Column_CreditForThisYear +Space + Real + Comma
//            + CustomerDataSource.Column_QRCode + Space + Text + ")";
//    public static final String DropCustomer = DropTable + Space + CustomerDataSource.Table_Customer;
//    public static final String DropScore = DropTable + Space + ScoreDataSource.Table_Score;
//    public static final String DropLane = DropTable + Space + LaneDataSource.Table_Lane;
//
//    //Coloums_CustomerID,Coloums_Value,Coloums_Date,Coloums_ID
//    private static final String CreateScore = CreateTable + Space + ScoreDataSource.Table_Score  + Space + "("
//            + ScoreDataSource.Coloums_CustomerID +  Space + Text + Comma
//            + ScoreDataSource.Coloums_Value +  Space + Integer + Comma
//            + ScoreDataSource.Coloums_Date +  Space + Integer + Comma  //stored as miliseconds
//            + ScoreDataSource.Coloums_ID +  Space + Integer + Space + PRIMARYKEY + ")";
//
//    //Column_LaneNumber,Column_NumberOfPlayers,Column_Players,Column_TotalCost,Column_RegistedCustomerID,Column_CheckInDate,Column_CheckOutDate,Column_ID
//    private static final String CreateLane = CreateTable + Space + LaneDataSource.Table_Lane  + Space + "("
//            + LaneDataSource.Column_LaneNumber +  Space + Integer  + Space + Unique + Comma  //we may mark it as unique , if we dun need the records
//            + LaneDataSource.Column_NumberOfPlayers +  Space + Integer + Comma
//            + LaneDataSource.Column_Players +  Space + Text + Comma
//            + LaneDataSource.Column_TotalCost +  Space + Real + Comma
//            + LaneDataSource.Column_RegistedCustomerID +  Space + Integer + Comma //store as the same number with customer id in DB
//            + LaneDataSource.Column_CheckInDate +  Space + Integer + Comma
//            + LaneDataSource.Column_CheckOutDate +  Space + Integer + Comma
//            + LaneDataSource.Column_ID +  Space + Integer + Comma + PRIMARYKEY + ")";
//
//    private final Context myContext;
//    protected SQLiteDatabase _db = null;
//
//    public DataBaseHelper_backup(Context context) {
//
//        super(context, DBName, null, DBVersion);
//        this.myContext = context;
//    }
//
//    @Override
//    public void onCreate(SQLiteDatabase db) {
//        //db.execSQL(CreateCustomer);
//        db.execSQL(CreateLane);
//        db.execSQL(CreateScore);
//
//        reOpen(true);
//        _db.close();
//
//    }
//
//    public void clearDataBaseForTesting(SQLiteDatabase db) {
//        db.execSQL(DropScore);
//        db.execSQL(DropLane);
//        db.execSQL(DropCustomer);
//        // Create tables again
//        onCreate(db);
//    }
//
//    @Override
//    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        // Drop older table if existed
//        db.execSQL(DropScore);
//        db.execSQL(DropLane);
//        db.execSQL(DropCustomer);
//        // Create tables again
//        onCreate(db);
//    }
//
//
//    public void reOpen(Boolean writable){
//
//
//        if(!writable){
//            _db = DataBaseHelper_backup.getReadableDB(this.myContext);
//        }
//        else{
//
//            _db = DataBaseHelper_backup.getWritableDB(this.myContext);
//            try {
//                _db.execSQL(CreateCustomer);
//                //_db.execSQL(CreateCurrentCustomerTable);
//            }
//            catch (Exception ex){}
//        }
//    }
//
//    public SQLiteDatabase getDB(){
//        return _db;
//    }
//
//    public static SQLiteDatabase getReadableDB(Context context, String dbName){
//        return context.openOrCreateDatabase(dbName, SQLiteDatabase.OPEN_READONLY, null);
//    }
//
//    public static SQLiteDatabase getReadableDB(Context context){
//        return DataBaseHelper_backup.getReadableDB(context, DataBaseHelper_backup.DBName);
//    }
//
//    public static SQLiteDatabase getWritableDB(Context context, String dbName){
//        return context.openOrCreateDatabase(dbName, SQLiteDatabase.OPEN_READWRITE, null);
//    }
//
//    public static SQLiteDatabase getWritableDB(Context context){
//        return DataBaseHelper_backup.getWritableDB(context, DataBaseHelper_backup.DBName);
//    }
//}
