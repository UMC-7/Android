package com.example.flo_clone_umc_bottom;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class SongDao_Impl implements SongDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Song> __insertionAdapterOfSong;

  private final EntityDeletionOrUpdateAdapter<Song> __deletionAdapterOfSong;

  private final EntityDeletionOrUpdateAdapter<Song> __updateAdapterOfSong;

  public SongDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfSong = new EntityInsertionAdapter<Song>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `SongTable` (`title`,`singer`,`second`,`playTime`,`isPlaying`,`music`,`coverImg`,`isLike`,`id`) VALUES (?,?,?,?,?,?,?,?,nullif(?, 0))";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Song entity) {
        if (entity.getTitle() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getTitle());
        }
        if (entity.getSinger() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getSinger());
        }
        statement.bindLong(3, entity.getSecond());
        statement.bindLong(4, entity.getPlayTime());
        final int _tmp = entity.isPlaying() ? 1 : 0;
        statement.bindLong(5, _tmp);
        if (entity.getMusic() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getMusic());
        }
        if (entity.getCoverImg() == null) {
          statement.bindNull(7);
        } else {
          statement.bindLong(7, entity.getCoverImg());
        }
        final int _tmp_1 = entity.isLike() ? 1 : 0;
        statement.bindLong(8, _tmp_1);
        statement.bindLong(9, entity.getId());
      }
    };
    this.__deletionAdapterOfSong = new EntityDeletionOrUpdateAdapter<Song>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `SongTable` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Song entity) {
        statement.bindLong(1, entity.getId());
      }
    };
    this.__updateAdapterOfSong = new EntityDeletionOrUpdateAdapter<Song>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `SongTable` SET `title` = ?,`singer` = ?,`second` = ?,`playTime` = ?,`isPlaying` = ?,`music` = ?,`coverImg` = ?,`isLike` = ?,`id` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Song entity) {
        if (entity.getTitle() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getTitle());
        }
        if (entity.getSinger() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getSinger());
        }
        statement.bindLong(3, entity.getSecond());
        statement.bindLong(4, entity.getPlayTime());
        final int _tmp = entity.isPlaying() ? 1 : 0;
        statement.bindLong(5, _tmp);
        if (entity.getMusic() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getMusic());
        }
        if (entity.getCoverImg() == null) {
          statement.bindNull(7);
        } else {
          statement.bindLong(7, entity.getCoverImg());
        }
        final int _tmp_1 = entity.isLike() ? 1 : 0;
        statement.bindLong(8, _tmp_1);
        statement.bindLong(9, entity.getId());
        statement.bindLong(10, entity.getId());
      }
    };
  }

  @Override
  public void insert(final Song song) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfSong.insert(song);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final Song song) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfSong.handle(song);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final Song song) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfSong.handle(song);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<Song> getSong() {
    final String _sql = "SELECT * FROM SongTable";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
      final int _cursorIndexOfSinger = CursorUtil.getColumnIndexOrThrow(_cursor, "singer");
      final int _cursorIndexOfSecond = CursorUtil.getColumnIndexOrThrow(_cursor, "second");
      final int _cursorIndexOfPlayTime = CursorUtil.getColumnIndexOrThrow(_cursor, "playTime");
      final int _cursorIndexOfIsPlaying = CursorUtil.getColumnIndexOrThrow(_cursor, "isPlaying");
      final int _cursorIndexOfMusic = CursorUtil.getColumnIndexOrThrow(_cursor, "music");
      final int _cursorIndexOfCoverImg = CursorUtil.getColumnIndexOrThrow(_cursor, "coverImg");
      final int _cursorIndexOfIsLike = CursorUtil.getColumnIndexOrThrow(_cursor, "isLike");
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final List<Song> _result = new ArrayList<Song>(_cursor.getCount());
      while (_cursor.moveToNext()) {
        final Song _item;
        final String _tmpTitle;
        if (_cursor.isNull(_cursorIndexOfTitle)) {
          _tmpTitle = null;
        } else {
          _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
        }
        final String _tmpSinger;
        if (_cursor.isNull(_cursorIndexOfSinger)) {
          _tmpSinger = null;
        } else {
          _tmpSinger = _cursor.getString(_cursorIndexOfSinger);
        }
        final int _tmpSecond;
        _tmpSecond = _cursor.getInt(_cursorIndexOfSecond);
        final int _tmpPlayTime;
        _tmpPlayTime = _cursor.getInt(_cursorIndexOfPlayTime);
        final boolean _tmpIsPlaying;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsPlaying);
        _tmpIsPlaying = _tmp != 0;
        final String _tmpMusic;
        if (_cursor.isNull(_cursorIndexOfMusic)) {
          _tmpMusic = null;
        } else {
          _tmpMusic = _cursor.getString(_cursorIndexOfMusic);
        }
        final Integer _tmpCoverImg;
        if (_cursor.isNull(_cursorIndexOfCoverImg)) {
          _tmpCoverImg = null;
        } else {
          _tmpCoverImg = _cursor.getInt(_cursorIndexOfCoverImg);
        }
        final boolean _tmpIsLike;
        final int _tmp_1;
        _tmp_1 = _cursor.getInt(_cursorIndexOfIsLike);
        _tmpIsLike = _tmp_1 != 0;
        _item = new Song(_tmpTitle,_tmpSinger,_tmpSecond,_tmpPlayTime,_tmpIsPlaying,_tmpMusic,_tmpCoverImg,_tmpIsLike);
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Song getSong(final int id) {
    final String _sql = "SELECT * FROM SongTable WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
      final int _cursorIndexOfSinger = CursorUtil.getColumnIndexOrThrow(_cursor, "singer");
      final int _cursorIndexOfSecond = CursorUtil.getColumnIndexOrThrow(_cursor, "second");
      final int _cursorIndexOfPlayTime = CursorUtil.getColumnIndexOrThrow(_cursor, "playTime");
      final int _cursorIndexOfIsPlaying = CursorUtil.getColumnIndexOrThrow(_cursor, "isPlaying");
      final int _cursorIndexOfMusic = CursorUtil.getColumnIndexOrThrow(_cursor, "music");
      final int _cursorIndexOfCoverImg = CursorUtil.getColumnIndexOrThrow(_cursor, "coverImg");
      final int _cursorIndexOfIsLike = CursorUtil.getColumnIndexOrThrow(_cursor, "isLike");
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final Song _result;
      if (_cursor.moveToFirst()) {
        final String _tmpTitle;
        if (_cursor.isNull(_cursorIndexOfTitle)) {
          _tmpTitle = null;
        } else {
          _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
        }
        final String _tmpSinger;
        if (_cursor.isNull(_cursorIndexOfSinger)) {
          _tmpSinger = null;
        } else {
          _tmpSinger = _cursor.getString(_cursorIndexOfSinger);
        }
        final int _tmpSecond;
        _tmpSecond = _cursor.getInt(_cursorIndexOfSecond);
        final int _tmpPlayTime;
        _tmpPlayTime = _cursor.getInt(_cursorIndexOfPlayTime);
        final boolean _tmpIsPlaying;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsPlaying);
        _tmpIsPlaying = _tmp != 0;
        final String _tmpMusic;
        if (_cursor.isNull(_cursorIndexOfMusic)) {
          _tmpMusic = null;
        } else {
          _tmpMusic = _cursor.getString(_cursorIndexOfMusic);
        }
        final Integer _tmpCoverImg;
        if (_cursor.isNull(_cursorIndexOfCoverImg)) {
          _tmpCoverImg = null;
        } else {
          _tmpCoverImg = _cursor.getInt(_cursorIndexOfCoverImg);
        }
        final boolean _tmpIsLike;
        final int _tmp_1;
        _tmp_1 = _cursor.getInt(_cursorIndexOfIsLike);
        _tmpIsLike = _tmp_1 != 0;
        _result = new Song(_tmpTitle,_tmpSinger,_tmpSecond,_tmpPlayTime,_tmpIsPlaying,_tmpMusic,_tmpCoverImg,_tmpIsLike);
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _result.setId(_tmpId);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
