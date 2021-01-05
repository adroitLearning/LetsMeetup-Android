package aculix.meetly.app.viewmodel;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\bR&\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Laculix/meetly/app/viewmodel/MeetingHistoryViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Laculix/meetly/app/repository/MeetingHistoryRepository;", "(Laculix/meetly/app/repository/MeetingHistoryRepository;)V", "meetingHistoryLiveData", "Landroidx/lifecycle/LiveData;", "", "Laculix/meetly/app/model/Meeting;", "getMeetingHistoryLiveData", "()Landroidx/lifecycle/LiveData;", "setMeetingHistoryLiveData", "(Landroidx/lifecycle/LiveData;)V", "addMeetingToDb", "", "meeting", "app_debug"})
public final class MeetingHistoryViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.LiveData<java.util.List<aculix.meetly.app.model.Meeting>> meetingHistoryLiveData;
    private final aculix.meetly.app.repository.MeetingHistoryRepository repository = null;
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<aculix.meetly.app.model.Meeting>> getMeetingHistoryLiveData() {
        return null;
    }
    
    public final void setMeetingHistoryLiveData(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.LiveData<java.util.List<aculix.meetly.app.model.Meeting>> p0) {
    }
    
    public final void addMeetingToDb(@org.jetbrains.annotations.NotNull()
    aculix.meetly.app.model.Meeting meeting) {
    }
    
    public MeetingHistoryViewModel(@org.jetbrains.annotations.NotNull()
    aculix.meetly.app.repository.MeetingHistoryRepository repository) {
        super();
    }
}