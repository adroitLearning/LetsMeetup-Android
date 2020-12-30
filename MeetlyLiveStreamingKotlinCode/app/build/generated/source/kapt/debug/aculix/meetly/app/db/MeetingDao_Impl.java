package aculix.meetly.app.db;

import aculix.meetly.app.model.Meeting;
import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Exception;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@SuppressWarnings({"unchecked", "deprecation"})
public final class MeetingDao_Impl implements MeetingDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Meeting> __insertionAdapterOfMeeting;

  public MeetingDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfMeeting = new EntityInsertionAdapter<Meeting>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `meetings` (`code`,`timeInMillis`) VALUES (?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Meeting value) {
        if (value.getCode() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getCode());
        }
        stmt.bindLong(2, value.getTimeInMillis());
      }
    };
  }

  @Override
  public Object insertMeeting(final Meeting meeting, final Continuation<? super Long> p1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          long _result = __insertionAdapterOfMeeting.insertAndReturnId(meeting);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, p1);
  }

  @Override
  public LiveData<List<Meeting>> getAllMeetings() {
    final String _sql = "SELECT * FROM meetings ORDER BY timeInMillis DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"meetings"}, false, new Callable<List<Meeting>>() {
      @Override
      public List<Meeting> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfCode = CursorUtil.getColumnIndexOrThrow(_cursor, "code");
          final int _cursorIndexOfTimeInMillis = CursorUtil.getColumnIndexOrThrow(_cursor, "timeInMillis");
          final List<Meeting> _result = new ArrayList<Meeting>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Meeting _item;
            final String _tmpCode;
            _tmpCode = _cursor.getString(_cursorIndexOfCode);
            final long _tmpTimeInMillis;
            _tmpTimeInMillis = _cursor.getLong(_cursorIndexOfTimeInMillis);
            _item = new Meeting(_tmpCode,_tmpTimeInMillis);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Object deleteMultipleMeetings(final List<String> meetingCodeList,
      final Continuation<? super Unit> p1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        StringBuilder _stringBuilder = StringUtil.newStringBuilder();
        _stringBuilder.append("DELETE FROM meetings where  code in (");
        final int _inputSize = meetingCodeList.size();
        StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
        _stringBuilder.append(")");
        final String _sql = _stringBuilder.toString();
        final SupportSQLiteStatement _stmt = __db.compileStatement(_sql);
        int _argIndex = 1;
        for (String _item : meetingCodeList) {
          if (_item == null) {
            _stmt.bindNull(_argIndex);
          } else {
            _stmt.bindString(_argIndex, _item);
          }
          _argIndex ++;
        }
        __db.beginTransaction();
        try {
          _stmt.executeUpdateDelete();
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, p1);
  }
}
