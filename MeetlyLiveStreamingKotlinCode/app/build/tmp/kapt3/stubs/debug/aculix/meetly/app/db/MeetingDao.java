package aculix.meetly.app.db;

import java.lang.System;

/**
 * Dao to save and access the meetings done by the user
 */
@androidx.room.Dao
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007J\u0014\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00050\tH\'J\u0019\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\nH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000e\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000f"}, d2 = {"Laculix/meetly/app/db/MeetingDao;", "", "deleteMultipleMeetings", "", "meetingCodeList", "", "", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllMeetings", "Landroidx/lifecycle/LiveData;", "Laculix/meetly/app/model/Meeting;", "insertMeeting", "", "meeting", "(Laculix/meetly/app/model/Meeting;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface MeetingDao {
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    public abstract java.lang.Object insertMeeting(@org.jetbrains.annotations.NotNull
    aculix.meetly.app.model.Meeting meeting, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Long> p1);
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT * FROM meetings ORDER BY timeInMillis DESC")
    public abstract androidx.lifecycle.LiveData<java.util.List<aculix.meetly.app.model.Meeting>> getAllMeetings();
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Query(value = "DELETE FROM meetings where  code in (:meetingCodeList)")
    public abstract java.lang.Object deleteMultipleMeetings(@org.jetbrains.annotations.NotNull
    java.util.List<java.lang.String> meetingCodeList, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> p1);
}