package aculix.meetly.app.activity;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 <2\u00020\u0001:\u0001<B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0002J\b\u0010\'\u001a\u00020&H\u0002J\b\u0010(\u001a\u00020&H\u0002J\b\u0010)\u001a\u00020&H\u0002J\b\u0010*\u001a\u00020$H\u0002J\u0010\u0010+\u001a\u00020\b2\u0006\u0010%\u001a\u00020&H\u0002J\u0010\u0010,\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0002J\b\u0010-\u001a\u00020$H\u0016J\b\u0010.\u001a\u00020$H\u0002J\u0012\u0010/\u001a\u00020$2\b\u00100\u001a\u0004\u0018\u000101H\u0014J\b\u00102\u001a\u00020$H\u0002J\u000e\u00102\u001a\u00020$2\u0006\u00103\u001a\u000204J\b\u00105\u001a\u00020$H\u0002J\b\u00106\u001a\u00020$H\u0002J\u000e\u00106\u001a\u00020$2\u0006\u00103\u001a\u000204J\b\u00107\u001a\u00020$H\u0002J\b\u00108\u001a\u00020$H\u0003J\u000e\u00109\u001a\u00020$2\u0006\u00103\u001a\u000204J\b\u0010:\u001a\u00020$H\u0002J\b\u0010;\u001a\u00020$H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082D\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001b\u0010\u001d\u001a\u00020\u001e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b\u001f\u0010 \u00a8\u0006="}, d2 = {"Laculix/meetly/app/activity/MainActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Laculix/meetly/app/databinding/ActivityMainBinding;", "currentUser", "Lcom/google/firebase/auth/FirebaseUser;", "doubleBackToExitPressedOnce", "", "drawerLayout", "Landroidx/drawerlayout/widget/DrawerLayout;", "getDrawerLayout", "()Landroidx/drawerlayout/widget/DrawerLayout;", "setDrawerLayout", "(Landroidx/drawerlayout/widget/DrawerLayout;)V", "minMeetingCodeLength", "", "navigationView", "Lcom/google/android/material/navigation/NavigationView;", "getNavigationView", "()Lcom/google/android/material/navigation/NavigationView;", "setNavigationView", "(Lcom/google/android/material/navigation/NavigationView;)V", "prefs", "Landroid/content/SharedPreferences;", "getPrefs", "()Landroid/content/SharedPreferences;", "setPrefs", "(Landroid/content/SharedPreferences;)V", "viewModel", "Laculix/meetly/app/viewmodel/MainViewModel;", "getViewModel", "()Laculix/meetly/app/viewmodel/MainViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "createMeeting", "", "meetingCode", "", "generateMeetingCode", "getCreateMeetingCode", "getJoinMeetingCode", "handleDynamicLink", "isMeetingCodeValid", "joinMeeting", "onBackPressed", "onCopyMeetingCodeFromClipboardClick", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateMeetingClick", "view", "Landroid/view/View;", "onCreateMeetingCodeChange", "onJoinMeetingClick", "onMeetingHistoryClick", "onProfileClick", "onScheduleMeetingClick", "onShareMeetingCodeClick", "setProfileIcon", "Companion", "app_debug"})
public final class MainActivity extends androidx.appcompat.app.AppCompatActivity {
    private final kotlin.Lazy viewModel$delegate = null;
    private aculix.meetly.app.databinding.ActivityMainBinding binding;
    private final int minMeetingCodeLength = 10;
    private com.google.firebase.auth.FirebaseUser currentUser;
    @org.jetbrains.annotations.Nullable
    private com.google.android.material.navigation.NavigationView navigationView;
    @org.jetbrains.annotations.Nullable
    private androidx.drawerlayout.widget.DrawerLayout drawerLayout;
    private boolean doubleBackToExitPressedOnce = false;
    @org.jetbrains.annotations.Nullable
    private android.content.SharedPreferences prefs;
    public static final aculix.meetly.app.activity.MainActivity.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
    private final aculix.meetly.app.viewmodel.MainViewModel getViewModel() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.google.android.material.navigation.NavigationView getNavigationView() {
        return null;
    }
    
    public final void setNavigationView(@org.jetbrains.annotations.Nullable
    com.google.android.material.navigation.NavigationView p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final androidx.drawerlayout.widget.DrawerLayout getDrawerLayout() {
        return null;
    }
    
    public final void setDrawerLayout(@org.jetbrains.annotations.Nullable
    androidx.drawerlayout.widget.DrawerLayout p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final android.content.SharedPreferences getPrefs() {
        return null;
    }
    
    public final void setPrefs(@org.jetbrains.annotations.Nullable
    android.content.SharedPreferences p0) {
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override
    public void onBackPressed() {
    }
    
    private final void setProfileIcon() {
    }
    
    private final void handleDynamicLink() {
    }
    
    public final void onJoinMeetingClick(@org.jetbrains.annotations.NotNull
    android.view.View view) {
    }
    
    public final void onCreateMeetingClick(@org.jetbrains.annotations.NotNull
    android.view.View view) {
    }
    
    private final void onCreateMeetingCodeChange() {
    }
    
    private final java.lang.String generateMeetingCode() {
        return null;
    }
    
    private final void onCopyMeetingCodeFromClipboardClick() {
    }
    
    /**
     * Called when the share icon is clicked in the EditText of the CREATE MEETING toggle
     */
    private final void onShareMeetingCodeClick() {
    }
    
    /**
     * Called when the JOIN button is clicked of the JOIN MEETING toggle
     */
    private final void onJoinMeetingClick() {
    }
    
    private final void joinMeeting(java.lang.String meetingCode) {
    }
    
    /**
     * Returns the meeting code for joining the meeting
     */
    private final java.lang.String getJoinMeetingCode() {
        return null;
    }
    
    /**
     * Called when the CREATE button is clicked of the CREATE MEETING toggle
     */
    private final void onCreateMeetingClick() {
    }
    
    private final void createMeeting(java.lang.String meetingCode) {
    }
    
    private final java.lang.String getCreateMeetingCode() {
        return null;
    }
    
    private final boolean isMeetingCodeValid(java.lang.String meetingCode) {
        return false;
    }
    
    private final void onMeetingHistoryClick() {
    }
    
    @android.annotation.SuppressLint(value = {"StringFormatInvalid"})
    private final void onProfileClick() {
    }
    
    public final void onScheduleMeetingClick(@org.jetbrains.annotations.NotNull
    android.view.View view) {
    }
    
    public MainActivity() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2 = {"Laculix/meetly/app/activity/MainActivity$Companion;", "", "()V", "startActivity", "", "context", "Landroid/content/Context;", "app_debug"})
    public static final class Companion {
        
        public final void startActivity(@org.jetbrains.annotations.NotNull
        android.content.Context context) {
        }
        
        private Companion() {
            super();
        }
    }
}