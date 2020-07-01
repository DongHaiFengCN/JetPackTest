package com.ctrl.jetpacktest;
import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
@Database(entities = {Student.class}, version = 1, exportSchema = false)
abstract class StudentDataBase extends RoomDatabase {

    private static class Single {

        public static StudentDataBase INSTANCE(Context context) {
            return Room.databaseBuilder(context, StudentDataBase.class, "students_database").build();
        }

    }

    public static StudentDataBase getInstance(Context context) {
        return Single.INSTANCE(context);
    }

    abstract StudentDao getStudentDao();

}
