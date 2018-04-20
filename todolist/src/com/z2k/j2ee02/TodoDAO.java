package com.z2k.j2ee02;

import java.util.List;

public interface TodoDAO {
    int save(Todo td);
    List<Todo> list();
}
