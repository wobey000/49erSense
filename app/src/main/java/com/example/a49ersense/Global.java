
package com.example.a49ersense;

import android.app.Application;

class Global extends Application {

    private int uuid;
    private String acct;

    public String getGlobalacct() {
        return acct;
    }

    // Insert UUID here
    public Void setGlobalacct(String str) {
        acct = str;
        return null;
    }

    public int getGlobalUUID() {
        return uuid;
    }

    // Insert UUID here
    public Void setGlobalUUID(int integer) {
        uuid = integer;
        return null;
    }
}

