package aculix.meetly.app.activity;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 /2\u00020\u0001:\u0001/B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\b\u0010\u0016\u001a\u00020\u0015H\u0002J\b\u0010\u0017\u001a\u00020\u0015H\u0002J\b\u0010\u0018\u001a\u00020\u0015H\u0002J\b\u0010\u0019\u001a\u00020\u0013H\u0002J\b\u0010\u001a\u001a\u00020\u0013H\u0002J\b\u0010\u001b\u001a\u00020\u0013H\u0002J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\b\u0010\u001f\u001a\u00020\u0013H\u0002J\b\u0010 \u001a\u00020\u0013H\u0002J\b\u0010!\u001a\u00020\u0013H\u0002J\u0012\u0010\"\u001a\u00020\u00132\b\u0010#\u001a\u0004\u0018\u00010$H\u0014J\b\u0010%\u001a\u00020\u0013H\u0002J\b\u0010&\u001a\u00020\u0013H\u0002J\b\u0010\'\u001a\u00020\u0013H\u0002J\b\u0010(\u001a\u00020\u0013H\u0002J\b\u0010)\u001a\u00020\u0013H\u0002J\b\u0010*\u001a\u00020\u0013H\u0002J\b\u0010+\u001a\u00020\u0013H\u0002J\b\u0010,\u001a\u00020\u0013H\u0002J\u0010\u0010-\u001a\u00020\u00132\u0006\u0010.\u001a\u00020\u000bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082D\u00a2\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000f\u00a8\u00060"}, d2 = {"Laculix/meetly/app/activity/MainActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Laculix/meetly/app/databinding/ActivityMainBinding;", "createMeetingInterstitialAd", "Lcom/google/android/gms/ads/InterstitialAd;", "currentUser", "Lcom/google/firebase/auth/FirebaseUser;", "joinMeetingInterstitialAd", "minMeetingCodeLength", "", "viewModel", "Laculix/meetly/app/viewmodel/MainViewModel;", "getViewModel", "()Laculix/meetly/app/viewmodel/MainViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "createMeeting", "", "meetingCode", "", "generateMeetingCode", "getCreateMeetingCode", "getJoinMeetingCode", "handleDynamicLink", "initializeCreateMeetingInterstitialAd", "initializeJoinMeetingInterstitialAd", "isMeetingCodeValid", "", "joinMeeting", "loadCreateMeetingInterstitialAd", "loadJoinMeetingInterstitialAd", "onCopyMeetingCodeFromClipboardClick", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateMeetingClick", "onCreateMeetingCodeChange", "onJoinMeetingClick", "onMeetingHistoryClick", "onMeetingToggleChange", "onProfileClick", "onShareMeetingCodeClick", "setProfileIcon", "setThemeMode", "themeMode", "Companion", "app_debug"})
public final class MainActivity extends androidx.appcompat.app.AppCompatActivity {
    private final kotlin.Lazy viewModel$delegate = null;
    private aculix.meetly.app.databinding.ActivityMainBinding binding;
    private final int minMeetingCodeLength = 10;
    private com.google.firebase.auth.FirebaseUser currentUser;
    private com.google.android.gms.ads.InterstitialAd createMeetingInterstitialAd;
    private com.google.android.gms.ads.InterstitialAd joinMeetingInterstitialAd;
    public static final aculix.meetly.app.activity.MainActivity.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
    private final aculix.meetly.app.viewmodel.MainViewModel getViewModel() {
        return null;
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setProfileIcon() {
    }
    
    private final void initializeCreateMeetingInterstitialAd() {
    }
    
    private final void loadCreateMeetingInterstitialAd() {
    }
    
    private final void initializeJoinMeetingInterstitialAd() {
    }
    
    private final void loadJoinMeetingInterstitialAd() {
    }
    
    private final void handleDynamicLink() {
    }
    
    /**
     * Called when the meeting toggle button check state is changed
     */
    private final void onMeetingToggleChange() {
    }
    
    /**
     * Called when the meeting code in the EditText of the CREATE MEETING toggle changes
     */
    private final void onCreateMeetingCodeChange() {
    }
    
    private final java.lang.String generateMeetingCode() {
        return null;
    }
    
    /**
     * Called when the clipboard icon is clicked in the EditText of the JOIN MEETING toggle
     */
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
    
    private final void onProfileClick() {
    }
    
    private final void setThemeMode(int themeMode) {
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