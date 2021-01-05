package aculix.meetly.app.adapteritem;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u001e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0016J\u001a\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0002H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0018"}, d2 = {"Laculix/meetly/app/adapteritem/MeetingHistoryItem;", "Lcom/mikepenz/fastadapter/binding/AbstractBindingItem;", "Laculix/meetly/app/databinding/ItemMeetingHistoryBinding;", "meeting", "Laculix/meetly/app/model/Meeting;", "(Laculix/meetly/app/model/Meeting;)V", "getMeeting", "()Laculix/meetly/app/model/Meeting;", "type", "", "getType", "()I", "bindView", "", "binding", "payloads", "", "", "createBinding", "inflater", "Landroid/view/LayoutInflater;", "parent", "Landroid/view/ViewGroup;", "unbindView", "app_debug"})
public final class MeetingHistoryItem extends com.mikepenz.fastadapter.binding.AbstractBindingItem<aculix.meetly.app.databinding.ItemMeetingHistoryBinding> {
    @org.jetbrains.annotations.NotNull()
    private final aculix.meetly.app.model.Meeting meeting = null;
    
    @java.lang.Override()
    public int getType() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public aculix.meetly.app.databinding.ItemMeetingHistoryBinding createBinding(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup parent) {
        return null;
    }
    
    @java.lang.Override()
    public void bindView(@org.jetbrains.annotations.NotNull()
    aculix.meetly.app.databinding.ItemMeetingHistoryBinding binding, @org.jetbrains.annotations.NotNull()
    java.util.List<? extends java.lang.Object> payloads) {
    }
    
    @java.lang.Override()
    public void unbindView(@org.jetbrains.annotations.NotNull()
    aculix.meetly.app.databinding.ItemMeetingHistoryBinding binding) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final aculix.meetly.app.model.Meeting getMeeting() {
        return null;
    }
    
    public MeetingHistoryItem(@org.jetbrains.annotations.NotNull()
    aculix.meetly.app.model.Meeting meeting) {
        super();
    }
}