package com.gevbagratunyan.medicalwebapp.services.CRUD;

public interface Update<ID, Request, Response> {
    Response update(ID id, Request request);
}
