package com.example.clone_coding;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
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

  private final SharedSQLiteStatement __preparedStmtOfUpdateIsLikeById;

  public SongDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfSong = new EntityInsertionAdapter<Song>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `SongTable` (`title`,`singer`,`currentTime`,`playTime`,`isPlaying`,`music`,`coverImg`,`isLike`,`id`) VALUES (?,?,?,?,?,?,?,?,nullif(?, 0))";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Song value) {
        if (value.getTitle() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getTitle());
        }
        if (value.getSinger() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getSinger());
        }
        stmt.bindLong(3, value.getCurrentTime());
        stmt.bindLong(4, value.getPlayTime());
        final int _tmp = value.isPlaying() ? 1 : 0;
        stmt.bindLong(5, _tmp);
        if (value.getMusic() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getMusic());
        }
        if (value.getCoverImg() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindLong(7, value.getCoverImg());
        }
        final int _tmp_1 = value.isLike() ? 1 : 0;
        stmt.bindLong(8, _tmp_1);
        stmt.bindLong(9, value.getId());
      }
    };
    this.__deletionAdapterOfSong = new EntityDeletionOrUpdateAdapter<Song>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `SongTable` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Song value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfSong = new EntityDeletionOrUpdateAdapter<Song>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `SongTable` SET `title` = ?,`singer` = ?,`currentTime` = ?,`playTime` = ?,`isPlaying` = ?,`music` = ?,`coverImg` = ?,`isLike` = ?,`id` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Song value) {
        if (value.getTitle() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getTitle());
        }
        if (value.getSinger() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getSinger());
        }
        stmt.bindLong(3, value.getCurrentTime());
        stmt.bindLong(4, value.getPlayTime());
        final int _tmp = value.isPlaying() ? 1 : 0;
        stmt.bindLong(5, _tmp);
        if (value.getMusic() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getMusic());
        }
        if (value.getCoverImg() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindLong(7, value.getCoverImg());
        }
        final int _tmp_1 = value.isLike() ? 1 : 0;
        stmt.bindLong(8, _tmp_1);
        stmt.bindLong(9, value.getId());
        stmt.bindLong(10, value.getId());
      }
    };
    this.__preparedStmtOfUpdateIsLikeById = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE SongTable SET isLike= ? WHERE id = ?";
        return _query;
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
  public void updateIsLikeById(final boolean isLike, final int id) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateIsLikeById.acquire();
    int _argIndex = 1;
    final int _tmp = isLike ? 1 : 0;
    _stmt.bindLong(_argIndex, _tmp);
    _argIndex = 2;
    _stmt.bindLong(_argIndex, id);
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateIsLikeById.release(_stmt);
    }
  }

  @Override
  public List<Song> getSongs() {
    final String _sql = "SELECT * FROM SongTable";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
      final int _cursorIndexOfSinger = CursorUtil.getColumnIndexOrThrow(_cursor, "singer");
      final int _cursorIndexOfCurrentTime = CursorUtil.getColumnIndexOrThrow(_cursor, "currentTime");
      final int _cursorIndexOfPlayTime = CursorUtil.getColumnIndexOrThrow(_cursor, "playTime");
      final int _cursorIndexOfIsPlaying = CursorUtil.getColumnIndexOrThrow(_cursor, "isPlaying");
      final int _cursorIndexOfMusic = CursorUtil.getColumnIndexOrThrow(_cursor, "music");
      final int _cursorIndexOfCoverImg = CursorUtil.getColumnIndexOrThrow(_cursor, "coverImg");
      final int _cursorIndexOfIsLike = CursorUtil.getColumnIndexOrThrow(_cursor, "isLike");
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final List<Song> _result = new ArrayList<Song>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Song _item;
        _item = new Song();
        final String _tmpTitle;
        if (_cursor.isNull(_cursorIndexOfTitle)) {
          _tmpTitle = null;
        } else {
          _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
        }
        _item.setTitle(_tmpTitle);
        final String _tmpSinger;
        if (_cursor.isNull(_cursorIndexOfSinger)) {
          _tmpSinger = null;
        } else {
          _tmpSinger = _cursor.getString(_cursorIndexOfSinger);
        }
        _item.setSinger(_tmpSinger);
        final int _tmpCurrentTime;
        _tmpCurrentTime = _cursor.getInt(_cursorIndexOfCurrentTime);
        _item.setCurrentTime(_tmpCurrentTime);
        final int _tmpPlayTime;
        _tmpPlayTime = _cursor.getInt(_cursorIndexOfPlayTime);
        _item.setPlayTime(_tmpPlayTime);
        final boolean _tmpIsPlaying;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsPlaying);
        _tmpIsPlaying = _tmp != 0;
        _item.setPlaying(_tmpIsPlaying);
        final String _tmpMusic;
        if (_cursor.isNull(_cursorIndexOfMusic)) {
          _tmpMusic = null;
        } else {
          _tmpMusic = _cursor.getString(_cursorIndexOfMusic);
        }
        _item.setMusic(_tmpMusic);
        final Integer _tmpCoverImg;
        if (_cursor.isNull(_cursorIndexOfCoverImg)) {
          _tmpCoverImg = null;
        } else {
          _tmpCoverImg = _cursor.getInt(_cursorIndexOfCoverImg);
        }
        _item.setCoverImg(_tmpCoverImg);
        final boolean _tmpIsLike;
        final int _tmp_1;
        _tmp_1 = _cursor.getInt(_cursorIndexOfIsLike);
        _tmpIsLike = _tmp_1 != 0;
        _item.setLike(_tmpIsLike);
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
      final int _cursorIndexOfCurrentTime = CursorUtil.getColumnIndexOrThrow(_cursor, "currentTime");
      final int _cursorIndexOfPlayTime = CursorUtil.getColumnIndexOrThrow(_cursor, "playTime");
      final int _cursorIndexOfIsPlaying = CursorUtil.getColumnIndexOrThrow(_cursor, "isPlaying");
      final int _cursorIndexOfMusic = CursorUtil.getColumnIndexOrThrow(_cursor, "music");
      final int _cursorIndexOfCoverImg = CursorUtil.getColumnIndexOrThrow(_cursor, "coverImg");
      final int _cursorIndexOfIsLike = CursorUtil.getColumnIndexOrThrow(_cursor, "isLike");
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final Song _result;
      if(_cursor.moveToFirst()) {
        _result = new Song();
        final String _tmpTitle;
        if (_cursor.isNull(_cursorIndexOfTitle)) {
          _tmpTitle = null;
        } else {
          _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
        }
        _result.setTitle(_tmpTitle);
        final String _tmpSinger;
        if (_cursor.isNull(_cursorIndexOfSinger)) {
          _tmpSinger = null;
        } else {
          _tmpSinger = _cursor.getString(_cursorIndexOfSinger);
        }
        _result.setSinger(_tmpSinger);
        final int _tmpCurrentTime;
        _tmpCurrentTime = _cursor.getInt(_cursorIndexOfCurrentTime);
        _result.setCurrentTime(_tmpCurrentTime);
        final int _tmpPlayTime;
        _tmpPlayTime = _cursor.getInt(_cursorIndexOfPlayTime);
        _result.setPlayTime(_tmpPlayTime);
        final boolean _tmpIsPlaying;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsPlaying);
        _tmpIsPlaying = _tmp != 0;
        _result.setPlaying(_tmpIsPlaying);
        final String _tmpMusic;
        if (_cursor.isNull(_cursorIndexOfMusic)) {
          _tmpMusic = null;
        } else {
          _tmpMusic = _cursor.getString(_cursorIndexOfMusic);
        }
        _result.setMusic(_tmpMusic);
        final Integer _tmpCoverImg;
        if (_cursor.isNull(_cursorIndexOfCoverImg)) {
          _tmpCoverImg = null;
        } else {
          _tmpCoverImg = _cursor.getInt(_cursorIndexOfCoverImg);
        }
        _result.setCoverImg(_tmpCoverImg);
        final boolean _tmpIsLike;
        final int _tmp_1;
        _tmp_1 = _cursor.getInt(_cursorIndexOfIsLike);
        _tmpIsLike = _tmp_1 != 0;
        _result.setLike(_tmpIsLike);
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

  @Override
  public Integer getFirstSongId() {
    final String _sql = "SELECT id FROM SongTable LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final Integer _result;
      if(_cursor.moveToFirst()) {
        if (_cursor.isNull(0)) {
          _result = null;
        } else {
          _result = _cursor.getInt(0);
        }
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Song> getLikedSongs(final boolean isLike) {
    final String _sql = "SELECT * FROM SongTable WHERE isLike = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    final int _tmp = isLike ? 1 : 0;
    _statement.bindLong(_argIndex, _tmp);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
      final int _cursorIndexOfSinger = CursorUtil.getColumnIndexOrThrow(_cursor, "singer");
      final int _cursorIndexOfCurrentTime = CursorUtil.getColumnIndexOrThrow(_cursor, "currentTime");
      final int _cursorIndexOfPlayTime = CursorUtil.getColumnIndexOrThrow(_cursor, "playTime");
      final int _cursorIndexOfIsPlaying = CursorUtil.getColumnIndexOrThrow(_cursor, "isPlaying");
      final int _cursorIndexOfMusic = CursorUtil.getColumnIndexOrThrow(_cursor, "music");
      final int _cursorIndexOfCoverImg = CursorUtil.getColumnIndexOrThrow(_cursor, "coverImg");
      final int _cursorIndexOfIsLike = CursorUtil.getColumnIndexOrThrow(_cursor, "isLike");
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final List<Song> _result = new ArrayList<Song>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Song _item;
        _item = new Song();
        final String _tmpTitle;
        if (_cursor.isNull(_cursorIndexOfTitle)) {
          _tmpTitle = null;
        } else {
          _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
        }
        _item.setTitle(_tmpTitle);
        final String _tmpSinger;
        if (_cursor.isNull(_cursorIndexOfSinger)) {
          _tmpSinger = null;
        } else {
          _tmpSinger = _cursor.getString(_cursorIndexOfSinger);
        }
        _item.setSinger(_tmpSinger);
        final int _tmpCurrentTime;
        _tmpCurrentTime = _cursor.getInt(_cursorIndexOfCurrentTime);
        _item.setCurrentTime(_tmpCurrentTime);
        final int _tmpPlayTime;
        _tmpPlayTime = _cursor.getInt(_cursorIndexOfPlayTime);
        _item.setPlayTime(_tmpPlayTime);
        final boolean _tmpIsPlaying;
        final int _tmp_1;
        _tmp_1 = _cursor.getInt(_cursorIndexOfIsPlaying);
        _tmpIsPlaying = _tmp_1 != 0;
        _item.setPlaying(_tmpIsPlaying);
        final String _tmpMusic;
        if (_cursor.isNull(_cursorIndexOfMusic)) {
          _tmpMusic = null;
        } else {
          _tmpMusic = _cursor.getString(_cursorIndexOfMusic);
        }
        _item.setMusic(_tmpMusic);
        final Integer _tmpCoverImg;
        if (_cursor.isNull(_cursorIndexOfCoverImg)) {
          _tmpCoverImg = null;
        } else {
          _tmpCoverImg = _cursor.getInt(_cursorIndexOfCoverImg);
        }
        _item.setCoverImg(_tmpCoverImg);
        final boolean _tmpIsLike;
        final int _tmp_2;
        _tmp_2 = _cursor.getInt(_cursorIndexOfIsLike);
        _tmpIsLike = _tmp_2 != 0;
        _item.setLike(_tmpIsLike);
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

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
