package entity;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private Integer mId;

    private Integer parentMId;

    private String mName;

    private String mUrl;

    private List<Menu> children = new ArrayList<>();

    private boolean open;

    public Integer getmId() {
        return mId;
    }

    public void setmId(Integer mId) {
        this.mId = mId;
    }

    public Integer getParentMId() {
        return parentMId;
    }

    public void setParentMId(Integer parentMId) {
        this.parentMId = parentMId;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName == null ? null : mName.trim();
    }

    public String getmUrl() {
        return mUrl;
    }

    public void setmUrl(String mUrl) {
        this.mUrl = mUrl == null ? null : mUrl.trim();
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public List<Menu> getChildren() {
        return children;
    }

    public void setChildren(List<Menu> children) {
        this.children = children;
    }

    public Menu() {
    }

    public Menu(Integer mId, Integer parentMId, String mName, String mUrl, List<Menu> children, boolean open) {
        this.mId = mId;
        this.parentMId = parentMId;
        this.mName = mName;
        this.mUrl = mUrl;
        this.children = children;
        this.open = open;
    }
}