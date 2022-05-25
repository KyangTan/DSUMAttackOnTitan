package com.magiconch.backend;

import java.io.File;
import javafx.scene.media.Media;

/**
 *
 * @author WeiXin
 */
public class Music {

    private String path;
    private String songName;
    private Media mediaObj;

    public Music(String songName, String path) {
        this.path = path;
        this.songName = songName;
        this.mediaObj = new Media(new File(path).toURI().toString());
    }

    public void setSongPath(String path) {
        this.path = path;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public void setMediaObject(Media mediaObject) {
        this.mediaObj = mediaObject;
    }

    public String getSongPath() {
        return this.path;
    }

    public String getSongName() {
        return this.songName;
    }

    public Media getMediaObject() {
        return this.mediaObj;
    }
}
