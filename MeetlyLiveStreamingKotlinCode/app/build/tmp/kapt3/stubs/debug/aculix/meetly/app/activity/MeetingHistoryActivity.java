package aculix.meetly.app.activity;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 (2\u00020\u0001:\u0001(B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0012\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0014J\b\u0010\u001a\u001a\u00020\u0017H\u0014J\b\u0010\u001b\u001a\u00020\u0017H\u0002J\b\u0010\u001c\u001a\u00020\u0017H\u0014J\b\u0010\u001d\u001a\u00020\u0017H\u0002J\b\u0010\u001e\u001a\u00020\u0017H\u0014J\u0010\u0010\u001f\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\u0019H\u0014J\b\u0010!\u001a\u00020\u0017H\u0002J\b\u0010\"\u001a\u00020\u0017H\u0002J\u0012\u0010#\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0002J\b\u0010$\u001a\u00020\u0017H\u0002J\u0010\u0010%\u001a\u00020\u00172\u0006\u0010&\u001a\u00020\'H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006)"}, d2 = {"Laculix/meetly/app/activity/MeetingHistoryActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "adView", "Lcom/google/android/gms/ads/AdView;", "binding", "Laculix/meetly/app/databinding/ActivityMeetingHistoryBinding;", "initialLayoutComplete", "", "meetingHistoryAdapter", "Lcom/mikepenz/fastadapter/adapters/FastItemAdapter;", "Laculix/meetly/app/adapteritem/MeetingHistoryItem;", "viewModel", "Laculix/meetly/app/viewmodel/MeetingHistoryViewModel;", "getViewModel", "()Laculix/meetly/app/viewmodel/MeetingHistoryViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getAdaptiveBannerAdSize", "Lcom/google/android/gms/ads/AdSize;", "adViewContainer", "Landroid/widget/FrameLayout;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onMeetingCodeClick", "onPause", "onRejoinClick", "onResume", "onSaveInstanceState", "_outState", "setupBannerAd", "setupObservables", "setupRecyclerView", "setupToolbar", "showEmptyState", "itemCount", "", "Companion", "app_debug"})
public final class MeetingHistoryActivity extends androidx.appcompat.app.AppCompatActivity {
    private aculix.meetly.app.databinding.ActivityMeetingHistoryBinding binding;
    private final kotlin.Lazy viewModel$delegate = null;
    private com.mikepenz.fastadapter.adapters.FastItemAdapter<aculix.meetly.app.adapteritem.MeetingHistoryItem> meetingHistoryAdapter;
    private com.google.android.gms.ads.AdView adView;
    private boolean initialLayoutComplete = false;
    public static final aculix.meetly.app.activity.MeetingHistoryActivity.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
    private final aculix.meetly.app.viewmodel.MeetingHistoryViewModel getViewModel() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    protected void onSaveInstanceState(@org.jetbrains.annotations.NotNull()
    android.os.Bundle _outState) {
    }
    
    @java.lang.Override()
    protected void onPause() {
    }
    
    @java.lang.Override()
    protected void onResume() {
    }
    
    @java.lang.Override()
    protected void onDestroy() {
    }
    
    private final void setupToolbar() {
    }
    
    private final void setupRecyclerView(android.os.Bundle savedInstanceState) {
    }
    
    private final void setupObservables() {
    }
    
    private final void showEmptyState(int itemCount) {
    }
    
    private final void setupBannerAd() {
    }
    
    /**
     * Returns the size of the Adaptive Banner Ad based on the screen width
     */
    private final com.google.android.gms.ads.AdSize getAdaptiveBannerAdSize(android.widget.FrameLayout adViewContainer) {
        return null;
    }
    
    /**
     * Called when the meeting code is clicked of a RecyclerView Item
     */
    private final void onMeetingCodeClick() {
    }
    
    /**
     * Called when the Rejoin button is clicked of a RecyclerView Item
     */
    private final void onRejoinClick() {
    }
    
    public MeetingHistoryActivity() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2 = {"Laculix/meetly/app/activity/MeetingHistoryActivity$Companion;", "", "()V", "startActivity", "", "context", "Landroid/content/Context;", "app_debug"})
    public static final class Companion {
        
        public final void startActivity(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
        }
        
        private Companion() {
            super();
        }
    }
}