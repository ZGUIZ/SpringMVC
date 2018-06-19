package com.zguiz.utils;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

public class DataConverter implements Converter<String,Date> {
    @Override
    public Date convert(String s) {
        SimpleDateFormat dateFormat=getSimpleDateFormat(s);
        if(dateFormat!=null){
            try {
                Date date = dateFormat.parse(s);
                return date;
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        else {
            return null;
        }
        return null;
    }

    private SimpleDateFormat getSimpleDateFormat(String source){
        SimpleDateFormat format=new SimpleDateFormat();
        if(Pattern.matches("^\\d{4}-\\d{2}-\\d{2}$",source)){
            format=new SimpleDateFormat("yyyy-MM-dd");
        } else if (Pattern.matches("^\\d{4}-\\d{2}-\\d{2}$ HH:mm:ss",source)){
            format=new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        } else if(Pattern.matches("^\\d{4}/\\d{2}/\\d{2}$",source)){
            format=new SimpleDateFormat("yyyy/MM/dd");
        } else if(Pattern.matches("^\\d{4}/\\d{2}/\\d{2} \\d{2}:\\d{2}:\\d{2}$",source)){
            format=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        } else if(Pattern.matches("^\\d{4}/\\d{2}/\\d{2} \\d{2}/\\d{2}/\\d{2}$",source)){
            format=new SimpleDateFormat("yyyy/MM/dd HH/mm/ss");
        } else {
            return null;
        }
        return format;
    }
}
