package com.example.huang_ms.service;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class DateConverter implements Converter<String,Date> {
    @Override
    public Date convert(String s){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return format.parse(s);
        }
        catch (ParseException e){
            e.printStackTrace();
        }
        return null;
    }
}
