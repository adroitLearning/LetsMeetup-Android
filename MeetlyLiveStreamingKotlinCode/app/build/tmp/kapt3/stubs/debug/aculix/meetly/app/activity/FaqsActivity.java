package aculix.meetly.app.activity;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00070\tj\b\u0012\u0004\u0012\u00020\u0007`\nH\u0002J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0014J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000eH\u0014J*\u0010\u0011\u001a\u00020\f2\u0016\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00070\tj\b\u0012\u0004\u0012\u00020\u0007`\n2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002J\b\u0010\u0013\u001a\u00020\fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Laculix/meetly/app/activity/FaqsActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Laculix/meetly/app/databinding/ActivityFaqsBinding;", "faqsAdapter", "Lcom/mikepenz/fastadapter/adapters/FastItemAdapter;", "Laculix/meetly/app/adapteritem/FaqsItem;", "getFaqItems", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onSaveInstanceState", "_outState", "setupRecyclerView", "faqItems", "setupToolbar", "Companion", "app_debug"})
public final class FaqsActivity extends androidx.appcompat.app.AppCompatActivity {
    private aculix.meetly.app.databinding.ActivityFaqsBinding binding;
    private com.mikepenz.fastadapter.adapters.FastItemAdapter<aculix.meetly.app.adapteritem.FaqsItem> faqsAdapter;
    public static final aculix.meetly.app.activity.FaqsActivity.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override
    protected void onSaveInstanceState(@org.jetbrains.annotations.NotNull
    android.os.Bundle _outState) {
    }
    
    private final void setupToolbar() {
    }
    
    private final java.util.ArrayList<aculix.meetly.app.adapteritem.FaqsItem> getFaqItems() {
        return null;
    }
    
    private final void setupRecyclerView(java.util.ArrayList<aculix.meetly.app.adapteritem.FaqsItem> faqItems, android.os.Bundle savedInstanceState) {
    }
    
    public FaqsActivity() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2 = {"Laculix/meetly/app/activity/FaqsActivity$Companion;", "", "()V", "startActivity", "", "context", "Landroid/content/Context;", "app_debug"})
    public static final class Companion {
        
        public final void startActivity(@org.jetbrains.annotations.NotNull
        android.content.Context context) {
        }
        
        private Companion() {
            super();
        }
    }
}