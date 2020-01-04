package com.example.assignment1;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateValidation {
      public static boolean isValidDate(String str) {
          boolean validdate=true;
          SimpleDateFormat format;
          format = new SimpleDateFormat("yyyy-MM-dd");
          try {
              format.setLenient(false);
              format.parse(str);
                    } catch (ParseException e) {
              validdate=false;
                    }
                return validdate;
         }
     public static boolean isValidtime(String str) {
        boolean validdate=true;
        SimpleDateFormat format;
        format = new SimpleDateFormat("HH:mm");
        try {
            format.setLenient(false);
            format.parse(str);
        } catch (ParseException e) {
            validdate=false;
        }
        return validdate;
    }

}
