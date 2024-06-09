package com.harryzhu.api.photos_clone.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("PHOTO")
public class Photo {

    @Id
    private Integer _id;

    private String _fileName;
    private String _contentType;

    @JsonIgnore
    private byte[] _data;

    public Photo() {}

    public String getFileName() {
        return this._fileName;
    }

    public void setFileName(String filename) {
        this._fileName = filename;
    }

    @JsonIgnore
    public byte[] getData() {
        return this._data;
    }

    public void setData(byte[] data) {
        this._data = data;
    }

    public String getContentType() {
        return this._contentType;
    }

    public void setContentType(String contentType) {
        this._contentType = contentType;
    }
}
