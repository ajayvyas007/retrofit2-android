package com.example.ajay.crownstack.model;

import java.util.List;

public class Responce {

    private List<Data> results;

    private String resultCount;

    public List<Data> getResults ()
    {
        return results;
    }

    public void setResults (List<Data> results)
    {
        this.results = results;
    }

    public String getResultCount ()
    {
        return resultCount;
    }

    public void setResultCount (String resultCount)
    {
        this.resultCount = resultCount;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [results = "+results+", resultCount = "+resultCount+"]";
    }
}
