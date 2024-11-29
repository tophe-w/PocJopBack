package com.example.pocJop.helper;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;

@Slf4j
public class Helpers {

    static public void UpdateObjectFields(Object object, Object objectToUpdate) {
        for (Field field : object.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            try {
                Object value = field.get(object);

                if (value != null) {
                        field.set(objectToUpdate, value);
                    }


            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

}
