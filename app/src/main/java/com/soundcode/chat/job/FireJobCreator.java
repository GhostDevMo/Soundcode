package com.soundcode.chat.job;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.evernote.android.job.Job;
import com.evernote.android.job.JobCreator;

public class FireJobCreator implements JobCreator {
    @Nullable
    @Override
    public Job create(@NonNull String tag) {
        switch (tag) {

            case JobIds.JOB_TAG_SYNC_CONTACTS:
                return new SyncContactsDailyJob();

            case JobIds.JOB_TAG_DELETE_STATUS:
                return new DeleteStatusJob();

            case JobIds.JOB_TAG_SET_STATUS_SEEN:
                return new SetStatusSeenJob();

        }
        return null;
    }
}
