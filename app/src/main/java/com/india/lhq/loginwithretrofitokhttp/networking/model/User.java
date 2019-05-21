package com.india.lhq.loginwithretrofitokhttp.networking.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class User extends RealmObject {
    @PrimaryKey
    public String Status;
   /* public long id;
    public String name;
    public String email;
    public String token;*/
}
