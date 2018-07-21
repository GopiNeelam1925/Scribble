package com.suriyal.shailendra.recyclerviewdemo.data;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.util.UUID;


/**
 * Created by shailendra.suriyal
 */

@Entity
public class Note {


    @PrimaryKey
    @NonNull
    private String id;

    private String mNoteId;
    private String message;
    private int colorResource;

    public Note(String mNoteId, String message, int colorResource) {
        this.id = UUID.randomUUID().toString();
        this.mNoteId = mNoteId;
        this.message = message;
        this.colorResource = colorResource;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNoteId() {
        return mNoteId;
    }

    public void setNoteId(String noteId) {
        this.mNoteId = noteId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getColorResource() {
        return colorResource;
    }

    public void setColorResource(int colorResource) {
        this.colorResource = colorResource;
    }
}
