package com.example.androidfloclone;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\'J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\bH\'J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0003H\'\u00a8\u0006\f"}, d2 = {"Lcom/example/androidfloclone/UserDao;", "", "getUser", "Lcom/example/androidfloclone/User;", "email", "", "password", "getUsers", "", "insert", "", "user", "app_debug"})
@androidx.room.Dao
public abstract interface UserDao {
    
    @androidx.room.Insert
    public abstract void insert(@org.jetbrains.annotations.NotNull
    com.example.androidfloclone.User user);
    
    @androidx.room.Query(value = "SELECT * FROM UserTable")
    @org.jetbrains.annotations.NotNull
    public abstract java.util.List<com.example.androidfloclone.User> getUsers();
    
    @androidx.room.Query(value = "SELECT *FROM UserTable WHERE email = :email AND password = :password")
    @org.jetbrains.annotations.Nullable
    public abstract com.example.androidfloclone.User getUser(@org.jetbrains.annotations.NotNull
    java.lang.String email, @org.jetbrains.annotations.NotNull
    java.lang.String password);
}