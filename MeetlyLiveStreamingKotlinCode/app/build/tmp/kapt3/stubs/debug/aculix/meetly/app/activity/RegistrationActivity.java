package aculix.meetly.app.activity;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\tJ\u0010\u0010\u0019\u001a\u00020\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\tJ\u0012\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0014J0\u0010\u001f\u001a\u00020\u001c2\f\u0010 \u001a\b\u0012\u0002\b\u0003\u0018\u00010!2\b\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010$\u001a\u00020\u00052\u0006\u0010%\u001a\u00020&H\u0016J\u0016\u0010\'\u001a\u00020\u001c2\f\u0010 \u001a\b\u0012\u0002\b\u0003\u0018\u00010!H\u0016J\u000e\u0010(\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020#J$\u0010)\u001a\u00020\u001c2\b\b\u0002\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\t2\b\b\u0002\u0010-\u001a\u00020\u0005H\u0002R\u0014\u0010\u0004\u001a\u00020\u0005X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\"\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\rX\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0013\u001a\n \u0015*\u0004\u0018\u00010\u00140\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006."}, d2 = {"Laculix/meetly/app/activity/RegistrationActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Landroid/widget/AdapterView$OnItemSelectedListener;", "()V", "NEW_SPINNER_ID", "", "getNEW_SPINNER_ID", "()I", "emailPattern", "", "getEmailPattern", "()Ljava/lang/String;", "languages", "", "getLanguages", "()[Ljava/lang/String;", "setLanguages", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "pattern", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "isValid", "", "email", "isValidPassword", "password", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onItemSelected", "parent", "Landroid/widget/AdapterView;", "view", "Landroid/view/View;", "position", "id", "", "onNothingSelected", "onSubmitClick", "showToast", "context", "Landroid/content/Context;", "message", "duration", "app_debug"})
public final class RegistrationActivity extends androidx.appcompat.app.AppCompatActivity implements android.widget.AdapterView.OnItemSelectedListener {
    @org.jetbrains.annotations.NotNull
    private final java.lang.String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    @org.jetbrains.annotations.NotNull
    private java.lang.String[] languages = {"Select Gender", "Female", "Male", "Other"};
    private final int NEW_SPINNER_ID = 1;
    private final java.util.regex.Pattern pattern = null;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getEmailPattern() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String[] getLanguages() {
        return null;
    }
    
    public final void setLanguages(@org.jetbrains.annotations.NotNull
    java.lang.String[] p0) {
    }
    
    public final int getNEW_SPINNER_ID() {
        return 0;
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    public final boolean isValidPassword(@org.jetbrains.annotations.Nullable
    java.lang.String password) {
        return false;
    }
    
    public final void onSubmitClick(@org.jetbrains.annotations.NotNull
    android.view.View view) {
    }
    
    @java.lang.Override
    public void onNothingSelected(@org.jetbrains.annotations.Nullable
    android.widget.AdapterView<?> parent) {
    }
    
    @java.lang.Override
    public void onItemSelected(@org.jetbrains.annotations.Nullable
    android.widget.AdapterView<?> parent, @org.jetbrains.annotations.Nullable
    android.view.View view, int position, long id) {
    }
    
    private final void showToast(android.content.Context context, java.lang.String message, int duration) {
    }
    
    public final boolean isValid(@org.jetbrains.annotations.Nullable
    java.lang.String email) {
        return false;
    }
    
    public RegistrationActivity() {
        super();
    }
}