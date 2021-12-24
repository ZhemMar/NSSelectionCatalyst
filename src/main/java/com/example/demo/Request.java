package com.example.demo;

import java.util.List;
import java.util.Objects;

public class Request {
    
    public List<Material> response;
    boolean valid_response;
    String copyright;

    public Request() {
    }

    public Request(List<Material> response, boolean valid_response, String copyright) {
        this.response = response;
        this.valid_response = valid_response;
        this.copyright = copyright;
    }

    public List<Material> getResponse() {
        return this.response;
    }

    public void setResponse(List<Material> response) {
        this.response = response;
    }

    public boolean isValid_response() {
        return this.valid_response;
    }

    public boolean getValid_response() {
        return this.valid_response;
    }

    public void setValid_response(boolean valid_response) {
        this.valid_response = valid_response;
    }

    public String getCopyright() {
        return this.copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public Request response(List<Material> response) {
        setResponse(response);
        return this;
    }

    public Request valid_response(boolean valid_response) {
        setValid_response(valid_response);
        return this;
    }

    public Request copyright(String copyright) {
        setCopyright(copyright);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Request)) {
            return false;
        }
        Request request = (Request) o;
        return Objects.equals(response, request.response) && valid_response == request.valid_response && Objects.equals(copyright, request.copyright);
    }

    @Override
    public int hashCode() {
        return Objects.hash(response, valid_response, copyright);
    }

    @Override
    public String toString() {
        return "{" +
            " response='" + getResponse() + "'" +
            ", valid_response='" + isValid_response() + "'" +
            ", copyright='" + getCopyright() + "'" +
            "}";
    }



}
