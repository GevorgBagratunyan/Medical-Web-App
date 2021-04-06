package com.gevbagratunyan.medicalwebapp.services.CRUD;

public interface Create<Request,Response> {
    Response add(Request request);
}
