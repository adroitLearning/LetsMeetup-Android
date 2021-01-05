package aculix.meetly.app.di;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 2, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002\u001a\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0002\"\u0011\u0010\u0000\u001a\u00020\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\u00a8\u0006\u000b"}, d2 = {"appModule", "Lorg/koin/core/module/Module;", "getAppModule", "()Lorg/koin/core/module/Module;", "provideMeetingDao", "Laculix/meetly/app/db/MeetingDao;", "meetlyDB", "Laculix/meetly/app/db/MeetlyDB;", "provideRoomDatabase", "androidApplication", "Landroid/app/Application;", "app_debug"})
public final class AppModuleKt {
    @org.jetbrains.annotations.NotNull()
    private static final org.koin.core.module.Module appModule = null;
    
    @org.jetbrains.annotations.NotNull()
    public static final org.koin.core.module.Module getAppModule() {
        return null;
    }
    
    private static final aculix.meetly.app.db.MeetlyDB provideRoomDatabase(android.app.Application androidApplication) {
        return null;
    }
    
    private static final aculix.meetly.app.db.MeetingDao provideMeetingDao(aculix.meetly.app.db.MeetlyDB meetlyDB) {
        return null;
    }
}