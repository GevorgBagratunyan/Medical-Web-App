package com.gevbagratunyan.medicalwebapp.services.CRUD;

public interface Read<ID, Response> {
    Response get(ID id);
}
