package com.example.lib_opensource.http;

public class HttpModel<T> {
    private boolean error;
    private T results;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public T getResults() {
        return results;
    }

    public void setResults(T results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "BaseModel{" +
                "error=" + error +
                ", results=" + results +
                '}';
    }
}
