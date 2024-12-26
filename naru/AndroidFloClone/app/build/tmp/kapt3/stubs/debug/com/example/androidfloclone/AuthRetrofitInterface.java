package com.example.androidfloclone;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\'J\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\'\u00a8\u0006\b"}, d2 = {"Lcom/example/androidfloclone/AuthRetrofitInterface;", "", "login", "Lretrofit2/Call;", "Lcom/example/androidfloclone/AuthResponse;", "user", "Lcom/example/androidfloclone/User;", "signUp", "app_debug"})
public abstract interface AuthRetrofitInterface {
    
    @retrofit2.http.POST(value = "/join")
    @org.jetbrains.annotations.NotNull
    public abstract retrofit2.Call<com.example.androidfloclone.AuthResponse> signUp(@retrofit2.http.Body
    @org.jetbrains.annotations.NotNull
    com.example.androidfloclone.User user);
    
    @retrofit2.http.POST(value = "/login")
    @org.jetbrains.annotations.NotNull
    public abstract retrofit2.Call<com.example.androidfloclone.AuthResponse> login(@retrofit2.http.Body
    @org.jetbrains.annotations.NotNull
    com.example.androidfloclone.User user);
}