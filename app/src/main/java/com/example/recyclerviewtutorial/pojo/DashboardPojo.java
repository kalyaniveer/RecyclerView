package com.example.recyclerviewtutorial.pojo;

import java.util.ArrayList;
import java.util.List;

import com.example.recyclerviewtutorial.models.DashboardCardDetails;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DashboardPojo {

    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("resultdata")
    @Expose
    private ArrayList<DashboardCardDetails> resultdata = null;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public ArrayList<DashboardCardDetails> getResultdata() {
        return resultdata;
    }

    public void setResultdata(ArrayList<DashboardCardDetails> resultdata) {
        this.resultdata = resultdata;
    }

}